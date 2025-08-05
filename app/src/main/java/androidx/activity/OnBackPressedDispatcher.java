package androidx.activity;

import android.os.Build;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.OnBackPressedDispatcher;
import androidx.lifecycle.AbstractC0203h;
import androidx.lifecycle.InterfaceC0206k;
import b1.C0217e;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import v.InterfaceC0338a;

/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* renamed from: a */
    private final Runnable f1478a;

    /* renamed from: b */
    private final InterfaceC0338a f1479b;

    /* renamed from: c */
    private final C0217e f1480c;

    /* renamed from: d */
    private u f1481d;
    private OnBackInvokedCallback e;

    /* renamed from: f */
    private OnBackInvokedDispatcher f1482f;

    /* renamed from: g */
    private boolean f1483g;

    /* renamed from: h */
    private boolean f1484h;

    private final class LifecycleOnBackPressedCancellable implements InterfaceC0206k, androidx.activity.c {

        /* renamed from: a */
        private final AbstractC0203h f1485a;

        /* renamed from: b */
        private final u f1486b;

        /* renamed from: c */
        private androidx.activity.c f1487c;

        /* renamed from: d */
        final /* synthetic */ OnBackPressedDispatcher f1488d;

        public LifecycleOnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, AbstractC0203h abstractC0203h, u uVar) {
            i1.k.e(abstractC0203h, "lifecycle");
            i1.k.e(uVar, "onBackPressedCallback");
            this.f1488d = onBackPressedDispatcher;
            this.f1485a = abstractC0203h;
            this.f1486b = uVar;
            abstractC0203h.a(this);
        }

        @Override // androidx.activity.c
        public void cancel() {
            this.f1485a.c(this);
            this.f1486b.i(this);
            androidx.activity.c cVar = this.f1487c;
            if (cVar != null) {
                cVar.cancel();
            }
            this.f1487c = null;
        }

        @Override // androidx.lifecycle.InterfaceC0206k
        public void d(androidx.lifecycle.m mVar, AbstractC0203h.a aVar) {
            i1.k.e(mVar, "source");
            i1.k.e(aVar, "event");
            if (aVar == AbstractC0203h.a.ON_START) {
                this.f1487c = this.f1488d.i(this.f1486b);
                return;
            }
            if (aVar != AbstractC0203h.a.ON_STOP) {
                if (aVar == AbstractC0203h.a.ON_DESTROY) {
                    cancel();
                }
            } else {
                androidx.activity.c cVar = this.f1487c;
                if (cVar != null) {
                    cVar.cancel();
                }
            }
        }
    }

    static final class a extends i1.l implements h1.l {
        a() {
            super(1);
        }

        @Override // h1.l
        public /* bridge */ /* synthetic */ Object b(Object obj) {
            c((androidx.activity.b) obj);
            return a1.i.f1440a;
        }

        public final void c(androidx.activity.b bVar) {
            i1.k.e(bVar, "backEvent");
            OnBackPressedDispatcher.this.m(bVar);
        }
    }

    static final class b extends i1.l implements h1.l {
        b() {
            super(1);
        }

        @Override // h1.l
        public /* bridge */ /* synthetic */ Object b(Object obj) {
            c((androidx.activity.b) obj);
            return a1.i.f1440a;
        }

        public final void c(androidx.activity.b bVar) {
            i1.k.e(bVar, "backEvent");
            OnBackPressedDispatcher.this.l(bVar);
        }
    }

    static final class c extends i1.l implements h1.a {
        c() {
            super(0);
        }

        @Override // h1.a
        public /* bridge */ /* synthetic */ Object a() {
            c();
            return a1.i.f1440a;
        }

        public final void c() {
            OnBackPressedDispatcher.this.k();
        }
    }

    static final class d extends i1.l implements h1.a {
        d() {
            super(0);
        }

        @Override // h1.a
        public /* bridge */ /* synthetic */ Object a() {
            c();
            return a1.i.f1440a;
        }

        public final void c() {
            OnBackPressedDispatcher.this.j();
        }
    }

    static final class e extends i1.l implements h1.a {
        e() {
            super(0);
        }

        @Override // h1.a
        public /* bridge */ /* synthetic */ Object a() {
            c();
            return a1.i.f1440a;
        }

        public final void c() {
            OnBackPressedDispatcher.this.k();
        }
    }

    public static final class f {

        /* renamed from: a */
        public static final f f1494a = new f();

        private f() {
        }

        public static final void c(h1.a aVar) {
            i1.k.e(aVar, "$onBackInvoked");
            aVar.a();
        }

        public final OnBackInvokedCallback b(final h1.a aVar) {
            i1.k.e(aVar, "onBackInvoked");
            return new OnBackInvokedCallback() { // from class: androidx.activity.v
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    OnBackPressedDispatcher.f.c(aVar);
                }
            };
        }

        public final void d(Object obj, int i2, Object obj2) {
            i1.k.e(obj, "dispatcher");
            i1.k.e(obj2, "callback");
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(i2, (OnBackInvokedCallback) obj2);
        }

        public final void e(Object obj, Object obj2) {
            i1.k.e(obj, "dispatcher");
            i1.k.e(obj2, "callback");
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    public static final class g {

        /* renamed from: a */
        public static final g f1495a = new g();

        public static final class a implements OnBackAnimationCallback {

            /* renamed from: a */
            final /* synthetic */ h1.l f1496a;

            /* renamed from: b */
            final /* synthetic */ h1.l f1497b;

            /* renamed from: c */
            final /* synthetic */ h1.a f1498c;

            /* renamed from: d */
            final /* synthetic */ h1.a f1499d;

            a(h1.l lVar, h1.l lVar2, h1.a aVar, h1.a aVar2) {
                this.f1496a = lVar;
                this.f1497b = lVar2;
                this.f1498c = aVar;
                this.f1499d = aVar2;
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackCancelled() {
                this.f1499d.a();
            }

            @Override // android.window.OnBackInvokedCallback
            public void onBackInvoked() {
                this.f1498c.a();
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackProgressed(BackEvent backEvent) {
                i1.k.e(backEvent, "backEvent");
                this.f1497b.b(new androidx.activity.b(backEvent));
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackStarted(BackEvent backEvent) {
                i1.k.e(backEvent, "backEvent");
                this.f1496a.b(new androidx.activity.b(backEvent));
            }
        }

        private g() {
        }

        public final OnBackInvokedCallback a(h1.l lVar, h1.l lVar2, h1.a aVar, h1.a aVar2) {
            i1.k.e(lVar, "onBackStarted");
            i1.k.e(lVar2, "onBackProgressed");
            i1.k.e(aVar, "onBackInvoked");
            i1.k.e(aVar2, "onBackCancelled");
            return new a(lVar, lVar2, aVar, aVar2);
        }
    }

    private final class h implements androidx.activity.c {

        /* renamed from: a */
        private final u f1500a;

        /* renamed from: b */
        final /* synthetic */ OnBackPressedDispatcher f1501b;

        public h(OnBackPressedDispatcher onBackPressedDispatcher, u uVar) {
            i1.k.e(uVar, "onBackPressedCallback");
            this.f1501b = onBackPressedDispatcher;
            this.f1500a = uVar;
        }

        @Override // androidx.activity.c
        public void cancel() {
            this.f1501b.f1480c.remove(this.f1500a);
            if (i1.k.a(this.f1501b.f1481d, this.f1500a)) {
                this.f1500a.c();
                this.f1501b.f1481d = null;
            }
            this.f1500a.i(this);
            h1.a aVarB = this.f1500a.b();
            if (aVarB != null) {
                aVarB.a();
            }
            this.f1500a.k(null);
        }
    }

    /* synthetic */ class i extends i1.j implements h1.a {
        i(Object obj) {
            super(0, obj, OnBackPressedDispatcher.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
        }

        @Override // h1.a
        public /* bridge */ /* synthetic */ Object a() {
            h();
            return a1.i.f1440a;
        }

        public final void h() {
            ((OnBackPressedDispatcher) this.f6460b).p();
        }
    }

    /* synthetic */ class j extends i1.j implements h1.a {
        j(Object obj) {
            super(0, obj, OnBackPressedDispatcher.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
        }

        @Override // h1.a
        public /* bridge */ /* synthetic */ Object a() {
            h();
            return a1.i.f1440a;
        }

        public final void h() {
            ((OnBackPressedDispatcher) this.f6460b).p();
        }
    }

    public OnBackPressedDispatcher(Runnable runnable, InterfaceC0338a interfaceC0338a) {
        this.f1478a = runnable;
        this.f1479b = interfaceC0338a;
        this.f1480c = new C0217e();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33) {
            this.e = i2 >= 34 ? g.f1495a.a(new a(), new b(), new c(), new d()) : f.f1494a.b(new e());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    public final void j() {
        u uVarPrevious;
        u uVar = this.f1481d;
        if (uVar == null) {
            C0217e c0217e = this.f1480c;
            ListIterator listIterator = c0217e.listIterator(c0217e.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    uVarPrevious = 0;
                    break;
                } else {
                    uVarPrevious = listIterator.previous();
                    if (((u) uVarPrevious).g()) {
                        break;
                    }
                }
            }
            uVar = uVarPrevious;
        }
        this.f1481d = null;
        if (uVar != null) {
            uVar.c();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object] */
    public final void l(androidx.activity.b bVar) {
        u uVarPrevious;
        u uVar = this.f1481d;
        if (uVar == null) {
            C0217e c0217e = this.f1480c;
            ListIterator listIterator = c0217e.listIterator(c0217e.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    uVarPrevious = 0;
                    break;
                } else {
                    uVarPrevious = listIterator.previous();
                    if (((u) uVarPrevious).g()) {
                        break;
                    }
                }
            }
            uVar = uVarPrevious;
        }
        if (uVar != null) {
            uVar.e(bVar);
        }
    }

    public final void m(androidx.activity.b bVar) {
        Object objPrevious;
        C0217e c0217e = this.f1480c;
        ListIterator<E> listIterator = c0217e.listIterator(c0217e.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            } else {
                objPrevious = listIterator.previous();
                if (((u) objPrevious).g()) {
                    break;
                }
            }
        }
        u uVar = (u) objPrevious;
        if (this.f1481d != null) {
            j();
        }
        this.f1481d = uVar;
        if (uVar != null) {
            uVar.f(bVar);
        }
    }

    private final void o(boolean z2) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f1482f;
        OnBackInvokedCallback onBackInvokedCallback = this.e;
        if (onBackInvokedDispatcher == null || onBackInvokedCallback == null) {
            return;
        }
        if (z2 && !this.f1483g) {
            f.f1494a.d(onBackInvokedDispatcher, 0, onBackInvokedCallback);
            this.f1483g = true;
        } else {
            if (z2 || !this.f1483g) {
                return;
            }
            f.f1494a.e(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f1483g = false;
        }
    }

    public final void p() {
        boolean z2 = this.f1484h;
        C0217e c0217e = this.f1480c;
        boolean z3 = false;
        if (!(c0217e instanceof Collection) || !c0217e.isEmpty()) {
            Iterator<E> it = c0217e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((u) it.next()).g()) {
                    z3 = true;
                    break;
                }
            }
        }
        this.f1484h = z3;
        if (z3 != z2) {
            InterfaceC0338a interfaceC0338a = this.f1479b;
            if (interfaceC0338a != null) {
                interfaceC0338a.a(Boolean.valueOf(z3));
            }
            if (Build.VERSION.SDK_INT >= 33) {
                o(z3);
            }
        }
    }

    public final void h(androidx.lifecycle.m mVar, u uVar) {
        i1.k.e(mVar, "owner");
        i1.k.e(uVar, "onBackPressedCallback");
        AbstractC0203h lifecycle = mVar.getLifecycle();
        if (lifecycle.b() == AbstractC0203h.b.DESTROYED) {
            return;
        }
        uVar.a(new LifecycleOnBackPressedCancellable(this, lifecycle, uVar));
        p();
        uVar.k(new i(this));
    }

    public final androidx.activity.c i(u uVar) {
        i1.k.e(uVar, "onBackPressedCallback");
        this.f1480c.add(uVar);
        h hVar = new h(this, uVar);
        uVar.a(hVar);
        p();
        uVar.k(new j(this));
        return hVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    public final void k() {
        u uVarPrevious;
        u uVar = this.f1481d;
        if (uVar == null) {
            C0217e c0217e = this.f1480c;
            ListIterator listIterator = c0217e.listIterator(c0217e.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    uVarPrevious = 0;
                    break;
                } else {
                    uVarPrevious = listIterator.previous();
                    if (((u) uVarPrevious).g()) {
                        break;
                    }
                }
            }
            uVar = uVarPrevious;
        }
        this.f1481d = null;
        if (uVar != null) {
            uVar.d();
            return;
        }
        Runnable runnable = this.f1478a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void n(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        i1.k.e(onBackInvokedDispatcher, "invoker");
        this.f1482f = onBackInvokedDispatcher;
        o(this.f1484h);
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this(runnable, null);
    }
}
