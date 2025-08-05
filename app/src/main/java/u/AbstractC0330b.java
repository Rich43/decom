package u;

import android.os.Handler;
import android.os.Looper;

/* renamed from: u.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract class AbstractC0330b {
    static Handler a() {
        return Looper.myLooper() == null ? new Handler(Looper.getMainLooper()) : new Handler();
    }
}
