package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.widget.C0138f;
import androidx.core.view.M;
import androidx.core.widget.j;
import f.AbstractC0250a;
import u0.AbstractC0331a;
import u0.AbstractC0336f;
import u0.AbstractC0337g;
import x0.AbstractC0373a;

/* loaded from: classes.dex */
public class a extends C0138f {

    /* renamed from: d, reason: collision with root package name */
    private final c f5686d;
    private int e;

    /* renamed from: f, reason: collision with root package name */
    private PorterDuff.Mode f5687f;

    /* renamed from: g, reason: collision with root package name */
    private ColorStateList f5688g;

    /* renamed from: h, reason: collision with root package name */
    private Drawable f5689h;

    /* renamed from: i, reason: collision with root package name */
    private int f5690i;

    /* renamed from: j, reason: collision with root package name */
    private int f5691j;

    /* renamed from: k, reason: collision with root package name */
    private int f5692k;

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC0331a.f7564c);
    }

    private boolean a() {
        return M.y(this) == 1;
    }

    private boolean b() {
        c cVar = this.f5686d;
        return (cVar == null || cVar.i()) ? false : true;
    }

    private void c() {
        Drawable drawable = this.f5689h;
        if (drawable != null) {
            Drawable drawableMutate = drawable.mutate();
            this.f5689h = drawableMutate;
            androidx.core.graphics.drawable.a.n(drawableMutate, this.f5688g);
            PorterDuff.Mode mode = this.f5687f;
            if (mode != null) {
                androidx.core.graphics.drawable.a.o(this.f5689h, mode);
            }
            int intrinsicWidth = this.f5690i;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.f5689h.getIntrinsicWidth();
            }
            int intrinsicHeight = this.f5690i;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.f5689h.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f5689h;
            int i2 = this.f5691j;
            drawable2.setBounds(i2, 0, intrinsicWidth + i2, intrinsicHeight);
        }
        j.h(this, this.f5689h, null, null, null);
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (b()) {
            return this.f5686d.c();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f5689h;
    }

    public int getIconGravity() {
        return this.f5692k;
    }

    public int getIconPadding() {
        return this.e;
    }

    public int getIconSize() {
        return this.f5690i;
    }

    public ColorStateList getIconTint() {
        return this.f5688g;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f5687f;
    }

    public ColorStateList getRippleColor() {
        if (b()) {
            return this.f5686d.d();
        }
        return null;
    }

    public ColorStateList getStrokeColor() {
        if (b()) {
            return this.f5686d.e();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (b()) {
            return this.f5686d.f();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.C0138f
    public ColorStateList getSupportBackgroundTintList() {
        return b() ? this.f5686d.g() : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.C0138f
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return b() ? this.f5686d.h() : super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // androidx.appcompat.widget.C0138f, android.widget.TextView, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        c cVar;
        super.onLayout(z2, i2, i3, i4, i5);
        if (Build.VERSION.SDK_INT != 21 || (cVar = this.f5686d) == null) {
            return;
        }
        cVar.u(i5 - i3, i4 - i2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f5689h == null || this.f5692k != 2) {
            return;
        }
        int iMeasureText = (int) getPaint().measureText(getText().toString());
        int intrinsicWidth = this.f5690i;
        if (intrinsicWidth == 0) {
            intrinsicWidth = this.f5689h.getIntrinsicWidth();
        }
        int measuredWidth = (((((getMeasuredWidth() - iMeasureText) - M.C(this)) - intrinsicWidth) - this.e) - M.D(this)) / 2;
        if (a()) {
            measuredWidth = -measuredWidth;
        }
        if (this.f5691j != measuredWidth) {
            this.f5691j = measuredWidth;
            c();
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        if (b()) {
            this.f5686d.k(i2);
        } else {
            super.setBackgroundColor(i2);
        }
    }

    @Override // androidx.appcompat.widget.C0138f, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (!b()) {
            super.setBackgroundDrawable(drawable);
        } else {
            if (drawable == getBackground()) {
                getBackground().setState(drawable.getState());
                return;
            }
            Log.i("MaterialButton", "Setting a custom background is not supported.");
            this.f5686d.l();
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.C0138f, android.view.View
    public void setBackgroundResource(int i2) {
        setBackgroundDrawable(i2 != 0 ? AbstractC0250a.b(getContext(), i2) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCornerRadius(int i2) {
        if (b()) {
            this.f5686d.m(i2);
        }
    }

    public void setCornerRadiusResource(int i2) {
        if (b()) {
            setCornerRadius(getResources().getDimensionPixelSize(i2));
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.f5689h != drawable) {
            this.f5689h = drawable;
            c();
        }
    }

    public void setIconGravity(int i2) {
        this.f5692k = i2;
    }

    public void setIconPadding(int i2) {
        if (this.e != i2) {
            this.e = i2;
            setCompoundDrawablePadding(i2);
        }
    }

    public void setIconResource(int i2) {
        setIcon(i2 != 0 ? AbstractC0250a.b(getContext(), i2) : null);
    }

    public void setIconSize(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.f5690i != i2) {
            this.f5690i = i2;
            c();
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f5688g != colorStateList) {
            this.f5688g = colorStateList;
            c();
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f5687f != mode) {
            this.f5687f = mode;
            c();
        }
    }

    public void setIconTintResource(int i2) {
        setIconTint(AbstractC0250a.a(getContext(), i2));
    }

    void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (b()) {
            this.f5686d.n(colorStateList);
        }
    }

    public void setRippleColorResource(int i2) {
        if (b()) {
            setRippleColor(AbstractC0250a.a(getContext(), i2));
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (b()) {
            this.f5686d.o(colorStateList);
        }
    }

    public void setStrokeColorResource(int i2) {
        if (b()) {
            setStrokeColor(AbstractC0250a.a(getContext(), i2));
        }
    }

    public void setStrokeWidth(int i2) {
        if (b()) {
            this.f5686d.p(i2);
        }
    }

    public void setStrokeWidthResource(int i2) {
        if (b()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i2));
        }
    }

    @Override // androidx.appcompat.widget.C0138f
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (b()) {
            this.f5686d.q(colorStateList);
        } else if (this.f5686d != null) {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.C0138f
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (b()) {
            this.f5686d.r(mode);
        } else if (this.f5686d != null) {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray typedArrayH = com.google.android.material.internal.b.h(context, attributeSet, AbstractC0337g.f7614U, i2, AbstractC0336f.f7575a, new int[0]);
        this.e = typedArrayH.getDimensionPixelSize(AbstractC0337g.f7628e0, 0);
        this.f5687f = com.google.android.material.internal.c.a(typedArrayH.getInt(AbstractC0337g.f7634h0, -1), PorterDuff.Mode.SRC_IN);
        this.f5688g = AbstractC0373a.a(getContext(), typedArrayH, AbstractC0337g.f7632g0);
        this.f5689h = AbstractC0373a.b(getContext(), typedArrayH, AbstractC0337g.f7625c0);
        this.f5692k = typedArrayH.getInteger(AbstractC0337g.f7627d0, 1);
        this.f5690i = typedArrayH.getDimensionPixelSize(AbstractC0337g.f7630f0, 0);
        c cVar = new c(this);
        this.f5686d = cVar;
        cVar.j(typedArrayH);
        typedArrayH.recycle();
        setCompoundDrawablePadding(this.e);
        c();
    }
}
