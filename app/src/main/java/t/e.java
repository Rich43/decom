package T;

import d0.C0244a;
import d0.C0246c;
import java.util.List;

/* loaded from: classes.dex */
public class e extends f {
    public e(List list) {
        super(list);
    }

    public int n() {
        return o(b(), d());
    }

    int o(C0244a c0244a, float f2) {
        Integer num;
        if (c0244a.f5783b == null || c0244a.f5784c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        C0246c c0246c = this.e;
        return (c0246c == null || (num = (Integer) c0246c.b(c0244a.e, c0244a.f5786f.floatValue(), c0244a.f5783b, c0244a.f5784c, f2, e(), f())) == null) ? c0.i.k(c0244a.g(), c0244a.d(), f2) : num.intValue();
    }

    @Override // T.a
    /* renamed from: p */
    public Integer i(C0244a c0244a, float f2) {
        return Integer.valueOf(o(c0244a, f2));
    }
}
