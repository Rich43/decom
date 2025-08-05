package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
final class e implements Runnable {
    static final ThreadLocal e = new ThreadLocal();

    /* renamed from: f, reason: collision with root package name */
    static Comparator f4201f = new a();

    /* renamed from: b, reason: collision with root package name */
    long f4203b;

    /* renamed from: c, reason: collision with root package name */
    long f4204c;

    /* renamed from: a, reason: collision with root package name */
    ArrayList f4202a = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private ArrayList f4205d = new ArrayList();

    static class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            RecyclerView recyclerView = cVar.f4213d;
            if ((recyclerView == null) != (cVar2.f4213d == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z2 = cVar.f4210a;
            if (z2 != cVar2.f4210a) {
                return z2 ? -1 : 1;
            }
            int i2 = cVar2.f4211b - cVar.f4211b;
            if (i2 != 0) {
                return i2;
            }
            int i3 = cVar.f4212c - cVar2.f4212c;
            if (i3 != 0) {
                return i3;
            }
            return 0;
        }
    }

    static class b implements RecyclerView.o.c {

        /* renamed from: a, reason: collision with root package name */
        int f4206a;

        /* renamed from: b, reason: collision with root package name */
        int f4207b;

        /* renamed from: c, reason: collision with root package name */
        int[] f4208c;

        /* renamed from: d, reason: collision with root package name */
        int f4209d;

        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o.c
        public void a(int i2, int i3) {
            if (i2 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i3 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i4 = this.f4209d;
            int i5 = i4 * 2;
            int[] iArr = this.f4208c;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.f4208c = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i5 >= iArr.length) {
                int[] iArr3 = new int[i4 * 4];
                this.f4208c = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.f4208c;
            iArr4[i5] = i2;
            iArr4[i5 + 1] = i3;
            this.f4209d++;
        }

        void b() {
            int[] iArr = this.f4208c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f4209d = 0;
        }

        void c(RecyclerView recyclerView, boolean z2) {
            this.f4209d = 0;
            int[] iArr = this.f4208c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.o oVar = recyclerView.f3943m;
            if (recyclerView.f3941l == null || oVar == null || !oVar.t0()) {
                return;
            }
            if (z2) {
                if (!recyclerView.f3926d.p()) {
                    oVar.p(recyclerView.f3941l.c(), this);
                }
            } else if (!recyclerView.n0()) {
                oVar.o(this.f4206a, this.f4207b, recyclerView.f3930f0, this);
            }
            int i2 = this.f4209d;
            if (i2 > oVar.f4013l) {
                oVar.f4013l = i2;
                oVar.f4014m = z2;
                recyclerView.f3922b.K();
            }
        }

        boolean d(int i2) {
            if (this.f4208c != null) {
                int i3 = this.f4209d * 2;
                for (int i4 = 0; i4 < i3; i4 += 2) {
                    if (this.f4208c[i4] == i2) {
                        return true;
                    }
                }
            }
            return false;
        }

        void e(int i2, int i3) {
            this.f4206a = i2;
            this.f4207b = i3;
        }
    }

    static class c {

        /* renamed from: a, reason: collision with root package name */
        public boolean f4210a;

        /* renamed from: b, reason: collision with root package name */
        public int f4211b;

        /* renamed from: c, reason: collision with root package name */
        public int f4212c;

        /* renamed from: d, reason: collision with root package name */
        public RecyclerView f4213d;
        public int e;

        c() {
        }

        public void a() {
            this.f4210a = false;
            this.f4211b = 0;
            this.f4212c = 0;
            this.f4213d = null;
            this.e = 0;
        }
    }

    e() {
    }

