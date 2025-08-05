package a0;

import android.graphics.Path;
import b0.c;

/* loaded from: classes.dex */
abstract class m {

    /* renamed from: a */
    private static final c.a f1411a = c.a.a("nm", "g", "o", "t", "s", "e", "r", "hd");

    /* renamed from: b */
    private static final c.a f1412b = c.a.a("p", "k");

    static X.d a(b0.c cVar, Q.d dVar) {
        Path.FillType fillType = Path.FillType.WINDING;
        String strU = null;
        X.f fVar = null;
        W.c cVarG = null;
        W.d dVarH = null;
        W.f fVarI = null;
        W.f fVarI2 = null;
        boolean zQ = false;
        while (cVar.p()) {
            switch (cVar.y(f1411a)) {
                case 0:
                    strU = cVar.u();
                    break;
                case 1:
                    cVar.l();
                    int iS = -1;
                    while (cVar.p()) {
                        int iY = cVar.y(f1412b);
                        if (iY == 0) {
                            iS = cVar.s();
                        } else if (iY != 1) {
                            cVar.z();
                            cVar.A();
                        } else {
                            cVarG = AbstractC0119d.g(cVar, dVar, iS);
                        }
                    }
                    cVar.n();
                    break;
                case 2:
                    dVarH = AbstractC0119d.h(cVar, dVar);
                    break;
                case 3:
                    fVar = cVar.s() == 1 ? X.f.LINEAR : X.f.RADIAL;
                    break;
                case 4:
                    fVarI = AbstractC0119d.i(cVar, dVar);
                    break;
                case 5:
                    fVarI2 = AbstractC0119d.i(cVar, dVar);
                    break;
                case 6:
                    fillType = cVar.s() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case 7:
                    zQ = cVar.q();
                    break;
                default:
                    cVar.z();
                    cVar.A();
                    break;
            }
        }
        return new X.d(strU, fVar, fillType, cVarG, dVarH, fVarI, fVarI2, null, null, zQ);
    }
}
