package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import defpackage.e;
import f.AbstractC0250a;

/* renamed from: androidx.appcompat.widget.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0141i {

    /* renamed from: a, reason: collision with root package name */
    private final CheckedTextView f2457a;

    /* renamed from: b, reason: collision with root package name */
    private ColorStateList f2458b = null;

    /* renamed from: c, reason: collision with root package name */
    private PorterDuff.Mode f2459c = null;

    /* renamed from: d, reason: collision with root package name */
    private boolean f2460d = false;
    private boolean e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f2461f;

    C0141i(CheckedTextView checkedTextView) {
        this.f2457a = checkedTextView;
    }

    void a() {
        Drawable drawableA = androidx.core.widget.b.a(this.f2457a);
        if (drawableA != null) {
            if (this.f2460d || this.e) {
                Drawable drawableMutate = androidx.core.graphics.drawable.a.p(drawableA).mutate();
                if (this.f2460d) {
                    androidx.core.graphics.drawable.a.n(drawableMutate, this.f2458b);
                }
                if (this.e) {
                    androidx.core.graphics.drawable.a.o(drawableMutate, this.f2459c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.f2457a.getDrawableState());
                }
                this.f2457a.setCheckMarkDrawable(drawableMutate);
            }
        }
    }

    ColorStateList b() {
        return this.f2458b;
    }

    PorterDuff.Mode c() {
        return this.f2459c;
    }

    void d(AttributeSet attributeSet, int i2) {
        int iM;
        int iM2;
        Context context = this.f2457a.getContext();
        int[] iArr = e.m.f6003P0;
        d0 d0VarU = d0.u(context, attributeSet, iArr, i2, 0);
        CheckedTextView checkedTextView = this.f2457a;
        androidx.core.view.M.d0(checkedTextView, checkedTextView.getContext(), iArr, attributeSet, d0VarU.q(), i2, 0);
        try {
            int i3 = e.m.f6007R0;
            if (!d0VarU.r(i3) || (iM2 = d0VarU.m(i3, 0)) == 0) {
                int i4 = e.m.f6005Q0;
                if (d0VarU.r(i4) && (iM = d0VarU.m(i4, 0)) != 0) {
                    CheckedTextView checkedTextView2 = this.f2457a;
                    checkedTextView2.setCheckMarkDrawable(AbstractC0250a.b(checkedTextView2.getContext(), iM));
                }
            } else {
                try {
                    CheckedTextView checkedTextView3 = this.f2457a;
                    checkedTextView3.setCheckMarkDrawable(AbstractC0250a.b(checkedTextView3.getContext(), iM2));
                } catch (Resources.NotFoundException unused) {
                }
            }
            int i5 = e.m.f6009S0;
            if (d0VarU.r(i5)) {
                androidx.core.widget.b.b(this.f2457a, d0VarU.c(i5));
            }
            int i6 = e.m.f6011T0;
            if (d0VarU.r(i6)) {
                androidx.core.widget.b.c(this.f2457a, M.c(d0VarU.j(i6, -1), null));
            }
        } finally {
            d0VarU.w();
        }
    }

    void e() {
        if (this.f2461f) {
            this.f2461f = false;
        } else {
            this.f2461f = true;
            a();
        }
    }

    void f(ColorStateList colorStateList) {
        this.f2458b = colorStateList;
        this.f2460d = true;
        a();
    }

    void g(PorterDuff.Mode mode) {
        this.f2459c = mode;
        this.e = true;
        a();
    }
}
