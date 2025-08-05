package com.eshare.mirror;

import android.util.Log;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Socket f5610a;

    /* renamed from: b, reason: collision with root package name */
    private Thread f5611b;

    /* renamed from: c, reason: collision with root package name */
    private String f5612c;

    /* renamed from: d, reason: collision with root package name */
    private final int f5613d = 52030;
    private boolean e = true;

    /* renamed from: com.eshare.mirror.a$a, reason: collision with other inner class name */
    class RunnableC0069a implements Runnable {
        RunnableC0069a() {
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            try {
                byte[] bArr = new byte[512];
                a.this.f5610a.connect(new InetSocketAddress(InetAddress.getByName(a.this.f5612c), 52030), 5000);
                while (!a.this.f5611b.isInterrupted() && !a.this.f5610a.isClosed()) {
                    int i2 = a.this.f5610a.getInputStream().read(bArr);
                    if (i2 > 0 && new String(bArr, 0, i2).contains("STOP_MIRROR")) {
                        Log.e("eshare", "set reconnect mirror false");
                        a.this.e = false;
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    a(String str) {
        this.f5612c = str;
    }

    boolean b() {
        return this.e;
    }

    void e() {
        this.f5610a = new Socket();
        Thread thread = new Thread(new RunnableC0069a());
        this.f5611b = thread;
        thread.start();
    }

    void g() throws IOException {
        try {
            this.e = false;
            Thread thread = this.f5611b;
            if (thread != null) {
                thread.interrupt();
                this.f5611b = null;
            }
            Socket socket = this.f5610a;
            if (socket != null) {
                socket.close();
                this.f5610a = null;
                System.gc();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
