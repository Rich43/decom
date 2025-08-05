package androidx.recyclerview.widget;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f;
import com.bumptech.glide.request.target.Target;
import java.util.List;

/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.o implements f.h {

    /* renamed from: A */
    int f3852A;

    /* renamed from: B */
    private boolean f3853B;

    /* renamed from: C */
    d f3854C;

    /* renamed from: D */
    final a f3855D;

    /* renamed from: E */
    private final b f3856E;

    /* renamed from: F */
    private int f3857F;
    int r;
    private c s;

    /* renamed from: t */
    k f3858t;

    /* renamed from: u */
    private boolean f3859u;

    /* renamed from: v */
    private boolean f3860v;

    /* renamed from: w */
    boolean f3861w;

    /* renamed from: x */
    private boolean f3862x;

    /* renamed from: y */
    private boolean f3863y;

    /* renamed from: z */
    int f3864z;

    static class a {

        /* renamed from: a */
        k f3865a;

        /* renamed from: b */
        int f3866b;

        /* renamed from: c */
        int f3867c;

        /* renamed from: d */
        boolean f3868d;
        boolean e;

        a() {
            e();
        }

        void a() {
            this.f3867c = this.f3868d ? this.f3865a.i() : this.f3865a.m();
        }

        public void b(View view, int i2) {
            if (this.f3868d) {
                this.f3867c = this.f3865a.d(view) + this.f3865a.o();
            } else {
                this.f3867c = this.f3865a.g(view);
            }
            this.f3866b = i2;
        }

        public void c(View view, int i2) {
            int iO = this.f3865a.o();
            if (iO >= 0) {
                b(view, i2);
                return;
            }
            this.f3866b = i2;
            if (this.f3868d) {
                int i3 = (this.f3865a.i() - iO) - this.f3865a.d(view);
                this.f3867c = this.f3865a.i() - i3;
                if (i3 > 0) {
                    int iE = this.f3867c - this.f3865a.e(view);
                    int iM = this.f3865a.m();
                    int iMin = iE - (iM + Math.min(this.f3865a.g(view) - iM, 0));
                    if (iMin < 0) {
                        this.f3867c += Math.min(i3, -iMin);
                        return;
                    }
                    return;
                }
                return;
            }
            int iG = this.f3865a.g(view);
            int iM2 = iG - this.f3865a.m();
            this.f3867c = iG;
            if (iM2 > 0) {
                int i4 = (this.f3865a.i() - Math.min(0, (this.f3865a.i() - iO) - this.f3865a.d(view))) - (iG + this.f3865a.e(view));
                if (i4 < 0) {
                    this.f3867c -= Math.min(iM2, -i4);
                }
            }
        }

        boolean d(View view, RecyclerView.z zVar) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return !pVar.c() && pVar.a() >= 0 && pVar.a() < zVar.b();
        }

        void e() {
            this.f3866b = -1;
            this.f3867c = Target.SIZE_ORIGINAL;
            this.f3868d = false;
            this.e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f3866b + ", mCoordinate=" + this.f3867c + ", mLayoutFromEnd=" + this.f3868d + ", mValid=" + this.e + '}';
        }
    }

    protected static class b {

        /* renamed from: a */
        public int f3869a;

        /* renamed from: b */
        public boolean f3870b;

        /* renamed from: c */
        public boolean f3871c;

        /* renamed from: d */
        public boolean f3872d;

        protected b() {
        }

        void a() {
            this.f3869a = 0;
            this.f3870b = false;
            this.f3871c = false;
            this.f3872d = false;
        }
    }

    static class c {

        /* renamed from: b */
        int f3874b;

        /* renamed from: c */
        int f3875c;

        /* renamed from: d */
        int f3876d;
        int e;

        /* renamed from: f */
        int f3877f;

        /* renamed from: g */
        int f3878g;

        /* renamed from: j */
        int f3881j;

        /* renamed from: l */
        boolean f3883l;

        /* renamed from: a */
        boolean f3873a = true;

        /* renamed from: h */
        int f3879h = 0;

        /* renamed from: i */
        boolean f3880i = false;

        /* renamed from: k */
        List f3882k = null;

        c() {
        }

        private View e() {
            int size = this.f3882k.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = ((RecyclerView.C) this.f3882k.get(i2)).f3971a;
                RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
                if (!pVar.c() && this.f3876d == pVar.a()) {
                    b(view);
                    return view;
                }
            }
            return null;
        }

        public void a() {
            b(null);
        }

        public void b(View view) {
            View viewF = f(view);
            if (viewF == null) {
                this.f3876d = -1;
            } else {
                this.f3876d = ((RecyclerView.p) viewF.getLayoutParams()).a();
            }
        }

        boolean c(RecyclerView.z zVar) {
            int i2 = this.f3876d;
            return i2 >= 0 && i2 < zVar.b();
        }

        View d(RecyclerView.v vVar) {
            if (this.f3882k != null) {
                return e();
            }
            View viewO = vVar.o(this.f3876d);
            this.f3876d += this.e;
            return viewO;
        }

        public View f(View view) {
            int iA;
            int size = this.f3882k.size();
            View view2 = null;
            int i2 = Integer.MAX_VALUE;
            for (int i3 = 0; i3 < size; i3++) {
                View view3 = ((RecyclerView.C) this.f3882k.get(i3)).f3971a;
                RecyclerView.p pVar = (RecyclerView.p) view3.getLayoutParams();
                if (view3 != view && !pVar.c() && (iA = (pVar.a() - this.f3876d) * this.e) >= 0 && iA < i2) {
                    view2 = view3;
                    if (iA == 0) {
                        break;
                    }
                    i2 = iA;
                }
            }
            return view2;
        }
    }

    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: a */
        int f3884a;

        /* renamed from: b */
        int f3885b;

        /* renamed from: c */
        boolean f3886c;

        static class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public d[] newArray(int i2) {
                return new d[i2];
            }
        }

        public d() {
        }

        boolean a() {
            return this.f3884a >= 0;
        }

        void b() {
            this.f3884a = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f3884a);
            parcel.writeInt(this.f3885b);
            parcel.writeInt(this.f3886c ? 1 : 0);
        }

        d(Parcel parcel) {
            this.f3884a = parcel.readInt();
            this.f3885b = parcel.readInt();
            this.f3886c = parcel.readInt() == 1;
        }

        public d(d dVar) {
            this.f3884a = dVar.f3884a;
            this.f3885b = dVar.f3885b;
            this.f3886c = dVar.f3886c;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    private boolean A2(RecyclerView.v vVar, RecyclerView.z zVar, a aVar) {
        if (J() == 0) {
            return false;
        }
        View viewV = V();
        if (viewV != null && aVar.d(viewV, zVar)) {
            aVar.c(viewV, g0(viewV));
            return true;
        }
        if (this.f3859u != this.f3862x) {
            return false;
        }
        View viewD2 = aVar.f3868d ? d2(vVar, zVar) : e2(vVar, zVar);
        if (viewD2 == null) {
            return false;
        }
        aVar.b(viewD2, g0(viewD2));
        if (!zVar.e() && H1() && (this.f3858t.g(viewD2) >= this.f3858t.i() || this.f3858t.d(viewD2) < this.f3858t.m())) {
            aVar.f3867c = aVar.f3868d ? this.f3858t.i() : this.f3858t.m();
        }
        return true;
    }

    private boolean B2(RecyclerView.z zVar, a aVar) {
        int i2;
        if (!zVar.e() && (i2 = this.f3864z) != -1) {
            if (i2 >= 0 && i2 < zVar.b()) {
                aVar.f3866b = this.f3864z;
                d dVar = this.f3854C;
                if (dVar != null && dVar.a()) {
                    boolean z2 = this.f3854C.f3886c;
                    aVar.f3868d = z2;
                    if (z2) {
                        aVar.f3867c = this.f3858t.i() - this.f3854C.f3885b;
                    } else {
                        aVar.f3867c = this.f3858t.m() + this.f3854C.f3885b;
                    }
                    return true;
                }
                if (this.f3852A != Integer.MIN_VALUE) {
                    boolean z3 = this.f3861w;
                    aVar.f3868d = z3;
                    if (z3) {
                        aVar.f3867c = this.f3858t.i() - this.f3852A;
                    } else {
                        aVar.f3867c = this.f3858t.m() + this.f3852A;
                    }
                    return true;
                }
                View viewC = C(this.f3864z);
                if (viewC == null) {
                    if (J() > 0) {
                        aVar.f3868d = (this.f3864z < g0(I(0))) == this.f3861w;
                    }
                    aVar.a();
                } else {
                    if (this.f3858t.e(viewC) > this.f3858t.n()) {
                        aVar.a();
                        return true;
                    }
                    if (this.f3858t.g(viewC) - this.f3858t.m() < 0) {
                        aVar.f3867c = this.f3858t.m();
                        aVar.f3868d = false;
                        return true;
                    }
                    if (this.f3858t.i() - this.f3858t.d(viewC) < 0) {
                        aVar.f3867c = this.f3858t.i();
                        aVar.f3868d = true;
                        return true;
                    }
                    aVar.f3867c = aVar.f3868d ? this.f3858t.d(viewC) + this.f3858t.o() : this.f3858t.g(viewC);
                }
                return true;
            }
            this.f3864z = -1;
            this.f3852A = Target.SIZE_ORIGINAL;
        }
        return false;
    }

    private void C2(RecyclerView.v vVar, RecyclerView.z zVar, a aVar) {
        if (B2(zVar, aVar) || A2(vVar, zVar, aVar)) {
            return;
        }
        aVar.a();
        aVar.f3866b = this.f3862x ? zVar.b() - 1 : 0;
    }

    private void D2(int i2, int i3, boolean z2, RecyclerView.z zVar) {
        int iM;
        this.s.f3883l = t2();
        this.s.f3879h = j2(zVar);
        c cVar = this.s;
        cVar.f3877f = i2;
        if (i2 == 1) {
            cVar.f3879h += this.f3858t.j();
            View viewH2 = h2();
            c cVar2 = this.s;
            cVar2.e = this.f3861w ? -1 : 1;
            int iG0 = g0(viewH2);
            c cVar3 = this.s;
            cVar2.f3876d = iG0 + cVar3.e;
            cVar3.f3874b = this.f3858t.d(viewH2);
            iM = this.f3858t.d(viewH2) - this.f3858t.i();
        } else {
            View viewI2 = i2();
            this.s.f3879h += this.f3858t.m();
            c cVar4 = this.s;
            cVar4.e = this.f3861w ? 1 : -1;
            int iG02 = g0(viewI2);
            c cVar5 = this.s;
            cVar4.f3876d = iG02 + cVar5.e;
            cVar5.f3874b = this.f3858t.g(viewI2);
            iM = (-this.f3858t.g(viewI2)) + this.f3858t.m();
        }
        c cVar6 = this.s;
        cVar6.f3875c = i3;
        if (z2) {
            cVar6.f3875c = i3 - iM;
        }
        cVar6.f3878g = iM;
    }

    private void E2(int i2, int i3) {
        this.s.f3875c = this.f3858t.i() - i3;
        c cVar = this.s;
        cVar.e = this.f3861w ? -1 : 1;
        cVar.f3876d = i2;
        cVar.f3877f = 1;
        cVar.f3874b = i3;
        cVar.f3878g = Target.SIZE_ORIGINAL;
    }

    private void F2(a aVar) {
        E2(aVar.f3866b, aVar.f3867c);
    }

    private void G2(int i2, int i3) {
        this.s.f3875c = i3 - this.f3858t.m();
        c cVar = this.s;
        cVar.f3876d = i2;
        cVar.e = this.f3861w ? 1 : -1;
        cVar.f3877f = -1;
        cVar.f3874b = i3;
        cVar.f3878g = Target.SIZE_ORIGINAL;
    }

    private void H2(a aVar) {
        G2(aVar.f3866b, aVar.f3867c);
    }

    private int J1(RecyclerView.z zVar) {
        if (J() == 0) {
            return 0;
        }
        O1();
        return m.a(zVar, this.f3858t, T1(!this.f3863y, true), S1(!this.f3863y, true), this, this.f3863y);
    }

    private int K1(RecyclerView.z zVar) {
        if (J() == 0) {
            return 0;
        }
        O1();
        return m.b(zVar, this.f3858t, T1(!this.f3863y, true), S1(!this.f3863y, true), this, this.f3863y, this.f3861w);
    }

    private int L1(RecyclerView.z zVar) {
        if (J() == 0) {
            return 0;
        }
        O1();
        return m.c(zVar, this.f3858t, T1(!this.f3863y, true), S1(!this.f3863y, true), this, this.f3863y);
    }

    private View Q1(RecyclerView.v vVar, RecyclerView.z zVar) {
        return Y1(0, J());
    }

    private View R1(RecyclerView.v vVar, RecyclerView.z zVar) {
        return c2(vVar, zVar, 0, J(), zVar.b());
    }

    private View S1(boolean z2, boolean z3) {
        return this.f3861w ? Z1(0, J(), z2, z3) : Z1(J() - 1, -1, z2, z3);
    }

    private View T1(boolean z2, boolean z3) {
        return this.f3861w ? Z1(J() - 1, -1, z2, z3) : Z1(0, J(), z2, z3);
    }

    private View V1(RecyclerView.v vVar, RecyclerView.z zVar) {
        return Y1(J() - 1, -1);
    }

    private View W1(RecyclerView.v vVar, RecyclerView.z zVar) {
        return c2(vVar, zVar, J() - 1, -1, zVar.b());
    }

    private View a2(RecyclerView.v vVar, RecyclerView.z zVar) {
        return this.f3861w ? Q1(vVar, zVar) : V1(vVar, zVar);
    }

    private View b2(RecyclerView.v vVar, RecyclerView.z zVar) {
        return this.f3861w ? V1(vVar, zVar) : Q1(vVar, zVar);
    }

    private View d2(RecyclerView.v vVar, RecyclerView.z zVar) {
        return this.f3861w ? R1(vVar, zVar) : W1(vVar, zVar);
    }

    private View e2(RecyclerView.v vVar, RecyclerView.z zVar) {
        return this.f3861w ? W1(vVar, zVar) : R1(vVar, zVar);
    }

    private int f2(int i2, RecyclerView.v vVar, RecyclerView.z zVar, boolean z2) {
        int i3;
        int i4 = this.f3858t.i() - i2;
        if (i4 <= 0) {
            return 0;
        }
        int i5 = -v2(-i4, vVar, zVar);
        int i6 = i2 + i5;
        if (!z2 || (i3 = this.f3858t.i() - i6) <= 0) {
            return i5;
        }
        this.f3858t.r(i3);
        return i3 + i5;
    }

    private int g2(int i2, RecyclerView.v vVar, RecyclerView.z zVar, boolean z2) {
        int iM;
        int iM2 = i2 - this.f3858t.m();
        if (iM2 <= 0) {
            return 0;
        }
        int i3 = -v2(iM2, vVar, zVar);
        int i4 = i2 + i3;
        if (!z2 || (iM = i4 - this.f3858t.m()) <= 0) {
            return i3;
        }
        this.f3858t.r(-iM);
        return i3 - iM;
    }

    private View h2() {
        return I(this.f3861w ? 0 : J() - 1);
    }

    private View i2() {
        return I(this.f3861w ? J() - 1 : 0);
    }

    private void n2(RecyclerView.v vVar, RecyclerView.z zVar, int i2, int i3) {
        if (!zVar.g() || J() == 0 || zVar.e() || !H1()) {
            return;
        }
        List listK = vVar.k();
        int size = listK.size();
        int iG0 = g0(I(0));
        int iE = 0;
        int iE2 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView.C c2 = (RecyclerView.C) listK.get(i4);
            if (!c2.u()) {
                if ((c2.m() < iG0) != this.f3861w) {
                    iE += this.f3858t.e(c2.f3971a);
                } else {
                    iE2 += this.f3858t.e(c2.f3971a);
                }
            }
        }
        this.s.f3882k = listK;
        if (iE > 0) {
            G2(g0(i2()), i2);
            c cVar = this.s;
            cVar.f3879h = iE;
            cVar.f3875c = 0;
            cVar.a();
            P1(vVar, this.s, zVar, false);
        }
        if (iE2 > 0) {
            E2(g0(h2()), i3);
            c cVar2 = this.s;
            cVar2.f3879h = iE2;
            cVar2.f3875c = 0;
            cVar2.a();
            P1(vVar, this.s, zVar, false);
        }
        this.s.f3882k = null;
    }

    private void p2(RecyclerView.v vVar, c cVar) {
        if (!cVar.f3873a || cVar.f3883l) {
            return;
        }
        if (cVar.f3877f == -1) {
            r2(vVar, cVar.f3878g);
        } else {
            s2(vVar, cVar.f3878g);
        }
    }

    private void q2(RecyclerView.v vVar, int i2, int i3) {
        if (i2 == i3) {
            return;
        }
        if (i3 <= i2) {
            while (i2 > i3) {
                l1(i2, vVar);
                i2--;
            }
        } else {
            for (int i4 = i3 - 1; i4 >= i2; i4--) {
                l1(i4, vVar);
            }
        }
    }

    private void r2(RecyclerView.v vVar, int i2) {
        int iJ = J();
        if (i2 < 0) {
            return;
        }
        int iH = this.f3858t.h() - i2;
        if (this.f3861w) {
            for (int i3 = 0; i3 < iJ; i3++) {
                View viewI = I(i3);
                if (this.f3858t.g(viewI) < iH || this.f3858t.q(viewI) < iH) {
                    q2(vVar, 0, i3);
                    return;
                }
            }
            return;
        }
        int i4 = iJ - 1;
        for (int i5 = i4; i5 >= 0; i5--) {
            View viewI2 = I(i5);
            if (this.f3858t.g(viewI2) < iH || this.f3858t.q(viewI2) < iH) {
                q2(vVar, i4, i5);
                return;
            }
        }
    }

    private void s2(RecyclerView.v vVar, int i2) {
        if (i2 < 0) {
            return;
        }
        int iJ = J();
        if (!this.f3861w) {
            for (int i3 = 0; i3 < iJ; i3++) {
                View viewI = I(i3);
                if (this.f3858t.d(viewI) > i2 || this.f3858t.p(viewI) > i2) {
                    q2(vVar, 0, i3);
                    return;
                }
            }
            return;
        }
        int i4 = iJ - 1;
        for (int i5 = i4; i5 >= 0; i5--) {
            View viewI2 = I(i5);
            if (this.f3858t.d(viewI2) > i2 || this.f3858t.p(viewI2) > i2) {
                q2(vVar, i4, i5);
                return;
            }
        }
    }

    private void u2() {
        if (this.r == 1 || !l2()) {
            this.f3861w = this.f3860v;
        } else {
            this.f3861w = !this.f3860v;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View C(int i2) {
        int iJ = J();
        if (iJ == 0) {
            return null;
        }
        int iG0 = i2 - g0(I(0));
        if (iG0 >= 0 && iG0 < iJ) {
            View viewI = I(iG0);
            if (g0(viewI) == i2) {
                return viewI;
            }
        }
        return super.C(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p D() {
        return new RecyclerView.p(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    boolean E1() {
        return (X() == 1073741824 || o0() == 1073741824 || !p0()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void H0(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.H0(recyclerView, vVar);
        if (this.f3853B) {
            i1(vVar);
            vVar.c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean H1() {
        return this.f3854C == null && this.f3859u == this.f3862x;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View I0(View view, int i2, RecyclerView.v vVar, RecyclerView.z zVar) {
        int iM1;
        u2();
        if (J() == 0 || (iM1 = M1(i2)) == Integer.MIN_VALUE) {
            return null;
        }
        O1();
        O1();
        D2(iM1, (int) (this.f3858t.n() * 0.33333334f), false, zVar);
        c cVar = this.s;
        cVar.f3878g = Target.SIZE_ORIGINAL;
        cVar.f3873a = false;
        P1(vVar, cVar, zVar, true);
        View viewB2 = iM1 == -1 ? b2(vVar, zVar) : a2(vVar, zVar);
        View viewI2 = iM1 == -1 ? i2() : h2();
        if (!viewI2.hasFocusable()) {
            return viewB2;
        }
        if (viewB2 == null) {
            return null;
        }
        return viewI2;
    }

    void I1(RecyclerView.z zVar, c cVar, RecyclerView.o.c cVar2) {
        int i2 = cVar.f3876d;
        if (i2 < 0 || i2 >= zVar.b()) {
            return;
        }
        cVar2.a(i2, Math.max(0, cVar.f3878g));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void J0(AccessibilityEvent accessibilityEvent) {
        super.J0(accessibilityEvent);
        if (J() > 0) {
            accessibilityEvent.setFromIndex(U1());
            accessibilityEvent.setToIndex(X1());
        }
    }

    int M1(int i2) {
        if (i2 == 1) {
            return (this.r != 1 && l2()) ? 1 : -1;
        }
        if (i2 == 2) {
            return (this.r != 1 && l2()) ? -1 : 1;
        }
        if (i2 == 17) {
            if (this.r == 0) {
                return -1;
            }
            return Target.SIZE_ORIGINAL;
        }
        if (i2 == 33) {
            if (this.r == 1) {
                return -1;
            }
            return Target.SIZE_ORIGINAL;
        }
        if (i2 == 66) {
            if (this.r == 0) {
                return 1;
            }
            return Target.SIZE_ORIGINAL;
        }
        if (i2 == 130 && this.r == 1) {
            return 1;
        }
        return Target.SIZE_ORIGINAL;
    }

    c N1() {
        return new c();
    }

    void O1() {
        if (this.s == null) {
            this.s = N1();
        }
    }

    int P1(RecyclerView.v vVar, c cVar, RecyclerView.z zVar, boolean z2) {
        int i2 = cVar.f3875c;
        int i3 = cVar.f3878g;
        if (i3 != Integer.MIN_VALUE) {
            if (i2 < 0) {
                cVar.f3878g = i3 + i2;
            }
            p2(vVar, cVar);
        }
        int i4 = cVar.f3875c + cVar.f3879h;
        b bVar = this.f3856E;
        while (true) {
            if ((!cVar.f3883l && i4 <= 0) || !cVar.c(zVar)) {
                break;
            }
            bVar.a();
            m2(vVar, zVar, cVar, bVar);
            if (!bVar.f3870b) {
                cVar.f3874b += bVar.f3869a * cVar.f3877f;
                if (!bVar.f3871c || this.s.f3882k != null || !zVar.e()) {
                    int i5 = cVar.f3875c;
                    int i6 = bVar.f3869a;
                    cVar.f3875c = i5 - i6;
                    i4 -= i6;
                }
                int i7 = cVar.f3878g;
                if (i7 != Integer.MIN_VALUE) {
                    int i8 = i7 + bVar.f3869a;
                    cVar.f3878g = i8;
                    int i9 = cVar.f3875c;
                    if (i9 < 0) {
                        cVar.f3878g = i8 + i9;
                    }
                    p2(vVar, cVar);
                }
                if (z2 && bVar.f3872d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i2 - cVar.f3875c;
    }

    public int U1() {
        View viewZ1 = Z1(0, J(), false, true);
        if (viewZ1 == null) {
            return -1;
        }
        return g0(viewZ1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void W0(RecyclerView.v vVar, RecyclerView.z zVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int iF2;
        int i7;
        View viewC;
        int iG;
        int i8;
        int i9 = -1;
        if (!(this.f3854C == null && this.f3864z == -1) && zVar.b() == 0) {
            i1(vVar);
            return;
        }
        d dVar = this.f3854C;
        if (dVar != null && dVar.a()) {
            this.f3864z = this.f3854C.f3884a;
        }
        O1();
        this.s.f3873a = false;
        u2();
        View viewV = V();
        a aVar = this.f3855D;
        if (!aVar.e || this.f3864z != -1 || this.f3854C != null) {
            aVar.e();
            a aVar2 = this.f3855D;
            aVar2.f3868d = this.f3861w ^ this.f3862x;
            C2(vVar, zVar, aVar2);
            this.f3855D.e = true;
        } else if (viewV != null && (this.f3858t.g(viewV) >= this.f3858t.i() || this.f3858t.d(viewV) <= this.f3858t.m())) {
            this.f3855D.c(viewV, g0(viewV));
        }
        int iJ2 = j2(zVar);
        if (this.s.f3881j >= 0) {
            i2 = iJ2;
            iJ2 = 0;
        } else {
            i2 = 0;
        }
        int iM = iJ2 + this.f3858t.m();
        int iJ = i2 + this.f3858t.j();
        if (zVar.e() && (i7 = this.f3864z) != -1 && this.f3852A != Integer.MIN_VALUE && (viewC = C(i7)) != null) {
            if (this.f3861w) {
                i8 = this.f3858t.i() - this.f3858t.d(viewC);
                iG = this.f3852A;
            } else {
                iG = this.f3858t.g(viewC) - this.f3858t.m();
                i8 = this.f3852A;
            }
            int i10 = i8 - iG;
            if (i10 > 0) {
                iM += i10;
            } else {
                iJ -= i10;
            }
        }
        a aVar3 = this.f3855D;
        if (!aVar3.f3868d ? !this.f3861w : this.f3861w) {
            i9 = 1;
        }
        o2(vVar, zVar, aVar3, i9);
        w(vVar);
        this.s.f3883l = t2();
        this.s.f3880i = zVar.e();
        a aVar4 = this.f3855D;
        if (aVar4.f3868d) {
            H2(aVar4);
            c cVar = this.s;
            cVar.f3879h = iM;
            P1(vVar, cVar, zVar, false);
            c cVar2 = this.s;
            i4 = cVar2.f3874b;
            int i11 = cVar2.f3876d;
            int i12 = cVar2.f3875c;
            if (i12 > 0) {
                iJ += i12;
            }
            F2(this.f3855D);
            c cVar3 = this.s;
            cVar3.f3879h = iJ;
            cVar3.f3876d += cVar3.e;
            P1(vVar, cVar3, zVar, false);
            c cVar4 = this.s;
            i3 = cVar4.f3874b;
            int i13 = cVar4.f3875c;
            if (i13 > 0) {
                G2(i11, i4);
                c cVar5 = this.s;
                cVar5.f3879h = i13;
                P1(vVar, cVar5, zVar, false);
                i4 = this.s.f3874b;
            }
        } else {
            F2(aVar4);
            c cVar6 = this.s;
            cVar6.f3879h = iJ;
            P1(vVar, cVar6, zVar, false);
            c cVar7 = this.s;
            i3 = cVar7.f3874b;
            int i14 = cVar7.f3876d;
            int i15 = cVar7.f3875c;
            if (i15 > 0) {
                iM += i15;
            }
            H2(this.f3855D);
            c cVar8 = this.s;
            cVar8.f3879h = iM;
            cVar8.f3876d += cVar8.e;
            P1(vVar, cVar8, zVar, false);
            c cVar9 = this.s;
            i4 = cVar9.f3874b;
            int i16 = cVar9.f3875c;
            if (i16 > 0) {
                E2(i14, i3);
                c cVar10 = this.s;
                cVar10.f3879h = i16;
                P1(vVar, cVar10, zVar, false);
                i3 = this.s.f3874b;
            }
        }
        if (J() > 0) {
            if (this.f3861w ^ this.f3862x) {
                int iF22 = f2(i3, vVar, zVar, true);
                i5 = i4 + iF22;
                i6 = i3 + iF22;
                iF2 = g2(i5, vVar, zVar, false);
            } else {
                int iG2 = g2(i4, vVar, zVar, true);
                i5 = i4 + iG2;
                i6 = i3 + iG2;
                iF2 = f2(i6, vVar, zVar, false);
            }
            i4 = i5 + iF2;
            i3 = i6 + iF2;
        }
        n2(vVar, zVar, i4, i3);
        if (zVar.e()) {
            this.f3855D.e();
        } else {
            this.f3858t.s();
        }
        this.f3859u = this.f3862x;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView.z zVar) {
        super.X0(zVar);
        this.f3854C = null;
        this.f3864z = -1;
        this.f3852A = Target.SIZE_ORIGINAL;
        this.f3855D.e();
    }

    public int X1() {
        View viewZ1 = Z1(J() - 1, -1, false, true);
        if (viewZ1 == null) {
            return -1;
        }
        return g0(viewZ1);
    }

    View Y1(int i2, int i3) {
        int i4;
        int i5;
        O1();
        if (i3 <= i2 && i3 >= i2) {
            return I(i2);
        }
        if (this.f3858t.g(I(i2)) < this.f3858t.m()) {
            i4 = 16644;
            i5 = 16388;
        } else {
            i4 = 4161;
            i5 = 4097;
        }
        return this.r == 0 ? this.e.a(i2, i3, i4, i5) : this.f4007f.a(i2, i3, i4, i5);
    }

    View Z1(int i2, int i3, boolean z2, boolean z3) {
        O1();
        int i4 = z2 ? 24579 : 320;
        int i5 = z3 ? 320 : 0;
        return this.r == 0 ? this.e.a(i2, i3, i4, i5) : this.f4007f.a(i2, i3, i4, i5);
    }

    @Override // androidx.recyclerview.widget.f.h
    public void a(View view, View view2, int i2, int i3) {
        g("Cannot drop a view during a scroll or layout calculation");
        O1();
        u2();
        int iG0 = g0(view);
        int iG02 = g0(view2);
        char c2 = iG0 < iG02 ? (char) 1 : (char) 65535;
        if (this.f3861w) {
            if (c2 == 1) {
                w2(iG02, this.f3858t.i() - (this.f3858t.g(view2) + this.f3858t.e(view)));
                return;
            } else {
                w2(iG02, this.f3858t.i() - this.f3858t.d(view2));
                return;
            }
        }
        if (c2 == 65535) {
            w2(iG02, this.f3858t.g(view2));
        } else {
            w2(iG02, this.f3858t.d(view2) - this.f3858t.e(view));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void b1(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.f3854C = (d) parcelable;
            r1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable c1() {
        if (this.f3854C != null) {
            return new d(this.f3854C);
        }
        d dVar = new d();
        if (J() > 0) {
            O1();
            boolean z2 = this.f3859u ^ this.f3861w;
            dVar.f3886c = z2;
            if (z2) {
                View viewH2 = h2();
                dVar.f3885b = this.f3858t.i() - this.f3858t.d(viewH2);
                dVar.f3884a = g0(viewH2);
            } else {
                View viewI2 = i2();
                dVar.f3884a = g0(viewI2);
                dVar.f3885b = this.f3858t.g(viewI2) - this.f3858t.m();
            }
        } else {
            dVar.b();
        }
        return dVar;
    }

    View c2(RecyclerView.v vVar, RecyclerView.z zVar, int i2, int i3, int i4) {
        O1();
        int iM = this.f3858t.m();
        int i5 = this.f3858t.i();
        int i6 = i3 > i2 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i2 != i3) {
            View viewI = I(i2);
            int iG0 = g0(viewI);
            if (iG0 >= 0 && iG0 < i4) {
                if (((RecyclerView.p) viewI.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = viewI;
                    }
                } else {
                    if (this.f3858t.g(viewI) < i5 && this.f3858t.d(viewI) >= iM) {
                        return viewI;
                    }
                    if (view == null) {
                        view = viewI;
                    }
                }
            }
            i2 += i6;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void g(String str) {
        if (this.f3854C == null) {
            super.g(str);
        }
    }

    protected int j2(RecyclerView.z zVar) {
        if (zVar.d()) {
            return this.f3858t.n();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean k() {
        return this.r == 0;
    }

    public int k2() {
        return this.r;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean l() {
        return this.r == 1;
    }

    protected boolean l2() {
        return Y() == 1;
    }

    void m2(RecyclerView.v vVar, RecyclerView.z zVar, c cVar, b bVar) {
        int i2;
        int i3;
        int i4;
        int iD0;
        int iF;
        View viewD = cVar.d(vVar);
        if (viewD == null) {
            bVar.f3870b = true;
            return;
        }
        RecyclerView.p pVar = (RecyclerView.p) viewD.getLayoutParams();
        if (cVar.f3882k == null) {
            if (this.f3861w == (cVar.f3877f == -1)) {
                d(viewD);
            } else {
                e(viewD, 0);
            }
        } else {
            if (this.f3861w == (cVar.f3877f == -1)) {
                b(viewD);
            } else {
                c(viewD, 0);
            }
        }
        z0(viewD, 0, 0);
        bVar.f3869a = this.f3858t.e(viewD);
        if (this.r == 1) {
            if (l2()) {
                iF = n0() - e0();
                iD0 = iF - this.f3858t.f(viewD);
            } else {
                iD0 = d0();
                iF = this.f3858t.f(viewD) + iD0;
            }
            if (cVar.f3877f == -1) {
                int i5 = cVar.f3874b;
                i4 = i5;
                i3 = iF;
                i2 = i5 - bVar.f3869a;
            } else {
                int i6 = cVar.f3874b;
                i2 = i6;
                i3 = iF;
                i4 = bVar.f3869a + i6;
            }
        } else {
            int iF0 = f0();
            int iF2 = this.f3858t.f(viewD) + iF0;
            if (cVar.f3877f == -1) {
                int i7 = cVar.f3874b;
                i3 = i7;
                i2 = iF0;
                i4 = iF2;
                iD0 = i7 - bVar.f3869a;
            } else {
                int i8 = cVar.f3874b;
                i2 = iF0;
                i3 = bVar.f3869a + i8;
                i4 = iF2;
                iD0 = i8;
            }
        }
        y0(viewD, iD0, i2, i3, i4);
        if (pVar.c() || pVar.b()) {
            bVar.f3871c = true;
        }
        bVar.f3872d = viewD.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void o(int i2, int i3, RecyclerView.z zVar, RecyclerView.o.c cVar) {
        if (this.r != 0) {
            i2 = i3;
        }
        if (J() == 0 || i2 == 0) {
            return;
        }
        O1();
        D2(i2 > 0 ? 1 : -1, Math.abs(i2), true, zVar);
        I1(zVar, this.s, cVar);
    }

    void o2(RecyclerView.v vVar, RecyclerView.z zVar, a aVar, int i2) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void p(int i2, RecyclerView.o.c cVar) {
        boolean z2;
        int i3;
        d dVar = this.f3854C;
        if (dVar == null || !dVar.a()) {
            u2();
            z2 = this.f3861w;
            i3 = this.f3864z;
            if (i3 == -1) {
                i3 = z2 ? i2 - 1 : 0;
            }
        } else {
            d dVar2 = this.f3854C;
            z2 = dVar2.f3886c;
            i3 = dVar2.f3884a;
        }
        int i4 = z2 ? -1 : 1;
        for (int i5 = 0; i5 < this.f3857F && i3 >= 0 && i3 < i2; i5++) {
            cVar.a(i3, 0);
            i3 += i4;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int q(RecyclerView.z zVar) {
        return J1(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int r(RecyclerView.z zVar) {
        return K1(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean r0() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int s(RecyclerView.z zVar) {
        return L1(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int t(RecyclerView.z zVar) {
        return J1(zVar);
    }

    boolean t2() {
        return this.f3858t.k() == 0 && this.f3858t.h() == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int u(RecyclerView.z zVar) {
        return K1(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int u1(int i2, RecyclerView.v vVar, RecyclerView.z zVar) {
        if (this.r == 1) {
            return 0;
        }
        return v2(i2, vVar, zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int v(RecyclerView.z zVar) {
        return L1(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void v1(int i2) {
        this.f3864z = i2;
        this.f3852A = Target.SIZE_ORIGINAL;
        d dVar = this.f3854C;
        if (dVar != null) {
            dVar.b();
        }
        r1();
    }

    int v2(int i2, RecyclerView.v vVar, RecyclerView.z zVar) {
        if (J() == 0 || i2 == 0) {
            return 0;
        }
        this.s.f3873a = true;
        O1();
        int i3 = i2 > 0 ? 1 : -1;
        int iAbs = Math.abs(i2);
        D2(i3, iAbs, true, zVar);
        c cVar = this.s;
        int iP1 = cVar.f3878g + P1(vVar, cVar, zVar, false);
        if (iP1 < 0) {
            return 0;
        }
        if (iAbs > iP1) {
            i2 = i3 * iP1;
        }
        this.f3858t.r(-i2);
        this.s.f3881j = i2;
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int w1(int i2, RecyclerView.v vVar, RecyclerView.z zVar) {
        if (this.r == 0) {
            return 0;
        }
        return v2(i2, vVar, zVar);
    }

    public void w2(int i2, int i3) {
        this.f3864z = i2;
        this.f3852A = i3;
        d dVar = this.f3854C;
        if (dVar != null) {
            dVar.b();
        }
        r1();
    }

    public void x2(int i2) {
        if (i2 != 0 && i2 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i2);
        }
        g(null);
        if (i2 != this.r || this.f3858t == null) {
            k kVarB = k.b(this, i2);
            this.f3858t = kVarB;
            this.f3855D.f3865a = kVarB;
            this.r = i2;
            r1();
        }
    }

    public void y2(boolean z2) {
        g(null);
        if (z2 == this.f3860v) {
            return;
        }
        this.f3860v = z2;
        r1();
    }

    public void z2(boolean z2) {
        g(null);
        if (this.f3862x == z2) {
            return;
        }
        this.f3862x = z2;
        r1();
    }

    public LinearLayoutManager(Context context, int i2, boolean z2) {
        this.r = 1;
        this.f3860v = false;
        this.f3861w = false;
        this.f3862x = false;
        this.f3863y = true;
        this.f3864z = -1;
        this.f3852A = Target.SIZE_ORIGINAL;
        this.f3854C = null;
        this.f3855D = new a();
        this.f3856E = new b();
        this.f3857F = 2;
        x2(i2);
        y2(z2);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.r = 1;
        this.f3860v = false;
        this.f3861w = false;
        this.f3862x = false;
        this.f3863y = true;
        this.f3864z = -1;
        this.f3852A = Target.SIZE_ORIGINAL;
        this.f3854C = null;
        this.f3855D = new a();
        this.f3856E = new b();
        this.f3857F = 2;
        RecyclerView.o.d dVarH0 = RecyclerView.o.h0(context, attributeSet, i2, i3);
        x2(dVarH0.f4020a);
        y2(dVarH0.f4022c);
        z2(dVarH0.f4023d);
    }
}
