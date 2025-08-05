package com.bumptech.glide.manager;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.AbstractActivityC0191i;
import androidx.fragment.app.w;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class RequestManagerRetriever implements Handler.Callback {
    private static final RequestManagerFactory DEFAULT_FACTORY = new RequestManagerFactory() { // from class: com.bumptech.glide.manager.RequestManagerRetriever.1
        @Override // com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory
        public RequestManager build(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context) {
            return new RequestManager(glide, lifecycle, requestManagerTreeNode, context);
        }
    };
    private static final String FRAGMENT_INDEX_KEY = "key";
    static final String FRAGMENT_TAG = "com.bumptech.glide.manager";
    private static final int ID_REMOVE_FRAGMENT_MANAGER = 1;
    private static final int ID_REMOVE_SUPPORT_FRAGMENT_MANAGER = 2;
    private static final String TAG = "RMRetriever";
    private volatile RequestManager applicationManager;
    private final RequestManagerFactory factory;
    private final Handler handler;
    final Map<FragmentManager, RequestManagerFragment> pendingRequestManagerFragments = new HashMap();
    final Map<w, SupportRequestManagerFragment> pendingSupportRequestManagerFragments = new HashMap();
    private final androidx.collection.a tempViewToSupportFragment = new androidx.collection.a();
    private final androidx.collection.a tempViewToFragment = new androidx.collection.a();
    private final Bundle tempBundle = new Bundle();

    public interface RequestManagerFactory {
        RequestManager build(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context);
    }

    public RequestManagerRetriever(RequestManagerFactory requestManagerFactory) {
        this.factory = requestManagerFactory == null ? DEFAULT_FACTORY : requestManagerFactory;
        this.handler = new Handler(Looper.getMainLooper(), this);
    }

    @TargetApi(17)
    private static void assertNotDestroyed(Activity activity) {
        if (activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    private Activity findActivity(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return findActivity(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    @TargetApi(26)
    @Deprecated
    private void findAllFragmentsWithViews(FragmentManager fragmentManager, androidx.collection.a aVar) {
        if (Build.VERSION.SDK_INT < 26) {
            findAllFragmentsWithViewsPreO(fragmentManager, aVar);
            return;
        }
        for (Fragment fragment : fragmentManager.getFragments()) {
            if (fragment.getView() != null) {
                aVar.put(fragment.getView(), fragment);
                findAllFragmentsWithViews(fragment.getChildFragmentManager(), aVar);
            }
        }
    }

    @Deprecated
    private void findAllFragmentsWithViewsPreO(FragmentManager fragmentManager, androidx.collection.a aVar) {
        Fragment fragment;
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            this.tempBundle.putInt(FRAGMENT_INDEX_KEY, i2);
            try {
                fragment = fragmentManager.getFragment(this.tempBundle, FRAGMENT_INDEX_KEY);
            } catch (Exception unused) {
                fragment = null;
            }
            if (fragment == null) {
                return;
            }
            if (fragment.getView() != null) {
                aVar.put(fragment.getView(), fragment);
                findAllFragmentsWithViews(fragment.getChildFragmentManager(), aVar);
            }
            i2 = i3;
        }
    }

    private static void findAllSupportFragmentsWithViews(Collection<androidx.fragment.app.Fragment> collection, Map<View, androidx.fragment.app.Fragment> map) {
        if (collection == null) {
            return;
        }
        for (androidx.fragment.app.Fragment fragment : collection) {
            if (fragment != null && fragment.getView() != null) {
                map.put(fragment.getView(), fragment);
                findAllSupportFragmentsWithViews(fragment.getChildFragmentManager().t0(), map);
            }
        }
    }

    @Deprecated
    private Fragment findFragment(View view, Activity activity) {
        this.tempViewToFragment.clear();
        findAllFragmentsWithViews(activity.getFragmentManager(), this.tempViewToFragment);
        View viewFindViewById = activity.findViewById(R.id.content);
        Fragment fragment = null;
        while (!view.equals(viewFindViewById) && (fragment = (Fragment) this.tempViewToFragment.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.tempViewToFragment.clear();
        return fragment;
    }

    private androidx.fragment.app.Fragment findSupportFragment(View view, AbstractActivityC0191i abstractActivityC0191i) {
        this.tempViewToSupportFragment.clear();
        findAllSupportFragmentsWithViews(abstractActivityC0191i.N0().t0(), this.tempViewToSupportFragment);
        View viewFindViewById = abstractActivityC0191i.findViewById(R.id.content);
        androidx.fragment.app.Fragment fragment = null;
        while (!view.equals(viewFindViewById) && (fragment = (androidx.fragment.app.Fragment) this.tempViewToSupportFragment.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.tempViewToSupportFragment.clear();
        return fragment;
    }

    @Deprecated
    private RequestManager fragmentGet(Context context, FragmentManager fragmentManager, Fragment fragment, boolean z2) {
        RequestManagerFragment requestManagerFragment = getRequestManagerFragment(fragmentManager, fragment, z2);
        RequestManager requestManager = requestManagerFragment.getRequestManager();
        if (requestManager != null) {
            return requestManager;
        }
        RequestManager requestManagerBuild = this.factory.build(Glide.get(context), requestManagerFragment.getGlideLifecycle(), requestManagerFragment.getRequestManagerTreeNode(), context);
        requestManagerFragment.setRequestManager(requestManagerBuild);
        return requestManagerBuild;
    }

    private RequestManager getApplicationManager(Context context) {
        if (this.applicationManager == null) {
            synchronized (this) {
                try {
                    if (this.applicationManager == null) {
                        this.applicationManager = this.factory.build(Glide.get(context.getApplicationContext()), new ApplicationLifecycle(), new EmptyRequestManagerTreeNode(), context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return this.applicationManager;
    }

    private static boolean isActivityVisible(Activity activity) {
        return !activity.isFinishing();
    }

    private RequestManager supportFragmentGet(Context context, w wVar, androidx.fragment.app.Fragment fragment, boolean z2) {
        SupportRequestManagerFragment supportRequestManagerFragment = getSupportRequestManagerFragment(wVar, fragment, z2);
        RequestManager requestManager = supportRequestManagerFragment.getRequestManager();
        if (requestManager != null) {
            return requestManager;
        }
        RequestManager requestManagerBuild = this.factory.build(Glide.get(context), supportRequestManagerFragment.getGlideLifecycle(), supportRequestManagerFragment.getRequestManagerTreeNode(), context);
        supportRequestManagerFragment.setRequestManager(requestManagerBuild);
        return requestManagerBuild;
    }

    public RequestManager get(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (Util.isOnMainThread() && !(context instanceof Application)) {
            if (context instanceof AbstractActivityC0191i) {
                return get((AbstractActivityC0191i) context);
            }
            if (context instanceof Activity) {
                return get((Activity) context);
            }
            if (context instanceof ContextWrapper) {
                return get(((ContextWrapper) context).getBaseContext());
            }
        }
        return getApplicationManager(context);
    }

    @Deprecated
    RequestManagerFragment getRequestManagerFragment(Activity activity) {
        return getRequestManagerFragment(activity.getFragmentManager(), null, isActivityVisible(activity));
    }

    SupportRequestManagerFragment getSupportRequestManagerFragment(AbstractActivityC0191i abstractActivityC0191i) {
        return getSupportRequestManagerFragment(abstractActivityC0191i.N0(), null, isActivityVisible(abstractActivityC0191i));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Object obj;
        ComponentCallbacks componentCallbacksRemove;
        Object obj2;
        ComponentCallbacks componentCallbacks;
        int i2 = message.what;
        boolean z2 = true;
        if (i2 == 1) {
            obj = (FragmentManager) message.obj;
            componentCallbacksRemove = this.pendingRequestManagerFragments.remove(obj);
        } else {
            if (i2 != 2) {
                componentCallbacks = null;
                z2 = false;
                obj2 = null;
                if (z2 && componentCallbacks == null && Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "Failed to remove expected request manager fragment, manager: " + obj2);
                }
                return z2;
            }
            obj = (w) message.obj;
            componentCallbacksRemove = this.pendingSupportRequestManagerFragments.remove(obj);
        }
        ComponentCallbacks componentCallbacks2 = componentCallbacksRemove;
        obj2 = obj;
        componentCallbacks = componentCallbacks2;
        if (z2) {
            Log.w(TAG, "Failed to remove expected request manager fragment, manager: " + obj2);
        }
        return z2;
    }

    private RequestManagerFragment getRequestManagerFragment(FragmentManager fragmentManager, Fragment fragment, boolean z2) {
        RequestManagerFragment requestManagerFragment = (RequestManagerFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (requestManagerFragment == null && (requestManagerFragment = this.pendingRequestManagerFragments.get(fragmentManager)) == null) {
            requestManagerFragment = new RequestManagerFragment();
            requestManagerFragment.setParentFragmentHint(fragment);
            if (z2) {
                requestManagerFragment.getGlideLifecycle().onStart();
            }
            this.pendingRequestManagerFragments.put(fragmentManager, requestManagerFragment);
            fragmentManager.beginTransaction().add(requestManagerFragment, FRAGMENT_TAG).commitAllowingStateLoss();
            this.handler.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return requestManagerFragment;
    }

    private SupportRequestManagerFragment getSupportRequestManagerFragment(w wVar, androidx.fragment.app.Fragment fragment, boolean z2) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) wVar.i0(FRAGMENT_TAG);
        if (supportRequestManagerFragment == null && (supportRequestManagerFragment = this.pendingSupportRequestManagerFragments.get(wVar)) == null) {
            supportRequestManagerFragment = new SupportRequestManagerFragment();
            supportRequestManagerFragment.setParentFragmentHint(fragment);
            if (z2) {
                supportRequestManagerFragment.getGlideLifecycle().onStart();
            }
            this.pendingSupportRequestManagerFragments.put(wVar, supportRequestManagerFragment);
            wVar.p().e(supportRequestManagerFragment, FRAGMENT_TAG).h();
            this.handler.obtainMessage(2, wVar).sendToTarget();
        }
        return supportRequestManagerFragment;
    }

    public RequestManager get(AbstractActivityC0191i abstractActivityC0191i) {
        if (Util.isOnBackgroundThread()) {
            return get(abstractActivityC0191i.getApplicationContext());
        }
        assertNotDestroyed(abstractActivityC0191i);
        return supportFragmentGet(abstractActivityC0191i, abstractActivityC0191i.N0(), null, isActivityVisible(abstractActivityC0191i));
    }

    public RequestManager get(androidx.fragment.app.Fragment fragment) {
        Preconditions.checkNotNull(fragment.getActivity(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (Util.isOnBackgroundThread()) {
            return get(fragment.getActivity().getApplicationContext());
        }
        return supportFragmentGet(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    public RequestManager get(Activity activity) {
        if (Util.isOnBackgroundThread()) {
            return get(activity.getApplicationContext());
        }
        assertNotDestroyed(activity);
        return fragmentGet(activity, activity.getFragmentManager(), null, isActivityVisible(activity));
    }

    public RequestManager get(View view) {
        if (Util.isOnBackgroundThread()) {
            return get(view.getContext().getApplicationContext());
        }
        Preconditions.checkNotNull(view);
        Preconditions.checkNotNull(view.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity activityFindActivity = findActivity(view.getContext());
        if (activityFindActivity == null) {
            return get(view.getContext().getApplicationContext());
        }
        if (activityFindActivity instanceof AbstractActivityC0191i) {
            androidx.fragment.app.Fragment fragmentFindSupportFragment = findSupportFragment(view, (AbstractActivityC0191i) activityFindActivity);
            return fragmentFindSupportFragment != null ? get(fragmentFindSupportFragment) : get(activityFindActivity);
        }
        Fragment fragmentFindFragment = findFragment(view, activityFindActivity);
        if (fragmentFindFragment == null) {
            return get(activityFindActivity);
        }
        return get(fragmentFindFragment);
    }

    @TargetApi(17)
    @Deprecated
    public RequestManager get(Fragment fragment) {
        if (fragment.getActivity() != null) {
            if (!Util.isOnBackgroundThread()) {
                return fragmentGet(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
            }
            return get(fragment.getActivity().getApplicationContext());
        }
        throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
    }
}
