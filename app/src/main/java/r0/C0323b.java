package r0;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: r0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0323b {

    /* renamed from: a, reason: collision with root package name */
    private int f7347a;

    /* renamed from: b, reason: collision with root package name */
    private OutputStream f7348b;

    /* renamed from: c, reason: collision with root package name */
    private long f7349c;

    /* renamed from: d, reason: collision with root package name */
    private Map f7350d = new HashMap();
    private int e;

    C0323b(OutputStream outputStream, int i2) {
        this.f7347a = 0;
        this.f7347a = i2;
        this.f7348b = new BufferedOutputStream(outputStream);
    }

    private static int b(int i2) {
        if (i2 < 256) {
            return 1;
        }
        return i2 < 65536 ? 2 : 4;
    }

    private int c(long j2) {
        if (j2 < 256) {
            return 1;
        }
        if (j2 < PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
            return 2;
        }
        return j2 < 4294967296L ? 4 : 8;
    }

    private static int e(h hVar) {
        int i2 = hVar == null ? 10 : 0;
        if (hVar instanceof f) {
            Iterator it = ((f) hVar).k().values().iterator();
            while (it.hasNext()) {
                int iE = e((h) it.next());
                if (iE > i2) {
                    i2 = iE;
                }
            }
        } else if (hVar instanceof C0324c) {
            for (h hVar2 : ((C0324c) hVar).j()) {
                int iE2 = e(hVar2);
                if (iE2 > i2) {
                    i2 = iE2;
                }
            }
        }
        return i2;
    }

    public static void g(OutputStream outputStream, h hVar) throws IOException {
        int iE = e(hVar);
        if (iE <= 0) {
            new C0323b(outputStream, iE).h(hVar);
            return;
        }
        throw new IOException("The given property list structure cannot be saved. The required version of the binary format (" + (iE != 10 ? iE != 15 ? iE == 20 ? "v2.0" : "v0.0" : "v1.5" : "v1.0") + ") is not yet supported.");
    }

    public static byte[] o(h hVar) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        g(byteArrayOutputStream, hVar);
        return byteArrayOutputStream.toByteArray();
    }

    void a(h hVar) {
        if (this.f7350d.containsKey(hVar)) {
            return;
        }
        Map map = this.f7350d;
        map.put(hVar, Integer.valueOf(map.size()));
    }

    int d(h hVar) {
        return ((Integer) this.f7350d.get(hVar)).intValue();
    }

    void f(int i2) throws IOException {
        this.f7348b.write(i2);
        this.f7349c++;
    }

    void h(h hVar) throws IOException {
        int i2;
        i(new byte[]{98, 112, 108, 105, 115, 116});
        int i3 = this.f7347a;
        if (i3 == 0) {
            i(new byte[]{48, 48});
        } else if (i3 == 10) {
            i(new byte[]{49, 48});
        } else if (i3 == 15) {
            i(new byte[]{49, 53});
        } else if (i3 == 20) {
            i(new byte[]{50, 48});
        }
        hVar.a(this);
        this.e = b(this.f7350d.size());
        int size = this.f7350d.size();
        long[] jArr = new long[size];
        Iterator it = this.f7350d.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            h hVar2 = (h) entry.getKey();
            jArr[((Integer) entry.getValue()).intValue()] = this.f7349c;
            if (hVar2 == null) {
                f(0);
            } else {
                hVar2.b(this);
            }
        }
        long j2 = this.f7349c;
        int iC = c(j2);
        for (i2 = 0; i2 < size; i2++) {
            j(jArr[i2], iC);
        }
        if (this.f7347a != 15) {
            i(new byte[6]);
            f(iC);
            f(this.e);
            n(this.f7350d.size());
            n(((Integer) this.f7350d.get(hVar)).intValue());
            n(j2);
        }
        this.f7348b.flush();
    }

    void i(byte[] bArr) throws IOException {
        this.f7348b.write(bArr);
        this.f7349c += bArr.length;
    }

    void j(long j2, int i2) throws IOException {
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            f((int) (j2 >> (i3 * 8)));
        }
    }

    void k(double d2) throws IOException {
        n(Double.doubleToRawLongBits(d2));
    }

    void l(int i2) throws IOException {
        j(i2, this.e);
    }

    void m(int i2, int i3) throws IOException {
        if (i3 < 15) {
            f((i2 << 4) + i3);
            return;
        }
        if (i3 < 256) {
            f((i2 << 4) + 15);
            f(16);
            j(i3, 1);
        } else if (i3 < 65536) {
            f((i2 << 4) + 15);
            f(17);
            j(i3, 2);
        } else {
            f((i2 << 4) + 15);
            f(18);
            j(i3, 4);
        }
    }

    void n(long j2) throws IOException {
        j(j2, 8);
    }
}
