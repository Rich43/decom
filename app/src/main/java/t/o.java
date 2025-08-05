package T;

import T.a;
import android.graphics.Matrix;
import android.graphics.PointF;
import d0.C0244a;
import d0.C0246c;
import d0.C0247d;
import java.util.Collections;

/* loaded from: classes.dex */
public class o {

    /* renamed from: a */
    private final Matrix f874a = new Matrix();

    /* renamed from: b */
    private final Matrix f875b;

    /* renamed from: c */
    private final Matrix f876c;

    /* renamed from: d */
    private final Matrix f877d;
    private final float[] e;

    /* renamed from: f */
    private a f878f;

    /* renamed from: g */
    private a f879g;

    /* renamed from: h */
    private a f880h;

    /* renamed from: i */
    private a f881i;

    /* renamed from: j */
    private a f882j;

    /* renamed from: k */
    private c f883k;

    /* renamed from: l */
    private c f884l;

    /* renamed from: m */
    private a f885m;

    /* renamed from: n */
    private a f886n;

    public o(W.l lVar) {
        this.f878f = lVar.c() == null ? null : lVar.c().a();
        this.f879g = lVar.f() == null ? null : lVar.f().a();
        this.f880h = lVar.h() == null ? null : lVar.h().a();
        this.f881i = lVar.g() == null ? null : lVar.g().a();
        c cVar = lVar.i() == null ? null : (c) lVar.i().a();
        this.f883k = cVar;
        if (cVar != null) {
            this.f875b = new Matrix();
            this.f876c = new Matrix();
            this.f877d = new Matrix();
            this.e = new float[9];
        } else {
            this.f875b = null;
            this.f876c = null;
            this.f877d = null;
            this.e = null;
        }
        this.f884l = lVar.j() == null ? null : (c) lVar.j().a();
        if (lVar.e() != null) {
            this.f882j = lVar.e().a();
        }
        if (lVar.k() != null) {
            this.f885m = lVar.k().a();
        } else {
            this.f885m = null;
        }
        if (lVar.d() != null) {
            this.f886n = lVar.d().a();
        } else {
            this.f886n = null;
        }
    }

    private void d() {
        for (int i2 = 0; i2 < 9; i2++) {
            this.e[i2] = 0.0f;
        }
    }

    public void a(Y.a aVar) {
        aVar.j(this.f882j);
        aVar.j(this.f885m);
        aVar.j(this.f886n);
        aVar.j(this.f878f);
        aVar.j(this.f879g);
        aVar.j(this.f880h);
        aVar.j(this.f881i);
        aVar.j(this.f883k);
        aVar.j(this.f884l);
    }

    public void b(a.InterfaceC0012a interfaceC0012a) {
        a aVar = this.f882j;
        if (aVar != null) {
            aVar.a(interfaceC0012a);
        }
        a aVar2 = this.f885m;
        if (aVar2 != null) {
            aVar2.a(interfaceC0012a);
        }
        a aVar3 = this.f886n;
        if (aVar3 != null) {
            aVar3.a(interfaceC0012a);
        }
        a aVar4 = this.f878f;
        if (aVar4 != null) {
            aVar4.a(interfaceC0012a);
        }
        a aVar5 = this.f879g;
        if (aVar5 != null) {
            aVar5.a(interfaceC0012a);
        }
        a aVar6 = this.f880h;
        if (aVar6 != null) {
            aVar6.a(interfaceC0012a);
        }
        a aVar7 = this.f881i;
        if (aVar7 != null) {
            aVar7.a(interfaceC0012a);
        }
        c cVar = this.f883k;
        if (cVar != null) {
            cVar.a(interfaceC0012a);
        }
        c cVar2 = this.f884l;
        if (cVar2 != null) {
            cVar2.a(interfaceC0012a);
        }
    }

    public boolean c(Object obj, C0246c c0246c) {
        c cVar;
        c cVar2;
        a aVar;
        a aVar2;
        if (obj == Q.i.e) {
            a aVar3 = this.f878f;
            if (aVar3 == null) {
                this.f878f = new p(c0246c, new PointF());
                return true;
            }
            aVar3.m(c0246c);
            return true;
        }
        if (obj == Q.i.f594f) {
            a aVar4 = this.f879g;
            if (aVar4 == null) {
                this.f879g = new p(c0246c, new PointF());
                return true;
            }
            aVar4.m(c0246c);
            return true;
        }
        if (obj == Q.i.f599k) {
            a aVar5 = this.f880h;
            if (aVar5 == null) {
                this.f880h = new p(c0246c, new C0247d());
                return true;
            }
            aVar5.m(c0246c);
            return true;
        }
        if (obj == Q.i.f600l) {
            a aVar6 = this.f881i;
            if (aVar6 == null) {
                this.f881i = new p(c0246c, Float.valueOf(0.0f));
                return true;
            }
            aVar6.m(c0246c);
            return true;
        }
        if (obj == Q.i.f592c) {
            a aVar7 = this.f882j;
            if (aVar7 == null) {
                this.f882j = new p(c0246c, 100);
                return true;
            }
            aVar7.m(c0246c);
            return true;
        }
        if (obj == Q.i.f610y && (aVar2 = this.f885m) != null) {
            if (aVar2 == null) {
                this.f885m = new p(c0246c, 100);
                return true;
            }
            aVar2.m(c0246c);
            return true;
        }
        if (obj == Q.i.f611z && (aVar = this.f886n) != null) {
            if (aVar == null) {
                this.f886n = new p(c0246c, 100);
                return true;
            }
            aVar.m(c0246c);
            return true;
        }
        if (obj == Q.i.f601m && (cVar2 = this.f883k) != null) {
            if (cVar2 == null) {
                this.f883k = new c(Collections.singletonList(new C0244a(Float.valueOf(0.0f))));
            }
            this.f883k.m(c0246c);
            return true;
        }
        if (obj != Q.i.f602n || (cVar = this.f884l) == null) {
            return false;
        }
        if (cVar == null) {
            this.f884l = new c(Collections.singletonList(new C0244a(Float.valueOf(0.0f))));
        }
        this.f884l.m(c0246c);
        return true;
    }

