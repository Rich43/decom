package androidx.appcompat.widget;

import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

/* loaded from: classes.dex */
class l0 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: k, reason: collision with root package name */
    private static l0 f2479k;

    /* renamed from: l, reason: collision with root package name */
    private static l0 f2480l;

    /* renamed from: a, reason: collision with root package name */
    private final View f2481a;

    /* renamed from: b, reason: collision with root package name */
    private final CharSequence f2482b;

    /* renamed from: c, reason: collision with root package name */
    private final int f2483c;

    /* renamed from: d, reason: collision with root package name */
    private final Runnable f2484d = new Runnable() { // from class: androidx.appcompat.widget.j0
        @Override // java.lang.Runnable
        public final void run() throws Resources.NotFoundException {
            this.f2467a.e();
        }
    };
    private final Runnable e = new Runnable() { // from class: androidx.appcompat.widget.k0
        @Override // java.lang.Runnable
        public final void run() {
            this.f2476a.d();
        }
    };

    /* renamed from: f, reason: collision with root package name */
    private int f2485f;

    /* renamed from: g, reason: collision with root package name */
    private int f2486g;

    /* renamed from: h, reason: collision with root package name */
    private m0 f2487h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f2488i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f2489j;

    private l0(View view, CharSequence charSequence) {
        this.f2481a = view;
        this.f2482b = charSequence;
        this.f2483c = androidx.core.view.Q.g(ViewConfiguration.get(view.getContext()));
        c();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    private void b() {
        this.f2481a.removeCallbacks(this.f2484d);
    }

    private void c() {
        this.f2489j = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() throws Resources.NotFoundException {
        i(false);
    }

    private void f() {
        this.f2481a.postDelayed(this.f2484d, ViewConfiguration.getLongPressTimeout());
    }

    private static void g(l0 l0Var) {
        l0 l0Var2 = f2479k;
        if (l0Var2 != null) {
            l0Var2.b();
        }
        f2479k = l0Var;
        if (l0Var != null) {
            l0Var.f();
        }
    }

    public static void h(View view, CharSequence charSequence) {
        l0 l0Var = f2479k;
        if (l0Var != null && l0Var.f2481a == view) {
            g(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new l0(view, charSequence);
            return;
        }
        l0 l0Var2 = f2480l;
        if (l0Var2 != null && l0Var2.f2481a == view) {
            l0Var2.d();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    private boolean j(MotionEvent motionEvent) {
        int x2 = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        if (!this.f2489j && Math.abs(x2 - this.f2485f) <= this.f2483c && Math.abs(y2 - this.f2486g) <= this.f2483c) {
            return false;
        }
        this.f2485f = x2;
        this.f2486g = y2;
        this.f2489j = false;
        return true;
    }

    void d() {
        if (f2480l == this) {
            f2480l = null;
            m0 m0Var = this.f2487h;
            if (m0Var != null) {
                m0Var.c();
                this.f2487h = null;
                c();
                this.f2481a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f2479k == this) {
            g(null);
        }
        this.f2481a.removeCallbacks(this.e);
    }

    void i(boolean z2) throws Resources.NotFoundException {
        long longPressTimeout;
        long j2;
        long j3;
        if (this.f2481a.isAttachedToWindow()) {
            g(null);
            l0 l0Var = f2480l;
            if (l0Var != null) {
                l0Var.d();
            }
            f2480l = this;
            this.f2488i = z2;
            m0 m0Var = new m0(this.f2481a.getContext());
            this.f2487h = m0Var;
            m0Var.e(this.f2481a, this.f2485f, this.f2486g, this.f2488i, this.f2482b);
            this.f2481a.addOnAttachStateChangeListener(this);
            if (this.f2488i) {
                j3 = 2500;
            } else {
                if ((androidx.core.view.M.H(this.f2481a) & 1) == 1) {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j2 = 3000;
                } else {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j2 = 15000;
                }
                j3 = j2 - longPressTimeout;
            }
            this.f2481a.removeCallbacks(this.e);
            this.f2481a.postDelayed(this.e, j3);
        }
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f2487h != null && this.f2488i) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f2481a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                c();
                d();
            }
        } else if (this.f2481a.isEnabled() && this.f2487h == null && j(motionEvent)) {
            g(this);
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) throws Resources.NotFoundException {
        this.f2485f = view.getWidth() / 2;
        this.f2486g = view.getHeight() / 2;
        i(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        d();
    }
}
