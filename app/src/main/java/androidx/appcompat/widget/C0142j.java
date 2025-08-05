package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import defpackage.e;
import f.AbstractC0250a;

/* renamed from: androidx.appcompat.widget.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0142j {

    /* renamed from: a, reason: collision with root package name */
    private final CompoundButton f2462a;

    /* renamed from: b, reason: collision with root package name */
    private ColorStateList f2463b = null;

    /* renamed from: c, reason: collision with root package name */
    private PorterDuff.Mode f2464c = null;

    /* renamed from: d, reason: collision with root package name */
    private boolean f2465d = false;
    private boolean e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f2466f;

    C0142j(CompoundButton compoundButton) {
        this.f2462a = compoundButton;
    }

    void a() throws NoSuchFieldException, SecurityException {
        Drawable drawableA = androidx.core.widget.c.a(this.f2462a);
        if (drawableA != null) {
            if (this.f2465d || this.e) {
                Drawable drawableMutate = androidx.core.graphics.drawable.a.p(drawableA).mutate();
                if (this.f2465d) {
                    androidx.core.graphics.drawable.a.n(drawableMutate, this.f2463b);
                }
                if (this.e) {
                    androidx.core.graphics.drawable.a.o(drawableMutate, this.f2464c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.f2462a.getDrawableState());
                }
                this.f2462a.setButtonDrawable(drawableMutate);
            }
        }
    }

    ColorStateList b() {
        return this.f2463b;
    }

    PorterDuff.Mode c() {
        return this.f2464c;
    }

    void d(AttributeSet attributeSet, int i2) {
        int iM;
        int iM2;
        Context context = this.f2462a.getContext();
        int[] iArr = e.m.f6013U0;
        d0 d0VarU = d0.u(context, attributeSet, iArr, i2, 0);
        CompoundButton compoundButton = this.f2462a;
        androidx.core.view.M.d0(compoundButton, compoundButton.getContext(), iArr, attributeSet, d0VarU.q(), i2, 0);
        try {
            int i3 = e.m.f6017W0;
            if (!d0VarU.r(i3) || (iM2 = d0VarU.m(i3, 0)) == 0) {
                int i4 = e.m.f6015V0;
                if (d0VarU.r(i4) && (iM = d0VarU.m(i4, 0)) != 0) {
                    CompoundButton compoundButton2 = this.f2462a;
                    compoundButton2.setButtonDrawable(AbstractC0250a.b(compoundButton2.getContext(), iM));
                }
            } else {
                try {
                    CompoundButton compoundButton3 = this.f2462a;
                    compoundButton3.setButtonDrawable(AbstractC0250a.b(compoundButton3.getContext(), iM2));
                } catch (Resources.NotFoundException unused) {
                }
            }
            int i5 = e.m.f6019X0;
            if (d0VarU.r(i5)) {
                androidx.core.widget.c.b(this.f2462a, d0VarU.c(i5));
            }
            int i6 = e.m.f6021Y0;
            if (d0VarU.r(i6)) {
                androidx.core.widget.c.c(this.f2462a, M.c(d0VarU.j(i6, -1), null));
            }
        } finally {
            d0VarU.w();
        }
    }

    void e() throws NoSuchFieldException, SecurityException {
        if (this.f2466f) {
            this.f2466f = false;
        } else {
            this.f2466f = true;
            a();
        }
    }

    void f(ColorStateList colorStateList) throws NoSuchFieldException, SecurityException {
        this.f2463b = colorStateList;
        this.f2465d = true;
        a();
    }

    void g(PorterDuff.Mode mode) throws NoSuchFieldException, SecurityException {
        this.f2464c = mode;
        this.e = true;
        a();
    }
}
