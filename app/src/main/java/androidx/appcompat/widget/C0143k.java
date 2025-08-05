package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.widget.V;
import defpackage.e;
import f.AbstractC0250a;

/* renamed from: androidx.appcompat.widget.k */
/* loaded from: classes.dex */
public final class C0143k {

    /* renamed from: b */
    private static final PorterDuff.Mode f2468b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c */
    private static C0143k f2469c;

    /* renamed from: a */
    private V f2470a;

    /* renamed from: androidx.appcompat.widget.k$a */
    class a implements V.f {

        /* renamed from: a */
        private final int[] f2471a = {e.h.f5891R, e.h.f5889P, e.h.f5893a};

        /* renamed from: b */
        private final int[] f2472b = {e.h.o, e.h.f5875B, e.h.f5908t, e.h.f5906p, e.h.f5907q, e.h.s, e.h.r};

        /* renamed from: c */
        private final int[] f2473c = {e.h.f5888O, e.h.f5890Q, e.h.f5902k, e.h.f5884K, e.h.f5885L, e.h.f5886M, e.h.f5887N};

        /* renamed from: d */
        private final int[] f2474d = {e.h.f5911w, e.h.f5900i, e.h.f5910v};
        private final int[] e = {e.h.f5883J, e.h.f5892S};

        /* renamed from: f */
        private final int[] f2475f = {e.h.f5895c, e.h.f5898g, e.h.f5896d, e.h.f5899h};

        a() {
        }

        private boolean f(int[] iArr, int i2) {
            for (int i3 : iArr) {
                if (i3 == i2) {
                    return true;
                }
            }
            return false;
        }

        private ColorStateList g(Context context) {
            return h(context, 0);
        }

        private ColorStateList h(Context context, int i2) {
            int iC = Z.c(context, e.d.f5851t);
            return new ColorStateList(new int[][]{Z.f2357b, Z.e, Z.f2358c, Z.f2363i}, new int[]{Z.b(context, e.d.r), androidx.core.graphics.a.c(iC, i2), androidx.core.graphics.a.c(iC, i2), i2});
        }

        private ColorStateList i(Context context) {
            return h(context, Z.c(context, e.d.f5850q));
        }

        private ColorStateList j(Context context) {
            return h(context, Z.c(context, e.d.r));
        }

