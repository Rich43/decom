package androidx.lifecycle;

import androidx.lifecycle.AbstractC0203h;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: androidx.lifecycle.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0197b {

    /* renamed from: c, reason: collision with root package name */
    static C0197b f3707c = new C0197b();

    /* renamed from: a, reason: collision with root package name */
    private final Map f3708a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map f3709b = new HashMap();

    /* renamed from: androidx.lifecycle.b$a */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        final Map f3710a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        final Map f3711b;

        a(Map map) {
            this.f3711b = map;
            for (Map.Entry entry : map.entrySet()) {
                AbstractC0203h.a aVar = (AbstractC0203h.a) entry.getValue();
                List arrayList = (List) this.f3710a.get(aVar);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    this.f3710a.put(aVar, arrayList);
                }
                arrayList.add((C0044b) entry.getKey());
            }
        }

        private static void b(List list, m mVar, AbstractC0203h.a aVar, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((C0044b) list.get(size)).a(mVar, aVar, obj);
                }
            }
        }

        void a(m mVar, AbstractC0203h.a aVar, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            b((List) this.f3710a.get(aVar), mVar, aVar, obj);
            b((List) this.f3710a.get(AbstractC0203h.a.ON_ANY), mVar, aVar, obj);
        }
    }

    /* renamed from: androidx.lifecycle.b$b, reason: collision with other inner class name */
    static final class C0044b {

        /* renamed from: a, reason: collision with root package name */
        final int f3712a;

        /* renamed from: b, reason: collision with root package name */
        final Method f3713b;

        C0044b(int i2, Method method) throws SecurityException {
            this.f3712a = i2;
            this.f3713b = method;
            method.setAccessible(true);
        }

        void a(m mVar, AbstractC0203h.a aVar, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            try {
                int i2 = this.f3712a;
                if (i2 == 0) {
                    this.f3713b.invoke(obj, null);
                } else if (i2 == 1) {
                    this.f3713b.invoke(obj, mVar);
                } else {
                    if (i2 != 2) {
                        return;
                    }
                    this.f3713b.invoke(obj, mVar, aVar);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException("Failed to call observer method", e2.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0044b)) {
                return false;
            }
            C0044b c0044b = (C0044b) obj;
            return this.f3712a == c0044b.f3712a && this.f3713b.getName().equals(c0044b.f3713b.getName());
        }

        public int hashCode() {
            return (this.f3712a * 31) + this.f3713b.getName().hashCode();
        }
    }

    C0197b() {
    }

    private a a(Class cls, Method[] methodArr) {
        int i2;
        a aVarC;
        Class superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        if (superclass != null && (aVarC = c(superclass)) != null) {
            map.putAll(aVarC.f3711b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry entry : c(cls2).f3711b.entrySet()) {
                e(map, (C0044b) entry.getKey(), (AbstractC0203h.a) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z2 = false;
        for (Method method : methodArr) {
            s sVar = (s) method.getAnnotation(s.class);
            if (sVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i2 = 0;
                } else {
                    if (!m.class.isAssignableFrom(parameterTypes[0])) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i2 = 1;
                }
                AbstractC0203h.a aVarValue = sVar.value();
                if (parameterTypes.length > 1) {
                    if (!AbstractC0203h.a.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (aVarValue != AbstractC0203h.a.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i2 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                e(map, new C0044b(i2, method), aVarValue, cls);
                z2 = true;
            }
        }
        a aVar = new a(map);
        this.f3708a.put(cls, aVar);
        this.f3709b.put(cls, Boolean.valueOf(z2));
        return aVar;
    }

    private Method[] b(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    private void e(Map map, C0044b c0044b, AbstractC0203h.a aVar, Class cls) {
        AbstractC0203h.a aVar2 = (AbstractC0203h.a) map.get(c0044b);
        if (aVar2 == null || aVar == aVar2) {
            if (aVar2 == null) {
                map.put(c0044b, aVar);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + c0044b.f3713b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + aVar2 + ", new value " + aVar);
    }

    a c(Class cls) {
        a aVar = (a) this.f3708a.get(cls);
        return aVar != null ? aVar : a(cls, null);
    }

    boolean d(Class cls) {
        Boolean bool = (Boolean) this.f3709b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] methodArrB = b(cls);
        for (Method method : methodArrB) {
            if (((s) method.getAnnotation(s.class)) != null) {
                a(cls, methodArrB);
                return true;
            }
        }
        this.f3709b.put(cls, Boolean.FALSE);
        return false;
    }
}
