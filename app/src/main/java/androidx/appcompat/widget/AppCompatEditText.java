package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import androidx.core.view.C0161d;
import defpackage.e;
import z.AbstractC0378c;

/* loaded from: classes.dex */
public class AppCompatEditText extends EditText implements androidx.core.view.H, androidx.core.widget.m {

    /* renamed from: a, reason: collision with root package name */
    private final C0137e f2129a;

    /* renamed from: b, reason: collision with root package name */
    private final D f2130b;

    /* renamed from: c, reason: collision with root package name */
    private final C f2131c;

    /* renamed from: d, reason: collision with root package name */
    private final androidx.core.widget.l f2132d;
    private final C0144l e;

    /* renamed from: f, reason: collision with root package name */
    private a f2133f;

    class a {
        a() {
        }

        public TextClassifier a() {
            return AppCompatEditText.super.getTextClassifier();
        }

        public void b(TextClassifier textClassifier) {
            AppCompatEditText.super.setTextClassifier(textClassifier);
        }
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, e.d.f5856y);
    }

    private a getSuperCaller() {
        if (this.f2133f == null) {
            this.f2133f = new a();
        }
        return this.f2133f;
    }

    @Override // androidx.core.view.H
    public C0161d a(C0161d c0161d) {
        return this.f2132d.a(this, c0161d);
    }

    void d(C0144l c0144l) {
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
        C0137e c0137e = this.f2129a;
        if (c0137e != null) {
            c0137e.b();
        }
        D d2 = this.f2130b;
        if (d2 != null) {
            d2.b();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.j.p(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0137e c0137e = this.f2129a;
        if (c0137e != null) {
            return c0137e.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0137e c0137e = this.f2129a;
        if (c0137e != null) {
            return c0137e.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f2130b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f2130b.k();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        C c2;
        return (Build.VERSION.SDK_INT >= 28 || (c2 = this.f2131c) == null) ? getSuperCaller().a() : c2.a();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        String[] strArrB;
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f2130b.r(this, inputConnectionOnCreateInputConnection, editorInfo);
        InputConnection inputConnectionA = AbstractC0146n.a(inputConnectionOnCreateInputConnection, editorInfo, this);
        if (inputConnectionA != null && Build.VERSION.SDK_INT <= 30 && (strArrB = androidx.core.view.M.B(this)) != null) {
            AbstractC0378c.d(editorInfo, strArrB);
            inputConnectionA = z.e.c(this, inputConnectionA, editorInfo);
        }
        return this.e.d(inputConnectionA, editorInfo);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 30 || i2 >= 33) {
            return;
        }
        ((InputMethodManager) getContext().getSystemService("input_method")).isActive(this);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onDragEvent(DragEvent dragEvent) {
        if (AbstractC0154w.a(this, dragEvent)) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i2) {
        if (AbstractC0154w.b(this, i2)) {
            return true;
        }
        return super.onTextContextMenuItem(i2);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0137e c0137e = this.f2129a;
        if (c0137e != null) {
            c0137e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0137e c0137e = this.f2129a;
        if (c0137e != null) {
            c0137e.g(i2);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        D d2 = this.f2130b;
        if (d2 != null) {
            d2.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        D d2 = this.f2130b;
        if (d2 != null) {
            d2.p();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.j.q(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z2) {
        this.e.e(z2);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.e.a(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0137e c0137e = this.f2129a;
        if (c0137e != null) {
            c0137e.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0137e c0137e = this.f2129a;
        if (c0137e != null) {
            c0137e.j(mode);
        }
    }

    @Override // androidx.core.widget.m
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f2130b.w(colorStateList);
        this.f2130b.b();
    }

    @Override // androidx.core.widget.m
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f2130b.x(mode);
        this.f2130b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        D d2 = this.f2130b;
        if (d2 != null) {
            d2.q(context, i2);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        C c2;
        if (Build.VERSION.SDK_INT >= 28 || (c2 = this.f2131c) == null) {
            getSuperCaller().b(textClassifier);
        } else {
            c2.b(textClassifier);
        }
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet, int i2) {
        super(a0.b(context), attributeSet, i2);
        Z.a(this, getContext());
        C0137e c0137e = new C0137e(this);
        this.f2129a = c0137e;
        c0137e.e(attributeSet, i2);
        D d2 = new D(this);
        this.f2130b = d2;
        d2.m(attributeSet, i2);
        d2.b();
        this.f2131c = new C(this);
        this.f2132d = new androidx.core.widget.l();
        C0144l c0144l = new C0144l(this);
        this.e = c0144l;
        c0144l.c(attributeSet, i2);
        d(c0144l);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : super.getEditableText();
    }
}
