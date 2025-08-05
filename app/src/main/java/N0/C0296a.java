package n0;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.eshare.api.EShareAPI;
import com.eshare.api.IDevice;
import e0.InterfaceC0248a;
import h0.C0261b;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import q0.k;

/* renamed from: n0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0296a {

    /* renamed from: a, reason: collision with root package name */
    private ExecutorService f6756a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f6757b;

    /* renamed from: c, reason: collision with root package name */
    private List f6758c;

    /* renamed from: d, reason: collision with root package name */
    private IDevice f6759d;
    private d e;

    /* renamed from: n0.a$a, reason: collision with other inner class name */
    class RunnableC0094a implements Runnable {
        RunnableC0094a() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            byte[] appList = null;
            for (int i2 = 0; i2 < 3 && (appList = C0296a.this.f6759d.getAppList()) == null; i2++) {
            }
            if (appList != null) {
                C0296a c0296a = C0296a.this;
                c0296a.f("saveToFile", Boolean.valueOf(c0296a.k(appList)));
            }
            C0296a.this.j(appList);
        }
    }

    /* renamed from: n0.a$b */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C0296a.this.e != null) {
                C0296a.this.e.F(false, null);
            }
        }
    }

    /* renamed from: n0.a$c */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C0296a.this.e != null) {
                C0296a.this.e.F(true, C0296a.this.f6758c);
            }
        }
    }

    /* renamed from: n0.a$d */
    public interface d {
        void F(boolean z2, List list);
    }

    /* renamed from: n0.a$e */
    private static class e {

        /* renamed from: a, reason: collision with root package name */
        private static C0296a f6763a = new C0296a();
    }

    public static int g(byte[] bArr, int i2) {
        return (bArr[i2] & 255) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 1] & 255) << 8);
    }

    public static C0296a h() {
        return e.f6763a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(byte[] bArr) {
        if (bArr == null) {
            this.f6757b.post(new b());
            return;
        }
        this.f6758c.clear();
        int iG = g(bArr, 0);
        int i2 = 4;
        while (i2 < iG) {
            C0261b c0261b = new C0261b();
            int iG2 = g(bArr, i2);
            int i3 = i2 + 4;
            byte[] bArr2 = new byte[iG2];
            System.arraycopy(bArr, i3, bArr2, 0, iG2);
            int i4 = i3 + iG2;
            c0261b.e(new String(bArr2));
            int iG3 = g(bArr, i4);
            int i5 = i4 + 4;
            byte[] bArr3 = new byte[iG3];
            System.arraycopy(bArr, i5, bArr3, 0, iG3);
            int i6 = i5 + iG3;
            c0261b.f(new String(bArr3));
            int iG4 = g(bArr, i6);
            int i7 = i6 + 4;
            byte[] bArr4 = new byte[iG4];
            System.arraycopy(bArr, i7, bArr4, 0, iG4);
            int i8 = i7 + iG4;
            c0261b.h(new String(bArr4));
            int iG5 = g(bArr, i8);
            int i9 = i8 + 4;
            c0261b.g(g(bArr, i9));
            int i10 = i9 + iG5;
            int iG6 = g(bArr, i10);
            int i11 = i10 + 4;
            byte[] bArr5 = new byte[iG6];
            System.arraycopy(bArr, i11, bArr5, 0, iG6);
            i2 = i11 + iG6;
            c0261b.d(bArr5);
            this.f6758c.add(c0261b);
        }
        this.f6757b.post(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k(byte[] bArr) throws Throwable {
        File file = new File(InterfaceC0248a.e);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bArr);
                    try {
                        fileOutputStream2.close();
                        return true;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return true;
                    }
                } catch (IOException e3) {
                    e = e3;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    if (!file.exists()) {
                        return false;
                    }
                    file.delete();
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void f(Object... objArr) throws Throwable {
        k.b(objArr);
    }

    public void i(Context context) {
        this.f6759d = EShareAPI.init(context).device();
        this.f6756a.execute(new RunnableC0094a());
    }

    public void l(d dVar) {
        this.e = dVar;
    }

    private C0296a() {
        this.f6757b = new Handler(Looper.getMainLooper());
        this.f6756a = Executors.newSingleThreadExecutor();
        this.f6758c = new ArrayList();
    }
}
