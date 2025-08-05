package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import defpackage.e;

/* renamed from: androidx.appcompat.widget.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0147o extends ImageButton {

    /* renamed from: a, reason: collision with root package name */
    private final C0137e f2500a;

    /* renamed from: b, reason: collision with root package name */
    private final C0148p f2501b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f2502c;

    public C0147o(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, e.d.f5857z);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0137e c0137e = this.f2500a;
        if (c0137e != null) {
            c0137e.b();
        }
        C0148p c0148p = this.f2501b;
        if (c0148p != null) {
            c0148p.c();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0137e c0137e = this.f2500a;
        if (c0137e != null) {
            return c0137e.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0137e c0137e = this.f2500a;
        if (c0137e != null) {
            return c0137e.d();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        C0148p c0148p = this.f2501b;
        if (c0148p != null) {
            return c0148p.d();
        }
        return null;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        C0148p c0148p = this.f2501b;
        if (c0148p != null) {
            return c0148p.e();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.f2501b.f() && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0137e c0137e = this.f2500a;
        if (c0137e != null) {
            c0137e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0137e c0137e = this.f2500a;
        if (c0137e != null) {
            c0137e.g(i2);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        C0148p c0148p = this.f2501b;
        if (c0148p != null) {
            c0148p.c();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        C0148p c0148p = this.f2501b;
        if (c0148p != null && drawable != null && !this.f2502c) {
            c0148p.h(drawable);
        }
        super.setImageDrawable(drawable);
        C0148p c0148p2 = this.f2501b;
        if (c0148p2 != null) {
            c0148p2.c();
            if (this.f2502c) {
                return;
            }
            this.f2501b.b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i2) {
        super.setImageLevel(i2);
        this.f2502c = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        this.f2501b.i(i2);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        C0148p c0148p = this.f2501b;
        if (c0148p != null) {
            c0148p.c();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0137e c0137e = this.f2500a;
        if (c0137e != null) {
            c0137e.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0137e c0137e = this.f2500a;
        if (c0137e != null) {
            c0137e.j(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        C0148p c0148p = this.f2501b;
        if (c0148p != null) {
            c0148p.j(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        C0148p c0148p = this.f2501b;
        if (c0148p != null) {
            c0148p.k(mode);
        }
    }

    public C0147o(Context context, AttributeSet attributeSet, int i2) {
        super(a0.b(context), attributeSet, i2);
        this.f2502c = false;
        Z.a(this, getContext());
        C0137e c0137e = new C0137e(this);
        this.f2500a = c0137e;
        c0137e.e(attributeSet, i2);
        C0148p c0148p = new C0148p(this);
        this.f2501b = c0148p;
        c0148p.g(attributeSet, i2);
    }
}
