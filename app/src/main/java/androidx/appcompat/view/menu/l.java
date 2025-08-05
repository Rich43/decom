package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.U;
import defpackage.e;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
final class l extends h implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, j, View.OnKeyListener {

    /* renamed from: v, reason: collision with root package name */
    private static final int f2037v = e.j.f5954m;

    /* renamed from: b, reason: collision with root package name */
    private final Context f2038b;

    /* renamed from: c, reason: collision with root package name */
    private final e f2039c;

    /* renamed from: d, reason: collision with root package name */
    private final d f2040d;
    private final boolean e;

    /* renamed from: f, reason: collision with root package name */
    private final int f2041f;

    /* renamed from: g, reason: collision with root package name */
    private final int f2042g;

    /* renamed from: h, reason: collision with root package name */
    private final int f2043h;

    /* renamed from: i, reason: collision with root package name */
    final U f2044i;

    /* renamed from: l, reason: collision with root package name */
    private PopupWindow.OnDismissListener f2047l;

    /* renamed from: m, reason: collision with root package name */
    private View f2048m;

    /* renamed from: n, reason: collision with root package name */
    View f2049n;
    private j.a o;

    /* renamed from: p, reason: collision with root package name */
    ViewTreeObserver f2050p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f2051q;
    private boolean r;
    private int s;

    /* renamed from: u, reason: collision with root package name */
    private boolean f2053u;

    /* renamed from: j, reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f2045j = new a();

    /* renamed from: k, reason: collision with root package name */
    private final View.OnAttachStateChangeListener f2046k = new b();

    /* renamed from: t, reason: collision with root package name */
    private int f2052t = 0;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (!l.this.b() || l.this.f2044i.x()) {
                return;
            }
            View view = l.this.f2049n;
            if (view == null || !view.isShown()) {
                l.this.dismiss();
            } else {
                l.this.f2044i.f();
            }
        }
    }

    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = l.this.f2050p;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    l.this.f2050p = view.getViewTreeObserver();
                }
                l lVar = l.this;
                lVar.f2050p.removeGlobalOnLayoutListener(lVar.f2045j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public l(Context context, e eVar, View view, int i2, int i3, boolean z2) {
        this.f2038b = context;
        this.f2039c = eVar;
        this.e = z2;
        this.f2040d = new d(eVar, LayoutInflater.from(context), z2, f2037v);
        this.f2042g = i2;
        this.f2043h = i3;
        Resources resources = context.getResources();
        this.f2041f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(e.g.f5867b));
        this.f2048m = view;
        this.f2044i = new U(context, null, i2, i3);
        eVar.c(this, context);
    }

    private boolean z() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        View view;
        if (b()) {
            return true;
        }
        if (this.f2051q || (view = this.f2048m) == null) {
            return false;
        }
        this.f2049n = view;
        this.f2044i.G(this);
        this.f2044i.H(this);
        this.f2044i.F(true);
        View view2 = this.f2049n;
        boolean z2 = this.f2050p == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f2050p = viewTreeObserver;
        if (z2) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f2045j);
        }
        view2.addOnAttachStateChangeListener(this.f2046k);
        this.f2044i.z(view2);
        this.f2044i.C(this.f2052t);
        if (!this.r) {
            this.s = h.o(this.f2040d, null, this.f2038b, this.f2041f);
            this.r = true;
        }
        this.f2044i.B(this.s);
        this.f2044i.E(2);
        this.f2044i.D(n());
        this.f2044i.f();
        ListView listViewK = this.f2044i.k();
        listViewK.setOnKeyListener(this);
        if (this.f2053u && this.f2039c.x() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f2038b).inflate(e.j.f5953l, (ViewGroup) listViewK, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            if (textView != null) {
                textView.setText(this.f2039c.x());
            }
            frameLayout.setEnabled(false);
            listViewK.addHeaderView(frameLayout, null, false);
        }
        this.f2044i.o(this.f2040d);
        this.f2044i.f();
        return true;
    }

    @Override // androidx.appcompat.view.menu.j
    public void a(e eVar, boolean z2) {
        if (eVar != this.f2039c) {
            return;
        }
        dismiss();
        j.a aVar = this.o;
        if (aVar != null) {
            aVar.a(eVar, z2);
        }
    }

    @Override // i.InterfaceC0269e
    public boolean b() {
        return !this.f2051q && this.f2044i.b();
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean c() {
        return false;
    }

    @Override // i.InterfaceC0269e
    public void dismiss() {
        if (b()) {
            this.f2044i.dismiss();
        }
    }

    @Override // i.InterfaceC0269e
    public void f() {
        if (!z()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void h(j.a aVar) {
        this.o = aVar;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean i(m mVar) {
        if (mVar.hasVisibleItems()) {
            i iVar = new i(this.f2038b, mVar, this.f2049n, this.e, this.f2042g, this.f2043h);
            iVar.j(this.o);
            iVar.g(h.x(mVar));
            iVar.i(this.f2047l);
            this.f2047l = null;
            this.f2039c.e(false);
            int iD = this.f2044i.d();
            int iG = this.f2044i.g();
            if ((Gravity.getAbsoluteGravity(this.f2052t, this.f2048m.getLayoutDirection()) & 7) == 5) {
                iD += this.f2048m.getWidth();
            }
            if (iVar.n(iD, iG)) {
                j.a aVar = this.o;
                if (aVar == null) {
                    return true;
                }
                aVar.b(mVar);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void j(boolean z2) {
        this.r = false;
        d dVar = this.f2040d;
        if (dVar != null) {
            dVar.notifyDataSetChanged();
        }
    }

    @Override // i.InterfaceC0269e
    public ListView k() {
        return this.f2044i.k();
    }

    @Override // androidx.appcompat.view.menu.h
    public void l(e eVar) {
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f2051q = true;
        this.f2039c.close();
        ViewTreeObserver viewTreeObserver = this.f2050p;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f2050p = this.f2049n.getViewTreeObserver();
            }
            this.f2050p.removeGlobalOnLayoutListener(this.f2045j);
            this.f2050p = null;
        }
        this.f2049n.removeOnAttachStateChangeListener(this.f2046k);
        PopupWindow.OnDismissListener onDismissListener = this.f2047l;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
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
        this.f2048m = view;
    }

    @Override // androidx.appcompat.view.menu.h
    public void r(boolean z2) {
        this.f2040d.d(z2);
    }

    @Override // androidx.appcompat.view.menu.h
    public void s(int i2) {
        this.f2052t = i2;
    }

    @Override // androidx.appcompat.view.menu.h
    public void t(int i2) {
        this.f2044i.c(i2);
    }

    @Override // androidx.appcompat.view.menu.h
    public void u(PopupWindow.OnDismissListener onDismissListener) {
        this.f2047l = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.h
    public void v(boolean z2) {
        this.f2053u = z2;
    }

    @Override // androidx.appcompat.view.menu.h
    public void w(int i2) {
        this.f2044i.n(i2);
    }
}
