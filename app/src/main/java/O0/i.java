package O0;

/* loaded from: classes.dex */
abstract class i extends h {
    i(D0.a aVar) {
        super(aVar);
    }

    protected abstract void h(StringBuilder sb, int i2);

    protected abstract int i(int i2);

    final void j(StringBuilder sb, int i2, int i3) {
        int iF = b().f(i2, i3);
        h(sb, iF);
        int i4 = i(iF);
        int i5 = 100000;
        for (int i6 = 0; i6 < 5; i6++) {
            if (i4 / i5 == 0) {
                sb.append('0');
            }
            i5 /= 10;
        }
        sb.append(i4);
    }
}
