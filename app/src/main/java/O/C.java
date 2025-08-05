package O;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class C extends B {
    private static Method e;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f371f;

    /* renamed from: g, reason: collision with root package name */
    private static Method f372g;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f373h;

    C() {
    }

    private void j() throws NoSuchMethodException, SecurityException {
        if (f371f) {
            return;
        }
        try {
            Method declaredMethod = View.class.getDeclaredMethod("transformMatrixToGlobal", Matrix.class);
            e = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToGlobal method", e2);
        }
        f371f = true;
    }

    private void k() throws NoSuchMethodException, SecurityException {
        if (f373h) {
            return;
        }
        try {
            Method declaredMethod = View.class.getDeclaredMethod("transformMatrixToLocal", Matrix.class);
            f372g = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToLocal method", e2);
        }
        f373h = true;
    }

    @Override // O.E
    public void f(View view, Matrix matrix) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        j();
        Method method = e;
        if (method != null) {
            try {
                method.invoke(view, matrix);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    @Override // O.E
    public void g(View view, Matrix matrix) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        k();
        Method method = f372g;
        if (method != null) {
            try {
                method.invoke(view, matrix);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }
}
