package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.view.b;
import androidx.appcompat.view.f;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.C0143k;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.K;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.d0;
import androidx.appcompat.widget.n0;
import androidx.appcompat.widget.o0;
import androidx.core.content.res.h;
import androidx.core.view.AbstractC0177u;
import androidx.core.view.AbstractC0178v;
import androidx.core.view.M;
import androidx.core.view.V;
import androidx.core.view.X;
import androidx.core.view.Z;
import androidx.lifecycle.AbstractC0203h;
import defpackage.e;
import f.AbstractC0250a;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;
import v.AbstractC0340c;

/* loaded from: classes.dex */
class h extends AbstractC0131f implements e.a, LayoutInflater.Factory2 {

    /* renamed from: j0, reason: collision with root package name */
    private static final androidx.collection.g f1722j0 = new androidx.collection.g();

    /* renamed from: k0, reason: collision with root package name */
    private static final boolean f1723k0 = false;

    /* renamed from: l0, reason: collision with root package name */
    private static final int[] f1724l0 = {R.attr.windowBackground};

    /* renamed from: m0, reason: collision with root package name */
    private static final boolean f1725m0 = !"robolectric".equals(Build.FINGERPRINT);

    /* renamed from: A, reason: collision with root package name */
    private boolean f1726A;

    /* renamed from: B, reason: collision with root package name */
    ViewGroup f1727B;

    /* renamed from: C, reason: collision with root package name */
    private TextView f1728C;

    /* renamed from: D, reason: collision with root package name */
    private View f1729D;

    /* renamed from: E, reason: collision with root package name */
    private boolean f1730E;

    /* renamed from: F, reason: collision with root package name */
    private boolean f1731F;

    /* renamed from: G, reason: collision with root package name */
    boolean f1732G;

    /* renamed from: H, reason: collision with root package name */
    boolean f1733H;

    /* renamed from: I, reason: collision with root package name */
    boolean f1734I;

    /* renamed from: J, reason: collision with root package name */
    boolean f1735J;

    /* renamed from: K, reason: collision with root package name */
    boolean f1736K;

    /* renamed from: L, reason: collision with root package name */
    private boolean f1737L;

    /* renamed from: M, reason: collision with root package name */
    private q[] f1738M;

    /* renamed from: N, reason: collision with root package name */
    private q f1739N;

    /* renamed from: O, reason: collision with root package name */
    private boolean f1740O;

    /* renamed from: P, reason: collision with root package name */
    private boolean f1741P;

    /* renamed from: Q, reason: collision with root package name */
    private boolean f1742Q;

    /* renamed from: R, reason: collision with root package name */
    boolean f1743R;

    /* renamed from: S, reason: collision with root package name */
    private Configuration f1744S;

    /* renamed from: T, reason: collision with root package name */
    private int f1745T;

    /* renamed from: U, reason: collision with root package name */
    private int f1746U;

    /* renamed from: V, reason: collision with root package name */
    private int f1747V;

    /* renamed from: W, reason: collision with root package name */
    private boolean f1748W;

    /* renamed from: X, reason: collision with root package name */
    private n f1749X;

    /* renamed from: Y, reason: collision with root package name */
    private n f1750Y;

    /* renamed from: Z, reason: collision with root package name */
    boolean f1751Z;

    /* renamed from: a0, reason: collision with root package name */
    int f1752a0;

    /* renamed from: b0, reason: collision with root package name */
    private final Runnable f1753b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f1754c0;

    /* renamed from: d0, reason: collision with root package name */
    private Rect f1755d0;

    /* renamed from: e0, reason: collision with root package name */
    private Rect f1756e0;

    /* renamed from: f0, reason: collision with root package name */
    private y f1757f0;

    /* renamed from: g0, reason: collision with root package name */
    private A f1758g0;

    /* renamed from: h0, reason: collision with root package name */
    private OnBackInvokedDispatcher f1759h0;

    /* renamed from: i0, reason: collision with root package name */
    private OnBackInvokedCallback f1760i0;

    /* renamed from: j, reason: collision with root package name */
    final Object f1761j;

    /* renamed from: k, reason: collision with root package name */
    final Context f1762k;

    /* renamed from: l, reason: collision with root package name */
    Window f1763l;

    /* renamed from: m, reason: collision with root package name */
    private l f1764m;

    /* renamed from: n, reason: collision with root package name */
    final InterfaceC0129d f1765n;
    AbstractC0126a o;

    /* renamed from: p, reason: collision with root package name */
    MenuInflater f1766p;

    /* renamed from: q, reason: collision with root package name */
    private CharSequence f1767q;
    private K r;
    private f s;

    /* renamed from: t, reason: collision with root package name */
    private r f1768t;

    /* renamed from: u, reason: collision with root package name */
    androidx.appcompat.view.b f1769u;

    /* renamed from: v, reason: collision with root package name */
    ActionBarContextView f1770v;

    /* renamed from: w, reason: collision with root package name */
    PopupWindow f1771w;

    /* renamed from: x, reason: collision with root package name */
    Runnable f1772x;

