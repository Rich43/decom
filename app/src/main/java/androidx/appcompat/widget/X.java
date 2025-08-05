package androidx.appcompat.widget;

import com.bumptech.glide.request.target.Target;

/* loaded from: classes.dex */
class X {

    /* renamed from: a, reason: collision with root package name */
    private int f2349a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f2350b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f2351c = Target.SIZE_ORIGINAL;

    /* renamed from: d, reason: collision with root package name */
    private int f2352d = Target.SIZE_ORIGINAL;
    private int e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f2353f = 0;

    /* renamed from: g, reason: collision with root package name */
    private boolean f2354g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f2355h = false;

    X() {
    }

    public int a() {
        return this.f2354g ? this.f2349a : this.f2350b;
    }

    public int b() {
        return this.f2349a;
    }

    public int c() {
        return this.f2350b;
    }

    public int d() {
        return this.f2354g ? this.f2350b : this.f2349a;
    }

    public void e(int i2, int i3) {
        this.f2355h = false;
        if (i2 != Integer.MIN_VALUE) {
            this.e = i2;
            this.f2349a = i2;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f2353f = i3;
            this.f2350b = i3;
        }
    }

    public void f(boolean z2) {
        if (z2 == this.f2354g) {
            return;
        }
        this.f2354g = z2;
        if (!this.f2355h) {
            this.f2349a = this.e;
            this.f2350b = this.f2353f;
            return;
        }
        if (z2) {
            int i2 = this.f2352d;
            if (i2 == Integer.MIN_VALUE) {
                i2 = this.e;
            }
            this.f2349a = i2;
            int i3 = this.f2351c;
            if (i3 == Integer.MIN_VALUE) {
                i3 = this.f2353f;
            }
            this.f2350b = i3;
            return;
        }
        int i4 = this.f2351c;
        if (i4 == Integer.MIN_VALUE) {
            i4 = this.e;
        }
        this.f2349a = i4;
        int i5 = this.f2352d;
        if (i5 == Integer.MIN_VALUE) {
            i5 = this.f2353f;
        }
        this.f2350b = i5;
    }

    public void g(int i2, int i3) {
        this.f2351c = i2;
        this.f2352d = i3;
        this.f2355h = true;
        if (this.f2354g) {
            if (i3 != Integer.MIN_VALUE) {
                this.f2349a = i3;
            }
            if (i2 != Integer.MIN_VALUE) {
                this.f2350b = i2;
                return;
            }
            return;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f2349a = i2;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f2350b = i3;
        }
    }
}
