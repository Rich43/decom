package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import androidx.profileinstaller.ProfileInstallReceiver;
import java.io.File;

/* loaded from: classes.dex */
abstract class a {

    /* renamed from: androidx.profileinstaller.a$a */
    private static class C0048a {
        static File a(Context context) {
            return context.getCodeCacheDir();
        }
    }

    private static class b {
        static File a(Context context) {
            return context.createDeviceProtectedStorageContext().getCodeCacheDir();
        }
    }

    static boolean a(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return true;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return false;
        }
        boolean z2 = true;
        for (File file2 : fileArrListFiles) {
            z2 = a(file2) && z2;
        }
        return z2;
    }

    static void b(Context context, ProfileInstallReceiver.a aVar) {
        int i2 = Build.VERSION.SDK_INT;
        if (a(i2 >= 24 ? b.a(context) : i2 >= 23 ? C0048a.a(context) : context.getCacheDir())) {
            aVar.b(14, null);
        } else {
            aVar.b(15, null);
        }
    }
}
