package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.app.AbstractC0126a;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.AbstractC0176t;
import androidx.core.view.C0180x;
import androidx.core.view.InterfaceC0179w;
import androidx.core.view.InterfaceC0182z;
import com.bumptech.glide.request.target.Target;
import defpackage.e;
import f.AbstractC0250a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class Toolbar extends ViewGroup implements InterfaceC0179w {

    /* renamed from: A, reason: collision with root package name */
    private ColorStateList f2279A;

    /* renamed from: B, reason: collision with root package name */
    private boolean f2280B;

    /* renamed from: C, reason: collision with root package name */
    private boolean f2281C;

    /* renamed from: D, reason: collision with root package name */
    private final ArrayList f2282D;

    /* renamed from: E, reason: collision with root package name */
    private final ArrayList f2283E;

    /* renamed from: F, reason: collision with root package name */
    private final int[] f2284F;

    /* renamed from: G, reason: collision with root package name */
    final C0180x f2285G;

    /* renamed from: H, reason: collision with root package name */
    private ArrayList f2286H;

    /* renamed from: I, reason: collision with root package name */
    private final ActionMenuView.e f2287I;

    /* renamed from: J, reason: collision with root package name */
    private h0 f2288J;

    /* renamed from: K, reason: collision with root package name */
    private C0135c f2289K;

    /* renamed from: L, reason: collision with root package name */
    private f f2290L;

    /* renamed from: M, reason: collision with root package name */
    private j.a f2291M;

    /* renamed from: N, reason: collision with root package name */
    e.a f2292N;

    /* renamed from: O, reason: collision with root package name */
    private boolean f2293O;

    /* renamed from: P, reason: collision with root package name */
    private OnBackInvokedCallback f2294P;

    /* renamed from: Q, reason: collision with root package name */
    private OnBackInvokedDispatcher f2295Q;

    /* renamed from: R, reason: collision with root package name */
    private boolean f2296R;

    /* renamed from: S, reason: collision with root package name */
    private final Runnable f2297S;

    /* renamed from: a, reason: collision with root package name */
    ActionMenuView f2298a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f2299b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f2300c;

    /* renamed from: d, reason: collision with root package name */
    private ImageButton f2301d;
    private ImageView e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f2302f;

    /* renamed from: g, reason: collision with root package name */
    private CharSequence f2303g;

    /* renamed from: h, reason: collision with root package name */
    ImageButton f2304h;

    /* renamed from: i, reason: collision with root package name */
    View f2305i;

    /* renamed from: j, reason: collision with root package name */
    private Context f2306j;

    /* renamed from: k, reason: collision with root package name */
    private int f2307k;

    /* renamed from: l, reason: collision with root package name */
    private int f2308l;

    /* renamed from: m, reason: collision with root package name */
    private int f2309m;

    /* renamed from: n, reason: collision with root package name */
    int f2310n;
    private int o;

    /* renamed from: p, reason: collision with root package name */
    private int f2311p;

    /* renamed from: q, reason: collision with root package name */
    private int f2312q;
    private int r;
    private int s;

    /* renamed from: t, reason: collision with root package name */
    private X f2313t;

    /* renamed from: u, reason: collision with root package name */
    private int f2314u;

    /* renamed from: v, reason: collision with root package name */
    private int f2315v;

    /* renamed from: w, reason: collision with root package name */
    private int f2316w;

    /* renamed from: x, reason: collision with root package name */
    private CharSequence f2317x;

    /* renamed from: y, reason: collision with root package name */
    private CharSequence f2318y;

    /* renamed from: z, reason: collision with root package name */
    private ColorStateList f2319z;

    class a implements ActionMenuView.e {
        a() {
        }

        @Override // androidx.appcompat.widget.ActionMenuView.e
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (Toolbar.this.f2285G.d(menuItem)) {
                return true;
            }
            Toolbar.this.getClass();
            return false;
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Toolbar.this.R();
        }
    }

    class c implements e.a {
        c() {
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            e.a aVar = Toolbar.this.f2292N;
            return aVar != null && aVar.a(eVar, menuItem);
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(androidx.appcompat.view.menu.e eVar) {
            if (!Toolbar.this.f2298a.J()) {
                Toolbar.this.f2285G.e(eVar);
            }
            e.a aVar = Toolbar.this.f2292N;
            if (aVar != null) {
                aVar.b(eVar);
            }
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Toolbar.this.e();
        }
    }

    static class e {
        static OnBackInvokedDispatcher a(View view) {
            return view.findOnBackInvokedDispatcher();
        }

        static OnBackInvokedCallback b(final Runnable runnable) {
            Objects.requireNonNull(runnable);
            return new OnBackInvokedCallback() { // from class: androidx.appcompat.widget.g0
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    runnable.run();
                }
            };
        }

        static void c(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback) obj2);
        }

        static void d(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    private class f implements androidx.appcompat.view.menu.j {

        /* renamed from: a, reason: collision with root package name */
        androidx.appcompat.view.menu.e f2324a;

        /* renamed from: b, reason: collision with root package name */
        androidx.appcompat.view.menu.g f2325b;

        f() {
        }

        @Override // androidx.appcompat.view.menu.j
        public void a(androidx.appcompat.view.menu.e eVar, boolean z2) {
        }

        @Override // androidx.appcompat.view.menu.j
        public boolean c() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.j
        public void d(Context context, androidx.appcompat.view.menu.e eVar) {
            androidx.appcompat.view.menu.g gVar;
            androidx.appcompat.view.menu.e eVar2 = this.f2324a;
            if (eVar2 != null && (gVar = this.f2325b) != null) {
                eVar2.f(gVar);
            }
            this.f2324a = eVar;
        }

        @Override // androidx.appcompat.view.menu.j
        public boolean e(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.g gVar) {
            KeyEvent.Callback callback = Toolbar.this.f2305i;
            if (callback instanceof androidx.appcompat.view.c) {
                ((androidx.appcompat.view.c) callback).f();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f2305i);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f2304h);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f2305i = null;
            toolbar3.a();
            this.f2325b = null;
            Toolbar.this.requestLayout();
            gVar.r(false);
            Toolbar.this.S();
            return true;
        }

        @Override // androidx.appcompat.view.menu.j
        public boolean g(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.g gVar) {
            Toolbar.this.g();
            ViewParent parent = Toolbar.this.f2304h.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f2304h);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.f2304h);
            }
            Toolbar.this.f2305i = gVar.getActionView();
            this.f2325b = gVar;
            ViewParent parent2 = Toolbar.this.f2305i.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.f2305i);
                }
                g gVarGenerateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                gVarGenerateDefaultLayoutParams.f1699a = (toolbar4.f2310n & 112) | 8388611;
                gVarGenerateDefaultLayoutParams.f2327b = 2;
                toolbar4.f2305i.setLayoutParams(gVarGenerateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.f2305i);
            }
            Toolbar.this.K();
            Toolbar.this.requestLayout();
            gVar.r(true);
            KeyEvent.Callback callback = Toolbar.this.f2305i;
            if (callback instanceof androidx.appcompat.view.c) {
                ((androidx.appcompat.view.c) callback).c();
            }
            Toolbar.this.S();
            return true;
        }

        @Override // androidx.appcompat.view.menu.j
        public boolean i(androidx.appcompat.view.menu.m mVar) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.j
        public void j(boolean z2) {
            if (this.f2325b != null) {
                androidx.appcompat.view.menu.e eVar = this.f2324a;
                if (eVar != null) {
                    int size = eVar.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        if (this.f2324a.getItem(i2) == this.f2325b) {
                            return;
                        }
                    }
                }
                e(this.f2324a, this.f2325b);
            }
        }
    }

    public interface h {
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, e.d.f5835H);
    }

    private boolean B(View view) {
        return view.getParent() == this || this.f2283E.contains(view);
    }

    private int E(View view, int i2, int[] iArr, int i3) {
        g gVar = (g) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) gVar).leftMargin - iArr[0];
        int iMax = i2 + Math.max(0, i4);
        iArr[0] = Math.max(0, -i4);
        int iS = s(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iS, iMax + measuredWidth, view.getMeasuredHeight() + iS);
        return iMax + measuredWidth + ((ViewGroup.MarginLayoutParams) gVar).rightMargin;
    }

    private int F(View view, int i2, int[] iArr, int i3) {
        g gVar = (g) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) gVar).rightMargin - iArr[1];
        int iMax = i2 - Math.max(0, i4);
        iArr[1] = Math.max(0, -i4);
        int iS = s(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iS, iMax, view.getMeasuredHeight() + iS);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) gVar).leftMargin);
    }

    private int G(View view, int i2, int i3, int i4, int i5, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i6 = marginLayoutParams.leftMargin - iArr[0];
        int i7 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i6) + Math.max(0, i7);
        iArr[0] = Math.max(0, -i6);
        iArr[1] = Math.max(0, -i7);
        view.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + iMax + i3, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    private void H(View view, int i2, int i3, int i4, int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i6 >= 0) {
            if (mode != 0) {
                i6 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i6);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void I() {
        Menu menu = getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        this.f2285G.b(menu, getMenuInflater());
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.f2286H = currentMenuItems2;
    }

    private void J() {
        removeCallbacks(this.f2297S);
        post(this.f2297S);
    }

    private boolean P() {
        if (!this.f2293O) {
            return false;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (Q(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean Q(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private void b(List list, int i2) {
        boolean z2 = getLayoutDirection() == 1;
        int childCount = getChildCount();
        int iB = AbstractC0176t.b(i2, getLayoutDirection());
        list.clear();
        if (!z2) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                g gVar = (g) childAt.getLayoutParams();
                if (gVar.f2327b == 0 && Q(childAt) && q(gVar.f1699a) == iB) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i4 = childCount - 1; i4 >= 0; i4--) {
            View childAt2 = getChildAt(i4);
            g gVar2 = (g) childAt2.getLayoutParams();
            if (gVar2.f2327b == 0 && Q(childAt2) && q(gVar2.f1699a) == iB) {
                list.add(childAt2);
            }
        }
    }

    private void c(View view, boolean z2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        g gVarGenerateDefaultLayoutParams = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (g) layoutParams;
        gVarGenerateDefaultLayoutParams.f2327b = 1;
        if (!z2 || this.f2305i == null) {
            addView(view, gVarGenerateDefaultLayoutParams);
        } else {
            view.setLayoutParams(gVarGenerateDefaultLayoutParams);
            this.f2283E.add(view);
        }
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i2 = 0; i2 < menu.size(); i2++) {
            arrayList.add(menu.getItem(i2));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new androidx.appcompat.view.g(getContext());
    }

    private void h() {
        if (this.f2313t == null) {
            this.f2313t = new X();
        }
    }

    private void i() {
        if (this.e == null) {
            this.e = new C0149q(getContext());
        }
    }

    private void j() {
        k();
        if (this.f2298a.N() == null) {
            androidx.appcompat.view.menu.e eVar = (androidx.appcompat.view.menu.e) this.f2298a.getMenu();
            if (this.f2290L == null) {
                this.f2290L = new f();
            }
            this.f2298a.setExpandedActionViewsExclusive(true);
            eVar.c(this.f2290L, this.f2306j);
            S();
        }
    }

    private void k() {
        if (this.f2298a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f2298a = actionMenuView;
            actionMenuView.setPopupTheme(this.f2307k);
            this.f2298a.setOnMenuItemClickListener(this.f2287I);
            this.f2298a.O(this.f2291M, new c());
            g gVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            gVarGenerateDefaultLayoutParams.f1699a = (this.f2310n & 112) | 8388613;
            this.f2298a.setLayoutParams(gVarGenerateDefaultLayoutParams);
            c(this.f2298a, false);
        }
    }

    private void l() {
        if (this.f2301d == null) {
            this.f2301d = new C0147o(getContext(), null, e.d.f5834G);
            g gVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            gVarGenerateDefaultLayoutParams.f1699a = (this.f2310n & 112) | 8388611;
            this.f2301d.setLayoutParams(gVarGenerateDefaultLayoutParams);
        }
    }

    private int q(int i2) {
        int layoutDirection = getLayoutDirection();
        int iB = AbstractC0176t.b(i2, layoutDirection) & 7;
        return (iB == 1 || iB == 3 || iB == 5) ? iB : layoutDirection == 1 ? 5 : 3;
    }

    private int s(View view, int i2) {
        g gVar = (g) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i3 = i2 > 0 ? (measuredHeight - i2) / 2 : 0;
        int iT = t(gVar.f1699a);
        if (iT == 48) {
            return getPaddingTop() - i3;
        }
        if (iT == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) gVar).bottomMargin) - i3;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i4 = ((ViewGroup.MarginLayoutParams) gVar).topMargin;
        if (iMax < i4) {
            iMax = i4;
        } else {
            int i5 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i6 = ((ViewGroup.MarginLayoutParams) gVar).bottomMargin;
            if (i5 < i6) {
                iMax = Math.max(0, iMax - (i6 - i5));
            }
        }
        return paddingTop + iMax;
    }

    private int t(int i2) {
        int i3 = i2 & 112;
        return (i3 == 16 || i3 == 48 || i3 == 80) ? i3 : this.f2316w & 112;
    }

    private int u(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginStart() + marginLayoutParams.getMarginEnd();
    }

    private int v(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private int w(List list, int[] iArr) {
        int i2 = iArr[0];
        int i3 = iArr[1];
        int size = list.size();
        int i4 = 0;
        int measuredWidth = 0;
        while (i4 < size) {
            View view = (View) list.get(i4);
            g gVar = (g) view.getLayoutParams();
            int i5 = ((ViewGroup.MarginLayoutParams) gVar).leftMargin - i2;
            int i6 = ((ViewGroup.MarginLayoutParams) gVar).rightMargin - i3;
            int iMax = Math.max(0, i5);
            int iMax2 = Math.max(0, i6);
            int iMax3 = Math.max(0, -i5);
            int iMax4 = Math.max(0, -i6);
            measuredWidth += iMax + view.getMeasuredWidth() + iMax2;
            i4++;
            i3 = iMax4;
            i2 = iMax3;
        }
        return measuredWidth;
    }

    public void A() {
        Iterator it = this.f2286H.iterator();
        while (it.hasNext()) {
            getMenu().removeItem(((MenuItem) it.next()).getItemId());
        }
        I();
    }

    public boolean C() {
        ActionMenuView actionMenuView = this.f2298a;
        return actionMenuView != null && actionMenuView.I();
    }

    public boolean D() {
        ActionMenuView actionMenuView = this.f2298a;
        return actionMenuView != null && actionMenuView.J();
    }

    void K() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((g) childAt.getLayoutParams()).f2327b != 2 && childAt != this.f2298a) {
                removeViewAt(childCount);
                this.f2283E.add(childAt);
            }
        }
    }

    public void L(int i2, int i3) {
        h();
        this.f2313t.g(i2, i3);
    }

    public void M(androidx.appcompat.view.menu.e eVar, C0135c c0135c) {
        if (eVar == null && this.f2298a == null) {
            return;
        }
        k();
        androidx.appcompat.view.menu.e eVarN = this.f2298a.N();
        if (eVarN == eVar) {
            return;
        }
        if (eVarN != null) {
            eVarN.P(this.f2289K);
            eVarN.P(this.f2290L);
        }
        if (this.f2290L == null) {
            this.f2290L = new f();
        }
        c0135c.G(true);
        if (eVar != null) {
            eVar.c(c0135c, this.f2306j);
            eVar.c(this.f2290L, this.f2306j);
        } else {
            c0135c.d(this.f2306j, null);
            this.f2290L.d(this.f2306j, null);
            c0135c.j(true);
            this.f2290L.j(true);
        }
        this.f2298a.setPopupTheme(this.f2307k);
        this.f2298a.setPresenter(c0135c);
        this.f2289K = c0135c;
        S();
    }

    public void N(Context context, int i2) {
        this.f2309m = i2;
        TextView textView = this.f2300c;
        if (textView != null) {
            textView.setTextAppearance(context, i2);
        }
    }

    public void O(Context context, int i2) {
        this.f2308l = i2;
        TextView textView = this.f2299b;
        if (textView != null) {
            textView.setTextAppearance(context, i2);
        }
    }

    public boolean R() {
        ActionMenuView actionMenuView = this.f2298a;
        return actionMenuView != null && actionMenuView.P();
    }

    void S() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcherA = e.a(this);
            boolean z2 = x() && onBackInvokedDispatcherA != null && isAttachedToWindow() && this.f2296R;
            if (z2 && this.f2295Q == null) {
                if (this.f2294P == null) {
                    this.f2294P = e.b(new Runnable() { // from class: androidx.appcompat.widget.e0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f2423a.e();
                        }
                    });
                }
                e.c(onBackInvokedDispatcherA, this.f2294P);
                this.f2295Q = onBackInvokedDispatcherA;
                return;
            }
            if (z2 || (onBackInvokedDispatcher = this.f2295Q) == null) {
                return;
            }
            e.d(onBackInvokedDispatcher, this.f2294P);
            this.f2295Q = null;
        }
    }

    void a() {
        for (int size = this.f2283E.size() - 1; size >= 0; size--) {
            addView((View) this.f2283E.get(size));
        }
        this.f2283E.clear();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof g);
    }

    public boolean d() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.f2298a) != null && actionMenuView.K();
    }

    public void e() {
        f fVar = this.f2290L;
        androidx.appcompat.view.menu.g gVar = fVar == null ? null : fVar.f2325b;
        if (gVar != null) {
            gVar.collapseActionView();
        }
    }

    public void f() {
        ActionMenuView actionMenuView = this.f2298a;
        if (actionMenuView != null) {
            actionMenuView.B();
        }
    }

    void g() {
        if (this.f2304h == null) {
            C0147o c0147o = new C0147o(getContext(), null, e.d.f5834G);
            this.f2304h = c0147o;
            c0147o.setImageDrawable(this.f2302f);
            this.f2304h.setContentDescription(this.f2303g);
            g gVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            gVarGenerateDefaultLayoutParams.f1699a = (this.f2310n & 112) | 8388611;
            gVarGenerateDefaultLayoutParams.f2327b = 2;
            this.f2304h.setLayoutParams(gVarGenerateDefaultLayoutParams);
            this.f2304h.setOnClickListener(new d());
        }
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.f2304h;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.f2304h;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        X x2 = this.f2313t;
        if (x2 != null) {
            return x2.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i2 = this.f2315v;
        return i2 != Integer.MIN_VALUE ? i2 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        X x2 = this.f2313t;
        if (x2 != null) {
            return x2.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        X x2 = this.f2313t;
        if (x2 != null) {
            return x2.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        X x2 = this.f2313t;
        if (x2 != null) {
            return x2.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i2 = this.f2314u;
        return i2 != Integer.MIN_VALUE ? i2 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        androidx.appcompat.view.menu.e eVarN;
        ActionMenuView actionMenuView = this.f2298a;
        return (actionMenuView == null || (eVarN = actionMenuView.N()) == null || !eVarN.hasVisibleItems()) ? getContentInsetEnd() : Math.max(getContentInsetEnd(), Math.max(this.f2315v, 0));
    }

    public int getCurrentContentInsetLeft() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.f2314u, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.e;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.e;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        j();
        return this.f2298a.getMenu();
    }

    View getNavButtonView() {
        return this.f2301d;
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f2301d;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f2301d;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    C0135c getOuterActionMenuPresenter() {
        return this.f2289K;
    }

    public Drawable getOverflowIcon() {
        j();
        return this.f2298a.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.f2306j;
    }

    public int getPopupTheme() {
        return this.f2307k;
    }

    public CharSequence getSubtitle() {
        return this.f2318y;
    }

    final TextView getSubtitleTextView() {
        return this.f2300c;
    }

    public CharSequence getTitle() {
        return this.f2317x;
    }

    public int getTitleMarginBottom() {
        return this.s;
    }

    public int getTitleMarginEnd() {
        return this.f2312q;
    }

    public int getTitleMarginStart() {
        return this.f2311p;
    }

    public int getTitleMarginTop() {
        return this.r;
    }

    final TextView getTitleTextView() {
        return this.f2299b;
    }

    public L getWrapper() {
        if (this.f2288J == null) {
            this.f2288J = new h0(this, true);
        }
        return this.f2288J;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public g generateDefaultLayoutParams() {
        return new g(-2, -2);
    }

    @Override // androidx.core.view.InterfaceC0179w
    public void n(InterfaceC0182z interfaceC0182z) {
        this.f2285G.f(interfaceC0182z);
    }

    @Override // android.view.ViewGroup
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public g generateLayoutParams(AttributeSet attributeSet) {
        return new g(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        S();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f2297S);
        S();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f2281C = false;
        }
        if (!this.f2281C) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f2281C = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f2281C = false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x02a1 A[LOOP:0: B:106:0x029f->B:107:0x02a1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02c3 A[LOOP:1: B:109:0x02c1->B:110:0x02c3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02fc A[LOOP:2: B:118:0x02fa->B:119:0x02fc, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0227  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 785
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int measuredWidth;
        int iMax;
        int iCombineMeasuredStates;
        int measuredWidth2;
        int iCombineMeasuredStates2;
        int iMax2;
        int measuredHeight;
        int[] iArr = this.f2284F;
        boolean zB = o0.b(this);
        int i4 = !zB ? 1 : 0;
        if (Q(this.f2301d)) {
            H(this.f2301d, i2, 0, i3, 0, this.o);
            measuredWidth = this.f2301d.getMeasuredWidth() + u(this.f2301d);
            iMax = Math.max(0, this.f2301d.getMeasuredHeight() + v(this.f2301d));
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.f2301d.getMeasuredState());
        } else {
            measuredWidth = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (Q(this.f2304h)) {
            H(this.f2304h, i2, 0, i3, 0, this.o);
            measuredWidth = this.f2304h.getMeasuredWidth() + u(this.f2304h);
            iMax = Math.max(iMax, this.f2304h.getMeasuredHeight() + v(this.f2304h));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f2304h.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = Math.max(currentContentInsetStart, measuredWidth);
        iArr[zB ? 1 : 0] = Math.max(0, currentContentInsetStart - measuredWidth);
        if (Q(this.f2298a)) {
            H(this.f2298a, i2, iMax3, i3, 0, this.o);
            measuredWidth2 = this.f2298a.getMeasuredWidth() + u(this.f2298a);
            iMax = Math.max(iMax, this.f2298a.getMeasuredHeight() + v(this.f2298a));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f2298a.getMeasuredState());
        } else {
            measuredWidth2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax4 = iMax3 + Math.max(currentContentInsetEnd, measuredWidth2);
        iArr[i4] = Math.max(0, currentContentInsetEnd - measuredWidth2);
        if (Q(this.f2305i)) {
            iMax4 += G(this.f2305i, i2, iMax4, i3, 0, iArr);
            iMax = Math.max(iMax, this.f2305i.getMeasuredHeight() + v(this.f2305i));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f2305i.getMeasuredState());
        }
        if (Q(this.e)) {
            iMax4 += G(this.e, i2, iMax4, i3, 0, iArr);
            iMax = Math.max(iMax, this.e.getMeasuredHeight() + v(this.e));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.e.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (((g) childAt.getLayoutParams()).f2327b == 0 && Q(childAt)) {
                iMax4 += G(childAt, i2, iMax4, i3, 0, iArr);
                iMax = Math.max(iMax, childAt.getMeasuredHeight() + v(childAt));
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
            }
        }
        int i6 = this.r + this.s;
        int i7 = this.f2311p + this.f2312q;
        if (Q(this.f2299b)) {
            G(this.f2299b, i2, iMax4 + i7, i3, i6, iArr);
            int measuredWidth3 = this.f2299b.getMeasuredWidth() + u(this.f2299b);
            measuredHeight = this.f2299b.getMeasuredHeight() + v(this.f2299b);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f2299b.getMeasuredState());
            iMax2 = measuredWidth3;
        } else {
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
            measuredHeight = 0;
        }
        if (Q(this.f2300c)) {
            iMax2 = Math.max(iMax2, G(this.f2300c, i2, iMax4 + i7, i3, measuredHeight + i6, iArr));
            measuredHeight += this.f2300c.getMeasuredHeight() + v(this.f2300c);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.f2300c.getMeasuredState());
        }
        int iMax5 = Math.max(iMax, measuredHeight);
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax4 + iMax2 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i2, (-16777216) & iCombineMeasuredStates2), P() ? 0 : View.resolveSizeAndState(Math.max(iMax5 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i3, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof i)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        i iVar = (i) parcelable;
        super.onRestoreInstanceState(iVar.a());
        ActionMenuView actionMenuView = this.f2298a;
        androidx.appcompat.view.menu.e eVarN = actionMenuView != null ? actionMenuView.N() : null;
        int i2 = iVar.f2328c;
        if (i2 != 0 && this.f2290L != null && eVarN != null && (menuItemFindItem = eVarN.findItem(i2)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (iVar.f2329d) {
            J();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i2) {
        super.onRtlPropertiesChanged(i2);
        h();
        this.f2313t.f(i2 == 1);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        androidx.appcompat.view.menu.g gVar;
        i iVar = new i(super.onSaveInstanceState());
        f fVar = this.f2290L;
        if (fVar != null && (gVar = fVar.f2325b) != null) {
            iVar.f2328c = gVar.getItemId();
        }
        iVar.f2329d = D();
        return iVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f2280B = false;
        }
        if (!this.f2280B) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f2280B = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f2280B = false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public g generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof g ? new g((g) layoutParams) : layoutParams instanceof AbstractC0126a.C0016a ? new g((AbstractC0126a.C0016a) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new g((ViewGroup.MarginLayoutParams) layoutParams) : new g(layoutParams);
    }

    @Override // androidx.core.view.InterfaceC0179w
    public void r(InterfaceC0182z interfaceC0182z) {
        this.f2285G.a(interfaceC0182z);
    }

    public void setBackInvokedCallbackEnabled(boolean z2) {
        if (this.f2296R != z2) {
            this.f2296R = z2;
            S();
        }
    }

    public void setCollapseContentDescription(int i2) {
        setCollapseContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setCollapseIcon(int i2) {
        setCollapseIcon(AbstractC0250a.b(getContext(), i2));
    }

    public void setCollapsible(boolean z2) {
        this.f2293O = z2;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i2) {
        if (i2 < 0) {
            i2 = Target.SIZE_ORIGINAL;
        }
        if (i2 != this.f2315v) {
            this.f2315v = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i2) {
        if (i2 < 0) {
            i2 = Target.SIZE_ORIGINAL;
        }
        if (i2 != this.f2314u) {
            this.f2314u = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i2) {
        setLogo(AbstractC0250a.b(getContext(), i2));
    }

    public void setLogoDescription(int i2) {
        setLogoDescription(getContext().getText(i2));
    }

    public void setNavigationContentDescription(int i2) {
        setNavigationContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setNavigationIcon(int i2) {
        setNavigationIcon(AbstractC0250a.b(getContext(), i2));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        l();
        this.f2301d.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(h hVar) {
    }

    public void setOverflowIcon(Drawable drawable) {
        j();
        this.f2298a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i2) {
        if (this.f2307k != i2) {
            this.f2307k = i2;
            if (i2 == 0) {
                this.f2306j = getContext();
            } else {
                this.f2306j = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public void setSubtitle(int i2) {
        setSubtitle(getContext().getText(i2));
    }

    public void setSubtitleTextColor(int i2) {
        setSubtitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setTitle(int i2) {
        setTitle(getContext().getText(i2));
    }

    public void setTitleMarginBottom(int i2) {
        this.s = i2;
        requestLayout();
    }

    public void setTitleMarginEnd(int i2) {
        this.f2312q = i2;
        requestLayout();
    }

    public void setTitleMarginStart(int i2) {
        this.f2311p = i2;
        requestLayout();
    }

    public void setTitleMarginTop(int i2) {
        this.r = i2;
        requestLayout();
    }

    public void setTitleTextColor(int i2) {
        setTitleTextColor(ColorStateList.valueOf(i2));
    }

    public boolean x() {
        f fVar = this.f2290L;
        return (fVar == null || fVar.f2325b == null) ? false : true;
    }

    public boolean y() {
        ActionMenuView actionMenuView = this.f2298a;
        return actionMenuView != null && actionMenuView.H();
    }

    public void z(int i2) {
        getMenuInflater().inflate(i2, getMenu());
    }

    public static class g extends AbstractC0126a.C0016a {

        /* renamed from: b, reason: collision with root package name */
        int f2327b;

        public g(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2327b = 0;
        }

        void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public g(int i2, int i3) {
            super(i2, i3);
            this.f2327b = 0;
            this.f1699a = 8388627;
        }

        public g(g gVar) {
            super((AbstractC0126a.C0016a) gVar);
            this.f2327b = 0;
            this.f2327b = gVar.f2327b;
        }

        public g(AbstractC0126a.C0016a c0016a) {
            super(c0016a);
            this.f2327b = 0;
        }

        public g(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2327b = 0;
            a(marginLayoutParams);
        }

        public g(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2327b = 0;
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2316w = 8388627;
        this.f2282D = new ArrayList();
        this.f2283E = new ArrayList();
        this.f2284F = new int[2];
        this.f2285G = new C0180x(new Runnable() { // from class: androidx.appcompat.widget.f0
            @Override // java.lang.Runnable
            public final void run() {
                this.f2427a.A();
            }
        });
        this.f2286H = new ArrayList();
        this.f2287I = new a();
        this.f2297S = new b();
        Context context2 = getContext();
        int[] iArr = e.m.A2;
        d0 d0VarU = d0.u(context2, attributeSet, iArr, i2, 0);
        androidx.core.view.M.d0(this, context, iArr, attributeSet, d0VarU.q(), i2, 0);
        this.f2308l = d0VarU.m(e.m.c3, 0);
        this.f2309m = d0VarU.m(e.m.T2, 0);
        this.f2316w = d0VarU.k(e.m.B2, this.f2316w);
        this.f2310n = d0VarU.k(e.m.C2, 48);
        int iD = d0VarU.d(e.m.W2, 0);
        int i3 = e.m.b3;
        iD = d0VarU.r(i3) ? d0VarU.d(i3, iD) : iD;
        this.s = iD;
        this.r = iD;
        this.f2312q = iD;
        this.f2311p = iD;
        int iD2 = d0VarU.d(e.m.Z2, -1);
        if (iD2 >= 0) {
            this.f2311p = iD2;
        }
        int iD3 = d0VarU.d(e.m.Y2, -1);
        if (iD3 >= 0) {
            this.f2312q = iD3;
        }
        int iD4 = d0VarU.d(e.m.a3, -1);
        if (iD4 >= 0) {
            this.r = iD4;
        }
        int iD5 = d0VarU.d(e.m.X2, -1);
        if (iD5 >= 0) {
            this.s = iD5;
        }
        this.o = d0VarU.e(e.m.N2, -1);
        int iD6 = d0VarU.d(e.m.J2, Target.SIZE_ORIGINAL);
        int iD7 = d0VarU.d(e.m.F2, Target.SIZE_ORIGINAL);
        int iE = d0VarU.e(e.m.H2, 0);
        int iE2 = d0VarU.e(e.m.I2, 0);
        h();
        this.f2313t.e(iE, iE2);
        if (iD6 != Integer.MIN_VALUE || iD7 != Integer.MIN_VALUE) {
            this.f2313t.g(iD6, iD7);
        }
        this.f2314u = d0VarU.d(e.m.K2, Target.SIZE_ORIGINAL);
        this.f2315v = d0VarU.d(e.m.G2, Target.SIZE_ORIGINAL);
        this.f2302f = d0VarU.f(e.m.E2);
        this.f2303g = d0VarU.o(e.m.D2);
        CharSequence charSequenceO = d0VarU.o(e.m.V2);
        if (!TextUtils.isEmpty(charSequenceO)) {
            setTitle(charSequenceO);
        }
        CharSequence charSequenceO2 = d0VarU.o(e.m.S2);
        if (!TextUtils.isEmpty(charSequenceO2)) {
            setSubtitle(charSequenceO2);
        }
        this.f2306j = getContext();
        setPopupTheme(d0VarU.m(e.m.R2, 0));
        Drawable drawableF = d0VarU.f(e.m.Q2);
        if (drawableF != null) {
            setNavigationIcon(drawableF);
        }
        CharSequence charSequenceO3 = d0VarU.o(e.m.P2);
        if (!TextUtils.isEmpty(charSequenceO3)) {
            setNavigationContentDescription(charSequenceO3);
        }
        Drawable drawableF2 = d0VarU.f(e.m.L2);
        if (drawableF2 != null) {
            setLogo(drawableF2);
        }
        CharSequence charSequenceO4 = d0VarU.o(e.m.M2);
        if (!TextUtils.isEmpty(charSequenceO4)) {
            setLogoDescription(charSequenceO4);
        }
        int i4 = e.m.d3;
        if (d0VarU.r(i4)) {
            setTitleTextColor(d0VarU.c(i4));
        }
        int i5 = e.m.U2;
        if (d0VarU.r(i5)) {
            setSubtitleTextColor(d0VarU.c(i5));
        }
        int i6 = e.m.O2;
        if (d0VarU.r(i6)) {
            z(d0VarU.m(i6, 0));
        }
        d0VarU.w();
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        ImageButton imageButton = this.f2304h;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            this.f2304h.setImageDrawable(drawable);
        } else {
            ImageButton imageButton = this.f2304h;
            if (imageButton != null) {
                imageButton.setImageDrawable(this.f2302f);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            i();
            if (!B(this.e)) {
                c(this.e, true);
            }
        } else {
            ImageView imageView = this.e;
            if (imageView != null && B(imageView)) {
                removeView(this.e);
                this.f2283E.remove(this.e);
            }
        }
        ImageView imageView2 = this.e;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            i();
        }
        ImageView imageView = this.e;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            l();
        }
        ImageButton imageButton = this.f2301d;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
            i0.a(this.f2301d, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            l();
            if (!B(this.f2301d)) {
                c(this.f2301d, true);
            }
        } else {
            ImageButton imageButton = this.f2301d;
            if (imageButton != null && B(imageButton)) {
                removeView(this.f2301d);
                this.f2283E.remove(this.f2301d);
            }
        }
        ImageButton imageButton2 = this.f2301d;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f2300c;
            if (textView != null && B(textView)) {
                removeView(this.f2300c);
                this.f2283E.remove(this.f2300c);
            }
        } else {
            if (this.f2300c == null) {
                Context context = getContext();
                E e2 = new E(context);
                this.f2300c = e2;
                e2.setSingleLine();
                this.f2300c.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.f2309m;
                if (i2 != 0) {
                    this.f2300c.setTextAppearance(context, i2);
                }
                ColorStateList colorStateList = this.f2279A;
                if (colorStateList != null) {
                    this.f2300c.setTextColor(colorStateList);
                }
            }
            if (!B(this.f2300c)) {
                c(this.f2300c, true);
            }
        }
        TextView textView2 = this.f2300c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f2318y = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.f2279A = colorStateList;
        TextView textView = this.f2300c;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f2299b;
            if (textView != null && B(textView)) {
                removeView(this.f2299b);
                this.f2283E.remove(this.f2299b);
            }
        } else {
            if (this.f2299b == null) {
                Context context = getContext();
                E e2 = new E(context);
                this.f2299b = e2;
                e2.setSingleLine();
                this.f2299b.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.f2308l;
                if (i2 != 0) {
                    this.f2299b.setTextAppearance(context, i2);
                }
                ColorStateList colorStateList = this.f2319z;
                if (colorStateList != null) {
                    this.f2299b.setTextColor(colorStateList);
                }
            }
            if (!B(this.f2299b)) {
                c(this.f2299b, true);
            }
        }
        TextView textView2 = this.f2299b;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f2317x = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.f2319z = colorStateList;
        TextView textView = this.f2299b;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public static class i extends A.a {
        public static final Parcelable.Creator<i> CREATOR = new a();

        /* renamed from: c, reason: collision with root package name */
        int f2328c;

        /* renamed from: d, reason: collision with root package name */
        boolean f2329d;

        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public i createFromParcel(Parcel parcel) {
                return new i(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public i createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new i(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public i[] newArray(int i2) {
                return new i[i2];
            }
        }

        public i(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2328c = parcel.readInt();
            this.f2329d = parcel.readInt() != 0;
        }

        @Override // A.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f2328c);
            parcel.writeInt(this.f2329d ? 1 : 0);
        }

        public i(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
