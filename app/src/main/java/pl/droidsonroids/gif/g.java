package pl.droidsonroids.gif;

import android.content.Context;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    private static Context f7182a;

    private static Context a() {
        if (f7182a == null) {
            try {
                f7182a = (Context) Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", null).invoke(null, null);
            } catch (Exception e) {
                throw new IllegalStateException("LibraryLoader not initialized. Call LibraryLoader.initialize() before using library classes.", e);
            }
        }
        return f7182a;
    }

    static void b(Context context) {
        try {
            System.loadLibrary("pl_droidsonroids_gif");
        } catch (UnsatisfiedLinkError unused) {
            if (context == null) {
                context = a();
            }
            h.h(context);
        }
    }
}
