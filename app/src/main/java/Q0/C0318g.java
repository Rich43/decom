package q0;

import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/* renamed from: q0.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0318g {

    /* renamed from: c, reason: collision with root package name */
    public static final String f7208c = Environment.getExternalStorageDirectory().getAbsolutePath();

    /* renamed from: d, reason: collision with root package name */
    private static C0318g f7209d;

    /* renamed from: a, reason: collision with root package name */
    public final String f7210a;

    /* renamed from: b, reason: collision with root package name */
    private PrintWriter f7211b;

    private C0318g() {
        String str = "luma-log" + System.currentTimeMillis() + ".txt";
        this.f7210a = str;
        File file = new File(f7208c, str);
        Log.d("FileLogger", "file path:" + Environment.getExternalStorageDirectory() + " fileName:" + str);
        try {
            if (file.exists()) {
                this.f7211b = new PrintWriter(new FileWriter(file, true));
            }
            Log.e("FileLogger", "file not exit");
        } catch (IOException e) {
            Log.e("FileLogger", "fail to create log file ", e);
            throw new RuntimeException(e);
        }
    }

    public static synchronized C0318g a() {
        try {
            if (f7209d == null) {
                f7209d = new C0318g();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f7209d;
    }

    public void b(String str) {
        Log.d("LXP", "println:" + str);
        PrintWriter printWriter = this.f7211b;
        if (printWriter == null) {
            Log.e("FileLogger", "mWriter is null");
        } else {
            printWriter.println(str);
            this.f7211b.flush();
        }
    }
}
