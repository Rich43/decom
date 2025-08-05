package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import defpackage.e;
import f.AbstractC0250a;

/* renamed from: androidx.appcompat.widget.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0148p {

    /* renamed from: a, reason: collision with root package name */
    private final ImageView f2506a;

    /* renamed from: b, reason: collision with root package name */
    private b0 f2507b;

    /* renamed from: c, reason: collision with root package name */
    private b0 f2508c;

    /* renamed from: d, reason: collision with root package name */
    private b0 f2509d;
    private int e = 0;

    public C0148p(ImageView imageView) {
        this.f2506a = imageView;
    }

    private boolean a(Drawable drawable) {
        if (this.f2509d == null) {
            this.f2509d = new b0();
        }
        b0 b0Var = this.f2509d;
        b0Var.a();
        ColorStateList colorStateListA = androidx.core.widget.e.a(this.f2506a);
        if (colorStateListA != null) {
            b0Var.f2383d = true;
            b0Var.f2380a = colorStateListA;
        }
        PorterDuff.Mode modeB = androidx.core.widget.e.b(this.f2506a);
        if (modeB != null) {
            b0Var.f2382c = true;
            b0Var.f2381b = modeB;
        }
        if (!b0Var.f2383d && !b0Var.f2382c) {
            return false;
        }
        C0143k.i(drawable, b0Var, this.f2506a.getDrawableState());
        return true;
    }

    private boolean l() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 > 21 ? this.f2507b != null : i2 == 21;
    }

    void b() {
        if (this.f2506a.getDrawable() != null) {
            this.f2506a.getDrawable().setLevel(this.e);
        }
    }

    void c() {
        Drawable drawable = this.f2506a.getDrawable();
        if (drawable != null) {
            M.a(drawable);
        }
        if (drawable != null) {
            if (l() && a(drawable)) {
                return;
            }
            b0 b0Var = this.f2508c;
            if (b0Var != null) {
                C0143k.i(drawable, b0Var, this.f2506a.getDrawableState());
                return;
            }
            b0 b0Var2 = this.f2507b;
            if (b0Var2 != null) {
                C0143k.i(drawable, b0Var2, this.f2506a.getDrawableState());
            }
        }
    }

    ColorStateList d() {
        b0 b0Var = this.f2508c;
        if (b0Var != null) {
            return b0Var.f2380a;
        }
        return null;
    }

    PorterDuff.Mode e() {
        b0 b0Var = this.f2508c;
        if (b0Var != null) {
            return b0Var.f2381b;
        }
        return null;
    }

    boolean f() {
        return !(this.f2506a.getBackground() instanceof RippleDrawable);
    }

    public void g(AttributeSet attributeSet, int i2) {
        int iM;
        Context context = this.f2506a.getContext();
        int[] iArr = e.m.f6002P;
        d0 d0VarU = d0.u(context, attributeSet, iArr, i2, 0);
        ImageView imageView = this.f2506a;
        androidx.core.view.M.d0(imageView, imageView.getContext(), iArr, attributeSet, d0VarU.q(), i2, 0);
        try {
            Drawable drawable = this.f2506a.getDrawable();
            if (drawable == null && (iM = d0VarU.m(e.m.f6004Q, -1)) != -1 && (drawable = AbstractC0250a.b(this.f2506a.getContext(), iM)) != null) {
                this.f2506a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                M.a(drawable);
            }
            int i3 = e.m.f6006R;
            if (d0VarU.r(i3)) {
                androidx.core.widget.e.c(this.f2506a, d0VarU.c(i3));
            }
            int i4 = e.m.f6008S;
            if (d0VarU.r(i4)) {
                androidx.core.widget.e.d(this.f2506a, M.c(d0VarU.j(i4, -1), null));
            }
            d0VarU.w();
        } catch (Throwable th) {
            d0VarU.w();
            throw th;
        }
    }

    void h(Drawable drawable) {
        this.e = drawable.getLevel();
    }

    public void i(int i2) {
        if (i2 != 0) {
            Drawable drawableB = AbstractC0250a.b(this.f2506a.getContext(), i2);
            if (drawableB != null) {
                M.a(drawableB);
            }
            this.f2506a.setImageDrawable(drawableB);
        } else {
            this.f2506a.setImageDrawable(null);
        }
        c();
    }

    void j(ColorStateList colorStateList) {
        if (this.f2508c == null) {
            this.f2508c = new b0();
        }
        b0 b0Var = this.f2508c;
        b0Var.f2380a = colorStateList;
        b0Var.f2383d = true;
        c();
    }

    void k(PorterDuff.Mode mode) {
        if (this.f2508c == null) {
            this.f2508c = new b0();
        }
        b0 b0Var = this.f2508c;
        b0Var.f2381b = mode;
        b0Var.f2382c = true;
        c();
    }
}
