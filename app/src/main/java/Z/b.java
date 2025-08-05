package Z;

import android.content.Context;
import c0.f;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import v.C0341d;

/* loaded from: classes.dex */
class b {

    /* renamed from: a, reason: collision with root package name */
    private final Context f1361a;

    /* renamed from: b, reason: collision with root package name */
    private final String f1362b;

    b(Context context, String str) {
        this.f1361a = context.getApplicationContext();
        this.f1362b = str;
    }

    private static String b(String str, a aVar, boolean z2) {
        StringBuilder sb = new StringBuilder();
        sb.append("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        sb.append(z2 ? aVar.a() : aVar.f1360a);
        return sb.toString();
    }

    private File c(String str) {
        File file = new File(this.f1361a.getCacheDir(), b(str, a.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(this.f1361a.getCacheDir(), b(str, a.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    C0341d a() {
        try {
            File fileC = c(this.f1362b);
            if (fileC == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(fileC);
            a aVar = fileC.getAbsolutePath().endsWith(".zip") ? a.ZIP : a.JSON;
            f.a("Cache hit for " + this.f1362b + " at " + fileC.getAbsolutePath());
            return new C0341d(aVar, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    void d(a aVar) {
        File file = new File(this.f1361a.getCacheDir(), b(this.f1362b, aVar, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean zRenameTo = file.renameTo(file2);
        f.a("Copying temp file to real file (" + file2 + ")");
        if (zRenameTo) {
            return;
        }
        f.b("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
    }

    File e(InputStream inputStream, a aVar) throws IOException {
        File file = new File(this.f1361a.getCacheDir(), b(this.f1362b, aVar, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i2 = inputStream.read(bArr);
                    if (i2 == -1) {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        return file;
                    }
                    fileOutputStream.write(bArr, 0, i2);
                }
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } finally {
            inputStream.close();
        }
    }
}
