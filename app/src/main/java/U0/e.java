package U0;

import java.util.Map;
import z0.C0382d;
import z0.C0384f;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final F0.c f915a = new F0.c(F0.a.f186l);

    private void a(byte[] bArr, int i2) throws C0382d {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & 255;
        }
        try {
            this.f915a.a(iArr, bArr.length - i2);
            for (int i4 = 0; i4 < i2; i4++) {
                bArr[i4] = (byte) iArr[i4];
            }
        } catch (F0.d unused) {
            throw C0382d.a();
        }
    }

    private D0.e c(a aVar, Map map) throws C0382d, C0384f {
        j jVarE = aVar.e();
        f fVarD = aVar.d().d();
        b[] bVarArrB = b.b(aVar.c(), jVarE, fVarD);
        int iC = 0;
        for (b bVar : bVarArrB) {
            iC += bVar.c();
        }
        byte[] bArr = new byte[iC];
        int i2 = 0;
        for (b bVar2 : bVarArrB) {
            byte[] bArrA = bVar2.a();
            int iC2 = bVar2.c();
            a(bArrA, iC2);
            int i3 = 0;
            while (i3 < iC2) {
                bArr[i2] = bArrA[i3];
                i3++;
                i2++;
            }
        }
        return d.a(bArr, jVarE, fVarD, map);
    }

    public D0.e b(D0.b bVar, Map map) throws C0382d, C0384f {
        C0382d e;
        a aVar = new a(bVar);
        C0384f c0384f = null;
        try {
            return c(aVar, map);
        } catch (C0382d e2) {
            e = e2;
            try {
                aVar.f();
                aVar.g(true);
                aVar.e();
                aVar.d();
                aVar.b();
                D0.e eVarC = c(aVar, map);
                eVarC.m(new i(true));
                return eVarC;
            } catch (C0382d | C0384f unused) {
                if (c0384f != null) {
                    throw c0384f;
                }
                throw e;
            }
        } catch (C0384f e3) {
            e = null;
            c0384f = e3;
            aVar.f();
            aVar.g(true);
            aVar.e();
            aVar.d();
            aVar.b();
            D0.e eVarC2 = c(aVar, map);
            eVarC2.m(new i(true));
            return eVarC2;
        }
    }
}
