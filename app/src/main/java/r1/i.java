package r1;

import android.support.v4.media.session.PlaybackStateCompat;

/* loaded from: classes.dex */
abstract class i {

    /* renamed from: a, reason: collision with root package name */
    static h f7385a;

    /* renamed from: b, reason: collision with root package name */
    static long f7386b;

    static void a(h hVar) {
        if (hVar.f7383f != null || hVar.f7384g != null) {
            throw new IllegalArgumentException();
        }
        if (hVar.f7382d) {
            return;
        }
        synchronized (i.class) {
            try {
                long j2 = f7386b;
                if (j2 + PlaybackStateCompat.ACTION_PLAY_FROM_URI > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                    return;
                }
                f7386b = j2 + PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                hVar.f7383f = f7385a;
                hVar.f7381c = 0;
                hVar.f7380b = 0;
                f7385a = hVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static h b() {
        synchronized (i.class) {
            try {
                h hVar = f7385a;
                if (hVar == null) {
                    return new h();
                }
                f7385a = hVar.f7383f;
                hVar.f7383f = null;
                f7386b -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                return hVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
