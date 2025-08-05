package X;

/* loaded from: classes.dex */
public class j implements b {

    /* renamed from: a */
    private final String f1180a;

    /* renamed from: b */
    private final W.m f1181b;

    /* renamed from: c */
    private final W.f f1182c;

    /* renamed from: d */
    private final W.b f1183d;
    private final boolean e;

    public j(String str, W.m mVar, W.f fVar, W.b bVar, boolean z2) {
        this.f1180a = str;
        this.f1181b = mVar;
        this.f1182c = fVar;
        this.f1183d = bVar;
        this.e = z2;
    }

    @Override // X.b
    public S.c a(com.airbnb.lottie.a aVar, Y.a aVar2) {
        return new S.o(aVar, aVar2, this);
    }

    public W.b b() {
        return this.f1183d;
    }

    public String c() {
        return this.f1180a;
    }

    public W.m d() {
        return this.f1181b;
    }

    public W.f e() {
        return this.f1182c;
    }

    public boolean f() {
        return this.e;
    }

    public String toString() {
        return "RectangleShape{position=" + this.f1181b + ", size=" + this.f1182c + '}';
    }
}
