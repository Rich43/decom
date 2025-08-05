package androidx.core.graphics;

import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import v.C0341d;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal f3030a = new ThreadLocal();

    static class a {
        static boolean a(Paint paint, String str) {
            return paint.hasGlyph(str);
        }
    }

    public static boolean a(Paint paint, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return a.a(paint, str);
        }
        int length = str.length();
        if (length == 1 && Character.isWhitespace(str.charAt(0))) {
            return true;
        }
        float fMeasureText = paint.measureText("\udfffd");
        float fMeasureText2 = paint.measureText("m");
        float fMeasureText3 = paint.measureText(str);
        float fMeasureText4 = 0.0f;
        if (fMeasureText3 == 0.0f) {
            return false;
        }
        if (str.codePointCount(0, str.length()) > 1) {
            if (fMeasureText3 > fMeasureText2 * 2.0f) {
                return false;
            }
            int i2 = 0;
            while (i2 < length) {
                int iCharCount = Character.charCount(str.codePointAt(i2)) + i2;
                fMeasureText4 += paint.measureText(str, i2, iCharCount);
                i2 = iCharCount;
            }
            if (fMeasureText3 >= fMeasureText4) {
                return false;
            }
        }
        if (fMeasureText3 != fMeasureText) {
            return true;
        }
        C0341d c0341dB = b();
        paint.getTextBounds("\udfffd", 0, 2, (Rect) c0341dB.f7671a);
        paint.getTextBounds(str, 0, length, (Rect) c0341dB.f7672b);
        return !((Rect) c0341dB.f7671a).equals(c0341dB.f7672b);
    }

    private static C0341d b() {
        ThreadLocal threadLocal = f3030a;
        C0341d c0341d = (C0341d) threadLocal.get();
        if (c0341d == null) {
            C0341d c0341d2 = new C0341d(new Rect(), new Rect());
            threadLocal.set(c0341d2);
            return c0341d2;
        }
        ((Rect) c0341d.f7671a).setEmpty();
        ((Rect) c0341d.f7672b).setEmpty();
        return c0341d;
    }
}
