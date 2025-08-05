package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import defpackage.e;

/* renamed from: androidx.appcompat.widget.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0144l {

    /* renamed from: a, reason: collision with root package name */
    private final EditText f2477a;

    /* renamed from: b, reason: collision with root package name */
    private final D.a f2478b;

    C0144l(EditText editText) {
        this.f2477a = editText;
        this.f2478b = new D.a(editText, false);
    }

    KeyListener a(KeyListener keyListener) {
        return b(keyListener) ? this.f2478b.a(keyListener) : keyListener;
    }

    boolean b(KeyListener keyListener) {
        return !(keyListener instanceof NumberKeyListener);
    }

    void c(AttributeSet attributeSet, int i2) {
        TypedArray typedArrayObtainStyledAttributes = this.f2477a.getContext().obtainStyledAttributes(attributeSet, e.m.f6042g0, i2, 0);
        try {
            int i3 = e.m.f6081u0;
            boolean z2 = typedArrayObtainStyledAttributes.hasValue(i3) ? typedArrayObtainStyledAttributes.getBoolean(i3, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            e(z2);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    InputConnection d(InputConnection inputConnection, EditorInfo editorInfo) {
        return this.f2478b.b(inputConnection, editorInfo);
    }

    void e(boolean z2) {
        this.f2478b.c(z2);
    }
}
