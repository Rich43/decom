package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/* loaded from: classes.dex */
public class J extends ToggleButton implements androidx.core.widget.m {

    /* renamed from: a, reason: collision with root package name */
    private final C0137e f2190a;

    /* renamed from: b, reason: collision with root package name */
    private final D f2191b;

    /* renamed from: c, reason: collision with root package name */
    private C0145m f2192c;

    public J(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyleToggle);
    }

    private C0145m getEmojiTextViewHelper() {
        if (this.f2192c == null) {
            this.f2192c = new C0145m(this);
        }
        return this.f2192c;
    }

    @Override // android.widget.ToggleButton, android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0137e c0137e = this.f2190a;
        if (c0137e != null) {
            c0137e.b();
        }
        D d2 = this.f2191b;
        if (d2 != null) {
            d2.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0137e c0137e = this.f2190a;
        if (c0137e != null) {
            return c0137e.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0137e c0137e = this.f2190a;
        if (c0137e != null) {
            return c0137e.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f2191b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f2191b.k();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z2) {
        super.setAllCaps(z2);
        getEmojiTextViewHelper().c(z2);
    }

    @Override // android.widget.ToggleButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0137e c0137e = this.f2190a;
        if (c0137e != null) {
            c0137e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0137e c0137e = this.f2190a;
        if (c0137e != null) {
            c0137e.g(i2);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        D d2 = this.f2191b;
        if (d2 != null) {
            d2.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        D d2 = this.f2191b;
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
        C0137e c0137e = this.f2190a;
        if (c0137e != null) {
            c0137e.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0137e c0137e = this.f2190a;
        if (c0137e != null) {
            c0137e.j(mode);
        }
    }

    @Override // androidx.core.widget.m
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f2191b.w(colorStateList);
        this.f2191b.b();
    }

    @Override // androidx.core.widget.m
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f2191b.x(mode);
        this.f2191b.b();
    }

    public J(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Z.a(this, getContext());
        C0137e c0137e = new C0137e(this);
        this.f2190a = c0137e;
        c0137e.e(attributeSet, i2);
        D d2 = new D(this);
        this.f2191b = d2;
        d2.m(attributeSet, i2);
        getEmojiTextViewHelper().b(attributeSet, i2);
    }
}
