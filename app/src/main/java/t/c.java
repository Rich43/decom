package T;

import d0.C0244a;
import d0.C0246c;
import java.util.List;

/* loaded from: classes.dex */
public class c extends f {
    public c(List list) {
        super(list);
    }

    public float n() {
        return o(b(), d());
    }

    float o(C0244a c0244a, float f2) {
        Float f3;
        if (c0244a.f5783b == null || c0244a.f5784c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        C0246c c0246c = this.e;
        return (c0246c == null || (f3 = (Float) c0246c.b(c0244a.e, c0244a.f5786f.floatValue(), c0244a.f5783b, c0244a.f5784c, f2, e(), f())) == null) ? c0.i.j(c0244a.f(), c0244a.c(), f2) : f3.floatValue();
    }

    @Override // T.a
    /* renamed from: p */
    public Float i(C0244a c0244a, float f2) {
        return Float.valueOf(o(c0244a, f2));
    }
}
