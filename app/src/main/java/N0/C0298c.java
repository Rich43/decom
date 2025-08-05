package n0;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.MediaStore;
import com.caglobal.kodakluma.CustomApplication;
import com.eshare.api.EShareAPI;
import com.eshare.api.IMedia;
import h0.C0260a;
import h0.C0262c;
import h0.C0264e;
import h0.n;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import p0.C0306a;
import p0.C0307b;
import p0.C0308c;
import q0.k;

/* renamed from: n0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0298c {

    /* renamed from: n, reason: collision with root package name */
    public static boolean f6764n = true;

    /* renamed from: a, reason: collision with root package name */
    private ExecutorService f6765a;

    /* renamed from: b, reason: collision with root package name */
    private ContentResolver f6766b;

    /* renamed from: c, reason: collision with root package name */
    private final Handler f6767c;

    /* renamed from: d, reason: collision with root package name */
    private List f6768d;
    private List e;

    /* renamed from: f, reason: collision with root package name */
    private List f6769f;

    /* renamed from: g, reason: collision with root package name */
    private List f6770g;

    /* renamed from: h, reason: collision with root package name */
    private List f6771h;

    /* renamed from: i, reason: collision with root package name */
    private List f6772i;

    /* renamed from: j, reason: collision with root package name */
    private i f6773j;

    /* renamed from: k, reason: collision with root package name */
    private g f6774k;

    /* renamed from: l, reason: collision with root package name */
    private f f6775l;

    /* renamed from: m, reason: collision with root package name */
    boolean f6776m;

    /* renamed from: n0.c$a */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f6777a;

        /* renamed from: n0.c$a$a, reason: collision with other inner class name */
        class RunnableC0095a implements Runnable {
            RunnableC0095a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (C0298c.this.f6773j != null) {
                    C0298c.this.f6773j.W(C0298c.this.f6768d);
                }
            }
        }

        a(Context context) {
            this.f6777a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            SystemClock.uptimeMillis();
            C0298c.this.B(this.f6777a);
            C0298c.this.f6767c.post(new RunnableC0095a());
        }
    }

    /* renamed from: n0.c$b */
    class b implements Runnable {

        /* renamed from: n0.c$b$a */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (C0298c.this.f6773j != null) {
                    C0298c.this.f6773j.g(C0298c.this.e, C0298c.this.f6769f);
                }
            }
        }

        b() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            long jUptimeMillis = SystemClock.uptimeMillis();
            C0298c.this.x();
            C0298c.this.f6767c.post(new a());
            C0298c.this.n("listMedias", Long.valueOf(SystemClock.uptimeMillis() - jUptimeMillis), Thread.currentThread().getName());
        }
    }

    /* renamed from: n0.c$c, reason: collision with other inner class name */
    class RunnableC0096c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f6782a;

        /* renamed from: n0.c$c$a */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (C0298c.this.f6773j != null) {
                    C0298c.this.f6773j.W(C0298c.this.f6768d);
                }
            }
        }

        /* renamed from: n0.c$c$b */
        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (C0298c.this.f6773j != null) {
                    C0298c.this.f6773j.g(C0298c.this.e, C0298c.this.f6769f);
                }
            }
        }

        RunnableC0096c(Context context) {
            this.f6782a = context;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            long jUptimeMillis = SystemClock.uptimeMillis();
            C0298c.this.B(this.f6782a);
            C0298c.this.f6767c.post(new a());
            C0298c.this.x();
            C0298c.this.f6767c.post(new b());
            C0298c.this.n("listMedias", Long.valueOf(SystemClock.uptimeMillis() - jUptimeMillis), Thread.currentThread().getName());
        }
    }

    /* renamed from: n0.c$d */
    class d implements Runnable {

        /* renamed from: n0.c$d$a */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (C0298c.this.f6774k != null) {
                    C0298c.this.f6774k.x(C0298c.this.f6770g);
                }
            }
        }

        d() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            long jUptimeMillis = SystemClock.uptimeMillis();
            C0298c.this.y();
            C0298c.this.f6767c.post(new a());
            C0298c.this.n("listDocuments", Long.valueOf(SystemClock.uptimeMillis() - jUptimeMillis), Thread.currentThread().getName());
        }
    }

    /* renamed from: n0.c$e */
    class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f6788a;

        /* renamed from: n0.c$e$a */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (C0298c.this.f6775l != null) {
                    C0298c.this.f6775l.o(C0298c.this.f6772i);
                }
            }
        }

        e(Context context) {
            this.f6788a = context;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            long jUptimeMillis = SystemClock.uptimeMillis();
            C0298c.this.w(EShareAPI.init(this.f6788a).media());
            C0298c.this.f6767c.post(new a());
            C0298c.this.n("listAlbums", Long.valueOf(SystemClock.uptimeMillis() - jUptimeMillis), Thread.currentThread().getName());
        }
    }

    /* renamed from: n0.c$f */
    public interface f {
        void o(List list);
    }

    /* renamed from: n0.c$g */
    public interface g {
        void x(List list);
    }

    /* renamed from: n0.c$h */
    private static class h {

        /* renamed from: a, reason: collision with root package name */
        private static C0298c f6791a = new C0298c();
    }

    /* renamed from: n0.c$i */
    public interface i {
        void W(List list);

        void g(List list, List list2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void B(Context context) {
        try {
            this.f6776m = true;
            Cursor cursorQuery = this.f6766b.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
            if (cursorQuery == null) {
                return;
            }
            this.f6768d.clear();
            while (cursorQuery.moveToNext()) {
                n nVar = new n(cursorQuery.getString(cursorQuery.getColumnIndex("_data")));
                if (nVar.e()) {
                    long j2 = cursorQuery.getLong(cursorQuery.getColumnIndex("duration"));
                    if (j2 > 0) {
                        nVar.m(j2);
                        nVar.f(cursorQuery.getString(cursorQuery.getColumnIndex("_display_name")));
                        nVar.l(context);
                        if (!this.f6768d.contains(nVar)) {
                            this.f6768d.add(nVar);
                        }
                    }
                }
            }
            if (!cursorQuery.isClosed()) {
                cursorQuery.close();
            }
            Collections.sort(this.f6768d, new C0308c());
            t();
            n("listVideos", Integer.valueOf(this.f6768d.size()), this.f6768d);
            this.f6776m = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    private void o() {
        String strG = null;
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            C0262c c0262c = (C0262c) this.e.get(i2);
            if (!c0262c.g().equals(strG)) {
                c0262c.j(true);
                strG = c0262c.g();
            }
        }
    }

    private void q() {
        String str = null;
        for (int i2 = 0; i2 < this.f6770g.size(); i2++) {
            C0264e c0264e = (C0264e) this.f6770g.get(i2);
            String strG = c0264e.g();
            if (strG.equals(str)) {
                C0264e c0264e2 = (C0264e) this.f6770g.get(i2 - 1);
                c0264e2.p(false);
                c0264e.o(c0264e2.h() + 1);
            } else {
                c0264e.n(true);
                c0264e.o(1);
                str = strG;
            }
        }
    }

    public static C0298c r() {
        return h.f6791a;
    }

    private String s(String str) {
        return String.format("%1$s='%2$s'", "mime_type", str);
    }

    private void t() {
        String str = null;
        for (int i2 = 0; i2 < this.f6768d.size(); i2++) {
            n nVar = (n) this.f6768d.get(i2);
            String strG = nVar.g();
            if (strG.equals(str)) {
                n nVar2 = (n) this.f6768d.get(i2 - 1);
                nVar2.p(false);
                nVar.o(nVar2.i() + 1);
            } else {
                nVar.n(true);
                nVar.o(1);
                str = strG;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void w(IMedia iMedia) {
        try {
            Cursor cursorQuery = this.f6766b.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
            if (cursorQuery == null) {
                return;
            }
            this.f6772i.clear();
            while (cursorQuery.moveToNext()) {
                File file = new File(cursorQuery.getString(cursorQuery.getColumnIndex("_data")));
                if (file.exists()) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
                    C0260a c0260a = new C0260a(file.getParentFile());
                    if (!this.f6772i.contains(c0260a)) {
                        c0260a.j(string);
                        this.f6772i.add(c0260a);
                    }
                }
            }
            if (!cursorQuery.isClosed()) {
                cursorQuery.close();
            }
            Collections.sort(this.f6772i, new C0306a());
            n("listAlbums", Integer.valueOf(this.f6772i.size()), this.f6772i);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void x() {
        try {
            Cursor cursorQuery = this.f6766b.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
            if (cursorQuery == null) {
                return;
            }
            this.e.clear();
            this.f6769f.clear();
            while (cursorQuery.moveToNext()) {
                C0262c c0262c = new C0262c(cursorQuery.getString(cursorQuery.getColumnIndex("_data")));
                if (c0262c.e()) {
                    long j2 = cursorQuery.getLong(cursorQuery.getColumnIndex("duration"));
                    if (j2 > 0) {
                        c0262c.i(j2);
                        c0262c.f(cursorQuery.getString(cursorQuery.getColumnIndex("_display_name")));
                        if (!this.f6769f.contains(c0262c.g())) {
                            this.f6769f.add(c0262c.g());
                        }
                        if (!this.e.contains(c0262c)) {
                            this.e.add(c0262c);
                        }
                    }
                }
            }
            if (!cursorQuery.isClosed()) {
                cursorQuery.close();
            }
            Collections.sort(this.e, new C0307b());
            o();
            n("listAudios", Integer.valueOf(this.e.size()), this.e);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void y() {
        try {
            Cursor cursorQuery = this.f6766b.query(MediaStore.Files.getContentUri("external"), null, s("application/msword") + " OR " + s("application/vnd.openxmlformats-officedocument.wordprocessingml.document") + " OR " + s("application/vnd.ms-powerpoint") + " OR " + s("application/vnd.openxmlformats-officedocument.presentationml.presentation") + " OR " + s("application/vnd.ms-excel") + " OR " + s("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet") + " OR " + s("application/pdf"), null, null);
            if (cursorQuery == null) {
                return;
            }
            this.f6770g.clear();
            while (cursorQuery.moveToNext()) {
                C0264e c0264e = new C0264e(cursorQuery.getString(cursorQuery.getColumnIndex("_data")));
                if (c0264e.e()) {
                    c0264e.l(CustomApplication.b());
                    if (!this.f6770g.contains(c0264e)) {
                        this.f6770g.add(c0264e);
                    }
                }
            }
            if (!cursorQuery.isClosed()) {
                cursorQuery.close();
            }
            Collections.sort(this.f6770g, new C0308c());
            q();
            n("listDocuments", Integer.valueOf(this.f6770g.size()), this.f6770g);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void A(Context context) {
        if (this.f6766b == null) {
            this.f6766b = context.getContentResolver();
        }
        this.f6765a.execute(new RunnableC0096c(context));
    }

    public void C(f fVar) {
        this.f6775l = fVar;
    }

    public void D(g gVar) {
        this.f6774k = gVar;
    }

    public void E(i iVar) {
        this.f6773j = iVar;
    }

    public void n(Object... objArr) throws Throwable {
        if (f6764n) {
            k.a(objArr);
        }
    }

    public void p(Context context) {
        if (this.f6766b == null) {
            this.f6766b = context.getContentResolver();
        }
        this.f6765a.execute(new b());
    }

    public void u(Context context) {
        if (this.f6776m) {
            return;
        }
        if (this.f6766b == null) {
            this.f6766b = context.getContentResolver();
        }
        this.f6765a.execute(new a(context));
    }

    public void v(Context context) {
        if (this.f6766b == null) {
            this.f6766b = context.getContentResolver();
        }
        this.f6765a.execute(new e(context));
    }

    public void z(Context context) {
        if (this.f6766b == null) {
            this.f6766b = context.getContentResolver();
        }
        this.f6765a.execute(new d());
    }

    private C0298c() {
        this.f6767c = new Handler(Looper.getMainLooper());
        this.f6765a = Executors.newCachedThreadPool();
        this.f6768d = new ArrayList();
        this.e = new ArrayList();
        this.f6769f = new ArrayList();
        this.f6770g = new ArrayList();
        this.f6771h = new ArrayList();
        this.f6772i = new ArrayList();
    }
}
