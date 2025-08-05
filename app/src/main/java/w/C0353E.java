package w;

import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import defpackage.r;
import java.lang.ref.WeakReference;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import w.InterfaceC0356H;

/* renamed from: w.E */
/* loaded from: classes.dex */
public class C0353E {

    /* renamed from: d */
    private static int f7684d;

    /* renamed from: a */
    private final AccessibilityNodeInfo f7685a;

    /* renamed from: b */
    public int f7686b = -1;

    /* renamed from: c */
    private int f7687c = -1;

    /* renamed from: w.E$a */
    public static class a {

        /* renamed from: A */
        public static final a f7688A;

        /* renamed from: B */
        public static final a f7689B;

        /* renamed from: C */
        public static final a f7690C;

        /* renamed from: D */
        public static final a f7691D;

        /* renamed from: E */
        public static final a f7692E;

        /* renamed from: F */
        public static final a f7693F;

        /* renamed from: G */
        public static final a f7694G;

        /* renamed from: H */
        public static final a f7695H;

        /* renamed from: I */
        public static final a f7696I;

        /* renamed from: J */
        public static final a f7697J;

        /* renamed from: K */
        public static final a f7698K;

        /* renamed from: L */
        public static final a f7699L;

        /* renamed from: M */
        public static final a f7700M;

        /* renamed from: N */
        public static final a f7701N;

        /* renamed from: O */
        public static final a f7702O;

        /* renamed from: P */
        public static final a f7703P;

        /* renamed from: Q */
        public static final a f7704Q;

        /* renamed from: R */
        public static final a f7705R;

        /* renamed from: S */
        public static final a f7706S;

        /* renamed from: T */
        public static final a f7707T;

        /* renamed from: U */
        public static final a f7708U;

        /* renamed from: d */
        public static final a f7709d = new a(1, null);
        public static final a e = new a(2, null);

        /* renamed from: f */
        public static final a f7710f = new a(4, null);

        /* renamed from: g */
        public static final a f7711g = new a(8, null);

        /* renamed from: h */
        public static final a f7712h = new a(16, null);

        /* renamed from: i */
        public static final a f7713i = new a(32, null);

        /* renamed from: j */
        public static final a f7714j = new a(64, null);

        /* renamed from: k */
        public static final a f7715k = new a(128, null);

        /* renamed from: l */
        public static final a f7716l = new a(256, null, InterfaceC0356H.b.class);

        /* renamed from: m */
        public static final a f7717m = new a(512, null, InterfaceC0356H.b.class);

        /* renamed from: n */
        public static final a f7718n = new a(1024, null, InterfaceC0356H.c.class);
        public static final a o = new a(2048, null, InterfaceC0356H.c.class);

        /* renamed from: p */
        public static final a f7719p = new a(4096, null);

        /* renamed from: q */
        public static final a f7720q = new a(8192, null);
        public static final a r = new a(16384, null);
        public static final a s = new a(32768, null);

        /* renamed from: t */
        public static final a f7721t = new a(ArrayPool.STANDARD_BUFFER_SIZE_BYTES, null);

        /* renamed from: u */
        public static final a f7722u = new a(131072, null, InterfaceC0356H.g.class);

        /* renamed from: v */
        public static final a f7723v = new a(262144, null);

        /* renamed from: w */
        public static final a f7724w = new a(524288, null);

        /* renamed from: x */
        public static final a f7725x = new a(1048576, null);

        /* renamed from: y */
        public static final a f7726y = new a(2097152, null, InterfaceC0356H.h.class);

        /* renamed from: z */
        public static final a f7727z;

        /* renamed from: a */
        final Object f7728a;

        /* renamed from: b */
        private final int f7729b;

        /* renamed from: c */
        private final Class f7730c;

