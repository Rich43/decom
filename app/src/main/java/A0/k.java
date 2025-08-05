package a0;

import b0.c;

/* loaded from: classes.dex */
abstract class k {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f1409a = c.a.a("fFamily", "fName", "fStyle", "ascent");

    static V.c a(b0.c cVar) {
        cVar.l();
        String strU = null;
        String strU2 = null;
        String strU3 = null;
        float fR = 0.0f;
        while (cVar.p()) {
            int iY = cVar.y(f1409a);
            if (iY == 0) {
                strU = cVar.u();
            } else if (iY == 1) {
                strU2 = cVar.u();
            } else if (iY == 2) {
                strU3 = cVar.u();
            } else if (iY != 3) {
                cVar.z();
                cVar.A();
            } else {
                fR = (float) cVar.r();
            }
        }
        cVar.n();
        return new V.c(strU, strU2, strU3, fR);
    }
}
