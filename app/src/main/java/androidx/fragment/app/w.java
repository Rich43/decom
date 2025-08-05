package androidx.fragment.app;

import F.c;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.view.InterfaceC0179w;
import androidx.core.view.InterfaceC0182z;
import androidx.fragment.app.E;
import androidx.lifecycle.AbstractC0203h;
import androidx.savedstate.a;
import b.C0211a;
import b.g;
import c.AbstractC0224a;
import c.C0225b;
import c.C0226c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import v.InterfaceC0338a;

/* loaded from: classes.dex */
public abstract class w {

    /* renamed from: S */
    private static boolean f3584S = false;

    /* renamed from: D */
    private b.c f3588D;

    /* renamed from: E */
    private b.c f3589E;

    /* renamed from: F */
    private b.c f3590F;

    /* renamed from: H */
    private boolean f3592H;

    /* renamed from: I */
    private boolean f3593I;

    /* renamed from: J */
    private boolean f3594J;

    /* renamed from: K */
    private boolean f3595K;

    /* renamed from: L */
    private boolean f3596L;

    /* renamed from: M */
    private ArrayList f3597M;

    /* renamed from: N */
    private ArrayList f3598N;

    /* renamed from: O */
    private ArrayList f3599O;

    /* renamed from: P */
    private z f3600P;

    /* renamed from: Q */
    private c.C0005c f3601Q;

    /* renamed from: b */
    private boolean f3604b;

    /* renamed from: d */
    ArrayList f3606d;
    private ArrayList e;

    /* renamed from: g */
    private OnBackPressedDispatcher f3608g;

    /* renamed from: m */
    private ArrayList f3614m;

    /* renamed from: v */
    private o f3620v;

    /* renamed from: w */
    private AbstractC0193k f3621w;

    /* renamed from: x */
    private Fragment f3622x;

    /* renamed from: y */
    Fragment f3623y;

    /* renamed from: a */
    private final ArrayList f3603a = new ArrayList();

    /* renamed from: c */
    private final D f3605c = new D();

    /* renamed from: f */
    private final p f3607f = new p(this);

    /* renamed from: h */
    private final androidx.activity.u f3609h = new b(false);

    /* renamed from: i */
    private final AtomicInteger f3610i = new AtomicInteger();

    /* renamed from: j */
    private final Map f3611j = Collections.synchronizedMap(new HashMap());

    /* renamed from: k */
    private final Map f3612k = Collections.synchronizedMap(new HashMap());

    /* renamed from: l */
    private final Map f3613l = Collections.synchronizedMap(new HashMap());

    /* renamed from: n */
    private final q f3615n = new q(this);
    private final CopyOnWriteArrayList o = new CopyOnWriteArrayList();

    /* renamed from: p */
    private final InterfaceC0338a f3616p = new InterfaceC0338a() { // from class: androidx.fragment.app.r
        @Override // v.InterfaceC0338a
        public final void a(Object obj) {
            this.f3579a.Q0((Configuration) obj);
        }
    };

    /* renamed from: q */
    private final InterfaceC0338a f3617q = new InterfaceC0338a() { // from class: androidx.fragment.app.s
        @Override // v.InterfaceC0338a
        public final void a(Object obj) {
            this.f3580a.R0((Integer) obj);
        }
    };
    private final InterfaceC0338a r = new InterfaceC0338a() { // from class: androidx.fragment.app.t
        @Override // v.InterfaceC0338a
        public final void a(Object obj) {
            this.f3581a.S0((androidx.core.app.i) obj);
        }
    };
    private final InterfaceC0338a s = new InterfaceC0338a() { // from class: androidx.fragment.app.u
        @Override // v.InterfaceC0338a
        public final void a(Object obj) {
            this.f3582a.T0((androidx.core.app.q) obj);
        }
    };

    /* renamed from: t */
    private final InterfaceC0182z f3618t = new c();

    /* renamed from: u */
    int f3619u = -1;

    /* renamed from: z */
    private n f3624z = null;

    /* renamed from: A */
    private n f3585A = new d();

    /* renamed from: B */
    private L f3586B = null;

    /* renamed from: C */
    private L f3587C = new e();

    /* renamed from: G */
    ArrayDeque f3591G = new ArrayDeque();

    /* renamed from: R */
    private Runnable f3602R = new f();

    class a implements b.b {
        a() {
        }

