package androidx.recyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.core.view.M;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
class d extends RecyclerView.n implements RecyclerView.s {

    /* renamed from: D, reason: collision with root package name */
    private static final int[] f4169D = {R.attr.state_pressed};

    /* renamed from: E, reason: collision with root package name */
    private static final int[] f4170E = new int[0];

    /* renamed from: A, reason: collision with root package name */
    int f4171A;

    /* renamed from: B, reason: collision with root package name */
    private final Runnable f4172B;

    /* renamed from: C, reason: collision with root package name */
    private final RecyclerView.t f4173C;

    /* renamed from: a, reason: collision with root package name */
    private final int f4174a;

    /* renamed from: b, reason: collision with root package name */
    private final int f4175b;

    /* renamed from: c, reason: collision with root package name */
    final StateListDrawable f4176c;

    /* renamed from: d, reason: collision with root package name */
    final Drawable f4177d;
    private final int e;

    /* renamed from: f, reason: collision with root package name */
    private final int f4178f;

    /* renamed from: g, reason: collision with root package name */
    private final StateListDrawable f4179g;

    /* renamed from: h, reason: collision with root package name */
    private final Drawable f4180h;

    /* renamed from: i, reason: collision with root package name */
    private final int f4181i;

    /* renamed from: j, reason: collision with root package name */
    private final int f4182j;

    /* renamed from: k, reason: collision with root package name */
    int f4183k;

    /* renamed from: l, reason: collision with root package name */
    int f4184l;

    /* renamed from: m, reason: collision with root package name */
    float f4185m;

    /* renamed from: n, reason: collision with root package name */
    int f4186n;
    int o;

    /* renamed from: p, reason: collision with root package name */
    float f4187p;
    private RecyclerView s;

    /* renamed from: z, reason: collision with root package name */
    final ValueAnimator f4195z;

    /* renamed from: q, reason: collision with root package name */
    private int f4188q = 0;
    private int r = 0;

    /* renamed from: t, reason: collision with root package name */
    private boolean f4189t = false;

    /* renamed from: u, reason: collision with root package name */
    private boolean f4190u = false;

    /* renamed from: v, reason: collision with root package name */
    private int f4191v = 0;

    /* renamed from: w, reason: collision with root package name */
    private int f4192w = 0;

    /* renamed from: x, reason: collision with root package name */
    private final int[] f4193x = new int[2];

