package androidx.startup;

import M.c;
import N.b;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    private static volatile a f4303d;
    private static final Object e = new Object();

    /* renamed from: c, reason: collision with root package name */
    final Context f4306c;

    /* renamed from: b, reason: collision with root package name */
    final Set f4305b = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    final Map f4304a = new HashMap();

    a(Context context) {
        this.f4306c = context.getApplicationContext();
    }

    private Object d(Class cls, Set set) {
        Object objB;
        if (b.d()) {
            try {
                b.a(cls.getSimpleName());
            } catch (Throwable th) {
                b.b();
                throw th;
            }
        }
        if (set.contains(cls)) {
            throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
        }
        if (this.f4304a.containsKey(cls)) {
            objB = this.f4304a.get(cls);
        } else {
            set.add(cls);
            try {
                M.a aVar = (M.a) cls.getDeclaredConstructor(null).newInstance(null);
                List<Class> listA = aVar.a();
                if (!listA.isEmpty()) {
                    for (Class cls2 : listA) {
                        if (!this.f4304a.containsKey(cls2)) {
                            d(cls2, set);
                        }
                    }
                }
                objB = aVar.b(this.f4306c);
                set.remove(cls);
                this.f4304a.put(cls, objB);
            } catch (Throwable th2) {
                throw new c(th2);
            }
        }
        b.b();
        return objB;
    }

    public static a e(Context context) {
        if (f4303d == null) {
            synchronized (e) {
                try {
                    if (f4303d == null) {
                        f4303d = new a(context);
                    }
                } finally {
                }
            }
        }
        return f4303d;
    }

    void a() {
        try {
            try {
                b.a("Startup");
                b(this.f4306c.getPackageManager().getProviderInfo(new ComponentName(this.f4306c.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
            } catch (PackageManager.NameNotFoundException e2) {
                throw new c(e2);
            }
        } finally {
            b.b();
        }
    }

    void b(Bundle bundle) throws ClassNotFoundException {
        String string = this.f4306c.getString(M.b.f324a);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (M.a.class.isAssignableFrom(cls)) {
                            this.f4305b.add(cls);
                        }
                    }
                }
                Iterator it = this.f4305b.iterator();
                while (it.hasNext()) {
                    d((Class) it.next(), hashSet);
                }
            } catch (ClassNotFoundException e2) {
                throw new c(e2);
            }
        }
    }

    Object c(Class cls) {
        Object objD;
        synchronized (e) {
            try {
                objD = this.f4304a.get(cls);
                if (objD == null) {
                    objD = d(cls, new HashSet());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return objD;
    }

    public Object f(Class cls) {
        return c(cls);
    }

    public boolean g(Class cls) {
        return this.f4305b.contains(cls);
    }
}
