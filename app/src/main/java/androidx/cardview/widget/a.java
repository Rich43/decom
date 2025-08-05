package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* loaded from: classes.dex */
class a implements c {
    a() {
    }

    private d o(b bVar) {
        return (d) bVar.d();
    }

    @Override // androidx.cardview.widget.c
    public float a(b bVar) {
        return o(bVar).c();
    }

    @Override // androidx.cardview.widget.c
    public float b(b bVar) {
        return o(bVar).d();
    }

    @Override // androidx.cardview.widget.c
    public float c(b bVar) {
        return b(bVar) * 2.0f;
    }

    @Override // androidx.cardview.widget.c
    public float d(b bVar) {
        return b(bVar) * 2.0f;
    }

    @Override // androidx.cardview.widget.c
    public void e(b bVar) {
        m(bVar, a(bVar));
    }

    @Override // androidx.cardview.widget.c
    public ColorStateList f(b bVar) {
        return o(bVar).b();
    }

    @Override // androidx.cardview.widget.c
    public void g(b bVar, float f2) {
        bVar.a().setElevation(f2);
    }

    @Override // androidx.cardview.widget.c
    public void h(b bVar, Context context, ColorStateList colorStateList, float f2, float f3, float f4) {
        bVar.e(new d(colorStateList, f2));
        View viewA = bVar.a();
        viewA.setClipToOutline(true);
        viewA.setElevation(f3);
        m(bVar, f4);
    }

    @Override // androidx.cardview.widget.c
    public void i(b bVar, float f2) {
        o(bVar).h(f2);
    }

    @Override // androidx.cardview.widget.c
    public void j(b bVar) {
        m(bVar, a(bVar));
    }

    @Override // androidx.cardview.widget.c
    public void k(b bVar, ColorStateList colorStateList) {
        o(bVar).f(colorStateList);
    }

    @Override // androidx.cardview.widget.c
    public float l(b bVar) {
        return bVar.a().getElevation();
    }

    @Override // androidx.cardview.widget.c
    public void m(b bVar, float f2) {
        o(bVar).g(f2, bVar.b(), bVar.f());
        p(bVar);
    }

    @Override // androidx.cardview.widget.c
    public void n() {
    }

    public void p(b bVar) {
        if (!bVar.b()) {
            bVar.c(0, 0, 0, 0);
            return;
        }
        float fA = a(bVar);
        float fB = b(bVar);
        int iCeil = (int) Math.ceil(e.a(fA, fB, bVar.f()));
        int iCeil2 = (int) Math.ceil(e.b(fA, fB, bVar.f()));
        bVar.c(iCeil, iCeil2, iCeil, iCeil2);
    }
}
