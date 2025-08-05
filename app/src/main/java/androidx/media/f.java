package androidx.media;

import android.media.session.MediaSessionManager;
import v.AbstractC0340c;

/* loaded from: classes.dex */
final class f implements c {

    /* renamed from: a, reason: collision with root package name */
    final MediaSessionManager.RemoteUserInfo f3777a;

    f(String str, int i2, int i3) {
        this.f3777a = e.a(str, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            return this.f3777a.equals(((f) obj).f3777a);
        }
        return false;
    }

    public int hashCode() {
        return AbstractC0340c.b(this.f3777a);
    }

    f(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        this.f3777a = remoteUserInfo;
    }
}
