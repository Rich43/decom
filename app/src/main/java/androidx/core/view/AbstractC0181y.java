package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import defpackage.s;

/* renamed from: androidx.core.view.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0181y {

    /* renamed from: androidx.core.view.y$a */
    static class a {
        static int a(MenuItem menuItem) {
            return menuItem.getAlphabeticModifiers();
        }

        static CharSequence b(MenuItem menuItem) {
            return menuItem.getContentDescription();
        }

        static ColorStateList c(MenuItem menuItem) {
            return menuItem.getIconTintList();
        }

        static PorterDuff.Mode d(MenuItem menuItem) {
            return menuItem.getIconTintMode();
        }

        static int e(MenuItem menuItem) {
            return menuItem.getNumericModifiers();
        }

        static CharSequence f(MenuItem menuItem) {
            return menuItem.getTooltipText();
        }

        static MenuItem g(MenuItem menuItem, char c2, int i2) {
            return menuItem.setAlphabeticShortcut(c2, i2);
        }

        static MenuItem h(MenuItem menuItem, CharSequence charSequence) {
            return menuItem.setContentDescription(charSequence);
        }

        static MenuItem i(MenuItem menuItem, ColorStateList colorStateList) {
            return menuItem.setIconTintList(colorStateList);
        }

        static MenuItem j(MenuItem menuItem, PorterDuff.Mode mode) {
            return menuItem.setIconTintMode(mode);
        }

        static MenuItem k(MenuItem menuItem, char c2, int i2) {
            return menuItem.setNumericShortcut(c2, i2);
        }

        static MenuItem l(MenuItem menuItem, char c2, char c3, int i2, int i3) {
            return menuItem.setShortcut(c2, c3, i2, i3);
        }

        static MenuItem m(MenuItem menuItem, CharSequence charSequence) {
            return menuItem.setTooltipText(charSequence);
        }
    }

    public static MenuItem a(MenuItem menuItem, AbstractC0159b abstractC0159b) {
        if (menuItem instanceof s.c) {
            return ((s.c) menuItem).a(abstractC0159b);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static void b(MenuItem menuItem, char c2, int i2) {
        if (menuItem instanceof s.c) {
            ((s.c) menuItem).setAlphabeticShortcut(c2, i2);
        } else if (Build.VERSION.SDK_INT >= 26) {
            a.g(menuItem, c2, i2);
        }
    }

    public static void c(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof s.c) {
            ((s.c) menuItem).setContentDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            a.h(menuItem, charSequence);
        }
    }

    public static void d(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof s.c) {
            ((s.c) menuItem).setIconTintList(colorStateList);
        } else if (Build.VERSION.SDK_INT >= 26) {
            a.i(menuItem, colorStateList);
        }
    }

    public static void e(MenuItem menuItem, PorterDuff.Mode mode) {
        if (menuItem instanceof s.c) {
            ((s.c) menuItem).setIconTintMode(mode);
        } else if (Build.VERSION.SDK_INT >= 26) {
            a.j(menuItem, mode);
        }
    }

    public static void f(MenuItem menuItem, char c2, int i2) {
        if (menuItem instanceof s.c) {
            ((s.c) menuItem).setNumericShortcut(c2, i2);
        } else if (Build.VERSION.SDK_INT >= 26) {
            a.k(menuItem, c2, i2);
        }
    }

    public static void g(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof s.c) {
            ((s.c) menuItem).setTooltipText(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            a.m(menuItem, charSequence);
        }
    }
}
