package a0;

import X.p;
import b0.c;
import java.util.ArrayList;

/* loaded from: classes.dex */
abstract class n {

    /* renamed from: a */
    private static c.a f1413a = c.a.a("nm", "g", "o", "t", "s", "e", "w", "lc", "lj", "ml", "hd", "d");

    /* renamed from: b */
    private static final c.a f1414b = c.a.a("p", "k");

    /* renamed from: c */
    private static final c.a f1415c = c.a.a("n", "v");

    static X.e a(b0.c cVar, Q.d dVar) {
        String str;
        W.c cVar2;
        ArrayList arrayList = new ArrayList();
        String strU = null;
        X.f fVar = null;
        W.c cVarG = null;
        W.d dVarH = null;
        W.f fVarI = null;
        W.f fVarI2 = null;
        W.b bVarE = null;
        p.b bVar = null;
        p.c cVar3 = null;
        float fR = 0.0f;
        W.b bVar2 = null;
        boolean zQ = false;
        while (cVar.p()) {
            switch (cVar.y(f1413a)) {
                case 0:
                    strU = cVar.u();
                    continue;
                case 1:
                    str = strU;
                    cVar.l();
                    int iS = -1;
                    while (cVar.p()) {
                        int iY = cVar.y(f1414b);
                        if (iY != 0) {
                            cVar2 = cVarG;
                            if (iY != 1) {
                                cVar.z();
                                cVar.A();
                            } else {
                                cVarG = AbstractC0119d.g(cVar, dVar, iS);
                            }
                        } else {
                            cVar2 = cVarG;
                            iS = cVar.s();
                        }
                        cVarG = cVar2;
                    }
                    cVar.n();
                    break;
                case 2:
                    dVarH = AbstractC0119d.h(cVar, dVar);
                    continue;
                case 3:
                    str = strU;
                    fVar = cVar.s() == 1 ? X.f.LINEAR : X.f.RADIAL;
                    break;
                case 4:
                    fVarI = AbstractC0119d.i(cVar, dVar);
                    continue;
                case 5:
                    fVarI2 = AbstractC0119d.i(cVar, dVar);
                    continue;
                case 6:
                    bVarE = AbstractC0119d.e(cVar, dVar);
                    continue;
                case 7:
                    str = strU;
                    bVar = p.b.values()[cVar.s() - 1];
                    break;
                case 8:
                    str = strU;
                    cVar3 = p.c.values()[cVar.s() - 1];
                    break;
                case 9:
                    str = strU;
                    fR = (float) cVar.r();
                    break;
                case 10:
                    zQ = cVar.q();
                    continue;
                case 11:
                    cVar.k();
                    while (cVar.p()) {
                        cVar.l();
                        String strU2 = null;
                        W.b bVarE2 = null;
                        while (cVar.p()) {
                            int iY2 = cVar.y(f1415c);
                            if (iY2 != 0) {
                                W.b bVar3 = bVar2;
                                if (iY2 != 1) {
                                    cVar.z();
                                    cVar.A();
                                } else {
                                    bVarE2 = AbstractC0119d.e(cVar, dVar);
                                }
                                bVar2 = bVar3;
                            } else {
                                strU2 = cVar.u();
                            }
                        }
                        W.b bVar4 = bVar2;
                        cVar.n();
                        if (strU2.equals("o")) {
                            bVar2 = bVarE2;
                        } else {
                            if (strU2.equals("d") || strU2.equals("g")) {
                                dVar.t(true);
                                arrayList.add(bVarE2);
                            }
                            bVar2 = bVar4;
                        }
                    }
                    W.b bVar5 = bVar2;
                    cVar.m();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                    }
                    bVar2 = bVar5;
                    continue;
                    break;
                default:
                    cVar.z();
                    cVar.A();
                    continue;
            }
            strU = str;
        }
        return new X.e(strU, fVar, cVarG, dVarH, fVarI, fVarI2, bVarE, bVar, cVar3, fR, arrayList, bVar2, zQ);
    }
}
