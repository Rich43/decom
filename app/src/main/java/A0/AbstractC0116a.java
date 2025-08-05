package a0;

import b0.c;
import d0.C0244a;
import java.util.ArrayList;

/* renamed from: a0.a */
/* loaded from: classes.dex */
public abstract class AbstractC0116a {

    /* renamed from: a */
    private static c.a f1396a = c.a.a("k", "x", "y");

    public static W.e a(b0.c cVar, Q.d dVar) {
        ArrayList arrayList = new ArrayList();
        if (cVar.w() == c.b.BEGIN_ARRAY) {
            cVar.k();
            while (cVar.p()) {
                arrayList.add(w.a(cVar, dVar));
            }
            cVar.m();
            r.b(arrayList);
        } else {
            arrayList.add(new C0244a(p.e(cVar, c0.j.e())));
        }
        return new W.e(arrayList);
    }

    static W.m b(b0.c cVar, Q.d dVar) {
        cVar.l();
        W.e eVarA = null;
        W.b bVarE = null;
        W.b bVarE2 = null;
        boolean z2 = false;
        while (cVar.w() != c.b.END_OBJECT) {
            int iY = cVar.y(f1396a);
            if (iY == 0) {
                eVarA = a(cVar, dVar);
            } else if (iY != 1) {
                if (iY != 2) {
                    cVar.z();
                    cVar.A();
                } else if (cVar.w() == c.b.STRING) {
                    cVar.A();
                    z2 = true;
                } else {
                    bVarE2 = AbstractC0119d.e(cVar, dVar);
                }
            } else if (cVar.w() == c.b.STRING) {
                cVar.A();
                z2 = true;
            } else {
                bVarE = AbstractC0119d.e(cVar, dVar);
            }
        }
        cVar.n();
        if (z2) {
            dVar.a("Lottie doesn't support expressions.");
        }
        return eVarA != null ? eVarA : new W.i(bVarE, bVarE2);
    }
}
