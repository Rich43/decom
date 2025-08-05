package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.RadioButton;
import defpackage.e;
import f.AbstractC0250a;

/* renamed from: androidx.appcompat.widget.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0152u extends RadioButton implements androidx.core.widget.m {

    /* renamed from: a, reason: collision with root package name */
    private final C0142j f2522a;

    /* renamed from: b, reason: collision with root package name */
    private final C0137e f2523b;

    /* renamed from: c, reason: collision with root package name */
    private final D f2524c;

    /* renamed from: d, reason: collision with root package name */
    private C0145m f2525d;

    public C0152u(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, e.d.f5830C);
    }

    private C0145m getEmojiTextViewHelper() {
        if (this.f2525d == null) {
            this.f2525d = new C0145m(this);
        }
        return this.f2525d;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0137e c0137e = this.f2523b;
        if (c0137e != null) {
            c0137e.b();
        }
        D d2 = this.f2524c;
        if (d2 != null) {
            d2.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0137e c0137e = this.f2523b;
        if (c0137e != null) {
            return c0137e.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0137e c0137e = this.f2523b;
        if (c0137e != null) {
            return c0137e.d();
        }
        return null;
    }

    public ColorStateList getSupportButtonTintList() {
        C0142j c0142j = this.f2522a;
        if (c0142j != null) {
            return c0142j.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        C0142j c0142j = this.f2522a;
        if (c0142j != null) {
            return c0142j.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f2524c.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f2524c.k();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z2) {
        super.setAllCaps(z2);
        getEmojiTextViewHelper().c(z2);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0137e c0137e = this.f2523b;
        if (c0137e != null) {
            c0137e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0137e c0137e = this.f2523b;
        if (c0137e != null) {
            c0137e.g(i2);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) throws NoSuchFieldException, SecurityException {
        super.setButtonDrawable(drawable);
        C0142j c0142j = this.f2522a;
        if (c0142j != null) {
            c0142j.e();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        D d2 = this.f2524c;
        if (d2 != null) {
            d2.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        D d2 = this.f2524c;
        if (d2 != null) {
            d2.p();
        }
    }

    public void setEmojiCompatEnabled(boolean z2) {
        getEmojiTextViewHelper().d(z2);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0137e c0137e = this.f2523b;
        if (c0137e != null) {
            c0137e.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0137e c0137e = this.f2523b;
        if (c0137e != null) {
            c0137e.j(mode);
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) throws NoSuchFieldException, SecurityException {
        C0142j c0142j = this.f2522a;
        if (c0142j != null) {
            c0142j.f(colorStateList);
        }
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) throws NoSuchFieldException, SecurityException {
        C0142j c0142j = this.f2522a;
        if (c0142j != null) {
            c0142j.g(mode);
        }
    }

    @Override // androidx.core.widget.m
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f2524c.w(colorStateList);
        this.f2524c.b();
    }

    @Override // androidx.core.widget.m
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f2524c.x(mode);
        this.f2524c.b();
    }

    public C0152u(Context context, AttributeSet attributeSet, int i2) {
        super(a0.b(context), attributeSet, i2);
        Z.a(this, getContext());
        C0142j c0142j = new C0142j(this);
        this.f2522a = c0142j;
        c0142j.d(attributeSet, i2);
        C0137e c0137e = new C0137e(this);
        this.f2523b = c0137e;
        c0137e.e(attributeSet, i2);
        D d2 = new D(this);
        this.f2524c = d2;
        d2.m(attributeSet, i2);
        getEmojiTextViewHelper().b(attributeSet, i2);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i2) throws NoSuchFieldException, SecurityException {
        setButtonDrawable(AbstractC0250a.b(getContext(), i2));
    }
}
