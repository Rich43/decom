package S;

import T.a;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import d0.C0246c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes.dex */
public class p implements e, m, j, a.InterfaceC0012a, k {

    /* renamed from: a, reason: collision with root package name */
    private final Matrix f820a = new Matrix();

    /* renamed from: b, reason: collision with root package name */
    private final Path f821b = new Path();

    /* renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.a f822c;

    /* renamed from: d, reason: collision with root package name */
    private final Y.a f823d;
    private final String e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f824f;

    /* renamed from: g, reason: collision with root package name */
    private final T.a f825g;

    /* renamed from: h, reason: collision with root package name */
    private final T.a f826h;

    /* renamed from: i, reason: collision with root package name */
    private final T.o f827i;

    /* renamed from: j, reason: collision with root package name */
    private d f828j;

    public p(com.airbnb.lottie.a aVar, Y.a aVar2, X.k kVar) {
        this.f822c = aVar;
        this.f823d = aVar2;
        this.e = kVar.c();
        this.f824f = kVar.f();
        T.a aVarA = kVar.b().a();
        this.f825g = aVarA;
        aVar2.j(aVarA);
        aVarA.a(this);
        T.a aVarA2 = kVar.d().a();
        this.f826h = aVarA2;
        aVar2.j(aVarA2);
        aVarA2.a(this);
        T.o oVarB = kVar.e().b();
        this.f827i = oVarB;
        oVarB.a(aVar2);
        oVarB.b(this);
    }

    @Override // S.e
    public void a(RectF rectF, Matrix matrix, boolean z2) {
        this.f828j.a(rectF, matrix, z2);
    }

    @Override // T.a.InterfaceC0012a
    public void b() {
        this.f822c.invalidateSelf();
    }

    @Override // V.f
    public void c(Object obj, C0246c c0246c) {
        if (this.f827i.c(obj, c0246c)) {
            return;
        }
        if (obj == Q.i.f604q) {
            this.f825g.m(c0246c);
        } else if (obj == Q.i.r) {
            this.f826h.m(c0246c);
        }
    }

    @Override // S.c
    public void d(List list, List list2) {
        this.f828j.d(list, list2);
    }

    @Override // S.j
    public void e(ListIterator listIterator) {
        if (this.f828j != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.f828j = new d(this.f822c, this.f823d, "Repeater", this.f824f, arrayList, null);
    }

    @Override // V.f
    public void f(V.e eVar, int i2, List list, V.e eVar2) {
        c0.i.l(eVar, i2, list, eVar2, this);
    }

    @Override // S.e
    public void g(Canvas canvas, Matrix matrix, int i2) {
        float fFloatValue = ((Float) this.f825g.h()).floatValue();
        float fFloatValue2 = ((Float) this.f826h.h()).floatValue();
        float fFloatValue3 = ((Float) this.f827i.i().h()).floatValue() / 100.0f;
        float fFloatValue4 = ((Float) this.f827i.e().h()).floatValue() / 100.0f;
        for (int i3 = ((int) fFloatValue) - 1; i3 >= 0; i3--) {
            this.f820a.set(matrix);
            float f2 = i3;
            this.f820a.preConcat(this.f827i.g(f2 + fFloatValue2));
            this.f828j.g(canvas, this.f820a, (int) (i2 * c0.i.j(fFloatValue3, fFloatValue4, f2 / fFloatValue)));
        }
    }

    @Override // S.m
    public Path h() {
        Path pathH = this.f828j.h();
        this.f821b.reset();
        float fFloatValue = ((Float) this.f825g.h()).floatValue();
        float fFloatValue2 = ((Float) this.f826h.h()).floatValue();
        for (int i2 = ((int) fFloatValue) - 1; i2 >= 0; i2--) {
            this.f820a.set(this.f827i.g(i2 + fFloatValue2));
            this.f821b.addPath(pathH, this.f820a);
        }
        return this.f821b;
    }

    @Override // S.c
    public String i() {
        return this.e;
    }
}