        static {
            int i2 = Build.VERSION.SDK_INT;
            f7727z = new a(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, R.id.accessibilityActionShowOnScreen, null, null, null);
            f7688A = new a(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, R.id.accessibilityActionScrollToPosition, null, null, InterfaceC0356H.e.class);
            f7689B = new a(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, R.id.accessibilityActionScrollUp, null, null, null);
            f7690C = new a(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, R.id.accessibilityActionScrollLeft, null, null, null);
            f7691D = new a(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, R.id.accessibilityActionScrollDown, null, null, null);
            f7692E = new a(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, R.id.accessibilityActionScrollRight, null, null, null);
            f7693F = new a(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null, null, null);
            f7694G = new a(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, R.id.accessibilityActionPageDown, null, null, null);
            f7695H = new a(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
            f7696I = new a(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id.accessibilityActionPageRight, null, null, null);
            f7697J = new a(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null, R.id.accessibilityActionContextClick, null, null, null);
            f7698K = new a(i2 >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, R.id.accessibilityActionSetProgress, null, null, InterfaceC0356H.f.class);
            f7699L = new a(i2 >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, R.id.accessibilityActionMoveWindow, null, null, InterfaceC0356H.d.class);
            f7700M = new a(i2 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, R.id.accessibilityActionShowTooltip, null, null, null);
            f7701N = new a(i2 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, R.id.accessibilityActionHideTooltip, null, null, null);
            f7702O = new a(i2 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null, null);
            f7703P = new a(i2 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, R.id.accessibilityActionImeEnter, null, null, null);
            f7704Q = new a(i2 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, R.id.accessibilityActionDragStart, null, null, null);
            f7705R = new a(i2 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP : null, R.id.accessibilityActionDragDrop, null, null, null);
            f7706S = new a(i2 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL : null, R.id.accessibilityActionDragCancel, null, null, null);
            f7707T = new a(i2 >= 33 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS : null, R.id.accessibilityActionShowTextSuggestions, null, null, null);
            f7708U = new a(i2 >= 34 ? d.a() : null, R.id.accessibilityActionScrollInDirection, null, null, null);
        }

        public a(int i2, CharSequence charSequence) {
            this(null, i2, charSequence, null, null);
        }

        public int a() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f7728a).getId();
        }

