package i;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.AbstractC0159b;
import defpackage.s;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: i.c */
/* loaded from: classes.dex */
public class MenuItemC0267c extends AbstractC0266b implements MenuItem {

    /* renamed from: d */
    private final s.c f6447d;
    private Method e;

    /* renamed from: i.c$a */
    private class a extends AbstractC0159b implements ActionProvider.VisibilityListener {

        /* renamed from: d */
        private AbstractC0159b.InterfaceC0034b f6448d;
        private final ActionProvider e;

        a(Context context, ActionProvider actionProvider) {
            super(context);
            this.e = actionProvider;
        }

        @Override // androidx.core.view.AbstractC0159b
        public boolean a() {
            return this.e.hasSubMenu();
        }

        @Override // androidx.core.view.AbstractC0159b
        public boolean b() {
            return this.e.isVisible();
        }

        @Override // androidx.core.view.AbstractC0159b
        public View c(MenuItem menuItem) {
            return this.e.onCreateActionView(menuItem);
        }

        @Override // androidx.core.view.AbstractC0159b
        public boolean d() {
            return this.e.onPerformDefaultAction();
        }

        @Override // androidx.core.view.AbstractC0159b
        public void e(SubMenu subMenu) {
            this.e.onPrepareSubMenu(MenuItemC0267c.this.d(subMenu));
        }

        @Override // androidx.core.view.AbstractC0159b
        public boolean f() {
            return this.e.overridesItemVisibility();
        }

        @Override // androidx.core.view.AbstractC0159b
        public void i(AbstractC0159b.InterfaceC0034b interfaceC0034b) {
            this.f6448d = interfaceC0034b;
            this.e.setVisibilityListener(interfaceC0034b != null ? this : null);
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z2) {
            AbstractC0159b.InterfaceC0034b interfaceC0034b = this.f6448d;
            if (interfaceC0034b != null) {
                interfaceC0034b.onActionProviderVisibilityChanged(z2);
            }
        }
    }

    /* renamed from: i.c$b */
    static class b extends FrameLayout implements androidx.appcompat.view.c {

        /* renamed from: a */
        final CollapsibleActionView f6450a;

        /* JADX WARN: Multi-variable type inference failed */
        b(View view) {
            super(view.getContext());
            this.f6450a = (CollapsibleActionView) view;
            addView(view);
        }

        View a() {
            return (View) this.f6450a;
        }

        @Override // androidx.appcompat.view.c
        public void c() {
            this.f6450a.onActionViewExpanded();
        }

        @Override // androidx.appcompat.view.c
        public void f() {
            this.f6450a.onActionViewCollapsed();
        }
    }

    /* renamed from: i.c$c */
    private class MenuItemOnActionExpandListenerC0085c implements MenuItem.OnActionExpandListener {

        /* renamed from: a */
        private final MenuItem.OnActionExpandListener f6451a;

        MenuItemOnActionExpandListenerC0085c(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f6451a = onActionExpandListener;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f6451a.onMenuItemActionCollapse(MenuItemC0267c.this.c(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f6451a.onMenuItemActionExpand(MenuItemC0267c.this.c(menuItem));
        }
    }

    /* renamed from: i.c$d */
    private class d implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a */
        private final MenuItem.OnMenuItemClickListener f6453a;

        d(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f6453a = onMenuItemClickListener;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f6453a.onMenuItemClick(MenuItemC0267c.this.c(menuItem));
        }
    }

    public MenuItemC0267c(Context context, s.c cVar) {
        super(context);
        if (cVar == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f6447d = cVar;
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return this.f6447d.collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return this.f6447d.expandActionView();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        AbstractC0159b abstractC0159bB = this.f6447d.b();
        if (abstractC0159bB instanceof a) {
            return ((a) abstractC0159bB).e;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = this.f6447d.getActionView();
        return actionView instanceof b ? ((b) actionView).a() : actionView;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f6447d.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f6447d.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f6447d.getContentDescription();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f6447d.getGroupId();
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f6447d.getIcon();
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f6447d.getIconTintList();
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f6447d.getIconTintMode();
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f6447d.getIntent();
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f6447d.getItemId();
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f6447d.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.f6447d.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f6447d.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f6447d.getOrder();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return d(this.f6447d.getSubMenu());
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f6447d.getTitle();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f6447d.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f6447d.getTooltipText();
    }

    public void h(boolean z2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            if (this.e == null) {
                this.e = this.f6447d.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.e.invoke(this.f6447d, Boolean.valueOf(z2));
        } catch (Exception e) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        }
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f6447d.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f6447d.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return this.f6447d.isCheckable();
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return this.f6447d.isChecked();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.f6447d.isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.f6447d.isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        a aVar = new a(this.f6444a, actionProvider);
        s.c cVar = this.f6447d;
        if (actionProvider == null) {
            aVar = null;
        }
        cVar.a(aVar);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new b(view);
        }
        this.f6447d.setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        this.f6447d.setAlphabeticShortcut(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z2) {
        this.f6447d.setCheckable(z2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z2) {
        this.f6447d.setChecked(z2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f6447d.setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z2) {
        this.f6447d.setEnabled(z2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f6447d.setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f6447d.setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f6447d.setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f6447d.setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        this.f6447d.setNumericShortcut(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f6447d.setOnActionExpandListener(onActionExpandListener != null ? new MenuItemOnActionExpandListenerC0085c(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f6447d.setOnMenuItemClickListener(onMenuItemClickListener != null ? new d(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        this.f6447d.setShortcut(c2, c3);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i2) {
        this.f6447d.setShowAsAction(i2);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i2) {
        this.f6447d.setShowAsActionFlags(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f6447d.setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f6447d.setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f6447d.setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z2) {
        return this.f6447d.setVisible(z2);
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        this.f6447d.setAlphabeticShortcut(c2, i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i2) {
        this.f6447d.setIcon(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2, int i2) {
        this.f6447d.setNumericShortcut(c2, i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.f6447d.setShortcut(c2, c3, i2, i3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i2) {
        this.f6447d.setTitle(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i2) {
        this.f6447d.setActionView(i2);
        View actionView = this.f6447d.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f6447d.setActionView(new b(actionView));
        }
        return this;
    }
}
