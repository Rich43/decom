package r0;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* renamed from: r0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0322a {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f7333a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f7334b = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: c, reason: collision with root package name */
    private static final byte[] f7335c = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f7336d = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] e = {45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};

    /* renamed from: f, reason: collision with root package name */
    private static final byte[] f7337f = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    public static byte[] d(String str) {
        return e(str, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v7 */
    public static byte[] e(String str, int i2) throws Throwable {
        byte[] bytes;
        ByteArrayInputStream length;
        ByteArrayInputStream byteArrayInputStream;
        GZIPInputStream gZIPInputStream;
        if (str == null) {
            throw new NullPointerException("Input string was null.");
        }
        try {
            bytes = str.getBytes("US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        byte[] bArrF = f(bytes, 0, bytes.length, i2);
        boolean z2 = (i2 & 4) != 0;
        if (bArrF != null && (length = bArrF.length) >= 4 && !z2 && 35615 == ((bArrF[0] & 255) | ((bArrF[1] << 8) & 65280))) {
            byte[] bArr = new byte[2048];
            ByteArrayOutputStream byteArrayOutputStream = null;
            try {
                try {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        byteArrayInputStream = new ByteArrayInputStream(bArrF);
                        try {
                            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                            while (true) {
                                try {
                                    int i3 = gZIPInputStream.read(bArr);
                                    if (i3 < 0) {
                                        break;
                                    }
                                    byteArrayOutputStream2.write(bArr, 0, i3);
                                } catch (IOException e2) {
                                    e = e2;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    byteArrayInputStream = byteArrayInputStream;
                                    try {
                                        e.printStackTrace();
                                        byteArrayOutputStream.close();
                                        length = byteArrayInputStream;
                                        gZIPInputStream.close();
                                        length.close();
                                        return bArrF;
                                    } catch (Throwable th) {
                                        th = th;
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (Exception unused2) {
                                        }
                                        try {
                                            gZIPInputStream.close();
                                        } catch (Exception unused3) {
                                        }
                                        try {
                                            byteArrayInputStream.close();
                                            throw th;
                                        } catch (Exception unused4) {
                                            throw th;
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    byteArrayOutputStream.close();
                                    gZIPInputStream.close();
                                    byteArrayInputStream.close();
                                    throw th;
                                }
                            }
                            bArrF = byteArrayOutputStream2.toByteArray();
                            byteArrayOutputStream2.close();
                            length = byteArrayInputStream;
                        } catch (IOException e3) {
                            e = e3;
                            gZIPInputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            gZIPInputStream = null;
                        }
                    } catch (IOException e4) {
                        e = e4;
                        byteArrayInputStream = null;
                        gZIPInputStream = null;
                    } catch (Throwable th4) {
                        th = th4;
                        byteArrayInputStream = null;
                        gZIPInputStream = null;
                    }
                } catch (IOException e5) {
                    e = e5;
                    byteArrayInputStream = null;
                    gZIPInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    byteArrayInputStream = null;
                    gZIPInputStream = null;
                }
            } catch (Exception unused5) {
            }
            try {
                gZIPInputStream.close();
            } catch (Exception unused6) {
            }
            try {
                length.close();
            } catch (Exception unused7) {
            }
        }
        return bArrF;
    }

    public static byte[] f(byte[] bArr, int i2, int i3, int i4) throws IOException {
        int i5;
        if (bArr == null) {
            throw new NullPointerException("Cannot decode null source array.");
        }
        if (i2 < 0 || (i5 = i2 + i3) > bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
        }
        if (i3 == 0) {
            return new byte[0];
        }
        if (i3 < 4) {
            throw new IllegalArgumentException("Base64-encoded string must have at least four characters, but length specified was " + i3);
        }
        byte[] bArrN = n(i4);
        byte[] bArr2 = new byte[(i3 * 3) / 4];
        byte[] bArr3 = new byte[4];
        int i6 = 0;
        int iG = 0;
        while (i2 < i5) {
            byte b2 = bArr[i2];
            byte b3 = bArrN[b2 & 255];
            if (b3 < -5) {
                throw new IOException(String.format("Bad Base64 input character decimal %d in array position %d", Integer.valueOf(bArr[i2] & 255), Integer.valueOf(i2)));
            }
            if (b3 >= -1) {
                int i7 = i6 + 1;
                bArr3[i6] = b2;
                if (i7 > 3) {
                    iG += g(bArr3, 0, bArr2, iG, i4);
                    if (bArr[i2] == 61) {
                        break;
                    }
                    i6 = 0;
                } else {
                    i6 = i7;
                }
            }
            i2++;
        }
        byte[] bArr4 = new byte[iG];
        System.arraycopy(bArr2, 0, bArr4, 0, iG);
        return bArr4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int g(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        int i5;
        int i6;
        if (bArr == null) {
            throw new NullPointerException("Source array was null.");
        }
        if (bArr2 == null) {
            throw new NullPointerException("Destination array was null.");
        }
        if (i2 < 0 || (i5 = i2 + 3) >= bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i2)));
        }
        if (i3 < 0 || (i6 = i3 + 2) >= bArr2.length) {
            throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr2.length), Integer.valueOf(i3)));
        }
        byte[] bArrN = n(i4);
        byte b2 = bArr[i2 + 2];
        if (b2 == 61) {
            bArr2[i3] = (byte) ((((bArrN[bArr[i2 + 1]] & 255) << 12) | ((bArrN[bArr[i2]] & 255) << 18)) >>> 16);
            return 1;
        }
        byte b3 = bArr[i5];
        if (b3 == 61) {
            int i7 = ((bArrN[bArr[i2 + 1]] & 255) << 12) | ((bArrN[bArr[i2]] & 255) << 18) | ((bArrN[b2] & 255) << 6);
            bArr2[i3] = (byte) (i7 >>> 16);
            bArr2[i3 + 1] = (byte) (i7 >>> 8);
            return 2;
        }
        int i8 = ((bArrN[bArr[i2 + 1]] & 255) << 12) | ((bArrN[bArr[i2]] & 255) << 18) | ((bArrN[b2] & 255) << 6) | (bArrN[b3] & 255);
        bArr2[i3] = (byte) (i8 >> 16);
        bArr2[i3 + 1] = (byte) (i8 >> 8);
        bArr2[i6] = (byte) i8;
        return 3;
    }

    private static byte[] h(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) {
        byte[] bArrM = m(i5);
        int i6 = (i3 > 0 ? (bArr[i2] << 24) >>> 8 : 0) | (i3 > 1 ? (bArr[i2 + 1] << 24) >>> 16 : 0) | (i3 > 2 ? (bArr[i2 + 2] << 24) >>> 24 : 0);
        if (i3 == 1) {
            bArr2[i4] = bArrM[i6 >>> 18];
            bArr2[i4 + 1] = bArrM[(i6 >>> 12) & 63];
            bArr2[i4 + 2] = 61;
            bArr2[i4 + 3] = 61;
            return bArr2;
        }
        if (i3 == 2) {
            bArr2[i4] = bArrM[i6 >>> 18];
            bArr2[i4 + 1] = bArrM[(i6 >>> 12) & 63];
            bArr2[i4 + 2] = bArrM[(i6 >>> 6) & 63];
            bArr2[i4 + 3] = 61;
            return bArr2;
        }
        if (i3 != 3) {
            return bArr2;
        }
        bArr2[i4] = bArrM[i6 >>> 18];
        bArr2[i4 + 1] = bArrM[(i6 >>> 12) & 63];
        bArr2[i4 + 2] = bArrM[(i6 >>> 6) & 63];
        bArr2[i4 + 3] = bArrM[i6 & 63];
        return bArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] i(byte[] bArr, byte[] bArr2, int i2, int i3) {
        h(bArr2, 0, i2, bArr, 0, i3);
        return bArr;
    }

    public static String j(byte[] bArr) {
        try {
            return k(bArr, 0, bArr.length, 0);
        } catch (IOException unused) {
            return null;
        }
    }

    public static String k(byte[] bArr, int i2, int i3, int i4) throws Throwable {
        byte[] bArrL = l(bArr, i2, i3, i4);
        try {
            return new String(bArrL, "US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArrL);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13, types: [java.io.OutputStream, java.util.zip.GZIPOutputStream] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static byte[] l(byte[] bArr, int i2, int i3, int i4) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        C0101a c0101a;
        ?? gZIPOutputStream;
        if (bArr == null) {
            throw new NullPointerException("Cannot serialize a null array.");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Cannot have negative offset: " + i2);
        }
        if (i3 < 0) {
            throw new IllegalArgumentException("Cannot have length offset: " + i3);
        }
        if (i2 + i3 > bArr.length) {
            throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(bArr.length)));
        }
        if ((i4 & 2) == 0) {
            boolean z2 = (i4 & 8) != 0;
            int i5 = ((i3 / 3) * 4) + (i3 % 3 > 0 ? 4 : 0);
            if (z2) {
                i5 += i5 / 76;
            }
            int i6 = i5;
            byte[] bArr2 = new byte[i6];
            int i7 = i3 - 2;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            while (i8 < i7) {
                int i11 = i8;
                int i12 = i7;
                byte[] bArr3 = bArr2;
                h(bArr, i8 + i2, 3, bArr2, i9, i4);
                int i13 = i10 + 4;
                if (!z2 || i13 < 76) {
                    i10 = i13;
                } else {
                    bArr3[i9 + 4] = 10;
                    i9++;
                    i10 = 0;
                }
                i8 = i11 + 3;
                i9 += 4;
                bArr2 = bArr3;
                i7 = i12;
            }
            int i14 = i8;
            byte[] bArr4 = bArr2;
            if (i14 < i3) {
                h(bArr, i14 + i2, i3 - i14, bArr4, i9, i4);
                i9 += 4;
            }
            int i15 = i9;
            if (i15 > i6 - 1) {
                return bArr4;
            }
            byte[] bArr5 = new byte[i15];
            System.arraycopy(bArr4, 0, bArr5, 0, i15);
            return bArr5;
        }
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                c0101a = new C0101a(byteArrayOutputStream, i4 | 1);
            } catch (IOException e2) {
                e = e2;
                c0101a = null;
                gZIPOutputStream = 0;
            } catch (Throwable th) {
                th = th;
                c0101a = null;
            }
            try {
                gZIPOutputStream = new GZIPOutputStream(c0101a);
            } catch (IOException e3) {
                e = e3;
                gZIPOutputStream = 0;
            } catch (Throwable th2) {
                th = th2;
                try {
                    byteArrayOutputStream2.close();
                } catch (Exception unused) {
                }
                try {
                    c0101a.close();
                } catch (Exception unused2) {
                }
                try {
                    byteArrayOutputStream.close();
                    throw th;
                } catch (Exception unused3) {
                    throw th;
                }
            }
        } catch (IOException e4) {
            e = e4;
            c0101a = null;
            gZIPOutputStream = 0;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            c0101a = null;
        }
        try {
            gZIPOutputStream.write(bArr, i2, i3);
            gZIPOutputStream.close();
            try {
                gZIPOutputStream.close();
            } catch (Exception unused4) {
            }
            try {
                c0101a.close();
            } catch (Exception unused5) {
            }
            try {
                byteArrayOutputStream.close();
            } catch (Exception unused6) {
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e5) {
            e = e5;
            byteArrayOutputStream2 = byteArrayOutputStream;
            gZIPOutputStream = gZIPOutputStream;
            try {
                throw e;
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = byteArrayOutputStream2;
                byteArrayOutputStream2 = gZIPOutputStream;
                byteArrayOutputStream2.close();
                c0101a.close();
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            byteArrayOutputStream2 = gZIPOutputStream;
            byteArrayOutputStream2.close();
            c0101a.close();
            byteArrayOutputStream.close();
            throw th;
        }
    }

    private static final byte[] m(int i2) {
        return (i2 & 16) == 16 ? f7335c : (i2 & 32) == 32 ? e : f7333a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] n(int i2) {
        return (i2 & 16) == 16 ? f7336d : (i2 & 32) == 32 ? f7337f : f7334b;
    }

    /* renamed from: r0.a$a, reason: collision with other inner class name */
    public static class C0101a extends FilterOutputStream {

        /* renamed from: a, reason: collision with root package name */
        private boolean f7338a;

        /* renamed from: b, reason: collision with root package name */
        private int f7339b;

        /* renamed from: c, reason: collision with root package name */
        private byte[] f7340c;

        /* renamed from: d, reason: collision with root package name */
        private int f7341d;
        private int e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f7342f;

        /* renamed from: g, reason: collision with root package name */
        private byte[] f7343g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f7344h;

        /* renamed from: i, reason: collision with root package name */
        private int f7345i;

        /* renamed from: j, reason: collision with root package name */
        private byte[] f7346j;

        public C0101a(OutputStream outputStream, int i2) {
            super(outputStream);
            this.f7342f = (i2 & 8) != 0;
            boolean z2 = (i2 & 1) != 0;
            this.f7338a = z2;
            int i3 = z2 ? 3 : 4;
            this.f7341d = i3;
            this.f7340c = new byte[i3];
            this.f7339b = 0;
            this.e = 0;
            this.f7344h = false;
            this.f7343g = new byte[4];
            this.f7345i = i2;
            this.f7346j = AbstractC0322a.n(i2);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            j();
            super.close();
            this.f7340c = null;
            ((FilterOutputStream) this).out = null;
        }

        public void j() throws IOException {
            int i2 = this.f7339b;
            if (i2 > 0) {
                if (!this.f7338a) {
                    throw new IOException("Base64 input not properly padded.");
                }
                ((FilterOutputStream) this).out.write(AbstractC0322a.i(this.f7343g, this.f7340c, i2, this.f7345i));
                this.f7339b = 0;
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i2) throws IOException {
            if (this.f7344h) {
                ((FilterOutputStream) this).out.write(i2);
                return;
            }
            if (!this.f7338a) {
                byte b2 = this.f7346j[i2 & 127];
                if (b2 <= -5) {
                    if (b2 != -5) {
                        throw new IOException("Invalid character in Base64 data.");
                    }
                    return;
                }
                byte[] bArr = this.f7340c;
                int i3 = this.f7339b;
                int i4 = i3 + 1;
                this.f7339b = i4;
                bArr[i3] = (byte) i2;
                if (i4 >= this.f7341d) {
                    ((FilterOutputStream) this).out.write(this.f7343g, 0, AbstractC0322a.g(bArr, 0, this.f7343g, 0, this.f7345i));
                    this.f7339b = 0;
                    return;
                }
                return;
            }
            byte[] bArr2 = this.f7340c;
            int i5 = this.f7339b;
            int i6 = i5 + 1;
            this.f7339b = i6;
            bArr2[i5] = (byte) i2;
            int i7 = this.f7341d;
            if (i6 >= i7) {
                ((FilterOutputStream) this).out.write(AbstractC0322a.i(this.f7343g, bArr2, i7, this.f7345i));
                int i8 = this.e + 4;
                this.e = i8;
                if (this.f7342f && i8 >= 76) {
                    ((FilterOutputStream) this).out.write(10);
                    this.e = 0;
                }
                this.f7339b = 0;
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i2, int i3) throws IOException {
            if (this.f7344h) {
                ((FilterOutputStream) this).out.write(bArr, i2, i3);
                return;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                write(bArr[i2 + i4]);
            }
        }
    }
}
