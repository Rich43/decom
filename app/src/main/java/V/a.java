package V;

import android.graphics.PointF;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final PointF f947a;

    /* renamed from: b, reason: collision with root package name */
    private final PointF f948b;

    /* renamed from: c, reason: collision with root package name */
    private final PointF f949c;

    public a() {
        this.f947a = new PointF();
        this.f948b = new PointF();
        this.f949c = new PointF();
    }

    public PointF a() {
        return this.f947a;
    }

    public PointF b() {
        return this.f948b;
    }

    public PointF c() {
        return this.f949c;
    }

    public void d(float f2, float f3) {
        this.f947a.set(f2, f3);
    }

    public void e(float f2, float f3) {
        this.f948b.set(f2, f3);
    }

    public void f(float f2, float f3) {
        this.f949c.set(f2, f3);
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f947a = pointF;
        this.f948b = pointF2;
        this.f949c = pointF3;
    }
}
