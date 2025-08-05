package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class E {

    /* renamed from: a, reason: collision with root package name */
    private final Map f3667a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Set f3668b = new LinkedHashSet();

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f3669c = false;

    private static void b(Object obj) throws IOException {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    final void a() {
        this.f3669c = true;
        Map map = this.f3667a;
        if (map != null) {
            synchronized (map) {
                try {
                    Iterator it = this.f3667a.values().iterator();
                    while (it.hasNext()) {
                        b(it.next());
                    }
                } finally {
                }
            }
        }
        Set set = this.f3668b;
        if (set != null) {
            synchronized (set) {
                try {
                    Iterator it2 = this.f3668b.iterator();
                    while (it2.hasNext()) {
                        b((Closeable) it2.next());
                    }
                } finally {
                }
            }
        }
        d();
    }

    Object c(String str) {
        Object obj;
        Map map = this.f3667a;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            obj = this.f3667a.get(str);
        }
        return obj;
    }

    protected void d() {
    }

    Object e(String str, Object obj) throws IOException {
        Object obj2;
        synchronized (this.f3667a) {
            try {
                obj2 = this.f3667a.get(str);
                if (obj2 == null) {
                    this.f3667a.put(str, obj);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (obj2 != null) {
            obj = obj2;
        }
        if (this.f3669c) {
            b(obj);
        }
        return obj;
    }
}
