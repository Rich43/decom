package a0;

import java.util.List;

/* renamed from: a0.d */
/* loaded from: classes.dex */
public abstract class AbstractC0119d {
    private static List a(b0.c cVar, float f2, Q.d dVar, J j2) {
        return r.a(cVar, dVar, f2, j2);
    }

    private static List b(b0.c cVar, Q.d dVar, J j2) {
        return r.a(cVar, dVar, 1.0f, j2);
    }

    static W.a c(b0.c cVar, Q.d dVar) {
        return new W.a(b(cVar, dVar, C0121f.f1402a));
    }

    static W.j d(b0.c cVar, Q.d dVar) {
        return new W.j(b(cVar, dVar, C0123h.f1404a));
    }

    public static W.b e(b0.c cVar, Q.d dVar) {
        return f(cVar, dVar, true);
    }

    public static W.b f(b0.c cVar, Q.d dVar, boolean z2) {
        return new W.b(a(cVar, z2 ? c0.j.e() : 1.0f, dVar, C0124i.f1406a));
    }

    static W.c g(b0.c cVar, Q.d dVar, int i2) {
        return new W.c(b(cVar, dVar, new l(i2)));
    }

    static W.d h(b0.c cVar, Q.d dVar) {
        return new W.d(b(cVar, dVar, o.f1416a));
    }

    static W.f i(b0.c cVar, Q.d dVar) {
        return new W.f(a(cVar, c0.j.e(), dVar, y.f1432a));
    }

    static W.g j(b0.c cVar, Q.d dVar) {
        return new W.g(b(cVar, dVar, C.f1387a));
    }

    static W.h k(b0.c cVar, Q.d dVar) {
        return new W.h(a(cVar, c0.j.e(), dVar, D.f1388a));
    }
}
