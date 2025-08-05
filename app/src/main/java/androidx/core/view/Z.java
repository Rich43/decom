package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;
import v.AbstractC0340c;
import v.AbstractC0345h;

/* loaded from: classes.dex */
public class Z {

    /* renamed from: b */
    public static final Z f3123b;

    /* renamed from: a */
    private final l f3124a;

    static class a {

        /* renamed from: a */
        private static Field f3125a;

        /* renamed from: b */
        private static Field f3126b;

        /* renamed from: c */
        private static Field f3127c;

        /* renamed from: d */
        private static boolean f3128d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f3125a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f3126b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f3127c = declaredField3;
                declaredField3.setAccessible(true);
                f3128d = true;
            } catch (ReflectiveOperationException e) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e.getMessage(), e);
            }
        }

        public static Z a(View view) throws IllegalAccessException, IllegalArgumentException {
            if (f3128d && view.isAttachedToWindow()) {
                try {
                    Object obj = f3125a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f3126b.get(obj);
                        Rect rect2 = (Rect) f3127c.get(obj);
                        if (rect != null && rect2 != null) {
                            Z zA = new b().b(androidx.core.graphics.f.c(rect)).c(androidx.core.graphics.f.c(rect2)).a();
                            zA.r(zA);
                            zA.d(view.getRootView());
                            return zA;
                        }
                    }
                } catch (IllegalAccessException e) {
                    Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e.getMessage(), e);
                }
            }
            return null;
        }
    }

    private static class e extends d {
        e() {
        }

        e(Z z2) {
            super(z2);
        }
    }

    private static class f {

        /* renamed from: a */
        private final Z f3136a;

        /* renamed from: b */
        androidx.core.graphics.f[] f3137b;

        f() {
            this(new Z((Z) null));
        }

        protected final void a() {
            androidx.core.graphics.f[] fVarArr = this.f3137b;
            if (fVarArr != null) {
                androidx.core.graphics.f fVarF = fVarArr[m.a(1)];
                androidx.core.graphics.f fVarF2 = this.f3137b[m.a(2)];
                if (fVarF2 == null) {
                    fVarF2 = this.f3136a.f(2);
                }
                if (fVarF == null) {
                    fVarF = this.f3136a.f(1);
                }
                f(androidx.core.graphics.f.a(fVarF, fVarF2));
                androidx.core.graphics.f fVar = this.f3137b[m.a(16)];
                if (fVar != null) {
                    e(fVar);
                }
                androidx.core.graphics.f fVar2 = this.f3137b[m.a(32)];
                if (fVar2 != null) {
                    c(fVar2);
                }
                androidx.core.graphics.f fVar3 = this.f3137b[m.a(64)];
                if (fVar3 != null) {
                    g(fVar3);
                }
            }
        }

        abstract Z b();

        void c(androidx.core.graphics.f fVar) {
        }

        abstract void d(androidx.core.graphics.f fVar);

        void e(androidx.core.graphics.f fVar) {
        }

        abstract void f(androidx.core.graphics.f fVar);

        void g(androidx.core.graphics.f fVar) {
        }

        f(Z z2) {
            this.f3136a = z2;
        }
    }

    private static class i extends h {
        i(Z z2, WindowInsets windowInsets) {
            super(z2, windowInsets);
        }

        @Override // androidx.core.view.Z.l
        Z a() {
            return Z.u(this.f3143c.consumeDisplayCutout());
        }

        @Override // androidx.core.view.Z.g, androidx.core.view.Z.l
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return Objects.equals(this.f3143c, iVar.f3143c) && Objects.equals(this.f3146g, iVar.f3146g);
        }

        @Override // androidx.core.view.Z.l
        r f() {
            return r.e(this.f3143c.getDisplayCutout());
        }

        @Override // androidx.core.view.Z.l
        public int hashCode() {
            return this.f3143c.hashCode();
        }

        i(Z z2, i iVar) {
            super(z2, iVar);
        }
    }

    private static class k extends j {

        /* renamed from: q */
        static final Z f3150q = Z.u(WindowInsets.CONSUMED);

        k(Z z2, WindowInsets windowInsets) {
            super(z2, windowInsets);
        }

        @Override // androidx.core.view.Z.g, androidx.core.view.Z.l
        final void d(View view) {
        }

        @Override // androidx.core.view.Z.g, androidx.core.view.Z.l
        public androidx.core.graphics.f g(int i2) {
            return androidx.core.graphics.f.d(this.f3143c.getInsets(n.a(i2)));
        }

        k(Z z2, k kVar) {
            super(z2, kVar);
        }
    }

    private static class l {

        /* renamed from: b */
        static final Z f3151b = new b().a().a().b().c();

        /* renamed from: a */
        final Z f3152a;

        l(Z z2) {
            this.f3152a = z2;
        }

        Z a() {
            return this.f3152a;
        }

        Z b() {
            return this.f3152a;
        }

        Z c() {
            return this.f3152a;
        }

        void d(View view) {
        }

        void e(Z z2) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            return o() == lVar.o() && n() == lVar.n() && AbstractC0340c.a(k(), lVar.k()) && AbstractC0340c.a(i(), lVar.i()) && AbstractC0340c.a(f(), lVar.f());
        }

        r f() {
            return null;
        }

        androidx.core.graphics.f g(int i2) {
            return androidx.core.graphics.f.e;
        }

        androidx.core.graphics.f h() {
            return k();
        }

        public int hashCode() {
            return AbstractC0340c.b(Boolean.valueOf(o()), Boolean.valueOf(n()), k(), i(), f());
        }

        androidx.core.graphics.f i() {
            return androidx.core.graphics.f.e;
        }

        androidx.core.graphics.f j() {
            return k();
        }

        androidx.core.graphics.f k() {
            return androidx.core.graphics.f.e;
        }

        androidx.core.graphics.f l() {
            return k();
        }

        Z m(int i2, int i3, int i4, int i5) {
            return f3151b;
        }

        boolean n() {
            return false;
        }

        boolean o() {
            return false;
        }

        public void p(androidx.core.graphics.f[] fVarArr) {
        }

        void q(androidx.core.graphics.f fVar) {
        }

        void r(Z z2) {
        }

        public void s(androidx.core.graphics.f fVar) {
        }
    }

    public static final class m {
        static int a(int i2) {
            if (i2 == 1) {
                return 0;
            }
            if (i2 == 2) {
                return 1;
            }
            if (i2 == 4) {
                return 2;
            }
            if (i2 == 8) {
                return 3;
            }
            if (i2 == 16) {
                return 4;
            }
            if (i2 == 32) {
                return 5;
            }
            if (i2 == 64) {
                return 6;
            }
            if (i2 == 128) {
                return 7;
            }
            if (i2 == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i2);
        }
    }

    private static final class n {
        static int a(int i2) {
            int iStatusBars;
            int i3 = 0;
            for (int i4 = 1; i4 <= 256; i4 <<= 1) {
                if ((i2 & i4) != 0) {
                    if (i4 == 1) {
                        iStatusBars = WindowInsets.Type.statusBars();
                    } else if (i4 == 2) {
                        iStatusBars = WindowInsets.Type.navigationBars();
                    } else if (i4 == 4) {
                        iStatusBars = WindowInsets.Type.captionBar();
                    } else if (i4 == 8) {
                        iStatusBars = WindowInsets.Type.ime();
                    } else if (i4 == 16) {
                        iStatusBars = WindowInsets.Type.systemGestures();
                    } else if (i4 == 32) {
                        iStatusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i4 == 64) {
                        iStatusBars = WindowInsets.Type.tappableElement();
                    } else if (i4 == 128) {
                        iStatusBars = WindowInsets.Type.displayCutout();
                    }
                    i3 |= iStatusBars;
                }
            }
            return i3;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            f3123b = k.f3150q;
        } else {
            f3123b = l.f3151b;
        }
    }

    private Z(WindowInsets windowInsets) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            this.f3124a = new k(this, windowInsets);
            return;
        }
        if (i2 >= 29) {
            this.f3124a = new j(this, windowInsets);
        } else if (i2 >= 28) {
            this.f3124a = new i(this, windowInsets);
        } else {
            this.f3124a = new h(this, windowInsets);
        }
    }

    static androidx.core.graphics.f m(androidx.core.graphics.f fVar, int i2, int i3, int i4, int i5) {
        int iMax = Math.max(0, fVar.f3026a - i2);
        int iMax2 = Math.max(0, fVar.f3027b - i3);
        int iMax3 = Math.max(0, fVar.f3028c - i4);
        int iMax4 = Math.max(0, fVar.f3029d - i5);
        return (iMax == i2 && iMax2 == i3 && iMax3 == i4 && iMax4 == i5) ? fVar : androidx.core.graphics.f.b(iMax, iMax2, iMax3, iMax4);
    }

    public static Z u(WindowInsets windowInsets) {
        return v(windowInsets, null);
    }

    public static Z v(WindowInsets windowInsets, View view) {
        Z z2 = new Z((WindowInsets) AbstractC0345h.f(windowInsets));
        if (view != null && view.isAttachedToWindow()) {
            z2.r(M.E(view));
            z2.d(view.getRootView());
        }
        return z2;
    }

    public Z a() {
        return this.f3124a.a();
    }

    public Z b() {
        return this.f3124a.b();
    }

    public Z c() {
        return this.f3124a.c();
    }

    void d(View view) {
        this.f3124a.d(view);
    }

    public r e() {
        return this.f3124a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Z) {
            return AbstractC0340c.a(this.f3124a, ((Z) obj).f3124a);
        }
        return false;
    }

    public androidx.core.graphics.f f(int i2) {
        return this.f3124a.g(i2);
    }

    public androidx.core.graphics.f g() {
        return this.f3124a.i();
    }

    public int h() {
        return this.f3124a.k().f3029d;
    }

    public int hashCode() {
        l lVar = this.f3124a;
        if (lVar == null) {
            return 0;
        }
        return lVar.hashCode();
    }

    public int i() {
        return this.f3124a.k().f3026a;
    }

    public int j() {
        return this.f3124a.k().f3028c;
    }

    public int k() {
        return this.f3124a.k().f3027b;
    }

    public Z l(int i2, int i3, int i4, int i5) {
        return this.f3124a.m(i2, i3, i4, i5);
    }

    public boolean n() {
        return this.f3124a.n();
    }

    public Z o(int i2, int i3, int i4, int i5) {
        return new b(this).c(androidx.core.graphics.f.b(i2, i3, i4, i5)).a();
    }

    void p(androidx.core.graphics.f[] fVarArr) {
        this.f3124a.p(fVarArr);
    }

    void q(androidx.core.graphics.f fVar) {
        this.f3124a.q(fVar);
    }

    void r(Z z2) {
        this.f3124a.r(z2);
    }

    void s(androidx.core.graphics.f fVar) {
        this.f3124a.s(fVar);
    }

    public WindowInsets t() {
        l lVar = this.f3124a;
        if (lVar instanceof g) {
            return ((g) lVar).f3143c;
        }
        return null;
    }

    private static class c extends f {
        private static Field e = null;

        /* renamed from: f */
        private static boolean f3130f = false;

        /* renamed from: g */
        private static Constructor f3131g = null;

        /* renamed from: h */
        private static boolean f3132h = false;

        /* renamed from: c */
        private WindowInsets f3133c;

        /* renamed from: d */
        private androidx.core.graphics.f f3134d;

        c() {
            this.f3133c = h();
        }

        private static WindowInsets h() {
            if (!f3130f) {
                try {
                    e = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e2) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e2);
                }
                f3130f = true;
            }
            Field field = e;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e3) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e3);
                }
            }
            if (!f3132h) {
                try {
                    f3131g = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e4) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e4);
                }
                f3132h = true;
            }
            Constructor constructor = f3131g;
            if (constructor != null) {
                try {
                    return (WindowInsets) constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e5) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e5);
                }
            }
            return null;
        }

        @Override // androidx.core.view.Z.f
        Z b() {
            a();
            Z zU = Z.u(this.f3133c);
            zU.p(this.f3137b);
            zU.s(this.f3134d);
            return zU;
        }

        @Override // androidx.core.view.Z.f
        void d(androidx.core.graphics.f fVar) {
            this.f3134d = fVar;
        }

        @Override // androidx.core.view.Z.f
        void f(androidx.core.graphics.f fVar) {
            WindowInsets windowInsets = this.f3133c;
            if (windowInsets != null) {
                this.f3133c = windowInsets.replaceSystemWindowInsets(fVar.f3026a, fVar.f3027b, fVar.f3028c, fVar.f3029d);
            }
        }

        c(Z z2) {
            super(z2);
            this.f3133c = z2.t();
        }
    }

    private static class d extends f {

        /* renamed from: c */
        final WindowInsets.Builder f3135c;

        d() {
            this.f3135c = h0.a();
        }

        @Override // androidx.core.view.Z.f
        Z b() {
            a();
            Z zU = Z.u(this.f3135c.build());
            zU.p(this.f3137b);
            return zU;
        }

        @Override // androidx.core.view.Z.f
        void c(androidx.core.graphics.f fVar) {
            this.f3135c.setMandatorySystemGestureInsets(fVar.e());
        }

        @Override // androidx.core.view.Z.f
        void d(androidx.core.graphics.f fVar) {
            this.f3135c.setStableInsets(fVar.e());
        }

        @Override // androidx.core.view.Z.f
        void e(androidx.core.graphics.f fVar) {
            this.f3135c.setSystemGestureInsets(fVar.e());
        }

        @Override // androidx.core.view.Z.f
        void f(androidx.core.graphics.f fVar) {
            this.f3135c.setSystemWindowInsets(fVar.e());
        }

        @Override // androidx.core.view.Z.f
        void g(androidx.core.graphics.f fVar) {
            this.f3135c.setTappableElementInsets(fVar.e());
        }

        d(Z z2) {
            WindowInsets.Builder builderA;
            super(z2);
            WindowInsets windowInsetsT = z2.t();
            if (windowInsetsT != null) {
                builderA = g0.a(windowInsetsT);
            } else {
                builderA = h0.a();
            }
            this.f3135c = builderA;
        }
    }

    private static class h extends g {

        /* renamed from: m */
        private androidx.core.graphics.f f3147m;

        h(Z z2, WindowInsets windowInsets) {
            super(z2, windowInsets);
            this.f3147m = null;
        }

        @Override // androidx.core.view.Z.l
        Z b() {
            return Z.u(this.f3143c.consumeStableInsets());
        }

        @Override // androidx.core.view.Z.l
        Z c() {
            return Z.u(this.f3143c.consumeSystemWindowInsets());
        }

        @Override // androidx.core.view.Z.l
        final androidx.core.graphics.f i() {
            if (this.f3147m == null) {
                this.f3147m = androidx.core.graphics.f.b(this.f3143c.getStableInsetLeft(), this.f3143c.getStableInsetTop(), this.f3143c.getStableInsetRight(), this.f3143c.getStableInsetBottom());
            }
            return this.f3147m;
        }

        @Override // androidx.core.view.Z.l
        boolean n() {
            return this.f3143c.isConsumed();
        }

        @Override // androidx.core.view.Z.l
        public void s(androidx.core.graphics.f fVar) {
            this.f3147m = fVar;
        }

        h(Z z2, h hVar) {
            super(z2, hVar);
            this.f3147m = null;
            this.f3147m = hVar.f3147m;
        }
    }

    private static class g extends l {

        /* renamed from: h */
        private static boolean f3138h = false;

        /* renamed from: i */
        private static Method f3139i;

        /* renamed from: j */
        private static Class f3140j;

        /* renamed from: k */
        private static Field f3141k;

        /* renamed from: l */
        private static Field f3142l;

        /* renamed from: c */
        final WindowInsets f3143c;

        /* renamed from: d */
        private androidx.core.graphics.f[] f3144d;
        private androidx.core.graphics.f e;

        /* renamed from: f */
        private Z f3145f;

        /* renamed from: g */
        androidx.core.graphics.f f3146g;

        g(Z z2, WindowInsets windowInsets) {
            super(z2);
            this.e = null;
            this.f3143c = windowInsets;
        }

        @SuppressLint({"WrongConstant"})
        private androidx.core.graphics.f t(int i2, boolean z2) {
            androidx.core.graphics.f fVarA = androidx.core.graphics.f.e;
            for (int i3 = 1; i3 <= 256; i3 <<= 1) {
                if ((i2 & i3) != 0) {
                    fVarA = androidx.core.graphics.f.a(fVarA, u(i3, z2));
                }
            }
            return fVarA;
        }

        private androidx.core.graphics.f v() {
            Z z2 = this.f3145f;
            return z2 != null ? z2.g() : androidx.core.graphics.f.e;
        }

        private androidx.core.graphics.f w(View view) throws IllegalAccessException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (Build.VERSION.SDK_INT >= 30) {
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }
            if (!f3138h) {
                x();
            }
            Method method = f3139i;
            if (method != null && f3140j != null && f3141k != null) {
                try {
                    Object objInvoke = method.invoke(view, null);
                    if (objInvoke == null) {
                        Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                        return null;
                    }
                    Rect rect = (Rect) f3141k.get(f3142l.get(objInvoke));
                    if (rect != null) {
                        return androidx.core.graphics.f.c(rect);
                    }
                    return null;
                } catch (ReflectiveOperationException e) {
                    Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
                }
            }
            return null;
        }

        @SuppressLint({"PrivateApi"})
        private static void x() throws ClassNotFoundException, SecurityException {
            try {
                f3139i = View.class.getDeclaredMethod("getViewRootImpl", null);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f3140j = cls;
                f3141k = cls.getDeclaredField("mVisibleInsets");
                f3142l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                f3141k.setAccessible(true);
                f3142l.setAccessible(true);
            } catch (ReflectiveOperationException e) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
            }
            f3138h = true;
        }

        @Override // androidx.core.view.Z.l
        void d(View view) throws IllegalAccessException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
            androidx.core.graphics.f fVarW = w(view);
            if (fVarW == null) {
                fVarW = androidx.core.graphics.f.e;
            }
            q(fVarW);
        }

        @Override // androidx.core.view.Z.l
        void e(Z z2) {
            z2.r(this.f3145f);
            z2.q(this.f3146g);
        }

        @Override // androidx.core.view.Z.l
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.f3146g, ((g) obj).f3146g);
            }
            return false;
        }

        @Override // androidx.core.view.Z.l
        public androidx.core.graphics.f g(int i2) {
            return t(i2, false);
        }

        @Override // androidx.core.view.Z.l
        final androidx.core.graphics.f k() {
            if (this.e == null) {
                this.e = androidx.core.graphics.f.b(this.f3143c.getSystemWindowInsetLeft(), this.f3143c.getSystemWindowInsetTop(), this.f3143c.getSystemWindowInsetRight(), this.f3143c.getSystemWindowInsetBottom());
            }
            return this.e;
        }

        @Override // androidx.core.view.Z.l
        Z m(int i2, int i3, int i4, int i5) {
            b bVar = new b(Z.u(this.f3143c));
            bVar.c(Z.m(k(), i2, i3, i4, i5));
            bVar.b(Z.m(i(), i2, i3, i4, i5));
            return bVar.a();
        }

        @Override // androidx.core.view.Z.l
        boolean o() {
            return this.f3143c.isRound();
        }

        @Override // androidx.core.view.Z.l
        public void p(androidx.core.graphics.f[] fVarArr) {
            this.f3144d = fVarArr;
        }

        @Override // androidx.core.view.Z.l
        void q(androidx.core.graphics.f fVar) {
            this.f3146g = fVar;
        }

        @Override // androidx.core.view.Z.l
        void r(Z z2) {
            this.f3145f = z2;
        }

        protected androidx.core.graphics.f u(int i2, boolean z2) {
            androidx.core.graphics.f fVarG;
            int i3;
            if (i2 == 1) {
                return z2 ? androidx.core.graphics.f.b(0, Math.max(v().f3027b, k().f3027b), 0, 0) : androidx.core.graphics.f.b(0, k().f3027b, 0, 0);
            }
            if (i2 == 2) {
                if (z2) {
                    androidx.core.graphics.f fVarV = v();
                    androidx.core.graphics.f fVarI = i();
                    return androidx.core.graphics.f.b(Math.max(fVarV.f3026a, fVarI.f3026a), 0, Math.max(fVarV.f3028c, fVarI.f3028c), Math.max(fVarV.f3029d, fVarI.f3029d));
                }
                androidx.core.graphics.f fVarK = k();
                Z z3 = this.f3145f;
                fVarG = z3 != null ? z3.g() : null;
                int iMin = fVarK.f3029d;
                if (fVarG != null) {
                    iMin = Math.min(iMin, fVarG.f3029d);
                }
                return androidx.core.graphics.f.b(fVarK.f3026a, 0, fVarK.f3028c, iMin);
            }
            if (i2 != 8) {
                if (i2 == 16) {
                    return j();
                }
                if (i2 == 32) {
                    return h();
                }
                if (i2 == 64) {
                    return l();
                }
                if (i2 != 128) {
                    return androidx.core.graphics.f.e;
                }
                Z z4 = this.f3145f;
                r rVarE = z4 != null ? z4.e() : f();
                return rVarE != null ? androidx.core.graphics.f.b(rVarE.b(), rVarE.d(), rVarE.c(), rVarE.a()) : androidx.core.graphics.f.e;
            }
            androidx.core.graphics.f[] fVarArr = this.f3144d;
            fVarG = fVarArr != null ? fVarArr[m.a(8)] : null;
            if (fVarG != null) {
                return fVarG;
            }
            androidx.core.graphics.f fVarK2 = k();
            androidx.core.graphics.f fVarV2 = v();
            int i4 = fVarK2.f3029d;
            if (i4 > fVarV2.f3029d) {
                return androidx.core.graphics.f.b(0, 0, 0, i4);
            }
            androidx.core.graphics.f fVar = this.f3146g;
            return (fVar == null || fVar.equals(androidx.core.graphics.f.e) || (i3 = this.f3146g.f3029d) <= fVarV2.f3029d) ? androidx.core.graphics.f.e : androidx.core.graphics.f.b(0, 0, 0, i3);
        }

        g(Z z2, g gVar) {
            this(z2, new WindowInsets(gVar.f3143c));
        }
    }

    private static class j extends i {

        /* renamed from: n */
        private androidx.core.graphics.f f3148n;
        private androidx.core.graphics.f o;

        /* renamed from: p */
        private androidx.core.graphics.f f3149p;

        j(Z z2, WindowInsets windowInsets) {
            super(z2, windowInsets);
            this.f3148n = null;
            this.o = null;
            this.f3149p = null;
        }

        @Override // androidx.core.view.Z.l
        androidx.core.graphics.f h() {
            if (this.o == null) {
                this.o = androidx.core.graphics.f.d(this.f3143c.getMandatorySystemGestureInsets());
            }
            return this.o;
        }

        @Override // androidx.core.view.Z.l
        androidx.core.graphics.f j() {
            if (this.f3148n == null) {
                this.f3148n = androidx.core.graphics.f.d(this.f3143c.getSystemGestureInsets());
            }
            return this.f3148n;
        }

        @Override // androidx.core.view.Z.l
        androidx.core.graphics.f l() {
            if (this.f3149p == null) {
                this.f3149p = androidx.core.graphics.f.d(this.f3143c.getTappableElementInsets());
            }
            return this.f3149p;
        }

        @Override // androidx.core.view.Z.g, androidx.core.view.Z.l
        Z m(int i2, int i3, int i4, int i5) {
            return Z.u(this.f3143c.inset(i2, i3, i4, i5));
        }

        @Override // androidx.core.view.Z.h, androidx.core.view.Z.l
        public void s(androidx.core.graphics.f fVar) {
        }

        j(Z z2, j jVar) {
            super(z2, jVar);
            this.f3148n = null;
            this.o = null;
            this.f3149p = null;
        }
    }

    public static final class b {

        /* renamed from: a */
        private final f f3129a;

        public b() {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30) {
                this.f3129a = new e();
            } else if (i2 >= 29) {
                this.f3129a = new d();
            } else {
                this.f3129a = new c();
            }
        }

        public Z a() {
            return this.f3129a.b();
        }

        public b b(androidx.core.graphics.f fVar) {
            this.f3129a.d(fVar);
            return this;
        }

        public b c(androidx.core.graphics.f fVar) {
            this.f3129a.f(fVar);
            return this;
        }

        public b(Z z2) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30) {
                this.f3129a = new e(z2);
            } else if (i2 >= 29) {
                this.f3129a = new d(z2);
            } else {
                this.f3129a = new c(z2);
            }
        }
    }

    public Z(Z z2) {
        if (z2 != null) {
            l lVar = z2.f3124a;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30 && (lVar instanceof k)) {
                this.f3124a = new k(this, (k) lVar);
            } else if (i2 >= 29 && (lVar instanceof j)) {
                this.f3124a = new j(this, (j) lVar);
            } else if (i2 >= 28 && (lVar instanceof i)) {
                this.f3124a = new i(this, (i) lVar);
            } else if (lVar instanceof h) {
                this.f3124a = new h(this, (h) lVar);
            } else if (lVar instanceof g) {
                this.f3124a = new g(this, (g) lVar);
            } else {
                this.f3124a = new l(this);
            }
            lVar.e(this);
            return;
        }
        this.f3124a = new l(this);
    }
}
