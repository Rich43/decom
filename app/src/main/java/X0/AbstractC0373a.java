package x0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import f.AbstractC0250a;

/* renamed from: x0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0373a {
    public static ColorStateList a(Context context, TypedArray typedArray, int i2) {
        int resourceId;
        ColorStateList colorStateListA;
        return (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0 || (colorStateListA = AbstractC0250a.a(context, resourceId)) == null) ? typedArray.getColorStateList(i2) : colorStateListA;
    }

    public static Drawable b(Context context, TypedArray typedArray, int i2) {
        int resourceId;
        Drawable drawableB;
        return (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0 || (drawableB = AbstractC0250a.b(context, resourceId)) == null) ? typedArray.getDrawable(i2) : drawableB;
    }
}
