package X0;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes.dex */
final class a implements Camera.AutoFocusCallback {

    /* renamed from: f, reason: collision with root package name */
    private static final String f1230f = "a";

    /* renamed from: g, reason: collision with root package name */
    private static final Collection f1231g;

    /* renamed from: a, reason: collision with root package name */
    private boolean f1232a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f1233b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f1234c;

    /* renamed from: d, reason: collision with root package name */
    private final Camera f1235d;
    private AsyncTask e;

    /* renamed from: X0.a$a, reason: collision with other inner class name */
    private static class AsyncTaskC0014a extends AsyncTask {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference f1236a;

        public AsyncTaskC0014a(a aVar) {
            this.f1236a = new WeakReference(aVar);
        }

        @Override // android.os.AsyncTask
        protected Object doInBackground(Object... objArr) throws InterruptedException {
            try {
                Thread.sleep(1200L);
            } catch (InterruptedException unused) {
            }
            a aVar = (a) this.f1236a.get();
            if (aVar == null) {
                return null;
            }
            aVar.c();
            return null;
        }
    }

    static {
        ArrayList arrayList = new ArrayList(2);
        f1231g = arrayList;
        arrayList.add("auto");
        arrayList.add("macro");
    }

    a(Context context, Camera camera) {
        this.f1235d = camera;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String focusMode = camera.getParameters().getFocusMode();
        boolean z2 = defaultSharedPreferences.getBoolean("preferences_auto_focus", true) && f1231g.contains(focusMode);
        this.f1234c = z2;
        Log.i(f1230f, "Current focus mode '" + focusMode + "'; use auto focus? " + z2);
        c();
    }

    private synchronized void a() {
        if (!this.f1232a && this.e == null) {
            AsyncTaskC0014a asyncTaskC0014a = new AsyncTaskC0014a(this);
            try {
                asyncTaskC0014a.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
                this.e = asyncTaskC0014a;
            } catch (RejectedExecutionException e) {
                Log.w(f1230f, "Could not request auto focus", e);
            }
        }
    }

    private synchronized void b() {
        try {
            AsyncTask asyncTask = this.e;
            if (asyncTask != null) {
                if (asyncTask.getStatus() != AsyncTask.Status.FINISHED) {
                    this.e.cancel(true);
                }
                this.e = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    synchronized void c() {
        if (this.f1234c) {
            this.e = null;
            if (!this.f1232a && !this.f1233b) {
                try {
                    this.f1235d.autoFocus(this);
                    this.f1233b = true;
                } catch (RuntimeException e) {
                    Log.w(f1230f, "Unexpected exception while focusing", e);
                    a();
                }
            }
        }
    }

    synchronized void d() {
        this.f1232a = true;
        if (this.f1234c) {
            b();
            try {
                this.f1235d.cancelAutoFocus();
            } catch (RuntimeException e) {
                Log.w(f1230f, "Unexpected exception while cancelling focusing", e);
            }
        }
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public synchronized void onAutoFocus(boolean z2, Camera camera) {
        this.f1233b = false;
        a();
    }
}
