package j;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class c extends e {

    /* renamed from: c */
    private static volatile c f6479c;

    /* renamed from: d */
    private static final Executor f6480d = new Executor() { // from class: j.a
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            c.g(runnable);
        }
    };
    private static final Executor e = new Executor() { // from class: j.b
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            c.h(runnable);
        }
    };

    /* renamed from: a */
    private e f6481a;

    /* renamed from: b */
    private final e f6482b;

    private c() {
        d dVar = new d();
        this.f6482b = dVar;
        this.f6481a = dVar;
    }

    public static c f() {
        if (f6479c != null) {
            return f6479c;
        }
        synchronized (c.class) {
            try {
                if (f6479c == null) {
                    f6479c = new c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f6479c;
    }

    public static /* synthetic */ void g(Runnable runnable) {
        f().c(runnable);
    }

    public static /* synthetic */ void h(Runnable runnable) {
        f().a(runnable);
    }

    @Override // j.e
    public void a(Runnable runnable) {
        this.f6481a.a(runnable);
    }

    @Override // j.e
    public boolean b() {
        return this.f6481a.b();
    }

    @Override // j.e
    public void c(Runnable runnable) {
        this.f6481a.c(runnable);
    }
}
