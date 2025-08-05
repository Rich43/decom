package S0;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import z0.C0381c;
import z0.o;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f843a = {0, 4, 1, 5};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f844b = {6, 2, 7, 3};

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f845c = {8, 1, 1, 1, 1, 1, 1, 3};

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f846d = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    private static void a(o[] oVarArr, o[] oVarArr2, int[] iArr) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            oVarArr[iArr[i2]] = oVarArr2[i2];
        }
    }

    public static b b(C0381c c0381c, Map map, boolean z2) {
        D0.b bVarA = c0381c.a();
        List listC = c(z2, bVarA);
        if (listC.isEmpty()) {
            bVarA = bVarA.clone();
            bVarA.k();
            listC = c(z2, bVarA);
        }
        return new b(bVarA, listC);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (r4 == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
    
        r3 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
    
        if (r3.hasNext() == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        r4 = (z0.o[]) r3.next();
        r7 = r4[1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
    
        if (r7 == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
    
        r2 = (int) java.lang.Math.max(r2, r7.d());
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003d, code lost:
    
        r4 = r4[3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
    
        if (r4 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
    
        r2 = java.lang.Math.max(r2, (int) r4.d());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List c(boolean r8, D0.b r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            r2 = 0
        L7:
            r3 = 0
            r4 = 0
        L9:
            int r5 = r9.g()
            if (r2 >= r5) goto L76
            z0.o[] r3 = f(r9, r2, r3)
            r5 = r3[r1]
            r6 = 1
            if (r5 != 0) goto L4e
            r5 = 3
            r7 = r3[r5]
            if (r7 != 0) goto L4e
            if (r4 == 0) goto L76
            java.util.Iterator r3 = r0.iterator()
        L23:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L4b
            java.lang.Object r4 = r3.next()
            z0.o[] r4 = (z0.o[]) r4
            r7 = r4[r6]
            if (r7 == 0) goto L3d
            float r2 = (float) r2
            float r7 = r7.d()
            float r2 = java.lang.Math.max(r2, r7)
            int r2 = (int) r2
        L3d:
            r4 = r4[r5]
            if (r4 == 0) goto L23
            float r4 = r4.d()
            int r4 = (int) r4
            int r2 = java.lang.Math.max(r2, r4)
            goto L23
        L4b:
            int r2 = r2 + 5
            goto L7
        L4e:
            r0.add(r3)
            if (r8 == 0) goto L76
            r2 = 2
            r4 = r3[r2]
            if (r4 == 0) goto L67
            float r4 = r4.c()
            int r4 = (int) r4
            r2 = r3[r2]
            float r2 = r2.d()
        L63:
            int r2 = (int) r2
            r3 = r4
            r4 = 1
            goto L9
        L67:
            r2 = 4
            r4 = r3[r2]
            float r4 = r4.c()
            int r4 = (int) r4
            r2 = r3[r2]
            float r2 = r2.d()
            goto L63
        L76:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: S0.a.c(boolean, D0.b):java.util.List");
    }

    private static int[] d(D0.b bVar, int i2, int i3, int i4, boolean z2, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i5 = 0;
        while (bVar.d(i2, i3) && i2 > 0) {
            int i6 = i5 + 1;
            if (i5 >= 3) {
                break;
            }
            i2--;
            i5 = i6;
        }
        int length = iArr.length;
        boolean z3 = z2;
        int i7 = 0;
        int i8 = i2;
        while (i2 < i4) {
            if (bVar.d(i2, i3) != z3) {
                iArr2[i7] = iArr2[i7] + 1;
            } else {
                if (i7 != length - 1) {
                    i7++;
                } else {
                    if (g(iArr2, iArr, 0.8f) < 0.42f) {
                        return new int[]{i8, i2};
                    }
                    i8 += iArr2[0] + iArr2[1];
                    int i9 = i7 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i9);
                    iArr2[i9] = 0;
                    iArr2[i7] = 0;
                    i7--;
                }
                iArr2[i7] = 1;
                z3 = !z3;
            }
            i2++;
        }
        if (i7 != length - 1 || g(iArr2, iArr, 0.8f) >= 0.42f) {
            return null;
        }
        return new int[]{i8, i2 - 1};
    }

    private static o[] e(D0.b bVar, int i2, int i3, int i4, int i5, int[] iArr) {
        boolean z2;
        int i6;
        int i7;
        o[] oVarArr = new o[4];
        int[] iArr2 = new int[iArr.length];
        int i8 = i4;
        while (true) {
            if (i8 >= i2) {
                z2 = false;
                break;
            }
            int[] iArrD = d(bVar, i5, i8, i3, false, iArr, iArr2);
            if (iArrD != null) {
                int i9 = i8;
                int[] iArr3 = iArrD;
                while (i9 > 0) {
                    int i10 = i9 - 1;
                    int[] iArrD2 = d(bVar, i5, i10, i3, false, iArr, iArr2);
                    if (iArrD2 == null) {
                        break;
                    }
                    iArr3 = iArrD2;
                    i9 = i10;
                }
                float f2 = i9;
                oVarArr[0] = new o(iArr3[0], f2);
                oVarArr[1] = new o(iArr3[1], f2);
                i8 = i9;
                z2 = true;
            } else {
                i8 += 5;
            }
        }
        int i11 = i8 + 1;
        if (z2) {
            int[] iArr4 = {(int) oVarArr[0].c(), (int) oVarArr[1].c()};
            int i12 = i11;
            int i13 = 0;
            while (true) {
                if (i12 >= i2) {
                    i6 = i13;
                    i7 = i12;
                    break;
                }
                i6 = i13;
                i7 = i12;
                int[] iArrD3 = d(bVar, iArr4[0], i12, i3, false, iArr, iArr2);
                if (iArrD3 != null && Math.abs(iArr4[0] - iArrD3[0]) < 5 && Math.abs(iArr4[1] - iArrD3[1]) < 5) {
                    iArr4 = iArrD3;
                    i13 = 0;
                } else {
                    if (i6 > 25) {
                        break;
                    }
                    i13 = i6 + 1;
                }
                i12 = i7 + 1;
            }
            i11 = i7 - (i6 + 1);
            float f3 = i11;
            oVarArr[2] = new o(iArr4[0], f3);
            oVarArr[3] = new o(iArr4[1], f3);
        }
        if (i11 - i8 < 10) {
            Arrays.fill(oVarArr, (Object) null);
        }
        return oVarArr;
    }

    private static o[] f(D0.b bVar, int i2, int i3) {
        int iG = bVar.g();
        int iJ = bVar.j();
        o[] oVarArr = new o[8];
        a(oVarArr, e(bVar, iG, iJ, i2, i3, f845c), f843a);
        o oVar = oVarArr[4];
        if (oVar != null) {
            i3 = (int) oVar.c();
            i2 = (int) oVarArr[4].d();
        }
        a(oVarArr, e(bVar, iG, iJ, i2, i3, f846d), f844b);
        return oVarArr;
    }

    private static float g(int[] iArr, int[] iArr2, float f2) {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            i2 += iArr[i4];
            i3 += iArr2[i4];
        }
        if (i2 < i3) {
            return Float.POSITIVE_INFINITY;
        }
        float f3 = i2;
        float f4 = f3 / i3;
        float f5 = f2 * f4;
        float f6 = 0.0f;
        for (int i5 = 0; i5 < length; i5++) {
            float f7 = iArr2[i5] * f4;
            float f8 = iArr[i5];
            float f9 = f8 > f7 ? f8 - f7 : f7 - f8;
            if (f9 > f5) {
                return Float.POSITIVE_INFINITY;
            }
            f6 += f9;
        }
        return f6 / f3;
    }
}
