package D0;

import z0.AbstractC0380b;

/* loaded from: classes.dex */
public class h extends AbstractC0380b {

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f125d = new byte[0];

    /* renamed from: b, reason: collision with root package name */
    private byte[] f126b;

    /* renamed from: c, reason: collision with root package name */
    private final int[] f127c;

    public h(z0.g gVar) {
        super(gVar);
        this.f126b = f125d;
        this.f127c = new int[32];
    }

    private static int g(int[] iArr) throws z0.i {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            int i6 = iArr[i5];
            if (i6 > i2) {
                i4 = i5;
                i2 = i6;
            }
            if (i6 > i3) {
                i3 = i6;
            }
        }
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < length; i9++) {
            int i10 = i9 - i4;
            int i11 = iArr[i9] * i10 * i10;
            if (i11 > i8) {
                i7 = i9;
                i8 = i11;
            }
        }
        if (i4 <= i7) {
            int i12 = i4;
            i4 = i7;
            i7 = i12;
        }
        if (i4 - i7 <= length / 16) {
            throw z0.i.a();
        }
        int i13 = i4 - 1;
        int i14 = i13;
        int i15 = -1;
        while (i13 > i7) {
            int i16 = i13 - i7;
            int i17 = i16 * i16 * (i4 - i13) * (i3 - iArr[i13]);
            if (i17 > i15) {
                i14 = i13;
                i15 = i17;
            }
            i13--;
        }
        return i14 << 3;
    }

    private void h(int i2) {
        if (this.f126b.length < i2) {
            this.f126b = new byte[i2];
        }
        for (int i3 = 0; i3 < 32; i3++) {
            this.f127c[i3] = 0;
        }
    }

    @Override // z0.AbstractC0380b
    public AbstractC0380b a(z0.g gVar) {
        return new h(gVar);
    }

    @Override // z0.AbstractC0380b
    public b b() throws z0.i {
        z0.g gVarE = e();
        int iD = gVarE.d();
        int iA = gVarE.a();
        b bVar = new b(iD, iA);
        h(iD);
        int[] iArr = this.f127c;
        for (int i2 = 1; i2 < 5; i2++) {
            byte[] bArrC = gVarE.c((iA * i2) / 5, this.f126b);
            int i3 = (iD << 2) / 5;
            for (int i4 = iD / 5; i4 < i3; i4++) {
                int i5 = (bArrC[i4] & 255) >> 3;
                iArr[i5] = iArr[i5] + 1;
            }
        }
        int iG = g(iArr);
        byte[] bArrB = gVarE.b();
        for (int i6 = 0; i6 < iA; i6++) {
            int i7 = i6 * iD;
            for (int i8 = 0; i8 < iD; i8++) {
                if ((bArrB[i7 + i8] & 255) < iG) {
                    bVar.l(i8, i6);
                }
            }
        }
        return bVar;
    }

    @Override // z0.AbstractC0380b
    public a c(int i2, a aVar) throws z0.i {
        z0.g gVarE = e();
        int iD = gVarE.d();
        if (aVar == null || aVar.g() < iD) {
            aVar = new a(iD);
        } else {
            aVar.a();
        }
        h(iD);
        byte[] bArrC = gVarE.c(i2, this.f126b);
        int[] iArr = this.f127c;
        for (int i3 = 0; i3 < iD; i3++) {
            int i4 = (bArrC[i3] & 255) >> 3;
            iArr[i4] = iArr[i4] + 1;
        }
        int iG = g(iArr);
        if (iD < 3) {
            for (int i5 = 0; i5 < iD; i5++) {
                if ((bArrC[i5] & 255) < iG) {
                    aVar.k(i5);
                }
            }
        } else {
            int i6 = 1;
            int i7 = bArrC[0] & 255;
            int i8 = bArrC[1] & 255;
            while (i6 < iD - 1) {
                int i9 = i6 + 1;
                int i10 = bArrC[i9] & 255;
                if ((((i8 << 2) - i7) - i10) / 2 < iG) {
                    aVar.k(i6);
                }
                i7 = i8;
                i6 = i9;
                i8 = i10;
            }
        }
        return aVar;
    }
}
