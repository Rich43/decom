package Q0;

import z0.o;

/* loaded from: classes.dex */
final class h extends g {

    /* renamed from: c, reason: collision with root package name */
    private final boolean f717c;

    h(c cVar, boolean z2) {
        super(cVar);
        this.f717c = z2;
    }

    private void h(a aVar) {
        c cVarA = a();
        o oVarH = this.f717c ? cVarA.h() : cVarA.i();
        o oVarB = this.f717c ? cVarA.b() : cVarA.c();
        int iE = e((int) oVarB.d());
        d[] dVarArrD = d();
        int iC = -1;
        int i2 = 0;
        int iMax = 1;
        for (int iE2 = e((int) oVarH.d()); iE2 < iE; iE2++) {
            d dVar = dVarArrD[iE2];
            if (dVar != null) {
                dVar.j();
                int iC2 = dVar.c() - iC;
                if (iC2 == 0) {
                    i2++;
                } else {
                    if (iC2 == 1) {
                        iMax = Math.max(iMax, i2);
                        iC = dVar.c();
                    } else if (dVar.c() >= aVar.c()) {
                        dVarArrD[iE2] = null;
                    } else {
                        iC = dVar.c();
                    }
                    i2 = 1;
                }
            }
        }
    }

    private void l(d[] dVarArr, a aVar) {
        for (int i2 = 0; i2 < dVarArr.length; i2++) {
            d dVar = dVarArr[i2];
            if (dVar != null) {
                int iE = dVar.e() % 30;
                int iC = dVar.c();
                if (iC > aVar.c()) {
                    dVarArr[i2] = null;
                } else {
                    if (!this.f717c) {
                        iC += 2;
                    }
                    int i3 = iC % 3;
                    if (i3 != 0) {
                        if (i3 != 1) {
                            if (i3 == 2 && iE + 1 != aVar.a()) {
                                dVarArr[i2] = null;
                            }
                        } else if (iE / 3 != aVar.b() || iE % 3 != aVar.d()) {
                            dVarArr[i2] = null;
                        }
                    } else if ((iE * 3) + 1 != aVar.e()) {
                        dVarArr[i2] = null;
                    }
                }
            }
        }
    }

    private void m() {
        for (d dVar : d()) {
            if (dVar != null) {
                dVar.j();
            }
        }
    }

    void g(a aVar) {
        d[] dVarArrD = d();
        m();
        l(dVarArrD, aVar);
        c cVarA = a();
        o oVarH = this.f717c ? cVarA.h() : cVarA.i();
        o oVarB = this.f717c ? cVarA.b() : cVarA.c();
        int iE = e((int) oVarH.d());
        int iE2 = e((int) oVarB.d());
        int iC = -1;
        int i2 = 0;
        int iMax = 1;
        while (iE < iE2) {
            d dVar = dVarArrD[iE];
            if (dVar != null) {
                int iC2 = dVar.c() - iC;
                if (iC2 == 0) {
                    i2++;
                } else {
                    if (iC2 == 1) {
                        iMax = Math.max(iMax, i2);
                        iC = dVar.c();
                    } else if (iC2 < 0 || dVar.c() >= aVar.c() || iC2 > iE) {
                        dVarArrD[iE] = null;
                    } else {
                        if (iMax > 2) {
                            iC2 *= iMax - 2;
                        }
                        boolean z2 = iC2 >= iE;
                        for (int i3 = 1; i3 <= iC2 && !z2; i3++) {
                            z2 = dVarArrD[iE - i3] != null;
                        }
                        if (z2) {
                            dVarArrD[iE] = null;
                        } else {
                            iC = dVar.c();
                        }
                    }
                    i2 = 1;
                }
            }
            iE++;
        }
    }

    a i() {
        d[] dVarArrD = d();
        b bVar = new b();
        b bVar2 = new b();
        b bVar3 = new b();
        b bVar4 = new b();
        for (d dVar : dVarArrD) {
            if (dVar != null) {
                dVar.j();
                int iE = dVar.e() % 30;
                int iC = dVar.c();
                if (!this.f717c) {
                    iC += 2;
                }
                int i2 = iC % 3;
                if (i2 == 0) {
                    bVar2.b((iE * 3) + 1);
                } else if (i2 == 1) {
                    bVar4.b(iE / 3);
                    bVar3.b(iE % 3);
                } else if (i2 == 2) {
                    bVar.b(iE + 1);
                }
            }
        }
        if (bVar.a().length == 0 || bVar2.a().length == 0 || bVar3.a().length == 0 || bVar4.a().length == 0 || bVar.a()[0] <= 0 || bVar2.a()[0] + bVar3.a()[0] < 3 || bVar2.a()[0] + bVar3.a()[0] > 90) {
            return null;
        }
        a aVar = new a(bVar.a()[0], bVar2.a()[0], bVar3.a()[0], bVar4.a()[0]);
        l(dVarArrD, aVar);
        return aVar;
    }

    int[] j() {
        int iC;
        a aVarI = i();
        if (aVarI == null) {
            return null;
        }
        h(aVarI);
        int iC2 = aVarI.c();
        int[] iArr = new int[iC2];
        for (d dVar : d()) {
            if (dVar != null && (iC = dVar.c()) < iC2) {
                iArr[iC] = iArr[iC] + 1;
            }
        }
        return iArr;
    }

    boolean k() {
        return this.f717c;
    }

    @Override // Q0.g
    public String toString() {
        return "IsLeft: " + this.f717c + '\n' + super.toString();
    }
}
