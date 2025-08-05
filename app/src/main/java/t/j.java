package T;

import android.graphics.PointF;
import d0.C0244a;
import d0.C0246c;
import java.util.List;

/* loaded from: classes.dex */
public class j extends f {

    /* renamed from: l, reason: collision with root package name */
    private final PointF f867l;

    public j(List list) {
        super(list);
        this.f867l = new PointF();
    }

    @Override // T.a
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public PointF i(C0244a c0244a, float f2) {
        Object obj;
        PointF pointF;
        Object obj2 = c0244a.f5783b;
        if (obj2 == null || (obj = c0244a.f5784c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF2 = (PointF) obj2;
        PointF pointF3 = (PointF) obj;
        C0246c c0246c = this.e;
        if (c0246c != null && (pointF = (PointF) c0246c.b(c0244a.e, c0244a.f5786f.floatValue(), pointF2, pointF3, f2, e(), f())) != null) {
            return pointF;
        }
        PointF pointF4 = this.f867l;
        float f3 = pointF2.x;
        float f4 = f3 + ((pointF3.x - f3) * f2);
        float f5 = pointF2.y;
        pointF4.set(f4, f5 + (f2 * (pointF3.y - f5)));
        return this.f867l;
    }
}
