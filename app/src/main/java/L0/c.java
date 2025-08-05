package L0;

import java.util.Arrays;
import java.util.Map;
import z0.C0382d;
import z0.EnumC0379a;

/* loaded from: classes.dex */
public final class c extends k {
    static final int[] e = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, 145, 400, 208, 133, 388, 196, 168, 162, 138, 42};

    /* renamed from: a, reason: collision with root package name */
    private final boolean f286a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f287b;

    /* renamed from: c, reason: collision with root package name */
    private final StringBuilder f288c;

    /* renamed from: d, reason: collision with root package name */
    private final int[] f289d;

    public c() {
        this(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String h(java.lang.CharSequence r12) throws z0.C0384f {
        /*
            int r0 = r12.length()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            r2 = 0
            r3 = 0
        Lb:
            if (r3 >= r0) goto Lbf
            char r4 = r12.charAt(r3)
            r5 = 47
            r6 = 37
            r7 = 36
            r8 = 43
            if (r4 == r8) goto L27
            if (r4 == r7) goto L27
            if (r4 == r6) goto L27
            if (r4 != r5) goto L22
            goto L27
        L22:
            r1.append(r4)
            goto Lb6
        L27:
            int r3 = r3 + 1
            char r9 = r12.charAt(r3)
            r10 = 90
            r11 = 65
            if (r4 == r7) goto Lac
            r7 = 79
            if (r4 == r6) goto L5e
            if (r4 == r8) goto L52
            if (r4 == r5) goto L3e
        L3b:
            r4 = 0
            goto Lb3
        L3e:
            if (r9 < r11) goto L47
            if (r9 > r7) goto L47
            int r9 = r9 + (-32)
        L44:
            char r4 = (char) r9
            goto Lb3
        L47:
            if (r9 != r10) goto L4d
            r4 = 58
            goto Lb3
        L4d:
            z0.f r12 = z0.C0384f.a()
            throw r12
        L52:
            if (r9 < r11) goto L59
            if (r9 > r10) goto L59
            int r9 = r9 + 32
            goto L44
        L59:
            z0.f r12 = z0.C0384f.a()
            throw r12
        L5e:
            if (r9 < r11) goto L67
            r4 = 69
            if (r9 > r4) goto L67
            int r9 = r9 + (-38)
            goto L44
        L67:
            r4 = 70
            if (r9 < r4) goto L72
            r4 = 74
            if (r9 > r4) goto L72
            int r9 = r9 + (-11)
            goto L44
        L72:
            r4 = 75
            if (r9 < r4) goto L7b
            if (r9 > r7) goto L7b
            int r9 = r9 + 16
            goto L44
        L7b:
            r4 = 80
            if (r9 < r4) goto L86
            r4 = 84
            if (r9 > r4) goto L86
            int r9 = r9 + 43
            goto L44
        L86:
            r4 = 85
            if (r9 != r4) goto L8b
            goto L3b
        L8b:
            r4 = 86
            if (r9 != r4) goto L92
            r4 = 64
            goto Lb3
        L92:
            r4 = 87
            if (r9 != r4) goto L99
            r4 = 96
            goto Lb3
        L99:
            r4 = 88
            if (r9 == r4) goto La9
            r4 = 89
            if (r9 == r4) goto La9
            if (r9 != r10) goto La4
            goto La9
        La4:
            z0.f r12 = z0.C0384f.a()
            throw r12
        La9:
            r4 = 127(0x7f, float:1.78E-43)
            goto Lb3
        Lac:
            if (r9 < r11) goto Lba
            if (r9 > r10) goto Lba
            int r9 = r9 + (-64)
            goto L44
        Lb3:
            r1.append(r4)
        Lb6:
            int r3 = r3 + 1
            goto Lb
        Lba:
            z0.f r12 = z0.C0384f.a()
            throw r12
        Lbf:
            java.lang.String r12 = r1.toString()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: L0.c.h(java.lang.CharSequence):java.lang.String");
    }

    private static int[] i(D0.a aVar, int[] iArr) throws z0.i {
        int iG = aVar.g();
        int iE = aVar.e(0);
        int length = iArr.length;
        int i2 = iE;
        boolean z2 = false;
        int i3 = 0;
        while (iE < iG) {
            if (aVar.c(iE) != z2) {
                iArr[i3] = iArr[i3] + 1;
            } else {
                if (i3 != length - 1) {
                    i3++;
                } else {
                    if (k(iArr) == 148 && aVar.h(Math.max(0, i2 - ((iE - i2) / 2)), i2, false)) {
                        return new int[]{i2, iE};
                    }
                    i2 += iArr[0] + iArr[1];
                    int i4 = i3 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i4);
                    iArr[i4] = 0;
                    iArr[i3] = 0;
                    i3--;
                }
                iArr[i3] = 1;
                z2 = !z2;
            }
            iE++;
        }
        throw z0.i.a();
    }

    private static char j(int i2) throws z0.i {
        int i3 = 0;
        while (true) {
            int[] iArr = e;
            if (i3 >= iArr.length) {
                if (i2 == 148) {
                    return '*';
                }
                throw z0.i.a();
            }
            if (iArr[i3] == i2) {
                return "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i3);
            }
            i3++;
        }
    }

    private static int k(int[] iArr) {
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            int i3 = Integer.MAX_VALUE;
            for (int i4 : iArr) {
                if (i4 < i3 && i4 > i2) {
                    i3 = i4;
                }
            }
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < length; i8++) {
                int i9 = iArr[i8];
                if (i9 > i3) {
                    i6 |= 1 << ((length - 1) - i8);
                    i5++;
                    i7 += i9;
                }
            }
            if (i5 == 3) {
                for (int i10 = 0; i10 < length && i5 > 0; i10++) {
                    int i11 = iArr[i10];
                    if (i11 > i3) {
                        i5--;
                        if ((i11 << 1) >= i7) {
                            return -1;
                        }
                    }
                }
                return i6;
            }
            if (i5 <= 3) {
                return -1;
            }
            i2 = i3;
        }
    }

    @Override // L0.k
    public z0.m c(int i2, D0.a aVar, Map map) throws C0382d, z0.i {
        int[] iArr = this.f289d;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.f288c;
        sb.setLength(0);
        int iE = aVar.e(i(aVar, iArr)[1]);
        int iG = aVar.g();
        while (true) {
            k.f(aVar, iE, iArr);
            int iK = k(iArr);
            if (iK < 0) {
                throw z0.i.a();
            }
            char cJ = j(iK);
            sb.append(cJ);
            int i3 = iE;
            for (int i4 : iArr) {
                i3 += i4;
            }
            int iE2 = aVar.e(i3);
            if (cJ == '*') {
                sb.setLength(sb.length() - 1);
                int i5 = 0;
                for (int i6 : iArr) {
                    i5 += i6;
                }
                int i7 = (iE2 - iE) - i5;
                if (iE2 != iG && (i7 << 1) < i5) {
                    throw z0.i.a();
                }
                if (this.f286a) {
                    int length = sb.length() - 1;
                    int iIndexOf = 0;
                    for (int i8 = 0; i8 < length; i8++) {
                        iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(this.f288c.charAt(i8));
                    }
                    if (sb.charAt(length) != "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(iIndexOf % 43)) {
                        throw C0382d.a();
                    }
                    sb.setLength(length);
                }
                if (sb.length() == 0) {
                    throw z0.i.a();
                }
                float f2 = i2;
                return new z0.m(this.f287b ? h(sb) : sb.toString(), null, new z0.o[]{new z0.o((r2[1] + r2[0]) / 2.0f, f2), new z0.o(iE + (i5 / 2.0f), f2)}, EnumC0379a.CODE_39);
            }
            iE = iE2;
        }
    }

    public c(boolean z2) {
        this(z2, false);
    }

    public c(boolean z2, boolean z3) {
        this.f286a = z2;
        this.f287b = z3;
        this.f288c = new StringBuilder(20);
        this.f289d = new int[9];
    }
}
