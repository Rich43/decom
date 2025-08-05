package N;

import android.os.Trace;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static long f345a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f346b;

    public static void a(String str) {
        c.a(str);
    }

    public static void b() {
        c.b();
    }

    private static void c(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (!(cause instanceof RuntimeException)) {
                throw new RuntimeException(cause);
            }
            throw ((RuntimeException) cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }

    public static boolean d() {
        try {
            if (f346b == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        return e();
    }

    private static boolean e() {
        try {
            if (f346b == null) {
                f345a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f346b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f346b.invoke(null, Long.valueOf(f345a))).booleanValue();
        } catch (Exception e) {
            c("isTagEnabled", e);
            return false;
        }
    }
}
