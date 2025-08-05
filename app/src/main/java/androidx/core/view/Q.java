package androidx.core.view;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import android.view.InputDevice;
import android.view.ViewConfiguration;
import com.bumptech.glide.request.target.Target;
import java.lang.reflect.Method;
import java.util.Objects;
import v.InterfaceC0346i;

/* loaded from: classes.dex */
public abstract class Q {

    /* renamed from: a, reason: collision with root package name */
    private static Method f3116a;

    static class a {
        static float a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHorizontalScrollFactor();
        }

        static float b(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledVerticalScrollFactor();
        }
    }

    static class b {
        static int a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHoverSlop();
        }

        static boolean b(ViewConfiguration viewConfiguration) {
            return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
        }
    }

    static class c {
        static int a(ViewConfiguration viewConfiguration, int i2, int i3, int i4) {
            return viewConfiguration.getScaledMaximumFlingVelocity(i2, i3, i4);
        }

        static int b(ViewConfiguration viewConfiguration, int i2, int i3, int i4) {
            return viewConfiguration.getScaledMinimumFlingVelocity(i2, i3, i4);
        }
    }

    static {
        if (Build.VERSION.SDK_INT == 25) {
            try {
                f3116a = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", null);
            } catch (Exception unused) {
                Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
    }

    private static int a(Resources resources, int i2, InterfaceC0346i interfaceC0346i, int i3) {
        int dimensionPixelSize;
        return i2 != -1 ? (i2 == 0 || (dimensionPixelSize = resources.getDimensionPixelSize(i2)) < 0) ? i3 : dimensionPixelSize : ((Integer) interfaceC0346i.get()).intValue();
    }

    private static float b(ViewConfiguration viewConfiguration, Context context) {
        Method method;
        if (Build.VERSION.SDK_INT >= 25 && (method = f3116a) != null) {
            try {
                return ((Integer) method.invoke(viewConfiguration, null)).intValue();
            } catch (Exception unused) {
                Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
            return typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return 0.0f;
    }

    private static int c(Resources resources, String str, String str2) {
        return resources.getIdentifier(str, str2, "android");
    }

    private static int d(Resources resources, int i2, int i3) {
        if (i2 == 4194304 && i3 == 26) {
            return c(resources, "config_viewMaxRotaryEncoderFlingVelocity", "dimen");
        }
        return -1;
    }

    private static int e(Resources resources, int i2, int i3) {
        if (i2 == 4194304 && i3 == 26) {
            return c(resources, "config_viewMinRotaryEncoderFlingVelocity", "dimen");
        }
        return -1;
    }

    public static float f(ViewConfiguration viewConfiguration, Context context) {
        return Build.VERSION.SDK_INT >= 26 ? a.a(viewConfiguration) : b(viewConfiguration, context);
    }

    public static int g(ViewConfiguration viewConfiguration) {
        return Build.VERSION.SDK_INT >= 28 ? b.a(viewConfiguration) : viewConfiguration.getScaledTouchSlop() / 2;
    }

    public static int h(Context context, final ViewConfiguration viewConfiguration, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 34) {
            return c.a(viewConfiguration, i2, i3, i4);
        }
        if (!k(i2, i3, i4)) {
            return Target.SIZE_ORIGINAL;
        }
        Resources resources = context.getResources();
        int iD = d(resources, i4, i3);
        Objects.requireNonNull(viewConfiguration);
        return a(resources, iD, new InterfaceC0346i() { // from class: androidx.core.view.O
            @Override // v.InterfaceC0346i
            public final Object get() {
                return Integer.valueOf(viewConfiguration.getScaledMaximumFlingVelocity());
            }
        }, Target.SIZE_ORIGINAL);
    }

    public static int i(Context context, final ViewConfiguration viewConfiguration, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 34) {
            return c.b(viewConfiguration, i2, i3, i4);
        }
        if (!k(i2, i3, i4)) {
            return Integer.MAX_VALUE;
        }
        Resources resources = context.getResources();
        int iE = e(resources, i4, i3);
        Objects.requireNonNull(viewConfiguration);
        return a(resources, iE, new InterfaceC0346i() { // from class: androidx.core.view.P
            @Override // v.InterfaceC0346i
            public final Object get() {
                return Integer.valueOf(viewConfiguration.getScaledMinimumFlingVelocity());
            }
        }, Integer.MAX_VALUE);
    }

    public static float j(ViewConfiguration viewConfiguration, Context context) {
        return Build.VERSION.SDK_INT >= 26 ? a.b(viewConfiguration) : b(viewConfiguration, context);
    }

    private static boolean k(int i2, int i3, int i4) {
        InputDevice device = InputDevice.getDevice(i2);
        return (device == null || device.getMotionRange(i3, i4) == null) ? false : true;
    }

    public static boolean l(ViewConfiguration viewConfiguration, Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            return b.b(viewConfiguration);
        }
        Resources resources = context.getResources();
        int iC = c(resources, "config_showMenuShortcutsWhenKeyboardPresent", "bool");
        return iC != 0 && resources.getBoolean(iC);
    }
}
