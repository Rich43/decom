package defpackage;

import java.io.ByteArrayOutputStream;

/* loaded from: classes.dex */
public class i {

    /* renamed from: f, reason: collision with root package name */
    private static final ByteArrayOutputStream f6423f = new ByteArrayOutputStream(512000);

    /* renamed from: a, reason: collision with root package name */
    private int f6424a;

    /* renamed from: b, reason: collision with root package name */
    private int f6425b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f6426c = true;

    /* renamed from: d, reason: collision with root package name */
    private j f6427d;
    private int e;

    public static int a(byte[] bArr, int i2) {
        return (bArr[i2] << 24) | (bArr[i2 + 3] & 255) | ((bArr[i2 + 2] << 8) & 65280) | ((bArr[i2 + 1] << 24) >>> 8);
    }

    public static long d(byte[] bArr, int i2) {
        long j2 = 0;
        for (int i3 = i2; i3 < i2 + 8; i3++) {
            j2 = (j2 << 8) ^ (bArr[i3] & 255);
        }
        return j2;
    }

    public void b(j jVar) {
        this.f6427d = jVar;
    }

    public void c(String str, byte[] bArr) {
        boolean z2 = false;
        int iA = a(bArr, 0);
        a(bArr, 4);
        d(bArr, 8);
        int iA2 = a(bArr, 16);
        int iA3 = a(bArr, 20);
        int iA4 = a(bArr, 24);
        d(bArr, 28);
        int iA5 = a(bArr, 36);
        int iA6 = a(bArr, 40);
        if (iA == 1) {
            int i2 = this.f6424a;
            if (i2 > 0 && i2 < iA4 && iA4 == iA3) {
                this.f6424a = 0;
                ByteArrayOutputStream byteArrayOutputStream = f6423f;
                byteArrayOutputStream.write(bArr, 44, iA5);
                if (this.f6426c && iA2 == byteArrayOutputStream.size()) {
                    z2 = true;
                }
                j jVar = this.f6427d;
                if (jVar != null) {
                    jVar.a(this.e, byteArrayOutputStream, z2, str);
                }
                this.f6426c = true;
                byteArrayOutputStream.reset();
            } else if (iA3 == 0 && i2 == 0) {
                f6423f.write(bArr, 44, iA5);
            } else if (iA3 > 0 && iA3 == i2 + 1) {
                this.f6424a = iA3;
                f6423f.write(bArr, 44, iA5);
            } else if (iA3 != 0 || i2 <= 0) {
                this.f6424a = iA3;
                this.f6426c = false;
            } else {
                this.f6424a = iA3;
                if (this.f6426c && this.f6425b - f6423f.size() < -2500) {
                    z2 = true;
                }
                j jVar2 = this.f6427d;
                if (jVar2 != null) {
                    jVar2.a(this.e, f6423f, z2, str);
                }
                this.f6426c = true;
                ByteArrayOutputStream byteArrayOutputStream2 = f6423f;
                byteArrayOutputStream2.reset();
                byteArrayOutputStream2.write(bArr, 44, iA5);
            }
            this.f6425b = iA2;
            this.e = iA6;
        }
    }
}
