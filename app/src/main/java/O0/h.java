package O0;

/* loaded from: classes.dex */
abstract class h extends j {
    h(D0.a aVar) {
        super(aVar);
    }

    private static void e(StringBuilder sb, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < 13; i4++) {
            int iCharAt = sb.charAt(i4 + i2) - '0';
            if ((i4 & 1) == 0) {
                iCharAt *= 3;
            }
            i3 += iCharAt;
        }
        int i5 = 10 - (i3 % 10);
        sb.append(i5 != 10 ? i5 : 0);
    }

    final void f(StringBuilder sb, int i2) {
        sb.append("(01)");
        int length = sb.length();
        sb.append('9');
        g(sb, i2, length);
    }

    final void g(StringBuilder sb, int i2, int i3) {
        for (int i4 = 0; i4 < 4; i4++) {
            int iF = b().f((i4 * 10) + i2, 10);
            if (iF / 100 == 0) {
                sb.append('0');
            }
            if (iF / 10 == 0) {
                sb.append('0');
            }
            sb.append(iF);
        }
        e(sb, i3);
    }
}
