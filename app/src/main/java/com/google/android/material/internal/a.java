package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.appcompat.widget.Q;
import u0.AbstractC0337g;

/* loaded from: classes.dex */
public abstract class a extends Q {

    /* renamed from: p, reason: collision with root package name */
    private Drawable f5728p;

    /* renamed from: q, reason: collision with root package name */
    private final Rect f5729q;
    private final Rect r;
    private int s;

    /* renamed from: t, reason: collision with root package name */
    protected boolean f5730t;

    /* renamed from: u, reason: collision with root package name */
    boolean f5731u;

    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f5729q = new Rect();
        this.r = new Rect();
        this.s = 119;
        this.f5730t = true;
        this.f5731u = false;
        TypedArray typedArrayH = b.h(context, attributeSet, AbstractC0337g.f7602N, i2, 0, new int[0]);
        this.s = typedArrayH.getInt(AbstractC0337g.f7606P, this.s);
        Drawable drawable = typedArrayH.getDrawable(AbstractC0337g.f7604O);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f5730t = typedArrayH.getBoolean(AbstractC0337g.f7608Q, true);
        typedArrayH.recycle();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f5728p;
        if (drawable != null) {
            if (this.f5731u) {
                this.f5731u = false;
                Rect rect = this.f5729q;
                Rect rect2 = this.r;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f5730t) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.s, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    public void drawableHotspotChanged(float f2, float f3) {
        super.drawableHotspotChanged(f2, f3);
        Drawable drawable = this.f5728p;
        if (drawable != null) {
            drawable.setHotspot(f2, f3);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f5728p;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.f5728p.setState(getDrawableState());
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.f5728p;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.s;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f5728p;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // androidx.appcompat.widget.Q, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        this.f5731u = z2 | this.f5731u;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f5731u = true;
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.f5728p;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f5728p);
            }
            this.f5728p = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.s == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i2) {
        if (this.s != i2) {
            if ((8388615 & i2) == 0) {
                i2 |= 8388611;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.s = i2;
            if (i2 == 119 && this.f5728p != null) {
                this.f5728p.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f5728p;
    }
}
