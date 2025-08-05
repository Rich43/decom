package q0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: q0.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0319h {
    public static boolean a(String str) {
        File file = new File(str);
        return file.exists() || file.mkdirs();
    }

    public static boolean b(Context context, String str, boolean z2) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(str, z2);
    }

    public static String c(File file) {
        String lowerCase = file.getName().toLowerCase();
        return !lowerCase.contains(".") ? "" : lowerCase.substring(lowerCase.lastIndexOf(".") + 1);
    }

    public static String d(File file) {
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(c(file));
        return TextUtils.isEmpty(mimeTypeFromExtension) ? "*/*" : mimeTypeFromExtension;
    }

    public static Bitmap e(String str, int i2, int i3) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i4 = 1;
        options.inJustDecodeBounds = true;
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str, options);
        float f2 = options.outWidth;
        float f3 = options.outHeight;
        int iCeil = (int) Math.ceil(f2 / i2);
        int iCeil2 = (int) Math.ceil(f3 / i3);
        if (iCeil >= iCeil2 && iCeil >= 1) {
            i4 = iCeil;
        } else if (iCeil2 >= iCeil && iCeil2 >= 1) {
            i4 = iCeil2;
        }
        options.inJustDecodeBounds = false;
        options.inSampleSize = i4;
        if (bitmapDecodeFile != null) {
            bitmapDecodeFile.recycle();
        }
        return BitmapFactory.decodeFile(str, options);
    }

    public static String f(Context context, String str, String str2) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(str, str2);
    }

    public static boolean g(File file) {
        return file != null && file.isFile() && d(file).contains("image/");
    }

    public static void h(Context context, String str, boolean z2) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(str, z2).apply();
    }

    public static void i(Context context, String str, String str2) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(str, str2).apply();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.graphics.Bitmap] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x001f -> B:28:0x0034). Please report as a decompilation issue!!! */
    public static void j(Bitmap bitmap, File file) throws Throwable {
        if (bitmap == 0) {
            return;
        }
        a(file.getParent());
        ?? r02 = 0;
        FileOutputStream fileOutputStream = null;
        r02 = 0;
        try {
        } catch (IOException e) {
            e.printStackTrace();
            r02 = r02;
        }
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    r02 = 100;
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream2);
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                } catch (IOException e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    r02 = fileOutputStream;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                        r02 = fileOutputStream;
                    }
                } catch (Throwable th) {
                    th = th;
                    r02 = fileOutputStream2;
                    if (r02 != 0) {
                        try {
                            r02.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e4) {
                e = e4;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void k(String str, Context context) throws Throwable {
        String str2 = new SimpleDateFormat("yyyyMMdd_HH", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
        String str3 = context.getExternalFilesDir("").getAbsolutePath() + "/KodakLuma";
        Log.d("FileUtils", "path:" + str3);
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!new File(str3, "/log" + str2 + ".txt").exists()) {
            Log.d("FileUtils", "file not exit...");
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(str3 + "/log" + str2 + ".txt", true);
                    try {
                        fileOutputStream2.write(str.getBytes());
                        fileOutputStream2.write("\n".getBytes());
                        fileOutputStream2.close();
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        }
    }
}
