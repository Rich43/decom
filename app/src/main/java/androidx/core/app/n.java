package androidx.core.app;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: c, reason: collision with root package name */
    private static final Object f2930c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static Set f2931d = new HashSet();
    private static final Object e = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final Context f2932a;

    /* renamed from: b, reason: collision with root package name */
    private final NotificationManager f2933b;

    static class a {
        static boolean a(NotificationManager notificationManager) {
            return notificationManager.areNotificationsEnabled();
        }

        static int b(NotificationManager notificationManager) {
            return notificationManager.getImportance();
        }
    }

    private n(Context context) {
        this.f2932a = context;
        this.f2933b = (NotificationManager) context.getSystemService("notification");
    }

    public static n b(Context context) {
        return new n(context);
    }

    public boolean a() throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        if (Build.VERSION.SDK_INT >= 24) {
            return a.a(this.f2933b);
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.f2932a.getSystemService("appops");
        ApplicationInfo applicationInfo = this.f2932a.getApplicationInfo();
        String packageName = this.f2932a.getApplicationContext().getPackageName();
        int i2 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            Method method = cls.getMethod("checkOpNoThrow", cls2, cls2, String.class);
            Integer num = (Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class);
            num.intValue();
            return ((Integer) method.invoke(appOpsManager, num, Integer.valueOf(i2), packageName)).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }
}
