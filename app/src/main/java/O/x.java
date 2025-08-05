package O;

import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
abstract class x {

    /* renamed from: a, reason: collision with root package name */
    private static Method f510a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f511b;

    private static void a() throws NoSuchMethodException, SecurityException {
        if (f511b) {
            return;
        }
        try {
            Method declaredMethod = ViewGroup.class.getDeclaredMethod("suppressLayout", Boolean.TYPE);
            f510a = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsApi18", "Failed to retrieve suppressLayout method", e);
        }
        f511b = true;
    }

    static void b(ViewGroup viewGroup, boolean z2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        a();
        Method method = f510a;
        if (method != null) {
            try {
                method.invoke(viewGroup, Boolean.valueOf(z2));
            } catch (IllegalAccessException e) {
                Log.i("ViewUtilsApi18", "Failed to invoke suppressLayout method", e);
            } catch (InvocationTargetException e2) {
                Log.i("ViewUtilsApi18", "Error invoking suppressLayout method", e2);
            }
        }
    }
}
