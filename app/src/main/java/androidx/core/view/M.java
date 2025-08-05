package androidx.core.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.OnReceiveContentListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import androidx.core.view.C0158a;
import androidx.core.view.Z;
import defpackage.r;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import x.AbstractC0372a;
import y.AbstractC0374a;

/* loaded from: classes.dex */
public abstract class M {

    /* renamed from: a */
    private static WeakHashMap f3095a = null;

    /* renamed from: b */
    private static Field f3096b = null;

    /* renamed from: c */
    private static boolean f3097c = false;

    /* renamed from: d */
    private static ThreadLocal f3098d;
    private static final int[] e = {r.e.f7274b, r.e.f7275c, r.e.f7285n, r.e.f7293y, r.e.f7255B, r.e.f7256C, r.e.f7257D, r.e.f7258E, r.e.f7259F, r.e.f7260G, r.e.f7276d, r.e.e, r.e.f7277f, r.e.f7278g, r.e.f7279h, r.e.f7280i, r.e.f7281j, r.e.f7282k, r.e.f7283l, r.e.f7284m, r.e.o, r.e.f7286p, r.e.f7287q, r.e.r, r.e.s, r.e.f7288t, r.e.f7289u, r.e.f7290v, r.e.f7291w, r.e.f7292x, r.e.f7294z, r.e.f7254A};

    /* renamed from: f */
    private static final H f3099f = new H() { // from class: androidx.core.view.L
        @Override // androidx.core.view.H
        public final C0161d a(C0161d c0161d) {
            return M.S(c0161d);
        }
    };

    /* renamed from: g */
    private static final e f3100g = new e();

    class a extends f {
        a(int i2, Class cls, int i3) {
            super(i2, cls, i3);
        }

        @Override // androidx.core.view.M.f
        /* renamed from: h */
        public Boolean c(View view) {
            return Boolean.valueOf(k.d(view));
        }

        @Override // androidx.core.view.M.f
        /* renamed from: i */
        public void d(View view, Boolean bool) {
            k.j(view, bool.booleanValue());
        }

