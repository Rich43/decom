package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(androidx.versionedparcelable.a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f2847a = (IconCompat) aVar.v(remoteActionCompat.f2847a, 1);
        remoteActionCompat.f2848b = aVar.l(remoteActionCompat.f2848b, 2);
        remoteActionCompat.f2849c = aVar.l(remoteActionCompat.f2849c, 3);
        remoteActionCompat.f2850d = (PendingIntent) aVar.r(remoteActionCompat.f2850d, 4);
        remoteActionCompat.e = aVar.h(remoteActionCompat.e, 5);
        remoteActionCompat.f2851f = aVar.h(remoteActionCompat.f2851f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, androidx.versionedparcelable.a aVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        aVar.x(false, false);
        aVar.M(remoteActionCompat.f2847a, 1);
        aVar.D(remoteActionCompat.f2848b, 2);
        aVar.D(remoteActionCompat.f2849c, 3);
        aVar.H(remoteActionCompat.f2850d, 4);
        aVar.z(remoteActionCompat.e, 5);
        aVar.z(remoteActionCompat.f2851f, 6);
    }
}
