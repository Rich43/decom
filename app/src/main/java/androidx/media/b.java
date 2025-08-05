package androidx.media;

import android.media.session.MediaSessionManager;
import android.os.Build;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    c f3776a;

    public b(String str, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f3776a = new f(str, i2, i3);
        } else {
            this.f3776a = new g(str, i2, i3);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            return this.f3776a.equals(((b) obj).f3776a);
        }
        return false;
    }

    public int hashCode() {
        return this.f3776a.hashCode();
    }

    public b(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        this.f3776a = new f(remoteUserInfo);
    }
}
