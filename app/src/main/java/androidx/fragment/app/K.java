package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
abstract class K {

    /* renamed from: a, reason: collision with root package name */
    private final ViewGroup f3462a;

    /* renamed from: b, reason: collision with root package name */
    final ArrayList f3463b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    final ArrayList f3464c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    boolean f3465d = false;
    boolean e = false;

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f3466a;

        a(d dVar) {
            this.f3466a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (K.this.f3463b.contains(this.f3466a)) {
                this.f3466a.e().a(this.f3466a.f().mView);
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f3468a;

        b(d dVar) {
            this.f3468a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            K.this.f3463b.remove(this.f3468a);
            K.this.f3464c.remove(this.f3468a);
        }
    }

    static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3470a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f3471b;

        static {
            int[] iArr = new int[e.b.values().length];
            f3471b = iArr;
            try {
                iArr[e.b.ADDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3471b[e.b.REMOVING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3471b[e.b.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[e.c.values().length];
            f3470a = iArr2;
            try {
                iArr2[e.c.REMOVED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3470a[e.c.VISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3470a[e.c.GONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3470a[e.c.INVISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private static class d extends e {

        /* renamed from: h, reason: collision with root package name */
        private final C f3472h;

        d(e.c cVar, e.b bVar, C c2, androidx.core.os.d dVar) {
            super(cVar, bVar, c2.k(), dVar);
            this.f3472h = c2;
        }

        @Override // androidx.fragment.app.K.e
        public void c() {
            super.c();
            this.f3472h.m();
        }

        @Override // androidx.fragment.app.K.e
        void l() {
            if (g() != e.b.ADDING) {
                if (g() == e.b.REMOVING) {
                    Fragment fragmentK = this.f3472h.k();
                    View viewRequireView = fragmentK.requireView();
                    if (w.H0(2)) {
                        Log.v("FragmentManager", "Clearing focus " + viewRequireView.findFocus() + " on view " + viewRequireView + " for Fragment " + fragmentK);
                    }
                    viewRequireView.clearFocus();
                    return;
                }
                return;
            }
            Fragment fragmentK2 = this.f3472h.k();
            View viewFindFocus = fragmentK2.mView.findFocus();
            if (viewFindFocus != null) {
                fragmentK2.setFocusedView(viewFindFocus);
                if (w.H0(2)) {
                    Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + fragmentK2);
                }
            }
            View viewRequireView2 = f().requireView();
            if (viewRequireView2.getParent() == null) {
                this.f3472h.b();
                viewRequireView2.setAlpha(0.0f);
            }
            if (viewRequireView2.getAlpha() == 0.0f && viewRequireView2.getVisibility() == 0) {
                viewRequireView2.setVisibility(4);
            }
            viewRequireView2.setAlpha(fragmentK2.getPostOnViewCreatedAlpha());
        }
    }

    static class e {

        /* renamed from: a, reason: collision with root package name */
        private c f3473a;

        /* renamed from: b, reason: collision with root package name */
        private b f3474b;

        /* renamed from: c, reason: collision with root package name */
        private final Fragment f3475c;

        /* renamed from: d, reason: collision with root package name */
        private final List f3476d = new ArrayList();
        private final HashSet e = new HashSet();

        /* renamed from: f, reason: collision with root package name */
        private boolean f3477f = false;

        /* renamed from: g, reason: collision with root package name */
        private boolean f3478g = false;

        class a implements d.a {
            a() {
            }

            @Override // androidx.core.os.d.a
            public void a() {
                e.this.b();
            }
        }

        enum b {
            NONE,
            ADDING,
            REMOVING
        }

        enum c {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            static c b(int i2) {
                if (i2 == 0) {
                    return VISIBLE;
                }
                if (i2 == 4) {
                    return INVISIBLE;
                }
                if (i2 == 8) {
                    return GONE;
                }
                throw new IllegalArgumentException("Unknown visibility " + i2);
            }

            static c c(View view) {
                return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? INVISIBLE : b(view.getVisibility());
            }

            void a(View view) {
                int i2 = c.f3470a[ordinal()];
                if (i2 == 1) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        if (w.H0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                        }
                        viewGroup.removeView(view);
                        return;
                    }
                    return;
                }
                if (i2 == 2) {
                    if (w.H0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    view.setVisibility(0);
                    return;
                }
                if (i2 == 3) {
                    if (w.H0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    view.setVisibility(8);
                    return;
                }
                if (i2 != 4) {
                    return;
                }
                if (w.H0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                }
                view.setVisibility(4);
            }
        }

        e(c cVar, b bVar, Fragment fragment, androidx.core.os.d dVar) {
            this.f3473a = cVar;
            this.f3474b = bVar;
            this.f3475c = fragment;
            dVar.b(new a());
        }

        final void a(Runnable runnable) {
            this.f3476d.add(runnable);
        }

        final void b() {
            if (h()) {
                return;
            }
            this.f3477f = true;
            if (this.e.isEmpty()) {
                c();
                return;
            }
            Iterator it = new ArrayList(this.e).iterator();
            while (it.hasNext()) {
                ((androidx.core.os.d) it.next()).a();
            }
        }

        public void c() {
            if (this.f3478g) {
                return;
            }
            if (w.H0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f3478g = true;
            Iterator it = this.f3476d.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }

        public final void d(androidx.core.os.d dVar) {
            if (this.e.remove(dVar) && this.e.isEmpty()) {
                c();
            }
        }

        public c e() {
            return this.f3473a;
        }

        public final Fragment f() {
            return this.f3475c;
        }

        b g() {
            return this.f3474b;
        }

        final boolean h() {
            return this.f3477f;
        }

        final boolean i() {
            return this.f3478g;
        }

        public final void j(androidx.core.os.d dVar) {
            l();
            this.e.add(dVar);
        }

        final void k(c cVar, b bVar) {
            int i2 = c.f3471b[bVar.ordinal()];
            if (i2 == 1) {
                if (this.f3473a == c.REMOVED) {
                    if (w.H0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f3475c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f3474b + " to ADDING.");
                    }
                    this.f3473a = c.VISIBLE;
                    this.f3474b = b.ADDING;
                    return;
                }
                return;
            }
            if (i2 == 2) {
                if (w.H0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f3475c + " mFinalState = " + this.f3473a + " -> REMOVED. mLifecycleImpact  = " + this.f3474b + " to REMOVING.");
                }
                this.f3473a = c.REMOVED;
                this.f3474b = b.REMOVING;
                return;
            }
            if (i2 == 3 && this.f3473a != c.REMOVED) {
                if (w.H0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f3475c + " mFinalState = " + this.f3473a + " -> " + cVar + ". ");
                }
                this.f3473a = cVar;
            }
        }

        abstract void l();

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.f3473a + "} {mLifecycleImpact = " + this.f3474b + "} {mFragment = " + this.f3475c + "}";
        }
    }

    K(ViewGroup viewGroup) {
        this.f3462a = viewGroup;
    }

    private void a(e.c cVar, e.b bVar, C c2) {
        synchronized (this.f3463b) {
            try {
                androidx.core.os.d dVar = new androidx.core.os.d();
                e eVarH = h(c2.k());
                if (eVarH != null) {
                    eVarH.k(cVar, bVar);
                    return;
                }
                d dVar2 = new d(cVar, bVar, c2, dVar);
                this.f3463b.add(dVar2);
                dVar2.a(new a(dVar2));
                dVar2.a(new b(dVar2));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private e h(Fragment fragment) {
        Iterator it = this.f3463b.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            if (eVar.f().equals(fragment) && !eVar.h()) {
                return eVar;
            }
        }
        return null;
    }

    private e i(Fragment fragment) {
        Iterator it = this.f3464c.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            if (eVar.f().equals(fragment) && !eVar.h()) {
                return eVar;
            }
        }
        return null;
    }

    static K n(ViewGroup viewGroup, w wVar) {
        return o(viewGroup, wVar.z0());
    }

    static K o(ViewGroup viewGroup, L l2) {
        int i2 = E.b.f145b;
        Object tag = viewGroup.getTag(i2);
        if (tag instanceof K) {
            return (K) tag;
        }
        K kA = l2.a(viewGroup);
        viewGroup.setTag(i2, kA);
        return kA;
    }

    private void q() {
        Iterator it = this.f3463b.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            if (eVar.g() == e.b.ADDING) {
                eVar.k(e.c.b(eVar.f().requireView().getVisibility()), e.b.NONE);
            }
        }
    }

    void b(e.c cVar, C c2) {
        if (w.H0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + c2.k());
        }
        a(cVar, e.b.ADDING, c2);
    }

    void c(C c2) {
        if (w.H0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + c2.k());
        }
        a(e.c.GONE, e.b.NONE, c2);
    }

    void d(C c2) {
        if (w.H0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + c2.k());
        }
        a(e.c.REMOVED, e.b.REMOVING, c2);
    }

    void e(C c2) {
        if (w.H0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + c2.k());
        }
        a(e.c.VISIBLE, e.b.NONE, c2);
    }

    abstract void f(List list, boolean z2);

    void g() {
        if (this.e) {
            return;
        }
        if (!androidx.core.view.M.N(this.f3462a)) {
            j();
            this.f3465d = false;
            return;
        }
        synchronized (this.f3463b) {
            try {
                if (!this.f3463b.isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.f3464c);
                    this.f3464c.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        e eVar = (e) it.next();
                        if (w.H0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + eVar);
                        }
                        eVar.b();
                        if (!eVar.i()) {
                            this.f3464c.add(eVar);
                        }
                    }
                    q();
                    ArrayList arrayList2 = new ArrayList(this.f3463b);
                    this.f3463b.clear();
                    this.f3464c.addAll(arrayList2);
                    if (w.H0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");
                    }
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        ((e) it2.next()).l();
                    }
                    f(arrayList2, this.f3465d);
                    this.f3465d = false;
                    if (w.H0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void j() {
        String str;
        String str2;
        if (w.H0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean zN = androidx.core.view.M.N(this.f3462a);
        synchronized (this.f3463b) {
            try {
                q();
                Iterator it = this.f3463b.iterator();
                while (it.hasNext()) {
                    ((e) it.next()).l();
                }
                Iterator it2 = new ArrayList(this.f3464c).iterator();
                while (it2.hasNext()) {
                    e eVar = (e) it2.next();
                    if (w.H0(2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("SpecialEffectsController: ");
                        if (zN) {
                            str2 = "";
                        } else {
                            str2 = "Container " + this.f3462a + " is not attached to window. ";
                        }
                        sb.append(str2);
                        sb.append("Cancelling running operation ");
                        sb.append(eVar);
                        Log.v("FragmentManager", sb.toString());
                    }
                    eVar.b();
                }
                Iterator it3 = new ArrayList(this.f3463b).iterator();
                while (it3.hasNext()) {
                    e eVar2 = (e) it3.next();
                    if (w.H0(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SpecialEffectsController: ");
                        if (zN) {
                            str = "";
                        } else {
                            str = "Container " + this.f3462a + " is not attached to window. ";
                        }
                        sb2.append(str);
                        sb2.append("Cancelling pending operation ");
                        sb2.append(eVar2);
                        Log.v("FragmentManager", sb2.toString());
                    }
                    eVar2.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void k() {
        if (this.e) {
            if (w.H0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
            }
            this.e = false;
            g();
        }
    }

    e.b l(C c2) {
        e eVarH = h(c2.k());
        e.b bVarG = eVarH != null ? eVarH.g() : null;
        e eVarI = i(c2.k());
        return (eVarI == null || !(bVarG == null || bVarG == e.b.NONE)) ? bVarG : eVarI.g();
    }

    public ViewGroup m() {
        return this.f3462a;
    }

    void p() {
        synchronized (this.f3463b) {
            try {
                q();
                this.e = false;
                int size = this.f3463b.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    e eVar = (e) this.f3463b.get(size);
                    e.c cVarC = e.c.c(eVar.f().mView);
                    e.c cVarE = eVar.e();
                    e.c cVar = e.c.VISIBLE;
                    if (cVarE == cVar && cVarC != cVar) {
                        this.e = eVar.f().isPostponed();
                        break;
                    }
                    size--;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void r(boolean z2) {
        this.f3465d = z2;
    }
}
