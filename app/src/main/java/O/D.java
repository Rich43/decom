package O;

import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class D extends C {

    /* renamed from: i, reason: collision with root package name */
    private static Method f374i;

    /* renamed from: j, reason: collision with root package name */
    private static boolean f375j;

    D() {
    }

    private void l() throws NoSuchMethodException, SecurityException {
        if (f375j) {
            return;
        }
        try {
            Class cls = Integer.TYPE;
            Method declaredMethod = View.class.getDeclaredMethod("setLeftTopRightBottom", cls, cls, cls, cls);
            f374i = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsApi22", "Failed to retrieve setLeftTopRightBottom method", e);
        }
        f375j = true;
    }

    @Override // O.E
    public void d(View view, int i2, int i3, int i4, int i5) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        l();
        Method method = f374i;
        if (method != null) {
            try {
                method.invoke(view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }
}
