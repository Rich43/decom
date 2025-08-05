package androidx.swiperefreshlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.ListView;
import androidx.core.view.B;
import androidx.core.view.E;
import androidx.core.view.M;

/* loaded from: classes.dex */
public class SwipeRefreshLayout extends ViewGroup {

    /* renamed from: N, reason: collision with root package name */
    private static final String f4307N = "SwipeRefreshLayout";

    /* renamed from: O, reason: collision with root package name */
    private static final int[] f4308O = {R.attr.enabled};

    /* renamed from: A, reason: collision with root package name */
    int f4309A;

    /* renamed from: B, reason: collision with root package name */
    androidx.swiperefreshlayout.widget.b f4310B;

    /* renamed from: C, reason: collision with root package name */
    private Animation f4311C;

    /* renamed from: D, reason: collision with root package name */
    private Animation f4312D;

    /* renamed from: E, reason: collision with root package name */
    private Animation f4313E;

    /* renamed from: F, reason: collision with root package name */
    private Animation f4314F;

    /* renamed from: G, reason: collision with root package name */
    private Animation f4315G;

    /* renamed from: H, reason: collision with root package name */
    boolean f4316H;

    /* renamed from: I, reason: collision with root package name */
    private int f4317I;

    /* renamed from: J, reason: collision with root package name */
    boolean f4318J;

    /* renamed from: K, reason: collision with root package name */
    private Animation.AnimationListener f4319K;

    /* renamed from: L, reason: collision with root package name */
    private final Animation f4320L;

    /* renamed from: M, reason: collision with root package name */
    private final Animation f4321M;

    /* renamed from: a, reason: collision with root package name */
    private View f4322a;

    /* renamed from: b, reason: collision with root package name */
    j f4323b;

    /* renamed from: c, reason: collision with root package name */
    boolean f4324c;

    /* renamed from: d, reason: collision with root package name */
    private int f4325d;
    private float e;

    /* renamed from: f, reason: collision with root package name */
    private float f4326f;

    /* renamed from: g, reason: collision with root package name */
    private final E f4327g;

    /* renamed from: h, reason: collision with root package name */
    private final B f4328h;

    /* renamed from: i, reason: collision with root package name */
    private final int[] f4329i;

    /* renamed from: j, reason: collision with root package name */
    private final int[] f4330j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f4331k;

    /* renamed from: l, reason: collision with root package name */
    private int f4332l;

    /* renamed from: m, reason: collision with root package name */
    int f4333m;

    /* renamed from: n, reason: collision with root package name */
    private float f4334n;
    private float o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f4335p;

    /* renamed from: q, reason: collision with root package name */
    private int f4336q;
    boolean r;
    private boolean s;

    /* renamed from: t, reason: collision with root package name */
    private final DecelerateInterpolator f4337t;

    /* renamed from: u, reason: collision with root package name */
    androidx.swiperefreshlayout.widget.a f4338u;

    /* renamed from: v, reason: collision with root package name */
    private int f4339v;

    /* renamed from: w, reason: collision with root package name */
    protected int f4340w;

    /* renamed from: x, reason: collision with root package name */
    float f4341x;

    /* renamed from: y, reason: collision with root package name */
    protected int f4342y;

    /* renamed from: z, reason: collision with root package name */
    int f4343z;

