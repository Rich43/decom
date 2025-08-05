package androidx.core.text;

import android.icu.util.ULocale;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static Method f3072a;

    /* renamed from: androidx.core.text.a$a, reason: collision with other inner class name */
    static class C0030a {
        static String a(Locale locale) {
            return locale.getScript();
        }
    }

    static class b {
        static ULocale a(Object obj) {
            return ULocale.addLikelySubtags((ULocale) obj);
        }

        static ULocale b(Locale locale) {
            return ULocale.forLocale(locale);
        }

        static String c(Object obj) {
            return ((ULocale) obj).getScript();
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 24) {
            try {
                f3072a = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public static String a(Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return b.c(b.a(b.b(locale)));
        }
        try {
            return C0030a.a((Locale) f3072a.invoke(null, locale));
        } catch (IllegalAccessException e) {
            Log.w("ICUCompat", e);
            return C0030a.a(locale);
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompat", e2);
            return C0030a.a(locale);
        }
    }
}
