package O;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.util.Property;
import android.view.View;
import androidx.core.view.M;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
abstract class A {

    /* renamed from: a, reason: collision with root package name */
    private static final E f363a;

    /* renamed from: b, reason: collision with root package name */
    private static Field f364b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f365c;

    /* renamed from: d, reason: collision with root package name */
    static final Property f366d;
    static final Property e;

    static class a extends Property {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(A.d(view));
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f2) {
            A.h(view, f2.floatValue());
        }
    }

    static class b extends Property {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Rect get(View view) {
            return M.q(view);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Rect rect) {
            M.l0(view, rect);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 22) {
            f363a = new D();
        } else {
            f363a = new C();
        }
        f366d = new a(Float.class, "translationAlpha");
        e = new b(Rect.class, "clipBounds");
    }

    static void a(View view) {
        f363a.a(view);
    }

    private static void b() throws NoSuchFieldException, SecurityException {
        if (f365c) {
            return;
        }
        try {
            Field declaredField = View.class.getDeclaredField("mViewFlags");
            f364b = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException unused) {
            Log.i("ViewUtils", "fetchViewFlagsField: ");
        }
        f365c = true;
    }

    static z c(View view) {
        return new y(view);
    }

    static float d(View view) {
        return f363a.b(view);
    }

    static H e(View view) {
        return new G(view);
    }

    static void f(View view) {
        f363a.c(view);
    }

    static void g(View view, int i2, int i3, int i4, int i5) {
        f363a.d(view, i2, i3, i4, i5);
    }

    static void h(View view, float f2) {
        f363a.e(view, f2);
    }

    static void i(View view, int i2) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        b();
        Field field = f364b;
        if (field != null) {
            try {
                f364b.setInt(view, i2 | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused) {
            }
        }
    }

    static void j(View view, Matrix matrix) {
        f363a.f(view, matrix);
    }

    static void k(View view, Matrix matrix) {
        f363a.g(view, matrix);
    }
}
