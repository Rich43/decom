package a0;

import b0.c;

/* loaded from: classes.dex */
abstract class G {

    /* renamed from: a, reason: collision with root package name */
    static c.a f1392a = c.a.a("nm", "ind", "ks", "hd");

    static X.o a(b0.c cVar, Q.d dVar) {
        String strU = null;
        W.h hVarK = null;
        int iS = 0;
        boolean zQ = false;
        while (cVar.p()) {
            int iY = cVar.y(f1392a);
            if (iY == 0) {
                strU = cVar.u();
            } else if (iY == 1) {
                iS = cVar.s();
            } else if (iY == 2) {
                hVarK = AbstractC0119d.k(cVar, dVar);
            } else if (iY != 3) {
                cVar.A();
            } else {
                zQ = cVar.q();
            }
        }
        return new X.o(strU, iS, hVarK, zQ);
    }
}
