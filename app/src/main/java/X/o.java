package X;

/* loaded from: classes.dex */
public class o implements b {

    /* renamed from: a */
    private final String f1199a;

    /* renamed from: b */
    private final int f1200b;

    /* renamed from: c */
    private final W.h f1201c;

    /* renamed from: d */
    private final boolean f1202d;

    public o(String str, int i2, W.h hVar, boolean z2) {
        this.f1199a = str;
        this.f1200b = i2;
        this.f1201c = hVar;
        this.f1202d = z2;
    }

    @Override // X.b
    public S.c a(com.airbnb.lottie.a aVar, Y.a aVar2) {
        return new S.q(aVar, aVar2, this);
    }

    public String b() {
        return this.f1199a;
    }

    public W.h c() {
        return this.f1201c;
    }

    public boolean d() {
        return this.f1202d;
    }

    public String toString() {
        return "ShapePath{name=" + this.f1199a + ", index=" + this.f1200b + '}';
    }
}
