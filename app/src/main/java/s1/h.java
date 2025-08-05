package s1;

import android.os.Looper;

/* loaded from: classes.dex */
public interface h {

    public static class a implements h {

        /* renamed from: a, reason: collision with root package name */
        private final Looper f7471a;

        public a(Looper looper) {
            this.f7471a = looper;
        }

        @Override // s1.h
        public boolean a() {
            return this.f7471a == Looper.myLooper();
        }

        @Override // s1.h
        public l b(c cVar) {
            return new f(cVar, this.f7471a, 10);
        }
    }

    boolean a();

    l b(c cVar);
}
