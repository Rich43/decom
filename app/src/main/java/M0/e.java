package M0;

import L0.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import z0.EnumC0379a;
import z0.EnumC0383e;
import z0.i;
import z0.m;
import z0.o;
import z0.p;

/* loaded from: classes.dex */
public final class e extends a {

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f337i = {1, 10, 34, 70, 126};

    /* renamed from: j, reason: collision with root package name */
    private static final int[] f338j = {4, 20, 48, 81};

    /* renamed from: k, reason: collision with root package name */
    private static final int[] f339k = {0, 161, 961, 2015, 2715};

    /* renamed from: l, reason: collision with root package name */
    private static final int[] f340l = {0, 336, 1036, 1516};

    /* renamed from: m, reason: collision with root package name */
    private static final int[] f341m = {8, 6, 4, 3, 1};

    /* renamed from: n, reason: collision with root package name */
    private static final int[] f342n = {2, 4, 6, 8};
    private static final int[][] o = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};

    /* renamed from: g, reason: collision with root package name */
    private final List f343g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private final List f344h = new ArrayList();

    private static void r(Collection collection, d dVar) {
        if (dVar == null) {
            return;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            d dVar2 = (d) it.next();
            if (dVar2.b() == dVar.b()) {
                dVar2.e();
                return;
            }
        }
        collection.add(dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002a A[PHI: r6 r7
  0x002a: PHI (r6v7 boolean) = (r6v3 boolean), (r6v13 boolean) binds: [B:28:0x0043, B:13:0x0028] A[DONT_GENERATE, DONT_INLINE]
  0x002a: PHI (r7v5 boolean) = (r7v1 boolean), (r7v11 boolean) binds: [B:28:0x0043, B:13:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002d A[PHI: r6 r7
  0x002d: PHI (r6v5 boolean) = (r6v3 boolean), (r6v13 boolean) binds: [B:28:0x0043, B:13:0x0028] A[DONT_GENERATE, DONT_INLINE]
  0x002d: PHI (r7v3 boolean) = (r7v1 boolean), (r7v11 boolean) binds: [B:28:0x0043, B:13:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void s(boolean r10, int r11) throws z0.i {
        /*
            Method dump skipped, instructions count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: M0.e.s(boolean, int):void");
    }

    private static boolean t(d dVar, d dVar2) {
        int iA = (dVar.a() + (dVar2.a() * 16)) % 79;
        int iC = (dVar.d().c() * 9) + dVar2.d().c();
        if (iC > 72) {
            iC--;
        }
        if (iC > 8) {
            iC--;
        }
        return iA == iC;
    }

    private static m u(d dVar, d dVar2) {
        String strValueOf = String.valueOf((dVar.b() * 4537077) + dVar2.b());
        StringBuilder sb = new StringBuilder(14);
        for (int length = 13 - strValueOf.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(strValueOf);
        int i2 = 0;
        for (int i3 = 0; i3 < 13; i3++) {
            int iCharAt = sb.charAt(i3) - '0';
            if ((i3 & 1) == 0) {
                iCharAt *= 3;
            }
            i2 += iCharAt;
        }
        int i4 = 10 - (i2 % 10);
        if (i4 == 10) {
            i4 = 0;
        }
        sb.append(i4);
        o[] oVarArrA = dVar.d().a();
        o[] oVarArrA2 = dVar2.d().a();
        return new m(sb.toString(), null, new o[]{oVarArrA[0], oVarArrA[1], oVarArrA2[0], oVarArrA2[1]}, EnumC0379a.RSS_14);
    }

    private b v(D0.a aVar, c cVar, boolean z2) throws i {
        int[] iArrI = i();
        for (int i2 = 0; i2 < iArrI.length; i2++) {
            iArrI[i2] = 0;
        }
        if (z2) {
            k.g(aVar, cVar.b()[0], iArrI);
        } else {
            k.f(aVar, cVar.b()[1] + 1, iArrI);
            int i3 = 0;
            for (int length = iArrI.length - 1; i3 < length; length--) {
                int i4 = iArrI[i3];
                iArrI[i3] = iArrI[length];
                iArrI[length] = i4;
                i3++;
            }
        }
        int i5 = z2 ? 16 : 15;
        float fD = E0.a.d(iArrI) / i5;
        int[] iArrM = m();
        int[] iArrK = k();
        float[] fArrN = n();
        float[] fArrL = l();
        for (int i6 = 0; i6 < iArrI.length; i6++) {
            float f2 = iArrI[i6] / fD;
            int i7 = (int) (0.5f + f2);
            if (i7 <= 0) {
                i7 = 1;
            } else if (i7 > 8) {
                i7 = 8;
            }
            int i8 = i6 / 2;
            if ((i6 & 1) == 0) {
                iArrM[i8] = i7;
                fArrN[i8] = f2 - i7;
            } else {
                iArrK[i8] = i7;
                fArrL[i8] = f2 - i7;
            }
        }
        s(z2, i5);
        int i9 = 0;
        int i10 = 0;
        for (int length2 = iArrM.length - 1; length2 >= 0; length2--) {
            int i11 = iArrM[length2];
            i9 = (i9 * 9) + i11;
            i10 += i11;
        }
        int i12 = 0;
        int i13 = 0;
        for (int length3 = iArrK.length - 1; length3 >= 0; length3--) {
            int i14 = iArrK[length3];
            i12 = (i12 * 9) + i14;
            i13 += i14;
        }
        int i15 = i9 + (i12 * 3);
        if (!z2) {
            if ((i13 & 1) != 0 || i13 > 10 || i13 < 4) {
                throw i.a();
            }
            int i16 = (10 - i13) / 2;
            int i17 = f342n[i16];
            return new b((f.b(iArrK, 9 - i17, false) * f338j[i16]) + f.b(iArrM, i17, true) + f340l[i16], i15);
        }
        if ((i10 & 1) != 0 || i10 > 12 || i10 < 4) {
            throw i.a();
        }
        int i18 = (12 - i10) / 2;
        int i19 = f341m[i18];
        return new b((f.b(iArrM, i19, false) * f337i[i18]) + f.b(iArrK, 9 - i19, true) + f339k[i18], i15);
    }

    private d w(D0.a aVar, boolean z2, int i2, Map map) {
        try {
            c cVarY = y(aVar, i2, z2, x(aVar, z2));
            p pVar = map == null ? null : (p) map.get(EnumC0383e.NEED_RESULT_POINT_CALLBACK);
            if (pVar != null) {
                float fG = (r1[0] + r1[1]) / 2.0f;
                if (z2) {
                    fG = (aVar.g() - 1) - fG;
                }
                pVar.a(new o(fG, i2));
            }
            b bVarV = v(aVar, cVarY, true);
            b bVarV2 = v(aVar, cVarY, false);
            return new d((bVarV.b() * 1597) + bVarV2.b(), bVarV.a() + (bVarV2.a() * 4), cVarY);
        } catch (i unused) {
            return null;
        }
    }

    private int[] x(D0.a aVar, boolean z2) throws i {
        int[] iArrJ = j();
        iArrJ[0] = 0;
        iArrJ[1] = 0;
        iArrJ[2] = 0;
        iArrJ[3] = 0;
        int iG = aVar.g();
        int i2 = 0;
        boolean z3 = false;
        while (i2 < iG) {
            z3 = !aVar.c(i2);
            if (z2 == z3) {
                break;
            }
            i2++;
        }
        int i3 = i2;
        int i4 = 0;
        while (i2 < iG) {
            if (aVar.c(i2) != z3) {
                iArrJ[i4] = iArrJ[i4] + 1;
            } else {
                if (i4 != 3) {
                    i4++;
                } else {
                    if (a.p(iArrJ)) {
                        return new int[]{i3, i2};
                    }
                    i3 += iArrJ[0] + iArrJ[1];
                    iArrJ[0] = iArrJ[2];
                    iArrJ[1] = iArrJ[3];
                    iArrJ[2] = 0;
                    iArrJ[3] = 0;
                    i4--;
                }
                iArrJ[i4] = 1;
                z3 = !z3;
            }
            i2++;
        }
        throw i.a();
    }

    private c y(D0.a aVar, int i2, boolean z2, int[] iArr) throws i {
        int iG;
        int i3;
        boolean zC = aVar.c(iArr[0]);
        int i4 = iArr[0] - 1;
        while (i4 >= 0 && zC != aVar.c(i4)) {
            i4--;
        }
        int i5 = i4 + 1;
        int i6 = iArr[0] - i5;
        int[] iArrJ = j();
        System.arraycopy(iArrJ, 0, iArrJ, 1, iArrJ.length - 1);
        iArrJ[0] = i6;
        int iQ = a.q(iArrJ, o);
        int i7 = iArr[1];
        if (z2) {
            int iG2 = (aVar.g() - 1) - i5;
            iG = (aVar.g() - 1) - i7;
            i3 = iG2;
        } else {
            iG = i7;
            i3 = i5;
        }
        return new c(iQ, new int[]{i5, iArr[1]}, i3, iG, i2);
    }

    @Override // L0.k, z0.k
    public void b() {
        this.f343g.clear();
        this.f344h.clear();
    }

    @Override // L0.k
    public m c(int i2, D0.a aVar, Map map) throws i {
        r(this.f343g, w(aVar, false, i2, map));
        aVar.j();
        r(this.f344h, w(aVar, true, i2, map));
        aVar.j();
        for (d dVar : this.f343g) {
            if (dVar.c() > 1) {
                for (d dVar2 : this.f344h) {
                    if (dVar2.c() > 1 && t(dVar, dVar2)) {
                        return u(dVar, dVar2);
                    }
                }
            }
        }
        throw i.a();
    }
}
