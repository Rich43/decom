package r1;

import java.io.InterruptedIOException;

/* loaded from: classes.dex */
public class l {

    /* renamed from: c, reason: collision with root package name */
    public static final l f7389c = new a();

    /* renamed from: a, reason: collision with root package name */
    private boolean f7390a;

    /* renamed from: b, reason: collision with root package name */
    private long f7391b;

    public void a() throws InterruptedIOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        if (this.f7390a && this.f7391b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    final class a extends l {
        a() {
        }

        @Override // r1.l
        public void a() {
        }
    }
}
