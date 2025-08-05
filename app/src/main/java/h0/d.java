package H0;

import z0.C0382d;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final F0.c f223a = new F0.c(F0.a.f187m);

    private void a(byte[] bArr, int i2) throws C0382d {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & 255;
        }
        try {
            this.f223a.a(iArr, bArr.length - i2);
            for (int i4 = 0; i4 < i2; i4++) {
                bArr[i4] = (byte) iArr[i4];
            }
        } catch (F0.d unused) {
            throw C0382d.a();
        }
    }

    public D0.e b(D0.b bVar) throws C0382d {
        a aVar = new a(bVar);
        b[] bVarArrB = b.b(aVar.c(), aVar.b());
        int iC = 0;
        for (b bVar2 : bVarArrB) {
            iC += bVar2.c();
        }
        byte[] bArr = new byte[iC];
        int length = bVarArrB.length;
        for (int i2 = 0; i2 < length; i2++) {
            b bVar3 = bVarArrB[i2];
            byte[] bArrA = bVar3.a();
            int iC2 = bVar3.c();
            a(bArrA, iC2);
            for (int i3 = 0; i3 < iC2; i3++) {
                bArr[(i3 * length) + i2] = bArrA[i3];
            }
        }
        return c.a(bArr);
    }
}
