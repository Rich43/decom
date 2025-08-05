package D0;

import java.util.List;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f114a;

    /* renamed from: b, reason: collision with root package name */
    private int f115b;

    /* renamed from: c, reason: collision with root package name */
    private final String f116c;

    /* renamed from: d, reason: collision with root package name */
    private final List f117d;
    private final String e;

    /* renamed from: f, reason: collision with root package name */
    private Integer f118f;

    /* renamed from: g, reason: collision with root package name */
    private Integer f119g;

    /* renamed from: h, reason: collision with root package name */
    private Object f120h;

    /* renamed from: i, reason: collision with root package name */
    private final int f121i;

    /* renamed from: j, reason: collision with root package name */
    private final int f122j;

    public e(byte[] bArr, String str, List list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public List a() {
        return this.f117d;
    }

    public String b() {
        return this.e;
    }

    public int c() {
        return this.f115b;
    }

    public Object d() {
        return this.f120h;
    }

    public byte[] e() {
        return this.f114a;
    }

    public int f() {
        return this.f121i;
    }

    public int g() {
        return this.f122j;
    }

    public String h() {
        return this.f116c;
    }

    public boolean i() {
        return this.f121i >= 0 && this.f122j >= 0;
    }

    public void j(Integer num) {
        this.f119g = num;
    }

    public void k(Integer num) {
        this.f118f = num;
    }

    public void l(int i2) {
        this.f115b = i2;
    }

    public void m(Object obj) {
        this.f120h = obj;
    }

    public e(byte[] bArr, String str, List list, String str2, int i2, int i3) {
        this.f114a = bArr;
        this.f115b = bArr == null ? 0 : bArr.length * 8;
        this.f116c = str;
        this.f117d = list;
        this.e = str2;
        this.f121i = i3;
        this.f122j = i2;
    }
}
