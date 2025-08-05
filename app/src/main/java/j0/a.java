package J0;

import D0.b;
import D0.e;
import K0.c;
import java.util.Map;
import z0.C0381c;
import z0.C0382d;
import z0.C0384f;
import z0.EnumC0379a;
import z0.EnumC0383e;
import z0.i;
import z0.k;
import z0.m;
import z0.n;
import z0.o;

/* loaded from: classes.dex */
public final class a implements k {

    /* renamed from: b, reason: collision with root package name */
    private static final o[] f247b = new o[0];

    /* renamed from: a, reason: collision with root package name */
    private final c f248a = new c();

    private static b c(b bVar) throws i {
        int[] iArrF = bVar.f();
        if (iArrF == null) {
            throw i.a();
        }
        int i2 = iArrF[0];
        int i3 = iArrF[1];
        int i4 = iArrF[2];
        int i5 = iArrF[3];
        b bVar2 = new b(30, 33);
        for (int i6 = 0; i6 < 33; i6++) {
            int i7 = (((i6 * i5) + (i5 / 2)) / 33) + i3;
            for (int i8 = 0; i8 < 30; i8++) {
                if (bVar.d(((((i8 * i4) + (i4 / 2)) + (((i6 & 1) * i4) / 2)) / 30) + i2, i7)) {
                    bVar2.l(i8, i6);
                }
            }
        }
        return bVar2;
    }

    @Override // z0.k
    public m a(C0381c c0381c, Map map) throws C0382d, C0384f, i {
        if (map == null || !map.containsKey(EnumC0383e.PURE_BARCODE)) {
            throw i.a();
        }
        e eVarB = this.f248a.b(c(c0381c.a()), map);
        m mVar = new m(eVarB.h(), eVarB.e(), f247b, EnumC0379a.MAXICODE);
        String strB = eVarB.b();
        if (strB != null) {
            mVar.h(n.ERROR_CORRECTION_LEVEL, strB);
        }
        return mVar;
    }

    @Override // z0.k
    public void b() {
    }
}
