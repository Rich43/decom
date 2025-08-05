package T;

import d0.C0244a;
import d0.C0246c;
import java.util.List;

/* loaded from: classes.dex */
public class b extends f {
    public b(List list) {
        super(list);
    }

    public int n() {
        return o(b(), d());
    }

    public int o(C0244a c0244a, float f2) {
        Integer num;
        Object obj = c0244a.f5783b;
        if (obj == null || c0244a.f5784c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        Integer num2 = (Integer) obj;
        int iIntValue = num2.intValue();
        Integer num3 = (Integer) c0244a.f5784c;
        int iIntValue2 = num3.intValue();
        C0246c c0246c = this.e;
        return (c0246c == null || (num = (Integer) c0246c.b(c0244a.e, c0244a.f5786f.floatValue(), num2, num3, f2, e(), f())) == null) ? c0.d.c(c0.i.b(f2, 0.0f, 1.0f), iIntValue, iIntValue2) : num.intValue();
    }

    @Override // T.a
    /* renamed from: p */
    public Integer i(C0244a c0244a, float f2) {
        return Integer.valueOf(o(c0244a, f2));
    }
}
