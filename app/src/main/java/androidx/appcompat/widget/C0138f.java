package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import defpackage.e;

/* renamed from: androidx.appcompat.widget.f */
/* loaded from: classes.dex */
public class C0138f extends Button implements androidx.core.widget.m {

    /* renamed from: a */
    private final C0137e f2424a;

    /* renamed from: b */
    private final D f2425b;

    /* renamed from: c */
    private C0145m f2426c;

    public C0138f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, e.d.f5848n);
    }

    private C0145m getEmojiTextViewHelper() {
        if (this.f2426c == null) {
            this.f2426c = new C0145m(this);
        }
        return this.f2426c;
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0137e c0137e = this.f2424a;
        if (c0137e != null) {
            c0137e.b();
        }
        D d2 = this.f2425b;
        if (d2 != null) {
            d2.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (o0.f2505c) {
            return super.getAutoSizeMaxTextSize();
        }
        D d2 = this.f2425b;
        if (d2 != null) {
            return d2.e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (o0.f2505c) {
            return super.getAutoSizeMinTextSize();
        }
        D d2 = this.f2425b;
        if (d2 != null) {
            return d2.f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (o0.f2505c) {
            return super.getAutoSizeStepGranularity();
        }
        D d2 = this.f2425b;
        if (d2 != null) {
            return d2.g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (o0.f2505c) {
            return super.getAutoSizeTextAvailableSizes();
        }
        D d2 = this.f2425b;
        return d2 != null ? d2.h() : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (o0.f2505c) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        D d2 = this.f2425b;
        if (d2 != null) {
            return d2.i();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.j.p(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0137e c0137e = this.f2424a;
        if (c0137e != null) {
            return c0137e.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0137e c0137e = this.f2424a;
        if (c0137e != null) {
            return c0137e.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f2425b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f2425b.k();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        D d2 = this.f2425b;
        if (d2 != null) {
            d2.o(z2, i2, i3, i4, i5);
        }
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        D d2 = this.f2425b;
        if (d2 == null || o0.f2505c || !d2.l()) {
            return;
        }
        this.f2425b.c();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z2) {
        super.setAllCaps(z2);
        getEmojiTextViewHelper().c(z2);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i3, int i4, int i5) {
        if (o0.f2505c) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
            return;
        }
        D d2 = this.f2425b;
        if (d2 != null) {
            d2.t(i2, i3, i4, i5);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i2) {
        if (o0.f2505c) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
            return;
        }
        D d2 = this.f2425b;
        if (d2 != null) {
            d2.u(iArr, i2);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i2) {
        if (o0.f2505c) {
            super.setAutoSizeTextTypeWithDefaults(i2);
            return;
        }
        D d2 = this.f2425b;
        if (d2 != null) {
            d2.v(i2);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0137e c0137e = this.f2424a;
        if (c0137e != null) {
            c0137e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0137e c0137e = this.f2424a;
        if (c0137e != null) {
            c0137e.g(i2);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.j.q(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z2) {
        getEmojiTextViewHelper().d(z2);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportAllCaps(boolean z2) {
        D d2 = this.f2425b;
        if (d2 != null) {
            d2.s(z2);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0137e c0137e = this.f2424a;
        if (c0137e != null) {
            c0137e.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0137e c0137e = this.f2424a;
        if (c0137e != null) {
            c0137e.j(mode);
        }
    }

    @Override // androidx.core.widget.m
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f2425b.w(colorStateList);
        this.f2425b.b();
    }

    @Override // androidx.core.widget.m
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f2425b.x(mode);
        this.f2425b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        D d2 = this.f2425b;
        if (d2 != null) {
            d2.q(context, i2);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i2, float f2) {
        if (o0.f2505c) {
            super.setTextSize(i2, f2);
            return;
        }
        D d2 = this.f2425b;
        if (d2 != null) {
            d2.A(i2, f2);
        }
    }

    public C0138f(Context context, AttributeSet attributeSet, int i2) {
        super(a0.b(context), attributeSet, i2);
        Z.a(this, getContext());
        C0137e c0137e = new C0137e(this);
        this.f2424a = c0137e;
        c0137e.e(attributeSet, i2);
        D d2 = new D(this);
        this.f2425b = d2;
        d2.m(attributeSet, i2);
        d2.b();
        getEmojiTextViewHelper().b(attributeSet, i2);
    }
}
