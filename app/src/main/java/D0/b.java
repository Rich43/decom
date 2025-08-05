package D0;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class b implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private final int f79a;

    /* renamed from: b, reason: collision with root package name */
    private final int f80b;

    /* renamed from: c, reason: collision with root package name */
    private final int f81c;

    /* renamed from: d, reason: collision with root package name */
    private final int[] f82d;

    public b(int i2) {
        this(i2, i2);
    }

    private String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.f80b * (this.f79a + 1));
        for (int i2 = 0; i2 < this.f80b; i2++) {
            for (int i3 = 0; i3 < this.f79a; i3++) {
                sb.append(d(i3, i2) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b clone() {
        return new b(this.f79a, this.f80b, this.f81c, (int[]) this.f82d.clone());
    }

    public void c(int i2, int i3) {
        int i4 = (i3 * this.f81c) + (i2 / 32);
        int[] iArr = this.f82d;
        iArr[i4] = (1 << (i2 & 31)) ^ iArr[i4];
    }

    public boolean d(int i2, int i3) {
        return ((this.f82d[(i3 * this.f81c) + (i2 / 32)] >>> (i2 & 31)) & 1) != 0;
    }

    public int[] e() {
        int length = this.f82d.length - 1;
        while (length >= 0 && this.f82d[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i2 = this.f81c;
        int i3 = length / i2;
        int i4 = (length % i2) << 5;
        int i5 = 31;
        while ((this.f82d[length] >>> i5) == 0) {
            i5--;
        }
        return new int[]{i4 + i5, i3};
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f79a == bVar.f79a && this.f80b == bVar.f80b && this.f81c == bVar.f81c && Arrays.equals(this.f82d, bVar.f82d);
    }

    public int[] f() {
        int i2 = this.f79a;
        int i3 = this.f80b;
        int i4 = -1;
        int i5 = -1;
        for (int i6 = 0; i6 < this.f80b; i6++) {
            int i7 = 0;
            while (true) {
                int i8 = this.f81c;
                if (i7 < i8) {
                    int i9 = this.f82d[(i8 * i6) + i7];
                    if (i9 != 0) {
                        if (i6 < i3) {
                            i3 = i6;
                        }
                        if (i6 > i5) {
                            i5 = i6;
                        }
                        int i10 = i7 << 5;
                        if (i10 < i2) {
                            int i11 = 0;
                            while ((i9 << (31 - i11)) == 0) {
                                i11++;
                            }
                            int i12 = i11 + i10;
                            if (i12 < i2) {
                                i2 = i12;
                            }
                        }
                        if (i10 + 31 > i4) {
                            int i13 = 31;
                            while ((i9 >>> i13) == 0) {
                                i13--;
                            }
                            int i14 = i10 + i13;
                            if (i14 > i4) {
                                i4 = i14;
                            }
                        }
                    }
                    i7++;
                }
            }
        }
        if (i4 < i2 || i5 < i3) {
            return null;
        }
        return new int[]{i2, i3, (i4 - i2) + 1, (i5 - i3) + 1};
    }

    public int g() {
        return this.f80b;
    }

    public a h(int i2, a aVar) {
        if (aVar == null || aVar.g() < this.f79a) {
            aVar = new a(this.f79a);
        } else {
            aVar.a();
        }
        int i3 = i2 * this.f81c;
        for (int i4 = 0; i4 < this.f81c; i4++) {
            aVar.l(i4 << 5, this.f82d[i3 + i4]);
        }
        return aVar;
    }

    public int hashCode() {
        int i2 = this.f79a;
        return (((((((i2 * 31) + i2) * 31) + this.f80b) * 31) + this.f81c) * 31) + Arrays.hashCode(this.f82d);
    }

    public int[] i() {
        int[] iArr;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            iArr = this.f82d;
            if (i3 >= iArr.length || iArr[i3] != 0) {
                break;
            }
            i3++;
        }
        if (i3 == iArr.length) {
            return null;
        }
        int i4 = this.f81c;
        int i5 = i3 / i4;
        int i6 = (i3 % i4) << 5;
        while ((iArr[i3] << (31 - i2)) == 0) {
            i2++;
        }
        return new int[]{i6 + i2, i5};
    }

    public int j() {
        return this.f79a;
    }

    public void k() {
        int iJ = j();
        int iG = g();
        a aVar = new a(iJ);
        a aVar2 = new a(iJ);
        for (int i2 = 0; i2 < (iG + 1) / 2; i2++) {
            aVar = h(i2, aVar);
            int i3 = (iG - 1) - i2;
            aVar2 = h(i3, aVar2);
            aVar.j();
            aVar2.j();
            n(i2, aVar2);
            n(i3, aVar);
        }
    }

    public void l(int i2, int i3) {
        int i4 = (i3 * this.f81c) + (i2 / 32);
        int[] iArr = this.f82d;
        iArr[i4] = (1 << (i2 & 31)) | iArr[i4];
    }

    public void m(int i2, int i3, int i4, int i5) {
        if (i3 < 0 || i2 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i5 <= 0 || i4 <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        int i6 = i4 + i2;
        int i7 = i5 + i3;
        if (i7 > this.f80b || i6 > this.f79a) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i3 < i7) {
            int i8 = this.f81c * i3;
            for (int i9 = i2; i9 < i6; i9++) {
                int[] iArr = this.f82d;
                int i10 = (i9 / 32) + i8;
                iArr[i10] = iArr[i10] | (1 << (i9 & 31));
            }
            i3++;
        }
    }

    public void n(int i2, a aVar) {
        int[] iArrD = aVar.d();
        int[] iArr = this.f82d;
        int i3 = this.f81c;
        System.arraycopy(iArrD, 0, iArr, i2 * i3, i3);
    }

    public String o(String str, String str2) {
        return a(str, str2, "\n");
    }

    public String toString() {
        return o("X ", "  ");
    }

    public b(int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f79a = i2;
        this.f80b = i3;
        int i4 = (i2 + 31) / 32;
        this.f81c = i4;
        this.f82d = new int[i4 * i3];
    }

    private b(int i2, int i3, int i4, int[] iArr) {
        this.f79a = i2;
        this.f80b = i3;
        this.f81c = i4;
        this.f82d = iArr;
    }
}
