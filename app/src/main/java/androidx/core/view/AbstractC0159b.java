package androidx.core.view;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: androidx.core.view.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0159b {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3157a;

    /* renamed from: b, reason: collision with root package name */
    private a f3158b;

    /* renamed from: c, reason: collision with root package name */
    private InterfaceC0034b f3159c;

    /* renamed from: androidx.core.view.b$a */
    public interface a {
    }

    /* renamed from: androidx.core.view.b$b, reason: collision with other inner class name */
    public interface InterfaceC0034b {
        void onActionProviderVisibilityChanged(boolean z2);
    }

    public AbstractC0159b(Context context) {
        this.f3157a = context;
    }

    public abstract boolean a();

    public abstract boolean b();

    public abstract View c(MenuItem menuItem);

    public abstract boolean d();

    public abstract void e(SubMenu subMenu);

    public abstract boolean f();

    public void g() {
        this.f3159c = null;
        this.f3158b = null;
    }

    public void h(a aVar) {
        this.f3158b = aVar;
    }

    public abstract void i(InterfaceC0034b interfaceC0034b);
}
