package defpackage;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f6489a = false;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f6490b = false;

    /* renamed from: c, reason: collision with root package name */
    public static String f6491c = "miao";

    /* renamed from: d, reason: collision with root package name */
    private static Context f6492d;

    public static void a(String str) throws Throwable {
        b(f6491c, str);
    }

    public static void b(String str, String str2) throws Throwable {
        if (f6489a) {
            Log.d(str, str2);
        }
        h(str, str2);
    }

    public static void c(Object... objArr) throws Throwable {
        b(f6491c, j(objArr));
    }

    public static String d(String str) {
        return new SimpleDateFormat(str, Locale.getDefault()).format(new Date(System.currentTimeMillis()));
    }

    public static void e(String str, String str2) throws Throwable {
        if (f6489a) {
            Log.e(str, str2);
        }
        h(str, str2);
    }

    public static void f(Object... objArr) throws Throwable {
        e(f6491c, j(objArr));
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00c2 -> B:35:0x00c5). Please report as a decompilation issue!!! */
    public static void g(String str) throws Throwable {
        FileOutputStream fileOutputStream;
        String str2 = new SimpleDateFormat("yyyyMMdd_HH", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
        String str3 = f6492d.getExternalFilesDir("").getAbsolutePath() + "/KodakLuma";
        Log.d("FileUtils", "path:" + str3);
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!new File(str3, "/log" + str2 + ".txt").exists()) {
            Log.d("FileUtils", "file not exit...");
        }
        FileOutputStream fileOutputStream2 = null;
        try {
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            try {
                fileOutputStream = new FileOutputStream(str3 + "/log" + str2 + ".txt", true);
                try {
                    fileOutputStream.write(str.getBytes());
                    fileOutputStream.write("\n".getBytes());
                    fileOutputStream.close();
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream2 = fileOutputStream;
                    e.printStackTrace();
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = fileOutputStream2;
        }
    }

    private static void h(String str, String str2) throws Throwable {
        if (f6490b && f6489a) {
            g(d("[yyyyMMdd_HHmmss.SSS]") + " --- " + str + " --- " + str2 + "\r\n");
        }
    }

    public static void i(Object... objArr) throws Throwable {
        k(f6491c, j(objArr));
    }

    private static String j(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "[empty]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(objArr[0]);
        for (int i2 = 1; i2 < objArr.length; i2++) {
            sb.append(" - ");
            sb.append(objArr[i2]);
        }
        return sb.toString();
    }

    public static void k(String str, String str2) throws Throwable {
        if (f6489a) {
            Log.w(str, str2);
        }
        h(str, str2);
    }
}
