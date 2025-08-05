package com.eshare.lib;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.os.StrictMode;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.eshare.api.EShareAPI;
import defpackage.i;
import defpackage.j;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes.dex */
public class TVMirrorActivity extends Activity implements View.OnClickListener {

    /* renamed from: p, reason: collision with root package name */
    private static TVMirrorActivity f5554p;

    /* renamed from: a, reason: collision with root package name */
    private EShareAPI f5555a;

    /* renamed from: b, reason: collision with root package name */
    private String f5556b;

    /* renamed from: c, reason: collision with root package name */
    private ImageView f5557c;

    /* renamed from: d, reason: collision with root package name */
    private RelativeLayout f5558d;
    private ImageButton e;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayout f5559f;

    /* renamed from: g, reason: collision with root package name */
    private volatile boolean f5560g;

    /* renamed from: h, reason: collision with root package name */
    private Thread f5561h;

    /* renamed from: i, reason: collision with root package name */
    private Thread f5562i;

    /* renamed from: j, reason: collision with root package name */
    private DatagramSocket f5563j;

    /* renamed from: k, reason: collision with root package name */
    private long f5564k;

    /* renamed from: m, reason: collision with root package name */
    private BlockingQueue f5566m;

    /* renamed from: n, reason: collision with root package name */
    private Bitmap f5567n;

