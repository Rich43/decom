package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.L;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.M;
import androidx.core.view.V;
import androidx.core.view.W;
import androidx.core.view.X;
import androidx.core.view.Y;
import defpackage.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class G extends AbstractC0126a implements ActionBarOverlayLayout.d {

    /* renamed from: D */
    private static final Interpolator f1665D = new AccelerateInterpolator();

    /* renamed from: E */
    private static final Interpolator f1666E = new DecelerateInterpolator();

    /* renamed from: a */
    Context f1670a;

    /* renamed from: b */
    private Context f1671b;

    /* renamed from: c */
    private Activity f1672c;

    /* renamed from: d */
    ActionBarOverlayLayout f1673d;
    ActionBarContainer e;

    /* renamed from: f */
    L f1674f;

    /* renamed from: g */
    ActionBarContextView f1675g;

    /* renamed from: h */
    View f1676h;

    /* renamed from: k */
    private boolean f1679k;

    /* renamed from: l */
    d f1680l;

    /* renamed from: m */
    androidx.appcompat.view.b f1681m;

    /* renamed from: n */
    b.a f1682n;
    private boolean o;

    /* renamed from: q */
    private boolean f1684q;

    /* renamed from: t */
    boolean f1685t;

    /* renamed from: u */
    boolean f1686u;

    /* renamed from: v */
    private boolean f1687v;

    /* renamed from: x */
    androidx.appcompat.view.h f1689x;

    /* renamed from: y */
    private boolean f1690y;

    /* renamed from: z */
    boolean f1691z;

    /* renamed from: i */
    private ArrayList f1677i = new ArrayList();

    /* renamed from: j */
    private int f1678j = -1;

    /* renamed from: p */
    private ArrayList f1683p = new ArrayList();
    private int r = 0;
    boolean s = true;

    /* renamed from: w */
    private boolean f1688w = true;

    /* renamed from: A */
    final W f1667A = new a();

    /* renamed from: B */
    final W f1668B = new b();

    /* renamed from: C */
    final Y f1669C = new c();

    class a extends X {
        a() {
        }

        @Override // androidx.core.view.W
        public void a(View view) {
            View view2;
            G g2 = G.this;
            if (g2.s && (view2 = g2.f1676h) != null) {
                view2.setTranslationY(0.0f);
                G.this.e.setTranslationY(0.0f);
            }
            G.this.e.setVisibility(8);
            G.this.e.setTransitioning(false);
            G g3 = G.this;
            g3.f1689x = null;
            g3.x();
            ActionBarOverlayLayout actionBarOverlayLayout = G.this.f1673d;
            if (actionBarOverlayLayout != null) {
                M.c0(actionBarOverlayLayout);
            }
        }
    }

    class b extends X {
        b() {
        }

        @Override // androidx.core.view.W
        public void a(View view) {
            G g2 = G.this;
            g2.f1689x = null;
            g2.e.requestLayout();
        }
    }

    class c implements Y {
        c() {
        }

        @Override // androidx.core.view.Y
        public void a(View view) {
            ((View) G.this.e.getParent()).invalidate();
        }
    }

    public class d extends androidx.appcompat.view.b implements e.a {

        /* renamed from: c */
        private final Context f1695c;

        /* renamed from: d */
        private final androidx.appcompat.view.menu.e f1696d;
        private b.a e;

        /* renamed from: f */
        private WeakReference f1697f;

        public d(Context context, b.a aVar) {
            this.f1695c = context;
            this.e = aVar;
            androidx.appcompat.view.menu.e eVarT = new androidx.appcompat.view.menu.e(context).T(1);
            this.f1696d = eVarT;
            eVarT.S(this);
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            b.a aVar = this.e;
            if (aVar != null) {
                return aVar.b(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(androidx.appcompat.view.menu.e eVar) {
            if (this.e == null) {
                return;
            }
            k();
            G.this.f1675g.l();
        }

        @Override // androidx.appcompat.view.b
        public void c() {
            G g2 = G.this;
            if (g2.f1680l != this) {
                return;
            }
            if (G.w(g2.f1685t, g2.f1686u, false)) {
                this.e.d(this);
            } else {
                G g3 = G.this;
                g3.f1681m = this;
                g3.f1682n = this.e;
            }
            this.e = null;
            G.this.v(false);
            G.this.f1675g.g();
            G g4 = G.this;
            g4.f1673d.setHideOnContentScrollEnabled(g4.f1691z);
            G.this.f1680l = null;
        }

        @Override // androidx.appcompat.view.b
        public View d() {
            WeakReference weakReference = this.f1697f;
            if (weakReference != null) {
                return (View) weakReference.get();
            }
            return null;
        }

        @Override // androidx.appcompat.view.b
        public Menu e() {
            return this.f1696d;
        }

        @Override // androidx.appcompat.view.b
        public MenuInflater f() {
            return new androidx.appcompat.view.g(this.f1695c);
        }

        @Override // androidx.appcompat.view.b
        public CharSequence g() {
            return G.this.f1675g.getSubtitle();
        }

        @Override // androidx.appcompat.view.b
        public CharSequence i() {
            return G.this.f1675g.getTitle();
        }

        @Override // androidx.appcompat.view.b
        public void k() {
            if (G.this.f1680l != this) {
                return;
            }
            this.f1696d.e0();
            try {
                this.e.a(this, this.f1696d);
            } finally {
                this.f1696d.d0();
            }
        }

        @Override // androidx.appcompat.view.b
        public boolean l() {
            return G.this.f1675g.j();
        }

        @Override // androidx.appcompat.view.b
        public void m(View view) {
            G.this.f1675g.setCustomView(view);
            this.f1697f = new WeakReference(view);
        }

        @Override // androidx.appcompat.view.b
        public void n(int i2) {
            o(G.this.f1670a.getResources().getString(i2));
        }

        @Override // androidx.appcompat.view.b
        public void o(CharSequence charSequence) {
            G.this.f1675g.setSubtitle(charSequence);
        }

        @Override // androidx.appcompat.view.b
        public void q(int i2) {
            r(G.this.f1670a.getResources().getString(i2));
        }

        @Override // androidx.appcompat.view.b
        public void r(CharSequence charSequence) {
            G.this.f1675g.setTitle(charSequence);
        }

        @Override // androidx.appcompat.view.b
        public void s(boolean z2) {
            super.s(z2);
            G.this.f1675g.setTitleOptional(z2);
        }

        public boolean t() {
            this.f1696d.e0();
            try {
                return this.e.c(this, this.f1696d);
            } finally {
                this.f1696d.d0();
            }
        }
    }

    public G(Activity activity, boolean z2) {
        this.f1672c = activity;
        View decorView = activity.getWindow().getDecorView();
        D(decorView);
        if (z2) {
            return;
        }
        this.f1676h = decorView.findViewById(R.id.content);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private L A(View view) {
        if (view instanceof L) {
            return (L) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != 0 ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    private void C() {
        if (this.f1687v) {
            this.f1687v = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f1673d;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            M(false);
        }
    }

    private void D(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(e.i.f5934p);
        this.f1673d = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f1674f = A(view.findViewById(e.i.f5921a));
        this.f1675g = (ActionBarContextView) view.findViewById(e.i.f5925f);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(e.i.f5923c);
        this.e = actionBarContainer;
        L l2 = this.f1674f;
        if (l2 == null || this.f1675g == null || actionBarContainer == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f1670a = l2.n();
        boolean z2 = (this.f1674f.i() & 4) != 0;
        if (z2) {
            this.f1679k = true;
        }
        androidx.appcompat.view.a aVarB = androidx.appcompat.view.a.b(this.f1670a);
        J(aVarB.a() || z2);
        H(aVarB.e());
        TypedArray typedArrayObtainStyledAttributes = this.f1670a.obtainStyledAttributes(null, e.m.f6024a, e.d.f5838c, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(e.m.f6053k, false)) {
            I(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(e.m.f6047i, 0);
        if (dimensionPixelSize != 0) {
            G(dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void H(boolean z2) {
        this.f1684q = z2;
        if (z2) {
            this.e.setTabContainer(null);
            this.f1674f.l(null);
        } else {
            this.f1674f.l(null);
            this.e.setTabContainer(null);
        }
        boolean z3 = false;
        boolean z4 = B() == 2;
        this.f1674f.t(!this.f1684q && z4);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f1673d;
        if (!this.f1684q && z4) {
            z3 = true;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z3);
    }

    private boolean K() {
        return this.e.isLaidOut();
    }

    private void L() {
        if (this.f1687v) {
            return;
        }
        this.f1687v = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f1673d;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        M(false);
    }

    private void M(boolean z2) {
        if (w(this.f1685t, this.f1686u, this.f1687v)) {
            if (this.f1688w) {
                return;
            }
            this.f1688w = true;
            z(z2);
            return;
        }
        if (this.f1688w) {
            this.f1688w = false;
            y(z2);
        }
    }

    static boolean w(boolean z2, boolean z3, boolean z4) {
        if (z4) {
            return true;
        }
        return (z2 || z3) ? false : true;
    }

    public int B() {
        return this.f1674f.o();
    }

    public void E(boolean z2) {
        F(z2 ? 4 : 0, 4);
    }

    public void F(int i2, int i3) {
        int i4 = this.f1674f.i();
        if ((i3 & 4) != 0) {
            this.f1679k = true;
        }
        this.f1674f.u((i2 & i3) | ((~i3) & i4));
    }

    public void G(float f2) {
        M.m0(this.e, f2);
    }

    public void I(boolean z2) {
        if (z2 && !this.f1673d.x()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.f1691z = z2;
        this.f1673d.setHideOnContentScrollEnabled(z2);
    }

    public void J(boolean z2) {
        this.f1674f.m(z2);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void a(boolean z2) {
        this.s = z2;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void b() {
        if (this.f1686u) {
            this.f1686u = false;
            M(true);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void c() {
        androidx.appcompat.view.h hVar = this.f1689x;
        if (hVar != null) {
            hVar.a();
            this.f1689x = null;
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void d(int i2) {
        this.r = i2;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void e() {
        if (this.f1686u) {
            return;
        }
        this.f1686u = true;
        M(true);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void f() {
    }

    @Override // androidx.appcompat.app.AbstractC0126a
    public boolean h() {
        L l2 = this.f1674f;
        if (l2 == null || !l2.r()) {
            return false;
        }
        this.f1674f.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.AbstractC0126a
    public void i(boolean z2) {
        if (z2 == this.o) {
            return;
        }
        this.o = z2;
        if (this.f1683p.size() <= 0) {
            return;
        }
        F.a(this.f1683p.get(0));
        throw null;
    }

    @Override // androidx.appcompat.app.AbstractC0126a
    public int j() {
        return this.f1674f.i();
    }

    @Override // androidx.appcompat.app.AbstractC0126a
    public Context k() {
        if (this.f1671b == null) {
            TypedValue typedValue = new TypedValue();
            this.f1670a.getTheme().resolveAttribute(e.d.e, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                this.f1671b = new ContextThemeWrapper(this.f1670a, i2);
            } else {
                this.f1671b = this.f1670a;
            }
        }
        return this.f1671b;
    }

    @Override // androidx.appcompat.app.AbstractC0126a
    public void m(Configuration configuration) {
        H(androidx.appcompat.view.a.b(this.f1670a).e());
    }

    @Override // androidx.appcompat.app.AbstractC0126a
    public boolean o(int i2, KeyEvent keyEvent) {
        Menu menuE;
        d dVar = this.f1680l;
        if (dVar == null || (menuE = dVar.e()) == null) {
            return false;
        }
        menuE.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuE.performShortcut(i2, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.AbstractC0126a
    public void r(boolean z2) {
        if (this.f1679k) {
            return;
        }
        E(z2);
    }

    @Override // androidx.appcompat.app.AbstractC0126a
    public void s(boolean z2) {
        androidx.appcompat.view.h hVar;
        this.f1690y = z2;
        if (z2 || (hVar = this.f1689x) == null) {
            return;
        }
        hVar.a();
    }

    @Override // androidx.appcompat.app.AbstractC0126a
    public void t(CharSequence charSequence) {
        this.f1674f.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.AbstractC0126a
    public androidx.appcompat.view.b u(b.a aVar) {
        d dVar = this.f1680l;
        if (dVar != null) {
            dVar.c();
        }
        this.f1673d.setHideOnContentScrollEnabled(false);
        this.f1675g.k();
        d dVar2 = new d(this.f1675g.getContext(), aVar);
        if (!dVar2.t()) {
            return null;
        }
        this.f1680l = dVar2;
        dVar2.k();
        this.f1675g.h(dVar2);
        v(true);
        return dVar2;
    }

    public void v(boolean z2) {
        V vP;
        V vF;
        if (z2) {
            L();
        } else {
            C();
        }
        if (!K()) {
            if (z2) {
                this.f1674f.j(4);
                this.f1675g.setVisibility(0);
                return;
            } else {
                this.f1674f.j(0);
                this.f1675g.setVisibility(8);
                return;
            }
        }
        if (z2) {
            vF = this.f1674f.p(4, 100L);
            vP = this.f1675g.f(0, 200L);
        } else {
            vP = this.f1674f.p(0, 200L);
            vF = this.f1675g.f(8, 100L);
        }
        androidx.appcompat.view.h hVar = new androidx.appcompat.view.h();
        hVar.d(vF, vP);
        hVar.h();
    }

    void x() {
        b.a aVar = this.f1682n;
        if (aVar != null) {
            aVar.d(this.f1681m);
            this.f1681m = null;
            this.f1682n = null;
        }
    }

    public void y(boolean z2) {
        View view;
        androidx.appcompat.view.h hVar = this.f1689x;
        if (hVar != null) {
            hVar.a();
        }
        if (this.r != 0 || (!this.f1690y && !z2)) {
            this.f1667A.a(null);
            return;
        }
        this.e.setAlpha(1.0f);
        this.e.setTransitioning(true);
        androidx.appcompat.view.h hVar2 = new androidx.appcompat.view.h();
        float f2 = -this.e.getHeight();
        if (z2) {
            this.e.getLocationInWindow(new int[]{0, 0});
            f2 -= r5[1];
        }
        V vM = M.c(this.e).m(f2);
        vM.k(this.f1669C);
        hVar2.c(vM);
        if (this.s && (view = this.f1676h) != null) {
            hVar2.c(M.c(view).m(f2));
        }
        hVar2.f(f1665D);
        hVar2.e(250L);
        hVar2.g(this.f1667A);
        this.f1689x = hVar2;
        hVar2.h();
    }

    public void z(boolean z2) {
        View view;
        View view2;
        androidx.appcompat.view.h hVar = this.f1689x;
        if (hVar != null) {
            hVar.a();
        }
        this.e.setVisibility(0);
        if (this.r == 0 && (this.f1690y || z2)) {
            this.e.setTranslationY(0.0f);
            float f2 = -this.e.getHeight();
            if (z2) {
                this.e.getLocationInWindow(new int[]{0, 0});
                f2 -= r5[1];
            }
            this.e.setTranslationY(f2);
            androidx.appcompat.view.h hVar2 = new androidx.appcompat.view.h();
            V vM = M.c(this.e).m(0.0f);
            vM.k(this.f1669C);
            hVar2.c(vM);
            if (this.s && (view2 = this.f1676h) != null) {
                view2.setTranslationY(f2);
                hVar2.c(M.c(this.f1676h).m(0.0f));
            }
            hVar2.f(f1666E);
            hVar2.e(250L);
            hVar2.g(this.f1668B);
            this.f1689x = hVar2;
            hVar2.h();
        } else {
            this.e.setAlpha(1.0f);
            this.e.setTranslationY(0.0f);
            if (this.s && (view = this.f1676h) != null) {
                view.setTranslationY(0.0f);
            }
            this.f1668B.a(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f1673d;
        if (actionBarOverlayLayout != null) {
            M.c0(actionBarOverlayLayout);
        }
    }

    public G(Dialog dialog) {
        D(dialog.getWindow().getDecorView());
    }
}
