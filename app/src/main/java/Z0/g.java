package z0;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a */
    private final int f7788a;

    /* renamed from: b */
    private final int f7789b;

    protected g(int i2, int i3) {
        this.f7788a = i2;
        this.f7789b = i3;
    }

    public final int a() {
        return this.f7789b;
    }

    public abstract byte[] b();

    public abstract byte[] c(int i2, byte[] bArr);

    public final int d() {
        return this.f7788a;
    }

    public boolean e() {
        return false;
    }

    public g f() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public final String toString() {
        int i2 = this.f7788a;
        byte[] bArrC = new byte[i2];
        StringBuilder sb = new StringBuilder(this.f7789b * (i2 + 1));
        for (int i3 = 0; i3 < this.f7789b; i3++) {
            bArrC = c(i3, bArrC);
            for (int i4 = 0; i4 < this.f7788a; i4++) {
                int i5 = bArrC[i4] & 255;
                sb.append(i5 < 64 ? '#' : i5 < 128 ? '+' : i5 < 192 ? '.' : ' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
