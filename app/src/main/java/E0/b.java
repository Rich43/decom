package E0;

import z0.i;
import z0.o;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final D0.b f153a;

    /* renamed from: b, reason: collision with root package name */
    private final int f154b;

    /* renamed from: c, reason: collision with root package name */
    private final int f155c;

    /* renamed from: d, reason: collision with root package name */
    private final int f156d;
    private final int e;

    /* renamed from: f, reason: collision with root package name */
    private final int f157f;

    /* renamed from: g, reason: collision with root package name */
    private final int f158g;

    public b(D0.b bVar) {
        this(bVar, 10, bVar.j() / 2, bVar.g() / 2);
    }

    private o[] a(o oVar, o oVar2, o oVar3, o oVar4) {
        float fC = oVar.c();
        float fD = oVar.d();
        float fC2 = oVar2.c();
        float fD2 = oVar2.d();
        float fC3 = oVar3.c();
        float fD3 = oVar3.d();
        float fC4 = oVar4.c();
        float fD4 = oVar4.d();
        return fC < ((float) this.f155c) / 2.0f ? new o[]{new o(fC4 - 1.0f, fD4 + 1.0f), new o(fC2 + 1.0f, fD2 + 1.0f), new o(fC3 - 1.0f, fD3 - 1.0f), new o(fC + 1.0f, fD - 1.0f)} : new o[]{new o(fC4 + 1.0f, fD4 + 1.0f), new o(fC2 + 1.0f, fD2 - 1.0f), new o(fC3 - 1.0f, fD3 + 1.0f), new o(fC - 1.0f, fD - 1.0f)};
    }

    private boolean b(int i2, int i3, int i4, boolean z2) {
        if (z2) {
            while (i2 <= i3) {
                if (this.f153a.d(i2, i4)) {
                    return true;
                }
                i2++;
            }
            return false;
        }
        while (i2 <= i3) {
            if (this.f153a.d(i4, i2)) {
                return true;
            }
            i2++;
        }
        return false;
    }

    private o d(float f2, float f3, float f4, float f5) {
        int iC = a.c(a.a(f2, f3, f4, f5));
        float f6 = iC;
        float f7 = (f4 - f2) / f6;
        float f8 = (f5 - f3) / f6;
        for (int i2 = 0; i2 < iC; i2++) {
            float f9 = i2;
            int iC2 = a.c((f9 * f7) + f2);
            int iC3 = a.c((f9 * f8) + f3);
            if (this.f153a.d(iC2, iC3)) {
                return new o(iC2, iC3);
            }
        }
        return null;
    }

    public o[] c() throws i {
        int i2 = this.f156d;
        int i3 = this.e;
        int i4 = this.f158g;
        int i5 = this.f157f;
        boolean z2 = false;
        boolean z3 = true;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        while (z3) {
            boolean zB = true;
            boolean z9 = false;
            while (true) {
                if ((!zB && z4) || i3 >= this.f155c) {
                    break;
                }
                zB = b(i4, i5, i3, false);
                if (zB) {
                    i3++;
                    z4 = true;
                    z9 = true;
                } else if (!z4) {
                    i3++;
                }
            }
            if (i3 < this.f155c) {
                boolean zB2 = true;
                while (true) {
                    if ((!zB2 && z5) || i5 >= this.f154b) {
                        break;
                    }
                    zB2 = b(i2, i3, i5, true);
                    if (zB2) {
                        i5++;
                        z5 = true;
                        z9 = true;
                    } else if (!z5) {
                        i5++;
                    }
                }
                if (i5 < this.f154b) {
                    boolean zB3 = true;
                    while (true) {
                        if ((!zB3 && z6) || i2 < 0) {
                            break;
                        }
                        zB3 = b(i4, i5, i2, false);
                        if (zB3) {
                            i2--;
                            z6 = true;
                            z9 = true;
                        } else if (!z6) {
                            i2--;
                        }
                    }
                    if (i2 >= 0) {
                        z3 = z9;
                        boolean zB4 = true;
                        while (true) {
                            if ((!zB4 && z8) || i4 < 0) {
                                break;
                            }
                            zB4 = b(i2, i3, i4, true);
                            if (zB4) {
                                i4--;
                                z3 = true;
                                z8 = true;
                            } else if (!z8) {
                                i4--;
                            }
                        }
                        if (i4 >= 0) {
                            if (z3) {
                                z7 = true;
                            }
                        }
                    }
                }
            }
            z2 = true;
            break;
        }
        if (z2 || !z7) {
            throw i.a();
        }
        int i6 = i3 - i2;
        o oVarD = null;
        o oVarD2 = null;
        for (int i7 = 1; oVarD2 == null && i7 < i6; i7++) {
            oVarD2 = d(i2, i5 - i7, i2 + i7, i5);
        }
        if (oVarD2 == null) {
            throw i.a();
        }
        o oVarD3 = null;
        for (int i8 = 1; oVarD3 == null && i8 < i6; i8++) {
            oVarD3 = d(i2, i4 + i8, i2 + i8, i4);
        }
        if (oVarD3 == null) {
            throw i.a();
        }
        o oVarD4 = null;
        for (int i9 = 1; oVarD4 == null && i9 < i6; i9++) {
            oVarD4 = d(i3, i4 + i9, i3 - i9, i4);
        }
        if (oVarD4 == null) {
            throw i.a();
        }
        for (int i10 = 1; oVarD == null && i10 < i6; i10++) {
            oVarD = d(i3, i5 - i10, i3 - i10, i5);
        }
        if (oVarD != null) {
            return a(oVarD, oVarD2, oVarD4, oVarD3);
        }
        throw i.a();
    }

    public b(D0.b bVar, int i2, int i3, int i4) throws i {
        this.f153a = bVar;
        int iG = bVar.g();
        this.f154b = iG;
        int iJ = bVar.j();
        this.f155c = iJ;
        int i5 = i2 / 2;
        int i6 = i3 - i5;
        this.f156d = i6;
        int i7 = i3 + i5;
        this.e = i7;
        int i8 = i4 - i5;
        this.f158g = i8;
        int i9 = i4 + i5;
        this.f157f = i9;
        if (i8 < 0 || i6 < 0 || i9 >= iG || i7 >= iJ) {
            throw i.a();
        }
    }
}
