package com.eshare.mirror;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.core.app.k;
import com.eshare.api.EShareAPI;
import defpackage.g;
import defpackage.l;
import defpackage.o;
import defpackage.q;
import defpackage.s;
import s0.AbstractC0325a;
import t0.f;

/* loaded from: classes.dex */
public class MirrorScreenCaptureService extends Service {

    /* renamed from: i, reason: collision with root package name */
    private a f5590i;

    /* renamed from: j, reason: collision with root package name */
    private o f5591j;

    /* renamed from: k, reason: collision with root package name */
    private com.eshare.mirror.a f5592k;

    /* renamed from: l, reason: collision with root package name */
    private l f5593l;

    /* renamed from: n, reason: collision with root package name */
    private EShareAPI f5595n;
    private s o;

    /* renamed from: p, reason: collision with root package name */
    private String f5596p;

    /* renamed from: a, reason: collision with root package name */
    private final int f5583a = 1;

    /* renamed from: b, reason: collision with root package name */
    private final int f5584b = 2;

    /* renamed from: c, reason: collision with root package name */
    private final int f5585c = 3;

    /* renamed from: d, reason: collision with root package name */
    private final int f5586d = 1;
    private final int e = 2;

    /* renamed from: f, reason: collision with root package name */
    private final String f5587f = "ButtonId";

    /* renamed from: g, reason: collision with root package name */
    private boolean f5588g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f5589h = false;

    /* renamed from: m, reason: collision with root package name */
    private int f5594m = 0;

    /* renamed from: q, reason: collision with root package name */
    private q f5597q = new b();
    public final Handler r = new c();

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            MirrorScreenCaptureService.this.f5594m = 0;
            String action = intent.getAction();
            if (!action.equals("com.eshare.mirror.ButtonClick")) {
                if (action.equals("com.eshare.mirror.startmirror")) {
                    if (MirrorScreenCaptureService.this.f5588g) {
                        return;
                    }
                    MirrorScreenCaptureService.this.l();
                    return;
                } else {
                    if (action.equals("com.eshare.mirror.stopmirror") && MirrorScreenCaptureService.this.f5588g) {
                        MirrorScreenCaptureService.this.q();
                        if (defpackage.b.a()) {
                            MirrorScreenCaptureService.this.stopSelf();
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            if (intent.getIntExtra("ButtonId", 0) != 2) {
                Intent launchIntentForPackage = MirrorScreenCaptureService.this.getPackageManager().getLaunchIntentForPackage(MirrorScreenCaptureService.this.getPackageName());
                launchIntentForPackage.addFlags(268435456);
                MirrorScreenCaptureService.this.startActivity(launchIntentForPackage);
                return;
            }
            MirrorScreenCaptureService.this.f5588g = !r3.f5588g;
            if (MirrorScreenCaptureService.this.f5588g) {
                MirrorScreenCaptureService.this.l();
                return;
            }
            MirrorScreenCaptureService.this.q();
            if (defpackage.b.a()) {
                MirrorScreenCaptureService.this.stopSelf();
            }
        }
    }

    class b implements q {
        b() {
        }

        @Override // defpackage.q
        public void a(int i2) {
            if (i2 == 0) {
                Log.d("eshare", "mirror connected");
                MirrorScreenCaptureService.this.r.sendEmptyMessage(1);
            } else {
                if (i2 == 1) {
                    Log.d("eshare", "mirror disconnected");
                    MirrorScreenCaptureService.this.r.sendEmptyMessage(3);
                    return;
                }
                Log.d("eshare", "statusCode:" + i2);
                MirrorScreenCaptureService.this.r.sendEmptyMessageDelayed(2, 500L);
            }
        }
    }

    class c extends Handler {
        c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                MirrorScreenCaptureService.this.sendBroadcast(new Intent("com.eshare.action.mirror.connected"));
                MirrorScreenCaptureService.this.e(true);
                MirrorScreenCaptureService.this.n();
                MirrorScreenCaptureService.this.f5594m = 0;
                return;
            }
            if (i2 != 2) {
                if (i2 != 3) {
                    return;
                }
                MirrorScreenCaptureService.this.sendBroadcast(new Intent("com.eshare.action.mirror.disconnected"));
                return;
            }
            Log.d("eshare", "do connect  retry " + MirrorScreenCaptureService.this.f5594m + " " + MirrorScreenCaptureService.this.f5595n.c());
            MirrorScreenCaptureService.k(MirrorScreenCaptureService.this);
            try {
                if (MirrorScreenCaptureService.this.f5592k != null && MirrorScreenCaptureService.this.f5592k.b()) {
                    if (MirrorScreenCaptureService.this.f5594m < 20) {
                        MirrorScreenCaptureService.this.l();
                        return;
                    }
                }
            } catch (Exception unused) {
            }
            MirrorScreenCaptureService.this.sendBroadcast(new Intent("com.eshare.action.mirror.disconnected"));
            MirrorScreenCaptureService.this.q();
            if (defpackage.b.a()) {
                MirrorScreenCaptureService.this.stopSelf();
            }
        }
    }

    private class d extends MediaProjection.Callback {
        private d() {
        }

        @Override // android.media.projection.MediaProjection.Callback
        public void onStop() {
            MirrorScreenCaptureService.this.f5593l.b(null);
            MirrorScreenCaptureService.this.stopSelf();
        }

        /* synthetic */ d(MirrorScreenCaptureService mirrorScreenCaptureService, b bVar) {
            this();
        }
    }

    private int b(String str, String str2) {
        return g.b(this, str, str2);
    }

