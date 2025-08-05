package androidx.lifecycle;

import android.app.Application;
import b1.AbstractC0218f;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public abstract class D {

    /* renamed from: a, reason: collision with root package name */
    private static final List f3662a = b1.l.g(Application.class, y.class);

    /* renamed from: b, reason: collision with root package name */
    private static final List f3663b = b1.l.b(y.class);

    public static final Constructor c(Class cls, List list) throws SecurityException {
        i1.k.e(cls, "modelClass");
        i1.k.e(list, "signature");
        Constructor<?>[] constructors = cls.getConstructors();
        i1.k.d(constructors, "modelClass.constructors");
        for (Constructor<?> constructor : constructors) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            i1.k.d(parameterTypes, "constructor.parameterTypes");
            List listL = AbstractC0218f.l(parameterTypes);
            if (i1.k.a(list, listL)) {
                i1.k.c(constructor, "null cannot be cast to non-null type java.lang.reflect.Constructor<T of androidx.lifecycle.SavedStateViewModelFactoryKt.findMatchingConstructor>");
                return constructor;
            }
            if (list.size() == listL.size() && listL.containsAll(list)) {
                throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + list);
            }
        }
        return null;
    }

    public static final E d(Class cls, Constructor constructor, Object... objArr) {
        i1.k.e(cls, "modelClass");
        i1.k.e(constructor, "constructor");
        i1.k.e(objArr, "params");
        try {
            return (E) constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to access " + cls, e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException("An exception happened in constructor of " + cls, e3.getCause());
        }
    }
}
