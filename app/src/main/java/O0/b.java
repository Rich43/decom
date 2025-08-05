package O0;

/* loaded from: classes.dex */
final class b extends f {
    b(D0.a aVar) {
        super(aVar);
    }

    @Override // O0.i
    protected void h(StringBuilder sb, int i2) {
        if (i2 < 10000) {
            sb.append("(3202)");
        } else {
            sb.append("(3203)");
        }
    }

    @Override // O0.i
    protected int i(int i2) {
        return i2 < 10000 ? i2 : i2 - 10000;
    }
}
