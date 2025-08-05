package u;

import android.graphics.Typeface;
import android.os.Handler;
import u.g;
import u.h;

/* renamed from: u.a */
/* loaded from: classes.dex */
class C0329a {

    /* renamed from: a */
    private final h.c f7515a;

    /* renamed from: b */
    private final Handler f7516b;

    /* renamed from: u.a$a */
    class RunnableC0103a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ h.c f7517a;

        /* renamed from: b */
        final /* synthetic */ Typeface f7518b;

        RunnableC0103a(h.c cVar, Typeface typeface) {
            this.f7517a = cVar;
            this.f7518b = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f7517a.b(this.f7518b);
        }
    }

    /* renamed from: u.a$b */
    class b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ h.c f7520a;

        /* renamed from: b */
        final /* synthetic */ int f7521b;

        b(h.c cVar, int i2) {
            this.f7520a = cVar;
            this.f7521b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f7520a.a(this.f7521b);
        }
    }

    C0329a(h.c cVar, Handler handler) {
        this.f7515a = cVar;
        this.f7516b = handler;
    }

    private void a(int i2) {
        this.f7516b.post(new b(this.f7515a, i2));
    }

    private void c(Typeface typeface) {
        this.f7516b.post(new RunnableC0103a(this.f7515a, typeface));
    }

    void b(g.e eVar) {
        if (eVar.a()) {
            c(eVar.f7545a);
        } else {
            a(eVar.f7546b);
        }
    }
}
