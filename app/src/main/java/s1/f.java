package s1;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* loaded from: classes.dex */
public class f extends Handler implements l {

    /* renamed from: a */
    private final k f7465a;

    /* renamed from: b */
    private final int f7466b;

    /* renamed from: c */
    private final c f7467c;

    /* renamed from: d */
    private boolean f7468d;

    protected f(c cVar, Looper looper, int i2) {
        super(looper);
        this.f7467c = cVar;
        this.f7466b = i2;
        this.f7465a = new k();
    }

    @Override // s1.l
    public void a(q qVar, Object obj) {
        j jVarA = j.a(qVar, obj);
        synchronized (this) {
            try {
                this.f7465a.a(jVarA);
                if (!this.f7468d) {
                    this.f7468d = true;
                    if (!sendMessage(obtainMessage())) {
                        throw new e("Could not send handler message");
                    }
                }
            } finally {
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            long jUptimeMillis = SystemClock.uptimeMillis();
            do {
                j jVarB = this.f7465a.b();
                if (jVarB == null) {
                    synchronized (this) {
                        jVarB = this.f7465a.b();
                        if (jVarB == null) {
                            this.f7468d = false;
                            return;
                        }
                    }
                }
                this.f7467c.g(jVarB);
            } while (SystemClock.uptimeMillis() - jUptimeMillis < this.f7466b);
            if (!sendMessage(obtainMessage())) {
                throw new e("Could not send handler message");
            }
            this.f7468d = true;
        } catch (Throwable th) {
            this.f7468d = false;
            throw th;
        }
    }
}
