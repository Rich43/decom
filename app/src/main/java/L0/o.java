package L0;

/* loaded from: classes.dex */
final class o {

    /* renamed from: c */
    private static final int[] f311c = {1, 1, 2};

    /* renamed from: a */
    private final m f312a = new m();

    /* renamed from: b */
    private final n f313b = new n();

    o() {
    }

    z0.m a(int i2, D0.a aVar, int i3) {
        int[] iArrN = p.n(aVar, i3, false, f311c);
        try {
            return this.f313b.b(i2, aVar, iArrN);
        } catch (z0.l unused) {
            return this.f312a.b(i2, aVar, iArrN);
        }
    }
}
