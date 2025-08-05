package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.text.Editable;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.core.text.m;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import v.AbstractC0345h;

/* loaded from: classes.dex */
public abstract class j {

    static class a {
        static int a(TextView textView) {
            return textView.getBreakStrategy();
        }

        static ColorStateList b(TextView textView) {
            return textView.getCompoundDrawableTintList();
        }

        static PorterDuff.Mode c(TextView textView) {
            return textView.getCompoundDrawableTintMode();
        }

        static int d(TextView textView) {
            return textView.getHyphenationFrequency();
        }

        static void e(TextView textView, int i2) {
            textView.setBreakStrategy(i2);
        }

        static void f(TextView textView, ColorStateList colorStateList) {
            textView.setCompoundDrawableTintList(colorStateList);
        }

        static void g(TextView textView, PorterDuff.Mode mode) {
            textView.setCompoundDrawableTintMode(mode);
        }

        static void h(TextView textView, int i2) {
            textView.setHyphenationFrequency(i2);
        }
    }

    static class b {
        static DecimalFormatSymbols a(Locale locale) {
            return DecimalFormatSymbols.getInstance(locale);
        }
    }

    static class c {
        static CharSequence a(PrecomputedText precomputedText) {
            return precomputedText;
        }

        static String[] b(DecimalFormatSymbols decimalFormatSymbols) {
            return decimalFormatSymbols.getDigitStrings();
        }

        static PrecomputedText.Params c(TextView textView) {
            return textView.getTextMetricsParams();
        }

        static void d(TextView textView, int i2) {
            textView.setFirstBaselineToTopHeight(i2);
        }
    }

    static class d {
        public static void a(TextView textView, int i2, float f2) {
            textView.setLineHeight(i2, f2);
        }
    }

    private static class e implements ActionMode.Callback {

        /* renamed from: a */
        private final ActionMode.Callback f3252a;

        /* renamed from: b */
        private final TextView f3253b;

        /* renamed from: c */
        private Class f3254c;

        /* renamed from: d */
        private Method f3255d;
        private boolean e;

        /* renamed from: f */
        private boolean f3256f = false;

        e(ActionMode.Callback callback, TextView textView) {
            this.f3252a = callback;
            this.f3253b = textView;
        }

        private Intent a() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }

