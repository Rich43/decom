package O0;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a */
    private final D0.a f515a;

    /* renamed from: b */
    private final s f516b;

    j(D0.a aVar) {
        this.f515a = aVar;
        this.f516b = new s(aVar);
    }

    public static j a(D0.a aVar) {
        if (aVar.c(1)) {
            return new g(aVar);
        }
        if (!aVar.c(2)) {
            return new k(aVar);
        }
        int iG = s.g(aVar, 1, 4);
        if (iG == 4) {
            return new a(aVar);
        }
        if (iG == 5) {
            return new b(aVar);
        }
        int iG2 = s.g(aVar, 1, 5);
        if (iG2 == 12) {
            return new c(aVar);
        }
        if (iG2 == 13) {
            return new d(aVar);
        }
        switch (s.g(aVar, 1, 7)) {
            case 56:
                return new e(aVar, "310", "11");
            case 57:
                return new e(aVar, "320", "11");
            case 58:
                return new e(aVar, "310", "13");
            case 59:
                return new e(aVar, "320", "13");
            case 60:
                return new e(aVar, "310", "15");
            case 61:
                return new e(aVar, "320", "15");
            case 62:
                return new e(aVar, "310", "17");
            case 63:
                return new e(aVar, "320", "17");
            default:
                throw new IllegalStateException("unknown decoder: ".concat(String.valueOf(aVar)));
        }
    }

    protected final s b() {
        return this.f516b;
    }

    protected final D0.a c() {
        return this.f515a;
    }

    public abstract String d();
}
