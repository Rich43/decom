package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.core.view.M;
import u0.AbstractC0337g;
import x0.AbstractC0373a;
import y0.AbstractC0375a;

/* loaded from: classes.dex */
class c {

    /* renamed from: w */
    private static final boolean f5693w = true;

    /* renamed from: a */
    private final a f5694a;

    /* renamed from: b */
    private int f5695b;

    /* renamed from: c */
    private int f5696c;

    /* renamed from: d */
    private int f5697d;
    private int e;

    /* renamed from: f */
    private int f5698f;

    /* renamed from: g */
    private int f5699g;

    /* renamed from: h */
    private PorterDuff.Mode f5700h;

    /* renamed from: i */
    private ColorStateList f5701i;

    /* renamed from: j */
    private ColorStateList f5702j;

    /* renamed from: k */
    private ColorStateList f5703k;
    private GradientDrawable o;

    /* renamed from: p */
    private Drawable f5707p;

    /* renamed from: q */
    private GradientDrawable f5708q;
    private Drawable r;
    private GradientDrawable s;

    /* renamed from: t */
    private GradientDrawable f5709t;

    /* renamed from: u */
    private GradientDrawable f5710u;

    /* renamed from: l */
    private final Paint f5704l = new Paint(1);

    /* renamed from: m */
    private final Rect f5705m = new Rect();

    /* renamed from: n */
    private final RectF f5706n = new RectF();

    /* renamed from: v */
    private boolean f5711v = false;

    public c(a aVar) {
        this.f5694a = aVar;
    }

