package O0;

/* loaded from: classes.dex */
final class o extends q {

    /* renamed from: b, reason: collision with root package name */
    private final String f526b;

    /* renamed from: c, reason: collision with root package name */
    private final int f527c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f528d;

    o(int i2, String str) {
        super(i2);
        this.f526b = str;
        this.f528d = false;
        this.f527c = 0;
    }

    String b() {
        return this.f526b;
    }

    int c() {
        return this.f527c;
    }

    boolean d() {
        return this.f528d;
    }

    o(int i2, String str, int i3) {
        super(i2);
        this.f528d = true;
        this.f527c = i3;
        this.f526b = str;
    }
}