        public CharSequence b() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f7728a).getLabel();
        }

        public boolean c(View view, Bundle bundle) {
            return false;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            Object obj2 = this.f7728a;
            return obj2 == null ? aVar.f7728a == null : obj2.equals(aVar.f7728a);
        }

        public int hashCode() {
            Object obj = this.f7728a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AccessibilityActionCompat: ");
            String strH = C0353E.h(this.f7729b);
            if (strH.equals("ACTION_UNKNOWN") && b() != null) {
                strH = b().toString();
            }
            sb.append(strH);
            return sb.toString();
        }

        a(Object obj) {
            this(obj, 0, null, null, null);
        }

        private a(int i2, CharSequence charSequence, Class cls) {
            this(null, i2, charSequence, null, cls);
        }

        a(Object obj, int i2, CharSequence charSequence, InterfaceC0356H interfaceC0356H, Class cls) {
            this.f7729b = i2;
            if (obj == null) {
                this.f7728a = new AccessibilityNodeInfo.AccessibilityAction(i2, charSequence);
            } else {
                this.f7728a = obj;
            }
            this.f7730c = cls;
        }
    }

    /* renamed from: w.E$b */
    private static class b {
        public static Object a(int i2, float f2, float f3, float f4) {
            return new AccessibilityNodeInfo.RangeInfo(i2, f2, f3, f4);
        }

        public static CharSequence b(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getStateDescription();
        }

        public static void c(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setStateDescription(charSequence);
        }
    }

    /* renamed from: w.E$c */
    private static class c {
        public static f a(boolean z2, int i2, int i3, int i4, int i5, boolean z3, String str, String str2) {
            return new f(new AccessibilityNodeInfo.CollectionItemInfo.Builder().setHeading(z2).setColumnIndex(i2).setRowIndex(i3).setColumnSpan(i4).setRowSpan(i5).setSelected(z3).setRowTitle(str).setColumnTitle(str2).build());
        }

        public static C0353E b(AccessibilityNodeInfo accessibilityNodeInfo, int i2, int i3) {
            return C0353E.i0(accessibilityNodeInfo.getChild(i2, i3));
        }

        public static String c(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getColumnTitle();
        }

        public static String d(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getRowTitle();
        }

        public static AccessibilityNodeInfo.ExtraRenderingInfo e(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getExtraRenderingInfo();
        }

        public static C0353E f(AccessibilityNodeInfo accessibilityNodeInfo, int i2) {
            return C0353E.i0(accessibilityNodeInfo.getParent(i2));
        }

        public static String g(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getUniqueId();
        }

        public static boolean h(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isTextSelectable();
        }

        public static void i(AccessibilityNodeInfo accessibilityNodeInfo, boolean z2) {
            accessibilityNodeInfo.setTextSelectable(z2);
        }

        public static void j(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
            accessibilityNodeInfo.setUniqueId(str);
        }
    }

    /* renamed from: w.E$d */
    private static class d {
        public static AccessibilityNodeInfo.AccessibilityAction a() {
            return AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
        }

        public static void b(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.getBoundsInWindow(rect);
        }

        public static CharSequence c(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getContainerTitle();
        }

        public static long d(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getMinDurationBetweenContentChanges().toMillis();
        }

        public static boolean e(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.hasRequestInitialAccessibilityFocus();
        }

        public static boolean f(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isAccessibilityDataSensitive();
        }

        public static void g(AccessibilityNodeInfo accessibilityNodeInfo, boolean z2) {
            accessibilityNodeInfo.setAccessibilityDataSensitive(z2);
        }

        public static void h(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.setBoundsInWindow(rect);
        }

        public static void i(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setContainerTitle(charSequence);
        }

        public static void j(AccessibilityNodeInfo accessibilityNodeInfo, long j2) {
            accessibilityNodeInfo.setMinDurationBetweenContentChanges(Duration.ofMillis(j2));
        }

        public static void k(AccessibilityNodeInfo accessibilityNodeInfo, View view, boolean z2) {
            accessibilityNodeInfo.setQueryFromAppProcessEnabled(view, z2);
        }

        public static void l(AccessibilityNodeInfo accessibilityNodeInfo, boolean z2) {
            accessibilityNodeInfo.setRequestInitialAccessibilityFocus(z2);
        }
    }

    /* renamed from: w.E$e */
    public static class e {

        /* renamed from: a */
        final Object f7731a;

        e(Object obj) {
            this.f7731a = obj;
        }

        public static e a(int i2, int i3, boolean z2, int i4) {
            return new e(AccessibilityNodeInfo.CollectionInfo.obtain(i2, i3, z2, i4));
        }
    }

    /* renamed from: w.E$f */
    public static class f {

        /* renamed from: a */
        final Object f7732a;

        f(Object obj) {
            this.f7732a = obj;
        }

        public static f a(int i2, int i3, int i4, int i5, boolean z2, boolean z3) {
            return new f(AccessibilityNodeInfo.CollectionItemInfo.obtain(i2, i3, i4, i5, z2, z3));
        }
    }

    public C0353E(Object obj) {
        this.f7685a = (AccessibilityNodeInfo) obj;
    }

    private boolean B() {
        return !f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    private int C(ClickableSpan clickableSpan, SparseArray sparseArray) {
        if (sparseArray != null) {
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                if (clickableSpan.equals((ClickableSpan) ((WeakReference) sparseArray.valueAt(i2)).get())) {
                    return sparseArray.keyAt(i2);
                }
            }
        }
        int i3 = f7684d;
        f7684d = i3 + 1;
        return i3;
    }

    private void U(View view) {
        SparseArray sparseArrayV = v(view);
        if (sparseArrayV != null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArrayV.size(); i2++) {
                if (((WeakReference) sparseArrayV.valueAt(i2)).get() == null) {
                    arrayList.add(Integer.valueOf(i2));
                }
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                sparseArrayV.remove(((Integer) arrayList.get(i3)).intValue());
            }
        }
    }

    private void V(int i2, boolean z2) {
        Bundle bundleR = r();
        if (bundleR != null) {
            int i3 = bundleR.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i2);
            if (!z2) {
                i2 = 0;
            }
            bundleR.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i2 | i3);
        }
    }

    private void c(ClickableSpan clickableSpan, Spanned spanned, int i2) {
        f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i2));
    }

    private void e() {
        this.f7685a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        this.f7685a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        this.f7685a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        this.f7685a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
    }

    private List f(String str) {
        ArrayList<Integer> integerArrayList = this.f7685a.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f7685a.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    static String h(int i2) {
        if (i2 == 1) {
            return "ACTION_FOCUS";
        }
        if (i2 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i2) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case ArrayPool.STANDARD_BUFFER_SIZE_BYTES /* 65536 */:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case R.id.accessibilityActionMoveWindow:
                return "ACTION_MOVE_WINDOW";
            case R.id.accessibilityActionScrollInDirection:
                return "ACTION_SCROLL_IN_DIRECTION";
            default:
                switch (i2) {
                    case R.id.accessibilityActionShowOnScreen:
                        return "ACTION_SHOW_ON_SCREEN";
                    case R.id.accessibilityActionScrollToPosition:
                        return "ACTION_SCROLL_TO_POSITION";
                    case R.id.accessibilityActionScrollUp:
                        return "ACTION_SCROLL_UP";
                    case R.id.accessibilityActionScrollLeft:
                        return "ACTION_SCROLL_LEFT";
                    case R.id.accessibilityActionScrollDown:
                        return "ACTION_SCROLL_DOWN";
                    case R.id.accessibilityActionScrollRight:
                        return "ACTION_SCROLL_RIGHT";
                    case R.id.accessibilityActionContextClick:
                        return "ACTION_CONTEXT_CLICK";
                    case R.id.accessibilityActionSetProgress:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i2) {
                            case R.id.accessibilityActionShowTooltip:
                                return "ACTION_SHOW_TOOLTIP";
                            case R.id.accessibilityActionHideTooltip:
                                return "ACTION_HIDE_TOOLTIP";
                            case R.id.accessibilityActionPageUp:
                                return "ACTION_PAGE_UP";
                            case R.id.accessibilityActionPageDown:
                                return "ACTION_PAGE_DOWN";
                            case R.id.accessibilityActionPageLeft:
                                return "ACTION_PAGE_LEFT";
                            case R.id.accessibilityActionPageRight:
                                return "ACTION_PAGE_RIGHT";
                            case R.id.accessibilityActionPressAndHold:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                switch (i2) {
                                    case R.id.accessibilityActionImeEnter:
                                        return "ACTION_IME_ENTER";
                                    case R.id.accessibilityActionDragStart:
                                        return "ACTION_DRAG_START";
                                    case R.id.accessibilityActionDragDrop:
                                        return "ACTION_DRAG_DROP";
                                    case R.id.accessibilityActionDragCancel:
                                        return "ACTION_DRAG_CANCEL";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
        }
    }

    public static C0353E h0(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new C0353E(accessibilityNodeInfo);
    }

    private boolean i(int i2) {
        Bundle bundleR = r();
        return bundleR != null && (bundleR.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i2) == i2;
    }

    static C0353E i0(Object obj) {
        if (obj != null) {
            return new C0353E(obj);
        }
        return null;
    }

    public static ClickableSpan[] n(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    private SparseArray t(View view) {
        SparseArray sparseArrayV = v(view);
        if (sparseArrayV != null) {
            return sparseArrayV;
        }
        SparseArray sparseArray = new SparseArray();
        view.setTag(r.e.f7262I, sparseArray);
        return sparseArray;
    }

    private SparseArray v(View view) {
        return (SparseArray) view.getTag(r.e.f7262I);
    }

    public String A() {
        return this.f7685a.getViewIdResourceName();
    }

    public boolean D() {
        return Build.VERSION.SDK_INT >= 34 ? d.f(this.f7685a) : i(64);
    }

    public boolean E() {
        return this.f7685a.isCheckable();
    }

    public boolean F() {
        return this.f7685a.isChecked();
    }

    public boolean G() {
        return this.f7685a.isClickable();
    }

    public boolean H() {
        if (Build.VERSION.SDK_INT >= 23) {
            return this.f7685a.isContextClickable();
        }
        return false;
    }

    public boolean I() {
        return this.f7685a.isEnabled();
    }

    public boolean J() {
        return this.f7685a.isFocusable();
    }

    public boolean K() {
        return this.f7685a.isFocused();
    }

    public boolean L() {
        return i(67108864);
    }

    public boolean M() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.f7685a.isImportantForAccessibility();
        }
        return true;
    }

    public boolean N() {
        return this.f7685a.isLongClickable();
    }

    public boolean O() {
        return this.f7685a.isPassword();
    }

    public boolean P() {
        return this.f7685a.isScrollable();
    }

    public boolean Q() {
        return this.f7685a.isSelected();
    }

    public boolean R() {
        return Build.VERSION.SDK_INT >= 33 ? c.h(this.f7685a) : i(8388608);
    }

    public boolean S() {
        return this.f7685a.isVisibleToUser();
    }

    public boolean T(int i2, Bundle bundle) {
        return this.f7685a.performAction(i2, bundle);
    }

    public void W(boolean z2) {
        this.f7685a.setCheckable(z2);
    }

    public void X(boolean z2) {
        this.f7685a.setChecked(z2);
    }

    public void Y(CharSequence charSequence) {
        this.f7685a.setClassName(charSequence);
    }

    public void Z(Object obj) {
        this.f7685a.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((e) obj).f7731a);
    }

    public void a(int i2) {
        this.f7685a.addAction(i2);
    }

    public void a0(Object obj) {
        this.f7685a.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((f) obj).f7732a);
    }

    public void b(a aVar) {
        this.f7685a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f7728a);
    }

    public void b0(boolean z2) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f7685a.setHeading(z2);
        } else {
            V(2, z2);
        }
    }

    public void c0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f7685a.setPaneTitle(charSequence);
        } else {
            this.f7685a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public void d(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT < 26) {
            e();
            U(view);
            ClickableSpan[] clickableSpanArrN = n(charSequence);
            if (clickableSpanArrN == null || clickableSpanArrN.length <= 0) {
                return;
            }
            r().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", r.e.f7273a);
            SparseArray sparseArrayT = t(view);
            for (int i2 = 0; i2 < clickableSpanArrN.length; i2++) {
                int iC = C(clickableSpanArrN[i2], sparseArrayT);
                sparseArrayT.put(iC, new WeakReference(clickableSpanArrN[i2]));
                c(clickableSpanArrN[i2], (Spanned) charSequence, iC);
            }
        }
    }

    public void d0(boolean z2) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f7685a.setScreenReaderFocusable(z2);
        } else {
            V(1, z2);
        }
    }

    public void e0(boolean z2) {
        this.f7685a.setScrollable(z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof C0353E)) {
            return false;
        }
        C0353E c0353e = (C0353E) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f7685a;
        if (accessibilityNodeInfo == null) {
            if (c0353e.f7685a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(c0353e.f7685a)) {
            return false;
        }
        return this.f7687c == c0353e.f7687c && this.f7686b == c0353e.f7686b;
    }

    public void f0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            b.c(this.f7685a, charSequence);
        } else {
            this.f7685a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    public List g() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.f7685a.getActionList();
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new a(actionList.get(i2)));
        }
        return arrayList;
    }

    public AccessibilityNodeInfo g0() {
        return this.f7685a;
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f7685a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public void j(Rect rect) {
        this.f7685a.getBoundsInParent(rect);
    }

    public void k(Rect rect) {
        this.f7685a.getBoundsInScreen(rect);
    }

    public void l(Rect rect) {
        if (Build.VERSION.SDK_INT >= 34) {
            d.b(this.f7685a, rect);
            return;
        }
        Rect rect2 = (Rect) this.f7685a.getExtras().getParcelable("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOUNDS_IN_WINDOW_KEY");
        if (rect2 != null) {
            rect.set(rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
    }

    public CharSequence m() {
        return this.f7685a.getClassName();
    }

    public CharSequence o() {
        return Build.VERSION.SDK_INT >= 34 ? d.c(this.f7685a) : this.f7685a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.CONTAINER_TITLE_KEY");
    }

    public CharSequence p() {
        return this.f7685a.getContentDescription();
    }

    public CharSequence q() {
        return this.f7685a.getError();
    }

    public Bundle r() {
        return this.f7685a.getExtras();
    }

    public int s() {
        return this.f7685a.getMaxTextLength();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        j(rect);
        sb.append("; boundsInParent: " + rect);
        k(rect);
        sb.append("; boundsInScreen: " + rect);
        l(rect);
        sb.append("; boundsInWindow: " + rect);
        sb.append("; packageName: ");
        sb.append(u());
        sb.append("; className: ");
        sb.append(m());
        sb.append("; text: ");
        sb.append(x());
        sb.append("; error: ");
        sb.append(q());
        sb.append("; maxTextLength: ");
        sb.append(s());
        sb.append("; stateDescription: ");
        sb.append(w());
        sb.append("; contentDescription: ");
        sb.append(p());
        sb.append("; tooltipText: ");
        sb.append(y());
        sb.append("; viewIdResName: ");
        sb.append(A());
        sb.append("; uniqueId: ");
        sb.append(z());
        sb.append("; checkable: ");
        sb.append(E());
        sb.append("; checked: ");
        sb.append(F());
        sb.append("; focusable: ");
        sb.append(J());
        sb.append("; focused: ");
        sb.append(K());
        sb.append("; selected: ");
        sb.append(Q());
        sb.append("; clickable: ");
        sb.append(G());
        sb.append("; longClickable: ");
        sb.append(N());
        sb.append("; contextClickable: ");
        sb.append(H());
        sb.append("; enabled: ");
        sb.append(I());
        sb.append("; password: ");
        sb.append(O());
        sb.append("; scrollable: " + P());
        sb.append("; containerTitle: ");
        sb.append(o());
        sb.append("; granularScrollingSupported: ");
        sb.append(L());
        sb.append("; importantForAccessibility: ");
        sb.append(M());
        sb.append("; visible: ");
        sb.append(S());
        sb.append("; isTextSelectable: ");
        sb.append(R());
        sb.append("; accessibilityDataSensitive: ");
        sb.append(D());
        sb.append("; [");
        List listG = g();
        for (int i2 = 0; i2 < listG.size(); i2++) {
            a aVar = (a) listG.get(i2);
            String strH = h(aVar.a());
            if (strH.equals("ACTION_UNKNOWN") && aVar.b() != null) {
                strH = aVar.b().toString();
            }
            sb.append(strH);
            if (i2 != listG.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public CharSequence u() {
        return this.f7685a.getPackageName();
    }

    public CharSequence w() {
        return Build.VERSION.SDK_INT >= 30 ? b.b(this.f7685a) : this.f7685a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY");
    }

    public CharSequence x() {
        if (!B()) {
            return this.f7685a.getText();
        }
        List listF = f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List listF2 = f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List listF3 = f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List listF4 = f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f7685a.getText(), 0, this.f7685a.getText().length()));
        for (int i2 = 0; i2 < listF.size(); i2++) {
            spannableString.setSpan(new C0357a(((Integer) listF4.get(i2)).intValue(), this, r().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer) listF.get(i2)).intValue(), ((Integer) listF2.get(i2)).intValue(), ((Integer) listF3.get(i2)).intValue());
        }
        return spannableString;
    }

    public CharSequence y() {
        return Build.VERSION.SDK_INT >= 28 ? this.f7685a.getTooltipText() : this.f7685a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY");
    }

    public String z() {
        return Build.VERSION.SDK_INT >= 33 ? c.g(this.f7685a) : this.f7685a.getExtras().getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY");
    }

    private C0353E(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f7685a = accessibilityNodeInfo;
    }
}
