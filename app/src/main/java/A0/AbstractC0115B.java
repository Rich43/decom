package a0;

import b0.c;

/* renamed from: a0.B, reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract class AbstractC0115B {

    /* renamed from: a, reason: collision with root package name */
    private static c.a f1386a = c.a.a("nm", "c", "o", "tr", "hd");

    static X.k a(b0.c cVar, Q.d dVar) {
        String strU = null;
        W.b bVarF = null;
        W.b bVarF2 = null;
        W.l lVarG = null;
        boolean zQ = false;
        while (cVar.p()) {
            int iY = cVar.y(f1386a);
            if (iY == 0) {
                strU = cVar.u();
            } else if (iY == 1) {
                bVarF = AbstractC0119d.f(cVar, dVar, false);
            } else if (iY == 2) {
                bVarF2 = AbstractC0119d.f(cVar, dVar, false);
            } else if (iY == 3) {
                lVarG = AbstractC0118c.g(cVar, dVar);
            } else if (iY != 4) {
                cVar.A();
            } else {
                zQ = cVar.q();
            }
        }
        return new X.k(strU, bVarF, bVarF2, lVarG, zQ);
    }
}
