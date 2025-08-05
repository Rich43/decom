package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import defpackage.e;
import java.lang.reflect.InvocationTargetException;

/* renamed from: androidx.appcompat.widget.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0156y extends C0151t {

    /* renamed from: d, reason: collision with root package name */
    private final SeekBar f2528d;
    private Drawable e;

    /* renamed from: f, reason: collision with root package name */
    private ColorStateList f2529f;

    /* renamed from: g, reason: collision with root package name */
    private PorterDuff.Mode f2530g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f2531h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f2532i;

    C0156y(SeekBar seekBar) {
        super(seekBar);
        this.f2529f = null;
        this.f2530g = null;
        this.f2531h = false;
        this.f2532i = false;
        this.f2528d = seekBar;
    }

    private void f() {
        Drawable drawable = this.e;
        if (drawable != null) {
            if (this.f2531h || this.f2532i) {
                Drawable drawableP = androidx.core.graphics.drawable.a.p(drawable.mutate());
                this.e = drawableP;
                if (this.f2531h) {
                    androidx.core.graphics.drawable.a.n(drawableP, this.f2529f);
                }
                if (this.f2532i) {
                    androidx.core.graphics.drawable.a.o(this.e, this.f2530g);
                }
                if (this.e.isStateful()) {
                    this.e.setState(this.f2528d.getDrawableState());
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.C0151t
    void c(AttributeSet attributeSet, int i2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.c(attributeSet, i2);
        Context context = this.f2528d.getContext();
        int[] iArr = e.m.f6010T;
        d0 d0VarU = d0.u(context, attributeSet, iArr, i2, 0);
        SeekBar seekBar = this.f2528d;
        androidx.core.view.M.d0(seekBar, seekBar.getContext(), iArr, attributeSet, d0VarU.q(), i2, 0);
        Drawable drawableG = d0VarU.g(e.m.f6012U);
        if (drawableG != null) {
            this.f2528d.setThumb(drawableG);
        }
        j(d0VarU.f(e.m.f6014V));
        int i3 = e.m.f6018X;
        if (d0VarU.r(i3)) {
            this.f2530g = M.c(d0VarU.j(i3, -1), this.f2530g);
            this.f2532i = true;
        }
        int i4 = e.m.f6016W;
        if (d0VarU.r(i4)) {
            this.f2529f = d0VarU.c(i4);
            this.f2531h = true;
        }
        d0VarU.w();
        f();
    }

    void g(Canvas canvas) {
        if (this.e != null) {
            int max = this.f2528d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.e.getIntrinsicWidth();
                int intrinsicHeight = this.e.getIntrinsicHeight();
                int i2 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i3 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.e.setBounds(-i2, -i3, i2, i3);
                float width = ((this.f2528d.getWidth() - this.f2528d.getPaddingLeft()) - this.f2528d.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(this.f2528d.getPaddingLeft(), this.f2528d.getHeight() / 2);
                for (int i4 = 0; i4 <= max; i4++) {
                    this.e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }

    void h() {
        Drawable drawable = this.e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f2528d.getDrawableState())) {
            this.f2528d.invalidateDrawable(drawable);
        }
    }

    void i() {
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    void j(Drawable drawable) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Drawable drawable2 = this.e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f2528d);
            androidx.core.graphics.drawable.a.l(drawable, this.f2528d.getLayoutDirection());
            if (drawable.isStateful()) {
                drawable.setState(this.f2528d.getDrawableState());
            }
            f();
        }
        this.f2528d.invalidate();
    }
}
