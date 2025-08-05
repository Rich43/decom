package V0;

import java.util.ArrayList;
import java.util.List;
import z0.i;
import z0.p;

/* loaded from: classes.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private final D0.b f984a;

    /* renamed from: c, reason: collision with root package name */
    private final int f986c;

    /* renamed from: d, reason: collision with root package name */
    private final int f987d;
    private final int e;

    /* renamed from: f, reason: collision with root package name */
    private final int f988f;

    /* renamed from: g, reason: collision with root package name */
    private final float f989g;

    /* renamed from: i, reason: collision with root package name */
    private final p f991i;

    /* renamed from: b, reason: collision with root package name */
    private final List f985b = new ArrayList(5);

    /* renamed from: h, reason: collision with root package name */
    private final int[] f990h = new int[3];

    b(D0.b bVar, int i2, int i3, int i4, int i5, float f2, p pVar) {
        this.f984a = bVar;
        this.f986c = i2;
        this.f987d = i3;
        this.e = i4;
        this.f988f = i5;
        this.f989g = f2;
        this.f991i = pVar;
    }

    private static float a(int[] iArr, int i2) {
        return (i2 - iArr[2]) - (iArr[1] / 2.0f);
    }

    private float b(int i2, int i3, int i4, int i5) {
        D0.b bVar = this.f984a;
        int iG = bVar.g();
        int[] iArr = this.f990h;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i6 = i2;
        while (i6 >= 0 && bVar.d(i3, i6)) {
            int i7 = iArr[1];
            if (i7 > i4) {
                break;
            }
            iArr[1] = i7 + 1;
            i6--;
        }
        if (i6 >= 0 && iArr[1] <= i4) {
            while (i6 >= 0 && !bVar.d(i3, i6)) {
                int i8 = iArr[0];
                if (i8 > i4) {
                    break;
                }
                iArr[0] = i8 + 1;
                i6--;
            }
            if (iArr[0] > i4) {
                return Float.NaN;
            }
            int i9 = i2 + 1;
            while (i9 < iG && bVar.d(i3, i9)) {
                int i10 = iArr[1];
                if (i10 > i4) {
                    break;
                }
                iArr[1] = i10 + 1;
                i9++;
            }
            if (i9 != iG && iArr[1] <= i4) {
                while (i9 < iG && !bVar.d(i3, i9)) {
                    int i11 = iArr[2];
                    if (i11 > i4) {
                        break;
                    }
                    iArr[2] = i11 + 1;
                    i9++;
                }
                int i12 = iArr[2];
                if (i12 <= i4 && Math.abs(((iArr[0] + iArr[1]) + i12) - i5) * 5 < i5 * 2 && d(iArr)) {
                    return a(iArr, i9);
                }
            }
        }
        return Float.NaN;
    }

    private boolean d(int[] iArr) {
        float f2 = this.f989g;
        float f3 = f2 / 2.0f;
        for (int i2 = 0; i2 < 3; i2++) {
            if (Math.abs(f2 - iArr[i2]) >= f3) {
                return false;
            }
        }
        return true;
    }

    private a e(int[] iArr, int i2, int i3) {
        int i4 = iArr[0] + iArr[1] + iArr[2];
        float fA = a(iArr, i3);
        float fB = b(i2, (int) fA, iArr[1] * 2, i4);
        if (Float.isNaN(fB)) {
            return null;
        }
        float f2 = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
        for (a aVar : this.f985b) {
            if (aVar.f(f2, fB, fA)) {
                return aVar.g(fB, fA, f2);
            }
        }
        a aVar2 = new a(fA, fB, f2);
        this.f985b.add(aVar2);
        p pVar = this.f991i;
        if (pVar == null) {
            return null;
        }
        pVar.a(aVar2);
        return null;
    }

    a c() throws i {
        a aVarE;
        a aVarE2;
        int i2 = this.f986c;
        int i3 = this.f988f;
        int i4 = this.e + i2;
        int i5 = this.f987d + (i3 / 2);
        int[] iArr = new int[3];
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = ((i6 & 1) == 0 ? (i6 + 1) / 2 : -((i6 + 1) / 2)) + i5;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i8 = i2;
            while (i8 < i4 && !this.f984a.d(i8, i7)) {
                i8++;
            }
            int i9 = 0;
            while (i8 < i4) {
                if (!this.f984a.d(i8, i7)) {
                    if (i9 == 1) {
                        i9++;
                    }
                    iArr[i9] = iArr[i9] + 1;
                } else if (i9 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i9 != 2) {
                    i9++;
                    iArr[i9] = iArr[i9] + 1;
                } else {
                    if (d(iArr) && (aVarE2 = e(iArr, i7, i8)) != null) {
                        return aVarE2;
                    }
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i9 = 1;
                }
                i8++;
            }
            if (d(iArr) && (aVarE = e(iArr, i7, i4)) != null) {
                return aVarE;
            }
        }
        if (this.f985b.isEmpty()) {
            throw i.a();
        }
        return (a) this.f985b.get(0);
    }
}
