package C;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a */
    protected int f36a;

    /* renamed from: b */
    protected ByteBuffer f37b;

    /* renamed from: c */
    private int f38c;

    /* renamed from: d */
    private int f39d;
    d e = d.a();

    protected int a(int i2) {
        return i2 + this.f37b.getInt(i2);
    }

    protected int b(int i2) {
        if (i2 < this.f39d) {
            return this.f37b.getShort(this.f38c + i2);
        }
        return 0;
    }

    protected void c(int i2, ByteBuffer byteBuffer) {
        this.f37b = byteBuffer;
        if (byteBuffer == null) {
            this.f36a = 0;
            this.f38c = 0;
            this.f39d = 0;
        } else {
            this.f36a = i2;
            int i3 = i2 - byteBuffer.getInt(i2);
            this.f38c = i3;
            this.f39d = this.f37b.getShort(i3);
        }
    }

    protected int d(int i2) {
        int i3 = i2 + this.f36a;
        return i3 + this.f37b.getInt(i3) + 4;
    }

    protected int e(int i2) {
        int i3 = i2 + this.f36a;
        return this.f37b.getInt(i3 + this.f37b.getInt(i3));
    }
}
