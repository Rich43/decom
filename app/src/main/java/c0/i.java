package c0;

import S.k;
import X.l;
import android.graphics.Path;
import android.graphics.PointF;
import java.util.List;

/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a */
    private static PointF f4646a = new PointF();

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static float b(float f2, float f3, float f4) {
        return Math.max(f3, Math.min(f4, f2));
    }

    public static int c(int i2, int i3, int i4) {
        return Math.max(i3, Math.min(i4, i2));
    }

    public static boolean d(float f2, float f3, float f4) {
        return f2 >= f3 && f2 <= f4;
    }

    private static int e(int i2, int i3) {
        int i4 = i2 / i3;
        return (((i2 ^ i3) >= 0) || i2 % i3 == 0) ? i4 : i4 - 1;
    }

    static int f(float f2, float f3) {
        return g((int) f2, (int) f3);
    }

    private static int g(int i2, int i3) {
        return i2 - (i3 * e(i2, i3));
    }

    public static void h(l lVar, Path path) {
        path.reset();
        PointF pointFB = lVar.b();
        path.moveTo(pointFB.x, pointFB.y);
        f4646a.set(pointFB.x, pointFB.y);
        for (int i2 = 0; i2 < lVar.a().size(); i2++) {
            V.a aVar = (V.a) lVar.a().get(i2);
            PointF pointFA = aVar.a();
            PointF pointFB2 = aVar.b();
            PointF pointFC = aVar.c();
            if (pointFA.equals(f4646a) && pointFB2.equals(pointFC)) {
                path.lineTo(pointFC.x, pointFC.y);
            } else {
                path.cubicTo(pointFA.x, pointFA.y, pointFB2.x, pointFB2.y, pointFC.x, pointFC.y);
            }
            f4646a.set(pointFC.x, pointFC.y);
        }
        if (lVar.d()) {
            path.close();
        }
    }

    public static double i(double d2, double d3, double d4) {
        return d2 + (d4 * (d3 - d2));
    }

    public static float j(float f2, float f3, float f4) {
        return f2 + (f4 * (f3 - f2));
    }

    public static int k(int i2, int i3, float f2) {
        return (int) (i2 + (f2 * (i3 - i2)));
    }

    public static void l(V.e eVar, int i2, List list, V.e eVar2, k kVar) {
        if (eVar.c(kVar.i(), i2)) {
            list.add(eVar2.a(kVar.i()).i(kVar));
        }
    }
}
