package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public static final o f3734a = new o();

    /* renamed from: b, reason: collision with root package name */
    private static final Map f3735b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private static final Map f3736c = new HashMap();

    private o() {
    }

    private final InterfaceC0201f a(Constructor constructor, Object obj) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        try {
            Object objNewInstance = constructor.newInstance(obj);
            i1.k.d(objNewInstance, "{\n            constructo…tance(`object`)\n        }");
            androidx.appcompat.app.F.a(objNewInstance);
            return null;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Constructor b(Class cls) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        try {
            Package r12 = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = r12 != null ? r12.getName() : "";
            i1.k.d(name, "fullPackage");
            if (name.length() != 0) {
                i1.k.d(canonicalName, "name");
                canonicalName = canonicalName.substring(name.length() + 1);
                i1.k.d(canonicalName, "this as java.lang.String).substring(startIndex)");
            }
            i1.k.d(canonicalName, "if (fullPackage.isEmpty(…g(fullPackage.length + 1)");
            String strC = c(canonicalName);
            if (name.length() != 0) {
                strC = name + '.' + strC;
            }
            Class<?> cls2 = Class.forName(strC);
            i1.k.c(cls2, "null cannot be cast to non-null type java.lang.Class<out androidx.lifecycle.GeneratedAdapter>");
            Constructor declaredConstructor = cls2.getDeclaredConstructor(cls);
            if (declaredConstructor.isAccessible()) {
                return declaredConstructor;
            }
            declaredConstructor.setAccessible(true);
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static final String c(String str) {
        i1.k.e(str, "className");
        return p1.c.c(str, ".", "_", false, 4, null) + "_LifecycleAdapter";
    }

    private final int d(Class cls) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        Map map = f3735b;
        Integer num = (Integer) map.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int iG = g(cls);
        map.put(cls, Integer.valueOf(iG));
        return iG;
    }

    private final boolean e(Class cls) {
        return cls != null && InterfaceC0207l.class.isAssignableFrom(cls);
    }

    public static final InterfaceC0206k f(Object obj) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        i1.k.e(obj, "object");
        boolean z2 = obj instanceof InterfaceC0206k;
        boolean z3 = obj instanceof InterfaceC0199d;
        if (z2 && z3) {
            return new DefaultLifecycleObserverAdapter((InterfaceC0199d) obj, (InterfaceC0206k) obj);
        }
        if (z3) {
            return new DefaultLifecycleObserverAdapter((InterfaceC0199d) obj, null);
        }
        if (z2) {
            return (InterfaceC0206k) obj;
        }
        Class<?> cls = obj.getClass();
        o oVar = f3734a;
        if (oVar.d(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        Object obj2 = f3736c.get(cls);
        i1.k.b(obj2);
        List list = (List) obj2;
        if (list.size() == 1) {
            oVar.a((Constructor) list.get(0), obj);
            return new SingleGeneratedAdapterObserver(null);
        }
        int size = list.size();
        InterfaceC0201f[] interfaceC0201fArr = new InterfaceC0201f[size];
        for (int i2 = 0; i2 < size; i2++) {
            f3734a.a((Constructor) list.get(i2), obj);
            interfaceC0201fArr[i2] = null;
        }
        return new CompositeGeneratedAdaptersObserver(interfaceC0201fArr);
    }

    private final int g(Class cls) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        ArrayList arrayList;
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor constructorB = b(cls);
        if (constructorB != null) {
            f3736c.put(cls, b1.l.b(constructorB));
            return 2;
        }
        if (C0197b.f3707c.d(cls)) {
            return 1;
        }
        Class superclass = cls.getSuperclass();
        if (e(superclass)) {
            i1.k.d(superclass, "superclass");
            if (d(superclass) == 1) {
                return 1;
            }
            Object obj = f3736c.get(superclass);
            i1.k.b(obj);
            arrayList = new ArrayList((Collection) obj);
        } else {
            arrayList = null;
        }
        Class<?>[] interfaces = cls.getInterfaces();
        i1.k.d(interfaces, "klass.interfaces");
        for (Class<?> cls2 : interfaces) {
            if (e(cls2)) {
                i1.k.d(cls2, "intrface");
                if (d(cls2) == 1) {
                    return 1;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                Object obj2 = f3736c.get(cls2);
                i1.k.b(obj2);
                arrayList.addAll((Collection) obj2);
            }
        }
        if (arrayList == null) {
            return 1;
        }
        f3736c.put(cls, arrayList);
        return 2;
    }
}
