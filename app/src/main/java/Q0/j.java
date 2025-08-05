package Q0;

import java.lang.reflect.Array;
import java.util.ArrayList;
import z0.C0382d;
import z0.C0384f;
import z0.o;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    private static final R0.a f719a = new R0.a();

    private static c a(h hVar) {
        int[] iArrJ;
        if (hVar == null || (iArrJ = hVar.j()) == null) {
            return null;
        }
        int iP = p(iArrJ);
        int i2 = 0;
        int i3 = 0;
        for (int i4 : iArrJ) {
            i3 += iP - i4;
            if (i4 > 0) {
                break;
            }
        }
        d[] dVarArrD = hVar.d();
        for (int i5 = 0; i3 > 0 && dVarArrD[i5] == null; i5++) {
            i3--;
        }
        for (int length = iArrJ.length - 1; length >= 0; length--) {
            int i6 = iArrJ[length];
            i2 += iP - i6;
            if (i6 > 0) {
                break;
            }
        }
        for (int length2 = dVarArrD.length - 1; i2 > 0 && dVarArrD[length2] == null; length2--) {
            i2--;
        }
        return hVar.a().a(i3, i2, hVar.k());
    }

    private static void b(f fVar, b[][] bVarArr) throws z0.i {
        b bVar = bVarArr[0][1];
        int[] iArrA = bVar.a();
        int iJ = (fVar.j() * fVar.l()) - r(fVar.k());
        if (iArrA.length != 0) {
            if (iArrA[0] != iJ) {
                bVar.b(iJ);
            }
        } else {
            if (iJ <= 0 || iJ > 928) {
                throw z0.i.a();
            }
            bVar.b(iJ);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0022, code lost:
    
        r0 = -r0;
        r8 = !r8;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int c(D0.b r5, int r6, int r7, boolean r8, int r9, int r10) {
        /*
            if (r8 == 0) goto L4
            r0 = -1
            goto L5
        L4:
            r0 = 1
        L5:
            r1 = 0
            r2 = r9
        L7:
            r3 = 2
            if (r1 >= r3) goto L28
        La:
            if (r8 == 0) goto Lf
            if (r2 < r6) goto L22
            goto L11
        Lf:
            if (r2 >= r7) goto L22
        L11:
            boolean r4 = r5.d(r2, r10)
            if (r8 != r4) goto L22
            int r4 = r9 - r2
            int r4 = java.lang.Math.abs(r4)
            if (r4 <= r3) goto L20
            return r9
        L20:
            int r2 = r2 + r0
            goto La
        L22:
            int r0 = -r0
            r8 = r8 ^ 1
            int r1 = r1 + 1
            goto L7
        L28:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: Q0.j.c(D0.b, int, int, boolean, int, int):int");
    }

    private static boolean d(int i2, int i3, int i4) {
        return i3 + (-2) <= i2 && i2 <= i4 + 2;
    }

    private static int e(int[] iArr, int[] iArr2, int i2) throws C0382d {
        if ((iArr2 == null || iArr2.length <= (i2 / 2) + 3) && i2 >= 0 && i2 <= 512) {
            return f719a.a(iArr, i2, iArr2);
        }
        throw C0382d.a();
    }

    private static b[][] f(f fVar) {
        int iC;
        b[][] bVarArr = (b[][]) Array.newInstance((Class<?>) b.class, fVar.l(), fVar.j() + 2);
        for (b[] bVarArr2 : bVarArr) {
            int i2 = 0;
            while (true) {
                if (i2 < bVarArr2.length) {
                    bVarArr2[i2] = new b();
                    i2++;
                }
            }
        }
        int i3 = 0;
        for (g gVar : fVar.o()) {
            if (gVar != null) {
                for (d dVar : gVar.d()) {
                    if (dVar != null && (iC = dVar.c()) >= 0 && iC < bVarArr.length) {
                        bVarArr[iC][i3].b(dVar.e());
                    }
                }
            }
            i3++;
        }
        return bVarArr;
    }

    private static D0.e g(f fVar) throws z0.i {
        b[][] bVarArrF = f(fVar);
        b(fVar, bVarArrF);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[fVar.l() * fVar.j()];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i2 = 0; i2 < fVar.l(); i2++) {
            int i3 = 0;
            while (i3 < fVar.j()) {
                int i4 = i3 + 1;
                int[] iArrA = bVarArrF[i2][i4].a();
                int iJ = (fVar.j() * i2) + i3;
                if (iArrA.length == 0) {
                    arrayList.add(Integer.valueOf(iJ));
                } else if (iArrA.length == 1) {
                    iArr[iJ] = iArrA[0];
                } else {
                    arrayList3.add(Integer.valueOf(iJ));
                    arrayList2.add(iArrA);
                }
                i3 = i4;
            }
        }
        int size = arrayList2.size();
        int[][] iArr2 = new int[size][];
        for (int i5 = 0; i5 < size; i5++) {
            iArr2[i5] = (int[]) arrayList2.get(i5);
        }
        return h(fVar.k(), iArr, P0.a.b(arrayList), P0.a.b(arrayList3), iArr2);
    }

    private static D0.e h(int i2, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) throws C0382d {
        int length = iArr3.length;
        int[] iArr5 = new int[length];
        int i3 = 100;
        while (true) {
            int i4 = i3 - 1;
            if (i3 <= 0) {
                throw C0382d.a();
            }
            for (int i5 = 0; i5 < length; i5++) {
                iArr[iArr3[i5]] = iArr4[i5][iArr5[i5]];
            }
            try {
                return j(iArr, i2, iArr2);
            } catch (C0382d unused) {
                if (length == 0) {
                    throw C0382d.a();
                }
                int i6 = 0;
                while (true) {
                    if (i6 >= length) {
                        break;
                    }
                    int i7 = iArr5[i6];
                    if (i7 < iArr4[i6].length - 1) {
                        iArr5[i6] = i7 + 1;
                        break;
                    }
                    iArr5[i6] = 0;
                    if (i6 == length - 1) {
                        throw C0382d.a();
                    }
                    i6++;
                }
                i3 = i4;
            }
        }
    }

    public static D0.e i(D0.b bVar, o oVar, o oVar2, o oVar3, o oVar4, int i2, int i3) throws z0.i {
        int i4;
        int i5;
        int i6;
        h hVarS = null;
        h hVarS2 = null;
        f fVarV = null;
        c cVar = new c(bVar, oVar, oVar2, oVar3, oVar4);
        for (int i7 = 0; i7 < 2; i7++) {
            if (oVar != null) {
                hVarS = s(bVar, cVar, oVar, true, i2, i3);
            }
            if (oVar3 != null) {
                hVarS2 = s(bVar, cVar, oVar3, false, i2, i3);
            }
            fVarV = v(hVarS, hVarS2);
            if (fVarV == null) {
                throw z0.i.a();
            }
            if (i7 != 0 || fVarV.m() == null || (fVarV.m().g() >= cVar.g() && fVarV.m().e() <= cVar.e())) {
                fVarV.p(cVar);
                break;
            }
            cVar = fVarV.m();
        }
        int iJ = fVarV.j() + 1;
        fVarV.q(0, hVarS);
        fVarV.q(iJ, hVarS2);
        boolean z2 = hVarS != null;
        int iMin = i2;
        int iMax = i3;
        for (int i8 = 1; i8 <= iJ; i8++) {
            int i9 = z2 ? i8 : iJ - i8;
            if (fVarV.n(i9) == null) {
                g hVar = (i9 == 0 || i9 == iJ) ? new h(cVar, i9 == 0) : new g(cVar);
                fVarV.q(i9, hVar);
                int i10 = -1;
                int iG = cVar.g();
                int i11 = -1;
                while (iG <= cVar.e()) {
                    int iT = t(fVarV, i9, iG, z2);
                    if (iT >= 0 && iT <= cVar.d()) {
                        i6 = iT;
                    } else if (i11 != i10) {
                        i6 = i11;
                    } else {
                        i4 = i11;
                        i5 = iG;
                        i11 = i4;
                        iG = i5 + 1;
                        i10 = -1;
                    }
                    i4 = i11;
                    int i12 = iG;
                    d dVarK = k(bVar, cVar.f(), cVar.d(), z2, i6, i12, iMin, iMax);
                    i5 = i12;
                    if (dVarK != null) {
                        hVar.f(i5, dVarK);
                        iMin = Math.min(iMin, dVarK.f());
                        iMax = Math.max(iMax, dVarK.f());
                        i11 = i6;
                    } else {
                        i11 = i4;
                    }
                    iG = i5 + 1;
                    i10 = -1;
                }
            }
        }
        return g(fVarV);
    }

    private static D0.e j(int[] iArr, int i2, int[] iArr2) throws C0382d, C0384f {
        if (iArr.length == 0) {
            throw C0384f.a();
        }
        int i3 = 1 << (i2 + 1);
        int iE = e(iArr, iArr2, i3);
        w(iArr, i3);
        D0.e eVarB = e.b(iArr, String.valueOf(i2));
        eVarB.k(Integer.valueOf(iE));
        eVarB.j(Integer.valueOf(iArr2.length));
        return eVarB;
    }

    private static d k(D0.b bVar, int i2, int i3, boolean z2, int i4, int i5, int i6, int i7) {
        int i8;
        int iD;
        int iA;
        int iC = c(bVar, i2, i3, z2, i4, i5);
        int[] iArrQ = q(bVar, i2, i3, z2, iC, i5);
        if (iArrQ == null) {
            return null;
        }
        int iD2 = E0.a.d(iArrQ);
        if (z2) {
            i8 = iC + iD2;
        } else {
            for (int i9 = 0; i9 < iArrQ.length / 2; i9++) {
                int i10 = iArrQ[i9];
                iArrQ[i9] = iArrQ[(iArrQ.length - 1) - i9];
                iArrQ[(iArrQ.length - 1) - i9] = i10;
            }
            iC -= iD2;
            i8 = iC;
        }
        if (d(iD2, i6, i7) && (iA = P0.a.a((iD = i.d(iArrQ)))) != -1) {
            return new d(iC, i8, n(iD), iA);
        }
        return null;
    }

    private static a l(h hVar, h hVar2) {
        a aVarI;
        a aVarI2;
        if (hVar == null || (aVarI = hVar.i()) == null) {
            if (hVar2 == null) {
                return null;
            }
            return hVar2.i();
        }
        if (hVar2 == null || (aVarI2 = hVar2.i()) == null || aVarI.a() == aVarI2.a() || aVarI.b() == aVarI2.b() || aVarI.c() == aVarI2.c()) {
            return aVarI;
        }
        return null;
    }

    private static int[] m(int i2) {
        int[] iArr = new int[8];
        int i3 = 0;
        int i4 = 7;
        while (true) {
            int i5 = i2 & 1;
            if (i5 != i3) {
                i4--;
                if (i4 < 0) {
                    return iArr;
                }
                i3 = i5;
            }
            iArr[i4] = iArr[i4] + 1;
            i2 >>= 1;
        }
    }

    private static int n(int i2) {
        return o(m(i2));
    }

    private static int o(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }

    private static int p(int[] iArr) {
        int iMax = -1;
        for (int i2 : iArr) {
            iMax = Math.max(iMax, i2);
        }
        return iMax;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int[] q(D0.b r7, int r8, int r9, boolean r10, int r11, int r12) {
        /*
            r0 = 8
            int[] r1 = new int[r0]
            r2 = 1
            if (r10 == 0) goto L9
            r3 = 1
            goto La
        L9:
            r3 = -1
        La:
            r4 = 0
            r5 = r10
        Lc:
            if (r10 == 0) goto L11
            if (r11 >= r9) goto L27
            goto L13
        L11:
            if (r11 < r8) goto L27
        L13:
            if (r4 >= r0) goto L27
            boolean r6 = r7.d(r11, r12)
            if (r6 != r5) goto L22
            r6 = r1[r4]
            int r6 = r6 + r2
            r1[r4] = r6
            int r11 = r11 + r3
            goto Lc
        L22:
            int r4 = r4 + 1
            r5 = r5 ^ 1
            goto Lc
        L27:
            if (r4 == r0) goto L34
            if (r10 == 0) goto L2c
            r8 = r9
        L2c:
            if (r11 != r8) goto L32
            r7 = 7
            if (r4 != r7) goto L32
            goto L34
        L32:
            r7 = 0
            return r7
        L34:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: Q0.j.q(D0.b, int, int, boolean, int, int):int[]");
    }

    private static int r(int i2) {
        return 2 << i2;
    }

    private static h s(D0.b bVar, c cVar, o oVar, boolean z2, int i2, int i3) {
        h hVar = new h(cVar, z2);
        int i4 = 0;
        while (i4 < 2) {
            int i5 = i4 == 0 ? 1 : -1;
            int iC = (int) oVar.c();
            for (int iD = (int) oVar.d(); iD <= cVar.e() && iD >= cVar.g(); iD += i5) {
                d dVarK = k(bVar, 0, bVar.j(), z2, iC, iD, i2, i3);
                if (dVarK != null) {
                    hVar.f(iD, dVarK);
                    iC = z2 ? dVarK.d() : dVarK.b();
                }
            }
            i4++;
        }
        return hVar;
    }

    private static int t(f fVar, int i2, int i3, boolean z2) {
        int i4 = z2 ? 1 : -1;
        int i5 = i2 - i4;
        d dVarB = u(fVar, i5) ? fVar.n(i5).b(i3) : null;
        if (dVarB != null) {
            return z2 ? dVarB.b() : dVarB.d();
        }
        d dVarC = fVar.n(i2).c(i3);
        if (dVarC != null) {
            return z2 ? dVarC.d() : dVarC.b();
        }
        if (u(fVar, i5)) {
            dVarC = fVar.n(i5).c(i3);
        }
        if (dVarC != null) {
            return z2 ? dVarC.b() : dVarC.d();
        }
        int i6 = 0;
        while (true) {
            i2 -= i4;
            if (!u(fVar, i2)) {
                c cVarM = fVar.m();
                return z2 ? cVarM.f() : cVarM.d();
            }
            for (d dVar : fVar.n(i2).d()) {
                if (dVar != null) {
                    return (z2 ? dVar.b() : dVar.d()) + (i4 * i6 * (dVar.b() - dVar.d()));
                }
            }
            i6++;
        }
    }

    private static boolean u(f fVar, int i2) {
        return i2 >= 0 && i2 <= fVar.j() + 1;
    }

    private static f v(h hVar, h hVar2) {
        a aVarL;
        if ((hVar == null && hVar2 == null) || (aVarL = l(hVar, hVar2)) == null) {
            return null;
        }
        return new f(aVarL, c.j(a(hVar), a(hVar2)));
    }

    private static void w(int[] iArr, int i2) throws C0384f {
        if (iArr.length < 4) {
            throw C0384f.a();
        }
        int i3 = iArr[0];
        if (i3 > iArr.length) {
            throw C0384f.a();
        }
        if (i3 == 0) {
            if (i2 >= iArr.length) {
                throw C0384f.a();
            }
            iArr[0] = iArr.length - i2;
        }
    }
}
