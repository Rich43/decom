package c0;

import S.s;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.provider.Settings;
import java.io.Closeable;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    private static final PathMeasure f4647a = new PathMeasure();

    /* renamed from: b, reason: collision with root package name */
    private static final Path f4648b = new Path();

    /* renamed from: c, reason: collision with root package name */
    private static final Path f4649c = new Path();

    /* renamed from: d, reason: collision with root package name */
    private static final float[] f4650d = new float[4];
    private static final float e = (float) Math.sqrt(2.0d);

    /* renamed from: f, reason: collision with root package name */
    private static float f4651f = -1.0f;

    public static void a(Path path, float f2, float f3, float f4) {
        Q.c.a("applyTrimPathIfNeeded");
        PathMeasure pathMeasure = f4647a;
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f2 == 1.0f && f3 == 0.0f) {
            Q.c.b("applyTrimPathIfNeeded");
            return;
        }
        if (length < 1.0f || Math.abs((f3 - f2) - 1.0f) < 0.01d) {
            Q.c.b("applyTrimPathIfNeeded");
            return;
        }
        float f5 = f2 * length;
        float f6 = f3 * length;
        float f7 = f4 * length;
        float fMin = Math.min(f5, f6) + f7;
        float fMax = Math.max(f5, f6) + f7;
        if (fMin >= length && fMax >= length) {
            fMin = i.f(fMin, length);
            fMax = i.f(fMax, length);
        }
        if (fMin < 0.0f) {
            fMin = i.f(fMin, length);
        }
        if (fMax < 0.0f) {
            fMax = i.f(fMax, length);
        }
        if (fMin == fMax) {
            path.reset();
            Q.c.b("applyTrimPathIfNeeded");
            return;
        }
        if (fMin >= fMax) {
            fMin -= length;
        }
        Path path2 = f4648b;
        path2.reset();
        pathMeasure.getSegment(fMin, fMax, path2, true);
        if (fMax > length) {
            Path path3 = f4649c;
            path3.reset();
            pathMeasure.getSegment(0.0f, fMax % length, path3, true);
            path2.addPath(path3);
        } else if (fMin < 0.0f) {
            Path path4 = f4649c;
            path4.reset();
            pathMeasure.getSegment(fMin + length, length, path4, true);
            path2.addPath(path4);
        }
        path.set(path2);
        Q.c.b("applyTrimPathIfNeeded");
    }

    public static void b(Path path, s sVar) {
        if (sVar == null || sVar.l()) {
            return;
        }
        a(path, ((T.c) sVar.j()).n() / 100.0f, ((T.c) sVar.e()).n() / 100.0f, ((T.c) sVar.f()).n() / 360.0f);
    }

    public static void c(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static Path d(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 == null || pointF4 == null || (pointF3.length() == 0.0f && pointF4.length() == 0.0f)) {
            path.lineTo(pointF2.x, pointF2.y);
        } else {
            float f2 = pointF3.x + pointF.x;
            float f3 = pointF.y + pointF3.y;
            float f4 = pointF2.x;
            float f5 = f4 + pointF4.x;
            float f6 = pointF2.y;
            path.cubicTo(f2, f3, f5, f6 + pointF4.y, f4, f6);
        }
        return path;
    }

    public static float e() {
        if (f4651f == -1.0f) {
            f4651f = Resources.getSystem().getDisplayMetrics().density;
        }
        return f4651f;
    }

    public static float f(Context context) {
        return Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }

    public static float g(Matrix matrix) {
        float[] fArr = f4650d;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f2 = e;
        fArr[2] = f2;
        fArr[3] = f2;
        matrix.mapPoints(fArr);
        return ((float) Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1])) / 2.0f;
    }

    public static boolean h(Matrix matrix) {
        float[] fArr = f4650d;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        return fArr[0] == fArr[2] || fArr[1] == fArr[3];
    }

    public static int i(float f2, float f3, float f4, float f5) {
        int i2 = f2 != 0.0f ? (int) (527 * f2) : 17;
        if (f3 != 0.0f) {
            i2 = (int) (i2 * 31 * f3);
        }
        if (f4 != 0.0f) {
            i2 = (int) (i2 * 31 * f4);
        }
        return f5 != 0.0f ? (int) (i2 * 31 * f5) : i2;
    }

    public static boolean j(int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i2 < i5) {
            return false;
        }
        if (i2 > i5) {
            return true;
        }
        if (i3 < i6) {
            return false;
        }
        return i3 > i6 || i4 >= i7;
    }

    public static Bitmap k(Bitmap bitmap, int i2, int i3) {
        if (bitmap.getWidth() == i2 && bitmap.getHeight() == i3) {
            return bitmap;
        }
        bitmap.getWidth();
        bitmap.getHeight();
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, i3, true);
        bitmap.recycle();
        return bitmapCreateScaledBitmap;
    }
}
