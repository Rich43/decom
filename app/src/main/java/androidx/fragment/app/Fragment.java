package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.view.AbstractC0178v;
import androidx.lifecycle.AbstractC0203h;
import androidx.lifecycle.F;
import androidx.lifecycle.InterfaceC0202g;
import androidx.lifecycle.InterfaceC0206k;
import androidx.lifecycle.LiveData;
import c.AbstractC0224a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import l.InterfaceC0276a;

/* loaded from: classes.dex */
public abstract class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, androidx.lifecycle.m, androidx.lifecycle.J, InterfaceC0202g, L.d {
    static final int ACTIVITY_CREATED = 4;
    static final int ATTACHED = 0;
    static final int AWAITING_ENTER_EFFECTS = 6;
    static final int AWAITING_EXIT_EFFECTS = 3;
    static final int CREATED = 1;
    static final int INITIALIZING = -1;
    static final int RESUMED = 7;
    static final int STARTED = 5;
    static final Object USE_DEFAULT_TRANSITION = new Object();
    static final int VIEW_CREATED = 2;
    boolean mAdded;
    j mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    boolean mBeingSaved;
    private boolean mCalled;
    ViewGroup mContainer;
    int mContainerId;
    private int mContentLayoutId;
    F.b mDefaultFactory;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    w mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    o mHost;
    boolean mInLayout;
    boolean mIsCreated;
    LayoutInflater mLayoutInflater;
    androidx.lifecycle.n mLifecycleRegistry;
    Fragment mParentFragment;
    boolean mPerformedCreateView;
    public String mPreviousWho;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    L.c mSavedStateRegistryController;
    Boolean mSavedUserVisibleHint;
    Bundle mSavedViewRegistryState;
    SparseArray<Parcelable> mSavedViewState;
    String mTag;
    Fragment mTarget;
    int mTargetRequestCode;
    View mView;
    I mViewLifecycleOwner;
    int mState = -1;
    String mWho = UUID.randomUUID().toString();
    String mTargetWho = null;
    private Boolean mIsPrimaryNavigationFragment = null;
    w mChildFragmentManager = new x();
    boolean mMenuVisible = true;
    boolean mUserVisibleHint = true;
    Runnable mPostponedDurationRunnable = new b();
    AbstractC0203h.b mMaxState = AbstractC0203h.b.RESUMED;
    androidx.lifecycle.q mViewLifecycleOwnerLiveData = new androidx.lifecycle.q();
    private final AtomicInteger mNextLocalRequestCode = new AtomicInteger();
    private final ArrayList<m> mOnPreAttachedListeners = new ArrayList<>();
    private final m mSavedStateAttachListener = new c();

    /* renamed from: androidx.fragment.app.Fragment$6 */
    class AnonymousClass6 implements InterfaceC0206k {
        AnonymousClass6() {
        }

        @Override // androidx.lifecycle.InterfaceC0206k
        public void d(androidx.lifecycle.m mVar, AbstractC0203h.a aVar) {
            View view;
            if (aVar != AbstractC0203h.a.ON_STOP || (view = Fragment.this.mView) == null) {
                return;
            }
            k.a(view);
        }
    }

    class a extends b.c {

        /* renamed from: a */
        final /* synthetic */ AtomicReference f3400a;

        /* renamed from: b */
        final /* synthetic */ AbstractC0224a f3401b;

        a(AtomicReference atomicReference, AbstractC0224a abstractC0224a) {
            this.f3400a = atomicReference;
            this.f3401b = abstractC0224a;
        }

        @Override // b.c
        public void b(Object obj, androidx.core.app.c cVar) {
            b.c cVar2 = (b.c) this.f3400a.get();
            if (cVar2 == null) {
                throw new IllegalStateException("Operation cannot be started before fragment is in created state");
            }
            cVar2.b(obj, cVar);
        }

        @Override // b.c
        public void c() {
            b.c cVar = (b.c) this.f3400a.getAndSet(null);
            if (cVar != null) {
                cVar.c();
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.startPostponedEnterTransition();
        }
    }

    class c extends m {
        c() {
            super(null);
        }

        @Override // androidx.fragment.app.Fragment.m
        void a() {
            Fragment.this.mSavedStateRegistryController.c();
            androidx.lifecycle.z.c(Fragment.this);
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.callStartTransitionListener(false);
        }
    }

    class e implements Runnable {

        /* renamed from: a */
        final /* synthetic */ K f3406a;

        e(K k2) {
            this.f3406a = k2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3406a.g();
        }
    }

    class f extends AbstractC0193k {
        f() {
        }

        @Override // androidx.fragment.app.AbstractC0193k
        public View d(int i2) {
            View view = Fragment.this.mView;
            if (view != null) {
                return view.findViewById(i2);
            }
            throw new IllegalStateException("Fragment " + Fragment.this + " does not have a view");
        }

