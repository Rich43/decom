package O0;

/* loaded from: classes.dex */
abstract class f extends i {
    f(D0.a aVar) {
        super(aVar);
    }

    @Override // O0.j
    public String d() throws z0.i {
        if (c().g() != 60) {
            throw z0.i.a();
        }
        StringBuilder sb = new StringBuilder();
        f(sb, 5);
        j(sb, 45, 15);
        return sb.toString();
    }
}
