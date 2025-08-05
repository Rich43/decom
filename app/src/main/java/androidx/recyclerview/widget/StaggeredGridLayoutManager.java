package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.request.target.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import w.C0353E;

/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.o {

    /* renamed from: A, reason: collision with root package name */
    private BitSet f4058A;

    /* renamed from: F, reason: collision with root package name */
    private boolean f4063F;

    /* renamed from: G, reason: collision with root package name */
    private boolean f4064G;

    /* renamed from: H, reason: collision with root package name */
    private e f4065H;

    /* renamed from: I, reason: collision with root package name */
    private int f4066I;

    /* renamed from: N, reason: collision with root package name */
    private int[] f4071N;
    f[] s;

    /* renamed from: t, reason: collision with root package name */
    k f4073t;

    /* renamed from: u, reason: collision with root package name */
    k f4074u;

    /* renamed from: v, reason: collision with root package name */
    private int f4075v;

    /* renamed from: w, reason: collision with root package name */
    private int f4076w;

    /* renamed from: x, reason: collision with root package name */
    private final i f4077x;
    private int r = -1;

    /* renamed from: y, reason: collision with root package name */
    boolean f4078y = false;

    /* renamed from: z, reason: collision with root package name */
    boolean f4079z = false;

    /* renamed from: B, reason: collision with root package name */
    int f4059B = -1;

    /* renamed from: C, reason: collision with root package name */
    int f4060C = Target.SIZE_ORIGINAL;

    /* renamed from: D, reason: collision with root package name */
    d f4061D = new d();

    /* renamed from: E, reason: collision with root package name */
    private int f4062E = 2;

    /* renamed from: J, reason: collision with root package name */
    private final Rect f4067J = new Rect();

    /* renamed from: K, reason: collision with root package name */
    private final b f4068K = new b();

    /* renamed from: L, reason: collision with root package name */
    private boolean f4069L = false;

    /* renamed from: M, reason: collision with root package name */
    private boolean f4070M = true;

    /* renamed from: O, reason: collision with root package name */
    private final Runnable f4072O = new a();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.O1();
        }
    }

    class b {

        /* renamed from: a, reason: collision with root package name */
        int f4081a;

        /* renamed from: b, reason: collision with root package name */
        int f4082b;

        /* renamed from: c, reason: collision with root package name */
        boolean f4083c;

        /* renamed from: d, reason: collision with root package name */
        boolean f4084d;
        boolean e;

        /* renamed from: f, reason: collision with root package name */
        int[] f4085f;

        b() {
            c();
        }

        void a() {
            this.f4082b = this.f4083c ? StaggeredGridLayoutManager.this.f4073t.i() : StaggeredGridLayoutManager.this.f4073t.m();
        }

        void b(int i2) {
            if (this.f4083c) {
                this.f4082b = StaggeredGridLayoutManager.this.f4073t.i() - i2;
            } else {
                this.f4082b = StaggeredGridLayoutManager.this.f4073t.m() + i2;
            }
        }

        void c() {
            this.f4081a = -1;
            this.f4082b = Target.SIZE_ORIGINAL;
            this.f4083c = false;
            this.f4084d = false;
            this.e = false;
            int[] iArr = this.f4085f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        void d(f[] fVarArr) {
            int length = fVarArr.length;
            int[] iArr = this.f4085f;
            if (iArr == null || iArr.length < length) {
                this.f4085f = new int[StaggeredGridLayoutManager.this.s.length];
            }
            for (int i2 = 0; i2 < length; i2++) {
                this.f4085f[i2] = fVarArr[i2].p(Target.SIZE_ORIGINAL);
            }
        }
    }

    public static class c extends RecyclerView.p {
        f e;

        /* renamed from: f, reason: collision with root package name */
        boolean f4087f;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public final int e() {
            f fVar = this.e;
            if (fVar == null) {
                return -1;
            }
            return fVar.e;
        }

        public boolean f() {
            return this.f4087f;
        }

        public c(int i2, int i3) {
            super(i2, i3);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public static class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        int f4094a;

        /* renamed from: b, reason: collision with root package name */
        int f4095b;

        /* renamed from: c, reason: collision with root package name */
        int f4096c;

        /* renamed from: d, reason: collision with root package name */
        int[] f4097d;
        int e;

        /* renamed from: f, reason: collision with root package name */
        int[] f4098f;

        /* renamed from: g, reason: collision with root package name */
        List f4099g;

        /* renamed from: h, reason: collision with root package name */
        boolean f4100h;

        /* renamed from: i, reason: collision with root package name */
        boolean f4101i;

        /* renamed from: j, reason: collision with root package name */
        boolean f4102j;

        static class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public e[] newArray(int i2) {
                return new e[i2];
            }
        }

        public e() {
        }

        void a() {
            this.f4097d = null;
            this.f4096c = 0;
            this.f4094a = -1;
            this.f4095b = -1;
        }

        void b() {
            this.f4097d = null;
            this.f4096c = 0;
            this.e = 0;
            this.f4098f = null;
            this.f4099g = null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f4094a);
            parcel.writeInt(this.f4095b);
            parcel.writeInt(this.f4096c);
            if (this.f4096c > 0) {
                parcel.writeIntArray(this.f4097d);
            }
            parcel.writeInt(this.e);
            if (this.e > 0) {
                parcel.writeIntArray(this.f4098f);
            }
            parcel.writeInt(this.f4100h ? 1 : 0);
            parcel.writeInt(this.f4101i ? 1 : 0);
            parcel.writeInt(this.f4102j ? 1 : 0);
            parcel.writeList(this.f4099g);
        }

        e(Parcel parcel) {
            this.f4094a = parcel.readInt();
            this.f4095b = parcel.readInt();
            int i2 = parcel.readInt();
            this.f4096c = i2;
            if (i2 > 0) {
                int[] iArr = new int[i2];
                this.f4097d = iArr;
                parcel.readIntArray(iArr);
            }
            int i3 = parcel.readInt();
            this.e = i3;
            if (i3 > 0) {
                int[] iArr2 = new int[i3];
                this.f4098f = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.f4100h = parcel.readInt() == 1;
            this.f4101i = parcel.readInt() == 1;
            this.f4102j = parcel.readInt() == 1;
            this.f4099g = parcel.readArrayList(d.a.class.getClassLoader());
        }

        public e(e eVar) {
            this.f4096c = eVar.f4096c;
            this.f4094a = eVar.f4094a;
            this.f4095b = eVar.f4095b;
            this.f4097d = eVar.f4097d;
            this.e = eVar.e;
            this.f4098f = eVar.f4098f;
            this.f4100h = eVar.f4100h;
            this.f4101i = eVar.f4101i;
            this.f4102j = eVar.f4102j;
            this.f4099g = eVar.f4099g;
        }
    }

    class f {

        /* renamed from: a, reason: collision with root package name */
        ArrayList f4103a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        int f4104b = Target.SIZE_ORIGINAL;

        /* renamed from: c, reason: collision with root package name */
        int f4105c = Target.SIZE_ORIGINAL;

        /* renamed from: d, reason: collision with root package name */
        int f4106d = 0;
        final int e;

        f(int i2) {
            this.e = i2;
        }

        void a(View view) {
            c cVarN = n(view);
            cVarN.e = this;
            this.f4103a.add(view);
            this.f4105c = Target.SIZE_ORIGINAL;
            if (this.f4103a.size() == 1) {
                this.f4104b = Target.SIZE_ORIGINAL;
            }
            if (cVarN.c() || cVarN.b()) {
                this.f4106d += StaggeredGridLayoutManager.this.f4073t.e(view);
            }
        }

        void b(boolean z2, int i2) {
            int iL = z2 ? l(Target.SIZE_ORIGINAL) : p(Target.SIZE_ORIGINAL);
            e();
            if (iL == Integer.MIN_VALUE) {
                return;
            }
            if (!z2 || iL >= StaggeredGridLayoutManager.this.f4073t.i()) {
                if (z2 || iL <= StaggeredGridLayoutManager.this.f4073t.m()) {
                    if (i2 != Integer.MIN_VALUE) {
                        iL += i2;
                    }
                    this.f4105c = iL;
                    this.f4104b = iL;
                }
            }
        }

        void c() {
            d.a aVarF;
            ArrayList arrayList = this.f4103a;
            View view = (View) arrayList.get(arrayList.size() - 1);
            c cVarN = n(view);
            this.f4105c = StaggeredGridLayoutManager.this.f4073t.d(view);
            if (cVarN.f4087f && (aVarF = StaggeredGridLayoutManager.this.f4061D.f(cVarN.a())) != null && aVarF.f4091b == 1) {
                this.f4105c += aVarF.a(this.e);
            }
        }

        void d() {
            d.a aVarF;
            View view = (View) this.f4103a.get(0);
            c cVarN = n(view);
            this.f4104b = StaggeredGridLayoutManager.this.f4073t.g(view);
            if (cVarN.f4087f && (aVarF = StaggeredGridLayoutManager.this.f4061D.f(cVarN.a())) != null && aVarF.f4091b == -1) {
                this.f4104b -= aVarF.a(this.e);
            }
        }

        void e() {
            this.f4103a.clear();
            q();
            this.f4106d = 0;
        }

        public int f() {
            return StaggeredGridLayoutManager.this.f4078y ? i(this.f4103a.size() - 1, -1, true) : i(0, this.f4103a.size(), true);
        }

        public int g() {
            return StaggeredGridLayoutManager.this.f4078y ? i(0, this.f4103a.size(), true) : i(this.f4103a.size() - 1, -1, true);
        }

        int h(int i2, int i3, boolean z2, boolean z3, boolean z4) {
            int iM = StaggeredGridLayoutManager.this.f4073t.m();
            int i4 = StaggeredGridLayoutManager.this.f4073t.i();
            int i5 = i3 > i2 ? 1 : -1;
            while (i2 != i3) {
                View view = (View) this.f4103a.get(i2);
                int iG = StaggeredGridLayoutManager.this.f4073t.g(view);
                int iD = StaggeredGridLayoutManager.this.f4073t.d(view);
                boolean z5 = false;
                boolean z6 = !z4 ? iG >= i4 : iG > i4;
                if (!z4 ? iD > iM : iD >= iM) {
                    z5 = true;
                }
                if (z6 && z5) {
                    if (z2 && z3) {
                        if (iG >= iM && iD <= i4) {
                            return StaggeredGridLayoutManager.this.g0(view);
                        }
                    } else {
                        if (z3) {
                            return StaggeredGridLayoutManager.this.g0(view);
                        }
                        if (iG < iM || iD > i4) {
                            return StaggeredGridLayoutManager.this.g0(view);
                        }
                    }
                }
                i2 += i5;
            }
            return -1;
        }

        int i(int i2, int i3, boolean z2) {
            return h(i2, i3, false, false, z2);
        }

        public int j() {
            return this.f4106d;
        }

        int k() {
            int i2 = this.f4105c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            c();
            return this.f4105c;
        }

        int l(int i2) {
            int i3 = this.f4105c;
            if (i3 != Integer.MIN_VALUE) {
                return i3;
            }
            if (this.f4103a.size() == 0) {
                return i2;
            }
            c();
            return this.f4105c;
        }

        public View m(int i2, int i3) {
            View view = null;
            if (i3 != -1) {
                int size = this.f4103a.size() - 1;
                while (size >= 0) {
                    View view2 = (View) this.f4103a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.f4078y && staggeredGridLayoutManager.g0(view2) >= i2) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.f4078y && staggeredGridLayoutManager2.g0(view2) <= i2) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f4103a.size();
                int i4 = 0;
                while (i4 < size2) {
                    View view3 = (View) this.f4103a.get(i4);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.f4078y && staggeredGridLayoutManager3.g0(view3) <= i2) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.f4078y && staggeredGridLayoutManager4.g0(view3) >= i2) || !view3.hasFocusable()) {
                        break;
                    }
                    i4++;
                    view = view3;
                }
            }
            return view;
        }

        c n(View view) {
            return (c) view.getLayoutParams();
        }

        int o() {
            int i2 = this.f4104b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            d();
            return this.f4104b;
        }

        int p(int i2) {
            int i3 = this.f4104b;
            if (i3 != Integer.MIN_VALUE) {
                return i3;
            }
            if (this.f4103a.size() == 0) {
                return i2;
            }
            d();
            return this.f4104b;
        }

        void q() {
            this.f4104b = Target.SIZE_ORIGINAL;
            this.f4105c = Target.SIZE_ORIGINAL;
        }

        void r(int i2) {
            int i3 = this.f4104b;
            if (i3 != Integer.MIN_VALUE) {
                this.f4104b = i3 + i2;
            }
            int i4 = this.f4105c;
            if (i4 != Integer.MIN_VALUE) {
                this.f4105c = i4 + i2;
            }
        }

        void s() {
            int size = this.f4103a.size();
            View view = (View) this.f4103a.remove(size - 1);
            c cVarN = n(view);
            cVarN.e = null;
            if (cVarN.c() || cVarN.b()) {
                this.f4106d -= StaggeredGridLayoutManager.this.f4073t.e(view);
            }
            if (size == 1) {
                this.f4104b = Target.SIZE_ORIGINAL;
            }
            this.f4105c = Target.SIZE_ORIGINAL;
        }

        void t() {
            View view = (View) this.f4103a.remove(0);
            c cVarN = n(view);
            cVarN.e = null;
            if (this.f4103a.size() == 0) {
                this.f4105c = Target.SIZE_ORIGINAL;
            }
            if (cVarN.c() || cVarN.b()) {
                this.f4106d -= StaggeredGridLayoutManager.this.f4073t.e(view);
            }
            this.f4104b = Target.SIZE_ORIGINAL;
        }

        void u(View view) {
            c cVarN = n(view);
            cVarN.e = this;
            this.f4103a.add(0, view);
            this.f4104b = Target.SIZE_ORIGINAL;
            if (this.f4103a.size() == 1) {
                this.f4105c = Target.SIZE_ORIGINAL;
            }
            if (cVarN.c() || cVarN.b()) {
                this.f4106d += StaggeredGridLayoutManager.this.f4073t.e(view);
            }
        }

        void v(int i2) {
            this.f4104b = i2;
            this.f4105c = i2;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        RecyclerView.o.d dVarH0 = RecyclerView.o.h0(context, attributeSet, i2, i3);
        D2(dVarH0.f4020a);
        F2(dVarH0.f4021b);
        E2(dVarH0.f4022c);
        this.f4077x = new i();
        W1();
    }

    private void A2() {
        if (this.f4075v == 1 || !p2()) {
            this.f4079z = this.f4078y;
        } else {
            this.f4079z = !this.f4078y;
        }
    }

    private void C2(int i2) {
        i iVar = this.f4077x;
        iVar.e = i2;
        iVar.f4270d = this.f4079z != (i2 == -1) ? -1 : 1;
    }

    private void G2(int i2, int i3) {
        for (int i4 = 0; i4 < this.r; i4++) {
            if (!this.s[i4].f4103a.isEmpty()) {
                M2(this.s[i4], i2, i3);
            }
        }
    }

    private boolean H2(RecyclerView.z zVar, b bVar) {
        bVar.f4081a = this.f4063F ? c2(zVar.b()) : Y1(zVar.b());
        bVar.f4082b = Target.SIZE_ORIGINAL;
        return true;
    }

    private void I1(View view) {
        for (int i2 = this.r - 1; i2 >= 0; i2--) {
            this.s[i2].a(view);
        }
    }

    private void J1(b bVar) {
        e eVar = this.f4065H;
        int i2 = eVar.f4096c;
        if (i2 > 0) {
            if (i2 == this.r) {
                for (int i3 = 0; i3 < this.r; i3++) {
                    this.s[i3].e();
                    e eVar2 = this.f4065H;
                    int i4 = eVar2.f4097d[i3];
                    if (i4 != Integer.MIN_VALUE) {
                        i4 += eVar2.f4101i ? this.f4073t.i() : this.f4073t.m();
                    }
                    this.s[i3].v(i4);
                }
            } else {
                eVar.b();
                e eVar3 = this.f4065H;
                eVar3.f4094a = eVar3.f4095b;
            }
        }
        e eVar4 = this.f4065H;
        this.f4064G = eVar4.f4102j;
        E2(eVar4.f4100h);
        A2();
        e eVar5 = this.f4065H;
        int i5 = eVar5.f4094a;
        if (i5 != -1) {
            this.f4059B = i5;
            bVar.f4083c = eVar5.f4101i;
        } else {
            bVar.f4083c = this.f4079z;
        }
        if (eVar5.e > 1) {
            d dVar = this.f4061D;
            dVar.f4088a = eVar5.f4098f;
            dVar.f4089b = eVar5.f4099g;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void K2(int r5, androidx.recyclerview.widget.RecyclerView.z r6) {
        /*
            r4 = this;
            androidx.recyclerview.widget.i r0 = r4.f4077x
            r1 = 0
            r0.f4268b = r1
            r0.f4269c = r5
            boolean r0 = r4.w0()
            r2 = 1
            if (r0 == 0) goto L2f
            int r6 = r6.c()
            r0 = -1
            if (r6 == r0) goto L2f
            boolean r0 = r4.f4079z
            if (r6 >= r5) goto L1b
            r5 = 1
            goto L1c
        L1b:
            r5 = 0
        L1c:
            if (r0 != r5) goto L26
            androidx.recyclerview.widget.k r5 = r4.f4073t
            int r5 = r5.n()
        L24:
            r6 = 0
            goto L31
        L26:
            androidx.recyclerview.widget.k r5 = r4.f4073t
            int r5 = r5.n()
            r6 = r5
            r5 = 0
            goto L31
        L2f:
            r5 = 0
            goto L24
        L31:
            boolean r0 = r4.M()
            if (r0 == 0) goto L4e
            androidx.recyclerview.widget.i r0 = r4.f4077x
            androidx.recyclerview.widget.k r3 = r4.f4073t
            int r3 = r3.m()
            int r3 = r3 - r6
            r0.f4271f = r3
            androidx.recyclerview.widget.i r6 = r4.f4077x
            androidx.recyclerview.widget.k r0 = r4.f4073t
            int r0 = r0.i()
            int r0 = r0 + r5
            r6.f4272g = r0
            goto L5e
        L4e:
            androidx.recyclerview.widget.i r0 = r4.f4077x
            androidx.recyclerview.widget.k r3 = r4.f4073t
            int r3 = r3.h()
            int r3 = r3 + r5
            r0.f4272g = r3
            androidx.recyclerview.widget.i r5 = r4.f4077x
            int r6 = -r6
            r5.f4271f = r6
        L5e:
            androidx.recyclerview.widget.i r5 = r4.f4077x
            r5.f4273h = r1
            r5.f4267a = r2
            androidx.recyclerview.widget.k r6 = r4.f4073t
            int r6 = r6.k()
            if (r6 != 0) goto L75
            androidx.recyclerview.widget.k r6 = r4.f4073t
            int r6 = r6.h()
            if (r6 != 0) goto L75
            r1 = 1
        L75:
            r5.f4274i = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.K2(int, androidx.recyclerview.widget.RecyclerView$z):void");
    }

    private void M1(View view, c cVar, i iVar) {
        if (iVar.e == 1) {
            if (cVar.f4087f) {
                I1(view);
                return;
            } else {
                cVar.e.a(view);
                return;
            }
        }
        if (cVar.f4087f) {
            v2(view);
        } else {
            cVar.e.u(view);
        }
    }

    private void M2(f fVar, int i2, int i3) {
        int iJ = fVar.j();
        if (i2 == -1) {
            if (fVar.o() + iJ <= i3) {
                this.f4058A.set(fVar.e, false);
            }
        } else if (fVar.k() - iJ >= i3) {
            this.f4058A.set(fVar.e, false);
        }
    }

    private int N1(int i2) {
        if (J() == 0) {
            return this.f4079z ? 1 : -1;
        }
        return (i2 < f2()) != this.f4079z ? -1 : 1;
    }

    private int N2(int i2, int i3, int i4) {
        if (i3 == 0 && i4 == 0) {
            return i2;
        }
        int mode = View.MeasureSpec.getMode(i2);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i2) - i3) - i4), mode) : i2;
    }

    private boolean P1(f fVar) {
        if (this.f4079z) {
            if (fVar.k() < this.f4073t.i()) {
                ArrayList arrayList = fVar.f4103a;
                return !fVar.n((View) arrayList.get(arrayList.size() - 1)).f4087f;
            }
        } else if (fVar.o() > this.f4073t.m()) {
            return !fVar.n((View) fVar.f4103a.get(0)).f4087f;
        }
        return false;
    }

    private int Q1(RecyclerView.z zVar) {
        if (J() == 0) {
            return 0;
        }
        return m.a(zVar, this.f4073t, a2(!this.f4070M), Z1(!this.f4070M), this, this.f4070M);
    }

    private int R1(RecyclerView.z zVar) {
        if (J() == 0) {
            return 0;
        }
        return m.b(zVar, this.f4073t, a2(!this.f4070M), Z1(!this.f4070M), this, this.f4070M, this.f4079z);
    }

    private int S1(RecyclerView.z zVar) {
        if (J() == 0) {
            return 0;
        }
        return m.c(zVar, this.f4073t, a2(!this.f4070M), Z1(!this.f4070M), this, this.f4070M);
    }

    private int T1(int i2) {
        if (i2 == 1) {
            return (this.f4075v != 1 && p2()) ? 1 : -1;
        }
        if (i2 == 2) {
            return (this.f4075v != 1 && p2()) ? -1 : 1;
        }
        if (i2 == 17) {
            if (this.f4075v == 0) {
                return -1;
            }
            return Target.SIZE_ORIGINAL;
        }
        if (i2 == 33) {
            if (this.f4075v == 1) {
                return -1;
            }
            return Target.SIZE_ORIGINAL;
        }
        if (i2 == 66) {
            if (this.f4075v == 0) {
                return 1;
            }
            return Target.SIZE_ORIGINAL;
        }
        if (i2 == 130 && this.f4075v == 1) {
            return 1;
        }
        return Target.SIZE_ORIGINAL;
    }

    private d.a U1(int i2) {
        d.a aVar = new d.a();
        aVar.f4092c = new int[this.r];
        for (int i3 = 0; i3 < this.r; i3++) {
            aVar.f4092c[i3] = i2 - this.s[i3].l(i2);
        }
        return aVar;
    }

    private d.a V1(int i2) {
        d.a aVar = new d.a();
        aVar.f4092c = new int[this.r];
        for (int i3 = 0; i3 < this.r; i3++) {
            aVar.f4092c[i3] = this.s[i3].p(i2) - i2;
        }
        return aVar;
    }

    private void W1() {
        this.f4073t = k.b(this, this.f4075v);
        this.f4074u = k.b(this, 1 - this.f4075v);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    private int X1(RecyclerView.v vVar, i iVar, RecyclerView.z zVar) {
        int i2;
        f fVarL2;
        int iE;
        int i3;
        int iE2;
        int iE3;
        ?? r9 = 0;
        this.f4058A.set(0, this.r, true);
        if (this.f4077x.f4274i) {
            i2 = iVar.e == 1 ? Integer.MAX_VALUE : Target.SIZE_ORIGINAL;
        } else {
            i2 = iVar.e == 1 ? iVar.f4272g + iVar.f4268b : iVar.f4271f - iVar.f4268b;
        }
        G2(iVar.e, i2);
        int i4 = this.f4079z ? this.f4073t.i() : this.f4073t.m();
        boolean z2 = false;
        while (iVar.a(zVar) && (this.f4077x.f4274i || !this.f4058A.isEmpty())) {
            View viewB = iVar.b(vVar);
            c cVar = (c) viewB.getLayoutParams();
            int iA = cVar.a();
            int iG = this.f4061D.g(iA);
            boolean z3 = iG == -1;
            if (z3) {
                fVarL2 = cVar.f4087f ? this.s[r9] : l2(iVar);
                this.f4061D.n(iA, fVarL2);
            } else {
                fVarL2 = this.s[iG];
            }
            f fVar = fVarL2;
            cVar.e = fVar;
            if (iVar.e == 1) {
                d(viewB);
            } else {
                e(viewB, r9);
            }
            r2(viewB, cVar, r9);
            if (iVar.e == 1) {
                int iH2 = cVar.f4087f ? h2(i4) : fVar.l(i4);
                int iE4 = this.f4073t.e(viewB) + iH2;
                if (z3 && cVar.f4087f) {
                    d.a aVarU1 = U1(iH2);
                    aVarU1.f4091b = -1;
                    aVarU1.f4090a = iA;
                    this.f4061D.a(aVarU1);
                }
                i3 = iE4;
                iE = iH2;
            } else {
                int iK2 = cVar.f4087f ? k2(i4) : fVar.p(i4);
                iE = iK2 - this.f4073t.e(viewB);
                if (z3 && cVar.f4087f) {
                    d.a aVarV1 = V1(iK2);
                    aVarV1.f4091b = 1;
                    aVarV1.f4090a = iA;
                    this.f4061D.a(aVarV1);
                }
                i3 = iK2;
            }
            if (cVar.f4087f && iVar.f4270d == -1) {
                if (z3) {
                    this.f4069L = true;
                } else {
                    if (!(iVar.e == 1 ? K1() : L1())) {
                        d.a aVarF = this.f4061D.f(iA);
                        if (aVarF != null) {
                            aVarF.f4093d = true;
                        }
                        this.f4069L = true;
                    }
                }
            }
            M1(viewB, cVar, iVar);
            if (p2() && this.f4075v == 1) {
                int i5 = cVar.f4087f ? this.f4074u.i() : this.f4074u.i() - (((this.r - 1) - fVar.e) * this.f4076w);
                iE3 = i5;
                iE2 = i5 - this.f4074u.e(viewB);
            } else {
                int iM = cVar.f4087f ? this.f4074u.m() : (fVar.e * this.f4076w) + this.f4074u.m();
                iE2 = iM;
                iE3 = this.f4074u.e(viewB) + iM;
            }
            if (this.f4075v == 1) {
                y0(viewB, iE2, iE, iE3, i3);
            } else {
                y0(viewB, iE, iE2, i3, iE3);
            }
            if (cVar.f4087f) {
                G2(this.f4077x.e, i2);
            } else {
                M2(fVar, this.f4077x.e, i2);
            }
            w2(vVar, this.f4077x);
            if (this.f4077x.f4273h && viewB.hasFocusable()) {
                if (cVar.f4087f) {
                    this.f4058A.clear();
                } else {
                    this.f4058A.set(fVar.e, false);
                }
            }
            z2 = true;
            r9 = 0;
        }
        if (!z2) {
            w2(vVar, this.f4077x);
        }
        int iM2 = this.f4077x.e == -1 ? this.f4073t.m() - k2(this.f4073t.m()) : h2(this.f4073t.i()) - this.f4073t.i();
        if (iM2 > 0) {
            return Math.min(iVar.f4268b, iM2);
        }
        return 0;
    }

    private int Y1(int i2) {
        int iJ = J();
        for (int i3 = 0; i3 < iJ; i3++) {
            int iG0 = g0(I(i3));
            if (iG0 >= 0 && iG0 < i2) {
                return iG0;
            }
        }
        return 0;
    }

    private int c2(int i2) {
        for (int iJ = J() - 1; iJ >= 0; iJ--) {
            int iG0 = g0(I(iJ));
            if (iG0 >= 0 && iG0 < i2) {
                return iG0;
            }
        }
        return 0;
    }

    private void d2(RecyclerView.v vVar, RecyclerView.z zVar, boolean z2) {
        int i2;
        int iH2 = h2(Target.SIZE_ORIGINAL);
        if (iH2 != Integer.MIN_VALUE && (i2 = this.f4073t.i() - iH2) > 0) {
            int i3 = i2 - (-B2(-i2, vVar, zVar));
            if (!z2 || i3 <= 0) {
                return;
            }
            this.f4073t.r(i3);
        }
    }

    private void e2(RecyclerView.v vVar, RecyclerView.z zVar, boolean z2) {
        int iM;
        int iK2 = k2(Integer.MAX_VALUE);
        if (iK2 != Integer.MAX_VALUE && (iM = iK2 - this.f4073t.m()) > 0) {
            int iB2 = iM - B2(iM, vVar, zVar);
            if (!z2 || iB2 <= 0) {
                return;
            }
            this.f4073t.r(-iB2);
        }
    }

    private int h2(int i2) {
        int iL = this.s[0].l(i2);
        for (int i3 = 1; i3 < this.r; i3++) {
            int iL2 = this.s[i3].l(i2);
            if (iL2 > iL) {
                iL = iL2;
            }
        }
        return iL;
    }

    private int i2(int i2) {
        int iP = this.s[0].p(i2);
        for (int i3 = 1; i3 < this.r; i3++) {
            int iP2 = this.s[i3].p(i2);
            if (iP2 > iP) {
                iP = iP2;
            }
        }
        return iP;
    }

    private int j2(int i2) {
        int iL = this.s[0].l(i2);
        for (int i3 = 1; i3 < this.r; i3++) {
            int iL2 = this.s[i3].l(i2);
            if (iL2 < iL) {
                iL = iL2;
            }
        }
        return iL;
    }

    private int k2(int i2) {
        int iP = this.s[0].p(i2);
        for (int i3 = 1; i3 < this.r; i3++) {
            int iP2 = this.s[i3].p(i2);
            if (iP2 < iP) {
                iP = iP2;
            }
        }
        return iP;
    }

    private f l2(i iVar) {
        int i2;
        int i3;
        int i4;
        if (t2(iVar.e)) {
            i3 = this.r - 1;
            i2 = -1;
            i4 = -1;
        } else {
            i2 = this.r;
            i3 = 0;
            i4 = 1;
        }
        f fVar = null;
        if (iVar.e == 1) {
            int iM = this.f4073t.m();
            int i5 = Integer.MAX_VALUE;
            while (i3 != i2) {
                f fVar2 = this.s[i3];
                int iL = fVar2.l(iM);
                if (iL < i5) {
                    fVar = fVar2;
                    i5 = iL;
                }
                i3 += i4;
            }
            return fVar;
        }
        int i6 = this.f4073t.i();
        int i7 = Target.SIZE_ORIGINAL;
        while (i3 != i2) {
            f fVar3 = this.s[i3];
            int iP = fVar3.p(i6);
            if (iP > i7) {
                fVar = fVar3;
                i7 = iP;
            }
            i3 += i4;
        }
        return fVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m2(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.f4079z
            if (r0 == 0) goto L9
            int r0 = r6.g2()
            goto Ld
        L9:
            int r0 = r6.f2()
        Ld:
            r1 = 8
            if (r9 != r1) goto L1b
            if (r7 >= r8) goto L17
            int r2 = r8 + 1
        L15:
            r3 = r7
            goto L1e
        L17:
            int r2 = r7 + 1
            r3 = r8
            goto L1e
        L1b:
            int r2 = r7 + r8
            goto L15
        L1e:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r4 = r6.f4061D
            r4.h(r3)
            r4 = 1
            if (r9 == r4) goto L3d
            r5 = 2
            if (r9 == r5) goto L37
            if (r9 == r1) goto L2c
            goto L42
        L2c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.f4061D
            r9.k(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r7 = r6.f4061D
            r7.j(r8, r4)
            goto L42
        L37:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.f4061D
            r9.k(r7, r8)
            goto L42
        L3d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.f4061D
            r9.j(r7, r8)
        L42:
            if (r2 > r0) goto L45
            return
        L45:
            boolean r7 = r6.f4079z
            if (r7 == 0) goto L4e
            int r7 = r6.f2()
            goto L52
        L4e:
            int r7 = r6.g2()
        L52:
            if (r3 > r7) goto L57
            r6.r1()
        L57:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.m2(int, int, int):void");
    }

    private void q2(View view, int i2, int i3, boolean z2) {
        j(view, this.f4067J);
        c cVar = (c) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
        Rect rect = this.f4067J;
        int iN2 = N2(i2, i4 + rect.left, ((ViewGroup.MarginLayoutParams) cVar).rightMargin + rect.right);
        int i5 = ((ViewGroup.MarginLayoutParams) cVar).topMargin;
        Rect rect2 = this.f4067J;
        int iN22 = N2(i3, i5 + rect2.top, ((ViewGroup.MarginLayoutParams) cVar).bottomMargin + rect2.bottom);
        if (z2 ? F1(view, iN2, iN22, cVar) : D1(view, iN2, iN22, cVar)) {
            view.measure(iN2, iN22);
        }
    }

    private void r2(View view, c cVar, boolean z2) {
        if (cVar.f4087f) {
            if (this.f4075v == 1) {
                q2(view, this.f4066I, RecyclerView.o.K(W(), X(), f0() + c0(), ((ViewGroup.MarginLayoutParams) cVar).height, true), z2);
                return;
            } else {
                q2(view, RecyclerView.o.K(n0(), o0(), d0() + e0(), ((ViewGroup.MarginLayoutParams) cVar).width, true), this.f4066I, z2);
                return;
            }
        }
        if (this.f4075v == 1) {
            q2(view, RecyclerView.o.K(this.f4076w, o0(), 0, ((ViewGroup.MarginLayoutParams) cVar).width, false), RecyclerView.o.K(W(), X(), f0() + c0(), ((ViewGroup.MarginLayoutParams) cVar).height, true), z2);
        } else {
            q2(view, RecyclerView.o.K(n0(), o0(), d0() + e0(), ((ViewGroup.MarginLayoutParams) cVar).width, true), RecyclerView.o.K(this.f4076w, X(), 0, ((ViewGroup.MarginLayoutParams) cVar).height, false), z2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x0155  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void s2(androidx.recyclerview.widget.RecyclerView.v r9, androidx.recyclerview.widget.RecyclerView.z r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.s2(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$z, boolean):void");
    }

    private boolean t2(int i2) {
        if (this.f4075v == 0) {
            return (i2 == -1) != this.f4079z;
        }
        return ((i2 == -1) == this.f4079z) == p2();
    }

    private void v2(View view) {
        for (int i2 = this.r - 1; i2 >= 0; i2--) {
            this.s[i2].u(view);
        }
    }

    private void w2(RecyclerView.v vVar, i iVar) {
        if (!iVar.f4267a || iVar.f4274i) {
            return;
        }
        if (iVar.f4268b == 0) {
            if (iVar.e == -1) {
                x2(vVar, iVar.f4272g);
                return;
            } else {
                y2(vVar, iVar.f4271f);
                return;
            }
        }
        if (iVar.e != -1) {
            int iJ2 = j2(iVar.f4272g) - iVar.f4272g;
            y2(vVar, iJ2 < 0 ? iVar.f4271f : Math.min(iJ2, iVar.f4268b) + iVar.f4271f);
        } else {
            int i2 = iVar.f4271f;
            int iI2 = i2 - i2(i2);
            x2(vVar, iI2 < 0 ? iVar.f4272g : iVar.f4272g - Math.min(iI2, iVar.f4268b));
        }
    }

    private void x2(RecyclerView.v vVar, int i2) {
        for (int iJ = J() - 1; iJ >= 0; iJ--) {
            View viewI = I(iJ);
            if (this.f4073t.g(viewI) < i2 || this.f4073t.q(viewI) < i2) {
                return;
            }
            c cVar = (c) viewI.getLayoutParams();
            if (cVar.f4087f) {
                for (int i3 = 0; i3 < this.r; i3++) {
                    if (this.s[i3].f4103a.size() == 1) {
                        return;
                    }
                }
                for (int i4 = 0; i4 < this.r; i4++) {
                    this.s[i4].s();
                }
            } else if (cVar.e.f4103a.size() == 1) {
                return;
            } else {
                cVar.e.s();
            }
            k1(viewI, vVar);
        }
    }

    private void y2(RecyclerView.v vVar, int i2) {
        while (J() > 0) {
            View viewI = I(0);
            if (this.f4073t.d(viewI) > i2 || this.f4073t.p(viewI) > i2) {
                return;
            }
            c cVar = (c) viewI.getLayoutParams();
            if (cVar.f4087f) {
                for (int i3 = 0; i3 < this.r; i3++) {
                    if (this.s[i3].f4103a.size() == 1) {
                        return;
                    }
                }
                for (int i4 = 0; i4 < this.r; i4++) {
                    this.s[i4].t();
                }
            } else if (cVar.e.f4103a.size() == 1) {
                return;
            } else {
                cVar.e.t();
            }
            k1(viewI, vVar);
        }
    }

    private void z2() {
        if (this.f4074u.k() == 1073741824) {
            return;
        }
        int iJ = J();
        float fMax = 0.0f;
        for (int i2 = 0; i2 < iJ; i2++) {
            View viewI = I(i2);
            float fE = this.f4074u.e(viewI);
            if (fE >= fMax) {
                if (((c) viewI.getLayoutParams()).f()) {
                    fE = (fE * 1.0f) / this.r;
                }
                fMax = Math.max(fMax, fE);
            }
        }
        int i3 = this.f4076w;
        int iRound = Math.round(fMax * this.r);
        if (this.f4074u.k() == Integer.MIN_VALUE) {
            iRound = Math.min(iRound, this.f4074u.n());
        }
        L2(iRound);
        if (this.f4076w == i3) {
            return;
        }
        for (int i4 = 0; i4 < iJ; i4++) {
            View viewI2 = I(i4);
            c cVar = (c) viewI2.getLayoutParams();
            if (!cVar.f4087f) {
                if (p2() && this.f4075v == 1) {
                    int i5 = this.r;
                    int i6 = cVar.e.e;
                    viewI2.offsetLeftAndRight(((-((i5 - 1) - i6)) * this.f4076w) - ((-((i5 - 1) - i6)) * i3));
                } else {
                    int i7 = cVar.e.e;
                    int i8 = this.f4076w * i7;
                    int i9 = i7 * i3;
                    if (this.f4075v == 1) {
                        viewI2.offsetLeftAndRight(i8 - i9);
                    } else {
                        viewI2.offsetTopAndBottom(i8 - i9);
                    }
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void A1(Rect rect, int i2, int i3) {
        int iN;
        int iN2;
        int iD0 = d0() + e0();
        int iF0 = f0() + c0();
        if (this.f4075v == 1) {
            iN2 = RecyclerView.o.n(i3, rect.height() + iF0, a0());
            iN = RecyclerView.o.n(i2, (this.f4076w * this.r) + iD0, b0());
        } else {
            iN = RecyclerView.o.n(i2, rect.width() + iD0, b0());
            iN2 = RecyclerView.o.n(i3, (this.f4076w * this.r) + iF0, a0());
        }
        z1(iN, iN2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void B0(int i2) {
        super.B0(i2);
        for (int i3 = 0; i3 < this.r; i3++) {
            this.s[i3].r(i2);
        }
    }

    int B2(int i2, RecyclerView.v vVar, RecyclerView.z zVar) {
        if (J() == 0 || i2 == 0) {
            return 0;
        }
        u2(i2, zVar);
        int iX1 = X1(vVar, this.f4077x, zVar);
        if (this.f4077x.f4268b >= iX1) {
            i2 = i2 < 0 ? -iX1 : iX1;
        }
        this.f4073t.r(-i2);
        this.f4063F = this.f4079z;
        i iVar = this.f4077x;
        iVar.f4268b = 0;
        w2(vVar, iVar);
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void C0(int i2) {
        super.C0(i2);
        for (int i3 = 0; i3 < this.r; i3++) {
            this.s[i3].r(i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p D() {
        return this.f4075v == 0 ? new c(-2, -1) : new c(-1, -2);
    }

    public void D2(int i2) {
        if (i2 != 0 && i2 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        g(null);
        if (i2 == this.f4075v) {
            return;
        }
        this.f4075v = i2;
        k kVar = this.f4073t;
        this.f4073t = this.f4074u;
        this.f4074u = kVar;
        r1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p E(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    public void E2(boolean z2) {
        g(null);
        e eVar = this.f4065H;
        if (eVar != null && eVar.f4100h != z2) {
            eVar.f4100h = z2;
        }
        this.f4078y = z2;
        r1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p F(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new c((ViewGroup.MarginLayoutParams) layoutParams) : new c(layoutParams);
    }

    public void F2(int i2) {
        g(null);
        if (i2 != this.r) {
            o2();
            this.r = i2;
            this.f4058A = new BitSet(this.r);
            this.s = new f[this.r];
            for (int i3 = 0; i3 < this.r; i3++) {
                this.s[i3] = new f(i3);
            }
            r1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void H0(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.H0(recyclerView, vVar);
        m1(this.f4072O);
        for (int i2 = 0; i2 < this.r; i2++) {
            this.s[i2].e();
        }
        recyclerView.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean H1() {
        return this.f4065H == null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View I0(View view, int i2, RecyclerView.v vVar, RecyclerView.z zVar) {
        View viewB;
        View viewM;
        if (J() == 0 || (viewB = B(view)) == null) {
            return null;
        }
        A2();
        int iT1 = T1(i2);
        if (iT1 == Integer.MIN_VALUE) {
            return null;
        }
        c cVar = (c) viewB.getLayoutParams();
        boolean z2 = cVar.f4087f;
        f fVar = cVar.e;
        int iG2 = iT1 == 1 ? g2() : f2();
        K2(iG2, zVar);
        C2(iT1);
        i iVar = this.f4077x;
        iVar.f4269c = iVar.f4270d + iG2;
        iVar.f4268b = (int) (this.f4073t.n() * 0.33333334f);
        i iVar2 = this.f4077x;
        iVar2.f4273h = true;
        iVar2.f4267a = false;
        X1(vVar, iVar2, zVar);
        this.f4063F = this.f4079z;
        if (!z2 && (viewM = fVar.m(iG2, iT1)) != null && viewM != viewB) {
            return viewM;
        }
        if (t2(iT1)) {
            for (int i3 = this.r - 1; i3 >= 0; i3--) {
                View viewM2 = this.s[i3].m(iG2, iT1);
                if (viewM2 != null && viewM2 != viewB) {
                    return viewM2;
                }
            }
        } else {
            for (int i4 = 0; i4 < this.r; i4++) {
                View viewM3 = this.s[i4].m(iG2, iT1);
                if (viewM3 != null && viewM3 != viewB) {
                    return viewM3;
                }
            }
        }
        boolean z3 = (this.f4078y ^ true) == (iT1 == -1);
        if (!z2) {
            View viewC = C(z3 ? fVar.f() : fVar.g());
            if (viewC != null && viewC != viewB) {
                return viewC;
            }
        }
        if (t2(iT1)) {
            for (int i5 = this.r - 1; i5 >= 0; i5--) {
                if (i5 != fVar.e) {
                    View viewC2 = C(z3 ? this.s[i5].f() : this.s[i5].g());
                    if (viewC2 != null && viewC2 != viewB) {
                        return viewC2;
                    }
                }
            }
        } else {
            for (int i6 = 0; i6 < this.r; i6++) {
                View viewC3 = C(z3 ? this.s[i6].f() : this.s[i6].g());
                if (viewC3 != null && viewC3 != viewB) {
                    return viewC3;
                }
            }
        }
        return null;
    }

    boolean I2(RecyclerView.z zVar, b bVar) {
        int i2;
        if (!zVar.e() && (i2 = this.f4059B) != -1) {
            if (i2 >= 0 && i2 < zVar.b()) {
                e eVar = this.f4065H;
                if (eVar == null || eVar.f4094a == -1 || eVar.f4096c < 1) {
                    View viewC = C(this.f4059B);
                    if (viewC != null) {
                        bVar.f4081a = this.f4079z ? g2() : f2();
                        if (this.f4060C != Integer.MIN_VALUE) {
                            if (bVar.f4083c) {
                                bVar.f4082b = (this.f4073t.i() - this.f4060C) - this.f4073t.d(viewC);
                            } else {
                                bVar.f4082b = (this.f4073t.m() + this.f4060C) - this.f4073t.g(viewC);
                            }
                            return true;
                        }
                        if (this.f4073t.e(viewC) > this.f4073t.n()) {
                            bVar.f4082b = bVar.f4083c ? this.f4073t.i() : this.f4073t.m();
                            return true;
                        }
                        int iG = this.f4073t.g(viewC) - this.f4073t.m();
                        if (iG < 0) {
                            bVar.f4082b = -iG;
                            return true;
                        }
                        int i3 = this.f4073t.i() - this.f4073t.d(viewC);
                        if (i3 < 0) {
                            bVar.f4082b = i3;
                            return true;
                        }
                        bVar.f4082b = Target.SIZE_ORIGINAL;
                    } else {
                        int i4 = this.f4059B;
                        bVar.f4081a = i4;
                        int i5 = this.f4060C;
                        if (i5 == Integer.MIN_VALUE) {
                            bVar.f4083c = N1(i4) == 1;
                            bVar.a();
                        } else {
                            bVar.b(i5);
                        }
                        bVar.f4084d = true;
                    }
                } else {
                    bVar.f4082b = Target.SIZE_ORIGINAL;
                    bVar.f4081a = this.f4059B;
                }
                return true;
            }
            this.f4059B = -1;
            this.f4060C = Target.SIZE_ORIGINAL;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void J0(AccessibilityEvent accessibilityEvent) {
        super.J0(accessibilityEvent);
        if (J() > 0) {
            View viewA2 = a2(false);
            View viewZ1 = Z1(false);
            if (viewA2 == null || viewZ1 == null) {
                return;
            }
            int iG0 = g0(viewA2);
            int iG02 = g0(viewZ1);
            if (iG0 < iG02) {
                accessibilityEvent.setFromIndex(iG0);
                accessibilityEvent.setToIndex(iG02);
            } else {
                accessibilityEvent.setFromIndex(iG02);
                accessibilityEvent.setToIndex(iG0);
            }
        }
    }

    void J2(RecyclerView.z zVar, b bVar) {
        if (I2(zVar, bVar) || H2(zVar, bVar)) {
            return;
        }
        bVar.a();
        bVar.f4081a = 0;
    }

    boolean K1() {
        int iL = this.s[0].l(Target.SIZE_ORIGINAL);
        for (int i2 = 1; i2 < this.r; i2++) {
            if (this.s[i2].l(Target.SIZE_ORIGINAL) != iL) {
                return false;
            }
        }
        return true;
    }

    boolean L1() {
        int iP = this.s[0].p(Target.SIZE_ORIGINAL);
        for (int i2 = 1; i2 < this.r; i2++) {
            if (this.s[i2].p(Target.SIZE_ORIGINAL) != iP) {
                return false;
            }
        }
        return true;
    }

    void L2(int i2) {
        this.f4076w = i2 / this.r;
        this.f4066I = View.MeasureSpec.makeMeasureSpec(i2, this.f4074u.k());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int N(RecyclerView.v vVar, RecyclerView.z zVar) {
        return this.f4075v == 1 ? this.r : super.N(vVar, zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void O0(RecyclerView.v vVar, RecyclerView.z zVar, View view, C0353E c0353e) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof c)) {
            super.N0(view, c0353e);
            return;
        }
        c cVar = (c) layoutParams;
        if (this.f4075v == 0) {
            int iE = cVar.e();
            boolean z2 = cVar.f4087f;
            c0353e.a0(C0353E.f.a(iE, z2 ? this.r : 1, -1, -1, z2, false));
        } else {
            int iE2 = cVar.e();
            boolean z3 = cVar.f4087f;
            c0353e.a0(C0353E.f.a(-1, -1, iE2, z3 ? this.r : 1, z3, false));
        }
    }

    boolean O1() {
        int iF2;
        int iG2;
        if (J() == 0 || this.f4062E == 0 || !q0()) {
            return false;
        }
        if (this.f4079z) {
            iF2 = g2();
            iG2 = f2();
        } else {
            iF2 = f2();
            iG2 = g2();
        }
        if (iF2 == 0 && n2() != null) {
            this.f4061D.b();
            s1();
            r1();
            return true;
        }
        if (!this.f4069L) {
            return false;
        }
        int i2 = this.f4079z ? -1 : 1;
        int i3 = iG2 + 1;
        d.a aVarE = this.f4061D.e(iF2, i3, i2, true);
        if (aVarE == null) {
            this.f4069L = false;
            this.f4061D.d(i3);
            return false;
        }
        d.a aVarE2 = this.f4061D.e(iF2, aVarE.f4090a, i2 * (-1), true);
        if (aVarE2 == null) {
            this.f4061D.d(aVarE.f4090a);
        } else {
            this.f4061D.d(aVarE2.f4090a + 1);
        }
        s1();
        r1();
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Q0(RecyclerView recyclerView, int i2, int i3) {
        m2(i2, i3, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void R0(RecyclerView recyclerView) {
        this.f4061D.b();
        r1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void S0(RecyclerView recyclerView, int i2, int i3, int i4) {
        m2(i2, i3, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void T0(RecyclerView recyclerView, int i2, int i3) {
        m2(i2, i3, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void V0(RecyclerView recyclerView, int i2, int i3, Object obj) {
        m2(i2, i3, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void W0(RecyclerView.v vVar, RecyclerView.z zVar) {
        s2(vVar, zVar, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView.z zVar) {
        super.X0(zVar);
        this.f4059B = -1;
        this.f4060C = Target.SIZE_ORIGINAL;
        this.f4065H = null;
        this.f4068K.c();
    }

    View Z1(boolean z2) {
        int iM = this.f4073t.m();
        int i2 = this.f4073t.i();
        View view = null;
        for (int iJ = J() - 1; iJ >= 0; iJ--) {
            View viewI = I(iJ);
            int iG = this.f4073t.g(viewI);
            int iD = this.f4073t.d(viewI);
            if (iD > iM && iG < i2) {
                if (iD <= i2 || !z2) {
                    return viewI;
                }
                if (view == null) {
                    view = viewI;
                }
            }
        }
        return view;
    }

    View a2(boolean z2) {
        int iM = this.f4073t.m();
        int i2 = this.f4073t.i();
        int iJ = J();
        View view = null;
        for (int i3 = 0; i3 < iJ; i3++) {
            View viewI = I(i3);
            int iG = this.f4073t.g(viewI);
            if (this.f4073t.d(viewI) > iM && iG < i2) {
                if (iG >= iM || !z2) {
                    return viewI;
                }
                if (view == null) {
                    view = viewI;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void b1(Parcelable parcelable) {
        if (parcelable instanceof e) {
            this.f4065H = (e) parcelable;
            r1();
        }
    }

    int b2() {
        View viewZ1 = this.f4079z ? Z1(true) : a2(true);
        if (viewZ1 == null) {
            return -1;
        }
        return g0(viewZ1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable c1() {
        int iP;
        int iM;
        int[] iArr;
        if (this.f4065H != null) {
            return new e(this.f4065H);
        }
        e eVar = new e();
        eVar.f4100h = this.f4078y;
        eVar.f4101i = this.f4063F;
        eVar.f4102j = this.f4064G;
        d dVar = this.f4061D;
        if (dVar == null || (iArr = dVar.f4088a) == null) {
            eVar.e = 0;
        } else {
            eVar.f4098f = iArr;
            eVar.e = iArr.length;
            eVar.f4099g = dVar.f4089b;
        }
        if (J() > 0) {
            eVar.f4094a = this.f4063F ? g2() : f2();
            eVar.f4095b = b2();
            int i2 = this.r;
            eVar.f4096c = i2;
            eVar.f4097d = new int[i2];
            for (int i3 = 0; i3 < this.r; i3++) {
                if (this.f4063F) {
                    iP = this.s[i3].l(Target.SIZE_ORIGINAL);
                    if (iP != Integer.MIN_VALUE) {
                        iM = this.f4073t.i();
                        iP -= iM;
                    }
                } else {
                    iP = this.s[i3].p(Target.SIZE_ORIGINAL);
                    if (iP != Integer.MIN_VALUE) {
                        iM = this.f4073t.m();
                        iP -= iM;
                    }
                }
                eVar.f4097d[i3] = iP;
            }
        } else {
            eVar.f4094a = -1;
            eVar.f4095b = -1;
            eVar.f4096c = 0;
        }
        return eVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void d1(int i2) {
        if (i2 == 0) {
            O1();
        }
    }

    int f2() {
        if (J() == 0) {
            return 0;
        }
        return g0(I(0));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void g(String str) {
        if (this.f4065H == null) {
            super.g(str);
        }
    }

    int g2() {
        int iJ = J();
        if (iJ == 0) {
            return 0;
        }
        return g0(I(iJ - 1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int j0(RecyclerView.v vVar, RecyclerView.z zVar) {
        return this.f4075v == 0 ? this.r : super.j0(vVar, zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean k() {
        return this.f4075v == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean l() {
        return this.f4075v == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean m(RecyclerView.p pVar) {
        return pVar instanceof c;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    android.view.View n2() {
        /*
            r12 = this;
            int r0 = r12.J()
            int r1 = r0 + (-1)
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.r
            r2.<init>(r3)
            int r3 = r12.r
            r4 = 0
            r5 = 1
            r2.set(r4, r3, r5)
            int r3 = r12.f4075v
            r6 = -1
            if (r3 != r5) goto L21
            boolean r3 = r12.p2()
            if (r3 == 0) goto L21
            r3 = 1
            goto L22
        L21:
            r3 = -1
        L22:
            boolean r7 = r12.f4079z
            if (r7 == 0) goto L28
            r0 = -1
            goto L29
        L28:
            r1 = 0
        L29:
            if (r1 >= r0) goto L2c
            r6 = 1
        L2c:
            if (r1 == r0) goto La4
            android.view.View r7 = r12.I(r1)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.c) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.e
            int r9 = r9.e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L52
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.e
            boolean r9 = r12.P1(r9)
            if (r9 == 0) goto L4b
            return r7
        L4b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.e
            int r9 = r9.e
            r2.clear(r9)
        L52:
            boolean r9 = r8.f4087f
            if (r9 == 0) goto L57
            goto La2
        L57:
            int r9 = r1 + r6
            if (r9 == r0) goto La2
            android.view.View r9 = r12.I(r9)
            boolean r10 = r12.f4079z
            if (r10 == 0) goto L75
            androidx.recyclerview.widget.k r10 = r12.f4073t
            int r10 = r10.d(r7)
            androidx.recyclerview.widget.k r11 = r12.f4073t
            int r11 = r11.d(r9)
            if (r10 >= r11) goto L72
            return r7
        L72:
            if (r10 != r11) goto La2
            goto L86
        L75:
            androidx.recyclerview.widget.k r10 = r12.f4073t
            int r10 = r10.g(r7)
            androidx.recyclerview.widget.k r11 = r12.f4073t
            int r11 = r11.g(r9)
            if (r10 <= r11) goto L84
            return r7
        L84:
            if (r10 != r11) goto La2
        L86:
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.c) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r8 = r8.e
            int r8 = r8.e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r9.e
            int r9 = r9.e
            int r8 = r8 - r9
            if (r8 >= 0) goto L99
            r8 = 1
            goto L9a
        L99:
            r8 = 0
        L9a:
            if (r3 >= 0) goto L9e
            r9 = 1
            goto L9f
        L9e:
            r9 = 0
        L9f:
            if (r8 == r9) goto La2
            return r7
        La2:
            int r1 = r1 + r6
            goto L2c
        La4:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.n2():android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void o(int i2, int i3, RecyclerView.z zVar, RecyclerView.o.c cVar) {
        int iL;
        int iP;
        if (this.f4075v != 0) {
            i2 = i3;
        }
        if (J() == 0 || i2 == 0) {
            return;
        }
        u2(i2, zVar);
        int[] iArr = this.f4071N;
        if (iArr == null || iArr.length < this.r) {
            this.f4071N = new int[this.r];
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.r; i5++) {
            i iVar = this.f4077x;
            if (iVar.f4270d == -1) {
                iL = iVar.f4271f;
                iP = this.s[i5].p(iL);
            } else {
                iL = this.s[i5].l(iVar.f4272g);
                iP = this.f4077x.f4272g;
            }
            int i6 = iL - iP;
            if (i6 >= 0) {
                this.f4071N[i4] = i6;
                i4++;
            }
        }
        Arrays.sort(this.f4071N, 0, i4);
        for (int i7 = 0; i7 < i4 && this.f4077x.a(zVar); i7++) {
            cVar.a(this.f4077x.f4269c, this.f4071N[i7]);
            i iVar2 = this.f4077x;
            iVar2.f4269c += iVar2.f4270d;
        }
    }

    public void o2() {
        this.f4061D.b();
        r1();
    }

    boolean p2() {
        return Y() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int q(RecyclerView.z zVar) {
        return Q1(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int r(RecyclerView.z zVar) {
        return R1(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean r0() {
        return this.f4062E != 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int s(RecyclerView.z zVar) {
        return S1(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int t(RecyclerView.z zVar) {
        return Q1(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int u(RecyclerView.z zVar) {
        return R1(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int u1(int i2, RecyclerView.v vVar, RecyclerView.z zVar) {
        return B2(i2, vVar, zVar);
    }

    void u2(int i2, RecyclerView.z zVar) {
        int iF2;
        int i3;
        if (i2 > 0) {
            iF2 = g2();
            i3 = 1;
        } else {
            iF2 = f2();
            i3 = -1;
        }
        this.f4077x.f4267a = true;
        K2(iF2, zVar);
        C2(i3);
        i iVar = this.f4077x;
        iVar.f4269c = iF2 + iVar.f4270d;
        iVar.f4268b = Math.abs(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int v(RecyclerView.z zVar) {
        return S1(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void v1(int i2) {
        e eVar = this.f4065H;
        if (eVar != null && eVar.f4094a != i2) {
            eVar.a();
        }
        this.f4059B = i2;
        this.f4060C = Target.SIZE_ORIGINAL;
        r1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int w1(int i2, RecyclerView.v vVar, RecyclerView.z zVar) {
        return B2(i2, vVar, zVar);
    }

    static class d {

        /* renamed from: a, reason: collision with root package name */
        int[] f4088a;

        /* renamed from: b, reason: collision with root package name */
        List f4089b;

        d() {
        }

        private int i(int i2) {
            if (this.f4089b == null) {
                return -1;
            }
            a aVarF = f(i2);
            if (aVarF != null) {
                this.f4089b.remove(aVarF);
            }
            int size = this.f4089b.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    i3 = -1;
                    break;
                }
                if (((a) this.f4089b.get(i3)).f4090a >= i2) {
                    break;
                }
                i3++;
            }
            if (i3 == -1) {
                return -1;
            }
            a aVar = (a) this.f4089b.get(i3);
            this.f4089b.remove(i3);
            return aVar.f4090a;
        }

        private void l(int i2, int i3) {
            List list = this.f4089b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = (a) this.f4089b.get(size);
                int i4 = aVar.f4090a;
                if (i4 >= i2) {
                    aVar.f4090a = i4 + i3;
                }
            }
        }

        private void m(int i2, int i3) {
            List list = this.f4089b;
            if (list == null) {
                return;
            }
            int i4 = i2 + i3;
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = (a) this.f4089b.get(size);
                int i5 = aVar.f4090a;
                if (i5 >= i2) {
                    if (i5 < i4) {
                        this.f4089b.remove(size);
                    } else {
                        aVar.f4090a = i5 - i3;
                    }
                }
            }
        }

        public void a(a aVar) {
            if (this.f4089b == null) {
                this.f4089b = new ArrayList();
            }
            int size = this.f4089b.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar2 = (a) this.f4089b.get(i2);
                if (aVar2.f4090a == aVar.f4090a) {
                    this.f4089b.remove(i2);
                }
                if (aVar2.f4090a >= aVar.f4090a) {
                    this.f4089b.add(i2, aVar);
                    return;
                }
            }
            this.f4089b.add(aVar);
        }

        void b() {
            int[] iArr = this.f4088a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f4089b = null;
        }

        void c(int i2) {
            int[] iArr = this.f4088a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i2, 10) + 1];
                this.f4088a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i2 >= iArr.length) {
                int[] iArr3 = new int[o(i2)];
                this.f4088a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f4088a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        int d(int i2) {
            List list = this.f4089b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (((a) this.f4089b.get(size)).f4090a >= i2) {
                        this.f4089b.remove(size);
                    }
                }
            }
            return h(i2);
        }

        public a e(int i2, int i3, int i4, boolean z2) {
            List list = this.f4089b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                a aVar = (a) this.f4089b.get(i5);
                int i6 = aVar.f4090a;
                if (i6 >= i3) {
                    return null;
                }
                if (i6 >= i2 && (i4 == 0 || aVar.f4091b == i4 || (z2 && aVar.f4093d))) {
                    return aVar;
                }
            }
            return null;
        }

        public a f(int i2) {
            List list = this.f4089b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = (a) this.f4089b.get(size);
                if (aVar.f4090a == i2) {
                    return aVar;
                }
            }
            return null;
        }

        int g(int i2) {
            int[] iArr = this.f4088a;
            if (iArr == null || i2 >= iArr.length) {
                return -1;
            }
            return iArr[i2];
        }

        int h(int i2) {
            int[] iArr = this.f4088a;
            if (iArr == null || i2 >= iArr.length) {
                return -1;
            }
            int i3 = i(i2);
            if (i3 == -1) {
                int[] iArr2 = this.f4088a;
                Arrays.fill(iArr2, i2, iArr2.length, -1);
                return this.f4088a.length;
            }
            int i4 = i3 + 1;
            Arrays.fill(this.f4088a, i2, i4, -1);
            return i4;
        }

        void j(int i2, int i3) {
            int[] iArr = this.f4088a;
            if (iArr == null || i2 >= iArr.length) {
                return;
            }
            int i4 = i2 + i3;
            c(i4);
            int[] iArr2 = this.f4088a;
            System.arraycopy(iArr2, i2, iArr2, i4, (iArr2.length - i2) - i3);
            Arrays.fill(this.f4088a, i2, i4, -1);
            l(i2, i3);
        }

        void k(int i2, int i3) {
            int[] iArr = this.f4088a;
            if (iArr == null || i2 >= iArr.length) {
                return;
            }
            int i4 = i2 + i3;
            c(i4);
            int[] iArr2 = this.f4088a;
            System.arraycopy(iArr2, i4, iArr2, i2, (iArr2.length - i2) - i3);
            int[] iArr3 = this.f4088a;
            Arrays.fill(iArr3, iArr3.length - i3, iArr3.length, -1);
            m(i2, i3);
        }

        void n(int i2, f fVar) {
            c(i2);
            this.f4088a[i2] = fVar.e;
        }

        int o(int i2) {
            int length = this.f4088a.length;
            while (length <= i2) {
                length *= 2;
            }
            return length;
        }

        static class a implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new C0049a();

            /* renamed from: a, reason: collision with root package name */
            int f4090a;

            /* renamed from: b, reason: collision with root package name */
            int f4091b;

            /* renamed from: c, reason: collision with root package name */
            int[] f4092c;

            /* renamed from: d, reason: collision with root package name */
            boolean f4093d;

            /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a$a, reason: collision with other inner class name */
            static class C0049a implements Parcelable.Creator {
                C0049a() {
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public a createFromParcel(Parcel parcel) {
                    return new a(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public a[] newArray(int i2) {
                    return new a[i2];
                }
            }

            a(Parcel parcel) {
                this.f4090a = parcel.readInt();
                this.f4091b = parcel.readInt();
                this.f4093d = parcel.readInt() == 1;
                int i2 = parcel.readInt();
                if (i2 > 0) {
                    int[] iArr = new int[i2];
                    this.f4092c = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            int a(int i2) {
                int[] iArr = this.f4092c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i2];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f4090a + ", mGapDir=" + this.f4091b + ", mHasUnwantedGapAfter=" + this.f4093d + ", mGapPerSpan=" + Arrays.toString(this.f4092c) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i2) {
                parcel.writeInt(this.f4090a);
                parcel.writeInt(this.f4091b);
                parcel.writeInt(this.f4093d ? 1 : 0);
                int[] iArr = this.f4092c;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.f4092c);
                }
            }

            a() {
            }
        }
    }
}
