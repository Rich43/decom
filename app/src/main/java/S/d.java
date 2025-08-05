package S;

import T.a;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import d0.C0246c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class d implements e, m, a.InterfaceC0012a, V.f {

    /* renamed from: a, reason: collision with root package name */
    private final Matrix f744a;

    /* renamed from: b, reason: collision with root package name */
    private final Path f745b;

    /* renamed from: c, reason: collision with root package name */
    private final RectF f746c;

    /* renamed from: d, reason: collision with root package name */
    private final String f747d;
    private final boolean e;

    /* renamed from: f, reason: collision with root package name */
    private final List f748f;

    /* renamed from: g, reason: collision with root package name */
    private final com.airbnb.lottie.a f749g;

    /* renamed from: h, reason: collision with root package name */
    private List f750h;

    /* renamed from: i, reason: collision with root package name */
    private T.o f751i;

    public d(com.airbnb.lottie.a aVar, Y.a aVar2, X.n nVar) {
        this(aVar, aVar2, nVar.c(), nVar.d(), e(aVar, aVar2, nVar.b()), j(nVar.b()));
    }

    private static List e(com.airbnb.lottie.a aVar, Y.a aVar2, List list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVarA = ((X.b) list.get(i2)).a(aVar, aVar2);
            if (cVarA != null) {
                arrayList.add(cVarA);
            }
        }
        return arrayList;
    }

    static W.l j(List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            X.b bVar = (X.b) list.get(i2);
            if (bVar instanceof W.l) {
                return (W.l) bVar;
            }
        }
        return null;
    }

    @Override // S.e
    public void a(RectF rectF, Matrix matrix, boolean z2) {
        this.f744a.set(matrix);
        T.o oVar = this.f751i;
        if (oVar != null) {
            this.f744a.preConcat(oVar.f());
        }
        this.f746c.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f748f.size() - 1; size >= 0; size--) {
            c cVar = (c) this.f748f.get(size);
            if (cVar instanceof e) {
                ((e) cVar).a(this.f746c, this.f744a, z2);
                rectF.union(this.f746c);
            }
        }
    }

    @Override // T.a.InterfaceC0012a
    public void b() {
        this.f749g.invalidateSelf();
    }

    @Override // V.f
    public void c(Object obj, C0246c c0246c) {
        T.o oVar = this.f751i;
        if (oVar != null) {
            oVar.c(obj, c0246c);
        }
    }

    @Override // S.c
    public void d(List list, List list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f748f.size());
        arrayList.addAll(list);
        for (int size = this.f748f.size() - 1; size >= 0; size--) {
            c cVar = (c) this.f748f.get(size);
            cVar.d(arrayList, this.f748f.subList(0, size));
            arrayList.add(cVar);
        }
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
                int iE = i2 + eVar.e(i(), i2);
                for (int i3 = 0; i3 < this.f748f.size(); i3++) {
                    c cVar = (c) this.f748f.get(i3);
                    if (cVar instanceof V.f) {
                        ((V.f) cVar).f(eVar, iE, list, eVar2);
                    }
                }
            }
        }
    }

    @Override // S.e
    public void g(Canvas canvas, Matrix matrix, int i2) {
        if (this.e) {
            return;
        }
        this.f744a.set(matrix);
        T.o oVar = this.f751i;
        if (oVar != null) {
            this.f744a.preConcat(oVar.f());
            i2 = (int) (((((this.f751i.h() == null ? 100 : ((Integer) this.f751i.h().h()).intValue()) / 100.0f) * i2) / 255.0f) * 255.0f);
        }
        for (int size = this.f748f.size() - 1; size >= 0; size--) {
            Object obj = this.f748f.get(size);
            if (obj instanceof e) {
                ((e) obj).g(canvas, this.f744a, i2);
            }
        }
    }

    @Override // S.m
    public Path h() {
        this.f744a.reset();
        T.o oVar = this.f751i;
        if (oVar != null) {
            this.f744a.set(oVar.f());
        }
        this.f745b.reset();
        if (this.e) {
            return this.f745b;
        }
        for (int size = this.f748f.size() - 1; size >= 0; size--) {
            c cVar = (c) this.f748f.get(size);
            if (cVar instanceof m) {
                this.f745b.addPath(((m) cVar).h(), this.f744a);
            }
        }
        return this.f745b;
    }

    @Override // S.c
    public String i() {
        return this.f747d;
    }

    List k() {
        if (this.f750h == null) {
            this.f750h = new ArrayList();
            for (int i2 = 0; i2 < this.f748f.size(); i2++) {
                c cVar = (c) this.f748f.get(i2);
                if (cVar instanceof m) {
                    this.f750h.add((m) cVar);
                }
            }
        }
        return this.f750h;
    }

    Matrix l() {
        T.o oVar = this.f751i;
        if (oVar != null) {
            return oVar.f();
        }
        this.f744a.reset();
        return this.f744a;
    }

    d(com.airbnb.lottie.a aVar, Y.a aVar2, String str, boolean z2, List list, W.l lVar) {
        this.f744a = new Matrix();
        this.f745b = new Path();
        this.f746c = new RectF();
        this.f747d = str;
        this.f749g = aVar;
        this.e = z2;
        this.f748f = list;
        if (lVar != null) {
            T.o oVarB = lVar.b();
            this.f751i = oVarB;
            oVarB.a(aVar2);
            this.f751i.b(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = (c) list.get(size);
            if (cVar instanceof j) {
                arrayList.add((j) cVar);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((j) arrayList.get(size2)).e(list.listIterator(list.size()));
        }
    }
}
