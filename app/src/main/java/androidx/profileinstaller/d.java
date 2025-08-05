package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import androidx.profileinstaller.j;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final AssetManager f3785a;

    /* renamed from: b, reason: collision with root package name */
    private final Executor f3786b;

    /* renamed from: c, reason: collision with root package name */
    private final j.c f3787c;
    private final File e;

    /* renamed from: f, reason: collision with root package name */
    private final String f3789f;

    /* renamed from: g, reason: collision with root package name */
    private final String f3790g;

    /* renamed from: h, reason: collision with root package name */
    private final String f3791h;

    /* renamed from: j, reason: collision with root package name */
    private e[] f3793j;

    /* renamed from: k, reason: collision with root package name */
    private byte[] f3794k;

    /* renamed from: i, reason: collision with root package name */
    private boolean f3792i = false;

    /* renamed from: d, reason: collision with root package name */
    private final byte[] f3788d = d();

    public d(AssetManager assetManager, Executor executor, j.c cVar, String str, String str2, String str3, File file) {
        this.f3785a = assetManager;
        this.f3786b = executor;
        this.f3787c = cVar;
        this.f3789f = str;
        this.f3790g = str2;
        this.f3791h = str3;
        this.e = file;
    }

    private d b(e[] eVarArr, byte[] bArr) throws IOException {
        InputStream inputStreamH;
        try {
            inputStreamH = h(this.f3785a, this.f3791h);
        } catch (FileNotFoundException e) {
            this.f3787c.b(9, e);
        } catch (IOException e2) {
            this.f3787c.b(7, e2);
        } catch (IllegalStateException e3) {
            this.f3793j = null;
            this.f3787c.b(8, e3);
        }
        if (inputStreamH == null) {
            if (inputStreamH != null) {
                inputStreamH.close();
            }
            return null;
        }
        try {
            this.f3793j = o.q(inputStreamH, o.o(inputStreamH, o.f3820b), bArr, eVarArr);
            inputStreamH.close();
            return this;
        } catch (Throwable th) {
            try {
                inputStreamH.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private void c() {
        if (!this.f3792i) {
            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
        }
    }

    private static byte[] d() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 24 || i2 > 34) {
            return null;
        }
        switch (i2) {
            case 24:
            case 25:
                return q.e;
            case 26:
                return q.f3834d;
            case 27:
                return q.f3833c;
            case 28:
            case 29:
            case 30:
                return q.f3832b;
            case 31:
            case 32:
            case 33:
            case 34:
                return q.f3831a;
            default:
                return null;
        }
    }

    private InputStream f(AssetManager assetManager) {
        try {
            return h(assetManager, this.f3790g);
        } catch (FileNotFoundException e) {
            this.f3787c.b(6, e);
            return null;
        } catch (IOException e2) {
            this.f3787c.b(7, e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(int i2, Object obj) {
        this.f3787c.b(i2, obj);
    }

    private InputStream h(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e) {
            String message = e.getMessage();
            if (message != null && message.contains("compressed")) {
                this.f3787c.a(5, null);
            }
            return null;
        }
    }

    private e[] j(InputStream inputStream) throws IOException {
        try {
            try {
                try {
                    try {
                        e[] eVarArrW = o.w(inputStream, o.o(inputStream, o.f3819a), this.f3789f);
                        try {
                            inputStream.close();
                            return eVarArrW;
                        } catch (IOException e) {
                            this.f3787c.b(7, e);
                            return eVarArrW;
                        }
                    } catch (IOException e2) {
                        this.f3787c.b(7, e2);
                        inputStream.close();
                        return null;
                    }
                } catch (IllegalStateException e3) {
                    this.f3787c.b(8, e3);
                    inputStream.close();
                    return null;
                }
            } catch (IOException e4) {
                this.f3787c.b(7, e4);
                return null;
            }
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e5) {
                this.f3787c.b(7, e5);
            }
            throw th;
        }
    }

    private static boolean k() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 24 || i2 > 34) {
            return false;
        }
        if (i2 != 24 && i2 != 25) {
            switch (i2) {
                case 31:
                case 32:
                case 33:
                case 34:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    private void l(final int i2, final Object obj) {
        this.f3786b.execute(new Runnable() { // from class: androidx.profileinstaller.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f3782a.g(i2, obj);
            }
        });
    }

    public boolean e() throws IOException {
        if (this.f3788d == null) {
            l(3, Integer.valueOf(Build.VERSION.SDK_INT));
            return false;
        }
        if (!this.e.exists()) {
            try {
                this.e.createNewFile();
            } catch (IOException unused) {
                l(4, null);
                return false;
            }
        } else if (!this.e.canWrite()) {
            l(4, null);
            return false;
        }
        this.f3792i = true;
        return true;
    }

    public d i() {
        d dVarB;
        c();
        if (this.f3788d == null) {
            return this;
        }
        InputStream inputStreamF = f(this.f3785a);
        if (inputStreamF != null) {
            this.f3793j = j(inputStreamF);
        }
        e[] eVarArr = this.f3793j;
        return (eVarArr == null || !k() || (dVarB = b(eVarArr, this.f3788d)) == null) ? this : dVarB;
    }

    public d m() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        e[] eVarArr = this.f3793j;
        byte[] bArr = this.f3788d;
        if (eVarArr != null && bArr != null) {
            c();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (IOException e) {
                this.f3787c.b(7, e);
            } catch (IllegalStateException e2) {
                this.f3787c.b(8, e2);
            }
            try {
                o.E(byteArrayOutputStream, bArr);
                if (!o.B(byteArrayOutputStream, bArr, eVarArr)) {
                    this.f3787c.b(5, null);
                    this.f3793j = null;
                    byteArrayOutputStream.close();
                    return this;
                }
                this.f3794k = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                this.f3793j = null;
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        return this;
    }

    public boolean n() {
        byte[] bArr = this.f3794k;
        if (bArr == null) {
            return false;
        }
        c();
        try {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.e);
                    try {
                        f.l(byteArrayInputStream, fileOutputStream);
                        l(1, null);
                        fileOutputStream.close();
                        byteArrayInputStream.close();
                        return true;
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (FileNotFoundException e) {
                l(6, e);
                return false;
            } catch (IOException e2) {
                l(7, e2);
                return false;
            }
        } finally {
            this.f3794k = null;
            this.f3793j = null;
        }
    }
}
