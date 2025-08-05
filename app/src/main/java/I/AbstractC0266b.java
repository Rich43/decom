package i;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.g;
import defpackage.s;

/* renamed from: i.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract class AbstractC0266b {

    /* renamed from: a, reason: collision with root package name */
    final Context f6444a;

    /* renamed from: b, reason: collision with root package name */
    private g f6445b;

    /* renamed from: c, reason: collision with root package name */
    private g f6446c;

    AbstractC0266b(Context context) {
        this.f6444a = context;
    }

    final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof s.c)) {
            return menuItem;
        }
        s.c cVar = (s.c) menuItem;
        if (this.f6445b == null) {
            this.f6445b = new g();
        }
        MenuItem menuItem2 = (MenuItem) this.f6445b.get(cVar);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItemC0267c menuItemC0267c = new MenuItemC0267c(this.f6444a, cVar);
        this.f6445b.put(cVar, menuItemC0267c);
        return menuItemC0267c;
    }

    final void e() {
        g gVar = this.f6445b;
        if (gVar != null) {
            gVar.clear();
        }
        g gVar2 = this.f6446c;
        if (gVar2 != null) {
            gVar2.clear();
        }
    }

    final void f(int i2) {
        if (this.f6445b == null) {
            return;
        }
        int i3 = 0;
        while (i3 < this.f6445b.size()) {
            if (((s.c) this.f6445b.keyAt(i3)).getGroupId() == i2) {
                this.f6445b.removeAt(i3);
                i3--;
            }
            i3++;
        }
    }

    final void g(int i2) {
        if (this.f6445b == null) {
            return;
        }
        for (int i3 = 0; i3 < this.f6445b.size(); i3++) {
            if (((s.c) this.f6445b.keyAt(i3)).getItemId() == i2) {
                this.f6445b.removeAt(i3);
                return;
            }
        }
    }

    final SubMenu d(SubMenu subMenu) {
        return subMenu;
    }
}
