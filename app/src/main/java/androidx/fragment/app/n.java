package androidx.fragment.app;

import androidx.fragment.app.Fragment;

/* loaded from: classes.dex */
public abstract class n {

    /* renamed from: a, reason: collision with root package name */
    private static final androidx.collection.g f3569a = new androidx.collection.g();

    static boolean b(ClassLoader classLoader, String str) {
        try {
            return Fragment.class.isAssignableFrom(c(classLoader, str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static Class c(ClassLoader classLoader, String str) throws ClassNotFoundException {
        androidx.collection.g gVar = f3569a;
        androidx.collection.g gVar2 = (androidx.collection.g) gVar.get(classLoader);
        if (gVar2 == null) {
            gVar2 = new androidx.collection.g();
            gVar.put(classLoader, gVar2);
        }
        Class cls = (Class) gVar2.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        gVar2.put(str, cls2);
        return cls2;
    }

    public static Class d(ClassLoader classLoader, String str) {
        try {
            return c(classLoader, str);
        } catch (ClassCastException e) {
            throw new Fragment.l("Unable to instantiate fragment " + str + ": make sure class is a valid subclass of Fragment", e);
        } catch (ClassNotFoundException e2) {
            throw new Fragment.l("Unable to instantiate fragment " + str + ": make sure class name exists", e2);
        }
    }

    public abstract Fragment a(ClassLoader classLoader, String str);
}
