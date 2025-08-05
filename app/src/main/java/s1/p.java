package s1;

import androidx.appcompat.app.F;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
class p {

    /* renamed from: d, reason: collision with root package name */
    private static final Map f7489d = new ConcurrentHashMap();
    private static final a[] e = new a[4];

    /* renamed from: a, reason: collision with root package name */
    private List f7490a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f7491b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f7492c;

    static class a {

        /* renamed from: a, reason: collision with root package name */
        final List f7493a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        final Map f7494b = new HashMap();

        /* renamed from: c, reason: collision with root package name */
        final Map f7495c = new HashMap();

        /* renamed from: d, reason: collision with root package name */
        final StringBuilder f7496d = new StringBuilder(128);
        Class e;

        /* renamed from: f, reason: collision with root package name */
        Class f7497f;

        /* renamed from: g, reason: collision with root package name */
        boolean f7498g;

        a() {
        }

        private boolean b(Method method, Class cls) {
            this.f7496d.setLength(0);
            this.f7496d.append(method.getName());
            StringBuilder sb = this.f7496d;
            sb.append('>');
            sb.append(cls.getName());
            String string = this.f7496d.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class cls2 = (Class) this.f7495c.put(string, declaringClass);
            if (cls2 == null || cls2.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.f7495c.put(string, cls2);
            return false;
        }

        boolean a(Method method, Class cls) {
            Object objPut = this.f7494b.put(cls, method);
            if (objPut == null) {
                return true;
            }
            if (objPut instanceof Method) {
                if (!b((Method) objPut, cls)) {
                    throw new IllegalStateException();
                }
                this.f7494b.put(cls, this);
            }
            return b(method, cls);
        }

        void c(Class cls) {
            this.f7497f = cls;
            this.e = cls;
            this.f7498g = false;
        }

        void d() {
            if (this.f7498g) {
                this.f7497f = null;
                return;
            }
            Class superclass = this.f7497f.getSuperclass();
            this.f7497f = superclass;
            String name = superclass.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.")) {
                this.f7497f = null;
            }
        }

        void e() {
            this.f7493a.clear();
            this.f7494b.clear();
            this.f7495c.clear();
            this.f7496d.setLength(0);
            this.e = null;
            this.f7497f = null;
            this.f7498g = false;
        }
    }

    p(List list, boolean z2, boolean z3) {
        this.f7490a = list;
        this.f7491b = z2;
        this.f7492c = z3;
    }

    private List b(Class cls) throws SecurityException {
        a aVarG = g();
        aVarG.c(cls);
        while (aVarG.f7497f != null) {
            f(aVarG);
            d(aVarG);
            aVarG.d();
        }
        return e(aVarG);
    }

    private List c(Class cls) throws SecurityException {
        a aVarG = g();
        aVarG.c(cls);
        while (aVarG.f7497f != null) {
            d(aVarG);
            aVarG.d();
        }
        return e(aVarG);
    }

    private void d(a aVar) throws SecurityException {
        Method[] methods;
        try {
            methods = aVar.f7497f.getDeclaredMethods();
        } catch (Throwable unused) {
            methods = aVar.f7497f.getMethods();
            aVar.f7498g = true;
        }
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) {
                    m mVar = (m) method.getAnnotation(m.class);
                    if (mVar != null) {
                        Class<?> cls = parameterTypes[0];
                        if (aVar.a(method, cls)) {
                            aVar.f7493a.add(new o(method, cls, mVar.threadMode(), mVar.priority(), mVar.sticky()));
                        }
                    }
                } else if (this.f7491b && method.isAnnotationPresent(m.class)) {
                    throw new e("@Subscribe method " + (method.getDeclaringClass().getName() + "." + method.getName()) + "must have exactly 1 parameter but has " + parameterTypes.length);
                }
            } else if (this.f7491b && method.isAnnotationPresent(m.class)) {
                throw new e((method.getDeclaringClass().getName() + "." + method.getName()) + " is a illegal @Subscribe method: must be public, non-static, and non-abstract");
            }
        }
    }

    private List e(a aVar) {
        ArrayList arrayList = new ArrayList(aVar.f7493a);
        aVar.e();
        synchronized (e) {
            int i2 = 0;
            while (true) {
                if (i2 >= 4) {
                    break;
                }
                try {
                    a[] aVarArr = e;
                    if (aVarArr[i2] == null) {
                        aVarArr[i2] = aVar;
                        break;
                    }
                    i2++;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return arrayList;
    }

    private t1.a f(a aVar) {
        aVar.getClass();
        List list = this.f7490a;
        if (list != null) {
            Iterator it = list.iterator();
            if (it.hasNext()) {
                F.a(it.next());
                throw null;
            }
        }
        return null;
    }

    private a g() {
        synchronized (e) {
            for (int i2 = 0; i2 < 4; i2++) {
                try {
                    a[] aVarArr = e;
                    a aVar = aVarArr[i2];
                    if (aVar != null) {
                        aVarArr[i2] = null;
                        return aVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return new a();
        }
    }

    List a(Class cls) {
        Map map = f7489d;
        List list = (List) map.get(cls);
        if (list != null) {
            return list;
        }
        List listC = this.f7492c ? c(cls) : b(cls);
        if (!listC.isEmpty()) {
            map.put(cls, listC);
            return listC;
        }
        throw new e("Subscriber " + cls + " and its super classes have no public methods with the @Subscribe annotation");
    }
}
