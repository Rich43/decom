package a0;

import b0.c;
import d0.C0244a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
abstract class r {

    /* renamed from: a, reason: collision with root package name */
    static c.a f1422a = c.a.a("k");

    static List a(b0.c cVar, Q.d dVar, float f2, J j2) {
        ArrayList arrayList = new ArrayList();
        if (cVar.w() == c.b.STRING) {
            dVar.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        cVar.l();
        while (cVar.p()) {
            if (cVar.y(f1422a) != 0) {
                cVar.A();
            } else if (cVar.w() == c.b.BEGIN_ARRAY) {
                cVar.k();
                if (cVar.w() == c.b.NUMBER) {
                    arrayList.add(q.b(cVar, dVar, f2, j2, false));
                } else {
                    while (cVar.p()) {
                        arrayList.add(q.b(cVar, dVar, f2, j2, true));
                    }
                }
                cVar.m();
            } else {
                arrayList.add(q.b(cVar, dVar, f2, j2, false));
            }
        }
        cVar.n();
        b(arrayList);
        return arrayList;
    }

    public static void b(List list) {
        int i2;
        Object obj;
        int size = list.size();
        int i3 = 0;
        while (true) {
            i2 = size - 1;
            if (i3 >= i2) {
                break;
            }
            C0244a c0244a = (C0244a) list.get(i3);
            i3++;
            C0244a c0244a2 = (C0244a) list.get(i3);
            c0244a.f5786f = Float.valueOf(c0244a2.e);
            if (c0244a.f5784c == null && (obj = c0244a2.f5783b) != null) {
                c0244a.f5784c = obj;
                if (c0244a instanceof T.h) {
                    ((T.h) c0244a).i();
                }
            }
        }
        C0244a c0244a3 = (C0244a) list.get(i2);
        if ((c0244a3.f5783b == null || c0244a3.f5784c == null) && list.size() > 1) {
            list.remove(c0244a3);
        }
    }
}
