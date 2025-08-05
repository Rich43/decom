package L0;

import z0.EnumC0379a;

/* loaded from: classes.dex */
public final class e extends p {

    /* renamed from: j, reason: collision with root package name */
    static final int[] f294j = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};

    /* renamed from: i, reason: collision with root package name */
    private final int[] f295i = new int[4];

    private static void s(StringBuilder sb, int i2) throws z0.i {
        for (int i3 = 0; i3 < 10; i3++) {
            if (i2 == f294j[i3]) {
                sb.insert(0, (char) (i3 + 48));
                return;
            }
        }
        throw z0.i.a();
    }

    @Override // L0.p
    protected int l(D0.a aVar, int[] iArr, StringBuilder sb) throws z0.i {
        int[] iArr2 = this.f295i;
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
        s(sb, i3);
        int i6 = p.n(aVar, i2, true, p.e)[1];
        for (int i7 = 0; i7 < 6 && i6 < iG; i7++) {
            sb.append((char) (p.j(aVar, iArr2, i6, p.f316g) + 48));
            for (int i8 : iArr2) {
                i6 += i8;
            }
        }
        return i6;
    }

    @Override // L0.p
    EnumC0379a q() {
        return EnumC0379a.EAN_13;
    }
}
