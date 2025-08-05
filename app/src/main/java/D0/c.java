package D0;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f83a;

    /* renamed from: b, reason: collision with root package name */
    private int f84b;

    /* renamed from: c, reason: collision with root package name */
    private int f85c;

    public c(byte[] bArr) {
        this.f83a = bArr;
    }

    public int a() {
        return ((this.f83a.length - this.f84b) * 8) - this.f85c;
    }

    public int b() {
        return this.f85c;
    }

    public int c() {
        return this.f84b;
    }

    public int d(int i2) {
        if (i2 <= 0 || i2 > 32 || i2 > a()) {
            throw new IllegalArgumentException(String.valueOf(i2));
        }
        int i3 = this.f85c;
        int i4 = 0;
        if (i3 > 0) {
            int i5 = 8 - i3;
            int i6 = i2 < i5 ? i2 : i5;
            int i7 = i5 - i6;
            byte[] bArr = this.f83a;
            int i8 = this.f84b;
            int i9 = (((255 >> (8 - i6)) << i7) & bArr[i8]) >> i7;
            i2 -= i6;
            int i10 = i3 + i6;
            this.f85c = i10;
            if (i10 == 8) {
                this.f85c = 0;
                this.f84b = i8 + 1;
            }
            i4 = i9;
        }
        if (i2 <= 0) {
            return i4;
        }
        while (i2 >= 8) {
            int i11 = i4 << 8;
            byte[] bArr2 = this.f83a;
            int i12 = this.f84b;
            i4 = (bArr2[i12] & 255) | i11;
            this.f84b = i12 + 1;
            i2 -= 8;
        }
        if (i2 <= 0) {
            return i4;
        }
        int i13 = 8 - i2;
        int i14 = (i4 << i2) | ((((255 >> i13) << i13) & this.f83a[this.f84b]) >> i13);
        this.f85c += i2;
        return i14;
    }
}
