package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: androidx.core.view.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0180x {

    /* renamed from: a, reason: collision with root package name */
    private final Runnable f3187a;

    /* renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList f3188b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final Map f3189c = new HashMap();

    public C0180x(Runnable runnable) {
        this.f3187a = runnable;
    }

    public void a(InterfaceC0182z interfaceC0182z) {
        this.f3188b.add(interfaceC0182z);
        this.f3187a.run();
    }

    public void b(Menu menu, MenuInflater menuInflater) {
        Iterator it = this.f3188b.iterator();
        while (it.hasNext()) {
            ((InterfaceC0182z) it.next()).a(menu, menuInflater);
        }
    }

    public void c(Menu menu) {
        Iterator it = this.f3188b.iterator();
        while (it.hasNext()) {
            ((InterfaceC0182z) it.next()).d(menu);
        }
    }

    public boolean d(MenuItem menuItem) {
        Iterator it = this.f3188b.iterator();
        while (it.hasNext()) {
            if (((InterfaceC0182z) it.next()).c(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void e(Menu menu) {
        Iterator it = this.f3188b.iterator();
        while (it.hasNext()) {
            ((InterfaceC0182z) it.next()).b(menu);
        }
    }

    public void f(InterfaceC0182z interfaceC0182z) {
        this.f3188b.remove(interfaceC0182z);
        androidx.appcompat.app.F.a(this.f3189c.remove(interfaceC0182z));
        this.f3187a.run();
    }
}
