package F0;

/* loaded from: classes.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private final a f195a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f196b;

    b(a aVar, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f195a = aVar;
        int length = iArr.length;
        int i2 = 1;
        if (length <= 1 || iArr[0] != 0) {
            this.f196b = iArr;
            return;
        }
        while (i2 < length && iArr[i2] == 0) {
            i2++;
        }
        if (i2 == length) {
            this.f196b = new int[]{0};
            return;
        }
        int[] iArr2 = new int[length - i2];
        this.f196b = iArr2;
        System.arraycopy(iArr, i2, iArr2, 0, iArr2.length);
    }

    b a(b bVar) {
        if (!this.f195a.equals(bVar.f195a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (e()) {
            return bVar;
        }
        if (bVar.e()) {
            return this;
        }
        int[] iArr = this.f196b;
        int[] iArr2 = bVar.f196b;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i2 = length; i2 < iArr.length; i2++) {
            iArr3[i2] = a.a(iArr2[i2 - length], iArr[i2]);
        }
        return new b(this.f195a, iArr3);
    }

    int b(int i2) {
        if (i2 == 0) {
            return c(0);
        }
        if (i2 == 1) {
            int iA = 0;
            for (int i3 : this.f196b) {
                iA = a.a(iA, i3);
            }
            return iA;
        }
        int[] iArr = this.f196b;
        int iA2 = iArr[0];
        int length = iArr.length;
        for (int i4 = 1; i4 < length; i4++) {
            iA2 = a.a(this.f195a.j(i2, iA2), this.f196b[i4]);
        }
        return iA2;
    }

    int c(int i2) {
        return this.f196b[(r0.length - 1) - i2];
    }

    int d() {
        return this.f196b.length - 1;
    }

    boolean e() {
        return this.f196b[0] == 0;
    }

    b f(int i2) {
        if (i2 == 0) {
            return this.f195a.g();
        }
        if (i2 == 1) {
            return this;
        }
        int length = this.f196b.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.f195a.j(this.f196b[i3], i2);
        }
        return new b(this.f195a, iArr);
    }

    b g(b bVar) {
        if (!this.f195a.equals(bVar.f195a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (e() || bVar.e()) {
            return this.f195a.g();
        }
        int[] iArr = this.f196b;
        int length = iArr.length;
        int[] iArr2 = bVar.f196b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = iArr[i2];
            for (int i4 = 0; i4 < length2; i4++) {
                int i5 = i2 + i4;
                iArr3[i5] = a.a(iArr3[i5], this.f195a.j(i3, iArr2[i4]));
            }
        }
        return new b(this.f195a, iArr3);
    }

    b h(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        if (i3 == 0) {
            return this.f195a.g();
        }
        int length = this.f196b.length;
        int[] iArr = new int[i2 + length];
        for (int i4 = 0; i4 < length; i4++) {
            iArr[i4] = this.f195a.j(this.f196b[i4], i3);
        }
        return new b(this.f195a, iArr);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(d() * 8);
        for (int iD = d(); iD >= 0; iD--) {
            int iC = c(iD);
            if (iC != 0) {
                if (iC < 0) {
                    sb.append(" - ");
                    iC = -iC;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (iD == 0 || iC != 1) {
                    int i2 = this.f195a.i(iC);
                    if (i2 == 0) {
                        sb.append('1');
                    } else if (i2 == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(i2);
                    }
                }
                if (iD != 0) {
                    if (iD == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(iD);
                    }
                }
            }
        }
        return sb.toString();
    }
}
