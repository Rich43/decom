package d0;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* renamed from: d0.a */
/* loaded from: classes.dex */
public class C0244a {

    /* renamed from: a */
    private final Q.d f5782a;

    /* renamed from: b */
    public final Object f5783b;

    /* renamed from: c */
    public Object f5784c;

    /* renamed from: d */
    public final Interpolator f5785d;
    public final float e;

    /* renamed from: f */
    public Float f5786f;

    /* renamed from: g */
    private float f5787g;

    /* renamed from: h */
    private float f5788h;

    /* renamed from: i */
    private int f5789i;

    /* renamed from: j */
    private int f5790j;

    /* renamed from: k */
    private float f5791k;

    /* renamed from: l */
    private float f5792l;

    /* renamed from: m */
    public PointF f5793m;

    /* renamed from: n */
    public PointF f5794n;

    public C0244a(Q.d dVar, Object obj, Object obj2, Interpolator interpolator, float f2, Float f3) {
        this.f5787g = -3987645.8f;
        this.f5788h = -3987645.8f;
        this.f5789i = 784923401;
        this.f5790j = 784923401;
        this.f5791k = Float.MIN_VALUE;
        this.f5792l = Float.MIN_VALUE;
        this.f5793m = null;
        this.f5794n = null;
        this.f5782a = dVar;
        this.f5783b = obj;
        this.f5784c = obj2;
        this.f5785d = interpolator;
        this.e = f2;
        this.f5786f = f3;
    }

    public boolean a(float f2) {
        return f2 >= e() && f2 < b();
    }

    public float b() {
        if (this.f5782a == null) {
            return 1.0f;
        }
        if (this.f5792l == Float.MIN_VALUE) {
            if (this.f5786f == null) {
                this.f5792l = 1.0f;
            } else {
                this.f5792l = e() + ((this.f5786f.floatValue() - this.e) / this.f5782a.e());
            }
        }
        return this.f5792l;
    }

    public float c() {
        if (this.f5788h == -3987645.8f) {
            this.f5788h = ((Float) this.f5784c).floatValue();
        }
        return this.f5788h;
    }

    public int d() {
        if (this.f5790j == 784923401) {
            this.f5790j = ((Integer) this.f5784c).intValue();
        }
        return this.f5790j;
    }

    public float e() {
        Q.d dVar = this.f5782a;
        if (dVar == null) {
            return 0.0f;
        }
        if (this.f5791k == Float.MIN_VALUE) {
            this.f5791k = (this.e - dVar.o()) / this.f5782a.e();
        }
        return this.f5791k;
    }

    public float f() {
        if (this.f5787g == -3987645.8f) {
            this.f5787g = ((Float) this.f5783b).floatValue();
        }
        return this.f5787g;
    }

    public int g() {
        if (this.f5789i == 784923401) {
            this.f5789i = ((Integer) this.f5783b).intValue();
        }
        return this.f5789i;
    }

    public boolean h() {
        return this.f5785d == null;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f5783b + ", endValue=" + this.f5784c + ", startFrame=" + this.e + ", endFrame=" + this.f5786f + ", interpolator=" + this.f5785d + '}';
    }

    public C0244a(Object obj) {
        this.f5787g = -3987645.8f;
        this.f5788h = -3987645.8f;
        this.f5789i = 784923401;
        this.f5790j = 784923401;
        this.f5791k = Float.MIN_VALUE;
        this.f5792l = Float.MIN_VALUE;
        this.f5793m = null;
        this.f5794n = null;
        this.f5782a = null;
        this.f5783b = obj;
        this.f5784c = obj;
        this.f5785d = null;
        this.e = Float.MIN_VALUE;
        this.f5786f = Float.valueOf(Float.MAX_VALUE);
    }
}
