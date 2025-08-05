package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.e;

/* loaded from: classes.dex */
public class m extends e implements SubMenu {

    /* renamed from: B */
    private e f2056B;

    /* renamed from: C */
    private g f2057C;

    public m(Context context, e eVar, g gVar) {
        super(context);
        this.f2056B = eVar;
        this.f2057C = gVar;
    }

    @Override // androidx.appcompat.view.menu.e
    public e D() {
        return this.f2056B.D();
    }

    @Override // androidx.appcompat.view.menu.e
    public boolean G() {
        return this.f2056B.G();
    }

    @Override // androidx.appcompat.view.menu.e
    public boolean H() {
        return this.f2056B.H();
    }

    @Override // androidx.appcompat.view.menu.e
    public boolean I() {
        return this.f2056B.I();
    }

    @Override // androidx.appcompat.view.menu.e
    public void S(e.a aVar) {
        this.f2056B.S(aVar);
    }

    @Override // androidx.appcompat.view.menu.e
    public boolean f(g gVar) {
        return this.f2056B.f(gVar);
    }

    public Menu f0() {
        return this.f2056B;
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.f2057C;
    }

    @Override // androidx.appcompat.view.menu.e
    boolean h(e eVar, MenuItem menuItem) {
        return super.h(eVar, menuItem) || this.f2056B.h(eVar, menuItem);
    }

    @Override // androidx.appcompat.view.menu.e
    public boolean k(g gVar) {
        return this.f2056B.k(gVar);
    }

    @Override // androidx.appcompat.view.menu.e, android.view.Menu
    public void setGroupDividerEnabled(boolean z2) {
        this.f2056B.setGroupDividerEnabled(z2);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.W(drawable);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.Z(charSequence);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.a0(view);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.f2057C.setIcon(drawable);
        return this;
    }

    @Override // androidx.appcompat.view.menu.e, android.view.Menu
    public void setQwertyMode(boolean z2) {
        this.f2056B.setQwertyMode(z2);
    }

    @Override // androidx.appcompat.view.menu.e
    public String t() {
        g gVar = this.f2057C;
        int itemId = gVar != null ? gVar.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.t() + ":" + itemId;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i2) {
        return (SubMenu) super.V(i2);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i2) {
        return (SubMenu) super.Y(i2);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i2) {
        this.f2057C.setIcon(i2);
        return this;
    }
}
