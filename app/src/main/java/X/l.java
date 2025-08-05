package X;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private final List f1188a;

    /* renamed from: b, reason: collision with root package name */
    private PointF f1189b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f1190c;

    public l(PointF pointF, boolean z2, List list) {
        this.f1189b = pointF;
        this.f1190c = z2;
        this.f1188a = new ArrayList(list);
    }

    private void e(float f2, float f3) {
        if (this.f1189b == null) {
            this.f1189b = new PointF();
        }
        this.f1189b.set(f2, f3);
    }

    public List a() {
        return this.f1188a;
    }

    public PointF b() {
        return this.f1189b;
    }

    public void c(l lVar, l lVar2, float f2) {
        if (this.f1189b == null) {
            this.f1189b = new PointF();
        }
        this.f1190c = lVar.d() || lVar2.d();
        if (lVar.a().size() != lVar2.a().size()) {
            c0.f.b("Curves must have the same number of control points. Shape 1: " + lVar.a().size() + "\tShape 2: " + lVar2.a().size());
        }
        int iMin = Math.min(lVar.a().size(), lVar2.a().size());
        if (this.f1188a.size() < iMin) {
            for (int size = this.f1188a.size(); size < iMin; size++) {
                this.f1188a.add(new V.a());
            }
        } else if (this.f1188a.size() > iMin) {
            for (int size2 = this.f1188a.size() - 1; size2 >= iMin; size2--) {
                List list = this.f1188a;
                list.remove(list.size() - 1);
            }
        }
        PointF pointFB = lVar.b();
        PointF pointFB2 = lVar2.b();
        e(c0.i.j(pointFB.x, pointFB2.x, f2), c0.i.j(pointFB.y, pointFB2.y, f2));
        for (int size3 = this.f1188a.size() - 1; size3 >= 0; size3--) {
            V.a aVar = (V.a) lVar.a().get(size3);
            V.a aVar2 = (V.a) lVar2.a().get(size3);
            PointF pointFA = aVar.a();
            PointF pointFB3 = aVar.b();
            PointF pointFC = aVar.c();
            PointF pointFA2 = aVar2.a();
            PointF pointFB4 = aVar2.b();
            PointF pointFC2 = aVar2.c();
            ((V.a) this.f1188a.get(size3)).d(c0.i.j(pointFA.x, pointFA2.x, f2), c0.i.j(pointFA.y, pointFA2.y, f2));
            ((V.a) this.f1188a.get(size3)).e(c0.i.j(pointFB3.x, pointFB4.x, f2), c0.i.j(pointFB3.y, pointFB4.y, f2));
            ((V.a) this.f1188a.get(size3)).f(c0.i.j(pointFC.x, pointFC2.x, f2), c0.i.j(pointFC.y, pointFC2.y, f2));
        }
    }

    public boolean d() {
        return this.f1190c;
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f1188a.size() + "closed=" + this.f1190c + '}';
    }

    public l() {
        this.f1188a = new ArrayList();
    }
}
