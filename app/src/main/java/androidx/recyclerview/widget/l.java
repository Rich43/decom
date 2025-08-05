package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.C0158a;
import w.C0353E;

/* loaded from: classes.dex */
public class l extends C0158a {

    /* renamed from: d, reason: collision with root package name */
    final RecyclerView f4279d;
    final C0158a e = new a(this);

    public static class a extends C0158a {

        /* renamed from: d, reason: collision with root package name */
        final l f4280d;

        public a(l lVar) {
            this.f4280d = lVar;
        }

        @Override // androidx.core.view.C0158a
        public void g(View view, C0353E c0353e) {
            super.g(view, c0353e);
            if (this.f4280d.o() || this.f4280d.f4279d.getLayoutManager() == null) {
                return;
            }
            this.f4280d.f4279d.getLayoutManager().N0(view, c0353e);
        }

        @Override // androidx.core.view.C0158a
        public boolean j(View view, int i2, Bundle bundle) {
            if (super.j(view, i2, bundle)) {
                return true;
            }
            if (this.f4280d.o() || this.f4280d.f4279d.getLayoutManager() == null) {
                return false;
            }
            return this.f4280d.f4279d.getLayoutManager().g1(view, i2, bundle);
        }
    }

    public l(RecyclerView recyclerView) {
        this.f4279d = recyclerView;
    }

    @Override // androidx.core.view.C0158a
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if (!(view instanceof RecyclerView) || o()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().J0(accessibilityEvent);
        }
    }

    @Override // androidx.core.view.C0158a
    public void g(View view, C0353E c0353e) {
        super.g(view, c0353e);
        c0353e.Y(RecyclerView.class.getName());
        if (o() || this.f4279d.getLayoutManager() == null) {
            return;
        }
        this.f4279d.getLayoutManager().M0(c0353e);
    }

    @Override // androidx.core.view.C0158a
    public boolean j(View view, int i2, Bundle bundle) {
        if (super.j(view, i2, bundle)) {
            return true;
        }
        if (o() || this.f4279d.getLayoutManager() == null) {
            return false;
        }
        return this.f4279d.getLayoutManager().e1(i2, bundle);
    }

    public C0158a n() {
        return this.e;
    }

    boolean o() {
        return this.f4279d.n0();
    }
}
