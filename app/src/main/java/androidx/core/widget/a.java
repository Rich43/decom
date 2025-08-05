package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.view.M;

/* loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {
    private static final int r = ViewConfiguration.getTapTimeout();

    /* renamed from: c, reason: collision with root package name */
    final View f3222c;

    /* renamed from: d, reason: collision with root package name */
    private Runnable f3223d;

    /* renamed from: g, reason: collision with root package name */
    private int f3225g;

    /* renamed from: h, reason: collision with root package name */
    private int f3226h;

    /* renamed from: l, reason: collision with root package name */
    private boolean f3230l;

    /* renamed from: m, reason: collision with root package name */
    boolean f3231m;

    /* renamed from: n, reason: collision with root package name */
    boolean f3232n;
    boolean o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f3233p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f3234q;

    /* renamed from: a, reason: collision with root package name */
    final C0036a f3220a = new C0036a();

    /* renamed from: b, reason: collision with root package name */
    private final Interpolator f3221b = new AccelerateInterpolator();
    private float[] e = {0.0f, 0.0f};

    /* renamed from: f, reason: collision with root package name */
    private float[] f3224f = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: i, reason: collision with root package name */
    private float[] f3227i = {0.0f, 0.0f};

    /* renamed from: j, reason: collision with root package name */
    private float[] f3228j = {0.0f, 0.0f};

    /* renamed from: k, reason: collision with root package name */
    private float[] f3229k = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: androidx.core.widget.a$a, reason: collision with other inner class name */
    private static class C0036a {

        /* renamed from: a, reason: collision with root package name */
        private int f3235a;

        /* renamed from: b, reason: collision with root package name */
        private int f3236b;

        /* renamed from: c, reason: collision with root package name */
        private float f3237c;

        /* renamed from: d, reason: collision with root package name */
        private float f3238d;

        /* renamed from: j, reason: collision with root package name */
        private float f3243j;

        /* renamed from: k, reason: collision with root package name */
        private int f3244k;
        private long e = Long.MIN_VALUE;

        /* renamed from: i, reason: collision with root package name */
        private long f3242i = -1;

        /* renamed from: f, reason: collision with root package name */
        private long f3239f = 0;

        /* renamed from: g, reason: collision with root package name */
        private int f3240g = 0;

        /* renamed from: h, reason: collision with root package name */
        private int f3241h = 0;

        C0036a() {
        }

        private float e(long j2) {
            if (j2 < this.e) {
                return 0.0f;
            }
            long j3 = this.f3242i;
            if (j3 < 0 || j2 < j3) {
                return a.e((j2 - r0) / this.f3235a, 0.0f, 1.0f) * 0.5f;
            }
            float f2 = this.f3243j;
            return (1.0f - f2) + (f2 * a.e((j2 - j3) / this.f3244k, 0.0f, 1.0f));
        }

        private float g(float f2) {
            return ((-4.0f) * f2 * f2) + (f2 * 4.0f);
        }

        public void a() {
            if (this.f3239f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float fG = g(e(jCurrentAnimationTimeMillis));
            long j2 = jCurrentAnimationTimeMillis - this.f3239f;
            this.f3239f = jCurrentAnimationTimeMillis;
            float f2 = j2 * fG;
            this.f3240g = (int) (this.f3237c * f2);
            this.f3241h = (int) (f2 * this.f3238d);
        }

        public int b() {
            return this.f3240g;
        }

        public int c() {
            return this.f3241h;
        }

        public int d() {
            float f2 = this.f3237c;
            return (int) (f2 / Math.abs(f2));
        }

        public int f() {
            float f2 = this.f3238d;
            return (int) (f2 / Math.abs(f2));
        }

        public boolean h() {
            return this.f3242i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f3242i + ((long) this.f3244k);
        }

        public void i() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f3244k = a.f((int) (jCurrentAnimationTimeMillis - this.e), 0, this.f3236b);
            this.f3243j = e(jCurrentAnimationTimeMillis);
            this.f3242i = jCurrentAnimationTimeMillis;
        }

        public void j(int i2) {
            this.f3236b = i2;
        }

        public void k(int i2) {
            this.f3235a = i2;
        }

        public void l(float f2, float f3) {
            this.f3237c = f2;
            this.f3238d = f3;
        }

        public void m() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.e = jCurrentAnimationTimeMillis;
            this.f3242i = -1L;
            this.f3239f = jCurrentAnimationTimeMillis;
            this.f3243j = 0.5f;
            this.f3240g = 0;
            this.f3241h = 0;
        }
    }

    private class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            if (aVar.o) {
                if (aVar.f3231m) {
                    aVar.f3231m = false;
                    aVar.f3220a.m();
                }
                C0036a c0036a = a.this.f3220a;
                if (c0036a.h() || !a.this.u()) {
                    a.this.o = false;
                    return;
                }
                a aVar2 = a.this;
                if (aVar2.f3232n) {
                    aVar2.f3232n = false;
                    aVar2.c();
                }
                c0036a.a();
                a.this.j(c0036a.b(), c0036a.c());
                M.a0(a.this.f3222c, this);
            }
        }
    }

    public a(View view) {
        this.f3222c = view;
        float f2 = Resources.getSystem().getDisplayMetrics().density;
        float f3 = (int) ((1575.0f * f2) + 0.5f);
        o(f3, f3);
        float f4 = (int) ((f2 * 315.0f) + 0.5f);
        p(f4, f4);
        l(1);
        n(Float.MAX_VALUE, Float.MAX_VALUE);
        s(0.2f, 0.2f);
        t(1.0f, 1.0f);
        k(r);
        r(500);
        q(500);
    }

    private float d(int i2, float f2, float f3, float f4) {
        float fH = h(this.e[i2], f3, this.f3224f[i2], f2);
        if (fH == 0.0f) {
            return 0.0f;
        }
        float f5 = this.f3227i[i2];
        float f6 = this.f3228j[i2];
        float f7 = this.f3229k[i2];
        float f8 = f5 * f4;
        return fH > 0.0f ? e(fH * f8, f6, f7) : -e((-fH) * f8, f6, f7);
    }

    static float e(float f2, float f3, float f4) {
        return f2 > f4 ? f4 : f2 < f3 ? f3 : f2;
    }

    static int f(int i2, int i3, int i4) {
        return i2 > i4 ? i4 : i2 < i3 ? i3 : i2;
    }

    private float g(float f2, float f3) {
        if (f3 == 0.0f) {
            return 0.0f;
        }
        int i2 = this.f3225g;
        if (i2 == 0 || i2 == 1) {
            if (f2 < f3) {
                if (f2 >= 0.0f) {
                    return 1.0f - (f2 / f3);
                }
                if (this.o && i2 == 1) {
                    return 1.0f;
                }
            }
        } else if (i2 == 2 && f2 < 0.0f) {
            return f2 / (-f3);
        }
        return 0.0f;
    }

    private float h(float f2, float f3, float f4, float f5) {
        float interpolation;
        float fE = e(f2 * f3, 0.0f, f4);
        float fG = g(f3 - f5, fE) - g(f5, fE);
        if (fG < 0.0f) {
            interpolation = -this.f3221b.getInterpolation(-fG);
        } else {
            if (fG <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.f3221b.getInterpolation(fG);
        }
        return e(interpolation, -1.0f, 1.0f);
    }

    private void i() {
        if (this.f3231m) {
            this.o = false;
        } else {
            this.f3220a.i();
        }
    }

    private void v() {
        int i2;
        if (this.f3223d == null) {
            this.f3223d = new b();
        }
        this.o = true;
        this.f3231m = true;
        if (this.f3230l || (i2 = this.f3226h) <= 0) {
            this.f3223d.run();
        } else {
            M.b0(this.f3222c, this.f3223d, i2);
        }
        this.f3230l = true;
    }

    public abstract boolean a(int i2);

    public abstract boolean b(int i2);

    void c() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f3222c.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    public abstract void j(int i2, int i3);

    public a k(int i2) {
        this.f3226h = i2;
        return this;
    }

    public a l(int i2) {
        this.f3225g = i2;
        return this;
    }

    public a m(boolean z2) {
        if (this.f3233p && !z2) {
            i();
        }
        this.f3233p = z2;
        return this;
    }

    public a n(float f2, float f3) {
        float[] fArr = this.f3224f;
        fArr[0] = f2;
        fArr[1] = f3;
        return this;
    }

    public a o(float f2, float f3) {
        float[] fArr = this.f3229k;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0016  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.f3233p
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1a
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L1e
            r6 = 3
            if (r0 == r6) goto L16
            goto L58
        L16:
            r5.i()
            goto L58
        L1a:
            r5.f3232n = r2
            r5.f3230l = r1
        L1e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f3222c
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.d(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f3222c
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.d(r2, r7, r6, r3)
            androidx.core.widget.a$a r7 = r5.f3220a
            r7.l(r0, r6)
            boolean r6 = r5.o
            if (r6 != 0) goto L58
            boolean r6 = r5.u()
            if (r6 == 0) goto L58
            r5.v()
        L58:
            boolean r6 = r5.f3234q
            if (r6 == 0) goto L61
            boolean r6 = r5.o
            if (r6 == 0) goto L61
            r1 = 1
        L61:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public a p(float f2, float f3) {
        float[] fArr = this.f3228j;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    public a q(int i2) {
        this.f3220a.j(i2);
        return this;
    }

    public a r(int i2) {
        this.f3220a.k(i2);
        return this;
    }

    public a s(float f2, float f3) {
        float[] fArr = this.e;
        fArr[0] = f2;
        fArr[1] = f3;
        return this;
    }

    public a t(float f2, float f3) {
        float[] fArr = this.f3227i;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    boolean u() {
        C0036a c0036a = this.f3220a;
        int iF = c0036a.f();
        int iD = c0036a.d();
        return (iF != 0 && b(iF)) || (iD != 0 && a(iD));
    }
}
