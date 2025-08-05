package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.util.Log;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a */
    private static final c f3812a = new a();

    /* renamed from: b */
    static final c f3813b = new b();

    class a implements c {
        a() {
        }

        @Override // androidx.profileinstaller.j.c
        public void a(int i2, Object obj) {
        }

        @Override // androidx.profileinstaller.j.c
        public void b(int i2, Object obj) {
        }
    }

    class b implements c {
        b() {
        }

        @Override // androidx.profileinstaller.j.c
        public void a(int i2, Object obj) {
            Log.d("ProfileInstaller", i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? "" : "DIAGNOSTIC_PROFILE_IS_COMPRESSED" : "DIAGNOSTIC_REF_PROFILE_DOES_NOT_EXIST" : "DIAGNOSTIC_REF_PROFILE_EXISTS" : "DIAGNOSTIC_CURRENT_PROFILE_DOES_NOT_EXIST" : "DIAGNOSTIC_CURRENT_PROFILE_EXISTS");
        }

        @Override // androidx.profileinstaller.j.c
        public void b(int i2, Object obj) {
            String str;
            switch (i2) {
                case 1:
                    str = "RESULT_INSTALL_SUCCESS";
                    break;
                case 2:
                    str = "RESULT_ALREADY_INSTALLED";
                    break;
                case 3:
                    str = "RESULT_UNSUPPORTED_ART_VERSION";
                    break;
                case 4:
                    str = "RESULT_NOT_WRITABLE";
                    break;
                case 5:
                    str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                    break;
                case 6:
                    str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                    break;
                case 7:
                    str = "RESULT_IO_EXCEPTION";
                    break;
                case 8:
                    str = "RESULT_PARSE_EXCEPTION";
                    break;
                case 9:
                default:
                    str = "";
                    break;
                case 10:
                    str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                    break;
                case 11:
                    str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                    break;
            }
            if (i2 == 6 || i2 == 7 || i2 == 8) {
                Log.e("ProfileInstaller", str, (Throwable) obj);
            } else {
                Log.d("ProfileInstaller", str);
            }
        }
    }

    public interface c {
        void a(int i2, Object obj);

        void b(int i2, Object obj);
    }

    static boolean b(File file) {
        return new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat").delete();
    }

    static void c(Context context, Executor executor, c cVar) {
        b(context.getFilesDir());
        g(executor, cVar, 11, null);
    }

    static boolean d(PackageInfo packageInfo, File file, c cVar) throws IOException {
        File file2 = new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat");
        if (!file2.exists()) {
            return false;
        }
        try {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file2));
            try {
                long j2 = dataInputStream.readLong();
                dataInputStream.close();
                boolean z2 = j2 == packageInfo.lastUpdateTime;
                if (z2) {
                    cVar.b(2, null);
                }
                return z2;
            } finally {
            }
        } catch (IOException unused) {
            return false;
        }
    }

    static void f(PackageInfo packageInfo, File file) throws IOException {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));
            try {
                dataOutputStream.writeLong(packageInfo.lastUpdateTime);
                dataOutputStream.close();
            } finally {
            }
        } catch (IOException unused) {
        }
    }

    static void g(Executor executor, final c cVar, final int i2, final Object obj) {
        executor.execute(new Runnable() { // from class: androidx.profileinstaller.i
            @Override // java.lang.Runnable
            public final void run() {
                cVar.b(i2, obj);
            }
        });
    }

    private static boolean h(AssetManager assetManager, String str, PackageInfo packageInfo, File file, String str2, Executor executor, c cVar) throws IOException {
        d dVar = new d(assetManager, executor, cVar, str2, "dexopt/baseline.prof", "dexopt/baseline.profm", new File(new File("/data/misc/profiles/cur/0", str), "primary.prof"));
        if (!dVar.e()) {
            return false;
        }
        boolean zN = dVar.i().m().n();
        if (zN) {
            f(packageInfo, file);
        }
        return zN;
    }

    public static void i(Context context) throws PackageManager.NameNotFoundException {
        j(context, new h(), f3812a);
    }

    public static void j(Context context, Executor executor, c cVar) throws PackageManager.NameNotFoundException {
        k(context, executor, cVar, false);
    }

    static void k(Context context, Executor executor, c cVar, boolean z2) throws PackageManager.NameNotFoundException {
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        ApplicationInfo applicationInfo = applicationContext.getApplicationInfo();
        AssetManager assets = applicationContext.getAssets();
        String name = new File(applicationInfo.sourceDir).getName();
        boolean z3 = false;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            File filesDir = context.getFilesDir();
            if (!z2 && d(packageInfo, filesDir, cVar)) {
                Log.d("ProfileInstaller", "Skipping profile installation for " + context.getPackageName());
                p.c(context, false);
                return;
            }
            Log.d("ProfileInstaller", "Installing profile for " + context.getPackageName());
            if (h(assets, packageName, packageInfo, filesDir, name, executor, cVar) && z2) {
                z3 = true;
            }
            p.c(context, z3);
        } catch (PackageManager.NameNotFoundException e) {
            cVar.b(7, e);
            p.c(context, false);
        }
    }

    static void l(Context context, Executor executor, c cVar) throws PackageManager.NameNotFoundException, IOException {
        try {
            f(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
            g(executor, cVar, 10, null);
        } catch (PackageManager.NameNotFoundException e) {
            g(executor, cVar, 7, e);
        }
    }
}
