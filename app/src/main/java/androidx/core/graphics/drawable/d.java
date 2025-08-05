package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
abstract class d extends Drawable implements Drawable.Callback, c, b {

    /* renamed from: g */
    static final PorterDuff.Mode f3015g = PorterDuff.Mode.SRC_IN;

    /* renamed from: a */
    private int f3016a;

    /* renamed from: b */
    private PorterDuff.Mode f3017b;

    /* renamed from: c */
    private boolean f3018c;

    /* renamed from: d */
    f f3019d;
    private boolean e;

    /* renamed from: f */
    Drawable f3020f;

    d(f fVar, Resources resources) {
        this.f3019d = fVar;
        e(resources);
    }

    private f d() {
        return new f(this.f3019d);
    }

    private void e(Resources resources) {
        Drawable.ConstantState constantState;
        f fVar = this.f3019d;
        if (fVar == null || (constantState = fVar.f3023b) == null) {
            return;
        }
        b(constantState.newDrawable(resources));
    }

    private boolean f(int[] iArr) {
        if (!c()) {
            return false;
        }
        f fVar = this.f3019d;
        ColorStateList colorStateList = fVar.f3024c;
        PorterDuff.Mode mode = fVar.f3025d;
        if (colorStateList == null || mode == null) {
            this.f3018c = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!this.f3018c || colorForState != this.f3016a || mode != this.f3017b) {
                setColorFilter(colorForState, mode);
                this.f3016a = colorForState;
                this.f3017b = mode;
                this.f3018c = true;
                return true;
            }
        }
        return false;
    }

    @Override // androidx.core.graphics.drawable.c
    public final Drawable a() {
        return this.f3020f;
    }

    @Override // androidx.core.graphics.drawable.c
    public final void b(Drawable drawable) {
        Drawable drawable2 = this.f3020f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f3020f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            f fVar = this.f3019d;
            if (fVar != null) {
                fVar.f3023b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    protected abstract boolean c();

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f3020f.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        f fVar = this.f3019d;
        return changingConfigurations | (fVar != null ? fVar.getChangingConfigurations() : 0) | this.f3020f.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        f fVar = this.f3019d;
        if (fVar == null || !fVar.a()) {
            return null;
        }
        this.f3019d.f3022a = getChangingConfigurations();
        return this.f3019d;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f3020f.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f3020f.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f3020f.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getLayoutDirection() {
        return a.e(this.f3020f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f3020f.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f3020f.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f3020f.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.f3020f.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.f3020f.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.f3020f.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return a.g(this.f3020f);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        f fVar;
        ColorStateList colorStateList = (!c() || (fVar = this.f3019d) == null) ? null : fVar.f3024c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f3020f.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f3020f.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.e && super.mutate() == this) {
            this.f3019d = d();
            Drawable drawable = this.f3020f;
            if (drawable != null) {
                drawable.mutate();
            }
            f fVar = this.f3019d;
            if (fVar != null) {
                Drawable drawable2 = this.f3020f;
                fVar.f3023b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.e = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f3020f;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i2) {
        return a.l(this.f3020f, i2);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i2) {
        return this.f3020f.setLevel(i2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f3020f.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z2) {
        a.i(this.f3020f, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i2) {
        this.f3020f.setChangingConfigurations(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f3020f.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z2) {
        this.f3020f.setDither(z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z2) {
        this.f3020f.setFilterBitmap(z2);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return f(iArr) || this.f3020f.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f3019d.f3024c = colorStateList;
        f(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f3019d.f3025d = mode;
        f(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        return super.setVisible(z2, z3) || this.f3020f.setVisible(z2, z3);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    d(Drawable drawable) {
        this.f3019d = d();
        b(drawable);
    }
}
