package defpackage;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class m {

    /* renamed from: c, reason: collision with root package name */
    private static m f6576c = new m();

    /* renamed from: a, reason: collision with root package name */
    private long f6577a;

    /* renamed from: b, reason: collision with root package name */
    private long f6578b;

    private m() {
    }

    public static m a(long j2) {
        m mVar = new m();
        mVar.c(j2);
        return mVar;
    }

    public void b(ByteBuffer byteBuffer, int i2) {
        byteBuffer.putInt(i2 + 4, (int) this.f6577a);
        byteBuffer.putInt(i2, (int) this.f6578b);
    }

    public void c(long j2) {
        this.f6577a = j2 / 1000;
        this.f6578b = (long) (((j2 % 1000) / 1000.0d) * 4.294967296E9d);
    }
}
