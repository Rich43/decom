package L0;

/* loaded from: classes.dex */
public final class b extends k {

    /* renamed from: a, reason: collision with root package name */
    static final int[][] f285a = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};

    private static int h(D0.a aVar, int[] iArr, int i2) throws z0.i {
        k.f(aVar, i2, iArr);
        float f2 = 0.25f;
        int i3 = -1;
        int i4 = 0;
        while (true) {
            int[][] iArr2 = f285a;
            if (i4 >= iArr2.length) {
                break;
            }
            float fE = k.e(iArr, iArr2[i4], 0.7f);
            if (fE < f2) {
                i3 = i4;
                f2 = fE;
            }
            i4++;
        }
        if (i3 >= 0) {
            return i3;
        }
        throw z0.i.a();
    }

    private static int[] i(D0.a aVar) throws z0.i {
        int iG = aVar.g();
        int iE = aVar.e(0);
        int[] iArr = new int[6];
        int i2 = iE;
        boolean z2 = false;
        int i3 = 0;
        while (iE < iG) {
            if (aVar.c(iE) != z2) {
                iArr[i3] = iArr[i3] + 1;
            } else {
                if (i3 == 5) {
                    int i4 = -1;
                    float f2 = 0.25f;
                    for (int i5 = 103; i5 <= 105; i5++) {
                        float fE = k.e(iArr, f285a[i5], 0.7f);
                        if (fE < f2) {
                            i4 = i5;
                            f2 = fE;
                        }
                    }
                    if (i4 >= 0 && aVar.h(Math.max(0, i2 - ((iE - i2) / 2)), i2, false)) {
                        return new int[]{i2, iE, i4};
                    }
                    i2 += iArr[0] + iArr[1];
                    int i6 = i3 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i6);
                    iArr[i6] = 0;
                    iArr[i3] = 0;
                    i3--;
                } else {
                    i3++;
                }
                iArr[i3] = 1;
                z2 = !z2;
            }
            iE++;
        }
        throw z0.i.a();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e3 A[PHI: r21
  0x00e3: PHI (r21v13 boolean) = (r21v6 boolean), (r21v16 boolean) binds: [B:86:0x013a, B:54:0x00e1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e7 A[PHI: r21
  0x00e7: PHI (r21v12 boolean) = (r21v6 boolean), (r21v6 boolean), (r21v16 boolean), (r21v16 boolean) binds: [B:85:0x0138, B:86:0x013a, B:53:0x00df, B:54:0x00e1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00f1 A[PHI: r21
  0x00f1: PHI (r21v10 boolean) = (r21v6 boolean), (r21v16 boolean) binds: [B:72:0x0119, B:43:0x00c3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00fc A[PHI: r21
  0x00fc: PHI (r21v8 boolean) = (r21v6 boolean), (r21v16 boolean) binds: [B:71:0x0117, B:42:0x00c1] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // L0.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public z0.m c(int r26, D0.a r27, java.util.Map r28) throws z0.C0382d, z0.C0384f, z0.i {
        /*
            Method dump skipped, instructions count: 632
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: L0.b.c(int, D0.a, java.util.Map):z0.m");
    }
}
