package L0;

import java.util.Arrays;
import java.util.Map;
import z0.EnumC0379a;
import z0.EnumC0383e;

/* loaded from: classes.dex */
public final class a extends k {

    /* renamed from: d, reason: collision with root package name */
    static final char[] f280d = "0123456789-$:/.+ABCD".toCharArray();
    static final int[] e = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};

    /* renamed from: f, reason: collision with root package name */
    private static final char[] f281f = {'A', 'B', 'C', 'D'};

    /* renamed from: a, reason: collision with root package name */
    private final StringBuilder f282a = new StringBuilder(20);

    /* renamed from: b, reason: collision with root package name */
    private int[] f283b = new int[80];

    /* renamed from: c, reason: collision with root package name */
    private int f284c = 0;

    static boolean h(char[] cArr, char c2) {
        if (cArr != null) {
            for (char c3 : cArr) {
                if (c3 == c2) {
                    return true;
                }
            }
        }
        return false;
    }

    private void i(int i2) {
        int[] iArr = this.f283b;
        int i3 = this.f284c;
        iArr[i3] = i2;
        int i4 = i3 + 1;
        this.f284c = i4;
        if (i4 >= iArr.length) {
            int[] iArr2 = new int[i4 << 1];
            System.arraycopy(iArr, 0, iArr2, 0, i4);
            this.f283b = iArr2;
        }
    }

    private int j() throws z0.i {
        for (int i2 = 1; i2 < this.f284c; i2 += 2) {
            int iL = l(i2);
            if (iL != -1 && h(f281f, f280d[iL])) {
                int i3 = 0;
                for (int i4 = i2; i4 < i2 + 7; i4++) {
                    i3 += this.f283b[i4];
                }
                if (i2 == 1 || this.f283b[i2 - 1] >= i3 / 2) {
                    return i2;
                }
            }
        }
        throw z0.i.a();
    }

    private void k(D0.a aVar) throws z0.i {
        int i2 = 0;
        this.f284c = 0;
        int iF = aVar.f(0);
        int iG = aVar.g();
        if (iF >= iG) {
            throw z0.i.a();
        }
        boolean z2 = true;
        while (iF < iG) {
            if (aVar.c(iF) != z2) {
                i2++;
            } else {
                i(i2);
                z2 = !z2;
                i2 = 1;
            }
            iF++;
        }
        i(i2);
    }

    private int l(int i2) {
        int i3 = i2 + 7;
        if (i3 >= this.f284c) {
            return -1;
        }
        int[] iArr = this.f283b;
        int i4 = Integer.MAX_VALUE;
        int i5 = 0;
        int i6 = Integer.MAX_VALUE;
        int i7 = 0;
        for (int i8 = i2; i8 < i3; i8 += 2) {
            int i9 = iArr[i8];
            if (i9 < i6) {
                i6 = i9;
            }
            if (i9 > i7) {
                i7 = i9;
            }
        }
        int i10 = (i6 + i7) / 2;
        int i11 = 0;
        for (int i12 = i2 + 1; i12 < i3; i12 += 2) {
            int i13 = iArr[i12];
            if (i13 < i4) {
                i4 = i13;
            }
            if (i13 > i11) {
                i11 = i13;
            }
        }
        int i14 = (i4 + i11) / 2;
        int i15 = 128;
        int i16 = 0;
        for (int i17 = 0; i17 < 7; i17++) {
            i15 >>= 1;
            if (iArr[i2 + i17] > ((i17 & 1) == 0 ? i10 : i14)) {
                i16 |= i15;
            }
        }
        while (true) {
            int[] iArr2 = e;
            if (i5 >= iArr2.length) {
                return -1;
            }
            if (iArr2[i5] == i16) {
                return i5;
            }
            i5++;
        }
    }

    private void m(int i2) throws z0.i {
        int[] iArr = new int[4];
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        int[] iArr2 = new int[4];
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int length = this.f282a.length() - 1;
        int i3 = i2;
        int i4 = 0;
        while (true) {
            int i5 = e[this.f282a.charAt(i4)];
            for (int i6 = 6; i6 >= 0; i6--) {
                int i7 = (i6 & 1) + ((i5 & 1) << 1);
                iArr[i7] = iArr[i7] + this.f283b[i3 + i6];
                iArr2[i7] = iArr2[i7] + 1;
                i5 >>= 1;
            }
            if (i4 >= length) {
                break;
            }
            i3 += 8;
            i4++;
        }
        float[] fArr = new float[4];
        float[] fArr2 = new float[4];
        for (int i8 = 0; i8 < 2; i8++) {
            fArr2[i8] = 0.0f;
            int i9 = i8 + 2;
            int i10 = iArr[i9];
            int i11 = iArr2[i9];
            float f2 = ((iArr[i8] / iArr2[i8]) + (i10 / i11)) / 2.0f;
            fArr2[i9] = f2;
            fArr[i8] = f2;
            fArr[i9] = ((i10 * 2.0f) + 1.5f) / i11;
        }
        int i12 = i2;
        int i13 = 0;
        loop3: while (true) {
            int i14 = e[this.f282a.charAt(i13)];
            for (int i15 = 6; i15 >= 0; i15--) {
                int i16 = (i15 & 1) + ((i14 & 1) << 1);
                float f3 = this.f283b[i12 + i15];
                if (f3 < fArr2[i16] || f3 > fArr[i16]) {
                    break loop3;
                }
                i14 >>= 1;
            }
            if (i13 >= length) {
                return;
            }
            i12 += 8;
            i13++;
        }
        throw z0.i.a();
    }

    @Override // L0.k
    public z0.m c(int i2, D0.a aVar, Map map) throws z0.i {
        int i3;
        Arrays.fill(this.f283b, 0);
        k(aVar);
        int iJ = j();
        this.f282a.setLength(0);
        int i4 = iJ;
        while (true) {
            int iL = l(i4);
            if (iL == -1) {
                throw z0.i.a();
            }
            this.f282a.append((char) iL);
            i3 = i4 + 8;
            if ((this.f282a.length() > 1 && h(f281f, f280d[iL])) || i3 >= this.f284c) {
                break;
            }
            i4 = i3;
        }
        int i5 = i4 + 7;
        int i6 = this.f283b[i5];
        int i7 = 0;
        for (int i8 = -8; i8 < -1; i8++) {
            i7 += this.f283b[i3 + i8];
        }
        if (i3 < this.f284c && i6 < i7 / 2) {
            throw z0.i.a();
        }
        m(iJ);
        for (int i9 = 0; i9 < this.f282a.length(); i9++) {
            StringBuilder sb = this.f282a;
            sb.setCharAt(i9, f280d[sb.charAt(i9)]);
        }
        char cCharAt = this.f282a.charAt(0);
        char[] cArr = f281f;
        if (!h(cArr, cCharAt)) {
            throw z0.i.a();
        }
        StringBuilder sb2 = this.f282a;
        if (!h(cArr, sb2.charAt(sb2.length() - 1))) {
            throw z0.i.a();
        }
        if (this.f282a.length() <= 3) {
            throw z0.i.a();
        }
        if (map == null || !map.containsKey(EnumC0383e.RETURN_CODABAR_START_END)) {
            StringBuilder sb3 = this.f282a;
            sb3.deleteCharAt(sb3.length() - 1);
            this.f282a.deleteCharAt(0);
        }
        int i10 = 0;
        for (int i11 = 0; i11 < iJ; i11++) {
            i10 += this.f283b[i11];
        }
        float f2 = i10;
        while (iJ < i5) {
            i10 += this.f283b[iJ];
            iJ++;
        }
        float f3 = i2;
        return new z0.m(this.f282a.toString(), null, new z0.o[]{new z0.o(f2, f3), new z0.o(i10, f3)}, EnumC0379a.CODABAR);
    }
}
