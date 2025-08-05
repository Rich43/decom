package androidx.lifecycle;

import androidx.lifecycle.AbstractC0203h;
import java.util.Map;
import k.C0274b;

/* loaded from: classes.dex */
public abstract class LiveData {

    /* renamed from: k, reason: collision with root package name */
    static final Object f3686k = new Object();

    /* renamed from: a, reason: collision with root package name */
    final Object f3687a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private C0274b f3688b = new C0274b();

    /* renamed from: c, reason: collision with root package name */
    int f3689c = 0;

    /* renamed from: d, reason: collision with root package name */
    private boolean f3690d;
    private volatile Object e;

    /* renamed from: f, reason: collision with root package name */
    volatile Object f3691f;

    /* renamed from: g, reason: collision with root package name */
    private int f3692g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f3693h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f3694i;

    /* renamed from: j, reason: collision with root package name */
    private final Runnable f3695j;

    class LifecycleBoundObserver extends androidx.lifecycle.LiveData.b implements InterfaceC0206k {

        /* renamed from: d, reason: collision with root package name */
        final m f3696d;
        final /* synthetic */ LiveData e;

        @Override // androidx.lifecycle.InterfaceC0206k
        public void d(m mVar, AbstractC0203h.a aVar) {
            AbstractC0203h.b bVarB = this.f3696d.getLifecycle().b();
            AbstractC0203h.b bVar = null;
            if (bVarB == AbstractC0203h.b.DESTROYED) {
                this.e.g(null);
                return;
            }
            while (bVar != bVarB) {
                h(j());
                bVar = bVarB;
                bVarB = this.f3696d.getLifecycle().b();
            }
        }

        void i() {
            this.f3696d.getLifecycle().c(this);
        }

        boolean j() {
            return this.f3696d.getLifecycle().b().b(AbstractC0203h.b.STARTED);
        }
    }

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (LiveData.this.f3687a) {
                obj = LiveData.this.f3691f;
                LiveData.this.f3691f = LiveData.f3686k;
            }
            LiveData.this.h(obj);
        }
    }

    private abstract class b {

        /* renamed from: a, reason: collision with root package name */
        boolean f3698a;

        /* renamed from: b, reason: collision with root package name */
        int f3699b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ LiveData f3700c;

        void h(boolean z2) {
            if (z2 == this.f3698a) {
                return;
            }
            this.f3698a = z2;
            this.f3700c.b(z2 ? 1 : -1);
            if (this.f3698a) {
                this.f3700c.d(this);
            }
        }

        abstract void i();

        abstract boolean j();
    }

    public LiveData() {
        Object obj = f3686k;
        this.f3691f = obj;
        this.f3695j = new a();
        this.e = obj;
        this.f3692g = -1;
    }

    static void a(String str) {
        if (j.c.f().b()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    private void c(b bVar) {
        if (bVar.f3698a) {
            if (!bVar.j()) {
                bVar.h(false);
                return;
            }
            int i2 = bVar.f3699b;
            int i3 = this.f3692g;
            if (i2 >= i3) {
                return;
            }
            bVar.f3699b = i3;
            throw null;
        }
    }

    void b(int i2) {
        int i3 = this.f3689c;
        this.f3689c = i2 + i3;
        if (this.f3690d) {
            return;
        }
        this.f3690d = true;
        while (true) {
            try {
                int i4 = this.f3689c;
                if (i3 == i4) {
                    this.f3690d = false;
                    return;
                }
                boolean z2 = i3 == 0 && i4 > 0;
                boolean z3 = i3 > 0 && i4 == 0;
                if (z2) {
                    e();
                } else if (z3) {
                    f();
                }
                i3 = i4;
            } catch (Throwable th) {
                this.f3690d = false;
                throw th;
            }
        }
    }

    void d(b bVar) {
        if (this.f3693h) {
            this.f3694i = true;
            return;
        }
        this.f3693h = true;
        do {
            this.f3694i = false;
            if (bVar != null) {
                c(bVar);
                bVar = null;
            } else {
                C0274b.d dVarD = this.f3688b.d();
                while (dVarD.hasNext()) {
                    c((b) ((Map.Entry) dVarD.next()).getValue());
                    if (this.f3694i) {
                        break;
                    }
                }
            }
        } while (this.f3694i);
        this.f3693h = false;
    }

    protected void e() {
    }

    protected void f() {
    }

    public void g(r rVar) {
        a("removeObserver");
        b bVar = (b) this.f3688b.h(rVar);
        if (bVar == null) {
            return;
        }
        bVar.i();
        bVar.h(false);
    }

    protected void h(Object obj) {
        a("setValue");
        this.f3692g++;
        this.e = obj;
        d(null);
    }
}