    /* renamed from: l, reason: collision with root package name */
    private i f5565l = new i();
    private final Handler o = new a();

    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws IOException {
            int i2 = message.what;
            if (i2 == 0) {
                if (TVMirrorActivity.this.f5557c == null || TVMirrorActivity.this.f5567n == null) {
                    return;
                }
                TVMirrorActivity.this.f5557c.setImageBitmap(TVMirrorActivity.this.f5567n);
                return;
            }
            if (i2 == 2 && TVMirrorActivity.this.f5563j != null) {
                defpackage.f.a(TVMirrorActivity.this.f5563j, TVMirrorActivity.this.f5556b);
                TVMirrorActivity.this.f5564k = System.currentTimeMillis();
                sendMessageDelayed(obtainMessage(2), 100L);
            }
        }
    }

    class b implements j {
        b() {
        }

        @Override // defpackage.j
        public void a(int i2, ByteArrayOutputStream byteArrayOutputStream, boolean z2, String str) throws IOException {
            if (z2) {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(byteArrayOutputStream.size());
                try {
                    byteArrayOutputStream.writeTo(byteArrayOutputStream2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                TVMirrorActivity.this.f5566m.clear();
                TVMirrorActivity.this.f5566m.offer(byteArrayOutputStream2);
            }
        }
    }

    class c implements View.OnTouchListener {
        c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            TVMirrorActivity.this.f5555a.b().b(motionEvent);
            return true;
        }
    }

    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() throws SecurityException, IOException, IllegalArgumentException {
            Process.setThreadPriority(Process.myTid(), -8);
            if (TVMirrorActivity.this.f5563j == null) {
                return;
            }
            byte[] bArr = new byte[1450];
            boolean z2 = false;
            while (!TVMirrorActivity.this.f5560g) {
                DatagramPacket datagramPacket = new DatagramPacket(bArr, 1450);
                if ((System.currentTimeMillis() - TVMirrorActivity.this.f5564k >= 100 || TVMirrorActivity.this.f5564k == 0) && !z2) {
                    defpackage.f.a(TVMirrorActivity.this.f5563j, TVMirrorActivity.this.f5556b);
                    TVMirrorActivity.this.f5564k = System.currentTimeMillis();
                }
                try {
                    TVMirrorActivity.this.f5563j.receive(datagramPacket);
                    if (i.a(bArr, 0) == 1) {
                        TVMirrorActivity.this.f5565l.c(null, bArr);
                    }
                    if (!z2 && !TVMirrorActivity.this.o.hasMessages(2)) {
                        TVMirrorActivity.this.o.sendEmptyMessage(2);
                        z2 = true;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() throws SecurityException, IllegalArgumentException {
            Process.setThreadPriority(Process.myTid(), -8);
            while (!TVMirrorActivity.this.f5560g) {
                try {
                    byte[] byteArray = ((ByteArrayOutputStream) TVMirrorActivity.this.f5566m.take()).toByteArray();
                    TVMirrorActivity.this.f5567n = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                    TVMirrorActivity.this.o.sendEmptyMessage(0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TVMirrorActivity.this.e.setVisibility(0);
        }
    }

    private int a(String str, String str2) {
        return defpackage.g.b(this, str, str2);
    }

    private void e() {
        this.f5557c = (ImageView) findViewById(a("id", "eshare_iv_tv_mirror"));
        this.f5558d = (RelativeLayout) findViewById(a("id", "eshare_rl_tv_mirror"));
        this.e = (ImageButton) findViewById(a("id", "eshare_ib_tv_mirror_out"));
        this.f5559f = (LinearLayout) findViewById(a("id", "eshare_ll_tv_mirror_tools"));
        this.e.setOnClickListener(this);
        findViewById(a("id", "eshare_ib_tv_mirror_in")).setOnClickListener(this);
        findViewById(a("id", "eshare_ib_tv_mirror_close")).setOnClickListener(this);
        findViewById(a("id", "eshare_ib_tv_mirror_home")).setOnClickListener(this);
        findViewById(a("id", "eshare_ib_tv_mirror_back")).setOnClickListener(this);
    }

    private void h() {
        this.f5566m = new ArrayBlockingQueue(2);
        this.f5565l.b(new b());
    }

    private void j() {
        this.f5557c.setOnTouchListener(new c());
        this.f5558d.setOnTouchListener(new d());
    }

    private void l() {
        Thread thread = new Thread(new f());
        this.f5562i = thread;
        thread.start();
    }

    private void n() throws IOException {
        if (this.f5563j == null) {
            try {
                DatagramSocket datagramSocket = new DatagramSocket();
                this.f5563j = datagramSocket;
                datagramSocket.setSoTimeout(100);
                DatagramSocket datagramSocket2 = this.f5563j;
                datagramSocket2.setReceiveBufferSize(datagramSocket2.getReceiveBufferSize() * 2);
                defpackage.f.a(this.f5563j, this.f5556b);
            } catch (SocketException e2) {
                e2.printStackTrace();
            }
        }
        Thread thread = new Thread(new e());
        this.f5561h = thread;
        thread.start();
    }

    private void p() throws IOException {
        this.f5560g = false;
        n();
        l();
    }

    private void r() {
        if (this.f5562i != null) {
            this.f5560g = true;
            this.f5562i.interrupt();
        }
    }

    private void t() {
        if (this.f5561h != null) {
            this.f5560g = true;
            this.f5561h.interrupt();
        }
    }

    private void u() {
        this.f5560g = true;
        this.o.removeMessages(2);
        t();
        r();
    }

    public void f(boolean z2) {
        if (z2) {
            this.e.setVisibility(8);
            ObjectAnimator.ofFloat(this.f5559f, "translationX", r9.getMeasuredWidth(), 0.0f).setDuration(250L).start();
        } else {
            ObjectAnimator.ofFloat(this.f5559f, "translationX", 0.0f, r9.getMeasuredWidth()).setDuration(250L).start();
            this.e.postDelayed(new g(), 250L);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a("id", "eshare_ib_tv_mirror_out")) {
            f(true);
            return;
        }
        if (id == a("id", "eshare_ib_tv_mirror_in")) {
            f(false);
            return;
        }
        if (id == a("id", "eshare_ib_tv_mirror_close")) {
            finish();
        } else if (id == a("id", "eshare_ib_tv_mirror_home")) {
            this.f5555a.b().a(3);
        } else if (id == a("id", "eshare_ib_tv_mirror_back")) {
            this.f5555a.b().a(4);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f5554p = this;
        this.f5555a = EShareAPI.a(this);
        setContentView(a("layout", "eshare_activity_tv_mirror"));
        this.f5556b = getIntent().getStringExtra("com.ecloud.eshare.lib.extra.IP_ADDRESS");
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        e();
        h();
        j();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 25 || i2 == 24) {
            this.f5555a.b().a(i2);
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity
    protected void onStart() throws IOException {
        super.onStart();
        u();
        p();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        u();
    }
}
