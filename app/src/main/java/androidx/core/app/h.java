package androidx.core.app;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.view.AbstractC0177u;
import androidx.lifecycle.AbstractC0203h;
import androidx.lifecycle.v;

/* loaded from: classes.dex */
public abstract class h extends Activity implements androidx.lifecycle.m, AbstractC0177u.a {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.collection.g f2874a = new androidx.collection.g();

    /* renamed from: b, reason: collision with root package name */
    private final androidx.lifecycle.n f2875b = new androidx.lifecycle.n(this);

    public static class a {
    }

    private final boolean g0(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        String str = strArr[0];
        switch (str.hashCode()) {
            case -645125871:
                return str.equals("--translation") && Build.VERSION.SDK_INT >= 31;
            case 100470631:
                if (!str.equals("--dump-dumpable")) {
                    return false;
                }
                break;
            case 472614934:
                if (!str.equals("--list-dumpables")) {
                    return false;
                }
                break;
            case 1159329357:
                return str.equals("--contentcapture") && Build.VERSION.SDK_INT >= 29;
            case 1455016274:
                return str.equals("--autofill") && Build.VERSION.SDK_INT >= 26;
            default:
                return false;
        }
        return Build.VERSION.SDK_INT >= 33;
    }

    public a d0(Class cls) {
        i1.k.e(cls, "extraDataClass");
        return (a) this.f2874a.get(cls);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        i1.k.e(keyEvent, "event");
        View decorView = getWindow().getDecorView();
        i1.k.d(decorView, "window.decorView");
        if (AbstractC0177u.d(decorView, keyEvent)) {
            return true;
        }
        return AbstractC0177u.e(this, decorView, this, keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        i1.k.e(keyEvent, "event");
        View decorView = getWindow().getDecorView();
        i1.k.d(decorView, "window.decorView");
        if (AbstractC0177u.d(decorView, keyEvent)) {
            return true;
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    public void e0(a aVar) {
        i1.k.e(aVar, "extraData");
        this.f2874a.put(aVar.getClass(), aVar);
    }

    protected final boolean f0(String[] strArr) {
        return !g0(strArr);
    }

    public AbstractC0203h getLifecycle() {
        return this.f2875b;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.f3750b.c(this);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        i1.k.e(bundle, "outState");
        this.f2875b.m(AbstractC0203h.b.CREATED);
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.core.view.AbstractC0177u.a
    public boolean y(KeyEvent keyEvent) {
        i1.k.e(keyEvent, "event");
        return super.dispatchKeyEvent(keyEvent);
    }
}
