package G0;

import D0.b;
import D0.e;
import D0.g;
import H0.d;
import java.util.List;
import java.util.Map;
import z0.C0381c;
import z0.C0382d;
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
    private static final o[] f203b = new o[0];

    /* renamed from: a, reason: collision with root package name */
    private final d f204a = new d();

    private static b c(b bVar) throws i {
        int[] iArrI = bVar.i();
        int[] iArrE = bVar.e();
        if (iArrI == null || iArrE == null) {
            throw i.a();
        }
        int iD = d(iArrI, bVar);
        int i2 = iArrI[1];
        int i3 = iArrE[1];
        int i4 = iArrI[0];
        int i5 = ((iArrE[0] - i4) + 1) / iD;
        int i6 = ((i3 - i2) + 1) / iD;
        if (i5 <= 0 || i6 <= 0) {
            throw i.a();
        }
        int i7 = iD / 2;
        int i8 = i2 + i7;
        int i9 = i4 + i7;
        b bVar2 = new b(i5, i6);
        for (int i10 = 0; i10 < i6; i10++) {
            int i11 = (i10 * iD) + i8;
            for (int i12 = 0; i12 < i5; i12++) {
                if (bVar.d((i12 * iD) + i9, i11)) {
                    bVar2.l(i12, i10);
                }
            }
        }
        return bVar2;
    }

    private static int d(int[] iArr, b bVar) throws i {
        int iJ = bVar.j();
        int i2 = iArr[0];
        int i3 = iArr[1];
        while (i2 < iJ && bVar.d(i2, i3)) {
            i2++;
        }
        if (i2 == iJ) {
            throw i.a();
        }
        int i4 = i2 - iArr[0];
        if (i4 != 0) {
            return i4;
        }
        throw i.a();
    }

    @Override // z0.k
    public m a(C0381c c0381c, Map map) throws C0382d, i {
        o[] oVarArrB;
        e eVarB;
        if (map == null || !map.containsKey(EnumC0383e.PURE_BARCODE)) {
            g gVarC = new I0.a(c0381c.a()).c();
            e eVarB2 = this.f204a.b(gVarC.a());
            oVarArrB = gVarC.b();
            eVarB = eVarB2;
        } else {
            eVarB = this.f204a.b(c(c0381c.a()));
            oVarArrB = f203b;
        }
        m mVar = new m(eVarB.h(), eVarB.e(), oVarArrB, EnumC0379a.DATA_MATRIX);
        List listA = eVarB.a();
        if (listA != null) {
            mVar.h(n.BYTE_SEGMENTS, listA);
        }
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
