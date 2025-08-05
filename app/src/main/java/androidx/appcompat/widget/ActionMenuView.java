package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.Q;

/* loaded from: classes.dex */
public class ActionMenuView extends Q implements e.b, androidx.appcompat.view.menu.k {

    /* renamed from: A */
    e f2112A;

    /* renamed from: p */
    private androidx.appcompat.view.menu.e f2113p;

    /* renamed from: q */
    private Context f2114q;
    private int r;
    private boolean s;

    /* renamed from: t */
    private C0135c f2115t;

    /* renamed from: u */
    private j.a f2116u;

    /* renamed from: v */
    e.a f2117v;

    /* renamed from: w */
    private boolean f2118w;

    /* renamed from: x */
    private int f2119x;

    /* renamed from: y */
    private int f2120y;

    /* renamed from: z */
    private int f2121z;

    public interface a {
        boolean a();

        boolean b();
    }

    private static class b implements j.a {
        b() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public void a(androidx.appcompat.view.menu.e eVar, boolean z2) {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean b(androidx.appcompat.view.menu.e eVar) {
            return false;
        }
    }

    public static class c extends Q.a {

        /* renamed from: a */
        public boolean f2122a;

        /* renamed from: b */
        public int f2123b;

        /* renamed from: c */
        public int f2124c;

        /* renamed from: d */
        public boolean f2125d;
        public boolean e;

        /* renamed from: f */
        boolean f2126f;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c cVar) {
            super((ViewGroup.LayoutParams) cVar);
            this.f2122a = cVar.f2122a;
        }

        public c(int i2, int i3) {
            super(i2, i3);
            this.f2122a = false;
        }
    }

    private class d implements e.a {
        d() {
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            e eVar2 = ActionMenuView.this.f2112A;
            return eVar2 != null && eVar2.onMenuItemClick(menuItem);
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(androidx.appcompat.view.menu.e eVar) {
            e.a aVar = ActionMenuView.this.f2117v;
            if (aVar != null) {
                aVar.b(eVar);
            }
        }
    }

