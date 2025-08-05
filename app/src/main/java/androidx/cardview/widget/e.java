package androidx.cardview.widget;

import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
abstract class e extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private static final double f2581a = Math.cos(Math.toRadians(45.0d));

    static float a(float f2, float f3, boolean z2) {
        return z2 ? (float) (f2 + ((1.0d - f2581a) * f3)) : f2;
    }

    static float b(float f2, float f3, boolean z2) {
        return z2 ? (float) ((f2 * 1.5f) + ((1.0d - f2581a) * f3)) : f2 * 1.5f;
    }
}
