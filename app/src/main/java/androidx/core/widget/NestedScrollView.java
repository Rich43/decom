package androidx.core.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.view.A;
import androidx.core.view.B;
import androidx.core.view.C0158a;
import androidx.core.view.C0172o;
import androidx.core.view.D;
import androidx.core.view.E;
import androidx.core.view.InterfaceC0173p;
import androidx.core.view.M;
import com.bumptech.glide.request.target.Target;
import defpackage.r;
import w.AbstractC0355G;
import w.C0353E;

/* loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements D {

    /* renamed from: D */
    private static final float f3190D = (float) (Math.log(0.78d) / Math.log(0.9d));

    /* renamed from: E */
    private static final a f3191E = new a();

    /* renamed from: F */
    private static final int[] f3192F = {R.attr.fillViewport};

    /* renamed from: A */
    private d f3193A;

    /* renamed from: B */
    final c f3194B;

    /* renamed from: C */
    C0172o f3195C;

    /* renamed from: a */
    private final float f3196a;

    /* renamed from: b */
    private long f3197b;

    /* renamed from: c */
    private final Rect f3198c;

    /* renamed from: d */
    private OverScroller f3199d;
    public EdgeEffect e;

    /* renamed from: f */
    public EdgeEffect f3200f;

    /* renamed from: g */
    private int f3201g;

    /* renamed from: h */
    private boolean f3202h;

    /* renamed from: i */
    private boolean f3203i;

    /* renamed from: j */
    private View f3204j;

    /* renamed from: k */
    private boolean f3205k;

    /* renamed from: l */
    private VelocityTracker f3206l;

    /* renamed from: m */
    private boolean f3207m;

    /* renamed from: n */
    private boolean f3208n;
    private int o;

    /* renamed from: p */
    private int f3209p;

    /* renamed from: q */
    private int f3210q;
    private int r;
    private final int[] s;

    /* renamed from: t */
    private final int[] f3211t;

    /* renamed from: u */
    private int f3212u;

    /* renamed from: v */
    private int f3213v;

    /* renamed from: w */
    private e f3214w;

    /* renamed from: x */
    private final E f3215x;

    /* renamed from: y */
    private final B f3216y;

    /* renamed from: z */
    private float f3217z;

    static class a extends C0158a {
        a() {
        }

        @Override // androidx.core.view.C0158a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            AbstractC0355G.a(accessibilityEvent, nestedScrollView.getScrollX());
            AbstractC0355G.b(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        @Override // androidx.core.view.C0158a
        public void g(View view, C0353E c0353e) {
            int scrollRange;
            super.g(view, c0353e);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            c0353e.Y(ScrollView.class.getName());
            if (!nestedScrollView.isEnabled() || (scrollRange = nestedScrollView.getScrollRange()) <= 0) {
                return;
            }
            c0353e.e0(true);
            if (nestedScrollView.getScrollY() > 0) {
                c0353e.b(C0353E.a.f7720q);
                c0353e.b(C0353E.a.f7689B);
            }
            if (nestedScrollView.getScrollY() < scrollRange) {
                c0353e.b(C0353E.a.f7719p);
                c0353e.b(C0353E.a.f7691D);
            }
        }

        @Override // androidx.core.view.C0158a
        public boolean j(View view, int i2, Bundle bundle) {
            if (super.j(view, i2, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int height = nestedScrollView.getHeight();
            Rect rect = new Rect();
            if (nestedScrollView.getMatrix().isIdentity() && nestedScrollView.getGlobalVisibleRect(rect)) {
                height = rect.height();
            }
            if (i2 != 4096) {
                if (i2 == 8192 || i2 == 16908344) {
                    int iMax = Math.max(nestedScrollView.getScrollY() - ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (iMax == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.W(0, iMax, true);
                    return true;
                }
                if (i2 != 16908346) {
                    return false;
                }
            }
            int iMin = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (iMin == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.W(0, iMin, true);
            return true;
        }
    }

    static class b {
        static boolean a(ViewGroup viewGroup) {
            return viewGroup.getClipToPadding();
        }
    }

    class c implements InterfaceC0173p {
        c() {
        }

        @Override // androidx.core.view.InterfaceC0173p
        public boolean a(float f2) {
            if (f2 == 0.0f) {
                return false;
            }
            c();
            NestedScrollView.this.v((int) f2);
            return true;
        }

        @Override // androidx.core.view.InterfaceC0173p
        public float b() {
            return -NestedScrollView.this.getVerticalScrollFactorCompat();
        }

        @Override // androidx.core.view.InterfaceC0173p
        public void c() {
            NestedScrollView.this.f3199d.abortAnimation();
        }
    }

    public interface d {
        void a(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5);
    }

    static class e extends View.BaseSavedState {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* renamed from: a */
        public int f3219a;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public e[] newArray(int i2) {
                return new e[i2];
            }
        }

        e(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f3219a + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f3219a);
        }

        e(Parcel parcel) {
            super(parcel);
            this.f3219a = parcel.readInt();
        }
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, r.c.f7251c);
    }

    private void A() {
        VelocityTracker velocityTracker = this.f3206l;
        if (velocityTracker == null) {
            this.f3206l = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void B() {
        this.f3199d = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.o = viewConfiguration.getScaledTouchSlop();
        this.f3209p = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f3210q = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void C() {
        if (this.f3206l == null) {
            this.f3206l = VelocityTracker.obtain();
        }
    }

    private void D(int i2, int i3) {
        this.f3201g = i2;
        this.r = i3;
        X(2, 0);
    }

    private boolean E(View view) {
        return !G(view, 0, getHeight());
    }

    private static boolean F(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && F((View) parent, view2);
    }

    private boolean G(View view, int i2, int i3) {
        view.getDrawingRect(this.f3198c);
        offsetDescendantRectToMyCoords(view, this.f3198c);
        return this.f3198c.bottom + i2 >= getScrollY() && this.f3198c.top - i2 <= getScrollY() + i3;
    }

    private void H(int i2, int i3, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i2);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.f3216y.e(0, scrollY2, 0, i2 - scrollY2, null, i3, iArr);
    }

    private void I(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.r) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.f3201g = (int) motionEvent.getY(i2);
            this.r = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.f3206l;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void L() {
        VelocityTracker velocityTracker = this.f3206l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f3206l = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int M(int r4, float r5) {
        /*
            r3 = this;
            int r0 = r3.getWidth()
            float r0 = (float) r0
            float r5 = r5 / r0
            float r4 = (float) r4
            int r0 = r3.getHeight()
            float r0 = (float) r0
            float r4 = r4 / r0
            android.widget.EdgeEffect r0 = r3.e
            float r0 = androidx.core.widget.d.b(r0)
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L31
            android.widget.EdgeEffect r0 = r3.e
            float r4 = -r4
            float r4 = androidx.core.widget.d.d(r0, r4, r5)
            float r4 = -r4
            android.widget.EdgeEffect r5 = r3.e
            float r5 = androidx.core.widget.d.b(r5)
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 != 0) goto L2f
            android.widget.EdgeEffect r5 = r3.e
            r5.onRelease()
        L2f:
            r1 = r4
            goto L54
        L31:
            android.widget.EdgeEffect r0 = r3.f3200f
            float r0 = androidx.core.widget.d.b(r0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L54
            android.widget.EdgeEffect r0 = r3.f3200f
            r2 = 1065353216(0x3f800000, float:1.0)
            float r2 = r2 - r5
            float r4 = androidx.core.widget.d.d(r0, r4, r2)
            android.widget.EdgeEffect r5 = r3.f3200f
            float r5 = androidx.core.widget.d.b(r5)
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 != 0) goto L2f
            android.widget.EdgeEffect r5 = r3.f3200f
            r5.onRelease()
            goto L2f
        L54:
            int r4 = r3.getHeight()
            float r4 = (float) r4
            float r1 = r1 * r4
            int r4 = java.lang.Math.round(r1)
            if (r4 == 0) goto L64
            r3.invalidate()
        L64:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.M(int, float):int");
    }

    private void N(boolean z2) {
        if (z2) {
            X(2, 1);
        } else {
            Z(1);
        }
        this.f3213v = getScrollY();
        postInvalidateOnAnimation();
    }

    private boolean O(int i2, int i3, int i4) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i5 = height + scrollY;
        boolean z2 = false;
        boolean z3 = i2 == 33;
        View viewU = u(z3, i3, i4);
        if (viewU == null) {
            viewU = this;
        }
        if (i3 < scrollY || i4 > i5) {
            P(z3 ? i3 - scrollY : i4 - i5, 0, 1, true);
            z2 = true;
        }
        if (viewU != findFocus()) {
            viewU.requestFocus(i2);
        }
        return z2;
    }

    private int P(int i2, int i3, int i4, boolean z2) {
        int i5;
        int i6;
        VelocityTracker velocityTracker;
        if (i4 == 1) {
            X(2, i4);
        }
        boolean z3 = false;
        if (l(0, i2, this.f3211t, this.s, i4)) {
            i5 = i2 - this.f3211t[1];
            i6 = this.s[1];
        } else {
            i5 = i2;
            i6 = 0;
        }
        int scrollY = getScrollY();
        int scrollRange = getScrollRange();
        boolean z4 = d() && !z2;
        boolean z5 = J(0, i5, 0, scrollY, 0, scrollRange, 0, 0, true) && !y(i4);
        int scrollY2 = getScrollY() - scrollY;
        int[] iArr = this.f3211t;
        iArr[1] = 0;
        p(0, scrollY2, 0, i5 - scrollY2, this.s, i4, iArr);
        int i7 = i6 + this.s[1];
        int i8 = i5 - this.f3211t[1];
        int i9 = scrollY + i8;
        if (i9 < 0) {
            if (z4) {
                androidx.core.widget.d.d(this.e, (-i8) / getHeight(), i3 / getWidth());
                if (!this.f3200f.isFinished()) {
                    this.f3200f.onRelease();
                }
            }
        } else if (i9 > scrollRange && z4) {
            androidx.core.widget.d.d(this.f3200f, i8 / getHeight(), 1.0f - (i3 / getWidth()));
            if (!this.e.isFinished()) {
                this.e.onRelease();
            }
        }
        if (this.e.isFinished() && this.f3200f.isFinished()) {
            z3 = z5;
        } else {
            postInvalidateOnAnimation();
        }
        if (z3 && i4 == 0 && (velocityTracker = this.f3206l) != null) {
            velocityTracker.clear();
        }
        if (i4 == 1) {
            Z(i4);
            this.e.onRelease();
            this.f3200f.onRelease();
        }
        return i7;
    }

    private void Q(View view) {
        view.getDrawingRect(this.f3198c);
        offsetDescendantRectToMyCoords(view, this.f3198c);
        int iG = g(this.f3198c);
        if (iG != 0) {
            scrollBy(0, iG);
        }
    }

    private boolean R(Rect rect, boolean z2) {
        int iG = g(rect);
        boolean z3 = iG != 0;
        if (z3) {
            if (z2) {
                scrollBy(0, iG);
            } else {
                T(0, iG);
            }
        }
        return z3;
    }

    private boolean S(EdgeEffect edgeEffect, int i2) {
        if (i2 > 0) {
            return true;
        }
        return x(-i2) < androidx.core.widget.d.b(edgeEffect) * ((float) getHeight());
    }

    private void U(int i2, int i3, int i4, boolean z2) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f3197b > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            this.f3199d.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i3 + scrollY, Math.max(0, height - height2))) - scrollY, i4);
            N(z2);
        } else {
            if (!this.f3199d.isFinished()) {
                a();
            }
            scrollBy(i2, i3);
        }
        this.f3197b = AnimationUtils.currentAnimationTimeMillis();
    }

    private boolean Y(MotionEvent motionEvent) {
        boolean z2;
        if (androidx.core.widget.d.b(this.e) != 0.0f) {
            androidx.core.widget.d.d(this.e, 0.0f, motionEvent.getX() / getWidth());
            z2 = true;
        } else {
            z2 = false;
        }
        if (androidx.core.widget.d.b(this.f3200f) == 0.0f) {
            return z2;
        }
        androidx.core.widget.d.d(this.f3200f, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
        return true;
    }

    private void a() {
        this.f3199d.abortAnimation();
        Z(1);
    }

    private boolean d() {
        int overScrollMode = getOverScrollMode();
        if (overScrollMode != 0) {
            return overScrollMode == 1 && getScrollRange() > 0;
        }
        return true;
    }

    private boolean e() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private static int f(int i2, int i3, int i4) {
        if (i3 >= i4 || i2 < 0) {
            return 0;
        }
        return i3 + i2 > i4 ? i4 - i3 : i2;
    }

    private void q(int i2) {
        if (i2 != 0) {
            if (this.f3208n) {
                T(0, i2);
            } else {
                scrollBy(0, i2);
            }
        }
    }

    private boolean r(int i2) {
        if (androidx.core.widget.d.b(this.e) != 0.0f) {
            if (S(this.e, i2)) {
                this.e.onAbsorb(i2);
            } else {
                v(-i2);
            }
        } else {
            if (androidx.core.widget.d.b(this.f3200f) == 0.0f) {
                return false;
            }
            int i3 = -i2;
            if (S(this.f3200f, i3)) {
                this.f3200f.onAbsorb(i3);
            } else {
                v(i3);
            }
        }
        return true;
    }

    private void s() {
        this.r = -1;
        this.f3205k = false;
        L();
        Z(0);
        this.e.onRelease();
        this.f3200f.onRelease();
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.view.View u(boolean r13, int r14, int r15) {
        /*
            r12 = this;
            r0 = 2
            java.util.ArrayList r0 = r12.getFocusables(r0)
            int r1 = r0.size()
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
        Ld:
            if (r4 >= r1) goto L53
            java.lang.Object r6 = r0.get(r4)
            android.view.View r6 = (android.view.View) r6
            int r7 = r6.getTop()
            int r8 = r6.getBottom()
            if (r14 >= r8) goto L50
            if (r7 >= r15) goto L50
            r9 = 1
            if (r14 >= r7) goto L28
            if (r8 >= r15) goto L28
            r10 = 1
            goto L29
        L28:
            r10 = 0
        L29:
            if (r2 != 0) goto L2e
            r2 = r6
            r5 = r10
            goto L50
        L2e:
            if (r13 == 0) goto L36
            int r11 = r2.getTop()
            if (r7 < r11) goto L3e
        L36:
            if (r13 != 0) goto L40
            int r7 = r2.getBottom()
            if (r8 <= r7) goto L40
        L3e:
            r7 = 1
            goto L41
        L40:
            r7 = 0
        L41:
            if (r5 == 0) goto L48
            if (r10 == 0) goto L50
            if (r7 == 0) goto L50
            goto L4f
        L48:
            if (r10 == 0) goto L4d
            r2 = r6
            r5 = 1
            goto L50
        L4d:
            if (r7 == 0) goto L50
        L4f:
            r2 = r6
        L50:
            int r4 = r4 + 1
            goto Ld
        L53:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.u(boolean, int, int):android.view.View");
    }

    private float x(int i2) {
        double dLog = Math.log((Math.abs(i2) * 0.35f) / (this.f3196a * 0.015f));
        float f2 = f3190D;
        return (float) (this.f3196a * 0.015f * Math.exp((f2 / (f2 - 1.0d)) * dLog));
    }

    private boolean z(int i2, int i3) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i3 >= childAt.getTop() - scrollY && i3 < childAt.getBottom() - scrollY && i2 >= childAt.getLeft() && i2 < childAt.getRight();
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0083 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean J(int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, boolean r21) {
        /*
            r12 = this;
            r0 = r12
            int r1 = r12.getOverScrollMode()
            int r2 = r12.computeHorizontalScrollRange()
            int r3 = r12.computeHorizontalScrollExtent()
            r4 = 0
            r5 = 1
            if (r2 <= r3) goto L13
            r2 = 1
            goto L14
        L13:
            r2 = 0
        L14:
            int r3 = r12.computeVerticalScrollRange()
            int r6 = r12.computeVerticalScrollExtent()
            if (r3 <= r6) goto L20
            r3 = 1
            goto L21
        L20:
            r3 = 0
        L21:
            if (r1 == 0) goto L2a
            if (r1 != r5) goto L28
            if (r2 == 0) goto L28
            goto L2a
        L28:
            r2 = 0
            goto L2b
        L2a:
            r2 = 1
        L2b:
            if (r1 == 0) goto L34
            if (r1 != r5) goto L32
            if (r3 == 0) goto L32
            goto L34
        L32:
            r1 = 0
            goto L35
        L34:
            r1 = 1
        L35:
            int r3 = r15 + r13
            if (r2 != 0) goto L3b
            r2 = 0
            goto L3d
        L3b:
            r2 = r19
        L3d:
            int r6 = r16 + r14
            if (r1 != 0) goto L43
            r1 = 0
            goto L45
        L43:
            r1 = r20
        L45:
            int r7 = -r2
            int r2 = r2 + r17
            int r8 = -r1
            int r1 = r1 + r18
            if (r3 <= r2) goto L50
            r3 = r2
        L4e:
            r2 = 1
            goto L55
        L50:
            if (r3 >= r7) goto L54
            r3 = r7
            goto L4e
        L54:
            r2 = 0
        L55:
            if (r6 <= r1) goto L5a
            r6 = r1
        L58:
            r1 = 1
            goto L5f
        L5a:
            if (r6 >= r8) goto L5e
            r6 = r8
            goto L58
        L5e:
            r1 = 0
        L5f:
            if (r1 == 0) goto L7e
            boolean r7 = r12.y(r5)
            if (r7 != 0) goto L7e
            android.widget.OverScroller r7 = r0.f3199d
            r8 = 0
            int r9 = r12.getScrollRange()
            r10 = 0
            r11 = 0
            r13 = r7
            r14 = r3
            r15 = r6
            r16 = r10
            r17 = r11
            r18 = r8
            r19 = r9
            r13.springBack(r14, r15, r16, r17, r18, r19)
        L7e:
            r12.onOverScrolled(r3, r6, r2, r1)
            if (r2 != 0) goto L85
            if (r1 == 0) goto L86
        L85:
            r4 = 1
        L86:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.J(int, int, int, int, int, int, int, int, boolean):boolean");
    }

    public boolean K(int i2) {
        boolean z2 = i2 == 130;
        int height = getHeight();
        if (z2) {
            this.f3198c.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect = this.f3198c;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.f3198c.top = getScrollY() - height;
            Rect rect2 = this.f3198c;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.f3198c;
        int i3 = rect3.top;
        int i4 = height + i3;
        rect3.bottom = i4;
        return O(i2, i3, i4);
    }

    public final void T(int i2, int i3) {
        U(i2, i3, 250, false);
    }

    void V(int i2, int i3, int i4, boolean z2) {
        U(i2 - getScrollX(), i3 - getScrollY(), i4, z2);
    }

    void W(int i2, int i3, boolean z2) {
        V(i2, i3, 250, z2);
    }

    public boolean X(int i2, int i3) {
        return this.f3216y.q(i2, i3);
    }

    public void Z(int i2) {
        this.f3216y.s(i2);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public boolean c(int i2) {
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i2);
        int maxScrollAmount = getMaxScrollAmount();
        if (viewFindNextFocus == null || !G(viewFindNextFocus, maxScrollAmount, getHeight())) {
            if (i2 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i2 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i2 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            P(maxScrollAmount, 0, 1, true);
        } else {
            viewFindNextFocus.getDrawingRect(this.f3198c);
            offsetDescendantRectToMyCoords(viewFindNextFocus, this.f3198c);
            P(g(this.f3198c), 0, 1, true);
            viewFindNextFocus.requestFocus(i2);
        }
        if (viewFindFocus != null && viewFindFocus.isFocused() && E(viewFindFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f3199d.isFinished()) {
            return;
        }
        this.f3199d.computeScrollOffset();
        int currY = this.f3199d.getCurrY();
        int iK = k(currY - this.f3213v);
        this.f3213v = currY;
        int[] iArr = this.f3211t;
        iArr[1] = 0;
        l(0, iK, iArr, null, 1);
        int i2 = iK - this.f3211t[1];
        int scrollRange = getScrollRange();
        if (i2 != 0) {
            int scrollY = getScrollY();
            J(0, i2, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
            int scrollY2 = getScrollY() - scrollY;
            int i3 = i2 - scrollY2;
            int[] iArr2 = this.f3211t;
            iArr2[1] = 0;
            p(0, scrollY2, 0, i3, this.s, 1, iArr2);
            i2 = i3 - this.f3211t[1];
        }
        if (i2 != 0) {
            int overScrollMode = getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                if (i2 < 0) {
                    if (this.e.isFinished()) {
                        this.e.onAbsorb((int) this.f3199d.getCurrVelocity());
                    }
                } else if (this.f3200f.isFinished()) {
                    this.f3200f.onAbsorb((int) this.f3199d.getCurrVelocity());
                }
            }
            a();
        }
        if (this.f3199d.isFinished()) {
            Z(1);
        } else {
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int iMax = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > iMax ? bottom + (scrollY - iMax) : bottom;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || t(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return this.f3216y.a(f2, f3, z2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.f3216y.b(f2, f3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return l(i2, i3, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.f3216y.f(i2, i3, i4, i5, iArr);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int paddingLeft;
        super.draw(canvas);
        int scrollY = getScrollY();
        int paddingLeft2 = 0;
        if (!this.e.isFinished()) {
            int iSave = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int iMin = Math.min(0, scrollY);
            if (b.a(this)) {
                width -= getPaddingLeft() + getPaddingRight();
                paddingLeft = getPaddingLeft();
            } else {
                paddingLeft = 0;
            }
            if (b.a(this)) {
                height -= getPaddingTop() + getPaddingBottom();
                iMin += getPaddingTop();
            }
            canvas.translate(paddingLeft, iMin);
            this.e.setSize(width, height);
            if (this.e.draw(canvas)) {
                postInvalidateOnAnimation();
            }
            canvas.restoreToCount(iSave);
        }
        if (this.f3200f.isFinished()) {
            return;
        }
        int iSave2 = canvas.save();
        int width2 = getWidth();
        int height2 = getHeight();
        int iMax = Math.max(getScrollRange(), scrollY) + height2;
        if (b.a(this)) {
            width2 -= getPaddingLeft() + getPaddingRight();
            paddingLeft2 = getPaddingLeft();
        }
        if (b.a(this)) {
            height2 -= getPaddingTop() + getPaddingBottom();
            iMax -= getPaddingBottom();
        }
        canvas.translate(paddingLeft2 - width2, iMax);
        canvas.rotate(180.0f, width2, 0.0f);
        this.f3200f.setSize(width2, height2);
        if (this.f3200f.draw(canvas)) {
            postInvalidateOnAnimation();
        }
        canvas.restoreToCount(iSave2);
    }

    protected int g(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i2 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i3 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i2 - verticalFadingEdgeLength : i2;
        int i4 = rect.bottom;
        if (i4 > i3 && rect.top > scrollY) {
            return Math.min(rect.height() > height ? rect.top - scrollY : rect.bottom - i3, (childAt.getBottom() + layoutParams.bottomMargin) - i2);
        }
        if (rect.top >= scrollY || i4 >= i3) {
            return 0;
        }
        return Math.max(rect.height() > height ? 0 - (i3 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f3215x.a();
    }

    int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    float getVerticalScrollFactorCompat() {
        if (this.f3217z == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.f3217z = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.f3217z;
    }

    @Override // androidx.core.view.C
    public void h(View view, View view2, int i2, int i3) {
        this.f3215x.c(view, view2, i2, i3);
        X(2, i3);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return y(0);
    }

    @Override // androidx.core.view.C
    public void i(View view, int i2) {
        this.f3215x.e(view, i2);
        Z(i2);
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.f3216y.m();
    }

    @Override // androidx.core.view.C
    public void j(View view, int i2, int i3, int[] iArr, int i4) {
        l(i2, i3, iArr, null, i4);
    }

    int k(int i2) {
        int height = getHeight();
        if (i2 > 0 && androidx.core.widget.d.b(this.e) != 0.0f) {
            int iRound = Math.round(((-height) / 4.0f) * androidx.core.widget.d.d(this.e, ((-i2) * 4.0f) / height, 0.5f));
            if (iRound != i2) {
                this.e.finish();
            }
            return i2 - iRound;
        }
        if (i2 >= 0 || androidx.core.widget.d.b(this.f3200f) == 0.0f) {
            return i2;
        }
        float f2 = height;
        int iRound2 = Math.round((f2 / 4.0f) * androidx.core.widget.d.d(this.f3200f, (i2 * 4.0f) / f2, 0.5f));
        if (iRound2 != i2) {
            this.f3200f.finish();
        }
        return i2 - iRound2;
    }

    public boolean l(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return this.f3216y.d(i2, i3, iArr, iArr2, i4);
    }

    @Override // androidx.core.view.D
    public void m(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        H(i5, i6, iArr);
    }

    @Override // android.view.ViewGroup
    protected void measureChild(View view, int i2, int i3) {
        view.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View view, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    @Override // androidx.core.view.C
    public void n(View view, int i2, int i3, int i4, int i5, int i6) {
        H(i5, i6, null);
    }

    @Override // androidx.core.view.C
    public boolean o(View view, View view2, int i2, int i3) {
        return (i2 & 2) != 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3203i = false;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        int i2;
        float axisValue;
        int width;
        if (motionEvent.getAction() == 8 && !this.f3205k) {
            if (A.a(motionEvent, 2)) {
                i2 = 9;
                axisValue = motionEvent.getAxisValue(9);
                width = (int) motionEvent.getX();
            } else if (A.a(motionEvent, 4194304)) {
                axisValue = motionEvent.getAxisValue(26);
                width = getWidth() / 2;
                i2 = 26;
            } else {
                i2 = 0;
                axisValue = 0.0f;
                width = 0;
            }
            if (axisValue != 0.0f) {
                P(-((int) (axisValue * getVerticalScrollFactorCompat())), width, 1, A.a(motionEvent, 8194));
                if (i2 != 0) {
                    this.f3195C.g(motionEvent, i2);
                }
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:84:0x007e  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r12) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        int measuredHeight = 0;
        this.f3202h = false;
        View view = this.f3204j;
        if (view != null && F(view, this)) {
            Q(this.f3204j);
        }
        this.f3204j = null;
        if (!this.f3203i) {
            if (this.f3214w != null) {
                scrollTo(getScrollX(), this.f3214w.f3219a);
                this.f3214w = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i5 - i3) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int iF = f(scrollY, paddingTop, measuredHeight);
            if (iF != scrollY) {
                scrollTo(getScrollX(), iF);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f3203i = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f3207m && View.MeasureSpec.getMode(i3) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        if (z2) {
            return false;
        }
        dispatchNestedFling(0.0f, f3, true);
        v((int) f3);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        j(view, i2, i3, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        H(i5, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        h(view, view2, i2, 0);
    }

    @Override // android.view.View
    protected void onOverScrolled(int i2, int i3, boolean z2, boolean z3) {
        super.scrollTo(i2, i3);
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (i2 == 2) {
            i2 = 130;
        } else if (i2 == 1) {
            i2 = 33;
        }
        View viewFindNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i2) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i2);
        if (viewFindNextFocus == null || E(viewFindNextFocus)) {
            return false;
        }
        return viewFindNextFocus.requestFocus(i2, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof e)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        e eVar = (e) parcelable;
        super.onRestoreInstanceState(eVar.getSuperState());
        this.f3214w = eVar;
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        e eVar = new e(super.onSaveInstanceState());
        eVar.f3219a = getScrollY();
        return eVar;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        d dVar = this.f3193A;
        if (dVar != null) {
            dVar.a(this, i2, i3, i4, i5);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        View viewFindFocus = findFocus();
        if (viewFindFocus == null || this == viewFindFocus || !G(viewFindFocus, 0, i5)) {
            return;
        }
        viewFindFocus.getDrawingRect(this.f3198c);
        offsetDescendantRectToMyCoords(viewFindFocus, this.f3198c);
        q(g(this.f3198c));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return o(view, view2, i2, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        i(view, 0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        C();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f3212u = 0;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(0.0f, this.f3212u);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.f3206l;
                velocityTracker.computeCurrentVelocity(1000, this.f3210q);
                int yVelocity = (int) velocityTracker.getYVelocity(this.r);
                if (Math.abs(yVelocity) >= this.f3209p) {
                    if (!r(yVelocity)) {
                        int i2 = -yVelocity;
                        float f2 = i2;
                        if (!dispatchNestedPreFling(0.0f, f2)) {
                            dispatchNestedFling(0.0f, f2, true);
                            v(i2);
                        }
                    }
                } else if (this.f3199d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    postInvalidateOnAnimation();
                }
                s();
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.r);
                if (iFindPointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + this.r + " in onTouchEvent");
                } else {
                    int y2 = (int) motionEvent.getY(iFindPointerIndex);
                    int i3 = this.f3201g - y2;
                    int iM = i3 - M(i3, motionEvent.getX(iFindPointerIndex));
                    if (!this.f3205k && Math.abs(iM) > this.o) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f3205k = true;
                        iM = iM > 0 ? iM - this.o : iM + this.o;
                    }
                    if (this.f3205k) {
                        int iP = P(iM, (int) motionEvent.getX(iFindPointerIndex), 0, false);
                        this.f3201g = y2 - iP;
                        this.f3212u += iP;
                    }
                }
            } else if (actionMasked == 3) {
                if (this.f3205k && getChildCount() > 0 && this.f3199d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    postInvalidateOnAnimation();
                }
                s();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.f3201g = (int) motionEvent.getY(actionIndex);
                this.r = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                I(motionEvent);
                this.f3201g = (int) motionEvent.getY(motionEvent.findPointerIndex(this.r));
            }
        } else {
            if (getChildCount() == 0) {
                return false;
            }
            if (this.f3205k && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.f3199d.isFinished()) {
                a();
            }
            D((int) motionEvent.getY(), motionEvent.getPointerId(0));
        }
        VelocityTracker velocityTracker2 = this.f3206l;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    public void p(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        this.f3216y.e(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.f3202h) {
            this.f3204j = view2;
        } else {
            Q(view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return R(rect, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        if (z2) {
            L();
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f3202h = true;
        super.requestLayout();
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int iF = f(i2, width, width2);
            int iF2 = f(i3, height, height2);
            if (iF == getScrollX() && iF2 == getScrollY()) {
                return;
            }
            super.scrollTo(iF, iF2);
        }
    }

    public void setFillViewport(boolean z2) {
        if (z2 != this.f3207m) {
            this.f3207m = z2;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z2) {
        this.f3216y.n(z2);
    }

    public void setOnScrollChangeListener(d dVar) {
        this.f3193A = dVar;
    }

    public void setSmoothScrollingEnabled(boolean z2) {
        this.f3208n = z2;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i2) {
        return X(i2, 0);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        Z(0);
    }

    public boolean t(KeyEvent keyEvent) {
        this.f3198c.setEmpty();
        if (!e()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View viewFindFocus = findFocus();
            if (viewFindFocus == this) {
                viewFindFocus = null;
            }
            View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, 130);
            return (viewFindNextFocus == null || viewFindNextFocus == this || !viewFindNextFocus.requestFocus(130)) ? false : true;
        }
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 19) {
            return keyEvent.isAltPressed() ? w(33) : c(33);
        }
        if (keyCode == 20) {
            return keyEvent.isAltPressed() ? w(130) : c(130);
        }
        if (keyCode == 62) {
            K(keyEvent.isShiftPressed() ? 33 : 130);
            return false;
        }
        if (keyCode == 92) {
            return w(33);
        }
        if (keyCode == 93) {
            return w(130);
        }
        if (keyCode == 122) {
            K(33);
            return false;
        }
        if (keyCode != 123) {
            return false;
        }
        K(130);
        return false;
    }

    public void v(int i2) {
        if (getChildCount() > 0) {
            this.f3199d.fling(getScrollX(), getScrollY(), 0, i2, 0, 0, Target.SIZE_ORIGINAL, Integer.MAX_VALUE, 0, 0);
            N(true);
        }
    }

    public boolean w(int i2) {
        int childCount;
        boolean z2 = i2 == 130;
        int height = getHeight();
        Rect rect = this.f3198c;
        rect.top = 0;
        rect.bottom = height;
        if (z2 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.f3198c.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.f3198c;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.f3198c;
        return O(i2, rect3.top, rect3.bottom);
    }

    public boolean y(int i2) {
        return this.f3216y.l(i2);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f3198c = new Rect();
        this.f3202h = true;
        this.f3203i = false;
        this.f3204j = null;
        this.f3205k = false;
        this.f3208n = true;
        this.r = -1;
        this.s = new int[2];
        this.f3211t = new int[2];
        c cVar = new c();
        this.f3194B = cVar;
        this.f3195C = new C0172o(getContext(), cVar);
        this.e = androidx.core.widget.d.a(context, attributeSet);
        this.f3200f = androidx.core.widget.d.a(context, attributeSet);
        this.f3196a = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        B();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f3192F, i2, 0);
        setFillViewport(typedArrayObtainStyledAttributes.getBoolean(0, false));
        typedArrayObtainStyledAttributes.recycle();
        this.f3215x = new E(this);
        this.f3216y = new B(this);
        setNestedScrollingEnabled(true);
        M.f0(this, f3191E);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2) {
        if (getChildCount() <= 0) {
            super.addView(view, i2);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i2, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
