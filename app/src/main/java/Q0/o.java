package q0;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public abstract class o {
    public static boolean a(Activity activity) {
        if (Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays(activity)) {
            return true;
        }
        try {
            activity.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + activity.getPackageName())), 2000);
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean b(Activity activity) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.add("android.permission.CAMERA");
        for (String str : copyOnWriteArrayList) {
            if (androidx.core.content.a.a(activity.getApplicationContext(), str) == 0) {
                copyOnWriteArrayList.remove(str);
            }
        }
        if (copyOnWriteArrayList.isEmpty()) {
            return true;
        }
        String[] strArr = new String[copyOnWriteArrayList.size()];
        copyOnWriteArrayList.toArray(strArr);
        androidx.core.app.b.m(activity, strArr, 1001);
        return false;
    }

    public static boolean c(Activity activity, int i2) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.add("android.permission.READ_EXTERNAL_STORAGE");
        copyOnWriteArrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
        for (String str : copyOnWriteArrayList) {
            if (androidx.core.content.a.a(activity.getApplicationContext(), str) == 0) {
                copyOnWriteArrayList.remove(str);
            }
        }
        if (copyOnWriteArrayList.isEmpty()) {
            return true;
        }
        String[] strArr = new String[copyOnWriteArrayList.size()];
        copyOnWriteArrayList.toArray(strArr);
        androidx.core.app.b.m(activity, strArr, i2);
        return false;
    }
}
