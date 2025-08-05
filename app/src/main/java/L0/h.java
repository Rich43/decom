package L0;

import java.util.Map;
import z0.C0384f;
import z0.EnumC0379a;
import z0.EnumC0383e;

/* loaded from: classes.dex */
public final class h extends k {

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f299b = {6, 8, 10, 12, 14};

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f300c = {1, 1, 1, 1};

    /* renamed from: d, reason: collision with root package name */
    private static final int[][] f301d = {new int[]{1, 1, 2}, new int[]{1, 1, 3}};
    private static final int[][] e = {new int[]{1, 1, 2, 2, 1}, new int[]{2, 1, 1, 1, 2}, new int[]{1, 2, 1, 1, 2}, new int[]{2, 2, 1, 1, 1}, new int[]{1, 1, 2, 1, 2}, new int[]{2, 1, 2, 1, 1}, new int[]{1, 2, 2, 1, 1}, new int[]{1, 1, 1, 2, 2}, new int[]{2, 1, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    /* renamed from: a, reason: collision with root package name */
    private int f302a = -1;

    private static int h(int[] iArr) throws z0.i {
        int length = e.length;
        float f2 = 0.38f;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            float fE = k.e(iArr, e[i3], 0.5f);
            if (fE < f2) {
                i2 = i3;
                f2 = fE;
            } else if (fE == f2) {
                i2 = -1;
            }
        }
        if (i2 >= 0) {
            return i2 % 10;
        }
        throw z0.i.a();
    }

    private int[] i(D0.a aVar) {
        int[] iArrL;
        aVar.j();
        try {
            int iM = m(aVar);
            try {
                iArrL = l(aVar, iM, f301d[0]);
            } catch (z0.i unused) {
                iArrL = l(aVar, iM, f301d[1]);
            }
            n(aVar, iArrL[0]);
            int i2 = iArrL[0];
            iArrL[0] = aVar.g() - iArrL[1];
            iArrL[1] = aVar.g() - i2;
            return iArrL;
        } finally {
            aVar.j();
        }
    }

    private static void j(D0.a aVar, int i2, int i3, StringBuilder sb) throws z0.i {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i2 < i3) {
            k.f(aVar, i2, iArr);
            for (int i4 = 0; i4 < 5; i4++) {
                int i5 = i4 * 2;
                iArr2[i4] = iArr[i5];
                iArr3[i4] = iArr[i5 + 1];
            }
            sb.append((char) (h(iArr2) + 48));
            sb.append((char) (h(iArr3) + 48));
            for (int i6 = 0; i6 < 10; i6++) {
                i2 += iArr[i6];
            }
        }
    }

    private int[] k(D0.a aVar) throws z0.i {
        int[] iArrL = l(aVar, m(aVar), f300c);
        int i2 = iArrL[1];
        int i3 = iArrL[0];
        this.f302a = (i2 - i3) / 4;
        n(aVar, i3);
        return iArrL;
    }

    private static int[] l(D0.a aVar, int i2, int[] iArr) throws z0.i {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int iG = aVar.g();
        int i3 = i2;
        boolean z2 = false;
        int i4 = 0;
        while (i2 < iG) {
            if (aVar.c(i2) != z2) {
                iArr2[i4] = iArr2[i4] + 1;
            } else {
                if (i4 != length - 1) {
                    i4++;
                } else {
                    if (k.e(iArr2, iArr, 0.5f) < 0.38f) {
                        return new int[]{i3, i2};
                    }
                    i3 += iArr2[0] + iArr2[1];
                    int i5 = i4 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i5);
                    iArr2[i5] = 0;
                    iArr2[i4] = 0;
                    i4--;
                }
                iArr2[i4] = 1;
                z2 = !z2;
            }
            i2++;
        }
        throw z0.i.a();
    }

    private static int m(D0.a aVar) throws z0.i {
        int iG = aVar.g();
        int iE = aVar.e(0);
        if (iE != iG) {
            return iE;
        }
        throw z0.i.a();
    }

    private void n(D0.a aVar, int i2) throws z0.i {
        int i3 = this.f302a * 10;
        if (i3 >= i2) {
            i3 = i2;
        }
        for (int i4 = i2 - 1; i3 > 0 && i4 >= 0 && !aVar.c(i4); i4--) {
            i3--;
        }
        if (i3 != 0) {
            throw z0.i.a();
        }
    }

    @Override // L0.k
    public z0.m c(int i2, D0.a aVar, Map map) throws C0384f, z0.i {
        boolean z2;
        int[] iArrK = k(aVar);
        int[] iArrI = i(aVar);
        StringBuilder sb = new StringBuilder(20);
        j(aVar, iArrK[1], iArrI[0], sb);
        String string = sb.toString();
        int[] iArr = map != null ? (int[]) map.get(EnumC0383e.ALLOWED_LENGTHS) : null;
        if (iArr == null) {
            iArr = f299b;
        }
        int length = string.length();
        int length2 = iArr.length;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= length2) {
                z2 = false;
                break;
            }
            int i5 = iArr[i3];
            if (length == i5) {
                z2 = true;
                break;
            }
            if (i5 > i4) {
                i4 = i5;
            }
            i3++;
        }
        if (!z2 && length > i4) {
            z2 = true;
        }
        if (!z2) {
            throw C0384f.a();
        }
        float f2 = i2;
        return new z0.m(string, null, new z0.o[]{new z0.o(iArrK[1], f2), new z0.o(iArrI[0], f2)}, EnumC0379a.ITF);
    }
}