        @Override // androidx.core.view.M.f
        /* renamed from: j */
        public boolean g(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    class b extends f {
        b(int i2, Class cls, int i3, int i4) {
            super(i2, cls, i3, i4);
        }

        @Override // androidx.core.view.M.f
        /* renamed from: h */
        public CharSequence c(View view) {
            return k.b(view);
        }

        @Override // androidx.core.view.M.f
        /* renamed from: i */
        public void d(View view, CharSequence charSequence) {
            k.h(view, charSequence);
        }

        @Override // androidx.core.view.M.f
        /* renamed from: j */
        public boolean g(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    class c extends f {
        c(int i2, Class cls, int i3, int i4) {
            super(i2, cls, i3, i4);
        }

        @Override // androidx.core.view.M.f
        /* renamed from: h */
        public CharSequence c(View view) {
            return m.b(view);
        }

        @Override // androidx.core.view.M.f
        /* renamed from: i */
        public void d(View view, CharSequence charSequence) {
            m.e(view, charSequence);
        }

        @Override // androidx.core.view.M.f
        /* renamed from: j */
        public boolean g(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    class d extends f {
        d(int i2, Class cls, int i3) {
            super(i2, cls, i3);
        }

        @Override // androidx.core.view.M.f
        /* renamed from: h */
        public Boolean c(View view) {
            return Boolean.valueOf(k.c(view));
        }

        @Override // androidx.core.view.M.f
        /* renamed from: i */
        public void d(View view, Boolean bool) {
            k.g(view, bool.booleanValue());
        }

        @Override // androidx.core.view.M.f
        /* renamed from: j */
        public boolean g(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    static class e implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* renamed from: a */
        private final WeakHashMap f3101a = new WeakHashMap();

        e() {
        }

        private void b(Map.Entry entry) {
            View view = (View) entry.getKey();
            boolean zBooleanValue = ((Boolean) entry.getValue()).booleanValue();
            boolean z2 = view.isShown() && view.getWindowVisibility() == 0;
            if (zBooleanValue != z2) {
                M.T(view, z2 ? 16 : 32);
                entry.setValue(Boolean.valueOf(z2));
            }
        }

        private void c(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        private void e(View view) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        void a(View view) {
            this.f3101a.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(this);
            if (view.isAttachedToWindow()) {
                c(view);
            }
        }

        void d(View view) {
            this.f3101a.remove(view);
            view.removeOnAttachStateChangeListener(this);
            e(view);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                Iterator it = this.f3101a.entrySet().iterator();
                while (it.hasNext()) {
                    b((Map.Entry) it.next());
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            c(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    static abstract class f {

        /* renamed from: a */
        private final int f3102a;

        /* renamed from: b */
        private final Class f3103b;

        /* renamed from: c */
        private final int f3104c;

        /* renamed from: d */
        private final int f3105d;

        f(int i2, Class cls, int i3) {
            this(i2, cls, 0, i3);
        }

        private boolean b() {
            return Build.VERSION.SDK_INT >= this.f3104c;
        }

        boolean a(Boolean bool, Boolean bool2) {
            return (bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue());
        }

        abstract Object c(View view);

        abstract void d(View view, Object obj);

        Object e(View view) {
            if (b()) {
                return c(view);
            }
            Object tag = view.getTag(this.f3102a);
            if (this.f3103b.isInstance(tag)) {
                return tag;
            }
            return null;
        }

        void f(View view, Object obj) {
            if (b()) {
                d(view, obj);
            } else if (g(e(view), obj)) {
                M.j(view);
                view.setTag(this.f3102a, obj);
                M.T(view, this.f3105d);
            }
        }

        abstract boolean g(Object obj, Object obj2);

        f(int i2, Class cls, int i3, int i4) {
            this.f3102a = i2;
            this.f3103b = cls;
            this.f3105d = i3;
            this.f3104c = i4;
        }
    }

    static class g {
        static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        static WindowInsets b(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        static void c(View view) {
            view.requestApplyInsets();
        }
    }

    private static class h {

        class a implements View.OnApplyWindowInsetsListener {

            /* renamed from: a */
            Z f3106a = null;

            /* renamed from: b */
            final /* synthetic */ View f3107b;

            /* renamed from: c */
            final /* synthetic */ F f3108c;

            a(View view, F f2) {
                this.f3107b = view;
                this.f3108c = f2;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                Z zV = Z.v(windowInsets, view);
                int i2 = Build.VERSION.SDK_INT;
                if (i2 < 30) {
                    h.a(windowInsets, this.f3107b);
                    if (zV.equals(this.f3106a)) {
                        return this.f3108c.a(view, zV).t();
                    }
                }
                this.f3106a = zV;
                Z zA = this.f3108c.a(view, zV);
                if (i2 >= 30) {
                    return zA.t();
                }
                M.c0(view);
                return zA.t();
            }
        }

        static void a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(r.e.f7272S);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        static Z b(View view, Z z2, Rect rect) {
            WindowInsets windowInsetsT = z2.t();
            if (windowInsetsT != null) {
                return Z.v(view.computeSystemWindowInsets(windowInsetsT, rect), view);
            }
            rect.setEmpty();
            return z2;
        }

        static boolean c(View view, float f2, float f3, boolean z2) {
            return view.dispatchNestedFling(f2, f3, z2);
        }

        static boolean d(View view, float f2, float f3) {
            return view.dispatchNestedPreFling(f2, f3);
        }

        static boolean e(View view, int i2, int i3, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
        }

        static boolean f(View view, int i2, int i3, int i4, int i5, int[] iArr) {
            return view.dispatchNestedScroll(i2, i3, i4, i5, iArr);
        }

        static ColorStateList g(View view) {
            return view.getBackgroundTintList();
        }

        static PorterDuff.Mode h(View view) {
            return view.getBackgroundTintMode();
        }

        static float i(View view) {
            return view.getElevation();
        }

        public static Z j(View view) {
            return Z.a.a(view);
        }

        static String k(View view) {
            return view.getTransitionName();
        }

        static float l(View view) {
            return view.getTranslationZ();
        }

        static float m(View view) {
            return view.getZ();
        }

        static boolean n(View view) {
            return view.hasNestedScrollingParent();
        }

        static boolean o(View view) {
            return view.isImportantForAccessibility();
        }

        static boolean p(View view) {
            return view.isNestedScrollingEnabled();
        }

        static void q(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        static void r(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        static void s(View view, float f2) {
            view.setElevation(f2);
        }

        static void t(View view, boolean z2) {
            view.setNestedScrollingEnabled(z2);
        }

        static void u(View view, F f2) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(r.e.f7265L, f2);
            }
            if (f2 == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(r.e.f7272S));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, f2));
            }
        }

        static void v(View view, String str) {
            view.setTransitionName(str);
        }

        static void w(View view, float f2) {
            view.setTranslationZ(f2);
        }

        static void x(View view, float f2) {
            view.setZ(f2);
        }

        static boolean y(View view, int i2) {
            return view.startNestedScroll(i2);
        }

        static void z(View view) {
            view.stopNestedScroll();
        }
    }

    private static class i {
        public static Z a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            Z zU = Z.u(rootWindowInsets);
            zU.r(zU);
            zU.d(view.getRootView());
            return zU;
        }

        static int b(View view) {
            return view.getScrollIndicators();
        }

        static void c(View view, int i2) {
            view.setScrollIndicators(i2);
        }

        static void d(View view, int i2, int i3) {
            view.setScrollIndicators(i2, i3);
        }
    }

    static class j {
        static void a(View view, Collection<View> collection, int i2) {
            view.addKeyboardNavigationClusters(collection, i2);
        }

        public static AutofillId b(View view) {
            return view.getAutofillId();
        }

        static int c(View view) {
            return view.getImportantForAutofill();
        }

        static int d(View view) {
            return view.getNextClusterForwardId();
        }

        static boolean e(View view) {
            return view.hasExplicitFocusable();
        }

        static boolean f(View view) {
            return view.isFocusedByDefault();
        }

        static boolean g(View view) {
            return view.isImportantForAutofill();
        }

        static boolean h(View view) {
            return view.isKeyboardNavigationCluster();
        }

        static View i(View view, View view2, int i2) {
            return view.keyboardNavigationClusterSearch(view2, i2);
        }

        static boolean j(View view) {
            return view.restoreDefaultFocus();
        }

        static void k(View view, String... strArr) {
            view.setAutofillHints(strArr);
        }

        static void l(View view, boolean z2) {
            view.setFocusedByDefault(z2);
        }

        static void m(View view, int i2) {
            view.setImportantForAutofill(i2);
        }

        static void n(View view, boolean z2) {
            view.setKeyboardNavigationCluster(z2);
        }

        static void o(View view, int i2) {
            view.setNextClusterForwardId(i2);
        }

        static void p(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    static class k {
        static void a(View view, final p pVar) {
            int i2 = r.e.f7271R;
            androidx.collection.g gVar = (androidx.collection.g) view.getTag(i2);
            if (gVar == null) {
                gVar = new androidx.collection.g();
                view.setTag(i2, gVar);
            }
            Objects.requireNonNull(pVar);
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener = new View.OnUnhandledKeyEventListener(pVar) { // from class: androidx.core.view.N
                @Override // android.view.View.OnUnhandledKeyEventListener
                public final boolean onUnhandledKeyEvent(View view2, KeyEvent keyEvent) {
                    throw null;
                }
            };
            gVar.put(pVar, onUnhandledKeyEventListener);
            view.addOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        static CharSequence b(View view) {
            return view.getAccessibilityPaneTitle();
        }

        static boolean c(View view) {
            return view.isAccessibilityHeading();
        }

        static boolean d(View view) {
            return view.isScreenReaderFocusable();
        }

        static void e(View view, p pVar) {
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
            androidx.collection.g gVar = (androidx.collection.g) view.getTag(r.e.f7271R);
            if (gVar == null || (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) gVar.get(pVar)) == null) {
                return;
            }
            view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        static <T> T f(View view, int i2) {
            return (T) view.requireViewById(i2);
        }

        static void g(View view, boolean z2) {
            view.setAccessibilityHeading(z2);
        }

        static void h(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        public static void i(View view, AbstractC0372a abstractC0372a) {
            view.setAutofillId(null);
        }

        static void j(View view, boolean z2) {
            view.setScreenReaderFocusable(z2);
        }
    }

    private static class l {
        static View.AccessibilityDelegate a(View view) {
            return view.getAccessibilityDelegate();
        }

        static ContentCaptureSession b(View view) {
            return view.getContentCaptureSession();
        }

        static List<Rect> c(View view) {
            return view.getSystemGestureExclusionRects();
        }

        static void d(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i2, int i3) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i2, i3);
        }

        static void e(View view, AbstractC0374a abstractC0374a) {
            view.setContentCaptureSession(null);
        }

        static void f(View view, List<Rect> list) {
            view.setSystemGestureExclusionRects(list);
        }
    }

    private static class m {
        static int a(View view) {
            return view.getImportantForContentCapture();
        }

        static CharSequence b(View view) {
            return view.getStateDescription();
        }

        static boolean c(View view) {
            return view.isImportantForContentCapture();
        }

        static void d(View view, int i2) {
            view.setImportantForContentCapture(i2);
        }

        static void e(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    private static final class n {
        public static String[] a(View view) {
            return view.getReceiveContentMimeTypes();
        }

        public static C0161d b(View view, C0161d c0161d) {
            ContentInfo contentInfoF = c0161d.f();
            ContentInfo contentInfoPerformReceiveContent = view.performReceiveContent(contentInfoF);
            if (contentInfoPerformReceiveContent == null) {
                return null;
            }
            return contentInfoPerformReceiveContent == contentInfoF ? c0161d : C0161d.g(contentInfoPerformReceiveContent);
        }

        public static void c(View view, String[] strArr, G g2) {
            if (g2 == null) {
                view.setOnReceiveContentListener(strArr, null);
            } else {
                view.setOnReceiveContentListener(strArr, new o(g2));
            }
        }
    }

    private static final class o implements OnReceiveContentListener {

        /* renamed from: a */
        private final G f3109a;

        o(G g2) {
            this.f3109a = g2;
        }

        @Override // android.view.OnReceiveContentListener
        public ContentInfo onReceiveContent(View view, ContentInfo contentInfo) {
            C0161d c0161dG = C0161d.g(contentInfo);
            C0161d c0161dA = this.f3109a.a(view, c0161dG);
            if (c0161dA == null) {
                return null;
            }
            return c0161dA == c0161dG ? contentInfo : c0161dA.f();
        }
    }

    public interface p {
    }

    static class q {

        /* renamed from: d */
        private static final ArrayList f3110d = new ArrayList();

        /* renamed from: a */
        private WeakHashMap f3111a = null;

        /* renamed from: b */
        private SparseArray f3112b = null;

        /* renamed from: c */
        private WeakReference f3113c = null;

        q() {
        }

        static q a(View view) {
            int i2 = r.e.f7270Q;
            q qVar = (q) view.getTag(i2);
            if (qVar != null) {
                return qVar;
            }
            q qVar2 = new q();
            view.setTag(i2, qVar2);
            return qVar2;
        }

        private View c(View view, KeyEvent keyEvent) {
            WeakHashMap weakHashMap = this.f3111a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View viewC = c(viewGroup.getChildAt(childCount), keyEvent);
                        if (viewC != null) {
                            return viewC;
                        }
                    }
                }
                if (e(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        private SparseArray d() {
            if (this.f3112b == null) {
                this.f3112b = new SparseArray();
            }
            return this.f3112b;
        }

        private boolean e(View view, KeyEvent keyEvent) {
            int size;
            ArrayList arrayList = (ArrayList) view.getTag(r.e.f7271R);
            if (arrayList == null || arrayList.size() - 1 < 0) {
                return false;
            }
            androidx.appcompat.app.F.a(arrayList.get(size));
            throw null;
        }

        private void g() {
            WeakHashMap weakHashMap = this.f3111a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList arrayList = f3110d;
            if (arrayList.isEmpty()) {
                return;
            }
            synchronized (arrayList) {
                try {
                    if (this.f3111a == null) {
                        this.f3111a = new WeakHashMap();
                    }
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        ArrayList arrayList2 = f3110d;
                        View view = (View) ((WeakReference) arrayList2.get(size)).get();
                        if (view == null) {
                            arrayList2.remove(size);
                        } else {
                            this.f3111a.put(view, Boolean.TRUE);
                            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                                this.f3111a.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        boolean b(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                g();
            }
            View viewC = c(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (viewC != null && !KeyEvent.isModifierKey(keyCode)) {
                    d().put(keyCode, new WeakReference(viewC));
                }
            }
            return viewC != null;
        }

        boolean f(KeyEvent keyEvent) {
            WeakReference weakReference;
            int iIndexOfKey;
            WeakReference weakReference2 = this.f3113c;
            if (weakReference2 != null && weakReference2.get() == keyEvent) {
                return false;
            }
            this.f3113c = new WeakReference(keyEvent);
            SparseArray sparseArrayD = d();
            if (keyEvent.getAction() != 1 || (iIndexOfKey = sparseArrayD.indexOfKey(keyEvent.getKeyCode())) < 0) {
                weakReference = null;
            } else {
                weakReference = (WeakReference) sparseArrayD.valueAt(iIndexOfKey);
                sparseArrayD.removeAt(iIndexOfKey);
            }
            if (weakReference == null) {
                weakReference = (WeakReference) sparseArrayD.get(keyEvent.getKeyCode());
            }
            if (weakReference == null) {
                return false;
            }
            View view = (View) weakReference.get();
            if (view != null && view.isAttachedToWindow()) {
                e(view, keyEvent);
            }
            return true;
        }
    }

    public static int A(View view) {
        return view.getMinimumWidth();
    }

    public static String[] B(View view) {
        return Build.VERSION.SDK_INT >= 31 ? n.a(view) : (String[]) view.getTag(r.e.f7267N);
    }

    public static int C(View view) {
        return view.getPaddingEnd();
    }

    public static int D(View view) {
        return view.getPaddingStart();
    }

    public static Z E(View view) {
        return Build.VERSION.SDK_INT >= 23 ? i.a(view) : h.j(view);
    }

    public static CharSequence F(View view) {
        return (CharSequence) x0().e(view);
    }

    public static String G(View view) {
        return h.k(view);
    }

    public static int H(View view) {
        return view.getWindowSystemUiVisibility();
    }

    public static float I(View view) {
        return h.m(view);
    }

    public static boolean J(View view) {
        return l(view) != null;
    }

    public static boolean K(View view) {
        return view.hasOverlappingRendering();
    }

    public static boolean L(View view) {
        return view.hasTransientState();
    }

    public static boolean M(View view) {
        Boolean bool = (Boolean) b().e(view);
        return bool != null && bool.booleanValue();
    }

    public static boolean N(View view) {
        return view.isAttachedToWindow();
    }

    public static boolean O(View view) {
        return view.isLaidOut();
    }

    public static boolean P(View view) {
        return h.p(view);
    }

    public static boolean Q(View view) {
        return view.isPaddingRelative();
    }

    public static boolean R(View view) {
        Boolean bool = (Boolean) e0().e(view);
        return bool != null && bool.booleanValue();
    }

    public static /* synthetic */ C0161d S(C0161d c0161d) {
        return c0161d;
    }

    static void T(View view, int i2) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z2 = n(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z2) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z2 ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(i2);
                if (z2) {
                    accessibilityEventObtain.getText().add(n(view));
                    q0(view);
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i2 == 32) {
                AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.setEventType(32);
                accessibilityEventObtain2.setContentChangeTypes(i2);
                accessibilityEventObtain2.setSource(view);
                view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.getText().add(n(view));
                accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
                return;
            }
            if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i2);
                } catch (AbstractMethodError e2) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e2);
                }
            }
        }
    }

    public static void U(View view, int i2) {
        boolean z2;
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(i2);
            return;
        }
        Rect rectT = t();
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            rectT.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z2 = !rectT.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        } else {
            z2 = false;
        }
        d(view, i2);
        if (z2 && rectT.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(rectT);
        }
    }

    public static void V(View view, int i2) {
        boolean z2;
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(i2);
            return;
        }
        Rect rectT = t();
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            rectT.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z2 = !rectT.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        } else {
            z2 = false;
        }
        e(view, i2);
        if (z2 && rectT.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(rectT);
        }
    }

    public static Z W(View view, Z z2) {
        WindowInsets windowInsetsT = z2.t();
        if (windowInsetsT != null) {
            WindowInsets windowInsetsB = g.b(view, windowInsetsT);
            if (!windowInsetsB.equals(windowInsetsT)) {
                return Z.v(windowInsetsB, view);
            }
        }
        return z2;
    }

    private static f X() {
        return new b(r.e.f7264K, CharSequence.class, 8, 28);
    }

    public static C0161d Y(View view, C0161d c0161d) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + c0161d + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return n.b(view, c0161d);
        }
        G g2 = (G) view.getTag(r.e.f7266M);
        if (g2 == null) {
            return u(view).a(c0161d);
        }
        C0161d c0161dA = g2.a(view, c0161d);
        if (c0161dA == null) {
            return null;
        }
        return u(view).a(c0161dA);
    }

    public static void Z(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void a0(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    private static f b() {
        return new d(r.e.f7263J, Boolean.class, 28);
    }

    public static void b0(View view, Runnable runnable, long j2) {
        view.postOnAnimationDelayed(runnable, j2);
    }

    public static V c(View view) {
        if (f3095a == null) {
            f3095a = new WeakHashMap();
        }
        V v2 = (V) f3095a.get(view);
        if (v2 != null) {
            return v2;
        }
        V v3 = new V(view);
        f3095a.put(view, v3);
        return v3;
    }

    public static void c0(View view) {
        g.c(view);
    }

    private static void d(View view, int i2) {
        view.offsetLeftAndRight(i2);
        if (view.getVisibility() == 0) {
            z0(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                z0((View) parent);
            }
        }
    }

    public static void d0(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 29) {
            l.d(view, context, iArr, attributeSet, typedArray, i2, i3);
        }
    }

    private static void e(View view, int i2) {
        view.offsetTopAndBottom(i2);
        if (view.getVisibility() == 0) {
            z0(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                z0((View) parent);
            }
        }
    }

    private static f e0() {
        return new a(r.e.f7268O, Boolean.class, 28);
    }

    public static Z f(View view, Z z2, Rect rect) {
        return h.b(view, z2, rect);
    }

    public static void f0(View view, C0158a c0158a) {
        if (c0158a == null && (l(view) instanceof C0158a.C0032a)) {
            c0158a = new C0158a();
        }
        q0(view);
        view.setAccessibilityDelegate(c0158a == null ? null : c0158a.d());
    }

    public static Z g(View view, Z z2) {
        WindowInsets windowInsetsT = z2.t();
        if (windowInsetsT != null) {
            WindowInsets windowInsetsA = g.a(view, windowInsetsT);
            if (!windowInsetsA.equals(windowInsetsT)) {
                return Z.v(windowInsetsA, view);
            }
        }
        return z2;
    }

    public static void g0(View view, boolean z2) {
        b().f(view, Boolean.valueOf(z2));
    }

    static boolean h(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return q.a(view).b(view, keyEvent);
    }

    public static void h0(View view, CharSequence charSequence) {
        X().f(view, charSequence);
        if (charSequence != null) {
            f3100g.a(view);
        } else {
            f3100g.d(view);
        }
    }

    static boolean i(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return q.a(view).f(keyEvent);
    }

    public static void i0(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    static void j(View view) {
        C0158a c0158aK = k(view);
        if (c0158aK == null) {
            c0158aK = new C0158a();
        }
        f0(view, c0158aK);
    }

    public static void j0(View view, ColorStateList colorStateList) {
        int i2 = Build.VERSION.SDK_INT;
        h.q(view, colorStateList);
        if (i2 == 21) {
            Drawable background = view.getBackground();
            boolean z2 = (h.g(view) == null && h.h(view) == null) ? false : true;
            if (background == null || !z2) {
                return;
            }
            if (background.isStateful()) {
                background.setState(view.getDrawableState());
            }
            view.setBackground(background);
        }
    }

    public static C0158a k(View view) {
        View.AccessibilityDelegate accessibilityDelegateL = l(view);
        if (accessibilityDelegateL == null) {
            return null;
        }
        return accessibilityDelegateL instanceof C0158a.C0032a ? ((C0158a.C0032a) accessibilityDelegateL).f3156a : new C0158a(accessibilityDelegateL);
    }

    public static void k0(View view, PorterDuff.Mode mode) {
        int i2 = Build.VERSION.SDK_INT;
        h.r(view, mode);
        if (i2 == 21) {
            Drawable background = view.getBackground();
            boolean z2 = (h.g(view) == null && h.h(view) == null) ? false : true;
            if (background == null || !z2) {
                return;
            }
            if (background.isStateful()) {
                background.setState(view.getDrawableState());
            }
            view.setBackground(background);
        }
    }

    private static View.AccessibilityDelegate l(View view) {
        return Build.VERSION.SDK_INT >= 29 ? l.a(view) : m(view);
    }

    public static void l0(View view, Rect rect) {
        view.setClipBounds(rect);
    }

    private static View.AccessibilityDelegate m(View view) {
        if (f3097c) {
            return null;
        }
        if (f3096b == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f3096b = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f3097c = true;
                return null;
            }
        }
        try {
            Object obj = f3096b.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f3097c = true;
            return null;
        }
    }

    public static void m0(View view, float f2) {
        h.s(view, f2);
    }

    public static CharSequence n(View view) {
        return (CharSequence) X().e(view);
    }

    public static void n0(View view, boolean z2) {
        view.setFitsSystemWindows(z2);
    }

    public static ColorStateList o(View view) {
        return h.g(view);
    }

    public static void o0(View view, boolean z2) {
        view.setHasTransientState(z2);
    }

    public static PorterDuff.Mode p(View view) {
        return h.h(view);
    }

    public static void p0(View view, int i2) {
        view.setImportantForAccessibility(i2);
    }

    public static Rect q(View view) {
        return view.getClipBounds();
    }

    private static void q0(View view) {
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
    }

    public static Display r(View view) {
        return view.getDisplay();
    }

    public static void r0(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            j.m(view, i2);
        }
    }

    public static float s(View view) {
        return h.i(view);
    }

    public static void s0(View view, F f2) {
        h.u(view, f2);
    }

    private static Rect t() {
        if (f3098d == null) {
            f3098d = new ThreadLocal();
        }
        Rect rect = (Rect) f3098d.get();
        if (rect == null) {
            rect = new Rect();
            f3098d.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static void t0(View view, int i2, int i3, int i4, int i5) {
        view.setPaddingRelative(i2, i3, i4, i5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static H u(View view) {
        return view instanceof H ? (H) view : f3099f;
    }

    public static void u0(View view, boolean z2) {
        e0().f(view, Boolean.valueOf(z2));
    }

    public static boolean v(View view) {
        return view.getFitsSystemWindows();
    }

    public static void v0(View view, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 23) {
            i.d(view, i2, i3);
        }
    }

    public static int w(View view) {
        return view.getImportantForAccessibility();
    }

    public static void w0(View view, String str) {
        h.v(view, str);
    }

    public static int x(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return j.c(view);
        }
        return 0;
    }

    private static f x0() {
        return new c(r.e.f7269P, CharSequence.class, 64, 30);
    }

    public static int y(View view) {
        return view.getLayoutDirection();
    }

    public static void y0(View view) {
        h.z(view);
    }

    public static int z(View view) {
        return view.getMinimumHeight();
    }

    private static void z0(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }
}
