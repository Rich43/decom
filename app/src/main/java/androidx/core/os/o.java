package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    private static long f3068a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f3069b;

    /* renamed from: c, reason: collision with root package name */
    private static Method f3070c;

    /* renamed from: d, reason: collision with root package name */
    private static Method f3071d;
    private static Method e;

    static {
        if (Build.VERSION.SDK_INT < 29) {
            try {
                f3068a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                Class cls = Long.TYPE;
                f3069b = Trace.class.getMethod("isTagEnabled", cls);
                Class cls2 = Integer.TYPE;
                f3070c = Trace.class.getMethod("asyncTraceBegin", cls, String.class, cls2);
                f3071d = Trace.class.getMethod("asyncTraceEnd", cls, String.class, cls2);
                e = Trace.class.getMethod("traceCounter", cls, String.class, cls2);
            } catch (Exception e2) {
                Log.i("TraceCompat", "Unable to initialize via reflection.", e2);
            }
        }
    }

    public static void a(String str) {
        Trace.beginSection(str);
    }

    public static void b() {
        Trace.endSection();
    }
}
