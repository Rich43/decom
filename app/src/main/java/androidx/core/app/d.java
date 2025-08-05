package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: classes.dex */
abstract class d {

    /* renamed from: a, reason: collision with root package name */
    protected static final Class f2856a;

    /* renamed from: b, reason: collision with root package name */
    protected static final Field f2857b;

    /* renamed from: c, reason: collision with root package name */
    protected static final Field f2858c;

    /* renamed from: d, reason: collision with root package name */
    protected static final Method f2859d;
    protected static final Method e;

    /* renamed from: f, reason: collision with root package name */
    protected static final Method f2860f;

    /* renamed from: g, reason: collision with root package name */
    private static final Handler f2861g = new Handler(Looper.getMainLooper());

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ C0026d f2862a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f2863b;

        a(C0026d c0026d, Object obj) {
            this.f2862a = c0026d;
            this.f2863b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2862a.f2868a = this.f2863b;
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Application f2864a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ C0026d f2865b;

        b(Application application, C0026d c0026d) {
            this.f2864a = application;
            this.f2865b = c0026d;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2864a.unregisterActivityLifecycleCallbacks(this.f2865b);
        }
    }

    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f2866a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f2867b;

        c(Object obj, Object obj2) {
            this.f2866a = obj;
            this.f2867b = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Method method = d.f2859d;
                if (method != null) {
                    method.invoke(this.f2866a, this.f2867b, Boolean.FALSE, "AppCompat recreation");
                } else {
                    d.e.invoke(this.f2866a, this.f2867b, Boolean.FALSE);
                }
            } catch (RuntimeException e) {
                if (e.getClass() == RuntimeException.class && e.getMessage() != null && e.getMessage().startsWith("Unable to stop")) {
                    throw e;
                }
            } catch (Throwable th) {
                Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
            }
        }
    }

    /* renamed from: androidx.core.app.d$d, reason: collision with other inner class name */
    private static final class C0026d implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a, reason: collision with root package name */
        Object f2868a;

        /* renamed from: b, reason: collision with root package name */
        private Activity f2869b;

        /* renamed from: c, reason: collision with root package name */
        private final int f2870c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f2871d = false;
        private boolean e = false;

        /* renamed from: f, reason: collision with root package name */
        private boolean f2872f = false;

        C0026d(Activity activity) {
            this.f2869b = activity;
            this.f2870c = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f2869b == activity) {
                this.f2869b = null;
                this.e = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (!this.e || this.f2872f || this.f2871d || !d.h(this.f2868a, this.f2870c, activity)) {
                return;
            }
            this.f2872f = true;
            this.f2868a = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.f2869b == activity) {
                this.f2871d = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    static {
        Class clsA = a();
        f2856a = clsA;
        f2857b = b();
        f2858c = f();
        f2859d = d(clsA);
        e = c(clsA);
        f2860f = e(clsA);
    }

    private static Class a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method c(Class cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method d(Class cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method e(Class cls) {
        if (g() && cls != null) {
            try {
                Class<?> cls2 = Boolean.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls2, Configuration.class, Configuration.class, cls2, cls2);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static Field f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean g() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 == 26 || i2 == 27;
    }

    protected static boolean h(Object obj, int i2, Activity activity) {
        try {
            Object obj2 = f2858c.get(activity);
            if (obj2 == obj && activity.hashCode() == i2) {
                f2861g.postAtFrontOfQueue(new c(f2857b.get(activity), obj2));
                return true;
            }
            return false;
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    static boolean i(Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        }
        if (g() && f2860f == null) {
            return false;
        }
        if (e == null && f2859d == null) {
            return false;
        }
        try {
            Object obj2 = f2858c.get(activity);
            if (obj2 == null || (obj = f2857b.get(activity)) == null) {
                return false;
            }
            Application application = activity.getApplication();
            C0026d c0026d = new C0026d(activity);
            application.registerActivityLifecycleCallbacks(c0026d);
            Handler handler = f2861g;
            handler.post(new a(c0026d, obj2));
            try {
                if (g()) {
                    Method method = f2860f;
                    Boolean bool = Boolean.FALSE;
                    method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                } else {
                    activity.recreate();
                }
                handler.post(new b(application, c0026d));
                return true;
            } catch (Throwable th) {
                f2861g.post(new b(application, c0026d));
                throw th;
            }
        } catch (Throwable unused) {
            return false;
        }
    }
}
