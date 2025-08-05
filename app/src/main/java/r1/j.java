package r1;

import java.util.Arrays;

/* loaded from: classes.dex */
final class j extends d {

    /* renamed from: f */
    final transient byte[][] f7387f;

    /* renamed from: g */
    final transient int[] f7388g;

    j(a aVar, int i2) {
        super(null);
        m.b(aVar.f7366b, 0L, i2);
        h hVar = aVar.f7365a;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            int i6 = hVar.f7381c;
            int i7 = hVar.f7380b;
            if (i6 == i7) {
                throw new AssertionError("s.limit == s.pos");
            }
            i4 += i6 - i7;
            i5++;
            hVar = hVar.f7383f;
        }
        this.f7387f = new byte[i5][];
        this.f7388g = new int[i5 * 2];
        h hVar2 = aVar.f7365a;
        int i8 = 0;
        while (i3 < i2) {
            byte[][] bArr = this.f7387f;
            bArr[i8] = hVar2.f7379a;
            int i9 = hVar2.f7381c;
            int i10 = hVar2.f7380b;
            i3 += i9 - i10;
            if (i3 > i2) {
                i3 = i2;
            }
            int[] iArr = this.f7388g;
            iArr[i8] = i3;
            iArr[bArr.length + i8] = i10;
            hVar2.f7382d = true;
            i8++;
            hVar2 = hVar2.f7383f;
        }
    }

    private int n(int i2) {
        int iBinarySearch = Arrays.binarySearch(this.f7388g, 0, this.f7387f.length, i2 + 1);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    private d p() {
        return new d(o());
    }

    @Override // r1.d
    public byte d(int i2) {
        m.b(this.f7388g[this.f7387f.length - 1], i2, 1L);
        int iN = n(i2);
        int i3 = iN == 0 ? 0 : this.f7388g[iN - 1];
        int[] iArr = this.f7388g;
        byte[][] bArr = this.f7387f;
        return bArr[iN][(i2 - i3) + iArr[bArr.length + iN]];
    }

    @Override // r1.d
    public String e() {
        return p().e();
    }

    @Override // r1.d
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (dVar.j() == j() && h(0, dVar, 0, j())) {
                return true;
            }
        }
        return false;
    }

    @Override // r1.d
    byte[] f() {
        return o();
    }

    @Override // r1.d
    public boolean h(int i2, d dVar, int i3, int i4) {
        if (i2 < 0 || i2 > j() - i4) {
            return false;
        }
        int iN = n(i2);
        while (i4 > 0) {
            int i5 = iN == 0 ? 0 : this.f7388g[iN - 1];
            int iMin = Math.min(i4, ((this.f7388g[iN] - i5) + i5) - i2);
            int[] iArr = this.f7388g;
            byte[][] bArr = this.f7387f;
            if (!dVar.i(i3, bArr[iN], (i2 - i5) + iArr[bArr.length + iN], iMin)) {
                return false;
            }
            i2 += iMin;
            i3 += iMin;
            i4 -= iMin;
            iN++;
        }
        return true;
    }

    @Override // r1.d
    public int hashCode() {
        int i2 = this.f7369b;
        if (i2 != 0) {
            return i2;
        }
        int length = this.f7387f.length;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        while (i3 < length) {
            byte[] bArr = this.f7387f[i3];
            int[] iArr = this.f7388g;
            int i6 = iArr[length + i3];
            int i7 = iArr[i3];
            int i8 = (i7 - i4) + i6;
            while (i6 < i8) {
                i5 = (i5 * 31) + bArr[i6];
                i6++;
            }
            i3++;
            i4 = i7;
        }
        this.f7369b = i5;
        return i5;
    }

    @Override // r1.d
    public boolean i(int i2, byte[] bArr, int i3, int i4) {
        if (i2 < 0 || i2 > j() - i4 || i3 < 0 || i3 > bArr.length - i4) {
            return false;
        }
        int iN = n(i2);
        while (i4 > 0) {
            int i5 = iN == 0 ? 0 : this.f7388g[iN - 1];
            int iMin = Math.min(i4, ((this.f7388g[iN] - i5) + i5) - i2);
            int[] iArr = this.f7388g;
            byte[][] bArr2 = this.f7387f;
            if (!m.a(bArr2[iN], (i2 - i5) + iArr[bArr2.length + iN], bArr, i3, iMin)) {
                return false;
            }
            i2 += iMin;
            i3 += iMin;
            i4 -= iMin;
            iN++;
        }
        return true;
    }

    @Override // r1.d
    public int j() {
        return this.f7388g[this.f7387f.length - 1];
    }

    @Override // r1.d
    public d l(int i2, int i3) {
        return p().l(i2, i3);
    }

    @Override // r1.d
    public String m() {
        return p().m();
    }

    public byte[] o() {
        int[] iArr = this.f7388g;
        byte[][] bArr = this.f7387f;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int[] iArr2 = this.f7388g;
            int i4 = iArr2[length + i2];
            int i5 = iArr2[i2];
            System.arraycopy(this.f7387f[i2], i4, bArr2, i3, i5 - i3);
            i2++;
            i3 = i5;
        }
        return bArr2;
    }

    @Override // r1.d
    public String toString() {
        return p().toString();
    }
}
