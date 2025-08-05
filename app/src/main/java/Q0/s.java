package q0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class s extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private InterfaceC0321j f7225a;

    public s(InterfaceC0321j interfaceC0321j) {
        this.f7225a = interfaceC0321j;
    }

    public static boolean a(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            return ((Integer) wifiManager.getClass().getDeclaredMethod("getWifiApState", null).invoke(wifiManager, null)).intValue() == ((Integer) wifiManager.getClass().getDeclaredField("WIFI_AP_STATE_ENABLED").get(wifiManager)).intValue();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return false;
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
            return false;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return false;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (a(context)) {
            return;
        }
        if (!"android.net.wifi.STATE_CHANGE".equals(action)) {
            if ("android.net.wifi.WIFI_STATE_CHANGED".equals(action) && intent.getIntExtra("wifi_state", 4) == 1) {
                this.f7225a.c();
                return;
            }
            return;
        }
        Parcelable parcelableExtra = intent.getParcelableExtra("networkInfo");
        if (parcelableExtra == null || ((NetworkInfo) parcelableExtra).isConnected()) {
            return;
        }
        this.f7225a.c();
    }
}
