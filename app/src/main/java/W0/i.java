package W0;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes.dex */
final class i {
    private static final String e = "i";

    /* renamed from: a, reason: collision with root package name */
    private final Activity f1088a;

    /* renamed from: b, reason: collision with root package name */
    private final BroadcastReceiver f1089b = new b(this);

    /* renamed from: c, reason: collision with root package name */
    private boolean f1090c = false;

    /* renamed from: d, reason: collision with root package name */
    private AsyncTask f1091d;

    private static class a extends AsyncTask {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference f1092a;

        public a(Activity activity) {
            this.f1092a = new WeakReference(activity);
        }

        @Override // android.os.AsyncTask
        protected Object doInBackground(Object... objArr) throws InterruptedException {
            try {
                Thread.sleep(300000L);
                Log.i(i.e, "Finishing activity due to inactivity");
                Activity activity = (Activity) this.f1092a.get();
                if (activity == null) {
                    return null;
                }
                activity.finish();
                return null;
            } catch (InterruptedException unused) {
                return null;
            }
        }
    }

    private static class b extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference f1093a;

        public b(i iVar) {
            this.f1093a = new WeakReference(iVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            i iVar;
            if (!"android.intent.action.BATTERY_CHANGED".equals(intent.getAction()) || (iVar = (i) this.f1093a.get()) == null) {
                return;
            }
            if (intent.getIntExtra("plugged", -1) <= 0) {
                iVar.d();
            } else {
                iVar.c();
            }
        }
    }

    i(Activity activity) {
        this.f1088a = activity;
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c() {
        AsyncTask asyncTask = this.f1091d;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.f1091d = null;
        }
    }

    synchronized void d() {
        c();
        a aVar = new a(this.f1088a);
        this.f1091d = aVar;
        try {
            aVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
        } catch (RejectedExecutionException unused) {
            Log.w(e, "Couldn't schedule inactivity task; ignoring");
        }
    }

    synchronized void e() {
        try {
            c();
            if (this.f1090c) {
                this.f1088a.unregisterReceiver(this.f1089b);
                this.f1090c = false;
            } else {
                Log.w(e, "PowerStatusReceiver was never registered?");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    synchronized void f() {
        try {
            if (this.f1090c) {
                Log.w(e, "PowerStatusReceiver was already registered?");
            } else {
                this.f1088a.registerReceiver(this.f1089b, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                this.f1090c = true;
            }
            d();
        } catch (Throwable th) {
            throw th;
        }
    }

    void g() {
        c();
    }
}
