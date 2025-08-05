package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import w.C0353E;

/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {

    /* renamed from: G, reason: collision with root package name */
    boolean f3841G;

    /* renamed from: H, reason: collision with root package name */
    int f3842H;

    /* renamed from: I, reason: collision with root package name */
    int[] f3843I;

    /* renamed from: J, reason: collision with root package name */
    View[] f3844J;

    /* renamed from: K, reason: collision with root package name */
    final SparseIntArray f3845K;

    /* renamed from: L, reason: collision with root package name */
    final SparseIntArray f3846L;

    /* renamed from: M, reason: collision with root package name */
    c f3847M;

    /* renamed from: N, reason: collision with root package name */
    final Rect f3848N;

    public static final class a extends c {
        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int d(int i2, int i3) {
            return i2 % i3;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int e(int i2) {
            return 1;
        }
    }

    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        final SparseIntArray f3850a = new SparseIntArray();

        /* renamed from: b, reason: collision with root package name */
        private boolean f3851b = false;

        int a(int i2) {
            int size = this.f3850a.size() - 1;
            int i3 = 0;
            while (i3 <= size) {
                int i4 = (i3 + size) >>> 1;
                if (this.f3850a.keyAt(i4) < i2) {
                    i3 = i4 + 1;
                } else {
                    size = i4 - 1;
                }
            }
            int i5 = i3 - 1;
            if (i5 < 0 || i5 >= this.f3850a.size()) {
                return -1;
            }
            return this.f3850a.keyAt(i5);
        }

        int b(int i2, int i3) {
            if (!this.f3851b) {
                return d(i2, i3);
            }
            int i4 = this.f3850a.get(i2, -1);
            if (i4 != -1) {
                return i4;
            }
            int iD = d(i2, i3);
            this.f3850a.put(i2, iD);
            return iD;
        }

        public int c(int i2, int i3) {
            int iE = e(i2);
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                int iE2 = e(i6);
                i4 += iE2;
                if (i4 == i3) {
                    i5++;
                    i4 = 0;
                } else if (i4 > i3) {
                    i5++;
                    i4 = iE2;
                }
            }
            return i4 + iE > i3 ? i5 + 1 : i5;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0031 -> B:19:0x0036). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0033 -> B:19:0x0036). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0035 -> B:19:0x0036). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int d(int r6, int r7) {
            /*
                r5 = this;
                int r0 = r5.e(r6)
                r1 = 0
                if (r0 != r7) goto L8
                return r1
            L8:
                boolean r2 = r5.f3851b
                if (r2 == 0) goto L26
                android.util.SparseIntArray r2 = r5.f3850a
                int r2 = r2.size()
                if (r2 <= 0) goto L26
                int r2 = r5.a(r6)
                if (r2 < 0) goto L26
                android.util.SparseIntArray r3 = r5.f3850a
                int r3 = r3.get(r2)
                int r4 = r5.e(r2)
                int r3 = r3 + r4
                goto L36
            L26:
                r2 = 0
                r3 = 0
            L28:
                if (r2 >= r6) goto L39
                int r4 = r5.e(r2)
                int r3 = r3 + r4
                if (r3 != r7) goto L33
                r3 = 0
                goto L36
            L33:
                if (r3 <= r7) goto L36
                r3 = r4
            L36:
                int r2 = r2 + 1
                goto L28
            L39:
                int r0 = r0 + r3
                if (r0 > r7) goto L3d
                return r3
            L3d:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.c.d(int, int):int");
        }

        public abstract int e(int i2);

        public void f() {
            this.f3850a.clear();
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.f3841G = false;
        this.f3842H = -1;
        this.f3845K = new SparseIntArray();
        this.f3846L = new SparseIntArray();
        this.f3847M = new a();
        this.f3848N = new Rect();
        X2(RecyclerView.o.h0(context, attributeSet, i2, i3).f4021b);
    }

    private void I2(RecyclerView.v vVar, RecyclerView.z zVar, int i2, int i3, boolean z2) {
        int i4;
        int i5;
        int i6;
        int i7 = 0;
        if (z2) {
            i5 = i2;
            i4 = 0;
            i6 = 1;
        } else {
            i4 = i2 - 1;
            i5 = -1;
            i6 = -1;
        }
        while (i4 != i5) {
            View view = this.f3844J[i4];
            b bVar = (b) view.getLayoutParams();
            int iT2 = T2(vVar, zVar, g0(view));
            bVar.f3849f = iT2;
            bVar.e = i7;
            i7 += iT2;
            i4 += i6;
        }
    }

    private void J2() {
        int iJ = J();
        for (int i2 = 0; i2 < iJ; i2++) {
            b bVar = (b) I(i2).getLayoutParams();
            int iA = bVar.a();
            this.f3845K.put(iA, bVar.f());
            this.f3846L.put(iA, bVar.e());
        }
    }

    private void K2(int i2) {
        this.f3843I = L2(this.f3843I, this.f3842H, i2);
    }

    static int[] L2(int[] iArr, int i2, int i3) {
        int i4;
        if (iArr == null || iArr.length != i2 + 1 || iArr[iArr.length - 1] != i3) {
            iArr = new int[i2 + 1];
        }
        int i5 = 0;
        iArr[0] = 0;
        int i6 = i3 / i2;
        int i7 = i3 % i2;
        int i8 = 0;
        for (int i9 = 1; i9 <= i2; i9++) {
            i5 += i7;
            if (i5 <= 0 || i2 - i5 >= i7) {
                i4 = i6;
            } else {
                i4 = i6 + 1;
                i5 -= i2;
            }
            i8 += i4;
            iArr[i9] = i8;
        }
        return iArr;
    }

    private void M2() {
        this.f3845K.clear();
        this.f3846L.clear();
    }

    private void N2(RecyclerView.v vVar, RecyclerView.z zVar, LinearLayoutManager.a aVar, int i2) {
        boolean z2 = i2 == 1;
        int iS2 = S2(vVar, zVar, aVar.f3866b);
        if (z2) {
            while (iS2 > 0) {
                int i3 = aVar.f3866b;
                if (i3 <= 0) {
                    return;
                }
                int i4 = i3 - 1;
                aVar.f3866b = i4;
                iS2 = S2(vVar, zVar, i4);
            }
            return;
        }
        int iB = zVar.b() - 1;
        int i5 = aVar.f3866b;
        while (i5 < iB) {
            int i6 = i5 + 1;
            int iS22 = S2(vVar, zVar, i6);
            if (iS22 <= iS2) {
                break;
            }
            i5 = i6;
            iS2 = iS22;
        }
        aVar.f3866b = i5;
    }

    private void O2() {
        View[] viewArr = this.f3844J;
        if (viewArr == null || viewArr.length != this.f3842H) {
            this.f3844J = new View[this.f3842H];
        }
    }

    private int R2(RecyclerView.v vVar, RecyclerView.z zVar, int i2) {
        if (!zVar.e()) {
            return this.f3847M.c(i2, this.f3842H);
        }
        int iF = vVar.f(i2);
        if (iF != -1) {
            return this.f3847M.c(iF, this.f3842H);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i2);
        return 0;
    }

    private int S2(RecyclerView.v vVar, RecyclerView.z zVar, int i2) {
        if (!zVar.e()) {
            return this.f3847M.b(i2, this.f3842H);
        }
        int i3 = this.f3846L.get(i2, -1);
        if (i3 != -1) {
            return i3;
        }
        int iF = vVar.f(i2);
        if (iF != -1) {
            return this.f3847M.b(iF, this.f3842H);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i2);
        return 0;
    }

    private int T2(RecyclerView.v vVar, RecyclerView.z zVar, int i2) {
        if (!zVar.e()) {
            return this.f3847M.e(i2);
        }
        int i3 = this.f3845K.get(i2, -1);
        if (i3 != -1) {
            return i3;
        }
        int iF = vVar.f(i2);
        if (iF != -1) {
            return this.f3847M.e(iF);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i2);
        return 1;
    }

    private void U2(float f2, int i2) {
        K2(Math.max(Math.round(f2 * this.f3842H), i2));
    }

    private void V2(View view, int i2, boolean z2) {
        int iK;
        int iK2;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.f4025b;
        int i3 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar).topMargin + ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
        int i4 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar).leftMargin + ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
        int iP2 = P2(bVar.e, bVar.f3849f);
        if (this.r == 1) {
            iK2 = RecyclerView.o.K(iP2, i2, i4, ((ViewGroup.MarginLayoutParams) bVar).width, false);
            iK = RecyclerView.o.K(this.f3858t.n(), X(), i3, ((ViewGroup.MarginLayoutParams) bVar).height, true);
        } else {
            int iK3 = RecyclerView.o.K(iP2, i2, i3, ((ViewGroup.MarginLayoutParams) bVar).height, false);
            int iK4 = RecyclerView.o.K(this.f3858t.n(), o0(), i4, ((ViewGroup.MarginLayoutParams) bVar).width, true);
            iK = iK3;
            iK2 = iK4;
        }
        W2(view, iK2, iK, z2);
    }

    private void W2(View view, int i2, int i3, boolean z2) {
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        if (z2 ? F1(view, i2, i3, pVar) : D1(view, i2, i3, pVar)) {
            view.measure(i2, i3);
        }
    }

    private void Z2() {
        int iW;
        int iF0;
        if (k2() == 1) {
            iW = n0() - e0();
            iF0 = d0();
        } else {
            iW = W() - c0();
            iF0 = f0();
        }
        K2(iW - iF0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void A1(Rect rect, int i2, int i3) {
        int iN;
        int iN2;
        if (this.f3843I == null) {
            super.A1(rect, i2, i3);
        }
        int iD0 = d0() + e0();
        int iF0 = f0() + c0();
        if (this.r == 1) {
            iN2 = RecyclerView.o.n(i3, rect.height() + iF0, a0());
            int[] iArr = this.f3843I;
            iN = RecyclerView.o.n(i2, iArr[iArr.length - 1] + iD0, b0());
        } else {
            iN = RecyclerView.o.n(i2, rect.width() + iD0, b0());
            int[] iArr2 = this.f3843I;
            iN2 = RecyclerView.o.n(i3, iArr2[iArr2.length - 1] + iF0, a0());
        }
        z1(iN, iN2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p D() {
        return this.r == 0 ? new b(-2, -1) : new b(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p E(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p F(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public boolean H1() {
        return this.f3854C == null && !this.f3841G;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00d1, code lost:
    
        if (r13 == (r2 > r15)) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x010f  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View I0(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.v r26, androidx.recyclerview.widget.RecyclerView.z r27) {
        /*
            Method dump skipped, instructions count: 317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.I0(android.view.View, int, androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$z):android.view.View");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void I1(RecyclerView.z zVar, LinearLayoutManager.c cVar, RecyclerView.o.c cVar2) {
        int iE = this.f3842H;
        for (int i2 = 0; i2 < this.f3842H && cVar.c(zVar) && iE > 0; i2++) {
            int i3 = cVar.f3876d;
            cVar2.a(i3, Math.max(0, cVar.f3878g));
            iE -= this.f3847M.e(i3);
            cVar.f3876d += cVar.e;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int N(RecyclerView.v vVar, RecyclerView.z zVar) {
        if (this.r == 1) {
            return this.f3842H;
        }
        if (zVar.b() < 1) {
            return 0;
        }
        return R2(vVar, zVar, zVar.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void O0(RecyclerView.v vVar, RecyclerView.z zVar, View view, C0353E c0353e) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.N0(view, c0353e);
            return;
        }
        b bVar = (b) layoutParams;
        int iR2 = R2(vVar, zVar, bVar.a());
        if (this.r == 0) {
            c0353e.a0(C0353E.f.a(bVar.e(), bVar.f(), iR2, 1, this.f3842H > 1 && bVar.f() == this.f3842H, false));
        } else {
            c0353e.a0(C0353E.f.a(iR2, 1, bVar.e(), bVar.f(), this.f3842H > 1 && bVar.f() == this.f3842H, false));
        }
    }

    int P2(int i2, int i3) {
        if (this.r != 1 || !l2()) {
            int[] iArr = this.f3843I;
            return iArr[i3 + i2] - iArr[i2];
        }
        int[] iArr2 = this.f3843I;
        int i4 = this.f3842H;
        return iArr2[i4 - i2] - iArr2[(i4 - i2) - i3];
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Q0(RecyclerView recyclerView, int i2, int i3) {
        this.f3847M.f();
    }

    public int Q2() {
        return this.f3842H;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void R0(RecyclerView recyclerView) {
        this.f3847M.f();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void S0(RecyclerView recyclerView, int i2, int i3, int i4) {
        this.f3847M.f();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void T0(RecyclerView recyclerView, int i2, int i3) {
        this.f3847M.f();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void V0(RecyclerView recyclerView, int i2, int i3, Object obj) {
        this.f3847M.f();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void W0(RecyclerView.v vVar, RecyclerView.z zVar) {
        if (zVar.e()) {
            J2();
        }
        super.W0(vVar, zVar);
        M2();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView.z zVar) {
        super.X0(zVar);
        this.f3841G = false;
    }

    public void X2(int i2) {
        if (i2 == this.f3842H) {
            return;
        }
        this.f3841G = true;
        if (i2 >= 1) {
            this.f3842H = i2;
            this.f3847M.f();
            r1();
        } else {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i2);
        }
    }

    public void Y2(c cVar) {
        this.f3847M = cVar;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
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
            if (iG0 >= 0 && iG0 < i4 && S2(vVar, zVar, iG0) == 0) {
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
    public int j0(RecyclerView.v vVar, RecyclerView.z zVar) {
        if (this.r == 0) {
            return this.f3842H;
        }
        if (zVar.b() < 1) {
            return 0;
        }
        return R2(vVar, zVar, zVar.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean m(RecyclerView.p pVar) {
        return pVar instanceof b;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void m2(RecyclerView.v vVar, RecyclerView.z zVar, LinearLayoutManager.c cVar, LinearLayoutManager.b bVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int iF;
        int iF2;
        int iF3;
        int iK;
        int iK2;
        boolean z2;
        View viewD;
        int iL = this.f3858t.l();
        boolean z3 = iL != 1073741824;
        int i7 = J() > 0 ? this.f3843I[this.f3842H] : 0;
        if (z3) {
            Z2();
        }
        boolean z4 = cVar.e == 1;
        int iS2 = this.f3842H;
        if (!z4) {
            iS2 = S2(vVar, zVar, cVar.f3876d) + T2(vVar, zVar, cVar.f3876d);
        }
        int i8 = 0;
        int i9 = 0;
        while (i9 < this.f3842H && cVar.c(zVar) && iS2 > 0) {
            int i10 = cVar.f3876d;
            int iT2 = T2(vVar, zVar, i10);
            if (iT2 > this.f3842H) {
                throw new IllegalArgumentException("Item at position " + i10 + " requires " + iT2 + " spans but GridLayoutManager has only " + this.f3842H + " spans.");
            }
            iS2 -= iT2;
            if (iS2 < 0 || (viewD = cVar.d(vVar)) == null) {
                break;
            }
            i8 += iT2;
            this.f3844J[i9] = viewD;
            i9++;
        }
        if (i9 == 0) {
            bVar.f3870b = true;
            return;
        }
        int i11 = i9;
        I2(vVar, zVar, i9, i8, z4);
        float f2 = 0.0f;
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            View view = this.f3844J[i13];
            if (cVar.f3882k != null) {
                z2 = false;
                if (z4) {
                    b(view);
                } else {
                    c(view, 0);
                }
            } else if (z4) {
                d(view);
                z2 = false;
            } else {
                z2 = false;
                e(view, 0);
            }
            j(view, this.f3848N);
            V2(view, iL, z2);
            int iE = this.f3858t.e(view);
            if (iE > i12) {
                i12 = iE;
            }
            float f3 = (this.f3858t.f(view) * 1.0f) / ((b) view.getLayoutParams()).f3849f;
            if (f3 > f2) {
                f2 = f3;
            }
        }
        if (z3) {
            U2(f2, i7);
            i12 = 0;
            for (int i14 = 0; i14 < i11; i14++) {
                View view2 = this.f3844J[i14];
                V2(view2, 1073741824, true);
                int iE2 = this.f3858t.e(view2);
                if (iE2 > i12) {
                    i12 = iE2;
                }
            }
        }
        for (int i15 = 0; i15 < i11; i15++) {
            View view3 = this.f3844J[i15];
            if (this.f3858t.e(view3) != i12) {
                b bVar2 = (b) view3.getLayoutParams();
                Rect rect = bVar2.f4025b;
                int i16 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar2).topMargin + ((ViewGroup.MarginLayoutParams) bVar2).bottomMargin;
                int i17 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar2).leftMargin + ((ViewGroup.MarginLayoutParams) bVar2).rightMargin;
                int iP2 = P2(bVar2.e, bVar2.f3849f);
                if (this.r == 1) {
                    iK2 = RecyclerView.o.K(iP2, 1073741824, i17, ((ViewGroup.MarginLayoutParams) bVar2).width, false);
                    iK = View.MeasureSpec.makeMeasureSpec(i12 - i16, 1073741824);
                } else {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i12 - i17, 1073741824);
                    iK = RecyclerView.o.K(iP2, 1073741824, i16, ((ViewGroup.MarginLayoutParams) bVar2).height, false);
                    iK2 = iMakeMeasureSpec;
                }
                W2(view3, iK2, iK, true);
            }
        }
        int i18 = 0;
        bVar.f3869a = i12;
        if (this.r != 1) {
            if (cVar.f3877f == -1) {
                int i19 = cVar.f3874b;
                i3 = i19 - i12;
                i2 = i19;
            } else {
                int i20 = cVar.f3874b;
                i2 = i20 + i12;
                i3 = i20;
            }
            i4 = 0;
            i5 = 0;
        } else if (cVar.f3877f == -1) {
            int i21 = cVar.f3874b;
            int i22 = i21 - i12;
            i3 = 0;
            i2 = 0;
            i5 = i22;
            i4 = i21;
        } else {
            i5 = cVar.f3874b;
            i4 = i5 + i12;
            i3 = 0;
            i2 = 0;
        }
        while (i18 < i11) {
            View view4 = this.f3844J[i18];
            b bVar3 = (b) view4.getLayoutParams();
            if (this.r == 1) {
                if (l2()) {
                    int iD0 = d0() + this.f3843I[this.f3842H - bVar3.e];
                    iF3 = i4;
                    iF2 = iD0;
                    iF = iD0 - this.f3858t.f(view4);
                } else {
                    int iD02 = d0() + this.f3843I[bVar3.e];
                    iF3 = i4;
                    iF = iD02;
                    iF2 = this.f3858t.f(view4) + iD02;
                }
                i6 = i5;
            } else {
                int iF0 = f0() + this.f3843I[bVar3.e];
                i6 = iF0;
                iF = i3;
                iF2 = i2;
                iF3 = this.f3858t.f(view4) + iF0;
            }
            y0(view4, iF, i6, iF2, iF3);
            if (bVar3.c() || bVar3.b()) {
                bVar.f3871c = true;
            }
            bVar.f3872d |= view4.hasFocusable();
            i18++;
            i4 = iF3;
            i3 = iF;
            i2 = iF2;
            i5 = i6;
        }
        Arrays.fill(this.f3844J, (Object) null);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void o2(RecyclerView.v vVar, RecyclerView.z zVar, LinearLayoutManager.a aVar, int i2) {
        super.o2(vVar, zVar, aVar, i2);
        Z2();
        if (zVar.b() > 0 && !zVar.e()) {
            N2(vVar, zVar, aVar, i2);
        }
        O2();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int u1(int i2, RecyclerView.v vVar, RecyclerView.z zVar) {
        Z2();
        O2();
        return super.u1(i2, vVar, zVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int w1(int i2, RecyclerView.v vVar, RecyclerView.z zVar) {
        Z2();
        O2();
        return super.w1(i2, vVar, zVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void z2(boolean z2) {
        if (z2) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.z2(false);
    }

    public static class b extends RecyclerView.p {
        int e;

        /* renamed from: f, reason: collision with root package name */
        int f3849f;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.e = -1;
            this.f3849f = 0;
        }

        public int e() {
            return this.e;
        }

        public int f() {
            return this.f3849f;
        }

        public b(int i2, int i3) {
            super(i2, i3);
            this.e = -1;
            this.f3849f = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.e = -1;
            this.f3849f = 0;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.e = -1;
            this.f3849f = 0;
        }
    }

    public GridLayoutManager(Context context, int i2) {
        super(context);
        this.f3841G = false;
        this.f3842H = -1;
        this.f3845K = new SparseIntArray();
        this.f3846L = new SparseIntArray();
        this.f3847M = new a();
        this.f3848N = new Rect();
        X2(i2);
    }
}
