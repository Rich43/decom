package U0;

import z0.C0384f;

/* loaded from: classes.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    private final D0.b f899a;

    /* renamed from: b, reason: collision with root package name */
    private j f900b;

    /* renamed from: c, reason: collision with root package name */
    private g f901c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f902d;

    a(D0.b bVar) throws C0384f {
        int iG = bVar.g();
        if (iG < 21 || (iG & 3) != 1) {
            throw C0384f.a();
        }
        this.f899a = bVar;
    }

    private int a(int i2, int i3, int i4) {
        return this.f902d ? this.f899a.d(i3, i2) : this.f899a.d(i2, i3) ? (i4 << 1) | 1 : i4 << 1;
    }

    void b() {
        int i2 = 0;
        while (i2 < this.f899a.j()) {
            int i3 = i2 + 1;
            for (int i4 = i3; i4 < this.f899a.g(); i4++) {
                if (this.f899a.d(i2, i4) != this.f899a.d(i4, i2)) {
                    this.f899a.c(i4, i2);
                    this.f899a.c(i2, i4);
                }
            }
            i2 = i3;
        }
    }

    byte[] c() throws C0384f {
        g gVarD = d();
        j jVarE = e();
        c cVar = c.values()[gVarD.c()];
        int iG = this.f899a.g();
        cVar.b(this.f899a, iG);
        D0.b bVarA = jVarE.a();
        byte[] bArr = new byte[jVarE.h()];
        int i2 = iG - 1;
        boolean z2 = true;
        int i3 = i2;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i3 > 0) {
            if (i3 == 6) {
                i3--;
            }
            for (int i7 = 0; i7 < iG; i7++) {
                int i8 = z2 ? i2 - i7 : i7;
                for (int i9 = 0; i9 < 2; i9++) {
                    int i10 = i3 - i9;
                    if (!bVarA.d(i10, i8)) {
                        i5++;
                        i6 <<= 1;
                        if (this.f899a.d(i10, i8)) {
                            i6 |= 1;
                        }
                        if (i5 == 8) {
                            bArr[i4] = (byte) i6;
                            i4++;
                            i5 = 0;
                            i6 = 0;
                        }
                    }
                }
            }
            z2 = !z2;
            i3 -= 2;
        }
        if (i4 == jVarE.h()) {
            return bArr;
        }
        throw C0384f.a();
    }

    g d() throws C0384f {
        g gVar = this.f901c;
        if (gVar != null) {
            return gVar;
        }
        int iA = 0;
        int iA2 = 0;
        for (int i2 = 0; i2 < 6; i2++) {
            iA2 = a(i2, 8, iA2);
        }
        int iA3 = a(8, 7, a(8, 8, a(7, 8, iA2)));
        for (int i3 = 5; i3 >= 0; i3--) {
            iA3 = a(8, i3, iA3);
        }
        int iG = this.f899a.g();
        int i4 = iG - 7;
        for (int i5 = iG - 1; i5 >= i4; i5--) {
            iA = a(8, i5, iA);
        }
        for (int i6 = iG - 8; i6 < iG; i6++) {
            iA = a(i6, 8, iA);
        }
        g gVarA = g.a(iA3, iA);
        this.f901c = gVarA;
        if (gVarA != null) {
            return gVarA;
        }
        throw C0384f.a();
    }

    j e() throws C0384f {
        j jVar = this.f900b;
        if (jVar != null) {
            return jVar;
        }
        int iG = this.f899a.g();
        int i2 = (iG - 17) / 4;
        if (i2 <= 6) {
            return j.i(i2);
        }
        int i3 = iG - 11;
        int iA = 0;
        int iA2 = 0;
        for (int i4 = 5; i4 >= 0; i4--) {
            for (int i5 = iG - 9; i5 >= i3; i5--) {
                iA2 = a(i5, i4, iA2);
            }
        }
        j jVarC = j.c(iA2);
        if (jVarC != null && jVarC.e() == iG) {
            this.f900b = jVarC;
            return jVarC;
        }
        for (int i6 = 5; i6 >= 0; i6--) {
            for (int i7 = iG - 9; i7 >= i3; i7--) {
                iA = a(i6, i7, iA);
            }
        }
        j jVarC2 = j.c(iA);
        if (jVarC2 == null || jVarC2.e() != iG) {
            throw C0384f.a();
        }
        this.f900b = jVarC2;
        return jVarC2;
    }

    void f() {
        if (this.f901c == null) {
            return;
        }
        c.values()[this.f901c.c()].b(this.f899a, this.f899a.g());
    }

    void g(boolean z2) {
        this.f900b = null;
        this.f901c = null;
        this.f902d = z2;
    }
}
