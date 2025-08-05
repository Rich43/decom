package com.eshare.api;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import defpackage.c;
import defpackage.d;
import defpackage.k;
import defpackage.l;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public final class a implements IDevice, IScreen, IMedia, IEvent {
    private Context e;

    /* renamed from: f, reason: collision with root package name */
    private WifiManager f5526f;

    /* renamed from: j, reason: collision with root package name */
    private Socket f5530j;

    /* renamed from: m, reason: collision with root package name */
    private float f5533m;

    /* renamed from: n, reason: collision with root package name */
    private float f5534n;

    /* renamed from: q, reason: collision with root package name */
    private int f5536q;
    private int r;
    private int s;

    /* renamed from: t, reason: collision with root package name */
    private int f5537t;

    /* renamed from: u, reason: collision with root package name */
    private long f5538u;

    /* renamed from: a, reason: collision with root package name */
    private final Object f5522a = new Object();

    /* renamed from: d, reason: collision with root package name */
    private String f5525d = "EShareX";

    /* renamed from: h, reason: collision with root package name */
    private final Handler f5528h = new Handler(Looper.getMainLooper());

    /* renamed from: i, reason: collision with root package name */
    private final Object f5529i = new Object();

    /* renamed from: k, reason: collision with root package name */
    private int f5531k = 8888;

    /* renamed from: l, reason: collision with root package name */
    private int f5532l = 57395;
    private int o = 1280;

    /* renamed from: p, reason: collision with root package name */
    private int f5535p = 720;

    /* renamed from: z, reason: collision with root package name */
    final String f5543z = "deviceFound";

    /* renamed from: b, reason: collision with root package name */
    private List f5523b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    private List f5524c = new CopyOnWriteArrayList();

    /* renamed from: v, reason: collision with root package name */
    private Lock f5539v = new ReentrantLock();

    /* renamed from: w, reason: collision with root package name */
    private Lock f5540w = new ReentrantLock();

    /* renamed from: x, reason: collision with root package name */
    private defpackage.a f5541x = defpackage.a.a();

    /* renamed from: g, reason: collision with root package name */
    private ExecutorService f5527g = Executors.newCachedThreadPool();

    /* renamed from: y, reason: collision with root package name */
    private l f5542y = l.a();

    a(Context context) {
        this.e = context;
        this.f5526f = (WifiManager) context.getSystemService("wifi");
    }

    private synchronized void d(int i2, int i3, float f2) {
        if (i2 <= 0 || i3 <= 0) {
            try {
                this.f5536q = d.b(this.e);
                this.r = d.a(this.e);
                k.c("获取屏幕宽高", Integer.valueOf(this.f5536q), Integer.valueOf(this.r));
            } catch (Throwable th) {
                throw th;
            }
        }
        if (i2 <= 0) {
            i2 = this.f5536q;
        }
        if (i3 <= 0) {
            i3 = this.r;
        }
        if (this.s != i2 || this.f5537t != i3) {
            this.s = i2;
            this.f5537t = i3;
            this.f5533m = (this.o * f2) / i2;
            this.f5534n = (this.f5535p * f2) / i3;
            k.f("屏幕缩放比", Float.valueOf(f2), Integer.valueOf(this.o), Integer.valueOf(this.f5535p), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(this.f5533m), Float.valueOf(this.f5534n));
        }
    }

    private boolean f(MotionEvent motionEvent, boolean z2, int i2, int i3, float f2) {
        if (this.f5530j == null) {
            return false;
        }
        String str = z2 ? "MIRRORTOUCHEVENT" : "TOUCHEVENT";
        int action = motionEvent.getAction();
        if (action == 2) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.f5538u < 55) {
                return false;
            }
            this.f5538u = jCurrentTimeMillis;
        } else if (action == 0) {
            d(i2, i3, f2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("\r\n");
        sb.append(action);
        sb.append("\r\n");
        sb.append("[");
        for (int i4 = 0; i4 < motionEvent.getPointerCount(); i4++) {
            sb.append("={");
            sb.append(motionEvent.getX(i4) * this.f5533m);
            sb.append(",");
            sb.append(motionEvent.getY(i4) * this.f5534n);
            sb.append("}");
        }
        sb.append("]");
        sb.append("\r\n\r\n");
        return g(sb.toString());
    }

    @Override // com.eshare.api.IEvent
    public boolean a(int i2) {
        return g("KEYEVENT\r\n" + i2 + "\r\n\r\n");
    }

    @Override // com.eshare.api.IEvent
    public boolean b(MotionEvent motionEvent) {
        return f(motionEvent, true, 0, 0, 1.0f);
    }

    public c c() {
        return null;
    }

    public boolean e(float f2, float f3, int i2) {
        if (this.f5530j == null) {
            return false;
        }
        if (i2 == 2) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.f5538u < 55) {
                return false;
            }
            this.f5538u = jCurrentTimeMillis;
        }
        return g("GYROSCOPEEVENT\r\n" + f2 + "\r\n" + f3 + "\r\n" + i2 + "\r\n\r\n");
    }

    public synchronized boolean g(String str) {
        this.f5539v.lock();
        try {
            Socket socket = this.f5530j;
            if (socket != null) {
                try {
                    socket.getOutputStream().write(str.getBytes());
                    this.f5530j.getOutputStream().flush();
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                    k.i("sendMessage", e);
                }
            }
            return false;
        } finally {
            this.f5539v.unlock();
        }
    }
}