        @Override // androidx.fragment.app.AbstractC0193k
        public boolean e() {
            return Fragment.this.mView != null;
        }
    }

    class g implements InterfaceC0276a {
        g() {
        }

        @Override // l.InterfaceC0276a
        /* renamed from: b */
        public b.e a(Void r3) {
            Fragment fragment = Fragment.this;
            Object obj = fragment.mHost;
            return obj instanceof b.f ? ((b.f) obj).s() : fragment.requireActivity().s();
        }
    }

    class h implements InterfaceC0276a {

        /* renamed from: a */
        final /* synthetic */ b.e f3410a;

        h(b.e eVar) {
            this.f3410a = eVar;
        }

        @Override // l.InterfaceC0276a
        /* renamed from: b */
        public b.e a(Void r12) {
            return this.f3410a;
        }
    }

    class i extends m {

        /* renamed from: a */
        final /* synthetic */ InterfaceC0276a f3412a;

        /* renamed from: b */
        final /* synthetic */ AtomicReference f3413b;

        /* renamed from: c */
        final /* synthetic */ AbstractC0224a f3414c;

        /* renamed from: d */
        final /* synthetic */ b.b f3415d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(InterfaceC0276a interfaceC0276a, AtomicReference atomicReference, AbstractC0224a abstractC0224a, b.b bVar) {
            super(null);
            this.f3412a = interfaceC0276a;
            this.f3413b = atomicReference;
            this.f3414c = abstractC0224a;
            this.f3415d = bVar;
        }

        @Override // androidx.fragment.app.Fragment.m
        void a() {
            String strGenerateActivityResultKey = Fragment.this.generateActivityResultKey();
            this.f3413b.set(((b.e) this.f3412a.a(null)).l(strGenerateActivityResultKey, Fragment.this, this.f3414c, this.f3415d));
        }
    }

    static class j {

        /* renamed from: a */
        View f3416a;

        /* renamed from: b */
        boolean f3417b;

        /* renamed from: c */
        int f3418c;

        /* renamed from: d */
        int f3419d;
        int e;

        /* renamed from: f */
        int f3420f;

        /* renamed from: g */
        int f3421g;

        /* renamed from: h */
        ArrayList f3422h;

        /* renamed from: i */
        ArrayList f3423i;

        /* renamed from: j */
        Object f3424j = null;

        /* renamed from: k */
        Object f3425k;

        /* renamed from: l */
        Object f3426l;

        /* renamed from: m */
        Object f3427m;

        /* renamed from: n */
        Object f3428n;
        Object o;

        /* renamed from: p */
        Boolean f3429p;

        /* renamed from: q */
        Boolean f3430q;
        float r;
        View s;

        /* renamed from: t */
        boolean f3431t;

        j() {
            Object obj = Fragment.USE_DEFAULT_TRANSITION;
            this.f3425k = obj;
            this.f3426l = null;
            this.f3427m = obj;
            this.f3428n = null;
            this.o = obj;
            this.r = 1.0f;
            this.s = null;
        }
    }

    static class k {
        static void a(View view) {
            view.cancelPendingInputEvents();
        }
    }

    public static class l extends RuntimeException {
        public l(String str, Exception exc) {
            super(str, exc);
        }
    }

    private static abstract class m {
        private m() {
        }

        abstract void a();

        /* synthetic */ m(b bVar) {
            this();
        }
    }

    public static class n implements Parcelable {
        public static final Parcelable.Creator<n> CREATOR = new a();

