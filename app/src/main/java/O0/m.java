package O0;

/* loaded from: classes.dex */
final class m {

    /* renamed from: a, reason: collision with root package name */
    private int f519a = 0;

    /* renamed from: b, reason: collision with root package name */
    private a f520b = a.NUMERIC;

    private enum a {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    m() {
    }

    int a() {
        return this.f519a;
    }

    void b(int i2) {
        this.f519a += i2;
    }

    boolean c() {
        return this.f520b == a.ALPHA;
    }

    boolean d() {
        return this.f520b == a.ISO_IEC_646;
    }

    void e() {
        this.f520b = a.ALPHA;
    }

    void f() {
        this.f520b = a.ISO_IEC_646;
    }

    void g() {
        this.f520b = a.NUMERIC;
    }

    void h(int i2) {
        this.f519a = i2;
    }
}
