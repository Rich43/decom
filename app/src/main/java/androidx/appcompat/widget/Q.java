package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import defpackage.e;

/* loaded from: classes.dex */
public abstract class Q extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    private boolean f2225a;

    /* renamed from: b, reason: collision with root package name */
    private int f2226b;

    /* renamed from: c, reason: collision with root package name */
    private int f2227c;

    /* renamed from: d, reason: collision with root package name */
    private int f2228d;
    private int e;

    /* renamed from: f, reason: collision with root package name */
    private int f2229f;

    /* renamed from: g, reason: collision with root package name */
    private float f2230g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f2231h;

    /* renamed from: i, reason: collision with root package name */
    private int[] f2232i;

    /* renamed from: j, reason: collision with root package name */
    private int[] f2233j;

    /* renamed from: k, reason: collision with root package name */
    private Drawable f2234k;

    /* renamed from: l, reason: collision with root package name */
    private int f2235l;

    /* renamed from: m, reason: collision with root package name */
    private int f2236m;

    /* renamed from: n, reason: collision with root package name */
    private int f2237n;
    private int o;

    public static class a extends LinearLayout.LayoutParams {
        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public a(int i2, int i3) {
            super(i2, i3);
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    public Q(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void A(View view, int i2, int i3, int i4, int i5) {
        view.layout(i2, i3, i4 + i2, i5 + i3);
    }

    private void k(int i2, int i3) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i4 = 0; i4 < i2; i4++) {
            View viewS = s(i4);
            if (viewS.getVisibility() != 8) {
                a aVar = (a) viewS.getLayoutParams();
                if (((LinearLayout.LayoutParams) aVar).height == -1) {
                    int i5 = ((LinearLayout.LayoutParams) aVar).width;
                    ((LinearLayout.LayoutParams) aVar).width = viewS.getMeasuredWidth();
                    measureChildWithMargins(viewS, i3, 0, iMakeMeasureSpec, 0);
                    ((LinearLayout.LayoutParams) aVar).width = i5;
                }
            }
        }
    }

    private void l(int i2, int i3) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i4 = 0; i4 < i2; i4++) {
            View viewS = s(i4);
            if (viewS.getVisibility() != 8) {
                a aVar = (a) viewS.getLayoutParams();
                if (((LinearLayout.LayoutParams) aVar).width == -1) {
                    int i5 = ((LinearLayout.LayoutParams) aVar).height;
                    ((LinearLayout.LayoutParams) aVar).height = viewS.getMeasuredHeight();
                    measureChildWithMargins(viewS, iMakeMeasureSpec, 0, i3, 0);
                    ((LinearLayout.LayoutParams) aVar).height = i5;
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    void g(Canvas canvas) {
        int right;
        int left;
        int i2;
        int virtualChildCount = getVirtualChildCount();
        boolean zB = o0.b(this);
        for (int i3 = 0; i3 < virtualChildCount; i3++) {
            View viewS = s(i3);
            if (viewS != null && viewS.getVisibility() != 8 && t(i3)) {
                a aVar = (a) viewS.getLayoutParams();
                j(canvas, zB ? viewS.getRight() + ((LinearLayout.LayoutParams) aVar).rightMargin : (viewS.getLeft() - ((LinearLayout.LayoutParams) aVar).leftMargin) - this.f2235l);
            }
        }
        if (t(virtualChildCount)) {
            View viewS2 = s(virtualChildCount - 1);
            if (viewS2 != null) {
                a aVar2 = (a) viewS2.getLayoutParams();
                if (zB) {
                    left = viewS2.getLeft() - ((LinearLayout.LayoutParams) aVar2).leftMargin;
                    i2 = this.f2235l;
                    right = left - i2;
                } else {
                    right = viewS2.getRight() + ((LinearLayout.LayoutParams) aVar2).rightMargin;
                }
            } else if (zB) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i2 = this.f2235l;
                right = left - i2;
            }
            j(canvas, right);
        }
    }

    @Override // android.view.View
    public int getBaseline() {
        int i2;
        if (this.f2226b < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i3 = this.f2226b;
        if (childCount <= i3) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i3);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f2226b == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.f2227c;
        if (this.f2228d == 1 && (i2 = this.e & 112) != 48) {
            if (i2 == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f2229f) / 2;
            } else if (i2 == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.f2229f;
            }
        }
        return bottom + ((LinearLayout.LayoutParams) ((a) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f2226b;
    }

    public Drawable getDividerDrawable() {
        return this.f2234k;
    }

    public int getDividerPadding() {
        return this.o;
    }

    public int getDividerWidth() {
        return this.f2235l;
    }

    public int getGravity() {
        return this.e;
    }

    public int getOrientation() {
        return this.f2228d;
    }

    public int getShowDividers() {
        return this.f2237n;
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f2230g;
    }

    void h(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i2 = 0; i2 < virtualChildCount; i2++) {
            View viewS = s(i2);
            if (viewS != null && viewS.getVisibility() != 8 && t(i2)) {
                i(canvas, (viewS.getTop() - ((LinearLayout.LayoutParams) ((a) viewS.getLayoutParams())).topMargin) - this.f2236m);
            }
        }
        if (t(virtualChildCount)) {
            View viewS2 = s(virtualChildCount - 1);
            i(canvas, viewS2 == null ? (getHeight() - getPaddingBottom()) - this.f2236m : viewS2.getBottom() + ((LinearLayout.LayoutParams) ((a) viewS2.getLayoutParams())).bottomMargin);
        }
    }

    void i(Canvas canvas, int i2) {
        this.f2234k.setBounds(getPaddingLeft() + this.o, i2, (getWidth() - getPaddingRight()) - this.o, this.f2236m + i2);
        this.f2234k.draw(canvas);
    }

    void j(Canvas canvas, int i2) {
        this.f2234k.setBounds(i2, getPaddingTop() + this.o, this.f2235l + i2, (getHeight() - getPaddingBottom()) - this.o);
        this.f2234k.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        int i2 = this.f2228d;
        if (i2 == 0) {
            return new a(-2, -2);
        }
        if (i2 == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a ? new a((ViewGroup.MarginLayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new a((ViewGroup.MarginLayoutParams) layoutParams) : new a(layoutParams);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f2234k == null) {
            return;
        }
        if (this.f2228d == 1) {
            h(canvas);
        } else {
            g(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        if (this.f2228d == 1) {
            v(i2, i3, i4, i5);
        } else {
            u(i2, i3, i4, i5);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        if (this.f2228d == 1) {
            z(i2, i3);
        } else {
            x(i2, i3);
        }
    }

    int p(View view, int i2) {
        return 0;
    }

    int q(View view) {
        return 0;
    }

    int r(View view) {
        return 0;
    }

    View s(int i2) {
        return getChildAt(i2);
    }

    public void setBaselineAligned(boolean z2) {
        this.f2225a = z2;
    }

    public void setBaselineAlignedChildIndex(int i2) {
        if (i2 >= 0 && i2 < getChildCount()) {
            this.f2226b = i2;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f2234k) {
            return;
        }
        this.f2234k = drawable;
        if (drawable != null) {
            this.f2235l = drawable.getIntrinsicWidth();
            this.f2236m = drawable.getIntrinsicHeight();
        } else {
            this.f2235l = 0;
            this.f2236m = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i2) {
        this.o = i2;
    }

    public void setGravity(int i2) {
        if (this.e != i2) {
            if ((8388615 & i2) == 0) {
                i2 |= 8388611;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.e = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i2) {
        int i3 = i2 & 8388615;
        int i4 = this.e;
        if ((8388615 & i4) != i3) {
            this.e = i3 | ((-8388616) & i4);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z2) {
        this.f2231h = z2;
    }

    public void setOrientation(int i2) {
        if (this.f2228d != i2) {
            this.f2228d = i2;
            requestLayout();
        }
    }

    public void setShowDividers(int i2) {
        if (i2 != this.f2237n) {
            requestLayout();
        }
        this.f2237n = i2;
    }

    public void setVerticalGravity(int i2) {
        int i3 = i2 & 112;
        int i4 = this.e;
        if ((i4 & 112) != i3) {
            this.e = i3 | (i4 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f2) {
        this.f2230g = Math.max(0.0f, f2);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    protected boolean t(int i2) {
        if (i2 == 0) {
            return (this.f2237n & 1) != 0;
        }
        if (i2 == getChildCount()) {
            return (this.f2237n & 4) != 0;
        }
        if ((this.f2237n & 2) == 0) {
            return false;
        }
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            if (getChildAt(i3).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void u(int r25, int r26, int r27, int r28) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Q.u(int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void v(int r18, int r19, int r20, int r21) {
        /*
            r17 = this;
            r6 = r17
            int r7 = r17.getPaddingLeft()
            int r0 = r20 - r18
            int r1 = r17.getPaddingRight()
            int r8 = r0 - r1
            int r0 = r0 - r7
            int r1 = r17.getPaddingRight()
            int r9 = r0 - r1
            int r10 = r17.getVirtualChildCount()
            int r0 = r6.e
            r1 = r0 & 112(0x70, float:1.57E-43)
            r2 = 8388615(0x800007, float:1.1754953E-38)
            r11 = r0 & r2
            r0 = 16
            if (r1 == r0) goto L3b
            r0 = 80
            if (r1 == r0) goto L2f
            int r0 = r17.getPaddingTop()
            goto L47
        L2f:
            int r0 = r17.getPaddingTop()
            int r0 = r0 + r21
            int r0 = r0 - r19
            int r1 = r6.f2229f
            int r0 = r0 - r1
            goto L47
        L3b:
            int r0 = r17.getPaddingTop()
            int r1 = r21 - r19
            int r2 = r6.f2229f
            int r1 = r1 - r2
            int r1 = r1 / 2
            int r0 = r0 + r1
        L47:
            r1 = 0
            r12 = 0
        L49:
            if (r12 >= r10) goto Lcb
            android.view.View r13 = r6.s(r12)
            r14 = 1
            if (r13 != 0) goto L5a
            int r1 = r6.y(r12)
            int r0 = r0 + r1
        L57:
            r1 = 1
            goto Lc8
        L5a:
            int r1 = r13.getVisibility()
            r2 = 8
            if (r1 == r2) goto L57
            int r4 = r13.getMeasuredWidth()
            int r15 = r13.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r1 = r13.getLayoutParams()
            r5 = r1
            androidx.appcompat.widget.Q$a r5 = (androidx.appcompat.widget.Q.a) r5
            int r1 = r5.gravity
            if (r1 >= 0) goto L76
            r1 = r11
        L76:
            int r2 = r17.getLayoutDirection()
            int r1 = androidx.core.view.AbstractC0176t.b(r1, r2)
            r1 = r1 & 7
            if (r1 == r14) goto L90
            r2 = 5
            if (r1 == r2) goto L8a
            int r1 = r5.leftMargin
            int r1 = r1 + r7
        L88:
            r2 = r1
            goto L9b
        L8a:
            int r1 = r8 - r4
            int r2 = r5.rightMargin
        L8e:
            int r1 = r1 - r2
            goto L88
        L90:
            int r1 = r9 - r4
            int r1 = r1 / 2
            int r1 = r1 + r7
            int r2 = r5.leftMargin
            int r1 = r1 + r2
            int r2 = r5.rightMargin
            goto L8e
        L9b:
            boolean r1 = r6.t(r12)
            if (r1 == 0) goto La4
            int r1 = r6.f2236m
            int r0 = r0 + r1
        La4:
            int r1 = r5.topMargin
            int r16 = r0 + r1
            int r0 = r6.q(r13)
            int r3 = r16 + r0
            r0 = r17
            r1 = r13
            r14 = r5
            r5 = r15
            r0.A(r1, r2, r3, r4, r5)
            int r0 = r14.bottomMargin
            int r15 = r15 + r0
            int r0 = r6.r(r13)
            int r15 = r15 + r0
            int r16 = r16 + r15
            int r0 = r6.p(r13, r12)
            int r12 = r12 + r0
            r0 = r16
            goto L57
        Lc8:
            int r12 = r12 + r1
            goto L49
        Lcb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Q.v(int, int, int, int):void");
    }

    void w(View view, int i2, int i3, int i4, int i5, int i6) {
        measureChildWithMargins(view, i3, i4, i5, i6);
    }

    /* JADX WARN: Removed duplicated region for block: B:200:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void x(int r39, int r40) {
        /*
            Method dump skipped, instructions count: 1287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Q.x(int, int):void");
    }

    int y(int i2) {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:152:0x032d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void z(int r34, int r35) {
        /*
            Method dump skipped, instructions count: 908
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Q.z(int, int):void");
    }

    public Q(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2225a = true;
        this.f2226b = -1;
        this.f2227c = 0;
        this.e = 8388659;
        int[] iArr = e.m.f6026a1;
        d0 d0VarU = d0.u(context, attributeSet, iArr, i2, 0);
        androidx.core.view.M.d0(this, context, iArr, attributeSet, d0VarU.q(), i2, 0);
        int iJ = d0VarU.j(e.m.f6032c1, -1);
        if (iJ >= 0) {
            setOrientation(iJ);
        }
        int iJ2 = d0VarU.j(e.m.f6029b1, -1);
        if (iJ2 >= 0) {
            setGravity(iJ2);
        }
        boolean zA = d0VarU.a(e.m.f6035d1, true);
        if (!zA) {
            setBaselineAligned(zA);
        }
        this.f2230g = d0VarU.h(e.m.f6040f1, -1.0f);
        this.f2226b = d0VarU.j(e.m.f6037e1, -1);
        this.f2231h = d0VarU.a(e.m.f6049i1, false);
        setDividerDrawable(d0VarU.f(e.m.f6043g1));
        this.f2237n = d0VarU.j(e.m.f6052j1, 0);
        this.o = d0VarU.e(e.m.f6046h1, 0);
        d0VarU.w();
    }
}