        /* renamed from: a */
        final Bundle f3432a;

        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public n createFromParcel(Parcel parcel) {
                return new n(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b */
            public n createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new n(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c */
            public n[] newArray(int i2) {
                return new n[i2];
            }
        }

        n(Parcel parcel, ClassLoader classLoader) {
            Bundle bundle = parcel.readBundle();
            this.f3432a = bundle;
            if (classLoader == null || bundle == null) {
                return;
            }
            bundle.setClassLoader(classLoader);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeBundle(this.f3432a);
        }
    }

    public Fragment() {
        d();
    }

    private j a() {
        if (this.mAnimationInfo == null) {
            this.mAnimationInfo = new j();
        }
        return this.mAnimationInfo;
    }

    private int b() {
        AbstractC0203h.b bVar = this.mMaxState;
        return (bVar == AbstractC0203h.b.INITIALIZED || this.mParentFragment == null) ? bVar.ordinal() : Math.min(bVar.ordinal(), this.mParentFragment.b());
    }

    private Fragment c(boolean z2) {
        String str;
        if (z2) {
            F.c.j(this);
        }
        Fragment fragment = this.mTarget;
        if (fragment != null) {
            return fragment;
        }
        w wVar = this.mFragmentManager;
        if (wVar == null || (str = this.mTargetWho) == null) {
            return null;
        }
        return wVar.f0(str);
    }

    private void d() {
        this.mLifecycleRegistry = new androidx.lifecycle.n(this);
        this.mSavedStateRegistryController = L.c.a(this);
        this.mDefaultFactory = null;
        if (this.mOnPreAttachedListeners.contains(this.mSavedStateAttachListener)) {
            return;
        }
        g(this.mSavedStateAttachListener);
    }

    private b.c e(AbstractC0224a abstractC0224a, InterfaceC0276a interfaceC0276a, b.b bVar) {
        if (this.mState <= 1) {
            AtomicReference atomicReference = new AtomicReference();
            g(new i(interfaceC0276a, atomicReference, abstractC0224a, bVar));
            return new a(atomicReference, abstractC0224a);
        }
        throw new IllegalStateException("Fragment " + this + " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
    }

    private void g(m mVar) {
        if (this.mState >= 0) {
            mVar.a();
        } else {
            this.mOnPreAttachedListeners.add(mVar);
        }
    }

    private void h() {
        if (w.H0(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
        }
        if (this.mView != null) {
            restoreViewState(this.mSavedFragmentState);
        }
        this.mSavedFragmentState = null;
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str) {
        return instantiate(context, str, null);
    }

    void callStartTransitionListener(boolean z2) {
        ViewGroup viewGroup;
        w wVar;
        j jVar = this.mAnimationInfo;
        if (jVar != null) {
            jVar.f3431t = false;
        }
        if (this.mView == null || (viewGroup = this.mContainer) == null || (wVar = this.mFragmentManager) == null) {
            return;
        }
        K kN = K.n(viewGroup, wVar);
        kN.p();
        if (z2) {
            this.mHost.i().post(new e(kN));
        } else {
            kN.g();
        }
    }

    AbstractC0193k createFragmentContainer() {
        return new f();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        if (this.mSavedViewRegistryState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.mSavedViewRegistryState);
        }
        Fragment fragmentC = c(false);
        if (fragmentC != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(fragmentC);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(getPopDirection());
        if (getEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(getEnterAnim());
        }
        if (getExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(getExitAnim());
        }
        if (getPopEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(getPopEnterAnim());
        }
        if (getPopExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(getPopExitAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(getAnimatingAway());
        }
        if (getContext() != null) {
            androidx.loader.app.a.b(this).a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.mChildFragmentManager + ":");
        this.mChildFragmentManager.X(str + "  ", fileDescriptor, printWriter, strArr);
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    Fragment findFragmentByWho(String str) {
        return str.equals(this.mWho) ? this : this.mChildFragmentManager.j0(str);
    }

    String generateActivityResultKey() {
        return "fragment_" + this.mWho + "_rq#" + this.mNextLocalRequestCode.getAndIncrement();
    }

    public final AbstractActivityC0191i getActivity() {
        o oVar = this.mHost;
        if (oVar == null) {
            return null;
        }
        return (AbstractActivityC0191i) oVar.g();
    }

    public boolean getAllowEnterTransitionOverlap() {
        Boolean bool;
        j jVar = this.mAnimationInfo;
        if (jVar == null || (bool = jVar.f3430q) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public boolean getAllowReturnTransitionOverlap() {
        Boolean bool;
        j jVar = this.mAnimationInfo;
        if (jVar == null || (bool = jVar.f3429p) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    View getAnimatingAway() {
        j jVar = this.mAnimationInfo;
        if (jVar == null) {
            return null;
        }
        return jVar.f3416a;
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final w getChildFragmentManager() {
        if (this.mHost != null) {
            return this.mChildFragmentManager;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public Context getContext() {
        o oVar = this.mHost;
        if (oVar == null) {
            return null;
        }
        return oVar.h();
    }

    @Override // androidx.lifecycle.InterfaceC0202g
    public I.a getDefaultViewModelCreationExtras() {
        Application application;
        Context applicationContext = requireContext().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        if (application == null && w.H0(3)) {
            Log.d("FragmentManager", "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
        }
        I.d dVar = new I.d();
        if (application != null) {
            dVar.c(F.a.f3674g, application);
        }
        dVar.c(androidx.lifecycle.z.f3759a, this);
        dVar.c(androidx.lifecycle.z.f3760b, this);
        if (getArguments() != null) {
            dVar.c(androidx.lifecycle.z.f3761c, getArguments());
        }
        return dVar;
    }

    public F.b getDefaultViewModelProviderFactory() {
        Application application;
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (this.mDefaultFactory == null) {
            Context applicationContext = requireContext().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            if (application == null && w.H0(3)) {
                Log.d("FragmentManager", "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will need CreationExtras to use AndroidViewModel with the default ViewModelProvider.Factory");
            }
            this.mDefaultFactory = new androidx.lifecycle.C(application, this, getArguments());
        }
        return this.mDefaultFactory;
    }

    int getEnterAnim() {
        j jVar = this.mAnimationInfo;
        if (jVar == null) {
            return 0;
        }
        return jVar.f3418c;
    }

    public Object getEnterTransition() {
        j jVar = this.mAnimationInfo;
        if (jVar == null) {
            return null;
        }
        return jVar.f3424j;
    }

    androidx.core.app.r getEnterTransitionCallback() {
        j jVar = this.mAnimationInfo;
        if (jVar == null) {
            return null;
        }
        jVar.getClass();
        return null;
    }

    int getExitAnim() {
        j jVar = this.mAnimationInfo;
        if (jVar == null) {
            return 0;
        }
        return jVar.f3419d;
    }

    public Object getExitTransition() {
        j jVar = this.mAnimationInfo;
        if (jVar == null) {
            return null;
        }
        return jVar.f3426l;
    }

    androidx.core.app.r getExitTransitionCallback() {
        j jVar = this.mAnimationInfo;
        if (jVar == null) {
            return null;
        }
        jVar.getClass();
        return null;
    }

    View getFocusedView() {
        j jVar = this.mAnimationInfo;
        if (jVar == null) {
            return null;
        }
        return jVar.s;
    }

    @Deprecated
    public final w getFragmentManager() {
        return this.mFragmentManager;
    }

    public final Object getHost() {
        o oVar = this.mHost;
        if (oVar == null) {
            return null;
        }
        return oVar.k();
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        return layoutInflater == null ? performGetLayoutInflater(null) : layoutInflater;
    }

    @Override // androidx.lifecycle.m
    public AbstractC0203h getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Deprecated
    public androidx.loader.app.a getLoaderManager() {
        return androidx.loader.app.a.b(this);
    }

    int getNextTransition() {
        j jVar = this.mAnimationInfo;
        if (jVar == null) {
            return 0;
        }
        return jVar.f3421g;
    }

    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    public final w getParentFragmentManager() {
        w wVar = this.mFragmentManager;
        if (wVar != null) {
            return wVar;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    boolean getPopDirection() {
        j jVar = this.mAnimationInfo;
        if (jVar == null) {
            return false;
        }
        return jVar.f3417b;
    }

    int getPopEnterAnim() {
        j jVar = this.mAnimationInfo;
        if (jVar == null) {
            return 0;
        }
        return jVar.e;
    }

    int getPopExitAnim() {
        j jVar = this.mAnimationInfo;
        if (jVar == null) {
            return 0;
        }
        return jVar.f3420f;
    }

    float getPostOnViewCreatedAlpha() {
        j jVar = this.mAnimationInfo;
        if (jVar == null) {
            return 1.0f;
        }
        return jVar.r;
    }

    public Object getReenterTransition() {
        j jVar = this.mAnimationInfo;
        if (jVar == null) {
            return null;
        }
        Object obj = jVar.f3427m;
        return obj == USE_DEFAULT_TRANSITION ? getExitTransition() : obj;
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    @Deprecated
    public final boolean getRetainInstance() {
        F.c.h(this);
        return this.mRetainInstance;
    }

    public Object getReturnTransition() {
        j jVar = this.mAnimationInfo;
        if (jVar == null) {
            return null;
        }
        Object obj = jVar.f3425k;
        return obj == USE_DEFAULT_TRANSITION ? getEnterTransition() : obj;
    }

    @Override // L.d
    public final androidx.savedstate.a getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b();
    }

    public Object getSharedElementEnterTransition() {
        j jVar = this.mAnimationInfo;
        if (jVar == null) {
            return null;
        }
        return jVar.f3428n;
    }

    public Object getSharedElementReturnTransition() {
        j jVar = this.mAnimationInfo;
        if (jVar == null) {
            return null;
        }
        Object obj = jVar.o;
        return obj == USE_DEFAULT_TRANSITION ? getSharedElementEnterTransition() : obj;
    }

    ArrayList<String> getSharedElementSourceNames() {
        ArrayList<String> arrayList;
        j jVar = this.mAnimationInfo;
        return (jVar == null || (arrayList = jVar.f3422h) == null) ? new ArrayList<>() : arrayList;
    }

    ArrayList<String> getSharedElementTargetNames() {
        ArrayList<String> arrayList;
        j jVar = this.mAnimationInfo;
        return (jVar == null || (arrayList = jVar.f3423i) == null) ? new ArrayList<>() : arrayList;
    }

    public final String getString(int i2) {
        return getResources().getString(i2);
    }

    public final String getTag() {
        return this.mTag;
    }

    @Deprecated
    public final Fragment getTargetFragment() {
        return c(true);
    }

    @Deprecated
    public final int getTargetRequestCode() {
        F.c.i(this);
        return this.mTargetRequestCode;
    }

    public final CharSequence getText(int i2) {
        return getResources().getText(i2);
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public View getView() {
        return this.mView;
    }

    public androidx.lifecycle.m getViewLifecycleOwner() {
        I i2 = this.mViewLifecycleOwner;
        if (i2 != null) {
            return i2;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    public LiveData getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override // androidx.lifecycle.J
    public androidx.lifecycle.I getViewModelStore() {
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (b() != AbstractC0203h.b.INITIALIZED.ordinal()) {
            return this.mFragmentManager.C0(this);
        }
        throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    void initState() {
        d();
        this.mPreviousWho = this.mWho;
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new x();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        w wVar;
        return this.mHidden || ((wVar = this.mFragmentManager) != null && wVar.K0(this.mParentFragment));
    }

    final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isMenuVisible() {
        w wVar;
        return this.mMenuVisible && ((wVar = this.mFragmentManager) == null || wVar.L0(this.mParentFragment));
    }

    boolean isPostponed() {
        j jVar = this.mAnimationInfo;
        if (jVar == null) {
            return false;
        }
        return jVar.f3431t;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isResumed() {
        return this.mState >= 7;
    }

    public final boolean isStateSaved() {
        w wVar = this.mFragmentManager;
        if (wVar == null) {
            return false;
        }
        return wVar.O0();
    }

    public final boolean isVisible() {
        View view;
        return (!isAdded() || isHidden() || (view = this.mView) == null || view.getWindowToken() == null || this.mView.getVisibility() != 0) ? false : true;
    }

    void noteStateNotSaved() {
        this.mChildFragmentManager.Y0();
    }

    @Deprecated
    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    @Deprecated
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (w.H0(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i2 + " resultCode: " + i3 + " data: " + intent);
        }
    }

    public void onAttach(Context context) {
        this.mCalled = true;
        o oVar = this.mHost;
        Activity activityG = oVar == null ? null : oVar.g();
        if (activityG != null) {
            this.mCalled = false;
            onAttach(activityG);
        }
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        this.mCalled = true;
        restoreChildFragmentState(bundle);
        if (this.mChildFragmentManager.N0(1)) {
            return;
        }
        this.mChildFragmentManager.C();
    }

    public Animation onCreateAnimation(int i2, boolean z2, int i3) {
        return null;
    }

    public Animator onCreateAnimator(int i2, boolean z2, int i3) {
        return null;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Deprecated
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2 = this.mContentLayoutId;
        if (i2 != 0) {
            return layoutInflater.inflate(i2, viewGroup, false);
        }
        return null;
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    @Deprecated
    public void onDestroyOptionsMenu() {
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    public void onHiddenChanged(boolean z2) {
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
        o oVar = this.mHost;
        Activity activityG = oVar == null ? null : oVar.g();
        if (activityG != null) {
            this.mCalled = false;
            onInflate(activityG, attributeSet, bundle);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean z2) {
    }

    @Deprecated
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    @Deprecated
    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean z2) {
    }

    @Deprecated
    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean z2) {
    }

    @Deprecated
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    public void onViewStateRestored(Bundle bundle) {
        this.mCalled = true;
    }

    void performActivityCreated(Bundle bundle) {
        this.mChildFragmentManager.Y0();
        this.mState = 3;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (this.mCalled) {
            h();
            this.mChildFragmentManager.y();
        } else {
            throw new M("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
    }

    void performAttach() {
        Iterator<m> it = this.mOnPreAttachedListeners.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.n(this.mHost, createFragmentContainer(), this);
        this.mState = 0;
        this.mCalled = false;
        onAttach(this.mHost.h());
        if (this.mCalled) {
            this.mFragmentManager.I(this);
            this.mChildFragmentManager.z();
        } else {
            throw new M("Fragment " + this + " did not call through to super.onAttach()");
        }
    }

    void performConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
    }

    boolean performContextItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (onContextItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.B(menuItem);
    }

    void performCreate(Bundle bundle) {
        this.mChildFragmentManager.Y0();
        this.mState = 1;
        this.mCalled = false;
        this.mLifecycleRegistry.a(new InterfaceC0206k() { // from class: androidx.fragment.app.Fragment.6
            AnonymousClass6() {
            }

            @Override // androidx.lifecycle.InterfaceC0206k
            public void d(androidx.lifecycle.m mVar, AbstractC0203h.a aVar) {
                View view;
                if (aVar != AbstractC0203h.a.ON_STOP || (view = Fragment.this.mView) == null) {
                    return;
                }
                k.a(view);
            }
        });
        this.mSavedStateRegistryController.d(bundle);
        onCreate(bundle);
        this.mIsCreated = true;
        if (this.mCalled) {
            this.mLifecycleRegistry.h(AbstractC0203h.a.ON_CREATE);
            return;
        }
        throw new M("Fragment " + this + " did not call through to super.onCreate()");
    }

    boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z2 = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onCreateOptionsMenu(menu, menuInflater);
            z2 = true;
        }
        return z2 | this.mChildFragmentManager.D(menu, menuInflater);
    }

    void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mChildFragmentManager.Y0();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new I(this, getViewModelStore());
        View viewOnCreateView = onCreateView(layoutInflater, viewGroup, bundle);
        this.mView = viewOnCreateView;
        if (viewOnCreateView == null) {
            if (this.mViewLifecycleOwner.c()) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.mViewLifecycleOwner = null;
        } else {
            this.mViewLifecycleOwner.b();
            androidx.lifecycle.K.a(this.mView, this.mViewLifecycleOwner);
            androidx.lifecycle.L.a(this.mView, this.mViewLifecycleOwner);
            L.e.a(this.mView, this.mViewLifecycleOwner);
            this.mViewLifecycleOwnerLiveData.h(this.mViewLifecycleOwner);
        }
    }

    void performDestroy() {
        this.mChildFragmentManager.E();
        this.mLifecycleRegistry.h(AbstractC0203h.a.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (this.mCalled) {
            return;
        }
        throw new M("Fragment " + this + " did not call through to super.onDestroy()");
    }

    void performDestroyView() {
        this.mChildFragmentManager.F();
        if (this.mView != null && this.mViewLifecycleOwner.getLifecycle().b().b(AbstractC0203h.b.CREATED)) {
            this.mViewLifecycleOwner.a(AbstractC0203h.a.ON_DESTROY);
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (this.mCalled) {
            androidx.loader.app.a.b(this).c();
            this.mPerformedCreateView = false;
        } else {
            throw new M("Fragment " + this + " did not call through to super.onDestroyView()");
        }
    }

    void performDetach() {
        this.mState = -1;
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (this.mCalled) {
            if (this.mChildFragmentManager.G0()) {
                return;
            }
            this.mChildFragmentManager.E();
            this.mChildFragmentManager = new x();
            return;
        }
        throw new M("Fragment " + this + " did not call through to super.onDetach()");
    }

    LayoutInflater performGetLayoutInflater(Bundle bundle) {
        LayoutInflater layoutInflaterOnGetLayoutInflater = onGetLayoutInflater(bundle);
        this.mLayoutInflater = layoutInflaterOnGetLayoutInflater;
        return layoutInflaterOnGetLayoutInflater;
    }

    void performLowMemory() {
        onLowMemory();
    }

    void performMultiWindowModeChanged(boolean z2) {
        onMultiWindowModeChanged(z2);
    }

    boolean performOptionsItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.K(menuItem);
    }

    void performOptionsMenuClosed(Menu menu) {
        if (this.mHidden) {
            return;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onOptionsMenuClosed(menu);
        }
        this.mChildFragmentManager.L(menu);
    }

    void performPause() {
        this.mChildFragmentManager.N();
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(AbstractC0203h.a.ON_PAUSE);
        }
        this.mLifecycleRegistry.h(AbstractC0203h.a.ON_PAUSE);
        this.mState = 6;
        this.mCalled = false;
        onPause();
        if (this.mCalled) {
            return;
        }
        throw new M("Fragment " + this + " did not call through to super.onPause()");
    }

    void performPictureInPictureModeChanged(boolean z2) {
        onPictureInPictureModeChanged(z2);
    }

    boolean performPrepareOptionsMenu(Menu menu) {
        boolean z2 = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onPrepareOptionsMenu(menu);
            z2 = true;
        }
        return z2 | this.mChildFragmentManager.P(menu);
    }

    void performPrimaryNavigationFragmentChanged() {
        boolean zM0 = this.mFragmentManager.M0(this);
        Boolean bool = this.mIsPrimaryNavigationFragment;
        if (bool == null || bool.booleanValue() != zM0) {
            this.mIsPrimaryNavigationFragment = Boolean.valueOf(zM0);
            onPrimaryNavigationFragmentChanged(zM0);
            this.mChildFragmentManager.Q();
        }
    }

    void performResume() {
        this.mChildFragmentManager.Y0();
        this.mChildFragmentManager.b0(true);
        this.mState = 7;
        this.mCalled = false;
        onResume();
        if (!this.mCalled) {
            throw new M("Fragment " + this + " did not call through to super.onResume()");
        }
        androidx.lifecycle.n nVar = this.mLifecycleRegistry;
        AbstractC0203h.a aVar = AbstractC0203h.a.ON_RESUME;
        nVar.h(aVar);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(aVar);
        }
        this.mChildFragmentManager.R();
    }

    void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.e(bundle);
        Bundle bundleP0 = this.mChildFragmentManager.P0();
        if (bundleP0 != null) {
            bundle.putParcelable("android:support:fragments", bundleP0);
        }
    }

    void performStart() {
        this.mChildFragmentManager.Y0();
        this.mChildFragmentManager.b0(true);
        this.mState = 5;
        this.mCalled = false;
        onStart();
        if (!this.mCalled) {
            throw new M("Fragment " + this + " did not call through to super.onStart()");
        }
        androidx.lifecycle.n nVar = this.mLifecycleRegistry;
        AbstractC0203h.a aVar = AbstractC0203h.a.ON_START;
        nVar.h(aVar);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(aVar);
        }
        this.mChildFragmentManager.S();
    }

    void performStop() {
        this.mChildFragmentManager.U();
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(AbstractC0203h.a.ON_STOP);
        }
        this.mLifecycleRegistry.h(AbstractC0203h.a.ON_STOP);
        this.mState = 4;
        this.mCalled = false;
        onStop();
        if (this.mCalled) {
            return;
        }
        throw new M("Fragment " + this + " did not call through to super.onStop()");
    }

    void performViewCreated() {
        onViewCreated(this.mView, this.mSavedFragmentState);
        this.mChildFragmentManager.V();
    }

    public void postponeEnterTransition() {
        a().f3431t = true;
    }

    public final <I, O> b.c registerForActivityResult(AbstractC0224a abstractC0224a, b.b bVar) {
        return e(abstractC0224a, new g(), bVar);
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    @Deprecated
    public final void requestPermissions(String[] strArr, int i2) {
        if (this.mHost != null) {
            getParentFragmentManager().U0(this, strArr, i2);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final AbstractActivityC0191i requireActivity() {
        AbstractActivityC0191i activity = getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public final Bundle requireArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new IllegalStateException("Fragment " + this + " does not have any arguments.");
    }

    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    @Deprecated
    public final w requireFragmentManager() {
        return getParentFragmentManager();
    }

    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a host.");
    }

    public final Fragment requireParentFragment() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        if (getContext() == null) {
            throw new IllegalStateException("Fragment " + this + " is not attached to any Fragment or host");
        }
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
    }

    public final View requireView() {
        View view = getView();
        if (view != null) {
            return view;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    void restoreChildFragmentState(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.mChildFragmentManager.i1(parcelable);
        this.mChildFragmentManager.C();
    }

    final void restoreViewState(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.mSavedViewState;
        if (sparseArray != null) {
            this.mView.restoreHierarchyState(sparseArray);
            this.mSavedViewState = null;
        }
        if (this.mView != null) {
            this.mViewLifecycleOwner.d(this.mSavedViewRegistryState);
            this.mSavedViewRegistryState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (this.mCalled) {
            if (this.mView != null) {
                this.mViewLifecycleOwner.a(AbstractC0203h.a.ON_CREATE);
            }
        } else {
            throw new M("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    public void setAllowEnterTransitionOverlap(boolean z2) {
        a().f3430q = Boolean.valueOf(z2);
    }

    public void setAllowReturnTransitionOverlap(boolean z2) {
        a().f3429p = Boolean.valueOf(z2);
    }

    void setAnimations(int i2, int i3, int i4, int i5) {
        if (this.mAnimationInfo == null && i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
            return;
        }
        a().f3418c = i2;
        a().f3419d = i3;
        a().e = i4;
        a().f3420f = i5;
    }

    public void setArguments(Bundle bundle) {
        if (this.mFragmentManager != null && isStateSaved()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.mArguments = bundle;
    }

    public void setEnterSharedElementCallback(androidx.core.app.r rVar) {
        a().getClass();
    }

    public void setEnterTransition(Object obj) {
        a().f3424j = obj;
    }

    public void setExitSharedElementCallback(androidx.core.app.r rVar) {
        a().getClass();
    }

    public void setExitTransition(Object obj) {
        a().f3426l = obj;
    }

    void setFocusedView(View view) {
        a().s = view;
    }

    @Deprecated
    public void setHasOptionsMenu(boolean z2) {
        if (this.mHasMenu != z2) {
            this.mHasMenu = z2;
            if (!isAdded() || isHidden()) {
                return;
            }
            this.mHost.u();
        }
    }

    public void setInitialSavedState(n nVar) {
        Bundle bundle;
        if (this.mFragmentManager != null) {
            throw new IllegalStateException("Fragment already added");
        }
        if (nVar == null || (bundle = nVar.f3432a) == null) {
            bundle = null;
        }
        this.mSavedFragmentState = bundle;
    }

    public void setMenuVisibility(boolean z2) {
        if (this.mMenuVisible != z2) {
            this.mMenuVisible = z2;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                this.mHost.u();
            }
        }
    }

    void setNextTransition(int i2) {
        if (this.mAnimationInfo == null && i2 == 0) {
            return;
        }
        a();
        this.mAnimationInfo.f3421g = i2;
    }

    void setPopDirection(boolean z2) {
        if (this.mAnimationInfo == null) {
            return;
        }
        a().f3417b = z2;
    }

    void setPostOnViewCreatedAlpha(float f2) {
        a().r = f2;
    }

    public void setReenterTransition(Object obj) {
        a().f3427m = obj;
    }

    @Deprecated
    public void setRetainInstance(boolean z2) {
        F.c.k(this);
        this.mRetainInstance = z2;
        w wVar = this.mFragmentManager;
        if (wVar == null) {
            this.mRetainInstanceChangedWhileDetached = true;
        } else if (z2) {
            wVar.l(this);
        } else {
            wVar.g1(this);
        }
    }

    public void setReturnTransition(Object obj) {
        a().f3425k = obj;
    }

    public void setSharedElementEnterTransition(Object obj) {
        a().f3428n = obj;
    }

    void setSharedElementNames(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        a();
        j jVar = this.mAnimationInfo;
        jVar.f3422h = arrayList;
        jVar.f3423i = arrayList2;
    }

    public void setSharedElementReturnTransition(Object obj) {
        a().o = obj;
    }

    @Deprecated
    public void setTargetFragment(Fragment fragment, int i2) {
        if (fragment != null) {
            F.c.l(this, fragment, i2);
        }
        w wVar = this.mFragmentManager;
        w wVar2 = fragment != null ? fragment.mFragmentManager : null;
        if (wVar != null && wVar2 != null && wVar != wVar2) {
            throw new IllegalArgumentException("Fragment " + fragment + " must share the same FragmentManager to be set as a target fragment");
        }
        for (Fragment fragmentC = fragment; fragmentC != null; fragmentC = fragmentC.c(false)) {
            if (fragmentC.equals(this)) {
                throw new IllegalArgumentException("Setting " + fragment + " as the target of " + this + " would create a target cycle");
            }
        }
        if (fragment == null) {
            this.mTargetWho = null;
            this.mTarget = null;
        } else if (this.mFragmentManager == null || fragment.mFragmentManager == null) {
            this.mTargetWho = null;
            this.mTarget = fragment;
        } else {
            this.mTargetWho = fragment.mWho;
            this.mTarget = null;
        }
        this.mTargetRequestCode = i2;
    }

    @Deprecated
    public void setUserVisibleHint(boolean z2) {
        F.c.m(this, z2);
        if (!this.mUserVisibleHint && z2 && this.mState < 5 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
            w wVar = this.mFragmentManager;
            wVar.a1(wVar.w(this));
        }
        this.mUserVisibleHint = z2;
        this.mDeferStart = this.mState < 5 && !z2;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = Boolean.valueOf(z2);
        }
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        o oVar = this.mHost;
        if (oVar != null) {
            return oVar.p(str);
        }
        return false;
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent) {
        startActivity(intent, null);
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i2) {
        startActivityForResult(intent, i2, null);
    }

    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) {
        if (this.mHost == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        if (w.H0(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in startIntentSenderForResult() requestCode: " + i2 + " IntentSender: " + intentSender + " fillInIntent: " + intent + " options: " + bundle);
        }
        getParentFragmentManager().W0(this, intentSender, i2, intent, i3, i4, i5, bundle);
    }

    public void startPostponedEnterTransition() {
        if (this.mAnimationInfo == null || !a().f3431t) {
            return;
        }
        if (this.mHost == null) {
            a().f3431t = false;
        } else if (Looper.myLooper() != this.mHost.i().getLooper()) {
            this.mHost.i().postAtFrontOfQueue(new d());
        } else {
            callStartTransitionListener(true);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("}");
        sb.append(" (");
        sb.append(this.mWho);
        if (this.mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" tag=");
            sb.append(this.mTag);
        }
        sb.append(")");
        return sb.toString();
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str, Bundle bundle) {
        try {
            Fragment fragment = (Fragment) androidx.fragment.app.n.d(context.getClassLoader(), str).getConstructor(null).newInstance(null);
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.setArguments(bundle);
            }
            return fragment;
        } catch (IllegalAccessException e2) {
            throw new l("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (InstantiationException e3) {
            throw new l("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e3);
        } catch (NoSuchMethodException e4) {
            throw new l("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e4);
        } catch (InvocationTargetException e5) {
            throw new l("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e5);
        }
    }

    public final String getString(int i2, Object... objArr) {
        return getResources().getString(i2, objArr);
    }

    public final void postponeEnterTransition(long j2, TimeUnit timeUnit) {
        a().f3431t = true;
        w wVar = this.mFragmentManager;
        Handler handlerI = wVar != null ? wVar.u0().i() : new Handler(Looper.getMainLooper());
        handlerI.removeCallbacks(this.mPostponedDurationRunnable);
        handlerI.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(j2));
    }

    public final <I, O> b.c registerForActivityResult(AbstractC0224a abstractC0224a, b.e eVar, b.b bVar) {
        return e(abstractC0224a, new h(eVar), bVar);
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent, Bundle bundle) {
        o oVar = this.mHost;
        if (oVar != null) {
            oVar.q(this, intent, -1, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle) {
        if (this.mHost != null) {
            getParentFragmentManager().V0(this, intent, i2, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle bundle) {
        o oVar = this.mHost;
        if (oVar != null) {
            LayoutInflater layoutInflaterL = oVar.l();
            AbstractC0178v.a(layoutInflaterL, this.mChildFragmentManager.v0());
            return layoutInflaterL;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }
}
