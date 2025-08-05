package q0;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* renamed from: q0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0312a {
    public static String a() {
        return b(System.currentTimeMillis());
    }

    public static String b(long j2) {
        return new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Long.valueOf(j2));
    }

    public static String c(String str) {
        return d(String.format("http://%s:8000/remote/screencapture", str), new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "Camera"), true);
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c7 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String d(java.lang.String r8, java.io.File r9, boolean r10) throws java.lang.Throwable {
        /*
            r0 = 0
            boolean r1 = r9.exists()
            if (r1 != 0) goto La
            r9.mkdirs()
        La:
            java.lang.String r1 = a()
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r0] = r1
            java.lang.String r1 = "IMG_%s.png"
            java.lang.String r1 = java.lang.String.format(r1, r2)
            java.io.File r2 = new java.io.File
            r2.<init>(r9, r1)
            boolean r1 = r2.exists()
            if (r1 == 0) goto L27
            r2.delete()
        L27:
            r1 = 0
            java.net.URL r3 = new java.net.URL     // Catch: java.lang.Throwable -> L87 java.io.IOException -> L8a
            r3.<init>(r8)     // Catch: java.lang.Throwable -> L87 java.io.IOException -> L8a
            java.net.URLConnection r3 = r3.openConnection()     // Catch: java.lang.Throwable -> L87 java.io.IOException -> L8a
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch: java.lang.Throwable -> L87 java.io.IOException -> L8a
            java.lang.String r4 = "GET"
            r3.setRequestMethod(r4)     // Catch: java.lang.Throwable -> L87 java.io.IOException -> L8a
            r4 = 10000(0x2710, float:1.4013E-41)
            r3.setReadTimeout(r4)     // Catch: java.lang.Throwable -> L87 java.io.IOException -> L8a
            int r4 = r3.getResponseCode()     // Catch: java.lang.Throwable -> L87 java.io.IOException -> L8a
            r5 = 200(0xc8, float:2.8E-43)
            if (r4 != r5) goto Lb7
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L87 java.io.IOException -> L8a
            java.io.InputStream r3 = r3.getInputStream()     // Catch: java.lang.Throwable -> L87 java.io.IOException -> L8a
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L87 java.io.IOException -> L8a
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L81 java.io.IOException -> L84
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L81 java.io.IOException -> L84
            r5.<init>(r2)     // Catch: java.lang.Throwable -> L81 java.io.IOException -> L84
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L81 java.io.IOException -> L84
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch: java.lang.Throwable -> L67 java.io.IOException -> L6a
        L5c:
            int r6 = r4.read(r5)     // Catch: java.lang.Throwable -> L67 java.io.IOException -> L6a
            r7 = -1
            if (r6 == r7) goto L6c
            r3.write(r5, r0, r6)     // Catch: java.lang.Throwable -> L67 java.io.IOException -> L6a
            goto L5c
        L67:
            r8 = move-exception
        L68:
            r1 = r4
            goto L8e
        L6a:
            goto La3
        L6c:
            java.lang.String r8 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> L67 java.io.IOException -> L6a
            r4.close()     // Catch: java.io.IOException -> L74
            goto L78
        L74:
            r9 = move-exception
            r9.printStackTrace()
        L78:
            r3.close()     // Catch: java.io.IOException -> L7c
            goto L80
        L7c:
            r9 = move-exception
            r9.printStackTrace()
        L80:
            return r8
        L81:
            r8 = move-exception
            r3 = r1
            goto L68
        L84:
            r3 = r1
            goto La3
        L87:
            r8 = move-exception
            r3 = r1
            goto L8e
        L8a:
            r3 = r1
            r4 = r3
            goto La3
        L8e:
            if (r1 == 0) goto L98
            r1.close()     // Catch: java.io.IOException -> L94
            goto L98
        L94:
            r9 = move-exception
            r9.printStackTrace()
        L98:
            if (r3 == 0) goto La2
            r3.close()     // Catch: java.io.IOException -> L9e
            goto La2
        L9e:
            r9 = move-exception
            r9.printStackTrace()
        La2:
            throw r8
        La3:
            if (r4 == 0) goto Lad
            r4.close()     // Catch: java.io.IOException -> La9
            goto Lad
        La9:
            r4 = move-exception
            r4.printStackTrace()
        Lad:
            if (r3 == 0) goto Lb7
            r3.close()     // Catch: java.io.IOException -> Lb3
            goto Lb7
        Lb3:
            r3 = move-exception
            r3.printStackTrace()
        Lb7:
            boolean r3 = r2.exists()
            if (r3 == 0) goto Lc0
            r2.delete()
        Lc0:
            if (r10 == 0) goto Lc7
            java.lang.String r8 = d(r8, r9, r0)
            return r8
        Lc7:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: q0.AbstractC0312a.d(java.lang.String, java.io.File, boolean):java.lang.String");
    }

    public static Bitmap e(String str) {
        return f(str, 800, 600);
    }

    public static Bitmap f(String str, int i2, int i3) {
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
}
