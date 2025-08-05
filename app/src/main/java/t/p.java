package T;

import d0.C0244a;
import d0.C0245b;
import d0.C0246c;
import java.util.Collections;

/* loaded from: classes.dex */
public class p extends a {

    /* renamed from: l, reason: collision with root package name */
    private final C0245b f887l;

    /* renamed from: m, reason: collision with root package name */
    private final Object f888m;

    public p(C0246c c0246c) {
        this(c0246c, null);
    }

    @Override // T.a
    float c() {
        return 1.0f;
    }

    @Override // T.a
    public Object h() {
        C0246c c0246c = this.e;
        Object obj = this.f888m;
        return c0246c.b(0.0f, 0.0f, obj, obj, f(), f(), f());
    }

    @Override // T.a
    Object i(C0244a c0244a, float f2) {
        return h();
    }

    @Override // T.a
    public void j() {
        if (this.e != null) {
            super.j();
        }
    }

    public p(C0246c c0246c, Object obj) {
        super(Collections.emptyList());
        this.f887l = new C0245b();
        m(c0246c);
        this.f888m = obj;
    }
}
