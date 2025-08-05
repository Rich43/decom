package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import defpackage.e;

/* renamed from: androidx.appcompat.widget.e */
/* loaded from: classes.dex */
class C0137e {

    /* renamed from: a */
    private final View f2418a;

    /* renamed from: d */
    private b0 f2421d;
    private b0 e;

    /* renamed from: f */
    private b0 f2422f;

    /* renamed from: c */
    private int f2420c = -1;

    /* renamed from: b */
    private final C0143k f2419b = C0143k.b();

    C0137e(View view) {
        this.f2418a = view;
    }

    private boolean a(Drawable drawable) {
        if (this.f2422f == null) {
            this.f2422f = new b0();
        }
        b0 b0Var = this.f2422f;
        b0Var.a();
        ColorStateList colorStateListO = androidx.core.view.M.o(this.f2418a);
        if (colorStateListO != null) {
            b0Var.f2383d = true;
            b0Var.f2380a = colorStateListO;
        }
        PorterDuff.Mode modeP = androidx.core.view.M.p(this.f2418a);
        if (modeP != null) {
            b0Var.f2382c = true;
            b0Var.f2381b = modeP;
        }
        if (!b0Var.f2383d && !b0Var.f2382c) {
            return false;
        }
        C0143k.i(drawable, b0Var, this.f2418a.getDrawableState());
        return true;
    }

    private boolean k() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 > 21 ? this.f2421d != null : i2 == 21;
    }

    void b() {
        Drawable background = this.f2418a.getBackground();
        if (background != null) {
            if (k() && a(background)) {
                return;
            }
            b0 b0Var = this.e;
            if (b0Var != null) {
                C0143k.i(background, b0Var, this.f2418a.getDrawableState());
                return;
            }
            b0 b0Var2 = this.f2421d;
            if (b0Var2 != null) {
                C0143k.i(background, b0Var2, this.f2418a.getDrawableState());
            }
        }
    }

    ColorStateList c() {
        b0 b0Var = this.e;
        if (b0Var != null) {
            return b0Var.f2380a;
        }
        return null;
    }

    PorterDuff.Mode d() {
        b0 b0Var = this.e;
        if (b0Var != null) {
            return b0Var.f2381b;
        }
        return null;
    }

    void e(AttributeSet attributeSet, int i2) {
        Context context = this.f2418a.getContext();
        int[] iArr = e.m.h3;
        d0 d0VarU = d0.u(context, attributeSet, iArr, i2, 0);
        View view = this.f2418a;
        androidx.core.view.M.d0(view, view.getContext(), iArr, attributeSet, d0VarU.q(), i2, 0);
        try {
            int i3 = e.m.i3;
            if (d0VarU.r(i3)) {
                this.f2420c = d0VarU.m(i3, -1);
                ColorStateList colorStateListF = this.f2419b.f(this.f2418a.getContext(), this.f2420c);
                if (colorStateListF != null) {
                    h(colorStateListF);
                }
            }
            int i4 = e.m.j3;
            if (d0VarU.r(i4)) {
                androidx.core.view.M.j0(this.f2418a, d0VarU.c(i4));
            }
            int i5 = e.m.k3;
            if (d0VarU.r(i5)) {
                androidx.core.view.M.k0(this.f2418a, M.c(d0VarU.j(i5, -1), null));
            }
            d0VarU.w();
        } catch (Throwable th) {
            d0VarU.w();
            throw th;
        }
    }

    void f(Drawable drawable) {
        this.f2420c = -1;
        h(null);
        b();
    }

    void g(int i2) {
        this.f2420c = i2;
        C0143k c0143k = this.f2419b;
        h(c0143k != null ? c0143k.f(this.f2418a.getContext(), i2) : null);
        b();
    }

    void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f2421d == null) {
                this.f2421d = new b0();
            }
            b0 b0Var = this.f2421d;
            b0Var.f2380a = colorStateList;
            b0Var.f2383d = true;
        } else {
            this.f2421d = null;
        }
        b();
    }

    void i(ColorStateList colorStateList) {
        if (this.e == null) {
            this.e = new b0();
        }
        b0 b0Var = this.e;
        b0Var.f2380a = colorStateList;
        b0Var.f2383d = true;
        b();
    }

    void j(PorterDuff.Mode mode) {
        if (this.e == null) {
            this.e = new b0();
        }
        b0 b0Var = this.e;
        b0Var.f2381b = mode;
        b0Var.f2382c = true;
        b();
    }
}
