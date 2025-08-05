package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.j;
import androidx.core.view.AbstractC0176t;
import defpackage.e;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a */
    private final Context f2025a;

    /* renamed from: b */
    private final e f2026b;

    /* renamed from: c */
    private final boolean f2027c;

    /* renamed from: d */
    private final int f2028d;
    private final int e;

    /* renamed from: f */
    private View f2029f;

    /* renamed from: g */
    private int f2030g;

    /* renamed from: h */
    private boolean f2031h;

    /* renamed from: i */
    private j.a f2032i;

    /* renamed from: j */
    private h f2033j;

    /* renamed from: k */
    private PopupWindow.OnDismissListener f2034k;

    /* renamed from: l */
    private final PopupWindow.OnDismissListener f2035l;

    class a implements PopupWindow.OnDismissListener {
        a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            i.this.e();
        }
    }

    public i(Context context, e eVar, View view, boolean z2, int i2) {
        this(context, eVar, view, z2, i2, 0);
    }

    private h a() {
        Display defaultDisplay = ((WindowManager) this.f2025a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        h bVar = Math.min(point.x, point.y) >= this.f2025a.getResources().getDimensionPixelSize(e.g.f5866a) ? new b(this.f2025a, this.f2029f, this.f2028d, this.e, this.f2027c) : new l(this.f2025a, this.f2026b, this.f2029f, this.f2028d, this.e, this.f2027c);
        bVar.l(this.f2026b);
        bVar.u(this.f2035l);
        bVar.p(this.f2029f);
        bVar.h(this.f2032i);
        bVar.r(this.f2031h);
        bVar.s(this.f2030g);
        return bVar;
    }

    private void l(int i2, int i3, boolean z2, boolean z3) {
        h hVarC = c();
        hVarC.v(z3);
        if (z2) {
            if ((AbstractC0176t.b(this.f2030g, this.f2029f.getLayoutDirection()) & 7) == 5) {
                i2 -= this.f2029f.getWidth();
            }
            hVarC.t(i2);
            hVarC.w(i3);
            int i4 = (int) ((this.f2025a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            hVarC.q(new Rect(i2 - i4, i3 - i4, i2 + i4, i3 + i4));
        }
        hVarC.f();
    }

    public void b() {
        if (d()) {
            this.f2033j.dismiss();
        }
    }

    public h c() {
        if (this.f2033j == null) {
            this.f2033j = a();
        }
        return this.f2033j;
    }

    public boolean d() {
        h hVar = this.f2033j;
        return hVar != null && hVar.b();
    }

    protected void e() {
        this.f2033j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f2034k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void f(View view) {
        this.f2029f = view;
    }

    public void g(boolean z2) {
        this.f2031h = z2;
        h hVar = this.f2033j;
        if (hVar != null) {
            hVar.r(z2);
        }
    }

    public void h(int i2) {
        this.f2030g = i2;
    }

    public void i(PopupWindow.OnDismissListener onDismissListener) {
        this.f2034k = onDismissListener;
    }

    public void j(j.a aVar) {
        this.f2032i = aVar;
        h hVar = this.f2033j;
        if (hVar != null) {
            hVar.h(aVar);
        }
    }

    public void k() {
        if (!m()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean m() {
        if (d()) {
            return true;
        }
        if (this.f2029f == null) {
            return false;
        }
        l(0, 0, false, false);
        return true;
    }

    public boolean n(int i2, int i3) {
        if (d()) {
            return true;
        }
        if (this.f2029f == null) {
            return false;
        }
        l(i2, i3, true, true);
        return true;
    }

    public i(Context context, e eVar, View view, boolean z2, int i2, int i3) {
        this.f2030g = 8388611;
        this.f2035l = new a();
        this.f2025a = context;
        this.f2026b = eVar;
        this.f2029f = view;
        this.f2027c = z2;
        this.f2028d = i2;
        this.e = i3;
    }
}
