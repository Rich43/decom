package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class e extends d {

    /* renamed from: h, reason: collision with root package name */
    private static Method f3021h;

    e(Drawable drawable) {
        super(drawable);
        g();
    }

    private void g() {
        if (f3021h == null) {
            try {
                f3021h = Drawable.class.getDeclaredMethod("isProjected", null);
            } catch (Exception e) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", e);
            }
        }
    }

    @Override // androidx.core.graphics.drawable.d
    protected boolean c() {
        if (Build.VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.f3020f;
        return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable);
    }

    @Override // android.graphics.drawable.Drawable
    public Rect getDirtyBounds() {
        return this.f3020f.getDirtyBounds();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.f3020f.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isProjected() {
        Method method;
        Drawable drawable = this.f3020f;
        if (drawable == null || (method = f3021h) == null) {
            return false;
        }
        try {
            return ((Boolean) method.invoke(drawable, null)).booleanValue();
        } catch (Exception e) {
            Log.w("WrappedDrawableApi21", "Error calling Drawable#isProjected() method", e);
            return false;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f2, float f3) {
        this.f3020f.setHotspot(f2, f3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        this.f3020f.setHotspotBounds(i2, i3, i4, i5);
    }

    @Override // androidx.core.graphics.drawable.d, android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    @Override // androidx.core.graphics.drawable.d, android.graphics.drawable.Drawable
    public void setTint(int i2) {
        if (c()) {
            super.setTint(i2);
        } else {
            this.f3020f.setTint(i2);
        }
    }

    @Override // androidx.core.graphics.drawable.d, android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        if (c()) {
            super.setTintList(colorStateList);
        } else {
            this.f3020f.setTintList(colorStateList);
        }
    }

    @Override // androidx.core.graphics.drawable.d, android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (c()) {
            super.setTintMode(mode);
        } else {
            this.f3020f.setTintMode(mode);
        }
    }

    e(f fVar, Resources resources) {
        super(fVar, resources);
        g();
    }
}
