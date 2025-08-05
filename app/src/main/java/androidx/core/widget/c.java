package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private static Field f3246a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f3247b;

    static class a {
        static ColorStateList a(CompoundButton compoundButton) {
            return compoundButton.getButtonTintList();
        }

        static PorterDuff.Mode b(CompoundButton compoundButton) {
            return compoundButton.getButtonTintMode();
        }

        static void c(CompoundButton compoundButton, ColorStateList colorStateList) {
            compoundButton.setButtonTintList(colorStateList);
        }

        static void d(CompoundButton compoundButton, PorterDuff.Mode mode) {
            compoundButton.setButtonTintMode(mode);
        }
    }

    static class b {
        static Drawable a(CompoundButton compoundButton) {
            return compoundButton.getButtonDrawable();
        }
    }

    public static Drawable a(CompoundButton compoundButton) throws NoSuchFieldException, SecurityException {
        if (Build.VERSION.SDK_INT >= 23) {
            return b.a(compoundButton);
        }
        if (!f3247b) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                f3246a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", e);
            }
            f3247b = true;
        }
        Field field = f3246a;
        if (field != null) {
            try {
                return (Drawable) field.get(compoundButton);
            } catch (IllegalAccessException e2) {
                Log.i("CompoundButtonCompat", "Failed to get button drawable via reflection", e2);
                f3246a = null;
            }
        }
        return null;
    }

    public static void b(CompoundButton compoundButton, ColorStateList colorStateList) {
        a.c(compoundButton, colorStateList);
    }

    public static void c(CompoundButton compoundButton, PorterDuff.Mode mode) {
        a.d(compoundButton, mode);
    }
}
