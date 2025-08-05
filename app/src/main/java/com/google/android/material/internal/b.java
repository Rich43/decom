package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import u0.AbstractC0331a;
import u0.AbstractC0337g;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f5732a = {AbstractC0331a.f7562a};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f5733b = {AbstractC0331a.f7563b};

    public static void a(Context context) {
        e(context, f5732a, "Theme.AppCompat");
    }

    private static void b(Context context, AttributeSet attributeSet, int i2, int i3) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0337g.f7597K0, i2, i3);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(AbstractC0337g.f7601M0, false);
        typedArrayObtainStyledAttributes.recycle();
        if (z2) {
            c(context);
        }
        a(context);
    }

    public static void c(Context context) {
        e(context, f5733b, "Theme.MaterialComponents");
    }

    private static void d(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3, int... iArr2) {
        boolean zF;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0337g.f7597K0, i2, i3);
        if (!typedArrayObtainStyledAttributes.getBoolean(AbstractC0337g.f7603N0, false)) {
            typedArrayObtainStyledAttributes.recycle();
            return;
        }
        if (iArr2 == null || iArr2.length == 0) {
            zF = typedArrayObtainStyledAttributes.getResourceId(AbstractC0337g.f7599L0, -1) != -1;
        } else {
            zF = f(context, attributeSet, iArr, i2, i3, iArr2);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!zF) {
            throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        }
    }

    private static void e(Context context, int[] iArr, String str) {
        if (g(context, iArr)) {
            return;
        }
        throw new IllegalArgumentException("The style on this component requires your app theme to be " + str + " (or a descendant).");
    }

    private static boolean f(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3, int... iArr2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
        for (int i4 : iArr2) {
            if (typedArrayObtainStyledAttributes.getResourceId(i4, -1) == -1) {
                typedArrayObtainStyledAttributes.recycle();
                return false;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return true;
    }

    private static boolean g(Context context, int[] iArr) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(0);
        typedArrayObtainStyledAttributes.recycle();
        return zHasValue;
    }

    public static TypedArray h(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3, int... iArr2) {
        b(context, attributeSet, i2, i3);
        d(context, attributeSet, iArr, i2, i3, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
    }
}
