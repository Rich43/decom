package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import v0.AbstractC0347a;

/* loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.b {

    /* renamed from: a, reason: collision with root package name */
    private int f5641a;

    /* renamed from: b, reason: collision with root package name */
    private int f5642b;

    /* renamed from: c, reason: collision with root package name */
    private ViewPropertyAnimator f5643c;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.f5643c = null;
        }
    }

    public HideBottomViewOnScrollBehavior() {
        this.f5641a = 0;
        this.f5642b = 2;
    }

    private void E(View view, int i2, long j2, TimeInterpolator timeInterpolator) {
        this.f5643c = view.animate().translationY(i2).setInterpolator(timeInterpolator).setDuration(j2).setListener(new a());
    }

    protected void F(View view) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5643c;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.f5642b = 1;
        E(view, this.f5641a, 175L, AbstractC0347a.f7678c);
    }

    protected void G(View view) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5643c;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.f5642b = 2;
        E(view, 0, 225L, AbstractC0347a.f7679d);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i2) {
        this.f5641a = view.getMeasuredHeight();
        return super.l(coordinatorLayout, view, i2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public void r(CoordinatorLayout coordinatorLayout, View view, View view2, int i2, int i3, int i4, int i5) {
        int i6 = this.f5642b;
        if (i6 != 1 && i3 > 0) {
            F(view);
        } else {
            if (i6 == 2 || i3 >= 0) {
                return;
            }
            G(view);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean y(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i2) {
        return i2 == 2;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5641a = 0;
        this.f5642b = 2;
    }
}
