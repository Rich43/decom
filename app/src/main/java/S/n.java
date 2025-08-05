package S;

import T.a;
import X.i;
import X.q;
import android.graphics.Path;
import android.graphics.PointF;
import d0.C0246c;
import java.util.List;

/* loaded from: classes.dex */
public class n implements m, a.InterfaceC0012a, k {

    /* renamed from: b, reason: collision with root package name */
    private final String f798b;

    /* renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.a f799c;

    /* renamed from: d, reason: collision with root package name */
    private final i.a f800d;
    private final boolean e;

    /* renamed from: f, reason: collision with root package name */
    private final T.a f801f;

    /* renamed from: g, reason: collision with root package name */
    private final T.a f802g;

    /* renamed from: h, reason: collision with root package name */
    private final T.a f803h;

    /* renamed from: i, reason: collision with root package name */
    private final T.a f804i;

    /* renamed from: j, reason: collision with root package name */
    private final T.a f805j;

    /* renamed from: k, reason: collision with root package name */
    private final T.a f806k;

    /* renamed from: l, reason: collision with root package name */
    private final T.a f807l;

    /* renamed from: n, reason: collision with root package name */
    private boolean f809n;

    /* renamed from: a, reason: collision with root package name */
    private final Path f797a = new Path();

    /* renamed from: m, reason: collision with root package name */
    private b f808m = new b();

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f810a;

