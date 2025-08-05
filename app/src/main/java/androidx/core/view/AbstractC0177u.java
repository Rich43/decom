package androidx.core.view;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: androidx.core.view.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0177u {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f3183a = false;

    /* renamed from: b, reason: collision with root package name */
    private static Method f3184b = null;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f3185c = false;

    /* renamed from: d, reason: collision with root package name */
    private static Field f3186d;

    /* renamed from: androidx.core.view.u$a */
    public interface a {
        boolean y(KeyEvent keyEvent);
    }

    private static boolean a(ActionBar actionBar, KeyEvent keyEvent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!f3183a) {
            try {
                f3184b = actionBar.getClass().getMethod("onMenuKeyEvent", KeyEvent.class);
            } catch (NoSuchMethodException unused) {
            }
            f3183a = true;
        }
        Method method = f3184b;
        if (method != null) {
            try {
                Object objInvoke = method.invoke(actionBar, keyEvent);
                if (objInvoke == null) {
                    return false;
                }
                return ((Boolean) objInvoke).booleanValue();
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
        }
        return false;
    }

    private static boolean b(Activity activity, KeyEvent keyEvent) {
        activity.onUserInteraction();
        Window window = activity.getWindow();
        if (window.hasFeature(8)) {
            ActionBar actionBar = activity.getActionBar();
            if (keyEvent.getKeyCode() == 82 && actionBar != null && a(actionBar, keyEvent)) {
                return true;
            }
        }
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView = window.getDecorView();
        if (M.h(decorView, keyEvent)) {
            return true;
        }
        return keyEvent.dispatch(activity, decorView != null ? decorView.getKeyDispatcherState() : null, activity);
    }

    private static boolean c(Dialog dialog, KeyEvent keyEvent) throws NoSuchFieldException, SecurityException {
        DialogInterface.OnKeyListener onKeyListenerF = f(dialog);
        if (onKeyListenerF != null && onKeyListenerF.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
            return true;
        }
        Window window = dialog.getWindow();
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView = window.getDecorView();
        if (M.h(decorView, keyEvent)) {
            return true;
        }
        return keyEvent.dispatch(dialog, decorView != null ? decorView.getKeyDispatcherState() : null, dialog);
    }

    public static boolean d(View view, KeyEvent keyEvent) {
        return M.i(view, keyEvent);
    }

    public static boolean e(a aVar, View view, Window.Callback callback, KeyEvent keyEvent) {
        if (aVar == null) {
            return false;
        }
        return Build.VERSION.SDK_INT >= 28 ? aVar.y(keyEvent) : callback instanceof Activity ? b((Activity) callback, keyEvent) : callback instanceof Dialog ? c((Dialog) callback, keyEvent) : (view != null && M.h(view, keyEvent)) || aVar.y(keyEvent);
    }

    private static DialogInterface.OnKeyListener f(Dialog dialog) throws NoSuchFieldException, SecurityException {
        if (!f3185c) {
            try {
                Field declaredField = Dialog.class.getDeclaredField("mOnKeyListener");
                f3186d = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f3185c = true;
        }
        Field field = f3186d;
        if (field == null) {
            return null;
        }
        try {
            return (DialogInterface.OnKeyListener) field.get(dialog);
        } catch (IllegalAccessException unused2) {
            return null;
        }
    }
}
