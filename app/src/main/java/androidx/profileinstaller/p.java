package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    private static final androidx.concurrent.futures.c f3821a = androidx.concurrent.futures.c.o();

    /* renamed from: b, reason: collision with root package name */
    private static final Object f3822b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static c f3823c = null;

    private static class a {
        static PackageInfo a(PackageManager packageManager, Context context) {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
        }
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        final int f3824a;

        /* renamed from: b, reason: collision with root package name */
        final int f3825b;

        /* renamed from: c, reason: collision with root package name */
        final long f3826c;

        /* renamed from: d, reason: collision with root package name */
        final long f3827d;

        b(int i2, int i3, long j2, long j3) {
            this.f3824a = i2;
            this.f3825b = i3;
            this.f3826c = j2;
            this.f3827d = j3;
        }

        static b a(File file) throws IOException {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                b bVar = new b(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
                dataInputStream.close();
                return bVar;
            } catch (Throwable th) {
                try {
                    dataInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }

        void b(File file) throws IOException {
            file.delete();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(this.f3824a);
                dataOutputStream.writeInt(this.f3825b);
                dataOutputStream.writeLong(this.f3826c);
                dataOutputStream.writeLong(this.f3827d);
                dataOutputStream.close();
            } catch (Throwable th) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f3825b == bVar.f3825b && this.f3826c == bVar.f3826c && this.f3824a == bVar.f3824a && this.f3827d == bVar.f3827d;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.f3825b), Long.valueOf(this.f3826c), Integer.valueOf(this.f3824a), Long.valueOf(this.f3827d));
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        final int f3828a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f3829b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f3830c;

        c(int i2, boolean z2, boolean z3) {
            this.f3828a = i2;
            this.f3830c = z3;
            this.f3829b = z2;
        }
    }

    private static long a(Context context) {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return Build.VERSION.SDK_INT >= 33 ? a.a(packageManager, context).lastUpdateTime : packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    private static c b(int i2, boolean z2, boolean z3) {
        c cVar = new c(i2, z2, z3);
        f3823c = cVar;
        f3821a.m(cVar);
        return f3823c;
    }

    static c c(Context context, boolean z2) {
        b bVarA;
        int i2;
        c cVar;
        if (!z2 && (cVar = f3823c) != null) {
            return cVar;
        }
        synchronized (f3822b) {
            if (!z2) {
                try {
                    c cVar2 = f3823c;
                    if (cVar2 != null) {
                        return cVar2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            int i3 = Build.VERSION.SDK_INT;
            int i4 = 0;
            if (i3 >= 28 && i3 != 30) {
                File file = new File(new File("/data/misc/profiles/ref/", context.getPackageName()), "primary.prof");
                long length = file.length();
                boolean z3 = file.exists() && length > 0;
                File file2 = new File(new File("/data/misc/profiles/cur/0/", context.getPackageName()), "primary.prof");
                long length2 = file2.length();
                boolean z4 = file2.exists() && length2 > 0;
                try {
                    long jA = a(context);
                    File file3 = new File(context.getFilesDir(), "profileInstalled");
                    if (file3.exists()) {
                        try {
                            bVarA = b.a(file3);
                        } catch (IOException unused) {
                            return b(131072, z3, z4);
                        }
                    } else {
                        bVarA = null;
                    }
                    if (bVarA != null && bVarA.f3826c == jA && (i2 = bVarA.f3825b) != 2) {
                        i4 = i2;
                    } else if (z3) {
                        i4 = 1;
                    } else if (z4) {
                        i4 = 2;
                    }
                    if (z2 && z4 && i4 != 1) {
                        i4 = 2;
                    }
                    if (bVarA != null && bVarA.f3825b == 2 && i4 == 1 && length < bVarA.f3827d) {
                        i4 = 3;
                    }
                    b bVar = new b(1, i4, jA, length2);
                    if (bVarA == null || !bVarA.equals(bVar)) {
                        try {
                            bVar.b(file3);
                        } catch (IOException unused2) {
                            i4 = 196608;
                        }
                    }
                    return b(i4, z3, z4);
                } catch (PackageManager.NameNotFoundException unused3) {
                    return b(ArrayPool.STANDARD_BUFFER_SIZE_BYTES, z3, z4);
                }
            }
            return b(262144, false, false);
        }
    }
}
