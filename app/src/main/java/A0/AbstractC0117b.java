package a0;

import b0.c;

/* renamed from: a0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0117b {

    /* renamed from: a, reason: collision with root package name */
    private static c.a f1397a = c.a.a("a");

    /* renamed from: b, reason: collision with root package name */
    private static c.a f1398b = c.a.a("fc", "sc", "sw", "t");

    public static W.k a(b0.c cVar, Q.d dVar) {
        cVar.l();
        W.k kVarB = null;
        while (cVar.p()) {
            if (cVar.y(f1397a) != 0) {
                cVar.z();
                cVar.A();
            } else {
                kVarB = b(cVar, dVar);
            }
        }
        cVar.n();
        return kVarB == null ? new W.k(null, null, null, null) : kVarB;
    }

    private static W.k b(b0.c cVar, Q.d dVar) {
        cVar.l();
        W.a aVarC = null;
        W.a aVarC2 = null;
        W.b bVarE = null;
        W.b bVarE2 = null;
        while (cVar.p()) {
            int iY = cVar.y(f1398b);
            if (iY == 0) {
                aVarC = AbstractC0119d.c(cVar, dVar);
            } else if (iY == 1) {
                aVarC2 = AbstractC0119d.c(cVar, dVar);
            } else if (iY == 2) {
                bVarE = AbstractC0119d.e(cVar, dVar);
            } else if (iY != 3) {
                cVar.z();
                cVar.A();
            } else {
                bVarE2 = AbstractC0119d.e(cVar, dVar);
            }
        }
        cVar.n();
        return new W.k(aVarC, aVarC2, bVarE, bVarE2);
    }
}