        @Override // b.b
        /* renamed from: b */
        public void a(Map map) {
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                iArr[i2] = ((Boolean) arrayList.get(i2)).booleanValue() ? 0 : -1;
            }
            k kVar = (k) w.this.f3591G.pollFirst();
            if (kVar == null) {
                Log.w("FragmentManager", "No permissions were requested for " + this);
                return;
            }
            String str = kVar.f3635a;
            int i3 = kVar.f3636b;
            Fragment fragmentI = w.this.f3605c.i(str);
            if (fragmentI != null) {
                fragmentI.onRequestPermissionsResult(i3, strArr, iArr);
                return;
            }
            Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
        }
    }

    class b extends androidx.activity.u {
        b(boolean z2) {
            super(z2);
        }

        @Override // androidx.activity.u
        public void d() {
            w.this.D0();
        }
    }

    class c implements InterfaceC0182z {
        c() {
        }

        @Override // androidx.core.view.InterfaceC0182z
        public void a(Menu menu, MenuInflater menuInflater) {
            w.this.D(menu, menuInflater);
        }

        @Override // androidx.core.view.InterfaceC0182z
        public void b(Menu menu) {
            w.this.P(menu);
        }

        @Override // androidx.core.view.InterfaceC0182z
        public boolean c(MenuItem menuItem) {
            return w.this.K(menuItem);
        }

        @Override // androidx.core.view.InterfaceC0182z
        public void d(Menu menu) {
            w.this.L(menu);
        }
    }

    class d extends n {
        d() {
        }

        @Override // androidx.fragment.app.n
        public Fragment a(ClassLoader classLoader, String str) {
            return w.this.u0().c(w.this.u0().h(), str, null);
        }
    }

    class e implements L {
        e() {
        }

        @Override // androidx.fragment.app.L
        public K a(ViewGroup viewGroup) {
            return new C0186d(viewGroup);
        }
    }

    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            w.this.b0(true);
        }
    }

    class g implements A {

        /* renamed from: a */
        final /* synthetic */ Fragment f3631a;

        g(Fragment fragment) {
            this.f3631a = fragment;
        }

        @Override // androidx.fragment.app.A
        public void a(w wVar, Fragment fragment) {
            this.f3631a.onAttachFragment(fragment);
        }
    }

    class h implements b.b {
        h() {
        }

        @Override // b.b
        /* renamed from: b */
        public void a(C0211a c0211a) {
            k kVar = (k) w.this.f3591G.pollFirst();
            if (kVar == null) {
                Log.w("FragmentManager", "No Activities were started for result for " + this);
                return;
            }
            String str = kVar.f3635a;
            int i2 = kVar.f3636b;
            Fragment fragmentI = w.this.f3605c.i(str);
            if (fragmentI != null) {
                fragmentI.onActivityResult(i2, c0211a.b(), c0211a.a());
                return;
            }
            Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
        }
    }

    class i implements b.b {
        i() {
        }

        @Override // b.b
        /* renamed from: b */
        public void a(C0211a c0211a) {
            k kVar = (k) w.this.f3591G.pollFirst();
            if (kVar == null) {
                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                return;
            }
            String str = kVar.f3635a;
            int i2 = kVar.f3636b;
            Fragment fragmentI = w.this.f3605c.i(str);
            if (fragmentI != null) {
                fragmentI.onActivityResult(i2, c0211a.b(), c0211a.a());
                return;
            }
            Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
        }
    }

    static class j extends AbstractC0224a {
        j() {
        }

        @Override // c.AbstractC0224a
        /* renamed from: d */
        public Intent a(Context context, b.g gVar) {
            Bundle bundleExtra;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent intentA = gVar.a();
            if (intentA != null && (bundleExtra = intentA.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                intentA.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (intentA.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    gVar = new g.a(gVar.d()).b(null).c(gVar.c(), gVar.b()).a();
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", gVar);
            if (w.H0(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        @Override // c.AbstractC0224a
        /* renamed from: e */
        public C0211a c(int i2, Intent intent) {
            return new C0211a(i2, intent);
        }
    }

    interface l {
        boolean a(ArrayList arrayList, ArrayList arrayList2);
    }

    static Fragment B0(View view) {
        Object tag = view.getTag(E.b.f144a);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    public static boolean H0(int i2) {
        return f3584S || Log.isLoggable("FragmentManager", i2);
    }

    private boolean I0(Fragment fragment) {
        return (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.q();
    }

    private boolean J0() {
        Fragment fragment = this.f3622x;
        if (fragment == null) {
            return true;
        }
        return fragment.isAdded() && this.f3622x.getParentFragmentManager().J0();
    }

    private void M(Fragment fragment) {
        if (fragment == null || !fragment.equals(f0(fragment.mWho))) {
            return;
        }
        fragment.performPrimaryNavigationFragmentChanged();
    }

    public /* synthetic */ void Q0(Configuration configuration) {
        if (J0()) {
            A(configuration, false);
        }
    }

    public /* synthetic */ void R0(Integer num) {
        if (J0() && num.intValue() == 80) {
            G(false);
        }
    }

    public /* synthetic */ void S0(androidx.core.app.i iVar) {
        if (J0()) {
            H(iVar.a(), false);
        }
    }

    private void T(int i2) {
        try {
            this.f3604b = true;
            this.f3605c.d(i2);
            X0(i2, false);
            Iterator it = u().iterator();
            while (it.hasNext()) {
                ((K) it.next()).j();
            }
            this.f3604b = false;
            b0(true);
        } catch (Throwable th) {
            this.f3604b = false;
            throw th;
        }
    }

    public /* synthetic */ void T0(androidx.core.app.q qVar) {
        if (J0()) {
            O(qVar.a(), false);
        }
    }

    private void W() {
        if (this.f3596L) {
            this.f3596L = false;
            r1();
        }
    }

    private void Y() {
        Iterator it = u().iterator();
        while (it.hasNext()) {
            ((K) it.next()).j();
        }
    }

    private void a0(boolean z2) {
        if (this.f3604b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f3620v == null) {
            if (!this.f3595K) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.f3620v.i().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z2) {
            r();
        }
        if (this.f3597M == null) {
            this.f3597M = new ArrayList();
            this.f3598N = new ArrayList();
        }
    }

    private boolean c1(String str, int i2, int i3) {
        b0(false);
        a0(true);
        Fragment fragment = this.f3623y;
        if (fragment != null && i2 < 0 && str == null && fragment.getChildFragmentManager().b1()) {
            return true;
        }
        boolean zD1 = d1(this.f3597M, this.f3598N, str, i2, i3);
        if (zD1) {
            this.f3604b = true;
            try {
                f1(this.f3597M, this.f3598N);
            } finally {
                s();
            }
        }
        t1();
        W();
        this.f3605c.b();
        return zD1;
    }

    private static void d0(ArrayList arrayList, ArrayList arrayList2, int i2, int i3) {
        while (i2 < i3) {
            C0183a c0183a = (C0183a) arrayList.get(i2);
            if (((Boolean) arrayList2.get(i2)).booleanValue()) {
                c0183a.p(-1);
                c0183a.u();
            } else {
                c0183a.p(1);
                c0183a.t();
            }
            i2++;
        }
    }

    private void e0(ArrayList arrayList, ArrayList arrayList2, int i2, int i3) {
        boolean z2 = ((C0183a) arrayList.get(i2)).r;
        ArrayList arrayList3 = this.f3599O;
        if (arrayList3 == null) {
            this.f3599O = new ArrayList();
        } else {
            arrayList3.clear();
        }
        this.f3599O.addAll(this.f3605c.o());
        Fragment fragmentY0 = y0();
        boolean z3 = false;
        for (int i4 = i2; i4 < i3; i4++) {
            C0183a c0183a = (C0183a) arrayList.get(i4);
            fragmentY0 = !((Boolean) arrayList2.get(i4)).booleanValue() ? c0183a.v(this.f3599O, fragmentY0) : c0183a.y(this.f3599O, fragmentY0);
            z3 = z3 || c0183a.f3381i;
        }
        this.f3599O.clear();
        if (!z2 && this.f3619u >= 1) {
            for (int i5 = i2; i5 < i3; i5++) {
                Iterator it = ((C0183a) arrayList.get(i5)).f3376c.iterator();
                while (it.hasNext()) {
                    Fragment fragment = ((E.a) it.next()).f3390b;
                    if (fragment != null && fragment.mFragmentManager != null) {
                        this.f3605c.r(w(fragment));
                    }
                }
            }
        }
        d0(arrayList, arrayList2, i2, i3);
        boolean zBooleanValue = ((Boolean) arrayList2.get(i3 - 1)).booleanValue();
        for (int i6 = i2; i6 < i3; i6++) {
            C0183a c0183a2 = (C0183a) arrayList.get(i6);
            if (zBooleanValue) {
                for (int size = c0183a2.f3376c.size() - 1; size >= 0; size--) {
                    Fragment fragment2 = ((E.a) c0183a2.f3376c.get(size)).f3390b;
                    if (fragment2 != null) {
                        w(fragment2).m();
                    }
                }
            } else {
                Iterator it2 = c0183a2.f3376c.iterator();
                while (it2.hasNext()) {
                    Fragment fragment3 = ((E.a) it2.next()).f3390b;
                    if (fragment3 != null) {
                        w(fragment3).m();
                    }
                }
            }
        }
        X0(this.f3619u, true);
        for (K k2 : v(arrayList, i2, i3)) {
            k2.r(zBooleanValue);
            k2.p();
            k2.g();
        }
        while (i2 < i3) {
            C0183a c0183a3 = (C0183a) arrayList.get(i2);
            if (((Boolean) arrayList2.get(i2)).booleanValue() && c0183a3.f3490v >= 0) {
                c0183a3.f3490v = -1;
            }
            c0183a3.x();
            i2++;
        }
        if (z3) {
            h1();
        }
    }

    private void f1(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            if (!((C0183a) arrayList.get(i2)).r) {
                if (i3 != i2) {
                    e0(arrayList, arrayList2, i3, i2);
                }
                i3 = i2 + 1;
                if (((Boolean) arrayList2.get(i2)).booleanValue()) {
                    while (i3 < size && ((Boolean) arrayList2.get(i3)).booleanValue() && !((C0183a) arrayList.get(i3)).r) {
                        i3++;
                    }
                }
                e0(arrayList, arrayList2, i2, i3);
                i2 = i3 - 1;
            }
            i2++;
        }
        if (i3 != size) {
            e0(arrayList, arrayList2, i3, size);
        }
    }

    private int g0(String str, int i2, boolean z2) {
        ArrayList arrayList = this.f3606d;
        if (arrayList == null || arrayList.isEmpty()) {
            return -1;
        }
        if (str == null && i2 < 0) {
            if (z2) {
                return 0;
            }
            return this.f3606d.size() - 1;
        }
        int size = this.f3606d.size() - 1;
        while (size >= 0) {
            C0183a c0183a = (C0183a) this.f3606d.get(size);
            if ((str != null && str.equals(c0183a.w())) || (i2 >= 0 && i2 == c0183a.f3490v)) {
                break;
            }
            size--;
        }
        if (size < 0) {
            return size;
        }
        if (!z2) {
            if (size == this.f3606d.size() - 1) {
                return -1;
            }
            return size + 1;
        }
        while (size > 0) {
            C0183a c0183a2 = (C0183a) this.f3606d.get(size - 1);
            if ((str == null || !str.equals(c0183a2.w())) && (i2 < 0 || i2 != c0183a2.f3490v)) {
                return size;
            }
            size--;
        }
        return size;
    }

    private void h1() {
        ArrayList arrayList = this.f3614m;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        androidx.appcompat.app.F.a(this.f3614m.get(0));
        throw null;
    }

    static int j1(int i2) {
        if (i2 == 4097) {
            return 8194;
        }
        if (i2 == 8194) {
            return 4097;
        }
        if (i2 == 8197) {
            return 4100;
        }
        if (i2 != 4099) {
            return i2 != 4100 ? 0 : 8197;
        }
        return 4099;
    }

    static w k0(View view) {
        AbstractActivityC0191i abstractActivityC0191i;
        Fragment fragmentL0 = l0(view);
        if (fragmentL0 != null) {
            if (fragmentL0.isAdded()) {
                return fragmentL0.getChildFragmentManager();
            }
            throw new IllegalStateException("The Fragment " + fragmentL0 + " that owns View " + view + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
        }
        Context context = view.getContext();
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                abstractActivityC0191i = null;
                break;
            }
            if (context instanceof AbstractActivityC0191i) {
                abstractActivityC0191i = (AbstractActivityC0191i) context;
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (abstractActivityC0191i != null) {
            return abstractActivityC0191i.N0();
        }
        throw new IllegalStateException("View " + view + " is not within a subclass of FragmentActivity.");
    }

    private static Fragment l0(View view) {
        while (view != null) {
            Fragment fragmentB0 = B0(view);
            if (fragmentB0 != null) {
                return fragmentB0;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    private void m0() {
        Iterator it = u().iterator();
        while (it.hasNext()) {
            ((K) it.next()).k();
        }
    }

    private boolean n0(ArrayList arrayList, ArrayList arrayList2) {
        synchronized (this.f3603a) {
            if (this.f3603a.isEmpty()) {
                return false;
            }
            try {
                int size = this.f3603a.size();
                boolean zA = false;
                for (int i2 = 0; i2 < size; i2++) {
                    zA |= ((l) this.f3603a.get(i2)).a(arrayList, arrayList2);
                }
                return zA;
            } finally {
                this.f3603a.clear();
                this.f3620v.i().removeCallbacks(this.f3602R);
            }
        }
    }

    private z p0(Fragment fragment) {
        return this.f3600P.k(fragment);
    }

    private void p1(Fragment fragment) {
        ViewGroup viewGroupR0 = r0(fragment);
        if (viewGroupR0 == null || fragment.getEnterAnim() + fragment.getExitAnim() + fragment.getPopEnterAnim() + fragment.getPopExitAnim() <= 0) {
            return;
        }
        int i2 = E.b.f146c;
        if (viewGroupR0.getTag(i2) == null) {
            viewGroupR0.setTag(i2, fragment);
        }
        ((Fragment) viewGroupR0.getTag(i2)).setPopDirection(fragment.getPopDirection());
    }

    private void r() {
        if (O0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private ViewGroup r0(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId > 0 && this.f3621w.e()) {
            View viewD = this.f3621w.d(fragment.mContainerId);
            if (viewD instanceof ViewGroup) {
                return (ViewGroup) viewD;
            }
        }
        return null;
    }

    private void r1() {
        Iterator it = this.f3605c.k().iterator();
        while (it.hasNext()) {
            a1((C) it.next());
        }
    }

    private void s() {
        this.f3604b = false;
        this.f3598N.clear();
        this.f3597M.clear();
    }

    private void s1(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new J("FragmentManager"));
        o oVar = this.f3620v;
        if (oVar != null) {
            try {
                oVar.j("  ", null, printWriter, new String[0]);
                throw runtimeException;
            } catch (Exception e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
                throw runtimeException;
            }
        }
        try {
            X("  ", null, printWriter, new String[0]);
            throw runtimeException;
        } catch (Exception e3) {
            Log.e("FragmentManager", "Failed dumping state", e3);
            throw runtimeException;
        }
    }

    private void t() {
        o oVar = this.f3620v;
        if (oVar instanceof androidx.lifecycle.J ? this.f3605c.p().o() : oVar.h() instanceof Activity ? !((Activity) this.f3620v.h()).isChangingConfigurations() : true) {
            Iterator it = this.f3611j.values().iterator();
            while (it.hasNext()) {
                Iterator it2 = ((C0185c) it.next()).f3505a.iterator();
                while (it2.hasNext()) {
                    this.f3605c.p().h((String) it2.next());
                }
            }
        }
    }

    private void t1() {
        synchronized (this.f3603a) {
            try {
                if (this.f3603a.isEmpty()) {
                    this.f3609h.j(o0() > 0 && M0(this.f3622x));
                } else {
                    this.f3609h.j(true);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private Set u() {
        HashSet hashSet = new HashSet();
        Iterator it = this.f3605c.k().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((C) it.next()).k().mContainer;
            if (viewGroup != null) {
                hashSet.add(K.o(viewGroup, z0()));
            }
        }
        return hashSet;
    }

    private Set v(ArrayList arrayList, int i2, int i3) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i2 < i3) {
            Iterator it = ((C0183a) arrayList.get(i2)).f3376c.iterator();
            while (it.hasNext()) {
                Fragment fragment = ((E.a) it.next()).f3390b;
                if (fragment != null && (viewGroup = fragment.mContainer) != null) {
                    hashSet.add(K.n(viewGroup, this));
                }
            }
            i2++;
        }
        return hashSet;
    }

    void A(Configuration configuration, boolean z2) {
        if (z2 && (this.f3620v instanceof androidx.core.content.b)) {
            s1(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
        }
        for (Fragment fragment : this.f3605c.o()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
                if (z2) {
                    fragment.mChildFragmentManager.A(configuration, true);
                }
            }
        }
    }

    public c.C0005c A0() {
        return this.f3601Q;
    }

    boolean B(MenuItem menuItem) {
        if (this.f3619u < 1) {
            return false;
        }
        for (Fragment fragment : this.f3605c.o()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    void C() {
        this.f3593I = false;
        this.f3594J = false;
        this.f3600P.q(false);
        T(1);
    }

    androidx.lifecycle.I C0(Fragment fragment) {
        return this.f3600P.n(fragment);
    }

    boolean D(Menu menu, MenuInflater menuInflater) {
        if (this.f3619u < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z2 = false;
        for (Fragment fragment : this.f3605c.o()) {
            if (fragment != null && L0(fragment) && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(fragment);
                z2 = true;
            }
        }
        if (this.e != null) {
            for (int i2 = 0; i2 < this.e.size(); i2++) {
                Fragment fragment2 = (Fragment) this.e.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.e = arrayList;
        return z2;
    }

    void D0() {
        b0(true);
        if (this.f3609h.g()) {
            b1();
        } else {
            this.f3608g.k();
        }
    }

    void E() {
        this.f3595K = true;
        b0(true);
        Y();
        t();
        T(-1);
        Object obj = this.f3620v;
        if (obj instanceof androidx.core.content.c) {
            ((androidx.core.content.c) obj).Z(this.f3617q);
        }
        Object obj2 = this.f3620v;
        if (obj2 instanceof androidx.core.content.b) {
            ((androidx.core.content.b) obj2).b(this.f3616p);
        }
        Object obj3 = this.f3620v;
        if (obj3 instanceof androidx.core.app.o) {
            ((androidx.core.app.o) obj3).b0(this.r);
        }
        Object obj4 = this.f3620v;
        if (obj4 instanceof androidx.core.app.p) {
            ((androidx.core.app.p) obj4).a0(this.s);
        }
        Object obj5 = this.f3620v;
        if (obj5 instanceof InterfaceC0179w) {
            ((InterfaceC0179w) obj5).n(this.f3618t);
        }
        this.f3620v = null;
        this.f3621w = null;
        this.f3622x = null;
        if (this.f3608g != null) {
            this.f3609h.h();
            this.f3608g = null;
        }
        b.c cVar = this.f3588D;
        if (cVar != null) {
            cVar.c();
            this.f3589E.c();
            this.f3590F.c();
        }
    }

    void E0(Fragment fragment) {
        if (H0(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.mHidden) {
            return;
        }
        fragment.mHidden = true;
        fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
        p1(fragment);
    }

    void F() {
        T(1);
    }

    void F0(Fragment fragment) {
        if (fragment.mAdded && I0(fragment)) {
            this.f3592H = true;
        }
    }

    void G(boolean z2) {
        if (z2 && (this.f3620v instanceof androidx.core.content.c)) {
            s1(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
        }
        for (Fragment fragment : this.f3605c.o()) {
            if (fragment != null) {
                fragment.performLowMemory();
                if (z2) {
                    fragment.mChildFragmentManager.G(true);
                }
            }
        }
    }

    public boolean G0() {
        return this.f3595K;
    }

    void H(boolean z2, boolean z3) {
        if (z3 && (this.f3620v instanceof androidx.core.app.o)) {
            s1(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
        }
        for (Fragment fragment : this.f3605c.o()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z2);
                if (z3) {
                    fragment.mChildFragmentManager.H(z2, true);
                }
            }
        }
    }

    void I(Fragment fragment) {
        Iterator it = this.o.iterator();
        while (it.hasNext()) {
            ((A) it.next()).a(this, fragment);
        }
    }

    void J() {
        for (Fragment fragment : this.f3605c.l()) {
            if (fragment != null) {
                fragment.onHiddenChanged(fragment.isHidden());
                fragment.mChildFragmentManager.J();
            }
        }
    }

    boolean K(MenuItem menuItem) {
        if (this.f3619u < 1) {
            return false;
        }
        for (Fragment fragment : this.f3605c.o()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    boolean K0(Fragment fragment) {
        if (fragment == null) {
            return false;
        }
        return fragment.isHidden();
    }

    void L(Menu menu) {
        if (this.f3619u < 1) {
            return;
        }
        for (Fragment fragment : this.f3605c.o()) {
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    boolean L0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.isMenuVisible();
    }

    boolean M0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        w wVar = fragment.mFragmentManager;
        return fragment.equals(wVar.y0()) && M0(wVar.f3622x);
    }

    void N() {
        T(5);
    }

    boolean N0(int i2) {
        return this.f3619u >= i2;
    }

    void O(boolean z2, boolean z3) {
        if (z3 && (this.f3620v instanceof androidx.core.app.p)) {
            s1(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
        }
        for (Fragment fragment : this.f3605c.o()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z2);
                if (z3) {
                    fragment.mChildFragmentManager.O(z2, true);
                }
            }
        }
    }

    public boolean O0() {
        return this.f3593I || this.f3594J;
    }

    boolean P(Menu menu) {
        boolean z2 = false;
        if (this.f3619u < 1) {
            return false;
        }
        for (Fragment fragment : this.f3605c.o()) {
            if (fragment != null && L0(fragment) && fragment.performPrepareOptionsMenu(menu)) {
                z2 = true;
            }
        }
        return z2;
    }

    void Q() {
        t1();
        M(this.f3623y);
    }

    void R() {
        this.f3593I = false;
        this.f3594J = false;
        this.f3600P.q(false);
        T(7);
    }

    void S() {
        this.f3593I = false;
        this.f3594J = false;
        this.f3600P.q(false);
        T(5);
    }

    void U() {
        this.f3594J = true;
        this.f3600P.q(true);
        T(4);
    }

    void U0(Fragment fragment, String[] strArr, int i2) {
        if (this.f3590F == null) {
            this.f3620v.o(fragment, strArr, i2);
            return;
        }
        this.f3591G.addLast(new k(fragment.mWho, i2));
        this.f3590F.a(strArr);
    }

    void V() {
        T(2);
    }

    void V0(Fragment fragment, Intent intent, int i2, Bundle bundle) {
        if (this.f3588D == null) {
            this.f3620v.q(fragment, intent, i2, bundle);
            return;
        }
        this.f3591G.addLast(new k(fragment.mWho, i2));
        if (intent != null && bundle != null) {
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        this.f3588D.a(intent);
    }

    void W0(Fragment fragment, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) {
        Intent intent2;
        if (this.f3589E == null) {
            this.f3620v.t(fragment, intentSender, i2, intent, i3, i4, i5, bundle);
            return;
        }
        if (bundle != null) {
            if (intent == null) {
                intent2 = new Intent();
                intent2.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
            } else {
                intent2 = intent;
            }
            if (H0(2)) {
                Log.v("FragmentManager", "ActivityOptions " + bundle + " were added to fillInIntent " + intent2 + " for fragment " + fragment);
            }
            intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        } else {
            intent2 = intent;
        }
        b.g gVarA = new g.a(intentSender).b(intent2).c(i4, i3).a();
        this.f3591G.addLast(new k(fragment.mWho, i2));
        if (H0(2)) {
            Log.v("FragmentManager", "Fragment " + fragment + "is launching an IntentSender for result ");
        }
        this.f3589E.a(gVarA);
    }

    public void X(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.f3605c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList arrayList = this.e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size2; i2++) {
                Fragment fragment = (Fragment) this.e.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
        ArrayList arrayList2 = this.f3606d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size; i3++) {
                C0183a c0183a = (C0183a) this.f3606d.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(c0183a.toString());
                c0183a.r(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f3610i.get());
        synchronized (this.f3603a) {
            try {
                int size3 = this.f3603a.size();
                if (size3 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i4 = 0; i4 < size3; i4++) {
                        l lVar = (l) this.f3603a.get(i4);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i4);
                        printWriter.print(": ");
                        printWriter.println(lVar);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f3620v);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f3621w);
        if (this.f3622x != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f3622x);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f3619u);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f3593I);
        printWriter.print(" mStopped=");
        printWriter.print(this.f3594J);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f3595K);
        if (this.f3592H) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f3592H);
        }
    }

    void X0(int i2, boolean z2) {
        o oVar;
        if (this.f3620v == null && i2 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z2 || i2 != this.f3619u) {
            this.f3619u = i2;
            this.f3605c.t();
            r1();
            if (this.f3592H && (oVar = this.f3620v) != null && this.f3619u == 7) {
                oVar.u();
                this.f3592H = false;
            }
        }
    }

    void Y0() {
        if (this.f3620v == null) {
            return;
        }
        this.f3593I = false;
        this.f3594J = false;
        this.f3600P.q(false);
        for (Fragment fragment : this.f3605c.o()) {
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    void Z(l lVar, boolean z2) {
        if (!z2) {
            if (this.f3620v == null) {
                if (!this.f3595K) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            r();
        }
        synchronized (this.f3603a) {
            try {
                if (this.f3620v == null) {
                    if (!z2) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.f3603a.add(lVar);
                    l1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void Z0(C0194l c0194l) {
        View view;
        for (C c2 : this.f3605c.k()) {
            Fragment fragmentK = c2.k();
            if (fragmentK.mContainerId == c0194l.getId() && (view = fragmentK.mView) != null && view.getParent() == null) {
                fragmentK.mContainer = c0194l;
                c2.b();
            }
        }
    }

    void a1(C c2) {
        Fragment fragmentK = c2.k();
        if (fragmentK.mDeferStart) {
            if (this.f3604b) {
                this.f3596L = true;
            } else {
                fragmentK.mDeferStart = false;
                c2.m();
            }
        }
    }

    boolean b0(boolean z2) {
        a0(z2);
        boolean z3 = false;
        while (n0(this.f3597M, this.f3598N)) {
            z3 = true;
            this.f3604b = true;
            try {
                f1(this.f3597M, this.f3598N);
            } finally {
                s();
            }
        }
        t1();
        W();
        this.f3605c.b();
        return z3;
    }

    public boolean b1() {
        return c1(null, -1, 0);
    }

    void c0(l lVar, boolean z2) {
        if (z2 && (this.f3620v == null || this.f3595K)) {
            return;
        }
        a0(z2);
        if (lVar.a(this.f3597M, this.f3598N)) {
            this.f3604b = true;
            try {
                f1(this.f3597M, this.f3598N);
            } finally {
                s();
            }
        }
        t1();
        W();
        this.f3605c.b();
    }

    boolean d1(ArrayList arrayList, ArrayList arrayList2, String str, int i2, int i3) {
        int iG0 = g0(str, i2, (i3 & 1) != 0);
        if (iG0 < 0) {
            return false;
        }
        for (int size = this.f3606d.size() - 1; size >= iG0; size--) {
            arrayList.add((C0183a) this.f3606d.remove(size));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    void e1(Fragment fragment) {
        if (H0(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean zIsInBackStack = fragment.isInBackStack();
        if (fragment.mDetached && zIsInBackStack) {
            return;
        }
        this.f3605c.u(fragment);
        if (I0(fragment)) {
            this.f3592H = true;
        }
        fragment.mRemoving = true;
        p1(fragment);
    }

    Fragment f0(String str) {
        return this.f3605c.f(str);
    }

    void g1(Fragment fragment) {
        this.f3600P.p(fragment);
    }

    public Fragment h0(int i2) {
        return this.f3605c.g(i2);
    }

    void i(C0183a c0183a) {
        if (this.f3606d == null) {
            this.f3606d = new ArrayList();
        }
        this.f3606d.add(c0183a);
    }

    public Fragment i0(String str) {
        return this.f3605c.h(str);
    }

    void i1(Parcelable parcelable) {
        C c2;
        Bundle bundle;
        Bundle bundle2;
        if (parcelable == null) {
            return;
        }
        Bundle bundle3 = (Bundle) parcelable;
        for (String str : bundle3.keySet()) {
            if (str.startsWith("result_") && (bundle2 = bundle3.getBundle(str)) != null) {
                bundle2.setClassLoader(this.f3620v.h().getClassLoader());
                this.f3612k.put(str.substring(7), bundle2);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : bundle3.keySet()) {
            if (str2.startsWith("fragment_") && (bundle = bundle3.getBundle(str2)) != null) {
                bundle.setClassLoader(this.f3620v.h().getClassLoader());
                arrayList.add((B) bundle.getParcelable("state"));
            }
        }
        this.f3605c.x(arrayList);
        y yVar = (y) bundle3.getParcelable("state");
        if (yVar == null) {
            return;
        }
        this.f3605c.v();
        Iterator it = yVar.f3637a.iterator();
        while (it.hasNext()) {
            B B2 = this.f3605c.B((String) it.next(), null);
            if (B2 != null) {
                Fragment fragmentJ = this.f3600P.j(B2.f3352b);
                if (fragmentJ != null) {
                    if (H0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + fragmentJ);
                    }
                    c2 = new C(this.f3615n, this.f3605c, fragmentJ, B2);
                } else {
                    c2 = new C(this.f3615n, this.f3605c, this.f3620v.h().getClassLoader(), s0(), B2);
                }
                Fragment fragmentK = c2.k();
                fragmentK.mFragmentManager = this;
                if (H0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + fragmentK.mWho + "): " + fragmentK);
                }
                c2.o(this.f3620v.h().getClassLoader());
                this.f3605c.r(c2);
                c2.t(this.f3619u);
            }
        }
        for (Fragment fragment : this.f3600P.m()) {
            if (!this.f3605c.c(fragment.mWho)) {
                if (H0(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + yVar.f3637a);
                }
                this.f3600P.p(fragment);
                fragment.mFragmentManager = this;
                C c3 = new C(this.f3615n, this.f3605c, fragment);
                c3.t(1);
                c3.m();
                fragment.mRemoving = true;
                c3.m();
            }
        }
        this.f3605c.w(yVar.f3638b);
        if (yVar.f3639c != null) {
            this.f3606d = new ArrayList(yVar.f3639c.length);
            int i2 = 0;
            while (true) {
                C0184b[] c0184bArr = yVar.f3639c;
                if (i2 >= c0184bArr.length) {
                    break;
                }
                C0183a c0183aB = c0184bArr[i2].b(this);
                if (H0(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i2 + " (index " + c0183aB.f3490v + "): " + c0183aB);
                    PrintWriter printWriter = new PrintWriter(new J("FragmentManager"));
                    c0183aB.s("  ", printWriter, false);
                    printWriter.close();
                }
                this.f3606d.add(c0183aB);
                i2++;
            }
        } else {
            this.f3606d = null;
        }
        this.f3610i.set(yVar.f3640d);
        String str3 = yVar.e;
        if (str3 != null) {
            Fragment fragmentF0 = f0(str3);
            this.f3623y = fragmentF0;
            M(fragmentF0);
        }
        ArrayList arrayList2 = yVar.f3641f;
        if (arrayList2 != null) {
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                this.f3611j.put((String) arrayList2.get(i3), (C0185c) yVar.f3642g.get(i3));
            }
        }
        this.f3591G = new ArrayDeque(yVar.f3643h);
    }

    C j(Fragment fragment) {
        String str = fragment.mPreviousWho;
        if (str != null) {
            F.c.f(fragment, str);
        }
        if (H0(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        C cW = w(fragment);
        fragment.mFragmentManager = this;
        this.f3605c.r(cW);
        if (!fragment.mDetached) {
            this.f3605c.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (I0(fragment)) {
                this.f3592H = true;
            }
        }
        return cW;
    }

    Fragment j0(String str) {
        return this.f3605c.i(str);
    }

    public void k(A a2) {
        this.o.add(a2);
    }

    /* renamed from: k1 */
    public Bundle P0() {
        C0184b[] c0184bArr;
        int size;
        Bundle bundle = new Bundle();
        m0();
        Y();
        b0(true);
        this.f3593I = true;
        this.f3600P.q(true);
        ArrayList arrayListY = this.f3605c.y();
        ArrayList arrayListM = this.f3605c.m();
        if (!arrayListM.isEmpty()) {
            ArrayList arrayListZ = this.f3605c.z();
            ArrayList arrayList = this.f3606d;
            if (arrayList == null || (size = arrayList.size()) <= 0) {
                c0184bArr = null;
            } else {
                c0184bArr = new C0184b[size];
                for (int i2 = 0; i2 < size; i2++) {
                    c0184bArr[i2] = new C0184b((C0183a) this.f3606d.get(i2));
                    if (H0(2)) {
                        Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f3606d.get(i2));
                    }
                }
            }
            y yVar = new y();
            yVar.f3637a = arrayListY;
            yVar.f3638b = arrayListZ;
            yVar.f3639c = c0184bArr;
            yVar.f3640d = this.f3610i.get();
            Fragment fragment = this.f3623y;
            if (fragment != null) {
                yVar.e = fragment.mWho;
            }
            yVar.f3641f.addAll(this.f3611j.keySet());
            yVar.f3642g.addAll(this.f3611j.values());
            yVar.f3643h = new ArrayList(this.f3591G);
            bundle.putParcelable("state", yVar);
            for (String str : this.f3612k.keySet()) {
                bundle.putBundle("result_" + str, (Bundle) this.f3612k.get(str));
            }
            Iterator it = arrayListM.iterator();
            while (it.hasNext()) {
                B b2 = (B) it.next();
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("state", b2);
                bundle.putBundle("fragment_" + b2.f3352b, bundle2);
            }
        } else if (H0(2)) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
        }
        return bundle;
    }

    void l(Fragment fragment) {
        this.f3600P.f(fragment);
    }

    void l1() {
        synchronized (this.f3603a) {
            try {
                if (this.f3603a.size() == 1) {
                    this.f3620v.i().removeCallbacks(this.f3602R);
                    this.f3620v.i().post(this.f3602R);
                    t1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    int m() {
        return this.f3610i.getAndIncrement();
    }

    void m1(Fragment fragment, boolean z2) {
        ViewGroup viewGroupR0 = r0(fragment);
        if (viewGroupR0 == null || !(viewGroupR0 instanceof C0194l)) {
            return;
        }
        ((C0194l) viewGroupR0).setDrawDisappearingViewsLast(!z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    void n(o oVar, AbstractC0193k abstractC0193k, Fragment fragment) {
        String str;
        if (this.f3620v != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f3620v = oVar;
        this.f3621w = abstractC0193k;
        this.f3622x = fragment;
        if (fragment != null) {
            k(new g(fragment));
        } else if (oVar instanceof A) {
            k((A) oVar);
        }
        if (this.f3622x != null) {
            t1();
        }
        if (oVar instanceof androidx.activity.w) {
            androidx.activity.w wVar = (androidx.activity.w) oVar;
            OnBackPressedDispatcher onBackPressedDispatcherF = wVar.f();
            this.f3608g = onBackPressedDispatcherF;
            androidx.lifecycle.m mVar = wVar;
            if (fragment != null) {
                mVar = fragment;
            }
            onBackPressedDispatcherF.h(mVar, this.f3609h);
        }
        if (fragment != null) {
            this.f3600P = fragment.mFragmentManager.p0(fragment);
        } else if (oVar instanceof androidx.lifecycle.J) {
            this.f3600P = z.l(((androidx.lifecycle.J) oVar).getViewModelStore());
        } else {
            this.f3600P = new z(false);
        }
        this.f3600P.q(O0());
        this.f3605c.A(this.f3600P);
        Object obj = this.f3620v;
        if ((obj instanceof L.d) && fragment == null) {
            androidx.savedstate.a savedStateRegistry = ((L.d) obj).getSavedStateRegistry();
            savedStateRegistry.h("android:support:fragments", new a.c() { // from class: androidx.fragment.app.v
                @Override // androidx.savedstate.a.c
                public final Bundle a() {
                    return this.f3583a.P0();
                }
            });
            Bundle bundleB = savedStateRegistry.b("android:support:fragments");
            if (bundleB != null) {
                i1(bundleB);
            }
        }
        Object obj2 = this.f3620v;
        if (obj2 instanceof b.f) {
            b.e eVarS = ((b.f) obj2).s();
            if (fragment != null) {
                str = fragment.mWho + ":";
            } else {
                str = "";
            }
            String str2 = "FragmentManager:" + str;
            this.f3588D = eVarS.m(str2 + "StartActivityForResult", new C0226c(), new h());
            this.f3589E = eVarS.m(str2 + "StartIntentSenderForResult", new j(), new i());
            this.f3590F = eVarS.m(str2 + "RequestPermissions", new C0225b(), new a());
        }
        Object obj3 = this.f3620v;
        if (obj3 instanceof androidx.core.content.b) {
            ((androidx.core.content.b) obj3).m(this.f3616p);
        }
        Object obj4 = this.f3620v;
        if (obj4 instanceof androidx.core.content.c) {
            ((androidx.core.content.c) obj4).I(this.f3617q);
        }
        Object obj5 = this.f3620v;
        if (obj5 instanceof androidx.core.app.o) {
            ((androidx.core.app.o) obj5).L(this.r);
        }
        Object obj6 = this.f3620v;
        if (obj6 instanceof androidx.core.app.p) {
            ((androidx.core.app.p) obj6).M(this.s);
        }
        Object obj7 = this.f3620v;
        if ((obj7 instanceof InterfaceC0179w) && fragment == null) {
            ((InterfaceC0179w) obj7).r(this.f3618t);
        }
    }

    void n1(Fragment fragment, AbstractC0203h.b bVar) {
        if (fragment.equals(f0(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this)) {
            fragment.mMaxState = bVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    void o(Fragment fragment) {
        if (H0(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            this.f3605c.a(fragment);
            if (H0(2)) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            if (I0(fragment)) {
                this.f3592H = true;
            }
        }
    }

    public int o0() {
        ArrayList arrayList = this.f3606d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    void o1(Fragment fragment) {
        if (fragment == null || (fragment.equals(f0(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this))) {
            Fragment fragment2 = this.f3623y;
            this.f3623y = fragment;
            M(fragment2);
            M(this.f3623y);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public E p() {
        return new C0183a(this);
    }

    boolean q() {
        boolean zI0 = false;
        for (Fragment fragment : this.f3605c.l()) {
            if (fragment != null) {
                zI0 = I0(fragment);
            }
            if (zI0) {
                return true;
            }
        }
        return false;
    }

    AbstractC0193k q0() {
        return this.f3621w;
    }

    void q1(Fragment fragment) {
        if (H0(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    public n s0() {
        n nVar = this.f3624z;
        if (nVar != null) {
            return nVar;
        }
        Fragment fragment = this.f3622x;
        return fragment != null ? fragment.mFragmentManager.s0() : this.f3585A;
    }

    public List t0() {
        return this.f3605c.o();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.f3622x;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.f3622x)));
            sb.append("}");
        } else {
            o oVar = this.f3620v;
            if (oVar != null) {
                sb.append(oVar.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.f3620v)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public o u0() {
        return this.f3620v;
    }

    LayoutInflater.Factory2 v0() {
        return this.f3607f;
    }

    C w(Fragment fragment) {
        C cN = this.f3605c.n(fragment.mWho);
        if (cN != null) {
            return cN;
        }
        C c2 = new C(this.f3615n, this.f3605c, fragment);
        c2.o(this.f3620v.h().getClassLoader());
        c2.t(this.f3619u);
        return c2;
    }

    q w0() {
        return this.f3615n;
    }

    void x(Fragment fragment) {
        if (H0(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            if (H0(2)) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            this.f3605c.u(fragment);
            if (I0(fragment)) {
                this.f3592H = true;
            }
            p1(fragment);
        }
    }

    Fragment x0() {
        return this.f3622x;
    }

    void y() {
        this.f3593I = false;
        this.f3594J = false;
        this.f3600P.q(false);
        T(4);
    }

    public Fragment y0() {
        return this.f3623y;
    }

    void z() {
        this.f3593I = false;
        this.f3594J = false;
        this.f3600P.q(false);
        T(0);
    }

    L z0() {
        L l2 = this.f3586B;
        if (l2 != null) {
            return l2;
        }
        Fragment fragment = this.f3622x;
        return fragment != null ? fragment.mFragmentManager.z0() : this.f3587C;
    }

    static class k implements Parcelable {
        public static final Parcelable.Creator<k> CREATOR = new a();

        /* renamed from: a */
        String f3635a;

        /* renamed from: b */
        int f3636b;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public k createFromParcel(Parcel parcel) {
                return new k(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public k[] newArray(int i2) {
                return new k[i2];
            }
        }

        k(String str, int i2) {
            this.f3635a = str;
            this.f3636b = i2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.f3635a);
            parcel.writeInt(this.f3636b);
        }

        k(Parcel parcel) {
            this.f3635a = parcel.readString();
            this.f3636b = parcel.readInt();
        }
    }
}
