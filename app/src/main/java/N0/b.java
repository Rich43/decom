package N0;

/* loaded from: classes.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f347a;

    /* renamed from: b, reason: collision with root package name */
    private final M0.b f348b;

    /* renamed from: c, reason: collision with root package name */
    private final M0.b f349c;

    /* renamed from: d, reason: collision with root package name */
    private final M0.c f350d;

    b(M0.b bVar, M0.b bVar2, M0.c cVar, boolean z2) {
        this.f348b = bVar;
        this.f349c = bVar2;
        this.f350d = cVar;
        this.f347a = z2;
    }

    private static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    private static int e(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    M0.c b() {
        return this.f350d;
    }

    M0.b c() {
        return this.f348b;
    }

    M0.b d() {
        return this.f349c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return a(this.f348b, bVar.f348b) && a(this.f349c, bVar.f349c) && a(this.f350d, bVar.f350d);
    }

    public boolean f() {
        return this.f349c == null;
    }

    public int hashCode() {
        return (e(this.f348b) ^ e(this.f349c)) ^ e(this.f350d);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        sb.append(this.f348b);
        sb.append(" , ");
        sb.append(this.f349c);
        sb.append(" : ");
        M0.c cVar = this.f350d;
        sb.append(cVar == null ? "null" : Integer.valueOf(cVar.c()));
        sb.append(" ]");
        return sb.toString();
    }
}
