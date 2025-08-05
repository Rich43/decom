package S;

import T.a;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import d0.C0246c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class a implements a.InterfaceC0012a, k, e {
    private final com.airbnb.lottie.a e;

    /* renamed from: f, reason: collision with root package name */
    protected final Y.a f732f;

    /* renamed from: h, reason: collision with root package name */
    private final float[] f734h;

    /* renamed from: i, reason: collision with root package name */
    final Paint f735i;

    /* renamed from: j, reason: collision with root package name */
    private final T.a f736j;

    /* renamed from: k, reason: collision with root package name */
    private final T.a f737k;

    /* renamed from: l, reason: collision with root package name */
    private final List f738l;

    /* renamed from: m, reason: collision with root package name */
    private final T.a f739m;

    /* renamed from: n, reason: collision with root package name */
    private T.a f740n;

    /* renamed from: a, reason: collision with root package name */
    private final PathMeasure f728a = new PathMeasure();

    /* renamed from: b, reason: collision with root package name */
    private final Path f729b = new Path();

    /* renamed from: c, reason: collision with root package name */
    private final Path f730c = new Path();

    /* renamed from: d, reason: collision with root package name */
    private final RectF f731d = new RectF();

    /* renamed from: g, reason: collision with root package name */
    private final List f733g = new ArrayList();

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final List f741a;

        /* renamed from: b, reason: collision with root package name */
        private final s f742b;

        private b(s sVar) {
            this.f741a = new ArrayList();
            this.f742b = sVar;
        }
    }

    a(com.airbnb.lottie.a aVar, Y.a aVar2, Paint.Cap cap, Paint.Join join, float f2, W.d dVar, W.b bVar, List list, W.b bVar2) {
        R.a aVar3 = new R.a(1);
        this.f735i = aVar3;
        this.e = aVar;
        this.f732f = aVar2;
        aVar3.setStyle(Paint.Style.STROKE);
        aVar3.setStrokeCap(cap);
        aVar3.setStrokeJoin(join);
        aVar3.setStrokeMiter(f2);
        this.f737k = dVar.a();
        this.f736j = bVar.a();
        if (bVar2 == null) {
            this.f739m = null;
        } else {
            this.f739m = bVar2.a();
        }
        this.f738l = new ArrayList(list.size());
        this.f734h = new float[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f738l.add(((W.b) list.get(i2)).a());
        }
        aVar2.j(this.f737k);
        aVar2.j(this.f736j);
        for (int i3 = 0; i3 < this.f738l.size(); i3++) {
            aVar2.j((T.a) this.f738l.get(i3));
        }
        T.a aVar4 = this.f739m;
        if (aVar4 != null) {
            aVar2.j(aVar4);
        }
        this.f737k.a(this);
        this.f736j.a(this);
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((T.a) this.f738l.get(i4)).a(this);
        }
        T.a aVar5 = this.f739m;
        if (aVar5 != null) {
            aVar5.a(this);
        }
    }

    private void e(Matrix matrix) {
        Q.c.a("StrokeContent#applyDashPattern");
        if (this.f738l.isEmpty()) {
            Q.c.b("StrokeContent#applyDashPattern");
            return;
        }
        float fG = c0.j.g(matrix);
        for (int i2 = 0; i2 < this.f738l.size(); i2++) {
            this.f734h[i2] = ((Float) ((T.a) this.f738l.get(i2)).h()).floatValue();
            if (i2 % 2 == 0) {
                float[] fArr = this.f734h;
                if (fArr[i2] < 1.0f) {
                    fArr[i2] = 1.0f;
                }
            } else {
                float[] fArr2 = this.f734h;
                if (fArr2[i2] < 0.1f) {
                    fArr2[i2] = 0.1f;
                }
            }
            float[] fArr3 = this.f734h;
            fArr3[i2] = fArr3[i2] * fG;
        }
        T.a aVar = this.f739m;
        this.f735i.setPathEffect(new DashPathEffect(this.f734h, aVar == null ? 0.0f : ((Float) aVar.h()).floatValue()));
        Q.c.b("StrokeContent#applyDashPattern");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void j(android.graphics.Canvas r13, S.a.b r14, android.graphics.Matrix r15) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: S.a.j(android.graphics.Canvas, S.a$b, android.graphics.Matrix):void");
    }

    @Override // S.e
    public void a(RectF rectF, Matrix matrix, boolean z2) {
        Q.c.a("StrokeContent#getBounds");
        this.f729b.reset();
        for (int i2 = 0; i2 < this.f733g.size(); i2++) {
            b bVar = (b) this.f733g.get(i2);
            for (int i3 = 0; i3 < bVar.f741a.size(); i3++) {
                this.f729b.addPath(((m) bVar.f741a.get(i3)).h(), matrix);
            }
        }
        this.f729b.computeBounds(this.f731d, false);
        float fN = ((T.c) this.f736j).n();
        RectF rectF2 = this.f731d;
        float f2 = fN / 2.0f;
        rectF2.set(rectF2.left - f2, rectF2.top - f2, rectF2.right + f2, rectF2.bottom + f2);
        rectF.set(this.f731d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        Q.c.b("StrokeContent#getBounds");
    }

    @Override // T.a.InterfaceC0012a
    public void b() {
        this.e.invalidateSelf();
    }

    @Override // V.f
    public void c(Object obj, C0246c c0246c) {
        if (obj == Q.i.f593d) {
            this.f737k.m(c0246c);
            return;
        }
        if (obj == Q.i.o) {
            this.f736j.m(c0246c);
            return;
        }
        if (obj == Q.i.f588B) {
            if (c0246c == null) {
                this.f740n = null;
                return;
            }
            T.p pVar = new T.p(c0246c);
            this.f740n = pVar;
            pVar.a(this);
            this.f732f.j(this.f740n);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0055  */
    @Override // S.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(java.util.List r8, java.util.List r9) {
        /*
            r7 = this;
            int r0 = r8.size()
            int r0 = r0 + (-1)
            r1 = 0
            r2 = r1
        L8:
            if (r0 < 0) goto L22
            java.lang.Object r3 = r8.get(r0)
            S.c r3 = (S.c) r3
            boolean r4 = r3 instanceof S.s
            if (r4 == 0) goto L1f
            S.s r3 = (S.s) r3
            X.q$a r4 = r3.k()
            X.q$a r5 = X.q.a.INDIVIDUALLY
            if (r4 != r5) goto L1f
            r2 = r3
        L1f:
            int r0 = r0 + (-1)
            goto L8
        L22:
            if (r2 == 0) goto L27
            r2.c(r7)
        L27:
            int r8 = r9.size()
            int r8 = r8 + (-1)
            r0 = r1
        L2e:
            if (r8 < 0) goto L6c
            java.lang.Object r3 = r9.get(r8)
            S.c r3 = (S.c) r3
            boolean r4 = r3 instanceof S.s
            if (r4 == 0) goto L55
            r4 = r3
            S.s r4 = (S.s) r4
            X.q$a r5 = r4.k()
            X.q$a r6 = X.q.a.INDIVIDUALLY
            if (r5 != r6) goto L55
            if (r0 == 0) goto L4c
            java.util.List r3 = r7.f733g
            r3.add(r0)
        L4c:
            S.a$b r0 = new S.a$b
            r0.<init>(r4)
            r4.c(r7)
            goto L69
        L55:
            boolean r4 = r3 instanceof S.m
            if (r4 == 0) goto L69
            if (r0 != 0) goto L60
            S.a$b r0 = new S.a$b
            r0.<init>(r2)
        L60:
            java.util.List r4 = S.a.b.a(r0)
            S.m r3 = (S.m) r3
            r4.add(r3)
        L69:
            int r8 = r8 + (-1)
            goto L2e
        L6c:
            if (r0 == 0) goto L73
            java.util.List r8 = r7.f733g
            r8.add(r0)
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: S.a.d(java.util.List, java.util.List):void");
    }

    @Override // V.f
    public void f(V.e eVar, int i2, List list, V.e eVar2) {
        c0.i.l(eVar, i2, list, eVar2, this);
    }

    @Override // S.e
    public void g(Canvas canvas, Matrix matrix, int i2) {
        Q.c.a("StrokeContent#draw");
        if (c0.j.h(matrix)) {
            Q.c.b("StrokeContent#draw");
            return;
        }
        this.f735i.setAlpha(c0.i.c((int) ((((i2 / 255.0f) * ((T.e) this.f737k).n()) / 100.0f) * 255.0f), 0, 255));
        this.f735i.setStrokeWidth(((T.c) this.f736j).n() * c0.j.g(matrix));
        if (this.f735i.getStrokeWidth() <= 0.0f) {
            Q.c.b("StrokeContent#draw");
            return;
        }
        e(matrix);
        T.a aVar = this.f740n;
        if (aVar != null) {
            this.f735i.setColorFilter((ColorFilter) aVar.h());
        }
        for (int i3 = 0; i3 < this.f733g.size(); i3++) {
            b bVar = (b) this.f733g.get(i3);
            if (bVar.f742b != null) {
                j(canvas, bVar, matrix);
            } else {
                Q.c.a("StrokeContent#buildPath");
                this.f729b.reset();
                for (int size = bVar.f741a.size() - 1; size >= 0; size--) {
                    this.f729b.addPath(((m) bVar.f741a.get(size)).h(), matrix);
                }
                Q.c.b("StrokeContent#buildPath");
                Q.c.a("StrokeContent#drawPath");
                canvas.drawPath(this.f729b, this.f735i);
                Q.c.b("StrokeContent#drawPath");
            }
        }
        Q.c.b("StrokeContent#draw");
    }
}
