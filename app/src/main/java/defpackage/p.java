package defpackage;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.load.Key;
import java.io.IOException;
import java.net.Socket;
import r0.AbstractC0322a;
import r0.C0323b;
import r0.C0324c;
import r0.d;
import r0.f;

/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private int f7006a = 0;

    /* renamed from: b, reason: collision with root package name */
    private String f7007b;

    /* renamed from: c, reason: collision with root package name */
    private Socket f7008c;

    public p(Socket socket, String str) {
        this.f7007b = str;
        this.f7008c = socket;
    }

    private String a() {
        StringBuilder sb = new StringBuilder();
        sb.append("CSeq: ");
        int i2 = this.f7006a + 1;
        this.f7006a = i2;
        sb.append(i2);
        sb.append("\r\nContent-Length: 0\r\n\r\n");
        return sb.toString();
    }

    private String b(int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("CSeq: ");
        int i3 = this.f7006a + 1;
        this.f7006a = i3;
        sb.append(i3);
        sb.append("\r\nContent-Length: ");
        sb.append(i2);
        sb.append("\r\n\r\n");
        return sb.toString();
    }

    public n c(Context context) throws IOException {
        try {
            String strC = g.c(context, "com.ecloud.eshare.lib.key.CLIENT_NAME", Build.MODEL);
            f fVar = new f();
            fVar.l("type", 110L);
            fVar.n("androdstream", true);
            fVar.l("dataPort", 0L);
            fVar.l("controlPort", 0L);
            fVar.put("machine_name", new d(AbstractC0322a.j(strC.getBytes())));
            C0324c c0324c = new C0324c(fVar);
            f fVar2 = new f();
            fVar2.put("streams", c0324c);
            byte[] bArrO = C0323b.o(fVar2);
            this.f7008c.getOutputStream().write(("SETUP rtsp://" + this.f7007b + " RTSP/1.0\r\n" + b(bArrO.length)).getBytes(Key.STRING_CHARSET_NAME));
            this.f7008c.getOutputStream().write(bArrO);
            this.f7008c.getOutputStream().flush();
            return n.b(this.f7008c.getInputStream());
        } catch (Exception unused) {
            Log.e("eshare", "setup video error");
            return null;
        }
    }

    public n d() throws IOException {
        try {
            this.f7008c.getOutputStream().write(("OPTIONS rtsp://" + this.f7007b + " RTSP/1.0\r\n" + a()).getBytes(Key.STRING_CHARSET_NAME));
            this.f7008c.getOutputStream().flush();
            return n.b(this.f7008c.getInputStream());
        } catch (Exception unused) {
            Log.e("eshare", "option error");
            return null;
        }
    }

    public n e() {
        try {
            f fVar = new f();
            fVar.l("type", 110L);
            fVar.l("dataPort", 0L);
            fVar.l("controlPort", 0L);
            C0324c c0324c = new C0324c(fVar);
            f fVar2 = new f();
            fVar2.put("streams", c0324c);
            byte[] bArrO = C0323b.o(fVar2);
            this.f7008c.getOutputStream().write(("TEARDOWN rtsp://" + this.f7007b + " RTSP/1.0\r\n" + b(bArrO.length)).getBytes(Key.STRING_CHARSET_NAME));
            this.f7008c.getOutputStream().write(bArrO);
            this.f7008c.getOutputStream().flush();
            return n.b(this.f7008c.getInputStream());
        } catch (Exception unused) {
            Log.e("eshare", "teardown error");
            return null;
        }
    }
}
