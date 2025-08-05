package androidx.appcompat.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import java.util.Calendar;

/* loaded from: classes.dex */
class E {

    /* renamed from: d, reason: collision with root package name */
    private static E f1659d;

    /* renamed from: a, reason: collision with root package name */
    private final Context f1660a;

    /* renamed from: b, reason: collision with root package name */
    private final LocationManager f1661b;

    /* renamed from: c, reason: collision with root package name */
    private final a f1662c = new a();

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        boolean f1663a;

        /* renamed from: b, reason: collision with root package name */
        long f1664b;

        a() {
        }
    }

    E(Context context, LocationManager locationManager) {
        this.f1660a = context;
        this.f1661b = locationManager;
    }

    static E a(Context context) {
        if (f1659d == null) {
            Context applicationContext = context.getApplicationContext();
            f1659d = new E(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f1659d;
    }

    private Location b() {
        Location locationC = androidx.core.content.d.b(this.f1660a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? c("network") : null;
        Location locationC2 = androidx.core.content.d.b(this.f1660a, "android.permission.ACCESS_FINE_LOCATION") == 0 ? c("gps") : null;
        return (locationC2 == null || locationC == null) ? locationC2 != null ? locationC2 : locationC : locationC2.getTime() > locationC.getTime() ? locationC2 : locationC;
    }

    private Location c(String str) {
        try {
            if (this.f1661b.isProviderEnabled(str)) {
                return this.f1661b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e) {
            Log.d("TwilightManager", "Failed to get last known location", e);
            return null;
        }
    }

    private boolean e() {
        return this.f1662c.f1664b > System.currentTimeMillis();
    }

    private void f(Location location) {
        long j2;
        a aVar = this.f1662c;
        long jCurrentTimeMillis = System.currentTimeMillis();
        D dB = D.b();
        dB.a(jCurrentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        dB.a(jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z2 = dB.f1658c == 1;
        long j3 = dB.f1657b;
        long j4 = dB.f1656a;
        dB.a(jCurrentTimeMillis + 86400000, location.getLatitude(), location.getLongitude());
        long j5 = dB.f1657b;
        if (j3 == -1 || j4 == -1) {
            j2 = jCurrentTimeMillis + 43200000;
        } else {
            if (jCurrentTimeMillis <= j4) {
                j5 = jCurrentTimeMillis > j3 ? j4 : j3;
            }
            j2 = j5 + 60000;
        }
        aVar.f1663a = z2;
        aVar.f1664b = j2;
    }

    boolean d() {
        a aVar = this.f1662c;
        if (e()) {
            return aVar.f1663a;
        }
        Location locationB = b();
        if (locationB != null) {
            f(locationB);
            return aVar.f1663a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i2 = Calendar.getInstance().get(11);
        return i2 < 6 || i2 >= 22;
    }
}
