package androidx.appcompat.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.view.menu.j;
import androidx.core.view.Z;
import com.bumptech.glide.request.target.Target;
import defpackage.e;

@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements K, androidx.core.view.C, androidx.core.view.D {

    /* renamed from: G, reason: collision with root package name */
    static final int[] f2078G = {e.d.f5837b, R.attr.windowContentOverlay};

    /* renamed from: H, reason: collision with root package name */
    private static final androidx.core.view.Z f2079H = new Z.b().c(androidx.core.graphics.f.b(0, 1, 0, 1)).a();

    /* renamed from: I, reason: collision with root package name */
    private static final Rect f2080I = new Rect();

    /* renamed from: A, reason: collision with root package name */
    ViewPropertyAnimator f2081A;

    /* renamed from: B, reason: collision with root package name */
    final AnimatorListenerAdapter f2082B;

    /* renamed from: C, reason: collision with root package name */
    private final Runnable f2083C;

    /* renamed from: D, reason: collision with root package name */
    private final Runnable f2084D;

    /* renamed from: E, reason: collision with root package name */
    private final androidx.core.view.E f2085E;

    /* renamed from: F, reason: collision with root package name */
    private final f f2086F;

    /* renamed from: a, reason: collision with root package name */
    private int f2087a;

    /* renamed from: b, reason: collision with root package name */
    private int f2088b;

    /* renamed from: c, reason: collision with root package name */
    private ContentFrameLayout f2089c;

    /* renamed from: d, reason: collision with root package name */
    ActionBarContainer f2090d;
    private L e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f2091f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f2092g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f2093h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f2094i;

    /* renamed from: j, reason: collision with root package name */
    boolean f2095j;

    /* renamed from: k, reason: collision with root package name */
    private int f2096k;

    /* renamed from: l, reason: collision with root package name */
    private int f2097l;

    /* renamed from: m, reason: collision with root package name */
    private final Rect f2098m;

    /* renamed from: n, reason: collision with root package name */
    private final Rect f2099n;
    private final Rect o;

    /* renamed from: p, reason: collision with root package name */
    private final Rect f2100p;

    /* renamed from: q, reason: collision with root package name */
    private final Rect f2101q;
    private final Rect r;
    private final Rect s;

    /* renamed from: t, reason: collision with root package name */
    private final Rect f2102t;

    /* renamed from: u, reason: collision with root package name */
    private androidx.core.view.Z f2103u;

    /* renamed from: v, reason: collision with root package name */
    private androidx.core.view.Z f2104v;

    /* renamed from: w, reason: collision with root package name */
    private androidx.core.view.Z f2105w;

    /* renamed from: x, reason: collision with root package name */
    private androidx.core.view.Z f2106x;

    /* renamed from: y, reason: collision with root package name */
    private d f2107y;

    /* renamed from: z, reason: collision with root package name */
    private OverScroller f2108z;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f2081A = null;
            actionBarOverlayLayout.f2095j = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f2081A = null;
            actionBarOverlayLayout.f2095j = false;
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.v();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f2081A = actionBarOverlayLayout.f2090d.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.f2082B);
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.v();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f2081A = actionBarOverlayLayout.f2090d.animate().translationY(-ActionBarOverlayLayout.this.f2090d.getHeight()).setListener(ActionBarOverlayLayout.this.f2082B);
        }
    }

    public interface d {
        void a(boolean z2);

        void b();

        void c();

        void d(int i2);

        void e();

        void f();
    }

    public static class e extends ViewGroup.MarginLayoutParams {
        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public e(int i2, int i3) {
            super(i2, i3);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    private static final class f extends View {
        f(Context context) {
            super(context);
            setWillNotDraw(true);
        }

        @Override // android.view.View
        public int getWindowSystemUiVisibility() {
            return 0;
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2088b = 0;
        this.f2098m = new Rect();
        this.f2099n = new Rect();
        this.o = new Rect();
        this.f2100p = new Rect();
        this.f2101q = new Rect();
        this.r = new Rect();
        this.s = new Rect();
        this.f2102t = new Rect();
        androidx.core.view.Z z2 = androidx.core.view.Z.f3123b;
        this.f2103u = z2;
        this.f2104v = z2;
        this.f2105w = z2;
        this.f2106x = z2;
        this.f2082B = new a();
        this.f2083C = new b();
        this.f2084D = new c();
        w(context);
        this.f2085E = new androidx.core.view.E(this);
        f fVar = new f(context);
        this.f2086F = fVar;
        addView(fVar);
    }

    private void B() {
        v();
        this.f2083C.run();
    }

    private boolean C(float f2) {
        this.f2108z.fling(0, 0, 0, (int) f2, 0, 0, Target.SIZE_ORIGINAL, Integer.MAX_VALUE);
        return this.f2108z.getFinalY() > this.f2090d.getHeight();
    }

    private void p() {
        v();
        this.f2084D.run();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean q(android.view.View r3, android.graphics.Rect r4, boolean r5, boolean r6, boolean r7, boolean r8) {
        /*
            r2 = this;
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.appcompat.widget.ActionBarOverlayLayout$e r3 = (androidx.appcompat.widget.ActionBarOverlayLayout.e) r3
            r0 = 1
            if (r5 == 0) goto L13
            int r5 = r3.leftMargin
            int r1 = r4.left
            if (r5 == r1) goto L13
            r3.leftMargin = r1
            r5 = 1
            goto L14
        L13:
            r5 = 0
        L14:
            if (r6 == 0) goto L1f
            int r6 = r3.topMargin
            int r1 = r4.top
            if (r6 == r1) goto L1f
            r3.topMargin = r1
            r5 = 1
        L1f:
            if (r8 == 0) goto L2a
            int r6 = r3.rightMargin
            int r8 = r4.right
            if (r6 == r8) goto L2a
            r3.rightMargin = r8
            r5 = 1
        L2a:
            if (r7 == 0) goto L35
            int r6 = r3.bottomMargin
            int r4 = r4.bottom
            if (r6 == r4) goto L35
            r3.bottomMargin = r4
            goto L36
        L35:
            r0 = r5
        L36:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.q(android.view.View, android.graphics.Rect, boolean, boolean, boolean, boolean):boolean");
    }

    private boolean r() {
        androidx.core.view.M.f(this.f2086F, f2079H, this.f2100p);
        return !this.f2100p.equals(f2080I);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private L u(View view) {
        if (view instanceof L) {
            return (L) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    private void w(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f2078G);
        this.f2087a = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f2091f = drawable;
        setWillNotDraw(drawable == null);
        typedArrayObtainStyledAttributes.recycle();
        this.f2108z = new OverScroller(context);
    }

    private void y() {
        v();
        postDelayed(this.f2084D, 600L);
    }

    private void z() {
        v();
        postDelayed(this.f2083C, 600L);
    }

    void A() {
        if (this.f2089c == null) {
            this.f2089c = (ContentFrameLayout) findViewById(e.i.f5922b);
            this.f2090d = (ActionBarContainer) findViewById(e.i.f5923c);
            this.e = u(findViewById(e.i.f5921a));
        }
    }

    @Override // androidx.appcompat.widget.K
    public void a(Menu menu, j.a aVar) {
        A();
        this.e.a(menu, aVar);
    }

    @Override // androidx.appcompat.widget.K
    public boolean b() {
        A();
        return this.e.b();
    }

    @Override // androidx.appcompat.widget.K
    public boolean c() {
        A();
        return this.e.c();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // androidx.appcompat.widget.K
    public boolean d() {
        A();
        return this.e.d();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f2091f != null) {
            int bottom = this.f2090d.getVisibility() == 0 ? (int) (this.f2090d.getBottom() + this.f2090d.getTranslationY() + 0.5f) : 0;
            this.f2091f.setBounds(0, bottom, getWidth(), this.f2091f.getIntrinsicHeight() + bottom);
            this.f2091f.draw(canvas);
        }
    }

    @Override // androidx.appcompat.widget.K
    public boolean e() {
        A();
        return this.e.e();
    }

    @Override // androidx.appcompat.widget.K
    public void f() {
        A();
        this.e.f();
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // androidx.appcompat.widget.K
    public boolean g() {
        A();
        return this.e.g();
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f2090d;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f2085E.a();
    }

    public CharSequence getTitle() {
        A();
        return this.e.getTitle();
    }

    @Override // androidx.core.view.C
    public void h(View view, View view2, int i2, int i3) {
        if (i3 == 0) {
            onNestedScrollAccepted(view, view2, i2);
        }
    }

    @Override // androidx.core.view.C
    public void i(View view, int i2) {
        if (i2 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // androidx.core.view.C
    public void j(View view, int i2, int i3, int[] iArr, int i4) {
        if (i4 == 0) {
            onNestedPreScroll(view, i2, i3, iArr);
        }
    }

    @Override // androidx.appcompat.widget.K
    public void k(int i2) {
        A();
        if (i2 == 2) {
            this.e.q();
        } else if (i2 == 5) {
            this.e.s();
        } else {
            if (i2 != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    @Override // androidx.appcompat.widget.K
    public void l() {
        A();
        this.e.h();
    }

    @Override // androidx.core.view.D
    public void m(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        n(view, i2, i3, i4, i5, i6);
    }

    @Override // androidx.core.view.C
    public void n(View view, int i2, int i3, int i4, int i5, int i6) {
        if (i6 == 0) {
            onNestedScroll(view, i2, i3, i4, i5);
        }
    }

    @Override // androidx.core.view.C
    public boolean o(View view, View view2, int i2, int i3) {
        return i3 == 0 && onStartNestedScroll(view, view2, i2);
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        A();
        androidx.core.view.Z zV = androidx.core.view.Z.v(windowInsets, this);
        boolean zQ = q(this.f2090d, new Rect(zV.i(), zV.k(), zV.j(), zV.h()), true, true, false, true);
        androidx.core.view.M.f(this, zV, this.f2098m);
        Rect rect = this.f2098m;
        androidx.core.view.Z zL = zV.l(rect.left, rect.top, rect.right, rect.bottom);
        this.f2103u = zL;
        boolean z2 = true;
        if (!this.f2104v.equals(zL)) {
            this.f2104v = this.f2103u;
            zQ = true;
        }
        if (this.f2099n.equals(this.f2098m)) {
            z2 = zQ;
        } else {
            this.f2099n.set(this.f2098m);
        }
        if (z2) {
            requestLayout();
        }
        return zV.a().c().b().t();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        w(getContext());
        androidx.core.view.M.c0(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        v();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i7 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin + paddingLeft;
                int i8 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + paddingTop;
                childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int measuredHeight;
        A();
        measureChildWithMargins(this.f2090d, i2, 0, i3, 0);
        e eVar = (e) this.f2090d.getLayoutParams();
        int iMax = Math.max(0, this.f2090d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin);
        int iMax2 = Math.max(0, this.f2090d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        int iCombineMeasuredStates = View.combineMeasuredStates(0, this.f2090d.getMeasuredState());
        boolean z2 = (androidx.core.view.M.H(this) & 256) != 0;
        if (z2) {
            measuredHeight = this.f2087a;
            if (this.f2093h && this.f2090d.getTabContainer() != null) {
                measuredHeight += this.f2087a;
            }
        } else {
            measuredHeight = this.f2090d.getVisibility() != 8 ? this.f2090d.getMeasuredHeight() : 0;
        }
        this.o.set(this.f2098m);
        this.f2105w = this.f2103u;
        if (this.f2092g || z2 || !r()) {
            this.f2105w = new Z.b(this.f2105w).c(androidx.core.graphics.f.b(this.f2105w.i(), this.f2105w.k() + measuredHeight, this.f2105w.j(), this.f2105w.h())).a();
        } else {
            Rect rect = this.o;
            rect.top += measuredHeight;
            rect.bottom = rect.bottom;
            this.f2105w = this.f2105w.l(0, measuredHeight, 0, 0);
        }
        q(this.f2089c, this.o, true, true, true, true);
        if (!this.f2106x.equals(this.f2105w)) {
            androidx.core.view.Z z3 = this.f2105w;
            this.f2106x = z3;
            androidx.core.view.M.g(this.f2089c, z3);
        }
        measureChildWithMargins(this.f2089c, i2, 0, i3, 0);
        e eVar2 = (e) this.f2089c.getLayoutParams();
        int iMax3 = Math.max(iMax, this.f2089c.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar2).leftMargin + ((ViewGroup.MarginLayoutParams) eVar2).rightMargin);
        int iMax4 = Math.max(iMax2, this.f2089c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar2).topMargin + ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin);
        int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f2089c.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i2, iCombineMeasuredStates2), View.resolveSizeAndState(Math.max(iMax4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i3, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        if (!this.f2094i || !z2) {
            return false;
        }
        if (C(f3)) {
            p();
        } else {
            B();
        }
        this.f2095j = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        int i6 = this.f2096k + i3;
        this.f2096k = i6;
        setActionBarHideOffset(i6);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.f2085E.b(view, view2, i2);
        this.f2096k = getActionBarHideOffset();
        v();
        d dVar = this.f2107y;
        if (dVar != null) {
            dVar.c();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        if ((i2 & 2) == 0 || this.f2090d.getVisibility() != 0) {
            return false;
        }
        return this.f2094i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        if (this.f2094i && !this.f2095j) {
            if (this.f2096k <= this.f2090d.getHeight()) {
                z();
            } else {
                y();
            }
        }
        d dVar = this.f2107y;
        if (dVar != null) {
            dVar.f();
        }
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i2) {
        super.onWindowSystemUiVisibilityChanged(i2);
        A();
        int i3 = this.f2097l ^ i2;
        this.f2097l = i2;
        boolean z2 = (i2 & 4) == 0;
        boolean z3 = (i2 & 256) != 0;
        d dVar = this.f2107y;
        if (dVar != null) {
            dVar.a(!z3);
            if (z2 || !z3) {
                this.f2107y.b();
            } else {
                this.f2107y.e();
            }
        }
        if ((i3 & 256) == 0 || this.f2107y == null) {
            return;
        }
        androidx.core.view.M.c0(this);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        this.f2088b = i2;
        d dVar = this.f2107y;
        if (dVar != null) {
            dVar.d(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    public void setActionBarHideOffset(int i2) {
        v();
        this.f2090d.setTranslationY(-Math.max(0, Math.min(i2, this.f2090d.getHeight())));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.f2107y = dVar;
        if (getWindowToken() != null) {
            this.f2107y.d(this.f2088b);
            int i2 = this.f2097l;
            if (i2 != 0) {
                onWindowSystemUiVisibilityChanged(i2);
                androidx.core.view.M.c0(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z2) {
        this.f2093h = z2;
    }

    public void setHideOnContentScrollEnabled(boolean z2) {
        if (z2 != this.f2094i) {
            this.f2094i = z2;
            if (z2) {
                return;
            }
            v();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i2) {
        A();
        this.e.setIcon(i2);
    }

    public void setLogo(int i2) {
        A();
        this.e.k(i2);
    }

    public void setOverlayMode(boolean z2) {
        this.f2092g = z2;
    }

    public void setShowingForActionMode(boolean z2) {
    }

    public void setUiOptions(int i2) {
    }

    @Override // androidx.appcompat.widget.K
    public void setWindowCallback(Window.Callback callback) {
        A();
        this.e.setWindowCallback(callback);
    }

    @Override // androidx.appcompat.widget.K
    public void setWindowTitle(CharSequence charSequence) {
        A();
        this.e.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    void v() {
        removeCallbacks(this.f2083C);
        removeCallbacks(this.f2084D);
        ViewPropertyAnimator viewPropertyAnimator = this.f2081A;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public boolean x() {
        return this.f2092g;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        A();
        this.e.setIcon(drawable);
    }
}
