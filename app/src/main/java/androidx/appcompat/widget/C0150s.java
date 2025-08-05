package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import defpackage.e;

/* renamed from: androidx.appcompat.widget.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0150s extends PopupWindow {

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f2517b = false;

    /* renamed from: a, reason: collision with root package name */
    private boolean f2518a;

    public C0150s(Context context, AttributeSet attributeSet, int i2, int i3) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        super(context, attributeSet, i2, i3);
        a(context, attributeSet, i2, i3);
    }

    private void a(Context context, AttributeSet attributeSet, int i2, int i3) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        d0 d0VarU = d0.u(context, attributeSet, e.m.Y1, i2, i3);
        int i4 = e.m.a2;
        if (d0VarU.r(i4)) {
            b(d0VarU.a(i4, false));
        }
        setBackgroundDrawable(d0VarU.f(e.m.Z1));
        d0VarU.w();
    }

    private void b(boolean z2) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (f2517b) {
            this.f2518a = z2;
        } else {
            androidx.core.widget.h.a(this, z2);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i2, int i3) {
        if (f2517b && this.f2518a) {
            i3 -= view.getHeight();
        }
        super.showAsDropDown(view, i2, i3);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i2, int i3, int i4, int i5) {
        if (f2517b && this.f2518a) {
            i3 -= view.getHeight();
        }
        super.update(view, i2, i3, i4, i5);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i2, int i3, int i4) {
        if (f2517b && this.f2518a) {
            i3 -= view.getHeight();
        }
        super.showAsDropDown(view, i2, i3, i4);
    }
}
