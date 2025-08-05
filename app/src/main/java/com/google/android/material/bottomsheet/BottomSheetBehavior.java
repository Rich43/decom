package com.google.android.material.bottomsheet;

import B.a;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.M;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import t.AbstractC0327a;
import u0.AbstractC0332b;
import u0.AbstractC0337g;

/* loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.b {

    /* renamed from: a, reason: collision with root package name */
    private boolean f5660a;

    /* renamed from: b, reason: collision with root package name */
    private float f5661b;

    /* renamed from: c, reason: collision with root package name */
    private int f5662c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f5663d;
    private int e;

    /* renamed from: f, reason: collision with root package name */
    private int f5664f;

    /* renamed from: g, reason: collision with root package name */
    int f5665g;

    /* renamed from: h, reason: collision with root package name */
    int f5666h;

    /* renamed from: i, reason: collision with root package name */
    int f5667i;

    /* renamed from: j, reason: collision with root package name */
    boolean f5668j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f5669k;

    /* renamed from: l, reason: collision with root package name */
    int f5670l;

    /* renamed from: m, reason: collision with root package name */
    B.a f5671m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f5672n;
    private int o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f5673p;

    /* renamed from: q, reason: collision with root package name */
    int f5674q;
    WeakReference r;
    WeakReference s;

    /* renamed from: t, reason: collision with root package name */
    private VelocityTracker f5675t;

    /* renamed from: u, reason: collision with root package name */
    int f5676u;

    /* renamed from: v, reason: collision with root package name */
    private int f5677v;

    /* renamed from: w, reason: collision with root package name */
    boolean f5678w;

    /* renamed from: x, reason: collision with root package name */
    private Map f5679x;

    /* renamed from: y, reason: collision with root package name */
    private final a.c f5680y;

    class a extends a.c {
        a() {
        }

        @Override // B.a.c
        public int a(View view, int i2, int i3) {
            return view.getLeft();
        }

        @Override // B.a.c
        public int b(View view, int i2, int i3) {
            int I2 = BottomSheetBehavior.this.I();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return AbstractC0327a.a(i2, I2, bottomSheetBehavior.f5668j ? bottomSheetBehavior.f5674q : bottomSheetBehavior.f5667i);
        }

        @Override // B.a.c
        public int e(View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return bottomSheetBehavior.f5668j ? bottomSheetBehavior.f5674q : bottomSheetBehavior.f5667i;
        }

        @Override // B.a.c
        public void j(int i2) {
            if (i2 == 1) {
                BottomSheetBehavior.this.P(1);
            }
        }

        @Override // B.a.c
        public void k(View view, int i2, int i3, int i4, int i5) {
            BottomSheetBehavior.this.G(i3);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0022 A[PHI: r0
  0x0022: PHI (r0v11 int) = (r0v0 int), (r0v10 int), (r0v0 int) binds: [B:37:0x00a2, B:31:0x0089, B:8:0x001e] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // B.a.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void l(android.view.View r7, float r8, float r9) {
            /*
                Method dump skipped, instructions count: 237
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.a.l(android.view.View, float, float):void");
        }

        @Override // B.a.c
        public boolean m(View view, int i2) {
            WeakReference weakReference;
            View view2;
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i3 = bottomSheetBehavior.f5670l;
            if (i3 == 1 || bottomSheetBehavior.f5678w) {
                return false;
            }
            return ((i3 == 3 && bottomSheetBehavior.f5676u == i2 && (view2 = (View) bottomSheetBehavior.s.get()) != null && view2.canScrollVertically(-1)) || (weakReference = BottomSheetBehavior.this.r) == null || weakReference.get() != view) ? false : true;
        }
    }

    private class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final View f5683a;

        /* renamed from: b, reason: collision with root package name */
        private final int f5684b;

        c(View view, int i2) {
            this.f5683a = view;
            this.f5684b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            B.a aVar = BottomSheetBehavior.this.f5671m;
            if (aVar == null || !aVar.k(true)) {
                BottomSheetBehavior.this.P(this.f5684b);
            } else {
                M.a0(this.f5683a, this);
            }
        }
    }

    public BottomSheetBehavior() {
        this.f5660a = true;
        this.f5670l = 4;
        this.f5680y = new a();
    }

    private void F() {
        if (this.f5660a) {
            this.f5667i = Math.max(this.f5674q - this.f5664f, this.f5665g);
        } else {
            this.f5667i = this.f5674q - this.f5664f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int I() {
        if (this.f5660a) {
            return this.f5665g;
        }
        return 0;
    }

    private float J() {
        VelocityTracker velocityTracker = this.f5675t;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.f5661b);
        return this.f5675t.getYVelocity(this.f5676u);
    }

    private void K() {
        this.f5676u = -1;
        VelocityTracker velocityTracker = this.f5675t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f5675t = null;
        }
    }

    private void R(boolean z2) {
        WeakReference weakReference = this.r;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = ((View) weakReference.get()).getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z2) {
                if (this.f5679x != null) {
                    return;
                } else {
                    this.f5679x = new HashMap(childCount);
                }
            }
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                if (childAt != this.r.get()) {
                    if (z2) {
                        this.f5679x.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        M.p0(childAt, 4);
                    } else {
                        Map map = this.f5679x;
                        if (map != null && map.containsKey(childAt)) {
                            M.p0(childAt, ((Integer) this.f5679x.get(childAt)).intValue());
                        }
                    }
                }
            }
            if (z2) {
                return;
            }
            this.f5679x = null;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public void B(CoordinatorLayout coordinatorLayout, View view, View view2, int i2) {
        int I2;
        int i3 = 3;
        if (view.getTop() == I()) {
            P(3);
            return;
        }
        if (view2 == this.s.get() && this.f5673p) {
            if (this.o > 0) {
                I2 = I();
            } else if (this.f5668j && Q(view, J())) {
                I2 = this.f5674q;
                i3 = 5;
            } else {
                if (this.o == 0) {
                    int top = view.getTop();
                    if (!this.f5660a) {
                        int i4 = this.f5666h;
                        if (top < i4) {
                            if (top < Math.abs(top - this.f5667i)) {
                                I2 = 0;
                            } else {
                                I2 = this.f5666h;
                            }
                        } else if (Math.abs(top - i4) < Math.abs(top - this.f5667i)) {
                            I2 = this.f5666h;
                        } else {
                            I2 = this.f5667i;
                        }
                        i3 = 6;
                    } else if (Math.abs(top - this.f5665g) < Math.abs(top - this.f5667i)) {
                        I2 = this.f5665g;
                    } else {
                        I2 = this.f5667i;
                    }
                } else {
                    I2 = this.f5667i;
                }
                i3 = 4;
            }
            if (this.f5671m.H(view, view.getLeft(), I2)) {
                P(2);
                M.a0(view, new c(view, i3));
            } else {
                P(i3);
            }
            this.f5673p = false;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean C(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f5670l == 1 && actionMasked == 0) {
            return true;
        }
        B.a aVar = this.f5671m;
        if (aVar != null) {
            aVar.z(motionEvent);
        }
        if (actionMasked == 0) {
            K();
        }
        if (this.f5675t == null) {
            this.f5675t = VelocityTracker.obtain();
        }
        this.f5675t.addMovement(motionEvent);
        if (actionMasked == 2 && !this.f5672n && Math.abs(this.f5677v - motionEvent.getY()) > this.f5671m.u()) {
            this.f5671m.b(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.f5672n;
    }

    void G(int i2) {
    }

    View H(View view) {
        if (M.P(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View viewH = H(viewGroup.getChildAt(i2));
            if (viewH != null) {
                return viewH;
            }
        }
        return null;
    }

    public void L(boolean z2) {
        if (this.f5660a == z2) {
            return;
        }
        this.f5660a = z2;
        if (this.r != null) {
            F();
        }
        P((this.f5660a && this.f5670l == 6) ? 3 : this.f5670l);
    }

    public void M(boolean z2) {
        this.f5668j = z2;
    }

    public final void N(int i2) {
        WeakReference weakReference;
        View view;
        if (i2 == -1) {
            if (this.f5663d) {
                return;
            } else {
                this.f5663d = true;
            }
        } else {
            if (!this.f5663d && this.f5662c == i2) {
                return;
            }
            this.f5663d = false;
            this.f5662c = Math.max(0, i2);
            this.f5667i = this.f5674q - i2;
        }
        if (this.f5670l != 4 || (weakReference = this.r) == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        view.requestLayout();
    }

    public void O(boolean z2) {
        this.f5669k = z2;
    }

    void P(int i2) {
        if (this.f5670l == i2) {
            return;
        }
        this.f5670l = i2;
        if (i2 == 6 || i2 == 3) {
            R(true);
        } else if (i2 == 5 || i2 == 4) {
            R(false);
        }
    }

    boolean Q(View view, float f2) {
        if (this.f5669k) {
            return true;
        }
        return view.getTop() >= this.f5667i && Math.abs((((float) view.getTop()) + (f2 * 0.1f)) - ((float) this.f5667i)) / ((float) this.f5662c) > 0.5f;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        B.a aVar;
        if (!view.isShown()) {
            this.f5672n = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            K();
        }
        if (this.f5675t == null) {
            this.f5675t = VelocityTracker.obtain();
        }
        this.f5675t.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x2 = (int) motionEvent.getX();
            this.f5677v = (int) motionEvent.getY();
            WeakReference weakReference = this.s;
            View view2 = weakReference != null ? (View) weakReference.get() : null;
            if (view2 != null && coordinatorLayout.z(view2, x2, this.f5677v)) {
                this.f5676u = motionEvent.getPointerId(motionEvent.getActionIndex());
                this.f5678w = true;
            }
            this.f5672n = this.f5676u == -1 && !coordinatorLayout.z(view, x2, this.f5677v);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f5678w = false;
            this.f5676u = -1;
            if (this.f5672n) {
                this.f5672n = false;
                return false;
            }
        }
        if (!this.f5672n && (aVar = this.f5671m) != null && aVar.G(motionEvent)) {
            return true;
        }
        WeakReference weakReference2 = this.s;
        View view3 = weakReference2 != null ? (View) weakReference2.get() : null;
        return (actionMasked != 2 || view3 == null || this.f5672n || this.f5670l == 1 || coordinatorLayout.z(view3, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.f5671m == null || Math.abs(((float) this.f5677v) - motionEvent.getY()) <= ((float) this.f5671m.u())) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i2) {
        if (M.v(coordinatorLayout) && !M.v(view)) {
            view.setFitsSystemWindows(true);
        }
        int top = view.getTop();
        coordinatorLayout.G(view, i2);
        this.f5674q = coordinatorLayout.getHeight();
        if (this.f5663d) {
            if (this.e == 0) {
                this.e = coordinatorLayout.getResources().getDimensionPixelSize(AbstractC0332b.f7565a);
            }
            this.f5664f = Math.max(this.e, this.f5674q - ((coordinatorLayout.getWidth() * 9) / 16));
        } else {
            this.f5664f = this.f5662c;
        }
        this.f5665g = Math.max(0, this.f5674q - view.getHeight());
        this.f5666h = this.f5674q / 2;
        F();
        int i3 = this.f5670l;
        if (i3 == 3) {
            M.V(view, I());
        } else if (i3 == 6) {
            M.V(view, this.f5666h);
        } else if (this.f5668j && i3 == 5) {
            M.V(view, this.f5674q);
        } else if (i3 == 4) {
            M.V(view, this.f5667i);
        } else if (i3 == 1 || i3 == 2) {
            M.V(view, top - view.getTop());
        }
        if (this.f5671m == null) {
            this.f5671m = B.a.m(coordinatorLayout, this.f5680y);
        }
        this.r = new WeakReference(view);
        this.s = new WeakReference(H(view));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean o(CoordinatorLayout coordinatorLayout, View view, View view2, float f2, float f3) {
        return view2 == this.s.get() && (this.f5670l != 3 || super.o(coordinatorLayout, view, view2, f2, f3));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public void q(CoordinatorLayout coordinatorLayout, View view, View view2, int i2, int i3, int[] iArr, int i4) {
        if (i4 != 1 && view2 == ((View) this.s.get())) {
            int top = view.getTop();
            int i5 = top - i3;
            if (i3 > 0) {
                if (i5 < I()) {
                    int I2 = top - I();
                    iArr[1] = I2;
                    M.V(view, -I2);
                    P(3);
                } else {
                    iArr[1] = i3;
                    M.V(view, -i3);
                    P(1);
                }
            } else if (i3 < 0 && !view2.canScrollVertically(-1)) {
                int i6 = this.f5667i;
                if (i5 <= i6 || this.f5668j) {
                    iArr[1] = i3;
                    M.V(view, -i3);
                    P(1);
                } else {
                    int i7 = top - i6;
                    iArr[1] = i7;
                    M.V(view, -i7);
                    P(4);
                }
            }
            G(view.getTop());
            this.o = i3;
            this.f5673p = true;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public void w(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        b bVar = (b) parcelable;
        super.w(coordinatorLayout, view, bVar.a());
        int i2 = bVar.f5682c;
        if (i2 == 1 || i2 == 2) {
            this.f5670l = 4;
        } else {
            this.f5670l = i2;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public Parcelable x(CoordinatorLayout coordinatorLayout, View view) {
        return new b(super.x(coordinatorLayout, view), this.f5670l);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean z(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i2, int i3) {
        this.o = 0;
        this.f5673p = false;
        return (i2 & 2) != 0;
    }

    protected static class b extends A.a {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* renamed from: c, reason: collision with root package name */
        final int f5682c;

        static class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new b(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i2) {
                return new b[i2];
            }
        }

        public b(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f5682c = parcel.readInt();
        }

        @Override // A.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f5682c);
        }

        public b(Parcelable parcelable, int i2) {
            super(parcelable);
            this.f5682c = i2;
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        int i2;
        super(context, attributeSet);
        this.f5660a = true;
        this.f5670l = 4;
        this.f5680y = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0337g.f7650q);
        int i3 = AbstractC0337g.f7654t;
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(i3);
        if (typedValuePeekValue != null && (i2 = typedValuePeekValue.data) == -1) {
            N(i2);
        } else {
            N(typedArrayObtainStyledAttributes.getDimensionPixelSize(i3, -1));
        }
        M(typedArrayObtainStyledAttributes.getBoolean(AbstractC0337g.s, false));
        L(typedArrayObtainStyledAttributes.getBoolean(AbstractC0337g.r, true));
        O(typedArrayObtainStyledAttributes.getBoolean(AbstractC0337g.f7656u, false));
        typedArrayObtainStyledAttributes.recycle();
        this.f5661b = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
