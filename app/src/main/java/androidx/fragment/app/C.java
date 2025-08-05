package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.K;
import androidx.lifecycle.AbstractC0203h;

/* loaded from: classes.dex */
class C {

    /* renamed from: a */
    private final q f3363a;

    /* renamed from: b */
    private final D f3364b;

    /* renamed from: c */
    private final Fragment f3365c;

    /* renamed from: d */
    private boolean f3366d = false;
    private int e = -1;

    class a implements View.OnAttachStateChangeListener {

        /* renamed from: a */
        final /* synthetic */ View f3367a;

        a(View view) {
            this.f3367a = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.f3367a.removeOnAttachStateChangeListener(this);
            androidx.core.view.M.c0(this.f3367a);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a */
        static final /* synthetic */ int[] f3369a;

        static {
            int[] iArr = new int[AbstractC0203h.b.values().length];
            f3369a = iArr;
            try {
                iArr[AbstractC0203h.b.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3369a[AbstractC0203h.b.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3369a[AbstractC0203h.b.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3369a[AbstractC0203h.b.INITIALIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    C(q qVar, D d2, Fragment fragment) {
        this.f3363a = qVar;
        this.f3364b = d2;
        this.f3365c = fragment;
    }

    private boolean l(View view) {
        if (view == this.f3365c.mView) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.f3365c.mView) {
                return true;
            }
        }
        return false;
    }

    private Bundle q() {
        Bundle bundle = new Bundle();
        this.f3365c.performSaveInstanceState(bundle);
        this.f3363a.j(this.f3365c, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.f3365c.mView != null) {
            s();
        }
        if (this.f3365c.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.f3365c.mSavedViewState);
        }
        if (this.f3365c.mSavedViewRegistryState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle("android:view_registry_state", this.f3365c.mSavedViewRegistryState);
        }
        if (!this.f3365c.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.f3365c.mUserVisibleHint);
        }
        return bundle;
    }

    void a() {
        if (w.H0(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.f3365c);
        }
        Fragment fragment = this.f3365c;
        fragment.performActivityCreated(fragment.mSavedFragmentState);
        q qVar = this.f3363a;
        Fragment fragment2 = this.f3365c;
        qVar.a(fragment2, fragment2.mSavedFragmentState, false);
    }

    void b() {
        int iJ = this.f3364b.j(this.f3365c);
        Fragment fragment = this.f3365c;
        fragment.mContainer.addView(fragment.mView, iJ);
    }

    void c() {
        if (w.H0(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.f3365c);
        }
        Fragment fragment = this.f3365c;
        Fragment fragment2 = fragment.mTarget;
        C cN = null;
        if (fragment2 != null) {
            C cN2 = this.f3364b.n(fragment2.mWho);
            if (cN2 == null) {
                throw new IllegalStateException("Fragment " + this.f3365c + " declared target fragment " + this.f3365c.mTarget + " that does not belong to this FragmentManager!");
            }
            Fragment fragment3 = this.f3365c;
            fragment3.mTargetWho = fragment3.mTarget.mWho;
            fragment3.mTarget = null;
            cN = cN2;
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (cN = this.f3364b.n(str)) == null) {
                throw new IllegalStateException("Fragment " + this.f3365c + " declared target fragment " + this.f3365c.mTargetWho + " that does not belong to this FragmentManager!");
            }
        }
        if (cN != null) {
            cN.m();
        }
        Fragment fragment4 = this.f3365c;
        fragment4.mHost = fragment4.mFragmentManager.u0();
        Fragment fragment5 = this.f3365c;
        fragment5.mParentFragment = fragment5.mFragmentManager.x0();
        this.f3363a.g(this.f3365c, false);
        this.f3365c.performAttach();
        this.f3363a.b(this.f3365c, false);
    }

    int d() {
        Fragment fragment = this.f3365c;
        if (fragment.mFragmentManager == null) {
            return fragment.mState;
        }
        int iMin = this.e;
        int i2 = b.f3369a[fragment.mMaxState.ordinal()];
        if (i2 != 1) {
            iMin = i2 != 2 ? i2 != 3 ? i2 != 4 ? Math.min(iMin, -1) : Math.min(iMin, 0) : Math.min(iMin, 1) : Math.min(iMin, 5);
        }
        Fragment fragment2 = this.f3365c;
        if (fragment2.mFromLayout) {
            if (fragment2.mInLayout) {
                iMin = Math.max(this.e, 2);
                View view = this.f3365c.mView;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = this.e < 4 ? Math.min(iMin, fragment2.mState) : Math.min(iMin, 1);
            }
        }
        if (!this.f3365c.mAdded) {
            iMin = Math.min(iMin, 1);
        }
        Fragment fragment3 = this.f3365c;
        ViewGroup viewGroup = fragment3.mContainer;
        K.e.b bVarL = viewGroup != null ? K.n(viewGroup, fragment3.getParentFragmentManager()).l(this) : null;
        if (bVarL == K.e.b.ADDING) {
            iMin = Math.min(iMin, 6);
        } else if (bVarL == K.e.b.REMOVING) {
            iMin = Math.max(iMin, 3);
        } else {
            Fragment fragment4 = this.f3365c;
            if (fragment4.mRemoving) {
                iMin = fragment4.isInBackStack() ? Math.min(iMin, 1) : Math.min(iMin, -1);
            }
        }
        Fragment fragment5 = this.f3365c;
        if (fragment5.mDeferStart && fragment5.mState < 5) {
            iMin = Math.min(iMin, 4);
        }
        if (w.H0(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + iMin + " for " + this.f3365c);
        }
        return iMin;
    }

    void e() {
        if (w.H0(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.f3365c);
        }
        Fragment fragment = this.f3365c;
        if (fragment.mIsCreated) {
            fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
            this.f3365c.mState = 1;
            return;
        }
        this.f3363a.h(fragment, fragment.mSavedFragmentState, false);
        Fragment fragment2 = this.f3365c;
        fragment2.performCreate(fragment2.mSavedFragmentState);
        q qVar = this.f3363a;
        Fragment fragment3 = this.f3365c;
        qVar.c(fragment3, fragment3.mSavedFragmentState, false);
    }

    void f() throws Resources.NotFoundException {
        String resourceName;
        if (this.f3365c.mFromLayout) {
            return;
        }
        if (w.H0(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f3365c);
        }
        Fragment fragment = this.f3365c;
        LayoutInflater layoutInflaterPerformGetLayoutInflater = fragment.performGetLayoutInflater(fragment.mSavedFragmentState);
        Fragment fragment2 = this.f3365c;
        ViewGroup viewGroup = fragment2.mContainer;
        if (viewGroup == null) {
            int i2 = fragment2.mContainerId;
            if (i2 == 0) {
                viewGroup = null;
            } else {
                if (i2 == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + this.f3365c + " for a container view with no id");
                }
                viewGroup = (ViewGroup) fragment2.mFragmentManager.q0().d(this.f3365c.mContainerId);
                if (viewGroup == null) {
                    Fragment fragment3 = this.f3365c;
                    if (!fragment3.mRestored) {
                        try {
                            resourceName = fragment3.getResources().getResourceName(this.f3365c.mContainerId);
                        } catch (Resources.NotFoundException unused) {
                            resourceName = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f3365c.mContainerId) + " (" + resourceName + ") for fragment " + this.f3365c);
                    }
                } else if (!(viewGroup instanceof C0194l)) {
                    F.c.n(this.f3365c, viewGroup);
                }
            }
        }
        Fragment fragment4 = this.f3365c;
        fragment4.mContainer = viewGroup;
        fragment4.performCreateView(layoutInflaterPerformGetLayoutInflater, viewGroup, fragment4.mSavedFragmentState);
        View view = this.f3365c.mView;
        if (view != null) {
            view.setSaveFromParentEnabled(false);
            Fragment fragment5 = this.f3365c;
            fragment5.mView.setTag(E.b.f144a, fragment5);
            if (viewGroup != null) {
                b();
            }
            Fragment fragment6 = this.f3365c;
            if (fragment6.mHidden) {
                fragment6.mView.setVisibility(8);
            }
            if (androidx.core.view.M.N(this.f3365c.mView)) {
                androidx.core.view.M.c0(this.f3365c.mView);
            } else {
                View view2 = this.f3365c.mView;
                view2.addOnAttachStateChangeListener(new a(view2));
            }
            this.f3365c.performViewCreated();
            q qVar = this.f3363a;
            Fragment fragment7 = this.f3365c;
            qVar.m(fragment7, fragment7.mView, fragment7.mSavedFragmentState, false);
            int visibility = this.f3365c.mView.getVisibility();
            this.f3365c.setPostOnViewCreatedAlpha(this.f3365c.mView.getAlpha());
            Fragment fragment8 = this.f3365c;
            if (fragment8.mContainer != null && visibility == 0) {
                View viewFindFocus = fragment8.mView.findFocus();
                if (viewFindFocus != null) {
                    this.f3365c.setFocusedView(viewFindFocus);
                    if (w.H0(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + this.f3365c);
                    }
                }
                this.f3365c.mView.setAlpha(0.0f);
            }
        }
        this.f3365c.mState = 2;
    }

