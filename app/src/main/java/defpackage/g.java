package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    private static SharedPreferences f6193a;

    public static float a(Context context, String str, float f2) {
        if (f6193a == null) {
            f6193a = PreferenceManager.getDefaultSharedPreferences(context);
        }
        return f6193a.getFloat(str, f2);
    }

    public static int b(Context context, String str, String str2) {
        if (str2 != null) {
            return context.getResources().getIdentifier(str2, str, context.getPackageName());
        }
        return 0;
    }

    public static String c(Context context, String str, String str2) {
        if (f6193a == null) {
            f6193a = PreferenceManager.getDefaultSharedPreferences(context);
        }
        return f6193a.getString(str, str2);
    }
}
