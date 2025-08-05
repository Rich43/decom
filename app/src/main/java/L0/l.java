package L0;

import java.util.Map;
import z0.C0381c;
import z0.C0384f;
import z0.EnumC0379a;

/* loaded from: classes.dex */
public final class l extends p {

    /* renamed from: i, reason: collision with root package name */
    private final p f305i = new e();

    private static z0.m s(z0.m mVar) throws C0384f {
        String strF = mVar.f();
        if (strF.charAt(0) != '0') {
            throw C0384f.a();
        }
        z0.m mVar2 = new z0.m(strF.substring(1), null, mVar.e(), EnumC0379a.UPC_A);
        if (mVar.d() != null) {
            mVar2.g(mVar.d());
        }
        return mVar2;
    }

    @Override // L0.k, z0.k
    public z0.m a(C0381c c0381c, Map map) {
        return s(this.f305i.a(c0381c, map));
    }

    @Override // L0.p, L0.k
    public z0.m c(int i2, D0.a aVar, Map map) {
        return s(this.f305i.c(i2, aVar, map));
    }

    @Override // L0.p
    protected int l(D0.a aVar, int[] iArr, StringBuilder sb) {
        return this.f305i.l(aVar, iArr, sb);
    }

    @Override // L0.p
    public z0.m m(int i2, D0.a aVar, int[] iArr, Map map) {
        return s(this.f305i.m(i2, aVar, iArr, map));
    }

    @Override // L0.p
    EnumC0379a q() {
        return EnumC0379a.UPC_A;
    }
}
