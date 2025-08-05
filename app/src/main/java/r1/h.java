package r1;

/* loaded from: classes.dex */
final class h {

    /* renamed from: a */
    final byte[] f7379a;

    /* renamed from: b */
    int f7380b;

    /* renamed from: c */
    int f7381c;

    /* renamed from: d */
    boolean f7382d;
    boolean e;

    /* renamed from: f */
    h f7383f;

    /* renamed from: g */
    h f7384g;

    h() {
        this.f7379a = new byte[8192];
        this.e = true;
        this.f7382d = false;
    }

    public final void a() {
        h hVar = this.f7384g;
        if (hVar == this) {
            throw new IllegalStateException();
        }
        if (hVar.e) {
            int i2 = this.f7381c - this.f7380b;
            if (i2 > (8192 - hVar.f7381c) + (hVar.f7382d ? 0 : hVar.f7380b)) {
                return;
            }
            f(hVar, i2);
            b();
            i.a(this);
        }
    }

    public final h b() {
        h hVar = this.f7383f;
        h hVar2 = hVar != this ? hVar : null;
        h hVar3 = this.f7384g;
        hVar3.f7383f = hVar;
        this.f7383f.f7384g = hVar3;
        this.f7383f = null;
        this.f7384g = null;
        return hVar2;
    }

    public final h c(h hVar) {
        hVar.f7384g = this;
        hVar.f7383f = this.f7383f;
        this.f7383f.f7384g = hVar;
        this.f7383f = hVar;
        return hVar;
    }

    final h d() {
        this.f7382d = true;
        return new h(this.f7379a, this.f7380b, this.f7381c, true, false);
    }

    public final h e(int i2) {
        h hVarB;
        if (i2 <= 0 || i2 > this.f7381c - this.f7380b) {
            throw new IllegalArgumentException();
        }
        if (i2 >= 1024) {
            hVarB = d();
        } else {
            hVarB = i.b();
            System.arraycopy(this.f7379a, this.f7380b, hVarB.f7379a, 0, i2);
        }
        hVarB.f7381c = hVarB.f7380b + i2;
        this.f7380b += i2;
        this.f7384g.c(hVarB);
        return hVarB;
    }

    public final void f(h hVar, int i2) {
        if (!hVar.e) {
            throw new IllegalArgumentException();
        }
        int i3 = hVar.f7381c;
        if (i3 + i2 > 8192) {
            if (hVar.f7382d) {
                throw new IllegalArgumentException();
            }
            int i4 = hVar.f7380b;
            if ((i3 + i2) - i4 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = hVar.f7379a;
            System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
            hVar.f7381c -= hVar.f7380b;
            hVar.f7380b = 0;
        }
        System.arraycopy(this.f7379a, this.f7380b, hVar.f7379a, hVar.f7381c, i2);
        hVar.f7381c += i2;
        this.f7380b += i2;
    }

    h(byte[] bArr, int i2, int i3, boolean z2, boolean z3) {
        this.f7379a = bArr;
        this.f7380b = i2;
        this.f7381c = i3;
        this.f7382d = z2;
        this.e = z3;
    }
}
