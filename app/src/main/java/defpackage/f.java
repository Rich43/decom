package defpackage;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/* loaded from: classes.dex */
public abstract class f {
    public static void a(DatagramSocket datagramSocket, String str) throws IOException {
        byte[] bytes = "getScreenCap".getBytes();
        byte[] bArr = new byte[50];
        b(bArr, 0, 26);
        b(bArr, 4, 0);
        b(bArr, 8, 0);
        b(bArr, 12, bytes.length);
        b(bArr, 16, 0);
        System.arraycopy(bytes, 0, bArr, 20, bytes.length);
        try {
            datagramSocket.send(new DatagramPacket(bArr, 50, InetAddress.getByName(str), 48689));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void b(byte[] bArr, int i2, int i3) {
        bArr[i2] = (byte) ((i3 >> 24) & 255);
        bArr[i2 + 1] = (byte) ((i3 >> 16) & 255);
        bArr[i2 + 2] = (byte) ((i3 >> 8) & 255);
        bArr[i2 + 3] = (byte) (i3 & 255);
    }
}
