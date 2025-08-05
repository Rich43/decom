package D0;

import z0.AbstractC0380b;

/* loaded from: classes.dex */
public final class j extends h {
    private b e;

    public j(z0.g gVar) {
        super(gVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x009c A[PHI: r5
  0x009c: PHI (r5v3 int) = (r5v2 int), (r5v6 int), (r5v6 int) binds: [B:31:0x007b, B:33:0x007f, B:34:0x0081] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int[][] i(byte[] r17, int r18, int r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 182
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: D0.j.i(byte[], int, int, int, int):int[][]");
    }

    private static void j(byte[] bArr, int i2, int i3, int i4, int i5, int[][] iArr, b bVar) {
        int i6 = i5 - 8;
        int i7 = i4 - 8;
        for (int i8 = 0; i8 < i3; i8++) {
            int i9 = i8 << 3;
            int i10 = i9 > i6 ? i6 : i9;
            int iK = k(i8, 2, i3 - 3);
            for (int i11 = 0; i11 < i2; i11++) {
                int i12 = i11 << 3;
                int i13 = i12 > i7 ? i7 : i12;
                int iK2 = k(i11, 2, i2 - 3);
                int i14 = 0;
                for (int i15 = -2; i15 <= 2; i15++) {
                    int[] iArr2 = iArr[iK + i15];
                    i14 += iArr2[iK2 - 2] + iArr2[iK2 - 1] + iArr2[iK2] + iArr2[iK2 + 1] + iArr2[iK2 + 2];
                }
                l(bArr, i13, i10, i14 / 25, i4, bVar);
            }
        }
    }

    private static int k(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
    }

    private static void l(byte[] bArr, int i2, int i3, int i4, int i5, b bVar) {
        int i6 = (i3 * i5) + i2;
        int i7 = 0;
        while (i7 < 8) {
            for (int i8 = 0; i8 < 8; i8++) {
                if ((bArr[i6 + i8] & 255) <= i4) {
                    bVar.l(i2 + i8, i3 + i7);
                }
            }
            i7++;
            i6 += i5;
        }
    }

    @Override // D0.h, z0.AbstractC0380b
    public AbstractC0380b a(z0.g gVar) {
        return new j(gVar);
    }

    @Override // D0.h, z0.AbstractC0380b
    public b b() {
        b bVar = this.e;
        if (bVar != null) {
            return bVar;
        }
        z0.g gVarE = e();
        int iD = gVarE.d();
        int iA = gVarE.a();
        if (iD < 40 || iA < 40) {
            this.e = super.b();
        } else {
            byte[] bArrB = gVarE.b();
            int i2 = iD >> 3;
            if ((iD & 7) != 0) {
                i2++;
            }
            int i3 = i2;
            int i4 = iA >> 3;
            if ((iA & 7) != 0) {
                i4++;
            }
            int i5 = i4;
            int[][] iArrI = i(bArrB, i3, i5, iD, iA);
            b bVar2 = new b(iD, iA);
            j(bArrB, i3, i5, iD, iA, iArrI, bVar2);
            this.e = bVar2;
        }
        return this.e;
    }
}
