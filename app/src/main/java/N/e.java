package n;

import defpackage.o;
import java.util.Arrays;
import java.util.HashMap;
import n.i;

/* loaded from: classes.dex */
public class e {

    /* renamed from: q, reason: collision with root package name */
    private static int f6724q = 1000;
    public static final /* synthetic */ int r = 0;

    /* renamed from: c, reason: collision with root package name */
    private a f6727c;

    /* renamed from: f, reason: collision with root package name */
    C0294b[] f6729f;

    /* renamed from: l, reason: collision with root package name */
    final C0295c f6735l;

    /* renamed from: p, reason: collision with root package name */
    private final a f6738p;

    /* renamed from: a, reason: collision with root package name */
    int f6725a = 0;

    /* renamed from: b, reason: collision with root package name */
    private HashMap f6726b = null;

    /* renamed from: d, reason: collision with root package name */
    private int f6728d = 32;
    private int e = 32;

    /* renamed from: g, reason: collision with root package name */
    public boolean f6730g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean[] f6731h = new boolean[32];

    /* renamed from: i, reason: collision with root package name */
    int f6732i = 1;

    /* renamed from: j, reason: collision with root package name */
    int f6733j = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f6734k = 32;

    /* renamed from: m, reason: collision with root package name */
    private i[] f6736m = new i[f6724q];

    /* renamed from: n, reason: collision with root package name */
    private int f6737n = 0;
    private C0294b[] o = new C0294b[32];

    interface a {
        i a(e eVar, boolean[] zArr);

        void b(i iVar);

        void c(a aVar);

        void clear();

        i getKey();
    }

    public e() {
        this.f6729f = null;
        this.f6729f = new C0294b[32];
        D();
        C0295c c0295c = new C0295c();
        this.f6735l = c0295c;
        this.f6727c = new d(c0295c);
        this.f6738p = new C0294b(c0295c);
    }

    private final int C(a aVar, boolean z2) {
        for (int i2 = 0; i2 < this.f6732i; i2++) {
            this.f6731h[i2] = false;
        }
        boolean z3 = false;
        int i3 = 0;
        while (!z3) {
            i3++;
            if (i3 >= this.f6732i * 2) {
                return i3;
            }
            if (aVar.getKey() != null) {
                this.f6731h[aVar.getKey().f6743b] = true;
            }
            i iVarA = aVar.a(this, this.f6731h);
            if (iVarA != null) {
                boolean[] zArr = this.f6731h;
                int i4 = iVarA.f6743b;
                if (zArr[i4]) {
                    return i3;
                }
                zArr[i4] = true;
            }
            if (iVarA != null) {
                float f2 = Float.MAX_VALUE;
                int i5 = -1;
                for (int i6 = 0; i6 < this.f6733j; i6++) {
                    C0294b c0294b = this.f6729f[i6];
                    if (c0294b.f6717a.f6747g != i.a.UNRESTRICTED && !c0294b.e && c0294b.s(iVarA)) {
                        float f3 = c0294b.f6720d.f(iVarA);
                        if (f3 < 0.0f) {
                            float f4 = (-c0294b.f6718b) / f3;
                            if (f4 < f2) {
                                i5 = i6;
                                f2 = f4;
                            }
                        }
                    }
                }
                if (i5 > -1) {
                    C0294b c0294b2 = this.f6729f[i5];
                    c0294b2.f6717a.f6744c = -1;
                    c0294b2.v(iVarA);
                    i iVar = c0294b2.f6717a;
                    iVar.f6744c = i5;
                    iVar.f(c0294b2);
                }
            }
            z3 = true;
        }
        return i3;
    }

    private void D() {
        int i2 = 0;
        while (true) {
            C0294b[] c0294bArr = this.f6729f;
            if (i2 >= c0294bArr.length) {
                return;
            }
            C0294b c0294b = c0294bArr[i2];
            if (c0294b != null) {
                this.f6735l.f6721a.release(c0294b);
            }
            this.f6729f[i2] = null;
            i2++;
        }
    }

    private final void F(C0294b c0294b) {
        if (this.f6733j > 0) {
            c0294b.f6720d.o(c0294b, this.f6729f);
            if (c0294b.f6720d.f6707a == 0) {
                c0294b.e = true;
            }
        }
    }

