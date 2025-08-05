package q0;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    private static SharedPreferences f7223a;

    public static boolean a(Context context, String str, boolean z2) {
        if (f7223a == null) {
            f7223a = context.getSharedPreferences("config", 0);
        }
        return f7223a.getBoolean(str, z2);
    }

    public static int b(Context context, String str, int i2) {
        if (f7223a == null) {
            f7223a = context.getSharedPreferences("config", 0);
        }
        return f7223a.getInt(str, i2);
    }

    public static String c(Context context, String str, String str2) {
        if (f7223a == null) {
            f7223a = context.getSharedPreferences("config", 0);
        }
        return f7223a.getString(str, str2);
    }

    public static void d(Context context, String str, boolean z2) {
        if (f7223a == null) {
            f7223a = context.getSharedPreferences("config", 0);
        }
        f7223a.edit().putBoolean(str, z2).commit();
    }

    public static void e(Context context, String str, int i2) {
        if (f7223a == null) {
            f7223a = context.getSharedPreferences("config", 0);
        }
        f7223a.edit().putInt(str, i2).commit();
    }

    public static void f(Context context, String str, String str2) {
        if (f7223a == null) {
            f7223a = context.getSharedPreferences("config", 0);
        }
        f7223a.edit().putString(str, str2).commit();
    }
}
