package S;

import T.a;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import d0.C0246c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class g implements e, a.InterfaceC0012a, k {

    /* renamed from: a */
    private final Path f759a;

    /* renamed from: b */
    private final Paint f760b;

    /* renamed from: c */
    private final Y.a f761c;

    /* renamed from: d */
    private final String f762d;
    private final boolean e;

    /* renamed from: f */
    private final List f763f;

    /* renamed from: g */
    private final T.a f764g;

    /* renamed from: h */
    private final T.a f765h;

    /* renamed from: i */
    private T.a f766i;

    /* renamed from: j */
    private final com.airbnb.lottie.a f767j;

    public g(com.airbnb.lottie.a aVar, Y.a aVar2, X.m mVar) {
        Path path = new Path();
        this.f759a = path;
        this.f760b = new R.a(1);
        this.f763f = new ArrayList();
        this.f761c = aVar2;
        this.f762d = mVar.d();
        this.e = mVar.f();
        this.f767j = aVar;
        if (mVar.b() == null || mVar.e() == null) {
            this.f764g = null;
            this.f765h = null;
            return;
        }
        path.setFillType(mVar.c());
        T.a aVarA = mVar.b().a();
        this.f764g = aVarA;
        aVarA.a(this);
        aVar2.j(aVarA);
        T.a aVarA2 = mVar.e().a();
        this.f765h = aVarA2;
        aVarA2.a(this);
        aVar2.j(aVarA2);
    }

    @Override // S.e
    public void a(RectF rectF, Matrix matrix, boolean z2) {
        this.f759a.reset();
        for (int i2 = 0; i2 < this.f763f.size(); i2++) {
            this.f759a.addPath(((m) this.f763f.get(i2)).h(), matrix);
        }
        this.f759a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // T.a.InterfaceC0012a
    public void b() {
        this.f767j.invalidateSelf();
    }

    @Override // V.f
    public void c(Object obj, C0246c c0246c) {
        if (obj == Q.i.f590a) {
            this.f764g.m(c0246c);
            return;
        }
        if (obj == Q.i.f593d) {
            this.f765h.m(c0246c);
            return;
        }
        if (obj == Q.i.f588B) {
            if (c0246c == null) {
                this.f766i = null;
                return;
            }
            T.p pVar = new T.p(c0246c);
            this.f766i = pVar;
            pVar.a(this);
            this.f761c.j(this.f766i);
        }
    }

    @Override // S.c
    public void d(List list, List list2) {
        for (int i2 = 0; i2 < list2.size(); i2++) {
            c cVar = (c) list2.get(i2);
            if (cVar instanceof m) {
                this.f763f.add((m) cVar);
            }
        }
    }

    @Override // V.f
    public void f(V.e eVar, int i2, List list, V.e eVar2) {
        c0.i.l(eVar, i2, list, eVar2, this);
    }

    @Override // S.e
    public void g(Canvas canvas, Matrix matrix, int i2) {
        if (this.e) {
            return;
        }
        Q.c.a("FillContent#draw");
        this.f760b.setColor(((T.b) this.f764g).n());
        this.f760b.setAlpha(c0.i.c((int) ((((i2 / 255.0f) * ((Integer) this.f765h.h()).intValue()) / 100.0f) * 255.0f), 0, 255));
        T.a aVar = this.f766i;
        if (aVar != null) {
            this.f760b.setColorFilter((ColorFilter) aVar.h());
        }
        this.f759a.reset();
        for (int i3 = 0; i3 < this.f763f.size(); i3++) {
            this.f759a.addPath(((m) this.f763f.get(i3)).h(), matrix);
        }
        canvas.drawPath(this.f759a, this.f760b);
        Q.c.b("FillContent#draw");
    }

    @Override // S.c
    public String i() {
        return this.f762d;
    }
}
