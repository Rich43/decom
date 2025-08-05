package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import androidx.core.view.C0175s;
import androidx.core.view.M;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class f extends RecyclerView.n implements RecyclerView.q {

    /* renamed from: A, reason: collision with root package name */
    private C0054f f4214A;

    /* renamed from: C, reason: collision with root package name */
    private Rect f4216C;

    /* renamed from: D, reason: collision with root package name */
    private long f4217D;

    /* renamed from: d, reason: collision with root package name */
    float f4221d;
    float e;

    /* renamed from: f, reason: collision with root package name */
    private float f4222f;

    /* renamed from: g, reason: collision with root package name */
    private float f4223g;

    /* renamed from: h, reason: collision with root package name */
    float f4224h;

    /* renamed from: i, reason: collision with root package name */
    float f4225i;

    /* renamed from: j, reason: collision with root package name */
    private float f4226j;

    /* renamed from: k, reason: collision with root package name */
    private float f4227k;

    /* renamed from: m, reason: collision with root package name */
    e f4229m;
    int o;

    /* renamed from: q, reason: collision with root package name */
    private int f4232q;
    RecyclerView r;

    /* renamed from: t, reason: collision with root package name */
    VelocityTracker f4233t;

    /* renamed from: u, reason: collision with root package name */
    private List f4234u;

    /* renamed from: v, reason: collision with root package name */
    private List f4235v;

    /* renamed from: w, reason: collision with root package name */
    private RecyclerView.j f4236w;

    /* renamed from: z, reason: collision with root package name */
    C0175s f4239z;

    /* renamed from: a, reason: collision with root package name */
    final List f4218a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final float[] f4219b = new float[2];

    /* renamed from: c, reason: collision with root package name */
    RecyclerView.C f4220c = null;

    /* renamed from: l, reason: collision with root package name */
    int f4228l = -1;

    /* renamed from: n, reason: collision with root package name */
    private int f4230n = 0;

    /* renamed from: p, reason: collision with root package name */
    List f4231p = new ArrayList();
    final Runnable s = new a();

    /* renamed from: x, reason: collision with root package name */
    View f4237x = null;

    /* renamed from: y, reason: collision with root package name */
    int f4238y = -1;

    /* renamed from: B, reason: collision with root package name */
    private final RecyclerView.s f4215B = new b();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar = f.this;
            if (fVar.f4220c == null || !fVar.E()) {
                return;
            }
            f fVar2 = f.this;
            RecyclerView.C c2 = fVar2.f4220c;
            if (c2 != null) {
                fVar2.z(c2);
            }
            f fVar3 = f.this;
            fVar3.r.removeCallbacks(fVar3.s);
            M.a0(f.this.r, this);
        }
    }

    class b implements RecyclerView.s {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
            int iFindPointerIndex;
            g gVarS;
            f.this.f4239z.a(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                f.this.f4228l = motionEvent.getPointerId(0);
                f.this.f4221d = motionEvent.getX();
                f.this.e = motionEvent.getY();
                f.this.A();
                f fVar = f.this;
                if (fVar.f4220c == null && (gVarS = fVar.s(motionEvent)) != null) {
                    f fVar2 = f.this;
                    fVar2.f4221d -= gVarS.f4260j;
                    fVar2.e -= gVarS.f4261k;
                    fVar2.r(gVarS.e, true);
                    if (f.this.f4218a.remove(gVarS.e.f3971a)) {
                        f fVar3 = f.this;
                        fVar3.f4229m.c(fVar3.r, gVarS.e);
                    }
                    f.this.F(gVarS.e, gVarS.f4256f);
                    f fVar4 = f.this;
                    fVar4.K(motionEvent, fVar4.o, 0);
                }
            } else if (actionMasked == 3 || actionMasked == 1) {
                f fVar5 = f.this;
                fVar5.f4228l = -1;
                fVar5.F(null, 0);
            } else {
                int i2 = f.this.f4228l;
                if (i2 != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i2)) >= 0) {
                    f.this.o(actionMasked, motionEvent, iFindPointerIndex);
                }
            }
            VelocityTracker velocityTracker = f.this.f4233t;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            return f.this.f4220c != null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void b(RecyclerView recyclerView, MotionEvent motionEvent) {
            f.this.f4239z.a(motionEvent);
            VelocityTracker velocityTracker = f.this.f4233t;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (f.this.f4228l == -1) {
                return;
            }
            int actionMasked = motionEvent.getActionMasked();
            int iFindPointerIndex = motionEvent.findPointerIndex(f.this.f4228l);
            if (iFindPointerIndex >= 0) {
                f.this.o(actionMasked, motionEvent, iFindPointerIndex);
            }
            f fVar = f.this;
            RecyclerView.C c2 = fVar.f4220c;
            if (c2 == null) {
                return;
            }
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (iFindPointerIndex >= 0) {
                        fVar.K(motionEvent, fVar.o, iFindPointerIndex);
                        f.this.z(c2);
                        f fVar2 = f.this;
                        fVar2.r.removeCallbacks(fVar2.s);
                        f.this.s.run();
                        f.this.r.invalidate();
                        return;
                    }
                    return;
                }
                if (actionMasked != 3) {
                    if (actionMasked != 6) {
                        return;
                    }
                    int actionIndex = motionEvent.getActionIndex();
                    int pointerId = motionEvent.getPointerId(actionIndex);
                    f fVar3 = f.this;
                    if (pointerId == fVar3.f4228l) {
                        fVar3.f4228l = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
                        f fVar4 = f.this;
                        fVar4.K(motionEvent, fVar4.o, actionIndex);
                        return;
                    }
                    return;
                }
                VelocityTracker velocityTracker2 = fVar.f4233t;
                if (velocityTracker2 != null) {
                    velocityTracker2.clear();
                }
            }
            f.this.F(null, 0);
            f.this.f4228l = -1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void e(boolean z2) {
            if (z2) {
                f.this.F(null, 0);
            }
        }
    }

    class c extends g {
        final /* synthetic */ int o;

        /* renamed from: p, reason: collision with root package name */
        final /* synthetic */ RecyclerView.C f4242p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(RecyclerView.C c2, int i2, int i3, float f2, float f3, float f4, float f5, int i4, RecyclerView.C c3) {
            super(c2, i2, i3, f2, f3, f4, f5);
            this.o = i4;
            this.f4242p = c3;
        }

        @Override // androidx.recyclerview.widget.f.g, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (this.f4262l) {
                return;
            }
            if (this.o <= 0) {
                f fVar = f.this;
                fVar.f4229m.c(fVar.r, this.f4242p);
            } else {
                f.this.f4218a.add(this.f4242p.f3971a);
                this.f4259i = true;
                int i2 = this.o;
                if (i2 > 0) {
                    f.this.B(this, i2);
                }
            }
            f fVar2 = f.this;
            View view = fVar2.f4237x;
            View view2 = this.f4242p.f3971a;
            if (view == view2) {
                fVar2.D(view2);
            }
        }
    }

    class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f4244a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f4245b;

        d(g gVar, int i2) {
            this.f4244a = gVar;
            this.f4245b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = f.this.r;
            if (recyclerView == null || !recyclerView.isAttachedToWindow()) {
                return;
            }
            g gVar = this.f4244a;
            if (gVar.f4262l || gVar.e.j() == -1) {
                return;
            }
            RecyclerView.l itemAnimator = f.this.r.getItemAnimator();
            if ((itemAnimator == null || !itemAnimator.q(null)) && !f.this.x()) {
                f.this.f4229m.B(this.f4244a.e, this.f4245b);
            } else {
                f.this.r.post(this);
            }
        }
    }

    public static abstract class e {

        /* renamed from: b, reason: collision with root package name */
        private static final Interpolator f4247b = new a();

        /* renamed from: c, reason: collision with root package name */
        private static final Interpolator f4248c = new b();

        /* renamed from: a, reason: collision with root package name */
        private int f4249a = -1;

        static class a implements Interpolator {
            a() {
            }

            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f2) {
                return f2 * f2 * f2 * f2 * f2;
            }
        }

        static class b implements Interpolator {
            b() {
            }

            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f2) {
                float f3 = f2 - 1.0f;
                return (f3 * f3 * f3 * f3 * f3) + 1.0f;
            }
        }

        public static int e(int i2, int i3) {
            int i4;
            int i5 = i2 & 789516;
            if (i5 == 0) {
                return i2;
            }
            int i6 = i2 & (~i5);
            if (i3 == 0) {
                i4 = i5 << 2;
            } else {
                int i7 = i5 << 1;
                i6 |= (-789517) & i7;
                i4 = (i7 & 789516) << 2;
            }
            return i6 | i4;
        }

        private int i(RecyclerView recyclerView) {
            if (this.f4249a == -1) {
                this.f4249a = recyclerView.getResources().getDimensionPixelSize(K.a.f252d);
            }
            return this.f4249a;
        }

        public static int s(int i2, int i3) {
            return i3 << (i2 * 8);
        }

        public static int t(int i2, int i3) {
            return s(2, i2) | s(1, i3) | s(0, i3 | i2);
        }

        public void A(RecyclerView.C c2, int i2) {
            if (c2 != null) {
                androidx.recyclerview.widget.h.f4266a.d(c2.f3971a);
            }
        }

        public abstract void B(RecyclerView.C c2, int i2);

        public boolean a(RecyclerView recyclerView, RecyclerView.C c2, RecyclerView.C c3) {
            return true;
        }

        public RecyclerView.C b(RecyclerView.C c2, List list, int i2, int i3) {
            int bottom;
            int iAbs;
            int top;
            int iAbs2;
            int left;
            int iAbs3;
            int right;
            int iAbs4;
            int width = i2 + c2.f3971a.getWidth();
            int height = i3 + c2.f3971a.getHeight();
            int left2 = i2 - c2.f3971a.getLeft();
            int top2 = i3 - c2.f3971a.getTop();
            int size = list.size();
            RecyclerView.C c3 = null;
            int i4 = -1;
            for (int i5 = 0; i5 < size; i5++) {
                RecyclerView.C c4 = (RecyclerView.C) list.get(i5);
                if (left2 > 0 && (right = c4.f3971a.getRight() - width) < 0 && c4.f3971a.getRight() > c2.f3971a.getRight() && (iAbs4 = Math.abs(right)) > i4) {
                    c3 = c4;
                    i4 = iAbs4;
                }
                if (left2 < 0 && (left = c4.f3971a.getLeft() - i2) > 0 && c4.f3971a.getLeft() < c2.f3971a.getLeft() && (iAbs3 = Math.abs(left)) > i4) {
                    c3 = c4;
                    i4 = iAbs3;
                }
                if (top2 < 0 && (top = c4.f3971a.getTop() - i3) > 0 && c4.f3971a.getTop() < c2.f3971a.getTop() && (iAbs2 = Math.abs(top)) > i4) {
                    c3 = c4;
                    i4 = iAbs2;
                }
                if (top2 > 0 && (bottom = c4.f3971a.getBottom() - height) < 0 && c4.f3971a.getBottom() > c2.f3971a.getBottom() && (iAbs = Math.abs(bottom)) > i4) {
                    c3 = c4;
                    i4 = iAbs;
                }
            }
            return c3;
        }

        public void c(RecyclerView recyclerView, RecyclerView.C c2) {
            androidx.recyclerview.widget.h.f4266a.a(c2.f3971a);
        }

        public int d(int i2, int i3) {
            int i4;
            int i5 = i2 & 3158064;
            if (i5 == 0) {
                return i2;
            }
            int i6 = i2 & (~i5);
            if (i3 == 0) {
                i4 = i5 >> 2;
            } else {
                int i7 = i5 >> 1;
                i6 |= (-3158065) & i7;
                i4 = (i7 & 3158064) >> 2;
            }
            return i6 | i4;
        }

        final int f(RecyclerView recyclerView, RecyclerView.C c2) {
            return d(k(recyclerView, c2), M.y(recyclerView));
        }

        public long g(RecyclerView recyclerView, int i2, float f2, float f3) {
            RecyclerView.l itemAnimator = recyclerView.getItemAnimator();
            return itemAnimator == null ? i2 == 8 ? 200L : 250L : i2 == 8 ? itemAnimator.n() : itemAnimator.o();
        }

        public int h() {
            return 0;
        }

        public float j(RecyclerView.C c2) {
            return 0.5f;
        }

        public abstract int k(RecyclerView recyclerView, RecyclerView.C c2);

        public float l(float f2) {
            return f2;
        }

        public float m(RecyclerView.C c2) {
            return 0.5f;
        }

        public float n(float f2) {
            return f2;
        }

        boolean o(RecyclerView recyclerView, RecyclerView.C c2) {
            return (f(recyclerView, c2) & 16711680) != 0;
        }

        public int p(RecyclerView recyclerView, int i2, int i3, int i4, long j2) {
            int iSignum = (int) (((int) (((int) Math.signum(i3)) * i(recyclerView) * f4248c.getInterpolation(Math.min(1.0f, (Math.abs(i3) * 1.0f) / i2)))) * f4247b.getInterpolation(j2 <= 2000 ? j2 / 2000.0f : 1.0f));
            return iSignum == 0 ? i3 > 0 ? 1 : -1 : iSignum;
        }

        public boolean q() {
            return true;
        }

        public boolean r() {
            return true;
        }

        public void u(Canvas canvas, RecyclerView recyclerView, RecyclerView.C c2, float f2, float f3, int i2, boolean z2) {
            androidx.recyclerview.widget.h.f4266a.c(canvas, recyclerView, c2.f3971a, f2, f3, i2, z2);
        }

        public void v(Canvas canvas, RecyclerView recyclerView, RecyclerView.C c2, float f2, float f3, int i2, boolean z2) {
            androidx.recyclerview.widget.h.f4266a.b(canvas, recyclerView, c2.f3971a, f2, f3, i2, z2);
        }

        void w(Canvas canvas, RecyclerView recyclerView, RecyclerView.C c2, List list, int i2, float f2, float f3) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                g gVar = (g) list.get(i3);
                gVar.e();
                int iSave = canvas.save();
                u(canvas, recyclerView, gVar.e, gVar.f4260j, gVar.f4261k, gVar.f4256f, false);
                canvas.restoreToCount(iSave);
            }
            if (c2 != null) {
                int iSave2 = canvas.save();
                u(canvas, recyclerView, c2, f2, f3, i2, true);
                canvas.restoreToCount(iSave2);
            }
        }

        void x(Canvas canvas, RecyclerView recyclerView, RecyclerView.C c2, List list, int i2, float f2, float f3) {
            int size = list.size();
            boolean z2 = false;
            for (int i3 = 0; i3 < size; i3++) {
                g gVar = (g) list.get(i3);
                int iSave = canvas.save();
                v(canvas, recyclerView, gVar.e, gVar.f4260j, gVar.f4261k, gVar.f4256f, false);
                canvas.restoreToCount(iSave);
            }
            if (c2 != null) {
                int iSave2 = canvas.save();
                v(canvas, recyclerView, c2, f2, f3, i2, true);
                canvas.restoreToCount(iSave2);
            }
            for (int i4 = size - 1; i4 >= 0; i4--) {
                g gVar2 = (g) list.get(i4);
                boolean z3 = gVar2.f4263m;
                if (z3 && !gVar2.f4259i) {
                    list.remove(i4);
                } else if (!z3) {
                    z2 = true;
                }
            }
            if (z2) {
                recyclerView.invalidate();
            }
        }

        public abstract boolean y(RecyclerView recyclerView, RecyclerView.C c2, RecyclerView.C c3);

        /* JADX WARN: Multi-variable type inference failed */
        public void z(RecyclerView recyclerView, RecyclerView.C c2, int i2, RecyclerView.C c3, int i3, int i4, int i5) {
            RecyclerView.o layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof h) {
                ((h) layoutManager).a(c2.f3971a, c3.f3971a, i4, i5);
                return;
            }
            if (layoutManager.k()) {
                if (layoutManager.Q(c3.f3971a) <= recyclerView.getPaddingLeft()) {
                    recyclerView.i1(i3);
                }
                if (layoutManager.T(c3.f3971a) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.i1(i3);
                }
            }
            if (layoutManager.l()) {
                if (layoutManager.U(c3.f3971a) <= recyclerView.getPaddingTop()) {
                    recyclerView.i1(i3);
                }
                if (layoutManager.O(c3.f3971a) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.i1(i3);
                }
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.f$f, reason: collision with other inner class name */
    private class C0054f extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: a, reason: collision with root package name */
        private boolean f4250a = true;

        C0054f() {
        }

        void a() {
            this.f4250a = false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            View viewT;
            RecyclerView.C cF0;
            if (!this.f4250a || (viewT = f.this.t(motionEvent)) == null || (cF0 = f.this.r.f0(viewT)) == null) {
                return;
            }
            f fVar = f.this;
            if (fVar.f4229m.o(fVar.r, cF0)) {
                int pointerId = motionEvent.getPointerId(0);
                int i2 = f.this.f4228l;
                if (pointerId == i2) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(i2);
                    float x2 = motionEvent.getX(iFindPointerIndex);
                    float y2 = motionEvent.getY(iFindPointerIndex);
                    f fVar2 = f.this;
                    fVar2.f4221d = x2;
                    fVar2.e = y2;
                    fVar2.f4225i = 0.0f;
                    fVar2.f4224h = 0.0f;
                    if (fVar2.f4229m.r()) {
                        f.this.F(cF0, 2);
                    }
                }
            }
        }
    }

    private static class g implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        final float f4252a;

        /* renamed from: b, reason: collision with root package name */
        final float f4253b;

        /* renamed from: c, reason: collision with root package name */
        final float f4254c;

        /* renamed from: d, reason: collision with root package name */
        final float f4255d;
        final RecyclerView.C e;

        /* renamed from: f, reason: collision with root package name */
        final int f4256f;

        /* renamed from: g, reason: collision with root package name */
        private final ValueAnimator f4257g;

        /* renamed from: h, reason: collision with root package name */
        final int f4258h;

        /* renamed from: i, reason: collision with root package name */
        boolean f4259i;

        /* renamed from: j, reason: collision with root package name */
        float f4260j;

        /* renamed from: k, reason: collision with root package name */
        float f4261k;

        /* renamed from: l, reason: collision with root package name */
        boolean f4262l = false;

        /* renamed from: m, reason: collision with root package name */
        boolean f4263m = false;

        /* renamed from: n, reason: collision with root package name */
        private float f4264n;

        class a implements ValueAnimator.AnimatorUpdateListener {
            a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                g.this.c(valueAnimator.getAnimatedFraction());
            }
        }

        g(RecyclerView.C c2, int i2, int i3, float f2, float f3, float f4, float f5) {
            this.f4256f = i3;
            this.f4258h = i2;
            this.e = c2;
            this.f4252a = f2;
            this.f4253b = f3;
            this.f4254c = f4;
            this.f4255d = f5;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f4257g = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new a());
            valueAnimatorOfFloat.setTarget(c2.f3971a);
            valueAnimatorOfFloat.addListener(this);
            c(0.0f);
        }

        public void a() {
            this.f4257g.cancel();
        }

        public void b(long j2) {
            this.f4257g.setDuration(j2);
        }

        public void c(float f2) {
            this.f4264n = f2;
        }

        public void d() {
            this.e.F(false);
            this.f4257g.start();
        }

        public void e() {
            float f2 = this.f4252a;
            float f3 = this.f4254c;
            if (f2 == f3) {
                this.f4260j = this.e.f3971a.getTranslationX();
            } else {
                this.f4260j = f2 + (this.f4264n * (f3 - f2));
            }
            float f4 = this.f4253b;
            float f5 = this.f4255d;
            if (f4 == f5) {
                this.f4261k = this.e.f3971a.getTranslationY();
            } else {
                this.f4261k = f4 + (this.f4264n * (f5 - f4));
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            c(1.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.f4263m) {
                this.e.F(true);
            }
            this.f4263m = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public interface h {
        void a(View view, View view2, int i2, int i3);
    }

    public f(e eVar) {
        this.f4229m = eVar;
    }

    private void C() {
        VelocityTracker velocityTracker = this.f4233t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f4233t = null;
        }
    }

    private void G() {
        this.f4232q = ViewConfiguration.get(this.r.getContext()).getScaledTouchSlop();
        this.r.h(this);
        this.r.k(this.f4215B);
        this.r.j(this);
        H();
    }

    private void H() {
        this.f4214A = new C0054f();
        this.f4239z = new C0175s(this.r.getContext(), this.f4214A);
    }

    private void I() {
        C0054f c0054f = this.f4214A;
        if (c0054f != null) {
            c0054f.a();
            this.f4214A = null;
        }
        if (this.f4239z != null) {
            this.f4239z = null;
        }
    }

    private int J(RecyclerView.C c2) {
        if (this.f4230n == 2) {
            return 0;
        }
        int iK = this.f4229m.k(this.r, c2);
        int iD = (this.f4229m.d(iK, M.y(this.r)) & 65280) >> 8;
        if (iD == 0) {
            return 0;
        }
        int i2 = (iK & 65280) >> 8;
        if (Math.abs(this.f4224h) > Math.abs(this.f4225i)) {
            int iN = n(c2, iD);
            if (iN > 0) {
                return (i2 & iN) == 0 ? e.e(iN, M.y(this.r)) : iN;
            }
            int iP = p(c2, iD);
            if (iP > 0) {
                return iP;
            }
        } else {
            int iP2 = p(c2, iD);
            if (iP2 > 0) {
                return iP2;
            }
            int iN2 = n(c2, iD);
            if (iN2 > 0) {
                return (i2 & iN2) == 0 ? e.e(iN2, M.y(this.r)) : iN2;
            }
        }
        return 0;
    }

    private void l() {
    }

    private int n(RecyclerView.C c2, int i2) {
        if ((i2 & 12) == 0) {
            return 0;
        }
        int i3 = this.f4224h > 0.0f ? 8 : 4;
        VelocityTracker velocityTracker = this.f4233t;
        if (velocityTracker != null && this.f4228l > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.f4229m.n(this.f4223g));
            float xVelocity = this.f4233t.getXVelocity(this.f4228l);
            float yVelocity = this.f4233t.getYVelocity(this.f4228l);
            int i4 = xVelocity > 0.0f ? 8 : 4;
            float fAbs = Math.abs(xVelocity);
            if ((i4 & i2) != 0 && i3 == i4 && fAbs >= this.f4229m.l(this.f4222f) && fAbs > Math.abs(yVelocity)) {
                return i4;
            }
        }
        float width = this.r.getWidth() * this.f4229m.m(c2);
        if ((i2 & i3) == 0 || Math.abs(this.f4224h) <= width) {
            return 0;
        }
        return i3;
    }

    private int p(RecyclerView.C c2, int i2) {
        if ((i2 & 3) == 0) {
            return 0;
        }
        int i3 = this.f4225i > 0.0f ? 2 : 1;
        VelocityTracker velocityTracker = this.f4233t;
        if (velocityTracker != null && this.f4228l > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.f4229m.n(this.f4223g));
            float xVelocity = this.f4233t.getXVelocity(this.f4228l);
            float yVelocity = this.f4233t.getYVelocity(this.f4228l);
            int i4 = yVelocity > 0.0f ? 2 : 1;
            float fAbs = Math.abs(yVelocity);
            if ((i4 & i2) != 0 && i4 == i3 && fAbs >= this.f4229m.l(this.f4222f) && fAbs > Math.abs(xVelocity)) {
                return i4;
            }
        }
        float height = this.r.getHeight() * this.f4229m.m(c2);
        if ((i2 & i3) == 0 || Math.abs(this.f4225i) <= height) {
            return 0;
        }
        return i3;
    }

    private void q() {
        this.r.W0(this);
        this.r.Y0(this.f4215B);
        this.r.X0(this);
        for (int size = this.f4231p.size() - 1; size >= 0; size--) {
            this.f4229m.c(this.r, ((g) this.f4231p.get(0)).e);
        }
        this.f4231p.clear();
        this.f4237x = null;
        this.f4238y = -1;
        C();
        I();
    }

    private List u(RecyclerView.C c2) {
        RecyclerView.C c3 = c2;
        List list = this.f4234u;
        if (list == null) {
            this.f4234u = new ArrayList();
            this.f4235v = new ArrayList();
        } else {
            list.clear();
            this.f4235v.clear();
        }
        int iH = this.f4229m.h();
        int iRound = Math.round(this.f4226j + this.f4224h) - iH;
        int iRound2 = Math.round(this.f4227k + this.f4225i) - iH;
        int i2 = iH * 2;
        int width = c3.f3971a.getWidth() + iRound + i2;
        int height = c3.f3971a.getHeight() + iRound2 + i2;
        int i3 = (iRound + width) / 2;
        int i4 = (iRound2 + height) / 2;
        RecyclerView.o layoutManager = this.r.getLayoutManager();
        int iJ = layoutManager.J();
        int i5 = 0;
        while (i5 < iJ) {
            View viewI = layoutManager.I(i5);
            if (viewI != c3.f3971a && viewI.getBottom() >= iRound2 && viewI.getTop() <= height && viewI.getRight() >= iRound && viewI.getLeft() <= width) {
                RecyclerView.C cF0 = this.r.f0(viewI);
                if (this.f4229m.a(this.r, this.f4220c, cF0)) {
                    int iAbs = Math.abs(i3 - ((viewI.getLeft() + viewI.getRight()) / 2));
                    int iAbs2 = Math.abs(i4 - ((viewI.getTop() + viewI.getBottom()) / 2));
                    int i6 = (iAbs * iAbs) + (iAbs2 * iAbs2);
                    int size = this.f4234u.size();
                    int i7 = 0;
                    for (int i8 = 0; i8 < size && i6 > ((Integer) this.f4235v.get(i8)).intValue(); i8++) {
                        i7++;
                    }
                    this.f4234u.add(i7, cF0);
                    this.f4235v.add(i7, Integer.valueOf(i6));
                }
            }
            i5++;
            c3 = c2;
        }
        return this.f4234u;
    }

    private RecyclerView.C v(MotionEvent motionEvent) {
        View viewT;
        RecyclerView.o layoutManager = this.r.getLayoutManager();
        int i2 = this.f4228l;
        if (i2 == -1) {
            return null;
        }
        int iFindPointerIndex = motionEvent.findPointerIndex(i2);
        float x2 = motionEvent.getX(iFindPointerIndex) - this.f4221d;
        float y2 = motionEvent.getY(iFindPointerIndex) - this.e;
        float fAbs = Math.abs(x2);
        float fAbs2 = Math.abs(y2);
        int i3 = this.f4232q;
        if (fAbs < i3 && fAbs2 < i3) {
            return null;
        }
        if (fAbs > fAbs2 && layoutManager.k()) {
            return null;
        }
        if ((fAbs2 <= fAbs || !layoutManager.l()) && (viewT = t(motionEvent)) != null) {
            return this.r.f0(viewT);
        }
        return null;
    }

    private void w(float[] fArr) {
        if ((this.o & 12) != 0) {
            fArr[0] = (this.f4226j + this.f4224h) - this.f4220c.f3971a.getLeft();
        } else {
            fArr[0] = this.f4220c.f3971a.getTranslationX();
        }
        if ((this.o & 3) != 0) {
            fArr[1] = (this.f4227k + this.f4225i) - this.f4220c.f3971a.getTop();
        } else {
            fArr[1] = this.f4220c.f3971a.getTranslationY();
        }
    }

    private static boolean y(View view, float f2, float f3, float f4, float f5) {
        return f2 >= f4 && f2 <= f4 + ((float) view.getWidth()) && f3 >= f5 && f3 <= f5 + ((float) view.getHeight());
    }

    void A() {
        VelocityTracker velocityTracker = this.f4233t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.f4233t = VelocityTracker.obtain();
    }

    void B(g gVar, int i2) {
        this.r.post(new d(gVar, i2));
    }

    void D(View view) {
        if (view == this.f4237x) {
            this.f4237x = null;
            if (this.f4236w != null) {
                this.r.setChildDrawingOrderCallback(null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean E() {
        /*
            Method dump skipped, instructions count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.f.E():boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void F(androidx.recyclerview.widget.RecyclerView.C r24, int r25) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.f.F(androidx.recyclerview.widget.RecyclerView$C, int):void");
    }

    void K(MotionEvent motionEvent, int i2, int i3) {
        float x2 = motionEvent.getX(i3);
        float y2 = motionEvent.getY(i3);
        float f2 = x2 - this.f4221d;
        this.f4224h = f2;
        this.f4225i = y2 - this.e;
        if ((i2 & 4) == 0) {
            this.f4224h = Math.max(0.0f, f2);
        }
        if ((i2 & 8) == 0) {
            this.f4224h = Math.min(0.0f, this.f4224h);
        }
        if ((i2 & 1) == 0) {
            this.f4225i = Math.max(0.0f, this.f4225i);
        }
        if ((i2 & 2) == 0) {
            this.f4225i = Math.min(0.0f, this.f4225i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void c(View view) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void d(View view) {
        D(view);
        RecyclerView.C cF0 = this.r.f0(view);
        if (cF0 == null) {
            return;
        }
        RecyclerView.C c2 = this.f4220c;
        if (c2 != null && cF0 == c2) {
            F(null, 0);
            return;
        }
        r(cF0, false);
        if (this.f4218a.remove(cF0.f3971a)) {
            this.f4229m.c(this.r, cF0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.z zVar) {
        rect.setEmpty();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.z zVar) {
        float f2;
        float f3;
        this.f4238y = -1;
        if (this.f4220c != null) {
            w(this.f4219b);
            float[] fArr = this.f4219b;
            float f4 = fArr[0];
            f3 = fArr[1];
            f2 = f4;
        } else {
            f2 = 0.0f;
            f3 = 0.0f;
        }
        this.f4229m.w(canvas, recyclerView, this.f4220c, this.f4231p, this.f4230n, f2, f3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void k(Canvas canvas, RecyclerView recyclerView, RecyclerView.z zVar) {
        float f2;
        float f3;
        if (this.f4220c != null) {
            w(this.f4219b);
            float[] fArr = this.f4219b;
            float f4 = fArr[0];
            f3 = fArr[1];
            f2 = f4;
        } else {
            f2 = 0.0f;
            f3 = 0.0f;
        }
        this.f4229m.x(canvas, recyclerView, this.f4220c, this.f4231p, this.f4230n, f2, f3);
    }

    public void m(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.r;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            q();
        }
        this.r = recyclerView;
        if (recyclerView != null) {
            Resources resources = recyclerView.getResources();
            this.f4222f = resources.getDimension(K.a.f253f);
            this.f4223g = resources.getDimension(K.a.e);
            G();
        }
    }

    void o(int i2, MotionEvent motionEvent, int i3) {
        RecyclerView.C cV;
        int iF;
        if (this.f4220c != null || i2 != 2 || this.f4230n == 2 || !this.f4229m.q() || this.r.getScrollState() == 1 || (cV = v(motionEvent)) == null || (iF = (this.f4229m.f(this.r, cV) & 65280) >> 8) == 0) {
            return;
        }
        float x2 = motionEvent.getX(i3);
        float y2 = motionEvent.getY(i3);
        float f2 = x2 - this.f4221d;
        float f3 = y2 - this.e;
        float fAbs = Math.abs(f2);
        float fAbs2 = Math.abs(f3);
        int i4 = this.f4232q;
        if (fAbs >= i4 || fAbs2 >= i4) {
            if (fAbs > fAbs2) {
                if (f2 < 0.0f && (iF & 4) == 0) {
                    return;
                }
                if (f2 > 0.0f && (iF & 8) == 0) {
                    return;
                }
            } else {
                if (f3 < 0.0f && (iF & 1) == 0) {
                    return;
                }
                if (f3 > 0.0f && (iF & 2) == 0) {
                    return;
                }
            }
            this.f4225i = 0.0f;
            this.f4224h = 0.0f;
            this.f4228l = motionEvent.getPointerId(0);
            F(cV, 1);
        }
    }

    void r(RecyclerView.C c2, boolean z2) {
        for (int size = this.f4231p.size() - 1; size >= 0; size--) {
            g gVar = (g) this.f4231p.get(size);
            if (gVar.e == c2) {
                gVar.f4262l |= z2;
                if (!gVar.f4263m) {
                    gVar.a();
                }
                this.f4231p.remove(size);
                return;
            }
        }
    }

    g s(MotionEvent motionEvent) {
        if (this.f4231p.isEmpty()) {
            return null;
        }
        View viewT = t(motionEvent);
        for (int size = this.f4231p.size() - 1; size >= 0; size--) {
            g gVar = (g) this.f4231p.get(size);
            if (gVar.e.f3971a == viewT) {
                return gVar;
            }
        }
        return null;
    }

    View t(MotionEvent motionEvent) {
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        RecyclerView.C c2 = this.f4220c;
        if (c2 != null) {
            View view = c2.f3971a;
            if (y(view, x2, y2, this.f4226j + this.f4224h, this.f4227k + this.f4225i)) {
                return view;
            }
        }
        for (int size = this.f4231p.size() - 1; size >= 0; size--) {
            g gVar = (g) this.f4231p.get(size);
            View view2 = gVar.e.f3971a;
            if (y(view2, x2, y2, gVar.f4260j, gVar.f4261k)) {
                return view2;
            }
        }
        return this.r.T(x2, y2);
    }

    boolean x() {
        int size = this.f4231p.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!((g) this.f4231p.get(i2)).f4263m) {
                return true;
            }
        }
        return false;
    }

    void z(RecyclerView.C c2) {
        if (!this.r.isLayoutRequested() && this.f4230n == 2) {
            float fJ = this.f4229m.j(c2);
            int i2 = (int) (this.f4226j + this.f4224h);
            int i3 = (int) (this.f4227k + this.f4225i);
            if (Math.abs(i3 - c2.f3971a.getTop()) >= c2.f3971a.getHeight() * fJ || Math.abs(i2 - c2.f3971a.getLeft()) >= c2.f3971a.getWidth() * fJ) {
                List listU = u(c2);
                if (listU.size() == 0) {
                    return;
                }
                RecyclerView.C cB = this.f4229m.b(c2, listU, i2, i3);
                if (cB == null) {
                    this.f4234u.clear();
                    this.f4235v.clear();
                    return;
                }
                int iJ = cB.j();
                int iJ2 = c2.j();
                if (this.f4229m.y(this.r, c2, cB)) {
                    this.f4229m.z(this.r, c2, iJ2, cB, iJ, i2, i3);
                }
            }
        }
    }
}
