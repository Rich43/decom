package X0;

import android.content.SharedPreferences;

/* loaded from: classes.dex */
public enum e {
    ON,
    AUTO,
    OFF;

    private static e a(String str) {
        return str == null ? OFF : valueOf(str);
    }

    public static e b(SharedPreferences sharedPreferences) {
        return a(sharedPreferences.getString("preferences_front_light_mode", OFF.toString()));
    }
}
