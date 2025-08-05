package S;

import T.a;
import X.q;
import android.graphics.Path;
import android.graphics.PointF;
import d0.C0246c;
import java.util.List;

/* loaded from: classes.dex */
public class f implements m, a.InterfaceC0012a, k {

    /* renamed from: b, reason: collision with root package name */
    private final String f753b;

    /* renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.a f754c;

    /* renamed from: d, reason: collision with root package name */
    private final T.a f755d;
    private final T.a e;

    /* renamed from: f, reason: collision with root package name */
    private final X.a f756f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f758h;

    /* renamed from: a, reason: collision with root package name */
    private final Path f752a = new Path();

    /* renamed from: g, reason: collision with root package name */
    private b f757g = new b();

    public f(com.airbnb.lottie.a aVar, Y.a aVar2, X.a aVar3) {
        this.f753b = aVar3.b();
        this.f754c = aVar;
        T.a aVarA = aVar3.d().a();
        this.f755d = aVarA;
        T.a aVarA2 = aVar3.c().a();
        this.e = aVarA2;
        this.f756f = aVar3;
        aVar2.j(aVarA);
        aVar2.j(aVarA2);
        aVarA.a(this);
        aVarA2.a(this);
    }

    private void e() {
        this.f758h = false;
        this.f754c.invalidateSelf();
    }

    @Override // T.a.InterfaceC0012a
    public void b() {
        e();
    }

    @Override // V.f
    public void c(Object obj, C0246c c0246c) {
        if (obj == Q.i.f595g) {
            this.f755d.m(c0246c);
        } else if (obj == Q.i.f598j) {
            this.e.m(c0246c);
        }
    }

    @Override // S.c
    public void d(List list, List list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVar = (c) list.get(i2);
            if (cVar instanceof s) {
                s sVar = (s) cVar;
                if (sVar.k() == q.a.SIMULTANEOUSLY) {
                    this.f757g.a(sVar);
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
        if (this.f758h) {
            return this.f752a;
        }
        this.f752a.reset();
        if (this.f756f.e()) {
            this.f758h = true;
            return this.f752a;
        }
        PointF pointF = (PointF) this.f755d.h();
        float f2 = pointF.x / 2.0f;
        float f3 = pointF.y / 2.0f;
        float f4 = f2 * 0.55228f;
        float f5 = 0.55228f * f3;
        this.f752a.reset();
        if (this.f756f.f()) {
            float f6 = -f3;
            this.f752a.moveTo(0.0f, f6);
            float f7 = 0.0f - f4;
            float f8 = -f2;
            float f9 = 0.0f - f5;
            this.f752a.cubicTo(f7, f6, f8, f9, f8, 0.0f);
            float f10 = f5 + 0.0f;
            this.f752a.cubicTo(f8, f10, f7, f3, 0.0f, f3);
            float f11 = f4 + 0.0f;
            this.f752a.cubicTo(f11, f3, f2, f10, f2, 0.0f);
            this.f752a.cubicTo(f2, f9, f11, f6, 0.0f, f6);
        } else {
            float f12 = -f3;
            this.f752a.moveTo(0.0f, f12);
            float f13 = f4 + 0.0f;
            float f14 = 0.0f - f5;
            this.f752a.cubicTo(f13, f12, f2, f14, f2, 0.0f);
            float f15 = f5 + 0.0f;
            this.f752a.cubicTo(f2, f15, f13, f3, 0.0f, f3);
            float f16 = 0.0f - f4;
            float f17 = -f2;
            this.f752a.cubicTo(f16, f3, f17, f15, f17, 0.0f);
            this.f752a.cubicTo(f17, f14, f16, f12, 0.0f, f12);
        }
        PointF pointF2 = (PointF) this.e.h();
        this.f752a.offset(pointF2.x, pointF2.y);
        this.f752a.close();
        this.f757g.b(this.f752a);
        this.f758h = true;
        return this.f752a;
    }

    @Override // S.c
    public String i() {
        return this.f753b;
    }
}
