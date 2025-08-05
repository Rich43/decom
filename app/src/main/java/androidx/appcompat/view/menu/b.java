package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.T;
import androidx.appcompat.widget.U;
import androidx.core.view.AbstractC0176t;
import defpackage.e;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
final class b extends h implements j, View.OnKeyListener, PopupWindow.OnDismissListener {

    /* renamed from: B, reason: collision with root package name */
    private static final int f1921B = e.j.e;

    /* renamed from: A, reason: collision with root package name */
    boolean f1922A;

    /* renamed from: b, reason: collision with root package name */
    private final Context f1923b;

    /* renamed from: c, reason: collision with root package name */
    private final int f1924c;

    /* renamed from: d, reason: collision with root package name */
    private final int f1925d;
    private final int e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f1926f;

    /* renamed from: g, reason: collision with root package name */
    final Handler f1927g;
    private View o;

    /* renamed from: p, reason: collision with root package name */
    View f1935p;
    private boolean r;
    private boolean s;

    /* renamed from: t, reason: collision with root package name */
    private int f1937t;

    /* renamed from: u, reason: collision with root package name */
    private int f1938u;

    /* renamed from: w, reason: collision with root package name */
    private boolean f1940w;

    /* renamed from: x, reason: collision with root package name */
    private j.a f1941x;

    /* renamed from: y, reason: collision with root package name */
    ViewTreeObserver f1942y;

    /* renamed from: z, reason: collision with root package name */
    private PopupWindow.OnDismissListener f1943z;

    /* renamed from: h, reason: collision with root package name */
    private final List f1928h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    final List f1929i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f1930j = new a();

    /* renamed from: k, reason: collision with root package name */
    private final View.OnAttachStateChangeListener f1931k = new ViewOnAttachStateChangeListenerC0018b();

    /* renamed from: l, reason: collision with root package name */
    private final T f1932l = new c();

    /* renamed from: m, reason: collision with root package name */
    private int f1933m = 0;

    /* renamed from: n, reason: collision with root package name */
    private int f1934n = 0;

    /* renamed from: v, reason: collision with root package name */
    private boolean f1939v = false;

