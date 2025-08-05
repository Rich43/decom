package androidx.core.widget;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    private static Method f3248a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f3249b;

    /* renamed from: c, reason: collision with root package name */
    private static Field f3250c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f3251d;

    static class a {
        static boolean a(PopupWindow popupWindow) {
            return popupWindow.getOverlapAnchor();
        }

        static int b(PopupWindow popupWindow) {
            return popupWindow.getWindowLayoutType();
        }

        static void c(PopupWindow popupWindow, boolean z2) {
            popupWindow.setOverlapAnchor(z2);
        }

        static void d(PopupWindow popupWindow, int i2) {
            popupWindow.setWindowLayoutType(i2);
        }
    }

    public static void a(PopupWindow popupWindow, boolean z2) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (Build.VERSION.SDK_INT >= 23) {
            a.c(popupWindow, z2);
            return;
        }
        if (!f3251d) {
            try {
                Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                f3250c = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e);
            }
            f3251d = true;
        }
        Field field = f3250c;
        if (field != null) {
            try {
                field.set(popupWindow, Boolean.valueOf(z2));
            } catch (IllegalAccessException e2) {
                Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e2);
            }
        }
    }

    public static void b(PopupWindow popupWindow, int i2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 23) {
            a.d(popupWindow, i2);
            return;
        }
        if (!f3249b) {
            try {
                Method declaredMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                f3248a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception unused) {
            }
            f3249b = true;
        }
        Method method = f3248a;
        if (method != null) {
            try {
                method.invoke(popupWindow, Integer.valueOf(i2));
            } catch (Exception unused2) {
            }
        }
    }

    public static void c(PopupWindow popupWindow, View view, int i2, int i3, int i4) {
        popupWindow.showAsDropDown(view, i2, i3, i4);
    }
}
