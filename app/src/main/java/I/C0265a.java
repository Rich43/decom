package i;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.view.AbstractC0159b;
import defpackage.s;

/* renamed from: i.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0265a implements s.c {

    /* renamed from: a, reason: collision with root package name */
    private final int f6428a;

    /* renamed from: b, reason: collision with root package name */
    private final int f6429b;

    /* renamed from: c, reason: collision with root package name */
    private final int f6430c;

    /* renamed from: d, reason: collision with root package name */
    private CharSequence f6431d;
    private CharSequence e;

    /* renamed from: f, reason: collision with root package name */
    private Intent f6432f;

    /* renamed from: g, reason: collision with root package name */
    private char f6433g;

    /* renamed from: i, reason: collision with root package name */
    private char f6435i;

    /* renamed from: k, reason: collision with root package name */
    private Drawable f6437k;

    /* renamed from: l, reason: collision with root package name */
    private Context f6438l;

    /* renamed from: m, reason: collision with root package name */
    private MenuItem.OnMenuItemClickListener f6439m;

    /* renamed from: n, reason: collision with root package name */
    private CharSequence f6440n;
    private CharSequence o;

    /* renamed from: h, reason: collision with root package name */
    private int f6434h = 4096;

    /* renamed from: j, reason: collision with root package name */
    private int f6436j = 4096;

    /* renamed from: p, reason: collision with root package name */
    private ColorStateList f6441p = null;

    /* renamed from: q, reason: collision with root package name */
    private PorterDuff.Mode f6442q = null;
    private boolean r = false;
    private boolean s = false;

    /* renamed from: t, reason: collision with root package name */
    private int f6443t = 16;

    public C0265a(Context context, int i2, int i3, int i4, int i5, CharSequence charSequence) {
        this.f6438l = context;
        this.f6428a = i3;
        this.f6429b = i2;
        this.f6430c = i5;
        this.f6431d = charSequence;
    }

    private void c() {
        Drawable drawable = this.f6437k;
        if (drawable != null) {
            if (this.r || this.s) {
                Drawable drawableP = androidx.core.graphics.drawable.a.p(drawable);
                this.f6437k = drawableP;
                Drawable drawableMutate = drawableP.mutate();
                this.f6437k = drawableMutate;
                if (this.r) {
                    androidx.core.graphics.drawable.a.n(drawableMutate, this.f6441p);
                }
                if (this.s) {
                    androidx.core.graphics.drawable.a.o(this.f6437k, this.f6442q);
                }
            }
        }
    }

    @Override // s.c
    public s.c a(AbstractC0159b abstractC0159b) {
        throw new UnsupportedOperationException();
    }

    @Override // s.c
    public AbstractC0159b b() {
        return null;
    }

    @Override // s.c, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // s.c, android.view.MenuItem
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public s.c setActionView(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // s.c, android.view.MenuItem
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public s.c setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // s.c, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // s.c, android.view.MenuItem
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public s.c setShowAsActionFlags(int i2) {
        setShowAsAction(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // s.c, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // s.c, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f6436j;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f6435i;
    }

    @Override // s.c, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f6440n;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f6429b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f6437k;
    }

    @Override // s.c, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f6441p;
    }

    @Override // s.c, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f6442q;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f6432f;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f6428a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // s.c, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f6434h;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f6433g;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f6430c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f6431d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.e;
        return charSequence != null ? charSequence : this.f6431d;
    }

    @Override // s.c, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.o;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // s.c, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f6443t & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f6443t & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f6443t & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f6443t & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        this.f6435i = Character.toLowerCase(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z2) {
        this.f6443t = (z2 ? 1 : 0) | (this.f6443t & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z2) {
        this.f6443t = (z2 ? 2 : 0) | (this.f6443t & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z2) {
        this.f6443t = (z2 ? 16 : 0) | (this.f6443t & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f6437k = drawable;
        c();
        return this;
    }

    @Override // s.c, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f6441p = colorStateList;
        this.r = true;
        c();
        return this;
    }

    @Override // s.c, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f6442q = mode;
        this.s = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f6432f = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        this.f6433g = c2;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f6439m = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        this.f6433g = c2;
        this.f6435i = Character.toLowerCase(c3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f6431d = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z2) {
        this.f6443t = (this.f6443t & 8) | (z2 ? 0 : 8);
        return this;
    }

    @Override // s.c, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        this.f6435i = Character.toLowerCase(c2);
        this.f6436j = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public s.c setContentDescription(CharSequence charSequence) {
        this.f6440n = charSequence;
        return this;
    }

    @Override // s.c, android.view.MenuItem
    public MenuItem setNumericShortcut(char c2, int i2) {
        this.f6433g = c2;
        this.f6434h = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i2) {
        this.f6431d = this.f6438l.getResources().getString(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public s.c setTooltipText(CharSequence charSequence) {
        this.o = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i2) {
        this.f6437k = androidx.core.content.a.d(this.f6438l, i2);
        c();
        return this;
    }

    @Override // s.c, android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.f6433g = c2;
        this.f6434h = KeyEvent.normalizeMetaState(i2);
        this.f6435i = Character.toLowerCase(c3);
        this.f6436j = KeyEvent.normalizeMetaState(i3);
        return this;
    }

    @Override // s.c, android.view.MenuItem
    public void setShowAsAction(int i2) {
    }
}
