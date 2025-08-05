package V0;

import z0.o;

/* loaded from: classes.dex */
public final class d extends o {

    /* renamed from: c, reason: collision with root package name */
    private final float f994c;

    /* renamed from: d, reason: collision with root package name */
    private final int f995d;

    d(float f2, float f3, float f4) {
        this(f2, f3, f4, 1);
    }

    boolean f(float f2, float f3, float f4) {
        if (Math.abs(f3 - d()) > f2 || Math.abs(f4 - c()) > f2) {
            return false;
        }
        float fAbs = Math.abs(f2 - this.f994c);
        return fAbs <= 1.0f || fAbs <= this.f994c;
    }

    d g(float f2, float f3, float f4) {
        int i2 = this.f995d;
        int i3 = i2 + 1;
        float fC = (i2 * c()) + f3;
        float f5 = i3;
        return new d(fC / f5, ((this.f995d * d()) + f2) / f5, ((this.f995d * this.f994c) + f4) / f5, i3);
    }

    int h() {
        return this.f995d;
    }

    public float i() {
        return this.f994c;
    }

    private d(float f2, float f3, float f4, int i2) {
        super(f2, f3);
        this.f994c = f4;
        this.f995d = i2;
    }
}
