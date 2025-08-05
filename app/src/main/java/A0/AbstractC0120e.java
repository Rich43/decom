package a0;

import b0.c;

/* renamed from: a0.e */
/* loaded from: classes.dex */
abstract class AbstractC0120e {

    /* renamed from: a */
    private static c.a f1401a = c.a.a("nm", "p", "s", "hd", "d");

    static X.a a(b0.c cVar, Q.d dVar, int i2) {
        boolean z2 = i2 == 3;
        String strU = null;
        W.m mVarB = null;
        W.f fVarI = null;
        boolean zQ = false;
        while (cVar.p()) {
            int iY = cVar.y(f1401a);
            if (iY == 0) {
                strU = cVar.u();
            } else if (iY == 1) {
                mVarB = AbstractC0116a.b(cVar, dVar);
            } else if (iY == 2) {
                fVarI = AbstractC0119d.i(cVar, dVar);
            } else if (iY == 3) {
                zQ = cVar.q();
            } else if (iY != 4) {
                cVar.z();
                cVar.A();
            } else {
                z2 = cVar.s() == 3;
            }
        }
        return new X.a(strU, mVarB, fVarI, z2, zQ);
    }
}
