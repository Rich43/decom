package r0;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/* loaded from: classes.dex */
public class i extends h implements Comparable {

    /* renamed from: c, reason: collision with root package name */
    private static CharsetEncoder f7361c;

    /* renamed from: d, reason: collision with root package name */
    private static CharsetEncoder f7362d;

    /* renamed from: b, reason: collision with root package name */
    private String f7363b;

    public i(String str) {
        this.f7363b = str;
    }

    @Override // r0.h
    public void b(C0323b c0323b) throws IOException {
        ByteBuffer byteBufferEncode;
        int i2;
        CharBuffer charBufferWrap = CharBuffer.wrap(this.f7363b);
        synchronized (i.class) {
            try {
                CharsetEncoder charsetEncoder = f7361c;
                if (charsetEncoder == null) {
                    f7361c = Charset.forName("ASCII").newEncoder();
                } else {
                    charsetEncoder.reset();
                }
                if (f7361c.canEncode(charBufferWrap)) {
                    byteBufferEncode = f7361c.encode(charBufferWrap);
                    i2 = 5;
                } else {
                    CharsetEncoder charsetEncoder2 = f7362d;
                    if (charsetEncoder2 == null) {
                        f7362d = Charset.forName("UTF-16BE").newEncoder();
                    } else {
                        charsetEncoder2.reset();
                    }
                    byteBufferEncode = f7362d.encode(charBufferWrap);
                    i2 = 6;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        byte[] bArr = new byte[byteBufferEncode.remaining()];
        byteBufferEncode.get(bArr);
        c0323b.m(i2, this.f7363b.length());
        c0323b.i(bArr);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj instanceof i) {
            return j().compareTo(((i) obj).j());
        }
        if (obj instanceof String) {
            return j().compareTo((String) obj);
        }
        return -1;
    }

    public boolean equals(Object obj) {
        if (obj instanceof i) {
            return this.f7363b.equals(((i) obj).f7363b);
        }
        return false;
    }

    public int hashCode() {
        return this.f7363b.hashCode();
    }

    public String j() {
        return this.f7363b;
    }

    public String toString() {
        return this.f7363b;
    }
}
