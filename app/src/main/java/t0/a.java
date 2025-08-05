package T0;

import D0.b;
import D0.g;
import U0.e;
import V0.c;
import java.util.List;
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
public class a implements k {

    /* renamed from: b, reason: collision with root package name */
    private static final o[] f889b = new o[0];

    /* renamed from: a, reason: collision with root package name */
    private final e f890a = new e();

    private static b c(b bVar) throws i {
        int[] iArrI = bVar.i();
        int[] iArrE = bVar.e();
        if (iArrI == null || iArrE == null) {
            throw i.a();
        }
        float fD = d(iArrI, bVar);
        int i2 = iArrI[1];
        int i3 = iArrE[1];
        int i4 = iArrI[0];
        int i5 = iArrE[0];
        if (i4 >= i5 || i2 >= i3) {
            throw i.a();
        }
        int i6 = i3 - i2;
        if (i6 != i5 - i4 && (i5 = i4 + i6) >= bVar.j()) {
            throw i.a();
        }
        int iRound = Math.round(((i5 - i4) + 1) / fD);
        int iRound2 = Math.round((i6 + 1) / fD);
        if (iRound <= 0 || iRound2 <= 0) {
            throw i.a();
        }
        if (iRound2 != iRound) {
            throw i.a();
        }
        int i7 = (int) (fD / 2.0f);
        int i8 = i2 + i7;
        int i9 = i4 + i7;
        int i10 = (((int) ((iRound - 1) * fD)) + i9) - i5;
        if (i10 > 0) {
            if (i10 > i7) {
                throw i.a();
            }
            i9 -= i10;
        }
        int i11 = (((int) ((iRound2 - 1) * fD)) + i8) - i3;
        if (i11 > 0) {
            if (i11 > i7) {
                throw i.a();
            }
            i8 -= i11;
        }
        b bVar2 = new b(iRound, iRound2);
        for (int i12 = 0; i12 < iRound2; i12++) {
            int i13 = ((int) (i12 * fD)) + i8;
            for (int i14 = 0; i14 < iRound; i14++) {
                if (bVar.d(((int) (i14 * fD)) + i9, i13)) {
                    bVar2.l(i14, i12);
                }
            }
        }
        return bVar2;
    }

    private static float d(int[] iArr, b bVar) throws i {
        int iG = bVar.g();
        int iJ = bVar.j();
        int i2 = iArr[0];
        boolean z2 = true;
        int i3 = iArr[1];
        int i4 = 0;
        while (i2 < iJ && i3 < iG) {
            if (z2 != bVar.d(i2, i3)) {
                i4++;
                if (i4 == 5) {
                    break;
                }
                z2 = !z2;
            }
            i2++;
            i3++;
        }
        if (i2 == iJ || i3 == iG) {
            throw i.a();
        }
        return (i2 - iArr[0]) / 7.0f;
    }

    @Override // z0.k
    public final m a(C0381c c0381c, Map map) throws C0382d, C0384f, i {
        o[] oVarArrB;
        D0.e eVarB;
        if (map == null || !map.containsKey(EnumC0383e.PURE_BARCODE)) {
            g gVarE = new c(c0381c.a()).e(map);
            D0.e eVarB2 = this.f890a.b(gVarE.a(), map);
            oVarArrB = gVarE.b();
            eVarB = eVarB2;
        } else {
            eVarB = this.f890a.b(c(c0381c.a()), map);
            oVarArrB = f889b;
        }
        if (eVarB.d() instanceof U0.i) {
            ((U0.i) eVarB.d()).a(oVarArrB);
        }
        m mVar = new m(eVarB.h(), eVarB.e(), oVarArrB, EnumC0379a.QR_CODE);
        List listA = eVarB.a();
        if (listA != null) {
            mVar.h(n.BYTE_SEGMENTS, listA);
        }
        String strB = eVarB.b();
        if (strB != null) {
            mVar.h(n.ERROR_CORRECTION_LEVEL, strB);
        }
        if (eVarB.i()) {
            mVar.h(n.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(eVarB.g()));
            mVar.h(n.STRUCTURED_APPEND_PARITY, Integer.valueOf(eVarB.f()));
        }
        return mVar;
    }

    @Override // z0.k
    public void b() {
    }
}
