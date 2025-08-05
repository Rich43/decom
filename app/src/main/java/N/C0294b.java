package n;

import n.e;
import n.i;

/* renamed from: n.b */
/* loaded from: classes.dex */
public class C0294b implements e.a {

    /* renamed from: d */
    public final C0293a f6720d;

    /* renamed from: a */
    i f6717a = null;

    /* renamed from: b */
    float f6718b = 0.0f;

    /* renamed from: c */
    boolean f6719c = false;
    boolean e = false;

    public C0294b(C0295c c0295c) {
        this.f6720d = new C0293a(this, c0295c);
    }

    @Override // n.e.a
    public i a(e eVar, boolean[] zArr) {
        return this.f6720d.g(zArr, null);
    }

    @Override // n.e.a
    public void b(i iVar) {
        int i2 = iVar.f6745d;
        float f2 = 1.0f;
        if (i2 != 1) {
            if (i2 == 2) {
                f2 = 1000.0f;
            } else if (i2 == 3) {
                f2 = 1000000.0f;
            } else if (i2 == 4) {
                f2 = 1.0E9f;
            } else if (i2 == 5) {
                f2 = 1.0E12f;
            }
        }
        this.f6720d.l(iVar, f2);
    }

    @Override // n.e.a
    public void c(e.a aVar) {
        if (!(aVar instanceof C0294b)) {
            return;
        }
        C0294b c0294b = (C0294b) aVar;
        this.f6717a = null;
        this.f6720d.c();
        int i2 = 0;
        while (true) {
            C0293a c0293a = c0294b.f6720d;
            if (i2 >= c0293a.f6707a) {
                return;
            }
            this.f6720d.a(c0293a.h(i2), c0294b.f6720d.i(i2), true);
            i2++;
        }
    }

    @Override // n.e.a
    public void clear() {
        this.f6720d.c();
        this.f6717a = null;
        this.f6718b = 0.0f;
    }

    public C0294b d(e eVar, int i2) {
        this.f6720d.l(eVar.p(i2, "ep"), 1.0f);
        this.f6720d.l(eVar.p(i2, "em"), -1.0f);
        return this;
    }

    C0294b e(i iVar, int i2) {
        this.f6720d.l(iVar, i2);
        return this;
    }

    boolean f(e eVar) {
        boolean z2;
        i iVarB = this.f6720d.b(eVar);
        if (iVarB == null) {
            z2 = true;
        } else {
            v(iVarB);
            z2 = false;
        }
        if (this.f6720d.f6707a == 0) {
            this.e = true;
        }
        return z2;
    }

    C0294b g(i iVar, i iVar2, int i2, float f2, i iVar3, i iVar4, int i3) {
        if (iVar2 == iVar3) {
            this.f6720d.l(iVar, 1.0f);
            this.f6720d.l(iVar4, 1.0f);
            this.f6720d.l(iVar2, -2.0f);
            return this;
        }
        if (f2 == 0.5f) {
            this.f6720d.l(iVar, 1.0f);
            this.f6720d.l(iVar2, -1.0f);
            this.f6720d.l(iVar3, -1.0f);
            this.f6720d.l(iVar4, 1.0f);
            if (i2 > 0 || i3 > 0) {
                this.f6718b = (-i2) + i3;
            }
        } else if (f2 <= 0.0f) {
            this.f6720d.l(iVar, -1.0f);
            this.f6720d.l(iVar2, 1.0f);
            this.f6718b = i2;
        } else if (f2 >= 1.0f) {
            this.f6720d.l(iVar3, -1.0f);
            this.f6720d.l(iVar4, 1.0f);
            this.f6718b = i3;
        } else {
            float f3 = 1.0f - f2;
            this.f6720d.l(iVar, f3 * 1.0f);
            this.f6720d.l(iVar2, f3 * (-1.0f));
            this.f6720d.l(iVar3, (-1.0f) * f2);
            this.f6720d.l(iVar4, 1.0f * f2);
            if (i2 > 0 || i3 > 0) {
                this.f6718b = ((-i2) * f3) + (i3 * f2);
            }
        }
        return this;
    }

    @Override // n.e.a
    public i getKey() {
        return this.f6717a;
    }

    C0294b h(i iVar, int i2) {
        this.f6717a = iVar;
        float f2 = i2;
        iVar.e = f2;
        this.f6718b = f2;
        this.e = true;
        return this;
    }

    C0294b i(i iVar, i iVar2, i iVar3, float f2) {
        this.f6720d.l(iVar, -1.0f);
        this.f6720d.l(iVar2, 1.0f - f2);
        this.f6720d.l(iVar3, f2);
        return this;
    }

