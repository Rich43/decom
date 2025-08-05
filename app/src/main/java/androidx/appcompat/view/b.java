package androidx.appcompat.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private Object f1820a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f1821b;

    public interface a {
        boolean a(b bVar, Menu menu);

        boolean b(b bVar, MenuItem menuItem);

        boolean c(b bVar, Menu menu);

        void d(b bVar);
    }

    public abstract void c();

    public abstract View d();

    public abstract Menu e();

    public abstract MenuInflater f();

    public abstract CharSequence g();

    public Object h() {
        return this.f1820a;
    }

    public abstract CharSequence i();

    public boolean j() {
        return this.f1821b;
    }

    public abstract void k();

    public abstract boolean l();

    public abstract void m(View view);

    public abstract void n(int i2);

    public abstract void o(CharSequence charSequence);

    public void p(Object obj) {
        this.f1820a = obj;
    }

    public abstract void q(int i2);

    public abstract void r(CharSequence charSequence);

    public void s(boolean z2) {
        this.f1821b = z2;
    }
}
