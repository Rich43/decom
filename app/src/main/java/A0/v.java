package a0;

import X.h;
import b0.c;

/* loaded from: classes.dex */
abstract class v {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f1430a = c.a.a("nm", "mm", "hd");

    static X.h a(b0.c cVar) {
        String strU = null;
        h.a aVarA = null;
        boolean zQ = false;
        while (cVar.p()) {
            int iY = cVar.y(f1430a);
            if (iY == 0) {
                strU = cVar.u();
            } else if (iY == 1) {
                aVarA = h.a.a(cVar.s());
            } else if (iY != 2) {
                cVar.z();
                cVar.A();
            } else {
                zQ = cVar.q();
            }
        }
        return new X.h(strU, aVarA, zQ);
    }
}
