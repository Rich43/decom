package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.bumptech.glide.request.target.Target;
import defpackage.e;
import i.InterfaceC0269e;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class S implements InterfaceC0269e {

    /* renamed from: G, reason: collision with root package name */
    private static Method f2238G;

    /* renamed from: H, reason: collision with root package name */
    private static Method f2239H;

    /* renamed from: I, reason: collision with root package name */
    private static Method f2240I;

    /* renamed from: A, reason: collision with root package name */
    private Runnable f2241A;

    /* renamed from: B, reason: collision with root package name */
    final Handler f2242B;

    /* renamed from: C, reason: collision with root package name */
    private final Rect f2243C;

    /* renamed from: D, reason: collision with root package name */
    private Rect f2244D;

    /* renamed from: E, reason: collision with root package name */
    private boolean f2245E;

    /* renamed from: F, reason: collision with root package name */
    PopupWindow f2246F;

    /* renamed from: a, reason: collision with root package name */
    private Context f2247a;

    /* renamed from: b, reason: collision with root package name */
    private ListAdapter f2248b;

    /* renamed from: c, reason: collision with root package name */
    N f2249c;

    /* renamed from: d, reason: collision with root package name */
    private int f2250d;
    private int e;

    /* renamed from: f, reason: collision with root package name */
    private int f2251f;

    /* renamed from: g, reason: collision with root package name */
    private int f2252g;

    /* renamed from: h, reason: collision with root package name */
    private int f2253h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f2254i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f2255j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f2256k;

    /* renamed from: l, reason: collision with root package name */
    private int f2257l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f2258m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f2259n;
    int o;

    /* renamed from: p, reason: collision with root package name */
    private View f2260p;

    /* renamed from: q, reason: collision with root package name */
    private int f2261q;
    private DataSetObserver r;
    private View s;

    /* renamed from: t, reason: collision with root package name */
    private Drawable f2262t;

    /* renamed from: u, reason: collision with root package name */
    private AdapterView.OnItemClickListener f2263u;

    /* renamed from: v, reason: collision with root package name */
    private AdapterView.OnItemSelectedListener f2264v;

    /* renamed from: w, reason: collision with root package name */
    final i f2265w;

    /* renamed from: x, reason: collision with root package name */
    private final h f2266x;

    /* renamed from: y, reason: collision with root package name */
    private final g f2267y;

    /* renamed from: z, reason: collision with root package name */
    private final e f2268z;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            View viewT = S.this.t();
            if (viewT == null || viewT.getWindowToken() == null) {
                return;
            }
            S.this.f();
        }
    }

    class b implements AdapterView.OnItemSelectedListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i2, long j2) {
            N n2;
            if (i2 == -1 || (n2 = S.this.f2249c) == null) {
                return;
            }
            n2.setListSelectionHidden(false);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    static class c {
        static int a(PopupWindow popupWindow, View view, int i2, boolean z2) {
            return popupWindow.getMaxAvailableHeight(view, i2, z2);
        }
    }

    static class d {
        static void a(PopupWindow popupWindow, Rect rect) {
            popupWindow.setEpicenterBounds(rect);
        }

        static void b(PopupWindow popupWindow, boolean z2) {
            popupWindow.setIsClippedToScreen(z2);
        }
    }

    private class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            S.this.r();
        }
    }

    private class f extends DataSetObserver {
        f() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (S.this.b()) {
                S.this.f();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            S.this.dismiss();
        }
    }

    private class g implements AbsListView.OnScrollListener {
        g() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (i2 != 1 || S.this.w() || S.this.f2246F.getContentView() == null) {
                return;
            }
            S s = S.this;
            s.f2242B.removeCallbacks(s.f2265w);
            S.this.f2265w.run();
        }
    }

    private class h implements View.OnTouchListener {
        h() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x2 = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = S.this.f2246F) != null && popupWindow.isShowing() && x2 >= 0 && x2 < S.this.f2246F.getWidth() && y2 >= 0 && y2 < S.this.f2246F.getHeight()) {
                S s = S.this;
                s.f2242B.postDelayed(s.f2265w, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            S s2 = S.this;
            s2.f2242B.removeCallbacks(s2.f2265w);
            return false;
        }
    }

    private class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            N n2 = S.this.f2249c;
            if (n2 == null || !n2.isAttachedToWindow() || S.this.f2249c.getCount() <= S.this.f2249c.getChildCount()) {
                return;
            }
            int childCount = S.this.f2249c.getChildCount();
            S s = S.this;
            if (childCount <= s.o) {
                s.f2246F.setInputMethodMode(2);
                S.this.f();
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                f2238G = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                f2240I = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                f2239H = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public S(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    private void J(boolean z2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT > 28) {
            d.b(this.f2246F, z2);
            return;
        }
        Method method = f2238G;
        if (method != null) {
            try {
                method.invoke(this.f2246F, Boolean.valueOf(z2));
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    private int q() {
        int measuredHeight;
        int i2;
        int iMakeMeasureSpec;
        int i3;
        if (this.f2249c == null) {
            Context context = this.f2247a;
            this.f2241A = new a();
            N nS = s(context, !this.f2245E);
            this.f2249c = nS;
            Drawable drawable = this.f2262t;
            if (drawable != null) {
                nS.setSelector(drawable);
            }
            this.f2249c.setAdapter(this.f2248b);
            this.f2249c.setOnItemClickListener(this.f2263u);
            this.f2249c.setFocusable(true);
            this.f2249c.setFocusableInTouchMode(true);
            this.f2249c.setOnItemSelectedListener(new b());
            this.f2249c.setOnScrollListener(this.f2267y);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f2264v;
            if (onItemSelectedListener != null) {
                this.f2249c.setOnItemSelectedListener(onItemSelectedListener);
            }
            View view = this.f2249c;
            View view2 = this.f2260p;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i4 = this.f2261q;
                if (i4 == 0) {
                    linearLayout.addView(view2);
                    linearLayout.addView(view, layoutParams);
                } else if (i4 != 1) {
                    Log.e("ListPopupWindow", "Invalid hint position " + this.f2261q);
                } else {
                    linearLayout.addView(view, layoutParams);
                    linearLayout.addView(view2);
                }
                int i5 = this.e;
                if (i5 >= 0) {
                    i3 = Target.SIZE_ORIGINAL;
                } else {
                    i5 = 0;
                    i3 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i5, i3), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                measuredHeight = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                measuredHeight = 0;
            }
            this.f2246F.setContentView(view);
        } else {
            View view3 = this.f2260p;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                measuredHeight = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                measuredHeight = 0;
            }
        }
        Drawable background = this.f2246F.getBackground();
        if (background != null) {
            background.getPadding(this.f2243C);
            Rect rect = this.f2243C;
            int i6 = rect.top;
            i2 = rect.bottom + i6;
            if (!this.f2254i) {
                this.f2252g = -i6;
            }
        } else {
            this.f2243C.setEmpty();
            i2 = 0;
        }
        int iU = u(t(), this.f2252g, this.f2246F.getInputMethodMode() == 2);
        if (this.f2258m || this.f2250d == -1) {
            return iU + i2;
        }
        int i7 = this.e;
        if (i7 == -2) {
            int i8 = this.f2247a.getResources().getDisplayMetrics().widthPixels;
            Rect rect2 = this.f2243C;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i8 - (rect2.left + rect2.right), Target.SIZE_ORIGINAL);
        } else if (i7 != -1) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
        } else {
            int i9 = this.f2247a.getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = this.f2243C;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i9 - (rect3.left + rect3.right), 1073741824);
        }
        int iD = this.f2249c.d(iMakeMeasureSpec, 0, -1, iU - measuredHeight, -1);
        if (iD > 0) {
            measuredHeight += i2 + this.f2249c.getPaddingTop() + this.f2249c.getPaddingBottom();
        }
        return iD + measuredHeight;
    }

    private int u(View view, int i2, boolean z2) {
        if (Build.VERSION.SDK_INT > 23) {
            return c.a(this.f2246F, view, i2, z2);
        }
        Method method = f2239H;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.f2246F, view, Integer.valueOf(i2), Boolean.valueOf(z2))).intValue();
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.f2246F.getMaxAvailableHeight(view, i2);
    }

    private void y() {
        View view = this.f2260p;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f2260p);
            }
        }
    }

    public void A(int i2) {
        this.f2246F.setAnimationStyle(i2);
    }

    public void B(int i2) {
        Drawable background = this.f2246F.getBackground();
        if (background == null) {
            M(i2);
            return;
        }
        background.getPadding(this.f2243C);
        Rect rect = this.f2243C;
        this.e = rect.left + rect.right + i2;
    }

    public void C(int i2) {
        this.f2257l = i2;
    }

    public void D(Rect rect) {
        this.f2244D = rect != null ? new Rect(rect) : null;
    }

    public void E(int i2) {
        this.f2246F.setInputMethodMode(i2);
    }

    public void F(boolean z2) {
        this.f2245E = z2;
        this.f2246F.setFocusable(z2);
    }

    public void G(PopupWindow.OnDismissListener onDismissListener) {
        this.f2246F.setOnDismissListener(onDismissListener);
    }

    public void H(AdapterView.OnItemClickListener onItemClickListener) {
        this.f2263u = onItemClickListener;
    }

    public void I(boolean z2) {
        this.f2256k = true;
        this.f2255j = z2;
    }

    public void K(int i2) {
        this.f2261q = i2;
    }

    public void L(int i2) {
        N n2 = this.f2249c;
        if (!b() || n2 == null) {
            return;
        }
        n2.setListSelectionHidden(false);
        n2.setSelection(i2);
        if (n2.getChoiceMode() != 0) {
            n2.setItemChecked(i2, true);
        }
    }

    public void M(int i2) {
        this.e = i2;
    }

    @Override // i.InterfaceC0269e
    public boolean b() {
        return this.f2246F.isShowing();
    }

    public void c(int i2) {
        this.f2251f = i2;
    }

    public int d() {
        return this.f2251f;
    }

    @Override // i.InterfaceC0269e
    public void dismiss() {
        this.f2246F.dismiss();
        y();
        this.f2246F.setContentView(null);
        this.f2249c = null;
        this.f2242B.removeCallbacks(this.f2265w);
    }

    @Override // i.InterfaceC0269e
    public void f() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int iQ = q();
        boolean zW = w();
        androidx.core.widget.h.b(this.f2246F, this.f2253h);
        if (this.f2246F.isShowing()) {
            if (t().isAttachedToWindow()) {
                int width = this.e;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = t().getWidth();
                }
                int i2 = this.f2250d;
                if (i2 == -1) {
                    if (!zW) {
                        iQ = -1;
                    }
                    if (zW) {
                        this.f2246F.setWidth(this.e == -1 ? -1 : 0);
                        this.f2246F.setHeight(0);
                    } else {
                        this.f2246F.setWidth(this.e == -1 ? -1 : 0);
                        this.f2246F.setHeight(-1);
                    }
                } else if (i2 != -2) {
                    iQ = i2;
                }
                this.f2246F.setOutsideTouchable((this.f2259n || this.f2258m) ? false : true);
                this.f2246F.update(t(), this.f2251f, this.f2252g, width < 0 ? -1 : width, iQ < 0 ? -1 : iQ);
                return;
            }
            return;
        }
        int width2 = this.e;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = t().getWidth();
        }
        int i3 = this.f2250d;
        if (i3 == -1) {
            iQ = -1;
        } else if (i3 != -2) {
            iQ = i3;
        }
        this.f2246F.setWidth(width2);
        this.f2246F.setHeight(iQ);
        J(true);
        this.f2246F.setOutsideTouchable((this.f2259n || this.f2258m) ? false : true);
        this.f2246F.setTouchInterceptor(this.f2266x);
        if (this.f2256k) {
            androidx.core.widget.h.a(this.f2246F, this.f2255j);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = f2240I;
            if (method != null) {
                try {
                    method.invoke(this.f2246F, this.f2244D);
                } catch (Exception e2) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
                }
            }
        } else {
            d.a(this.f2246F, this.f2244D);
        }
        androidx.core.widget.h.c(this.f2246F, t(), this.f2251f, this.f2252g, this.f2257l);
        this.f2249c.setSelection(-1);
        if (!this.f2245E || this.f2249c.isInTouchMode()) {
            r();
        }
        if (this.f2245E) {
            return;
        }
        this.f2242B.post(this.f2268z);
    }

    public int g() {
        if (this.f2254i) {
            return this.f2252g;
        }
        return 0;
    }

    public Drawable i() {
        return this.f2246F.getBackground();
    }

    @Override // i.InterfaceC0269e
    public ListView k() {
        return this.f2249c;
    }

    public void m(Drawable drawable) {
        this.f2246F.setBackgroundDrawable(drawable);
    }

    public void n(int i2) {
        this.f2252g = i2;
        this.f2254i = true;
    }

    public void o(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.r;
        if (dataSetObserver == null) {
            this.r = new f();
        } else {
            ListAdapter listAdapter2 = this.f2248b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f2248b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.r);
        }
        N n2 = this.f2249c;
        if (n2 != null) {
            n2.setAdapter(this.f2248b);
        }
    }

    public void r() {
        N n2 = this.f2249c;
        if (n2 != null) {
            n2.setListSelectionHidden(true);
            n2.requestLayout();
        }
    }

    N s(Context context, boolean z2) {
        return new N(context, z2);
    }

    public View t() {
        return this.s;
    }

    public int v() {
        return this.e;
    }

    public boolean w() {
        return this.f2246F.getInputMethodMode() == 2;
    }

    public boolean x() {
        return this.f2245E;
    }

    public void z(View view) {
        this.s = view;
    }

    public S(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.f2250d = -2;
        this.e = -2;
        this.f2253h = 1002;
        this.f2257l = 0;
        this.f2258m = false;
        this.f2259n = false;
        this.o = Integer.MAX_VALUE;
        this.f2261q = 0;
        this.f2265w = new i();
        this.f2266x = new h();
        this.f2267y = new g();
        this.f2268z = new e();
        this.f2243C = new Rect();
        this.f2247a = context;
        this.f2242B = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.m.f6058l1, i2, i3);
        this.f2251f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(e.m.f6061m1, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(e.m.f6064n1, 0);
        this.f2252g = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f2254i = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        C0150s c0150s = new C0150s(context, attributeSet, i2, i3);
        this.f2246F = c0150s;
        c0150s.setInputMethodMode(1);
    }
}