        private ColorStateList k(Context context) {
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            int i2 = e.d.f5853v;
            ColorStateList colorStateListE = Z.e(context, i2);
            if (colorStateListE == null || !colorStateListE.isStateful()) {
                iArr[0] = Z.f2357b;
                iArr2[0] = Z.b(context, i2);
                iArr[1] = Z.f2360f;
                iArr2[1] = Z.c(context, e.d.s);
                iArr[2] = Z.f2363i;
                iArr2[2] = Z.c(context, i2);
            } else {
                int[] iArr3 = Z.f2357b;
                iArr[0] = iArr3;
                iArr2[0] = colorStateListE.getColorForState(iArr3, 0);
                iArr[1] = Z.f2360f;
                iArr2[1] = Z.c(context, e.d.s);
                iArr[2] = Z.f2363i;
                iArr2[2] = colorStateListE.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        private LayerDrawable l(V v2, Context context, int i2) throws Resources.NotFoundException {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i2);
            Drawable drawableJ = v2.j(context, e.h.f5879F);
            Drawable drawableJ2 = v2.j(context, e.h.f5880G);
            if ((drawableJ instanceof BitmapDrawable) && drawableJ.getIntrinsicWidth() == dimensionPixelSize && drawableJ.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable = (BitmapDrawable) drawableJ;
                bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
            } else {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                drawableJ.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawableJ.draw(canvas);
                bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
                bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap);
            }
            bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
            if ((drawableJ2 instanceof BitmapDrawable) && drawableJ2.getIntrinsicWidth() == dimensionPixelSize && drawableJ2.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) drawableJ2;
            } else {
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
                drawableJ2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawableJ2.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(bitmapCreateBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
            layerDrawable.setId(0, R.id.background);
            layerDrawable.setId(1, R.id.secondaryProgress);
            layerDrawable.setId(2, R.id.progress);
            return layerDrawable;
        }

        private void m(Drawable drawable, int i2, PorterDuff.Mode mode) {
            Drawable drawableMutate = drawable.mutate();
            if (mode == null) {
                mode = C0143k.f2468b;
            }
            drawableMutate.setColorFilter(C0143k.e(i2, mode));
        }

        @Override // androidx.appcompat.widget.V.f
        public Drawable a(V v2, Context context, int i2) {
            if (i2 == e.h.f5901j) {
                return new LayerDrawable(new Drawable[]{v2.j(context, e.h.f5900i), v2.j(context, e.h.f5902k)});
            }
            if (i2 == e.h.f5913y) {
                return l(v2, context, e.g.f5868c);
            }
            if (i2 == e.h.f5912x) {
                return l(v2, context, e.g.f5869d);
            }
            if (i2 == e.h.f5914z) {
                return l(v2, context, e.g.e);
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:49:0x0052  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0067 A[RETURN] */
        @Override // androidx.appcompat.widget.V.f
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean b(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
            /*
                r6 = this;
                android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.C0143k.a()
                int[] r1 = r6.f2471a
                boolean r1 = r6.f(r1, r8)
                r2 = 1
                r3 = 0
                r4 = -1
                if (r1 == 0) goto L15
                int r8 = e.d.f5852u
            L11:
                r1 = r0
            L12:
                r0 = -1
                r5 = 1
                goto L50
            L15:
                int[] r1 = r6.f2473c
                boolean r1 = r6.f(r1, r8)
                if (r1 == 0) goto L20
                int r8 = e.d.s
                goto L11
            L20:
                int[] r1 = r6.f2474d
                boolean r1 = r6.f(r1, r8)
                r5 = 16842801(0x1010031, float:2.3693695E-38)
                if (r1 == 0) goto L32
                android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
            L2d:
                r1 = r0
                r8 = 16842801(0x1010031, float:2.3693695E-38)
                goto L12
            L32:
                int r1 = e.h.f5909u
                if (r8 != r1) goto L47
                r8 = 1109603123(0x42233333, float:40.8)
                int r8 = java.lang.Math.round(r8)
                r1 = 16842800(0x1010030, float:2.3693693E-38)
                r1 = r0
                r5 = 1
                r0 = r8
                r8 = 16842800(0x1010030, float:2.3693693E-38)
                goto L50
            L47:
                int r1 = e.h.f5903l
                if (r8 != r1) goto L4c
                goto L2d
            L4c:
                r1 = r0
                r8 = 0
                r0 = -1
                r5 = 0
            L50:
                if (r5 == 0) goto L67
                android.graphics.drawable.Drawable r9 = r9.mutate()
                int r7 = androidx.appcompat.widget.Z.c(r7, r8)
                android.graphics.PorterDuffColorFilter r7 = androidx.appcompat.widget.C0143k.e(r7, r1)
                r9.setColorFilter(r7)
                if (r0 == r4) goto L66
                r9.setAlpha(r0)
            L66:
                return r2
            L67:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0143k.a.b(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
        }

        @Override // androidx.appcompat.widget.V.f
        public ColorStateList c(Context context, int i2) {
            if (i2 == e.h.f5904m) {
                return AbstractC0250a.a(context, e.f.e);
            }
            if (i2 == e.h.f5882I) {
                return AbstractC0250a.a(context, e.f.f5865h);
            }
            if (i2 == e.h.f5881H) {
                return k(context);
            }
            if (i2 == e.h.f5897f) {
                return j(context);
            }
            if (i2 == e.h.f5894b) {
                return g(context);
            }
            if (i2 == e.h.e) {
                return i(context);
            }
            if (i2 == e.h.f5877D || i2 == e.h.f5878E) {
                return AbstractC0250a.a(context, e.f.f5864g);
            }
            if (f(this.f2472b, i2)) {
                return Z.e(context, e.d.f5852u);
            }
            if (f(this.e, i2)) {
                return AbstractC0250a.a(context, e.f.f5862d);
            }
            if (f(this.f2475f, i2)) {
                return AbstractC0250a.a(context, e.f.f5861c);
            }
            if (i2 == e.h.f5874A) {
                return AbstractC0250a.a(context, e.f.f5863f);
            }
            return null;
        }

        @Override // androidx.appcompat.widget.V.f
        public boolean d(Context context, int i2, Drawable drawable) {
            if (i2 == e.h.f5876C) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.background);
                int i3 = e.d.f5852u;
                m(drawableFindDrawableByLayerId, Z.c(context, i3), C0143k.f2468b);
                m(layerDrawable.findDrawableByLayerId(R.id.secondaryProgress), Z.c(context, i3), C0143k.f2468b);
                m(layerDrawable.findDrawableByLayerId(R.id.progress), Z.c(context, e.d.s), C0143k.f2468b);
                return true;
            }
            if (i2 != e.h.f5913y && i2 != e.h.f5912x && i2 != e.h.f5914z) {
                return false;
            }
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            m(layerDrawable2.findDrawableByLayerId(R.id.background), Z.b(context, e.d.f5852u), C0143k.f2468b);
            Drawable drawableFindDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(R.id.secondaryProgress);
            int i4 = e.d.s;
            m(drawableFindDrawableByLayerId2, Z.c(context, i4), C0143k.f2468b);
            m(layerDrawable2.findDrawableByLayerId(R.id.progress), Z.c(context, i4), C0143k.f2468b);
            return true;
        }

        @Override // androidx.appcompat.widget.V.f
        public PorterDuff.Mode e(int i2) {
            if (i2 == e.h.f5881H) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }
    }

    public static synchronized C0143k b() {
        try {
            if (f2469c == null) {
                h();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f2469c;
    }

    public static synchronized PorterDuffColorFilter e(int i2, PorterDuff.Mode mode) {
        return V.l(i2, mode);
    }

    public static synchronized void h() {
        if (f2469c == null) {
            C0143k c0143k = new C0143k();
            f2469c = c0143k;
            c0143k.f2470a = V.h();
            f2469c.f2470a.u(new a());
        }
    }

    static void i(Drawable drawable, b0 b0Var, int[] iArr) {
        V.w(drawable, b0Var, iArr);
    }

    public synchronized Drawable c(Context context, int i2) {
        return this.f2470a.j(context, i2);
    }

    synchronized Drawable d(Context context, int i2, boolean z2) {
        return this.f2470a.k(context, i2, z2);
    }

    synchronized ColorStateList f(Context context, int i2) {
        return this.f2470a.m(context, i2);
    }

    public synchronized void g(Context context) {
        this.f2470a.s(context);
    }
}
