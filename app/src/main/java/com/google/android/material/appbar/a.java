package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.M;
import com.bumptech.glide.request.target.Target;

/* loaded from: classes.dex */
abstract class a extends c {

    /* renamed from: d, reason: collision with root package name */
    private Runnable f5622d;
    OverScroller e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f5623f;

    /* renamed from: g, reason: collision with root package name */
    private int f5624g;

    /* renamed from: h, reason: collision with root package name */
    private int f5625h;

    /* renamed from: i, reason: collision with root package name */
    private int f5626i;

    /* renamed from: j, reason: collision with root package name */
    private VelocityTracker f5627j;

    /* renamed from: com.google.android.material.appbar.a$a, reason: collision with other inner class name */
    private class RunnableC0071a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final CoordinatorLayout f5628a;

        /* renamed from: b, reason: collision with root package name */
        private final View f5629b;

        RunnableC0071a(CoordinatorLayout coordinatorLayout, View view) {
            this.f5628a = coordinatorLayout;
            this.f5629b = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.f5629b == null || (overScroller = a.this.e) == null) {
                return;
            }
            if (!overScroller.computeScrollOffset()) {
                a.this.L(this.f5628a, this.f5629b);
                return;
            }
            a aVar = a.this;
            aVar.N(this.f5628a, this.f5629b, aVar.e.getCurrY());
            M.a0(this.f5629b, this);
        }
    }

    public a() {
        this.f5624g = -1;
        this.f5626i = -1;
    }

    private void G() {
        if (this.f5627j == null) {
            this.f5627j = VelocityTracker.obtain();
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean C(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (this.f5626i < 0) {
            this.f5626i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.f5627j;
                if (velocityTracker != null) {
                    velocityTracker.addMovement(motionEvent);
                    this.f5627j.computeCurrentVelocity(1000);
                    H(coordinatorLayout, view, -J(view), 0, this.f5627j.getYVelocity(this.f5624g));
                }
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f5624g);
                if (iFindPointerIndex == -1) {
                    return false;
                }
                int y2 = (int) motionEvent.getY(iFindPointerIndex);
                int i2 = this.f5625h - y2;
                if (!this.f5623f) {
                    int iAbs = Math.abs(i2);
                    int i3 = this.f5626i;
                    if (iAbs > i3) {
                        this.f5623f = true;
                        i2 = i2 > 0 ? i2 - i3 : i2 + i3;
                    }
                }
                int i4 = i2;
                if (this.f5623f) {
                    this.f5625h = y2;
                    M(coordinatorLayout, view, i4, I(view), 0);
                }
            } else if (actionMasked == 3) {
            }
            this.f5623f = false;
            this.f5624g = -1;
            VelocityTracker velocityTracker2 = this.f5627j;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.f5627j = null;
            }
        } else {
            int x2 = (int) motionEvent.getX();
            int y3 = (int) motionEvent.getY();
            if (!coordinatorLayout.z(view, x2, y3) || !F(view)) {
                return false;
            }
            this.f5625h = y3;
            this.f5624g = motionEvent.getPointerId(0);
            G();
        }
        VelocityTracker velocityTracker3 = this.f5627j;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(motionEvent);
        }
        return true;
    }

    abstract boolean F(View view);

    final boolean H(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, float f2) {
        Runnable runnable = this.f5622d;
        if (runnable != null) {
            view.removeCallbacks(runnable);
            this.f5622d = null;
        }
        if (this.e == null) {
            this.e = new OverScroller(view.getContext());
        }
        this.e.fling(0, D(), 0, Math.round(f2), 0, 0, i2, i3);
        if (!this.e.computeScrollOffset()) {
            L(coordinatorLayout, view);
            return false;
        }
        RunnableC0071a runnableC0071a = new RunnableC0071a(coordinatorLayout, view);
        this.f5622d = runnableC0071a;
        M.a0(view, runnableC0071a);
        return true;
    }

    abstract int I(View view);

    abstract int J(View view);

    abstract int K();

    abstract void L(CoordinatorLayout coordinatorLayout, View view);

    final int M(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4) {
        return O(coordinatorLayout, view, K() - i2, i3, i4);
    }

    int N(CoordinatorLayout coordinatorLayout, View view, int i2) {
        return O(coordinatorLayout, view, i2, Target.SIZE_ORIGINAL, Integer.MAX_VALUE);
    }

    abstract int O(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4);

    /* JADX WARN: Removed duplicated region for block: B:27:0x0051  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean k(androidx.coordinatorlayout.widget.CoordinatorLayout r5, android.view.View r6, android.view.MotionEvent r7) {
        /*
            r4 = this;
            int r0 = r4.f5626i
            if (r0 >= 0) goto L12
            android.content.Context r0 = r5.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            r4.f5626i = r0
        L12:
            int r0 = r7.getAction()
            r1 = 2
            r2 = 1
            if (r0 != r1) goto L1f
            boolean r0 = r4.f5623f
            if (r0 == 0) goto L1f
            return r2
        L1f:
            int r0 = r7.getActionMasked()
            r3 = 0
            if (r0 == 0) goto L60
            r5 = -1
            if (r0 == r2) goto L51
            if (r0 == r1) goto L2f
            r6 = 3
            if (r0 == r6) goto L51
            goto L83
        L2f:
            int r6 = r4.f5624g
            if (r6 != r5) goto L34
            goto L83
        L34:
            int r6 = r7.findPointerIndex(r6)
            if (r6 != r5) goto L3b
            goto L83
        L3b:
            float r5 = r7.getY(r6)
            int r5 = (int) r5
            int r6 = r4.f5625h
            int r6 = r5 - r6
            int r6 = java.lang.Math.abs(r6)
            int r0 = r4.f5626i
            if (r6 <= r0) goto L83
            r4.f5623f = r2
            r4.f5625h = r5
            goto L83
        L51:
            r4.f5623f = r3
            r4.f5624g = r5
            android.view.VelocityTracker r5 = r4.f5627j
            if (r5 == 0) goto L83
            r5.recycle()
            r5 = 0
            r4.f5627j = r5
            goto L83
        L60:
            r4.f5623f = r3
            float r0 = r7.getX()
            int r0 = (int) r0
            float r1 = r7.getY()
            int r1 = (int) r1
            boolean r2 = r4.F(r6)
            if (r2 == 0) goto L83
            boolean r5 = r5.z(r6, r0, r1)
            if (r5 == 0) goto L83
            r4.f5625h = r1
            int r5 = r7.getPointerId(r3)
            r4.f5624g = r5
            r4.G()
        L83:
            android.view.VelocityTracker r5 = r4.f5627j
            if (r5 == 0) goto L8a
            r5.addMovement(r7)
        L8a:
            boolean r5 = r4.f5623f
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.a.k(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5624g = -1;
        this.f5626i = -1;
    }
}
