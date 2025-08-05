package a0;

import X.i;
import b0.c;

/* loaded from: classes.dex */
abstract class z {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f1433a = c.a.a("nm", "sy", "pt", "p", "r", "or", "os", "ir", "is", "hd");

    static X.i a(b0.c cVar, Q.d dVar) {
        String strU = null;
        i.a aVarA = null;
        W.b bVarF = null;
        W.m mVarB = null;
        W.b bVarF2 = null;
        W.b bVarE = null;
        W.b bVarE2 = null;
        W.b bVarF3 = null;
        W.b bVarF4 = null;
        boolean zQ = false;
        while (cVar.p()) {
            switch (cVar.y(f1433a)) {
                case 0:
                    strU = cVar.u();
                    break;
                case 1:
                    aVarA = i.a.a(cVar.s());
                    break;
                case 2:
                    bVarF = AbstractC0119d.f(cVar, dVar, false);
                    break;
                case 3:
                    mVarB = AbstractC0116a.b(cVar, dVar);
                    break;
                case 4:
                    bVarF2 = AbstractC0119d.f(cVar, dVar, false);
                    break;
                case 5:
                    bVarE2 = AbstractC0119d.e(cVar, dVar);
                    break;
                case 6:
                    bVarF4 = AbstractC0119d.f(cVar, dVar, false);
                    break;
                case 7:
                    bVarE = AbstractC0119d.e(cVar, dVar);
                    break;
                case 8:
                    bVarF3 = AbstractC0119d.f(cVar, dVar, false);
                    break;
                case 9:
                    zQ = cVar.q();
                    break;
                default:
                    cVar.z();
                    cVar.A();
                    break;
            }
        }
        return new X.i(strU, aVarA, bVarF, mVarB, bVarF2, bVarE, bVarE2, bVarF3, bVarF4, zQ);
    }
}
