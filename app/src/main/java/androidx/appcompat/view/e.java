package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class e extends b implements e.a {

    /* renamed from: c, reason: collision with root package name */
    private Context f1827c;

    /* renamed from: d, reason: collision with root package name */
    private ActionBarContextView f1828d;
    private b.a e;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference f1829f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f1830g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f1831h;

    /* renamed from: i, reason: collision with root package name */
    private androidx.appcompat.view.menu.e f1832i;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z2) {
        this.f1827c = context;
        this.f1828d = actionBarContextView;
        this.e = aVar;
        androidx.appcompat.view.menu.e eVarT = new androidx.appcompat.view.menu.e(actionBarContextView.getContext()).T(1);
        this.f1832i = eVarT;
        eVarT.S(this);
        this.f1831h = z2;
    }

    @Override // androidx.appcompat.view.menu.e.a
    public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        return this.e.b(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.e.a
    public void b(androidx.appcompat.view.menu.e eVar) {
        k();
        this.f1828d.l();
    }

    @Override // androidx.appcompat.view.b
    public void c() {
        if (this.f1830g) {
            return;
        }
        this.f1830g = true;
        this.e.d(this);
    }

    @Override // androidx.appcompat.view.b
    public View d() {
        WeakReference weakReference = this.f1829f;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // androidx.appcompat.view.b
    public Menu e() {
        return this.f1832i;
    }

    @Override // androidx.appcompat.view.b
    public MenuInflater f() {
        return new g(this.f1828d.getContext());
    }

    @Override // androidx.appcompat.view.b
    public CharSequence g() {
        return this.f1828d.getSubtitle();
    }

    @Override // androidx.appcompat.view.b
    public CharSequence i() {
        return this.f1828d.getTitle();
    }

    @Override // androidx.appcompat.view.b
    public void k() {
        this.e.a(this, this.f1832i);
    }

    @Override // androidx.appcompat.view.b
    public boolean l() {
        return this.f1828d.j();
    }

    @Override // androidx.appcompat.view.b
    public void m(View view) {
        this.f1828d.setCustomView(view);
        this.f1829f = view != null ? new WeakReference(view) : null;
    }

    @Override // androidx.appcompat.view.b
    public void n(int i2) {
        o(this.f1827c.getString(i2));
    }

    @Override // androidx.appcompat.view.b
    public void o(CharSequence charSequence) {
        this.f1828d.setSubtitle(charSequence);
    }

    @Override // androidx.appcompat.view.b
    public void q(int i2) {
        r(this.f1827c.getString(i2));
    }

    @Override // androidx.appcompat.view.b
    public void r(CharSequence charSequence) {
        this.f1828d.setTitle(charSequence);
    }

    @Override // androidx.appcompat.view.b
    public void s(boolean z2) {
        super.s(z2);
        this.f1828d.setTitleOptional(z2);
    }
}
