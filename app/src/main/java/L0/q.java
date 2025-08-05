package L0;

import z0.EnumC0379a;

/* loaded from: classes.dex */
public final class q extends p {

    /* renamed from: j, reason: collision with root package name */
    private static final int[] f321j = {1, 1, 1, 1, 1, 1};

    /* renamed from: k, reason: collision with root package name */
    static final int[][] f322k = {new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};

    /* renamed from: i, reason: collision with root package name */
    private final int[] f323i = new int[4];

    public static String s(String str) {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        StringBuilder sb = new StringBuilder(12);
        sb.append(str.charAt(0));
        char c2 = cArr[5];
        switch (c2) {
            case '0':
            case '1':
            case '2':
                sb.append(cArr, 0, 2);
                sb.append(c2);
                sb.append("0000");
                sb.append(cArr, 2, 3);
                break;
            case '3':
                sb.append(cArr, 0, 3);
                sb.append("00000");
                sb.append(cArr, 3, 2);
                break;
            case '4':
                sb.append(cArr, 0, 4);
                sb.append("00000");
                sb.append(cArr[4]);
                break;
            default:
                sb.append(cArr, 0, 5);
                sb.append("0000");
                sb.append(c2);
                break;
        }
        if (str.length() >= 8) {
            sb.append(str.charAt(7));
        }
        return sb.toString();
    }

    private static void t(StringBuilder sb, int i2) throws z0.i {
        for (int i3 = 0; i3 <= 1; i3++) {
            for (int i4 = 0; i4 < 10; i4++) {
                if (i2 == f322k[i3][i4]) {
                    sb.insert(0, (char) (i3 + 48));
                    sb.append((char) (i4 + 48));
                    return;
                }
            }
        }
        throw z0.i.a();
    }

    @Override // L0.p
    protected boolean h(String str) {
        return super.h(s(str));
    }

    @Override // L0.p
    protected int[] k(D0.a aVar, int i2) {
        return p.n(aVar, i2, true, f321j);
    }

    @Override // L0.p
    protected int l(D0.a aVar, int[] iArr, StringBuilder sb) throws z0.i {
        int[] iArr2 = this.f323i;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iG = aVar.g();
        int i2 = iArr[1];
        int i3 = 0;
        for (int i4 = 0; i4 < 6 && i2 < iG; i4++) {
            int iJ = p.j(aVar, iArr2, i2, p.f317h);
            sb.append((char) ((iJ % 10) + 48));
            for (int i5 : iArr2) {
                i2 += i5;
            }
            if (iJ >= 10) {
                i3 |= 1 << (5 - i4);
            }
        }
        t(sb, i3);
        return i2;
    }

    @Override // L0.p
    EnumC0379a q() {
        return EnumC0379a.UPC_E;
    }
}
