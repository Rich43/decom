package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import v.AbstractC0340c;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a */
    private static final ThreadLocal f2975a = new ThreadLocal();

    /* renamed from: b */
    private static final WeakHashMap f2976b = new WeakHashMap(0);

    /* renamed from: c */
    private static final Object f2977c = new Object();

    static class a {
        static Drawable a(Resources resources, int i2, Resources.Theme theme) {
            return resources.getDrawable(i2, theme);
        }

        static Drawable b(Resources resources, int i2, int i3, Resources.Theme theme) {
            return resources.getDrawableForDensity(i2, i3, theme);
        }
    }

    static class b {
        static int a(Resources resources, int i2, Resources.Theme theme) {
            return resources.getColor(i2, theme);
        }

        static ColorStateList b(Resources resources, int i2, Resources.Theme theme) {
            return resources.getColorStateList(i2, theme);
        }
    }

    private static class c {

        /* renamed from: a */
        final ColorStateList f2978a;

        /* renamed from: b */
        final Configuration f2979b;

        /* renamed from: c */
        final int f2980c;

        c(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
            this.f2978a = colorStateList;
            this.f2979b = configuration;
            this.f2980c = theme == null ? 0 : theme.hashCode();
        }
    }

    private static final class d {

        /* renamed from: a */
        final Resources f2981a;

        /* renamed from: b */
        final Resources.Theme f2982b;

        d(Resources resources, Resources.Theme theme) {
            this.f2981a = resources;
            this.f2982b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.f2981a.equals(dVar.f2981a) && AbstractC0340c.a(this.f2982b, dVar.f2982b);
        }

        public int hashCode() {
            return AbstractC0340c.b(this.f2981a, this.f2982b);
        }
    }

    public static abstract class e {
        public static Handler e(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        public final void c(final int i2, Handler handler) {
            e(handler).post(new Runnable() { // from class: androidx.core.content.res.j
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2988a.f(i2);
                }
            });
        }

        public final void d(final Typeface typeface, Handler handler) {
            e(handler).post(new Runnable() { // from class: androidx.core.content.res.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2986a.g(typeface);
                }
            });
        }

        /* renamed from: h */
        public abstract void f(int i2);

        /* renamed from: i */
        public abstract void g(Typeface typeface);
    }

    public static final class f {

        static class a {

            /* renamed from: a */
            private static final Object f2983a = new Object();

            /* renamed from: b */
            private static Method f2984b;

            /* renamed from: c */
            private static boolean f2985c;

            /* JADX WARN: Removed duplicated region for block: B:64:0x0027 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            static void a(android.content.res.Resources.Theme r6) {
                /*
                    java.lang.Object r0 = androidx.core.content.res.h.f.a.f2983a
                    monitor-enter(r0)
                    boolean r1 = androidx.core.content.res.h.f.a.f2985c     // Catch: java.lang.Throwable -> L17
                    r2 = 0
                    if (r1 != 0) goto L23
                    r1 = 1
                    java.lang.Class<android.content.res.Resources$Theme> r3 = android.content.res.Resources.Theme.class
                    java.lang.String r4 = "rebase"
                    java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r2)     // Catch: java.lang.Throwable -> L17 java.lang.NoSuchMethodException -> L19
                    androidx.core.content.res.h.f.a.f2984b = r3     // Catch: java.lang.Throwable -> L17 java.lang.NoSuchMethodException -> L19
                    r3.setAccessible(r1)     // Catch: java.lang.Throwable -> L17 java.lang.NoSuchMethodException -> L19
                    goto L21
                L17:
                    r6 = move-exception
                    goto L39
                L19:
                    r3 = move-exception
                    java.lang.String r4 = "ResourcesCompat"
                    java.lang.String r5 = "Failed to retrieve rebase() method"
                    android.util.Log.i(r4, r5, r3)     // Catch: java.lang.Throwable -> L17
                L21:
                    androidx.core.content.res.h.f.a.f2985c = r1     // Catch: java.lang.Throwable -> L17
                L23:
                    java.lang.reflect.Method r1 = androidx.core.content.res.h.f.a.f2984b     // Catch: java.lang.Throwable -> L17
                    if (r1 == 0) goto L37
                    r1.invoke(r6, r2)     // Catch: java.lang.Throwable -> L17 java.lang.reflect.InvocationTargetException -> L2b java.lang.IllegalAccessException -> L2d
                    goto L37
                L2b:
                    r6 = move-exception
                    goto L2e
                L2d:
                    r6 = move-exception
                L2e:
                    java.lang.String r1 = "ResourcesCompat"
                    java.lang.String r3 = "Failed to invoke rebase() method via reflection"
                    android.util.Log.i(r1, r3, r6)     // Catch: java.lang.Throwable -> L17
                    androidx.core.content.res.h.f.a.f2984b = r2     // Catch: java.lang.Throwable -> L17
                L37:
                    monitor-exit(r0)     // Catch: java.lang.Throwable -> L17
                    return
                L39:
                    monitor-exit(r0)     // Catch: java.lang.Throwable -> L17
                    throw r6
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.h.f.a.a(android.content.res.Resources$Theme):void");
            }
        }

        static class b {
            static void a(Resources.Theme theme) {
                theme.rebase();
            }
        }

        public static void a(Resources.Theme theme) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                b.a(theme);
            } else if (i2 >= 23) {
                a.a(theme);
            }
        }
    }

    private static void a(d dVar, int i2, ColorStateList colorStateList, Resources.Theme theme) {
        synchronized (f2977c) {
            try {
                WeakHashMap weakHashMap = f2976b;
                SparseArray sparseArray = (SparseArray) weakHashMap.get(dVar);
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    weakHashMap.put(dVar, sparseArray);
                }
                sparseArray.append(i2, new c(colorStateList, dVar.f2981a.getConfiguration(), theme));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x003c, code lost:
    
        if (r2.f2980c == r5.hashCode()) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.content.res.ColorStateList b(androidx.core.content.res.h.d r5, int r6) {
        /*
            java.lang.Object r0 = androidx.core.content.res.h.f2977c
            monitor-enter(r0)
            java.util.WeakHashMap r1 = androidx.core.content.res.h.f2976b     // Catch: java.lang.Throwable -> L32
            java.lang.Object r1 = r1.get(r5)     // Catch: java.lang.Throwable -> L32
            android.util.SparseArray r1 = (android.util.SparseArray) r1     // Catch: java.lang.Throwable -> L32
            if (r1 == 0) goto L45
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L32
            if (r2 <= 0) goto L45
            java.lang.Object r2 = r1.get(r6)     // Catch: java.lang.Throwable -> L32
            androidx.core.content.res.h$c r2 = (androidx.core.content.res.h.c) r2     // Catch: java.lang.Throwable -> L32
            if (r2 == 0) goto L45
            android.content.res.Configuration r3 = r2.f2979b     // Catch: java.lang.Throwable -> L32
            android.content.res.Resources r4 = r5.f2981a     // Catch: java.lang.Throwable -> L32
            android.content.res.Configuration r4 = r4.getConfiguration()     // Catch: java.lang.Throwable -> L32
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Throwable -> L32
            if (r3 == 0) goto L42
            android.content.res.Resources$Theme r5 = r5.f2982b     // Catch: java.lang.Throwable -> L32
            if (r5 != 0) goto L34
            int r3 = r2.f2980c     // Catch: java.lang.Throwable -> L32
            if (r3 == 0) goto L3e
            goto L34
        L32:
            r5 = move-exception
            goto L48
        L34:
            if (r5 == 0) goto L42
            int r3 = r2.f2980c     // Catch: java.lang.Throwable -> L32
            int r5 = r5.hashCode()     // Catch: java.lang.Throwable -> L32
            if (r3 != r5) goto L42
        L3e:
            android.content.res.ColorStateList r5 = r2.f2978a     // Catch: java.lang.Throwable -> L32
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            return r5
        L42:
            r1.remove(r6)     // Catch: java.lang.Throwable -> L32
        L45:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            r5 = 0
            return r5
        L48:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.h.b(androidx.core.content.res.h$d, int):android.content.res.ColorStateList");
    }

    public static ColorStateList c(Resources resources, int i2, Resources.Theme theme) {
        d dVar = new d(resources, theme);
        ColorStateList colorStateListB = b(dVar, i2);
        if (colorStateListB != null) {
            return colorStateListB;
        }
        ColorStateList colorStateListH = h(resources, i2, theme);
        if (colorStateListH == null) {
            return Build.VERSION.SDK_INT >= 23 ? b.b(resources, i2, theme) : resources.getColorStateList(i2);
        }
        a(dVar, i2, colorStateListH, theme);
        return colorStateListH;
    }

    public static Drawable d(Resources resources, int i2, Resources.Theme theme) {
        return a.a(resources, i2, theme);
    }

    public static Drawable e(Resources resources, int i2, int i3, Resources.Theme theme) {
        return a.b(resources, i2, i3, theme);
    }

    public static Typeface f(Context context, int i2, TypedValue typedValue, int i3, e eVar) {
        if (context.isRestricted()) {
            return null;
        }
        return j(context, i2, typedValue, i3, eVar, null, true, false);
    }

    private static TypedValue g() {
        ThreadLocal threadLocal = f2975a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    private static ColorStateList h(Resources resources, int i2, Resources.Theme theme) {
        if (i(resources, i2)) {
            return null;
        }
        try {
            return androidx.core.content.res.c.a(resources, resources.getXml(i2), theme);
        } catch (Exception e2) {
            Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e2);
            return null;
        }
    }

    private static boolean i(Resources resources, int i2) throws Resources.NotFoundException {
        TypedValue typedValueG = g();
        resources.getValue(i2, typedValueG, true);
        int i3 = typedValueG.type;
        return i3 >= 28 && i3 <= 31;
    }

    private static Typeface j(Context context, int i2, TypedValue typedValue, int i3, e eVar, Handler handler, boolean z2, boolean z3) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        Typeface typefaceK = k(context, resources, typedValue, i2, i3, eVar, handler, z2, z3);
        if (typefaceK != null || eVar != null || z3) {
            return typefaceK;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i2) + " could not be retrieved.");
    }

    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Typeface k(android.content.Context r16, android.content.res.Resources r17, android.util.TypedValue r18, int r19, int r20, androidx.core.content.res.h.e r21, android.os.Handler r22, boolean r23, boolean r24) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.h.k(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, androidx.core.content.res.h$e, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }
}
