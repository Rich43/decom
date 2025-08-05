package X;

/* loaded from: classes.dex */
public class i implements b {

    /* renamed from: a */
    private final String f1167a;

    /* renamed from: b */
    private final a f1168b;

    /* renamed from: c */
    private final W.b f1169c;

    /* renamed from: d */
    private final W.m f1170d;
    private final W.b e;

    /* renamed from: f */
    private final W.b f1171f;

    /* renamed from: g */
    private final W.b f1172g;

    /* renamed from: h */
    private final W.b f1173h;

    /* renamed from: i */
    private final W.b f1174i;

    /* renamed from: j */
    private final boolean f1175j;

    public enum a {
        STAR(1),
        POLYGON(2);


        /* renamed from: a */
        private final int f1179a;

        a(int i2) {
            this.f1179a = i2;
        }

        public static a a(int i2) {
            for (a aVar : values()) {
                if (aVar.f1179a == i2) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public i(String str, a aVar, W.b bVar, W.m mVar, W.b bVar2, W.b bVar3, W.b bVar4, W.b bVar5, W.b bVar6, boolean z2) {
        this.f1167a = str;
        this.f1168b = aVar;
        this.f1169c = bVar;
        this.f1170d = mVar;
        this.e = bVar2;
        this.f1171f = bVar3;
        this.f1172g = bVar4;
        this.f1173h = bVar5;
        this.f1174i = bVar6;
        this.f1175j = z2;
    }

    @Override // X.b
    public S.c a(com.airbnb.lottie.a aVar, Y.a aVar2) {
        return new S.n(aVar, aVar2, this);
    }

    public W.b b() {
        return this.f1171f;
    }

    public W.b c() {
        return this.f1173h;
    }

    public String d() {
        return this.f1167a;
    }

    public W.b e() {
        return this.f1172g;
    }

    public W.b f() {
        return this.f1174i;
    }

    public W.b g() {
        return this.f1169c;
    }

    public W.m h() {
        return this.f1170d;
    }

    public W.b i() {
        return this.e;
    }

    public a j() {
        return this.f1168b;
    }

    public boolean k() {
        return this.f1175j;
    }
}
