package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import defpackage.e;
import f.AbstractC0250a;

/* renamed from: androidx.appcompat.widget.h */
/* loaded from: classes.dex */
public class C0140h extends CheckedTextView implements androidx.core.widget.m {

    /* renamed from: a */
    private final C0141i f2433a;

    /* renamed from: b */
    private final C0137e f2434b;

    /* renamed from: c */
    private final D f2435c;

    /* renamed from: d */
    private C0145m f2436d;

    public C0140h(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, e.d.f5849p);
    }

    private C0145m getEmojiTextViewHelper() {
        if (this.f2436d == null) {
            this.f2436d = new C0145m(this);
        }
        return this.f2436d;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        D d2 = this.f2435c;
        if (d2 != null) {
            d2.b();
        }
        C0137e c0137e = this.f2434b;
        if (c0137e != null) {
            c0137e.b();
        }
        C0141i c0141i = this.f2433a;
        if (c0141i != null) {
            c0141i.a();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.j.p(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0137e c0137e = this.f2434b;
        if (c0137e != null) {
            return c0137e.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0137e c0137e = this.f2434b;
        if (c0137e != null) {
            return c0137e.d();
        }
        return null;
    }

    public ColorStateList getSupportCheckMarkTintList() {
        C0141i c0141i = this.f2433a;
        if (c0141i != null) {
            return c0141i.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        C0141i c0141i = this.f2433a;
        if (c0141i != null) {
            return c0141i.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f2435c.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f2435c.k();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return AbstractC0146n.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z2) {
        super.setAllCaps(z2);
        getEmojiTextViewHelper().c(z2);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0137e c0137e = this.f2434b;
        if (c0137e != null) {
            c0137e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0137e c0137e = this.f2434b;
        if (c0137e != null) {
            c0137e.g(i2);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        C0141i c0141i = this.f2433a;
        if (c0141i != null) {
            c0141i.e();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        D d2 = this.f2435c;
        if (d2 != null) {
            d2.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        D d2 = this.f2435c;
        if (d2 != null) {
            d2.p();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.j.q(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z2) {
        getEmojiTextViewHelper().d(z2);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0137e c0137e = this.f2434b;
        if (c0137e != null) {
            c0137e.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0137e c0137e = this.f2434b;
        if (c0137e != null) {
            c0137e.j(mode);
        }
    }

    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        C0141i c0141i = this.f2433a;
        if (c0141i != null) {
            c0141i.f(colorStateList);
        }
    }

    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        C0141i c0141i = this.f2433a;
        if (c0141i != null) {
            c0141i.g(mode);
        }
    }

    @Override // androidx.core.widget.m
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f2435c.w(colorStateList);
        this.f2435c.b();
    }

    @Override // androidx.core.widget.m
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f2435c.x(mode);
        this.f2435c.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        D d2 = this.f2435c;
        if (d2 != null) {
            d2.q(context, i2);
        }
    }

    public C0140h(Context context, AttributeSet attributeSet, int i2) {
        super(a0.b(context), attributeSet, i2);
        Z.a(this, getContext());
        D d2 = new D(this);
        this.f2435c = d2;
        d2.m(attributeSet, i2);
        d2.b();
        C0137e c0137e = new C0137e(this);
        this.f2434b = c0137e;
        c0137e.e(attributeSet, i2);
        C0141i c0141i = new C0141i(this);
        this.f2433a = c0141i;
        c0141i.d(attributeSet, i2);
        getEmojiTextViewHelper().b(attributeSet, i2);
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i2) {
        setCheckMarkDrawable(AbstractC0250a.b(getContext(), i2));
    }
}
