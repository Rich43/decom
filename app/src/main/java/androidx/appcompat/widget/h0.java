package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.view.menu.j;
import defpackage.e;
import f.AbstractC0250a;
import i.C0265a;

/* loaded from: classes.dex */
public class h0 implements L {

    /* renamed from: a */
    Toolbar f2437a;

    /* renamed from: b */
    private int f2438b;

    /* renamed from: c */
    private View f2439c;

    /* renamed from: d */
    private View f2440d;
    private Drawable e;

    /* renamed from: f */
    private Drawable f2441f;

    /* renamed from: g */
    private Drawable f2442g;

    /* renamed from: h */
    private boolean f2443h;

    /* renamed from: i */
    CharSequence f2444i;

    /* renamed from: j */
    private CharSequence f2445j;

    /* renamed from: k */
    private CharSequence f2446k;

    /* renamed from: l */
    Window.Callback f2447l;

    /* renamed from: m */
    boolean f2448m;

    /* renamed from: n */
    private C0135c f2449n;
    private int o;

    /* renamed from: p */
    private int f2450p;

    /* renamed from: q */
    private Drawable f2451q;

    class a implements View.OnClickListener {

        /* renamed from: a */
        final C0265a f2452a;

        a() {
            this.f2452a = new C0265a(h0.this.f2437a.getContext(), 0, R.id.home, 0, 0, h0.this.f2444i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h0 h0Var = h0.this;
            Window.Callback callback = h0Var.f2447l;
            if (callback == null || !h0Var.f2448m) {
                return;
            }
            callback.onMenuItemSelected(0, this.f2452a);
        }
    }

    class b extends androidx.core.view.X {

        /* renamed from: a */
        private boolean f2454a = false;

        /* renamed from: b */
        final /* synthetic */ int f2455b;

        b(int i2) {
            this.f2455b = i2;
        }

        @Override // androidx.core.view.W
        public void a(View view) {
            if (this.f2454a) {
                return;
            }
            h0.this.f2437a.setVisibility(this.f2455b);
        }

        @Override // androidx.core.view.X, androidx.core.view.W
        public void b(View view) {
            h0.this.f2437a.setVisibility(0);
        }

        @Override // androidx.core.view.X, androidx.core.view.W
        public void c(View view) {
            this.f2454a = true;
        }
    }

    public h0(Toolbar toolbar, boolean z2) {
        this(toolbar, z2, e.k.f5958a, e.h.f5905n);
    }

    private void E(CharSequence charSequence) {
        this.f2444i = charSequence;
        if ((this.f2438b & 8) != 0) {
            this.f2437a.setTitle(charSequence);
            if (this.f2443h) {
                androidx.core.view.M.h0(this.f2437a.getRootView(), charSequence);
            }
        }
    }

    private void F() {
        if ((this.f2438b & 4) != 0) {
            if (TextUtils.isEmpty(this.f2446k)) {
                this.f2437a.setNavigationContentDescription(this.f2450p);
            } else {
                this.f2437a.setNavigationContentDescription(this.f2446k);
            }
        }
    }

    private void G() {
        if ((this.f2438b & 4) == 0) {
            this.f2437a.setNavigationIcon((Drawable) null);
            return;
        }
        Toolbar toolbar = this.f2437a;
        Drawable drawable = this.f2442g;
        if (drawable == null) {
            drawable = this.f2451q;
        }
        toolbar.setNavigationIcon(drawable);
    }

    private void H() {
        Drawable drawable;
        int i2 = this.f2438b;
        if ((i2 & 2) == 0) {
            drawable = null;
        } else if ((i2 & 1) == 0 || (drawable = this.f2441f) == null) {
            drawable = this.e;
        }
        this.f2437a.setLogo(drawable);
    }

    private int v() {
        if (this.f2437a.getNavigationIcon() == null) {
            return 11;
        }
        this.f2451q = this.f2437a.getNavigationIcon();
        return 15;
    }

    public void A(CharSequence charSequence) {
        this.f2446k = charSequence;
        F();
    }

    public void B(Drawable drawable) {
        this.f2442g = drawable;
        G();
    }

    public void C(CharSequence charSequence) {
        this.f2445j = charSequence;
        if ((this.f2438b & 8) != 0) {
            this.f2437a.setSubtitle(charSequence);
        }
    }

