package a0;

import android.graphics.Color;
import android.graphics.PointF;
import b0.c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
abstract class p {

    /* renamed from: a */
    private static final c.a f1417a = c.a.a("x", "y");

    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f1418a;

        static {
            int[] iArr = new int[c.b.values().length];
            f1418a = iArr;
            try {
                iArr[c.b.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1418a[c.b.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1418a[c.b.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static PointF a(b0.c cVar, float f2) {
        cVar.k();
        float fR = (float) cVar.r();
        float fR2 = (float) cVar.r();
        while (cVar.w() != c.b.END_ARRAY) {
            cVar.A();
        }
        cVar.m();
        return new PointF(fR * f2, fR2 * f2);
    }

    private static PointF b(b0.c cVar, float f2) {
        float fR = (float) cVar.r();
        float fR2 = (float) cVar.r();
        while (cVar.p()) {
            cVar.A();
        }
        return new PointF(fR * f2, fR2 * f2);
    }

    private static PointF c(b0.c cVar, float f2) {
        cVar.l();
        float fG = 0.0f;
        float fG2 = 0.0f;
        while (cVar.p()) {
            int iY = cVar.y(f1417a);
            if (iY == 0) {
                fG = g(cVar);
            } else if (iY != 1) {
                cVar.z();
                cVar.A();
            } else {
                fG2 = g(cVar);
            }
        }
        cVar.n();
        return new PointF(fG * f2, fG2 * f2);
    }

    static int d(b0.c cVar) {
        cVar.k();
        int iR = (int) (cVar.r() * 255.0d);
        int iR2 = (int) (cVar.r() * 255.0d);
        int iR3 = (int) (cVar.r() * 255.0d);
        while (cVar.p()) {
            cVar.A();
        }
        cVar.m();
        return Color.argb(255, iR, iR2, iR3);
    }

    static PointF e(b0.c cVar, float f2) {
        int i2 = a.f1418a[cVar.w().ordinal()];
        if (i2 == 1) {
            return b(cVar, f2);
        }
        if (i2 == 2) {
            return a(cVar, f2);
        }
        if (i2 == 3) {
            return c(cVar, f2);
        }
        throw new IllegalArgumentException("Unknown point starts with " + cVar.w());
    }

    static List f(b0.c cVar, float f2) {
        ArrayList arrayList = new ArrayList();
        cVar.k();
        while (cVar.w() == c.b.BEGIN_ARRAY) {
            cVar.k();
            arrayList.add(e(cVar, f2));
            cVar.m();
        }
        cVar.m();
        return arrayList;
    }

    static float g(b0.c cVar) {
        c.b bVarW = cVar.w();
        int i2 = a.f1418a[bVarW.ordinal()];
        if (i2 == 1) {
            return (float) cVar.r();
        }
        if (i2 != 2) {
            throw new IllegalArgumentException("Unknown value for token of type " + bVarW);
        }
        cVar.k();
        float fR = (float) cVar.r();
        while (cVar.p()) {
            cVar.A();
        }
        cVar.m();
        return fR;
    }
}