    /* renamed from: q, reason: collision with root package name */
    private int f1936q = D();

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (!b.this.b() || b.this.f1929i.size() <= 0 || ((d) b.this.f1929i.get(0)).f1951a.x()) {
                return;
            }
            View view = b.this.f1935p;
            if (view == null || !view.isShown()) {
                b.this.dismiss();
                return;
            }
            Iterator it = b.this.f1929i.iterator();
            while (it.hasNext()) {
                ((d) it.next()).f1951a.f();
            }
        }
    }

    /* renamed from: androidx.appcompat.view.menu.b$b, reason: collision with other inner class name */
    class ViewOnAttachStateChangeListenerC0018b implements View.OnAttachStateChangeListener {
        ViewOnAttachStateChangeListenerC0018b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = b.this.f1942y;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    b.this.f1942y = view.getViewTreeObserver();
                }
                b bVar = b.this;
                bVar.f1942y.removeGlobalOnLayoutListener(bVar.f1930j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    class c implements T {

        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ d f1947a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ MenuItem f1948b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ e f1949c;

            a(d dVar, MenuItem menuItem, e eVar) {
                this.f1947a = dVar;
                this.f1948b = menuItem;
                this.f1949c = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = this.f1947a;
                if (dVar != null) {
                    b.this.f1922A = true;
                    dVar.f1952b.e(false);
                    b.this.f1922A = false;
                }
                if (this.f1948b.isEnabled() && this.f1948b.hasSubMenu()) {
                    this.f1949c.M(this.f1948b, 4);
                }
            }
        }

        c() {
        }

        @Override // androidx.appcompat.widget.T
        public void a(e eVar, MenuItem menuItem) {
            b.this.f1927g.removeCallbacksAndMessages(null);
            int size = b.this.f1929i.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (eVar == ((d) b.this.f1929i.get(i2)).f1952b) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 == -1) {
                return;
            }
            int i3 = i2 + 1;
            b.this.f1927g.postAtTime(new a(i3 < b.this.f1929i.size() ? (d) b.this.f1929i.get(i3) : null, menuItem, eVar), eVar, SystemClock.uptimeMillis() + 200);
        }

        @Override // androidx.appcompat.widget.T
        public void h(e eVar, MenuItem menuItem) {
            b.this.f1927g.removeCallbacksAndMessages(eVar);
        }
    }

    private static class d {

        /* renamed from: a, reason: collision with root package name */
        public final U f1951a;

        /* renamed from: b, reason: collision with root package name */
        public final e f1952b;

        /* renamed from: c, reason: collision with root package name */
        public final int f1953c;

        public d(U u2, e eVar, int i2) {
            this.f1951a = u2;
            this.f1952b = eVar;
            this.f1953c = i2;
        }

        public ListView a() {
            return this.f1951a.k();
        }
    }

    public b(Context context, View view, int i2, int i3, boolean z2) {
        this.f1923b = context;
        this.o = view;
        this.f1925d = i2;
        this.e = i3;
        this.f1926f = z2;
        Resources resources = context.getResources();
        this.f1924c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(e.g.f5867b));
        this.f1927g = new Handler();
    }

    private int A(e eVar) {
        int size = this.f1929i.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (eVar == ((d) this.f1929i.get(i2)).f1952b) {
                return i2;
            }
        }
        return -1;
    }

    private MenuItem B(e eVar, e eVar2) {
        int size = eVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = eVar.getItem(i2);
            if (item.hasSubMenu() && eVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View C(d dVar, e eVar) {
        androidx.appcompat.view.menu.d dVar2;
        int headersCount;
        int firstVisiblePosition;
        MenuItem menuItemB = B(dVar.f1952b, eVar);
        if (menuItemB == null) {
            return null;
        }
        ListView listViewA = dVar.a();
        ListAdapter adapter = listViewA.getAdapter();
        int i2 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            dVar2 = (androidx.appcompat.view.menu.d) headerViewListAdapter.getWrappedAdapter();
        } else {
            dVar2 = (androidx.appcompat.view.menu.d) adapter;
            headersCount = 0;
        }
        int count = dVar2.getCount();
        while (true) {
            if (i2 >= count) {
                i2 = -1;
                break;
            }
            if (menuItemB == dVar2.getItem(i2)) {
                break;
            }
            i2++;
        }
        if (i2 != -1 && (firstVisiblePosition = (i2 + headersCount) - listViewA.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < listViewA.getChildCount()) {
            return listViewA.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    private int D() {
        return this.o.getLayoutDirection() == 1 ? 0 : 1;
    }

    private int E(int i2) {
        List list = this.f1929i;
        ListView listViewA = ((d) list.get(list.size() - 1)).a();
        int[] iArr = new int[2];
        listViewA.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f1935p.getWindowVisibleDisplayFrame(rect);
        return this.f1936q == 1 ? (iArr[0] + listViewA.getWidth()) + i2 > rect.right ? 0 : 1 : iArr[0] - i2 < 0 ? 1 : 0;
    }

    private void F(e eVar) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        d dVar;
        View viewC;
        int i2;
        int i3;
        int i4;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f1923b);
        androidx.appcompat.view.menu.d dVar2 = new androidx.appcompat.view.menu.d(eVar, layoutInflaterFrom, this.f1926f, f1921B);
        if (!b() && this.f1939v) {
            dVar2.d(true);
        } else if (b()) {
            dVar2.d(h.x(eVar));
        }
        int iO = h.o(dVar2, null, this.f1923b, this.f1924c);
        U uZ = z();
        uZ.o(dVar2);
        uZ.B(iO);
        uZ.C(this.f1934n);
        if (this.f1929i.size() > 0) {
            List list = this.f1929i;
            dVar = (d) list.get(list.size() - 1);
            viewC = C(dVar, eVar);
        } else {
            dVar = null;
            viewC = null;
        }
        if (viewC != null) {
            uZ.Q(false);
            uZ.N(null);
            int iE = E(iO);
            boolean z2 = iE == 1;
            this.f1936q = iE;
            if (Build.VERSION.SDK_INT >= 26) {
                uZ.z(viewC);
                i3 = 0;
                i2 = 0;
            } else {
                int[] iArr = new int[2];
                this.o.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                viewC.getLocationOnScreen(iArr2);
                if ((this.f1934n & 7) == 5) {
                    iArr[0] = iArr[0] + this.o.getWidth();
                    iArr2[0] = iArr2[0] + viewC.getWidth();
                }
                i2 = iArr2[0] - iArr[0];
                i3 = iArr2[1] - iArr[1];
            }
            if ((this.f1934n & 5) == 5) {
                if (!z2) {
                    iO = viewC.getWidth();
                    i4 = i2 - iO;
                }
                i4 = i2 + iO;
            } else {
                if (z2) {
                    iO = viewC.getWidth();
                    i4 = i2 + iO;
                }
                i4 = i2 - iO;
            }
            uZ.c(i4);
            uZ.I(true);
            uZ.n(i3);
        } else {
            if (this.r) {
                uZ.c(this.f1937t);
            }
            if (this.s) {
                uZ.n(this.f1938u);
            }
            uZ.D(n());
        }
        this.f1929i.add(new d(uZ, eVar, this.f1936q));
        uZ.f();
        ListView listViewK = uZ.k();
        listViewK.setOnKeyListener(this);
        if (dVar == null && this.f1940w && eVar.x() != null) {
            FrameLayout frameLayout = (FrameLayout) layoutInflaterFrom.inflate(e.j.f5953l, (ViewGroup) listViewK, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(eVar.x());
            listViewK.addHeaderView(frameLayout, null, false);
            uZ.f();
        }
    }

    private U z() {
        U u2 = new U(this.f1923b, null, this.f1925d, this.e);
        u2.P(this.f1932l);
        u2.H(this);
        u2.G(this);
        u2.z(this.o);
        u2.C(this.f1934n);
        u2.F(true);
        u2.E(2);
        return u2;
    }

    @Override // androidx.appcompat.view.menu.j
    public void a(e eVar, boolean z2) {
        int iA = A(eVar);
        if (iA < 0) {
            return;
        }
        int i2 = iA + 1;
        if (i2 < this.f1929i.size()) {
            ((d) this.f1929i.get(i2)).f1952b.e(false);
        }
        d dVar = (d) this.f1929i.remove(iA);
        dVar.f1952b.P(this);
        if (this.f1922A) {
            dVar.f1951a.O(null);
            dVar.f1951a.A(0);
        }
        dVar.f1951a.dismiss();
        int size = this.f1929i.size();
        if (size > 0) {
            this.f1936q = ((d) this.f1929i.get(size - 1)).f1953c;
        } else {
            this.f1936q = D();
        }
        if (size != 0) {
            if (z2) {
                ((d) this.f1929i.get(0)).f1952b.e(false);
                return;
            }
            return;
        }
        dismiss();
        j.a aVar = this.f1941x;
        if (aVar != null) {
            aVar.a(eVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.f1942y;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.f1942y.removeGlobalOnLayoutListener(this.f1930j);
            }
            this.f1942y = null;
        }
        this.f1935p.removeOnAttachStateChangeListener(this.f1931k);
        this.f1943z.onDismiss();
    }

    @Override // i.InterfaceC0269e
    public boolean b() {
        return this.f1929i.size() > 0 && ((d) this.f1929i.get(0)).f1951a.b();
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean c() {
        return false;
    }

    @Override // i.InterfaceC0269e
    public void dismiss() {
        int size = this.f1929i.size();
        if (size > 0) {
            d[] dVarArr = (d[]) this.f1929i.toArray(new d[size]);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                d dVar = dVarArr[i2];
                if (dVar.f1951a.b()) {
                    dVar.f1951a.dismiss();
                }
            }
        }
    }

    @Override // i.InterfaceC0269e
    public void f() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (b()) {
            return;
        }
        Iterator it = this.f1928h.iterator();
        while (it.hasNext()) {
            F((e) it.next());
        }
        this.f1928h.clear();
        View view = this.o;
        this.f1935p = view;
        if (view != null) {
            boolean z2 = this.f1942y == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.f1942y = viewTreeObserver;
            if (z2) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f1930j);
            }
            this.f1935p.addOnAttachStateChangeListener(this.f1931k);
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void h(j.a aVar) {
        this.f1941x = aVar;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean i(m mVar) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        for (d dVar : this.f1929i) {
            if (mVar == dVar.f1952b) {
                dVar.a().requestFocus();
                return true;
            }
        }
        if (!mVar.hasVisibleItems()) {
            return false;
        }
        l(mVar);
        j.a aVar = this.f1941x;
        if (aVar != null) {
            aVar.b(mVar);
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.j
    public void j(boolean z2) {
        Iterator it = this.f1929i.iterator();
        while (it.hasNext()) {
            h.y(((d) it.next()).a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // i.InterfaceC0269e
    public ListView k() {
        if (this.f1929i.isEmpty()) {
            return null;
        }
        return ((d) this.f1929i.get(r0.size() - 1)).a();
    }

    @Override // androidx.appcompat.view.menu.h
    public void l(e eVar) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        eVar.c(this, this.f1923b);
        if (b()) {
            F(eVar);
        } else {
            this.f1928h.add(eVar);
        }
    }

    @Override // androidx.appcompat.view.menu.h
    protected boolean m() {
        return false;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        d dVar;
        int size = this.f1929i.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                dVar = null;
                break;
            }
            dVar = (d) this.f1929i.get(i2);
            if (!dVar.f1951a.b()) {
                break;
            } else {
                i2++;
            }
        }
        if (dVar != null) {
            dVar.f1952b.e(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.h
    public void p(View view) {
        if (this.o != view) {
            this.o = view;
            this.f1934n = AbstractC0176t.b(this.f1933m, view.getLayoutDirection());
        }
    }

    @Override // androidx.appcompat.view.menu.h
    public void r(boolean z2) {
        this.f1939v = z2;
    }

    @Override // androidx.appcompat.view.menu.h
    public void s(int i2) {
        if (this.f1933m != i2) {
            this.f1933m = i2;
            this.f1934n = AbstractC0176t.b(i2, this.o.getLayoutDirection());
        }
    }

    @Override // androidx.appcompat.view.menu.h
    public void t(int i2) {
        this.r = true;
        this.f1937t = i2;
    }

    @Override // androidx.appcompat.view.menu.h
    public void u(PopupWindow.OnDismissListener onDismissListener) {
        this.f1943z = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.h
    public void v(boolean z2) {
        this.f1940w = z2;
    }

    @Override // androidx.appcompat.view.menu.h
    public void w(int i2) {
        this.s = true;
        this.f1938u = i2;
    }
}
