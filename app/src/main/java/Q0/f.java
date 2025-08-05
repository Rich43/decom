package Q0;

import java.util.Formatter;

/* loaded from: classes.dex */
final class f {

    /* renamed from: a, reason: collision with root package name */
    private final a f711a;

    /* renamed from: b, reason: collision with root package name */
    private final g[] f712b;

    /* renamed from: c, reason: collision with root package name */
    private c f713c;

    /* renamed from: d, reason: collision with root package name */
    private final int f714d;

    f(a aVar, c cVar) {
        this.f711a = aVar;
        int iA = aVar.a();
        this.f714d = iA;
        this.f713c = cVar;
        this.f712b = new g[iA + 2];
    }

    private void a(g gVar) {
        if (gVar != null) {
            ((h) gVar).g(this.f711a);
        }
    }

    private static boolean b(d dVar, d dVar2) {
        if (dVar2 == null || !dVar2.g() || dVar2.a() != dVar.a()) {
            return false;
        }
        dVar.i(dVar2.c());
        return true;
    }

    private static int c(int i2, int i3, d dVar) {
        if (dVar == null || dVar.g()) {
            return i3;
        }
        if (!dVar.h(i2)) {
            return i3 + 1;
        }
        dVar.i(i2);
        return 0;
    }

    private int d() {
        int iF = f();
        if (iF == 0) {
            return 0;
        }
        for (int i2 = 1; i2 < this.f714d + 1; i2++) {
            d[] dVarArrD = this.f712b[i2].d();
            for (int i3 = 0; i3 < dVarArrD.length; i3++) {
                d dVar = dVarArrD[i3];
                if (dVar != null && !dVar.g()) {
                    e(i2, i3, dVarArrD);
                }
            }
        }
        return iF;
    }

    private void e(int i2, int i3, d[] dVarArr) {
        d dVar = dVarArr[i3];
        d[] dVarArrD = this.f712b[i2 - 1].d();
        g gVar = this.f712b[i2 + 1];
        d[] dVarArrD2 = gVar != null ? gVar.d() : dVarArrD;
        d[] dVarArr2 = new d[14];
        dVarArr2[2] = dVarArrD[i3];
        dVarArr2[3] = dVarArrD2[i3];
        if (i3 > 0) {
            int i4 = i3 - 1;
            dVarArr2[0] = dVarArr[i4];
            dVarArr2[4] = dVarArrD[i4];
            dVarArr2[5] = dVarArrD2[i4];
        }
        if (i3 > 1) {
            int i5 = i3 - 2;
            dVarArr2[8] = dVarArr[i5];
            dVarArr2[10] = dVarArrD[i5];
            dVarArr2[11] = dVarArrD2[i5];
        }
        if (i3 < dVarArr.length - 1) {
            int i6 = i3 + 1;
            dVarArr2[1] = dVarArr[i6];
            dVarArr2[6] = dVarArrD[i6];
            dVarArr2[7] = dVarArrD2[i6];
        }
        if (i3 < dVarArr.length - 2) {
            int i7 = i3 + 2;
            dVarArr2[9] = dVarArr[i7];
            dVarArr2[12] = dVarArrD[i7];
            dVarArr2[13] = dVarArrD2[i7];
        }
        for (int i8 = 0; i8 < 14 && !b(dVar, dVarArr2[i8]); i8++) {
        }
    }

    private int f() {
        g();
        return h() + i();
    }

    private void g() {
        g[] gVarArr = this.f712b;
        g gVar = gVarArr[0];
        if (gVar == null || gVarArr[this.f714d + 1] == null) {
            return;
        }
        d[] dVarArrD = gVar.d();
        d[] dVarArrD2 = this.f712b[this.f714d + 1].d();
        for (int i2 = 0; i2 < dVarArrD.length; i2++) {
            d dVar = dVarArrD[i2];
            if (dVar != null && dVarArrD2[i2] != null && dVar.c() == dVarArrD2[i2].c()) {
                for (int i3 = 1; i3 <= this.f714d; i3++) {
                    d dVar2 = this.f712b[i3].d()[i2];
                    if (dVar2 != null) {
                        dVar2.i(dVarArrD[i2].c());
                        if (!dVar2.g()) {
                            this.f712b[i3].d()[i2] = null;
                        }
                    }
                }
            }
        }
    }

    private int h() {
        g gVar = this.f712b[0];
        if (gVar == null) {
            return 0;
        }
        d[] dVarArrD = gVar.d();
        int i2 = 0;
        for (int i3 = 0; i3 < dVarArrD.length; i3++) {
            d dVar = dVarArrD[i3];
            if (dVar != null) {
                int iC = dVar.c();
                int iC2 = 0;
                for (int i4 = 1; i4 < this.f714d + 1 && iC2 < 2; i4++) {
                    d dVar2 = this.f712b[i4].d()[i3];
                    if (dVar2 != null) {
                        iC2 = c(iC, iC2, dVar2);
                        if (!dVar2.g()) {
                            i2++;
                        }
                    }
                }
            }
        }
        return i2;
    }

    private int i() {
        g[] gVarArr = this.f712b;
        int i2 = this.f714d;
        if (gVarArr[i2 + 1] == null) {
            return 0;
        }
        d[] dVarArrD = gVarArr[i2 + 1].d();
        int i3 = 0;
        for (int i4 = 0; i4 < dVarArrD.length; i4++) {
            d dVar = dVarArrD[i4];
            if (dVar != null) {
                int iC = dVar.c();
                int iC2 = 0;
                for (int i5 = this.f714d + 1; i5 > 0 && iC2 < 2; i5--) {
                    d dVar2 = this.f712b[i5].d()[i4];
                    if (dVar2 != null) {
                        iC2 = c(iC, iC2, dVar2);
                        if (!dVar2.g()) {
                            i3++;
                        }
                    }
                }
            }
        }
        return i3;
    }

    int j() {
        return this.f714d;
    }

    int k() {
        return this.f711a.b();
    }

    int l() {
        return this.f711a.c();
    }

    c m() {
        return this.f713c;
    }

    g n(int i2) {
        return this.f712b[i2];
    }

    g[] o() {
        a(this.f712b[0]);
        a(this.f712b[this.f714d + 1]);
        int i2 = 928;
        while (true) {
            int iD = d();
            if (iD <= 0 || iD >= i2) {
                break;
            }
            i2 = iD;
        }
        return this.f712b;
    }

    void p(c cVar) {
        this.f713c = cVar;
    }

    void q(int i2, g gVar) {
        this.f712b[i2] = gVar;
    }

    public String toString() {
        g[] gVarArr = this.f712b;
        g gVar = gVarArr[0];
        if (gVar == null) {
            gVar = gVarArr[this.f714d + 1];
        }
        Formatter formatter = new Formatter();
        for (int i2 = 0; i2 < gVar.d().length; i2++) {
            try {
                formatter.format("CW %3d:", Integer.valueOf(i2));
                for (int i3 = 0; i3 < this.f714d + 2; i3++) {
                    g gVar2 = this.f712b[i3];
                    if (gVar2 == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        d dVar = gVar2.d()[i2];
                        if (dVar == null) {
                            formatter.format("    |   ", new Object[0]);
                        } else {
                            formatter.format(" %3d|%3d", Integer.valueOf(dVar.c()), Integer.valueOf(dVar.e()));
                        }
                    }
                }
                formatter.format("%n", new Object[0]);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        formatter.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        }
        String string = formatter.toString();
        formatter.close();
        return string;
    }
}
