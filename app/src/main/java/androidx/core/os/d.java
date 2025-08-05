package androidx.core.os;

import android.os.CancellationSignal;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private boolean f3055a;

    /* renamed from: b, reason: collision with root package name */
    private a f3056b;

    /* renamed from: c, reason: collision with root package name */
    private Object f3057c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f3058d;

    public interface a {
        void a();
    }

    private void c() throws InterruptedException {
        while (this.f3058d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public void a() {
        synchronized (this) {
            try {
                if (this.f3055a) {
                    return;
                }
                this.f3055a = true;
                this.f3058d = true;
                a aVar = this.f3056b;
                Object obj = this.f3057c;
                if (aVar != null) {
                    try {
                        aVar.a();
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.f3058d = false;
                            notifyAll();
                            throw th;
                        }
                    }
                }
                if (obj != null) {
                    ((CancellationSignal) obj).cancel();
                }
                synchronized (this) {
                    this.f3058d = false;
                    notifyAll();
                }
            } finally {
            }
        }
    }

    public void b(a aVar) {
        synchronized (this) {
            try {
                c();
                if (this.f3056b == aVar) {
                    return;
                }
                this.f3056b = aVar;
                if (this.f3055a && aVar != null) {
                    aVar.a();
                }
            } finally {
            }
        }
    }
}
