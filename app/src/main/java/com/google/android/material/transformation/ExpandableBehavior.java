package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.app.F;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.M;
import java.util.List;
import w0.InterfaceC0371a;

/* loaded from: classes.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.b {

    /* renamed from: a, reason: collision with root package name */
    private int f5746a;

    public ExpandableBehavior() {
        this.f5746a = 0;
    }

    protected InterfaceC0371a D(CoordinatorLayout coordinatorLayout, View view) {
        List listQ = coordinatorLayout.q(view);
        int size = listQ.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view2 = (View) listQ.get(i2);
            if (e(coordinatorLayout, view, view2)) {
                F.a(view2);
                return null;
            }
        }
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public abstract boolean e(CoordinatorLayout coordinatorLayout, View view, View view2);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
        F.a(view2);
        throw null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i2) {
        if (M.O(view)) {
            return false;
        }
        D(coordinatorLayout, view);
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5746a = 0;
    }
}
