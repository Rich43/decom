package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.V;
import androidx.core.view.W;
import androidx.core.view.X;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class h {

    /* renamed from: c, reason: collision with root package name */
    private Interpolator f1877c;

    /* renamed from: d, reason: collision with root package name */
    W f1878d;
    private boolean e;

    /* renamed from: b, reason: collision with root package name */
    private long f1876b = -1;

    /* renamed from: f, reason: collision with root package name */
    private final X f1879f = new a();

    /* renamed from: a, reason: collision with root package name */
    final ArrayList f1875a = new ArrayList();

    class a extends X {

        /* renamed from: a, reason: collision with root package name */
        private boolean f1880a = false;

        /* renamed from: b, reason: collision with root package name */
        private int f1881b = 0;

        a() {
        }

        @Override // androidx.core.view.W
        public void a(View view) {
            int i2 = this.f1881b + 1;
            this.f1881b = i2;
            if (i2 == h.this.f1875a.size()) {
                W w2 = h.this.f1878d;
                if (w2 != null) {
                    w2.a(null);
                }
                d();
            }
        }

        @Override // androidx.core.view.X, androidx.core.view.W
        public void b(View view) {
            if (this.f1880a) {
                return;
            }
            this.f1880a = true;
            W w2 = h.this.f1878d;
            if (w2 != null) {
                w2.b(null);
            }
        }

        void d() {
            this.f1881b = 0;
            this.f1880a = false;
            h.this.b();
        }
    }

    public void a() {
        if (this.e) {
            Iterator it = this.f1875a.iterator();
            while (it.hasNext()) {
                ((V) it.next()).c();
            }
            this.e = false;
        }
    }

    void b() {
        this.e = false;
    }

    public h c(V v2) {
        if (!this.e) {
            this.f1875a.add(v2);
        }
        return this;
    }

    public h d(V v2, V v3) {
        this.f1875a.add(v2);
        v3.j(v2.d());
        this.f1875a.add(v3);
        return this;
    }

    public h e(long j2) {
        if (!this.e) {
            this.f1876b = j2;
        }
        return this;
    }

    public h f(Interpolator interpolator) {
        if (!this.e) {
            this.f1877c = interpolator;
        }
        return this;
    }

    public h g(W w2) {
        if (!this.e) {
            this.f1878d = w2;
        }
        return this;
    }

    public void h() {
        if (this.e) {
            return;
        }
        Iterator it = this.f1875a.iterator();
        while (it.hasNext()) {
            V v2 = (V) it.next();
            long j2 = this.f1876b;
            if (j2 >= 0) {
                v2.f(j2);
            }
            Interpolator interpolator = this.f1877c;
            if (interpolator != null) {
                v2.g(interpolator);
            }
            if (this.f1878d != null) {
                v2.h(this.f1879f);
            }
            v2.l();
        }
        this.e = true;
    }
}
