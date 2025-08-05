package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.appcompat.app.F;

/* loaded from: classes.dex */
class e {

    /* renamed from: c, reason: collision with root package name */
    private static e f5742c;

    /* renamed from: a, reason: collision with root package name */
    private final Object f5743a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final Handler f5744b = new Handler(Looper.getMainLooper(), new a());

    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            e eVar = e.this;
            F.a(message.obj);
            eVar.c(null);
            return true;
        }
    }

    interface b {
    }

    private static class c {
    }

    private e() {
    }

    private boolean a(c cVar, int i2) {
        throw null;
    }

    static e b() {
        if (f5742c == null) {
            f5742c = new e();
        }
        return f5742c;
    }

    private boolean d(b bVar) {
        return false;
    }

    void c(c cVar) {
        synchronized (this.f5743a) {
            a(cVar, 2);
        }
    }

    public void e(b bVar) {
        synchronized (this.f5743a) {
            try {
                if (d(bVar)) {
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void f(b bVar) {
        synchronized (this.f5743a) {
            try {
                if (d(bVar)) {
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
