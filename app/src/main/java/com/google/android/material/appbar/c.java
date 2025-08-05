package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes.dex */
abstract class c extends CoordinatorLayout.b {

    /* renamed from: a, reason: collision with root package name */
    private d f5634a;

    /* renamed from: b, reason: collision with root package name */
    private int f5635b;

    /* renamed from: c, reason: collision with root package name */
    private int f5636c;

    public c() {
        this.f5635b = 0;
        this.f5636c = 0;
    }

    public int D() {
        d dVar = this.f5634a;
        if (dVar != null) {
            return dVar.a();
        }
        return 0;
    }

    protected void E(CoordinatorLayout coordinatorLayout, View view, int i2) {
        coordinatorLayout.G(view, i2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i2) {
        E(coordinatorLayout, view, i2);
        if (this.f5634a == null) {
            this.f5634a = new d(view);
        }
        this.f5634a.b();
        int i3 = this.f5635b;
        if (i3 != 0) {
            this.f5634a.d(i3);
            this.f5635b = 0;
        }
        int i4 = this.f5636c;
        if (i4 == 0) {
            return true;
        }
        this.f5634a.c(i4);
        this.f5636c = 0;
        return true;
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5635b = 0;
        this.f5636c = 0;
    }
}
