package Q0;

/* loaded from: classes.dex */
final class d {

    /* renamed from: a, reason: collision with root package name */
    private final int f697a;

    /* renamed from: b, reason: collision with root package name */
    private final int f698b;

    /* renamed from: c, reason: collision with root package name */
    private final int f699c;

    /* renamed from: d, reason: collision with root package name */
    private final int f700d;
    private int e = -1;

    d(int i2, int i3, int i4, int i5) {
        this.f697a = i2;
        this.f698b = i3;
        this.f699c = i4;
        this.f700d = i5;
    }

    int a() {
        return this.f699c;
    }

    int b() {
        return this.f698b;
    }

    int c() {
        return this.e;
    }

    int d() {
        return this.f697a;
    }

    int e() {
        return this.f700d;
    }

    int f() {
        return this.f698b - this.f697a;
    }

    boolean g() {
        return h(this.e);
    }

    boolean h(int i2) {
        return i2 != -1 && this.f699c == (i2 % 3) * 3;
    }

    void i(int i2) {
        this.e = i2;
    }

    void j() {
        this.e = ((this.f700d / 30) * 3) + (this.f699c / 3);
    }

    public String toString() {
        return this.e + "|" + this.f700d;
    }
}
