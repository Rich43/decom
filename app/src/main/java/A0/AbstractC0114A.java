package a0;

import b0.c;

/* renamed from: a0.A, reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract class AbstractC0114A {

    /* renamed from: a, reason: collision with root package name */
    private static c.a f1385a = c.a.a("nm", "p", "s", "r", "hd");

    static X.j a(b0.c cVar, Q.d dVar) {
        String strU = null;
        W.m mVarB = null;
        W.f fVarI = null;
        W.b bVarE = null;
        boolean zQ = false;
        while (cVar.p()) {
            int iY = cVar.y(f1385a);
            if (iY == 0) {
                strU = cVar.u();
            } else if (iY == 1) {
                mVarB = AbstractC0116a.b(cVar, dVar);
            } else if (iY == 2) {
                fVarI = AbstractC0119d.i(cVar, dVar);
            } else if (iY == 3) {
                bVarE = AbstractC0119d.e(cVar, dVar);
            } else if (iY != 4) {
                cVar.A();
            } else {
                zQ = cVar.q();
            }
        }
        return new X.j(strU, mVarB, fVarI, bVarE, zQ);
    }
}
