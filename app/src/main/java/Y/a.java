package Y;

import T.a;
import T.o;
import X.g;
import Y.d;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import d0.C0246c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class a implements S.e, a.InterfaceC0012a, V.f {

    /* renamed from: a */
    private final Path f1265a = new Path();

    /* renamed from: b */
    private final Matrix f1266b = new Matrix();

    /* renamed from: c */
    private final Paint f1267c = new R.a(1);

    /* renamed from: d */
    private final Paint f1268d;
    private final Paint e;

    /* renamed from: f */
    private final Paint f1269f;

    /* renamed from: g */
    private final Paint f1270g;

    /* renamed from: h */
    private final RectF f1271h;

    /* renamed from: i */
    private final RectF f1272i;

    /* renamed from: j */
    private final RectF f1273j;

    /* renamed from: k */
    private final RectF f1274k;

    /* renamed from: l */
    private final String f1275l;

    /* renamed from: m */
    final Matrix f1276m;

    /* renamed from: n */
    final com.airbnb.lottie.a f1277n;
    final d o;

    /* renamed from: p */
    private T.g f1278p;

    /* renamed from: q */
    private a f1279q;
    private a r;
    private List s;

    /* renamed from: t */
    private final List f1280t;

    /* renamed from: u */
    final o f1281u;

    /* renamed from: v */
    private boolean f1282v;

    /* renamed from: Y.a$a */
    class C0015a implements a.InterfaceC0012a {

        /* renamed from: a */
        final /* synthetic */ T.c f1283a;

        C0015a(T.c cVar) {
            this.f1283a = cVar;
        }

        @Override // T.a.InterfaceC0012a
        public void b() {
            a.this.I(this.f1283a.n() == 1.0f);
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a */
        static final /* synthetic */ int[] f1285a;

        /* renamed from: b */
        static final /* synthetic */ int[] f1286b;

        static {
            int[] iArr = new int[g.a.values().length];
            f1286b = iArr;
            try {
                iArr[g.a.MASK_MODE_SUBTRACT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1286b[g.a.MASK_MODE_INTERSECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1286b[g.a.MASK_MODE_ADD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[d.a.values().length];
            f1285a = iArr2;
            try {
                iArr2[d.a.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1285a[d.a.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1285a[d.a.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1285a[d.a.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1285a[d.a.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1285a[d.a.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f1285a[d.a.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    a(com.airbnb.lottie.a aVar, d dVar) {
        PorterDuff.Mode mode = PorterDuff.Mode.DST_IN;
        this.f1268d = new R.a(1, mode);
        PorterDuff.Mode mode2 = PorterDuff.Mode.DST_OUT;
        this.e = new R.a(1, mode2);
        R.a aVar2 = new R.a(1);
        this.f1269f = aVar2;
        this.f1270g = new R.a(PorterDuff.Mode.CLEAR);
        this.f1271h = new RectF();
        this.f1272i = new RectF();
        this.f1273j = new RectF();
        this.f1274k = new RectF();
        this.f1276m = new Matrix();
        this.f1280t = new ArrayList();
        this.f1282v = true;
        this.f1277n = aVar;
        this.o = dVar;
        this.f1275l = dVar.g() + "#draw";
        if (dVar.f() == d.b.INVERT) {
            aVar2.setXfermode(new PorterDuffXfermode(mode2));
        } else {
            aVar2.setXfermode(new PorterDuffXfermode(mode));
        }
        o oVarB = dVar.u().b();
        this.f1281u = oVarB;
        oVarB.b(this);
        if (dVar.e() != null && !dVar.e().isEmpty()) {
            T.g gVar = new T.g(dVar.e());
            this.f1278p = gVar;
            Iterator it = gVar.a().iterator();
            while (it.hasNext()) {
                ((T.a) it.next()).a(this);
            }
            for (T.a aVar3 : this.f1278p.c()) {
                j(aVar3);
                aVar3.a(this);
            }
        }
        J();
    }

    private void A() {
        this.f1277n.invalidateSelf();
    }

    private void B(float f2) {
        this.f1277n.k().m().a(this.o.g(), f2);
    }

    private void E(Canvas canvas, RectF rectF, Paint paint, boolean z2) {
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, z2 ? 31 : 19);
        } else {
            canvas.saveLayer(rectF, paint);
        }
    }

    public void I(boolean z2) {
        if (z2 != this.f1282v) {
            this.f1282v = z2;
            A();
        }
    }

    private void J() {
        if (this.o.c().isEmpty()) {
            I(true);
            return;
        }
        T.c cVar = new T.c(this.o.c());
        cVar.k();
        cVar.a(new C0015a(cVar));
        I(((Float) cVar.h()).floatValue() == 1.0f);
        j(cVar);
    }

    private void k(Canvas canvas, Matrix matrix, X.g gVar, T.a aVar, T.a aVar2) {
        this.f1265a.set((Path) aVar.h());
        this.f1265a.transform(matrix);
        this.f1267c.setAlpha((int) (((Integer) aVar2.h()).intValue() * 2.55f));
        canvas.drawPath(this.f1265a, this.f1267c);
    }

    private void l(Canvas canvas, Matrix matrix, X.g gVar, T.a aVar, T.a aVar2) {
        E(canvas, this.f1271h, this.f1268d, true);
        this.f1265a.set((Path) aVar.h());
        this.f1265a.transform(matrix);
        this.f1267c.setAlpha((int) (((Integer) aVar2.h()).intValue() * 2.55f));
        canvas.drawPath(this.f1265a, this.f1267c);
        canvas.restore();
    }

    private void m(Canvas canvas, Matrix matrix, X.g gVar, T.a aVar, T.a aVar2) {
        E(canvas, this.f1271h, this.f1267c, true);
        canvas.drawRect(this.f1271h, this.f1267c);
        this.f1265a.set((Path) aVar.h());
        this.f1265a.transform(matrix);
        this.f1267c.setAlpha((int) (((Integer) aVar2.h()).intValue() * 2.55f));
        canvas.drawPath(this.f1265a, this.e);
        canvas.restore();
    }

    private void n(Canvas canvas, Matrix matrix, X.g gVar, T.a aVar, T.a aVar2) {
        E(canvas, this.f1271h, this.f1268d, true);
        canvas.drawRect(this.f1271h, this.f1267c);
        this.e.setAlpha((int) (((Integer) aVar2.h()).intValue() * 2.55f));
        this.f1265a.set((Path) aVar.h());
        this.f1265a.transform(matrix);
        canvas.drawPath(this.f1265a, this.e);
        canvas.restore();
    }

    private void o(Canvas canvas, Matrix matrix, X.g gVar, T.a aVar, T.a aVar2) {
        E(canvas, this.f1271h, this.e, true);
        canvas.drawRect(this.f1271h, this.f1267c);
        this.e.setAlpha((int) (((Integer) aVar2.h()).intValue() * 2.55f));
        this.f1265a.set((Path) aVar.h());
        this.f1265a.transform(matrix);
        canvas.drawPath(this.f1265a, this.e);
        canvas.restore();
    }

    private void p(Canvas canvas, Matrix matrix) {
        Q.c.a("Layer#saveLayer");
        E(canvas, this.f1271h, this.f1268d, false);
        Q.c.b("Layer#saveLayer");
        for (int i2 = 0; i2 < this.f1278p.b().size(); i2++) {
            X.g gVar = (X.g) this.f1278p.b().get(i2);
            T.a aVar = (T.a) this.f1278p.a().get(i2);
            T.a aVar2 = (T.a) this.f1278p.c().get(i2);
            int i3 = b.f1286b[gVar.a().ordinal()];
            if (i3 == 1) {
                if (i2 == 0) {
                    Paint paint = new Paint();
                    paint.setColor(-16777216);
                    canvas.drawRect(this.f1271h, paint);
                }
                if (gVar.d()) {
                    o(canvas, matrix, gVar, aVar, aVar2);
                } else {
                    q(canvas, matrix, gVar, aVar, aVar2);
                }
            } else if (i3 != 2) {
                if (i3 == 3) {
                    if (gVar.d()) {
                        m(canvas, matrix, gVar, aVar, aVar2);
                    } else {
                        k(canvas, matrix, gVar, aVar, aVar2);
                    }
                }
            } else if (gVar.d()) {
                n(canvas, matrix, gVar, aVar, aVar2);
            } else {
                l(canvas, matrix, gVar, aVar, aVar2);
            }
        }
        Q.c.a("Layer#restoreLayer");
        canvas.restore();
        Q.c.b("Layer#restoreLayer");
    }

    private void q(Canvas canvas, Matrix matrix, X.g gVar, T.a aVar, T.a aVar2) {
        this.f1265a.set((Path) aVar.h());
        this.f1265a.transform(matrix);
        canvas.drawPath(this.f1265a, this.e);
    }

    private void r() {
        if (this.s != null) {
            return;
        }
        if (this.r == null) {
            this.s = Collections.emptyList();
            return;
        }
        this.s = new ArrayList();
        for (a aVar = this.r; aVar != null; aVar = aVar.r) {
            this.s.add(aVar);
        }
    }

    private void s(Canvas canvas) {
        Q.c.a("Layer#clearLayer");
        RectF rectF = this.f1271h;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.f1270g);
        Q.c.b("Layer#clearLayer");
    }

    static a u(d dVar, com.airbnb.lottie.a aVar, Q.d dVar2) {
        switch (b.f1285a[dVar.d().ordinal()]) {
            case 1:
                return new f(aVar, dVar);
            case 2:
                return new Y.b(aVar, dVar, dVar2.n(dVar.k()), dVar2);
            case 3:
                return new g(aVar, dVar);
            case 4:
                return new c(aVar, dVar);
            case 5:
                return new e(aVar, dVar);
            case 6:
                return new h(aVar, dVar);
            default:
                c0.f.b("Unknown layer type " + dVar.d());
                return null;
        }
    }

    private void y(RectF rectF, Matrix matrix) {
        this.f1272i.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (w()) {
            int size = this.f1278p.b().size();
            for (int i2 = 0; i2 < size; i2++) {
                X.g gVar = (X.g) this.f1278p.b().get(i2);
                this.f1265a.set((Path) ((T.a) this.f1278p.a().get(i2)).h());
                this.f1265a.transform(matrix);
                int i3 = b.f1286b[gVar.a().ordinal()];
                if (i3 == 1) {
                    return;
                }
                if ((i3 == 2 || i3 == 3) && gVar.d()) {
                    return;
                }
                this.f1265a.computeBounds(this.f1274k, false);
                if (i2 == 0) {
                    this.f1272i.set(this.f1274k);
                } else {
                    RectF rectF2 = this.f1272i;
                    rectF2.set(Math.min(rectF2.left, this.f1274k.left), Math.min(this.f1272i.top, this.f1274k.top), Math.max(this.f1272i.right, this.f1274k.right), Math.max(this.f1272i.bottom, this.f1274k.bottom));
                }
            }
            if (rectF.intersect(this.f1272i)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void z(RectF rectF, Matrix matrix) {
        if (x() && this.o.f() != d.b.INVERT) {
            this.f1273j.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.f1279q.a(this.f1273j, matrix, true);
            if (rectF.intersect(this.f1273j)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public void C(T.a aVar) {
        this.f1280t.remove(aVar);
    }

    void F(a aVar) {
        this.f1279q = aVar;
    }

    void G(a aVar) {
        this.r = aVar;
    }

    void H(float f2) {
        this.f1281u.j(f2);
        if (this.f1278p != null) {
            for (int i2 = 0; i2 < this.f1278p.a().size(); i2++) {
                ((T.a) this.f1278p.a().get(i2)).l(f2);
            }
        }
        if (this.o.t() != 0.0f) {
            f2 /= this.o.t();
        }
        a aVar = this.f1279q;
        if (aVar != null) {
            this.f1279q.H(aVar.o.t() * f2);
        }
        for (int i3 = 0; i3 < this.f1280t.size(); i3++) {
            ((T.a) this.f1280t.get(i3)).l(f2);
        }
    }

    @Override // S.e
    public void a(RectF rectF, Matrix matrix, boolean z2) {
        this.f1271h.set(0.0f, 0.0f, 0.0f, 0.0f);
        r();
        this.f1276m.set(matrix);
        if (z2) {
            List list = this.s;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f1276m.preConcat(((a) this.s.get(size)).f1281u.f());
                }
            } else {
                a aVar = this.r;
                if (aVar != null) {
                    this.f1276m.preConcat(aVar.f1281u.f());
                }
            }
        }
        this.f1276m.preConcat(this.f1281u.f());
    }

    @Override // T.a.InterfaceC0012a
    public void b() {
        A();
    }

    @Override // V.f
    public void c(Object obj, C0246c c0246c) {
        this.f1281u.c(obj, c0246c);
    }

    @Override // V.f
    public void f(V.e eVar, int i2, List list, V.e eVar2) {
        if (eVar.g(i(), i2)) {
            if (!"__container".equals(i())) {
                eVar2 = eVar2.a(i());
                if (eVar.c(i(), i2)) {
                    list.add(eVar2.i(this));
                }
            }
            if (eVar.h(i(), i2)) {
                D(eVar, i2 + eVar.e(i(), i2), list, eVar2);
            }
        }
    }

    @Override // S.e
    public void g(Canvas canvas, Matrix matrix, int i2) {
        Q.c.a(this.f1275l);
        if (!this.f1282v || this.o.v()) {
            Q.c.b(this.f1275l);
            return;
        }
        r();
        Q.c.a("Layer#parentMatrix");
        this.f1266b.reset();
        this.f1266b.set(matrix);
        for (int size = this.s.size() - 1; size >= 0; size--) {
            this.f1266b.preConcat(((a) this.s.get(size)).f1281u.f());
        }
        Q.c.b("Layer#parentMatrix");
        int iIntValue = (int) ((((i2 / 255.0f) * (this.f1281u.h() == null ? 100 : ((Integer) this.f1281u.h().h()).intValue())) / 100.0f) * 255.0f);
        if (!x() && !w()) {
            this.f1266b.preConcat(this.f1281u.f());
            Q.c.a("Layer#drawLayer");
            t(canvas, this.f1266b, iIntValue);
            Q.c.b("Layer#drawLayer");
            B(Q.c.b(this.f1275l));
            return;
        }
        Q.c.a("Layer#computeBounds");
        a(this.f1271h, this.f1266b, false);
        z(this.f1271h, matrix);
        this.f1266b.preConcat(this.f1281u.f());
        y(this.f1271h, this.f1266b);
        if (!this.f1271h.intersect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight())) {
            this.f1271h.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
        Q.c.b("Layer#computeBounds");
        if (!this.f1271h.isEmpty()) {
            Q.c.a("Layer#saveLayer");
            E(canvas, this.f1271h, this.f1267c, true);
            Q.c.b("Layer#saveLayer");
            s(canvas);
            Q.c.a("Layer#drawLayer");
            t(canvas, this.f1266b, iIntValue);
            Q.c.b("Layer#drawLayer");
            if (w()) {
                p(canvas, this.f1266b);
            }
            if (x()) {
                Q.c.a("Layer#drawMatte");
                Q.c.a("Layer#saveLayer");
                E(canvas, this.f1271h, this.f1269f, false);
                Q.c.b("Layer#saveLayer");
                s(canvas);
                this.f1279q.g(canvas, matrix, iIntValue);
                Q.c.a("Layer#restoreLayer");
                canvas.restore();
                Q.c.b("Layer#restoreLayer");
                Q.c.b("Layer#drawMatte");
            }
            Q.c.a("Layer#restoreLayer");
            canvas.restore();
            Q.c.b("Layer#restoreLayer");
        }
        B(Q.c.b(this.f1275l));
    }

    @Override // S.c
    public String i() {
        return this.o.g();
    }

    public void j(T.a aVar) {
        if (aVar == null) {
            return;
        }
        this.f1280t.add(aVar);
    }

    abstract void t(Canvas canvas, Matrix matrix, int i2);

    d v() {
        return this.o;
    }

    boolean w() {
        T.g gVar = this.f1278p;
        return (gVar == null || gVar.a().isEmpty()) ? false : true;
    }

    boolean x() {
        return this.f1279q != null;
    }

    @Override // S.c
    public void d(List list, List list2) {
    }

    void D(V.e eVar, int i2, List list, V.e eVar2) {
    }
}
