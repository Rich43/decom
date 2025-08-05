package h0;

import android.text.TextUtils;
import java.io.File;

/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    protected final File f6408a;

    /* renamed from: b, reason: collision with root package name */
    protected final String f6409b;

    /* renamed from: c, reason: collision with root package name */
    protected String f6410c;

    /* renamed from: d, reason: collision with root package name */
    protected final long f6411d;
    protected final boolean e;

    public l(File file) {
        this.f6408a = file;
        this.f6409b = file.getAbsolutePath();
        this.f6411d = file.lastModified();
        this.e = file.exists();
        this.f6410c = file.getName();
    }

    public File a() {
        return this.f6408a;
    }

    public long b() {
        return this.f6411d;
    }

    public String c() {
        return this.f6409b;
    }

    public String d() {
        return this.f6410c;
    }

    public boolean e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.f6409b;
        String str2 = ((l) obj).f6409b;
        if (str != null) {
            if (str.equals(str2)) {
                return true;
            }
        } else if (str2 == null) {
            return true;
        }
        return false;
    }

    public void f(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f6410c = str;
    }

    public int hashCode() {
        String str = this.f6409b;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public l(String str) {
        this(new File(str));
    }
}