    private void j() {
        l lVarA = l.a();
        this.f5593l = lVarA;
        MediaProjection mediaProjectionC = lVarA.c();
        if (mediaProjectionC != null) {
            mediaProjectionC.registerCallback(new d(this, null), null);
        }
    }

    static /* synthetic */ int k(MirrorScreenCaptureService mirrorScreenCaptureService) {
        int i2 = mirrorScreenCaptureService.f5594m;
        mirrorScreenCaptureService.f5594m = i2 + 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void l() {
        try {
            String strC = this.f5595n.c();
            if (strC == null) {
                strC = this.f5596p;
            } else {
                this.f5596p = strC;
            }
            com.eshare.mirror.a aVar = this.f5592k;
            if (aVar != null) {
                aVar.g();
            }
            com.eshare.mirror.a aVar2 = new com.eshare.mirror.a(strC);
            this.f5592k = aVar2;
            aVar2.e();
            if (this.f5591j == null) {
                o oVar = new o(this);
                this.f5591j = oVar;
                oVar.e(this.f5597q);
            }
            this.f5591j.c();
            this.f5591j.d(strC);
            this.f5588g = true;
            e(true);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.o == null && this.f5593l.d()) {
            s();
            this.o = new s(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void q() {
        try {
            o oVar = this.f5591j;
            if (oVar != null) {
                oVar.c();
            }
            com.eshare.mirror.a aVar = this.f5592k;
            if (aVar != null) {
                aVar.g();
                this.f5592k = null;
            }
            s();
            this.f5588g = false;
            e(false);
        } catch (Throwable th) {
            throw th;
        }
    }

    private void s() {
        s sVar = this.o;
        if (sVar != null) {
            sVar.b();
            this.o = null;
        }
    }

    public void d() {
        ((NotificationManager) getSystemService("notification")).cancel(65537);
    }

    public void e(boolean z2) {
        if (this.f5589h) {
            if (z2 || !defpackage.b.a()) {
                if (Build.VERSION.SDK_INT >= 26) {
                    NotificationChannel notificationChannelA = f.a("Luma", "Cast", 1);
                    notificationChannelA.setDescription("Cast screen");
                    NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
                    if (notificationManager != null) {
                        notificationManager.createNotificationChannel(notificationChannelA);
                    }
                }
                k.c cVar = new k.c(this, "Luma");
                Intent intent = new Intent("com.eshare.mirror.ButtonClick");
                intent.putExtra("ButtonId", 2);
                RemoteViews remoteViews = new RemoteViews(getPackageName(), b("layout", "eshare_layout_notification"));
                PendingIntent activity = PendingIntent.getActivity(this, 100, getPackageManager().getLaunchIntentForPackage(getPackageName()), 67108864);
                remoteViews.setOnClickPendingIntent(b("id", "eshare_ib_switch"), PendingIntent.getBroadcast(this, 1, intent, 67108864));
                remoteViews.setTextViewText(b("id", "eshare_tv_title"), getString(b("string", "eshare_mirror_open_close")));
                if (z2) {
                    remoteViews.setImageViewResource(b("id", "eshare_ib_switch"), b("drawable", "eshare_cb_on"));
                    remoteViews.setTextViewText(b("id", "eshare_tv_content"), getString(b("string", "eshare_mirror_description_stop")));
                } else {
                    remoteViews.setImageViewResource(b("id", "eshare_ib_switch"), b("drawable", "eshare_cb_off"));
                    remoteViews.setTextViewText(b("id", "eshare_tv_content"), getString(b("string", "eshare_mirror_description_start")));
                }
                cVar.d(remoteViews).e(activity).k(System.currentTimeMillis()).i(0).h(true).j(AbstractC0325a.f7415c).g(BitmapFactory.decodeResource(getResources(), AbstractC0325a.f7416d)).c(Color.parseColor("#D21A21"));
                Notification notificationA = cVar.a();
                notificationA.flags = 2;
                if (defpackage.b.a()) {
                    startForeground(65537, notificationA, 32);
                } else {
                    startForeground(65537, notificationA);
                }
            }
        }
    }

    public void g() {
        this.f5590i = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.eshare.mirror.ButtonClick");
        intentFilter.addAction("com.eshare.mirror.startmirror");
        intentFilter.addAction("com.eshare.mirror.stopmirror");
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(this.f5590i, intentFilter, 2);
        } else {
            registerReceiver(this.f5590i, intentFilter);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f5589h = true;
        this.f5595n = EShareAPI.a(this);
        if (Build.VERSION.SDK_INT < 29) {
            j();
            l();
        }
        g();
    }

    @Override // android.app.Service
    public void onDestroy() {
        Log.d("eshare", "Android mirror version 2");
        super.onDestroy();
        this.f5589h = false;
        q();
        p();
        u();
        d();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) throws Throwable {
        defpackage.k.a("MirrorService onStartCommand...startId=" + i3);
        if (Build.VERSION.SDK_INT < 29) {
            return 2;
        }
        e(true);
        int intExtra = intent.getIntExtra("code", -1);
        Intent intent2 = (Intent) intent.getParcelableExtra("data");
        if (intent2 == null) {
            return 2;
        }
        l.a().b(((MediaProjectionManager) getApplicationContext().getSystemService("media_projection")).getMediaProjection(intExtra, intent2));
        j();
        l();
        return 2;
    }

    public void p() {
        this.f5593l.e();
    }

    public void u() {
        a aVar = this.f5590i;
        if (aVar != null) {
            unregisterReceiver(aVar);
            this.f5590i = null;
            ((NotificationManager) getSystemService("notification")).cancelAll();
        }
    }
}
