package V0;

import D0.g;
import D0.k;
import U0.j;
import java.util.Map;
import z0.C0384f;
import z0.EnumC0383e;
import z0.i;
import z0.o;
import z0.p;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final D0.b f992a;

    /* renamed from: b, reason: collision with root package name */
    private p f993b;

    public c(D0.b bVar) {
        this.f992a = bVar;
    }

    private float b(o oVar, o oVar2) {
        float fJ = j((int) oVar.c(), (int) oVar.d(), (int) oVar2.c(), (int) oVar2.d());
        float fJ2 = j((int) oVar2.c(), (int) oVar2.d(), (int) oVar.c(), (int) oVar.d());
        return Float.isNaN(fJ) ? fJ2 / 7.0f : Float.isNaN(fJ2) ? fJ / 7.0f : (fJ + fJ2) / 14.0f;
    }

    private static int c(o oVar, o oVar2, o oVar3, float f2) throws i {
        int iC = (E0.a.c(o.b(oVar, oVar2) / f2) + E0.a.c(o.b(oVar, oVar3) / f2)) / 2;
        int i2 = iC + 7;
        int i3 = i2 & 3;
        if (i3 == 0) {
            return iC + 8;
        }
        if (i3 == 2) {
            return iC + 6;
        }
        if (i3 != 3) {
            return i2;
        }
        throw i.a();
    }

    private static k d(o oVar, o oVar2, o oVar3, o oVar4, int i2) {
        float fC;
        float fD;
        float f2;
        float f3 = i2 - 3.5f;
        if (oVar4 != null) {
            fC = oVar4.c();
            fD = oVar4.d();
            f2 = f3 - 3.0f;
        } else {
            fC = (oVar2.c() - oVar.c()) + oVar3.c();
            fD = (oVar2.d() - oVar.d()) + oVar3.d();
            f2 = f3;
        }
        return k.b(3.5f, 3.5f, f3, 3.5f, f2, f2, 3.5f, f3, oVar.c(), oVar.d(), oVar2.c(), oVar2.d(), fC, fD, oVar3.c(), oVar3.d());
    }

    private static D0.b h(D0.b bVar, k kVar, int i2) {
        return D0.i.b().d(bVar, i2, i2, kVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0087, code lost:
    
        if (r15 != 2) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x008f, code lost:
    
        return E0.a.b(r19, r6, r1, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0090, code lost:
    
        return Float.NaN;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float i(int r18, int r19, int r20, int r21) {
        /*
            r17 = this;
            int r0 = r21 - r19
            int r0 = java.lang.Math.abs(r0)
            int r1 = r20 - r18
            int r1 = java.lang.Math.abs(r1)
            r3 = 1
            if (r0 <= r1) goto L11
            r0 = 1
            goto L12
        L11:
            r0 = 0
        L12:
            if (r0 == 0) goto L1d
            r4 = r18
            r1 = r19
            r6 = r20
            r5 = r21
            goto L25
        L1d:
            r1 = r18
            r4 = r19
            r5 = r20
            r6 = r21
        L25:
            int r7 = r5 - r1
            int r7 = java.lang.Math.abs(r7)
            int r8 = r6 - r4
            int r8 = java.lang.Math.abs(r8)
            int r9 = -r7
            r10 = 2
            int r9 = r9 / r10
            r11 = -1
            if (r1 >= r5) goto L39
            r12 = 1
            goto L3a
        L39:
            r12 = -1
        L3a:
            if (r4 >= r6) goto L3d
            r11 = 1
        L3d:
            int r5 = r5 + r12
            r13 = r1
            r14 = r4
            r15 = 0
        L41:
            if (r13 == r5) goto L82
            if (r0 == 0) goto L47
            r2 = r14
            goto L48
        L47:
            r2 = r13
        L48:
            if (r0 == 0) goto L4c
            r10 = r13
            goto L4d
        L4c:
            r10 = r14
        L4d:
            if (r15 != r3) goto L57
            r3 = r17
            r16 = r0
            r19 = r5
            r0 = 1
            goto L5e
        L57:
            r3 = r17
            r16 = r0
            r19 = r5
            r0 = 0
        L5e:
            D0.b r5 = r3.f992a
            boolean r2 = r5.d(r2, r10)
            if (r0 != r2) goto L70
            r0 = 2
            if (r15 != r0) goto L6e
            float r0 = E0.a.b(r13, r14, r1, r4)
            return r0
        L6e:
            int r15 = r15 + 1
        L70:
            int r9 = r9 + r8
            if (r9 <= 0) goto L7a
            if (r14 == r6) goto L78
            int r14 = r14 + r11
            int r9 = r9 - r7
            goto L7a
        L78:
            r0 = 2
            goto L87
        L7a:
            int r13 = r13 + r12
            r5 = r19
            r0 = r16
            r3 = 1
            r10 = 2
            goto L41
        L82:
            r3 = r17
            r19 = r5
            goto L78
        L87:
            if (r15 != r0) goto L90
            r5 = r19
            float r0 = E0.a.b(r5, r6, r1, r4)
            return r0
        L90:
            r0 = 2143289344(0x7fc00000, float:NaN)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: V0.c.i(int, int, int, int):float");
    }

    private float j(int i2, int i3, int i4, int i5) {
        float fJ;
        float fG;
        float fI = i(i2, i3, i4, i5);
        int iJ = i2 - (i4 - i2);
        int iG = 0;
        if (iJ < 0) {
            fJ = i2 / (i2 - iJ);
            iJ = 0;
        } else if (iJ >= this.f992a.j()) {
            fJ = ((this.f992a.j() - 1) - i2) / (iJ - i2);
            iJ = this.f992a.j() - 1;
        } else {
            fJ = 1.0f;
        }
        float f2 = i3;
        int i6 = (int) (f2 - ((i5 - i3) * fJ));
        if (i6 < 0) {
            fG = f2 / (i3 - i6);
        } else if (i6 >= this.f992a.g()) {
            fG = ((this.f992a.g() - 1) - i3) / (i6 - i3);
            iG = this.f992a.g() - 1;
        } else {
            iG = i6;
            fG = 1.0f;
        }
        return (fI + i(i2, i3, (int) (i2 + ((iJ - i2) * fG)), iG)) - 1.0f;
    }

    protected final float a(o oVar, o oVar2, o oVar3) {
        return (b(oVar, oVar2) + b(oVar, oVar3)) / 2.0f;
    }

    public final g e(Map map) {
        p pVar = map == null ? null : (p) map.get(EnumC0383e.NEED_RESULT_POINT_CALLBACK);
        this.f993b = pVar;
        return g(new e(this.f992a, pVar).f(map));
    }

    protected final a f(float f2, int i2, int i3, float f3) throws i {
        int i4 = (int) (f3 * f2);
        int iMax = Math.max(0, i2 - i4);
        int iMin = Math.min(this.f992a.j() - 1, i2 + i4) - iMax;
        float f4 = 3.0f * f2;
        if (iMin < f4) {
            throw i.a();
        }
        int iMax2 = Math.max(0, i3 - i4);
        int iMin2 = Math.min(this.f992a.g() - 1, i3 + i4) - iMax2;
        if (iMin2 >= f4) {
            return new b(this.f992a, iMax, iMax2, iMin, iMin2, f2, this.f993b).c();
        }
        throw i.a();
    }

    protected final g g(f fVar) throws C0384f, i {
        a aVarF;
        d dVarB = fVar.b();
        d dVarC = fVar.c();
        d dVarA = fVar.a();
        float fA = a(dVarB, dVarC, dVarA);
        if (fA < 1.0f) {
            throw i.a();
        }
        int iC = c(dVarB, dVarC, dVarA, fA);
        j jVarG = j.g(iC);
        int iE = jVarG.e() - 7;
        if (jVarG.d().length > 0) {
            float fC = (dVarC.c() - dVarB.c()) + dVarA.c();
            float fD = (dVarC.d() - dVarB.d()) + dVarA.d();
            float f2 = 1.0f - (3.0f / iE);
            int iC2 = (int) (dVarB.c() + ((fC - dVarB.c()) * f2));
            int iD = (int) (dVarB.d() + (f2 * (fD - dVarB.d())));
            for (int i2 = 4; i2 <= 16; i2 <<= 1) {
                try {
                    aVarF = f(fA, iC2, iD, i2);
                    break;
                } catch (i unused) {
                }
            }
            aVarF = null;
        } else {
            aVarF = null;
        }
        return new g(h(this.f992a, d(dVarB, dVarC, dVarA, aVarF, iC), iC), aVarF == null ? new o[]{dVarA, dVarB, dVarC} : new o[]{dVarA, dVarB, dVarC, aVarF});
    }
}
