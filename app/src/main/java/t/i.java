package T;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import d0.C0244a;
import d0.C0246c;
import java.util.List;

/* loaded from: classes.dex */
public class i extends f {

    /* renamed from: l, reason: collision with root package name */
    private final PointF f864l;

    /* renamed from: m, reason: collision with root package name */
    private final float[] f865m;

    /* renamed from: n, reason: collision with root package name */
    private h f866n;
    private PathMeasure o;

    public i(List list) {
        super(list);
        this.f864l = new PointF();
        this.f865m = new float[2];
        this.o = new PathMeasure();
    }

    @Override // T.a
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public PointF i(C0244a c0244a, float f2) {
        PointF pointF;
        h hVar = (h) c0244a;
        Path pathJ = hVar.j();
        if (pathJ == null) {
            return (PointF) c0244a.f5783b;
        }
        C0246c c0246c = this.e;
        if (c0246c != null && (pointF = (PointF) c0246c.b(hVar.e, hVar.f5786f.floatValue(), hVar.f5783b, hVar.f5784c, e(), f2, f())) != null) {
            return pointF;
        }
        if (this.f866n != hVar) {
            this.o.setPath(pathJ, false);
            this.f866n = hVar;
        }
        PathMeasure pathMeasure = this.o;
        pathMeasure.getPosTan(f2 * pathMeasure.getLength(), this.f865m, null);
        PointF pointF2 = this.f864l;
        float[] fArr = this.f865m;
        pointF2.set(fArr[0], fArr[1]);
        return this.f864l;
    }
}