    public interface e {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static int L(android.view.View r5, int r6, int r7, int r8, int r9) {
        /*
            android.view.ViewGroup$LayoutParams r0 = r5.getLayoutParams()
            androidx.appcompat.widget.ActionMenuView$c r0 = (androidx.appcompat.widget.ActionMenuView.c) r0
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            int r1 = r1 - r9
            int r8 = android.view.View.MeasureSpec.getMode(r8)
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8)
            boolean r9 = r5 instanceof androidx.appcompat.view.menu.ActionMenuItemView
            if (r9 == 0) goto L1b
            r9 = r5
            androidx.appcompat.view.menu.ActionMenuItemView r9 = (androidx.appcompat.view.menu.ActionMenuItemView) r9
            goto L1c
        L1b:
            r9 = 0
        L1c:
            r1 = 0
            r2 = 1
            if (r9 == 0) goto L28
            boolean r9 = r9.s()
            if (r9 == 0) goto L28
            r9 = 1
            goto L29
        L28:
            r9 = 0
        L29:
            if (r7 <= 0) goto L4d
            r3 = 2
            if (r9 == 0) goto L30
            if (r7 < r3) goto L4d
        L30:
            int r7 = r7 * r6
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r4)
            r5.measure(r7, r8)
            int r7 = r5.getMeasuredWidth()
            int r4 = r7 / r6
            int r7 = r7 % r6
            if (r7 == 0) goto L46
            int r4 = r4 + 1
        L46:
            if (r9 == 0) goto L4b
            if (r4 >= r3) goto L4b
            goto L4e
        L4b:
            r3 = r4
            goto L4e
        L4d:
            r3 = 0
        L4e:
            boolean r7 = r0.f2122a
            if (r7 != 0) goto L55
            if (r9 == 0) goto L55
            r1 = 1
        L55:
            r0.f2125d = r1
            r0.f2123b = r3
            int r6 = r6 * r3
            r7 = 1073741824(0x40000000, float:2.0)
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r7)
            r5.measure(r6, r8)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionMenuView.L(android.view.View, int, int, int, int):int");
    }

    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9, types: [boolean, int] */
    private void M(int i2, int i3) {
        int i4;
        int i5;
        boolean z2;
        int i6;
        boolean z3;
        boolean z4;
        int i7;
        ?? r14;
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, paddingTop, -2);
        int i8 = size - paddingLeft;
        int i9 = this.f2120y;
        int i10 = i8 / i9;
        int i11 = i8 % i9;
        if (i10 == 0) {
            setMeasuredDimension(i8, 0);
            return;
        }
        int i12 = i9 + (i11 / i10);
        int childCount = getChildCount();
        int iMax = 0;
        int i13 = 0;
        boolean z5 = false;
        int i14 = 0;
        int iMax2 = 0;
        int i15 = 0;
        long j2 = 0;
        while (i13 < childCount) {
            View childAt = getChildAt(i13);
            int i16 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z6 = childAt instanceof ActionMenuItemView;
                int i17 = i14 + 1;
                if (z6) {
                    int i18 = this.f2121z;
                    i7 = i17;
                    r14 = 0;
                    childAt.setPadding(i18, 0, i18, 0);
                } else {
                    i7 = i17;
                    r14 = 0;
                }
                c cVar = (c) childAt.getLayoutParams();
                cVar.f2126f = r14;
                cVar.f2124c = r14;
                cVar.f2123b = r14;
                cVar.f2125d = r14;
                ((LinearLayout.LayoutParams) cVar).leftMargin = r14;
                ((LinearLayout.LayoutParams) cVar).rightMargin = r14;
                cVar.e = z6 && ((ActionMenuItemView) childAt).s();
                int iL = L(childAt, i12, cVar.f2122a ? 1 : i10, childMeasureSpec, paddingTop);
                iMax2 = Math.max(iMax2, iL);
                if (cVar.f2125d) {
                    i15++;
                }
                if (cVar.f2122a) {
                    z5 = true;
                }
                i10 -= iL;
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                if (iL == 1) {
                    j2 |= 1 << i13;
                    iMax = iMax;
                }
                i14 = i7;
            }
            i13++;
            size2 = i16;
        }
        int i19 = size2;
        boolean z7 = z5 && i14 == 2;
        boolean z8 = false;
        while (i15 > 0 && i10 > 0) {
            int i20 = 0;
            int i21 = 0;
            int i22 = Integer.MAX_VALUE;
            long j3 = 0;
            while (i21 < childCount) {
                boolean z9 = z8;
                c cVar2 = (c) getChildAt(i21).getLayoutParams();
                int i23 = iMax;
                if (cVar2.f2125d) {
                    int i24 = cVar2.f2123b;
                    if (i24 < i22) {
                        j3 = 1 << i21;
                        i22 = i24;
                        i20 = 1;
                    } else if (i24 == i22) {
                        i20++;
                        j3 |= 1 << i21;
                    }
                }
                i21++;
                iMax = i23;
                z8 = z9;
            }
            z2 = z8;
            i6 = iMax;
            j2 |= j3;
            if (i20 > i10) {
                i4 = mode;
                i5 = i8;
                break;
            }
            int i25 = i22 + 1;
            int i26 = 0;
            while (i26 < childCount) {
                View childAt2 = getChildAt(i26);
                c cVar3 = (c) childAt2.getLayoutParams();
                int i27 = i8;
                int i28 = mode;
                long j4 = 1 << i26;
                if ((j3 & j4) == 0) {
                    if (cVar3.f2123b == i25) {
                        j2 |= j4;
                    }
                    z4 = z7;
                } else {
                    if (z7 && cVar3.e && i10 == 1) {
                        int i29 = this.f2121z;
                        z4 = z7;
                        childAt2.setPadding(i29 + i12, 0, i29, 0);
                    } else {
                        z4 = z7;
                    }
                    cVar3.f2123b++;
                    cVar3.f2126f = true;
                    i10--;
                }
                i26++;
                mode = i28;
                i8 = i27;
                z7 = z4;
            }
            iMax = i6;
            z8 = true;
        }
        i4 = mode;
        i5 = i8;
        z2 = z8;
        i6 = iMax;
        boolean z10 = !z5 && i14 == 1;
        if (i10 <= 0 || j2 == 0 || (i10 >= i14 - 1 && !z10 && iMax2 <= 1)) {
            z3 = z2;
        } else {
            float fBitCount = Long.bitCount(j2);
            if (!z10) {
                if ((j2 & 1) != 0 && !((c) getChildAt(0).getLayoutParams()).e) {
                    fBitCount -= 0.5f;
                }
                int i30 = childCount - 1;
                if ((j2 & (1 << i30)) != 0 && !((c) getChildAt(i30).getLayoutParams()).e) {
                    fBitCount -= 0.5f;
                }
            }
            int i31 = fBitCount > 0.0f ? (int) ((i10 * i12) / fBitCount) : 0;
            z3 = z2;
            for (int i32 = 0; i32 < childCount; i32++) {
                if ((j2 & (1 << i32)) != 0) {
                    View childAt3 = getChildAt(i32);
                    c cVar4 = (c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cVar4.f2124c = i31;
                        cVar4.f2126f = true;
                        if (i32 == 0 && !cVar4.e) {
                            ((LinearLayout.LayoutParams) cVar4).leftMargin = (-i31) / 2;
                        }
                    } else if (cVar4.f2122a) {
                        cVar4.f2124c = i31;
                        cVar4.f2126f = true;
                        ((LinearLayout.LayoutParams) cVar4).rightMargin = (-i31) / 2;
                    } else {
                        if (i32 != 0) {
                            ((LinearLayout.LayoutParams) cVar4).leftMargin = i31 / 2;
                        }
                        if (i32 != childCount - 1) {
                            ((LinearLayout.LayoutParams) cVar4).rightMargin = i31 / 2;
                        }
                    }
                    z3 = true;
                }
            }
        }
        if (z3) {
            for (int i33 = 0; i33 < childCount; i33++) {
                View childAt4 = getChildAt(i33);
                c cVar5 = (c) childAt4.getLayoutParams();
                if (cVar5.f2126f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((cVar5.f2123b * i12) + cVar5.f2124c, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i5, i4 != 1073741824 ? i6 : i19);
    }

    public void B() {
        C0135c c0135c = this.f2115t;
        if (c0135c != null) {
            c0135c.y();
        }
    }

    @Override // androidx.appcompat.widget.Q
    /* renamed from: C */
    public c generateDefaultLayoutParams() {
        c cVar = new c(-2, -2);
        ((LinearLayout.LayoutParams) cVar).gravity = 16;
        return cVar;
    }

    @Override // androidx.appcompat.widget.Q
    /* renamed from: D */
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.Q
    /* renamed from: E */
    public c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        c cVar = layoutParams instanceof c ? new c((c) layoutParams) : new c(layoutParams);
        if (((LinearLayout.LayoutParams) cVar).gravity <= 0) {
            ((LinearLayout.LayoutParams) cVar).gravity = 16;
        }
        return cVar;
    }

    public c F() {
        c cVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        cVarGenerateDefaultLayoutParams.f2122a = true;
        return cVarGenerateDefaultLayoutParams;
    }

    protected boolean G(int i2) {
        boolean zA = false;
        if (i2 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i2 - 1);
        KeyEvent.Callback childAt2 = getChildAt(i2);
        if (i2 < getChildCount() && (childAt instanceof a)) {
            zA = ((a) childAt).a();
        }
        return (i2 <= 0 || !(childAt2 instanceof a)) ? zA : zA | ((a) childAt2).b();
    }

    public boolean H() {
        C0135c c0135c = this.f2115t;
        return c0135c != null && c0135c.B();
    }

    public boolean I() {
        C0135c c0135c = this.f2115t;
        return c0135c != null && c0135c.D();
    }

    public boolean J() {
        C0135c c0135c = this.f2115t;
        return c0135c != null && c0135c.E();
    }

    public boolean K() {
        return this.s;
    }

    public androidx.appcompat.view.menu.e N() {
        return this.f2113p;
    }

    public void O(j.a aVar, e.a aVar2) {
        this.f2116u = aVar;
        this.f2117v = aVar2;
    }

    public boolean P() {
        C0135c c0135c = this.f2115t;
        return c0135c != null && c0135c.K();
    }

    @Override // androidx.appcompat.view.menu.e.b
    public boolean a(androidx.appcompat.view.menu.g gVar) {
        return this.f2113p.M(gVar, 0);
    }

    @Override // androidx.appcompat.view.menu.k
    public void b(androidx.appcompat.view.menu.e eVar) {
        this.f2113p = eVar;
    }

    @Override // androidx.appcompat.widget.Q, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public Menu getMenu() {
        if (this.f2113p == null) {
            Context context = getContext();
            androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(context);
            this.f2113p = eVar;
            eVar.S(new d());
            C0135c c0135c = new C0135c(context);
            this.f2115t = c0135c;
            c0135c.J(true);
            C0135c c0135c2 = this.f2115t;
            j.a bVar = this.f2116u;
            if (bVar == null) {
                bVar = new b();
            }
            c0135c2.h(bVar);
            this.f2113p.c(this.f2115t, this.f2114q);
            this.f2115t.H(this);
        }
        return this.f2113p;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f2115t.A();
    }