    public void D(CharSequence charSequence) {
        this.f2443h = true;
        E(charSequence);
    }

    @Override // androidx.appcompat.widget.L
    public void a(Menu menu, j.a aVar) {
        if (this.f2449n == null) {
            C0135c c0135c = new C0135c(this.f2437a.getContext());
            this.f2449n = c0135c;
            c0135c.p(e.i.f5926g);
        }
        this.f2449n.h(aVar);
        this.f2437a.M((androidx.appcompat.view.menu.e) menu, this.f2449n);
    }

    @Override // androidx.appcompat.widget.L
    public boolean b() {
        return this.f2437a.C();
    }

    @Override // androidx.appcompat.widget.L
    public boolean c() {
        return this.f2437a.D();
    }

    @Override // androidx.appcompat.widget.L
    public void collapseActionView() {
        this.f2437a.e();
    }

    @Override // androidx.appcompat.widget.L
    public boolean d() {
        return this.f2437a.y();
    }

    @Override // androidx.appcompat.widget.L
    public boolean e() {
        return this.f2437a.R();
    }

    @Override // androidx.appcompat.widget.L
    public void f() {
        this.f2448m = true;
    }

    @Override // androidx.appcompat.widget.L
    public boolean g() {
        return this.f2437a.d();
    }

    @Override // androidx.appcompat.widget.L
    public CharSequence getTitle() {
        return this.f2437a.getTitle();
    }

    @Override // androidx.appcompat.widget.L
    public void h() {
        this.f2437a.f();
    }

    @Override // androidx.appcompat.widget.L
    public int i() {
        return this.f2438b;
    }

    @Override // androidx.appcompat.widget.L
    public void j(int i2) {
        this.f2437a.setVisibility(i2);
    }

    @Override // androidx.appcompat.widget.L
    public void k(int i2) {
        y(i2 != 0 ? AbstractC0250a.b(n(), i2) : null);
    }

    @Override // androidx.appcompat.widget.L
    public void l(Y y2) {
        View view = this.f2439c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f2437a;
            if (parent == toolbar) {
                toolbar.removeView(this.f2439c);
            }
        }
        this.f2439c = y2;
    }

    @Override // androidx.appcompat.widget.L
    public void m(boolean z2) {
    }

    @Override // androidx.appcompat.widget.L
    public Context n() {
        return this.f2437a.getContext();
    }

    @Override // androidx.appcompat.widget.L
    public int o() {
        return this.o;
    }

    @Override // androidx.appcompat.widget.L
    public androidx.core.view.V p(int i2, long j2) {
        return androidx.core.view.M.c(this.f2437a).b(i2 == 0 ? 1.0f : 0.0f).f(j2).h(new b(i2));
    }

    @Override // androidx.appcompat.widget.L
    public void q() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.L
    public boolean r() {
        return this.f2437a.x();
    }

    @Override // androidx.appcompat.widget.L
    public void s() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.L
    public void setIcon(int i2) {
        setIcon(i2 != 0 ? AbstractC0250a.b(n(), i2) : null);
    }

    @Override // androidx.appcompat.widget.L
    public void setWindowCallback(Window.Callback callback) {
        this.f2447l = callback;
    }

    @Override // androidx.appcompat.widget.L
    public void setWindowTitle(CharSequence charSequence) {
        if (this.f2443h) {
            return;
        }
        E(charSequence);
    }

    @Override // androidx.appcompat.widget.L
    public void t(boolean z2) {
        this.f2437a.setCollapsible(z2);
    }

    @Override // androidx.appcompat.widget.L
    public void u(int i2) {
        View view;
        int i3 = this.f2438b ^ i2;
        this.f2438b = i2;
        if (i3 != 0) {
            if ((i3 & 4) != 0) {
                if ((i2 & 4) != 0) {
                    F();
                }
                G();
            }
            if ((i3 & 3) != 0) {
                H();
            }
            if ((i3 & 8) != 0) {
                if ((i2 & 8) != 0) {
                    this.f2437a.setTitle(this.f2444i);
                    this.f2437a.setSubtitle(this.f2445j);
                } else {
                    this.f2437a.setTitle((CharSequence) null);
                    this.f2437a.setSubtitle((CharSequence) null);
                }
            }
            if ((i3 & 16) == 0 || (view = this.f2440d) == null) {
                return;
            }
            if ((i2 & 16) != 0) {
                this.f2437a.addView(view);
            } else {
                this.f2437a.removeView(view);
            }
        }
    }

