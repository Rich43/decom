package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.TextView;
import defpackage.e;

/* renamed from: androidx.appcompat.widget.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0145m {

    /* renamed from: a, reason: collision with root package name */
    private final TextView f2490a;

    /* renamed from: b, reason: collision with root package name */
    private final D.f f2491b;

    C0145m(TextView textView) {
        this.f2490a = textView;
        this.f2491b = new D.f(textView, false);
    }

    InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f2491b.a(inputFilterArr);
    }

    void b(AttributeSet attributeSet, int i2) {
        TypedArray typedArrayObtainStyledAttributes = this.f2490a.getContext().obtainStyledAttributes(attributeSet, e.m.f6042g0, i2, 0);
        try {
            int i3 = e.m.f6081u0;
            boolean z2 = typedArrayObtainStyledAttributes.hasValue(i3) ? typedArrayObtainStyledAttributes.getBoolean(i3, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            d(z2);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    void c(boolean z2) {
        this.f2491b.b(z2);
    }

    void d(boolean z2) {
        this.f2491b.c(z2);
    }
}