        static {
            int[] iArr = new int[i.a.values().length];
            f810a = iArr;
            try {
                iArr[i.a.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f810a[i.a.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public n(com.airbnb.lottie.a aVar, Y.a aVar2, X.i iVar) {
        this.f799c = aVar;
        this.f798b = iVar.d();
        i.a aVarJ = iVar.j();
        this.f800d = aVarJ;
        this.e = iVar.k();
        T.a aVarA = iVar.g().a();
        this.f801f = aVarA;
        T.a aVarA2 = iVar.h().a();
        this.f802g = aVarA2;
        T.a aVarA3 = iVar.i().a();
        this.f803h = aVarA3;
        T.a aVarA4 = iVar.e().a();
        this.f805j = aVarA4;
        T.a aVarA5 = iVar.f().a();
        this.f807l = aVarA5;
        i.a aVar3 = i.a.STAR;
        if (aVarJ == aVar3) {
            this.f804i = iVar.b().a();
            this.f806k = iVar.c().a();
        } else {
            this.f804i = null;
            this.f806k = null;
        }
        aVar2.j(aVarA);
        aVar2.j(aVarA2);
        aVar2.j(aVarA3);
        aVar2.j(aVarA4);
        aVar2.j(aVarA5);
        if (aVarJ == aVar3) {
            aVar2.j(this.f804i);
            aVar2.j(this.f806k);
        }
        aVarA.a(this);
        aVarA2.a(this);
        aVarA3.a(this);
        aVarA4.a(this);
        aVarA5.a(this);
        if (aVarJ == aVar3) {
            this.f804i.a(this);
            this.f806k.a(this);
        }
    }

    private void e() {
        int i2;
        double d2;
        double d3;
        double d4;
        int iFloor = (int) Math.floor(((Float) this.f801f.h()).floatValue());
        double radians = Math.toRadians((this.f803h == null ? 0.0d : ((Float) r2.h()).floatValue()) - 90.0d);
        double d5 = iFloor;
        float fFloatValue = ((Float) this.f807l.h()).floatValue() / 100.0f;
        float fFloatValue2 = ((Float) this.f805j.h()).floatValue();
        double d6 = fFloatValue2;
        float fCos = (float) (Math.cos(radians) * d6);
        float fSin = (float) (Math.sin(radians) * d6);
        this.f797a.moveTo(fCos, fSin);
        double d7 = (float) (6.283185307179586d / d5);
        double d8 = radians + d7;
        double dCeil = Math.ceil(d5);
        int i3 = 0;
        while (i3 < dCeil) {
            float fCos2 = (float) (Math.cos(d8) * d6);
            double d9 = dCeil;
            float fSin2 = (float) (d6 * Math.sin(d8));
            if (fFloatValue != 0.0f) {
                d3 = d6;
                i2 = i3;
                d2 = d8;
                double dAtan2 = (float) (Math.atan2(fSin, fCos) - 1.5707963267948966d);
                float fCos3 = (float) Math.cos(dAtan2);
                float fSin3 = (float) Math.sin(dAtan2);
                d4 = d7;
                double dAtan22 = (float) (Math.atan2(fSin2, fCos2) - 1.5707963267948966d);
                float f2 = fFloatValue2 * fFloatValue * 0.25f;
                this.f797a.cubicTo(fCos - (fCos3 * f2), fSin - (fSin3 * f2), fCos2 + (((float) Math.cos(dAtan22)) * f2), fSin2 + (f2 * ((float) Math.sin(dAtan22))), fCos2, fSin2);
            } else {
                i2 = i3;
                d2 = d8;
                d3 = d6;
                d4 = d7;
                this.f797a.lineTo(fCos2, fSin2);
            }
            d8 = d2 + d4;
            i3 = i2 + 1;
            fSin = fSin2;
            fCos = fCos2;
            dCeil = d9;
            d6 = d3;
            d7 = d4;
        }
        PointF pointF = (PointF) this.f802g.h();
        this.f797a.offset(pointF.x, pointF.y);
        this.f797a.close();
    }

    private void j() {
        int i2;
        float f2;
        float f3;
        double d2;
        float fSin;
        float f4;
        float f5;
        float f6;
        double d3;
        float f7;
        float f8;
        float f9;
        double d4;
        float fFloatValue = ((Float) this.f801f.h()).floatValue();
        double radians = Math.toRadians((this.f803h == null ? 0.0d : ((Float) r2.h()).floatValue()) - 90.0d);
        double d5 = fFloatValue;
        float f10 = (float) (6.283185307179586d / d5);
        float f11 = f10 / 2.0f;
        float f12 = fFloatValue - ((int) fFloatValue);
        int i3 = (f12 > 0.0f ? 1 : (f12 == 0.0f ? 0 : -1));
        if (i3 != 0) {
            radians += (1.0f - f12) * f11;
        }
        float fFloatValue2 = ((Float) this.f805j.h()).floatValue();
        float fFloatValue3 = ((Float) this.f804i.h()).floatValue();
        T.a aVar = this.f806k;
        float fFloatValue4 = aVar != null ? ((Float) aVar.h()).floatValue() / 100.0f : 0.0f;
        T.a aVar2 = this.f807l;
        float fFloatValue5 = aVar2 != null ? ((Float) aVar2.h()).floatValue() / 100.0f : 0.0f;
        if (i3 != 0) {
            f4 = ((fFloatValue2 - fFloatValue3) * f12) + fFloatValue3;
            i2 = i3;
            double d6 = f4;
            float fCos = (float) (d6 * Math.cos(radians));
            fSin = (float) (d6 * Math.sin(radians));
            this.f797a.moveTo(fCos, fSin);
            d2 = radians + ((f10 * f12) / 2.0f);
            f2 = fCos;
            f3 = f11;
        } else {
            i2 = i3;
            double d7 = fFloatValue2;
            float fCos2 = (float) (Math.cos(radians) * d7);
            float fSin2 = (float) (d7 * Math.sin(radians));
            this.f797a.moveTo(fCos2, fSin2);
            f2 = fCos2;
            f3 = f11;
            d2 = radians + f3;
            fSin = fSin2;
            f4 = 0.0f;
        }
        double dCeil = Math.ceil(d5) * 2.0d;
        int i4 = 0;
        float f13 = f3;
        float f14 = f2;
        boolean z2 = false;
        while (true) {
            double d8 = i4;
            if (d8 >= dCeil) {
                PointF pointF = (PointF) this.f802g.h();
                this.f797a.offset(pointF.x, pointF.y);
                this.f797a.close();
                return;
            }
            float f15 = z2 ? fFloatValue2 : fFloatValue3;
            if (f4 == 0.0f || d8 != dCeil - 2.0d) {
                f5 = f10;
                f6 = f13;
            } else {
                f5 = f10;
                f6 = (f10 * f12) / 2.0f;
            }
            if (f4 == 0.0f || d8 != dCeil - 1.0d) {
                d3 = d8;
                f7 = f4;
                f4 = f15;
            } else {
                d3 = d8;
                f7 = f4;
            }
            double d9 = f4;
            double d10 = dCeil;
            float fCos3 = (float) (d9 * Math.cos(d2));
            float fSin3 = (float) (d9 * Math.sin(d2));
            if (fFloatValue4 == 0.0f && fFloatValue5 == 0.0f) {
                this.f797a.lineTo(fCos3, fSin3);
                d4 = d2;
                f8 = fFloatValue4;
                f9 = fFloatValue5;
            } else {
                f8 = fFloatValue4;
                double dAtan2 = (float) (Math.atan2(fSin, f14) - 1.5707963267948966d);
                float fCos4 = (float) Math.cos(dAtan2);
                float fSin4 = (float) Math.sin(dAtan2);
                f9 = fFloatValue5;
                d4 = d2;
                double dAtan22 = (float) (Math.atan2(fSin3, fCos3) - 1.5707963267948966d);
                float fCos5 = (float) Math.cos(dAtan22);
                float fSin5 = (float) Math.sin(dAtan22);
                float f16 = z2 ? f8 : f9;
                float f17 = z2 ? f9 : f8;
                float f18 = (z2 ? fFloatValue3 : fFloatValue2) * f16 * 0.47829f;
                float f19 = fCos4 * f18;
                float f20 = f18 * fSin4;
                float f21 = (z2 ? fFloatValue2 : fFloatValue3) * f17 * 0.47829f;
                float f22 = fCos5 * f21;
                float f23 = f21 * fSin5;
                if (i2 != 0) {
                    if (i4 == 0) {
                        f19 *= f12;
                        f20 *= f12;
                    } else if (d3 == d10 - 1.0d) {
                        f22 *= f12;
                        f23 *= f12;
                    }
                }
                this.f797a.cubicTo(f14 - f19, fSin - f20, fCos3 + f22, fSin3 + f23, fCos3, fSin3);
            }
            d2 = d4 + f6;
            z2 = !z2;
            i4++;
            f14 = fCos3;
            fSin = fSin3;
            fFloatValue5 = f9;
            fFloatValue4 = f8;
            f4 = f7;
            f10 = f5;
            dCeil = d10;
        }
    }

    private void k() {
        this.f809n = false;
        this.f799c.invalidateSelf();
    }

    @Override // T.a.InterfaceC0012a
    public void b() {
        k();
    }

    @Override // V.f
    public void c(Object obj, C0246c c0246c) {
        T.a aVar;
        T.a aVar2;
        if (obj == Q.i.s) {
            this.f801f.m(c0246c);
            return;
        }
        if (obj == Q.i.f605t) {
            this.f803h.m(c0246c);
            return;
        }
        if (obj == Q.i.f598j) {
            this.f802g.m(c0246c);
            return;
        }
        if (obj == Q.i.f606u && (aVar2 = this.f804i) != null) {
            aVar2.m(c0246c);
            return;
        }
        if (obj == Q.i.f607v) {
            this.f805j.m(c0246c);
            return;
        }
        if (obj == Q.i.f608w && (aVar = this.f806k) != null) {
            aVar.m(c0246c);
        } else if (obj == Q.i.f609x) {
            this.f807l.m(c0246c);
        }
    }

    @Override // S.c
    public void d(List list, List list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVar = (c) list.get(i2);
            if (cVar instanceof s) {
                s sVar = (s) cVar;
                if (sVar.k() == q.a.SIMULTANEOUSLY) {
                    this.f808m.a(sVar);
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
        if (this.f809n) {
            return this.f797a;
        }
        this.f797a.reset();
        if (this.e) {
            this.f809n = true;
            return this.f797a;
        }
        int i2 = a.f810a[this.f800d.ordinal()];
        if (i2 == 1) {
            j();
        } else if (i2 == 2) {
            e();
        }
        this.f797a.close();
        this.f808m.b(this.f797a);
        this.f809n = true;
        return this.f797a;
    }

    @Override // S.c
    public String i() {
        return this.f798b;
    }
}
