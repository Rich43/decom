package S;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import d0.C0246c;

/* loaded from: classes.dex */
public class i extends a {
    private final String o;

    /* renamed from: p, reason: collision with root package name */
    private final boolean f783p;

    /* renamed from: q, reason: collision with root package name */
    private final androidx.collection.d f784q;
    private final androidx.collection.d r;
    private final RectF s;

    /* renamed from: t, reason: collision with root package name */
    private final X.f f785t;

    /* renamed from: u, reason: collision with root package name */
    private final int f786u;

    /* renamed from: v, reason: collision with root package name */
    private final T.a f787v;

    /* renamed from: w, reason: collision with root package name */
    private final T.a f788w;

    /* renamed from: x, reason: collision with root package name */
    private final T.a f789x;

    /* renamed from: y, reason: collision with root package name */
    private T.p f790y;

    public i(com.airbnb.lottie.a aVar, Y.a aVar2, X.e eVar) {
        super(aVar, aVar2, eVar.b().a(), eVar.g().a(), eVar.i(), eVar.k(), eVar.m(), eVar.h(), eVar.c());
        this.f784q = new androidx.collection.d();
        this.r = new androidx.collection.d();
        this.s = new RectF();
        this.o = eVar.j();
        this.f785t = eVar.f();
        this.f783p = eVar.n();
        this.f786u = (int) (aVar.k().d() / 32.0f);
        T.a aVarA = eVar.e().a();
        this.f787v = aVarA;
        aVarA.a(this);
        aVar2.j(aVarA);
        T.a aVarA2 = eVar.l().a();
        this.f788w = aVarA2;
        aVarA2.a(this);
        aVar2.j(aVarA2);
        T.a aVarA3 = eVar.d().a();
        this.f789x = aVarA3;
        aVarA3.a(this);
        aVar2.j(aVarA3);
    }

    private int[] k(int[] iArr) {
        T.p pVar = this.f790y;
        if (pVar != null) {
            Integer[] numArr = (Integer[]) pVar.h();
            int i2 = 0;
            if (iArr.length == numArr.length) {
                while (i2 < iArr.length) {
                    iArr[i2] = numArr[i2].intValue();
                    i2++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i2 < numArr.length) {
                    iArr[i2] = numArr[i2].intValue();
                    i2++;
                }
            }
        }
        return iArr;
    }

    private int l() {
        int iRound = Math.round(this.f788w.f() * this.f786u);
        int iRound2 = Math.round(this.f789x.f() * this.f786u);
        int iRound3 = Math.round(this.f787v.f() * this.f786u);
        int i2 = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i2 = i2 * 31 * iRound2;
        }
        return iRound3 != 0 ? i2 * 31 * iRound3 : i2;
    }

    private LinearGradient m() {
        long jL = l();
        LinearGradient linearGradient = (LinearGradient) this.f784q.f(jL);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointF = (PointF) this.f788w.h();
        PointF pointF2 = (PointF) this.f789x.h();
        X.c cVar = (X.c) this.f787v.h();
        int[] iArrK = k(cVar.a());
        float[] fArrB = cVar.b();
        RectF rectF = this.s;
        int iWidth = (int) (rectF.left + (rectF.width() / 2.0f) + pointF.x);
        RectF rectF2 = this.s;
        int iHeight = (int) (rectF2.top + (rectF2.height() / 2.0f) + pointF.y);
        RectF rectF3 = this.s;
        int iWidth2 = (int) (rectF3.left + (rectF3.width() / 2.0f) + pointF2.x);
        RectF rectF4 = this.s;
        LinearGradient linearGradient2 = new LinearGradient(iWidth, iHeight, iWidth2, (int) (rectF4.top + (rectF4.height() / 2.0f) + pointF2.y), iArrK, fArrB, Shader.TileMode.CLAMP);
        this.f784q.j(jL, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient n() {
        long jL = l();
        RadialGradient radialGradient = (RadialGradient) this.r.f(jL);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointF = (PointF) this.f788w.h();
        PointF pointF2 = (PointF) this.f789x.h();
        X.c cVar = (X.c) this.f787v.h();
        int[] iArrK = k(cVar.a());
        float[] fArrB = cVar.b();
        RectF rectF = this.s;
        int iWidth = (int) (rectF.left + (rectF.width() / 2.0f) + pointF.x);
        RectF rectF2 = this.s;
        int iHeight = (int) (rectF2.top + (rectF2.height() / 2.0f) + pointF.y);
        RectF rectF3 = this.s;
        int iWidth2 = (int) (rectF3.left + (rectF3.width() / 2.0f) + pointF2.x);
        RectF rectF4 = this.s;
        RadialGradient radialGradient2 = new RadialGradient(iWidth, iHeight, (float) Math.hypot(iWidth2 - iWidth, ((int) ((rectF4.top + (rectF4.height() / 2.0f)) + pointF2.y)) - iHeight), iArrK, fArrB, Shader.TileMode.CLAMP);
        this.r.j(jL, radialGradient2);
        return radialGradient2;
    }

    @Override // S.a, V.f
    public void c(Object obj, C0246c c0246c) {
        super.c(obj, c0246c);
        if (obj == Q.i.f589C) {
            if (c0246c == null) {
                T.p pVar = this.f790y;
                if (pVar != null) {
                    this.f732f.C(pVar);
                }
                this.f790y = null;
                return;
            }
            T.p pVar2 = new T.p(c0246c);
            this.f790y = pVar2;
            pVar2.a(this);
            this.f732f.j(this.f790y);
        }
    }

    @Override // S.a, S.e
    public void g(Canvas canvas, Matrix matrix, int i2) {
        if (this.f783p) {
            return;
        }
        a(this.s, matrix, false);
        this.f735i.setShader(this.f785t == X.f.LINEAR ? m() : n());
        super.g(canvas, matrix, i2);
    }

    @Override // S.c
    public String i() {
        return this.o;
    }
}
