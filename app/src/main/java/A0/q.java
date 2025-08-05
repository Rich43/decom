package a0;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import b0.c;
import d0.C0244a;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
abstract class q {

    /* renamed from: b, reason: collision with root package name */
    private static androidx.collection.h f1420b;

    /* renamed from: a, reason: collision with root package name */
    private static final Interpolator f1419a = new LinearInterpolator();

    /* renamed from: c, reason: collision with root package name */
    static c.a f1421c = c.a.a("t", "s", "e", "o", "i", "h", "to", "ti");

    private static WeakReference a(int i2) {
        WeakReference weakReference;
        synchronized (q.class) {
            weakReference = (WeakReference) e().e(i2);
        }
        return weakReference;
    }

    static C0244a b(b0.c cVar, Q.d dVar, float f2, J j2, boolean z2) {
        return z2 ? c(dVar, cVar, f2, j2) : d(cVar, f2, j2);
    }

    private static C0244a c(Q.d dVar, b0.c cVar, float f2, J j2) {
        Interpolator interpolator;
        cVar.l();
        PointF pointFE = null;
        PointF pointFE2 = null;
        Object objA = null;
        Object objA2 = null;
        PointF pointFE3 = null;
        PointF pointFE4 = null;
        boolean z2 = false;
        float fR = 0.0f;
        while (cVar.p()) {
            switch (cVar.y(f1421c)) {
                case 0:
                    fR = (float) cVar.r();
                    break;
                case 1:
                    objA = j2.a(cVar, f2);
                    break;
                case 2:
                    objA2 = j2.a(cVar, f2);
                    break;
                case 3:
                    pointFE = p.e(cVar, f2);
                    break;
                case 4:
                    pointFE2 = p.e(cVar, f2);
                    break;
                case 5:
                    if (cVar.s() != 1) {
                        z2 = false;
                        break;
                    } else {
                        z2 = true;
                        break;
                    }
                case 6:
                    pointFE3 = p.e(cVar, f2);
                    break;
                case 7:
                    pointFE4 = p.e(cVar, f2);
                    break;
                default:
                    cVar.A();
                    break;
            }
        }
        cVar.n();
        if (z2) {
            interpolator = f1419a;
            objA2 = objA;
        } else if (pointFE == null || pointFE2 == null) {
            interpolator = f1419a;
        } else {
            float f3 = -f2;
            pointFE.x = c0.i.b(pointFE.x, f3, f2);
            pointFE.y = c0.i.b(pointFE.y, -100.0f, 100.0f);
            pointFE2.x = c0.i.b(pointFE2.x, f3, f2);
            float fB = c0.i.b(pointFE2.y, -100.0f, 100.0f);
            pointFE2.y = fB;
            int i2 = c0.j.i(pointFE.x, pointFE.y, pointFE2.x, fB);
            WeakReference weakReferenceA = a(i2);
            Interpolator interpolatorA = weakReferenceA != null ? (Interpolator) weakReferenceA.get() : null;
            if (weakReferenceA == null || interpolatorA == null) {
                interpolatorA = androidx.core.view.animation.a.a(pointFE.x / f2, pointFE.y / f2, pointFE2.x / f2, pointFE2.y / f2);
                try {
                    f(i2, new WeakReference(interpolatorA));
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
            }
            interpolator = interpolatorA;
        }
        C0244a c0244a = new C0244a(dVar, objA, objA2, interpolator, fR, null);
        c0244a.f5793m = pointFE3;
        c0244a.f5794n = pointFE4;
        return c0244a;
    }

    private static C0244a d(b0.c cVar, float f2, J j2) {
        return new C0244a(j2.a(cVar, f2));
    }

    private static androidx.collection.h e() {
        if (f1420b == null) {
            f1420b = new androidx.collection.h();
        }
        return f1420b;
    }

    private static void f(int i2, WeakReference weakReference) {
        synchronized (q.class) {
            f1420b.h(i2, weakReference);
        }
    }
}
