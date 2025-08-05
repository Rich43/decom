package L0;

import z0.EnumC0379a;

/* loaded from: classes.dex */
public final class f extends p {

    /* renamed from: i, reason: collision with root package name */
    private final int[] f296i = new int[4];

    @Override // L0.p
    protected int l(D0.a aVar, int[] iArr, StringBuilder sb) {
        int[] iArr2 = this.f296i;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iG = aVar.g();
        int i2 = iArr[1];
        for (int i3 = 0; i3 < 4 && i2 < iG; i3++) {
            sb.append((char) (p.j(aVar, iArr2, i2, p.f316g) + 48));
            for (int i4 : iArr2) {
                i2 += i4;
            }
        }
        int i5 = p.n(aVar, i2, true, p.e)[1];
        for (int i6 = 0; i6 < 4 && i5 < iG; i6++) {
            sb.append((char) (p.j(aVar, iArr2, i5, p.f316g) + 48));
            for (int i7 : iArr2) {
                i5 += i7;
            }
        }
        return i5;
    }

    @Override // L0.p
    EnumC0379a q() {
        return EnumC0379a.EAN_8;
    }
}
