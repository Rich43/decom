package X;

/* loaded from: classes.dex */
public class h implements b {

    /* renamed from: a, reason: collision with root package name */
    private final String f1159a;

    /* renamed from: b, reason: collision with root package name */
    private final a f1160b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f1161c;

    public enum a {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static a a(int i2) {
            return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? MERGE : EXCLUDE_INTERSECTIONS : INTERSECT : SUBTRACT : ADD : MERGE;
        }
    }

    public h(String str, a aVar, boolean z2) {
        this.f1159a = str;
        this.f1160b = aVar;
        this.f1161c = z2;
    }

    @Override // X.b
    public S.c a(com.airbnb.lottie.a aVar, Y.a aVar2) {
        if (aVar.i()) {
            return new S.l(this);
        }
        c0.f.b("Animation contains merge paths but they are disabled.");
        return null;
    }

    public a b() {
        return this.f1160b;
    }

    public String c() {
        return this.f1159a;
    }

    public boolean d() {
        return this.f1161c;
    }

    public String toString() {
        return "MergePaths{mode=" + this.f1160b + '}';
    }
}
