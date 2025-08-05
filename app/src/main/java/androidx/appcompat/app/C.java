package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

/* loaded from: classes.dex */
abstract class C {

    /* renamed from: a, reason: collision with root package name */
    private static Field f1648a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f1649b;

    /* renamed from: c, reason: collision with root package name */
    private static Class f1650c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f1651d;
    private static Field e;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f1652f;

    /* renamed from: g, reason: collision with root package name */
    private static Field f1653g;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f1654h;

    static void a(Resources resources) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            return;
        }
        if (i2 >= 24) {
            d(resources);
        } else if (i2 >= 23) {
            c(resources);
        } else {
            b(resources);
        }
    }

    private static void b(Resources resources) throws NoSuchFieldException, SecurityException {
        Map map;
        if (!f1649b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f1648a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e2);
            }
            f1649b = true;
        }
        Field field = f1648a;
        if (field != null) {
            try {
                map = (Map) field.get(resources);
            } catch (IllegalAccessException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e3);
                map = null;
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    private static void c(Resources resources) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Object obj;
        if (!f1649b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f1648a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e2);
            }
            f1649b = true;
        }
        Field field = f1648a;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e3);
            }
        } else {
            obj = null;
        }
        if (obj == null) {
            return;
        }
        e(obj);
    }

    private static void d(Resources resources) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Object obj;
        if (!f1654h) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                f1653g = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e2);
            }
            f1654h = true;
        }
        Field field = f1653g;
        if (field == null) {
            return;
        }
        Object obj2 = null;
        try {
            obj = field.get(resources);
        } catch (IllegalAccessException e3) {
            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e3);
            obj = null;
        }
        if (obj == null) {
            return;
        }
        if (!f1649b) {
            try {
                Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                f1648a = declaredField2;
                declaredField2.setAccessible(true);
            } catch (NoSuchFieldException e4) {
                Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e4);
            }
            f1649b = true;
        }
        Field field2 = f1648a;
        if (field2 != null) {
            try {
                obj2 = field2.get(obj);
            } catch (IllegalAccessException e5) {
                Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e5);
            }
        }
        if (obj2 != null) {
            e(obj2);
        }
    }

    private static void e(Object obj) throws NoSuchFieldException, SecurityException {
        LongSparseArray longSparseArray;
        if (!f1651d) {
            try {
                f1650c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e2) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e2);
            }
            f1651d = true;
        }
        Class cls = f1650c;
        if (cls == null) {
            return;
        }
        if (!f1652f) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                e = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e3);
            }
            f1652f = true;
        }
        Field field = e;
        if (field == null) {
            return;
        }
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException e4) {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e4);
            longSparseArray = null;
        }
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }
}
