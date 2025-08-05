package X;

/* loaded from: classes.dex */
public class a implements b {

    /* renamed from: a */
    private final String f1121a;

    /* renamed from: b */
    private final W.m f1122b;

    /* renamed from: c */
    private final W.f f1123c;

    /* renamed from: d */
    private final boolean f1124d;
    private final boolean e;

    public a(String str, W.m mVar, W.f fVar, boolean z2, boolean z3) {
        this.f1121a = str;
        this.f1122b = mVar;
        this.f1123c = fVar;
        this.f1124d = z2;
        this.e = z3;
    }

    @Override // X.b
    public S.c a(com.airbnb.lottie.a aVar, Y.a aVar2) {
        return new S.f(aVar, aVar2, this);
    }

    public String b() {
        return this.f1121a;
    }

    public W.m c() {
        return this.f1122b;
    }

    public W.f d() {
        return this.f1123c;
    }

    public boolean e() {
        return this.e;
    }

    public boolean f() {
        return this.f1124d;
    }
}
