package g;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import java.lang.reflect.InvocationTargetException;

/* renamed from: g.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0255b extends Drawable implements Drawable.Callback {

    /* renamed from: a, reason: collision with root package name */
    private d f6205a;

    /* renamed from: b, reason: collision with root package name */
    private Rect f6206b;

    /* renamed from: c, reason: collision with root package name */
    private Drawable f6207c;

    /* renamed from: d, reason: collision with root package name */
    private Drawable f6208d;

    /* renamed from: f, reason: collision with root package name */
    private boolean f6209f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f6211h;

    /* renamed from: i, reason: collision with root package name */
    private Runnable f6212i;

    /* renamed from: j, reason: collision with root package name */
    private long f6213j;

    /* renamed from: k, reason: collision with root package name */
    private long f6214k;

    /* renamed from: l, reason: collision with root package name */
    private c f6215l;
    private int e = 255;

    /* renamed from: g, reason: collision with root package name */
    private int f6210g = -1;

    /* renamed from: g.b$a */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC0255b.this.a(true);
            AbstractC0255b.this.invalidateSelf();
        }
    }

    /* renamed from: g.b$b, reason: collision with other inner class name */
    private static class C0075b {
        public static boolean a(Drawable.ConstantState constantState) {
            return constantState.canApplyTheme();
        }

        public static void b(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }

        public static Resources c(Resources.Theme theme) {
            return theme.getResources();
        }
    }

    /* renamed from: g.b$d */
    static abstract class d extends Drawable.ConstantState {

        /* renamed from: A, reason: collision with root package name */
        int f6218A;

        /* renamed from: B, reason: collision with root package name */
        int f6219B;

        /* renamed from: C, reason: collision with root package name */
        boolean f6220C;

        /* renamed from: D, reason: collision with root package name */
        ColorFilter f6221D;

        /* renamed from: E, reason: collision with root package name */
        boolean f6222E;

        /* renamed from: F, reason: collision with root package name */
        ColorStateList f6223F;

        /* renamed from: G, reason: collision with root package name */
        PorterDuff.Mode f6224G;

        /* renamed from: H, reason: collision with root package name */
        boolean f6225H;

        /* renamed from: I, reason: collision with root package name */
        boolean f6226I;

        /* renamed from: a, reason: collision with root package name */
        final AbstractC0255b f6227a;

        /* renamed from: b, reason: collision with root package name */
        Resources f6228b;

        /* renamed from: c, reason: collision with root package name */
        int f6229c;

        /* renamed from: d, reason: collision with root package name */
        int f6230d;
        int e;

        /* renamed from: f, reason: collision with root package name */
        SparseArray f6231f;

        /* renamed from: g, reason: collision with root package name */
        Drawable[] f6232g;

        /* renamed from: h, reason: collision with root package name */
        int f6233h;

        /* renamed from: i, reason: collision with root package name */
        boolean f6234i;

        /* renamed from: j, reason: collision with root package name */
        boolean f6235j;

        /* renamed from: k, reason: collision with root package name */
        Rect f6236k;

        /* renamed from: l, reason: collision with root package name */
        boolean f6237l;

        /* renamed from: m, reason: collision with root package name */
        boolean f6238m;

        /* renamed from: n, reason: collision with root package name */
        int f6239n;
        int o;

        /* renamed from: p, reason: collision with root package name */
        int f6240p;

        /* renamed from: q, reason: collision with root package name */
        int f6241q;
        boolean r;
        int s;

        /* renamed from: t, reason: collision with root package name */
        boolean f6242t;

        /* renamed from: u, reason: collision with root package name */
        boolean f6243u;

        /* renamed from: v, reason: collision with root package name */
        boolean f6244v;

        /* renamed from: w, reason: collision with root package name */
        boolean f6245w;

        /* renamed from: x, reason: collision with root package name */
        boolean f6246x;

        /* renamed from: y, reason: collision with root package name */
        boolean f6247y;

        /* renamed from: z, reason: collision with root package name */
        int f6248z;

        d(d dVar, AbstractC0255b abstractC0255b, Resources resources) {
            this.f6234i = false;
            this.f6237l = false;
            this.f6246x = true;
            this.f6218A = 0;
            this.f6219B = 0;
            this.f6227a = abstractC0255b;
            this.f6228b = resources != null ? resources : dVar != null ? dVar.f6228b : null;
            int iF = AbstractC0255b.f(resources, dVar != null ? dVar.f6229c : 0);
            this.f6229c = iF;
            if (dVar == null) {
                this.f6232g = new Drawable[10];
                this.f6233h = 0;
                return;
            }
            this.f6230d = dVar.f6230d;
            this.e = dVar.e;
            this.f6244v = true;
            this.f6245w = true;
            this.f6234i = dVar.f6234i;
            this.f6237l = dVar.f6237l;
            this.f6246x = dVar.f6246x;
            this.f6247y = dVar.f6247y;
            this.f6248z = dVar.f6248z;
            this.f6218A = dVar.f6218A;
            this.f6219B = dVar.f6219B;
            this.f6220C = dVar.f6220C;
            this.f6221D = dVar.f6221D;
            this.f6222E = dVar.f6222E;
            this.f6223F = dVar.f6223F;
            this.f6224G = dVar.f6224G;
            this.f6225H = dVar.f6225H;
            this.f6226I = dVar.f6226I;
            if (dVar.f6229c == iF) {
                if (dVar.f6235j) {
                    this.f6236k = dVar.f6236k != null ? new Rect(dVar.f6236k) : null;
                    this.f6235j = true;
                }
                if (dVar.f6238m) {
                    this.f6239n = dVar.f6239n;
                    this.o = dVar.o;
                    this.f6240p = dVar.f6240p;
                    this.f6241q = dVar.f6241q;
                    this.f6238m = true;
                }
            }
            if (dVar.r) {
                this.s = dVar.s;
                this.r = true;
            }
            if (dVar.f6242t) {
                this.f6243u = dVar.f6243u;
                this.f6242t = true;
            }
            Drawable[] drawableArr = dVar.f6232g;
            this.f6232g = new Drawable[drawableArr.length];
            this.f6233h = dVar.f6233h;
            SparseArray sparseArray = dVar.f6231f;
            if (sparseArray != null) {
                this.f6231f = sparseArray.clone();
            } else {
                this.f6231f = new SparseArray(this.f6233h);
            }
            int i2 = this.f6233h;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                if (drawable != null) {
                    Drawable.ConstantState constantState = drawable.getConstantState();
                    if (constantState != null) {
                        this.f6231f.put(i3, constantState);
                    } else {
                        this.f6232g[i3] = drawableArr[i3];
                    }
                }
            }
        }

        private void e() {
            SparseArray sparseArray = this.f6231f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f6232g[this.f6231f.keyAt(i2)] = s(((Drawable.ConstantState) this.f6231f.valueAt(i2)).newDrawable(this.f6228b));
                }
                this.f6231f = null;
            }
        }

        private Drawable s(Drawable drawable) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (Build.VERSION.SDK_INT >= 23) {
                androidx.core.graphics.drawable.a.l(drawable, this.f6248z);
            }
            Drawable drawableMutate = drawable.mutate();
            drawableMutate.setCallback(this.f6227a);
            return drawableMutate;
        }

        public final int a(Drawable drawable) {
            int i2 = this.f6233h;
            if (i2 >= this.f6232g.length) {
                o(i2, i2 + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f6227a);
            this.f6232g[i2] = drawable;
            this.f6233h++;
            this.e = drawable.getChangingConfigurations() | this.e;
            p();
            this.f6236k = null;
            this.f6235j = false;
            this.f6238m = false;
            this.f6244v = false;
            return i2;
        }

        final void b(Resources.Theme theme) {
            if (theme != null) {
                e();
                int i2 = this.f6233h;
                Drawable[] drawableArr = this.f6232g;
                for (int i3 = 0; i3 < i2; i3++) {
                    Drawable drawable = drawableArr[i3];
                    if (drawable != null && androidx.core.graphics.drawable.a.b(drawable)) {
                        androidx.core.graphics.drawable.a.a(drawableArr[i3], theme);
                        this.e |= drawableArr[i3].getChangingConfigurations();
                    }
                }
                y(C0075b.c(theme));
            }
        }

        public boolean c() {
            if (this.f6244v) {
                return this.f6245w;
            }
            e();
            this.f6244v = true;
            int i2 = this.f6233h;
            Drawable[] drawableArr = this.f6232g;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3].getConstantState() == null) {
                    this.f6245w = false;
                    return false;
                }
            }
            this.f6245w = true;
            return true;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            int i2 = this.f6233h;
            Drawable[] drawableArr = this.f6232g;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                if (drawable == null) {
                    Drawable.ConstantState constantState = (Drawable.ConstantState) this.f6231f.get(i3);
                    if (constantState != null && C0075b.a(constantState)) {
                        return true;
                    }
                } else if (androidx.core.graphics.drawable.a.b(drawable)) {
                    return true;
                }
            }
            return false;
        }

        protected void d() {
            this.f6238m = true;
            e();
            int i2 = this.f6233h;
            Drawable[] drawableArr = this.f6232g;
            this.o = -1;
            this.f6239n = -1;
            this.f6241q = 0;
            this.f6240p = 0;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.f6239n) {
                    this.f6239n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.o) {
                    this.o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.f6240p) {
                    this.f6240p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.f6241q) {
                    this.f6241q = minimumHeight;
                }
            }
        }

        final int f() {
            return this.f6232g.length;
        }

        public final Drawable g(int i2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            int iIndexOfKey;
            Drawable drawable = this.f6232g[i2];
            if (drawable != null) {
                return drawable;
            }
            SparseArray sparseArray = this.f6231f;
            if (sparseArray == null || (iIndexOfKey = sparseArray.indexOfKey(i2)) < 0) {
                return null;
            }
            Drawable drawableS = s(((Drawable.ConstantState) this.f6231f.valueAt(iIndexOfKey)).newDrawable(this.f6228b));
            this.f6232g[i2] = drawableS;
            this.f6231f.removeAt(iIndexOfKey);
            if (this.f6231f.size() == 0) {
                this.f6231f = null;
            }
            return drawableS;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f6230d | this.e;
        }

        public final int h() {
            return this.f6233h;
        }

        public final int i() {
            if (!this.f6238m) {
                d();
            }
            return this.o;
        }

        public final int j() {
            if (!this.f6238m) {
                d();
            }
            return this.f6241q;
        }

        public final int k() {
            if (!this.f6238m) {
                d();
            }
            return this.f6240p;
        }

        public final Rect l() {
            Rect rect = null;
            if (this.f6234i) {
                return null;
            }
            Rect rect2 = this.f6236k;
            if (rect2 != null || this.f6235j) {
                return rect2;
            }
            e();
            Rect rect3 = new Rect();
            int i2 = this.f6233h;
            Drawable[] drawableArr = this.f6232g;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3].getPadding(rect3)) {
                    if (rect == null) {
                        rect = new Rect(0, 0, 0, 0);
                    }
                    int i4 = rect3.left;
                    if (i4 > rect.left) {
                        rect.left = i4;
                    }
                    int i5 = rect3.top;
                    if (i5 > rect.top) {
                        rect.top = i5;
                    }
                    int i6 = rect3.right;
                    if (i6 > rect.right) {
                        rect.right = i6;
                    }
                    int i7 = rect3.bottom;
                    if (i7 > rect.bottom) {
                        rect.bottom = i7;
                    }
                }
            }
            this.f6235j = true;
            this.f6236k = rect;
            return rect;
        }

        public final int m() {
            if (!this.f6238m) {
                d();
            }
            return this.f6239n;
        }

        public final int n() {
            if (this.r) {
                return this.s;
            }
            e();
            int i2 = this.f6233h;
            Drawable[] drawableArr = this.f6232g;
            int opacity = i2 > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i3 = 1; i3 < i2; i3++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i3].getOpacity());
            }
            this.s = opacity;
            this.r = true;
            return opacity;
        }

        public void o(int i2, int i3) {
            Drawable[] drawableArr = new Drawable[i3];
            Drawable[] drawableArr2 = this.f6232g;
            if (drawableArr2 != null) {
                System.arraycopy(drawableArr2, 0, drawableArr, 0, i2);
            }
            this.f6232g = drawableArr;
        }

        void p() {
            this.r = false;
            this.f6242t = false;
        }

        public final boolean q() {
            return this.f6237l;
        }

        abstract void r();

        public final void t(boolean z2) {
            this.f6237l = z2;
        }

        public final void u(int i2) {
            this.f6218A = i2;
        }

        public final void v(int i2) {
            this.f6219B = i2;
        }

        final boolean w(int i2, int i3) {
            int i4 = this.f6233h;
            Drawable[] drawableArr = this.f6232g;
            boolean z2 = false;
            for (int i5 = 0; i5 < i4; i5++) {
                Drawable drawable = drawableArr[i5];
                if (drawable != null) {
                    boolean zL = Build.VERSION.SDK_INT >= 23 ? androidx.core.graphics.drawable.a.l(drawable, i2) : false;
                    if (i5 == i3) {
                        z2 = zL;
                    }
                }
            }
            this.f6248z = i2;
            return z2;
        }

        public final void x(boolean z2) {
            this.f6234i = z2;
        }

        final void y(Resources resources) {
            if (resources != null) {
                this.f6228b = resources;
                int iF = AbstractC0255b.f(resources, this.f6229c);
                int i2 = this.f6229c;
                this.f6229c = iF;
                if (i2 != iF) {
                    this.f6238m = false;
                    this.f6235j = false;
                }
            }
        }
    }

    private void d(Drawable drawable) {
        if (this.f6215l == null) {
            this.f6215l = new c();
        }
        drawable.setCallback(this.f6215l.b(drawable.getCallback()));
        try {
            if (this.f6205a.f6218A <= 0 && this.f6209f) {
                drawable.setAlpha(this.e);
            }
            d dVar = this.f6205a;
            if (dVar.f6222E) {
                drawable.setColorFilter(dVar.f6221D);
            } else {
                if (dVar.f6225H) {
                    androidx.core.graphics.drawable.a.n(drawable, dVar.f6223F);
                }
                d dVar2 = this.f6205a;
                if (dVar2.f6226I) {
                    androidx.core.graphics.drawable.a.o(drawable, dVar2.f6224G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f6205a.f6246x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                androidx.core.graphics.drawable.a.l(drawable, androidx.core.graphics.drawable.a.e(this));
            }
            androidx.core.graphics.drawable.a.i(drawable, this.f6205a.f6220C);
            Rect rect = this.f6206b;
            if (rect != null) {
                androidx.core.graphics.drawable.a.k(drawable, rect.left, rect.top, rect.right, rect.bottom);
            }
            drawable.setCallback(this.f6215l.a());
        } catch (Throwable th) {
            drawable.setCallback(this.f6215l.a());
            throw th;
        }
    }

    private boolean e() {
        return isAutoMirrored() && androidx.core.graphics.drawable.a.e(this) == 1;
    }

    static int f(Resources resources, int i2) {
        if (resources != null) {
            i2 = resources.getDisplayMetrics().densityDpi;
        }
        if (i2 == 0) {
            return 160;
        }
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void a(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.f6209f = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.f6207c
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r8 = 0
            if (r3 == 0) goto L38
            long r9 = r13.f6213j
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 == 0) goto L3a
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L22
            int r9 = r13.e
            r3.setAlpha(r9)
            r13.f6213j = r6
            goto L3a
        L22:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r10 = (int) r9
            g.b$d r9 = r13.f6205a
            int r9 = r9.f6218A
            int r10 = r10 / r9
            int r9 = 255 - r10
            int r10 = r13.e
            int r9 = r9 * r10
            int r9 = r9 / 255
            r3.setAlpha(r9)
            r3 = 1
            goto L3b
        L38:
            r13.f6213j = r6
        L3a:
            r3 = 0
        L3b:
            android.graphics.drawable.Drawable r9 = r13.f6208d
            if (r9 == 0) goto L65
            long r10 = r13.f6214k
            int r12 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r12 == 0) goto L67
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L52
            r9.setVisible(r8, r8)
            r0 = 0
            r13.f6208d = r0
            r13.f6214k = r6
            goto L67
        L52:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            g.b$d r4 = r13.f6205a
            int r4 = r4.f6219B
            int r3 = r3 / r4
            int r4 = r13.e
            int r3 = r3 * r4
            int r3 = r3 / 255
            r9.setAlpha(r3)
            goto L68
        L65:
            r13.f6214k = r6
        L67:
            r0 = r3
        L68:
            if (r14 == 0) goto L74
            if (r0 == 0) goto L74
            java.lang.Runnable r14 = r13.f6212i
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g.AbstractC0255b.a(boolean):void");
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        this.f6205a.b(theme);
    }

    abstract d b();

    int c() {
        return this.f6210g;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.f6205a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f6207c;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f6208d;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean g(int r10) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r9 = this;
            int r0 = r9.f6210g
            r1 = 0
            if (r10 != r0) goto L6
            return r1
        L6:
            long r2 = android.os.SystemClock.uptimeMillis()
            g.b$d r0 = r9.f6205a
            int r0 = r0.f6219B
            r4 = 0
            r5 = 0
            if (r0 <= 0) goto L2e
            android.graphics.drawable.Drawable r0 = r9.f6208d
            if (r0 == 0) goto L1a
            r0.setVisible(r1, r1)
        L1a:
            android.graphics.drawable.Drawable r0 = r9.f6207c
            if (r0 == 0) goto L29
            r9.f6208d = r0
            g.b$d r0 = r9.f6205a
            int r0 = r0.f6219B
            long r0 = (long) r0
            long r0 = r0 + r2
            r9.f6214k = r0
            goto L35
        L29:
            r9.f6208d = r4
            r9.f6214k = r5
            goto L35
        L2e:
            android.graphics.drawable.Drawable r0 = r9.f6207c
            if (r0 == 0) goto L35
            r0.setVisible(r1, r1)
        L35:
            if (r10 < 0) goto L55
            g.b$d r0 = r9.f6205a
            int r1 = r0.f6233h
            if (r10 >= r1) goto L55
            android.graphics.drawable.Drawable r0 = r0.g(r10)
            r9.f6207c = r0
            r9.f6210g = r10
            if (r0 == 0) goto L5a
            g.b$d r10 = r9.f6205a
            int r10 = r10.f6218A
            if (r10 <= 0) goto L51
            long r7 = (long) r10
            long r2 = r2 + r7
            r9.f6213j = r2
        L51:
            r9.d(r0)
            goto L5a
        L55:
            r9.f6207c = r4
            r10 = -1
            r9.f6210g = r10
        L5a:
            long r0 = r9.f6213j
            r10 = 1
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 != 0) goto L67
            long r0 = r9.f6214k
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 == 0) goto L79
        L67:
            java.lang.Runnable r0 = r9.f6212i
            if (r0 != 0) goto L73
            g.b$a r0 = new g.b$a
            r0.<init>()
            r9.f6212i = r0
            goto L76
        L73:
            r9.unscheduleSelf(r0)
        L76:
            r9.a(r10)
        L79:
            r9.invalidateSelf()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: g.AbstractC0255b.g(int):boolean");
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f6205a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (!this.f6205a.c()) {
            return null;
        }
        this.f6205a.f6230d = getChangingConfigurations();
        return this.f6205a;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f6207c;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f6206b;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f6205a.q()) {
            return this.f6205a.i();
        }
        Drawable drawable = this.f6207c;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f6205a.q()) {
            return this.f6205a.m();
        }
        Drawable drawable = this.f6207c;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.f6205a.q()) {
            return this.f6205a.j();
        }
        Drawable drawable = this.f6207c;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.f6205a.q()) {
            return this.f6205a.k();
        }
        Drawable drawable = this.f6207c;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f6207c;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f6205a.n();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Drawable drawable = this.f6207c;
        if (drawable != null) {
            C0075b.b(drawable, outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        boolean padding;
        Rect rectL = this.f6205a.l();
        if (rectL != null) {
            rect.set(rectL);
            padding = (rectL.right | ((rectL.left | rectL.top) | rectL.bottom)) != 0;
        } else {
            Drawable drawable = this.f6207c;
            padding = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (e()) {
            int i2 = rect.left;
            rect.left = rect.right;
            rect.right = i2;
        }
        return padding;
    }

    void h(d dVar) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        this.f6205a = dVar;
        int i2 = this.f6210g;
        if (i2 >= 0) {
            Drawable drawableG = dVar.g(i2);
            this.f6207c = drawableG;
            if (drawableG != null) {
                d(drawableG);
            }
        }
        this.f6208d = null;
    }

    final void i(Resources resources) {
        this.f6205a.y(resources);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        d dVar = this.f6205a;
        if (dVar != null) {
            dVar.p();
        }
        if (drawable != this.f6207c || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f6205a.f6220C;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z2;
        Drawable drawable = this.f6208d;
        boolean z3 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f6208d = null;
            z2 = true;
        } else {
            z2 = false;
        }
        Drawable drawable2 = this.f6207c;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f6209f) {
                this.f6207c.setAlpha(this.e);
            }
        }
        if (this.f6214k != 0) {
            this.f6214k = 0L;
            z2 = true;
        }
        if (this.f6213j != 0) {
            this.f6213j = 0L;
        } else {
            z3 = z2;
        }
        if (z3) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (!this.f6211h && super.mutate() == this) {
            d dVarB = b();
            dVarB.r();
            h(dVarB);
            this.f6211h = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f6208d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f6207c;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i2) {
        return this.f6205a.w(i2, c());
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i2) {
        Drawable drawable = this.f6208d;
        if (drawable != null) {
            return drawable.setLevel(i2);
        }
        Drawable drawable2 = this.f6207c;
        if (drawable2 != null) {
            return drawable2.setLevel(i2);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        if (drawable != this.f6207c || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        if (this.f6209f && this.e == i2) {
            return;
        }
        this.f6209f = true;
        this.e = i2;
        Drawable drawable = this.f6207c;
        if (drawable != null) {
            if (this.f6213j == 0) {
                drawable.setAlpha(i2);
            } else {
                a(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z2) {
        d dVar = this.f6205a;
        if (dVar.f6220C != z2) {
            dVar.f6220C = z2;
            Drawable drawable = this.f6207c;
            if (drawable != null) {
                androidx.core.graphics.drawable.a.i(drawable, z2);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        d dVar = this.f6205a;
        dVar.f6222E = true;
        if (dVar.f6221D != colorFilter) {
            dVar.f6221D = colorFilter;
            Drawable drawable = this.f6207c;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z2) {
        d dVar = this.f6205a;
        if (dVar.f6246x != z2) {
            dVar.f6246x = z2;
            Drawable drawable = this.f6207c;
            if (drawable != null) {
                drawable.setDither(z2);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f2, float f3) {
        Drawable drawable = this.f6207c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.j(drawable, f2, f3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        Rect rect = this.f6206b;
        if (rect == null) {
            this.f6206b = new Rect(i2, i3, i4, i5);
        } else {
            rect.set(i2, i3, i4, i5);
        }
        Drawable drawable = this.f6207c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.k(drawable, i2, i3, i4, i5);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        d dVar = this.f6205a;
        dVar.f6225H = true;
        if (dVar.f6223F != colorStateList) {
            dVar.f6223F = colorStateList;
            androidx.core.graphics.drawable.a.n(this.f6207c, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        d dVar = this.f6205a;
        dVar.f6226I = true;
        if (dVar.f6224G != mode) {
            dVar.f6224G = mode;
            androidx.core.graphics.drawable.a.o(this.f6207c, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        boolean visible = super.setVisible(z2, z3);
        Drawable drawable = this.f6208d;
        if (drawable != null) {
            drawable.setVisible(z2, z3);
        }
        Drawable drawable2 = this.f6207c;
        if (drawable2 != null) {
            drawable2.setVisible(z2, z3);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.f6207c || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }

    /* renamed from: g.b$c */
    static class c implements Drawable.Callback {

        /* renamed from: a, reason: collision with root package name */
        private Drawable.Callback f6217a;

        c() {
        }

        public Drawable.Callback a() {
            Drawable.Callback callback = this.f6217a;
            this.f6217a = null;
            return callback;
        }

        public c b(Drawable.Callback callback) {
            this.f6217a = callback;
            return this;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
            Drawable.Callback callback = this.f6217a;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j2);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.f6217a;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
        }
    }
}
