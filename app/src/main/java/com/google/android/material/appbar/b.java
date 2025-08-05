package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AbstractC0176t;
import androidx.core.view.M;
import androidx.core.view.Z;
import com.bumptech.glide.request.target.Target;
import java.util.List;
import t.AbstractC0327a;

/* loaded from: classes.dex */
abstract class b extends c {

    /* renamed from: d, reason: collision with root package name */
    final Rect f5631d;
    final Rect e;

    /* renamed from: f, reason: collision with root package name */
    private int f5632f;

    /* renamed from: g, reason: collision with root package name */
    private int f5633g;

    public b() {
        this.f5631d = new Rect();
        this.e = new Rect();
        this.f5632f = 0;
    }

    private static int K(int i2) {
        if (i2 == 0) {
            return 8388659;
        }
        return i2;
    }

    @Override // com.google.android.material.appbar.c
    protected void E(CoordinatorLayout coordinatorLayout, View view, int i2) {
        View viewF = F(coordinatorLayout.q(view));
        if (viewF == null) {
            super.E(coordinatorLayout, view, i2);
            this.f5632f = 0;
            return;
        }
        CoordinatorLayout.e eVar = (CoordinatorLayout.e) view.getLayoutParams();
        Rect rect = this.f5631d;
        rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin, viewF.getBottom() + ((ViewGroup.MarginLayoutParams) eVar).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin, ((coordinatorLayout.getHeight() + viewF.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        Z lastWindowInsets = coordinatorLayout.getLastWindowInsets();
        if (lastWindowInsets != null && M.v(coordinatorLayout) && !M.v(view)) {
            rect.left += lastWindowInsets.i();
            rect.right -= lastWindowInsets.j();
        }
        Rect rect2 = this.e;
        AbstractC0176t.a(K(eVar.f2826c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i2);
        int iG = G(viewF);
        view.layout(rect2.left, rect2.top - iG, rect2.right, rect2.bottom - iG);
        this.f5632f = rect2.top - viewF.getBottom();
    }

    abstract View F(List list);

    final int G(View view) {
        if (this.f5633g == 0) {
            return 0;
        }
        float fH = H(view);
        int i2 = this.f5633g;
        return AbstractC0327a.a((int) (fH * i2), 0, i2);
    }

    abstract float H(View view);

    int I(View view) {
        return view.getMeasuredHeight();
    }

    final int J() {
        return this.f5632f;
    }

    public final void L(int i2) {
        this.f5633g = i2;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean m(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4, int i5) {
        View viewF;
        int i6 = view.getLayoutParams().height;
        if ((i6 != -1 && i6 != -2) || (viewF = F(coordinatorLayout.q(view))) == null) {
            return false;
        }
        if (M.v(viewF) && !M.v(view)) {
            M.n0(view, true);
            if (M.v(view)) {
                view.requestLayout();
                return true;
            }
        }
        int size = View.MeasureSpec.getSize(i4);
        if (size == 0) {
            size = coordinatorLayout.getHeight();
        }
        coordinatorLayout.H(view, i2, i3, View.MeasureSpec.makeMeasureSpec((size - viewF.getMeasuredHeight()) + I(viewF), i6 == -1 ? 1073741824 : Target.SIZE_ORIGINAL), i5);
        return true;
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5631d = new Rect();
        this.e = new Rect();
        this.f5632f = 0;
    }
}
