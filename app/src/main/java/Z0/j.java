package z0;

/* loaded from: classes.dex */
public final class j extends g {

    /* renamed from: c, reason: collision with root package name */
    private final byte[] f7793c;

    /* renamed from: d, reason: collision with root package name */
    private final int f7794d;
    private final int e;

    /* renamed from: f, reason: collision with root package name */
    private final int f7795f;

    /* renamed from: g, reason: collision with root package name */
    private final int f7796g;

    public j(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, boolean z2) {
        super(i6, i7);
        if (i4 + i6 > i2 || i5 + i7 > i3) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f7793c = bArr;
        this.f7794d = i2;
        this.e = i3;
        this.f7795f = i4;
        this.f7796g = i5;
        if (z2) {
            j(i6, i7);
        }
    }

    private void j(int i2, int i3) {
        byte[] bArr = this.f7793c;
        int i4 = (this.f7796g * this.f7794d) + this.f7795f;
        int i5 = 0;
        while (i5 < i3) {
            int i6 = (i2 / 2) + i4;
            int i7 = (i4 + i2) - 1;
            int i8 = i4;
            while (i8 < i6) {
                byte b2 = bArr[i8];
                bArr[i8] = bArr[i7];
                bArr[i7] = b2;
                i8++;
                i7--;
            }
            i5++;
            i4 += this.f7794d;
        }
    }

    @Override // z0.g
    public byte[] b() {
        int iD = d();
        int iA = a();
        int i2 = this.f7794d;
        if (iD == i2 && iA == this.e) {
            return this.f7793c;
        }
        int i3 = iD * iA;
        byte[] bArr = new byte[i3];
        int i4 = (this.f7796g * i2) + this.f7795f;
        if (iD == i2) {
            System.arraycopy(this.f7793c, i4, bArr, 0, i3);
            return bArr;
        }
        for (int i5 = 0; i5 < iA; i5++) {
            System.arraycopy(this.f7793c, i4, bArr, i5 * iD, iD);
            i4 += this.f7794d;
        }
        return bArr;
    }

    @Override // z0.g
    public byte[] c(int i2, byte[] bArr) {
        if (i2 < 0 || i2 >= a()) {
            throw new IllegalArgumentException("Requested row is outside the image: ".concat(String.valueOf(i2)));
        }
        int iD = d();
        if (bArr == null || bArr.length < iD) {
            bArr = new byte[iD];
        }
        System.arraycopy(this.f7793c, ((i2 + this.f7796g) * this.f7794d) + this.f7795f, bArr, 0, iD);
        return bArr;
    }

    public int g() {
        return a() / 2;
    }

    public int h() {
        return d() / 2;
    }

    public int[] i() {
        int iD = d() / 2;
        int iA = a() / 2;
        int[] iArr = new int[iD * iA];
        byte[] bArr = this.f7793c;
        int i2 = (this.f7796g * this.f7794d) + this.f7795f;
        for (int i3 = 0; i3 < iA; i3++) {
            int i4 = i3 * iD;
            for (int i5 = 0; i5 < iD; i5++) {
                iArr[i4 + i5] = ((bArr[(i5 << 1) + i2] & 255) * 65793) | (-16777216);
            }
            i2 += this.f7794d << 1;
        }
        return iArr;
    }
}