    public int getPopupTheme() {
        return this.r;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0135c c0135c = this.f2115t;
        if (c0135c != null) {
            c0135c.j(false);
            if (this.f2115t.E()) {
                this.f2115t.B();
                this.f2115t.K();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        B();
    }

    @Override // androidx.appcompat.widget.Q, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int width;
        int paddingLeft;
        if (!this.f2118w) {
            super.onLayout(z2, i2, i3, i4, i5);
            return;
        }
        int childCount = getChildCount();
        int i6 = (i5 - i3) / 2;
        int dividerWidth = getDividerWidth();
        int i7 = i4 - i2;
        int paddingRight = (i7 - getPaddingRight()) - getPaddingLeft();
        boolean zB = o0.b(this);
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f2122a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (G(i10)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (zB) {
                        paddingLeft = getPaddingLeft() + ((LinearLayout.LayoutParams) cVar).leftMargin;
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) cVar).rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i11 = i6 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i11, width, measuredHeight + i11);
                    paddingRight -= measuredWidth;
                    i8 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) cVar).leftMargin) + ((LinearLayout.LayoutParams) cVar).rightMargin;
                    G(i10);
                    i9++;
                }
            }
        }
        if (childCount == 1 && i8 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i12 = (i7 / 2) - (measuredWidth2 / 2);
            int i13 = i6 - (measuredHeight2 / 2);
            childAt2.layout(i12, i13, measuredWidth2 + i12, measuredHeight2 + i13);
            return;
        }
        int i14 = i9 - (i8 ^ 1);
        int iMax = Math.max(0, i14 > 0 ? paddingRight / i14 : 0);
        if (zB) {
            int width2 = getWidth() - getPaddingRight();
            for (int i15 = 0; i15 < childCount; i15++) {
                View childAt3 = getChildAt(i15);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.f2122a) {
                    int i16 = width2 - ((LinearLayout.LayoutParams) cVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i17 = i6 - (measuredHeight3 / 2);
                    childAt3.layout(i16 - measuredWidth3, i17, i16, measuredHeight3 + i17);
                    width2 = i16 - ((measuredWidth3 + ((LinearLayout.LayoutParams) cVar2).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt4 = getChildAt(i18);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.f2122a) {
                int i19 = paddingLeft2 + ((LinearLayout.LayoutParams) cVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i20 = i6 - (measuredHeight4 / 2);
                childAt4.layout(i19, i20, i19 + measuredWidth4, measuredHeight4 + i20);
                paddingLeft2 = i19 + measuredWidth4 + ((LinearLayout.LayoutParams) cVar3).rightMargin + iMax;
            }
        }
    }

    @Override // androidx.appcompat.widget.Q, android.view.View
    protected void onMeasure(int i2, int i3) {
        androidx.appcompat.view.menu.e eVar;
        boolean z2 = this.f2118w;
        boolean z3 = View.MeasureSpec.getMode(i2) == 1073741824;
        this.f2118w = z3;
        if (z2 != z3) {
            this.f2119x = 0;
        }
        int size = View.MeasureSpec.getSize(i2);
        if (this.f2118w && (eVar = this.f2113p) != null && size != this.f2119x) {
            this.f2119x = size;
            eVar.L(true);
        }
        int childCount = getChildCount();
        if (this.f2118w && childCount > 0) {
            M(i2, i3);
            return;
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            c cVar = (c) getChildAt(i4).getLayoutParams();
            ((LinearLayout.LayoutParams) cVar).rightMargin = 0;
            ((LinearLayout.LayoutParams) cVar).leftMargin = 0;
        }
        super.onMeasure(i2, i3);
    }

    public void setExpandedActionViewsExclusive(boolean z2) {
        this.f2115t.G(z2);
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.f2112A = eVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f2115t.I(drawable);
    }

    public void setOverflowReserved(boolean z2) {
        this.s = z2;
    }

    public void setPopupTheme(int i2) {
        if (this.r != i2) {
            this.r = i2;
            if (i2 == 0) {
                this.f2114q = getContext();
            } else {
                this.f2114q = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public void setPresenter(C0135c c0135c) {
        this.f2115t = c0135c;
        c0135c.H(this);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.f2120y = (int) (56.0f * f2);
        this.f2121z = (int) (f2 * 4.0f);
        this.f2114q = context;
        this.r = 0;
    }
}
