package V0;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import z0.EnumC0383e;
import z0.i;
import z0.o;
import z0.p;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final D0.b f996a;

    /* renamed from: c, reason: collision with root package name */
    private boolean f998c;
    private final p e;

    /* renamed from: b, reason: collision with root package name */
    private final List f997b = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private final int[] f999d = new int[5];

    private static final class b implements Serializable, Comparator {

        /* renamed from: a, reason: collision with root package name */
        private final float f1000a;

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d dVar, d dVar2) {
            int iCompare = Integer.compare(dVar2.h(), dVar.h());
            return iCompare == 0 ? Float.compare(Math.abs(dVar.i() - this.f1000a), Math.abs(dVar2.i() - this.f1000a)) : iCompare;
        }

        private b(float f2) {
            this.f1000a = f2;
        }
    }

    private static final class c implements Serializable, Comparator {

        /* renamed from: a, reason: collision with root package name */
        private final float f1001a;

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d dVar, d dVar2) {
            return Float.compare(Math.abs(dVar2.i() - this.f1001a), Math.abs(dVar.i() - this.f1001a));
        }

        private c(float f2) {
            this.f1001a = f2;
        }
    }

    public e(D0.b bVar, p pVar) {
        this.f996a = bVar;
        this.e = pVar;
    }

    private static float a(int[] iArr, int i2) {
        return ((i2 - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    private boolean c(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int[] iArrJ = j();
        int i7 = 0;
        while (i2 >= i7 && i3 >= i7 && this.f996a.d(i3 - i7, i2 - i7)) {
            iArrJ[2] = iArrJ[2] + 1;
            i7++;
        }
        if (iArrJ[2] == 0) {
            return false;
        }
        while (i2 >= i7 && i3 >= i7 && !this.f996a.d(i3 - i7, i2 - i7)) {
            iArrJ[1] = iArrJ[1] + 1;
            i7++;
        }
        if (iArrJ[1] == 0) {
            return false;
        }
        while (i2 >= i7 && i3 >= i7 && this.f996a.d(i3 - i7, i2 - i7)) {
            iArrJ[0] = iArrJ[0] + 1;
            i7++;
        }
        if (iArrJ[0] == 0) {
            return false;
        }
        int iG = this.f996a.g();
        int iJ = this.f996a.j();
        int i8 = 1;
        while (true) {
            int i9 = i2 + i8;
            if (i9 >= iG || (i6 = i3 + i8) >= iJ || !this.f996a.d(i6, i9)) {
                break;
            }
            iArrJ[2] = iArrJ[2] + 1;
            i8++;
        }
        while (true) {
            int i10 = i2 + i8;
            if (i10 >= iG || (i5 = i3 + i8) >= iJ || this.f996a.d(i5, i10)) {
                break;
            }
            iArrJ[3] = iArrJ[3] + 1;
            i8++;
        }
        if (iArrJ[3] == 0) {
            return false;
        }
        while (true) {
            int i11 = i2 + i8;
            if (i11 >= iG || (i4 = i3 + i8) >= iJ || !this.f996a.d(i4, i11)) {
                break;
            }
            iArrJ[4] = iArrJ[4] + 1;
            i8++;
        }
        if (iArrJ[4] == 0) {
            return false;
        }
        return i(iArrJ);
    }

    private float d(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        D0.b bVar = this.f996a;
        int iJ = bVar.j();
        int[] iArrJ = j();
        int i9 = i2;
        while (i9 >= 0 && bVar.d(i9, i3)) {
            iArrJ[2] = iArrJ[2] + 1;
            i9--;
        }
        if (i9 < 0) {
            return Float.NaN;
        }
        while (i9 >= 0 && !bVar.d(i9, i3)) {
            int i10 = iArrJ[1];
            if (i10 > i4) {
                break;
            }
            iArrJ[1] = i10 + 1;
            i9--;
        }
        if (i9 >= 0 && iArrJ[1] <= i4) {
            while (i9 >= 0 && bVar.d(i9, i3) && (i8 = iArrJ[0]) <= i4) {
                iArrJ[0] = i8 + 1;
                i9--;
            }
            if (iArrJ[0] > i4) {
                return Float.NaN;
            }
            int i11 = i2 + 1;
            while (i11 < iJ && bVar.d(i11, i3)) {
                iArrJ[2] = iArrJ[2] + 1;
                i11++;
            }
            if (i11 == iJ) {
                return Float.NaN;
            }
            while (i11 < iJ && !bVar.d(i11, i3) && (i7 = iArrJ[3]) < i4) {
                iArrJ[3] = i7 + 1;
                i11++;
            }
            if (i11 != iJ && iArrJ[3] < i4) {
                while (i11 < iJ && bVar.d(i11, i3) && (i6 = iArrJ[4]) < i4) {
                    iArrJ[4] = i6 + 1;
                    i11++;
                }
                int i12 = iArrJ[4];
                if (i12 < i4 && Math.abs(((((iArrJ[0] + iArrJ[1]) + iArrJ[2]) + iArrJ[3]) + i12) - i5) * 5 < i5 && h(iArrJ)) {
                    return a(iArrJ, i11);
                }
            }
        }
        return Float.NaN;
    }

    private float e(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        D0.b bVar = this.f996a;
        int iG = bVar.g();
        int[] iArrJ = j();
        int i9 = i2;
        while (i9 >= 0 && bVar.d(i3, i9)) {
            iArrJ[2] = iArrJ[2] + 1;
            i9--;
        }
        if (i9 < 0) {
            return Float.NaN;
        }
        while (i9 >= 0 && !bVar.d(i3, i9)) {
            int i10 = iArrJ[1];
            if (i10 > i4) {
                break;
            }
            iArrJ[1] = i10 + 1;
            i9--;
        }
        if (i9 >= 0 && iArrJ[1] <= i4) {
            while (i9 >= 0 && bVar.d(i3, i9) && (i8 = iArrJ[0]) <= i4) {
                iArrJ[0] = i8 + 1;
                i9--;
            }
            if (iArrJ[0] > i4) {
                return Float.NaN;
            }
            int i11 = i2 + 1;
            while (i11 < iG && bVar.d(i3, i11)) {
                iArrJ[2] = iArrJ[2] + 1;
                i11++;
            }
            if (i11 == iG) {
                return Float.NaN;
            }
            while (i11 < iG && !bVar.d(i3, i11) && (i7 = iArrJ[3]) < i4) {
                iArrJ[3] = i7 + 1;
                i11++;
            }
            if (i11 != iG && iArrJ[3] < i4) {
                while (i11 < iG && bVar.d(i3, i11) && (i6 = iArrJ[4]) < i4) {
                    iArrJ[4] = i6 + 1;
                    i11++;
                }
                int i12 = iArrJ[4];
                if (i12 < i4 && Math.abs(((((iArrJ[0] + iArrJ[1]) + iArrJ[2]) + iArrJ[3]) + i12) - i5) * 5 < i5 * 2 && h(iArrJ)) {
                    return a(iArrJ, i11);
                }
            }
        }
        return Float.NaN;
    }

    private int g() {
        if (this.f997b.size() <= 1) {
            return 0;
        }
        d dVar = null;
        for (d dVar2 : this.f997b) {
            if (dVar2.h() >= 2) {
                if (dVar != null) {
                    this.f998c = true;
                    return ((int) (Math.abs(dVar.c() - dVar2.c()) - Math.abs(dVar.d() - dVar2.d()))) / 2;
                }
                dVar = dVar2;
            }
        }
        return 0;
    }

    protected static boolean h(int[] iArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 5; i3++) {
            int i4 = iArr[i3];
            if (i4 == 0) {
                return false;
            }
            i2 += i4;
        }
        if (i2 < 7) {
            return false;
        }
        float f2 = i2 / 7.0f;
        float f3 = f2 / 2.0f;
        return Math.abs(f2 - ((float) iArr[0])) < f3 && Math.abs(f2 - ((float) iArr[1])) < f3 && Math.abs((f2 * 3.0f) - ((float) iArr[2])) < 3.0f * f3 && Math.abs(f2 - ((float) iArr[3])) < f3 && Math.abs(f2 - ((float) iArr[4])) < f3;
    }

    protected static boolean i(int[] iArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 5; i3++) {
            int i4 = iArr[i3];
            if (i4 == 0) {
                return false;
            }
            i2 += i4;
        }
        if (i2 < 7) {
            return false;
        }
        float f2 = i2 / 7.0f;
        float f3 = f2 / 1.333f;
        return Math.abs(f2 - ((float) iArr[0])) < f3 && Math.abs(f2 - ((float) iArr[1])) < f3 && Math.abs((f2 * 3.0f) - ((float) iArr[2])) < 3.0f * f3 && Math.abs(f2 - ((float) iArr[3])) < f3 && Math.abs(f2 - ((float) iArr[4])) < f3;
    }

    private int[] j() {
        b(this.f999d);
        return this.f999d;
    }

    private boolean l() {
        int size = this.f997b.size();
        float fAbs = 0.0f;
        int i2 = 0;
        float fI = 0.0f;
        for (d dVar : this.f997b) {
            if (dVar.h() >= 2) {
                i2++;
                fI += dVar.i();
            }
        }
        if (i2 < 3) {
            return false;
        }
        float f2 = fI / size;
        Iterator it = this.f997b.iterator();
        while (it.hasNext()) {
            fAbs += Math.abs(((d) it.next()).i() - f2);
        }
        return fAbs <= fI * 0.05f;
    }

    private d[] m() throws i {
        int size = this.f997b.size();
        if (size < 3) {
            throw i.a();
        }
        float fI = 0.0f;
        if (size > 3) {
            Iterator it = this.f997b.iterator();
            float f2 = 0.0f;
            float f3 = 0.0f;
            while (it.hasNext()) {
                float fI2 = ((d) it.next()).i();
                f2 += fI2;
                f3 += fI2 * fI2;
            }
            float f4 = f2 / size;
            float fSqrt = (float) Math.sqrt((f3 / r3) - (f4 * f4));
            Collections.sort(this.f997b, new c(f4));
            float fMax = Math.max(0.2f * f4, fSqrt);
            int i2 = 0;
            while (i2 < this.f997b.size() && this.f997b.size() > 3) {
                if (Math.abs(((d) this.f997b.get(i2)).i() - f4) > fMax) {
                    this.f997b.remove(i2);
                    i2--;
                }
                i2++;
            }
        }
        if (this.f997b.size() > 3) {
            Iterator it2 = this.f997b.iterator();
            while (it2.hasNext()) {
                fI += ((d) it2.next()).i();
            }
            Collections.sort(this.f997b, new b(fI / this.f997b.size()));
            List list = this.f997b;
            list.subList(3, list.size()).clear();
        }
        return new d[]{(d) this.f997b.get(0), (d) this.f997b.get(1), (d) this.f997b.get(2)};
    }

    protected final void b(int[] iArr) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = 0;
        }
    }

    final f f(Map map) throws i {
        boolean z2 = map != null && map.containsKey(EnumC0383e.TRY_HARDER);
        int iG = this.f996a.g();
        int iJ = this.f996a.j();
        int i2 = (iG * 3) / 388;
        if (i2 < 3 || z2) {
            i2 = 3;
        }
        int[] iArr = new int[5];
        int i3 = i2 - 1;
        boolean zL = false;
        while (i3 < iG && !zL) {
            b(iArr);
            int i4 = 0;
            int i5 = 0;
            while (i4 < iJ) {
                if (this.f996a.d(i4, i3)) {
                    if ((i5 & 1) == 1) {
                        i5++;
                    }
                    iArr[i5] = iArr[i5] + 1;
                } else if ((i5 & 1) != 0) {
                    iArr[i5] = iArr[i5] + 1;
                } else if (i5 != 4) {
                    i5++;
                    iArr[i5] = iArr[i5] + 1;
                } else if (h(iArr) && k(iArr, i3, i4)) {
                    if (this.f998c) {
                        zL = l();
                    } else {
                        int iG2 = g();
                        int i6 = iArr[2];
                        if (iG2 > i6) {
                            i3 += (iG2 - i6) - 2;
                            i4 = iJ - 1;
                        }
                    }
                    b(iArr);
                    i2 = 2;
                    i5 = 0;
                } else {
                    n(iArr);
                    i5 = 3;
                }
                i4++;
            }
            if (h(iArr) && k(iArr, i3, iJ)) {
                i2 = iArr[0];
                if (this.f998c) {
                    zL = l();
                }
            }
            i3 += i2;
        }
        d[] dVarArrM = m();
        o.e(dVarArrM);
        return new f(dVarArrM);
    }

    protected final boolean k(int[] iArr, int i2, int i3) {
        int i4 = 0;
        int i5 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int iA = (int) a(iArr, i3);
        float fE = e(i2, iA, iArr[2], i5);
        if (!Float.isNaN(fE)) {
            int i6 = (int) fE;
            float fD = d(iA, i6, iArr[2], i5);
            if (!Float.isNaN(fD) && c(i6, (int) fD)) {
                float f2 = i5 / 7.0f;
                while (true) {
                    if (i4 < this.f997b.size()) {
                        d dVar = (d) this.f997b.get(i4);
                        if (dVar.f(f2, fE, fD)) {
                            this.f997b.set(i4, dVar.g(fE, fD, f2));
                            break;
                        }
                        i4++;
                    } else {
                        d dVar2 = new d(fD, fE, f2);
                        this.f997b.add(dVar2);
                        p pVar = this.e;
                        if (pVar != null) {
                            pVar.a(dVar2);
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    protected final void n(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }
}
