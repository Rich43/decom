package X;

/* loaded from: classes.dex */
public class k implements b {

    /* renamed from: a */
    private final String f1184a;

    /* renamed from: b */
    private final W.b f1185b;

    /* renamed from: c */
    private final W.b f1186c;

    /* renamed from: d */
    private final W.l f1187d;
    private final boolean e;

    public k(String str, W.b bVar, W.b bVar2, W.l lVar, boolean z2) {
        this.f1184a = str;
        this.f1185b = bVar;
        this.f1186c = bVar2;
        this.f1187d = lVar;
        this.e = z2;
    }

    @Override // X.b
    public S.c a(com.airbnb.lottie.a aVar, Y.a aVar2) {
        return new S.p(aVar, aVar2, this);
    }

    public W.b b() {
        return this.f1185b;
    }

    public String c() {
        return this.f1184a;
    }

    public W.b d() {
        return this.f1186c;
    }

    public W.l e() {
        return this.f1187d;
    }

    public boolean f() {
        return this.e;
    }
}