    void g() {
        Fragment fragmentF;
        if (w.H0(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.f3365c);
        }
        Fragment fragment = this.f3365c;
        boolean zIsChangingConfigurations = true;
        boolean z2 = fragment.mRemoving && !fragment.isInBackStack();
        if (z2) {
            Fragment fragment2 = this.f3365c;
            if (!fragment2.mBeingSaved) {
                this.f3364b.B(fragment2.mWho, null);
            }
        }
        if (!z2 && !this.f3364b.p().r(this.f3365c)) {
            String str = this.f3365c.mTargetWho;
            if (str != null && (fragmentF = this.f3364b.f(str)) != null && fragmentF.mRetainInstance) {
                this.f3365c.mTarget = fragmentF;
            }
            this.f3365c.mState = 0;
            return;
        }
        o oVar = this.f3365c.mHost;
        if (oVar instanceof androidx.lifecycle.J) {
            zIsChangingConfigurations = this.f3364b.p().o();
        } else if (oVar.h() instanceof Activity) {
            zIsChangingConfigurations = true ^ ((Activity) oVar.h()).isChangingConfigurations();
        }
        if ((z2 && !this.f3365c.mBeingSaved) || zIsChangingConfigurations) {
            this.f3364b.p().g(this.f3365c);
        }
        this.f3365c.performDestroy();
        this.f3363a.d(this.f3365c, false);
        for (C c2 : this.f3364b.k()) {
            if (c2 != null) {
                Fragment fragmentK = c2.k();
                if (this.f3365c.mWho.equals(fragmentK.mTargetWho)) {
                    fragmentK.mTarget = this.f3365c;
                    fragmentK.mTargetWho = null;
                }
            }
        }
        Fragment fragment3 = this.f3365c;
        String str2 = fragment3.mTargetWho;
        if (str2 != null) {
            fragment3.mTarget = this.f3364b.f(str2);
        }
        this.f3364b.s(this);
    }

