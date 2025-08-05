package a0;

import android.graphics.Path;
import b0.c;

/* loaded from: classes.dex */
abstract class E {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f1390a = c.a.a("nm", "c", "o", "fillEnabled", "r", "hd");

    static X.m a(b0.c cVar, Q.d dVar) {
        String strU = null;
        W.a aVarC = null;
        W.d dVarH = null;
        int iS = 1;
        boolean zQ = false;
        boolean zQ2 = false;
        while (cVar.p()) {
            int iY = cVar.y(f1390a);
            if (iY == 0) {
                strU = cVar.u();
            } else if (iY == 1) {
                aVarC = AbstractC0119d.c(cVar, dVar);
            } else if (iY == 2) {
                dVarH = AbstractC0119d.h(cVar, dVar);
            } else if (iY == 3) {
                zQ = cVar.q();
            } else if (iY == 4) {
                iS = cVar.s();
            } else if (iY != 5) {
                cVar.z();
                cVar.A();
            } else {
                zQ2 = cVar.q();
            }
        }
        return new X.m(strU, zQ, iS == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, aVarC, dVarH, zQ2);
    }
}
