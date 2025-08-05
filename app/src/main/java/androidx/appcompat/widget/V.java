package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import g.C0254a;
import h.AbstractC0259a;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class V {

    /* renamed from: i */
    private static V f2336i;

    /* renamed from: a */
    private WeakHashMap f2338a;

    /* renamed from: b */
    private androidx.collection.g f2339b;

    /* renamed from: c */
    private androidx.collection.h f2340c;

    /* renamed from: d */
    private final WeakHashMap f2341d = new WeakHashMap(0);
    private TypedValue e;

    /* renamed from: f */
    private boolean f2342f;

    /* renamed from: g */
    private f f2343g;

    /* renamed from: h */
    private static final PorterDuff.Mode f2335h = PorterDuff.Mode.SRC_IN;

    /* renamed from: j */
    private static final c f2337j = new c(6);

    static class a implements e {
        a() {
        }

        @Override // androidx.appcompat.widget.V.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return C0254a.l(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e);
                return null;
            }
        }
    }

    private static class b implements e {
        b() {
        }

        @Override // androidx.appcompat.widget.V.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return androidx.vectordrawable.graphics.drawable.b.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    private static class c extends androidx.collection.e {
        public c(int i2) {
            super(i2);
        }

        private static int h(int i2, PorterDuff.Mode mode) {
            return ((i2 + 31) * 31) + mode.hashCode();
        }

        PorterDuffColorFilter i(int i2, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter) c(Integer.valueOf(h(i2, mode)));
        }

        PorterDuffColorFilter j(int i2, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) d(Integer.valueOf(h(i2, mode)), porterDuffColorFilter);
        }
    }

    static class d implements e {
        d() {
        }

        @Override // androidx.appcompat.widget.V.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            String classAttribute = attributeSet.getClassAttribute();
            if (classAttribute != null) {
                try {
                    Drawable drawable = (Drawable) d.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor(null).newInstance(null);
                    AbstractC0259a.c(drawable, context.getResources(), xmlPullParser, attributeSet, theme);
                    return drawable;
                } catch (Exception e) {
                    Log.e("DrawableDelegate", "Exception while inflating <drawable>", e);
                }
            }
            return null;
        }
    }

    private interface e {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    public interface f {
        Drawable a(V v2, Context context, int i2);

        boolean b(Context context, int i2, Drawable drawable);

        ColorStateList c(Context context, int i2);

        boolean d(Context context, int i2, Drawable drawable);

        PorterDuff.Mode e(int i2);
    }

    private static class g implements e {
        g() {
        }

        @Override // androidx.appcompat.widget.V.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return androidx.vectordrawable.graphics.drawable.g.c(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    private void a(String str, e eVar) {
        if (this.f2339b == null) {
            this.f2339b = new androidx.collection.g();
        }
        this.f2339b.put(str, eVar);
    }

    private synchronized boolean b(Context context, long j2, Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState == null) {
                return false;
            }
            androidx.collection.d dVar = (androidx.collection.d) this.f2341d.get(context);
            if (dVar == null) {
                dVar = new androidx.collection.d();
                this.f2341d.put(context, dVar);
            }
            dVar.j(j2, new WeakReference(constantState));
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    private void c(Context context, int i2, ColorStateList colorStateList) {
        if (this.f2338a == null) {
            this.f2338a = new WeakHashMap();
        }
        androidx.collection.h hVar = (androidx.collection.h) this.f2338a.get(context);
        if (hVar == null) {
            hVar = new androidx.collection.h();
            this.f2338a.put(context, hVar);
        }
        hVar.a(i2, colorStateList);
    }

    private void d(Context context) {
        if (this.f2342f) {
            return;
        }
        this.f2342f = true;
        Drawable drawableJ = j(context, h.b.f6354a);
        if (drawableJ == null || !q(drawableJ)) {
            this.f2342f = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    private static long e(TypedValue typedValue) {
        return (typedValue.assetCookie << 32) | typedValue.data;
    }

    private Drawable f(Context context, int i2) throws Resources.NotFoundException {
        if (this.e == null) {
            this.e = new TypedValue();
        }
        TypedValue typedValue = this.e;
        context.getResources().getValue(i2, typedValue, true);
        long jE = e(typedValue);
        Drawable drawableI = i(context, jE);
        if (drawableI != null) {
            return drawableI;
        }
        f fVar = this.f2343g;
        Drawable drawableA = fVar == null ? null : fVar.a(this, context, i2);
        if (drawableA != null) {
            drawableA.setChangingConfigurations(typedValue.changingConfigurations);
            b(context, jE, drawableA);
        }
        return drawableA;
    }

    private static PorterDuffColorFilter g(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return l(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized V h() {
        try {
            if (f2336i == null) {
                V v2 = new V();
                f2336i = v2;
                p(v2);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f2336i;
    }

    private synchronized Drawable i(Context context, long j2) {
        androidx.collection.d dVar = (androidx.collection.d) this.f2341d.get(context);
        if (dVar == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) dVar.f(j2);
        if (weakReference != null) {
            Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            dVar.k(j2);
        }
        return null;
    }

    public static synchronized PorterDuffColorFilter l(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterI;
        c cVar = f2337j;
        porterDuffColorFilterI = cVar.i(i2, mode);
        if (porterDuffColorFilterI == null) {
            porterDuffColorFilterI = new PorterDuffColorFilter(i2, mode);
            cVar.j(i2, mode, porterDuffColorFilterI);
        }
        return porterDuffColorFilterI;
    }

    private ColorStateList n(Context context, int i2) {
        androidx.collection.h hVar;
        WeakHashMap weakHashMap = this.f2338a;
        if (weakHashMap == null || (hVar = (androidx.collection.h) weakHashMap.get(context)) == null) {
            return null;
        }
        return (ColorStateList) hVar.e(i2);
    }

    private static void p(V v2) {
        if (Build.VERSION.SDK_INT < 24) {
            v2.a("vector", new g());
            v2.a("animated-vector", new b());
            v2.a("animated-selector", new a());
            v2.a("drawable", new d());
        }
    }

    private static boolean q(Drawable drawable) {
        return (drawable instanceof androidx.vectordrawable.graphics.drawable.g) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    private Drawable r(Context context, int i2) throws XmlPullParserException, Resources.NotFoundException, IOException {
        int next;
        androidx.collection.g gVar = this.f2339b;
        if (gVar == null || gVar.isEmpty()) {
            return null;
        }
        androidx.collection.h hVar = this.f2340c;
        if (hVar != null) {
            String str = (String) hVar.e(i2);
            if ("appcompat_skip_skip".equals(str) || (str != null && this.f2339b.get(str) == null)) {
                return null;
            }
        } else {
            this.f2340c = new androidx.collection.h();
        }
        if (this.e == null) {
            this.e = new TypedValue();
        }
        TypedValue typedValue = this.e;
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        long jE = e(typedValue);
        Drawable drawableI = i(context, jE);
        if (drawableI != null) {
            return drawableI;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i2);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.f2340c.a(i2, name);
                e eVar = (e) this.f2339b.get(name);
                if (eVar != null) {
                    drawableI = eVar.a(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableI != null) {
                    drawableI.setChangingConfigurations(typedValue.changingConfigurations);
                    b(context, jE, drawableI);
                }
            } catch (Exception e2) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e2);
            }
        }
        if (drawableI == null) {
            this.f2340c.a(i2, "appcompat_skip_skip");
        }
        return drawableI;
    }

    private Drawable v(Context context, int i2, boolean z2, Drawable drawable) {
        ColorStateList colorStateListM = m(context, i2);
        if (colorStateListM != null) {
            Drawable drawableP = androidx.core.graphics.drawable.a.p(drawable.mutate());
            androidx.core.graphics.drawable.a.n(drawableP, colorStateListM);
            PorterDuff.Mode modeO = o(i2);
            if (modeO == null) {
                return drawableP;
            }
            androidx.core.graphics.drawable.a.o(drawableP, modeO);
            return drawableP;
        }
        f fVar = this.f2343g;
        if ((fVar == null || !fVar.d(context, i2, drawable)) && !x(context, i2, drawable) && z2) {
            return null;
        }
        return drawable;
    }

    static void w(Drawable drawable, b0 b0Var, int[] iArr) {
        int[] state = drawable.getState();
        if (drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z2 = b0Var.f2383d;
        if (z2 || b0Var.f2382c) {
            drawable.setColorFilter(g(z2 ? b0Var.f2380a : null, b0Var.f2382c ? b0Var.f2381b : f2335h, iArr));
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    public synchronized Drawable j(Context context, int i2) {
        return k(context, i2, false);
    }

    synchronized Drawable k(Context context, int i2, boolean z2) {
        Drawable drawableR;
        try {
            d(context);
            drawableR = r(context, i2);
            if (drawableR == null) {
                drawableR = f(context, i2);
            }
            if (drawableR == null) {
                drawableR = androidx.core.content.a.d(context, i2);
            }
            if (drawableR != null) {
                drawableR = v(context, i2, z2, drawableR);
            }
            if (drawableR != null) {
                M.a(drawableR);
            }
        } catch (Throwable th) {
            throw th;
        }
        return drawableR;
    }

    synchronized ColorStateList m(Context context, int i2) {
        ColorStateList colorStateListN;
        colorStateListN = n(context, i2);
        if (colorStateListN == null) {
            f fVar = this.f2343g;
            colorStateListN = fVar == null ? null : fVar.c(context, i2);
            if (colorStateListN != null) {
                c(context, i2, colorStateListN);
            }
        }
        return colorStateListN;
    }

    PorterDuff.Mode o(int i2) {
        f fVar = this.f2343g;
        if (fVar == null) {
            return null;
        }
        return fVar.e(i2);
    }

    public synchronized void s(Context context) {
        androidx.collection.d dVar = (androidx.collection.d) this.f2341d.get(context);
        if (dVar != null) {
            dVar.b();
        }
    }

    synchronized Drawable t(Context context, n0 n0Var, int i2) {
        try {
            Drawable drawableR = r(context, i2);
            if (drawableR == null) {
                drawableR = n0Var.a(i2);
            }
            if (drawableR == null) {
                return null;
            }
            return v(context, i2, false, drawableR);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void u(f fVar) {
        this.f2343g = fVar;
    }

    boolean x(Context context, int i2, Drawable drawable) {
        f fVar = this.f2343g;
        return fVar != null && fVar.b(context, i2, drawable);
    }
}