    void h() {
        View view;
        if (w.H0(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.f3365c);
        }
        Fragment fragment = this.f3365c;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && (view = fragment.mView) != null) {
            viewGroup.removeView(view);
        }
        this.f3365c.performDestroyView();
        this.f3363a.n(this.f3365c, false);
        Fragment fragment2 = this.f3365c;
        fragment2.mContainer = null;
        fragment2.mView = null;
        fragment2.mViewLifecycleOwner = null;
        fragment2.mViewLifecycleOwnerLiveData.h(null);
        this.f3365c.mInLayout = false;
    }

    void i() {
        if (w.H0(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.f3365c);
        }
        this.f3365c.performDetach();
        this.f3363a.e(this.f3365c, false);
        Fragment fragment = this.f3365c;
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if ((!fragment.mRemoving || fragment.isInBackStack()) && !this.f3364b.p().r(this.f3365c)) {
            return;
        }
        if (w.H0(3)) {
            Log.d("FragmentManager", "initState called for fragment: " + this.f3365c);
        }
        this.f3365c.initState();
    }

    void j() {
        Fragment fragment = this.f3365c;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (w.H0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f3365c);
            }
            Fragment fragment2 = this.f3365c;
            fragment2.performCreateView(fragment2.performGetLayoutInflater(fragment2.mSavedFragmentState), null, this.f3365c.mSavedFragmentState);
            View view = this.f3365c.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.f3365c;
                fragment3.mView.setTag(E.b.f144a, fragment3);
                Fragment fragment4 = this.f3365c;
                if (fragment4.mHidden) {
                    fragment4.mView.setVisibility(8);
                }
                this.f3365c.performViewCreated();
                q qVar = this.f3363a;
                Fragment fragment5 = this.f3365c;
                qVar.m(fragment5, fragment5.mView, fragment5.mSavedFragmentState, false);
                this.f3365c.mState = 2;
            }
        }
    }

    Fragment k() {
        return this.f3365c;
    }

    void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (this.f3366d) {
            if (w.H0(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + k());
                return;
            }
            return;
        }
        try {
            this.f3366d = true;
            boolean z2 = false;
            while (true) {
                int iD = d();
                Fragment fragment = this.f3365c;
                int i2 = fragment.mState;
                if (iD == i2) {
                    if (!z2 && i2 == -1 && fragment.mRemoving && !fragment.isInBackStack() && !this.f3365c.mBeingSaved) {
                        if (w.H0(3)) {
                            Log.d("FragmentManager", "Cleaning up state of never attached fragment: " + this.f3365c);
                        }
                        this.f3364b.p().g(this.f3365c);
                        this.f3364b.s(this);
                        if (w.H0(3)) {
                            Log.d("FragmentManager", "initState called for fragment: " + this.f3365c);
                        }
                        this.f3365c.initState();
                    }
                    Fragment fragment2 = this.f3365c;
                    if (fragment2.mHiddenChanged) {
                        if (fragment2.mView != null && (viewGroup = fragment2.mContainer) != null) {
                            K kN = K.n(viewGroup, fragment2.getParentFragmentManager());
                            if (this.f3365c.mHidden) {
                                kN.c(this);
                            } else {
                                kN.e(this);
                            }
                        }
                        Fragment fragment3 = this.f3365c;
                        w wVar = fragment3.mFragmentManager;
                        if (wVar != null) {
                            wVar.F0(fragment3);
                        }
                        Fragment fragment4 = this.f3365c;
                        fragment4.mHiddenChanged = false;
                        fragment4.onHiddenChanged(fragment4.mHidden);
                        this.f3365c.mChildFragmentManager.J();
                    }
                    this.f3366d = false;
                    return;
                }
                if (iD <= i2) {
                    switch (i2 - 1) {
                        case -1:
                            i();
                            break;
                        case 0:
                            if (fragment.mBeingSaved && this.f3364b.q(fragment.mWho) == null) {
                                r();
                            }
                            g();
                            break;
                        case 1:
                            h();
                            this.f3365c.mState = 1;
                            break;
                        case 2:
                            fragment.mInLayout = false;
                            fragment.mState = 2;
                            break;
                        case 3:
                            if (w.H0(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.f3365c);
                            }
                            Fragment fragment5 = this.f3365c;
                            if (fragment5.mBeingSaved) {
                                r();
                            } else if (fragment5.mView != null && fragment5.mSavedViewState == null) {
                                s();
                            }
                            Fragment fragment6 = this.f3365c;
                            if (fragment6.mView != null && (viewGroup2 = fragment6.mContainer) != null) {
                                K.n(viewGroup2, fragment6.getParentFragmentManager()).d(this);
                            }
                            this.f3365c.mState = 3;
                            break;
                        case 4:
                            v();
                            break;
                        case 5:
                            fragment.mState = 5;
                            break;
                        case 6:
                            n();
                            break;
                    }
                } else {
                    switch (i2 + 1) {
                        case 0:
                            c();
                            break;
                        case 1:
                            e();
                            break;
                        case 2:
                            j();
                            f();
                            break;
                        case 3:
                            a();
                            break;
                        case 4:
                            if (fragment.mView != null && (viewGroup3 = fragment.mContainer) != null) {
                                K.n(viewGroup3, fragment.getParentFragmentManager()).b(K.e.c.b(this.f3365c.mView.getVisibility()), this);
                            }
                            this.f3365c.mState = 4;
                            break;
                        case 5:
                            u();
                            break;
                        case 6:
                            fragment.mState = 6;
                            break;
                        case 7:
                            p();
                            break;
                    }
                }
                z2 = true;
            }
        } catch (Throwable th) {
            this.f3366d = false;
            throw th;
        }
    }

    void n() {
        if (w.H0(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.f3365c);
        }
        this.f3365c.performPause();
        this.f3363a.f(this.f3365c, false);
    }

    void o(ClassLoader classLoader) {
        Bundle bundle = this.f3365c.mSavedFragmentState;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        Fragment fragment = this.f3365c;
        fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
        Fragment fragment2 = this.f3365c;
        fragment2.mSavedViewRegistryState = fragment2.mSavedFragmentState.getBundle("android:view_registry_state");
        Fragment fragment3 = this.f3365c;
        fragment3.mTargetWho = fragment3.mSavedFragmentState.getString("android:target_state");
        Fragment fragment4 = this.f3365c;
        if (fragment4.mTargetWho != null) {
            fragment4.mTargetRequestCode = fragment4.mSavedFragmentState.getInt("android:target_req_state", 0);
        }
        Fragment fragment5 = this.f3365c;
        Boolean bool = fragment5.mSavedUserVisibleHint;
        if (bool != null) {
            fragment5.mUserVisibleHint = bool.booleanValue();
            this.f3365c.mSavedUserVisibleHint = null;
        } else {
            fragment5.mUserVisibleHint = fragment5.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
        }
        Fragment fragment6 = this.f3365c;
        if (fragment6.mUserVisibleHint) {
            return;
        }
        fragment6.mDeferStart = true;
    }

    void p() {
        if (w.H0(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.f3365c);
        }
        View focusedView = this.f3365c.getFocusedView();
        if (focusedView != null && l(focusedView)) {
            boolean zRequestFocus = focusedView.requestFocus();
            if (w.H0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("requestFocus: Restoring focused view ");
                sb.append(focusedView);
                sb.append(" ");
                sb.append(zRequestFocus ? "succeeded" : "failed");
                sb.append(" on Fragment ");
                sb.append(this.f3365c);
                sb.append(" resulting in focused view ");
                sb.append(this.f3365c.mView.findFocus());
                Log.v("FragmentManager", sb.toString());
            }
        }
        this.f3365c.setFocusedView(null);
        this.f3365c.performResume();
        this.f3363a.i(this.f3365c, false);
        Fragment fragment = this.f3365c;
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
    }

    void r() {
        B b2 = new B(this.f3365c);
        Fragment fragment = this.f3365c;
        if (fragment.mState <= -1 || b2.f3362m != null) {
            b2.f3362m = fragment.mSavedFragmentState;
        } else {
            Bundle bundleQ = q();
            b2.f3362m = bundleQ;
            if (this.f3365c.mTargetWho != null) {
                if (bundleQ == null) {
                    b2.f3362m = new Bundle();
                }
                b2.f3362m.putString("android:target_state", this.f3365c.mTargetWho);
                int i2 = this.f3365c.mTargetRequestCode;
                if (i2 != 0) {
                    b2.f3362m.putInt("android:target_req_state", i2);
                }
            }
        }
        this.f3364b.B(this.f3365c.mWho, b2);
    }

    void s() {
        if (this.f3365c.mView == null) {
            return;
        }
        if (w.H0(2)) {
            Log.v("FragmentManager", "Saving view state for fragment " + this.f3365c + " with view " + this.f3365c.mView);
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.f3365c.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.f3365c.mSavedViewState = sparseArray;
        }
        Bundle bundle = new Bundle();
        this.f3365c.mViewLifecycleOwner.e(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        this.f3365c.mSavedViewRegistryState = bundle;
    }

    void t(int i2) {
        this.e = i2;
    }

    void u() {
        if (w.H0(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.f3365c);
        }
        this.f3365c.performStart();
        this.f3363a.k(this.f3365c, false);
    }

    void v() {
        if (w.H0(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.f3365c);
        }
        this.f3365c.performStop();
        this.f3363a.l(this.f3365c, false);
    }

    C(q qVar, D d2, ClassLoader classLoader, n nVar, B b2) {
        this.f3363a = qVar;
        this.f3364b = d2;
        Fragment fragmentA = b2.a(nVar, classLoader);
        this.f3365c = fragmentA;
        if (w.H0(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + fragmentA);
        }
    }

    C(q qVar, D d2, Fragment fragment, B b2) {
        this.f3363a = qVar;
        this.f3364b = d2;
        this.f3365c = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        Bundle bundle = b2.f3362m;
        if (bundle != null) {
            fragment.mSavedFragmentState = bundle;
        } else {
            fragment.mSavedFragmentState = new Bundle();
        }
    }
}
