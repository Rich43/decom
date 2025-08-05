package N;

import android.os.Trace;

/* loaded from: classes.dex */
abstract class c {
    public static void a(String str) {
        Trace.beginSection(str);
    }

    public static void b() {
        Trace.endSection();
    }
}
