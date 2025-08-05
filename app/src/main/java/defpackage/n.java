package defpackage;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class n {

    /* renamed from: g, reason: collision with root package name */
    private static final byte[] f6700g = {13, 10, 13, 10};

    /* renamed from: h, reason: collision with root package name */
    private static ByteBuffer f6701h = ByteBuffer.allocate(4096);

    /* renamed from: a, reason: collision with root package name */
    private String f6702a;

    /* renamed from: b, reason: collision with root package name */
    private String f6703b;

    /* renamed from: c, reason: collision with root package name */
    private String f6704c;

    /* renamed from: d, reason: collision with root package name */
    private Vector f6705d = new Vector();
    private Vector e = new Vector();

    /* renamed from: f, reason: collision with root package name */
    private String f6706f;

    private n(String str) {
        this.f6706f = str;
        Matcher matcher = Pattern.compile("^(\\w+)\\W(.+)\\WRTSP/(.+)\r\n").matcher(str);
        if (matcher.find()) {
            this.f6702a = matcher.group(1);
            this.f6703b = matcher.group(2);
            this.f6704c = matcher.group(3);
        }
        Matcher matcher2 = Pattern.compile("^([\\w-]+):\\W(.+)\r\n", 8).matcher(str);
        while (matcher2.find()) {
            this.f6705d.add(matcher2.group(1));
            this.e.add(matcher2.group(2));
        }
    }

    private static int a(ByteBuffer byteBuffer, InputStream inputStream, byte[] bArr) throws IOException {
        int i2 = 0;
        int i3 = 0;
        do {
            try {
                int i4 = inputStream.read();
                if (i4 < 0) {
                    Log.e("eshare", "socket read timeout < 0,exit");
                    return i4;
                }
                i2++;
                byte b2 = (byte) (i4 & 255);
                byteBuffer.put(b2);
                i3 = b2 == bArr[i3] ? i3 + 1 : 0;
            } catch (SocketTimeoutException unused) {
            }
        } while (i3 != bArr.length);
        return i2;
    }

    public static n b(InputStream inputStream) throws IOException {
        f6701h.rewind();
        int iA = a(f6701h, inputStream, f6700g);
        if (iA > 0) {
            return new n(new String(f6701h.array(), 0, iA).toString());
        }
        Log.d("eshare", "MirrorResponse exception ");
        throw new SocketException("Connection lost");
    }

    public String toString() {
        String str = " < " + this.f6706f.replaceAll("\r\n", "\r\n < ");
        str.length();
        return str;
    }
}
