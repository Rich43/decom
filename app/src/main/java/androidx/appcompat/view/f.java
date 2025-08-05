package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.b;
import defpackage.s;
import i.MenuC0268d;
import i.MenuItemC0267c;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class f extends ActionMode {

    /* renamed from: a, reason: collision with root package name */
    final Context f1833a;

    /* renamed from: b, reason: collision with root package name */
    final b f1834b;

    public static class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final ActionMode.Callback f1835a;

        /* renamed from: b, reason: collision with root package name */
        final Context f1836b;

        /* renamed from: c, reason: collision with root package name */
        final ArrayList f1837c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        final androidx.collection.g f1838d = new androidx.collection.g();

        public a(Context context, ActionMode.Callback callback) {
            this.f1836b = context;
            this.f1835a = callback;
        }

        private Menu f(Menu menu) {
            Menu menu2 = (Menu) this.f1838d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            MenuC0268d menuC0268d = new MenuC0268d(this.f1836b, (s.b) menu);
            this.f1838d.put(menu, menuC0268d);
            return menuC0268d;
        }

        @Override // androidx.appcompat.view.b.a
        public boolean a(b bVar, Menu menu) {
            return this.f1835a.onPrepareActionMode(e(bVar), f(menu));
        }

        @Override // androidx.appcompat.view.b.a
        public boolean b(b bVar, MenuItem menuItem) {
            return this.f1835a.onActionItemClicked(e(bVar), new MenuItemC0267c(this.f1836b, (s.c) menuItem));
        }

        @Override // androidx.appcompat.view.b.a
        public boolean c(b bVar, Menu menu) {
            return this.f1835a.onCreateActionMode(e(bVar), f(menu));
        }

        @Override // androidx.appcompat.view.b.a
        public void d(b bVar) {
            this.f1835a.onDestroyActionMode(e(bVar));
        }

        public ActionMode e(b bVar) {
            int size = this.f1837c.size();
            for (int i2 = 0; i2 < size; i2++) {
                f fVar = (f) this.f1837c.get(i2);
                if (fVar != null && fVar.f1834b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f1836b, bVar);
            this.f1837c.add(fVar2);
            return fVar2;
        }
    }

    public f(Context context, b bVar) {
        this.f1833a = context;
        this.f1834b = bVar;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f1834b.c();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f1834b.d();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new MenuC0268d(this.f1833a, (s.b) this.f1834b.e());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f1834b.f();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f1834b.g();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f1834b.h();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f1834b.i();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f1834b.j();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f1834b.k();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f1834b.l();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f1834b.m(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f1834b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f1834b.p(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f1834b.r(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z2) {
        this.f1834b.s(z2);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i2) {
        this.f1834b.n(i2);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i2) {
        this.f1834b.q(i2);
    }
}