        private Intent b(ResolveInfo resolveInfo, TextView textView) {
            Intent intentPutExtra = a().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !e(textView));
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            return intentPutExtra.setClassName(activityInfo.packageName, activityInfo.name);
        }

        private List c(Context context, PackageManager packageManager) {
            ArrayList arrayList = new ArrayList();
            if (!(context instanceof Activity)) {
                return arrayList;
            }
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(a(), 0)) {
                if (f(resolveInfo, context)) {
                    arrayList.add(resolveInfo);
                }
            }
            return arrayList;
        }

        private boolean e(TextView textView) {
            return (textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled();
        }

        private boolean f(ResolveInfo resolveInfo, Context context) {
            if (context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                return true;
            }
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (!activityInfo.exported) {
                return false;
            }
            String str = activityInfo.permission;
            return str == null || context.checkSelfPermission(str) == 0;
        }

        private void g(Menu menu) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            Context context = this.f3253b.getContext();
            PackageManager packageManager = context.getPackageManager();
            if (!this.f3256f) {
                this.f3256f = true;
                try {
                    Class<?> cls = Class.forName("com.android.internal.view.menu.MenuBuilder");
                    this.f3254c = cls;
                    this.f3255d = cls.getDeclaredMethod("removeItemAt", Integer.TYPE);
                    this.e = true;
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    this.f3254c = null;
                    this.f3255d = null;
                    this.e = false;
                }
            }
            try {
                Method declaredMethod = (this.e && this.f3254c.isInstance(menu)) ? this.f3255d : menu.getClass().getDeclaredMethod("removeItemAt", Integer.TYPE);
                for (int size = menu.size() - 1; size >= 0; size--) {
                    MenuItem item = menu.getItem(size);
                    if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                        declaredMethod.invoke(menu, Integer.valueOf(size));
                    }
                }
                List listC = c(context, packageManager);
                for (int i2 = 0; i2 < listC.size(); i2++) {
                    ResolveInfo resolveInfo = (ResolveInfo) listC.get(i2);
                    menu.add(0, 0, i2 + 100, resolveInfo.loadLabel(packageManager)).setIntent(b(resolveInfo, this.f3253b)).setShowAsAction(1);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }

        ActionMode.Callback d() {
            return this.f3252a;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f3252a.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f3252a.onCreateActionMode(actionMode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.f3252a.onDestroyActionMode(actionMode);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            g(menu);
            return this.f3252a.onPrepareActionMode(actionMode, menu);
        }
    }

    public static int a(TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    public static int b(TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    private static int c(TextDirectionHeuristic textDirectionHeuristic) {
        TextDirectionHeuristic textDirectionHeuristic2;
        TextDirectionHeuristic textDirectionHeuristic3 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        if (textDirectionHeuristic == textDirectionHeuristic3 || textDirectionHeuristic == (textDirectionHeuristic2 = TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
            return 1;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
            return 2;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
            return 3;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
            return 4;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
            return 5;
        }
        if (textDirectionHeuristic == textDirectionHeuristic2) {
            return 6;
        }
        return textDirectionHeuristic == textDirectionHeuristic3 ? 7 : 1;
    }

    private static TextDirectionHeuristic d(TextView textView) {
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            return TextDirectionHeuristics.LTR;
        }
        if (Build.VERSION.SDK_INT >= 28 && (textView.getInputType() & 15) == 3) {
            byte directionality = Character.getDirectionality(c.b(b.a(textView.getTextLocale()))[0].codePointAt(0));
            return (directionality == 1 || directionality == 2) ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
        }
        boolean z2 = textView.getLayoutDirection() == 1;
        switch (textView.getTextDirection()) {
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            default:
                if (!z2) {
                    break;
                } else {
                    break;
                }
        }
        return TextDirectionHeuristics.LTR;
    }

    public static m.a e(TextView textView) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            return new m.a(c.c(textView));
        }
        m.a.C0031a c0031a = new m.a.C0031a(new TextPaint(textView.getPaint()));
        if (i2 >= 23) {
            c0031a.b(a.a(textView));
            c0031a.c(a.d(textView));
        }
        c0031a.d(d(textView));
        return c0031a.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void f(TextView textView, ColorStateList colorStateList) {
        AbstractC0345h.f(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            a.f(textView, colorStateList);
        } else if (textView instanceof m) {
            ((m) textView).setSupportCompoundDrawablesTintList(colorStateList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void g(TextView textView, PorterDuff.Mode mode) {
        AbstractC0345h.f(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            a.g(textView, mode);
        } else if (textView instanceof m) {
            ((m) textView).setSupportCompoundDrawablesTintMode(mode);
        }
    }

    public static void h(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    public static void i(TextView textView, int i2) {
        AbstractC0345h.c(i2);
        if (Build.VERSION.SDK_INT >= 28) {
            c.d(textView, i2);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i3 = textView.getIncludeFontPadding() ? fontMetricsInt.top : fontMetricsInt.ascent;
        if (i2 > Math.abs(i3)) {
            textView.setPadding(textView.getPaddingLeft(), i2 + i3, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void j(TextView textView, int i2) {
        AbstractC0345h.c(i2);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i3 = textView.getIncludeFontPadding() ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i2 > Math.abs(i3)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i2 - i3);
        }
    }

    public static void k(TextView textView, int i2) {
        AbstractC0345h.c(i2);
        if (i2 != textView.getPaint().getFontMetricsInt(null)) {
            textView.setLineSpacing(i2 - r0, 1.0f);
        }
    }

    public static void l(TextView textView, int i2, float f2) {
        if (Build.VERSION.SDK_INT >= 34) {
            d.a(textView, i2, f2);
        } else {
            k(textView, Math.round(TypedValue.applyDimension(i2, f2, textView.getResources().getDisplayMetrics())));
        }
    }

    public static void m(TextView textView, androidx.core.text.m mVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            throw null;
        }
        e(textView);
        throw null;
    }

    public static void n(TextView textView, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i2);
        } else {
            textView.setTextAppearance(textView.getContext(), i2);
        }
    }

    public static void o(TextView textView, m.a aVar) {
        textView.setTextDirection(c(aVar.d()));
        if (Build.VERSION.SDK_INT >= 23) {
            textView.getPaint().set(aVar.e());
            a.e(textView, aVar.b());
            a.h(textView, aVar.c());
        } else {
            float textScaleX = aVar.e().getTextScaleX();
            textView.getPaint().set(aVar.e());
            if (textScaleX == textView.getTextScaleX()) {
                textView.setTextScaleX((textScaleX / 2.0f) + 1.0f);
            }
            textView.setTextScaleX(textScaleX);
        }
    }

    public static ActionMode.Callback p(ActionMode.Callback callback) {
        return (!(callback instanceof e) || Build.VERSION.SDK_INT < 26) ? callback : ((e) callback).d();
    }

    public static ActionMode.Callback q(TextView textView, ActionMode.Callback callback) {
        int i2 = Build.VERSION.SDK_INT;
        return (i2 < 26 || i2 > 27 || (callback instanceof e) || callback == null) ? callback : new e(callback, textView);
    }
}
