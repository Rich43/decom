package O0;

/* loaded from: classes.dex */
final class c extends h {
    c(D0.a aVar) {
        super(aVar);
    }

    @Override // O0.j
    public String d() throws z0.i {
        if (c().g() < 48) {
            throw z0.i.a();
        }
        StringBuilder sb = new StringBuilder();
        f(sb, 8);
        int iF = b().f(48, 2);
        sb.append("(392");
        sb.append(iF);
        sb.append(')');
        sb.append(b().c(50, null).b());
        return sb.toString();
    }
}
