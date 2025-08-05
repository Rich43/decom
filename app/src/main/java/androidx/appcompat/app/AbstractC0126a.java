package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.ViewGroup;
import androidx.appcompat.view.b;
import defpackage.e;

/* renamed from: androidx.appcompat.app.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0126a {
    public boolean g() {
        return false;
    }

    public abstract boolean h();

    public abstract void i(boolean z2);

    public abstract int j();

    public abstract Context k();

    public boolean l() {
        return false;
    }

    public abstract void m(Configuration configuration);

    void n() {
    }

    public abstract boolean o(int i2, KeyEvent keyEvent);

    public boolean p(KeyEvent keyEvent) {
        return false;
    }

    public boolean q() {
        return false;
    }

    public abstract void r(boolean z2);

    public abstract void s(boolean z2);

    public abstract void t(CharSequence charSequence);

    public abstract androidx.appcompat.view.b u(b.a aVar);

    /* renamed from: androidx.appcompat.app.a$a, reason: collision with other inner class name */
    public static class C0016a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f1699a;

        public C0016a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1699a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.m.f6077t);
            this.f1699a = typedArrayObtainStyledAttributes.getInt(e.m.f6080u, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public C0016a(int i2, int i3) {
            super(i2, i3);
            this.f1699a = 8388627;
        }

        public C0016a(C0016a c0016a) {
            super((ViewGroup.MarginLayoutParams) c0016a);
            this.f1699a = 0;
            this.f1699a = c0016a.f1699a;
        }

        public C0016a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1699a = 0;
        }
    }
}
