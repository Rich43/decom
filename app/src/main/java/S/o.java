package S;

import T.a;
import X.q;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import d0.C0246c;
import java.util.List;

/* loaded from: classes.dex */
public class o implements a.InterfaceC0012a, k, m {

    /* renamed from: c, reason: collision with root package name */
    private final String f813c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f814d;
    private final com.airbnb.lottie.a e;

    /* renamed from: f, reason: collision with root package name */
    private final T.a f815f;

    /* renamed from: g, reason: collision with root package name */
    private final T.a f816g;

    /* renamed from: h, reason: collision with root package name */
    private final T.a f817h;

    /* renamed from: j, reason: collision with root package name */
    private boolean f819j;

    /* renamed from: a, reason: collision with root package name */
    private final Path f811a = new Path();

    /* renamed from: b, reason: collision with root package name */
    private final RectF f812b = new RectF();

    /* renamed from: i, reason: collision with root package name */
    private b f818i = new b();

    public o(com.airbnb.lottie.a aVar, Y.a aVar2, X.j jVar) {
        this.f813c = jVar.c();
        this.f814d = jVar.f();
        this.e = aVar;
        T.a aVarA = jVar.d().a();
        this.f815f = aVarA;
        T.a aVarA2 = jVar.e().a();
        this.f816g = aVarA2;
        T.a aVarA3 = jVar.b().a();
        this.f817h = aVarA3;
        aVar2.j(aVarA);
        aVar2.j(aVarA2);
        aVar2.j(aVarA3);
        aVarA.a(this);
        aVarA2.a(this);
        aVarA3.a(this);
    }

    private void e() {
        this.f819j = false;
        this.e.invalidateSelf();
    }

    @Override // T.a.InterfaceC0012a
    public void b() {
        e();
    }

    @Override // V.f
    public void c(Object obj, C0246c c0246c) {
        if (obj == Q.i.f596h) {
            this.f816g.m(c0246c);
        } else if (obj == Q.i.f598j) {
            this.f815f.m(c0246c);
        } else if (obj == Q.i.f597i) {
            this.f817h.m(c0246c);
        }
    }

    @Override // S.c
    public void d(List list, List list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVar = (c) list.get(i2);
            if (cVar instanceof s) {
                s sVar = (s) cVar;
                if (sVar.k() == q.a.SIMULTANEOUSLY) {
                    this.f818i.a(sVar);
                    sVar.c(this);
                }
            }
        }
    }

    @Override // V.f
    public void f(V.e eVar, int i2, List list, V.e eVar2) {
        c0.i.l(eVar, i2, list, eVar2, this);
    }

    @Override // S.m
    public Path h() {
        if (this.f819j) {
            return this.f811a;
        }
        this.f811a.reset();
        if (this.f814d) {
            this.f819j = true;
            return this.f811a;
        }
        PointF pointF = (PointF) this.f816g.h();
        float f2 = pointF.x / 2.0f;
        float f3 = pointF.y / 2.0f;
        T.a aVar = this.f817h;
        float fN = aVar == null ? 0.0f : ((T.c) aVar).n();
        float fMin = Math.min(f2, f3);
        if (fN > fMin) {
            fN = fMin;
        }
        PointF pointF2 = (PointF) this.f815f.h();
        this.f811a.moveTo(pointF2.x + f2, (pointF2.y - f3) + fN);
        this.f811a.lineTo(pointF2.x + f2, (pointF2.y + f3) - fN);
        if (fN > 0.0f) {
            RectF rectF = this.f812b;
            float f4 = pointF2.x;
            float f5 = fN * 2.0f;
            float f6 = pointF2.y;
            rectF.set((f4 + f2) - f5, (f6 + f3) - f5, f4 + f2, f6 + f3);
            this.f811a.arcTo(this.f812b, 0.0f, 90.0f, false);
        }
        this.f811a.lineTo((pointF2.x - f2) + fN, pointF2.y + f3);
        if (fN > 0.0f) {
            RectF rectF2 = this.f812b;
            float f7 = pointF2.x;
            float f8 = pointF2.y;
            float f9 = fN * 2.0f;
            rectF2.set(f7 - f2, (f8 + f3) - f9, (f7 - f2) + f9, f8 + f3);
            this.f811a.arcTo(this.f812b, 90.0f, 90.0f, false);
        }
        this.f811a.lineTo(pointF2.x - f2, (pointF2.y - f3) + fN);
        if (fN > 0.0f) {
            RectF rectF3 = this.f812b;
            float f10 = pointF2.x;
            float f11 = pointF2.y;
            float f12 = fN * 2.0f;
            rectF3.set(f10 - f2, f11 - f3, (f10 - f2) + f12, (f11 - f3) + f12);
            this.f811a.arcTo(this.f812b, 180.0f, 90.0f, false);
        }
        this.f811a.lineTo((pointF2.x + f2) - fN, pointF2.y - f3);
        if (fN > 0.0f) {
            RectF rectF4 = this.f812b;
            float f13 = pointF2.x;
            float f14 = fN * 2.0f;
            float f15 = pointF2.y;
            rectF4.set((f13 + f2) - f14, f15 - f3, f13 + f2, (f15 - f3) + f14);
            this.f811a.arcTo(this.f812b, 270.0f, 90.0f, false);
        }
        this.f811a.close();
        this.f818i.b(this.f811a);
        this.f819j = true;
        return this.f811a;
    }

    @Override // S.c
    public String i() {
        return this.f813c;
    }
}
