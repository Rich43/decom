package c0;

import android.view.Choreographer;

/* loaded from: classes.dex */
public class g extends c implements Choreographer.FrameCallback {

    /* renamed from: j, reason: collision with root package name */
    private Q.d f4642j;

    /* renamed from: c, reason: collision with root package name */
    private float f4636c = 1.0f;

    /* renamed from: d, reason: collision with root package name */
    private boolean f4637d = false;
    private long e = 0;

    /* renamed from: f, reason: collision with root package name */
    private float f4638f = 0.0f;

    /* renamed from: g, reason: collision with root package name */
    private int f4639g = 0;

    /* renamed from: h, reason: collision with root package name */
    private float f4640h = -2.1474836E9f;

    /* renamed from: i, reason: collision with root package name */
    private float f4641i = 2.1474836E9f;

    /* renamed from: k, reason: collision with root package name */
    protected boolean f4643k = false;

    private void B() {
        if (this.f4642j == null) {
            return;
        }
        float f2 = this.f4638f;
        if (f2 < this.f4640h || f2 > this.f4641i) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.f4640h), Float.valueOf(this.f4641i), Float.valueOf(this.f4638f)));
        }
    }

    private float j() {
        Q.d dVar = this.f4642j;
        if (dVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / dVar.h()) / Math.abs(this.f4636c);
    }

    private boolean n() {
        return m() < 0.0f;
    }

    public void A(float f2) {
        this.f4636c = f2;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void cancel() {
        a();
        r();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j2) {
        q();
        if (this.f4642j == null || !isRunning()) {
            return;
        }
        float fJ = (this.e != 0 ? j2 - r0 : 0L) / j();
        float f2 = this.f4638f;
        if (n()) {
            fJ = -fJ;
        }
        float f3 = f2 + fJ;
        this.f4638f = f3;
        boolean zD = i.d(f3, l(), k());
        this.f4638f = i.b(this.f4638f, l(), k());
        this.e = j2;
        e();
        if (!zD) {
            if (getRepeatCount() == -1 || this.f4639g < getRepeatCount()) {
                c();
                this.f4639g++;
                if (getRepeatMode() == 2) {
                    this.f4637d = !this.f4637d;
                    u();
                } else {
                    this.f4638f = n() ? k() : l();
                }
                this.e = j2;
            } else {
                this.f4638f = this.f4636c < 0.0f ? l() : k();
                r();
                b(n());
            }
        }
        B();
    }

    public void f() {
        this.f4642j = null;
        this.f4640h = -2.1474836E9f;
        this.f4641i = 2.1474836E9f;
    }

    public void g() {
        r();
        b(n());
    }

    @Override // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        float fL;
        float fK;
        float fL2;
        if (this.f4642j == null) {
            return 0.0f;
        }
        if (n()) {
            fL = k() - this.f4638f;
            fK = k();
            fL2 = l();
        } else {
            fL = this.f4638f - l();
            fK = k();
            fL2 = l();
        }
        return fL / (fK - fL2);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(h());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        Q.d dVar = this.f4642j;
        if (dVar == null) {
            return 0L;
        }
        return (long) dVar.d();
    }

    public float h() {
        Q.d dVar = this.f4642j;
        if (dVar == null) {
            return 0.0f;
        }
        return (this.f4638f - dVar.o()) / (this.f4642j.f() - this.f4642j.o());
    }

    public float i() {
        return this.f4638f;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.f4643k;
    }

    public float k() {
        Q.d dVar = this.f4642j;
        if (dVar == null) {
            return 0.0f;
        }
        float f2 = this.f4641i;
        return f2 == 2.1474836E9f ? dVar.f() : f2;
    }

    public float l() {
        Q.d dVar = this.f4642j;
        if (dVar == null) {
            return 0.0f;
        }
        float f2 = this.f4640h;
        return f2 == -2.1474836E9f ? dVar.o() : f2;
    }

    public float m() {
        return this.f4636c;
    }

    public void o() {
        r();
    }

    public void p() {
        this.f4643k = true;
        d(n());
        w((int) (n() ? k() : l()));
        this.e = 0L;
        this.f4639g = 0;
        q();
    }

    protected void q() {
        if (isRunning()) {
            s(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    protected void r() {
        s(true);
    }

    protected void s(boolean z2) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z2) {
            this.f4643k = false;
        }
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i2) {
        super.setRepeatMode(i2);
        if (i2 == 2 || !this.f4637d) {
            return;
        }
        this.f4637d = false;
        u();
    }

    public void t() {
        this.f4643k = true;
        q();
        this.e = 0L;
        if (n() && i() == l()) {
            this.f4638f = k();
        } else {
            if (n() || i() != k()) {
                return;
            }
            this.f4638f = l();
        }
    }

    public void u() {
        A(-m());
    }

    public void v(Q.d dVar) {
        boolean z2 = this.f4642j == null;
        this.f4642j = dVar;
        if (z2) {
            y((int) Math.max(this.f4640h, dVar.o()), (int) Math.min(this.f4641i, dVar.f()));
        } else {
            y((int) dVar.o(), (int) dVar.f());
        }
        float f2 = this.f4638f;
        this.f4638f = 0.0f;
        w((int) f2);
    }

    public void w(float f2) {
        if (this.f4638f == f2) {
            return;
        }
        this.f4638f = i.b(f2, l(), k());
        this.e = 0L;
        e();
    }

    public void x(float f2) {
        y(this.f4640h, f2);
    }

    public void y(float f2, float f3) {
        if (f2 > f3) {
            throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f2), Float.valueOf(f3)));
        }
        Q.d dVar = this.f4642j;
        float fO = dVar == null ? -3.4028235E38f : dVar.o();
        Q.d dVar2 = this.f4642j;
        float f4 = dVar2 == null ? Float.MAX_VALUE : dVar2.f();
        this.f4640h = i.b(f2, fO, f4);
        this.f4641i = i.b(f3, fO, f4);
        w((int) i.b(this.f4638f, f2, f3));
    }

    public void z(int i2) {
        y(i2, (int) this.f4641i);
    }
}
