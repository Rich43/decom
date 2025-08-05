package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.text.m;
import f.AbstractC0250a;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public class E extends TextView implements androidx.core.widget.m {

    /* renamed from: a, reason: collision with root package name */
    private final C0137e f2167a;

    /* renamed from: b, reason: collision with root package name */
    private final D f2168b;

    /* renamed from: c, reason: collision with root package name */
    private final C f2169c;

    /* renamed from: d, reason: collision with root package name */
    private C0145m f2170d;
    private boolean e;

    /* renamed from: f, reason: collision with root package name */
    private a f2171f;

    /* renamed from: g, reason: collision with root package name */
    private Future f2172g;

    private interface a {
        void a(int[] iArr, int i2);

        void b(TextClassifier textClassifier);

        int c();

        int[] d();

        void e(int i2);

        void f(int i2);

        TextClassifier g();

        int h();

        int i();

        void j(int i2);

        void k(int i2, int i3, int i4, int i5);

        void l(int i2, float f2);

        int m();
    }

    class b implements a {
        b() {
        }

        @Override // androidx.appcompat.widget.E.a
        public void a(int[] iArr, int i2) {
            E.super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
        }

        @Override // androidx.appcompat.widget.E.a
        public void b(TextClassifier textClassifier) {
            E.super.setTextClassifier(textClassifier);
        }

        @Override // androidx.appcompat.widget.E.a
        public int c() {
            return E.super.getAutoSizeMinTextSize();
        }

        @Override // androidx.appcompat.widget.E.a
        public int[] d() {
            return E.super.getAutoSizeTextAvailableSizes();
        }

        @Override // androidx.appcompat.widget.E.a
        public void e(int i2) {
        }

        @Override // androidx.appcompat.widget.E.a
        public void f(int i2) {
        }

        @Override // androidx.appcompat.widget.E.a
        public TextClassifier g() {
            return E.super.getTextClassifier();
        }

        @Override // androidx.appcompat.widget.E.a
        public int h() {
            return E.super.getAutoSizeStepGranularity();
        }

        @Override // androidx.appcompat.widget.E.a
        public int i() {
            return E.super.getAutoSizeMaxTextSize();
        }

        @Override // androidx.appcompat.widget.E.a
        public void j(int i2) {
            E.super.setAutoSizeTextTypeWithDefaults(i2);
        }

        @Override // androidx.appcompat.widget.E.a
        public void k(int i2, int i3, int i4, int i5) {
            E.super.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
        }

        @Override // androidx.appcompat.widget.E.a
        public void l(int i2, float f2) {
        }

        @Override // androidx.appcompat.widget.E.a
        public int m() {
            return E.super.getAutoSizeTextType();
        }
    }

    class c extends b {
        c() {
            super();
        }

        @Override // androidx.appcompat.widget.E.b, androidx.appcompat.widget.E.a
        public void e(int i2) {
            E.super.setLastBaselineToBottomHeight(i2);
        }

        @Override // androidx.appcompat.widget.E.b, androidx.appcompat.widget.E.a
        public void f(int i2) {
            E.super.setFirstBaselineToTopHeight(i2);
        }
    }

    class d extends c {
        d() {
            super();
        }

        @Override // androidx.appcompat.widget.E.b, androidx.appcompat.widget.E.a
        public void l(int i2, float f2) {
            E.super.setLineHeight(i2, f2);
        }
    }

    public E(Context context) {
        this(context, null);
    }

    private C0145m getEmojiTextViewHelper() {
        if (this.f2170d == null) {
            this.f2170d = new C0145m(this);
        }
        return this.f2170d;
    }

    private void r() {
        Future future = this.f2172g;
        if (future != null) {
            try {
                this.f2172g = null;
                androidx.appcompat.app.F.a(future.get());
                androidx.core.widget.j.m(this, null);
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0137e c0137e = this.f2167a;
        if (c0137e != null) {
            c0137e.b();
        }
        D d2 = this.f2168b;
        if (d2 != null) {
            d2.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (o0.f2505c) {
            return getSuperCaller().i();
        }
        D d2 = this.f2168b;
        if (d2 != null) {
            return d2.e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (o0.f2505c) {
            return getSuperCaller().c();
        }
        D d2 = this.f2168b;
        if (d2 != null) {
            return d2.f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (o0.f2505c) {
            return getSuperCaller().h();
        }
        D d2 = this.f2168b;
        if (d2 != null) {
            return d2.g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (o0.f2505c) {
            return getSuperCaller().d();
        }
        D d2 = this.f2168b;
        return d2 != null ? d2.h() : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (o0.f2505c) {
            return getSuperCaller().m() == 1 ? 1 : 0;
        }
        D d2 = this.f2168b;
        if (d2 != null) {
            return d2.i();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.j.p(super.getCustomSelectionActionModeCallback());
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return androidx.core.widget.j.a(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return androidx.core.widget.j.b(this);
    }

    a getSuperCaller() {
        if (this.f2171f == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 34) {
                this.f2171f = new d();
            } else if (i2 >= 28) {
                this.f2171f = new c();
            } else if (i2 >= 26) {
                this.f2171f = new b();
            }
        }
        return this.f2171f;
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0137e c0137e = this.f2167a;
        if (c0137e != null) {
            return c0137e.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0137e c0137e = this.f2167a;
        if (c0137e != null) {
            return c0137e.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f2168b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f2168b.k();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        r();
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        C c2;
        return (Build.VERSION.SDK_INT >= 28 || (c2 = this.f2169c) == null) ? getSuperCaller().g() : c2.a();
    }

    public m.a getTextMetricsParamsCompat() {
        return androidx.core.widget.j.e(this);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f2168b.r(this, inputConnectionOnCreateInputConnection, editorInfo);
        return AbstractC0146n.a(inputConnectionOnCreateInputConnection, editorInfo, this);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 30 || i2 >= 33 || !onCheckIsTextEditor()) {
            return;
        }
        ((InputMethodManager) getContext().getSystemService("input_method")).isActive(this);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        D d2 = this.f2168b;
        if (d2 != null) {
            d2.o(z2, i2, i3, i4, i5);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i2, int i3) {
        r();
        super.onMeasure(i2, i3);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        D d2 = this.f2168b;
        if (d2 == null || o0.f2505c || !d2.l()) {
            return;
        }
        this.f2168b.c();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z2) {
        super.setAllCaps(z2);
        getEmojiTextViewHelper().c(z2);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i3, int i4, int i5) {
        if (o0.f2505c) {
            getSuperCaller().k(i2, i3, i4, i5);
            return;
        }
        D d2 = this.f2168b;
        if (d2 != null) {
            d2.t(i2, i3, i4, i5);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i2) {
        if (o0.f2505c) {
            getSuperCaller().a(iArr, i2);
            return;
        }
        D d2 = this.f2168b;
        if (d2 != null) {
            d2.u(iArr, i2);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i2) {
        if (o0.f2505c) {
            getSuperCaller().j(i2);
            return;
        }
        D d2 = this.f2168b;
        if (d2 != null) {
            d2.v(i2);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0137e c0137e = this.f2167a;
        if (c0137e != null) {
            c0137e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0137e c0137e = this.f2167a;
        if (c0137e != null) {
            c0137e.g(i2);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        D d2 = this.f2168b;
        if (d2 != null) {
            d2.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        D d2 = this.f2168b;
        if (d2 != null) {
            d2.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        D d2 = this.f2168b;
        if (d2 != null) {
            d2.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        D d2 = this.f2168b;
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

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().f(i2);
        } else {
            androidx.core.widget.j.i(this, i2);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().e(i2);
        } else {
            androidx.core.widget.j.j(this, i2);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i2) {
        androidx.core.widget.j.k(this, i2);
    }

    public void setPrecomputedText(androidx.core.text.m mVar) {
        androidx.core.widget.j.m(this, mVar);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0137e c0137e = this.f2167a;
        if (c0137e != null) {
            c0137e.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0137e c0137e = this.f2167a;
        if (c0137e != null) {
            c0137e.j(mode);
        }
    }

    @Override // androidx.core.widget.m
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f2168b.w(colorStateList);
        this.f2168b.b();
    }

    @Override // androidx.core.widget.m
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f2168b.x(mode);
        this.f2168b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        D d2 = this.f2168b;
        if (d2 != null) {
            d2.q(context, i2);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        C c2;
        if (Build.VERSION.SDK_INT >= 28 || (c2 = this.f2169c) == null) {
            getSuperCaller().b(textClassifier);
        } else {
            c2.b(textClassifier);
        }
    }

    public void setTextFuture(Future<androidx.core.text.m> future) {
        this.f2172g = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(m.a aVar) {
        androidx.core.widget.j.o(this, aVar);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i2, float f2) {
        if (o0.f2505c) {
            super.setTextSize(i2, f2);
            return;
        }
        D d2 = this.f2168b;
        if (d2 != null) {
            d2.A(i2, f2);
        }
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface, int i2) {
        if (this.e) {
            return;
        }
        Typeface typefaceA = (typeface == null || i2 <= 0) ? null : androidx.core.graphics.i.a(getContext(), typeface, i2);
        this.e = true;
        if (typefaceA != null) {
            typeface = typefaceA;
        }
        try {
            super.setTypeface(typeface, i2);
        } finally {
            this.e = false;
        }
    }

    public E(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i2, float f2) {
        if (Build.VERSION.SDK_INT >= 34) {
            getSuperCaller().l(i2, f2);
        } else {
            androidx.core.widget.j.l(this, i2, f2);
        }
    }

    public E(Context context, AttributeSet attributeSet, int i2) {
        super(a0.b(context), attributeSet, i2);
        this.e = false;
        this.f2171f = null;
        Z.a(this, getContext());
        C0137e c0137e = new C0137e(this);
        this.f2167a = c0137e;
        c0137e.e(attributeSet, i2);
        D d2 = new D(this);
        this.f2168b = d2;
        d2.m(attributeSet, i2);
        d2.b();
        this.f2169c = new C(this);
        getEmojiTextViewHelper().b(attributeSet, i2);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i2 != 0 ? AbstractC0250a.b(context, i2) : null, i3 != 0 ? AbstractC0250a.b(context, i3) : null, i4 != 0 ? AbstractC0250a.b(context, i4) : null, i5 != 0 ? AbstractC0250a.b(context, i5) : null);
        D d2 = this.f2168b;
        if (d2 != null) {
            d2.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i2 != 0 ? AbstractC0250a.b(context, i2) : null, i3 != 0 ? AbstractC0250a.b(context, i3) : null, i4 != 0 ? AbstractC0250a.b(context, i4) : null, i5 != 0 ? AbstractC0250a.b(context, i5) : null);
        D d2 = this.f2168b;
        if (d2 != null) {
            d2.p();
        }
    }
}