    private Drawable a() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.o = gradientDrawable;
        gradientDrawable.setCornerRadius(this.f5698f + 1.0E-5f);
        this.o.setColor(-1);
        Drawable drawableP = androidx.core.graphics.drawable.a.p(this.o);
        this.f5707p = drawableP;
        androidx.core.graphics.drawable.a.n(drawableP, this.f5701i);
        PorterDuff.Mode mode = this.f5700h;
        if (mode != null) {
            androidx.core.graphics.drawable.a.o(this.f5707p, mode);
        }
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        this.f5708q = gradientDrawable2;
        gradientDrawable2.setCornerRadius(this.f5698f + 1.0E-5f);
        this.f5708q.setColor(-1);
        Drawable drawableP2 = androidx.core.graphics.drawable.a.p(this.f5708q);
        this.r = drawableP2;
        androidx.core.graphics.drawable.a.n(drawableP2, this.f5703k);
        return x(new LayerDrawable(new Drawable[]{this.f5707p, this.r}));
    }

    private Drawable b() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.s = gradientDrawable;
        gradientDrawable.setCornerRadius(this.f5698f + 1.0E-5f);
        this.s.setColor(-1);
        w();
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        this.f5709t = gradientDrawable2;
        gradientDrawable2.setCornerRadius(this.f5698f + 1.0E-5f);
        this.f5709t.setColor(0);
        this.f5709t.setStroke(this.f5699g, this.f5702j);
        InsetDrawable insetDrawableX = x(new LayerDrawable(new Drawable[]{this.s, this.f5709t}));
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        this.f5710u = gradientDrawable3;
        gradientDrawable3.setCornerRadius(this.f5698f + 1.0E-5f);
        this.f5710u.setColor(-1);
        return new b(AbstractC0375a.a(this.f5703k), insetDrawableX, this.f5710u);
    }

    private GradientDrawable s() {
        if (!f5693w || this.f5694a.getBackground() == null) {
            return null;
        }
        return (GradientDrawable) ((LayerDrawable) ((InsetDrawable) ((RippleDrawable) this.f5694a.getBackground()).getDrawable(0)).getDrawable()).getDrawable(0);
    }

    private GradientDrawable t() {
        if (!f5693w || this.f5694a.getBackground() == null) {
            return null;
        }
        return (GradientDrawable) ((LayerDrawable) ((InsetDrawable) ((RippleDrawable) this.f5694a.getBackground()).getDrawable(0)).getDrawable()).getDrawable(1);
    }

    private void v() {
        boolean z2 = f5693w;
        if (z2 && this.f5709t != null) {
            this.f5694a.setInternalBackground(b());
        } else {
            if (z2) {
                return;
            }
            this.f5694a.invalidate();
        }
    }

    private void w() {
        GradientDrawable gradientDrawable = this.s;
        if (gradientDrawable != null) {
            androidx.core.graphics.drawable.a.n(gradientDrawable, this.f5701i);
            PorterDuff.Mode mode = this.f5700h;
            if (mode != null) {
                androidx.core.graphics.drawable.a.o(this.s, mode);
            }
        }
    }

    private InsetDrawable x(Drawable drawable) {
        return new InsetDrawable(drawable, this.f5695b, this.f5697d, this.f5696c, this.e);
    }

    int c() {
        return this.f5698f;
    }

    ColorStateList d() {
        return this.f5703k;
    }

    ColorStateList e() {
        return this.f5702j;
    }

    int f() {
        return this.f5699g;
    }

    ColorStateList g() {
        return this.f5701i;
    }

    PorterDuff.Mode h() {
        return this.f5700h;
    }

    boolean i() {
        return this.f5711v;
    }

    public void j(TypedArray typedArray) {
        this.f5695b = typedArray.getDimensionPixelOffset(AbstractC0337g.f7615V, 0);
        this.f5696c = typedArray.getDimensionPixelOffset(AbstractC0337g.f7616W, 0);
        this.f5697d = typedArray.getDimensionPixelOffset(AbstractC0337g.f7617X, 0);
        this.e = typedArray.getDimensionPixelOffset(AbstractC0337g.f7618Y, 0);
        this.f5698f = typedArray.getDimensionPixelSize(AbstractC0337g.f7623b0, 0);
        this.f5699g = typedArray.getDimensionPixelSize(AbstractC0337g.f7640k0, 0);
        this.f5700h = com.google.android.material.internal.c.a(typedArray.getInt(AbstractC0337g.f7621a0, -1), PorterDuff.Mode.SRC_IN);
        this.f5701i = AbstractC0373a.a(this.f5694a.getContext(), typedArray, AbstractC0337g.f7619Z);
        this.f5702j = AbstractC0373a.a(this.f5694a.getContext(), typedArray, AbstractC0337g.f7638j0);
        this.f5703k = AbstractC0373a.a(this.f5694a.getContext(), typedArray, AbstractC0337g.f7636i0);
        this.f5704l.setStyle(Paint.Style.STROKE);
        this.f5704l.setStrokeWidth(this.f5699g);
        Paint paint = this.f5704l;
        ColorStateList colorStateList = this.f5702j;
        paint.setColor(colorStateList != null ? colorStateList.getColorForState(this.f5694a.getDrawableState(), 0) : 0);
        int iD = M.D(this.f5694a);
        int paddingTop = this.f5694a.getPaddingTop();
        int iC = M.C(this.f5694a);
        int paddingBottom = this.f5694a.getPaddingBottom();
        this.f5694a.setInternalBackground(f5693w ? b() : a());
        M.t0(this.f5694a, iD + this.f5695b, paddingTop + this.f5697d, iC + this.f5696c, paddingBottom + this.e);
    }

    void k(int i2) {
        GradientDrawable gradientDrawable;
        GradientDrawable gradientDrawable2;
        boolean z2 = f5693w;
        if (z2 && (gradientDrawable2 = this.s) != null) {
            gradientDrawable2.setColor(i2);
        } else {
            if (z2 || (gradientDrawable = this.o) == null) {
                return;
            }
            gradientDrawable.setColor(i2);
        }
    }

    void l() {
        this.f5711v = true;
        this.f5694a.setSupportBackgroundTintList(this.f5701i);
        this.f5694a.setSupportBackgroundTintMode(this.f5700h);
    }

    void m(int i2) {
        GradientDrawable gradientDrawable;
        if (this.f5698f != i2) {
            this.f5698f = i2;
            boolean z2 = f5693w;
            if (!z2 || this.s == null || this.f5709t == null || this.f5710u == null) {
                if (z2 || (gradientDrawable = this.o) == null || this.f5708q == null) {
                    return;
                }
                float f2 = i2 + 1.0E-5f;
                gradientDrawable.setCornerRadius(f2);
                this.f5708q.setCornerRadius(f2);
                this.f5694a.invalidate();
                return;
            }
            if (Build.VERSION.SDK_INT == 21) {
                float f3 = i2 + 1.0E-5f;
                s().setCornerRadius(f3);
                t().setCornerRadius(f3);
            }
            float f4 = i2 + 1.0E-5f;
            this.s.setCornerRadius(f4);
            this.f5709t.setCornerRadius(f4);
            this.f5710u.setCornerRadius(f4);
        }
    }

    void n(ColorStateList colorStateList) {
        Drawable drawable;
        if (this.f5703k != colorStateList) {
            this.f5703k = colorStateList;
            boolean z2 = f5693w;
            if (z2 && (this.f5694a.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f5694a.getBackground()).setColor(colorStateList);
            } else {
                if (z2 || (drawable = this.r) == null) {
                    return;
                }
                androidx.core.graphics.drawable.a.n(drawable, colorStateList);
            }
        }
    }

    void o(ColorStateList colorStateList) {
        if (this.f5702j != colorStateList) {
            this.f5702j = colorStateList;
            this.f5704l.setColor(colorStateList != null ? colorStateList.getColorForState(this.f5694a.getDrawableState(), 0) : 0);
            v();
        }
    }

    void p(int i2) {
        if (this.f5699g != i2) {
            this.f5699g = i2;
            this.f5704l.setStrokeWidth(i2);
            v();
        }
    }

    void q(ColorStateList colorStateList) {
        if (this.f5701i != colorStateList) {
            this.f5701i = colorStateList;
            if (f5693w) {
                w();
                return;
            }
            Drawable drawable = this.f5707p;
            if (drawable != null) {
                androidx.core.graphics.drawable.a.n(drawable, colorStateList);
            }
        }
    }

    void r(PorterDuff.Mode mode) {
        if (this.f5700h != mode) {
            this.f5700h = mode;
            if (f5693w) {
                w();
                return;
            }
            Drawable drawable = this.f5707p;
            if (drawable == null || mode == null) {
                return;
            }
            androidx.core.graphics.drawable.a.o(drawable, mode);
        }
    }

    void u(int i2, int i3) {
        GradientDrawable gradientDrawable = this.f5710u;
        if (gradientDrawable != null) {
            gradientDrawable.setBounds(this.f5695b, this.f5697d, i3 - this.f5696c, i2 - this.e);
        }
    }
}
