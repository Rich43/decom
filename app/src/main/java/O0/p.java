package O0;

import z0.C0384f;

/* loaded from: classes.dex */
final class p extends q {

    /* renamed from: b, reason: collision with root package name */
    private final int f529b;

    /* renamed from: c, reason: collision with root package name */
    private final int f530c;

    p(int i2, int i3, int i4) throws C0384f {
        super(i2);
        if (i3 < 0 || i3 > 10 || i4 < 0 || i4 > 10) {
            throw C0384f.a();
        }
        this.f529b = i3;
        this.f530c = i4;
    }

    int b() {
        return this.f529b;
    }

    int c() {
        return this.f530c;
    }

    boolean d() {
        return this.f529b == 10;
    }

    boolean e() {
        return this.f530c == 10;
    }
}
