package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class b {

    /* renamed from: a, reason: collision with root package name */
    final InterfaceC0051b f4119a;

    /* renamed from: b, reason: collision with root package name */
    final a f4120b = new a();

    /* renamed from: c, reason: collision with root package name */
    final List f4121c = new ArrayList();

    static class a {

        /* renamed from: a, reason: collision with root package name */
        long f4122a = 0;

        /* renamed from: b, reason: collision with root package name */
        a f4123b;

        a() {
        }

        private void c() {
            if (this.f4123b == null) {
                this.f4123b = new a();
            }
        }

        void a(int i2) {
            if (i2 < 64) {
                this.f4122a &= ~(1 << i2);
                return;
            }
            a aVar = this.f4123b;
            if (aVar != null) {
                aVar.a(i2 - 64);
            }
        }

        int b(int i2) {
            a aVar = this.f4123b;
            return aVar == null ? i2 >= 64 ? Long.bitCount(this.f4122a) : Long.bitCount(this.f4122a & ((1 << i2) - 1)) : i2 < 64 ? Long.bitCount(this.f4122a & ((1 << i2) - 1)) : aVar.b(i2 - 64) + Long.bitCount(this.f4122a);
        }

        boolean d(int i2) {
            if (i2 < 64) {
                return (this.f4122a & (1 << i2)) != 0;
            }
            c();
            return this.f4123b.d(i2 - 64);
        }

        void e(int i2, boolean z2) {
            if (i2 >= 64) {
                c();
                this.f4123b.e(i2 - 64, z2);
                return;
            }
            long j2 = this.f4122a;
            boolean z3 = (Long.MIN_VALUE & j2) != 0;
            long j3 = (1 << i2) - 1;
            this.f4122a = ((j2 & (~j3)) << 1) | (j2 & j3);
            if (z2) {
                h(i2);
            } else {
                a(i2);
            }
            if (z3 || this.f4123b != null) {
                c();
                this.f4123b.e(0, z3);
            }
        }

        boolean f(int i2) {
            if (i2 >= 64) {
                c();
                return this.f4123b.f(i2 - 64);
            }
            long j2 = 1 << i2;
            long j3 = this.f4122a;
            boolean z2 = (j3 & j2) != 0;
            long j4 = j3 & (~j2);
            this.f4122a = j4;
            long j5 = j2 - 1;
            this.f4122a = (j4 & j5) | Long.rotateRight((~j5) & j4, 1);
            a aVar = this.f4123b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.f4123b.f(0);
            }
            return z2;
        }

        void g() {
            this.f4122a = 0L;
            a aVar = this.f4123b;
            if (aVar != null) {
                aVar.g();
            }
        }

        void h(int i2) {
            if (i2 < 64) {
                this.f4122a |= 1 << i2;
            } else {
                c();
                this.f4123b.h(i2 - 64);
            }
        }

        public String toString() {
            if (this.f4123b == null) {
                return Long.toBinaryString(this.f4122a);
            }
            return this.f4123b.toString() + "xx" + Long.toBinaryString(this.f4122a);
        }
    }

    /* renamed from: androidx.recyclerview.widget.b$b, reason: collision with other inner class name */
    interface InterfaceC0051b {
        View a(int i2);

        void b(View view);

        void c(int i2);

        void d();

        RecyclerView.C e(View view);

        void f(int i2);

        void g(View view);

        void h(View view, int i2, ViewGroup.LayoutParams layoutParams);

        void i(View view, int i2);

        int j(View view);

        int k();
    }

    b(InterfaceC0051b interfaceC0051b) {
        this.f4119a = interfaceC0051b;
    }

    private int h(int i2) {
        if (i2 < 0) {
            return -1;
        }
        int iK = this.f4119a.k();
        int i3 = i2;
        while (i3 < iK) {
            int iB = i2 - (i3 - this.f4120b.b(i3));
            if (iB == 0) {
                while (this.f4120b.d(i3)) {
                    i3++;
                }
                return i3;
            }
            i3 += iB;
        }
        return -1;
    }

    private void l(View view) {
        this.f4121c.add(view);
        this.f4119a.b(view);
    }

    private boolean t(View view) {
        if (!this.f4121c.remove(view)) {
            return false;
        }
        this.f4119a.g(view);
        return true;
    }

    void a(View view, int i2, boolean z2) {
        int iK = i2 < 0 ? this.f4119a.k() : h(i2);
        this.f4120b.e(iK, z2);
        if (z2) {
            l(view);
        }
        this.f4119a.i(view, iK);
    }

    void b(View view, boolean z2) {
        a(view, -1, z2);
    }

    void c(View view, int i2, ViewGroup.LayoutParams layoutParams, boolean z2) {
        int iK = i2 < 0 ? this.f4119a.k() : h(i2);
        this.f4120b.e(iK, z2);
        if (z2) {
            l(view);
        }
        this.f4119a.h(view, iK, layoutParams);
    }

    void d(int i2) {
        int iH = h(i2);
        this.f4120b.f(iH);
        this.f4119a.f(iH);
    }

    View e(int i2) {
        int size = this.f4121c.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = (View) this.f4121c.get(i3);
            RecyclerView.C cE = this.f4119a.e(view);
            if (cE.m() == i2 && !cE.s() && !cE.u()) {
                return view;
            }
        }
        return null;
    }

    View f(int i2) {
        return this.f4119a.a(h(i2));
    }

    int g() {
        return this.f4119a.k() - this.f4121c.size();
    }

    View i(int i2) {
        return this.f4119a.a(i2);
    }

    int j() {
        return this.f4119a.k();
    }

    void k(View view) {
        int iJ = this.f4119a.j(view);
        if (iJ >= 0) {
            this.f4120b.h(iJ);
            l(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    int m(View view) {
        int iJ = this.f4119a.j(view);
        if (iJ == -1 || this.f4120b.d(iJ)) {
            return -1;
        }
        return iJ - this.f4120b.b(iJ);
    }

    boolean n(View view) {
        return this.f4121c.contains(view);
    }

    void o() {
        this.f4120b.g();
        for (int size = this.f4121c.size() - 1; size >= 0; size--) {
            this.f4119a.g((View) this.f4121c.get(size));
            this.f4121c.remove(size);
        }
        this.f4119a.d();
    }

    void p(View view) {
        int iJ = this.f4119a.j(view);
        if (iJ < 0) {
            return;
        }
        if (this.f4120b.f(iJ)) {
            t(view);
        }
        this.f4119a.c(iJ);
    }

    void q(int i2) {
        int iH = h(i2);
        View viewA = this.f4119a.a(iH);
        if (viewA == null) {
            return;
        }
        if (this.f4120b.f(iH)) {
            t(viewA);
        }
        this.f4119a.c(iH);
    }

    boolean r(View view) {
        int iJ = this.f4119a.j(view);
        if (iJ == -1) {
            t(view);
            return true;
        }
        if (!this.f4120b.d(iJ)) {
            return false;
        }
        this.f4120b.f(iJ);
        t(view);
        this.f4119a.c(iJ);
        return true;
    }

    void s(View view) {
        int iJ = this.f4119a.j(view);
        if (iJ < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (this.f4120b.d(iJ)) {
            this.f4120b.a(iJ);
            t(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public String toString() {
        return this.f4120b.toString() + ", hidden list:" + this.f4121c.size();
    }
}
