package androidx.appcompat.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.b;
import androidx.appcompat.widget.n0;
import androidx.core.app.s;
import androidx.fragment.app.AbstractActivityC0191i;
import androidx.lifecycle.K;
import androidx.lifecycle.L;
import androidx.savedstate.a;

/* renamed from: androidx.appcompat.app.c */
/* loaded from: classes.dex */
public abstract class AbstractActivityC0128c extends AbstractActivityC0191i implements InterfaceC0129d, s.a {

    /* renamed from: B */
    private AbstractC0131f f1703B;

    /* renamed from: C */
    private Resources f1704C;

    /* renamed from: androidx.appcompat.app.c$a */
    class a implements a.c {
        a() {
        }

        @Override // androidx.savedstate.a.c
        public Bundle a() {
            Bundle bundle = new Bundle();
            AbstractActivityC0128c.this.X0().B(bundle);
            return bundle;
        }
    }

    /* renamed from: androidx.appcompat.app.c$b */
    class b implements a.b {
        b() {
        }

        @Override // a.b
        public void a(Context context) {
            AbstractC0131f abstractC0131fX0 = AbstractActivityC0128c.this.X0();
            abstractC0131fX0.s();
            abstractC0131fX0.x(AbstractActivityC0128c.this.getSavedStateRegistry().b("androidx:appcompat"));
        }
    }

    public AbstractActivityC0128c() {
        Z0();
    }

    private void Z0() {
        getSavedStateRegistry().h("androidx:appcompat", new a());
        x0(new b());
    }

    private void a1() {
        K.a(getWindow().getDecorView(), this);
        L.a(getWindow().getDecorView(), this);
        L.e.a(getWindow().getDecorView(), this);
        androidx.activity.z.a(getWindow().getDecorView(), this);
    }

    private boolean h1(KeyEvent keyEvent) {
        Window window;
        return (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) ? false : true;
    }

    @Override // androidx.core.app.s.a
    public Intent A() {
        return androidx.core.app.j.a(this);
    }

    @Override // androidx.appcompat.app.InterfaceC0129d
    public void G(androidx.appcompat.view.b bVar) {
    }

    @Override // androidx.appcompat.app.InterfaceC0129d
    public void R(androidx.appcompat.view.b bVar) {
    }

    @Override // androidx.appcompat.app.InterfaceC0129d
    public androidx.appcompat.view.b T(b.a aVar) {
        return null;
    }

    public AbstractC0131f X0() {
        if (this.f1703B == null) {
            this.f1703B = AbstractC0131f.h(this, this);
        }
        return this.f1703B;
    }

    public AbstractC0126a Y0() {
        return X0().r();
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a1();
        X0().e(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(X0().g(context));
    }

    public void b1(androidx.core.app.s sVar) {
        sVar.b(this);
    }

    protected void c1(androidx.core.os.e eVar) {
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        AbstractC0126a abstractC0126aY0 = Y0();
        if (getWindow().hasFeature(0)) {
            if (abstractC0126aY0 == null || !abstractC0126aY0.g()) {
                super.closeOptionsMenu();
            }
        }
    }

    protected void d1(int i2) {
    }

    @Override // androidx.core.app.h, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        AbstractC0126a abstractC0126aY0 = Y0();
        if (keyCode == 82 && abstractC0126aY0 != null && abstractC0126aY0.p(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public void e1(androidx.core.app.s sVar) {
    }

    public void f1() {
    }

    @Override // android.app.Activity
    public View findViewById(int i2) {
        return X0().j(i2);
    }

    public boolean g1() {
        Intent intentA = A();
        if (intentA == null) {
            return false;
        }
        if (!j1(intentA)) {
            i1(intentA);
            return true;
        }
        androidx.core.app.s sVarD = androidx.core.app.s.d(this);
        b1(sVarD);
        e1(sVarD);
        sVarD.e();
        try {
            androidx.core.app.b.j(this);
            return true;
        } catch (IllegalStateException unused) {
            finish();
            return true;
        }
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return X0().p();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.f1704C == null && n0.c()) {
            this.f1704C = new n0(this, super.getResources());
        }
        Resources resources = this.f1704C;
        return resources == null ? super.getResources() : resources;
    }

    public void i1(Intent intent) {
        androidx.core.app.j.e(this, intent);
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        X0().t();
    }

    public boolean j1(Intent intent) {
        return androidx.core.app.j.f(this, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        X0().w(configuration);
        if (this.f1704C != null) {
            this.f1704C.updateConfiguration(super.getResources().getConfiguration(), super.getResources().getDisplayMetrics());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        f1();
    }

    @Override // androidx.fragment.app.AbstractActivityC0191i, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        X0().y();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (h1(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // androidx.fragment.app.AbstractActivityC0191i, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        AbstractC0126a abstractC0126aY0 = Y0();
        if (menuItem.getItemId() != 16908332 || abstractC0126aY0 == null || (abstractC0126aY0.j() & 4) == 0) {
            return false;
        }
        return g1();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i2, Menu menu) {
        return super.onMenuOpened(i2, menu);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i2, Menu menu) {
        super.onPanelClosed(i2, menu);
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        X0().z(bundle);
    }

    @Override // androidx.fragment.app.AbstractActivityC0191i, android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        X0().A();
    }

    @Override // androidx.fragment.app.AbstractActivityC0191i, android.app.Activity
    protected void onStart() {
        super.onStart();
        X0().C();
    }

    @Override // androidx.fragment.app.AbstractActivityC0191i, android.app.Activity
    protected void onStop() {
        super.onStop();
        X0().D();
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i2) {
        super.onTitleChanged(charSequence, i2);
        X0().M(charSequence);
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        AbstractC0126a abstractC0126aY0 = Y0();
        if (getWindow().hasFeature(0)) {
            if (abstractC0126aY0 == null || !abstractC0126aY0.q()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i2) {
        a1();
        X0().H(i2);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        super.setTheme(i2);
        X0().L(i2);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        a1();
        X0().I(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a1();
        X0().J(view, layoutParams);
    }
}
