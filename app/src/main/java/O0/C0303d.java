package o0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import com.eshare.api.utils.LogHelper;

/* renamed from: o0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0303d {

    /* renamed from: a, reason: collision with root package name */
    private final Context f6994a;

    /* renamed from: b, reason: collision with root package name */
    private final a f6995b;

    /* renamed from: c, reason: collision with root package name */
    private final b f6996c;

    /* renamed from: d, reason: collision with root package name */
    private final ConnectivityManager f6997d;

    /* renamed from: o0.d$a */
    public interface a {
        void a();
    }

    /* renamed from: o0.d$b */
    private class b extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            LogHelper.D(new Object[]{"NetworkReceiver", action});
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) || "android.net.wifi.STATE_CHANGE".equals(action) || "android.net.wifi.WIFI_STATE_CHANGED".equals(action) || "android.net.wifi.WIFI_AP_STATE_CHANGED".equals(action) || "android.net.ethernet.ETHERNET_STATE_CHANGED".equals(action)) {
                C0303d.this.f6995b.a();
            }
        }

        private b() {
        }
    }

    public C0303d(Context context, a aVar) {
        Context applicationContext = context.getApplicationContext();
        this.f6994a = applicationContext;
        this.f6995b = aVar;
        this.f6997d = (ConnectivityManager) applicationContext.getSystemService("connectivity");
        this.f6996c = new b();
        b();
    }

    private void b() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.WIFI_AP_STATE_CHANGED");
        intentFilter.addAction("android.net.ethernet.ETHERNET_STATE_CHANGED");
        if (Build.VERSION.SDK_INT >= 33) {
            this.f6994a.registerReceiver(this.f6996c, intentFilter, 2);
        } else {
            this.f6994a.registerReceiver(this.f6996c, intentFilter);
        }
    }

    public void c() {
        this.f6994a.unregisterReceiver(this.f6996c);
    }
}
