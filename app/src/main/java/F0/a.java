package F0;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: h */
    public static final a f182h = new a(4201, 4096, 1);

    /* renamed from: i */
    public static final a f183i = new a(1033, 1024, 1);

    /* renamed from: j */
    public static final a f184j;

    /* renamed from: k */
    public static final a f185k;

    /* renamed from: l */
    public static final a f186l;

    /* renamed from: m */
    public static final a f187m;

    /* renamed from: n */
    public static final a f188n;
    public static final a o;

    /* renamed from: a */
    private final int[] f189a;

    /* renamed from: b */
    private final int[] f190b;

    /* renamed from: c */
    private final b f191c;

    /* renamed from: d */
    private final b f192d;
    private final int e;

    /* renamed from: f */
    private final int f193f;

    /* renamed from: g */
    private final int f194g;

    static {
        a aVar = new a(67, 64, 1);
        f184j = aVar;
        f185k = new a(19, 16, 1);
        f186l = new a(285, 256, 0);
        a aVar2 = new a(301, 256, 1);
        f187m = aVar2;
        f188n = aVar2;
        o = aVar;
    }

    public a(int i2, int i3, int i4) {
        this.f193f = i2;
        this.e = i3;
        this.f194g = i4;
        this.f189a = new int[i3];
        this.f190b = new int[i3];
        int i5 = 1;
        for (int i6 = 0; i6 < i3; i6++) {
            this.f189a[i6] = i5;
            i5 <<= 1;
            if (i5 >= i3) {
                i5 = (i5 ^ i2) & (i3 - 1);
            }
        }
        for (int i7 = 0; i7 < i3 - 1; i7++) {
            this.f190b[this.f189a[i7]] = i7;
        }
        this.f191c = new b(this, new int[]{0});
        this.f192d = new b(this, new int[]{1});
    }

    static int a(int i2, int i3) {
        return i2 ^ i3;
    }

    b b(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        if (i3 == 0) {
            return this.f191c;
        }
        int[] iArr = new int[i2 + 1];
        iArr[0] = i3;
        return new b(this, iArr);
    }

    int c(int i2) {
        return this.f189a[i2];
    }

    public int d() {
        return this.f194g;
    }

    b e() {
        return this.f192d;
    }

    public int f() {
        return this.e;
    }

    b g() {
        return this.f191c;
    }

    int h(int i2) {
        if (i2 != 0) {
            return this.f189a[(this.e - this.f190b[i2]) - 1];
        }
        throw new ArithmeticException();
    }

    int i(int i2) {
        if (i2 != 0) {
            return this.f190b[i2];
        }
        throw new IllegalArgumentException();
    }

    int j(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        int[] iArr = this.f189a;
        int[] iArr2 = this.f190b;
        return iArr[(iArr2[i2] + iArr2[i3]) % (this.e - 1)];
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f193f) + ',' + this.e + ')';
    }
}