    public a e() {
        return this.f886n;
    }

    public Matrix f() {
        this.f874a.reset();
        a aVar = this.f879g;
        if (aVar != null) {
            PointF pointF = (PointF) aVar.h();
            float f2 = pointF.x;
            if (f2 != 0.0f || pointF.y != 0.0f) {
                this.f874a.preTranslate(f2, pointF.y);
            }
        }
        a aVar2 = this.f881i;
        if (aVar2 != null) {
            float fFloatValue = aVar2 instanceof p ? ((Float) aVar2.h()).floatValue() : ((c) aVar2).n();
            if (fFloatValue != 0.0f) {
                this.f874a.preRotate(fFloatValue);
            }
        }
        if (this.f883k != null) {
            float fCos = this.f884l == null ? 0.0f : (float) Math.cos(Math.toRadians((-r0.n()) + 90.0f));
            float fSin = this.f884l == null ? 1.0f : (float) Math.sin(Math.toRadians((-r4.n()) + 90.0f));
            float fTan = (float) Math.tan(Math.toRadians(this.f883k.n()));
            d();
            float[] fArr = this.e;
            fArr[0] = fCos;
            fArr[1] = fSin;
            float f3 = -fSin;
            fArr[3] = f3;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            this.f875b.setValues(fArr);
            d();
            float[] fArr2 = this.e;
            fArr2[0] = 1.0f;
            fArr2[3] = fTan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.f876c.setValues(fArr2);
            d();
            float[] fArr3 = this.e;
            fArr3[0] = fCos;
            fArr3[1] = f3;
            fArr3[3] = fSin;
            fArr3[4] = fCos;
            fArr3[8] = 1.0f;
            this.f877d.setValues(fArr3);
            this.f876c.preConcat(this.f875b);
            this.f877d.preConcat(this.f876c);
            this.f874a.preConcat(this.f877d);
        }
        a aVar3 = this.f880h;
        if (aVar3 != null) {
            C0247d c0247d = (C0247d) aVar3.h();
            if (c0247d.b() != 1.0f || c0247d.c() != 1.0f) {
                this.f874a.preScale(c0247d.b(), c0247d.c());
            }
        }
        a aVar4 = this.f878f;
        if (aVar4 != null) {
            PointF pointF2 = (PointF) aVar4.h();
            float f4 = pointF2.x;
            if (f4 != 0.0f || pointF2.y != 0.0f) {
                this.f874a.preTranslate(-f4, -pointF2.y);
            }
        }
        return this.f874a;
    }

    public Matrix g(float f2) {
        a aVar = this.f879g;
        PointF pointF = aVar == null ? null : (PointF) aVar.h();
        a aVar2 = this.f880h;
        C0247d c0247d = aVar2 == null ? null : (C0247d) aVar2.h();
        this.f874a.reset();
        if (pointF != null) {
            this.f874a.preTranslate(pointF.x * f2, pointF.y * f2);
        }
        if (c0247d != null) {
            double d2 = f2;
            this.f874a.preScale((float) Math.pow(c0247d.b(), d2), (float) Math.pow(c0247d.c(), d2));
        }
        a aVar3 = this.f881i;
        if (aVar3 != null) {
            float fFloatValue = ((Float) aVar3.h()).floatValue();
            a aVar4 = this.f878f;
            PointF pointF2 = aVar4 != null ? (PointF) aVar4.h() : null;
            this.f874a.preRotate(fFloatValue * f2, pointF2 == null ? 0.0f : pointF2.x, pointF2 != null ? pointF2.y : 0.0f);
        }
        return this.f874a;
    }

    public a h() {
        return this.f882j;
    }

    public a i() {
        return this.f885m;
    }

    public void j(float f2) {
        a aVar = this.f882j;
        if (aVar != null) {
            aVar.l(f2);
        }
        a aVar2 = this.f885m;
        if (aVar2 != null) {
            aVar2.l(f2);
        }
        a aVar3 = this.f886n;
        if (aVar3 != null) {
            aVar3.l(f2);
        }
        a aVar4 = this.f878f;
        if (aVar4 != null) {
            aVar4.l(f2);
        }
        a aVar5 = this.f879g;
        if (aVar5 != null) {
            aVar5.l(f2);
        }
        a aVar6 = this.f880h;
        if (aVar6 != null) {
            aVar6.l(f2);
        }
        a aVar7 = this.f881i;
        if (aVar7 != null) {
            aVar7.l(f2);
        }
        c cVar = this.f883k;
        if (cVar != null) {
            cVar.l(f2);
        }
        c cVar2 = this.f884l;
        if (cVar2 != null) {
            cVar2.l(f2);
        }
    }
}
