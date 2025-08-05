package N0;

import L0.k;
import M0.f;
import O0.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import z0.EnumC0379a;
import z0.i;
import z0.m;
import z0.o;

/* loaded from: classes.dex */
public final class d extends M0.a {

    /* renamed from: k, reason: collision with root package name */
    private static final int[] f354k = {7, 5, 4, 3, 1};

    /* renamed from: l, reason: collision with root package name */
    private static final int[] f355l = {4, 20, 52, 104, 204};

    /* renamed from: m, reason: collision with root package name */
    private static final int[] f356m = {0, 348, 1388, 2948, 3988};

    /* renamed from: n, reason: collision with root package name */
    private static final int[][] f357n = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};
    private static final int[][] o = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, 143, 7, 21, 63}, new int[]{189, 145, 13, 39, 117, 140, 209, 205}, new int[]{193, 157, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, 169, 85, 44, 132}, new int[]{185, 133, 188, 142, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, 138, 203, 187, 139, 206, 196, 166}, new int[]{76, 17, 51, 153, 37, 111, 122, 155}, new int[]{43, 129, 176, 106, 107, 110, 119, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, 116, 137, 200, 178, 112, 125, 164}, new int[]{70, 210, 208, 202, 184, 130, 179, 115}, new int[]{134, 191, 151, 31, 93, 68, 204, 190}, new int[]{148, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, 192, 154, 40}, new int[]{120, 149, 25, 75, 14, 42, 126, 167}, new int[]{79, 26, 78, 23, 69, 207, 199, 175}, new int[]{103, 98, 83, 38, 114, 131, 182, 124}, new int[]{161, 61, 183, 127, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, 160, 58, 174, 100, 89}};

    /* renamed from: p, reason: collision with root package name */
    private static final int[][] f358p = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};

    /* renamed from: g, reason: collision with root package name */
    private final List f359g = new ArrayList(11);

    /* renamed from: h, reason: collision with root package name */
    private final List f360h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    private final int[] f361i = new int[2];

    /* renamed from: j, reason: collision with root package name */
    private boolean f362j;

    private static boolean A(M0.c cVar, boolean z2, boolean z3) {
        return (cVar.c() == 0 && z2 && z3) ? false : true;
    }

    private static boolean B(Iterable iterable, Iterable iterable2) {
        Iterator it = iterable2.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            Iterator it2 = iterable.iterator();
            while (it2.hasNext()) {
                b bVar = (b) it2.next();
                Iterator it3 = cVar.a().iterator();
                while (it3.hasNext()) {
                    if (bVar.equals((b) it3.next())) {
                        break;
                    }
                }
            }
            return true;
        }
        return false;
    }

    private static boolean C(List list) {
        for (int[] iArr : f358p) {
            if (list.size() <= iArr.length) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (((b) list.get(i2)).b().c() != iArr[i2]) {
                        break;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private M0.c D(D0.a aVar, int i2, boolean z2) {
        int i3;
        int i4;
        int i5;
        if (z2) {
            int i6 = this.f361i[0] - 1;
            while (i6 >= 0 && !aVar.c(i6)) {
                i6--;
            }
            int i7 = i6 + 1;
            int[] iArr = this.f361i;
            i5 = iArr[0] - i7;
            i3 = iArr[1];
            i4 = i7;
        } else {
            int[] iArr2 = this.f361i;
            int i8 = iArr2[0];
            int iF = aVar.f(iArr2[1] + 1);
            i3 = iF;
            i4 = i8;
            i5 = iF - this.f361i[1];
        }
        int[] iArrJ = j();
        System.arraycopy(iArrJ, 0, iArrJ, 1, iArrJ.length - 1);
        iArrJ[0] = i5;
        try {
            return new M0.c(M0.a.q(iArrJ, f357n), new int[]{i4, i3}, i4, i3, i2);
        } catch (i unused) {
            return null;
        }
    }

    private static void E(List list, List list2) {
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.a().size() != list.size()) {
                Iterator it2 = cVar.a().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        it.remove();
                        break;
                    }
                    b bVar = (b) it2.next();
                    Iterator it3 = list.iterator();
                    while (it3.hasNext()) {
                        if (bVar.equals((b) it3.next())) {
                            break;
                        }
                    }
                }
            }
        }
    }

    private static void G(int[] iArr) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length / 2; i2++) {
            int i3 = iArr[i2];
            int i4 = (length - i2) - 1;
            iArr[i2] = iArr[i4];
            iArr[i4] = i3;
        }
    }

    private void H(int i2, boolean z2) {
        boolean zC = false;
        int i3 = 0;
        boolean zC2 = false;
        while (true) {
            if (i3 >= this.f360h.size()) {
                break;
            }
            c cVar = (c) this.f360h.get(i3);
            if (cVar.b() > i2) {
                zC = cVar.c(this.f359g);
                break;
            } else {
                zC2 = cVar.c(this.f359g);
                i3++;
            }
        }
        if (zC || zC2 || B(this.f359g, this.f360h)) {
            return;
        }
        this.f360h.add(i3, new c(this.f359g, i2, z2));
        E(this.f359g, this.f360h);
    }

    private void r(int i2) throws i {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int iD = E0.a.d(m());
        int iD2 = E0.a.d(k());
        boolean z6 = true;
        if (iD > 13) {
            z2 = false;
            z3 = true;
        } else {
            z2 = iD < 4;
            z3 = false;
        }
        if (iD2 > 13) {
            z4 = false;
            z5 = true;
        } else {
            z4 = iD2 < 4;
            z5 = false;
        }
        int i3 = (iD + iD2) - i2;
        boolean z7 = (iD & 1) == 1;
        boolean z8 = (iD2 & 1) == 0;
        if (i3 == 1) {
            if (z7) {
                if (z8) {
                    throw i.a();
                }
                z6 = z2;
                z3 = true;
            } else {
                if (!z8) {
                    throw i.a();
                }
                z6 = z2;
                z5 = true;
            }
        } else if (i3 == -1) {
            if (z7) {
                if (z8) {
                    throw i.a();
                }
            } else {
                if (!z8) {
                    throw i.a();
                }
                z6 = z2;
                z4 = true;
            }
        } else {
            if (i3 != 0) {
                throw i.a();
            }
            if (z7) {
                if (!z8) {
                    throw i.a();
                }
                if (iD >= iD2) {
                    z6 = z2;
                    z4 = true;
                    z3 = true;
                }
                z5 = true;
            } else {
                if (z8) {
                    throw i.a();
                }
                z6 = z2;
            }
        }
        if (z6) {
            if (z3) {
                throw i.a();
            }
            M0.a.o(m(), n());
        }
        if (z3) {
            M0.a.h(m(), n());
        }
        if (z4) {
            if (z5) {
                throw i.a();
            }
            M0.a.o(k(), n());
        }
        if (z5) {
            M0.a.h(k(), l());
        }
    }

    private boolean s() {
        b bVar = (b) this.f359g.get(0);
        M0.b bVarC = bVar.c();
        M0.b bVarD = bVar.d();
        if (bVarD == null) {
            return false;
        }
        int iA = bVarD.a();
        int i2 = 2;
        for (int i3 = 1; i3 < this.f359g.size(); i3++) {
            b bVar2 = (b) this.f359g.get(i3);
            iA += bVar2.c().a();
            int i4 = i2 + 1;
            M0.b bVarD2 = bVar2.d();
            if (bVarD2 != null) {
                iA += bVarD2.a();
                i2 += 2;
            } else {
                i2 = i4;
            }
        }
        return ((i2 + (-4)) * 211) + (iA % 211) == bVarC.b();
    }

    private List t(List list, int i2) throws i {
        while (i2 < this.f360h.size()) {
            c cVar = (c) this.f360h.get(i2);
            this.f359g.clear();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.f359g.addAll(((c) it.next()).a());
            }
            this.f359g.addAll(cVar.a());
            if (C(this.f359g)) {
                if (s()) {
                    return this.f359g;
                }
                ArrayList arrayList = new ArrayList(list);
                arrayList.add(cVar);
                try {
                    return t(arrayList, i2 + 1);
                } catch (i unused) {
                    continue;
                }
            }
            i2++;
        }
        throw i.a();
    }

    private List u(boolean z2) {
        List listT = null;
        if (this.f360h.size() > 25) {
            this.f360h.clear();
            return null;
        }
        this.f359g.clear();
        if (z2) {
            Collections.reverse(this.f360h);
        }
        try {
            listT = t(new ArrayList(), 0);
        } catch (i unused) {
        }
        if (z2) {
            Collections.reverse(this.f360h);
        }
        return listT;
    }

    static m v(List list) {
        String strD = j.a(a.a(list)).d();
        o[] oVarArrA = ((b) list.get(0)).b().a();
        o[] oVarArrA2 = ((b) list.get(list.size() - 1)).b().a();
        return new m(strD, null, new o[]{oVarArrA[0], oVarArrA[1], oVarArrA2[0], oVarArrA2[1]}, EnumC0379a.RSS_EXPANDED);
    }

    private void y(D0.a aVar, List list, int i2) throws i {
        int[] iArrJ = j();
        iArrJ[0] = 0;
        iArrJ[1] = 0;
        iArrJ[2] = 0;
        iArrJ[3] = 0;
        int iG = aVar.g();
        if (i2 < 0) {
            i2 = list.isEmpty() ? 0 : ((b) list.get(list.size() - 1)).b().b()[1];
        }
        boolean z2 = list.size() % 2 != 0;
        if (this.f362j) {
            z2 = !z2;
        }
        boolean z3 = false;
        while (true) {
            if (i2 >= iG) {
                break;
            }
            boolean zC = aVar.c(i2);
            boolean z4 = !zC;
            if (zC) {
                z3 = z4;
                break;
            } else {
                i2++;
                z3 = z4;
            }
        }
        boolean z5 = z3;
        int i3 = 0;
        int i4 = i2;
        while (i2 < iG) {
            if (aVar.c(i2) != z5) {
                iArrJ[i3] = iArrJ[i3] + 1;
            } else {
                if (i3 == 3) {
                    if (z2) {
                        G(iArrJ);
                    }
                    if (M0.a.p(iArrJ)) {
                        int[] iArr = this.f361i;
                        iArr[0] = i4;
                        iArr[1] = i2;
                        return;
                    }
                    if (z2) {
                        G(iArrJ);
                    }
                    i4 += iArrJ[0] + iArrJ[1];
                    iArrJ[0] = iArrJ[2];
                    iArrJ[1] = iArrJ[3];
                    iArrJ[2] = 0;
                    iArrJ[3] = 0;
                    i3--;
                } else {
                    i3++;
                }
                iArrJ[i3] = 1;
                z5 = !z5;
            }
            i2++;
        }
        throw i.a();
    }

    private static int z(D0.a aVar, int i2) {
        return aVar.c(i2) ? aVar.e(aVar.f(i2)) : aVar.f(aVar.e(i2));
    }

    b F(D0.a aVar, List list, int i2) throws i {
        M0.c cVarD;
        M0.b bVarW;
        boolean z2 = list.size() % 2 == 0;
        if (this.f362j) {
            z2 = !z2;
        }
        int iZ = -1;
        boolean z3 = true;
        do {
            y(aVar, list, iZ);
            cVarD = D(aVar, i2, z2);
            if (cVarD == null) {
                iZ = z(aVar, this.f361i[0]);
            } else {
                z3 = false;
            }
        } while (z3);
        M0.b bVarW2 = w(aVar, cVarD, z2, true);
        if (!list.isEmpty() && ((b) list.get(list.size() - 1)).f()) {
            throw i.a();
        }
        try {
            bVarW = w(aVar, cVarD, z2, false);
        } catch (i unused) {
            bVarW = null;
        }
        return new b(bVarW2, bVarW, cVarD, true);
    }

    @Override // L0.k, z0.k
    public void b() {
        this.f359g.clear();
        this.f360h.clear();
    }

    @Override // L0.k
    public m c(int i2, D0.a aVar, Map map) {
        this.f359g.clear();
        this.f362j = false;
        try {
            return v(x(i2, aVar));
        } catch (i unused) {
            this.f359g.clear();
            this.f362j = true;
            return v(x(i2, aVar));
        }
    }

    M0.b w(D0.a aVar, M0.c cVar, boolean z2, boolean z3) throws i {
        int[] iArrI = i();
        for (int i2 = 0; i2 < iArrI.length; i2++) {
            iArrI[i2] = 0;
        }
        if (z3) {
            k.g(aVar, cVar.b()[0], iArrI);
        } else {
            k.f(aVar, cVar.b()[1], iArrI);
            int i3 = 0;
            for (int length = iArrI.length - 1; i3 < length; length--) {
                int i4 = iArrI[i3];
                iArrI[i3] = iArrI[length];
                iArrI[length] = i4;
                i3++;
            }
        }
        float fD = E0.a.d(iArrI) / 17.0f;
        float f2 = (cVar.b()[1] - cVar.b()[0]) / 15.0f;
        if (Math.abs(fD - f2) / f2 > 0.3f) {
            throw i.a();
        }
        int[] iArrM = m();
        int[] iArrK = k();
        float[] fArrN = n();
        float[] fArrL = l();
        for (int i5 = 0; i5 < iArrI.length; i5++) {
            float f3 = (iArrI[i5] * 1.0f) / fD;
            int i6 = (int) (0.5f + f3);
            if (i6 <= 0) {
                if (f3 < 0.3f) {
                    throw i.a();
                }
                i6 = 1;
            } else if (i6 > 8) {
                if (f3 > 8.7f) {
                    throw i.a();
                }
                i6 = 8;
            }
            int i7 = i5 / 2;
            if ((i5 & 1) == 0) {
                iArrM[i7] = i6;
                fArrN[i7] = f3 - i6;
            } else {
                iArrK[i7] = i6;
                fArrL[i7] = f3 - i6;
            }
        }
        r(17);
        int iC = (((cVar.c() * 4) + (z2 ? 0 : 2)) + (!z3 ? 1 : 0)) - 1;
        int i8 = 0;
        int i9 = 0;
        for (int length2 = iArrM.length - 1; length2 >= 0; length2--) {
            if (A(cVar, z2, z3)) {
                i8 += iArrM[length2] * o[iC][length2 * 2];
            }
            i9 += iArrM[length2];
        }
        int i10 = 0;
        for (int length3 = iArrK.length - 1; length3 >= 0; length3--) {
            if (A(cVar, z2, z3)) {
                i10 += iArrK[length3] * o[iC][(length3 * 2) + 1];
            }
        }
        int i11 = i8 + i10;
        if ((i9 & 1) != 0 || i9 > 13 || i9 < 4) {
            throw i.a();
        }
        int i12 = (13 - i9) / 2;
        int i13 = f354k[i12];
        return new M0.b((f.b(iArrM, i13, true) * f355l[i12]) + f.b(iArrK, 9 - i13, false) + f356m[i12], i11);
    }

    List x(int i2, D0.a aVar) throws i {
        boolean z2 = false;
        while (!z2) {
            try {
                List list = this.f359g;
                list.add(F(aVar, list, i2));
            } catch (i e) {
                if (this.f359g.isEmpty()) {
                    throw e;
                }
                z2 = true;
            }
        }
        if (s()) {
            return this.f359g;
        }
        boolean zIsEmpty = this.f360h.isEmpty();
        H(i2, false);
        if (!zIsEmpty) {
            List listU = u(false);
            if (listU != null) {
                return listU;
            }
            List listU2 = u(true);
            if (listU2 != null) {
                return listU2;
            }
        }
        throw i.a();
    }
}
