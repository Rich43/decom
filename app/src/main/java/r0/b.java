package R0;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: f */
    public static final b f721f = new b(929, 3);

    /* renamed from: a */
    private final int[] f722a;

    /* renamed from: b */
    private final int[] f723b;

    /* renamed from: c */
    private final c f724c;

    /* renamed from: d */
    private final c f725d;
    private final int e;

    private b(int i2, int i3) {
        this.e = i2;
        this.f722a = new int[i2];
        this.f723b = new int[i2];
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            this.f722a[i5] = i4;
            i4 = (i4 * i3) % i2;
        }
        for (int i6 = 0; i6 < i2 - 1; i6++) {
            this.f723b[this.f722a[i6]] = i6;
        }
        this.f724c = new c(this, new int[]{0});
        this.f725d = new c(this, new int[]{1});
    }

    int a(int i2, int i3) {
        return (i2 + i3) % this.e;
    }

    c b(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        if (i3 == 0) {
            return this.f724c;
        }
        int[] iArr = new int[i2 + 1];
        iArr[0] = i3;
        return new c(this, iArr);
    }

    int c(int i2) {
        return this.f722a[i2];
    }

    c d() {
        return this.f725d;
    }

    int e() {
        return this.e;
    }

    c f() {
        return this.f724c;
    }

    int g(int i2) {
        if (i2 != 0) {
            return this.f722a[(this.e - this.f723b[i2]) - 1];
        }
        throw new ArithmeticException();
    }

    int h(int i2) {
        if (i2 != 0) {
            return this.f723b[i2];
        }
        throw new IllegalArgumentException();
    }

    int i(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        int[] iArr = this.f722a;
        int[] iArr2 = this.f723b;
        return iArr[(iArr2[i2] + iArr2[i3]) % (this.e - 1)];
    }

    int j(int i2, int i3) {
        int i4 = this.e;
        return ((i2 + i4) - i3) % i4;
    }
}
