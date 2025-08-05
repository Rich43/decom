package r0;

import java.io.IOException;
import java.util.Arrays;

/* renamed from: r0.c */
/* loaded from: classes.dex */
public class C0324c extends h {

    /* renamed from: b */
    private h[] f7351b;

    public C0324c(int i2) {
        this.f7351b = new h[i2];
    }

    @Override // r0.h
    void a(C0323b c0323b) {
        super.a(c0323b);
        for (h hVar : this.f7351b) {
            hVar.a(c0323b);
        }
    }

    @Override // r0.h
    void b(C0323b c0323b) throws IOException {
        c0323b.m(10, this.f7351b.length);
        for (h hVar : this.f7351b) {
            c0323b.l(c0323b.d(hVar));
        }
    }

    public boolean equals(Object obj) {
        if (obj.getClass().equals(C0324c.class)) {
            return Arrays.equals(((C0324c) obj).j(), this.f7351b);
        }
        h hVarH = h.h(obj);
        if (hVarH.getClass().equals(C0324c.class)) {
            return Arrays.equals(((C0324c) hVarH).j(), this.f7351b);
        }
        return false;
    }

    public int hashCode() {
        return 623 + Arrays.deepHashCode(this.f7351b);
    }

    public h[] j() {
        return this.f7351b;
    }

    public void k(int i2, Object obj) {
        if (obj == null) {
            throw new NullPointerException("Cannot add null values to an NSArray!");
        }
        this.f7351b[i2] = h.h(obj);
    }

    public C0324c(h... hVarArr) {
        this.f7351b = hVarArr;
    }
}
