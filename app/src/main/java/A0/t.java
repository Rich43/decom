package a0;

import Y.d;
import android.graphics.Rect;
import b0.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class t {

    /* renamed from: a */
    private static final c.a f1426a = c.a.a("w", "h", "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");

    /* renamed from: b */
    static c.a f1427b = c.a.a("id", "layers", "w", "h", "p", "u");

    /* renamed from: c */
    private static final c.a f1428c = c.a.a("list");

    /* renamed from: d */
    private static final c.a f1429d = c.a.a("cm", "tm", "dr");

    public static Q.d a(b0.c cVar) {
        HashMap map;
        ArrayList arrayList;
        b0.c cVar2 = cVar;
        float fE = c0.j.e();
        androidx.collection.d dVar = new androidx.collection.d();
        ArrayList arrayList2 = new ArrayList();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        HashMap map4 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        androidx.collection.h hVar = new androidx.collection.h();
        Q.d dVar2 = new Q.d();
        cVar.l();
        int iS = 0;
        float fR = 0.0f;
        float fR2 = 0.0f;
        float fR3 = 0.0f;
        int iS2 = 0;
        while (cVar.p()) {
            switch (cVar2.y(f1426a)) {
                case 0:
                    iS = cVar.s();
                    continue;
                    cVar2 = cVar;
                case 1:
                    iS2 = cVar.s();
                    continue;
                    cVar2 = cVar;
                case 2:
                    fR = (float) cVar.r();
                    continue;
                    cVar2 = cVar;
                case 3:
                    map = map4;
                    arrayList = arrayList3;
                    fR2 = ((float) cVar.r()) - 0.01f;
                    break;
                case 4:
                    map = map4;
                    arrayList = arrayList3;
                    fR3 = (float) cVar.r();
                    break;
                case 5:
                    String[] strArrSplit = cVar.u().split("\\.");
                    if (!c0.j.j(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), 4, 4, 0)) {
                        dVar2.a("Lottie only supports bodymovin >= 4.4.0");
                        continue;
                    }
                    cVar2 = cVar;
                case 6:
                    e(cVar2, dVar2, arrayList2, dVar);
                    continue;
                    cVar2 = cVar;
                case 7:
                    b(cVar2, dVar2, map2, map3);
                    continue;
                    cVar2 = cVar;
                case 8:
                    d(cVar2, map4);
                    continue;
                    cVar2 = cVar;
                case 9:
                    c(cVar2, dVar2, hVar);
                    continue;
                    cVar2 = cVar;
                case 10:
                    f(cVar2, dVar2, arrayList3);
                    continue;
                    cVar2 = cVar;
                default:
                    cVar.z();
                    cVar.A();
                    continue;
                    cVar2 = cVar;
            }
            map4 = map;
            arrayList3 = arrayList;
            cVar2 = cVar;
        }
        dVar2.r(new Rect(0, 0, (int) (iS * fE), (int) (iS2 * fE)), fR, fR2, fR3, arrayList2, dVar, map2, map3, hVar, map4, arrayList3);
        return dVar2;
    }

    private static void b(b0.c cVar, Q.d dVar, Map map, Map map2) {
        cVar.k();
        while (cVar.p()) {
            ArrayList arrayList = new ArrayList();
            androidx.collection.d dVar2 = new androidx.collection.d();
            cVar.l();
            String strU = null;
            String strU2 = null;
            String strU3 = null;
            int iS = 0;
            int iS2 = 0;
            while (cVar.p()) {
                int iY = cVar.y(f1427b);
                if (iY == 0) {
                    strU = cVar.u();
                } else if (iY == 1) {
                    cVar.k();
                    while (cVar.p()) {
                        Y.d dVarB = s.b(cVar, dVar);
                        dVar2.j(dVarB.b(), dVarB);
                        arrayList.add(dVarB);
                    }
                    cVar.m();
                } else if (iY == 2) {
                    iS = cVar.s();
                } else if (iY == 3) {
                    iS2 = cVar.s();
                } else if (iY == 4) {
                    strU2 = cVar.u();
                } else if (iY != 5) {
                    cVar.z();
                    cVar.A();
                } else {
                    strU3 = cVar.u();
                }
            }
            cVar.n();
            if (strU2 != null) {
                Q.f fVar = new Q.f(iS, iS2, strU, strU2, strU3);
                map2.put(fVar.d(), fVar);
            } else {
                map.put(strU, arrayList);
            }
        }
        cVar.m();
    }

    private static void c(b0.c cVar, Q.d dVar, androidx.collection.h hVar) {
        cVar.k();
        while (cVar.p()) {
            V.d dVarA = AbstractC0125j.a(cVar, dVar);
            hVar.h(dVarA.hashCode(), dVarA);
        }
        cVar.m();
    }

    private static void d(b0.c cVar, Map map) {
        cVar.l();
        while (cVar.p()) {
            if (cVar.y(f1428c) != 0) {
                cVar.z();
                cVar.A();
            } else {
                cVar.k();
                while (cVar.p()) {
                    V.c cVarA = k.a(cVar);
                    map.put(cVarA.b(), cVarA);
                }
                cVar.m();
            }
        }
        cVar.n();
    }

    private static void e(b0.c cVar, Q.d dVar, List list, androidx.collection.d dVar2) {
        cVar.k();
        int i2 = 0;
        while (cVar.p()) {
            Y.d dVarB = s.b(cVar, dVar);
            if (dVarB.d() == d.a.IMAGE) {
                i2++;
            }
            list.add(dVarB);
            dVar2.j(dVarB.b(), dVarB);
            if (i2 > 4) {
                c0.f.b("You have " + i2 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        cVar.m();
    }

    private static void f(b0.c cVar, Q.d dVar, List list) {
        cVar.k();
        while (cVar.p()) {
            cVar.l();
            float fR = 0.0f;
            String strU = null;
            float fR2 = 0.0f;
            while (cVar.p()) {
                int iY = cVar.y(f1429d);
                if (iY == 0) {
                    strU = cVar.u();
                } else if (iY == 1) {
                    fR = (float) cVar.r();
                } else if (iY != 2) {
                    cVar.z();
                    cVar.A();
                } else {
                    fR2 = (float) cVar.r();
                }
            }
            cVar.n();
            list.add(new V.h(strU, fR, fR2));
        }
        cVar.m();
    }
}
