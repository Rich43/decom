package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import defpackage.e;
import f.AbstractC0250a;

/* renamed from: androidx.appcompat.widget.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0136d extends AutoCompleteTextView implements androidx.core.widget.m {

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f2411d = {R.attr.popupBackground};

    /* renamed from: a, reason: collision with root package name */
    private final C0137e f2412a;

    /* renamed from: b, reason: collision with root package name */
    private final D f2413b;

    /* renamed from: c, reason: collision with root package name */
    private final C0144l f2414c;

    public C0136d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, e.d.f5847m);
    }

    void a(C0144l c0144l) {
        KeyListener keyListener = getKeyListener();
        if (c0144l.b(keyListener)) {
            boolean zIsFocusable = super.isFocusable();
            boolean zIsClickable = super.isClickable();
            boolean zIsLongClickable = super.isLongClickable();
            int inputType = super.getInputType();
            KeyListener keyListenerA = c0144l.a(keyListener);
            if (keyListenerA == keyListener) {
                return;
            }
            super.setKeyListener(keyListenerA);
            super.setRawInputType(inputType);
            super.setFocusable(zIsFocusable);
            super.setClickable(zIsClickable);
            super.setLongClickable(zIsLongClickable);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0137e c0137e = this.f2412a;
        if (c0137e != null) {
            c0137e.b();
        }
        D d2 = this.f2413b;
        if (d2 != null) {
            d2.b();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.j.p(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0137e c0137e = this.f2412a;
        if (c0137e != null) {
            return c0137e.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0137e c0137e = this.f2412a;
        if (c0137e != null) {
            return c0137e.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f2413b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f2413b.k();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return this.f2414c.d(AbstractC0146n.a(super.onCreateInputConnection(editorInfo), editorInfo, this), editorInfo);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0137e c0137e = this.f2412a;
        if (c0137e != null) {
            c0137e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0137e c0137e = this.f2412a;
        if (c0137e != null) {
            c0137e.g(i2);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        D d2 = this.f2413b;
        if (d2 != null) {
            d2.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        D d2 = this.f2413b;
        if (d2 != null) {
            d2.p();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.j.q(this, callback));
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i2) {
        setDropDownBackgroundDrawable(AbstractC0250a.b(getContext(), i2));
    }

    public void setEmojiCompatEnabled(boolean z2) {
        this.f2414c.e(z2);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f2414c.a(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0137e c0137e = this.f2412a;
        if (c0137e != null) {
            c0137e.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0137e c0137e = this.f2412a;
        if (c0137e != null) {
            c0137e.j(mode);
        }
    }

    @Override // androidx.core.widget.m
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f2413b.w(colorStateList);
        this.f2413b.b();
    }

    @Override // androidx.core.widget.m
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f2413b.x(mode);
        this.f2413b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        D d2 = this.f2413b;
        if (d2 != null) {
            d2.q(context, i2);
        }
    }

    public C0136d(Context context, AttributeSet attributeSet, int i2) {
        super(a0.b(context), attributeSet, i2);
        Z.a(this, getContext());
        d0 d0VarU = d0.u(getContext(), attributeSet, f2411d, i2, 0);
        if (d0VarU.r(0)) {
            setDropDownBackgroundDrawable(d0VarU.f(0));
        }
        d0VarU.w();
        C0137e c0137e = new C0137e(this);
        this.f2412a = c0137e;
        c0137e.e(attributeSet, i2);
        D d2 = new D(this);
        this.f2413b = d2;
        d2.m(attributeSet, i2);
        d2.b();
        C0144l c0144l = new C0144l(this);
        this.f2414c = c0144l;
        c0144l.c(attributeSet, i2);
        a(c0144l);
    }
}
