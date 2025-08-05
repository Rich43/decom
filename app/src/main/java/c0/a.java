package C0;

import D0.b;
import F0.c;
import F0.d;
import z0.i;
import z0.o;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: g, reason: collision with root package name */
    private static final int[] f41g = {3808, 476, 2107, 1799};

    /* renamed from: a, reason: collision with root package name */
    private final b f42a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f43b;

    /* renamed from: c, reason: collision with root package name */
    private int f44c;

    /* renamed from: d, reason: collision with root package name */
    private int f45d;
    private int e;

    /* renamed from: f, reason: collision with root package name */
    private int f46f;

    /* renamed from: C0.a$a, reason: collision with other inner class name */
    static final class C0003a {

        /* renamed from: a, reason: collision with root package name */
        private final int f47a;

        /* renamed from: b, reason: collision with root package name */
        private final int f48b;

        C0003a(int i2, int i3) {
            this.f47a = i2;
            this.f48b = i3;
        }

        int a() {
            return this.f47a;
        }

        int b() {
            return this.f48b;
        }

        o c() {
            return new o(a(), b());
        }

        public String toString() {
            return "<" + this.f47a + ' ' + this.f48b + '>';
        }
    }

    public a(b bVar) {
        this.f42a = bVar;
    }

    private static float b(C0003a c0003a, C0003a c0003a2) {
        return E0.a.b(c0003a.a(), c0003a.b(), c0003a2.a(), c0003a2.b());
    }

    private static float c(o oVar, o oVar2) {
        return E0.a.a(oVar.c(), oVar.d(), oVar2.c(), oVar2.d());
    }

    private static o[] d(o[] oVarArr, int i2, int i3) {
        float f2 = i3 / (i2 * 2.0f);
        float fC = oVarArr[0].c() - oVarArr[2].c();
        float fD = oVarArr[0].d() - oVarArr[2].d();
        float fC2 = (oVarArr[0].c() + oVarArr[2].c()) / 2.0f;
        float fD2 = (oVarArr[0].d() + oVarArr[2].d()) / 2.0f;
        float f3 = fC * f2;
        float f4 = fD * f2;
        o oVar = new o(fC2 + f3, fD2 + f4);
        o oVar2 = new o(fC2 - f3, fD2 - f4);
        float fC3 = oVarArr[1].c() - oVarArr[3].c();
        float fD3 = oVarArr[1].d() - oVarArr[3].d();
        float fC4 = (oVarArr[1].c() + oVarArr[3].c()) / 2.0f;
        float fD4 = (oVarArr[1].d() + oVarArr[3].d()) / 2.0f;
        float f5 = fC3 * f2;
        float f6 = f2 * fD3;
        return new o[]{oVar, new o(fC4 + f5, fD4 + f6), oVar2, new o(fC4 - f5, fD4 - f6)};
    }

    private void e(o[] oVarArr) throws i {
        long j2;
        long j3;
        if (!o(oVarArr[0]) || !o(oVarArr[1]) || !o(oVarArr[2]) || !o(oVarArr[3])) {
            throw i.a();
        }
        int i2 = this.e * 2;
        int[] iArr = {r(oVarArr[0], oVarArr[1], i2), r(oVarArr[1], oVarArr[2], i2), r(oVarArr[2], oVarArr[3], i2), r(oVarArr[3], oVarArr[0], i2)};
        this.f46f = m(iArr, i2);
        long j4 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            int i4 = iArr[(this.f46f + i3) % 4];
            if (this.f43b) {
                j2 = j4 << 7;
                j3 = (i4 >> 1) & 127;
            } else {
                j2 = j4 << 10;
                j3 = ((i4 >> 2) & 992) + ((i4 >> 1) & 31);
            }
            j4 = j2 + j3;
        }
        int iH = h(j4, this.f43b);
        if (this.f43b) {
            this.f44c = (iH >> 6) + 1;
            this.f45d = (iH & 63) + 1;
        } else {
            this.f44c = (iH >> 11) + 1;
            this.f45d = (iH & 2047) + 1;
        }
    }

    private o[] f(C0003a c0003a) throws i {
        this.e = 1;
        C0003a c0003a2 = c0003a;
        C0003a c0003a3 = c0003a2;
        C0003a c0003a4 = c0003a3;
        C0003a c0003a5 = c0003a4;
        boolean z2 = true;
        while (this.e < 9) {
            C0003a c0003aJ = j(c0003a2, z2, 1, -1);
            C0003a c0003aJ2 = j(c0003a3, z2, 1, 1);
            C0003a c0003aJ3 = j(c0003a4, z2, -1, 1);
            C0003a c0003aJ4 = j(c0003a5, z2, -1, -1);
            if (this.e > 2) {
                double dB = (b(c0003aJ4, c0003aJ) * this.e) / (b(c0003a5, c0003a2) * (this.e + 2));
                if (dB < 0.75d || dB > 1.25d || !p(c0003aJ, c0003aJ2, c0003aJ3, c0003aJ4)) {
                    break;
                }
            }
            z2 = !z2;
            this.e++;
            c0003a5 = c0003aJ4;
            c0003a2 = c0003aJ;
            c0003a3 = c0003aJ2;
            c0003a4 = c0003aJ3;
        }
        int i2 = this.e;
        if (i2 != 5 && i2 != 7) {
            throw i.a();
        }
        this.f43b = i2 == 5;
        o[] oVarArr = {new o(c0003a2.a() + 0.5f, c0003a2.b() - 0.5f), new o(c0003a3.a() + 0.5f, c0003a3.b() + 0.5f), new o(c0003a4.a() - 0.5f, c0003a4.b() + 0.5f), new o(c0003a5.a() - 0.5f, c0003a5.b() - 0.5f)};
        int i3 = this.e;
        return d(oVarArr, (i3 * 2) - 3, i3 * 2);
    }

    private int g(C0003a c0003a, C0003a c0003a2) {
        float fB = b(c0003a, c0003a2);
        float fA = (c0003a2.a() - c0003a.a()) / fB;
        float fB2 = (c0003a2.b() - c0003a.b()) / fB;
        float fA2 = c0003a.a();
        float fB3 = c0003a.b();
        boolean zD = this.f42a.d(c0003a.a(), c0003a.b());
        int iCeil = (int) Math.ceil(fB);
        int i2 = 0;
        for (int i3 = 0; i3 < iCeil; i3++) {
            fA2 += fA;
            fB3 += fB2;
            if (this.f42a.d(E0.a.c(fA2), E0.a.c(fB3)) != zD) {
                i2++;
            }
        }
        float f2 = i2 / fB;
        if (f2 <= 0.1f || f2 >= 0.9f) {
            return (f2 <= 0.1f) == zD ? 1 : -1;
        }
        return 0;
    }

    private static int h(long j2, boolean z2) throws i {
        int i2;
        int i3;
        if (z2) {
            i2 = 7;
            i3 = 2;
        } else {
            i2 = 10;
            i3 = 4;
        }
        int i4 = i2 - i3;
        int[] iArr = new int[i2];
        for (int i5 = i2 - 1; i5 >= 0; i5--) {
            iArr[i5] = ((int) j2) & 15;
            j2 >>= 4;
        }
        try {
            new c(F0.a.f185k).a(iArr, i4);
            int i6 = 0;
            for (int i7 = 0; i7 < i3; i7++) {
                i6 = (i6 << 4) + iArr[i7];
            }
            return i6;
        } catch (d unused) {
            throw i.a();
        }
    }

    private int i() {
        if (this.f43b) {
            return (this.f44c * 4) + 11;
        }
        int i2 = this.f44c;
        return i2 <= 4 ? (i2 * 4) + 15 : (i2 * 4) + ((((i2 - 4) / 8) + 1) * 2) + 15;
    }

    private C0003a j(C0003a c0003a, boolean z2, int i2, int i3) {
        int iA = c0003a.a() + i2;
        int iB = c0003a.b();
        while (true) {
            iB += i3;
            if (!n(iA, iB) || this.f42a.d(iA, iB) != z2) {
                break;
            }
            iA += i2;
        }
        int i4 = iA - i2;
        int i5 = iB - i3;
        while (n(i4, i5) && this.f42a.d(i4, i5) == z2) {
            i4 += i2;
        }
        int i6 = i4 - i2;
        while (n(i6, i5) && this.f42a.d(i6, i5) == z2) {
            i5 += i3;
        }
        return new C0003a(i6, i5 - i3);
    }

    private C0003a k() {
        o oVarC;
        o oVar;
        o oVar2;
        o oVar3;
        o oVarC2;
        o oVarC3;
        o oVarC4;
        o oVarC5;
        try {
            o[] oVarArrC = new E0.b(this.f42a).c();
            oVar2 = oVarArrC[0];
            oVar3 = oVarArrC[1];
            oVar = oVarArrC[2];
            oVarC = oVarArrC[3];
        } catch (i unused) {
            int iJ = this.f42a.j() / 2;
            int iG = this.f42a.g() / 2;
            int i2 = iJ + 7;
            int i3 = iG - 7;
            o oVarC6 = j(new C0003a(i2, i3), false, 1, -1).c();
            int i4 = iG + 7;
            o oVarC7 = j(new C0003a(i2, i4), false, 1, 1).c();
            int i5 = iJ - 7;
            o oVarC8 = j(new C0003a(i5, i4), false, -1, 1).c();
            oVarC = j(new C0003a(i5, i3), false, -1, -1).c();
            oVar = oVarC8;
            oVar2 = oVarC6;
            oVar3 = oVarC7;
        }
        int iC = E0.a.c((((oVar2.c() + oVarC.c()) + oVar3.c()) + oVar.c()) / 4.0f);
        int iC2 = E0.a.c((((oVar2.d() + oVarC.d()) + oVar3.d()) + oVar.d()) / 4.0f);
        try {
            o[] oVarArrC2 = new E0.b(this.f42a, 15, iC, iC2).c();
            oVarC2 = oVarArrC2[0];
            oVarC3 = oVarArrC2[1];
            oVarC4 = oVarArrC2[2];
            oVarC5 = oVarArrC2[3];
        } catch (i unused2) {
            int i6 = iC + 7;
            int i7 = iC2 - 7;
            oVarC2 = j(new C0003a(i6, i7), false, 1, -1).c();
            int i8 = iC2 + 7;
            oVarC3 = j(new C0003a(i6, i8), false, 1, 1).c();
            int i9 = iC - 7;
            oVarC4 = j(new C0003a(i9, i8), false, -1, 1).c();
            oVarC5 = j(new C0003a(i9, i7), false, -1, -1).c();
        }
        return new C0003a(E0.a.c((((oVarC2.c() + oVarC5.c()) + oVarC3.c()) + oVarC4.c()) / 4.0f), E0.a.c((((oVarC2.d() + oVarC5.d()) + oVarC3.d()) + oVarC4.d()) / 4.0f));
    }

    private o[] l(o[] oVarArr) {
        return d(oVarArr, this.e * 2, i());
    }

    private static int m(int[] iArr, int i2) throws i {
        int i3 = 0;
        for (int i4 : iArr) {
            i3 = (i3 << 3) + ((i4 >> (i2 - 2)) << 1) + (i4 & 1);
        }
        int i5 = ((i3 & 1) << 11) + (i3 >> 1);
        for (int i6 = 0; i6 < 4; i6++) {
            if (Integer.bitCount(f41g[i6] ^ i5) <= 2) {
                return i6;
            }
        }
        throw i.a();
    }

    private boolean n(int i2, int i3) {
        return i2 >= 0 && i2 < this.f42a.j() && i3 > 0 && i3 < this.f42a.g();
    }

    private boolean o(o oVar) {
        return n(E0.a.c(oVar.c()), E0.a.c(oVar.d()));
    }

    private boolean p(C0003a c0003a, C0003a c0003a2, C0003a c0003a3, C0003a c0003a4) {
        C0003a c0003a5 = new C0003a(c0003a.a() - 3, c0003a.b() + 3);
        C0003a c0003a6 = new C0003a(c0003a2.a() - 3, c0003a2.b() - 3);
        C0003a c0003a7 = new C0003a(c0003a3.a() + 3, c0003a3.b() - 3);
        C0003a c0003a8 = new C0003a(c0003a4.a() + 3, c0003a4.b() + 3);
        int iG = g(c0003a8, c0003a5);
        return iG != 0 && g(c0003a5, c0003a6) == iG && g(c0003a6, c0003a7) == iG && g(c0003a7, c0003a8) == iG;
    }

    private b q(b bVar, o oVar, o oVar2, o oVar3, o oVar4) {
        D0.i iVarB = D0.i.b();
        int i2 = i();
        float f2 = i2 / 2.0f;
        int i3 = this.e;
        float f3 = f2 - i3;
        float f4 = f2 + i3;
        return iVarB.c(bVar, i2, i2, f3, f3, f4, f3, f4, f4, f3, f4, oVar.c(), oVar.d(), oVar2.c(), oVar2.d(), oVar3.c(), oVar3.d(), oVar4.c(), oVar4.d());
    }

    private int r(o oVar, o oVar2, int i2) {
        float fC = c(oVar, oVar2);
        float f2 = fC / i2;
        float fC2 = oVar.c();
        float fD = oVar.d();
        float fC3 = ((oVar2.c() - oVar.c()) * f2) / fC;
        float fD2 = (f2 * (oVar2.d() - oVar.d())) / fC;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            float f3 = i4;
            if (this.f42a.d(E0.a.c((f3 * fC3) + fC2), E0.a.c((f3 * fD2) + fD))) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    public A0.a a(boolean z2) throws i {
        o[] oVarArrF = f(k());
        if (z2) {
            o oVar = oVarArrF[0];
            oVarArrF[0] = oVarArrF[2];
            oVarArrF[2] = oVar;
        }
        e(oVarArrF);
        b bVar = this.f42a;
        int i2 = this.f46f;
        return new A0.a(q(bVar, oVarArrF[i2 % 4], oVarArrF[(i2 + 1) % 4], oVarArrF[(i2 + 2) % 4], oVarArrF[(i2 + 3) % 4]), l(oVarArrF), this.f43b, this.f45d, this.f44c);
    }
}
