package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import defpackage.e;

/* loaded from: classes.dex */
public abstract class Z {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal f2356a = new ThreadLocal();

    /* renamed from: b, reason: collision with root package name */
    static final int[] f2357b = {-16842910};

    /* renamed from: c, reason: collision with root package name */
    static final int[] f2358c = {R.attr.state_focused};

    /* renamed from: d, reason: collision with root package name */
    static final int[] f2359d = {R.attr.state_activated};
    static final int[] e = {R.attr.state_pressed};

    /* renamed from: f, reason: collision with root package name */
    static final int[] f2360f = {R.attr.state_checked};

    /* renamed from: g, reason: collision with root package name */
    static final int[] f2361g = {R.attr.state_selected};

    /* renamed from: h, reason: collision with root package name */
    static final int[] f2362h = {-16842919, -16842908};

    /* renamed from: i, reason: collision with root package name */
    static final int[] f2363i = new int[0];

    /* renamed from: j, reason: collision with root package name */
    private static final int[] f2364j = new int[1];

    public static void a(View view, Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(e.m.f6090y0);
        try {
            if (!typedArrayObtainStyledAttributes.hasValue(e.m.f5979D0)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static int b(Context context, int i2) {
        ColorStateList colorStateListE = e(context, i2);
        if (colorStateListE != null && colorStateListE.isStateful()) {
            return colorStateListE.getColorForState(f2357b, colorStateListE.getDefaultColor());
        }
        TypedValue typedValueF = f();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValueF, true);
        return d(context, i2, typedValueF.getFloat());
    }

    public static int c(Context context, int i2) {
        int[] iArr = f2364j;
        iArr[0] = i2;
        d0 d0VarT = d0.t(context, null, iArr);
        try {
            return d0VarT.b(0, 0);
        } finally {
            d0VarT.w();
        }
    }

    static int d(Context context, int i2, float f2) {
        return androidx.core.graphics.a.f(c(context, i2), Math.round(Color.alpha(r0) * f2));
    }

    public static ColorStateList e(Context context, int i2) {
        int[] iArr = f2364j;
        iArr[0] = i2;
        d0 d0VarT = d0.t(context, null, iArr);
        try {
            return d0VarT.c(0);
        } finally {
            d0VarT.w();
        }
    }

    private static TypedValue f() {
        ThreadLocal threadLocal = f2356a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }
}
