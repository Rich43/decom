package T;

import d0.C0244a;
import d0.C0246c;
import d0.C0247d;
import java.util.List;

/* loaded from: classes.dex */
public class k extends f {

    /* renamed from: l, reason: collision with root package name */
    private final C0247d f868l;

    public k(List list) {
        super(list);
        this.f868l = new C0247d();
    }

    @Override // T.a
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public C0247d i(C0244a c0244a, float f2) {
        Object obj;
        C0247d c0247d;
        Object obj2 = c0244a.f5783b;
        if (obj2 == null || (obj = c0244a.f5784c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        C0247d c0247d2 = (C0247d) obj2;
        C0247d c0247d3 = (C0247d) obj;
        C0246c c0246c = this.e;
        if (c0246c != null && (c0247d = (C0247d) c0246c.b(c0244a.e, c0244a.f5786f.floatValue(), c0247d2, c0247d3, f2, e(), f())) != null) {
            return c0247d;
        }
        this.f868l.d(c0.i.j(c0247d2.b(), c0247d3.b(), f2), c0.i.j(c0247d2.c(), c0247d3.c(), f2));
        return this.f868l;
    }
}