    private i a(i.a aVar, String str) {
        i iVar = (i) this.f6735l.f6722b.acquire();
        if (iVar == null) {
            iVar = new i(aVar, str);
            iVar.e(aVar, str);
        } else {
            iVar.d();
            iVar.e(aVar, str);
        }
        int i2 = this.f6737n;
        int i3 = f6724q;
        if (i2 >= i3) {
            int i4 = i3 * 2;
            f6724q = i4;
            this.f6736m = (i[]) Arrays.copyOf(this.f6736m, i4);
        }
        i[] iVarArr = this.f6736m;
        int i5 = this.f6737n;
        this.f6737n = i5 + 1;
        iVarArr[i5] = iVar;
        return iVar;
    }

    private void g(C0294b c0294b) {
        c0294b.d(this, 0);
    }

    private final void m(C0294b c0294b) {
        C0294b c0294b2 = this.f6729f[this.f6733j];
        if (c0294b2 != null) {
            this.f6735l.f6721a.release(c0294b2);
        }
        C0294b[] c0294bArr = this.f6729f;
        int i2 = this.f6733j;
        c0294bArr[i2] = c0294b;
        i iVar = c0294b.f6717a;
        iVar.f6744c = i2;
        this.f6733j = i2 + 1;
        iVar.f(c0294b);
    }

    private void o() {
        for (int i2 = 0; i2 < this.f6733j; i2++) {
            C0294b c0294b = this.f6729f[i2];
            c0294b.f6717a.e = c0294b.f6718b;
        }
    }

    public static C0294b t(e eVar, i iVar, i iVar2, i iVar3, float f2, boolean z2) {
        C0294b c0294bS = eVar.s();
        if (z2) {
            eVar.g(c0294bS);
        }
        return c0294bS.i(iVar, iVar2, iVar3, f2);
    }

    private int v(a aVar) {
        for (int i2 = 0; i2 < this.f6733j; i2++) {
            C0294b c0294b = this.f6729f[i2];
            if (c0294b.f6717a.f6747g != i.a.UNRESTRICTED && c0294b.f6718b < 0.0f) {
                boolean z2 = false;
                int i3 = 0;
                while (!z2) {
                    i3++;
                    float f2 = Float.MAX_VALUE;
                    int i4 = 0;
                    int i5 = -1;
                    int i6 = -1;
                    int i7 = 0;
                    while (true) {
                        if (i4 >= this.f6733j) {
                            break;
                        }
                        C0294b c0294b2 = this.f6729f[i4];
                        if (c0294b2.f6717a.f6747g != i.a.UNRESTRICTED && !c0294b2.e && c0294b2.f6718b < 0.0f) {
                            for (int i8 = 1; i8 < this.f6732i; i8++) {
                                i iVar = this.f6735l.f6723c[i8];
                                float f3 = c0294b2.f6720d.f(iVar);
                                if (f3 > 0.0f) {
                                    for (int i9 = 0; i9 < 7; i9++) {
                                        float f4 = iVar.f6746f[i9] / f3;
                                        if ((f4 < f2 && i9 == i7) || i9 > i7) {
                                            f2 = f4;
                                            i5 = i4;
                                            i6 = i8;
                                            i7 = i9;
                                        }
                                    }
                                }
                            }
                        }
                        i4++;
                    }
                    if (i5 != -1) {
                        C0294b c0294b3 = this.f6729f[i5];
                        c0294b3.f6717a.f6744c = -1;
                        c0294b3.v(this.f6735l.f6723c[i6]);
                        i iVar2 = c0294b3.f6717a;
                        iVar2.f6744c = i5;
                        iVar2.f(c0294b3);
                    } else {
                        z2 = true;
                    }
                    if (i3 > this.f6732i / 2) {
                        z2 = true;
                    }
                }
                return i3;
            }
        }
        return 0;
    }

    public static f x() {
        return null;
    }

    private void z() {
        int i2 = this.f6728d * 2;
        this.f6728d = i2;
        this.f6729f = (C0294b[]) Arrays.copyOf(this.f6729f, i2);
        C0295c c0295c = this.f6735l;
        c0295c.f6723c = (i[]) Arrays.copyOf(c0295c.f6723c, this.f6728d);
        int i3 = this.f6728d;
        this.f6731h = new boolean[i3];
        this.e = i3;
        this.f6734k = i3;
    }

    public void A() {
        if (!this.f6730g) {
            B(this.f6727c);
            return;
        }
        for (int i2 = 0; i2 < this.f6733j; i2++) {
            if (!this.f6729f[i2].e) {
                B(this.f6727c);
                return;
            }
        }
        o();
    }

    void B(a aVar) {
        F((C0294b) aVar);
        v(aVar);
        C(aVar, false);
        o();
    }

