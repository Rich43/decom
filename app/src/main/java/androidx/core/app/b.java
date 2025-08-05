package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;

/* loaded from: classes.dex */
public abstract class b extends androidx.core.content.a {

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String[] f2853a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f2854b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f2855c;

        a(String[] strArr, Activity activity, int i2) {
            this.f2853a = strArr;
            this.f2854b = activity;
            this.f2855c = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[this.f2853a.length];
            PackageManager packageManager = this.f2854b.getPackageManager();
            String packageName = this.f2854b.getPackageName();
            int length = this.f2853a.length;
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = packageManager.checkPermission(this.f2853a[i2], packageName);
            }
            ((e) this.f2854b).onRequestPermissionsResult(this.f2855c, this.f2853a, iArr);
        }
    }

    /* renamed from: androidx.core.app.b$b, reason: collision with other inner class name */
    static class C0025b {
        static void a(Object obj) {
            ((SharedElementCallback.OnSharedElementsReadyListener) obj).onSharedElementsReady();
        }

        static void b(Activity activity, String[] strArr, int i2) {
            activity.requestPermissions(strArr, i2);
        }

        static boolean c(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    static class c {
        static boolean a(Activity activity) {
            return activity.isLaunchedFromBubble();
        }

        @SuppressLint({"BanUncheckedReflection"})
        static boolean b(Activity activity, String str) {
            try {
                return ((Boolean) PackageManager.class.getMethod("shouldShowRequestPermissionRationale", String.class).invoke(activity.getApplication().getPackageManager(), str)).booleanValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return activity.shouldShowRequestPermissionRationale(str);
            }
        }
    }

    static class d {
        static boolean a(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    public interface e {
        void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr);
    }

    public interface f {
        void d(int i2);
    }

    public static void j(Activity activity) {
        activity.finishAffinity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(Activity activity) {
        if (activity.isFinishing() || androidx.core.app.d.i(activity)) {
            return;
        }
        activity.recreate();
    }

    public static void l(final Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
        } else {
            new Handler(activity.getMainLooper()).post(new Runnable() { // from class: androidx.core.app.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.k(activity);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void m(Activity activity, String[] strArr, int i2) {
        HashSet hashSet = new HashSet();
        for (int i3 = 0; i3 < strArr.length; i3++) {
            if (TextUtils.isEmpty(strArr[i3])) {
                throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
            }
            if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(strArr[i3], "android.permission.POST_NOTIFICATIONS")) {
                hashSet.add(Integer.valueOf(i3));
            }
        }
        int size = hashSet.size();
        String[] strArr2 = size > 0 ? new String[strArr.length - size] : strArr;
        if (size > 0) {
            if (size == strArr.length) {
                return;
            }
            int i4 = 0;
            for (int i5 = 0; i5 < strArr.length; i5++) {
                if (!hashSet.contains(Integer.valueOf(i5))) {
                    strArr2[i4] = strArr[i5];
                    i4++;
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (activity instanceof f) {
                ((f) activity).d(i2);
            }
            C0025b.b(activity, strArr, i2);
        } else if (activity instanceof e) {
            new Handler(Looper.getMainLooper()).post(new a(strArr2, activity, i2));
        }
    }

    public static boolean n(Activity activity, String str) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 33 && TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return false;
        }
        if (i2 >= 32) {
            return d.a(activity, str);
        }
        if (i2 == 31) {
            return c.b(activity, str);
        }
        if (i2 >= 23) {
            return C0025b.c(activity, str);
        }
        return false;
    }

    public static void o(Activity activity, Intent intent, int i2, Bundle bundle) {
        activity.startActivityForResult(intent, i2, bundle);
    }

    public static void p(Activity activity, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        activity.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
    }
}
