package O;

import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
abstract class B extends E {

    /* renamed from: a, reason: collision with root package name */
    private static Method f367a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f368b;

    /* renamed from: c, reason: collision with root package name */
    private static Method f369c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f370d;

    B() {
    }

    private void h() throws NoSuchMethodException, SecurityException {
        if (f370d) {
            return;
        }
        try {
            Method declaredMethod = View.class.getDeclaredMethod("getTransitionAlpha", null);
            f369c = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsApi19", "Failed to retrieve getTransitionAlpha method", e);
        }
        f370d = true;
    }

    private void i() throws NoSuchMethodException, SecurityException {
        if (f368b) {
            return;
        }
        try {
            Method declaredMethod = View.class.getDeclaredMethod("setTransitionAlpha", Float.TYPE);
            f367a = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsApi19", "Failed to retrieve setTransitionAlpha method", e);
        }
        f368b = true;
    }

    @Override // O.E
    public float b(View view) throws NoSuchMethodException, SecurityException {
        h();
        Method method = f369c;
        if (method != null) {
            try {
                return ((Float) method.invoke(view, null)).floatValue();
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return super.b(view);
    }

    @Override // O.E
    public void e(View view, float f2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        i();
        Method method = f367a;
        if (method == null) {
            view.setAlpha(f2);
            return;
        }
        try {
            method.invoke(view, Float.valueOf(f2));
        } catch (IllegalAccessException unused) {
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override // O.E
    public void a(View view) {
    }

    @Override // O.E
    public void c(View view) {
    }
}
