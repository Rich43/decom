package D0;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class a implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private int[] f77a;

    /* renamed from: b, reason: collision with root package name */
    private int f78b;

    public a(int i2) {
        this.f78b = i2;
        this.f77a = i(i2);
    }

    private static int[] i(int i2) {
        return new int[(i2 + 31) / 32];
    }

    public void a() {
        int length = this.f77a.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.f77a[i2] = 0;
        }
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a clone() {
        return new a((int[]) this.f77a.clone(), this.f78b);
    }

    public boolean c(int i2) {
        return ((1 << (i2 & 31)) & this.f77a[i2 / 32]) != 0;
    }

    public int[] d() {
        return this.f77a;
    }

    public int e(int i2) {
        int i3 = this.f78b;
        if (i2 >= i3) {
            return i3;
        }
        int i4 = i2 / 32;
        int i5 = (~((1 << (i2 & 31)) - 1)) & this.f77a[i4];
        while (i5 == 0) {
            i4++;
            int[] iArr = this.f77a;
            if (i4 == iArr.length) {
                return this.f78b;
            }
            i5 = iArr[i4];
        }
        int iNumberOfTrailingZeros = (i4 << 5) + Integer.numberOfTrailingZeros(i5);
        int i6 = this.f78b;
        return iNumberOfTrailingZeros > i6 ? i6 : iNumberOfTrailingZeros;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f78b == aVar.f78b && Arrays.equals(this.f77a, aVar.f77a);
    }

    public int f(int i2) {
        int i3 = this.f78b;
        if (i2 >= i3) {
            return i3;
        }
        int i4 = i2 / 32;
        int i5 = (~((1 << (i2 & 31)) - 1)) & (~this.f77a[i4]);
        while (i5 == 0) {
            i4++;
            int[] iArr = this.f77a;
            if (i4 == iArr.length) {
                return this.f78b;
            }
            i5 = ~iArr[i4];
        }
        int iNumberOfTrailingZeros = (i4 << 5) + Integer.numberOfTrailingZeros(i5);
        int i6 = this.f78b;
        return iNumberOfTrailingZeros > i6 ? i6 : iNumberOfTrailingZeros;
    }

    public int g() {
        return this.f78b;
    }

    public boolean h(int i2, int i3, boolean z2) {
        if (i3 < i2 || i2 < 0 || i3 > this.f78b) {
            throw new IllegalArgumentException();
        }
        if (i3 == i2) {
            return true;
        }
        int i4 = i3 - 1;
        int i5 = i2 / 32;
        int i6 = i4 / 32;
        int i7 = i5;
        while (i7 <= i6) {
            int i8 = (2 << (i7 >= i6 ? 31 & i4 : 31)) - (1 << (i7 > i5 ? 0 : i2 & 31));
            int i9 = this.f77a[i7] & i8;
            if (!z2) {
                i8 = 0;
            }
            if (i9 != i8) {
                return false;
            }
            i7++;
        }
        return true;
    }

    public int hashCode() {
        return (this.f78b * 31) + Arrays.hashCode(this.f77a);
    }

    public void j() {
        int[] iArr = new int[this.f77a.length];
        int i2 = (this.f78b - 1) / 32;
        int i3 = i2 + 1;
        for (int i4 = 0; i4 < i3; i4++) {
            long j2 = this.f77a[i4];
            long j3 = ((j2 & 1431655765) << 1) | ((j2 >> 1) & 1431655765);
            long j4 = ((j3 & 858993459) << 2) | ((j3 >> 2) & 858993459);
            long j5 = ((j4 & 252645135) << 4) | ((j4 >> 4) & 252645135);
            long j6 = ((j5 & 16711935) << 8) | ((j5 >> 8) & 16711935);
            iArr[i2 - i4] = (int) (((j6 & 65535) << 16) | ((j6 >> 16) & 65535));
        }
        int i5 = this.f78b;
        int i6 = i3 << 5;
        if (i5 != i6) {
            int i7 = i6 - i5;
            int i8 = iArr[0] >>> i7;
            for (int i9 = 1; i9 < i3; i9++) {
                int i10 = iArr[i9];
                iArr[i9 - 1] = i8 | (i10 << (32 - i7));
                i8 = i10 >>> i7;
            }
            iArr[i2] = i8;
        }
        this.f77a = iArr;
    }

    public void k(int i2) {
        int[] iArr = this.f77a;
        int i3 = i2 / 32;
        iArr[i3] = (1 << (i2 & 31)) | iArr[i3];
    }

    public void l(int i2, int i3) {
        this.f77a[i2 / 32] = i3;
    }

    public String toString() {
        int i2 = this.f78b;
        StringBuilder sb = new StringBuilder(i2 + (i2 / 8) + 1);
        for (int i3 = 0; i3 < this.f78b; i3++) {
            if ((i3 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(c(i3) ? 'X' : '.');
        }
        return sb.toString();
    }

    a(int[] iArr, int i2) {
        this.f77a = iArr;
        this.f78b = i2;
    }
}
