package S;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import d0.C0246c;

/* loaded from: classes.dex */
public class r extends a {
    private final Y.a o;

    /* renamed from: p, reason: collision with root package name */
    private final String f835p;

    /* renamed from: q, reason: collision with root package name */
    private final boolean f836q;
    private final T.a r;
    private T.a s;

    public r(com.airbnb.lottie.a aVar, Y.a aVar2, X.p pVar) {
        super(aVar, aVar2, pVar.b().a(), pVar.e().a(), pVar.g(), pVar.i(), pVar.j(), pVar.f(), pVar.d());
        this.o = aVar2;
        this.f835p = pVar.h();
        this.f836q = pVar.k();
        T.a aVarA = pVar.c().a();
        this.r = aVarA;
        aVarA.a(this);
        aVar2.j(aVarA);
    }

    @Override // S.a, V.f
    public void c(Object obj, C0246c c0246c) {
        super.c(obj, c0246c);
        if (obj == Q.i.f591b) {
            this.r.m(c0246c);
            return;
        }
        if (obj == Q.i.f588B) {
            if (c0246c == null) {
                this.s = null;
                return;
            }
            T.p pVar = new T.p(c0246c);
            this.s = pVar;
            pVar.a(this);
            this.o.j(this.r);
        }
    }

    @Override // S.a, S.e
    public void g(Canvas canvas, Matrix matrix, int i2) {
        if (this.f836q) {
            return;
        }
        this.f735i.setColor(((T.b) this.r).n());
        T.a aVar = this.s;
        if (aVar != null) {
            this.f735i.setColorFilter((ColorFilter) aVar.h());
        }
        super.g(canvas, matrix, i2);
    }

    @Override // S.c
    public String i() {
        return this.f835p;
    }
}
