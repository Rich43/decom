package androidx.recyclerview.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.appcompat.app.F;
import androidx.core.view.M;
import androidx.core.view.Q;
import androidx.recyclerview.widget.a;
import androidx.recyclerview.widget.b;
import androidx.recyclerview.widget.e;
import androidx.recyclerview.widget.o;
import androidx.recyclerview.widget.p;
import com.bumptech.glide.request.target.Target;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import v.AbstractC0345h;
import w.AbstractC0358b;
import w.C0353E;

/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup {

    /* renamed from: A0 */
    static final boolean f3887A0;

    /* renamed from: B0 */
    static final boolean f3888B0;

    /* renamed from: C0 */
    static final boolean f3889C0;

    /* renamed from: D0 */
    private static final boolean f3890D0;

    /* renamed from: E0 */
    private static final boolean f3891E0;

    /* renamed from: F0 */
    private static final Class[] f3892F0;

    /* renamed from: G0 */
    static final Interpolator f3893G0;

    /* renamed from: x0 */
    private static final int[] f3894x0 = {R.attr.nestedScrollingEnabled};

    /* renamed from: y0 */
    private static final int[] f3895y0 = {R.attr.clipToPadding};

    /* renamed from: z0 */
    static final boolean f3896z0;

    /* renamed from: A */
    private final AccessibilityManager f3897A;

    /* renamed from: B */
    private List f3898B;

    /* renamed from: C */
    boolean f3899C;

    /* renamed from: D */
    boolean f3900D;

    /* renamed from: E */
    private int f3901E;

    /* renamed from: F */
    private int f3902F;

    /* renamed from: G */
    private k f3903G;

    /* renamed from: H */
    private EdgeEffect f3904H;

    /* renamed from: I */
    private EdgeEffect f3905I;

    /* renamed from: J */
    private EdgeEffect f3906J;

    /* renamed from: K */
    private EdgeEffect f3907K;

    /* renamed from: L */
    l f3908L;

    /* renamed from: M */
    private int f3909M;

    /* renamed from: N */
    private int f3910N;

    /* renamed from: O */
    private VelocityTracker f3911O;

    /* renamed from: P */
    private int f3912P;

    /* renamed from: Q */
    private int f3913Q;

    /* renamed from: R */
    private int f3914R;

    /* renamed from: S */
    private int f3915S;

    /* renamed from: T */
    private int f3916T;

    /* renamed from: U */
    private final int f3917U;

    /* renamed from: V */
    private final int f3918V;

    /* renamed from: W */
    private float f3919W;

    /* renamed from: a */
    private final x f3920a;

    /* renamed from: a0 */
    private float f3921a0;

    /* renamed from: b */
    final v f3922b;

    /* renamed from: b0 */
    private boolean f3923b0;

    /* renamed from: c */
    private y f3924c;

    /* renamed from: c0 */
    final B f3925c0;

    /* renamed from: d */
    a f3926d;

    /* renamed from: d0 */
    androidx.recyclerview.widget.e f3927d0;
    b e;

    /* renamed from: e0 */
    e.b f3928e0;

    /* renamed from: f */
    final androidx.recyclerview.widget.p f3929f;

    /* renamed from: f0 */
    final z f3930f0;

    /* renamed from: g */
    boolean f3931g;

    /* renamed from: g0 */
    private t f3932g0;

    /* renamed from: h */
    final Runnable f3933h;

    /* renamed from: h0 */
    private List f3934h0;

    /* renamed from: i */
    final Rect f3935i;

    /* renamed from: i0 */
    boolean f3936i0;

    /* renamed from: j */
    private final Rect f3937j;

    /* renamed from: j0 */
    boolean f3938j0;

    /* renamed from: k */
    final RectF f3939k;

    /* renamed from: k0 */
    private l.b f3940k0;

    /* renamed from: l */
    g f3941l;

    /* renamed from: l0 */
    boolean f3942l0;

    /* renamed from: m */
    o f3943m;

    /* renamed from: m0 */
    androidx.recyclerview.widget.l f3944m0;

    /* renamed from: n */
    final ArrayList f3945n;

    /* renamed from: n0 */
    private j f3946n0;
    private final ArrayList o;

    /* renamed from: o0 */
    private final int[] f3947o0;

    /* renamed from: p */
    private s f3948p;

    /* renamed from: p0 */
    private androidx.core.view.B f3949p0;

    /* renamed from: q */
    boolean f3950q;

    /* renamed from: q0 */
    private final int[] f3951q0;
    boolean r;

    /* renamed from: r0 */
    final int[] f3952r0;
    boolean s;

    /* renamed from: s0 */
    private final int[] f3953s0;

    /* renamed from: t */
    boolean f3954t;

    /* renamed from: t0 */
    final int[] f3955t0;

    /* renamed from: u */
    private int f3956u;

    /* renamed from: u0 */
    final List f3957u0;

    /* renamed from: v */
    boolean f3958v;

    /* renamed from: v0 */
    private Runnable f3959v0;

    /* renamed from: w */
    boolean f3960w;

    /* renamed from: w0 */
    private final p.b f3961w0;

    /* renamed from: x */
    private boolean f3962x;

    /* renamed from: y */
    private int f3963y;

    /* renamed from: z */
    boolean f3964z;

    public static abstract class A {
    }

    class B implements Runnable {

        /* renamed from: a */
        private int f3965a;

        /* renamed from: b */
        private int f3966b;

        /* renamed from: c */
        OverScroller f3967c;

        /* renamed from: d */
        Interpolator f3968d;
        private boolean e;

        /* renamed from: f */
        private boolean f3969f;

        B() {
            Interpolator interpolator = RecyclerView.f3893G0;
            this.f3968d = interpolator;
            this.e = false;
            this.f3969f = false;
            this.f3967c = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        private int a(int i2, int i3, int i4, int i5) {
            int iRound;
            int iAbs = Math.abs(i2);
            int iAbs2 = Math.abs(i3);
            boolean z2 = iAbs > iAbs2;
            int iSqrt = (int) Math.sqrt((i4 * i4) + (i5 * i5));
            int iSqrt2 = (int) Math.sqrt((i2 * i2) + (i3 * i3));
            RecyclerView recyclerView = RecyclerView.this;
            int width = z2 ? recyclerView.getWidth() : recyclerView.getHeight();
            int i6 = width / 2;
            float f2 = width;
            float f3 = i6;
            float fC = f3 + (c(Math.min(1.0f, (iSqrt2 * 1.0f) / f2)) * f3);
            if (iSqrt > 0) {
                iRound = Math.round(Math.abs(fC / iSqrt) * 1000.0f) * 4;
            } else {
                if (!z2) {
                    iAbs = iAbs2;
                }
                iRound = (int) (((iAbs / f2) + 1.0f) * 300.0f);
            }
            return Math.min(iRound, 2000);
        }

        private void b() {
            this.f3969f = false;
            this.e = true;
        }

        private float c(float f2) {
            return (float) Math.sin((f2 - 0.5f) * 0.47123894f);
        }

        private void d() {
            this.e = false;
            if (this.f3969f) {
                f();
            }
        }

        public void e(int i2, int i3) {
            RecyclerView.this.setScrollState(2);
            this.f3966b = 0;
            this.f3965a = 0;
            this.f3967c.fling(0, 0, i2, i3, Target.SIZE_ORIGINAL, Integer.MAX_VALUE, Target.SIZE_ORIGINAL, Integer.MAX_VALUE);
            f();
        }

        void f() {
            if (this.e) {
                this.f3969f = true;
            } else {
                RecyclerView.this.removeCallbacks(this);
                M.a0(RecyclerView.this, this);
            }
        }

        public void g(int i2, int i3, int i4, Interpolator interpolator) {
            if (this.f3968d != interpolator) {
                this.f3968d = interpolator;
                this.f3967c = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.f3966b = 0;
            this.f3965a = 0;
            this.f3967c.startScroll(0, 0, i2, i3, i4);
            if (Build.VERSION.SDK_INT < 23) {
                this.f3967c.computeScrollOffset();
            }
            f();
        }

        public void h(int i2, int i3, Interpolator interpolator) {
            int iA = a(i2, i3, 0, 0);
            if (interpolator == null) {
                interpolator = RecyclerView.f3893G0;
            }
            g(i2, i3, iA, interpolator);
        }

        public void i() {
            RecyclerView.this.removeCallbacks(this);
            this.f3967c.abortAnimation();
        }

        /* JADX WARN: Removed duplicated region for block: B:121:0x00af  */
        /* JADX WARN: Removed duplicated region for block: B:123:0x00b2  */
        /* JADX WARN: Removed duplicated region for block: B:127:0x00b9  */
        /* JADX WARN: Removed duplicated region for block: B:130:0x00c2  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 345
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.B.run():void");
        }
    }

    public static abstract class C {
        private static final List s = Collections.emptyList();

        /* renamed from: a */
        public final View f3971a;

        /* renamed from: b */
        WeakReference f3972b;

        /* renamed from: j */
        int f3979j;
        RecyclerView r;

        /* renamed from: c */
        int f3973c = -1;

        /* renamed from: d */
        int f3974d = -1;
        long e = -1;

        /* renamed from: f */
        int f3975f = -1;

        /* renamed from: g */
        int f3976g = -1;

        /* renamed from: h */
        C f3977h = null;

        /* renamed from: i */
        C f3978i = null;

        /* renamed from: k */
        List f3980k = null;

        /* renamed from: l */
        List f3981l = null;

        /* renamed from: m */
        private int f3982m = 0;

        /* renamed from: n */
        v f3983n = null;
        boolean o = false;

        /* renamed from: p */
        private int f3984p = 0;

        /* renamed from: q */
        int f3985q = -1;

        public C(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.f3971a = view;
        }

        private void g() {
            if (this.f3980k == null) {
                ArrayList arrayList = new ArrayList();
                this.f3980k = arrayList;
                this.f3981l = Collections.unmodifiableList(arrayList);
            }
        }

        void A(RecyclerView recyclerView) {
            int i2 = this.f3985q;
            if (i2 != -1) {
                this.f3984p = i2;
            } else {
                this.f3984p = M.w(this.f3971a);
            }
            recyclerView.k1(this, 4);
        }

        void B(RecyclerView recyclerView) {
            recyclerView.k1(this, this.f3984p);
            this.f3984p = 0;
        }

        void C() {
            this.f3979j = 0;
            this.f3973c = -1;
            this.f3974d = -1;
            this.e = -1L;
            this.f3976g = -1;
            this.f3982m = 0;
            this.f3977h = null;
            this.f3978i = null;
            d();
            this.f3984p = 0;
            this.f3985q = -1;
            RecyclerView.s(this);
        }

        void D() {
            if (this.f3974d == -1) {
                this.f3974d = this.f3973c;
            }
        }

        void E(int i2, int i3) {
            this.f3979j = (i2 & i3) | (this.f3979j & (~i3));
        }

        public final void F(boolean z2) {
            int i2 = this.f3982m;
            int i3 = z2 ? i2 - 1 : i2 + 1;
            this.f3982m = i3;
            if (i3 < 0) {
                this.f3982m = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z2 && i3 == 1) {
                this.f3979j |= 16;
            } else if (z2 && i3 == 0) {
                this.f3979j &= -17;
            }
        }

        void G(v vVar, boolean z2) {
            this.f3983n = vVar;
            this.o = z2;
        }

        boolean H() {
            return (this.f3979j & 16) != 0;
        }

        boolean I() {
            return (this.f3979j & 128) != 0;
        }

        void J() {
            this.f3983n.J(this);
        }

        boolean K() {
            return (this.f3979j & 32) != 0;
        }

        void a(Object obj) {
            if (obj == null) {
                b(1024);
            } else if ((1024 & this.f3979j) == 0) {
                g();
                this.f3980k.add(obj);
            }
        }

        void b(int i2) {
            this.f3979j = i2 | this.f3979j;
        }

        void c() {
            this.f3974d = -1;
            this.f3976g = -1;
        }

        void d() {
            List list = this.f3980k;
            if (list != null) {
                list.clear();
            }
            this.f3979j &= -1025;
        }

        void e() {
            this.f3979j &= -33;
        }

        void f() {
            this.f3979j &= -257;
        }

        boolean h() {
            return (this.f3979j & 16) == 0 && M.L(this.f3971a);
        }

        void i(int i2, int i3, boolean z2) {
            b(8);
            z(i3, z2);
            this.f3973c = i2;
        }

        public final int j() {
            RecyclerView recyclerView = this.r;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.d0(this);
        }

        public final long k() {
            return this.e;
        }

        public final int l() {
            return this.f3975f;
        }

        public final int m() {
            int i2 = this.f3976g;
            return i2 == -1 ? this.f3973c : i2;
        }

        public final int n() {
            return this.f3974d;
        }

        List o() {
            if ((this.f3979j & 1024) != 0) {
                return s;
            }
            List list = this.f3980k;
            return (list == null || list.size() == 0) ? s : this.f3981l;
        }

        boolean p(int i2) {
            return (i2 & this.f3979j) != 0;
        }

        boolean q() {
            return (this.f3979j & 512) != 0 || s();
        }

        boolean r() {
            return (this.f3979j & 1) != 0;
        }

        boolean s() {
            return (this.f3979j & 4) != 0;
        }

        public final boolean t() {
            return (this.f3979j & 16) == 0 && !M.L(this.f3971a);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.f3973c + " id=" + this.e + ", oldPos=" + this.f3974d + ", pLpos:" + this.f3976g);
            if (v()) {
                sb.append(" scrap ");
                sb.append(this.o ? "[changeScrap]" : "[attachedScrap]");
            }
            if (s()) {
                sb.append(" invalid");
            }
            if (!r()) {
                sb.append(" unbound");
            }
            if (y()) {
                sb.append(" update");
            }
            if (u()) {
                sb.append(" removed");
            }
            if (I()) {
                sb.append(" ignored");
            }
            if (w()) {
                sb.append(" tmpDetached");
            }
            if (!t()) {
                sb.append(" not recyclable(" + this.f3982m + ")");
            }
            if (q()) {
                sb.append(" undefined adapter position");
            }
            if (this.f3971a.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        boolean u() {
            return (this.f3979j & 8) != 0;
        }

        boolean v() {
            return this.f3983n != null;
        }

        boolean w() {
            return (this.f3979j & 256) != 0;
        }

        boolean x() {
            return (this.f3979j & 2) != 0;
        }

        boolean y() {
            return (this.f3979j & 2) != 0;
        }

        void z(int i2, boolean z2) {
            if (this.f3974d == -1) {
                this.f3974d = this.f3973c;
            }
            if (this.f3976g == -1) {
                this.f3976g = this.f3973c;
            }
            if (z2) {
                this.f3976g += i2;
            }
            this.f3973c += i2;
            if (this.f3971a.getLayoutParams() != null) {
                ((p) this.f3971a.getLayoutParams()).f4026c = true;
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$a */
    class RunnableC0208a implements Runnable {
        RunnableC0208a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.f3954t || recyclerView.isLayoutRequested()) {
                return;
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            if (!recyclerView2.f3950q) {
                recyclerView2.requestLayout();
            } else if (recyclerView2.f3960w) {
                recyclerView2.f3958v = true;
            } else {
                recyclerView2.v();
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$b */
    class RunnableC0209b implements Runnable {
        RunnableC0209b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l lVar = RecyclerView.this.f3908L;
            if (lVar != null) {
                lVar.v();
            }
            RecyclerView.this.f3942l0 = false;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$c */
    static class InterpolatorC0210c implements Interpolator {
        InterpolatorC0210c() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    }

    class d implements p.b {
        d() {
        }

        @Override // androidx.recyclerview.widget.p.b
        public void a(C c2) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f3943m.k1(c2.f3971a, recyclerView.f3922b);
        }

        @Override // androidx.recyclerview.widget.p.b
        public void b(C c2, l.c cVar, l.c cVar2) {
            RecyclerView.this.m(c2, cVar, cVar2);
        }

        @Override // androidx.recyclerview.widget.p.b
        public void c(C c2, l.c cVar, l.c cVar2) {
            RecyclerView.this.f3922b.J(c2);
            RecyclerView.this.o(c2, cVar, cVar2);
        }

        @Override // androidx.recyclerview.widget.p.b
        public void d(C c2, l.c cVar, l.c cVar2) {
            c2.F(false);
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f3899C) {
                if (recyclerView.f3908L.b(c2, c2, cVar, cVar2)) {
                    RecyclerView.this.M0();
                }
            } else if (recyclerView.f3908L.d(c2, cVar, cVar2)) {
                RecyclerView.this.M0();
            }
        }
    }

    class e implements b.InterfaceC0051b {
        e() {
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0051b
        public View a(int i2) {
            return RecyclerView.this.getChildAt(i2);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0051b
        public void b(View view) {
            C cG0 = RecyclerView.g0(view);
            if (cG0 != null) {
                cG0.A(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0051b
        public void c(int i2) {
            View childAt = RecyclerView.this.getChildAt(i2);
            if (childAt != null) {
                RecyclerView.this.A(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i2);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0051b
        public void d() {
            int iK = k();
            for (int i2 = 0; i2 < iK; i2++) {
                View viewA = a(i2);
                RecyclerView.this.A(viewA);
                viewA.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0051b
        public C e(View view) {
            return RecyclerView.g0(view);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0051b
        public void f(int i2) {
            C cG0;
            View viewA = a(i2);
            if (viewA != null && (cG0 = RecyclerView.g0(viewA)) != null) {
                if (cG0.w() && !cG0.I()) {
                    throw new IllegalArgumentException("called detach on an already detached child " + cG0 + RecyclerView.this.R());
                }
                cG0.b(256);
            }
            RecyclerView.this.detachViewFromParent(i2);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0051b
        public void g(View view) {
            C cG0 = RecyclerView.g0(view);
            if (cG0 != null) {
                cG0.B(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0051b
        public void h(View view, int i2, ViewGroup.LayoutParams layoutParams) {
            C cG0 = RecyclerView.g0(view);
            if (cG0 != null) {
                if (!cG0.w() && !cG0.I()) {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + cG0 + RecyclerView.this.R());
                }
                cG0.f();
            }
            RecyclerView.this.attachViewToParent(view, i2, layoutParams);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0051b
        public void i(View view, int i2) {
            RecyclerView.this.addView(view, i2);
            RecyclerView.this.z(view);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0051b
        public int j(View view) {
            return RecyclerView.this.indexOfChild(view);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0051b
        public int k() {
            return RecyclerView.this.getChildCount();
        }
    }

    class f implements a.InterfaceC0050a {
        f() {
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0050a
        public void a(int i2, int i3) {
            RecyclerView.this.C0(i2, i3);
            RecyclerView.this.f3936i0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0050a
        public void b(a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0050a
        public C c(int i2) {
            C cB0 = RecyclerView.this.b0(i2, true);
            if (cB0 == null || RecyclerView.this.e.n(cB0.f3971a)) {
                return null;
            }
            return cB0;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0050a
        public void d(int i2, int i3) {
            RecyclerView.this.D0(i2, i3, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f3936i0 = true;
            recyclerView.f3930f0.f4046d += i3;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0050a
        public void e(int i2, int i3) {
            RecyclerView.this.D0(i2, i3, false);
            RecyclerView.this.f3936i0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0050a
        public void f(a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0050a
        public void g(int i2, int i3) {
            RecyclerView.this.B0(i2, i3);
            RecyclerView.this.f3936i0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0050a
        public void h(int i2, int i3, Object obj) {
            RecyclerView.this.u1(i2, i3, obj);
            RecyclerView.this.f3938j0 = true;
        }

        void i(a.b bVar) {
            int i2 = bVar.f4115a;
            if (i2 == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.f3943m.Q0(recyclerView, bVar.f4116b, bVar.f4118d);
                return;
            }
            if (i2 == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.f3943m.T0(recyclerView2, bVar.f4116b, bVar.f4118d);
            } else if (i2 == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.f3943m.V0(recyclerView3, bVar.f4116b, bVar.f4118d, bVar.f4117c);
            } else {
                if (i2 != 8) {
                    return;
                }
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.f3943m.S0(recyclerView4, bVar.f4116b, bVar.f4118d, 1);
            }
        }
    }

    public static abstract class g {

        /* renamed from: a */
        private final h f3991a = new h();

        /* renamed from: b */
        private boolean f3992b = false;

        public final void a(C c2, int i2) {
            c2.f3973c = i2;
            if (f()) {
                c2.e = d(i2);
            }
            c2.E(1, 519);
            androidx.core.os.o.a("RV OnBindView");
            l(c2, i2, c2.o());
            c2.d();
            ViewGroup.LayoutParams layoutParams = c2.f3971a.getLayoutParams();
            if (layoutParams instanceof p) {
                ((p) layoutParams).f4026c = true;
            }
            androidx.core.os.o.b();
        }

        public final C b(ViewGroup viewGroup, int i2) {
            try {
                androidx.core.os.o.a("RV CreateView");
                C cM = m(viewGroup, i2);
                if (cM.f3971a.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                cM.f3975f = i2;
                return cM;
            } finally {
                androidx.core.os.o.b();
            }
        }

        public abstract int c();

        public long d(int i2) {
            return -1L;
        }

        public int e(int i2) {
            return 0;
        }

        public final boolean f() {
            return this.f3992b;
        }

        public final void g() {
            this.f3991a.a();
        }

        public final void h(int i2, int i3) {
            this.f3991a.b(i2, i3);
        }

        public final void i(int i2) {
            this.f3991a.d(i2, 1);
        }

        public void j(RecyclerView recyclerView) {
        }

        public abstract void k(C c2, int i2);

        public void l(C c2, int i2, List list) {
            k(c2, i2);
        }

        public abstract C m(ViewGroup viewGroup, int i2);

        public void n(RecyclerView recyclerView) {
        }

        public boolean o(C c2) {
            return false;
        }

        public void p(C c2) {
        }

        public void q(C c2) {
        }

        public void r(C c2) {
        }

        public void s(i iVar) {
            this.f3991a.registerObserver(iVar);
        }

        public void t(i iVar) {
            this.f3991a.unregisterObserver(iVar);
        }
    }

    static class h extends Observable {
        h() {
        }

        public void a() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).a();
            }
        }

        public void b(int i2, int i3) {
            c(i2, i3, null);
        }

        public void c(int i2, int i3, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).b(i2, i3, obj);
            }
        }

        public void d(int i2, int i3) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).c(i2, i3);
            }
        }
    }

    public static abstract class i {
        public abstract void a();

        public abstract void b(int i2, int i3, Object obj);

        public abstract void c(int i2, int i3);
    }

    public interface j {
        int a(int i2, int i3);
    }

    public static class k {
        protected EdgeEffect a(RecyclerView recyclerView, int i2) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class l {

        /* renamed from: a */
        private b f3993a = null;

        /* renamed from: b */
        private ArrayList f3994b = new ArrayList();

        /* renamed from: c */
        private long f3995c = 120;

        /* renamed from: d */
        private long f3996d = 120;
        private long e = 250;

        /* renamed from: f */
        private long f3997f = 250;

        public interface a {
            void a();
        }

        interface b {
            void a(C c2);
        }

        public static class c {

            /* renamed from: a */
            public int f3998a;

            /* renamed from: b */
            public int f3999b;

            /* renamed from: c */
            public int f4000c;

            /* renamed from: d */
            public int f4001d;

            public c a(C c2) {
                return b(c2, 0);
            }

            public c b(C c2, int i2) {
                View view = c2.f3971a;
                this.f3998a = view.getLeft();
                this.f3999b = view.getTop();
                this.f4000c = view.getRight();
                this.f4001d = view.getBottom();
                return this;
            }
        }

        static int e(C c2) {
            int i2 = c2.f3979j;
            int i3 = i2 & 14;
            if (c2.s()) {
                return 4;
            }
            if ((i2 & 4) != 0) {
                return i3;
            }
            int iN = c2.n();
            int iJ = c2.j();
            return (iN == -1 || iJ == -1 || iN == iJ) ? i3 : i3 | 2048;
        }

        public abstract boolean a(C c2, c cVar, c cVar2);

        public abstract boolean b(C c2, C c3, c cVar, c cVar2);

        public abstract boolean c(C c2, c cVar, c cVar2);

        public abstract boolean d(C c2, c cVar, c cVar2);

        public abstract boolean f(C c2);

        public boolean g(C c2, List list) {
            return f(c2);
        }

        public final void h(C c2) {
            s(c2);
            b bVar = this.f3993a;
            if (bVar != null) {
                bVar.a(c2);
            }
        }

        public final void i() {
            if (this.f3994b.size() <= 0) {
                this.f3994b.clear();
            } else {
                F.a(this.f3994b.get(0));
                throw null;
            }
        }

        public abstract void j(C c2);

        public abstract void k();

        public long l() {
            return this.f3995c;
        }

        public long m() {
            return this.f3997f;
        }

        public long n() {
            return this.e;
        }

        public long o() {
            return this.f3996d;
        }

        public abstract boolean p();

        public final boolean q(a aVar) {
            boolean zP = p();
            if (aVar != null) {
                if (zP) {
                    this.f3994b.add(aVar);
                } else {
                    aVar.a();
                }
            }
            return zP;
        }

        public c r() {
            return new c();
        }

        public void s(C c2) {
        }

        public c t(z zVar, C c2) {
            return r().a(c2);
        }

        public c u(z zVar, C c2, int i2, List list) {
            return r().a(c2);
        }

        public abstract void v();

        void w(b bVar) {
            this.f3993a = bVar;
        }
    }

    private class m implements l.b {
        m() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l.b
        public void a(C c2) {
            c2.F(true);
            if (c2.f3977h != null && c2.f3978i == null) {
                c2.f3977h = null;
            }
            c2.f3978i = null;
            if (c2.H() || RecyclerView.this.V0(c2.f3971a) || !c2.w()) {
                return;
            }
            RecyclerView.this.removeDetachedView(c2.f3971a, false);
        }
    }

    public static abstract class n {
        public void f(Rect rect, int i2, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void g(Rect rect, View view, RecyclerView recyclerView, z zVar) {
            f(rect, ((p) view.getLayoutParams()).a(), recyclerView);
        }

        public void h(Canvas canvas, RecyclerView recyclerView) {
        }

        public void i(Canvas canvas, RecyclerView recyclerView, z zVar) {
            h(canvas, recyclerView);
        }

        public void j(Canvas canvas, RecyclerView recyclerView) {
        }

        public void k(Canvas canvas, RecyclerView recyclerView, z zVar) {
            j(canvas, recyclerView);
        }
    }

    public static abstract class o {

        /* renamed from: a */
        androidx.recyclerview.widget.b f4003a;

        /* renamed from: b */
        RecyclerView f4004b;

        /* renamed from: c */
        private final o.b f4005c;

        /* renamed from: d */
        private final o.b f4006d;
        androidx.recyclerview.widget.o e;

        /* renamed from: f */
        androidx.recyclerview.widget.o f4007f;

        /* renamed from: g */
        boolean f4008g;

        /* renamed from: h */
        boolean f4009h;

        /* renamed from: i */
        boolean f4010i;

        /* renamed from: j */
        private boolean f4011j;

        /* renamed from: k */
        private boolean f4012k;

        /* renamed from: l */
        int f4013l;

        /* renamed from: m */
        boolean f4014m;

        /* renamed from: n */
        private int f4015n;
        private int o;

        /* renamed from: p */
        private int f4016p;

        /* renamed from: q */
        private int f4017q;

        class a implements o.b {
            a() {
            }

            @Override // androidx.recyclerview.widget.o.b
            public View a(int i2) {
                return o.this.I(i2);
            }

            @Override // androidx.recyclerview.widget.o.b
            public int b() {
                return o.this.n0() - o.this.e0();
            }

            @Override // androidx.recyclerview.widget.o.b
            public int c() {
                return o.this.d0();
            }

            @Override // androidx.recyclerview.widget.o.b
            public int d(View view) {
                return o.this.T(view) + ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).rightMargin;
            }

            @Override // androidx.recyclerview.widget.o.b
            public int e(View view) {
                return o.this.Q(view) - ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).leftMargin;
            }
        }

        class b implements o.b {
            b() {
            }

            @Override // androidx.recyclerview.widget.o.b
            public View a(int i2) {
                return o.this.I(i2);
            }

            @Override // androidx.recyclerview.widget.o.b
            public int b() {
                return o.this.W() - o.this.c0();
            }

            @Override // androidx.recyclerview.widget.o.b
            public int c() {
                return o.this.f0();
            }

            @Override // androidx.recyclerview.widget.o.b
            public int d(View view) {
                return o.this.O(view) + ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).bottomMargin;
            }

            @Override // androidx.recyclerview.widget.o.b
            public int e(View view) {
                return o.this.U(view) - ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).topMargin;
            }
        }

        public interface c {
            void a(int i2, int i3);
        }

        public static class d {

            /* renamed from: a */
            public int f4020a;

            /* renamed from: b */
            public int f4021b;

            /* renamed from: c */
            public boolean f4022c;

            /* renamed from: d */
            public boolean f4023d;
        }

        public o() {
            a aVar = new a();
            this.f4005c = aVar;
            b bVar = new b();
            this.f4006d = bVar;
            this.e = new androidx.recyclerview.widget.o(aVar);
            this.f4007f = new androidx.recyclerview.widget.o(bVar);
            this.f4008g = false;
            this.f4009h = false;
            this.f4010i = false;
            this.f4011j = true;
            this.f4012k = true;
        }

        public static int K(int i2, int i3, int i4, int i5, boolean z2) {
            int iMax = Math.max(0, i2 - i4);
            if (z2) {
                if (i5 < 0) {
                    if (i5 != -1 || (i3 != Integer.MIN_VALUE && (i3 == 0 || i3 != 1073741824))) {
                        i3 = 0;
                        i5 = 0;
                    } else {
                        i5 = iMax;
                    }
                }
                i3 = 1073741824;
            } else {
                if (i5 < 0) {
                    if (i5 != -1) {
                        if (i5 == -2) {
                            i3 = (i3 == Integer.MIN_VALUE || i3 == 1073741824) ? Target.SIZE_ORIGINAL : 0;
                        }
                        i3 = 0;
                        i5 = 0;
                    }
                    i5 = iMax;
                }
                i3 = 1073741824;
            }
            return View.MeasureSpec.makeMeasureSpec(i5, i3);
        }

        private int[] L(RecyclerView recyclerView, View view, Rect rect, boolean z2) {
            int iD0 = d0();
            int iF0 = f0();
            int iN0 = n0() - e0();
            int iW = W() - c0();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = rect.width() + left;
            int iHeight = rect.height() + top;
            int i2 = left - iD0;
            int iMin = Math.min(0, i2);
            int i3 = top - iF0;
            int iMin2 = Math.min(0, i3);
            int i4 = iWidth - iN0;
            int iMax = Math.max(0, i4);
            int iMax2 = Math.max(0, iHeight - iW);
            if (Y() != 1) {
                if (iMin == 0) {
                    iMin = Math.min(i2, iMax);
                }
                iMax = iMin;
            } else if (iMax == 0) {
                iMax = Math.max(iMin, i4);
            }
            if (iMin2 == 0) {
                iMin2 = Math.min(i3, iMax2);
            }
            return new int[]{iMax, iMin2};
        }

        private void f(View view, int i2, boolean z2) {
            C cG0 = RecyclerView.g0(view);
            if (z2 || cG0.u()) {
                this.f4004b.f3929f.b(cG0);
            } else {
                this.f4004b.f3929f.p(cG0);
            }
            p pVar = (p) view.getLayoutParams();
            if (cG0.K() || cG0.v()) {
                if (cG0.v()) {
                    cG0.J();
                } else {
                    cG0.e();
                }
                this.f4003a.c(view, i2, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f4004b) {
                int iM = this.f4003a.m(view);
                if (i2 == -1) {
                    i2 = this.f4003a.g();
                }
                if (iM == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f4004b.indexOfChild(view) + this.f4004b.R());
                }
                if (iM != i2) {
                    this.f4004b.f3943m.A0(iM, i2);
                }
            } else {
                this.f4003a.a(view, i2, false);
                pVar.f4026c = true;
            }
            if (pVar.f4027d) {
                cG0.f3971a.invalidate();
                pVar.f4027d = false;
            }
        }

        public static d h0(Context context, AttributeSet attributeSet, int i2, int i3) {
            d dVar = new d();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, K.c.f261h, i2, i3);
            dVar.f4020a = typedArrayObtainStyledAttributes.getInt(K.c.f262i, 1);
            dVar.f4021b = typedArrayObtainStyledAttributes.getInt(K.c.r, 1);
            dVar.f4022c = typedArrayObtainStyledAttributes.getBoolean(K.c.f269q, false);
            dVar.f4023d = typedArrayObtainStyledAttributes.getBoolean(K.c.s, false);
            typedArrayObtainStyledAttributes.recycle();
            return dVar;
        }

        public static int n(int i2, int i3, int i4) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i3, i4) : size : Math.min(size, Math.max(i3, i4));
        }

        private boolean s0(RecyclerView recyclerView, int i2, int i3) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int iD0 = d0();
            int iF0 = f0();
            int iN0 = n0() - e0();
            int iW = W() - c0();
            Rect rect = this.f4004b.f3935i;
            P(focusedChild, rect);
            return rect.left - i2 < iN0 && rect.right - i2 > iD0 && rect.top - i3 < iW && rect.bottom - i3 > iF0;
        }

        private void t1(v vVar, int i2, View view) {
            C cG0 = RecyclerView.g0(view);
            if (cG0.I()) {
                return;
            }
            if (cG0.s() && !cG0.u() && !this.f4004b.f3941l.f()) {
                o1(i2);
                vVar.C(cG0);
            } else {
                x(i2);
                vVar.D(view);
                this.f4004b.f3929f.k(cG0);
            }
        }

        private static boolean v0(int i2, int i3, int i4) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            if (i4 > 0 && i2 != i4) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i2;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i2;
            }
            return true;
        }

        private void y(int i2, View view) {
            this.f4003a.d(i2);
        }

        void A(RecyclerView recyclerView, v vVar) {
            this.f4009h = false;
            H0(recyclerView, vVar);
        }

        public void A0(int i2, int i3) {
            View viewI = I(i2);
            if (viewI != null) {
                x(i2);
                h(viewI, i3);
            } else {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i2 + this.f4004b.toString());
            }
        }

        public void A1(Rect rect, int i2, int i3) {
            z1(n(i2, rect.width() + d0() + e0(), b0()), n(i3, rect.height() + f0() + c0(), a0()));
        }

        public View B(View view) {
            View viewU;
            RecyclerView recyclerView = this.f4004b;
            if (recyclerView == null || (viewU = recyclerView.U(view)) == null || this.f4003a.n(viewU)) {
                return null;
            }
            return viewU;
        }

        public void B0(int i2) {
            RecyclerView recyclerView = this.f4004b;
            if (recyclerView != null) {
                recyclerView.z0(i2);
            }
        }

        void B1(int i2, int i3) {
            int iJ = J();
            if (iJ == 0) {
                this.f4004b.x(i2, i3);
                return;
            }
            int i4 = Target.SIZE_ORIGINAL;
            int i5 = Target.SIZE_ORIGINAL;
            int i6 = Integer.MAX_VALUE;
            int i7 = Integer.MAX_VALUE;
            for (int i8 = 0; i8 < iJ; i8++) {
                View viewI = I(i8);
                Rect rect = this.f4004b.f3935i;
                P(viewI, rect);
                int i9 = rect.left;
                if (i9 < i6) {
                    i6 = i9;
                }
                int i10 = rect.right;
                if (i10 > i4) {
                    i4 = i10;
                }
                int i11 = rect.top;
                if (i11 < i7) {
                    i7 = i11;
                }
                int i12 = rect.bottom;
                if (i12 > i5) {
                    i5 = i12;
                }
            }
            this.f4004b.f3935i.set(i6, i7, i4, i5);
            A1(this.f4004b.f3935i, i2, i3);
        }

        public View C(int i2) {
            int iJ = J();
            for (int i3 = 0; i3 < iJ; i3++) {
                View viewI = I(i3);
                C cG0 = RecyclerView.g0(viewI);
                if (cG0 != null && cG0.m() == i2 && !cG0.I() && (this.f4004b.f3930f0.e() || !cG0.u())) {
                    return viewI;
                }
            }
            return null;
        }

        public void C0(int i2) {
            RecyclerView recyclerView = this.f4004b;
            if (recyclerView != null) {
                recyclerView.A0(i2);
            }
        }

        void C1(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f4004b = null;
                this.f4003a = null;
                this.f4016p = 0;
                this.f4017q = 0;
            } else {
                this.f4004b = recyclerView;
                this.f4003a = recyclerView.e;
                this.f4016p = recyclerView.getWidth();
                this.f4017q = recyclerView.getHeight();
            }
            this.f4015n = 1073741824;
            this.o = 1073741824;
        }

        public abstract p D();

        public void D0(g gVar, g gVar2) {
        }

        boolean D1(View view, int i2, int i3, p pVar) {
            return (!view.isLayoutRequested() && this.f4011j && v0(view.getWidth(), i2, ((ViewGroup.MarginLayoutParams) pVar).width) && v0(view.getHeight(), i3, ((ViewGroup.MarginLayoutParams) pVar).height)) ? false : true;
        }

        public p E(Context context, AttributeSet attributeSet) {
            return new p(context, attributeSet);
        }

        public boolean E0(RecyclerView recyclerView, ArrayList arrayList, int i2, int i3) {
            return false;
        }

        boolean E1() {
            return false;
        }

        public p F(ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof p ? new p((p) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new p((ViewGroup.MarginLayoutParams) layoutParams) : new p(layoutParams);
        }

        public void F0(RecyclerView recyclerView) {
        }

        boolean F1(View view, int i2, int i3, p pVar) {
            return (this.f4011j && v0(view.getMeasuredWidth(), i2, ((ViewGroup.MarginLayoutParams) pVar).width) && v0(view.getMeasuredHeight(), i3, ((ViewGroup.MarginLayoutParams) pVar).height)) ? false : true;
        }

        public int G() {
            return -1;
        }

        public void G0(RecyclerView recyclerView) {
        }

        void G1() {
        }

        public int H(View view) {
            return ((p) view.getLayoutParams()).f4025b.bottom;
        }

        public void H0(RecyclerView recyclerView, v vVar) {
            G0(recyclerView);
        }

        public abstract boolean H1();

        public View I(int i2) {
            androidx.recyclerview.widget.b bVar = this.f4003a;
            if (bVar != null) {
                return bVar.f(i2);
            }
            return null;
        }

        public abstract View I0(View view, int i2, v vVar, z zVar);

        public int J() {
            androidx.recyclerview.widget.b bVar = this.f4003a;
            if (bVar != null) {
                return bVar.g();
            }
            return 0;
        }

        public void J0(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f4004b;
            K0(recyclerView.f3922b, recyclerView.f3930f0, accessibilityEvent);
        }

        public void K0(v vVar, z zVar, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f4004b;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z2 = true;
            if (!recyclerView.canScrollVertically(1) && !this.f4004b.canScrollVertically(-1) && !this.f4004b.canScrollHorizontally(-1) && !this.f4004b.canScrollHorizontally(1)) {
                z2 = false;
            }
            accessibilityEvent.setScrollable(z2);
            g gVar = this.f4004b.f3941l;
            if (gVar != null) {
                accessibilityEvent.setItemCount(gVar.c());
            }
        }

        public void L0(v vVar, z zVar, C0353E c0353e) {
            if (this.f4004b.canScrollVertically(-1) || this.f4004b.canScrollHorizontally(-1)) {
                c0353e.a(8192);
                c0353e.e0(true);
            }
            if (this.f4004b.canScrollVertically(1) || this.f4004b.canScrollHorizontally(1)) {
                c0353e.a(4096);
                c0353e.e0(true);
            }
            c0353e.Z(C0353E.e.a(j0(vVar, zVar), N(vVar, zVar), u0(vVar, zVar), k0(vVar, zVar)));
        }

        public boolean M() {
            RecyclerView recyclerView = this.f4004b;
            return recyclerView != null && recyclerView.f3931g;
        }

        void M0(C0353E c0353e) {
            RecyclerView recyclerView = this.f4004b;
            L0(recyclerView.f3922b, recyclerView.f3930f0, c0353e);
        }

        public int N(v vVar, z zVar) {
            RecyclerView recyclerView = this.f4004b;
            if (recyclerView == null || recyclerView.f3941l == null || !k()) {
                return 1;
            }
            return this.f4004b.f3941l.c();
        }

        void N0(View view, C0353E c0353e) {
            C cG0 = RecyclerView.g0(view);
            if (cG0 == null || cG0.u() || this.f4003a.n(cG0.f3971a)) {
                return;
            }
            RecyclerView recyclerView = this.f4004b;
            O0(recyclerView.f3922b, recyclerView.f3930f0, view, c0353e);
        }

        public int O(View view) {
            return view.getBottom() + H(view);
        }

        public void O0(v vVar, z zVar, View view, C0353E c0353e) {
            c0353e.a0(C0353E.f.a(l() ? g0(view) : 0, 1, k() ? g0(view) : 0, 1, false, false));
        }

        public void P(View view, Rect rect) {
            RecyclerView.h0(view, rect);
        }

        public View P0(View view, int i2) {
            return null;
        }

        public int Q(View view) {
            return view.getLeft() - Z(view);
        }

        public void Q0(RecyclerView recyclerView, int i2, int i3) {
        }

        public int R(View view) {
            Rect rect = ((p) view.getLayoutParams()).f4025b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void R0(RecyclerView recyclerView) {
        }

        public int S(View view) {
            Rect rect = ((p) view.getLayoutParams()).f4025b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public void S0(RecyclerView recyclerView, int i2, int i3, int i4) {
        }

        public int T(View view) {
            return view.getRight() + i0(view);
        }

        public void T0(RecyclerView recyclerView, int i2, int i3) {
        }

        public int U(View view) {
            return view.getTop() - l0(view);
        }

        public void U0(RecyclerView recyclerView, int i2, int i3) {
        }

        public View V() {
            View focusedChild;
            RecyclerView recyclerView = this.f4004b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f4003a.n(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public void V0(RecyclerView recyclerView, int i2, int i3, Object obj) {
            U0(recyclerView, i2, i3);
        }

        public int W() {
            return this.f4017q;
        }

        public abstract void W0(v vVar, z zVar);

        public int X() {
            return this.o;
        }

        public void X0(z zVar) {
        }

        public int Y() {
            return M.y(this.f4004b);
        }

        public void Y0(v vVar, z zVar, int i2, int i3) {
            this.f4004b.x(i2, i3);
        }

        public int Z(View view) {
            return ((p) view.getLayoutParams()).f4025b.left;
        }

        public boolean Z0(RecyclerView recyclerView, View view, View view2) {
            return w0() || recyclerView.v0();
        }

        public int a0() {
            return M.z(this.f4004b);
        }

        public boolean a1(RecyclerView recyclerView, z zVar, View view, View view2) {
            return Z0(recyclerView, view, view2);
        }

        public void b(View view) {
            c(view, -1);
        }

        public int b0() {
            return M.A(this.f4004b);
        }

        public abstract void b1(Parcelable parcelable);

        public void c(View view, int i2) {
            f(view, i2, true);
        }

        public int c0() {
            RecyclerView recyclerView = this.f4004b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public abstract Parcelable c1();

        public void d(View view) {
            e(view, -1);
        }

        public int d0() {
            RecyclerView recyclerView = this.f4004b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public void d1(int i2) {
        }

        public void e(View view, int i2) {
            f(view, i2, false);
        }

        public int e0() {
            RecyclerView recyclerView = this.f4004b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        boolean e1(int i2, Bundle bundle) {
            RecyclerView recyclerView = this.f4004b;
            return f1(recyclerView.f3922b, recyclerView.f3930f0, i2, bundle);
        }

        public int f0() {
            RecyclerView recyclerView = this.f4004b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public boolean f1(v vVar, z zVar, int i2, Bundle bundle) {
            int iW;
            int iN0;
            RecyclerView recyclerView = this.f4004b;
            if (recyclerView == null) {
                return false;
            }
            if (i2 != 4096) {
                if (i2 != 8192) {
                    iW = 0;
                } else {
                    iW = recyclerView.canScrollVertically(-1) ? -((W() - f0()) - c0()) : 0;
                    if (this.f4004b.canScrollHorizontally(-1)) {
                        iN0 = -((n0() - d0()) - e0());
                    }
                }
            } else {
                iW = recyclerView.canScrollVertically(1) ? (W() - f0()) - c0() : 0;
                iN0 = this.f4004b.canScrollHorizontally(1) ? (n0() - d0()) - e0() : 0;
            }
            if (iW == 0 && iN0 == 0) {
                return false;
            }
            this.f4004b.m1(iN0, iW);
            return true;
        }

        public void g(String str) {
            RecyclerView recyclerView = this.f4004b;
            if (recyclerView != null) {
                recyclerView.p(str);
            }
        }

        public int g0(View view) {
            return ((p) view.getLayoutParams()).a();
        }

        boolean g1(View view, int i2, Bundle bundle) {
            RecyclerView recyclerView = this.f4004b;
            return h1(recyclerView.f3922b, recyclerView.f3930f0, view, i2, bundle);
        }

        public void h(View view, int i2) {
            i(view, i2, (p) view.getLayoutParams());
        }

        public boolean h1(v vVar, z zVar, View view, int i2, Bundle bundle) {
            return false;
        }

        public void i(View view, int i2, p pVar) {
            C cG0 = RecyclerView.g0(view);
            if (cG0.u()) {
                this.f4004b.f3929f.b(cG0);
            } else {
                this.f4004b.f3929f.p(cG0);
            }
            this.f4003a.c(view, i2, pVar, cG0.u());
        }

        public int i0(View view) {
            return ((p) view.getLayoutParams()).f4025b.right;
        }

        public void i1(v vVar) {
            for (int iJ = J() - 1; iJ >= 0; iJ--) {
                if (!RecyclerView.g0(I(iJ)).I()) {
                    l1(iJ, vVar);
                }
            }
        }

        public void j(View view, Rect rect) {
            RecyclerView recyclerView = this.f4004b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.k0(view));
            }
        }

        public int j0(v vVar, z zVar) {
            RecyclerView recyclerView = this.f4004b;
            if (recyclerView == null || recyclerView.f3941l == null || !l()) {
                return 1;
            }
            return this.f4004b.f3941l.c();
        }

        void j1(v vVar) {
            int iJ = vVar.j();
            for (int i2 = iJ - 1; i2 >= 0; i2--) {
                View viewN = vVar.n(i2);
                C cG0 = RecyclerView.g0(viewN);
                if (!cG0.I()) {
                    cG0.F(false);
                    if (cG0.w()) {
                        this.f4004b.removeDetachedView(viewN, false);
                    }
                    l lVar = this.f4004b.f3908L;
                    if (lVar != null) {
                        lVar.j(cG0);
                    }
                    cG0.F(true);
                    vVar.y(viewN);
                }
            }
            vVar.e();
            if (iJ > 0) {
                this.f4004b.invalidate();
            }
        }

        public abstract boolean k();

        public int k0(v vVar, z zVar) {
            return 0;
        }

        public void k1(View view, v vVar) {
            n1(view);
            vVar.B(view);
        }

        public abstract boolean l();

        public int l0(View view) {
            return ((p) view.getLayoutParams()).f4025b.top;
        }

        public void l1(int i2, v vVar) {
            View viewI = I(i2);
            o1(i2);
            vVar.B(viewI);
        }

        public boolean m(p pVar) {
            return pVar != null;
        }

        public void m0(View view, boolean z2, Rect rect) {
            Matrix matrix;
            if (z2) {
                Rect rect2 = ((p) view.getLayoutParams()).f4025b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.f4004b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.f4004b.f3939k;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public boolean m1(Runnable runnable) {
            RecyclerView recyclerView = this.f4004b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public int n0() {
            return this.f4016p;
        }

        public void n1(View view) {
            this.f4003a.p(view);
        }

        public abstract void o(int i2, int i3, z zVar, c cVar);

        public int o0() {
            return this.f4015n;
        }

        public void o1(int i2) {
            if (I(i2) != null) {
                this.f4003a.q(i2);
            }
        }

        public void p(int i2, c cVar) {
        }

        boolean p0() {
            int iJ = J();
            for (int i2 = 0; i2 < iJ; i2++) {
                ViewGroup.LayoutParams layoutParams = I(i2).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public boolean p1(RecyclerView recyclerView, View view, Rect rect, boolean z2) {
            return q1(recyclerView, view, rect, z2, false);
        }

        public abstract int q(z zVar);

        public boolean q0() {
            return this.f4009h;
        }

        public boolean q1(RecyclerView recyclerView, View view, Rect rect, boolean z2, boolean z3) {
            int[] iArrL = L(recyclerView, view, rect, z2);
            int i2 = iArrL[0];
            int i3 = iArrL[1];
            if ((z3 && !s0(recyclerView, i2, i3)) || (i2 == 0 && i3 == 0)) {
                return false;
            }
            if (z2) {
                recyclerView.scrollBy(i2, i3);
            } else {
                recyclerView.m1(i2, i3);
            }
            return true;
        }

        public abstract int r(z zVar);

        public abstract boolean r0();

        public void r1() {
            RecyclerView recyclerView = this.f4004b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public abstract int s(z zVar);

        public void s1() {
            this.f4008g = true;
        }

        public abstract int t(z zVar);

        public final boolean t0() {
            return this.f4012k;
        }

        public abstract int u(z zVar);

        public boolean u0(v vVar, z zVar) {
            return false;
        }

        public abstract int u1(int i2, v vVar, z zVar);

        public abstract int v(z zVar);

        public abstract void v1(int i2);

        public void w(v vVar) {
            for (int iJ = J() - 1; iJ >= 0; iJ--) {
                t1(vVar, iJ, I(iJ));
            }
        }

        public boolean w0() {
            return false;
        }

        public abstract int w1(int i2, v vVar, z zVar);

        public void x(int i2) {
            y(i2, I(i2));
        }

        public boolean x0(View view, boolean z2, boolean z3) {
            boolean z4 = this.e.b(view, 24579) && this.f4007f.b(view, 24579);
            return z2 ? z4 : !z4;
        }

        void x1(RecyclerView recyclerView) {
            y1(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public void y0(View view, int i2, int i3, int i4, int i5) {
            p pVar = (p) view.getLayoutParams();
            Rect rect = pVar.f4025b;
            view.layout(i2 + rect.left + ((ViewGroup.MarginLayoutParams) pVar).leftMargin, i3 + rect.top + ((ViewGroup.MarginLayoutParams) pVar).topMargin, (i4 - rect.right) - ((ViewGroup.MarginLayoutParams) pVar).rightMargin, (i5 - rect.bottom) - ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
        }

        void y1(int i2, int i3) {
            this.f4016p = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            this.f4015n = mode;
            if (mode == 0 && !RecyclerView.f3887A0) {
                this.f4016p = 0;
            }
            this.f4017q = View.MeasureSpec.getSize(i3);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.o = mode2;
            if (mode2 != 0 || RecyclerView.f3887A0) {
                return;
            }
            this.f4017q = 0;
        }

        void z(RecyclerView recyclerView) {
            this.f4009h = true;
            F0(recyclerView);
        }

        public void z0(View view, int i2, int i3) {
            p pVar = (p) view.getLayoutParams();
            Rect rectK0 = this.f4004b.k0(view);
            int i4 = i2 + rectK0.left + rectK0.right;
            int i5 = i3 + rectK0.top + rectK0.bottom;
            int iK = K(n0(), o0(), d0() + e0() + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin + i4, ((ViewGroup.MarginLayoutParams) pVar).width, k());
            int iK2 = K(W(), X(), f0() + c0() + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin + i5, ((ViewGroup.MarginLayoutParams) pVar).height, l());
            if (D1(view, iK, iK2, pVar)) {
                view.measure(iK, iK2);
            }
        }

        public void z1(int i2, int i3) {
            this.f4004b.setMeasuredDimension(i2, i3);
        }
    }

    public interface q {
        void c(View view);

        void d(View view);
    }

    public static abstract class r {
    }

    public interface s {
        boolean a(RecyclerView recyclerView, MotionEvent motionEvent);

        void b(RecyclerView recyclerView, MotionEvent motionEvent);

        void e(boolean z2);
    }

    public static abstract class t {
        public void a(RecyclerView recyclerView, int i2) {
        }

        public abstract void b(RecyclerView recyclerView, int i2, int i3);
    }

    public static class u {

        /* renamed from: a */
        SparseArray f4028a = new SparseArray();

        /* renamed from: b */
        private int f4029b = 0;

        static class a {

            /* renamed from: a */
            final ArrayList f4030a = new ArrayList();

            /* renamed from: b */
            int f4031b = 5;

            /* renamed from: c */
            long f4032c = 0;

            /* renamed from: d */
            long f4033d = 0;

            a() {
            }
        }

        private a g(int i2) {
            a aVar = (a) this.f4028a.get(i2);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.f4028a.put(i2, aVar2);
            return aVar2;
        }

        void a() {
            this.f4029b++;
        }

        public void b() {
            for (int i2 = 0; i2 < this.f4028a.size(); i2++) {
                ((a) this.f4028a.valueAt(i2)).f4030a.clear();
            }
        }

        void c() {
            this.f4029b--;
        }

        void d(int i2, long j2) {
            a aVarG = g(i2);
            aVarG.f4033d = j(aVarG.f4033d, j2);
        }

        void e(int i2, long j2) {
            a aVarG = g(i2);
            aVarG.f4032c = j(aVarG.f4032c, j2);
        }

        public C f(int i2) {
            a aVar = (a) this.f4028a.get(i2);
            if (aVar == null || aVar.f4030a.isEmpty()) {
                return null;
            }
            return (C) aVar.f4030a.remove(r2.size() - 1);
        }

        void h(g gVar, g gVar2, boolean z2) {
            if (gVar != null) {
                c();
            }
            if (!z2 && this.f4029b == 0) {
                b();
            }
            if (gVar2 != null) {
                a();
            }
        }

        public void i(C c2) {
            int iL = c2.l();
            ArrayList arrayList = g(iL).f4030a;
            if (((a) this.f4028a.get(iL)).f4031b <= arrayList.size()) {
                return;
            }
            c2.C();
            arrayList.add(c2);
        }

        long j(long j2, long j3) {
            return j2 == 0 ? j3 : ((j2 / 4) * 3) + (j3 / 4);
        }

        boolean k(int i2, long j2, long j3) {
            long j4 = g(i2).f4033d;
            return j4 == 0 || j2 + j4 < j3;
        }

        boolean l(int i2, long j2, long j3) {
            long j4 = g(i2).f4032c;
            return j4 == 0 || j2 + j4 < j3;
        }
    }

    public final class v {

        /* renamed from: a */
        final ArrayList f4034a;

        /* renamed from: b */
        ArrayList f4035b;

        /* renamed from: c */
        final ArrayList f4036c;

        /* renamed from: d */
        private final List f4037d;
        private int e;

        /* renamed from: f */
        int f4038f;

        /* renamed from: g */
        u f4039g;

        public v() {
            ArrayList arrayList = new ArrayList();
            this.f4034a = arrayList;
            this.f4035b = null;
            this.f4036c = new ArrayList();
            this.f4037d = Collections.unmodifiableList(arrayList);
            this.e = 2;
            this.f4038f = 2;
        }

        private boolean H(C c2, int i2, int i3, long j2) {
            c2.r = RecyclerView.this;
            int iL = c2.l();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j2 != Long.MAX_VALUE && !this.f4039g.k(iL, nanoTime, j2)) {
                return false;
            }
            RecyclerView.this.f3941l.a(c2, i2);
            this.f4039g.d(c2.l(), RecyclerView.this.getNanoTime() - nanoTime);
            b(c2);
            if (!RecyclerView.this.f3930f0.e()) {
                return true;
            }
            c2.f3976g = i3;
            return true;
        }

        private void b(C c2) {
            if (RecyclerView.this.u0()) {
                View view = c2.f3971a;
                if (M.w(view) == 0) {
                    M.p0(view, 1);
                }
                if (M.J(view)) {
                    return;
                }
                c2.b(16384);
                M.f0(view, RecyclerView.this.f3944m0.n());
            }
        }

        private void q(ViewGroup viewGroup, boolean z2) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    q((ViewGroup) childAt, true);
                }
            }
            if (z2) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        private void r(C c2) {
            View view = c2.f3971a;
            if (view instanceof ViewGroup) {
                q((ViewGroup) view, false);
            }
        }

        void A(int i2) {
            a((C) this.f4036c.get(i2), true);
            this.f4036c.remove(i2);
        }

        public void B(View view) {
            C cG0 = RecyclerView.g0(view);
            if (cG0.w()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (cG0.v()) {
                cG0.J();
            } else if (cG0.K()) {
                cG0.e();
            }
            C(cG0);
        }

        void C(C c2) {
            boolean z2;
            boolean z3 = true;
            if (c2.v() || c2.f3971a.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(c2.v());
                sb.append(" isAttached:");
                sb.append(c2.f3971a.getParent() != null);
                sb.append(RecyclerView.this.R());
                throw new IllegalArgumentException(sb.toString());
            }
            if (c2.w()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + c2 + RecyclerView.this.R());
            }
            if (c2.I()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.R());
            }
            boolean zH = c2.h();
            g gVar = RecyclerView.this.f3941l;
            if ((gVar != null && zH && gVar.o(c2)) || c2.t()) {
                if (this.f4038f <= 0 || c2.p(526)) {
                    z2 = false;
                } else {
                    int size = this.f4036c.size();
                    if (size >= this.f4038f && size > 0) {
                        A(0);
                        size--;
                    }
                    if (RecyclerView.f3889C0 && size > 0 && !RecyclerView.this.f3928e0.d(c2.f3973c)) {
                        int i2 = size - 1;
                        while (i2 >= 0) {
                            if (!RecyclerView.this.f3928e0.d(((C) this.f4036c.get(i2)).f3973c)) {
                                break;
                            } else {
                                i2--;
                            }
                        }
                        size = i2 + 1;
                    }
                    this.f4036c.add(size, c2);
                    z2 = true;
                }
                if (z2) {
                    z = z2;
                    z3 = false;
                } else {
                    a(c2, true);
                    z = z2;
                }
            } else {
                z3 = false;
            }
            RecyclerView.this.f3929f.q(c2);
            if (z || z3 || !zH) {
                return;
            }
            c2.r = null;
        }

        void D(View view) {
            C cG0 = RecyclerView.g0(view);
            if (!cG0.p(12) && cG0.x() && !RecyclerView.this.q(cG0)) {
                if (this.f4035b == null) {
                    this.f4035b = new ArrayList();
                }
                cG0.G(this, true);
                this.f4035b.add(cG0);
                return;
            }
            if (!cG0.s() || cG0.u() || RecyclerView.this.f3941l.f()) {
                cG0.G(this, false);
                this.f4034a.add(cG0);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.R());
            }
        }

        void E(u uVar) {
            u uVar2 = this.f4039g;
            if (uVar2 != null) {
                uVar2.c();
            }
            this.f4039g = uVar;
            if (uVar == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.f4039g.a();
        }

        void F(A a2) {
        }

        public void G(int i2) {
            this.e = i2;
            K();
        }

        /* JADX WARN: Removed duplicated region for block: B:117:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:126:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:128:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:157:0x00f5 A[PHI: r1 r4
  0x00f5: PHI (r1v12 androidx.recyclerview.widget.RecyclerView$C) = (r1v11 androidx.recyclerview.widget.RecyclerView$C), (r1v30 androidx.recyclerview.widget.RecyclerView$C) binds: [B:127:0x005d, B:144:0x00ad] A[DONT_GENERATE, DONT_INLINE]
  0x00f5: PHI (r4v3 boolean) = (r4v2 boolean), (r4v7 boolean) binds: [B:127:0x005d, B:144:0x00ad] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:167:0x0153  */
        /* JADX WARN: Removed duplicated region for block: B:173:0x017f  */
        /* JADX WARN: Removed duplicated region for block: B:184:0x01af  */
        /* JADX WARN: Removed duplicated region for block: B:185:0x01bd  */
        /* JADX WARN: Removed duplicated region for block: B:191:0x01d9 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:193:0x01dc  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        androidx.recyclerview.widget.RecyclerView.C I(int r17, boolean r18, long r19) {
            /*
                Method dump skipped, instructions count: 536
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.v.I(int, boolean, long):androidx.recyclerview.widget.RecyclerView$C");
        }

        void J(C c2) {
            if (c2.o) {
                this.f4035b.remove(c2);
            } else {
                this.f4034a.remove(c2);
            }
            c2.f3983n = null;
            c2.o = false;
            c2.e();
        }

        void K() {
            o oVar = RecyclerView.this.f3943m;
            this.f4038f = this.e + (oVar != null ? oVar.f4013l : 0);
            for (int size = this.f4036c.size() - 1; size >= 0 && this.f4036c.size() > this.f4038f; size--) {
                A(size);
            }
        }

        boolean L(C c2) {
            if (c2.u()) {
                return RecyclerView.this.f3930f0.e();
            }
            int i2 = c2.f3973c;
            if (i2 >= 0 && i2 < RecyclerView.this.f3941l.c()) {
                if (RecyclerView.this.f3930f0.e() || RecyclerView.this.f3941l.e(c2.f3973c) == c2.l()) {
                    return !RecyclerView.this.f3941l.f() || c2.k() == RecyclerView.this.f3941l.d(c2.f3973c);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + c2 + RecyclerView.this.R());
        }

        void M(int i2, int i3) {
            int i4;
            int i5 = i3 + i2;
            for (int size = this.f4036c.size() - 1; size >= 0; size--) {
                C c2 = (C) this.f4036c.get(size);
                if (c2 != null && (i4 = c2.f3973c) >= i2 && i4 < i5) {
                    c2.b(2);
                    A(size);
                }
            }
        }

        void a(C c2, boolean z2) {
            RecyclerView.s(c2);
            if (c2.p(16384)) {
                c2.E(0, 16384);
                M.f0(c2.f3971a, null);
            }
            if (z2) {
                g(c2);
            }
            c2.r = null;
            i().i(c2);
        }

        public void c() {
            this.f4034a.clear();
            z();
        }

        void d() {
            int size = this.f4036c.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((C) this.f4036c.get(i2)).c();
            }
            int size2 = this.f4034a.size();
            for (int i3 = 0; i3 < size2; i3++) {
                ((C) this.f4034a.get(i3)).c();
            }
            ArrayList arrayList = this.f4035b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i4 = 0; i4 < size3; i4++) {
                    ((C) this.f4035b.get(i4)).c();
                }
            }
        }

        void e() {
            this.f4034a.clear();
            ArrayList arrayList = this.f4035b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public int f(int i2) {
            if (i2 >= 0 && i2 < RecyclerView.this.f3930f0.b()) {
                return !RecyclerView.this.f3930f0.e() ? i2 : RecyclerView.this.f3926d.m(i2);
            }
            throw new IndexOutOfBoundsException("invalid position " + i2 + ". State item count is " + RecyclerView.this.f3930f0.b() + RecyclerView.this.R());
        }

        void g(C c2) {
            RecyclerView.this.getClass();
            g gVar = RecyclerView.this.f3941l;
            if (gVar != null) {
                gVar.r(c2);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f3930f0 != null) {
                recyclerView.f3929f.q(c2);
            }
        }

        C h(int i2) {
            int size;
            int iM;
            ArrayList arrayList = this.f4035b;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i3 = 0; i3 < size; i3++) {
                    C c2 = (C) this.f4035b.get(i3);
                    if (!c2.K() && c2.m() == i2) {
                        c2.b(32);
                        return c2;
                    }
                }
                if (RecyclerView.this.f3941l.f() && (iM = RecyclerView.this.f3926d.m(i2)) > 0 && iM < RecyclerView.this.f3941l.c()) {
                    long jD = RecyclerView.this.f3941l.d(iM);
                    for (int i4 = 0; i4 < size; i4++) {
                        C c3 = (C) this.f4035b.get(i4);
                        if (!c3.K() && c3.k() == jD) {
                            c3.b(32);
                            return c3;
                        }
                    }
                }
            }
            return null;
        }

        u i() {
            if (this.f4039g == null) {
                this.f4039g = new u();
            }
            return this.f4039g;
        }

        int j() {
            return this.f4034a.size();
        }

        public List k() {
            return this.f4037d;
        }

        C l(long j2, int i2, boolean z2) {
            for (int size = this.f4034a.size() - 1; size >= 0; size--) {
                C c2 = (C) this.f4034a.get(size);
                if (c2.k() == j2 && !c2.K()) {
                    if (i2 == c2.l()) {
                        c2.b(32);
                        if (c2.u() && !RecyclerView.this.f3930f0.e()) {
                            c2.E(2, 14);
                        }
                        return c2;
                    }
                    if (!z2) {
                        this.f4034a.remove(size);
                        RecyclerView.this.removeDetachedView(c2.f3971a, false);
                        y(c2.f3971a);
                    }
                }
            }
            int size2 = this.f4036c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                C c3 = (C) this.f4036c.get(size2);
                if (c3.k() == j2) {
                    if (i2 == c3.l()) {
                        if (!z2) {
                            this.f4036c.remove(size2);
                        }
                        return c3;
                    }
                    if (!z2) {
                        A(size2);
                        return null;
                    }
                }
            }
        }

        C m(int i2, boolean z2) {
            View viewE;
            int size = this.f4034a.size();
            for (int i3 = 0; i3 < size; i3++) {
                C c2 = (C) this.f4034a.get(i3);
                if (!c2.K() && c2.m() == i2 && !c2.s() && (RecyclerView.this.f3930f0.f4049h || !c2.u())) {
                    c2.b(32);
                    return c2;
                }
            }
            if (z2 || (viewE = RecyclerView.this.e.e(i2)) == null) {
                int size2 = this.f4036c.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    C c3 = (C) this.f4036c.get(i4);
                    if (!c3.s() && c3.m() == i2) {
                        if (!z2) {
                            this.f4036c.remove(i4);
                        }
                        return c3;
                    }
                }
                return null;
            }
            C cG0 = RecyclerView.g0(viewE);
            RecyclerView.this.e.s(viewE);
            int iM = RecyclerView.this.e.m(viewE);
            if (iM != -1) {
                RecyclerView.this.e.d(iM);
                D(viewE);
                cG0.b(8224);
                return cG0;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + cG0 + RecyclerView.this.R());
        }

        View n(int i2) {
            return ((C) this.f4034a.get(i2)).f3971a;
        }

        public View o(int i2) {
            return p(i2, false);
        }

        View p(int i2, boolean z2) {
            return I(i2, z2, Long.MAX_VALUE).f3971a;
        }

        void s() {
            int size = this.f4036c.size();
            for (int i2 = 0; i2 < size; i2++) {
                p pVar = (p) ((C) this.f4036c.get(i2)).f3971a.getLayoutParams();
                if (pVar != null) {
                    pVar.f4026c = true;
                }
            }
        }

        void t() {
            int size = this.f4036c.size();
            for (int i2 = 0; i2 < size; i2++) {
                C c2 = (C) this.f4036c.get(i2);
                if (c2 != null) {
                    c2.b(6);
                    c2.a(null);
                }
            }
            g gVar = RecyclerView.this.f3941l;
            if (gVar == null || !gVar.f()) {
                z();
            }
        }

        void u(int i2, int i3) {
            int size = this.f4036c.size();
            for (int i4 = 0; i4 < size; i4++) {
                C c2 = (C) this.f4036c.get(i4);
                if (c2 != null && c2.f3973c >= i2) {
                    c2.z(i3, true);
                }
            }
        }

        void v(int i2, int i3) {
            int i4;
            int i5;
            int i6;
            int i7;
            if (i2 < i3) {
                i4 = -1;
                i6 = i2;
                i5 = i3;
            } else {
                i4 = 1;
                i5 = i2;
                i6 = i3;
            }
            int size = this.f4036c.size();
            for (int i8 = 0; i8 < size; i8++) {
                C c2 = (C) this.f4036c.get(i8);
                if (c2 != null && (i7 = c2.f3973c) >= i6 && i7 <= i5) {
                    if (i7 == i2) {
                        c2.z(i3 - i2, false);
                    } else {
                        c2.z(i4, false);
                    }
                }
            }
        }

        void w(int i2, int i3, boolean z2) {
            int i4 = i2 + i3;
            for (int size = this.f4036c.size() - 1; size >= 0; size--) {
                C c2 = (C) this.f4036c.get(size);
                if (c2 != null) {
                    int i5 = c2.f3973c;
                    if (i5 >= i4) {
                        c2.z(-i3, z2);
                    } else if (i5 >= i2) {
                        c2.b(8);
                        A(size);
                    }
                }
            }
        }

        void x(g gVar, g gVar2, boolean z2) {
            c();
            i().h(gVar, gVar2, z2);
        }

        void y(View view) {
            C cG0 = RecyclerView.g0(view);
            cG0.f3983n = null;
            cG0.o = false;
            cG0.e();
            C(cG0);
        }

        void z() {
            for (int size = this.f4036c.size() - 1; size >= 0; size--) {
                A(size);
            }
            this.f4036c.clear();
            if (RecyclerView.f3889C0) {
                RecyclerView.this.f3928e0.b();
            }
        }
    }

    public interface w {
    }

    private class x extends i {
        x() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void a() {
            RecyclerView.this.p(null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f3930f0.f4048g = true;
            recyclerView.P0(true);
            if (RecyclerView.this.f3926d.p()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void b(int i2, int i3, Object obj) {
            RecyclerView.this.p(null);
            if (RecyclerView.this.f3926d.r(i2, i3, obj)) {
                d();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void c(int i2, int i3) {
            RecyclerView.this.p(null);
            if (RecyclerView.this.f3926d.s(i2, i3)) {
                d();
            }
        }

        void d() {
            if (RecyclerView.f3888B0) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.r && recyclerView.f3950q) {
                    M.a0(recyclerView, recyclerView.f3933h);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.f3964z = true;
            recyclerView2.requestLayout();
        }
    }

    public static class z {

        /* renamed from: b */
        private SparseArray f4044b;

        /* renamed from: m */
        int f4054m;

        /* renamed from: n */
        long f4055n;
        int o;

        /* renamed from: p */
        int f4056p;

        /* renamed from: q */
        int f4057q;

        /* renamed from: a */
        int f4043a = -1;

        /* renamed from: c */
        int f4045c = 0;

        /* renamed from: d */
        int f4046d = 0;
        int e = 1;

        /* renamed from: f */
        int f4047f = 0;

        /* renamed from: g */
        boolean f4048g = false;

        /* renamed from: h */
        boolean f4049h = false;

        /* renamed from: i */
        boolean f4050i = false;

        /* renamed from: j */
        boolean f4051j = false;

        /* renamed from: k */
        boolean f4052k = false;

        /* renamed from: l */
        boolean f4053l = false;

        void a(int i2) {
            if ((this.e & i2) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i2) + " but it is " + Integer.toBinaryString(this.e));
        }

        public int b() {
            return this.f4049h ? this.f4045c - this.f4046d : this.f4047f;
        }

        public int c() {
            return this.f4043a;
        }

        public boolean d() {
            return this.f4043a != -1;
        }

        public boolean e() {
            return this.f4049h;
        }

        void f(g gVar) {
            this.e = 1;
            this.f4047f = gVar.c();
            this.f4049h = false;
            this.f4050i = false;
            this.f4051j = false;
        }

        public boolean g() {
            return this.f4053l;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f4043a + ", mData=" + this.f4044b + ", mItemCount=" + this.f4047f + ", mIsMeasuring=" + this.f4051j + ", mPreviousLayoutItemCount=" + this.f4045c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f4046d + ", mStructureChanged=" + this.f4048g + ", mInPreLayout=" + this.f4049h + ", mRunSimpleAnimations=" + this.f4052k + ", mRunPredictiveAnimations=" + this.f4053l + '}';
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        f3896z0 = false;
        f3887A0 = i2 >= 23;
        f3888B0 = true;
        f3889C0 = true;
        f3890D0 = false;
        f3891E0 = false;
        Class cls = Integer.TYPE;
        f3892F0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        f3893G0 = new InterpolatorC0210c();
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void B() {
        int i2 = this.f3963y;
        this.f3963y = 0;
        if (i2 == 0 || !u0()) {
            return;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
        accessibilityEventObtain.setEventType(2048);
        AbstractC0358b.b(accessibilityEventObtain, i2);
        sendAccessibilityEventUnchecked(accessibilityEventObtain);
    }

    private void D() {
        this.f3930f0.a(1);
        S(this.f3930f0);
        this.f3930f0.f4051j = false;
        o1();
        this.f3929f.f();
        G0();
        O0();
        e1();
        z zVar = this.f3930f0;
        zVar.f4050i = zVar.f4052k && this.f3938j0;
        this.f3938j0 = false;
        this.f3936i0 = false;
        zVar.f4049h = zVar.f4053l;
        zVar.f4047f = this.f3941l.c();
        W(this.f3947o0);
        if (this.f3930f0.f4052k) {
            int iG = this.e.g();
            for (int i2 = 0; i2 < iG; i2++) {
                C cG0 = g0(this.e.f(i2));
                if (!cG0.I() && (!cG0.s() || this.f3941l.f())) {
                    this.f3929f.e(cG0, this.f3908L.u(this.f3930f0, cG0, l.e(cG0), cG0.o()));
                    if (this.f3930f0.f4050i && cG0.x() && !cG0.u() && !cG0.I() && !cG0.s()) {
                        this.f3929f.c(e0(cG0), cG0);
                    }
                }
            }
        }
        if (this.f3930f0.f4053l) {
            f1();
            z zVar2 = this.f3930f0;
            boolean z2 = zVar2.f4048g;
            zVar2.f4048g = false;
            this.f3943m.W0(this.f3922b, zVar2);
            this.f3930f0.f4048g = z2;
            for (int i3 = 0; i3 < this.e.g(); i3++) {
                C cG02 = g0(this.e.f(i3));
                if (!cG02.I() && !this.f3929f.i(cG02)) {
                    int iE = l.e(cG02);
                    boolean zP = cG02.p(8192);
                    if (!zP) {
                        iE |= 4096;
                    }
                    l.c cVarU = this.f3908L.u(this.f3930f0, cG02, iE, cG02.o());
                    if (zP) {
                        R0(cG02, cVarU);
                    } else {
                        this.f3929f.a(cG02, cVarU);
                    }
                }
            }
            t();
        } else {
            t();
        }
        H0();
        q1(false);
        this.f3930f0.e = 2;
    }

    private void E() {
        o1();
        G0();
        this.f3930f0.a(6);
        this.f3926d.j();
        this.f3930f0.f4047f = this.f3941l.c();
        z zVar = this.f3930f0;
        zVar.f4046d = 0;
        zVar.f4049h = false;
        this.f3943m.W0(this.f3922b, zVar);
        z zVar2 = this.f3930f0;
        zVar2.f4048g = false;
        this.f3924c = null;
        zVar2.f4052k = zVar2.f4052k && this.f3908L != null;
        zVar2.e = 4;
        H0();
        q1(false);
    }

    private void F() {
        this.f3930f0.a(4);
        o1();
        G0();
        z zVar = this.f3930f0;
        zVar.e = 1;
        if (zVar.f4052k) {
            for (int iG = this.e.g() - 1; iG >= 0; iG--) {
                C cG0 = g0(this.e.f(iG));
                if (!cG0.I()) {
                    long jE0 = e0(cG0);
                    l.c cVarT = this.f3908L.t(this.f3930f0, cG0);
                    C cG = this.f3929f.g(jE0);
                    if (cG == null || cG.I()) {
                        this.f3929f.d(cG0, cVarT);
                    } else {
                        boolean zH = this.f3929f.h(cG);
                        boolean zH2 = this.f3929f.h(cG0);
                        if (zH && cG == cG0) {
                            this.f3929f.d(cG0, cVarT);
                        } else {
                            l.c cVarN = this.f3929f.n(cG);
                            this.f3929f.d(cG0, cVarT);
                            l.c cVarM = this.f3929f.m(cG0);
                            if (cVarN == null) {
                                l0(jE0, cG0, cG);
                            } else {
                                n(cG, cG0, cVarN, cVarM, zH, zH2);
                            }
                        }
                    }
                }
            }
            this.f3929f.o(this.f3961w0);
        }
        this.f3943m.j1(this.f3922b);
        z zVar2 = this.f3930f0;
        zVar2.f4045c = zVar2.f4047f;
        this.f3899C = false;
        this.f3900D = false;
        zVar2.f4052k = false;
        zVar2.f4053l = false;
        this.f3943m.f4008g = false;
        ArrayList arrayList = this.f3922b.f4035b;
        if (arrayList != null) {
            arrayList.clear();
        }
        o oVar = this.f3943m;
        if (oVar.f4014m) {
            oVar.f4013l = 0;
            oVar.f4014m = false;
            this.f3922b.K();
        }
        this.f3943m.X0(this.f3930f0);
        H0();
        q1(false);
        this.f3929f.f();
        int[] iArr = this.f3947o0;
        if (y(iArr[0], iArr[1])) {
            L(0, 0);
        }
        S0();
        c1();
    }

    private boolean I(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        s sVar = this.f3948p;
        if (sVar != null) {
            if (action != 0) {
                sVar.b(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.f3948p = null;
                }
                return true;
            }
            this.f3948p = null;
        }
        if (action != 0) {
            int size = this.o.size();
            for (int i2 = 0; i2 < size; i2++) {
                s sVar2 = (s) this.o.get(i2);
                if (sVar2.a(this, motionEvent)) {
                    this.f3948p = sVar2;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean J(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.f3948p = null;
        }
        int size = this.o.size();
        for (int i2 = 0; i2 < size; i2++) {
            s sVar = (s) this.o.get(i2);
            if (sVar.a(this, motionEvent) && action != 3) {
                this.f3948p = sVar;
                return true;
            }
        }
        return false;
    }

    private void J0(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f3910N) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.f3910N = motionEvent.getPointerId(i2);
            int x2 = (int) (motionEvent.getX(i2) + 0.5f);
            this.f3914R = x2;
            this.f3912P = x2;
            int y2 = (int) (motionEvent.getY(i2) + 0.5f);
            this.f3915S = y2;
            this.f3913Q = y2;
        }
    }

    private boolean N0() {
        return this.f3908L != null && this.f3943m.H1();
    }

    private void O0() {
        boolean z2;
        if (this.f3899C) {
            this.f3926d.w();
            if (this.f3900D) {
                this.f3943m.R0(this);
            }
        }
        if (N0()) {
            this.f3926d.u();
        } else {
            this.f3926d.j();
        }
        boolean z3 = this.f3936i0 || this.f3938j0;
        this.f3930f0.f4052k = this.f3954t && this.f3908L != null && ((z2 = this.f3899C) || z3 || this.f3943m.f4008g) && (!z2 || this.f3941l.f());
        z zVar = this.f3930f0;
        zVar.f4053l = zVar.f4052k && z3 && !this.f3899C && N0();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void Q0(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 1
            r2 = 0
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 >= 0) goto L21
            r6.O()
            android.widget.EdgeEffect r3 = r6.f3904H
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r0 - r9
            androidx.core.widget.d.c(r3, r4, r9)
        L1f:
            r9 = 1
            goto L3c
        L21:
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 <= 0) goto L3b
            r6.P()
            android.widget.EdgeEffect r3 = r6.f3906J
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            androidx.core.widget.d.c(r3, r4, r9)
            goto L1f
        L3b:
            r9 = 0
        L3c:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 >= 0) goto L56
            r6.Q()
            android.widget.EdgeEffect r9 = r6.f3905I
            float r0 = -r10
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            int r3 = r6.getWidth()
            float r3 = (float) r3
            float r7 = r7 / r3
            androidx.core.widget.d.c(r9, r0, r7)
            goto L72
        L56:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 <= 0) goto L71
            r6.N()
            android.widget.EdgeEffect r9 = r6.f3907K
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r3 = r10 / r3
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r0 = r0 - r7
            androidx.core.widget.d.c(r9, r3, r0)
            goto L72
        L71:
            r1 = r9
        L72:
            if (r1 != 0) goto L7c
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 != 0) goto L7c
            int r7 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r7 == 0) goto L7f
        L7c:
            androidx.core.view.M.Z(r6)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.Q0(float, float, float, float):void");
    }

    private void S0() {
        View viewFindViewById;
        if (!this.f3923b0 || this.f3941l == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (!f3891E0 || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                if (!this.e.n(focusedChild)) {
                    return;
                }
            } else if (this.e.g() == 0) {
                requestFocus();
                return;
            }
        }
        View viewY = null;
        C cA0 = (this.f3930f0.f4055n == -1 || !this.f3941l.f()) ? null : a0(this.f3930f0.f4055n);
        if (cA0 != null && !this.e.n(cA0.f3971a) && cA0.f3971a.hasFocusable()) {
            viewY = cA0.f3971a;
        } else if (this.e.g() > 0) {
            viewY = Y();
        }
        if (viewY != null) {
            int i2 = this.f3930f0.o;
            if (i2 != -1 && (viewFindViewById = viewY.findViewById(i2)) != null && viewFindViewById.isFocusable()) {
                viewY = viewFindViewById;
            }
            viewY.requestFocus();
        }
    }

    private void T0() {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.f3904H;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.f3904H.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = this.f3905I;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.f3905I.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f3906J;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.f3906J.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f3907K;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.f3907K.isFinished();
        }
        if (zIsFinished) {
            M.Z(this);
        }
    }

    private void W(int[] iArr) {
        int iG = this.e.g();
        if (iG == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = Target.SIZE_ORIGINAL;
        for (int i4 = 0; i4 < iG; i4++) {
            C cG0 = g0(this.e.f(i4));
            if (!cG0.I()) {
                int iM = cG0.m();
                if (iM < i2) {
                    i2 = iM;
                }
                if (iM > i3) {
                    i3 = iM;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    static RecyclerView X(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView recyclerViewX = X(viewGroup.getChildAt(i2));
            if (recyclerViewX != null) {
                return recyclerViewX;
            }
        }
        return null;
    }

    private View Y() {
        C cZ;
        z zVar = this.f3930f0;
        int i2 = zVar.f4054m;
        if (i2 == -1) {
            i2 = 0;
        }
        int iB = zVar.b();
        for (int i3 = i2; i3 < iB; i3++) {
            C cZ2 = Z(i3);
            if (cZ2 == null) {
                break;
            }
            if (cZ2.f3971a.hasFocusable()) {
                return cZ2.f3971a;
            }
        }
        int iMin = Math.min(iB, i2);
        do {
            iMin--;
            if (iMin < 0 || (cZ = Z(iMin)) == null) {
                return null;
            }
        } while (!cZ.f3971a.hasFocusable());
        return cZ.f3971a;
    }

    private void b1(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.f3935i.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof p) {
            p pVar = (p) layoutParams;
            if (!pVar.f4026c) {
                Rect rect = pVar.f4025b;
                Rect rect2 = this.f3935i;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.f3935i);
            offsetRectIntoDescendantCoords(view, this.f3935i);
        }
        this.f3943m.q1(this, view, this.f3935i, !this.f3954t, view2 == null);
    }

    private void c1() {
        z zVar = this.f3930f0;
        zVar.f4055n = -1L;
        zVar.f4054m = -1;
        zVar.o = -1;
    }

    private void d1() {
        VelocityTracker velocityTracker = this.f3911O;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        r1(0);
        T0();
    }

    private void e1() {
        View focusedChild = (this.f3923b0 && hasFocus() && this.f3941l != null) ? getFocusedChild() : null;
        C cV = focusedChild != null ? V(focusedChild) : null;
        if (cV == null) {
            c1();
            return;
        }
        this.f3930f0.f4055n = this.f3941l.f() ? cV.k() : -1L;
        this.f3930f0.f4054m = this.f3899C ? -1 : cV.u() ? cV.f3974d : cV.j();
        this.f3930f0.o = i0(cV.f3971a);
    }

    private void g(C c2) {
        View view = c2.f3971a;
        boolean z2 = view.getParent() == this;
        this.f3922b.J(f0(view));
        if (c2.w()) {
            this.e.c(view, -1, view.getLayoutParams(), true);
        } else if (z2) {
            this.e.k(view);
        } else {
            this.e.b(view, true);
        }
    }

    static C g0(View view) {
        if (view == null) {
            return null;
        }
        return ((p) view.getLayoutParams()).f4024a;
    }

    private androidx.core.view.B getScrollingChildHelper() {
        if (this.f3949p0 == null) {
            this.f3949p0 = new androidx.core.view.B(this);
        }
        return this.f3949p0;
    }

    static void h0(View view, Rect rect) {
        p pVar = (p) view.getLayoutParams();
        Rect rect2 = pVar.f4025b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) pVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) pVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) pVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
    }

    private int i0(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    private String j0(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(".")) {
            return str;
        }
        return RecyclerView.class.getPackage().getName() + '.' + str;
    }

    private void j1(g gVar, boolean z2, boolean z3) {
        g gVar2 = this.f3941l;
        if (gVar2 != null) {
            gVar2.t(this.f3920a);
            this.f3941l.n(this);
        }
        if (!z2 || z3) {
            U0();
        }
        this.f3926d.w();
        g gVar3 = this.f3941l;
        this.f3941l = gVar;
        if (gVar != null) {
            gVar.s(this.f3920a);
            gVar.j(this);
        }
        o oVar = this.f3943m;
        if (oVar != null) {
            oVar.D0(gVar3, this.f3941l);
        }
        this.f3922b.x(gVar3, this.f3941l, z2);
        this.f3930f0.f4048g = true;
    }

    private void l0(long j2, C c2, C c3) {
        int iG = this.e.g();
        for (int i2 = 0; i2 < iG; i2++) {
            C cG0 = g0(this.e.f(i2));
            if (cG0 != c2 && e0(cG0) == j2) {
                g gVar = this.f3941l;
                if (gVar == null || !gVar.f()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + cG0 + " \n View Holder 2:" + c2 + R());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + cG0 + " \n View Holder 2:" + c2 + R());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + c3 + " cannot be found but it is necessary for " + c2 + R());
    }

    private void n(C c2, C c3, l.c cVar, l.c cVar2, boolean z2, boolean z3) {
        c2.F(false);
        if (z2) {
            g(c2);
        }
        if (c2 != c3) {
            if (z3) {
                g(c3);
            }
            c2.f3977h = c3;
            g(c2);
            this.f3922b.J(c2);
            c3.F(false);
            c3.f3978i = c2;
        }
        if (this.f3908L.b(c2, c3, cVar, cVar2)) {
            M0();
        }
    }

    private boolean o0() {
        int iG = this.e.g();
        for (int i2 = 0; i2 < iG; i2++) {
            C cG0 = g0(this.e.f(i2));
            if (cG0 != null && !cG0.I() && cG0.x()) {
                return true;
            }
        }
        return false;
    }

    private void q0() {
        if (M.x(this) == 0) {
            M.r0(this, 8);
        }
    }

    private void r() {
        d1();
        setScrollState(0);
    }

    private void r0() {
        this.e = new b(new e());
    }

    static void s(C c2) {
        WeakReference weakReference = c2.f3972b;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            while (view != null) {
                if (view == c2.f3971a) {
                    return;
                }
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            c2.f3972b = null;
        }
    }

    private void t1() {
        this.f3925c0.i();
        o oVar = this.f3943m;
        if (oVar != null) {
            oVar.G1();
        }
    }

    private void w(Context context, String str, AttributeSet attributeSet, int i2, int i3) throws NoSuchMethodException, SecurityException {
        Object[] objArr;
        Constructor constructor;
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            String strJ0 = j0(context, strTrim);
            try {
                Class<? extends U> clsAsSubclass = (isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).loadClass(strJ0).asSubclass(o.class);
                try {
                    constructor = clsAsSubclass.getConstructor(f3892F0);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
                } catch (NoSuchMethodException e2) {
                    objArr = null;
                    try {
                        constructor = clsAsSubclass.getConstructor(null);
                    } catch (NoSuchMethodException e3) {
                        e3.initCause(e2);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + strJ0, e3);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((o) constructor.newInstance(objArr));
            } catch (ClassCastException e4) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + strJ0, e4);
            } catch (ClassNotFoundException e5) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + strJ0, e5);
            } catch (IllegalAccessException e6) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + strJ0, e6);
            } catch (InstantiationException e7) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strJ0, e7);
            } catch (InvocationTargetException e8) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strJ0, e8);
            }
        }
    }

    private boolean w0(View view, View view2, int i2) {
        int i3;
        if (view2 == null || view2 == this || U(view2) == null) {
            return false;
        }
        if (view == null || U(view) == null) {
            return true;
        }
        this.f3935i.set(0, 0, view.getWidth(), view.getHeight());
        this.f3937j.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.f3935i);
        offsetDescendantRectToMyCoords(view2, this.f3937j);
        char c2 = 65535;
        int i4 = this.f3943m.Y() == 1 ? -1 : 1;
        Rect rect = this.f3935i;
        int i5 = rect.left;
        Rect rect2 = this.f3937j;
        int i6 = rect2.left;
        if ((i5 < i6 || rect.right <= i6) && rect.right < rect2.right) {
            i3 = 1;
        } else {
            int i7 = rect.right;
            int i8 = rect2.right;
            i3 = ((i7 > i8 || i5 >= i8) && i5 > i6) ? -1 : 0;
        }
        int i9 = rect.top;
        int i10 = rect2.top;
        if ((i9 < i10 || rect.bottom <= i10) && rect.bottom < rect2.bottom) {
            c2 = 1;
        } else {
            int i11 = rect.bottom;
            int i12 = rect2.bottom;
            if ((i11 <= i12 && i9 < i12) || i9 <= i10) {
                c2 = 0;
            }
        }
        if (i2 == 1) {
            return c2 < 0 || (c2 == 0 && i3 * i4 <= 0);
        }
        if (i2 == 2) {
            return c2 > 0 || (c2 == 0 && i3 * i4 >= 0);
        }
        if (i2 == 17) {
            return i3 < 0;
        }
        if (i2 == 33) {
            return c2 < 0;
        }
        if (i2 == 66) {
            return i3 > 0;
        }
        if (i2 == 130) {
            return c2 > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i2 + R());
    }

    private boolean y(int i2, int i3) {
        W(this.f3947o0);
        int[] iArr = this.f3947o0;
        return (iArr[0] == i2 && iArr[1] == i3) ? false : true;
    }

    void A(View view) {
        C cG0 = g0(view);
        F0(view);
        g gVar = this.f3941l;
        if (gVar != null && cG0 != null) {
            gVar.q(cG0);
        }
        List list = this.f3898B;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((q) this.f3898B.get(size)).d(view);
            }
        }
    }

    public void A0(int i2) {
        int iG = this.e.g();
        for (int i3 = 0; i3 < iG; i3++) {
            this.e.f(i3).offsetTopAndBottom(i2);
        }
    }

    void B0(int i2, int i3) {
        int iJ = this.e.j();
        for (int i4 = 0; i4 < iJ; i4++) {
            C cG0 = g0(this.e.i(i4));
            if (cG0 != null && !cG0.I() && cG0.f3973c >= i2) {
                cG0.z(i3, false);
                this.f3930f0.f4048g = true;
            }
        }
        this.f3922b.u(i2, i3);
        requestLayout();
    }

    void C() {
        if (this.f3941l == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        if (this.f3943m == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        z zVar = this.f3930f0;
        zVar.f4051j = false;
        if (zVar.e == 1) {
            D();
            this.f3943m.x1(this);
            E();
        } else if (!this.f3926d.q() && this.f3943m.n0() == getWidth() && this.f3943m.W() == getHeight()) {
            this.f3943m.x1(this);
        } else {
            this.f3943m.x1(this);
            E();
        }
        F();
    }

    void C0(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int iJ = this.e.j();
        if (i2 < i3) {
            i6 = -1;
            i5 = i2;
            i4 = i3;
        } else {
            i4 = i2;
            i5 = i3;
            i6 = 1;
        }
        for (int i8 = 0; i8 < iJ; i8++) {
            C cG0 = g0(this.e.i(i8));
            if (cG0 != null && (i7 = cG0.f3973c) >= i5 && i7 <= i4) {
                if (i7 == i2) {
                    cG0.z(i3 - i2, false);
                } else {
                    cG0.z(i6, false);
                }
                this.f3930f0.f4048g = true;
            }
        }
        this.f3922b.v(i2, i3);
        requestLayout();
    }

    void D0(int i2, int i3, boolean z2) {
        int i4 = i2 + i3;
        int iJ = this.e.j();
        for (int i5 = 0; i5 < iJ; i5++) {
            C cG0 = g0(this.e.i(i5));
            if (cG0 != null && !cG0.I()) {
                int i6 = cG0.f3973c;
                if (i6 >= i4) {
                    cG0.z(-i3, z2);
                    this.f3930f0.f4048g = true;
                } else if (i6 >= i2) {
                    cG0.i(i2 - 1, -i3, z2);
                    this.f3930f0.f4048g = true;
                }
            }
        }
        this.f3922b.w(i2, i3, z2);
        requestLayout();
    }

    public void E0(View view) {
    }

    public void F0(View view) {
    }

    public boolean G(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().d(i2, i3, iArr, iArr2, i4);
    }

    void G0() {
        this.f3901E++;
    }

    public boolean H(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        return getScrollingChildHelper().g(i2, i3, i4, i5, iArr, i6);
    }

    void H0() {
        I0(true);
    }

    void I0(boolean z2) {
        int i2 = this.f3901E - 1;
        this.f3901E = i2;
        if (i2 < 1) {
            this.f3901E = 0;
            if (z2) {
                B();
                M();
            }
        }
    }

    void K(int i2) {
        o oVar = this.f3943m;
        if (oVar != null) {
            oVar.d1(i2);
        }
        K0(i2);
        t tVar = this.f3932g0;
        if (tVar != null) {
            tVar.a(this, i2);
        }
        List list = this.f3934h0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((t) this.f3934h0.get(size)).a(this, i2);
            }
        }
    }

    public void K0(int i2) {
    }

    void L(int i2, int i3) {
        this.f3902F++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        L0(i2, i3);
        t tVar = this.f3932g0;
        if (tVar != null) {
            tVar.b(this, i2, i3);
        }
        List list = this.f3934h0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((t) this.f3934h0.get(size)).b(this, i2, i3);
            }
        }
        this.f3902F--;
    }

    public void L0(int i2, int i3) {
    }

    void M() {
        int i2;
        for (int size = this.f3957u0.size() - 1; size >= 0; size--) {
            C c2 = (C) this.f3957u0.get(size);
            if (c2.f3971a.getParent() == this && !c2.I() && (i2 = c2.f3985q) != -1) {
                M.p0(c2.f3971a, i2);
                c2.f3985q = -1;
            }
        }
        this.f3957u0.clear();
    }

    void M0() {
        if (this.f3942l0 || !this.f3950q) {
            return;
        }
        M.a0(this, this.f3959v0);
        this.f3942l0 = true;
    }

    void N() {
        if (this.f3907K != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.f3903G.a(this, 3);
        this.f3907K = edgeEffectA;
        if (this.f3931g) {
            edgeEffectA.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectA.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    void O() {
        if (this.f3904H != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.f3903G.a(this, 0);
        this.f3904H = edgeEffectA;
        if (this.f3931g) {
            edgeEffectA.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectA.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    void P() {
        if (this.f3906J != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.f3903G.a(this, 2);
        this.f3906J = edgeEffectA;
        if (this.f3931g) {
            edgeEffectA.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectA.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    void P0(boolean z2) {
        this.f3900D = z2 | this.f3900D;
        this.f3899C = true;
        y0();
    }

    void Q() {
        if (this.f3905I != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.f3903G.a(this, 1);
        this.f3905I = edgeEffectA;
        if (this.f3931g) {
            edgeEffectA.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectA.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    String R() {
        return " " + super.toString() + ", adapter:" + this.f3941l + ", layout:" + this.f3943m + ", context:" + getContext();
    }

    void R0(C c2, l.c cVar) {
        c2.E(0, 8192);
        if (this.f3930f0.f4050i && c2.x() && !c2.u() && !c2.I()) {
            this.f3929f.c(e0(c2), c2);
        }
        this.f3929f.e(c2, cVar);
    }

    final void S(z zVar) {
        if (getScrollState() != 2) {
            zVar.f4056p = 0;
            zVar.f4057q = 0;
        } else {
            OverScroller overScroller = this.f3925c0.f3967c;
            zVar.f4056p = overScroller.getFinalX() - overScroller.getCurrX();
            zVar.f4057q = overScroller.getFinalY() - overScroller.getCurrY();
        }
    }

    public View T(float f2, float f3) {
        for (int iG = this.e.g() - 1; iG >= 0; iG--) {
            View viewF = this.e.f(iG);
            float translationX = viewF.getTranslationX();
            float translationY = viewF.getTranslationY();
            if (f2 >= viewF.getLeft() + translationX && f2 <= viewF.getRight() + translationX && f3 >= viewF.getTop() + translationY && f3 <= viewF.getBottom() + translationY) {
                return viewF;
            }
        }
        return null;
    }

    public View U(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    void U0() {
        l lVar = this.f3908L;
        if (lVar != null) {
            lVar.k();
        }
        o oVar = this.f3943m;
        if (oVar != null) {
            oVar.i1(this.f3922b);
            this.f3943m.j1(this.f3922b);
        }
        this.f3922b.c();
    }

    public C V(View view) {
        View viewU = U(view);
        if (viewU == null) {
            return null;
        }
        return f0(viewU);
    }

    boolean V0(View view) {
        o1();
        boolean zR = this.e.r(view);
        if (zR) {
            C cG0 = g0(view);
            this.f3922b.J(cG0);
            this.f3922b.C(cG0);
        }
        q1(!zR);
        return zR;
    }

    public void W0(n nVar) {
        o oVar = this.f3943m;
        if (oVar != null) {
            oVar.g("Cannot remove item decoration during a scroll  or layout");
        }
        this.f3945n.remove(nVar);
        if (this.f3945n.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        x0();
        requestLayout();
    }

    public void X0(q qVar) {
        List list = this.f3898B;
        if (list == null) {
            return;
        }
        list.remove(qVar);
    }

    public void Y0(s sVar) {
        this.o.remove(sVar);
        if (this.f3948p == sVar) {
            this.f3948p = null;
        }
    }

    public C Z(int i2) {
        C c2 = null;
        if (this.f3899C) {
            return null;
        }
        int iJ = this.e.j();
        for (int i3 = 0; i3 < iJ; i3++) {
            C cG0 = g0(this.e.i(i3));
            if (cG0 != null && !cG0.u() && d0(cG0) == i2) {
                if (!this.e.n(cG0.f3971a)) {
                    return cG0;
                }
                c2 = cG0;
            }
        }
        return c2;
    }

    public void Z0(t tVar) {
        List list = this.f3934h0;
        if (list != null) {
            list.remove(tVar);
        }
    }

    void a(int i2, int i3) {
        if (i2 < 0) {
            O();
            this.f3904H.onAbsorb(-i2);
        } else if (i2 > 0) {
            P();
            this.f3906J.onAbsorb(i2);
        }
        if (i3 < 0) {
            Q();
            this.f3905I.onAbsorb(-i3);
        } else if (i3 > 0) {
            N();
            this.f3907K.onAbsorb(i3);
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        M.Z(this);
    }

    public C a0(long j2) {
        g gVar = this.f3941l;
        C c2 = null;
        if (gVar != null && gVar.f()) {
            int iJ = this.e.j();
            for (int i2 = 0; i2 < iJ; i2++) {
                C cG0 = g0(this.e.i(i2));
                if (cG0 != null && !cG0.u() && cG0.k() == j2) {
                    if (!this.e.n(cG0.f3971a)) {
                        return cG0;
                    }
                    c2 = cG0;
                }
            }
        }
        return c2;
    }

    void a1() {
        C c2;
        int iG = this.e.g();
        for (int i2 = 0; i2 < iG; i2++) {
            View viewF = this.e.f(i2);
            C cF0 = f0(viewF);
            if (cF0 != null && (c2 = cF0.f3978i) != null) {
                View view = c2.f3971a;
                int left = viewF.getLeft();
                int top = viewF.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList arrayList, int i2, int i3) {
        o oVar = this.f3943m;
        if (oVar == null || !oVar.E0(this, arrayList, i2, i3)) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    androidx.recyclerview.widget.RecyclerView.C b0(int r6, boolean r7) {
        /*
            r5 = this;
            androidx.recyclerview.widget.b r0 = r5.e
            int r0 = r0.j()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3a
            androidx.recyclerview.widget.b r3 = r5.e
            android.view.View r3 = r3.i(r2)
            androidx.recyclerview.widget.RecyclerView$C r3 = g0(r3)
            if (r3 == 0) goto L37
            boolean r4 = r3.u()
            if (r4 != 0) goto L37
            if (r7 == 0) goto L23
            int r4 = r3.f3973c
            if (r4 == r6) goto L2a
            goto L37
        L23:
            int r4 = r3.m()
            if (r4 == r6) goto L2a
            goto L37
        L2a:
            androidx.recyclerview.widget.b r1 = r5.e
            android.view.View r4 = r3.f3971a
            boolean r1 = r1.n(r4)
            if (r1 == 0) goto L36
            r1 = r3
            goto L37
        L36:
            return r3
        L37:
            int r2 = r2 + 1
            goto L8
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.b0(int, boolean):androidx.recyclerview.widget.RecyclerView$C");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean c0(int i2, int i3) {
        o oVar = this.f3943m;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.f3960w) {
            return false;
        }
        boolean zK = oVar.k();
        boolean zL = this.f3943m.l();
        if (zK == 0 || Math.abs(i2) < this.f3917U) {
            i2 = 0;
        }
        if (!zL || Math.abs(i3) < this.f3917U) {
            i3 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            return false;
        }
        float f2 = i2;
        float f3 = i3;
        if (!dispatchNestedPreFling(f2, f3)) {
            boolean z2 = zK != 0 || zL;
            dispatchNestedFling(f2, f3, z2);
            int i4 = zK;
            if (z2) {
                if (zL) {
                    i4 = (zK ? 1 : 0) | 2;
                }
                p1(i4, 1);
                int i5 = this.f3918V;
                int iMax = Math.max(-i5, Math.min(i2, i5));
                int i6 = this.f3918V;
                this.f3925c0.e(iMax, Math.max(-i6, Math.min(i3, i6)));
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof p) && this.f3943m.m((p) layoutParams);
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        o oVar = this.f3943m;
        if (oVar != null && oVar.k()) {
            return this.f3943m.q(this.f3930f0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        o oVar = this.f3943m;
        if (oVar != null && oVar.k()) {
            return this.f3943m.r(this.f3930f0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        o oVar = this.f3943m;
        if (oVar != null && oVar.k()) {
            return this.f3943m.s(this.f3930f0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        o oVar = this.f3943m;
        if (oVar != null && oVar.l()) {
            return this.f3943m.t(this.f3930f0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        o oVar = this.f3943m;
        if (oVar != null && oVar.l()) {
            return this.f3943m.u(this.f3930f0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        o oVar = this.f3943m;
        if (oVar != null && oVar.l()) {
            return this.f3943m.v(this.f3930f0);
        }
        return 0;
    }

    int d0(C c2) {
        if (c2.p(524) || !c2.r()) {
            return -1;
        }
        return this.f3926d.e(c2.f3973c);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return getScrollingChildHelper().a(f2, f3, z2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().b(f2, f3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().f(i2, i3, i4, i5, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z2;
        super.draw(canvas);
        int size = this.f3945n.size();
        boolean z3 = false;
        for (int i2 = 0; i2 < size; i2++) {
            ((n) this.f3945n.get(i2)).k(canvas, this, this.f3930f0);
        }
        EdgeEffect edgeEffect = this.f3904H;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z2 = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.f3931g ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.f3904H;
            z2 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.f3905I;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.f3931g) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.f3905I;
            z2 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.f3906J;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f3931g ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.f3906J;
            z2 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.f3907K;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f3931g) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.f3907K;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z3 = true;
            }
            z2 |= z3;
            canvas.restoreToCount(iSave4);
        }
        if ((z2 || this.f3908L == null || this.f3945n.size() <= 0 || !this.f3908L.p()) ? z2 : true) {
            M.Z(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    long e0(C c2) {
        return this.f3941l.f() ? c2.k() : c2.f3973c;
    }

    public C f0(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return g0(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    void f1() {
        int iJ = this.e.j();
        for (int i2 = 0; i2 < iJ; i2++) {
            C cG0 = g0(this.e.i(i2));
            if (!cG0.I()) {
                cG0.D();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i2) {
        View viewI0;
        boolean z2;
        View viewP0 = this.f3943m.P0(view, i2);
        if (viewP0 != null) {
            return viewP0;
        }
        boolean z3 = (this.f3941l == null || this.f3943m == null || v0() || this.f3960w) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z3 && (i2 == 2 || i2 == 1)) {
            if (this.f3943m.l()) {
                int i3 = i2 == 2 ? 130 : 33;
                z2 = focusFinder.findNextFocus(this, view, i3) == null;
                if (f3890D0) {
                    i2 = i3;
                }
            } else {
                z2 = false;
            }
            if (!z2 && this.f3943m.k()) {
                int i4 = (this.f3943m.Y() == 1) ^ (i2 == 2) ? 66 : 17;
                boolean z4 = focusFinder.findNextFocus(this, view, i4) == null;
                if (f3890D0) {
                    i2 = i4;
                }
                z2 = z4;
            }
            if (z2) {
                v();
                if (U(view) == null) {
                    return null;
                }
                o1();
                this.f3943m.I0(view, i2, this.f3922b, this.f3930f0);
                q1(false);
            }
            viewI0 = focusFinder.findNextFocus(this, view, i2);
        } else {
            View viewFindNextFocus = focusFinder.findNextFocus(this, view, i2);
            if (viewFindNextFocus == null && z3) {
                v();
                if (U(view) == null) {
                    return null;
                }
                o1();
                viewI0 = this.f3943m.I0(view, i2, this.f3922b, this.f3930f0);
                q1(false);
            } else {
                viewI0 = viewFindNextFocus;
            }
        }
        if (viewI0 == null || viewI0.hasFocusable()) {
            return w0(view, viewI0, i2) ? viewI0 : super.focusSearch(view, i2);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i2);
        }
        b1(viewI0, null);
        return view;
    }

    boolean g1(int i2, int i3, MotionEvent motionEvent) {
        int i4;
        int i5;
        int i6;
        int i7;
        v();
        if (this.f3941l != null) {
            h1(i2, i3, this.f3955t0);
            int[] iArr = this.f3955t0;
            int i8 = iArr[0];
            int i9 = iArr[1];
            i5 = i9;
            i6 = i8;
            i7 = i2 - i8;
            i4 = i3 - i9;
        } else {
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
        }
        if (!this.f3945n.isEmpty()) {
            invalidate();
        }
        int i10 = i4;
        if (H(i6, i5, i7, i4, this.f3951q0, 0)) {
            int i11 = this.f3914R;
            int[] iArr2 = this.f3951q0;
            int i12 = iArr2[0];
            this.f3914R = i11 - i12;
            int i13 = this.f3915S;
            int i14 = iArr2[1];
            this.f3915S = i13 - i14;
            if (motionEvent != null) {
                motionEvent.offsetLocation(i12, i14);
            }
            int[] iArr3 = this.f3953s0;
            int i15 = iArr3[0];
            int[] iArr4 = this.f3951q0;
            iArr3[0] = i15 + iArr4[0];
            iArr3[1] = iArr3[1] + iArr4[1];
        } else if (getOverScrollMode() != 2) {
            if (motionEvent != null && !androidx.core.view.A.a(motionEvent, 8194)) {
                Q0(motionEvent.getX(), i7, motionEvent.getY(), i10);
            }
            u(i2, i3);
        }
        if (i6 != 0 || i5 != 0) {
            L(i6, i5);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (i6 == 0 && i5 == 0) ? false : true;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        o oVar = this.f3943m;
        if (oVar != null) {
            return oVar.D();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + R());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        o oVar = this.f3943m;
        if (oVar != null) {
            return oVar.E(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + R());
    }

    public g getAdapter() {
        return this.f3941l;
    }

    @Override // android.view.View
    public int getBaseline() {
        o oVar = this.f3943m;
        return oVar != null ? oVar.G() : super.getBaseline();
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        j jVar = this.f3946n0;
        return jVar == null ? super.getChildDrawingOrder(i2, i3) : jVar.a(i2, i3);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f3931g;
    }

    public androidx.recyclerview.widget.l getCompatAccessibilityDelegate() {
        return this.f3944m0;
    }

    public k getEdgeEffectFactory() {
        return this.f3903G;
    }

    public l getItemAnimator() {
        return this.f3908L;
    }

    public int getItemDecorationCount() {
        return this.f3945n.size();
    }

    public o getLayoutManager() {
        return this.f3943m;
    }

    public int getMaxFlingVelocity() {
        return this.f3918V;
    }

    public int getMinFlingVelocity() {
        return this.f3917U;
    }

    long getNanoTime() {
        if (f3889C0) {
            return System.nanoTime();
        }
        return 0L;
    }

    public r getOnFlingListener() {
        return null;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f3923b0;
    }

    public u getRecycledViewPool() {
        return this.f3922b.i();
    }

    public int getScrollState() {
        return this.f3909M;
    }

    public void h(n nVar) {
        i(nVar, -1);
    }

    void h1(int i2, int i3, int[] iArr) {
        o1();
        G0();
        androidx.core.os.o.a("RV Scroll");
        S(this.f3930f0);
        int iU1 = i2 != 0 ? this.f3943m.u1(i2, this.f3922b, this.f3930f0) : 0;
        int iW1 = i3 != 0 ? this.f3943m.w1(i3, this.f3922b, this.f3930f0) : 0;
        androidx.core.os.o.b();
        a1();
        H0();
        q1(false);
        if (iArr != null) {
            iArr[0] = iU1;
            iArr[1] = iW1;
        }
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().k();
    }

    public void i(n nVar, int i2) {
        o oVar = this.f3943m;
        if (oVar != null) {
            oVar.g("Cannot add item decoration during a scroll  or layout");
        }
        if (this.f3945n.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i2 < 0) {
            this.f3945n.add(nVar);
        } else {
            this.f3945n.add(i2, nVar);
        }
        x0();
        requestLayout();
    }

    public void i1(int i2) {
        if (this.f3960w) {
            return;
        }
        s1();
        o oVar = this.f3943m;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            oVar.v1(i2);
            awakenScrollBars();
        }
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.f3950q;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().m();
    }

    public void j(q qVar) {
        if (this.f3898B == null) {
            this.f3898B = new ArrayList();
        }
        this.f3898B.add(qVar);
    }

    public void k(s sVar) {
        this.o.add(sVar);
    }

    Rect k0(View view) {
        p pVar = (p) view.getLayoutParams();
        if (!pVar.f4026c) {
            return pVar.f4025b;
        }
        if (this.f3930f0.e() && (pVar.b() || pVar.d())) {
            return pVar.f4025b;
        }
        Rect rect = pVar.f4025b;
        rect.set(0, 0, 0, 0);
        int size = this.f3945n.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f3935i.set(0, 0, 0, 0);
            ((n) this.f3945n.get(i2)).g(this.f3935i, view, this, this.f3930f0);
            int i3 = rect.left;
            Rect rect2 = this.f3935i;
            rect.left = i3 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        pVar.f4026c = false;
        return rect;
    }

    boolean k1(C c2, int i2) {
        if (!v0()) {
            M.p0(c2.f3971a, i2);
            return true;
        }
        c2.f3985q = i2;
        this.f3957u0.add(c2);
        return false;
    }

    public void l(t tVar) {
        if (this.f3934h0 == null) {
            this.f3934h0 = new ArrayList();
        }
        this.f3934h0.add(tVar);
    }

    boolean l1(AccessibilityEvent accessibilityEvent) {
        if (!v0()) {
            return false;
        }
        int iA = accessibilityEvent != null ? AbstractC0358b.a(accessibilityEvent) : 0;
        this.f3963y |= iA != 0 ? iA : 0;
        return true;
    }

    void m(C c2, l.c cVar, l.c cVar2) {
        c2.F(false);
        if (this.f3908L.a(c2, cVar, cVar2)) {
            M0();
        }
    }

    public boolean m0(int i2) {
        return getScrollingChildHelper().l(i2);
    }

    public void m1(int i2, int i3) {
        n1(i2, i3, null);
    }

    public boolean n0() {
        return !this.f3954t || this.f3899C || this.f3926d.p();
    }

    public void n1(int i2, int i3, Interpolator interpolator) {
        o oVar = this.f3943m;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f3960w) {
            return;
        }
        if (!oVar.k()) {
            i2 = 0;
        }
        if (!this.f3943m.l()) {
            i3 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        this.f3925c0.h(i2, i3, interpolator);
    }

    void o(C c2, l.c cVar, l.c cVar2) {
        g(c2);
        c2.F(false);
        if (this.f3908L.c(c2, cVar, cVar2)) {
            M0();
        }
    }

    void o1() {
        int i2 = this.f3956u + 1;
        this.f3956u = i2;
        if (i2 != 1 || this.f3960w) {
            return;
        }
        this.f3958v = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x004e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            r0 = 0
            r5.f3901E = r0
            r1 = 1
            r5.f3950q = r1
            boolean r2 = r5.f3954t
            if (r2 == 0) goto L14
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L14
            goto L15
        L14:
            r1 = 0
        L15:
            r5.f3954t = r1
            androidx.recyclerview.widget.RecyclerView$o r1 = r5.f3943m
            if (r1 == 0) goto L1e
            r1.z(r5)
        L1e:
            r5.f3942l0 = r0
            boolean r0 = androidx.recyclerview.widget.RecyclerView.f3889C0
            if (r0 == 0) goto L61
            java.lang.ThreadLocal r0 = androidx.recyclerview.widget.e.e
            java.lang.Object r1 = r0.get()
            androidx.recyclerview.widget.e r1 = (androidx.recyclerview.widget.e) r1
            r5.f3927d0 = r1
            if (r1 != 0) goto L5c
            androidx.recyclerview.widget.e r1 = new androidx.recyclerview.widget.e
            r1.<init>()
            r5.f3927d0 = r1
            android.view.Display r1 = androidx.core.view.M.r(r5)
            boolean r2 = r5.isInEditMode()
            if (r2 != 0) goto L4e
            if (r1 == 0) goto L4e
            float r1 = r1.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L4e
            goto L50
        L4e:
            r1 = 1114636288(0x42700000, float:60.0)
        L50:
            androidx.recyclerview.widget.e r2 = r5.f3927d0
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.f4204c = r3
            r0.set(r2)
        L5c:
            androidx.recyclerview.widget.e r0 = r5.f3927d0
            r0.a(r5)
        L61:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        androidx.recyclerview.widget.e eVar;
        super.onDetachedFromWindow();
        l lVar = this.f3908L;
        if (lVar != null) {
            lVar.k();
        }
        s1();
        this.f3950q = false;
        o oVar = this.f3943m;
        if (oVar != null) {
            oVar.A(this, this.f3922b);
        }
        this.f3957u0.clear();
        removeCallbacks(this.f3959v0);
        this.f3929f.j();
        if (!f3889C0 || (eVar = this.f3927d0) == null) {
            return;
        }
        eVar.j(this);
        this.f3927d0 = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.f3945n.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((n) this.f3945n.get(i2)).i(canvas, this, this.f3930f0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x006c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView$o r0 = r5.f3943m
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.f3960w
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L79
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3e
            androidx.recyclerview.widget.RecyclerView$o r0 = r5.f3943m
            boolean r0 = r0.l()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = 0
        L2d:
            androidx.recyclerview.widget.RecyclerView$o r3 = r5.f3943m
            boolean r3 = r3.k()
            if (r3 == 0) goto L3c
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L64
        L3c:
            r3 = 0
            goto L64
        L3e:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L62
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            androidx.recyclerview.widget.RecyclerView$o r3 = r5.f3943m
            boolean r3 = r3.l()
            if (r3 == 0) goto L57
            float r0 = -r0
            goto L3c
        L57:
            androidx.recyclerview.widget.RecyclerView$o r3 = r5.f3943m
            boolean r3 = r3.k()
            if (r3 == 0) goto L62
            r3 = r0
            r0 = 0
            goto L64
        L62:
            r0 = 0
            goto L3c
        L64:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6c
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L79
        L6c:
            float r2 = r5.f3919W
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.f3921a0
            float r0 = r0 * r3
            int r0 = (int) r0
            r5.g1(r2, r0, r6)
        L79:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        if (this.f3960w) {
            return false;
        }
        if (J(motionEvent)) {
            r();
            return true;
        }
        o oVar = this.f3943m;
        if (oVar == null) {
            return false;
        }
        boolean zK = oVar.k();
        boolean zL = this.f3943m.l();
        if (this.f3911O == null) {
            this.f3911O = VelocityTracker.obtain();
        }
        this.f3911O.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.f3962x) {
                this.f3962x = false;
            }
            this.f3910N = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.f3914R = x2;
            this.f3912P = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.f3915S = y2;
            this.f3913Q = y2;
            if (this.f3909M == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
            int[] iArr = this.f3953s0;
            iArr[1] = 0;
            iArr[0] = 0;
            int i2 = zK;
            if (zL) {
                i2 = (zK ? 1 : 0) | 2;
            }
            p1(i2, 0);
        } else if (actionMasked == 1) {
            this.f3911O.clear();
            r1(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.f3910N);
            if (iFindPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f3910N + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x3 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.f3909M != 1) {
                int i3 = x3 - this.f3912P;
                int i4 = y3 - this.f3913Q;
                if (zK == 0 || Math.abs(i3) <= this.f3916T) {
                    z2 = false;
                } else {
                    this.f3914R = x3;
                    z2 = true;
                }
                if (zL && Math.abs(i4) > this.f3916T) {
                    this.f3915S = y3;
                    z2 = true;
                }
                if (z2) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            r();
        } else if (actionMasked == 5) {
            this.f3910N = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.f3914R = x4;
            this.f3912P = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.f3915S = y4;
            this.f3913Q = y4;
        } else if (actionMasked == 6) {
            J0(motionEvent);
        }
        return this.f3909M == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        androidx.core.os.o.a("RV OnLayout");
        C();
        androidx.core.os.o.b();
        this.f3954t = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        o oVar = this.f3943m;
        if (oVar == null) {
            x(i2, i3);
            return;
        }
        if (oVar.r0()) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.f3943m.Y0(this.f3922b, this.f3930f0, i2, i3);
            if ((mode == 1073741824 && mode2 == 1073741824) || this.f3941l == null) {
                return;
            }
            if (this.f3930f0.e == 1) {
                D();
            }
            this.f3943m.y1(i2, i3);
            this.f3930f0.f4051j = true;
            E();
            this.f3943m.B1(i2, i3);
            if (this.f3943m.E1()) {
                this.f3943m.y1(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.f3930f0.f4051j = true;
                E();
                this.f3943m.B1(i2, i3);
                return;
            }
            return;
        }
        if (this.r) {
            this.f3943m.Y0(this.f3922b, this.f3930f0, i2, i3);
            return;
        }
        if (this.f3964z) {
            o1();
            G0();
            O0();
            H0();
            z zVar = this.f3930f0;
            if (zVar.f4053l) {
                zVar.f4049h = true;
            } else {
                this.f3926d.j();
                this.f3930f0.f4049h = false;
            }
            this.f3964z = false;
            q1(false);
        } else if (this.f3930f0.f4053l) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        g gVar = this.f3941l;
        if (gVar != null) {
            this.f3930f0.f4047f = gVar.c();
        } else {
            this.f3930f0.f4047f = 0;
        }
        o1();
        this.f3943m.Y0(this.f3922b, this.f3930f0, i2, i3);
        q1(false);
        this.f3930f0.f4049h = false;
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (v0()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof y)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        y yVar = (y) parcelable;
        this.f3924c = yVar;
        super.onRestoreInstanceState(yVar.a());
        o oVar = this.f3943m;
        if (oVar == null || (parcelable2 = this.f3924c.f4042c) == null) {
            return;
        }
        oVar.b1(parcelable2);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        y yVar = new y(super.onSaveInstanceState());
        y yVar2 = this.f3924c;
        if (yVar2 != null) {
            yVar.b(yVar2);
        } else {
            o oVar = this.f3943m;
            if (oVar != null) {
                yVar.f4042c = oVar.c1();
            } else {
                yVar.f4042c = null;
            }
        }
        return yVar;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 == i4 && i3 == i5) {
            return;
        }
        t0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0109  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r15) {
        /*
            Method dump skipped, instructions count: 444
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    void p(String str) {
        if (v0()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + R());
        }
        if (this.f3902F > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + R()));
        }
    }

    void p0() {
        this.f3926d = new a(new f());
    }

    public boolean p1(int i2, int i3) {
        return getScrollingChildHelper().q(i2, i3);
    }

    boolean q(C c2) {
        l lVar = this.f3908L;
        return lVar == null || lVar.g(c2, c2.o());
    }

    void q1(boolean z2) {
        if (this.f3956u < 1) {
            this.f3956u = 1;
        }
        if (!z2 && !this.f3960w) {
            this.f3958v = false;
        }
        if (this.f3956u == 1) {
            if (z2 && this.f3958v && !this.f3960w && this.f3943m != null && this.f3941l != null) {
                C();
            }
            if (!this.f3960w) {
                this.f3958v = false;
            }
        }
        this.f3956u--;
    }

    public void r1(int i2) {
        getScrollingChildHelper().s(i2);
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z2) {
        C cG0 = g0(view);
        if (cG0 != null) {
            if (cG0.w()) {
                cG0.f();
            } else if (!cG0.I()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + cG0 + R());
            }
        }
        view.clearAnimation();
        A(view);
        super.removeDetachedView(view, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.f3943m.a1(this, this.f3930f0, view, view2) && view2 != null) {
            b1(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        return this.f3943m.p1(this, view, rect, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        int size = this.o.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((s) this.o.get(i2)).e(z2);
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f3956u != 0 || this.f3960w) {
            this.f3958v = true;
        } else {
            super.requestLayout();
        }
    }

    void s0(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new androidx.recyclerview.widget.d(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(K.a.f249a), resources.getDimensionPixelSize(K.a.f251c), resources.getDimensionPixelOffset(K.a.f250b));
        } else {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + R());
        }
    }

    public void s1() {
        setScrollState(0);
        t1();
    }

    @Override // android.view.View
    public void scrollBy(int i2, int i3) {
        o oVar = this.f3943m;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f3960w) {
            return;
        }
        boolean zK = oVar.k();
        boolean zL = this.f3943m.l();
        if (zK || zL) {
            if (!zK) {
                i2 = 0;
            }
            if (!zL) {
                i3 = 0;
            }
            g1(i2, i3, null);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (l1(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(androidx.recyclerview.widget.l lVar) {
        this.f3944m0 = lVar;
        M.f0(this, lVar);
    }

    public void setAdapter(g gVar) {
        setLayoutFrozen(false);
        j1(gVar, false, true);
        P0(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(j jVar) {
        if (jVar == this.f3946n0) {
            return;
        }
        setChildrenDrawingOrderEnabled(jVar != null);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z2) {
        if (z2 != this.f3931g) {
            t0();
        }
        this.f3931g = z2;
        super.setClipToPadding(z2);
        if (this.f3954t) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(k kVar) {
        AbstractC0345h.f(kVar);
        this.f3903G = kVar;
        t0();
    }

    public void setHasFixedSize(boolean z2) {
        this.r = z2;
    }

    public void setItemAnimator(l lVar) {
        l lVar2 = this.f3908L;
        if (lVar2 != null) {
            lVar2.k();
            this.f3908L.w(null);
        }
        this.f3908L = lVar;
        if (lVar != null) {
            lVar.w(this.f3940k0);
        }
    }

    public void setItemViewCacheSize(int i2) {
        this.f3922b.G(i2);
    }

    public void setLayoutFrozen(boolean z2) {
        if (z2 != this.f3960w) {
            p("Do not setLayoutFrozen in layout or scroll");
            if (z2) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
                this.f3960w = true;
                this.f3962x = true;
                s1();
                return;
            }
            this.f3960w = false;
            if (this.f3958v && this.f3943m != null && this.f3941l != null) {
                requestLayout();
            }
            this.f3958v = false;
        }
    }

    public void setLayoutManager(o oVar) {
        if (oVar == this.f3943m) {
            return;
        }
        s1();
        if (this.f3943m != null) {
            l lVar = this.f3908L;
            if (lVar != null) {
                lVar.k();
            }
            this.f3943m.i1(this.f3922b);
            this.f3943m.j1(this.f3922b);
            this.f3922b.c();
            if (this.f3950q) {
                this.f3943m.A(this, this.f3922b);
            }
            this.f3943m.C1(null);
            this.f3943m = null;
        } else {
            this.f3922b.c();
        }
        this.e.o();
        this.f3943m = oVar;
        if (oVar != null) {
            if (oVar.f4004b != null) {
                throw new IllegalArgumentException("LayoutManager " + oVar + " is already attached to a RecyclerView:" + oVar.f4004b.R());
            }
            oVar.C1(this);
            if (this.f3950q) {
                this.f3943m.z(this);
            }
        }
        this.f3922b.K();
        requestLayout();
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z2) {
        getScrollingChildHelper().n(z2);
    }

    public void setOnFlingListener(r rVar) {
    }

    @Deprecated
    public void setOnScrollListener(t tVar) {
        this.f3932g0 = tVar;
    }

    public void setPreserveFocusAfterLayout(boolean z2) {
        this.f3923b0 = z2;
    }

    public void setRecycledViewPool(u uVar) {
        this.f3922b.E(uVar);
    }

    public void setRecyclerListener(w wVar) {
    }

    void setScrollState(int i2) {
        if (i2 == this.f3909M) {
            return;
        }
        this.f3909M = i2;
        if (i2 != 2) {
            t1();
        }
        K(i2);
    }

    public void setScrollingTouchSlop(int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i2 != 0) {
            if (i2 == 1) {
                this.f3916T = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i2 + "; using default value");
        }
        this.f3916T = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(A a2) {
        this.f3922b.F(a2);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().p(i2);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        getScrollingChildHelper().r();
    }

    void t() {
        int iJ = this.e.j();
        for (int i2 = 0; i2 < iJ; i2++) {
            C cG0 = g0(this.e.i(i2));
            if (!cG0.I()) {
                cG0.c();
            }
        }
        this.f3922b.d();
    }

    void t0() {
        this.f3907K = null;
        this.f3905I = null;
        this.f3906J = null;
        this.f3904H = null;
    }

    void u(int i2, int i3) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.f3904H;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            zIsFinished = false;
        } else {
            this.f3904H.onRelease();
            zIsFinished = this.f3904H.isFinished();
        }
        EdgeEffect edgeEffect2 = this.f3906J;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.f3906J.onRelease();
            zIsFinished |= this.f3906J.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f3905I;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.f3905I.onRelease();
            zIsFinished |= this.f3905I.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f3907K;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.f3907K.onRelease();
            zIsFinished |= this.f3907K.isFinished();
        }
        if (zIsFinished) {
            M.Z(this);
        }
    }

    boolean u0() {
        AccessibilityManager accessibilityManager = this.f3897A;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    void u1(int i2, int i3, Object obj) {
        int i4;
        int iJ = this.e.j();
        int i5 = i2 + i3;
        for (int i6 = 0; i6 < iJ; i6++) {
            View viewI = this.e.i(i6);
            C cG0 = g0(viewI);
            if (cG0 != null && !cG0.I() && (i4 = cG0.f3973c) >= i2 && i4 < i5) {
                cG0.b(2);
                cG0.a(obj);
                ((p) viewI.getLayoutParams()).f4026c = true;
            }
        }
        this.f3922b.M(i2, i3);
    }

    void v() {
        if (!this.f3954t || this.f3899C) {
            androidx.core.os.o.a("RV FullInvalidate");
            C();
            androidx.core.os.o.b();
            return;
        }
        if (this.f3926d.p()) {
            if (!this.f3926d.o(4) || this.f3926d.o(11)) {
                if (this.f3926d.p()) {
                    androidx.core.os.o.a("RV FullInvalidate");
                    C();
                    androidx.core.os.o.b();
                    return;
                }
                return;
            }
            androidx.core.os.o.a("RV PartialInvalidate");
            o1();
            G0();
            this.f3926d.u();
            if (!this.f3958v) {
                if (o0()) {
                    C();
                } else {
                    this.f3926d.i();
                }
            }
            q1(true);
            H0();
            androidx.core.os.o.b();
        }
    }

    public boolean v0() {
        return this.f3901E > 0;
    }

    void x(int i2, int i3) {
        setMeasuredDimension(o.n(i2, getPaddingLeft() + getPaddingRight(), M.A(this)), o.n(i3, getPaddingTop() + getPaddingBottom(), M.z(this)));
    }

    void x0() {
        int iJ = this.e.j();
        for (int i2 = 0; i2 < iJ; i2++) {
            ((p) this.e.i(i2).getLayoutParams()).f4026c = true;
        }
        this.f3922b.s();
    }

    void y0() {
        int iJ = this.e.j();
        for (int i2 = 0; i2 < iJ; i2++) {
            C cG0 = g0(this.e.i(i2));
            if (cG0 != null && !cG0.I()) {
                cG0.b(6);
            }
        }
        x0();
        this.f3922b.t();
    }

    void z(View view) {
        C cG0 = g0(view);
        E0(view);
        g gVar = this.f3941l;
        if (gVar != null && cG0 != null) {
            gVar.p(cG0);
        }
        List list = this.f3898B;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((q) this.f3898B.get(size)).c(view);
            }
        }
    }

    public void z0(int i2) {
        int iG = this.e.g();
        for (int i3 = 0; i3 < iG; i3++) {
            this.e.f(i3).offsetLeftAndRight(i2);
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i2) throws NoSuchMethodException, SecurityException {
        super(context, attributeSet, i2);
        this.f3920a = new x();
        this.f3922b = new v();
        this.f3929f = new androidx.recyclerview.widget.p();
        this.f3933h = new RunnableC0208a();
        this.f3935i = new Rect();
        this.f3937j = new Rect();
        this.f3939k = new RectF();
        this.f3945n = new ArrayList();
        this.o = new ArrayList();
        this.f3956u = 0;
        this.f3899C = false;
        this.f3900D = false;
        this.f3901E = 0;
        this.f3902F = 0;
        this.f3903G = new k();
        this.f3908L = new c();
        this.f3909M = 0;
        this.f3910N = -1;
        this.f3919W = Float.MIN_VALUE;
        this.f3921a0 = Float.MIN_VALUE;
        boolean z2 = true;
        this.f3923b0 = true;
        this.f3925c0 = new B();
        this.f3928e0 = f3889C0 ? new e.b() : null;
        this.f3930f0 = new z();
        this.f3936i0 = false;
        this.f3938j0 = false;
        this.f3940k0 = new m();
        this.f3942l0 = false;
        this.f3947o0 = new int[2];
        this.f3951q0 = new int[2];
        this.f3952r0 = new int[2];
        this.f3953s0 = new int[2];
        this.f3955t0 = new int[2];
        this.f3957u0 = new ArrayList();
        this.f3959v0 = new RunnableC0209b();
        this.f3961w0 = new d();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f3895y0, i2, 0);
            this.f3931g = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
        } else {
            this.f3931g = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f3916T = viewConfiguration.getScaledTouchSlop();
        this.f3919W = Q.f(viewConfiguration, context);
        this.f3921a0 = Q.j(viewConfiguration, context);
        this.f3917U = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f3918V = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.f3908L.w(this.f3940k0);
        p0();
        r0();
        q0();
        if (M.w(this) == 0) {
            M.p0(this, 1);
        }
        this.f3897A = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new androidx.recyclerview.widget.l(this));
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, K.c.f261h, i2, 0);
            String string = typedArrayObtainStyledAttributes2.getString(K.c.f268p);
            if (typedArrayObtainStyledAttributes2.getInt(K.c.f263j, -1) == -1) {
                setDescendantFocusability(262144);
            }
            boolean z3 = typedArrayObtainStyledAttributes2.getBoolean(K.c.f264k, false);
            this.s = z3;
            if (z3) {
                s0((StateListDrawable) typedArrayObtainStyledAttributes2.getDrawable(K.c.f267n), typedArrayObtainStyledAttributes2.getDrawable(K.c.o), (StateListDrawable) typedArrayObtainStyledAttributes2.getDrawable(K.c.f265l), typedArrayObtainStyledAttributes2.getDrawable(K.c.f266m));
            }
            typedArrayObtainStyledAttributes2.recycle();
            w(context, string, attributeSet, i2, 0);
            TypedArray typedArrayObtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f3894x0, i2, 0);
            z2 = typedArrayObtainStyledAttributes3.getBoolean(0, true);
            typedArrayObtainStyledAttributes3.recycle();
        } else {
            setDescendantFocusability(262144);
        }
        setNestedScrollingEnabled(z2);
    }

    public static class p extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        C f4024a;

        /* renamed from: b */
        final Rect f4025b;

        /* renamed from: c */
        boolean f4026c;

        /* renamed from: d */
        boolean f4027d;

        public p(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f4025b = new Rect();
            this.f4026c = true;
            this.f4027d = false;
        }

        public int a() {
            return this.f4024a.m();
        }

        public boolean b() {
            return this.f4024a.x();
        }

        public boolean c() {
            return this.f4024a.u();
        }

        public boolean d() {
            return this.f4024a.s();
        }

        public p(int i2, int i3) {
            super(i2, i3);
            this.f4025b = new Rect();
            this.f4026c = true;
            this.f4027d = false;
        }

        public p(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f4025b = new Rect();
            this.f4026c = true;
            this.f4027d = false;
        }

        public p(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f4025b = new Rect();
            this.f4026c = true;
            this.f4027d = false;
        }

        public p(p pVar) {
            super((ViewGroup.LayoutParams) pVar);
            this.f4025b = new Rect();
            this.f4026c = true;
            this.f4027d = false;
        }
    }

    public static class y extends A.a {
        public static final Parcelable.Creator<y> CREATOR = new a();

        /* renamed from: c */
        Parcelable f4042c;

        static class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public y createFromParcel(Parcel parcel) {
                return new y(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b */
            public y createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new y(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c */
            public y[] newArray(int i2) {
                return new y[i2];
            }
        }

        y(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f4042c = parcel.readParcelable(classLoader == null ? o.class.getClassLoader() : classLoader);
        }

        void b(y yVar) {
            this.f4042c = yVar.f4042c;
        }

        @Override // A.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeParcelable(this.f4042c, 0);
        }

        y(Parcelable parcelable) {
            super(parcelable);
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        o oVar = this.f3943m;
        if (oVar != null) {
            return oVar.F(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + R());
    }
}
