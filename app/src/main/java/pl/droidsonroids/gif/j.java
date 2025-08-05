package pl.droidsonroids.gif;

import java.lang.Thread;

/* loaded from: classes.dex */
abstract class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final a f7185a;

    j(a aVar) {
        this.f7185a = aVar;
    }

    abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f7185a.e()) {
                return;
            }
            a();
        } catch (Throwable th) {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (defaultUncaughtExceptionHandler != null) {
                defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
            }
            throw th;
        }
    }
}