    public C0294b j(i iVar, i iVar2, i iVar3, i iVar4, float f2) {
        this.f6720d.l(iVar, -1.0f);
        this.f6720d.l(iVar2, 1.0f);
        this.f6720d.l(iVar3, f2);
        this.f6720d.l(iVar4, -f2);
        return this;
    }

    public C0294b k(float f2, float f3, float f4, i iVar, i iVar2, i iVar3, i iVar4) {
        this.f6718b = 0.0f;
        if (f3 == 0.0f || f2 == f4) {
            this.f6720d.l(iVar, 1.0f);
            this.f6720d.l(iVar2, -1.0f);
            this.f6720d.l(iVar4, 1.0f);
            this.f6720d.l(iVar3, -1.0f);
        } else if (f2 == 0.0f) {
            this.f6720d.l(iVar, 1.0f);
            this.f6720d.l(iVar2, -1.0f);
        } else if (f4 == 0.0f) {
            this.f6720d.l(iVar3, 1.0f);
            this.f6720d.l(iVar4, -1.0f);
        } else {
            float f5 = (f2 / f3) / (f4 / f3);
            this.f6720d.l(iVar, 1.0f);
            this.f6720d.l(iVar2, -1.0f);
            this.f6720d.l(iVar4, f5);
            this.f6720d.l(iVar3, -f5);
        }
        return this;
    }

    public C0294b l(i iVar, int i2) {
        if (i2 < 0) {
            this.f6718b = i2 * (-1);
            this.f6720d.l(iVar, 1.0f);
        } else {
            this.f6718b = i2;
            this.f6720d.l(iVar, -1.0f);
        }
        return this;
    }

    public C0294b m(i iVar, i iVar2, int i2) {
        boolean z2 = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z2 = true;
            }
            this.f6718b = i2;
        }
        if (z2) {
            this.f6720d.l(iVar, 1.0f);
            this.f6720d.l(iVar2, -1.0f);
        } else {
            this.f6720d.l(iVar, -1.0f);
            this.f6720d.l(iVar2, 1.0f);
        }
        return this;
    }

    public C0294b n(i iVar, i iVar2, i iVar3, int i2) {
        boolean z2 = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z2 = true;
            }
            this.f6718b = i2;
        }
        if (z2) {
            this.f6720d.l(iVar, 1.0f);
            this.f6720d.l(iVar2, -1.0f);
            this.f6720d.l(iVar3, -1.0f);
        } else {
            this.f6720d.l(iVar, -1.0f);
            this.f6720d.l(iVar2, 1.0f);
            this.f6720d.l(iVar3, 1.0f);
        }
        return this;
    }

    public C0294b o(i iVar, i iVar2, i iVar3, int i2) {
        boolean z2 = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z2 = true;
            }
            this.f6718b = i2;
        }
        if (z2) {
            this.f6720d.l(iVar, 1.0f);
            this.f6720d.l(iVar2, -1.0f);
            this.f6720d.l(iVar3, 1.0f);
        } else {
            this.f6720d.l(iVar, -1.0f);
            this.f6720d.l(iVar2, 1.0f);
            this.f6720d.l(iVar3, -1.0f);
        }
        return this;
    }

    public C0294b p(i iVar, i iVar2, i iVar3, i iVar4, float f2) {
        this.f6720d.l(iVar3, 0.5f);
        this.f6720d.l(iVar4, 0.5f);
        this.f6720d.l(iVar, -0.5f);
        this.f6720d.l(iVar2, -0.5f);
        this.f6718b = -f2;
        return this;
    }

    void q() {
        float f2 = this.f6718b;
        if (f2 < 0.0f) {
            this.f6718b = f2 * (-1.0f);
            this.f6720d.j();
        }
    }

    boolean r() {
        i iVar = this.f6717a;
        return iVar != null && (iVar.f6747g == i.a.UNRESTRICTED || this.f6718b >= 0.0f);
    }

    boolean s(i iVar) {
        return this.f6720d.d(iVar);
    }

    public boolean t() {
        return this.f6717a == null && this.f6718b == 0.0f && this.f6720d.f6707a == 0;
    }

    public String toString() {
        return x();
    }

    i u(i iVar) {
        return this.f6720d.g(null, iVar);
    }

    void v(i iVar) {
        i iVar2 = this.f6717a;
        if (iVar2 != null) {
            this.f6720d.l(iVar2, -1.0f);
            this.f6717a = null;
        }
        float fM = this.f6720d.m(iVar, true) * (-1.0f);
        this.f6717a = iVar;
        if (fM == 1.0f) {
            return;
        }
        this.f6718b /= fM;
        this.f6720d.e(fM);
    }

    public void w() {
        this.f6717a = null;
        this.f6720d.c();
        this.f6718b = 0.0f;
        this.e = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.lang.String x() {
        /*
            Method dump skipped, instructions count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: n.C0294b.x():java.lang.String");
    }
}
