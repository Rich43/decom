package androidx.core.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: androidx.core.view.animation.a$a, reason: collision with other inner class name */
    static class C0033a {
        static Interpolator a(float f2, float f3) {
            return new PathInterpolator(f2, f3);
        }

        static Interpolator b(float f2, float f3, float f4, float f5) {
            return new PathInterpolator(f2, f3, f4, f5);
        }

        static Interpolator c(Path path) {
            return new PathInterpolator(path);
        }
    }

    public static Interpolator a(float f2, float f3, float f4, float f5) {
        return C0033a.b(f2, f3, f4, f5);
    }
}
