package i1;

import java.util.Map;

/* loaded from: classes.dex */
public abstract class p {
    public static Map a(Object obj) {
        if (obj instanceof j1.a) {
            e(obj, "kotlin.collections.MutableMap");
        }
        return b(obj);
    }

    public static Map b(Object obj) {
        try {
            return (Map) obj;
        } catch (ClassCastException e) {
            throw d(e);
        }
    }

    private static Throwable c(Throwable th) {
        return k.h(th, p.class.getName());
    }

    public static ClassCastException d(ClassCastException classCastException) {
        throw ((ClassCastException) c(classCastException));
    }

    public static void e(Object obj, String str) {
        f((obj == null ? "null" : obj.getClass().getName()) + " cannot be cast to " + str);
    }

    public static void f(String str) {
        throw d(new ClassCastException(str));
    }
}
