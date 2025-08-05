package a0;

import b0.c;
import java.util.ArrayList;

/* renamed from: a0.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract class AbstractC0125j {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f1407a = c.a.a("ch", "size", "w", "style", "fFamily", "data");

    /* renamed from: b, reason: collision with root package name */
    private static final c.a f1408b = c.a.a("shapes");

    static V.d a(b0.c cVar, Q.d dVar) {
        ArrayList arrayList = new ArrayList();
        cVar.l();
        double dR = 0.0d;
        String strU = null;
        String strU2 = null;
        double dR2 = 0.0d;
        char cCharAt = 0;
        while (cVar.p()) {
            int iY = cVar.y(f1407a);
            if (iY == 0) {
                cCharAt = cVar.u().charAt(0);
            } else if (iY == 1) {
                dR2 = cVar.r();
            } else if (iY == 2) {
                dR = cVar.r();
            } else if (iY == 3) {
                strU = cVar.u();
            } else if (iY == 4) {
                strU2 = cVar.u();
            } else if (iY != 5) {
                cVar.z();
                cVar.A();
            } else {
                cVar.l();
                while (cVar.p()) {
                    if (cVar.y(f1408b) != 0) {
                        cVar.z();
                        cVar.A();
                    } else {
                        cVar.k();
                        while (cVar.p()) {
                            arrayList.add((X.n) AbstractC0122g.a(cVar, dVar));
                        }
                        cVar.m();
                    }
                }
                cVar.n();
            }
        }
        cVar.n();
        return new V.d(arrayList, cCharAt, dR2, dR, strU, strU2);
    }
}