    class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            j jVar;
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (!swipeRefreshLayout.f4324c) {
                swipeRefreshLayout.k();
                return;
            }
            swipeRefreshLayout.f4310B.setAlpha(255);
            SwipeRefreshLayout.this.f4310B.start();
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            if (swipeRefreshLayout2.f4316H && (jVar = swipeRefreshLayout2.f4323b) != null) {
                jVar.a();
            }
            SwipeRefreshLayout swipeRefreshLayout3 = SwipeRefreshLayout.this;
            swipeRefreshLayout3.f4333m = swipeRefreshLayout3.f4338u.getTop();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    class b extends Animation {
        b() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(f2);
        }
    }

    class c extends Animation {
        c() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(1.0f - f2);
        }
    }

    class d extends Animation {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f4347a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f4348b;

        d(int i2, int i3) {
            this.f4347a = i2;
            this.f4348b = i3;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            SwipeRefreshLayout.this.f4310B.setAlpha((int) (this.f4347a + ((this.f4348b - r0) * f2)));
        }
    }

    class e implements Animation.AnimationListener {
        e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (swipeRefreshLayout.r) {
                return;
            }
            swipeRefreshLayout.q(null);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    class f extends Animation {
        f() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            int iAbs = !swipeRefreshLayout.f4318J ? swipeRefreshLayout.f4343z - Math.abs(swipeRefreshLayout.f4342y) : swipeRefreshLayout.f4343z;
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((swipeRefreshLayout2.f4340w + ((int) ((iAbs - r1) * f2))) - swipeRefreshLayout2.f4338u.getTop());
            SwipeRefreshLayout.this.f4310B.e(1.0f - f2);
        }
    }

    class g extends Animation {
        g() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            SwipeRefreshLayout.this.i(f2);
        }
    }

    class h extends Animation {
        h() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            float f3 = swipeRefreshLayout.f4341x;
            swipeRefreshLayout.setAnimationProgress(f3 + ((-f3) * f2));
            SwipeRefreshLayout.this.i(f2);
        }
    }

    public interface i {
    }

    public interface j {
        void a();
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4324c = false;
        this.e = -1.0f;
        this.f4329i = new int[2];
        this.f4330j = new int[2];
        this.f4336q = -1;
        this.f4339v = -1;
        this.f4319K = new a();
        this.f4320L = new f();
        this.f4321M = new g();
        this.f4325d = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f4332l = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.f4337t = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f4317I = (int) (displayMetrics.density * 40.0f);
        d();
        setChildrenDrawingOrderEnabled(true);
        int i2 = (int) (displayMetrics.density * 64.0f);
        this.f4343z = i2;
        this.e = i2;
        this.f4327g = new E(this);
        this.f4328h = new B(this);
        setNestedScrollingEnabled(true);
        int i3 = -this.f4317I;
        this.f4333m = i3;
        this.f4342y = i3;
        i(1.0f);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f4308O);
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(0, true));
        typedArrayObtainStyledAttributes.recycle();
    }

    private void a(int i2, Animation.AnimationListener animationListener) {
        this.f4340w = i2;
        this.f4320L.reset();
        this.f4320L.setDuration(200L);
        this.f4320L.setInterpolator(this.f4337t);
        if (animationListener != null) {
            this.f4338u.b(animationListener);
        }
        this.f4338u.clearAnimation();
        this.f4338u.startAnimation(this.f4320L);
    }

    private void b(int i2, Animation.AnimationListener animationListener) {
        if (this.r) {
            r(i2, animationListener);
            return;
        }
        this.f4340w = i2;
        this.f4321M.reset();
        this.f4321M.setDuration(200L);
        this.f4321M.setInterpolator(this.f4337t);
        if (animationListener != null) {
            this.f4338u.b(animationListener);
        }
        this.f4338u.clearAnimation();
        this.f4338u.startAnimation(this.f4321M);
    }

    private void d() {
        this.f4338u = new androidx.swiperefreshlayout.widget.a(getContext(), -328966);
        androidx.swiperefreshlayout.widget.b bVar = new androidx.swiperefreshlayout.widget.b(getContext());
        this.f4310B = bVar;
        bVar.l(1);
        this.f4338u.setImageDrawable(this.f4310B);
        this.f4338u.setVisibility(8);
        addView(this.f4338u);
    }

    private void e() {
        if (this.f4322a == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (!childAt.equals(this.f4338u)) {
                    this.f4322a = childAt;
                    return;
                }
            }
        }
    }

    private void f(float f2) {
        if (f2 > this.e) {
            l(true, true);
            return;
        }
        this.f4324c = false;
        this.f4310B.j(0.0f, 0.0f);
        b(this.f4333m, !this.r ? new e() : null);
        this.f4310B.d(false);
    }

    private boolean g(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void h(float f2) {
        this.f4310B.d(true);
        float fMin = Math.min(1.0f, Math.abs(f2 / this.e));
        float fMax = (((float) Math.max(fMin - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float fAbs = Math.abs(f2) - this.e;
        int i2 = this.f4309A;
        if (i2 <= 0) {
            i2 = this.f4318J ? this.f4343z - this.f4342y : this.f4343z;
        }
        float f3 = i2;
        double dMax = Math.max(0.0f, Math.min(fAbs, f3 * 2.0f) / f3) / 4.0f;
        float fPow = ((float) (dMax - Math.pow(dMax, 2.0d))) * 2.0f;
        int i3 = this.f4342y + ((int) ((f3 * fMin) + (f3 * fPow * 2.0f)));
        if (this.f4338u.getVisibility() != 0) {
            this.f4338u.setVisibility(0);
        }
        if (!this.r) {
            this.f4338u.setScaleX(1.0f);
            this.f4338u.setScaleY(1.0f);
        }
        if (this.r) {
            setAnimationProgress(Math.min(1.0f, f2 / this.e));
        }
        if (f2 < this.e) {
            if (this.f4310B.getAlpha() > 76 && !g(this.f4313E)) {
                p();
            }
        } else if (this.f4310B.getAlpha() < 255 && !g(this.f4314F)) {
            o();
        }
        this.f4310B.j(0.0f, Math.min(0.8f, fMax * 0.8f));
        this.f4310B.e(Math.min(1.0f, fMax));
        this.f4310B.g((((fMax * 0.4f) - 0.25f) + (fPow * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i3 - this.f4333m);
    }

    private void j(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f4336q) {
            this.f4336q = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    private void l(boolean z2, boolean z3) {
        if (this.f4324c != z2) {
            this.f4316H = z3;
            e();
            this.f4324c = z2;
            if (z2) {
                a(this.f4333m, this.f4319K);
            } else {
                q(this.f4319K);
            }
        }
    }

    private Animation m(int i2, int i3) {
        d dVar = new d(i2, i3);
        dVar.setDuration(300L);
        this.f4338u.b(null);
        this.f4338u.clearAnimation();
        this.f4338u.startAnimation(dVar);
        return dVar;
    }

    private void n(float f2) {
        float f3 = this.o;
        float f4 = f2 - f3;
        int i2 = this.f4325d;
        if (f4 <= i2 || this.f4335p) {
            return;
        }
        this.f4334n = f3 + i2;
        this.f4335p = true;
        this.f4310B.setAlpha(76);
    }

    private void o() {
        this.f4314F = m(this.f4310B.getAlpha(), 255);
    }

    private void p() {
        this.f4313E = m(this.f4310B.getAlpha(), 76);
    }

    private void r(int i2, Animation.AnimationListener animationListener) {
        this.f4340w = i2;
        this.f4341x = this.f4338u.getScaleX();
        h hVar = new h();
        this.f4315G = hVar;
        hVar.setDuration(150L);
        if (animationListener != null) {
            this.f4338u.b(animationListener);
        }
        this.f4338u.clearAnimation();
        this.f4338u.startAnimation(this.f4315G);
    }

    private void s(Animation.AnimationListener animationListener) {
        this.f4338u.setVisibility(0);
        this.f4310B.setAlpha(255);
        b bVar = new b();
        this.f4311C = bVar;
        bVar.setDuration(this.f4332l);
        if (animationListener != null) {
            this.f4338u.b(animationListener);
        }
        this.f4338u.clearAnimation();
        this.f4338u.startAnimation(this.f4311C);
    }

    private void setColorViewAlpha(int i2) {
        this.f4338u.getBackground().setAlpha(i2);
        this.f4310B.setAlpha(i2);
    }

    public boolean c() {
        View view = this.f4322a;
        return view instanceof ListView ? androidx.core.widget.g.a((ListView) view, -1) : view.canScrollVertically(-1);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return this.f4328h.a(f2, f3, z2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.f4328h.b(f2, f3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return this.f4328h.c(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.f4328h.f(i2, i3, i4, i5, iArr);
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        int i4 = this.f4339v;
        return i4 < 0 ? i3 : i3 == i2 + (-1) ? i4 : i3 >= i4 ? i3 + 1 : i3;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f4327g.a();
    }

    public int getProgressCircleDiameter() {
        return this.f4317I;
    }

    public int getProgressViewEndOffset() {
        return this.f4343z;
    }

    public int getProgressViewStartOffset() {
        return this.f4342y;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.f4328h.k();
    }

    void i(float f2) {
        setTargetOffsetTopAndBottom((this.f4340w + ((int) ((this.f4342y - r0) * f2))) - this.f4338u.getTop());
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.f4328h.m();
    }

    void k() {
        this.f4338u.clearAnimation();
        this.f4310B.stop();
        this.f4338u.setVisibility(8);
        setColorViewAlpha(255);
        if (this.r) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.f4342y - this.f4333m);
        }
        this.f4333m = this.f4338u.getTop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        k();
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0058  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            r4.e()
            int r0 = r5.getActionMasked()
            boolean r1 = r4.s
            r2 = 0
            if (r1 == 0) goto L10
            if (r0 != 0) goto L10
            r4.s = r2
        L10:
            boolean r1 = r4.isEnabled()
            if (r1 == 0) goto L81
            boolean r1 = r4.s
            if (r1 != 0) goto L81
            boolean r1 = r4.c()
            if (r1 != 0) goto L81
            boolean r1 = r4.f4324c
            if (r1 != 0) goto L81
            boolean r1 = r4.f4331k
            if (r1 == 0) goto L29
            goto L81
        L29:
            if (r0 == 0) goto L5d
            r1 = 1
            r3 = -1
            if (r0 == r1) goto L58
            r1 = 2
            if (r0 == r1) goto L3d
            r1 = 3
            if (r0 == r1) goto L58
            r1 = 6
            if (r0 == r1) goto L39
            goto L7e
        L39:
            r4.j(r5)
            goto L7e
        L3d:
            int r0 = r4.f4336q
            if (r0 != r3) goto L49
            java.lang.String r5 = androidx.swiperefreshlayout.widget.SwipeRefreshLayout.f4307N
            java.lang.String r0 = "Got ACTION_MOVE event but don't have an active pointer id."
            android.util.Log.e(r5, r0)
            return r2
        L49:
            int r0 = r5.findPointerIndex(r0)
            if (r0 >= 0) goto L50
            return r2
        L50:
            float r5 = r5.getY(r0)
            r4.n(r5)
            goto L7e
        L58:
            r4.f4335p = r2
            r4.f4336q = r3
            goto L7e
        L5d:
            int r0 = r4.f4342y
            androidx.swiperefreshlayout.widget.a r1 = r4.f4338u
            int r1 = r1.getTop()
            int r0 = r0 - r1
            r4.setTargetOffsetTopAndBottom(r0)
            int r0 = r5.getPointerId(r2)
            r4.f4336q = r0
            r4.f4335p = r2
            int r0 = r5.findPointerIndex(r0)
            if (r0 >= 0) goto L78
            return r2
        L78:
            float r5 = r5.getY(r0)
            r4.o = r5
        L7e:
            boolean r5 = r4.f4335p
            return r5
        L81:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.f4322a == null) {
            e();
        }
        View view = this.f4322a;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.f4338u.getMeasuredWidth();
        int measuredHeight2 = this.f4338u.getMeasuredHeight();
        int i6 = measuredWidth / 2;
        int i7 = measuredWidth2 / 2;
        int i8 = this.f4333m;
        this.f4338u.layout(i6 - i7, i8, i6 + i7, measuredHeight2 + i8);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f4322a == null) {
            e();
        }
        View view = this.f4322a;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.f4338u.measure(View.MeasureSpec.makeMeasureSpec(this.f4317I, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f4317I, 1073741824));
        this.f4339v = -1;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            if (getChildAt(i4) == this.f4338u) {
                this.f4339v = i4;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        return dispatchNestedFling(f2, f3, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        if (i3 > 0) {
            float f2 = this.f4326f;
            if (f2 > 0.0f) {
                float f3 = i3;
                if (f3 > f2) {
                    iArr[1] = i3 - ((int) f2);
                    this.f4326f = 0.0f;
                } else {
                    this.f4326f = f2 - f3;
                    iArr[1] = i3;
                }
                h(this.f4326f);
            }
        }
        if (this.f4318J && i3 > 0 && this.f4326f == 0.0f && Math.abs(i3 - iArr[1]) > 0) {
            this.f4338u.setVisibility(8);
        }
        int[] iArr2 = this.f4329i;
        if (dispatchNestedPreScroll(i2 - iArr[0], i3 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        dispatchNestedScroll(i2, i3, i4, i5, this.f4330j);
        if (i5 + this.f4330j[1] >= 0 || c()) {
            return;
        }
        float fAbs = this.f4326f + Math.abs(r11);
        this.f4326f = fAbs;
        h(fAbs);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.f4327g.b(view, view2, i2);
        startNestedScroll(i2 & 2);
        this.f4326f = 0.0f;
        this.f4331k = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return (!isEnabled() || this.s || this.f4324c || (i2 & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        this.f4327g.d(view);
        this.f4331k = false;
        float f2 = this.f4326f;
        if (f2 > 0.0f) {
            f(f2);
            this.f4326f = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.s && actionMasked == 0) {
            this.s = false;
        }
        if (!isEnabled() || this.s || c() || this.f4324c || this.f4331k) {
            return false;
        }
        if (actionMasked == 0) {
            this.f4336q = motionEvent.getPointerId(0);
            this.f4335p = false;
        } else {
            if (actionMasked == 1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f4336q);
                if (iFindPointerIndex < 0) {
                    Log.e(f4307N, "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                if (this.f4335p) {
                    float y2 = (motionEvent.getY(iFindPointerIndex) - this.f4334n) * 0.5f;
                    this.f4335p = false;
                    f(y2);
                }
                this.f4336q = -1;
                return false;
            }
            if (actionMasked == 2) {
                int iFindPointerIndex2 = motionEvent.findPointerIndex(this.f4336q);
                if (iFindPointerIndex2 < 0) {
                    Log.e(f4307N, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                float y3 = motionEvent.getY(iFindPointerIndex2);
                n(y3);
                if (this.f4335p) {
                    float f2 = (y3 - this.f4334n) * 0.5f;
                    if (f2 <= 0.0f) {
                        return false;
                    }
                    h(f2);
                }
            } else {
                if (actionMasked == 3) {
                    return false;
                }
                if (actionMasked == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    if (actionIndex < 0) {
                        Log.e(f4307N, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                        return false;
                    }
                    this.f4336q = motionEvent.getPointerId(actionIndex);
                } else if (actionMasked == 6) {
                    j(motionEvent);
                }
            }
        }
        return true;
    }

    void q(Animation.AnimationListener animationListener) {
        c cVar = new c();
        this.f4312D = cVar;
        cVar.setDuration(150L);
        this.f4338u.b(animationListener);
        this.f4338u.clearAnimation();
        this.f4338u.startAnimation(this.f4312D);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        View view = this.f4322a;
        if (view == null || M.P(view)) {
            super.requestDisallowInterceptTouchEvent(z2);
        }
    }

    void setAnimationProgress(float f2) {
        this.f4338u.setScaleX(f2);
        this.f4338u.setScaleY(f2);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        e();
        this.f4310B.f(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr2[i2] = androidx.core.content.a.b(context, iArr[i2]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i2) {
        this.e = i2;
    }

    @Override // android.view.View
    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        if (z2) {
            return;
        }
        k();
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z2) {
        this.f4328h.n(z2);
    }

    public void setOnChildScrollUpCallback(i iVar) {
    }

    public void setOnRefreshListener(j jVar) {
        this.f4323b = jVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i2) {
        setProgressBackgroundColorSchemeResource(i2);
    }

    public void setProgressBackgroundColorSchemeColor(int i2) {
        this.f4338u.setBackgroundColor(i2);
    }

    public void setProgressBackgroundColorSchemeResource(int i2) {
        setProgressBackgroundColorSchemeColor(androidx.core.content.a.b(getContext(), i2));
    }

    public void setRefreshing(boolean z2) {
        if (!z2 || this.f4324c == z2) {
            l(z2, false);
            return;
        }
        this.f4324c = z2;
        setTargetOffsetTopAndBottom((!this.f4318J ? this.f4343z + this.f4342y : this.f4343z) - this.f4333m);
        this.f4316H = false;
        s(this.f4319K);
    }

    public void setSize(int i2) {
        if (i2 == 0 || i2 == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i2 == 0) {
                this.f4317I = (int) (displayMetrics.density * 56.0f);
            } else {
                this.f4317I = (int) (displayMetrics.density * 40.0f);
            }
            this.f4338u.setImageDrawable(null);
            this.f4310B.l(i2);
            this.f4338u.setImageDrawable(this.f4310B);
        }
    }

    public void setSlingshotDistance(int i2) {
        this.f4309A = i2;
    }

    void setTargetOffsetTopAndBottom(int i2) {
        this.f4338u.bringToFront();
        M.V(this.f4338u, i2);
        this.f4333m = this.f4338u.getTop();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i2) {
        return this.f4328h.p(i2);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        this.f4328h.r();
    }
}
