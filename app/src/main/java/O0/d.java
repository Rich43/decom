package O0;

/* loaded from: classes.dex */
final class d extends h {
    d(D0.a aVar) {
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
        sb.append("(393");
        sb.append(iF);
        sb.append(')');
        int iF2 = b().f(50, 10);
        if (iF2 / 100 == 0) {
            sb.append('0');
        }
        if (iF2 / 10 == 0) {
            sb.append('0');
        }
        sb.append(iF2);
        sb.append(b().c(60, null).b());
        return sb.toString();
    }
}
