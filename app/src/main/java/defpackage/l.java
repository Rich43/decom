package defpackage;

import android.media.projection.MediaProjection;

/* loaded from: classes.dex */
public class l {

    /* renamed from: b, reason: collision with root package name */
    private static l f6520b;

    /* renamed from: c, reason: collision with root package name */
    private static MediaProjection f6521c;

    /* renamed from: a, reason: collision with root package name */
    private boolean f6522a = true;

    public static l a() {
        if (f6520b == null) {
            synchronized (l.class) {
                try {
                    if (f6520b == null) {
                        f6520b = new l();
                    }
                } finally {
                }
            }
        }
        return f6520b;
    }

    public void b(MediaProjection mediaProjection) {
        f6521c = mediaProjection;
    }

    public MediaProjection c() {
        return f6521c;
    }

    public boolean d() {
        return this.f6522a;
    }

    public void e() {
        MediaProjection mediaProjection = f6521c;
        if (mediaProjection != null) {
            mediaProjection.stop();
            f6521c = null;
        }
    }
}
