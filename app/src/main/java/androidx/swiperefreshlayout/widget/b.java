package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import v.AbstractC0345h;

/* loaded from: classes.dex */
public class b extends Drawable implements Animatable {

    /* renamed from: g, reason: collision with root package name */
    private static final Interpolator f4359g = new LinearInterpolator();

    /* renamed from: h, reason: collision with root package name */
    private static final Interpolator f4360h = new G.b();

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f4361i = {-16777216};

    /* renamed from: a, reason: collision with root package name */
    private final c f4362a;

    /* renamed from: b, reason: collision with root package name */
    private float f4363b;

    /* renamed from: c, reason: collision with root package name */
    private Resources f4364c;

    /* renamed from: d, reason: collision with root package name */
    private Animator f4365d;
    float e;

    /* renamed from: f, reason: collision with root package name */
    boolean f4366f;

    class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f4367a;

        a(c cVar) {
            this.f4367a = cVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            b.this.n(fFloatValue, this.f4367a);
            b.this.b(fFloatValue, this.f4367a, false);
            b.this.invalidateSelf();
        }
    }

    /* renamed from: androidx.swiperefreshlayout.widget.b$b, reason: collision with other inner class name */
    class C0057b implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f4369a;

        C0057b(c cVar) {
            this.f4369a = cVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            b.this.b(1.0f, this.f4369a, true);
            this.f4369a.A();
            this.f4369a.l();
            b bVar = b.this;
            if (!bVar.f4366f) {
                bVar.e += 1.0f;
                return;
            }
            bVar.f4366f = false;
            animator.cancel();
            animator.setDuration(1332L);
            animator.start();
            this.f4369a.x(false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            b.this.e = 0.0f;
        }
    }

    private static class c {

        /* renamed from: a, reason: collision with root package name */
        final RectF f4371a = new RectF();

        /* renamed from: b, reason: collision with root package name */
        final Paint f4372b;

        /* renamed from: c, reason: collision with root package name */
        final Paint f4373c;

        /* renamed from: d, reason: collision with root package name */
        final Paint f4374d;
        float e;

        /* renamed from: f, reason: collision with root package name */
        float f4375f;

        /* renamed from: g, reason: collision with root package name */
        float f4376g;

        /* renamed from: h, reason: collision with root package name */
        float f4377h;

        /* renamed from: i, reason: collision with root package name */
        int[] f4378i;

        /* renamed from: j, reason: collision with root package name */
        int f4379j;

        /* renamed from: k, reason: collision with root package name */
        float f4380k;

        /* renamed from: l, reason: collision with root package name */
        float f4381l;

        /* renamed from: m, reason: collision with root package name */
        float f4382m;

        /* renamed from: n, reason: collision with root package name */
        boolean f4383n;
        Path o;

        /* renamed from: p, reason: collision with root package name */
        float f4384p;

        /* renamed from: q, reason: collision with root package name */
        float f4385q;
        int r;
        int s;

        /* renamed from: t, reason: collision with root package name */
        int f4386t;

        /* renamed from: u, reason: collision with root package name */
        int f4387u;

        c() {
            Paint paint = new Paint();
            this.f4372b = paint;
            Paint paint2 = new Paint();
            this.f4373c = paint2;
            Paint paint3 = new Paint();
            this.f4374d = paint3;
            this.e = 0.0f;
            this.f4375f = 0.0f;
            this.f4376g = 0.0f;
            this.f4377h = 5.0f;
            this.f4384p = 1.0f;
            this.f4386t = 255;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint3.setColor(0);
        }

        void A() {
            this.f4380k = this.e;
            this.f4381l = this.f4375f;
            this.f4382m = this.f4376g;
        }

        void a(Canvas canvas, Rect rect) {
            RectF rectF = this.f4371a;
            float f2 = this.f4385q;
            float fMin = (this.f4377h / 2.0f) + f2;
            if (f2 <= 0.0f) {
                fMin = (Math.min(rect.width(), rect.height()) / 2.0f) - Math.max((this.r * this.f4384p) / 2.0f, this.f4377h / 2.0f);
            }
            rectF.set(rect.centerX() - fMin, rect.centerY() - fMin, rect.centerX() + fMin, rect.centerY() + fMin);
            float f3 = this.e;
            float f4 = this.f4376g;
            float f5 = (f3 + f4) * 360.0f;
            float f6 = ((this.f4375f + f4) * 360.0f) - f5;
            this.f4372b.setColor(this.f4387u);
            this.f4372b.setAlpha(this.f4386t);
            float f7 = this.f4377h / 2.0f;
            rectF.inset(f7, f7);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.f4374d);
            float f8 = -f7;
            rectF.inset(f8, f8);
            canvas.drawArc(rectF, f5, f6, false, this.f4372b);
            b(canvas, f5, f6, rectF);
        }

        void b(Canvas canvas, float f2, float f3, RectF rectF) {
            if (this.f4383n) {
                Path path = this.o;
                if (path == null) {
                    Path path2 = new Path();
                    this.o = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float fMin = Math.min(rectF.width(), rectF.height()) / 2.0f;
                float f4 = (this.r * this.f4384p) / 2.0f;
                this.o.moveTo(0.0f, 0.0f);
                this.o.lineTo(this.r * this.f4384p, 0.0f);
                Path path3 = this.o;
                float f5 = this.r;
                float f6 = this.f4384p;
                path3.lineTo((f5 * f6) / 2.0f, this.s * f6);
                this.o.offset((fMin + rectF.centerX()) - f4, rectF.centerY() + (this.f4377h / 2.0f));
                this.o.close();
                this.f4373c.setColor(this.f4387u);
                this.f4373c.setAlpha(this.f4386t);
                canvas.save();
                canvas.rotate(f2 + f3, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.o, this.f4373c);
                canvas.restore();
            }
        }

        int c() {
            return this.f4386t;
        }

        float d() {
            return this.f4375f;
        }

        int e() {
            return this.f4378i[f()];
        }

        int f() {
            return (this.f4379j + 1) % this.f4378i.length;
        }

        float g() {
            return this.e;
        }

        int h() {
            return this.f4378i[this.f4379j];
        }

        float i() {
            return this.f4381l;
        }

        float j() {
            return this.f4382m;
        }

        float k() {
            return this.f4380k;
        }

        void l() {
            t(f());
        }

        void m() {
            this.f4380k = 0.0f;
            this.f4381l = 0.0f;
            this.f4382m = 0.0f;
            y(0.0f);
            v(0.0f);
            w(0.0f);
        }

        void n(int i2) {
            this.f4386t = i2;
        }

        void o(float f2, float f3) {
            this.r = (int) f2;
            this.s = (int) f3;
        }

        void p(float f2) {
            if (f2 != this.f4384p) {
                this.f4384p = f2;
            }
        }

        void q(float f2) {
            this.f4385q = f2;
        }

        void r(int i2) {
            this.f4387u = i2;
        }

        void s(ColorFilter colorFilter) {
            this.f4372b.setColorFilter(colorFilter);
        }

        void t(int i2) {
            this.f4379j = i2;
            this.f4387u = this.f4378i[i2];
        }

        void u(int[] iArr) {
            this.f4378i = iArr;
            t(0);
        }

        void v(float f2) {
            this.f4375f = f2;
        }

        void w(float f2) {
            this.f4376g = f2;
        }

        void x(boolean z2) {
            if (this.f4383n != z2) {
                this.f4383n = z2;
            }
        }

        void y(float f2) {
            this.e = f2;
        }

        void z(float f2) {
            this.f4377h = f2;
            this.f4372b.setStrokeWidth(f2);
        }
    }

    public b(Context context) {
        this.f4364c = ((Context) AbstractC0345h.f(context)).getResources();
        c cVar = new c();
        this.f4362a = cVar;
        cVar.u(f4361i);
        k(2.5f);
        m();
    }

    private void a(float f2, c cVar) {
        n(f2, cVar);
        float fFloor = (float) (Math.floor(cVar.j() / 0.8f) + 1.0d);
        cVar.y(cVar.k() + (((cVar.i() - 0.01f) - cVar.k()) * f2));
        cVar.v(cVar.i());
        cVar.w(cVar.j() + ((fFloor - cVar.j()) * f2));
    }

    private int c(float f2, int i2, int i3) {
        return ((((i2 >> 24) & 255) + ((int) ((((i3 >> 24) & 255) - r0) * f2))) << 24) | ((((i2 >> 16) & 255) + ((int) ((((i3 >> 16) & 255) - r1) * f2))) << 16) | ((((i2 >> 8) & 255) + ((int) ((((i3 >> 8) & 255) - r2) * f2))) << 8) | ((i2 & 255) + ((int) (f2 * ((i3 & 255) - r8))));
    }

    private void h(float f2) {
        this.f4363b = f2;
    }

    private void i(float f2, float f3, float f4, float f5) {
        c cVar = this.f4362a;
        float f6 = this.f4364c.getDisplayMetrics().density;
        cVar.z(f3 * f6);
        cVar.q(f2 * f6);
        cVar.t(0);
        cVar.o(f4 * f6, f5 * f6);
    }

    private void m() {
        c cVar = this.f4362a;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new a(cVar));
        valueAnimatorOfFloat.setRepeatCount(-1);
        valueAnimatorOfFloat.setRepeatMode(1);
        valueAnimatorOfFloat.setInterpolator(f4359g);
        valueAnimatorOfFloat.addListener(new C0057b(cVar));
        this.f4365d = valueAnimatorOfFloat;
    }

    void b(float f2, c cVar, boolean z2) {
        float interpolation;
        float interpolation2;
        if (this.f4366f) {
            a(f2, cVar);
            return;
        }
        if (f2 != 1.0f || z2) {
            float fJ = cVar.j();
            if (f2 < 0.5f) {
                interpolation = cVar.k();
                interpolation2 = (f4360h.getInterpolation(f2 / 0.5f) * 0.79f) + 0.01f + interpolation;
            } else {
                float fK = cVar.k() + 0.79f;
                interpolation = fK - (((1.0f - f4360h.getInterpolation((f2 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                interpolation2 = fK;
            }
            float f3 = fJ + (0.20999998f * f2);
            float f4 = (f2 + this.e) * 216.0f;
            cVar.y(interpolation);
            cVar.v(interpolation2);
            cVar.w(f3);
            h(f4);
        }
    }

    public void d(boolean z2) {
        this.f4362a.x(z2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f4363b, bounds.exactCenterX(), bounds.exactCenterY());
        this.f4362a.a(canvas, bounds);
        canvas.restore();
    }

    public void e(float f2) {
        this.f4362a.p(f2);
        invalidateSelf();
    }

    public void f(int... iArr) {
        this.f4362a.u(iArr);
        this.f4362a.t(0);
        invalidateSelf();
    }

    public void g(float f2) {
        this.f4362a.w(f2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f4362a.c();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f4365d.isRunning();
    }

    public void j(float f2, float f3) {
        this.f4362a.y(f2);
        this.f4362a.v(f3);
        invalidateSelf();
    }

    public void k(float f2) {
        this.f4362a.z(f2);
        invalidateSelf();
    }

    public void l(int i2) {
        if (i2 == 0) {
            i(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            i(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    void n(float f2, c cVar) {
        if (f2 > 0.75f) {
            cVar.r(c((f2 - 0.75f) / 0.25f, cVar.h(), cVar.e()));
        } else {
            cVar.r(cVar.h());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f4362a.n(i2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f4362a.s(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f4365d.cancel();
        this.f4362a.A();
        if (this.f4362a.d() != this.f4362a.g()) {
            this.f4366f = true;
            this.f4365d.setDuration(666L);
            this.f4365d.start();
        } else {
            this.f4362a.t(0);
            this.f4362a.m();
            this.f4365d.setDuration(1332L);
            this.f4365d.start();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f4365d.cancel();
        h(0.0f);
        this.f4362a.x(false);
        this.f4362a.t(0);
        this.f4362a.m();
        invalidateSelf();
    }
}
