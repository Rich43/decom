package a0;

import X.q;
import b0.c;

/* loaded from: classes.dex */
abstract class I {

    /* renamed from: a, reason: collision with root package name */
    private static c.a f1395a = c.a.a("s", "e", "o", "nm", "m", "hd");

    static X.q a(b0.c cVar, Q.d dVar) {
        String strU = null;
        q.a aVarA = null;
        W.b bVarF = null;
        W.b bVarF2 = null;
        W.b bVarF3 = null;
        boolean zQ = false;
        while (cVar.p()) {
            int iY = cVar.y(f1395a);
            if (iY == 0) {
                bVarF = AbstractC0119d.f(cVar, dVar, false);
            } else if (iY == 1) {
                bVarF2 = AbstractC0119d.f(cVar, dVar, false);
            } else if (iY == 2) {
                bVarF3 = AbstractC0119d.f(cVar, dVar, false);
            } else if (iY == 3) {
                strU = cVar.u();
            } else if (iY == 4) {
                aVarA = q.a.a(cVar.s());
            } else if (iY != 5) {
                cVar.A();
            } else {
                zQ = cVar.q();
            }
        }
        return new X.q(strU, aVarA, bVarF, bVarF2, bVarF3, zQ);
    }
}