    public void E() {
        C0295c c0295c;
        int i2 = 0;
        while (true) {
            c0295c = this.f6735l;
            i[] iVarArr = c0295c.f6723c;
            if (i2 >= iVarArr.length) {
                break;
            }
            i iVar = iVarArr[i2];
            if (iVar != null) {
                iVar.d();
            }
            i2++;
        }
        c0295c.f6722b.a(this.f6736m, this.f6737n);
        this.f6737n = 0;
        Arrays.fill(this.f6735l.f6723c, (Object) null);
        HashMap map = this.f6726b;
        if (map != null) {
            map.clear();
        }
        this.f6725a = 0;
        this.f6727c.clear();
        this.f6732i = 1;
        for (int i3 = 0; i3 < this.f6733j; i3++) {
            this.f6729f[i3].f6719c = false;
        }
        D();
        this.f6733j = 0;
    }

    public void b(o.g gVar, o.g gVar2, float f2, int i2) {
        o.f.d dVar = o.f.d.LEFT;
        i iVarR = r(gVar.h(dVar));
        o.f.d dVar2 = o.f.d.TOP;
        i iVarR2 = r(gVar.h(dVar2));
        o.f.d dVar3 = o.f.d.RIGHT;
        i iVarR3 = r(gVar.h(dVar3));
        o.f.d dVar4 = o.f.d.BOTTOM;
        i iVarR4 = r(gVar.h(dVar4));
        i iVarR5 = r(gVar2.h(dVar));
        i iVarR6 = r(gVar2.h(dVar2));
        i iVarR7 = r(gVar2.h(dVar3));
        i iVarR8 = r(gVar2.h(dVar4));
        C0294b c0294bS = s();
        double d2 = f2;
        double d3 = i2;
        c0294bS.p(iVarR2, iVarR4, iVarR6, iVarR8, (float) (Math.sin(d2) * d3));
        d(c0294bS);
        C0294b c0294bS2 = s();
        c0294bS2.p(iVarR, iVarR3, iVarR5, iVarR7, (float) (Math.cos(d2) * d3));
        d(c0294bS2);
    }

    public void c(i iVar, i iVar2, int i2, float f2, i iVar3, i iVar4, int i3, int i4) {
        C0294b c0294bS = s();
        c0294bS.g(iVar, iVar2, i2, f2, iVar3, iVar4, i3);
        if (i4 != 6) {
            c0294bS.d(this, i4);
        }
        d(c0294bS);
    }

    public void d(C0294b c0294b) {
        i iVarU;
        if (c0294b == null) {
            return;
        }
        boolean z2 = true;
        if (this.f6733j + 1 >= this.f6734k || this.f6732i + 1 >= this.e) {
            z();
        }
        boolean z3 = false;
        if (!c0294b.e) {
            F(c0294b);
            if (c0294b.t()) {
                return;
            }
            c0294b.q();
            if (c0294b.f(this)) {
                i iVarQ = q();
                c0294b.f6717a = iVarQ;
                m(c0294b);
                this.f6738p.c(c0294b);
                C(this.f6738p, true);
                if (iVarQ.f6744c == -1) {
                    if (c0294b.f6717a == iVarQ && (iVarU = c0294b.u(iVarQ)) != null) {
                        c0294b.v(iVarU);
                    }
                    if (!c0294b.e) {
                        c0294b.f6717a.f(c0294b);
                    }
                    this.f6733j--;
                }
            } else {
                z2 = false;
            }
            if (!c0294b.r()) {
                return;
            } else {
                z3 = z2;
            }
        }
        if (z3) {
            return;
        }
        m(c0294b);
    }

    public C0294b e(i iVar, i iVar2, int i2, int i3) {
        C0294b c0294bS = s();
        c0294bS.m(iVar, iVar2, i2);
        if (i3 != 6) {
            c0294bS.d(this, i3);
        }
        d(c0294bS);
        return c0294bS;
    }

    public void f(i iVar, int i2) {
        int i3 = iVar.f6744c;
        if (i3 == -1) {
            C0294b c0294bS = s();
            c0294bS.h(iVar, i2);
            d(c0294bS);
            return;
        }
        C0294b c0294b = this.f6729f[i3];
        if (c0294b.e) {
            c0294b.f6718b = i2;
            return;
        }
        if (c0294b.f6720d.f6707a == 0) {
            c0294b.e = true;
            c0294b.f6718b = i2;
        } else {
            C0294b c0294bS2 = s();
            c0294bS2.l(iVar, i2);
            d(c0294bS2);
        }
    }

