package androidx.appcompat.app;

import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.b;
import androidx.core.view.AbstractC0177u;
import androidx.lifecycle.K;
import defpackage.e;

/* loaded from: classes.dex */
public abstract class x extends androidx.activity.q implements InterfaceC0129d {

    /* renamed from: d */
    private AbstractC0131f f1814d;
    private final AbstractC0177u.a e;

    public x(Context context, int i2) {
        super(context, e(context, i2));
        this.e = new AbstractC0177u.a() { // from class: androidx.appcompat.app.w
            @Override // androidx.core.view.AbstractC0177u.a
            public final boolean y(KeyEvent keyEvent) {
                return this.f1813a.h(keyEvent);
            }
        };
        AbstractC0131f abstractC0131fD = d();
        abstractC0131fD.L(e(context, i2));
        abstractC0131fD.x(null);
    }

    private static int e(Context context, int i2) {
        if (i2 != 0) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(e.d.f5854w, typedValue, true);
        return typedValue.resourceId;
    }

    private void g() {
        K.a(getWindow().getDecorView(), this);
        L.e.a(getWindow().getDecorView(), this);
        androidx.activity.z.a(getWindow().getDecorView(), this);
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

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        d().e(view, layoutParams);
    }

    public AbstractC0131f d() {
        if (this.f1814d == null) {
            this.f1814d = AbstractC0131f.i(this, this);
        }
        return this.f1814d;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        d().y();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return AbstractC0177u.e(this.e, getWindow().getDecorView(), this, keyEvent);
    }

    @Override // android.app.Dialog
    public View findViewById(int i2) {
        return d().j(i2);
    }

    boolean h(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean i(int i2) {
        return d().G(i2);
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        d().t();
    }

    @Override // androidx.activity.q, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        d().s();
        super.onCreate(bundle);
        d().x(bundle);
    }

    @Override // androidx.activity.q, android.app.Dialog
    protected void onStop() {
        super.onStop();
        d().D();
    }

    @Override // android.app.Dialog
    public void setContentView(int i2) {
        g();
        d().H(i2);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        d().M(charSequence);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        g();
        d().I(view);
    }

    @Override // android.app.Dialog
    public void setTitle(int i2) {
        super.setTitle(i2);
        d().M(getContext().getString(i2));
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        g();
        d().J(view, layoutParams);
    }
}
