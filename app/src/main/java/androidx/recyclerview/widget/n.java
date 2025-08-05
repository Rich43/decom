package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class n extends RecyclerView.l {

    /* renamed from: g, reason: collision with root package name */
    boolean f4281g = true;

    public abstract boolean A(RecyclerView.C c2);

    public final void B(RecyclerView.C c2) {
        J(c2);
        h(c2);
    }

    public final void C(RecyclerView.C c2) {
        K(c2);
    }

    public final void D(RecyclerView.C c2, boolean z2) {
        L(c2, z2);
        h(c2);
    }

    public final void E(RecyclerView.C c2, boolean z2) {
        M(c2, z2);
    }

    public final void F(RecyclerView.C c2) {
        N(c2);
        h(c2);
    }

    public final void G(RecyclerView.C c2) {
        O(c2);
    }

    public final void H(RecyclerView.C c2) {
        P(c2);
        h(c2);
    }

    public final void I(RecyclerView.C c2) {
        Q(c2);
    }

    public void J(RecyclerView.C c2) {
    }

    public void K(RecyclerView.C c2) {
    }

    public void L(RecyclerView.C c2, boolean z2) {
    }

    public void M(RecyclerView.C c2, boolean z2) {
    }

    public void N(RecyclerView.C c2) {
    }

    public void O(RecyclerView.C c2) {
    }

    public void P(RecyclerView.C c2) {
    }

    public void Q(RecyclerView.C c2) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean a(RecyclerView.C c2, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i2;
        int i3;
        return (cVar == null || ((i2 = cVar.f3998a) == (i3 = cVar2.f3998a) && cVar.f3999b == cVar2.f3999b)) ? x(c2) : z(c2, i2, cVar.f3999b, i3, cVar2.f3999b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean b(RecyclerView.C c2, RecyclerView.C c3, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i2;
        int i3;
        int i4 = cVar.f3998a;
        int i5 = cVar.f3999b;
        if (c3.I()) {
            int i6 = cVar.f3998a;
            i3 = cVar.f3999b;
            i2 = i6;
        } else {
            i2 = cVar2.f3998a;
            i3 = cVar2.f3999b;
        }
        return y(c2, c3, i4, i5, i2, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean c(RecyclerView.C c2, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i2 = cVar.f3998a;
        int i3 = cVar.f3999b;
        View view = c2.f3971a;
        int left = cVar2 == null ? view.getLeft() : cVar2.f3998a;
        int top = cVar2 == null ? view.getTop() : cVar2.f3999b;
        if (c2.u() || (i2 == left && i3 == top)) {
            return A(c2);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return z(c2, i2, i3, left, top);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean d(RecyclerView.C c2, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i2 = cVar.f3998a;
        int i3 = cVar2.f3998a;
        if (i2 != i3 || cVar.f3999b != cVar2.f3999b) {
            return z(c2, i2, cVar.f3999b, i3, cVar2.f3999b);
        }
        F(c2);
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean f(RecyclerView.C c2) {
        return !this.f4281g || c2.s();
    }

    public abstract boolean x(RecyclerView.C c2);

    public abstract boolean y(RecyclerView.C c2, RecyclerView.C c3, int i2, int i3, int i4, int i5);

    public abstract boolean z(RecyclerView.C c2, int i2, int i3, int i4, int i5);
}