    public void h(i iVar, i iVar2, boolean z2) {
        C0294b c0294bS = s();
        i iVarU = u();
        iVarU.f6745d = 0;
        c0294bS.n(iVar, iVar2, iVarU, 0);
        if (z2) {
            n(c0294bS, (int) (c0294bS.f6720d.f(iVarU) * (-1.0f)), 1);
        }
        d(c0294bS);
    }

    public void i(i iVar, i iVar2, int i2, int i3) {
        C0294b c0294bS = s();
        i iVarU = u();
        iVarU.f6745d = 0;
        c0294bS.n(iVar, iVar2, iVarU, i2);
        if (i3 != 6) {
            n(c0294bS, (int) (c0294bS.f6720d.f(iVarU) * (-1.0f)), i3);
        }
        d(c0294bS);
    }

    public void j(i iVar, i iVar2, boolean z2) {
        C0294b c0294bS = s();
        i iVarU = u();
        iVarU.f6745d = 0;
        c0294bS.o(iVar, iVar2, iVarU, 0);
        if (z2) {
            n(c0294bS, (int) (c0294bS.f6720d.f(iVarU) * (-1.0f)), 1);
        }
        d(c0294bS);
    }

    public void k(i iVar, i iVar2, int i2, int i3) {
        C0294b c0294bS = s();
        i iVarU = u();
        iVarU.f6745d = 0;
        c0294bS.o(iVar, iVar2, iVarU, i2);
        if (i3 != 6) {
            n(c0294bS, (int) (c0294bS.f6720d.f(iVarU) * (-1.0f)), i3);
        }
        d(c0294bS);
    }

    public void l(i iVar, i iVar2, i iVar3, i iVar4, float f2, int i2) {
        C0294b c0294bS = s();
        c0294bS.j(iVar, iVar2, iVar3, iVar4, f2);
        if (i2 != 6) {
            c0294bS.d(this, i2);
        }
        d(c0294bS);
    }

    void n(C0294b c0294b, int i2, int i3) {
        c0294b.e(p(i3, null), i2);
    }

    public i p(int i2, String str) {
        if (this.f6732i + 1 >= this.e) {
            z();
        }
        i iVarA = a(i.a.ERROR, str);
        int i3 = this.f6725a + 1;
        this.f6725a = i3;
        this.f6732i++;
        iVarA.f6743b = i3;
        iVarA.f6745d = i2;
        this.f6735l.f6723c[i3] = iVarA;
        this.f6727c.b(iVarA);
        return iVarA;
    }

    public i q() {
        if (this.f6732i + 1 >= this.e) {
            z();
        }
        i iVarA = a(i.a.SLACK, null);
        int i2 = this.f6725a + 1;
        this.f6725a = i2;
        this.f6732i++;
        iVarA.f6743b = i2;
        this.f6735l.f6723c[i2] = iVarA;
        return iVarA;
    }

    public i r(Object obj) {
        i iVarG = null;
        if (obj == null) {
            return null;
        }
        if (this.f6732i + 1 >= this.e) {
            z();
        }
        if (obj instanceof o.f) {
            o.f fVar = (o.f) obj;
            iVarG = fVar.g();
            if (iVarG == null) {
                fVar.n(this.f6735l);
                iVarG = fVar.g();
            }
            int i2 = iVarG.f6743b;
            if (i2 == -1 || i2 > this.f6725a || this.f6735l.f6723c[i2] == null) {
                if (i2 != -1) {
                    iVarG.d();
                }
                int i3 = this.f6725a + 1;
                this.f6725a = i3;
                this.f6732i++;
                iVarG.f6743b = i3;
                iVarG.f6747g = i.a.UNRESTRICTED;
                this.f6735l.f6723c[i3] = iVarG;
            }
        }
        return iVarG;
    }

    public C0294b s() {
        C0294b c0294b = (C0294b) this.f6735l.f6721a.acquire();
        if (c0294b == null) {
            c0294b = new C0294b(this.f6735l);
        } else {
            c0294b.w();
        }
        i.b();
        return c0294b;
    }

    public i u() {
        if (this.f6732i + 1 >= this.e) {
            z();
        }
        i iVarA = a(i.a.SLACK, null);
        int i2 = this.f6725a + 1;
        this.f6725a = i2;
        this.f6732i++;
        iVarA.f6743b = i2;
        this.f6735l.f6723c[i2] = iVarA;
        return iVarA;
    }

    public C0295c w() {
        return this.f6735l;
    }

    public int y(Object obj) {
        i iVarG = ((o.f) obj).g();
        if (iVarG != null) {
            return (int) (iVarG.e + 0.5f);
        }
        return 0;
    }
}
