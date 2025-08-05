package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.core.view.AbstractC0176t;
import androidx.core.view.C;
import androidx.core.view.E;
import androidx.core.view.F;
import androidx.core.view.M;
import androidx.core.view.Z;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import q.AbstractC0309a;
import q.AbstractC0310b;
import q.AbstractC0311c;
import v.AbstractC0340c;
import v.C0344g;
import v.InterfaceC0342e;

/* loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements C {

    /* renamed from: t */
    static final String f2802t;

    /* renamed from: u */
    static final Class[] f2803u;

    /* renamed from: v */
    static final ThreadLocal f2804v;

    /* renamed from: w */
    static final Comparator f2805w;

    /* renamed from: x */
    private static final InterfaceC0342e f2806x;

    /* renamed from: a */
    private final List f2807a;

    /* renamed from: b */
    private final androidx.coordinatorlayout.widget.a f2808b;

    /* renamed from: c */
    private final List f2809c;

    /* renamed from: d */
    private final List f2810d;
    private final int[] e;

    /* renamed from: f */
    private Paint f2811f;

    /* renamed from: g */
    private boolean f2812g;

    /* renamed from: h */
    private boolean f2813h;

    /* renamed from: i */
    private int[] f2814i;

    /* renamed from: j */
    private View f2815j;

    /* renamed from: k */
    private View f2816k;

    /* renamed from: l */
    private f f2817l;

    /* renamed from: m */
    private boolean f2818m;

    /* renamed from: n */
    private Z f2819n;
    private boolean o;

    /* renamed from: p */
    private Drawable f2820p;

    /* renamed from: q */
    ViewGroup.OnHierarchyChangeListener f2821q;
    private F r;
    private final E s;

    class a implements F {
        a() {
        }

        @Override // androidx.core.view.F
        public Z a(View view, Z z2) {
            return CoordinatorLayout.this.U(z2);
        }
    }

    public static abstract class b {
        public b() {
        }

        public void A(CoordinatorLayout coordinatorLayout, View view, View view2) {
        }

        public void B(CoordinatorLayout coordinatorLayout, View view, View view2, int i2) {
            if (i2 == 0) {
                A(coordinatorLayout, view, view2);
            }
        }

        public boolean C(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, View view) {
            return d(coordinatorLayout, view) > 0.0f;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
            return false;
        }

        public int c(CoordinatorLayout coordinatorLayout, View view) {
            return -16777216;
        }

        public float d(CoordinatorLayout coordinatorLayout, View view) {
            return 0.0f;
        }

        public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return false;
        }

        public Z f(CoordinatorLayout coordinatorLayout, View view, Z z2) {
            return z2;
        }

        public void g(e eVar) {
        }

        public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return false;
        }

        public void i(CoordinatorLayout coordinatorLayout, View view, View view2) {
        }

        public void j() {
        }

        public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return false;
        }

        public boolean l(CoordinatorLayout coordinatorLayout, View view, int i2) {
            return false;
        }

        public boolean m(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4, int i5) {
            return false;
        }

        public boolean n(CoordinatorLayout coordinatorLayout, View view, View view2, float f2, float f3, boolean z2) {
            return false;
        }

        public boolean o(CoordinatorLayout coordinatorLayout, View view, View view2, float f2, float f3) {
            return false;
        }

        public void p(CoordinatorLayout coordinatorLayout, View view, View view2, int i2, int i3, int[] iArr) {
        }

        public void q(CoordinatorLayout coordinatorLayout, View view, View view2, int i2, int i3, int[] iArr, int i4) {
            if (i4 == 0) {
                p(coordinatorLayout, view, view2, i2, i3, iArr);
            }
        }

        public void r(CoordinatorLayout coordinatorLayout, View view, View view2, int i2, int i3, int i4, int i5) {
        }

        public void s(CoordinatorLayout coordinatorLayout, View view, View view2, int i2, int i3, int i4, int i5, int i6) {
            if (i6 == 0) {
                r(coordinatorLayout, view, view2, i2, i3, i4, i5);
            }
        }

        public void t(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i2) {
        }

        public void u(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i2, int i3) {
            if (i3 == 0) {
                t(coordinatorLayout, view, view2, view3, i2);
            }
        }

        public boolean v(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z2) {
            return false;
        }

        public void w(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        }

        public Parcelable x(CoordinatorLayout coordinatorLayout, View view) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        public boolean y(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i2) {
            return false;
        }

        public boolean z(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i2, int i3) {
            if (i3 == 0) {
                return y(coordinatorLayout, view, view2, view3, i2);
            }
            return false;
        }

        public b(Context context, AttributeSet attributeSet) {
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface c {
        Class value();
    }

    private class d implements ViewGroup.OnHierarchyChangeListener {
        d() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f2821q;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.F(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f2821q;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    class f implements ViewTreeObserver.OnPreDrawListener {
        f() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.F(0);
            return true;
        }
    }

    static class h implements Comparator {
        h() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(View view, View view2) {
            float fI = M.I(view);
            float fI2 = M.I(view2);
            if (fI > fI2) {
                return -1;
            }
            return fI < fI2 ? 1 : 0;
        }
    }

    static {
        Package r02 = CoordinatorLayout.class.getPackage();
        f2802t = r02 != null ? r02.getName() : null;
        f2805w = new h();
        f2803u = new Class[]{Context.class, AttributeSet.class};
        f2804v = new ThreadLocal();
        f2806x = new C0344g(12);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC0309a.f7186a);
    }

    private void A(View view, int i2) {
        e eVar = (e) view.getLayoutParams();
        Rect rectA = a();
        rectA.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        if (this.f2819n != null && M.v(this) && !M.v(view)) {
            rectA.left += this.f2819n.i();
            rectA.top += this.f2819n.k();
            rectA.right -= this.f2819n.j();
            rectA.bottom -= this.f2819n.h();
        }
        Rect rectA2 = a();
        AbstractC0176t.a(Q(eVar.f2826c), view.getMeasuredWidth(), view.getMeasuredHeight(), rectA, rectA2, i2);
        view.layout(rectA2.left, rectA2.top, rectA2.right, rectA2.bottom);
        M(rectA);
        M(rectA2);
    }

    private void B(View view, View view2, int i2) {
        Rect rectA = a();
        Rect rectA2 = a();
        try {
            r(view2, rectA);
            s(view, i2, rectA, rectA2);
            view.layout(rectA2.left, rectA2.top, rectA2.right, rectA2.bottom);
        } finally {
            M(rectA);
            M(rectA2);
        }
    }

    private void C(View view, int i2, int i3) {
        e eVar = (e) view.getLayoutParams();
        int iB = AbstractC0176t.b(R(eVar.f2826c), i3);
        int i4 = iB & 7;
        int i5 = iB & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i3 == 1) {
            i2 = width - i2;
        }
        int iU = u(i2) - measuredWidth;
        if (i4 == 1) {
            iU += measuredWidth / 2;
        } else if (i4 == 5) {
            iU += measuredWidth;
        }
        int i6 = i5 != 16 ? i5 != 80 ? 0 : measuredHeight : measuredHeight / 2;
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin, Math.min(iU, ((width - getPaddingRight()) - measuredWidth) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin, Math.min(i6, ((height - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin));
        view.layout(iMax, iMax2, measuredWidth + iMax, measuredHeight + iMax2);
    }

    private void D(View view, Rect rect, int i2) {
        boolean z2;
        boolean z3;
        int width;
        int i3;
        int i4;
        int i5;
        int height;
        int i6;
        int i7;
        int i8;
        if (M.O(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            e eVar = (e) view.getLayoutParams();
            b bVarE = eVar.e();
            Rect rectA = a();
            Rect rectA2 = a();
            rectA2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (bVarE == null || !bVarE.b(this, view, rectA)) {
                rectA.set(rectA2);
            } else if (!rectA2.contains(rectA)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + rectA.toShortString() + " | Bounds:" + rectA2.toShortString());
            }
            M(rectA2);
            if (rectA.isEmpty()) {
                M(rectA);
                return;
            }
            int iB = AbstractC0176t.b(eVar.f2830h, i2);
            boolean z4 = true;
            if ((iB & 48) != 48 || (i7 = (rectA.top - ((ViewGroup.MarginLayoutParams) eVar).topMargin) - eVar.f2832j) >= (i8 = rect.top)) {
                z2 = false;
            } else {
                T(view, i8 - i7);
                z2 = true;
            }
            if ((iB & 80) == 80 && (height = ((getHeight() - rectA.bottom) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) + eVar.f2832j) < (i6 = rect.bottom)) {
                T(view, height - i6);
                z2 = true;
            }
            if (!z2) {
                T(view, 0);
            }
            if ((iB & 3) != 3 || (i4 = (rectA.left - ((ViewGroup.MarginLayoutParams) eVar).leftMargin) - eVar.f2831i) >= (i5 = rect.left)) {
                z3 = false;
            } else {
                S(view, i5 - i4);
                z3 = true;
            }
            if ((iB & 5) != 5 || (width = ((getWidth() - rectA.right) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin) + eVar.f2831i) >= (i3 = rect.right)) {
                z4 = z3;
            } else {
                S(view, width - i3);
            }
            if (!z4) {
                S(view, 0);
            }
            M(rectA);
        }
    }

    static b I(Context context, AttributeSet attributeSet, String str) throws NoSuchMethodException, SecurityException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0) {
            String str2 = f2802t;
            if (!TextUtils.isEmpty(str2)) {
                str = str2 + '.' + str;
            }
        }
        try {
            ThreadLocal threadLocal = f2804v;
            Map map = (Map) threadLocal.get();
            if (map == null) {
                map = new HashMap();
                threadLocal.set(map);
            }
            Constructor<?> constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = context.getClassLoader().loadClass(str).getConstructor(f2803u);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (b) constructor.newInstance(context, attributeSet);
        } catch (Exception e2) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e2);
        }
    }

    private boolean J(MotionEvent motionEvent, int i2) {
        int actionMasked = motionEvent.getActionMasked();
        List list = this.f2809c;
        x(list);
        int size = list.size();
        MotionEvent motionEventObtain = null;
        boolean zK = false;
        boolean z2 = false;
        for (int i3 = 0; i3 < size; i3++) {
            View view = (View) list.get(i3);
            e eVar = (e) view.getLayoutParams();
            b bVarE = eVar.e();
            if (!(zK || z2) || actionMasked == 0) {
                if (!zK && bVarE != null) {
                    if (i2 == 0) {
                        zK = bVarE.k(this, view, motionEvent);
                    } else if (i2 == 1) {
                        zK = bVarE.C(this, view, motionEvent);
                    }
                    if (zK) {
                        this.f2815j = view;
                    }
                }
                boolean zC = eVar.c();
                boolean zH = eVar.h(this, view);
                z2 = zH && !zC;
                if (zH && !z2) {
                    break;
                }
            } else if (bVarE != null) {
                if (motionEventObtain == null) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i2 == 0) {
                    bVarE.k(this, view, motionEventObtain);
                } else if (i2 == 1) {
                    bVarE.C(this, view, motionEventObtain);
                }
            }
        }
        list.clear();
        return zK;
    }

    private void K() {
        this.f2807a.clear();
        this.f2808b.c();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            e eVarW = w(childAt);
            eVarW.d(this, childAt);
            this.f2808b.b(childAt);
            for (int i3 = 0; i3 < childCount; i3++) {
                if (i3 != i2) {
                    View childAt2 = getChildAt(i3);
                    if (eVarW.b(this, childAt, childAt2)) {
                        if (!this.f2808b.d(childAt2)) {
                            this.f2808b.b(childAt2);
                        }
                        this.f2808b.a(childAt2, childAt);
                    }
                }
            }
        }
        this.f2807a.addAll(this.f2808b.h());
        Collections.reverse(this.f2807a);
    }

    private static void M(Rect rect) {
        rect.setEmpty();
        f2806x.release(rect);
    }

    private void O(boolean z2) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            b bVarE = ((e) childAt.getLayoutParams()).e();
            if (bVarE != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z2) {
                    bVarE.k(this, childAt, motionEventObtain);
                } else {
                    bVarE.C(this, childAt, motionEventObtain);
                }
                motionEventObtain.recycle();
            }
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            ((e) getChildAt(i3).getLayoutParams()).l();
        }
        this.f2815j = null;
        this.f2812g = false;
    }

    private static int P(int i2) {
        if (i2 == 0) {
            return 17;
        }
        return i2;
    }

    private static int Q(int i2) {
        if ((i2 & 7) == 0) {
            i2 |= 8388611;
        }
        return (i2 & 112) == 0 ? i2 | 48 : i2;
    }

    private static int R(int i2) {
        if (i2 == 0) {
            return 8388661;
        }
        return i2;
    }

    private void S(View view, int i2) {
        e eVar = (e) view.getLayoutParams();
        int i3 = eVar.f2831i;
        if (i3 != i2) {
            M.U(view, i2 - i3);
            eVar.f2831i = i2;
        }
    }

    private void T(View view, int i2) {
        e eVar = (e) view.getLayoutParams();
        int i3 = eVar.f2832j;
        if (i3 != i2) {
            M.V(view, i2 - i3);
            eVar.f2832j = i2;
        }
    }

    private void V() {
        if (!M.v(this)) {
            M.s0(this, null);
            return;
        }
        if (this.r == null) {
            this.r = new a();
        }
        M.s0(this, this.r);
        setSystemUiVisibility(1280);
    }

    private static Rect a() {
        Rect rect = (Rect) f2806x.acquire();
        return rect == null ? new Rect() : rect;
    }

    private static int c(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
    }

    private void d(e eVar, Rect rect, int i2, int i3) {
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i2) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i3) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin));
        rect.set(iMax, iMax2, i2 + iMax, i3 + iMax2);
    }

    private Z e(Z z2) {
        b bVarE;
        if (z2.n()) {
            return z2;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (M.v(childAt) && (bVarE = ((e) childAt.getLayoutParams()).e()) != null) {
                z2 = bVarE.f(this, childAt, z2);
                if (z2.n()) {
                    break;
                }
            }
        }
        return z2;
    }

    private void t(View view, int i2, Rect rect, Rect rect2, e eVar, int i3, int i4) {
        int iB = AbstractC0176t.b(P(eVar.f2826c), i2);
        int iB2 = AbstractC0176t.b(Q(eVar.f2827d), i2);
        int i5 = iB & 7;
        int i6 = iB & 112;
        int i7 = iB2 & 7;
        int i8 = iB2 & 112;
        int iWidth = i7 != 1 ? i7 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int iHeight = i8 != 16 ? i8 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i5 == 1) {
            iWidth -= i3 / 2;
        } else if (i5 != 5) {
            iWidth -= i3;
        }
        if (i6 == 16) {
            iHeight -= i4 / 2;
        } else if (i6 != 80) {
            iHeight -= i4;
        }
        rect2.set(iWidth, iHeight, i3 + iWidth, i4 + iHeight);
    }

    private int u(int i2) {
        int[] iArr = this.f2814i;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i2);
            return 0;
        }
        if (i2 >= 0 && i2 < iArr.length) {
            return iArr[i2];
        }
        Log.e("CoordinatorLayout", "Keyline index " + i2 + " out of range for " + this);
        return 0;
    }

    private void x(List list) {
        list.clear();
        boolean zIsChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            list.add(getChildAt(zIsChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i2) : i2));
        }
        Comparator comparator = f2805w;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    private boolean y(View view) {
        return this.f2808b.i(view);
    }

    void E(View view, int i2) {
        b bVarE;
        e eVar = (e) view.getLayoutParams();
        if (eVar.f2833k != null) {
            Rect rectA = a();
            Rect rectA2 = a();
            Rect rectA3 = a();
            r(eVar.f2833k, rectA);
            p(view, false, rectA2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            t(view, i2, rectA, rectA3, eVar, measuredWidth, measuredHeight);
            boolean z2 = (rectA3.left == rectA2.left && rectA3.top == rectA2.top) ? false : true;
            d(eVar, rectA3, measuredWidth, measuredHeight);
            int i3 = rectA3.left - rectA2.left;
            int i4 = rectA3.top - rectA2.top;
            if (i3 != 0) {
                M.U(view, i3);
            }
            if (i4 != 0) {
                M.V(view, i4);
            }
            if (z2 && (bVarE = eVar.e()) != null) {
                bVarE.h(this, view, eVar.f2833k);
            }
            M(rectA);
            M(rectA2);
            M(rectA3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void F(int r18) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.F(int):void");
    }

    public void G(View view, int i2) {
        e eVar = (e) view.getLayoutParams();
        if (eVar.a()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        View view2 = eVar.f2833k;
        if (view2 != null) {
            B(view, view2, i2);
            return;
        }
        int i3 = eVar.e;
        if (i3 >= 0) {
            C(view, i3, i2);
        } else {
            A(view, i2);
        }
    }

    public void H(View view, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    void L(View view, Rect rect) {
        ((e) view.getLayoutParams()).p(rect);
    }

    void N() {
        if (this.f2813h && this.f2817l != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f2817l);
        }
        this.f2818m = false;
    }

    final Z U(Z z2) {
        if (AbstractC0340c.a(this.f2819n, z2)) {
            return z2;
        }
        this.f2819n = z2;
        boolean z3 = false;
        boolean z4 = z2 != null && z2.k() > 0;
        this.o = z4;
        if (!z4 && getBackground() == null) {
            z3 = true;
        }
        setWillNotDraw(z3);
        Z zE = e(z2);
        requestLayout();
        return zE;
    }

    void b() {
        if (this.f2813h) {
            if (this.f2817l == null) {
                this.f2817l = new f();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f2817l);
        }
        this.f2818m = true;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof e) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j2) {
        e eVar = (e) view.getLayoutParams();
        b bVar = eVar.f2824a;
        if (bVar != null) {
            float fD = bVar.d(this, view);
            if (fD > 0.0f) {
                if (this.f2811f == null) {
                    this.f2811f = new Paint();
                }
                this.f2811f.setColor(eVar.f2824a.c(this, view));
                this.f2811f.setAlpha(c(Math.round(fD * 255.0f), 0, 255));
                int iSave = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.f2811f);
                canvas.restoreToCount(iSave);
            }
        }
        return super.drawChild(canvas, view, j2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f2820p;
        if ((drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState)) {
            invalidate();
        }
    }

    void f() {
        int childCount = getChildCount();
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            if (y(getChildAt(i2))) {
                z2 = true;
                break;
            }
            i2++;
        }
        if (z2 != this.f2818m) {
            if (z2) {
                b();
            } else {
                N();
            }
        }
    }

    @Override // android.view.ViewGroup
    /* renamed from: g */
    public e generateDefaultLayoutParams() {
        return new e(-2, -2);
    }

    final List<View> getDependencySortedChildren() {
        K();
        return Collections.unmodifiableList(this.f2807a);
    }

    public final Z getLastWindowInsets() {
        return this.f2819n;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.s.a();
    }

    public Drawable getStatusBarBackground() {
        return this.f2820p;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    @Override // androidx.core.view.C
    public void h(View view, View view2, int i2, int i3) {
        b bVarE;
        this.s.c(view, view2, i2, i3);
        this.f2816k = view2;
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            e eVar = (e) childAt.getLayoutParams();
            if (eVar.i(i3) && (bVarE = eVar.e()) != null) {
                bVarE.u(this, childAt, view, view2, i2, i3);
            }
        }
    }

    @Override // androidx.core.view.C
    public void i(View view, int i2) {
        this.s.e(view, i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            e eVar = (e) childAt.getLayoutParams();
            if (eVar.i(i2)) {
                b bVarE = eVar.e();
                if (bVarE != null) {
                    bVarE.B(this, childAt, view, i2);
                }
                eVar.k(i2);
                eVar.j();
            }
        }
        this.f2816k = null;
    }

    @Override // androidx.core.view.C
    public void j(View view, int i2, int i3, int[] iArr, int i4) {
        b bVarE;
        int childCount = getChildCount();
        boolean z2 = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.i(i4) && (bVarE = eVar.e()) != null) {
                    int[] iArr2 = this.e;
                    iArr2[1] = 0;
                    iArr2[0] = 0;
                    bVarE.q(this, childAt, view, i2, i3, iArr2, i4);
                    int[] iArr3 = this.e;
                    iMax = i2 > 0 ? Math.max(iMax, iArr3[0]) : Math.min(iMax, iArr3[0]);
                    int[] iArr4 = this.e;
                    iMax2 = i3 > 0 ? Math.max(iMax2, iArr4[1]) : Math.min(iMax2, iArr4[1]);
                    z2 = true;
                }
            }
        }
        iArr[0] = iMax;
        iArr[1] = iMax2;
        if (z2) {
            F(1);
        }
    }

    @Override // android.view.ViewGroup
    /* renamed from: k */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    /* renamed from: l */
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e ? new e((e) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    @Override // androidx.core.view.C
    public void n(View view, int i2, int i3, int i4, int i5, int i6) {
        b bVarE;
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.i(i6) && (bVarE = eVar.e()) != null) {
                    bVarE.s(this, childAt, view, i2, i3, i4, i5, i6);
                    z2 = true;
                }
            }
        }
        if (z2) {
            F(1);
        }
    }

    @Override // androidx.core.view.C
    public boolean o(View view, View view2, int i2, int i3) {
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                b bVarE = eVar.e();
                if (bVarE != null) {
                    boolean z3 = bVarE.z(this, childAt, view, view2, i2, i3);
                    z2 |= z3;
                    eVar.q(i3, z3);
                } else {
                    eVar.q(i3, false);
                }
            }
        }
        return z2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        O(false);
        if (this.f2818m) {
            if (this.f2817l == null) {
                this.f2817l = new f();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f2817l);
        }
        if (this.f2819n == null && M.v(this)) {
            M.c0(this);
        }
        this.f2813h = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        O(false);
        if (this.f2818m && this.f2817l != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f2817l);
        }
        View view = this.f2816k;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.f2813h = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.o || this.f2820p == null) {
            return;
        }
        Z z2 = this.f2819n;
        int iK = z2 != null ? z2.k() : 0;
        if (iK > 0) {
            this.f2820p.setBounds(0, 0, getWidth(), iK);
            this.f2820p.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            O(true);
        }
        boolean zJ = J(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            O(true);
        }
        return zJ;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        b bVarE;
        int iY = M.y(this);
        int size = this.f2807a.size();
        for (int i6 = 0; i6 < size; i6++) {
            View view = (View) this.f2807a.get(i6);
            if (view.getVisibility() != 8 && ((bVarE = ((e) view.getLayoutParams()).e()) == null || !bVarE.l(this, view, iY))) {
                G(view, iY);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00fd  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r31, int r32) {
        /*
            Method dump skipped, instructions count: 393
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        b bVarE;
        int childCount = getChildCount();
        boolean zN = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.i(0) && (bVarE = eVar.e()) != null) {
                    zN |= bVarE.n(this, childAt, view, f2, f3, z2);
                }
            }
        }
        if (zN) {
            F(1);
        }
        return zN;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        b bVarE;
        int childCount = getChildCount();
        boolean zO = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.i(0) && (bVarE = eVar.e()) != null) {
                    zO |= bVarE.o(this, childAt, view, f2, f3);
                }
            }
        }
        return zO;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        j(view, i2, i3, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        n(view, i2, i3, i4, i5, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        h(view, view2, i2, 0);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof g)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        g gVar = (g) parcelable;
        super.onRestoreInstanceState(gVar.a());
        SparseArray sparseArray = gVar.f2840c;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            b bVarE = w(childAt).e();
            if (id != -1 && bVarE != null && (parcelable2 = (Parcelable) sparseArray.get(id)) != null) {
                bVarE.w(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelableX;
        g gVar = new g(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            b bVarE = ((e) childAt.getLayoutParams()).e();
            if (id != -1 && bVarE != null && (parcelableX = bVarE.x(this, childAt)) != null) {
                sparseArray.append(id, parcelableX);
            }
        }
        gVar.f2840c = sparseArray;
        return gVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return o(view, view2, i2, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        i(view, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0015 A[PHI: r3
  0x0015: PHI (r3v4 boolean) = (r3v2 boolean), (r3v5 boolean) binds: [B:34:0x0024, B:29:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0054  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.f2815j
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L17
            boolean r3 = r0.J(r1, r4)
            if (r3 == 0) goto L15
            goto L18
        L15:
            r6 = 0
            goto L2c
        L17:
            r3 = 0
        L18:
            android.view.View r6 = r0.f2815j
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$e r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.e) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$b r6 = r6.e()
            if (r6 == 0) goto L15
            android.view.View r7 = r0.f2815j
            boolean r6 = r6.C(r0, r7, r1)
        L2c:
            android.view.View r7 = r0.f2815j
            r8 = 0
            if (r7 != 0) goto L37
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L4a
        L37:
            if (r3 == 0) goto L4a
            long r11 = android.os.SystemClock.uptimeMillis()
            r15 = 0
            r16 = 0
            r13 = 3
            r14 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L4a:
            if (r8 == 0) goto L4f
            r8.recycle()
        L4f:
            if (r2 == r4) goto L54
            r1 = 3
            if (r2 != r1) goto L57
        L54:
            r0.O(r5)
        L57:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    void p(View view, boolean z2, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z2) {
            r(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public List q(View view) {
        List listG = this.f2808b.g(view);
        this.f2810d.clear();
        if (listG != null) {
            this.f2810d.addAll(listG);
        }
        return this.f2810d;
    }

    void r(View view, Rect rect) {
        androidx.coordinatorlayout.widget.b.a(this, view, rect);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        b bVarE = ((e) view.getLayoutParams()).e();
        if (bVarE == null || !bVarE.v(this, view, rect, z2)) {
            return super.requestChildRectangleOnScreen(view, rect, z2);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        super.requestDisallowInterceptTouchEvent(z2);
        if (!z2 || this.f2812g) {
            return;
        }
        O(false);
        this.f2812g = true;
    }

    void s(View view, int i2, Rect rect, Rect rect2) {
        e eVar = (e) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        t(view, i2, rect, rect2, eVar, measuredWidth, measuredHeight);
        d(eVar, rect2, measuredWidth, measuredHeight);
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z2) {
        super.setFitsSystemWindows(z2);
        V();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f2821q = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Drawable drawable2 = this.f2820p;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f2820p = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.f2820p.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a.l(this.f2820p, M.y(this));
                this.f2820p.setVisible(getVisibility() == 0, false);
                this.f2820p.setCallback(this);
            }
            M.Z(this);
        }
    }

    public void setStatusBarBackgroundColor(int i2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        setStatusBarBackground(new ColorDrawable(i2));
    }

    public void setStatusBarBackgroundResource(int i2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        setStatusBarBackground(i2 != 0 ? androidx.core.content.a.d(getContext(), i2) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z2 = i2 == 0;
        Drawable drawable = this.f2820p;
        if (drawable == null || drawable.isVisible() == z2) {
            return;
        }
        this.f2820p.setVisible(z2, false);
    }

    void v(View view, Rect rect) {
        rect.set(((e) view.getLayoutParams()).g());
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f2820p;
    }

    e w(View view) {
        e eVar = (e) view.getLayoutParams();
        if (!eVar.f2825b) {
            c cVar = null;
            for (Class<?> superclass = view.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                cVar = (c) superclass.getAnnotation(c.class);
                if (cVar != null) {
                    break;
                }
            }
            if (cVar != null) {
                try {
                    eVar.n((b) cVar.value().getDeclaredConstructor(null).newInstance(null));
                } catch (Exception e2) {
                    Log.e("CoordinatorLayout", "Default behavior class " + cVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e2);
                }
            }
            eVar.f2825b = true;
        }
        return eVar;
    }

    public boolean z(View view, int i2, int i3) {
        Rect rectA = a();
        r(view, rectA);
        try {
            return rectA.contains(i2, i3);
        } finally {
            M(rectA);
        }
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2807a = new ArrayList();
        this.f2808b = new androidx.coordinatorlayout.widget.a();
        this.f2809c = new ArrayList();
        this.f2810d = new ArrayList();
        this.e = new int[2];
        this.s = new E(this);
        TypedArray typedArrayObtainStyledAttributes = i2 == 0 ? context.obtainStyledAttributes(attributeSet, AbstractC0311c.f7189b, 0, AbstractC0310b.f7187a) : context.obtainStyledAttributes(attributeSet, AbstractC0311c.f7189b, i2, 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(AbstractC0311c.f7190c, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f2814i = resources.getIntArray(resourceId);
            float f2 = resources.getDisplayMetrics().density;
            int length = this.f2814i.length;
            for (int i3 = 0; i3 < length; i3++) {
                this.f2814i[i3] = (int) (r1[i3] * f2);
            }
        }
        this.f2820p = typedArrayObtainStyledAttributes.getDrawable(AbstractC0311c.f7191d);
        typedArrayObtainStyledAttributes.recycle();
        V();
        super.setOnHierarchyChangeListener(new d());
    }

    protected static class g extends A.a {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* renamed from: c */
        SparseArray f2840c;

        static class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b */
            public g createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new g(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c */
            public g[] newArray(int i2) {
                return new g[i2];
            }
        }

        public g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int i2 = parcel.readInt();
            int[] iArr = new int[i2];
            parcel.readIntArray(iArr);
            Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
            this.f2840c = new SparseArray(i2);
            for (int i3 = 0; i3 < i2; i3++) {
                this.f2840c.append(iArr[i3], parcelableArray[i3]);
            }
        }

        @Override // A.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            SparseArray sparseArray = this.f2840c;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i3 = 0; i3 < size; i3++) {
                iArr[i3] = this.f2840c.keyAt(i3);
                parcelableArr[i3] = (Parcelable) this.f2840c.valueAt(i3);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i2);
        }

        public g(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static class e extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        b f2824a;

        /* renamed from: b */
        boolean f2825b;

        /* renamed from: c */
        public int f2826c;

        /* renamed from: d */
        public int f2827d;
        public int e;

        /* renamed from: f */
        int f2828f;

        /* renamed from: g */
        public int f2829g;

        /* renamed from: h */
        public int f2830h;

        /* renamed from: i */
        int f2831i;

        /* renamed from: j */
        int f2832j;

        /* renamed from: k */
        View f2833k;

        /* renamed from: l */
        View f2834l;

        /* renamed from: m */
        private boolean f2835m;

        /* renamed from: n */
        private boolean f2836n;
        private boolean o;

        /* renamed from: p */
        private boolean f2837p;

        /* renamed from: q */
        final Rect f2838q;
        Object r;

        public e(int i2, int i3) {
            super(i2, i3);
            this.f2825b = false;
            this.f2826c = 0;
            this.f2827d = 0;
            this.e = -1;
            this.f2828f = -1;
            this.f2829g = 0;
            this.f2830h = 0;
            this.f2838q = new Rect();
        }

        private void m(View view, CoordinatorLayout coordinatorLayout) {
            View viewFindViewById = coordinatorLayout.findViewById(this.f2828f);
            this.f2833k = viewFindViewById;
            if (viewFindViewById == null) {
                if (coordinatorLayout.isInEditMode()) {
                    this.f2834l = null;
                    this.f2833k = null;
                    return;
                }
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f2828f) + " to anchor view " + view);
            }
            if (viewFindViewById == coordinatorLayout) {
                if (!coordinatorLayout.isInEditMode()) {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
                this.f2834l = null;
                this.f2833k = null;
                return;
            }
            for (ViewParent parent = viewFindViewById.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                if (parent == view) {
                    if (!coordinatorLayout.isInEditMode()) {
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }
                    this.f2834l = null;
                    this.f2833k = null;
                    return;
                }
                if (parent instanceof View) {
                    viewFindViewById = parent;
                }
            }
            this.f2834l = viewFindViewById;
        }

        private boolean r(View view, int i2) {
            int iB = AbstractC0176t.b(((e) view.getLayoutParams()).f2829g, i2);
            return iB != 0 && (AbstractC0176t.b(this.f2830h, i2) & iB) == iB;
        }

        private boolean s(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f2833k.getId() != this.f2828f) {
                return false;
            }
            View view2 = this.f2833k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.f2834l = null;
                    this.f2833k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = parent;
                }
            }
            this.f2834l = view2;
            return true;
        }

        boolean a() {
            return this.f2833k == null && this.f2828f != -1;
        }

        boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            b bVar;
            return view2 == this.f2834l || r(view2, M.y(coordinatorLayout)) || ((bVar = this.f2824a) != null && bVar.e(coordinatorLayout, view, view2));
        }

        boolean c() {
            if (this.f2824a == null) {
                this.f2835m = false;
            }
            return this.f2835m;
        }

        View d(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f2828f == -1) {
                this.f2834l = null;
                this.f2833k = null;
                return null;
            }
            if (this.f2833k == null || !s(view, coordinatorLayout)) {
                m(view, coordinatorLayout);
            }
            return this.f2833k;
        }

        public b e() {
            return this.f2824a;
        }

        boolean f() {
            return this.f2837p;
        }

        Rect g() {
            return this.f2838q;
        }

        boolean h(CoordinatorLayout coordinatorLayout, View view) {
            boolean z2 = this.f2835m;
            if (z2) {
                return true;
            }
            b bVar = this.f2824a;
            boolean zA = (bVar != null ? bVar.a(coordinatorLayout, view) : false) | z2;
            this.f2835m = zA;
            return zA;
        }

        boolean i(int i2) {
            if (i2 == 0) {
                return this.f2836n;
            }
            if (i2 != 1) {
                return false;
            }
            return this.o;
        }

        void j() {
            this.f2837p = false;
        }

        void k(int i2) {
            q(i2, false);
        }

        void l() {
            this.f2835m = false;
        }

        public void n(b bVar) {
            b bVar2 = this.f2824a;
            if (bVar2 != bVar) {
                if (bVar2 != null) {
                    bVar2.j();
                }
                this.f2824a = bVar;
                this.r = null;
                this.f2825b = true;
                if (bVar != null) {
                    bVar.g(this);
                }
            }
        }

        void o(boolean z2) {
            this.f2837p = z2;
        }

        void p(Rect rect) {
            this.f2838q.set(rect);
        }

        void q(int i2, boolean z2) {
            if (i2 == 0) {
                this.f2836n = z2;
            } else {
                if (i2 != 1) {
                    return;
                }
                this.o = z2;
            }
        }

        e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2825b = false;
            this.f2826c = 0;
            this.f2827d = 0;
            this.e = -1;
            this.f2828f = -1;
            this.f2829g = 0;
            this.f2830h = 0;
            this.f2838q = new Rect();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0311c.e);
            this.f2826c = typedArrayObtainStyledAttributes.getInteger(AbstractC0311c.f7192f, 0);
            this.f2828f = typedArrayObtainStyledAttributes.getResourceId(AbstractC0311c.f7193g, -1);
            this.f2827d = typedArrayObtainStyledAttributes.getInteger(AbstractC0311c.f7194h, 0);
            this.e = typedArrayObtainStyledAttributes.getInteger(AbstractC0311c.f7198l, -1);
            this.f2829g = typedArrayObtainStyledAttributes.getInt(AbstractC0311c.f7197k, 0);
            this.f2830h = typedArrayObtainStyledAttributes.getInt(AbstractC0311c.f7196j, 0);
            int i2 = AbstractC0311c.f7195i;
            boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i2);
            this.f2825b = zHasValue;
            if (zHasValue) {
                this.f2824a = CoordinatorLayout.I(context, attributeSet, typedArrayObtainStyledAttributes.getString(i2));
            }
            typedArrayObtainStyledAttributes.recycle();
            b bVar = this.f2824a;
            if (bVar != null) {
                bVar.g(this);
            }
        }

        public e(e eVar) {
            super((ViewGroup.MarginLayoutParams) eVar);
            this.f2825b = false;
            this.f2826c = 0;
            this.f2827d = 0;
            this.e = -1;
            this.f2828f = -1;
            this.f2829g = 0;
            this.f2830h = 0;
            this.f2838q = new Rect();
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2825b = false;
            this.f2826c = 0;
            this.f2827d = 0;
            this.e = -1;
            this.f2828f = -1;
            this.f2829g = 0;
            this.f2830h = 0;
            this.f2838q = new Rect();
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2825b = false;
            this.f2826c = 0;
            this.f2827d = 0;
            this.e = -1;
            this.f2828f = -1;
            this.f2829g = 0;
            this.f2830h = 0;
            this.f2838q = new Rect();
        }
    }
}
