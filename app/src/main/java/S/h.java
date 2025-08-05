package S;

import T.a;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import d0.C0246c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class h implements e, a.InterfaceC0012a, k {

    /* renamed from: a, reason: collision with root package name */
    private final String f768a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f769b;

    /* renamed from: c, reason: collision with root package name */
    private final Y.a f770c;

    /* renamed from: d, reason: collision with root package name */
    private final androidx.collection.d f771d = new androidx.collection.d();
    private final androidx.collection.d e = new androidx.collection.d();

    /* renamed from: f, reason: collision with root package name */
    private final Matrix f772f = new Matrix();

    /* renamed from: g, reason: collision with root package name */
    private final Path f773g;

    /* renamed from: h, reason: collision with root package name */
    private final Paint f774h;

    /* renamed from: i, reason: collision with root package name */
    private final RectF f775i;

    /* renamed from: j, reason: collision with root package name */
    private final List f776j;

    /* renamed from: k, reason: collision with root package name */
    private final X.f f777k;

    /* renamed from: l, reason: collision with root package name */
    private final T.a f778l;

    /* renamed from: m, reason: collision with root package name */
    private final T.a f779m;

    /* renamed from: n, reason: collision with root package name */
    private final T.a f780n;
    private final T.a o;

    /* renamed from: p, reason: collision with root package name */
    private T.a f781p;

    /* renamed from: q, reason: collision with root package name */
    private T.p f782q;
    private final com.airbnb.lottie.a r;
    private final int s;

    public h(com.airbnb.lottie.a aVar, Y.a aVar2, X.d dVar) {
        Path path = new Path();
        this.f773g = path;
        this.f774h = new R.a(1);
        this.f775i = new RectF();
        this.f776j = new ArrayList();
        this.f770c = aVar2;
        this.f768a = dVar.f();
        this.f769b = dVar.i();
        this.r = aVar;
        this.f777k = dVar.e();
        path.setFillType(dVar.c());
        this.s = (int) (aVar.k().d() / 32.0f);
        T.a aVarA = dVar.d().a();
        this.f778l = aVarA;
        aVarA.a(this);
        aVar2.j(aVarA);
        T.a aVarA2 = dVar.g().a();
        this.f779m = aVarA2;
        aVarA2.a(this);
        aVar2.j(aVarA2);
        T.a aVarA3 = dVar.h().a();
        this.f780n = aVarA3;
        aVarA3.a(this);
        aVar2.j(aVarA3);
        T.a aVarA4 = dVar.b().a();
        this.o = aVarA4;
        aVarA4.a(this);
        aVar2.j(aVarA4);
    }

    private int[] e(int[] iArr) {
        T.p pVar = this.f782q;
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

    private int j() {
        int iRound = Math.round(this.f780n.f() * this.s);
        int iRound2 = Math.round(this.o.f() * this.s);
        int iRound3 = Math.round(this.f778l.f() * this.s);
        int i2 = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i2 = i2 * 31 * iRound2;
        }
        return iRound3 != 0 ? i2 * 31 * iRound3 : i2;
    }

    private LinearGradient k() {
        long j2 = j();
        LinearGradient linearGradient = (LinearGradient) this.f771d.f(j2);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointF = (PointF) this.f780n.h();
        PointF pointF2 = (PointF) this.o.h();
        X.c cVar = (X.c) this.f778l.h();
        LinearGradient linearGradient2 = new LinearGradient(pointF.x, pointF.y, pointF2.x, pointF2.y, e(cVar.a()), cVar.b(), Shader.TileMode.CLAMP);
        this.f771d.j(j2, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient l() {
        long j2 = j();
        RadialGradient radialGradient = (RadialGradient) this.e.f(j2);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointF = (PointF) this.f780n.h();
        PointF pointF2 = (PointF) this.o.h();
        X.c cVar = (X.c) this.f778l.h();
        int[] iArrE = e(cVar.a());
        float[] fArrB = cVar.b();
        float f2 = pointF.x;
        float f3 = pointF.y;
        float fHypot = (float) Math.hypot(pointF2.x - f2, pointF2.y - f3);
        RadialGradient radialGradient2 = new RadialGradient(f2, f3, fHypot <= 0.0f ? 0.001f : fHypot, iArrE, fArrB, Shader.TileMode.CLAMP);
        this.e.j(j2, radialGradient2);
        return radialGradient2;
    }

    @Override // S.e
    public void a(RectF rectF, Matrix matrix, boolean z2) {
        this.f773g.reset();
        for (int i2 = 0; i2 < this.f776j.size(); i2++) {
            this.f773g.addPath(((m) this.f776j.get(i2)).h(), matrix);
        }
        this.f773g.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // T.a.InterfaceC0012a
    public void b() {
        this.r.invalidateSelf();
    }

    @Override // V.f
    public void c(Object obj, C0246c c0246c) {
        if (obj == Q.i.f593d) {
            this.f779m.m(c0246c);
            return;
        }
        if (obj == Q.i.f588B) {
            if (c0246c == null) {
                this.f781p = null;
                return;
            }
            T.p pVar = new T.p(c0246c);
            this.f781p = pVar;
            pVar.a(this);
            this.f770c.j(this.f781p);
            return;
        }
        if (obj == Q.i.f589C) {
            if (c0246c == null) {
                T.p pVar2 = this.f782q;
                if (pVar2 != null) {
                    this.f770c.C(pVar2);
                }
                this.f782q = null;
                return;
            }
            T.p pVar3 = new T.p(c0246c);
            this.f782q = pVar3;
            pVar3.a(this);
            this.f770c.j(this.f782q);
        }
    }

    @Override // S.c
    public void d(List list, List list2) {
        for (int i2 = 0; i2 < list2.size(); i2++) {
            c cVar = (c) list2.get(i2);
            if (cVar instanceof m) {
                this.f776j.add((m) cVar);
            }
        }
    }

    @Override // V.f
    public void f(V.e eVar, int i2, List list, V.e eVar2) {
        c0.i.l(eVar, i2, list, eVar2, this);
    }

    @Override // S.e
    public void g(Canvas canvas, Matrix matrix, int i2) {
        if (this.f769b) {
            return;
        }
        Q.c.a("GradientFillContent#draw");
        this.f773g.reset();
        for (int i3 = 0; i3 < this.f776j.size(); i3++) {
            this.f773g.addPath(((m) this.f776j.get(i3)).h(), matrix);
        }
        this.f773g.computeBounds(this.f775i, false);
        Shader shaderK = this.f777k == X.f.LINEAR ? k() : l();
        this.f772f.set(matrix);
        shaderK.setLocalMatrix(this.f772f);
        this.f774h.setShader(shaderK);
        T.a aVar = this.f781p;
        if (aVar != null) {
            this.f774h.setColorFilter((ColorFilter) aVar.h());
        }
        this.f774h.setAlpha(c0.i.c((int) ((((i2 / 255.0f) * ((Integer) this.f779m.h()).intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f773g, this.f774h);
        Q.c.b("GradientFillContent#draw");
    }

    @Override // S.c
    public String i() {
        return this.f768a;
    }
}
