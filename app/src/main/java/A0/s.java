package a0;

import Y.d;
import android.graphics.Color;
import android.graphics.Rect;
import b0.c;
import d0.C0244a;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f1423a = c.a.a("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", "w", "h", "ip", "op", "tm", "cl", "hd");

    /* renamed from: b, reason: collision with root package name */
    private static final c.a f1424b = c.a.a("d", "a");

    /* renamed from: c, reason: collision with root package name */
    private static final c.a f1425c = c.a.a("nm");

    public static Y.d a(Q.d dVar) {
        Rect rectB = dVar.b();
        return new Y.d(Collections.emptyList(), dVar, "__container", -1L, d.a.PRE_COMP, -1L, null, Collections.emptyList(), new W.l(), 0, 0, 0, 0.0f, 0.0f, rectB.width(), rectB.height(), null, null, Collections.emptyList(), d.b.NONE, null, false);
    }

    public static Y.d b(b0.c cVar, Q.d dVar) {
        ArrayList arrayList;
        ArrayList arrayList2;
        d.b bVar = d.b.NONE;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        cVar.l();
        Float fValueOf = Float.valueOf(1.0f);
        Float fValueOf2 = Float.valueOf(0.0f);
        d.b bVar2 = bVar;
        String strU = "UNSET";
        String strU2 = null;
        W.l lVarG = null;
        W.j jVarD = null;
        W.k kVarA = null;
        W.b bVarF = null;
        long jS = 0;
        long jS2 = -1;
        float fR = 0.0f;
        float fR2 = 0.0f;
        int iS = 0;
        int iS2 = 0;
        int color = 0;
        float fR3 = 1.0f;
        float fR4 = 0.0f;
        int iS3 = 0;
        int iS4 = 0;
        boolean zQ = false;
        String strU3 = null;
        d.a aVar = null;
        while (cVar.p()) {
            switch (cVar.y(f1423a)) {
                case 0:
                    strU = cVar.u();
                    break;
                case 1:
                    jS = cVar.s();
                    break;
                case 2:
                    strU2 = cVar.u();
                    break;
                case 3:
                    int iS5 = cVar.s();
                    aVar = d.a.UNKNOWN;
                    if (iS5 >= aVar.ordinal()) {
                        break;
                    } else {
                        aVar = d.a.values()[iS5];
                        break;
                    }
                case 4:
                    jS2 = cVar.s();
                    break;
                case 5:
                    iS = (int) (cVar.s() * c0.j.e());
                    break;
                case 6:
                    iS2 = (int) (cVar.s() * c0.j.e());
                    break;
                case 7:
                    color = Color.parseColor(cVar.u());
                    break;
                case 8:
                    lVarG = AbstractC0118c.g(cVar, dVar);
                    break;
                case 9:
                    bVar2 = d.b.values()[cVar.s()];
                    dVar.q(1);
                    break;
                case 10:
                    cVar.k();
                    while (cVar.p()) {
                        arrayList3.add(u.a(cVar, dVar));
                    }
                    dVar.q(arrayList3.size());
                    cVar.m();
                    break;
                case 11:
                    cVar.k();
                    while (cVar.p()) {
                        X.b bVarA = AbstractC0122g.a(cVar, dVar);
                        if (bVarA != null) {
                            arrayList4.add(bVarA);
                        }
                    }
                    cVar.m();
                    break;
                case 12:
                    cVar.l();
                    while (cVar.p()) {
                        int iY = cVar.y(f1424b);
                        if (iY == 0) {
                            jVarD = AbstractC0119d.d(cVar, dVar);
                        } else if (iY != 1) {
                            cVar.z();
                            cVar.A();
                        } else {
                            cVar.k();
                            if (cVar.p()) {
                                kVarA = AbstractC0117b.a(cVar, dVar);
                            }
                            while (cVar.p()) {
                                cVar.A();
                            }
                            cVar.m();
                        }
                    }
                    cVar.n();
                    break;
                case 13:
                    cVar.k();
                    ArrayList arrayList5 = new ArrayList();
                    while (cVar.p()) {
                        cVar.l();
                        while (cVar.p()) {
                            if (cVar.y(f1425c) != 0) {
                                cVar.z();
                                cVar.A();
                            } else {
                                arrayList5.add(cVar.u());
                            }
                        }
                        cVar.n();
                    }
                    cVar.m();
                    dVar.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList5);
                    break;
                case 14:
                    fR3 = (float) cVar.r();
                    break;
                case 15:
                    fR4 = (float) cVar.r();
                    break;
                case 16:
                    iS3 = (int) (cVar.s() * c0.j.e());
                    break;
                case 17:
                    iS4 = (int) (cVar.s() * c0.j.e());
                    break;
                case 18:
                    fR = (float) cVar.r();
                    break;
                case 19:
                    fR2 = (float) cVar.r();
                    break;
                case 20:
                    bVarF = AbstractC0119d.f(cVar, dVar, false);
                    break;
                case 21:
                    strU3 = cVar.u();
                    break;
                case 22:
                    zQ = cVar.q();
                    break;
                default:
                    cVar.z();
                    cVar.A();
                    break;
            }
        }
        cVar.n();
        float f2 = fR / fR3;
        float f3 = fR2 / fR3;
        ArrayList arrayList6 = new ArrayList();
        if (f2 > 0.0f) {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
            arrayList2.add(new C0244a(dVar, fValueOf2, fValueOf2, null, 0.0f, Float.valueOf(f2)));
        } else {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
        }
        if (f3 <= 0.0f) {
            f3 = dVar.f();
        }
        arrayList2.add(new C0244a(dVar, fValueOf, fValueOf, null, f2, Float.valueOf(f3)));
        arrayList2.add(new C0244a(dVar, fValueOf2, fValueOf2, null, f3, Float.valueOf(Float.MAX_VALUE)));
        if (strU.endsWith(".ai") || "ai".equals(strU3)) {
            dVar.a("Convert your Illustrator layers to shape layers.");
        }
        return new Y.d(arrayList4, dVar, strU, jS, aVar, jS2, strU2, arrayList, lVarG, iS, iS2, color, fR3, fR4, iS3, iS4, jVarD, kVarA, arrayList2, bVar2, bVarF, zQ);
    }
}
