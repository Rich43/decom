package com.caglobal.kodakluma.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.eshare.api.EShareAPI;
import com.eshare.api.IMedia;
import com.eshare.api.callback.MediaStateCallback;
import h0.C0262c;
import h0.l;
import h0.n;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import q0.k;

/* loaded from: classes.dex */
public class MediaService extends Service {

    /* renamed from: a, reason: collision with root package name */
    private Context f5422a;

    /* renamed from: b, reason: collision with root package name */
    private IMedia f5423b;

    /* renamed from: c, reason: collision with root package name */
    private List f5424c;

    /* renamed from: d, reason: collision with root package name */
    private e f5425d;
    private g e;

    /* renamed from: f, reason: collision with root package name */
    private d f5426f;

    /* renamed from: h, reason: collision with root package name */
    private l f5428h;

    /* renamed from: i, reason: collision with root package name */
    private List f5429i;

    /* renamed from: j, reason: collision with root package name */
    private List f5430j;

    /* renamed from: k, reason: collision with root package name */
    private int f5431k;

    /* renamed from: l, reason: collision with root package name */
    private int f5432l;

    /* renamed from: g, reason: collision with root package name */
    private int f5427g = 10;

    /* renamed from: m, reason: collision with root package name */
    private final Handler f5433m = new a();

    class a extends Handler {

        /* renamed from: com.caglobal.kodakluma.service.MediaService$a$a, reason: collision with other inner class name */
        class C0068a implements MediaStateCallback {
            C0068a() {
            }
        }

        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            MediaService.this.f5423b.getMediaState(new C0068a());
            sendMessageDelayed(obtainMessage(1), 1000L);
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5436a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f5437b;

        b(int i2, int i3) {
            this.f5436a = i2;
            this.f5437b = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (j0.b bVar : MediaService.this.f5424c) {
                if (bVar != null) {
                    bVar.e(this.f5436a, this.f5437b);
                }
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MediaService.this.f5425d != null) {
                MediaService.this.f5425d.h(MediaService.this.f5428h);
            }
        }
    }

    public interface d {
    }

    public interface e {
        void h(l lVar);
    }

    public class f extends Binder {
        public f() {
        }

        public MediaService a() {
            return MediaService.this;
        }
    }

    public interface g {
        void l(l lVar);
    }

    private void h() {
        this.f5433m.post(new c());
    }

    private void i(int i2, int i3) {
        this.f5433m.post(new b(i2, i3));
    }

    public void e(Object... objArr) throws Throwable {
        k.a(objArr);
    }

    public void f(Object... objArr) throws Throwable {
        k.b(objArr);
    }

    public l g() {
        return this.f5428h;
    }

    public void j(int i2, boolean z2) throws Throwable {
        l lVar;
        File file;
        if (z2) {
            List list = this.f5429i;
            if (list == null || list.size() < 1) {
                return;
            }
            u();
            int i3 = this.f5431k + i2;
            this.f5431k = i3;
            if (i3 < 0) {
                this.f5431k = this.f5429i.size() - 1;
            }
            if (this.f5431k >= this.f5429i.size()) {
                this.f5431k = 0;
            }
            lVar = (l) this.f5429i.get(this.f5431k);
            file = new File(lVar.c());
        } else {
            List list2 = this.f5430j;
            if (list2 == null || list2.size() < 1) {
                return;
            }
            u();
            int i4 = this.f5432l;
            if (i4 == 0) {
                this.f5431k += i2;
            } else if (i4 == 2) {
                this.f5431k = new Random().nextInt(this.f5430j.size() - 1);
            }
            if (this.f5431k < 0) {
                this.f5431k = this.f5430j.size() - 1;
            }
            if (this.f5431k >= this.f5430j.size()) {
                this.f5431k = 0;
            }
            lVar = (l) this.f5430j.get(this.f5431k);
            file = new File(lVar.c());
        }
        o(file, z2);
        g gVar = this.e;
        if (gVar != null) {
            gVar.l(lVar);
        }
    }

    public void k(j0.b bVar) {
        if (this.f5424c.contains(bVar)) {
            return;
        }
        this.f5424c.add(bVar);
    }

    public void l(int i2) {
        this.f5431k = i2;
    }

    public void m(d dVar) {
        this.f5426f = dVar;
    }

    public void n(e eVar) {
        this.f5425d = eVar;
    }

    public void o(File file, boolean z2) throws Throwable {
        f("setFileItem", file);
        if (file == null) {
            this.f5428h = null;
        } else if (z2) {
            this.f5428h = new n(file);
        } else {
            this.f5428h = new C0262c(file);
        }
        h();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return new f();
    }

    @Override // android.app.Service
    public void onCreate() throws Throwable {
        super.onCreate();
        e("MediaService", "onCreate");
        this.f5423b = EShareAPI.init(this).media();
        this.f5424c = new ArrayList();
        this.f5422a = this;
    }

    @Override // android.app.Service
    public void onDestroy() throws Throwable {
        super.onDestroy();
        e("MediaService", "onDestroy");
        u();
    }

    public void p(int i2) {
        this.f5432l = i2;
    }

    public void q(List list) {
        this.f5430j = list;
    }

    public void r(g gVar) {
        this.e = gVar;
    }

    public void s(List list) {
        this.f5429i = list;
    }

    public void t() throws Throwable {
        f("startCheckProgress");
        this.f5433m.removeMessages(1);
        this.f5433m.sendEmptyMessage(1);
    }

    public void u() throws Throwable {
        f("stopCheckProgress");
        this.f5433m.removeCallbacksAndMessages(null);
        o(null, true);
        i(0, 0);
    }

    public void v(j0.b bVar) {
        if (this.f5424c.contains(bVar)) {
            this.f5424c.remove(bVar);
        }
    }
}