    /* renamed from: y, reason: collision with root package name */
    V f1773y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f1774z;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            if ((hVar.f1752a0 & 1) != 0) {
                hVar.g0(0);
            }
            h hVar2 = h.this;
            if ((hVar2.f1752a0 & 4096) != 0) {
                hVar2.g0(108);
            }
            h hVar3 = h.this;
            hVar3.f1751Z = false;
            hVar3.f1752a0 = 0;
        }
    }

    class b implements androidx.core.view.F {
        b() {
        }

        @Override // androidx.core.view.F
        public Z a(View view, Z z2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            int iK = z2.k();
            int iD1 = h.this.d1(z2, null);
            if (iK != iD1) {
                z2 = z2.o(z2.i(), iD1, z2.j(), z2.h());
            }
            return M.W(view, z2);
        }
    }

    class c implements ContentFrameLayout.a {
        c() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void a() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void onDetachedFromWindow() {
            h.this.e0();
        }
    }

    class d implements Runnable {

        class a extends X {
            a() {
            }

            @Override // androidx.core.view.W
            public void a(View view) {
                h.this.f1770v.setAlpha(1.0f);
                h.this.f1773y.h(null);
                h.this.f1773y = null;
            }

            @Override // androidx.core.view.X, androidx.core.view.W
            public void b(View view) {
                h.this.f1770v.setVisibility(0);
            }
        }

        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            hVar.f1771w.showAtLocation(hVar.f1770v, 55, 0, 0);
            h.this.h0();
            if (!h.this.S0()) {
                h.this.f1770v.setAlpha(1.0f);
                h.this.f1770v.setVisibility(0);
            } else {
                h.this.f1770v.setAlpha(0.0f);
                h hVar2 = h.this;
                hVar2.f1773y = M.c(hVar2.f1770v).b(1.0f);
                h.this.f1773y.h(new a());
            }
        }
    }

    class e extends X {
        e() {
        }

        @Override // androidx.core.view.W
        public void a(View view) {
            h.this.f1770v.setAlpha(1.0f);
            h.this.f1773y.h(null);
            h.this.f1773y = null;
        }

        @Override // androidx.core.view.X, androidx.core.view.W
        public void b(View view) {
            h.this.f1770v.setVisibility(0);
            if (h.this.f1770v.getParent() instanceof View) {
                M.c0((View) h.this.f1770v.getParent());
            }
        }
    }

    private final class f implements j.a {
        f() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public void a(androidx.appcompat.view.menu.e eVar, boolean z2) {
            h.this.X(eVar);
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean b(androidx.appcompat.view.menu.e eVar) {
            Window.Callback callbackT0 = h.this.t0();
            if (callbackT0 == null) {
                return true;
            }
            callbackT0.onMenuOpened(108, eVar);
            return true;
        }
    }

    class g implements b.a {

        /* renamed from: a, reason: collision with root package name */
        private b.a f1782a;

        class a extends X {
            a() {
            }

            @Override // androidx.core.view.W
            public void a(View view) {
                h.this.f1770v.setVisibility(8);
                h hVar = h.this;
                PopupWindow popupWindow = hVar.f1771w;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (hVar.f1770v.getParent() instanceof View) {
                    M.c0((View) h.this.f1770v.getParent());
                }
                h.this.f1770v.k();
                h.this.f1773y.h(null);
                h hVar2 = h.this;
                hVar2.f1773y = null;
                M.c0(hVar2.f1727B);
            }
        }

        public g(b.a aVar) {
            this.f1782a = aVar;
        }

        @Override // androidx.appcompat.view.b.a
        public boolean a(androidx.appcompat.view.b bVar, Menu menu) {
            M.c0(h.this.f1727B);
            return this.f1782a.a(bVar, menu);
        }

        @Override // androidx.appcompat.view.b.a
        public boolean b(androidx.appcompat.view.b bVar, MenuItem menuItem) {
            return this.f1782a.b(bVar, menuItem);
        }

        @Override // androidx.appcompat.view.b.a
        public boolean c(androidx.appcompat.view.b bVar, Menu menu) {
            return this.f1782a.c(bVar, menu);
        }

        @Override // androidx.appcompat.view.b.a
        public void d(androidx.appcompat.view.b bVar) {
            this.f1782a.d(bVar);
            h hVar = h.this;
            if (hVar.f1771w != null) {
                hVar.f1763l.getDecorView().removeCallbacks(h.this.f1772x);
            }
            h hVar2 = h.this;
            if (hVar2.f1770v != null) {
                hVar2.h0();
                h hVar3 = h.this;
                hVar3.f1773y = M.c(hVar3.f1770v).b(0.0f);
                h.this.f1773y.h(new a());
            }
            h hVar4 = h.this;
            InterfaceC0129d interfaceC0129d = hVar4.f1765n;
            if (interfaceC0129d != null) {
                interfaceC0129d.R(hVar4.f1769u);
            }
            h hVar5 = h.this;
            hVar5.f1769u = null;
            M.c0(hVar5.f1727B);
            h.this.b1();
        }
    }

    /* renamed from: androidx.appcompat.app.h$h, reason: collision with other inner class name */
    static class C0017h {
        static boolean a(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }

        static String b(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    static class i {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (locales.equals(locales2)) {
                return;
            }
            configuration3.setLocales(locales2);
            configuration3.locale = configuration2.locale;
        }

        static androidx.core.os.e b(Configuration configuration) {
            return androidx.core.os.e.c(configuration.getLocales().toLanguageTags());
        }

        public static void c(androidx.core.os.e eVar) {
            LocaleList.setDefault(LocaleList.forLanguageTags(eVar.h()));
        }

        static void d(Configuration configuration, androidx.core.os.e eVar) {
            configuration.setLocales(LocaleList.forLanguageTags(eVar.h()));
        }
    }

    static class j {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            if ((configuration.colorMode & 3) != (configuration2.colorMode & 3)) {
                configuration3.colorMode |= configuration2.colorMode & 3;
            }
            if ((configuration.colorMode & 12) != (configuration2.colorMode & 12)) {
                configuration3.colorMode |= configuration2.colorMode & 12;
            }
        }
    }

    static class k {
        static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }

        static OnBackInvokedCallback b(Object obj, final h hVar) {
            Objects.requireNonNull(hVar);
            OnBackInvokedCallback onBackInvokedCallback = new OnBackInvokedCallback() { // from class: androidx.appcompat.app.v
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    hVar.B0();
                }
            };
            androidx.appcompat.app.r.a(obj).registerOnBackInvokedCallback(1000000, onBackInvokedCallback);
            return onBackInvokedCallback;
        }

        static void c(Object obj, Object obj2) {
            androidx.appcompat.app.r.a(obj).unregisterOnBackInvokedCallback(androidx.appcompat.app.q.a(obj2));
        }
    }

    private class m extends n {

        /* renamed from: c, reason: collision with root package name */
        private final PowerManager f1788c;

        m(Context context) {
            super();
            this.f1788c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.h.n
        IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.h.n
        public int c() {
            return C0017h.a(this.f1788c) ? 2 : 1;
        }

        @Override // androidx.appcompat.app.h.n
        public void d() {
            h.this.R();
        }
    }

    abstract class n {

        /* renamed from: a, reason: collision with root package name */
        private BroadcastReceiver f1790a;

        class a extends BroadcastReceiver {
            a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                n.this.d();
            }
        }

        n() {
        }

        void a() {
            BroadcastReceiver broadcastReceiver = this.f1790a;
            if (broadcastReceiver != null) {
                try {
                    h.this.f1762k.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f1790a = null;
            }
        }

        abstract IntentFilter b();

        abstract int c();

        abstract void d();

        void e() {
            a();
            IntentFilter intentFilterB = b();
            if (intentFilterB == null || intentFilterB.countActions() == 0) {
                return;
            }
            if (this.f1790a == null) {
                this.f1790a = new a();
            }
            h.this.f1762k.registerReceiver(this.f1790a, intentFilterB);
        }
    }

    private class o extends n {

        /* renamed from: c, reason: collision with root package name */
        private final E f1793c;

        o(E e) {
            super();
            this.f1793c = e;
        }

        @Override // androidx.appcompat.app.h.n
        IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.h.n
        public int c() {
            return this.f1793c.d() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.h.n
        public void d() {
            h.this.R();
        }
    }

    private class p extends ContentFrameLayout {
        public p(Context context) {
            super(context);
        }

        private boolean b(int i2, int i3) {
            return i2 < -5 || i3 < -5 || i2 > getWidth() + 5 || i3 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return h.this.f0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !b((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            h.this.Z(0);
            return true;
        }

        @Override // android.view.View
        public void setBackgroundResource(int i2) {
            setBackgroundDrawable(AbstractC0250a.b(getContext(), i2));
        }
    }

    protected static final class q {

        /* renamed from: a, reason: collision with root package name */
        int f1796a;

        /* renamed from: b, reason: collision with root package name */
        int f1797b;

        /* renamed from: c, reason: collision with root package name */
        int f1798c;

        /* renamed from: d, reason: collision with root package name */
        int f1799d;
        int e;

        /* renamed from: f, reason: collision with root package name */
        int f1800f;

        /* renamed from: g, reason: collision with root package name */
        ViewGroup f1801g;

        /* renamed from: h, reason: collision with root package name */
        View f1802h;

        /* renamed from: i, reason: collision with root package name */
        View f1803i;

        /* renamed from: j, reason: collision with root package name */
        androidx.appcompat.view.menu.e f1804j;

        /* renamed from: k, reason: collision with root package name */
        androidx.appcompat.view.menu.c f1805k;

        /* renamed from: l, reason: collision with root package name */
        Context f1806l;

        /* renamed from: m, reason: collision with root package name */
        boolean f1807m;

        /* renamed from: n, reason: collision with root package name */
        boolean f1808n;
        boolean o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f1809p;

        /* renamed from: q, reason: collision with root package name */
        boolean f1810q = false;
        boolean r;
        Bundle s;

        q(int i2) {
            this.f1796a = i2;
        }

        androidx.appcompat.view.menu.k a(j.a aVar) {
            if (this.f1804j == null) {
                return null;
            }
            if (this.f1805k == null) {
                androidx.appcompat.view.menu.c cVar = new androidx.appcompat.view.menu.c(this.f1806l, e.j.f5951j);
                this.f1805k = cVar;
                cVar.h(aVar);
                this.f1804j.b(this.f1805k);
            }
            return this.f1805k.f(this.f1801g);
        }

        public boolean b() {
            if (this.f1802h == null) {
                return false;
            }
            return this.f1803i != null || this.f1805k.b().getCount() > 0;
        }

        void c(androidx.appcompat.view.menu.e eVar) {
            androidx.appcompat.view.menu.c cVar;
            androidx.appcompat.view.menu.e eVar2 = this.f1804j;
            if (eVar == eVar2) {
                return;
            }
            if (eVar2 != null) {
                eVar2.P(this.f1805k);
            }
            this.f1804j = eVar;
            if (eVar == null || (cVar = this.f1805k) == null) {
                return;
            }
            eVar.b(cVar);
        }

        void d(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme themeNewTheme = context.getResources().newTheme();
            themeNewTheme.setTo(context.getTheme());
            themeNewTheme.resolveAttribute(e.d.f5836a, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                themeNewTheme.applyStyle(i2, true);
            }
            themeNewTheme.resolveAttribute(e.d.f5829B, typedValue, true);
            int i3 = typedValue.resourceId;
            if (i3 != 0) {
                themeNewTheme.applyStyle(i3, true);
            } else {
                themeNewTheme.applyStyle(e.l.f5969b, true);
            }
            androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, 0);
            dVar.getTheme().setTo(themeNewTheme);
            this.f1806l = dVar;
            TypedArray typedArrayObtainStyledAttributes = dVar.obtainStyledAttributes(e.m.f6090y0);
            this.f1797b = typedArrayObtainStyledAttributes.getResourceId(e.m.f5975B0, 0);
            this.f1800f = typedArrayObtainStyledAttributes.getResourceId(e.m.f5973A0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private final class r implements j.a {
        r() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public void a(androidx.appcompat.view.menu.e eVar, boolean z2) {
            androidx.appcompat.view.menu.e eVarD = eVar.D();
            boolean z3 = eVarD != eVar;
            h hVar = h.this;
            if (z3) {
                eVar = eVarD;
            }
            q qVarK0 = hVar.k0(eVar);
            if (qVarK0 != null) {
                if (!z3) {
                    h.this.a0(qVarK0, z2);
                } else {
                    h.this.W(qVarK0.f1796a, qVarK0, eVarD);
                    h.this.a0(qVarK0, true);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean b(androidx.appcompat.view.menu.e eVar) {
            Window.Callback callbackT0;
            if (eVar != eVar.D()) {
                return true;
            }
            h hVar = h.this;
            if (!hVar.f1732G || (callbackT0 = hVar.t0()) == null || h.this.f1743R) {
                return true;
            }
            callbackT0.onMenuOpened(108, eVar);
            return true;
        }
    }

    h(Activity activity, InterfaceC0129d interfaceC0129d) {
        this(activity, null, interfaceC0129d, activity);
    }

    private boolean D0(int i2, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        q qVarR0 = r0(i2, true);
        if (qVarR0.o) {
            return false;
        }
        return N0(qVarR0, keyEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean G0(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            androidx.appcompat.view.b r0 = r4.f1769u
            r1 = 0
            if (r0 == 0) goto L6
            return r1
        L6:
            r0 = 1
            androidx.appcompat.app.h$q r2 = r4.r0(r5, r0)
            if (r5 != 0) goto L43
            androidx.appcompat.widget.K r5 = r4.r
            if (r5 == 0) goto L43
            boolean r5 = r5.g()
            if (r5 == 0) goto L43
            android.content.Context r5 = r4.f1762k
            android.view.ViewConfiguration r5 = android.view.ViewConfiguration.get(r5)
            boolean r5 = r5.hasPermanentMenuKey()
            if (r5 != 0) goto L43
            androidx.appcompat.widget.K r5 = r4.r
            boolean r5 = r5.c()
            if (r5 != 0) goto L3c
            boolean r5 = r4.f1743R
            if (r5 != 0) goto L62
            boolean r5 = r4.N0(r2, r6)
            if (r5 == 0) goto L62
            androidx.appcompat.widget.K r5 = r4.r
            boolean r0 = r5.e()
            goto L68
        L3c:
            androidx.appcompat.widget.K r5 = r4.r
            boolean r0 = r5.d()
            goto L68
        L43:
            boolean r5 = r2.o
            if (r5 != 0) goto L64
            boolean r3 = r2.f1808n
            if (r3 == 0) goto L4c
            goto L64
        L4c:
            boolean r5 = r2.f1807m
            if (r5 == 0) goto L62
            boolean r5 = r2.r
            if (r5 == 0) goto L5b
            r2.f1807m = r1
            boolean r5 = r4.N0(r2, r6)
            goto L5c
        L5b:
            r5 = 1
        L5c:
            if (r5 == 0) goto L62
            r4.K0(r2, r6)
            goto L68
        L62:
            r0 = 0
            goto L68
        L64:
            r4.a0(r2, r0)
            r0 = r5
        L68:
            if (r0 == 0) goto L85
            android.content.Context r5 = r4.f1762k
            android.content.Context r5 = r5.getApplicationContext()
            java.lang.String r6 = "audio"
            java.lang.Object r5 = r5.getSystemService(r6)
            android.media.AudioManager r5 = (android.media.AudioManager) r5
            if (r5 == 0) goto L7e
            r5.playSoundEffect(r1)
            goto L85
        L7e:
            java.lang.String r5 = "AppCompatDelegate"
            java.lang.String r6 = "Couldn't get audio manager"
            android.util.Log.w(r5, r6)
        L85:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.h.G0(int, android.view.KeyEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void K0(androidx.appcompat.app.h.q r12, android.view.KeyEvent r13) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.h.K0(androidx.appcompat.app.h$q, android.view.KeyEvent):void");
    }

    private boolean M0(q qVar, int i2, KeyEvent keyEvent, int i3) {
        androidx.appcompat.view.menu.e eVar;
        boolean zPerformShortcut = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((qVar.f1807m || N0(qVar, keyEvent)) && (eVar = qVar.f1804j) != null) {
            zPerformShortcut = eVar.performShortcut(i2, keyEvent, i3);
        }
        if (zPerformShortcut && (i3 & 1) == 0 && this.r == null) {
            a0(qVar, true);
        }
        return zPerformShortcut;
    }

    private boolean N0(q qVar, KeyEvent keyEvent) {
        K k2;
        K k3;
        K k4;
        if (this.f1743R) {
            return false;
        }
        if (qVar.f1807m) {
            return true;
        }
        q qVar2 = this.f1739N;
        if (qVar2 != null && qVar2 != qVar) {
            a0(qVar2, false);
        }
        Window.Callback callbackT0 = t0();
        if (callbackT0 != null) {
            qVar.f1803i = callbackT0.onCreatePanelView(qVar.f1796a);
        }
        int i2 = qVar.f1796a;
        boolean z2 = i2 == 0 || i2 == 108;
        if (z2 && (k4 = this.r) != null) {
            k4.f();
        }
        if (qVar.f1803i == null) {
            if (z2) {
                L0();
            }
            androidx.appcompat.view.menu.e eVar = qVar.f1804j;
            if (eVar == null || qVar.r) {
                if (eVar == null && (!x0(qVar) || qVar.f1804j == null)) {
                    return false;
                }
                if (z2 && this.r != null) {
                    if (this.s == null) {
                        this.s = new f();
                    }
                    this.r.a(qVar.f1804j, this.s);
                }
                qVar.f1804j.e0();
                if (!callbackT0.onCreatePanelMenu(qVar.f1796a, qVar.f1804j)) {
                    qVar.c(null);
                    if (z2 && (k2 = this.r) != null) {
                        k2.a(null, this.s);
                    }
                    return false;
                }
                qVar.r = false;
            }
            qVar.f1804j.e0();
            Bundle bundle = qVar.s;
            if (bundle != null) {
                qVar.f1804j.Q(bundle);
                qVar.s = null;
            }
            if (!callbackT0.onPreparePanel(0, qVar.f1803i, qVar.f1804j)) {
                if (z2 && (k3 = this.r) != null) {
                    k3.a(null, this.s);
                }
                qVar.f1804j.d0();
                return false;
            }
            boolean z3 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            qVar.f1809p = z3;
            qVar.f1804j.setQwertyMode(z3);
            qVar.f1804j.d0();
        }
        qVar.f1807m = true;
        qVar.f1808n = false;
        this.f1739N = qVar;
        return true;
    }

    private void O0(boolean z2) {
        K k2 = this.r;
        if (k2 == null || !k2.g() || (ViewConfiguration.get(this.f1762k).hasPermanentMenuKey() && !this.r.b())) {
            q qVarR0 = r0(0, true);
            qVarR0.f1810q = true;
            a0(qVarR0, false);
            K0(qVarR0, null);
            return;
        }
        Window.Callback callbackT0 = t0();
        if (this.r.c() && z2) {
            this.r.d();
            if (this.f1743R) {
                return;
            }
            callbackT0.onPanelClosed(108, r0(0, true).f1804j);
            return;
        }
        if (callbackT0 == null || this.f1743R) {
            return;
        }
        if (this.f1751Z && (this.f1752a0 & 1) != 0) {
            this.f1763l.getDecorView().removeCallbacks(this.f1753b0);
            this.f1753b0.run();
        }
        q qVarR02 = r0(0, true);
        androidx.appcompat.view.menu.e eVar = qVarR02.f1804j;
        if (eVar == null || qVarR02.r || !callbackT0.onPreparePanel(0, qVarR02.f1803i, eVar)) {
            return;
        }
        callbackT0.onMenuOpened(108, qVarR02.f1804j);
        this.r.e();
    }

    private boolean P(boolean z2) {
        return Q(z2, true);
    }

    private int P0(int i2) {
        if (i2 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (i2 != 9) {
            return i2;
        }
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    }

    private boolean Q(boolean z2, boolean z3) throws IllegalAccessException, NoSuchFieldException, PackageManager.NameNotFoundException, SecurityException, IllegalArgumentException {
        if (this.f1743R) {
            return false;
        }
        int iV = V();
        int iA0 = A0(this.f1762k, iV);
        androidx.core.os.e eVarU = Build.VERSION.SDK_INT < 33 ? U(this.f1762k) : null;
        if (!z3 && eVarU != null) {
            eVarU = q0(this.f1762k.getResources().getConfiguration());
        }
        boolean zA1 = a1(iA0, eVarU, z2);
        if (iV == 0) {
            p0(this.f1762k).e();
        } else {
            n nVar = this.f1749X;
            if (nVar != null) {
                nVar.a();
            }
        }
        if (iV == 3) {
            o0(this.f1762k).e();
        } else {
            n nVar2 = this.f1750Y;
            if (nVar2 != null) {
                nVar2.a();
            }
        }
        return zA1;
    }

    private void S() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f1727B.findViewById(R.id.content);
        View decorView = this.f1763l.getDecorView();
        contentFrameLayout.a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray typedArrayObtainStyledAttributes = this.f1762k.obtainStyledAttributes(e.m.f6090y0);
        typedArrayObtainStyledAttributes.getValue(e.m.f5993K0, contentFrameLayout.getMinWidthMajor());
        typedArrayObtainStyledAttributes.getValue(e.m.f5995L0, contentFrameLayout.getMinWidthMinor());
        int i2 = e.m.f5989I0;
        if (typedArrayObtainStyledAttributes.hasValue(i2)) {
            typedArrayObtainStyledAttributes.getValue(i2, contentFrameLayout.getFixedWidthMajor());
        }
        int i3 = e.m.f5991J0;
        if (typedArrayObtainStyledAttributes.hasValue(i3)) {
            typedArrayObtainStyledAttributes.getValue(i3, contentFrameLayout.getFixedWidthMinor());
        }
        int i4 = e.m.f5985G0;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            typedArrayObtainStyledAttributes.getValue(i4, contentFrameLayout.getFixedHeightMajor());
        }
        int i5 = e.m.f5987H0;
        if (typedArrayObtainStyledAttributes.hasValue(i5)) {
            typedArrayObtainStyledAttributes.getValue(i5, contentFrameLayout.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private void T(Window window) {
        if (this.f1763l != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof l) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        l lVar = new l(callback);
        this.f1764m = lVar;
        window.setCallback(lVar);
        d0 d0VarT = d0.t(this.f1762k, null, f1724l0);
        Drawable drawableG = d0VarT.g(0);
        if (drawableG != null) {
            window.setBackgroundDrawable(drawableG);
        }
        d0VarT.w();
        this.f1763l = window;
        if (Build.VERSION.SDK_INT < 33 || this.f1759h0 != null) {
            return;
        }
        K(null);
    }

    private boolean T0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f1763l.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || ((View) viewParent).isAttachedToWindow()) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private int V() {
        int i2 = this.f1745T;
        return i2 != -100 ? i2 : AbstractC0131f.m();
    }

    private void X0() {
        if (this.f1726A) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private void Y() {
        n nVar = this.f1749X;
        if (nVar != null) {
            nVar.a();
        }
        n nVar2 = this.f1750Y;
        if (nVar2 != null) {
            nVar2.a();
        }
    }

    private AbstractActivityC0128c Y0() {
        for (Context baseContext = this.f1762k; baseContext != null; baseContext = ((ContextWrapper) baseContext).getBaseContext()) {
            if (baseContext instanceof AbstractActivityC0128c) {
                return (AbstractActivityC0128c) baseContext;
            }
            if (!(baseContext instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void Z0(Configuration configuration) {
        Activity activity = (Activity) this.f1761j;
        if (activity instanceof androidx.lifecycle.m) {
            if (((androidx.lifecycle.m) activity).getLifecycle().b().b(AbstractC0203h.b.CREATED)) {
                activity.onConfigurationChanged(configuration);
            }
        } else {
            if (!this.f1742Q || this.f1743R) {
                return;
            }
            activity.onConfigurationChanged(configuration);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a1(int r10, androidx.core.os.e r11, boolean r12) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, android.content.pm.PackageManager.NameNotFoundException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        /*
            r9 = this;
            android.content.Context r1 = r9.f1762k
            r4 = 0
            r5 = 0
            r0 = r9
            r2 = r10
            r3 = r11
            android.content.res.Configuration r0 = r0.b0(r1, r2, r3, r4, r5)
            android.content.Context r1 = r9.f1762k
            int r1 = r9.n0(r1)
            android.content.res.Configuration r2 = r9.f1744S
            if (r2 != 0) goto L1f
            android.content.Context r2 = r9.f1762k
            android.content.res.Resources r2 = r2.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
        L1f:
            int r3 = r2.uiMode
            r3 = r3 & 48
            int r4 = r0.uiMode
            r4 = r4 & 48
            androidx.core.os.e r2 = r9.q0(r2)
            r5 = 0
            if (r11 != 0) goto L30
            r6 = r5
            goto L34
        L30:
            androidx.core.os.e r6 = r9.q0(r0)
        L34:
            r7 = 0
            if (r3 == r4) goto L3a
            r3 = 512(0x200, float:7.17E-43)
            goto L3b
        L3a:
            r3 = 0
        L3b:
            if (r6 == 0) goto L45
            boolean r2 = r2.equals(r6)
            if (r2 != 0) goto L45
            r3 = r3 | 8196(0x2004, float:1.1485E-41)
        L45:
            int r2 = ~r1
            r2 = r2 & r3
            r8 = 1
            if (r2 == 0) goto L8c
            if (r12 == 0) goto L8c
            boolean r12 = r9.f1741P
            if (r12 == 0) goto L8c
            boolean r12 = androidx.appcompat.app.h.f1725m0
            if (r12 != 0) goto L58
            boolean r12 = r9.f1742Q
            if (r12 == 0) goto L8c
        L58:
            java.lang.Object r12 = r9.f1761j
            boolean r2 = r12 instanceof android.app.Activity
            if (r2 == 0) goto L8c
            android.app.Activity r12 = (android.app.Activity) r12
            boolean r12 = r12.isChild()
            if (r12 != 0) goto L8c
            int r12 = android.os.Build.VERSION.SDK_INT
            r2 = 31
            if (r12 < r2) goto L83
            r12 = r3 & 8192(0x2000, float:1.148E-41)
            if (r12 == 0) goto L83
            java.lang.Object r12 = r9.f1761j
            android.app.Activity r12 = (android.app.Activity) r12
            android.view.Window r12 = r12.getWindow()
            android.view.View r12 = r12.getDecorView()
            int r0 = r0.getLayoutDirection()
            r12.setLayoutDirection(r0)
        L83:
            java.lang.Object r12 = r9.f1761j
            android.app.Activity r12 = (android.app.Activity) r12
            androidx.core.app.b.l(r12)
            r12 = 1
            goto L8d
        L8c:
            r12 = 0
        L8d:
            if (r12 != 0) goto L9a
            if (r3 == 0) goto L9a
            r12 = r3 & r1
            if (r12 != r3) goto L96
            r7 = 1
        L96:
            r9.c1(r4, r6, r7, r5)
            goto L9b
        L9a:
            r8 = r12
        L9b:
            if (r8 == 0) goto Lb7
            java.lang.Object r12 = r9.f1761j
            boolean r0 = r12 instanceof androidx.appcompat.app.AbstractActivityC0128c
            if (r0 == 0) goto Lb7
            r0 = r3 & 512(0x200, float:7.17E-43)
            if (r0 == 0) goto Lac
            androidx.appcompat.app.c r12 = (androidx.appcompat.app.AbstractActivityC0128c) r12
            r12.d1(r10)
        Lac:
            r10 = r3 & 4
            if (r10 == 0) goto Lb7
            java.lang.Object r10 = r9.f1761j
            androidx.appcompat.app.c r10 = (androidx.appcompat.app.AbstractActivityC0128c) r10
            r10.c1(r11)
        Lb7:
            if (r6 == 0) goto Lca
            android.content.Context r10 = r9.f1762k
            android.content.res.Resources r10 = r10.getResources()
            android.content.res.Configuration r10 = r10.getConfiguration()
            androidx.core.os.e r10 = r9.q0(r10)
            r9.R0(r10)
        Lca:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.h.a1(int, androidx.core.os.e, boolean):boolean");
    }

    private Configuration b0(Context context, int i2, androidx.core.os.e eVar, Configuration configuration, boolean z2) {
        int i3 = i2 != 1 ? i2 != 2 ? z2 ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i3 | (configuration2.uiMode & (-49));
        if (eVar != null) {
            Q0(configuration2, eVar);
        }
        return configuration2;
    }

    private ViewGroup c0() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        ViewGroup viewGroup;
        TypedArray typedArrayObtainStyledAttributes = this.f1762k.obtainStyledAttributes(e.m.f6090y0);
        int i2 = e.m.f5979D0;
        if (!typedArrayObtainStyledAttributes.hasValue(i2)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(e.m.f5997M0, false)) {
            G(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(i2, false)) {
            G(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(e.m.f5981E0, false)) {
            G(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(e.m.f5983F0, false)) {
            G(10);
        }
        this.f1735J = typedArrayObtainStyledAttributes.getBoolean(e.m.f6092z0, false);
        typedArrayObtainStyledAttributes.recycle();
        j0();
        this.f1763l.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f1762k);
        if (this.f1736K) {
            viewGroup = this.f1734I ? (ViewGroup) layoutInflaterFrom.inflate(e.j.o, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(e.j.f5955n, (ViewGroup) null);
        } else if (this.f1735J) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(e.j.f5947f, (ViewGroup) null);
            this.f1733H = false;
            this.f1732G = false;
        } else if (this.f1732G) {
            TypedValue typedValue = new TypedValue();
            this.f1762k.getTheme().resolveAttribute(e.d.f5839d, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new androidx.appcompat.view.d(this.f1762k, typedValue.resourceId) : this.f1762k).inflate(e.j.f5956p, (ViewGroup) null);
            K k2 = (K) viewGroup.findViewById(e.i.f5934p);
            this.r = k2;
            k2.setWindowCallback(t0());
            if (this.f1733H) {
                this.r.k(109);
            }
            if (this.f1730E) {
                this.r.k(2);
            }
            if (this.f1731F) {
                this.r.k(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f1732G + ", windowActionBarOverlay: " + this.f1733H + ", android:windowIsFloating: " + this.f1735J + ", windowActionModeOverlay: " + this.f1734I + ", windowNoTitle: " + this.f1736K + " }");
        }
        M.s0(viewGroup, new b());
        if (this.r == null) {
            this.f1728C = (TextView) viewGroup.findViewById(e.i.f5917C);
        }
        o0.c(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(e.i.f5922b);
        ViewGroup viewGroup2 = (ViewGroup) this.f1763l.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.f1763l.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new c());
        return viewGroup;
    }

    private void c1(int i2, androidx.core.os.e eVar, boolean z2, Configuration configuration) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Resources resources = this.f1762k.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i2 | (resources.getConfiguration().uiMode & (-49));
        if (eVar != null) {
            Q0(configuration2, eVar);
        }
        resources.updateConfiguration(configuration2, null);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 26) {
            C.a(resources);
        }
        int i4 = this.f1746U;
        if (i4 != 0) {
            this.f1762k.setTheme(i4);
            if (i3 >= 23) {
                this.f1762k.getTheme().applyStyle(this.f1746U, true);
            }
        }
        if (z2 && (this.f1761j instanceof Activity)) {
            Z0(configuration2);
        }
    }

    private void e1(View view) {
        view.setBackgroundColor((M.H(view) & 8192) != 0 ? androidx.core.content.a.b(this.f1762k, e.f.f5860b) : androidx.core.content.a.b(this.f1762k, e.f.f5859a));
    }

    private void i0() {
        if (this.f1726A) {
            return;
        }
        this.f1727B = c0();
        CharSequence charSequenceS0 = s0();
        if (!TextUtils.isEmpty(charSequenceS0)) {
            K k2 = this.r;
            if (k2 != null) {
                k2.setWindowTitle(charSequenceS0);
            } else if (L0() != null) {
                L0().t(charSequenceS0);
            } else {
                TextView textView = this.f1728C;
                if (textView != null) {
                    textView.setText(charSequenceS0);
                }
            }
        }
        S();
        J0(this.f1727B);
        this.f1726A = true;
        q qVarR0 = r0(0, false);
        if (this.f1743R) {
            return;
        }
        if (qVarR0 == null || qVarR0.f1804j == null) {
            y0(108);
        }
    }

    private void j0() {
        if (this.f1763l == null) {
            Object obj = this.f1761j;
            if (obj instanceof Activity) {
                T(((Activity) obj).getWindow());
            }
        }
        if (this.f1763l == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private static Configuration l0(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (configuration2 != null && configuration.diff(configuration2) != 0) {
            float f2 = configuration.fontScale;
            float f3 = configuration2.fontScale;
            if (f2 != f3) {
                configuration3.fontScale = f3;
            }
            int i2 = configuration.mcc;
            int i3 = configuration2.mcc;
            if (i2 != i3) {
                configuration3.mcc = i3;
            }
            int i4 = configuration.mnc;
            int i5 = configuration2.mnc;
            if (i4 != i5) {
                configuration3.mnc = i5;
            }
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 24) {
                i.a(configuration, configuration2, configuration3);
            } else if (!AbstractC0340c.a(configuration.locale, configuration2.locale)) {
                configuration3.locale = configuration2.locale;
            }
            int i7 = configuration.touchscreen;
            int i8 = configuration2.touchscreen;
            if (i7 != i8) {
                configuration3.touchscreen = i8;
            }
            int i9 = configuration.keyboard;
            int i10 = configuration2.keyboard;
            if (i9 != i10) {
                configuration3.keyboard = i10;
            }
            int i11 = configuration.keyboardHidden;
            int i12 = configuration2.keyboardHidden;
            if (i11 != i12) {
                configuration3.keyboardHidden = i12;
            }
            int i13 = configuration.navigation;
            int i14 = configuration2.navigation;
            if (i13 != i14) {
                configuration3.navigation = i14;
            }
            int i15 = configuration.navigationHidden;
            int i16 = configuration2.navigationHidden;
            if (i15 != i16) {
                configuration3.navigationHidden = i16;
            }
            int i17 = configuration.orientation;
            int i18 = configuration2.orientation;
            if (i17 != i18) {
                configuration3.orientation = i18;
            }
            int i19 = configuration.screenLayout & 15;
            int i20 = configuration2.screenLayout;
            if (i19 != (i20 & 15)) {
                configuration3.screenLayout |= i20 & 15;
            }
            int i21 = configuration.screenLayout & 192;
            int i22 = configuration2.screenLayout;
            if (i21 != (i22 & 192)) {
                configuration3.screenLayout |= i22 & 192;
            }
            int i23 = configuration.screenLayout & 48;
            int i24 = configuration2.screenLayout;
            if (i23 != (i24 & 48)) {
                configuration3.screenLayout |= i24 & 48;
            }
            int i25 = configuration.screenLayout & 768;
            int i26 = configuration2.screenLayout;
            if (i25 != (i26 & 768)) {
                configuration3.screenLayout |= i26 & 768;
            }
            if (i6 >= 26) {
                j.a(configuration, configuration2, configuration3);
            }
            int i27 = configuration.uiMode & 15;
            int i28 = configuration2.uiMode;
            if (i27 != (i28 & 15)) {
                configuration3.uiMode |= i28 & 15;
            }
            int i29 = configuration.uiMode & 48;
            int i30 = configuration2.uiMode;
            if (i29 != (i30 & 48)) {
                configuration3.uiMode |= i30 & 48;
            }
            int i31 = configuration.screenWidthDp;
            int i32 = configuration2.screenWidthDp;
            if (i31 != i32) {
                configuration3.screenWidthDp = i32;
            }
            int i33 = configuration.screenHeightDp;
            int i34 = configuration2.screenHeightDp;
            if (i33 != i34) {
                configuration3.screenHeightDp = i34;
            }
            int i35 = configuration.smallestScreenWidthDp;
            int i36 = configuration2.smallestScreenWidthDp;
            if (i35 != i36) {
                configuration3.smallestScreenWidthDp = i36;
            }
            int i37 = configuration.densityDpi;
            int i38 = configuration2.densityDpi;
            if (i37 != i38) {
                configuration3.densityDpi = i38;
            }
        }
        return configuration3;
    }

    private int n0(Context context) throws PackageManager.NameNotFoundException {
        if (!this.f1748W && (this.f1761j instanceof Activity)) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return 0;
            }
            try {
                int i2 = Build.VERSION.SDK_INT;
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, this.f1761j.getClass()), i2 >= 29 ? 269221888 : i2 >= 24 ? 786432 : 0);
                if (activityInfo != null) {
                    this.f1747V = activityInfo.configChanges;
                }
            } catch (PackageManager.NameNotFoundException e2) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e2);
                this.f1747V = 0;
            }
        }
        this.f1748W = true;
        return this.f1747V;
    }

    private n o0(Context context) {
        if (this.f1750Y == null) {
            this.f1750Y = new m(context);
        }
        return this.f1750Y;
    }

    private n p0(Context context) {
        if (this.f1749X == null) {
            this.f1749X = new o(E.a(context));
        }
        return this.f1749X;
    }

    private void u0() {
        i0();
        if (this.f1732G && this.o == null) {
            Object obj = this.f1761j;
            if (obj instanceof Activity) {
                this.o = new G((Activity) this.f1761j, this.f1733H);
            } else if (obj instanceof Dialog) {
                this.o = new G((Dialog) this.f1761j);
            }
            AbstractC0126a abstractC0126a = this.o;
            if (abstractC0126a != null) {
                abstractC0126a.r(this.f1754c0);
            }
        }
    }

    private boolean v0(q qVar) {
        View view = qVar.f1803i;
        if (view != null) {
            qVar.f1802h = view;
            return true;
        }
        if (qVar.f1804j == null) {
            return false;
        }
        if (this.f1768t == null) {
            this.f1768t = new r();
        }
        View view2 = (View) qVar.a(this.f1768t);
        qVar.f1802h = view2;
        return view2 != null;
    }

    private boolean w0(q qVar) {
        qVar.d(m0());
        qVar.f1801g = new p(qVar.f1806l);
        qVar.f1798c = 81;
        return true;
    }

    private boolean x0(q qVar) {
        Resources.Theme themeNewTheme;
        Context context = this.f1762k;
        int i2 = qVar.f1796a;
        if ((i2 == 0 || i2 == 108) && this.r != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(e.d.f5839d, typedValue, true);
            if (typedValue.resourceId != 0) {
                themeNewTheme = context.getResources().newTheme();
                themeNewTheme.setTo(theme);
                themeNewTheme.applyStyle(typedValue.resourceId, true);
                themeNewTheme.resolveAttribute(e.d.e, typedValue, true);
            } else {
                theme.resolveAttribute(e.d.e, typedValue, true);
                themeNewTheme = null;
            }
            if (typedValue.resourceId != 0) {
                if (themeNewTheme == null) {
                    themeNewTheme = context.getResources().newTheme();
                    themeNewTheme.setTo(theme);
                }
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            }
            if (themeNewTheme != null) {
                androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, 0);
                dVar.getTheme().setTo(themeNewTheme);
                context = dVar;
            }
        }
        androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(context);
        eVar.S(this);
        qVar.c(eVar);
        return true;
    }

    private void y0(int i2) {
        this.f1752a0 = (1 << i2) | this.f1752a0;
        if (this.f1751Z) {
            return;
        }
        M.a0(this.f1763l.getDecorView(), this.f1753b0);
        this.f1751Z = true;
    }

    @Override // androidx.appcompat.app.AbstractC0131f
    public void A() {
        AbstractC0126a abstractC0126aR = r();
        if (abstractC0126aR != null) {
            abstractC0126aR.s(true);
        }
    }

    int A0(Context context, int i2) {
        if (i2 == -100) {
            return -1;
        }
        if (i2 != -1) {
            if (i2 == 0) {
                if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() != 0) {
                    return p0(context).c();
                }
                return -1;
            }
            if (i2 != 1 && i2 != 2) {
                if (i2 == 3) {
                    return o0(context).c();
                }
                throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
            }
        }
        return i2;
    }

    @Override // androidx.appcompat.app.AbstractC0131f
    public void B(Bundle bundle) {
    }

    boolean B0() {
        boolean z2 = this.f1740O;
        this.f1740O = false;
        q qVarR0 = r0(0, false);
        if (qVarR0 != null && qVarR0.o) {
            if (!z2) {
                a0(qVarR0, true);
            }
            return true;
        }
        androidx.appcompat.view.b bVar = this.f1769u;
        if (bVar != null) {
            bVar.c();
            return true;
        }
        AbstractC0126a abstractC0126aR = r();
        return abstractC0126aR != null && abstractC0126aR.h();
    }

    @Override // androidx.appcompat.app.AbstractC0131f
    public void C() throws IllegalAccessException, NoSuchFieldException, PackageManager.NameNotFoundException, SecurityException, IllegalArgumentException {
        Q(true, false);
    }

    boolean C0(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            this.f1740O = (keyEvent.getFlags() & 128) != 0;
        } else if (i2 == 82) {
            D0(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.AbstractC0131f
    public void D() {
        AbstractC0126a abstractC0126aR = r();
        if (abstractC0126aR != null) {
            abstractC0126aR.s(false);
        }
    }

    boolean E0(int i2, KeyEvent keyEvent) {
        AbstractC0126a abstractC0126aR = r();
        if (abstractC0126aR != null && abstractC0126aR.o(i2, keyEvent)) {
            return true;
        }
        q qVar = this.f1739N;
        if (qVar != null && M0(qVar, keyEvent.getKeyCode(), keyEvent, 1)) {
            q qVar2 = this.f1739N;
            if (qVar2 != null) {
                qVar2.f1808n = true;
            }
            return true;
        }
        if (this.f1739N == null) {
            q qVarR0 = r0(0, true);
            N0(qVarR0, keyEvent);
            boolean zM0 = M0(qVarR0, keyEvent.getKeyCode(), keyEvent, 1);
            qVarR0.f1807m = false;
            if (zM0) {
                return true;
            }
        }
        return false;
    }

    boolean F0(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            if (i2 == 82) {
                G0(0, keyEvent);
                return true;
            }
        } else if (B0()) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.AbstractC0131f
    public boolean G(int i2) {
        int iP0 = P0(i2);
        if (this.f1736K && iP0 == 108) {
            return false;
        }
        if (this.f1732G && iP0 == 1) {
            this.f1732G = false;
        }
        if (iP0 == 1) {
            X0();
            this.f1736K = true;
            return true;
        }
        if (iP0 == 2) {
            X0();
            this.f1730E = true;
            return true;
        }
        if (iP0 == 5) {
            X0();
            this.f1731F = true;
            return true;
        }
        if (iP0 == 10) {
            X0();
            this.f1734I = true;
            return true;
        }
        if (iP0 == 108) {
            X0();
            this.f1732G = true;
            return true;
        }
        if (iP0 != 109) {
            return this.f1763l.requestFeature(iP0);
        }
        X0();
        this.f1733H = true;
        return true;
    }

    @Override // androidx.appcompat.app.AbstractC0131f
    public void H(int i2) {
        i0();
        ViewGroup viewGroup = (ViewGroup) this.f1727B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f1762k).inflate(i2, viewGroup);
        this.f1764m.c(this.f1763l.getCallback());
    }

    void H0(int i2) {
        AbstractC0126a abstractC0126aR;
        if (i2 != 108 || (abstractC0126aR = r()) == null) {
            return;
        }
        abstractC0126aR.i(true);
    }

    @Override // androidx.appcompat.app.AbstractC0131f
    public void I(View view) {
        i0();
        ViewGroup viewGroup = (ViewGroup) this.f1727B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f1764m.c(this.f1763l.getCallback());
    }

    void I0(int i2) {
        if (i2 == 108) {
            AbstractC0126a abstractC0126aR = r();
            if (abstractC0126aR != null) {
                abstractC0126aR.i(false);
                return;
            }
            return;
        }
        if (i2 == 0) {
            q qVarR0 = r0(i2, true);
            if (qVarR0.o) {
                a0(qVarR0, false);
            }
        }
    }

    @Override // androidx.appcompat.app.AbstractC0131f
    public void J(View view, ViewGroup.LayoutParams layoutParams) {
        i0();
        ViewGroup viewGroup = (ViewGroup) this.f1727B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f1764m.c(this.f1763l.getCallback());
    }

    void J0(ViewGroup viewGroup) {
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
    @Override // androidx.appcompat.app.AbstractC0131f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void K(android.window.OnBackInvokedDispatcher r3) {
        /*
            r2 = this;
            super.K(r3)
            android.window.OnBackInvokedDispatcher r0 = r2.f1759h0
            if (r0 == 0) goto L11
            android.window.OnBackInvokedCallback r1 = r2.f1760i0
            if (r1 == 0) goto L11
            androidx.appcompat.app.h.k.c(r0, r1)
            r0 = 0
            r2.f1760i0 = r0
        L11:
            if (r3 != 0) goto L2c
            java.lang.Object r0 = r2.f1761j
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L2c
            android.app.Activity r0 = (android.app.Activity) r0
            android.view.Window r0 = r0.getWindow()
            if (r0 == 0) goto L2c
            java.lang.Object r3 = r2.f1761j
            android.app.Activity r3 = (android.app.Activity) r3
            android.window.OnBackInvokedDispatcher r3 = androidx.appcompat.app.h.k.a(r3)
            r2.f1759h0 = r3
            goto L2e
        L2c:
            r2.f1759h0 = r3
        L2e:
            r2.b1()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.h.K(android.window.OnBackInvokedDispatcher):void");
    }

    @Override // androidx.appcompat.app.AbstractC0131f
    public void L(int i2) {
        this.f1746U = i2;
    }

    final AbstractC0126a L0() {
        return this.o;
    }

    @Override // androidx.appcompat.app.AbstractC0131f
    public final void M(CharSequence charSequence) {
        this.f1767q = charSequence;
        K k2 = this.r;
        if (k2 != null) {
            k2.setWindowTitle(charSequence);
            return;
        }
        if (L0() != null) {
            L0().t(charSequence);
            return;
        }
        TextView textView = this.f1728C;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    void Q0(Configuration configuration, androidx.core.os.e eVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            i.d(configuration, eVar);
        } else {
            configuration.setLocale(eVar.d(0));
            configuration.setLayoutDirection(eVar.d(0));
        }
    }

    public boolean R() {
        return P(true);
    }

    void R0(androidx.core.os.e eVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            i.c(eVar);
        } else {
            Locale.setDefault(eVar.d(0));
        }
    }

    final boolean S0() {
        ViewGroup viewGroup;
        return this.f1726A && (viewGroup = this.f1727B) != null && viewGroup.isLaidOut();
    }

    androidx.core.os.e U(Context context) {
        androidx.core.os.e eVarQ;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33 || (eVarQ = AbstractC0131f.q()) == null) {
            return null;
        }
        androidx.core.os.e eVarQ0 = q0(context.getApplicationContext().getResources().getConfiguration());
        androidx.core.os.e eVarB = i2 >= 24 ? B.b(eVarQ, eVarQ0) : eVarQ.f() ? androidx.core.os.e.e() : androidx.core.os.e.c(C0017h.b(eVarQ.d(0)));
        return eVarB.f() ? eVarQ0 : eVarB;
    }

    boolean U0() {
        if (this.f1759h0 == null) {
            return false;
        }
        q qVarR0 = r0(0, false);
        return (qVarR0 != null && qVarR0.o) || this.f1769u != null;
    }

    public androidx.appcompat.view.b V0(b.a aVar) {
        InterfaceC0129d interfaceC0129d;
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        androidx.appcompat.view.b bVar = this.f1769u;
        if (bVar != null) {
            bVar.c();
        }
        g gVar = new g(aVar);
        AbstractC0126a abstractC0126aR = r();
        if (abstractC0126aR != null) {
            androidx.appcompat.view.b bVarU = abstractC0126aR.u(gVar);
            this.f1769u = bVarU;
            if (bVarU != null && (interfaceC0129d = this.f1765n) != null) {
                interfaceC0129d.G(bVarU);
            }
        }
        if (this.f1769u == null) {
            this.f1769u = W0(gVar);
        }
        b1();
        return this.f1769u;
    }

    void W(int i2, q qVar, Menu menu) {
        if (menu == null) {
            if (qVar == null && i2 >= 0) {
                q[] qVarArr = this.f1738M;
                if (i2 < qVarArr.length) {
                    qVar = qVarArr[i2];
                }
            }
            if (qVar != null) {
                menu = qVar.f1804j;
            }
        }
        if ((qVar == null || qVar.o) && !this.f1743R) {
            this.f1764m.d(this.f1763l.getCallback(), i2, menu);
        }
    }

    androidx.appcompat.view.b W0(b.a aVar) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        androidx.appcompat.view.b bVarT;
        Context dVar;
        InterfaceC0129d interfaceC0129d;
        h0();
        androidx.appcompat.view.b bVar = this.f1769u;
        if (bVar != null) {
            bVar.c();
        }
        if (!(aVar instanceof g)) {
            aVar = new g(aVar);
        }
        InterfaceC0129d interfaceC0129d2 = this.f1765n;
        if (interfaceC0129d2 == null || this.f1743R) {
            bVarT = null;
        } else {
            try {
                bVarT = interfaceC0129d2.T(aVar);
            } catch (AbstractMethodError unused) {
            }
        }
        if (bVarT != null) {
            this.f1769u = bVarT;
        } else {
            if (this.f1770v == null) {
                if (this.f1735J) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = this.f1762k.getTheme();
                    theme.resolveAttribute(e.d.f5839d, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme themeNewTheme = this.f1762k.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        dVar = new androidx.appcompat.view.d(this.f1762k, 0);
                        dVar.getTheme().setTo(themeNewTheme);
                    } else {
                        dVar = this.f1762k;
                    }
                    this.f1770v = new ActionBarContextView(dVar);
                    PopupWindow popupWindow = new PopupWindow(dVar, (AttributeSet) null, e.d.f5840f);
                    this.f1771w = popupWindow;
                    androidx.core.widget.h.b(popupWindow, 2);
                    this.f1771w.setContentView(this.f1770v);
                    this.f1771w.setWidth(-1);
                    dVar.getTheme().resolveAttribute(e.d.f5837b, typedValue, true);
                    this.f1770v.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, dVar.getResources().getDisplayMetrics()));
                    this.f1771w.setHeight(-2);
                    this.f1772x = new d();
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.f1727B.findViewById(e.i.f5927h);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(m0()));
                        this.f1770v = (ActionBarContextView) viewStubCompat.a();
                    }
                }
            }
            if (this.f1770v != null) {
                h0();
                this.f1770v.k();
                androidx.appcompat.view.e eVar = new androidx.appcompat.view.e(this.f1770v.getContext(), this.f1770v, aVar, this.f1771w == null);
                if (aVar.c(eVar, eVar.e())) {
                    eVar.k();
                    this.f1770v.h(eVar);
                    this.f1769u = eVar;
                    if (S0()) {
                        this.f1770v.setAlpha(0.0f);
                        V vB = M.c(this.f1770v).b(1.0f);
                        this.f1773y = vB;
                        vB.h(new e());
                    } else {
                        this.f1770v.setAlpha(1.0f);
                        this.f1770v.setVisibility(0);
                        if (this.f1770v.getParent() instanceof View) {
                            M.c0((View) this.f1770v.getParent());
                        }
                    }
                    if (this.f1771w != null) {
                        this.f1763l.getDecorView().post(this.f1772x);
                    }
                } else {
                    this.f1769u = null;
                }
            }
        }
        androidx.appcompat.view.b bVar2 = this.f1769u;
        if (bVar2 != null && (interfaceC0129d = this.f1765n) != null) {
            interfaceC0129d.G(bVar2);
        }
        b1();
        return this.f1769u;
    }

    void X(androidx.appcompat.view.menu.e eVar) {
        if (this.f1737L) {
            return;
        }
        this.f1737L = true;
        this.r.l();
        Window.Callback callbackT0 = t0();
        if (callbackT0 != null && !this.f1743R) {
            callbackT0.onPanelClosed(108, eVar);
        }
        this.f1737L = false;
    }

    void Z(int i2) {
        a0(r0(i2, true), true);
    }

    @Override // androidx.appcompat.view.menu.e.a
    public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        q qVarK0;
        Window.Callback callbackT0 = t0();
        if (callbackT0 == null || this.f1743R || (qVarK0 = k0(eVar.D())) == null) {
            return false;
        }
        return callbackT0.onMenuItemSelected(qVarK0.f1796a, menuItem);
    }

    void a0(q qVar, boolean z2) {
        ViewGroup viewGroup;
        K k2;
        if (z2 && qVar.f1796a == 0 && (k2 = this.r) != null && k2.c()) {
            X(qVar.f1804j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f1762k.getSystemService("window");
        if (windowManager != null && qVar.o && (viewGroup = qVar.f1801g) != null) {
            windowManager.removeView(viewGroup);
            if (z2) {
                W(qVar.f1796a, qVar, null);
            }
        }
        qVar.f1807m = false;
        qVar.f1808n = false;
        qVar.o = false;
        qVar.f1802h = null;
        qVar.f1810q = true;
        if (this.f1739N == qVar) {
            this.f1739N = null;
        }
        if (qVar.f1796a == 0) {
            b1();
        }
    }

    @Override // androidx.appcompat.view.menu.e.a
    public void b(androidx.appcompat.view.menu.e eVar) {
        O0(true);
    }

    void b1() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean zU0 = U0();
            if (zU0 && this.f1760i0 == null) {
                this.f1760i0 = k.b(this.f1759h0, this);
            } else {
                if (zU0 || (onBackInvokedCallback = this.f1760i0) == null) {
                    return;
                }
                k.c(this.f1759h0, onBackInvokedCallback);
                this.f1760i0 = null;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View d0(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z2;
        if (this.f1757f0 == null) {
            TypedArray typedArrayObtainStyledAttributes = this.f1762k.obtainStyledAttributes(e.m.f6090y0);
            String string = typedArrayObtainStyledAttributes.getString(e.m.f5977C0);
            typedArrayObtainStyledAttributes.recycle();
            if (string == null) {
                this.f1757f0 = new y();
            } else {
                try {
                    this.f1757f0 = (y) this.f1762k.getClassLoader().loadClass(string).getDeclaredConstructor(null).newInstance(null);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.f1757f0 = new y();
                }
            }
        }
        boolean z3 = f1723k0;
        boolean zT0 = false;
        if (z3) {
            if (this.f1758g0 == null) {
                this.f1758g0 = new A();
            }
            if (this.f1758g0.a(attributeSet)) {
                z2 = true;
            } else {
                if (!(attributeSet instanceof XmlPullParser)) {
                    zT0 = T0((ViewParent) view);
                } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                    zT0 = true;
                }
                z2 = zT0;
            }
        } else {
            z2 = false;
        }
        return this.f1757f0.createView(view, str, context, attributeSet, z2, z3, true, n0.c());
    }

    final int d1(Z z2, Rect rect) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        boolean z3;
        boolean z4;
        int iK = z2 != null ? z2.k() : rect != null ? rect.top : 0;
        ActionBarContextView actionBarContextView = this.f1770v;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z3 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1770v.getLayoutParams();
            if (this.f1770v.isShown()) {
                if (this.f1755d0 == null) {
                    this.f1755d0 = new Rect();
                    this.f1756e0 = new Rect();
                }
                Rect rect2 = this.f1755d0;
                Rect rect3 = this.f1756e0;
                if (z2 == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(z2.i(), z2.k(), z2.j(), z2.h());
                }
                o0.a(this.f1727B, rect2, rect3);
                int i2 = rect2.top;
                int i3 = rect2.left;
                int i4 = rect2.right;
                Z zE = M.E(this.f1727B);
                int i5 = zE == null ? 0 : zE.i();
                int iJ = zE == null ? 0 : zE.j();
                if (marginLayoutParams.topMargin == i2 && marginLayoutParams.leftMargin == i3 && marginLayoutParams.rightMargin == i4) {
                    z4 = false;
                } else {
                    marginLayoutParams.topMargin = i2;
                    marginLayoutParams.leftMargin = i3;
                    marginLayoutParams.rightMargin = i4;
                    z4 = true;
                }
                if (i2 <= 0 || this.f1729D != null) {
                    View view = this.f1729D;
                    if (view != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        int i6 = marginLayoutParams2.height;
                        int i7 = marginLayoutParams.topMargin;
                        if (i6 != i7 || marginLayoutParams2.leftMargin != i5 || marginLayoutParams2.rightMargin != iJ) {
                            marginLayoutParams2.height = i7;
                            marginLayoutParams2.leftMargin = i5;
                            marginLayoutParams2.rightMargin = iJ;
                            this.f1729D.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view2 = new View(this.f1762k);
                    this.f1729D = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = i5;
                    layoutParams.rightMargin = iJ;
                    this.f1727B.addView(this.f1729D, -1, layoutParams);
                }
                View view3 = this.f1729D;
                z = view3 != null;
                if (z && view3.getVisibility() != 0) {
                    e1(this.f1729D);
                }
                if (!this.f1734I && z) {
                    iK = 0;
                }
                z3 = z;
                z = z4;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z3 = false;
            } else {
                z3 = false;
                z = false;
            }
            if (z) {
                this.f1770v.setLayoutParams(marginLayoutParams);
            }
        }
        View view4 = this.f1729D;
        if (view4 != null) {
            view4.setVisibility(z3 ? 0 : 8);
        }
        return iK;
    }

    @Override // androidx.appcompat.app.AbstractC0131f
    public void e(View view, ViewGroup.LayoutParams layoutParams) {
        i0();
        ((ViewGroup) this.f1727B.findViewById(R.id.content)).addView(view, layoutParams);
        this.f1764m.c(this.f1763l.getCallback());
    }

    void e0() {
        androidx.appcompat.view.menu.e eVar;
        K k2 = this.r;
        if (k2 != null) {
            k2.l();
        }
        if (this.f1771w != null) {
            this.f1763l.getDecorView().removeCallbacks(this.f1772x);
            if (this.f1771w.isShowing()) {
                try {
                    this.f1771w.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f1771w = null;
        }
        h0();
        q qVarR0 = r0(0, false);
        if (qVarR0 == null || (eVar = qVarR0.f1804j) == null) {
            return;
        }
        eVar.close();
    }

    boolean f0(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f1761j;
        if (((obj instanceof AbstractC0177u.a) || (obj instanceof x)) && (decorView = this.f1763l.getDecorView()) != null && AbstractC0177u.d(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f1764m.b(this.f1763l.getCallback(), keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? C0(keyCode, keyEvent) : F0(keyCode, keyEvent);
    }

    @Override // androidx.appcompat.app.AbstractC0131f
    public Context g(Context context) {
        this.f1741P = true;
        int iA0 = A0(context, V());
        if (AbstractC0131f.u(context)) {
            AbstractC0131f.O(context);
        }
        androidx.core.os.e eVarU = U(context);
        if (context instanceof ContextThemeWrapper) {
            try {
                ((ContextThemeWrapper) context).applyOverrideConfiguration(b0(context, iA0, eVarU, null, false));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof androidx.appcompat.view.d) {
            try {
                ((androidx.appcompat.view.d) context).a(b0(context, iA0, eVarU, null, false));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!f1725m0) {
            return super.g(context);
        }
        Configuration configuration = new Configuration();
        configuration.uiMode = -1;
        configuration.fontScale = 0.0f;
        Configuration configuration2 = context.createConfigurationContext(configuration).getResources().getConfiguration();
        Configuration configuration3 = context.getResources().getConfiguration();
        configuration2.uiMode = configuration3.uiMode;
        Configuration configurationB0 = b0(context, iA0, eVarU, !configuration2.equals(configuration3) ? l0(configuration2, configuration3) : null, true);
        androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, e.l.f5970c);
        dVar.a(configurationB0);
        try {
            if (context.getTheme() != null) {
                h.f.a(dVar.getTheme());
            }
        } catch (NullPointerException unused3) {
        }
        return super.g(dVar);
    }

    void g0(int i2) {
        q qVarR0;
        q qVarR02 = r0(i2, true);
        if (qVarR02.f1804j != null) {
            Bundle bundle = new Bundle();
            qVarR02.f1804j.R(bundle);
            if (bundle.size() > 0) {
                qVarR02.s = bundle;
            }
            qVarR02.f1804j.e0();
            qVarR02.f1804j.clear();
        }
        qVarR02.r = true;
        qVarR02.f1810q = true;
        if ((i2 != 108 && i2 != 0) || this.r == null || (qVarR0 = r0(0, false)) == null) {
            return;
        }
        qVarR0.f1807m = false;
        N0(qVarR0, null);
    }

    void h0() {
        V v2 = this.f1773y;
        if (v2 != null) {
            v2.c();
        }
    }

    @Override // androidx.appcompat.app.AbstractC0131f
    public View j(int i2) {
        i0();
        return this.f1763l.findViewById(i2);
    }

    q k0(Menu menu) {
        q[] qVarArr = this.f1738M;
        int length = qVarArr != null ? qVarArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            q qVar = qVarArr[i2];
            if (qVar != null && qVar.f1804j == menu) {
                return qVar;
            }
        }
        return null;
    }

    @Override // androidx.appcompat.app.AbstractC0131f
    public Context l() {
        return this.f1762k;
    }

    final Context m0() {
        AbstractC0126a abstractC0126aR = r();
        Context contextK = abstractC0126aR != null ? abstractC0126aR.k() : null;
        return contextK == null ? this.f1762k : contextK;
    }

    @Override // androidx.appcompat.app.AbstractC0131f
    public int n() {
        return this.f1745T;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return d0(view, str, context, attributeSet);
    }

    @Override // androidx.appcompat.app.AbstractC0131f
    public MenuInflater p() {
        if (this.f1766p == null) {
            u0();
            AbstractC0126a abstractC0126a = this.o;
            this.f1766p = new androidx.appcompat.view.g(abstractC0126a != null ? abstractC0126a.k() : this.f1762k);
        }
        return this.f1766p;
    }

    androidx.core.os.e q0(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? i.b(configuration) : androidx.core.os.e.c(C0017h.b(configuration.locale));
    }

    @Override // androidx.appcompat.app.AbstractC0131f
    public AbstractC0126a r() {
        u0();
        return this.o;
    }

    protected q r0(int i2, boolean z2) {
        q[] qVarArr = this.f1738M;
        if (qVarArr == null || qVarArr.length <= i2) {
            q[] qVarArr2 = new q[i2 + 1];
            if (qVarArr != null) {
                System.arraycopy(qVarArr, 0, qVarArr2, 0, qVarArr.length);
            }
            this.f1738M = qVarArr2;
            qVarArr = qVarArr2;
        }
        q qVar = qVarArr[i2];
        if (qVar != null) {
            return qVar;
        }
        q qVar2 = new q(i2);
        qVarArr[i2] = qVar2;
        return qVar2;
    }

    @Override // androidx.appcompat.app.AbstractC0131f
    public void s() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f1762k);
        if (layoutInflaterFrom.getFactory() == null) {
            AbstractC0178v.a(layoutInflaterFrom, this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof h) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    final CharSequence s0() {
        Object obj = this.f1761j;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.f1767q;
    }

    @Override // androidx.appcompat.app.AbstractC0131f
    public void t() {
        if (L0() == null || r().l()) {
            return;
        }
        y0(0);
    }

    final Window.Callback t0() {
        return this.f1763l.getCallback();
    }

    @Override // androidx.appcompat.app.AbstractC0131f
    public void w(Configuration configuration) throws IllegalAccessException, NoSuchFieldException, PackageManager.NameNotFoundException, SecurityException, IllegalArgumentException {
        AbstractC0126a abstractC0126aR;
        if (this.f1732G && this.f1726A && (abstractC0126aR = r()) != null) {
            abstractC0126aR.m(configuration);
        }
        C0143k.b().g(this.f1762k);
        this.f1744S = new Configuration(this.f1762k.getResources().getConfiguration());
        Q(false, false);
    }

    @Override // androidx.appcompat.app.AbstractC0131f
    public void x(Bundle bundle) {
        String strC;
        this.f1741P = true;
        P(false);
        j0();
        Object obj = this.f1761j;
        if (obj instanceof Activity) {
            try {
                strC = androidx.core.app.j.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
                strC = null;
            }
            if (strC != null) {
                AbstractC0126a abstractC0126aL0 = L0();
                if (abstractC0126aL0 == null) {
                    this.f1754c0 = true;
                } else {
                    abstractC0126aL0.r(true);
                }
            }
            AbstractC0131f.d(this);
        }
        this.f1744S = new Configuration(this.f1762k.getResources().getConfiguration());
        this.f1742Q = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    @Override // androidx.appcompat.app.AbstractC0131f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void y() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f1761j
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L9
            androidx.appcompat.app.AbstractC0131f.E(r3)
        L9:
            boolean r0 = r3.f1751Z
            if (r0 == 0) goto L18
            android.view.Window r0 = r3.f1763l
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.f1753b0
            r0.removeCallbacks(r1)
        L18:
            r0 = 1
            r3.f1743R = r0
            int r0 = r3.f1745T
            r1 = -100
            if (r0 == r1) goto L45
            java.lang.Object r0 = r3.f1761j
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L45
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L45
            androidx.collection.g r0 = androidx.appcompat.app.h.f1722j0
            java.lang.Object r1 = r3.f1761j
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.f1745T
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L54
        L45:
            androidx.collection.g r0 = androidx.appcompat.app.h.f1722j0
            java.lang.Object r1 = r3.f1761j
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L54:
            androidx.appcompat.app.a r0 = r3.o
            if (r0 == 0) goto L5b
            r0.n()
        L5b:
            r3.Y()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.h.y():void");
    }

    @Override // androidx.appcompat.app.AbstractC0131f
    public void z(Bundle bundle) {
        i0();
    }

    public boolean z0() {
        return this.f1774z;
    }

    h(Dialog dialog, InterfaceC0129d interfaceC0129d) {
        this(dialog.getContext(), dialog.getWindow(), interfaceC0129d, dialog);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    private h(Context context, Window window, InterfaceC0129d interfaceC0129d, Object obj) {
        AbstractActivityC0128c abstractActivityC0128cY0;
        this.f1773y = null;
        this.f1774z = true;
        this.f1745T = -100;
        this.f1753b0 = new a();
        this.f1762k = context;
        this.f1765n = interfaceC0129d;
        this.f1761j = obj;
        if (this.f1745T == -100 && (obj instanceof Dialog) && (abstractActivityC0128cY0 = Y0()) != null) {
            this.f1745T = abstractActivityC0128cY0.X0().n();
        }
        if (this.f1745T == -100) {
            androidx.collection.g gVar = f1722j0;
            Integer num = (Integer) gVar.get(obj.getClass().getName());
            if (num != null) {
                this.f1745T = num.intValue();
                gVar.remove(obj.getClass().getName());
            }
        }
        if (window != null) {
            T(window);
        }
        C0143k.h();
    }

    class l extends androidx.appcompat.view.i {

        /* renamed from: b, reason: collision with root package name */
        private boolean f1785b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f1786c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f1787d;

        l(Window.Callback callback) {
            super(callback);
        }

        public boolean b(Window.Callback callback, KeyEvent keyEvent) {
            try {
                this.f1786c = true;
                return callback.dispatchKeyEvent(keyEvent);
            } finally {
                this.f1786c = false;
            }
        }

        public void c(Window.Callback callback) {
            try {
                this.f1785b = true;
                callback.onContentChanged();
            } finally {
                this.f1785b = false;
            }
        }

        public void d(Window.Callback callback, int i2, Menu menu) {
            try {
                this.f1787d = true;
                callback.onPanelClosed(i2, menu);
            } finally {
                this.f1787d = false;
            }
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.f1786c ? a().dispatchKeyEvent(keyEvent) : h.this.f0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || h.this.E0(keyEvent.getKeyCode(), keyEvent);
        }

        final ActionMode e(ActionMode.Callback callback) {
            f.a aVar = new f.a(h.this.f1762k, callback);
            androidx.appcompat.view.b bVarV0 = h.this.V0(aVar);
            if (bVarV0 != null) {
                return aVar.e(bVarV0);
            }
            return null;
        }

        @Override // android.view.Window.Callback
        public void onContentChanged() {
            if (this.f1785b) {
                a().onContentChanged();
            }
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i2, Menu menu) {
            if (i2 != 0 || (menu instanceof androidx.appcompat.view.menu.e)) {
                return super.onCreatePanelMenu(i2, menu);
            }
            return false;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public View onCreatePanelView(int i2) {
            return super.onCreatePanelView(i2);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onMenuOpened(int i2, Menu menu) {
            super.onMenuOpened(i2, menu);
            h.this.H0(i2);
            return true;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public void onPanelClosed(int i2, Menu menu) {
            if (this.f1787d) {
                a().onPanelClosed(i2, menu);
            } else {
                super.onPanelClosed(i2, menu);
                h.this.I0(i2);
            }
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onPreparePanel(int i2, View view, Menu menu) {
            androidx.appcompat.view.menu.e eVar = menu instanceof androidx.appcompat.view.menu.e ? (androidx.appcompat.view.menu.e) menu : null;
            if (i2 == 0 && eVar == null) {
                return false;
            }
            if (eVar != null) {
                eVar.b0(true);
            }
            boolean zOnPreparePanel = super.onPreparePanel(i2, view, menu);
            if (eVar != null) {
                eVar.b0(false);
            }
            return zOnPreparePanel;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List list, Menu menu, int i2) {
            androidx.appcompat.view.menu.e eVar;
            q qVarR0 = h.this.r0(0, true);
            if (qVarR0 == null || (eVar = qVarR0.f1804j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i2);
            } else {
                super.onProvideKeyboardShortcuts(list, eVar, i2);
            }
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            return h.this.z0() ? e(callback) : super.onWindowStartingActionMode(callback);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i2) {
            if (h.this.z0() && i2 == 0) {
                return e(callback);
            }
            return super.onWindowStartingActionMode(callback, i2);
        }
    }
}