    private void b() {
        c cVar;
        int size = this.f4202a.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            RecyclerView recyclerView = (RecyclerView) this.f4202a.get(i3);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.f3928e0.c(recyclerView, false);
                i2 += recyclerView.f3928e0.f4209d;
            }
        }
        this.f4205d.ensureCapacity(i2);
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView recyclerView2 = (RecyclerView) this.f4202a.get(i5);
            if (recyclerView2.getWindowVisibility() == 0) {
                b bVar = recyclerView2.f3928e0;
                int iAbs = Math.abs(bVar.f4206a) + Math.abs(bVar.f4207b);
                for (int i6 = 0; i6 < bVar.f4209d * 2; i6 += 2) {
                    if (i4 >= this.f4205d.size()) {
                        cVar = new c();
                        this.f4205d.add(cVar);
                    } else {
                        cVar = (c) this.f4205d.get(i4);
                    }
                    int[] iArr = bVar.f4208c;
                    int i7 = iArr[i6 + 1];
                    cVar.f4210a = i7 <= iAbs;
                    cVar.f4211b = iAbs;
                    cVar.f4212c = i7;
                    cVar.f4213d = recyclerView2;
                    cVar.e = iArr[i6];
                    i4++;
                }
            }
        }
        Collections.sort(this.f4205d, f4201f);
    }

    private void c(c cVar, long j2) {
        RecyclerView.C cI = i(cVar.f4213d, cVar.e, cVar.f4210a ? Long.MAX_VALUE : j2);
        if (cI == null || cI.f3972b == null || !cI.r() || cI.s()) {
            return;
        }
        h((RecyclerView) cI.f3972b.get(), j2);
    }

    private void d(long j2) {
        for (int i2 = 0; i2 < this.f4205d.size(); i2++) {
            c cVar = (c) this.f4205d.get(i2);
            if (cVar.f4213d == null) {
                return;
            }
            c(cVar, j2);
            cVar.a();
        }
    }

    static boolean e(RecyclerView recyclerView, int i2) {
        int iJ = recyclerView.e.j();
        for (int i3 = 0; i3 < iJ; i3++) {
            RecyclerView.C cG0 = RecyclerView.g0(recyclerView.e.i(i3));
            if (cG0.f3973c == i2 && !cG0.s()) {
                return true;
            }
        }
        return false;
    }

    private void h(RecyclerView recyclerView, long j2) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.f3899C && recyclerView.e.j() != 0) {
            recyclerView.U0();
        }
        b bVar = recyclerView.f3928e0;
        bVar.c(recyclerView, true);
        if (bVar.f4209d != 0) {
            try {
                androidx.core.os.o.a("RV Nested Prefetch");
                recyclerView.f3930f0.f(recyclerView.f3941l);
                for (int i2 = 0; i2 < bVar.f4209d * 2; i2 += 2) {
                    i(recyclerView, bVar.f4208c[i2], j2);
                }
            } finally {
                androidx.core.os.o.b();
            }
        }
    }

    private RecyclerView.C i(RecyclerView recyclerView, int i2, long j2) {
        if (e(recyclerView, i2)) {
            return null;
        }
        RecyclerView.v vVar = recyclerView.f3922b;
        try {
            recyclerView.G0();
            RecyclerView.C cI = vVar.I(i2, false, j2);
            if (cI != null) {
                if (!cI.r() || cI.s()) {
                    vVar.a(cI, false);
                } else {
                    vVar.B(cI.f3971a);
                }
            }
            recyclerView.I0(false);
            return cI;
        } catch (Throwable th) {
            recyclerView.I0(false);
            throw th;
        }
    }

    public void a(RecyclerView recyclerView) {
        this.f4202a.add(recyclerView);
    }

    void f(RecyclerView recyclerView, int i2, int i3) {
        if (recyclerView.isAttachedToWindow() && this.f4203b == 0) {
            this.f4203b = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.f3928e0.e(i2, i3);
    }

    void g(long j2) {
        b();
        d(j2);
    }

    public void j(RecyclerView recyclerView) {
        this.f4202a.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            androidx.core.os.o.a("RV Prefetch");
            if (!this.f4202a.isEmpty()) {
                int size = this.f4202a.size();
                long jMax = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    RecyclerView recyclerView = (RecyclerView) this.f4202a.get(i2);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    g(TimeUnit.MILLISECONDS.toNanos(jMax) + this.f4204c);
                    this.f4203b = 0L;
                    androidx.core.os.o.b();
                }
            }
        } finally {
            this.f4203b = 0L;
            androidx.core.os.o.b();
        }
    }
}
