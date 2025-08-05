package Q;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final int f582a;

    /* renamed from: b, reason: collision with root package name */
    private final int f583b;

    /* renamed from: c, reason: collision with root package name */
    private final String f584c;

    /* renamed from: d, reason: collision with root package name */
    private final String f585d;
    private final String e;

    /* renamed from: f, reason: collision with root package name */
    private Bitmap f586f;

    public f(int i2, int i3, String str, String str2, String str3) {
        this.f582a = i2;
        this.f583b = i3;
        this.f584c = str;
        this.f585d = str2;
        this.e = str3;
    }

    public Bitmap a() {
        return this.f586f;
    }

    public String b() {
        return this.f585d;
    }

    public int c() {
        return this.f583b;
    }

    public String d() {
        return this.f584c;
    }

    public int e() {
        return this.f582a;
    }

    public void f(Bitmap bitmap) {
        this.f586f = bitmap;
    }
}
