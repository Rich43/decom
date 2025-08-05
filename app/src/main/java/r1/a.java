package r1;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class a implements c, b, Cloneable, ByteChannel {

    /* renamed from: c, reason: collision with root package name */
    private static final byte[] f7364c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: a, reason: collision with root package name */
    h f7365a;

    /* renamed from: b, reason: collision with root package name */
    long f7366b;

    private boolean p(h hVar, int i2, d dVar, int i3, int i4) {
        int i5 = hVar.f7381c;
        byte[] bArr = hVar.f7379a;
        while (i3 < i4) {
            if (i2 == i5) {
                hVar = hVar.f7383f;
                byte[] bArr2 = hVar.f7379a;
                bArr = bArr2;
                i2 = hVar.f7380b;
                i5 = hVar.f7381c;
            }
            if (bArr[i2] != dVar.d(i3)) {
                return false;
            }
            i2++;
            i3++;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0055, code lost:
    
        if (r19 == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0058, code lost:
    
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    int A(r1.f r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 158
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: r1.a.A(r1.f, boolean):int");
    }

    public final long B() {
        return this.f7366b;
    }

    public void C(long j2) throws EOFException {
        while (j2 > 0) {
            if (this.f7365a == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j2, r0.f7381c - r0.f7380b);
            long j3 = iMin;
            this.f7366b -= j3;
            j2 -= j3;
            h hVar = this.f7365a;
            int i2 = hVar.f7380b + iMin;
            hVar.f7380b = i2;
            if (i2 == hVar.f7381c) {
                this.f7365a = hVar.b();
                i.a(hVar);
            }
        }
    }

    public final d D() {
        long j2 = this.f7366b;
        if (j2 <= 2147483647L) {
            return E((int) j2);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f7366b);
    }

    public final d E(int i2) {
        return i2 == 0 ? d.e : new j(this, i2);
    }

    h F(int i2) {
        if (i2 < 1 || i2 > 8192) {
            throw new IllegalArgumentException();
        }
        h hVar = this.f7365a;
        if (hVar != null) {
            h hVar2 = hVar.f7384g;
            return (hVar2.f7381c + i2 > 8192 || !hVar2.e) ? hVar2.c(i.b()) : hVar2;
        }
        h hVarB = i.b();
        this.f7365a = hVarB;
        hVarB.f7384g = hVarB;
        hVarB.f7383f = hVarB;
        return hVarB;
    }

    public void G(a aVar, long j2) {
        if (aVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (aVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        m.b(aVar.f7366b, 0L, j2);
        while (j2 > 0) {
            h hVar = aVar.f7365a;
            if (j2 < hVar.f7381c - hVar.f7380b) {
                h hVar2 = this.f7365a;
                h hVar3 = hVar2 != null ? hVar2.f7384g : null;
                if (hVar3 != null && hVar3.e) {
                    if ((hVar3.f7381c + j2) - (hVar3.f7382d ? 0 : hVar3.f7380b) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                        hVar.f(hVar3, (int) j2);
                        aVar.f7366b -= j2;
                        this.f7366b += j2;
                        return;
                    }
                }
                aVar.f7365a = hVar.e((int) j2);
            }
            h hVar4 = aVar.f7365a;
            long j3 = hVar4.f7381c - hVar4.f7380b;
            aVar.f7365a = hVar4.b();
            h hVar5 = this.f7365a;
            if (hVar5 == null) {
                this.f7365a = hVar4;
                hVar4.f7384g = hVar4;
                hVar4.f7383f = hVar4;
            } else {
                hVar5.f7384g.c(hVar4).a();
            }
            aVar.f7366b -= j3;
            this.f7366b += j3;
            j2 -= j3;
        }
    }

    @Override // r1.b
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public a h(int i2) {
        h hVarF = F(1);
        byte[] bArr = hVarF.f7379a;
        int i3 = hVarF.f7381c;
        hVarF.f7381c = i3 + 1;
        bArr[i3] = (byte) i2;
        this.f7366b++;
        return this;
    }

    public a I(int i2) {
        h hVarF = F(4);
        byte[] bArr = hVarF.f7379a;
        int i3 = hVarF.f7381c;
        bArr[i3] = (byte) ((i2 >>> 24) & 255);
        bArr[i3 + 1] = (byte) ((i2 >>> 16) & 255);
        bArr[i3 + 2] = (byte) ((i2 >>> 8) & 255);
        bArr[i3 + 3] = (byte) (i2 & 255);
        hVarF.f7381c = i3 + 4;
        this.f7366b += 4;
        return this;
    }

    @Override // r1.b
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public a e(String str) {
        return a(str, 0, str.length());
    }

    @Override // r1.b
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public a a(String str, int i2, int i3) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i2);
        }
        if (i3 < i2) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i3 + " < " + i2);
        }
        if (i3 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i3 + " > " + str.length());
        }
        while (i2 < i3) {
            char cCharAt = str.charAt(i2);
            if (cCharAt < 128) {
                h hVarF = F(1);
                byte[] bArr = hVarF.f7379a;
                int i4 = hVarF.f7381c - i2;
                int iMin = Math.min(i3, 8192 - i4);
                int i5 = i2 + 1;
                bArr[i2 + i4] = (byte) cCharAt;
                while (i5 < iMin) {
                    char cCharAt2 = str.charAt(i5);
                    if (cCharAt2 >= 128) {
                        break;
                    }
                    bArr[i5 + i4] = (byte) cCharAt2;
                    i5++;
                }
                int i6 = hVarF.f7381c;
                int i7 = (i4 + i5) - i6;
                hVarF.f7381c = i6 + i7;
                this.f7366b += i7;
                i2 = i5;
            } else {
                if (cCharAt < 2048) {
                    h((cCharAt >> 6) | 192);
                    h((cCharAt & '?') | 128);
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    h((cCharAt >> '\f') | 224);
                    h(((cCharAt >> 6) & 63) | 128);
                    h((cCharAt & '?') | 128);
                } else {
                    int i8 = i2 + 1;
                    char cCharAt3 = i8 < i3 ? str.charAt(i8) : (char) 0;
                    if (cCharAt > 56319 || cCharAt3 < 56320 || cCharAt3 > 57343) {
                        h(63);
                        i2 = i8;
                    } else {
                        int i9 = (((cCharAt & 10239) << 10) | (9215 & cCharAt3)) + ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        h((i9 >> 18) | 240);
                        h(((i9 >> 12) & 63) | 128);
                        h(((i9 >> 6) & 63) | 128);
                        h((i9 & 63) | 128);
                        i2 += 2;
                    }
                }
                i2++;
            }
        }
        return this;
    }

    @Override // r1.c
    public long b(d dVar) {
        return o(dVar, 0L);
    }

    @Override // r1.k
    public long c(a aVar, long j2) {
        if (aVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        }
        long j3 = this.f7366b;
        if (j3 == 0) {
            return -1L;
        }
        if (j2 > j3) {
            j2 = j3;
        }
        aVar.G(this, j2);
        return j2;
    }

    @Override // r1.c
    public boolean d(long j2) {
        return this.f7366b >= j2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        long j2 = this.f7366b;
        if (j2 != aVar.f7366b) {
            return false;
        }
        long j3 = 0;
        if (j2 == 0) {
            return true;
        }
        h hVar = this.f7365a;
        h hVar2 = aVar.f7365a;
        int i2 = hVar.f7380b;
        int i3 = hVar2.f7380b;
        while (j3 < this.f7366b) {
            long jMin = Math.min(hVar.f7381c - i2, hVar2.f7381c - i3);
            int i4 = 0;
            while (i4 < jMin) {
                int i5 = i2 + 1;
                int i6 = i3 + 1;
                if (hVar.f7379a[i2] != hVar2.f7379a[i3]) {
                    return false;
                }
                i4++;
                i2 = i5;
                i3 = i6;
            }
            if (i2 == hVar.f7381c) {
                hVar = hVar.f7383f;
                i2 = hVar.f7380b;
            }
            if (i3 == hVar2.f7381c) {
                hVar2 = hVar2.f7383f;
                i3 = hVar2.f7380b;
            }
            j3 += jMin;
        }
        return true;
    }

    @Override // r1.c
    public long g(d dVar) {
        return n(dVar, 0L);
    }

    public int hashCode() {
        h hVar = this.f7365a;
        if (hVar == null) {
            return 0;
        }
        int i2 = 1;
        do {
            int i3 = hVar.f7381c;
            for (int i4 = hVar.f7380b; i4 < i3; i4++) {
                i2 = (i2 * 31) + hVar.f7379a[i4];
            }
            hVar = hVar.f7383f;
        } while (hVar != this.f7365a);
        return i2;
    }

    @Override // r1.c
    public int i(f fVar) {
        int iA = A(fVar, false);
        if (iA == -1) {
            return -1;
        }
        try {
            C(fVar.f7374a[iA].j());
            return iA;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final void j() {
        try {
            C(this.f7366b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public a clone() {
        a aVar = new a();
        if (this.f7366b == 0) {
            return aVar;
        }
        h hVarD = this.f7365a.d();
        aVar.f7365a = hVarD;
        hVarD.f7384g = hVarD;
        hVarD.f7383f = hVarD;
        h hVar = this.f7365a;
        while (true) {
            hVar = hVar.f7383f;
            if (hVar == this.f7365a) {
                aVar.f7366b = this.f7366b;
                return aVar;
            }
            aVar.f7365a.f7384g.c(hVar.d());
        }
    }

    public boolean l() {
        return this.f7366b == 0;
    }

    public final byte m(long j2) {
        int i2;
        m.b(this.f7366b, j2, 1L);
        long j3 = this.f7366b;
        if (j3 - j2 <= j2) {
            long j4 = j2 - j3;
            h hVar = this.f7365a;
            do {
                hVar = hVar.f7384g;
                int i3 = hVar.f7381c;
                i2 = hVar.f7380b;
                j4 += i3 - i2;
            } while (j4 < 0);
            return hVar.f7379a[i2 + ((int) j4)];
        }
        h hVar2 = this.f7365a;
        while (true) {
            int i4 = hVar2.f7381c;
            int i5 = hVar2.f7380b;
            long j5 = i4 - i5;
            if (j2 < j5) {
                return hVar2.f7379a[i5 + ((int) j2)];
            }
            j2 -= j5;
            hVar2 = hVar2.f7383f;
        }
    }

    public long n(d dVar, long j2) {
        byte[] bArr;
        if (dVar.j() == 0) {
            throw new IllegalArgumentException("bytes is empty");
        }
        long j3 = 0;
        if (j2 < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        h hVar = this.f7365a;
        long j4 = -1;
        if (hVar == null) {
            return -1L;
        }
        long j5 = this.f7366b;
        if (j5 - j2 < j2) {
            while (j5 > j2) {
                hVar = hVar.f7384g;
                j5 -= hVar.f7381c - hVar.f7380b;
            }
        } else {
            while (true) {
                long j6 = (hVar.f7381c - hVar.f7380b) + j3;
                if (j6 >= j2) {
                    break;
                }
                hVar = hVar.f7383f;
                j3 = j6;
            }
            j5 = j3;
        }
        byte bD = dVar.d(0);
        int iJ = dVar.j();
        long j7 = 1 + (this.f7366b - iJ);
        long j8 = j2;
        h hVar2 = hVar;
        long j9 = j5;
        while (j9 < j7) {
            byte[] bArr2 = hVar2.f7379a;
            int iMin = (int) Math.min(hVar2.f7381c, (hVar2.f7380b + j7) - j9);
            int i2 = (int) ((hVar2.f7380b + j8) - j9);
            while (i2 < iMin) {
                if (bArr2[i2] == bD) {
                    bArr = bArr2;
                    if (p(hVar2, i2 + 1, dVar, 1, iJ)) {
                        return (i2 - hVar2.f7380b) + j9;
                    }
                } else {
                    bArr = bArr2;
                }
                i2++;
                bArr2 = bArr;
            }
            j9 += hVar2.f7381c - hVar2.f7380b;
            hVar2 = hVar2.f7383f;
            j8 = j9;
            j4 = -1;
        }
        return j4;
    }

    public long o(d dVar, long j2) {
        int i2;
        int i3;
        long j3 = 0;
        if (j2 < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        h hVar = this.f7365a;
        if (hVar == null) {
            return -1L;
        }
        long j4 = this.f7366b;
        if (j4 - j2 < j2) {
            while (j4 > j2) {
                hVar = hVar.f7384g;
                j4 -= hVar.f7381c - hVar.f7380b;
            }
        } else {
            while (true) {
                long j5 = (hVar.f7381c - hVar.f7380b) + j3;
                if (j5 >= j2) {
                    break;
                }
                hVar = hVar.f7383f;
                j3 = j5;
            }
            j4 = j3;
        }
        if (dVar.j() == 2) {
            byte bD = dVar.d(0);
            byte bD2 = dVar.d(1);
            while (j4 < this.f7366b) {
                byte[] bArr = hVar.f7379a;
                i2 = (int) ((hVar.f7380b + j2) - j4);
                int i4 = hVar.f7381c;
                while (i2 < i4) {
                    byte b2 = bArr[i2];
                    if (b2 == bD || b2 == bD2) {
                        i3 = hVar.f7380b;
                        return (i2 - i3) + j4;
                    }
                    i2++;
                }
                j4 += hVar.f7381c - hVar.f7380b;
                hVar = hVar.f7383f;
                j2 = j4;
            }
            return -1L;
        }
        byte[] bArrF = dVar.f();
        while (j4 < this.f7366b) {
            byte[] bArr2 = hVar.f7379a;
            i2 = (int) ((hVar.f7380b + j2) - j4);
            int i5 = hVar.f7381c;
            while (i2 < i5) {
                byte b3 = bArr2[i2];
                for (byte b4 : bArrF) {
                    if (b3 == b4) {
                        i3 = hVar.f7380b;
                        return (i2 - i3) + j4;
                    }
                }
                i2++;
            }
            j4 += hVar.f7381c - hVar.f7380b;
            hVar = hVar.f7383f;
            j2 = j4;
        }
        return -1L;
    }

    public int q(byte[] bArr, int i2, int i3) {
        m.b(bArr.length, i2, i3);
        h hVar = this.f7365a;
        if (hVar == null) {
            return -1;
        }
        int iMin = Math.min(i3, hVar.f7381c - hVar.f7380b);
        System.arraycopy(hVar.f7379a, hVar.f7380b, bArr, i2, iMin);
        int i4 = hVar.f7380b + iMin;
        hVar.f7380b = i4;
        this.f7366b -= iMin;
        if (i4 == hVar.f7381c) {
            this.f7365a = hVar.b();
            i.a(hVar);
        }
        return iMin;
    }

    public byte r() {
        long j2 = this.f7366b;
        if (j2 == 0) {
            throw new IllegalStateException("size == 0");
        }
        h hVar = this.f7365a;
        int i2 = hVar.f7380b;
        int i3 = hVar.f7381c;
        int i4 = i2 + 1;
        byte b2 = hVar.f7379a[i2];
        this.f7366b = j2 - 1;
        if (i4 == i3) {
            this.f7365a = hVar.b();
            i.a(hVar);
        } else {
            hVar.f7380b = i4;
        }
        return b2;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        h hVar = this.f7365a;
        if (hVar == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), hVar.f7381c - hVar.f7380b);
        byteBuffer.put(hVar.f7379a, hVar.f7380b, iMin);
        int i2 = hVar.f7380b + iMin;
        hVar.f7380b = i2;
        this.f7366b -= iMin;
        if (i2 == hVar.f7381c) {
            this.f7365a = hVar.b();
            i.a(hVar);
        }
        return iMin;
    }

    public byte[] s() {
        try {
            return t(this.f7366b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public byte[] t(long j2) throws EOFException {
        m.b(this.f7366b, 0L, j2);
        if (j2 <= 2147483647L) {
            byte[] bArr = new byte[(int) j2];
            v(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j2);
    }

    public String toString() {
        return D().toString();
    }

    public d u() {
        return new d(s());
    }

    public void v(byte[] bArr) throws EOFException {
        int i2 = 0;
        while (i2 < bArr.length) {
            int iQ = q(bArr, i2, bArr.length - i2);
            if (iQ == -1) {
                throw new EOFException();
            }
            i2 += iQ;
        }
    }

    public int w() {
        long j2 = this.f7366b;
        if (j2 < 4) {
            throw new IllegalStateException("size < 4: " + this.f7366b);
        }
        h hVar = this.f7365a;
        int i2 = hVar.f7380b;
        int i3 = hVar.f7381c;
        if (i3 - i2 < 4) {
            return ((r() & 255) << 24) | ((r() & 255) << 16) | ((r() & 255) << 8) | (r() & 255);
        }
        byte[] bArr = hVar.f7379a;
        int i4 = i2 + 3;
        int i5 = ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2] & 255) << 24) | ((bArr[i2 + 2] & 255) << 8);
        int i6 = i2 + 4;
        int i7 = (bArr[i4] & 255) | i5;
        this.f7366b = j2 - 4;
        if (i6 == i3) {
            this.f7365a = hVar.b();
            i.a(hVar);
        } else {
            hVar.f7380b = i6;
        }
        return i7;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int iRemaining = byteBuffer.remaining();
        int i2 = iRemaining;
        while (i2 > 0) {
            h hVarF = F(1);
            int iMin = Math.min(i2, 8192 - hVarF.f7381c);
            byteBuffer.get(hVarF.f7379a, hVarF.f7381c, iMin);
            i2 -= iMin;
            hVarF.f7381c += iMin;
        }
        this.f7366b += iRemaining;
        return iRemaining;
    }

    public String x(long j2, Charset charset) {
        m.b(this.f7366b, 0L, j2);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j2 > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j2);
        }
        if (j2 == 0) {
            return "";
        }
        h hVar = this.f7365a;
        int i2 = hVar.f7380b;
        if (i2 + j2 > hVar.f7381c) {
            return new String(t(j2), charset);
        }
        String str = new String(hVar.f7379a, i2, (int) j2, charset);
        int i3 = (int) (hVar.f7380b + j2);
        hVar.f7380b = i3;
        this.f7366b -= j2;
        if (i3 == hVar.f7381c) {
            this.f7365a = hVar.b();
            i.a(hVar);
        }
        return str;
    }

    public String y() {
        try {
            return x(this.f7366b, m.f7392a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String z(long j2) {
        return x(j2, m.f7392a);
    }

    @Override // r1.k, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
    }

    @Override // r1.c
    public a f() {
        return this;
    }

    @Override // java.io.Flushable
    public void flush() {
    }
}