    public void w(View view) {
        View view2 = this.f2440d;
        if (view2 != null && (this.f2438b & 16) != 0) {
            this.f2437a.removeView(view2);
        }
        this.f2440d = view;
        if (view == null || (this.f2438b & 16) == 0) {
            return;
        }
        this.f2437a.addView(view);
    }

    public void x(int i2) {
        if (i2 == this.f2450p) {
            return;
        }
        this.f2450p = i2;
        if (TextUtils.isEmpty(this.f2437a.getNavigationContentDescription())) {
            z(this.f2450p);
        }
    }

    public void y(Drawable drawable) {
        this.f2441f = drawable;
        H();
    }

    public void z(int i2) {
        A(i2 == 0 ? null : n().getString(i2));
    }

    public h0(Toolbar toolbar, boolean z2, int i2, int i3) {
        Drawable drawable;
        this.o = 0;
        this.f2450p = 0;
        this.f2437a = toolbar;
        this.f2444i = toolbar.getTitle();
        this.f2445j = toolbar.getSubtitle();
        this.f2443h = this.f2444i != null;
        this.f2442g = toolbar.getNavigationIcon();
        d0 d0VarU = d0.u(toolbar.getContext(), null, e.m.f6024a, e.d.f5838c, 0);
        this.f2451q = d0VarU.f(e.m.f6056l);
        if (z2) {
            CharSequence charSequenceO = d0VarU.o(e.m.r);
            if (!TextUtils.isEmpty(charSequenceO)) {
                D(charSequenceO);
            }
            CharSequence charSequenceO2 = d0VarU.o(e.m.f6067p);
            if (!TextUtils.isEmpty(charSequenceO2)) {
                C(charSequenceO2);
            }
            Drawable drawableF = d0VarU.f(e.m.f6062n);
            if (drawableF != null) {
                y(drawableF);
            }
            Drawable drawableF2 = d0VarU.f(e.m.f6059m);
            if (drawableF2 != null) {
                setIcon(drawableF2);
            }
            if (this.f2442g == null && (drawable = this.f2451q) != null) {
                B(drawable);
            }
            u(d0VarU.j(e.m.f6044h, 0));
            int iM = d0VarU.m(e.m.f6041g, 0);
            if (iM != 0) {
                w(LayoutInflater.from(this.f2437a.getContext()).inflate(iM, (ViewGroup) this.f2437a, false));
                u(this.f2438b | 16);
            }
            int iL = d0VarU.l(e.m.f6050j, 0);
            if (iL > 0) {
                ViewGroup.LayoutParams layoutParams = this.f2437a.getLayoutParams();
                layoutParams.height = iL;
                this.f2437a.setLayoutParams(layoutParams);
            }
            int iD = d0VarU.d(e.m.f6038f, -1);
            int iD2 = d0VarU.d(e.m.e, -1);
            if (iD >= 0 || iD2 >= 0) {
                this.f2437a.L(Math.max(iD, 0), Math.max(iD2, 0));
            }
            int iM2 = d0VarU.m(e.m.s, 0);
            if (iM2 != 0) {
                Toolbar toolbar2 = this.f2437a;
                toolbar2.O(toolbar2.getContext(), iM2);
            }
            int iM3 = d0VarU.m(e.m.f6070q, 0);
            if (iM3 != 0) {
                Toolbar toolbar3 = this.f2437a;
                toolbar3.N(toolbar3.getContext(), iM3);
            }
            int iM4 = d0VarU.m(e.m.o, 0);
            if (iM4 != 0) {
                this.f2437a.setPopupTheme(iM4);
            }
        } else {
            this.f2438b = v();
        }
        d0VarU.w();
        x(i2);
        this.f2446k = this.f2437a.getNavigationContentDescription();
        this.f2437a.setNavigationOnClickListener(new a());
    }

    @Override // androidx.appcompat.widget.L
    public void setIcon(Drawable drawable) {
        this.e = drawable;
        H();
    }
}
