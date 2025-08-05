package a0;

import b0.c;
import java.util.ArrayList;

/* loaded from: classes.dex */
abstract class F {

    /* renamed from: a */
    private static c.a f1391a = c.a.a("nm", "hd", "it");

    static X.n a(b0.c cVar, Q.d dVar) {
        ArrayList arrayList = new ArrayList();
        String strU = null;
        boolean zQ = false;
        while (cVar.p()) {
            int iY = cVar.y(f1391a);
            if (iY == 0) {
                strU = cVar.u();
            } else if (iY == 1) {
                zQ = cVar.q();
            } else if (iY != 2) {
                cVar.A();
            } else {
                cVar.k();
                while (cVar.p()) {
                    X.b bVarA = AbstractC0122g.a(cVar, dVar);
                    if (bVarA != null) {
                        arrayList.add(bVarA);
                    }
                }
                cVar.m();
            }
        }
        return new X.n(strU, arrayList, zQ);
    }
}