    /* renamed from: y, reason: collision with root package name */
    private final int[] f4194y = new int[2];

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.s(500);
        }
    }

    class b extends RecyclerView.t {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i2, int i3) {
            d.this.D(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }

    private class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private boolean f4198a = false;

        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f4198a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f4198a) {
                this.f4198a = false;
                return;
            }
            if (((Float) d.this.f4195z.getAnimatedValue()).floatValue() == 0.0f) {
                d dVar = d.this;
                dVar.f4171A = 0;
                dVar.A(0);
            } else {
                d dVar2 = d.this;
                dVar2.f4171A = 2;
                dVar2.x();
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.d$d, reason: collision with other inner class name */
    private class C0053d implements ValueAnimator.AnimatorUpdateListener {
        C0053d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            d.this.f4176c.setAlpha(iFloatValue);
            d.this.f4177d.setAlpha(iFloatValue);
            d.this.x();
        }
    }

    d(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i2, int i3, int i4) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f4195z = valueAnimatorOfFloat;
        this.f4171A = 0;
        this.f4172B = new a();
        this.f4173C = new b();
        this.f4176c = stateListDrawable;
        this.f4177d = drawable;
        this.f4179g = stateListDrawable2;
        this.f4180h = drawable2;
        this.e = Math.max(i2, stateListDrawable.getIntrinsicWidth());
        this.f4178f = Math.max(i2, drawable.getIntrinsicWidth());
        this.f4181i = Math.max(i2, stateListDrawable2.getIntrinsicWidth());
        this.f4182j = Math.max(i2, drawable2.getIntrinsicWidth());
        this.f4174a = i3;
        this.f4175b = i4;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        valueAnimatorOfFloat.addListener(new c());
        valueAnimatorOfFloat.addUpdateListener(new C0053d());
        l(recyclerView);
    }

    private void B() {
        this.s.h(this);
        this.s.k(this);
        this.s.l(this.f4173C);
    }

    private void E(float f2) {
        int[] iArrR = r();
        float fMax = Math.max(iArrR[0], Math.min(iArrR[1], f2));
        if (Math.abs(this.f4184l - fMax) < 2.0f) {
            return;
        }
        int iZ = z(this.f4185m, fMax, iArrR, this.s.computeVerticalScrollRange(), this.s.computeVerticalScrollOffset(), this.r);
        if (iZ != 0) {
            this.s.scrollBy(0, iZ);
        }
        this.f4185m = fMax;
    }

    private void m() {
        this.s.removeCallbacks(this.f4172B);
    }

    private void n() {
        this.s.W0(this);
        this.s.Y0(this);
        this.s.Z0(this.f4173C);
        m();
    }

    private void o(Canvas canvas) {
        int i2 = this.r;
        int i3 = this.f4181i;
        int i4 = this.o;
        int i5 = this.f4186n;
        this.f4179g.setBounds(0, 0, i5, i3);
        this.f4180h.setBounds(0, 0, this.f4188q, this.f4182j);
        canvas.translate(0.0f, i2 - i3);
        this.f4180h.draw(canvas);
        canvas.translate(i4 - (i5 / 2), 0.0f);
        this.f4179g.draw(canvas);
        canvas.translate(-r2, -r0);
    }

    private void p(Canvas canvas) {
        int i2 = this.f4188q;
        int i3 = this.e;
        int i4 = i2 - i3;
        int i5 = this.f4184l;
        int i6 = this.f4183k;
        int i7 = i5 - (i6 / 2);
        this.f4176c.setBounds(0, 0, i3, i6);
        this.f4177d.setBounds(0, 0, this.f4178f, this.r);
        if (!u()) {
            canvas.translate(i4, 0.0f);
            this.f4177d.draw(canvas);
            canvas.translate(0.0f, i7);
            this.f4176c.draw(canvas);
            canvas.translate(-i4, -i7);
            return;
        }
        this.f4177d.draw(canvas);
        canvas.translate(this.e, i7);
        canvas.scale(-1.0f, 1.0f);
        this.f4176c.draw(canvas);
        canvas.scale(1.0f, 1.0f);
        canvas.translate(-this.e, -i7);
    }

    private int[] q() {
        int[] iArr = this.f4194y;
        int i2 = this.f4175b;
        iArr[0] = i2;
        iArr[1] = this.f4188q - i2;
        return iArr;
    }

    private int[] r() {
        int[] iArr = this.f4193x;
        int i2 = this.f4175b;
        iArr[0] = i2;
        iArr[1] = this.r - i2;
        return iArr;
    }

    private void t(float f2) {
        int[] iArrQ = q();
        float fMax = Math.max(iArrQ[0], Math.min(iArrQ[1], f2));
        if (Math.abs(this.o - fMax) < 2.0f) {
            return;
        }
        int iZ = z(this.f4187p, fMax, iArrQ, this.s.computeHorizontalScrollRange(), this.s.computeHorizontalScrollOffset(), this.f4188q);
        if (iZ != 0) {
            this.s.scrollBy(iZ, 0);
        }
        this.f4187p = fMax;
    }

    private boolean u() {
        return M.y(this.s) == 1;
    }

    private void y(int i2) {
        m();
        this.s.postDelayed(this.f4172B, i2);
    }

    private int z(float f2, float f3, int[] iArr, int i2, int i3, int i4) {
        int i5 = iArr[1] - iArr[0];
        if (i5 == 0) {
            return 0;
        }
        int i6 = i2 - i4;
        int i7 = (int) (((f3 - f2) / i5) * i6);
        int i8 = i3 + i7;
        if (i8 >= i6 || i8 < 0) {
            return 0;
        }
        return i7;
    }

    void A(int i2) {
        if (i2 == 2 && this.f4191v != 2) {
            this.f4176c.setState(f4169D);
            m();
        }
        if (i2 == 0) {
            x();
        } else {
            C();
        }
        if (this.f4191v == 2 && i2 != 2) {
            this.f4176c.setState(f4170E);
            y(1200);
        } else if (i2 == 1) {
            y(1500);
        }
        this.f4191v = i2;
    }

    public void C() {
        int i2 = this.f4171A;
        if (i2 != 0) {
            if (i2 != 3) {
                return;
            } else {
                this.f4195z.cancel();
            }
        }
        this.f4171A = 1;
        ValueAnimator valueAnimator = this.f4195z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.f4195z.setDuration(500L);
        this.f4195z.setStartDelay(0L);
        this.f4195z.start();
    }

    void D(int i2, int i3) {
        int iComputeVerticalScrollRange = this.s.computeVerticalScrollRange();
        int i4 = this.r;
        this.f4189t = iComputeVerticalScrollRange - i4 > 0 && i4 >= this.f4174a;
        int iComputeHorizontalScrollRange = this.s.computeHorizontalScrollRange();
        int i5 = this.f4188q;
        boolean z2 = iComputeHorizontalScrollRange - i5 > 0 && i5 >= this.f4174a;
        this.f4190u = z2;
        boolean z3 = this.f4189t;
        if (!z3 && !z2) {
            if (this.f4191v != 0) {
                A(0);
                return;
            }
            return;
        }
        if (z3) {
            float f2 = i4;
            this.f4184l = (int) ((f2 * (i3 + (f2 / 2.0f))) / iComputeVerticalScrollRange);
            this.f4183k = Math.min(i4, (i4 * i4) / iComputeVerticalScrollRange);
        }
        if (this.f4190u) {
            float f3 = i5;
            this.o = (int) ((f3 * (i2 + (f3 / 2.0f))) / iComputeHorizontalScrollRange);
            this.f4186n = Math.min(i5, (i5 * i5) / iComputeHorizontalScrollRange);
        }
        int i6 = this.f4191v;
        if (i6 == 0 || i6 == 1) {
            A(1);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i2 = this.f4191v;
        if (i2 == 1) {
            boolean zW = w(motionEvent.getX(), motionEvent.getY());
            boolean zV = v(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!zW && !zV) {
                return false;
            }
            if (zV) {
                this.f4192w = 1;
                this.f4187p = (int) motionEvent.getX();
            } else if (zW) {
                this.f4192w = 2;
                this.f4185m = (int) motionEvent.getY();
            }
            A(2);
        } else if (i2 != 2) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void b(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f4191v == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean zW = w(motionEvent.getX(), motionEvent.getY());
            boolean zV = v(motionEvent.getX(), motionEvent.getY());
            if (zW || zV) {
                if (zV) {
                    this.f4192w = 1;
                    this.f4187p = (int) motionEvent.getX();
                } else if (zW) {
                    this.f4192w = 2;
                    this.f4185m = (int) motionEvent.getY();
                }
                A(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.f4191v == 2) {
            this.f4185m = 0.0f;
            this.f4187p = 0.0f;
            A(1);
            this.f4192w = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.f4191v == 2) {
            C();
            if (this.f4192w == 1) {
                t(motionEvent.getX());
            }
            if (this.f4192w == 2) {
                E(motionEvent.getY());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void e(boolean z2) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void k(Canvas canvas, RecyclerView recyclerView, RecyclerView.z zVar) {
        if (this.f4188q != this.s.getWidth() || this.r != this.s.getHeight()) {
            this.f4188q = this.s.getWidth();
            this.r = this.s.getHeight();
            A(0);
        } else if (this.f4171A != 0) {
            if (this.f4189t) {
                p(canvas);
            }
            if (this.f4190u) {
                o(canvas);
            }
        }
    }

    public void l(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            n();
        }
        this.s = recyclerView;
        if (recyclerView != null) {
            B();
        }
    }

    void s(int i2) {
        int i3 = this.f4171A;
        if (i3 == 1) {
            this.f4195z.cancel();
        } else if (i3 != 2) {
            return;
        }
        this.f4171A = 3;
        ValueAnimator valueAnimator = this.f4195z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.f4195z.setDuration(i2);
        this.f4195z.start();
    }

    boolean v(float f2, float f3) {
        if (f3 >= this.r - this.f4181i) {
            int i2 = this.o;
            int i3 = this.f4186n;
            if (f2 >= i2 - (i3 / 2) && f2 <= i2 + (i3 / 2)) {
                return true;
            }
        }
        return false;
    }

    boolean w(float f2, float f3) {
        if (!u() ? f2 >= this.f4188q - this.e : f2 <= this.e / 2) {
            int i2 = this.f4184l;
            int i3 = this.f4183k;
            if (f3 >= i2 - (i3 / 2) && f3 <= i2 + (i3 / 2)) {
                return true;
            }
        }
        return false;
    }

    void x() {
        this.s.invalidate();
    }
}
