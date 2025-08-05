package a0;

import android.graphics.PointF;
import b0.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class D implements J {

    /* renamed from: a, reason: collision with root package name */
    public static final D f1388a = new D();

    /* renamed from: b, reason: collision with root package name */
    private static final c.a f1389b = c.a.a("c", "v", "i", "o");

    private D() {
    }

    @Override // a0.J
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public X.l a(b0.c cVar, float f2) {
        if (cVar.w() == c.b.BEGIN_ARRAY) {
            cVar.k();
        }
        cVar.l();
        List listF = null;
        List listF2 = null;
        List listF3 = null;
        boolean zQ = false;
        while (cVar.p()) {
            int iY = cVar.y(f1389b);
            if (iY == 0) {
                zQ = cVar.q();
            } else if (iY == 1) {
                listF = p.f(cVar, f2);
            } else if (iY == 2) {
                listF2 = p.f(cVar, f2);
            } else if (iY != 3) {
                cVar.z();
                cVar.A();
            } else {
                listF3 = p.f(cVar, f2);
            }
        }
        cVar.n();
        if (cVar.w() == c.b.END_ARRAY) {
            cVar.m();
        }
        if (listF == null || listF2 == null || listF3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        }
        if (listF.isEmpty()) {
            return new X.l(new PointF(), false, Collections.emptyList());
        }
        int size = listF.size();
        PointF pointF = (PointF) listF.get(0);
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 1; i2 < size; i2++) {
            PointF pointF2 = (PointF) listF.get(i2);
            int i3 = i2 - 1;
            arrayList.add(new V.a(c0.i.a((PointF) listF.get(i3), (PointF) listF3.get(i3)), c0.i.a(pointF2, (PointF) listF2.get(i2)), pointF2));
        }
        if (zQ) {
            PointF pointF3 = (PointF) listF.get(0);
            int i4 = size - 1;
            arrayList.add(new V.a(c0.i.a((PointF) listF.get(i4), (PointF) listF3.get(i4)), c0.i.a(pointF3, (PointF) listF2.get(0)), pointF3));
        }
        return new X.l(pointF, zQ, arrayList);
    }
}
