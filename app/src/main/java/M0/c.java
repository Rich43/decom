package M0;

import z0.o;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final int f332a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f333b;

    /* renamed from: c, reason: collision with root package name */
    private final o[] f334c;

    public c(int i2, int[] iArr, int i3, int i4, int i5) {
        this.f332a = i2;
        this.f333b = iArr;
        float f2 = i3;
        float f3 = i5;
        this.f334c = new o[]{new o(f2, f3), new o(i4, f3)};
    }

    public o[] a() {
        return this.f334c;
    }

    public int[] b() {
        return this.f333b;
    }

    public int c() {
        return this.f332a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && this.f332a == ((c) obj).f332a;
    }

    public int hashCode() {
        return this.f332a;
    }
}
