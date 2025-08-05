package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.request.target.Target;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    protected final RecyclerView.o f4276a;

    /* renamed from: b, reason: collision with root package name */
    private int f4277b;

    /* renamed from: c, reason: collision with root package name */
    final Rect f4278c;

    static class a extends k {
        a(RecyclerView.o oVar) {
            super(oVar, null);
        }

        @Override // androidx.recyclerview.widget.k
        public int d(View view) {
            return this.f4276a.T(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).rightMargin;
        }

        @Override // androidx.recyclerview.widget.k
        public int e(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f4276a.S(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.k
        public int f(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f4276a.R(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.k
        public int g(View view) {
            return this.f4276a.Q(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).leftMargin;
        }

        @Override // androidx.recyclerview.widget.k
        public int h() {
            return this.f4276a.n0();
        }

        @Override // androidx.recyclerview.widget.k
        public int i() {
            return this.f4276a.n0() - this.f4276a.e0();
        }

        @Override // androidx.recyclerview.widget.k
        public int j() {
            return this.f4276a.e0();
        }

        @Override // androidx.recyclerview.widget.k
        public int k() {
            return this.f4276a.o0();
        }

        @Override // androidx.recyclerview.widget.k
        public int l() {
            return this.f4276a.X();
        }

        @Override // androidx.recyclerview.widget.k
        public int m() {
            return this.f4276a.d0();
        }

        @Override // androidx.recyclerview.widget.k
        public int n() {
            return (this.f4276a.n0() - this.f4276a.d0()) - this.f4276a.e0();
        }

        @Override // androidx.recyclerview.widget.k
        public int p(View view) {
            this.f4276a.m0(view, true, this.f4278c);
            return this.f4278c.right;
        }

        @Override // androidx.recyclerview.widget.k
        public int q(View view) {
            this.f4276a.m0(view, true, this.f4278c);
            return this.f4278c.left;
        }

        @Override // androidx.recyclerview.widget.k
        public void r(int i2) {
            this.f4276a.B0(i2);
        }
    }

    static class b extends k {
        b(RecyclerView.o oVar) {
            super(oVar, null);
        }

        @Override // androidx.recyclerview.widget.k
        public int d(View view) {
            return this.f4276a.O(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.k
        public int e(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f4276a.R(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.k
        public int f(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f4276a.S(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.k
        public int g(View view) {
            return this.f4276a.U(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).topMargin;
        }

        @Override // androidx.recyclerview.widget.k
        public int h() {
            return this.f4276a.W();
        }

        @Override // androidx.recyclerview.widget.k
        public int i() {
            return this.f4276a.W() - this.f4276a.c0();
        }

        @Override // androidx.recyclerview.widget.k
        public int j() {
            return this.f4276a.c0();
        }

        @Override // androidx.recyclerview.widget.k
        public int k() {
            return this.f4276a.X();
        }

        @Override // androidx.recyclerview.widget.k
        public int l() {
            return this.f4276a.o0();
        }

        @Override // androidx.recyclerview.widget.k
        public int m() {
            return this.f4276a.f0();
        }

        @Override // androidx.recyclerview.widget.k
        public int n() {
            return (this.f4276a.W() - this.f4276a.f0()) - this.f4276a.c0();
        }

        @Override // androidx.recyclerview.widget.k
        public int p(View view) {
            this.f4276a.m0(view, true, this.f4278c);
            return this.f4278c.bottom;
        }

        @Override // androidx.recyclerview.widget.k
        public int q(View view) {
            this.f4276a.m0(view, true, this.f4278c);
            return this.f4278c.top;
        }

        @Override // androidx.recyclerview.widget.k
        public void r(int i2) {
            this.f4276a.C0(i2);
        }
    }

    /* synthetic */ k(RecyclerView.o oVar, a aVar) {
        this(oVar);
    }

    public static k a(RecyclerView.o oVar) {
        return new a(oVar);
    }

    public static k b(RecyclerView.o oVar, int i2) {
        if (i2 == 0) {
            return a(oVar);
        }
        if (i2 == 1) {
            return c(oVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static k c(RecyclerView.o oVar) {
        return new b(oVar);
    }

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public int o() {
        if (Integer.MIN_VALUE == this.f4277b) {
            return 0;
        }
        return n() - this.f4277b;
    }

    public abstract int p(View view);

    public abstract int q(View view);

    public abstract void r(int i2);

    public void s() {
        this.f4277b = n();
    }

    private k(RecyclerView.o oVar) {
        this.f4277b = Target.SIZE_ORIGINAL;
        this.f4278c = new Rect();
        this.f4276a = oVar;
    }
}
