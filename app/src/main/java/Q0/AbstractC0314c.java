package q0;

import android.content.Context;
import android.os.Build;

/* renamed from: q0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0314c {

    /* renamed from: a, reason: collision with root package name */
    private static String f7202a = null;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f7203b = true;

    public static String a(Context context) {
        if (f7202a == null) {
            f7202a = AbstractC0319h.f(context, "com.eshare.optoma.key.DEVICE_NAME", Build.MODEL);
        }
        return f7202a;
    }

    public static boolean b(Context context) {
        if (f7203b) {
            f7203b = AbstractC0319h.b(context, "com.eshare.optoma.key.FIRST_CAST", true);
        }
        return f7203b;
    }

    public static void c(Context context, String str) {
        if (str.equals(f7202a)) {
            return;
        }
        AbstractC0319h.i(context, "com.eshare.optoma.key.DEVICE_NAME", str);
        f7202a = str;
    }

    public static void d(Context context, boolean z2) {
        if (f7203b != z2) {
            AbstractC0319h.h(context, "com.eshare.optoma.key.FIRST_CAST", z2);
            f7203b = z2;
        }
    }
}
