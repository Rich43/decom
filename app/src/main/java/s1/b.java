package s1;

import java.util.logging.Level;

/* loaded from: classes.dex */
final class b implements Runnable, l {

    /* renamed from: a, reason: collision with root package name */
    private final k f7426a = new k();

    /* renamed from: b, reason: collision with root package name */
    private final c f7427b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f7428c;

    b(c cVar) {
        this.f7427b = cVar;
    }

    @Override // s1.l
    public void a(q qVar, Object obj) {
        j jVarA = j.a(qVar, obj);
        synchronized (this) {
            try {
                this.f7426a.a(jVarA);
                if (!this.f7428c) {
                    this.f7428c = true;
                    this.f7427b.d().execute(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                try {
                    j jVarC = this.f7426a.c(1000);
                    if (jVarC == null) {
                        synchronized (this) {
                            jVarC = this.f7426a.b();
                            if (jVarC == null) {
                                this.f7428c = false;
                                this.f7428c = false;
                                return;
                            }
                        }
                    }
                    this.f7427b.g(jVarC);
                } catch (InterruptedException e) {
                    this.f7427b.e().b(Level.WARNING, Thread.currentThread().getName() + " was interruppted", e);
                    this.f7428c = false;
                    return;
                }
            } catch (Throwable th) {
                this.f7428c = false;
                throw th;
            }
        }
    }
}
