package h0;

/* renamed from: h0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0261b {

    /* renamed from: a, reason: collision with root package name */
    private String f6374a;

    /* renamed from: b, reason: collision with root package name */
    private String f6375b;

    /* renamed from: c, reason: collision with root package name */
    private String f6376c;

    /* renamed from: d, reason: collision with root package name */
    private int f6377d;
    private byte[] e;

    public byte[] a() {
        return this.e;
    }

    public String b() {
        return this.f6374a;
    }

    public String c() {
        return this.f6375b;
    }

    public void d(byte[] bArr) {
        this.e = bArr;
    }

    public void e(String str) {
        this.f6374a = str;
    }

    public void f(String str) {
        this.f6375b = str;
    }

    public void g(int i2) {
        this.f6377d = i2;
    }

    public void h(String str) {
        this.f6376c = str;
    }

    public String toString() {
        return "AppItem{appName='" + this.f6374a + "', packageName='" + this.f6375b + "', versionName='" + this.f6376c + "', versionCode=" + this.f6377d + '}';
    }
}
