package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.k;
import androidx.core.view.AbstractC0159b;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import defpackage.e;
import defpackage.s;
import f.AbstractC0250a;

/* loaded from: classes.dex */
public final class g implements s.c {

    /* renamed from: A */
    private View f1996A;

    /* renamed from: B */
    private AbstractC0159b f1997B;

    /* renamed from: C */
    private MenuItem.OnActionExpandListener f1998C;

    /* renamed from: E */
    private ContextMenu.ContextMenuInfo f2000E;

    /* renamed from: a */
    private final int f2001a;

    /* renamed from: b */
    private final int f2002b;

    /* renamed from: c */
    private final int f2003c;

    /* renamed from: d */
    private final int f2004d;
    private CharSequence e;

    /* renamed from: f */
    private CharSequence f2005f;

    /* renamed from: g */
    private Intent f2006g;

    /* renamed from: h */
    private char f2007h;

    /* renamed from: j */
    private char f2009j;

    /* renamed from: l */
    private Drawable f2011l;

    /* renamed from: n */
    e f2013n;
    private m o;

    /* renamed from: p */
    private Runnable f2014p;

    /* renamed from: q */
    private MenuItem.OnMenuItemClickListener f2015q;
    private CharSequence r;
    private CharSequence s;

    /* renamed from: z */
    private int f2022z;

    /* renamed from: i */
    private int f2008i = 4096;

    /* renamed from: k */
    private int f2010k = 4096;

    /* renamed from: m */
    private int f2012m = 0;

    /* renamed from: t */
    private ColorStateList f2016t = null;

    /* renamed from: u */
    private PorterDuff.Mode f2017u = null;

    /* renamed from: v */
    private boolean f2018v = false;

    /* renamed from: w */
    private boolean f2019w = false;

    /* renamed from: x */
    private boolean f2020x = false;

    /* renamed from: y */
    private int f2021y = 16;

    /* renamed from: D */
    private boolean f1999D = false;

    class a implements AbstractC0159b.InterfaceC0034b {
        a() {
        }

        @Override // androidx.core.view.AbstractC0159b.InterfaceC0034b
        public void onActionProviderVisibilityChanged(boolean z2) {
            g gVar = g.this;
            gVar.f2013n.K(gVar);
        }
    }

    g(e eVar, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6) {
        this.f2013n = eVar;
        this.f2001a = i3;
        this.f2002b = i2;
        this.f2003c = i4;
        this.f2004d = i5;
        this.e = charSequence;
        this.f2022z = i6;
    }

    private static void d(StringBuilder sb, int i2, int i3, String str) {
        if ((i2 & i3) == i3) {
            sb.append(str);
        }
    }

    private Drawable e(Drawable drawable) {
        if (drawable != null && this.f2020x && (this.f2018v || this.f2019w)) {
            drawable = androidx.core.graphics.drawable.a.p(drawable).mutate();
            if (this.f2018v) {
                androidx.core.graphics.drawable.a.n(drawable, this.f2016t);
            }
            if (this.f2019w) {
                androidx.core.graphics.drawable.a.o(drawable, this.f2017u);
            }
            this.f2020x = false;
        }
        return drawable;
    }

    boolean A() {
        return this.f2013n.I() && g() != 0;
    }

    public boolean B() {
        return (this.f2022z & 4) == 4;
    }

    @Override // s.c
    public s.c a(AbstractC0159b abstractC0159b) {
        AbstractC0159b abstractC0159b2 = this.f1997B;
        if (abstractC0159b2 != null) {
            abstractC0159b2.g();
        }
        this.f1996A = null;
        this.f1997B = abstractC0159b;
        this.f2013n.L(true);
        AbstractC0159b abstractC0159b3 = this.f1997B;
        if (abstractC0159b3 != null) {
            abstractC0159b3.i(new a());
        }
        return this;
    }

    @Override // s.c
    public AbstractC0159b b() {
        return this.f1997B;
    }

    public void c() {
        this.f2013n.J(this);
    }

    @Override // s.c, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.f2022z & 8) == 0) {
            return false;
        }
        if (this.f1996A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f1998C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f2013n.f(this);
        }
        return false;
    }

    @Override // s.c, android.view.MenuItem
    public boolean expandActionView() {
        if (!j()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f1998C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f2013n.k(this);
        }
        return false;
    }

    public int f() {
        return this.f2004d;
    }

    char g() {
        return this.f2013n.H() ? this.f2009j : this.f2007h;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // s.c, android.view.MenuItem
    public View getActionView() {
        View view = this.f1996A;
        if (view != null) {
            return view;
        }
        AbstractC0159b abstractC0159b = this.f1997B;
        if (abstractC0159b == null) {
            return null;
        }
        View viewC = abstractC0159b.c(this);
        this.f1996A = viewC;
        return viewC;
    }

    @Override // s.c, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f2010k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f2009j;
    }

    @Override // s.c, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.r;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f2002b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.f2011l;
        if (drawable != null) {
            return e(drawable);
        }
        if (this.f2012m == 0) {
            return null;
        }
        Drawable drawableB = AbstractC0250a.b(this.f2013n.u(), this.f2012m);
        this.f2012m = 0;
        this.f2011l = drawableB;
        return e(drawableB);
    }

    @Override // s.c, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f2016t;
    }

    @Override // s.c, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f2017u;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f2006g;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f2001a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f2000E;
    }

    @Override // s.c, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f2008i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f2007h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f2003c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.o;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f2005f;
        return charSequence != null ? charSequence : this.e;
    }

    @Override // s.c, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.s;
    }

    String h() {
        char cG = g();
        if (cG == 0) {
            return "";
        }
        Resources resources = this.f2013n.u().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.f2013n.u()).hasPermanentMenuKey()) {
            sb.append(resources.getString(e.k.f5967k));
        }
        int i2 = this.f2013n.H() ? this.f2010k : this.f2008i;
        d(sb, i2, ArrayPool.STANDARD_BUFFER_SIZE_BYTES, resources.getString(e.k.f5963g));
        d(sb, i2, 4096, resources.getString(e.k.f5960c));
        d(sb, i2, 2, resources.getString(e.k.f5959b));
        d(sb, i2, 1, resources.getString(e.k.f5964h));
        d(sb, i2, 4, resources.getString(e.k.f5966j));
        d(sb, i2, 8, resources.getString(e.k.f5962f));
        if (cG == '\b') {
            sb.append(resources.getString(e.k.f5961d));
        } else if (cG == '\n') {
            sb.append(resources.getString(e.k.e));
        } else if (cG != ' ') {
            sb.append(cG);
        } else {
            sb.append(resources.getString(e.k.f5965i));
        }
        return sb.toString();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.o != null;
    }

    CharSequence i(k.a aVar) {
        return (aVar == null || !aVar.d()) ? getTitle() : getTitleCondensed();
    }

    @Override // s.c, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f1999D;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f2021y & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f2021y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f2021y & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        AbstractC0159b abstractC0159b = this.f1997B;
        return (abstractC0159b == null || !abstractC0159b.f()) ? (this.f2021y & 8) == 0 : (this.f2021y & 8) == 0 && this.f1997B.b();
    }

    public boolean j() {
        AbstractC0159b abstractC0159b;
        if ((this.f2022z & 8) == 0) {
            return false;
        }
        if (this.f1996A == null && (abstractC0159b = this.f1997B) != null) {
            this.f1996A = abstractC0159b.c(this);
        }
        return this.f1996A != null;
    }

    public boolean k() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f2015q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        e eVar = this.f2013n;
        if (eVar.h(eVar, this)) {
            return true;
        }
        Runnable runnable = this.f2014p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f2006g != null) {
            try {
                this.f2013n.u().startActivity(this.f2006g);
                return true;
            } catch (ActivityNotFoundException e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        AbstractC0159b abstractC0159b = this.f1997B;
        return abstractC0159b != null && abstractC0159b.d();
    }

    public boolean l() {
        return (this.f2021y & 32) == 32;
    }

    public boolean m() {
        return (this.f2021y & 4) != 0;
    }

    public boolean n() {
        return (this.f2022z & 1) == 1;
    }

    public boolean o() {
        return (this.f2022z & 2) == 2;
    }

    @Override // s.c, android.view.MenuItem
    /* renamed from: p */
    public s.c setActionView(int i2) {
        Context contextU = this.f2013n.u();
        setActionView(LayoutInflater.from(contextU).inflate(i2, (ViewGroup) new LinearLayout(contextU), false));
        return this;
    }

    @Override // s.c, android.view.MenuItem
    /* renamed from: q */
    public s.c setActionView(View view) {
        int i2;
        this.f1996A = view;
        this.f1997B = null;
        if (view != null && view.getId() == -1 && (i2 = this.f2001a) > 0) {
            view.setId(i2);
        }
        this.f2013n.J(this);
        return this;
    }

    public void r(boolean z2) {
        this.f1999D = z2;
        this.f2013n.L(false);
    }

    void s(boolean z2) {
        int i2 = this.f2021y;
        int i3 = (z2 ? 2 : 0) | (i2 & (-3));
        this.f2021y = i3;
        if (i2 != i3) {
            this.f2013n.L(false);
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        if (this.f2009j == c2) {
            return this;
        }
        this.f2009j = Character.toLowerCase(c2);
        this.f2013n.L(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z2) {
        int i2 = this.f2021y;
        int i3 = (z2 ? 1 : 0) | (i2 & (-2));
        this.f2021y = i3;
        if (i2 != i3) {
            this.f2013n.L(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z2) {
        if ((this.f2021y & 4) != 0) {
            this.f2013n.U(this);
        } else {
            s(z2);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z2) {
        if (z2) {
            this.f2021y |= 16;
        } else {
            this.f2021y &= -17;
        }
        this.f2013n.L(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f2012m = 0;
        this.f2011l = drawable;
        this.f2020x = true;
        this.f2013n.L(false);
        return this;
    }

    @Override // s.c, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f2016t = colorStateList;
        this.f2018v = true;
        this.f2020x = true;
        this.f2013n.L(false);
        return this;
    }

    @Override // s.c, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f2017u = mode;
        this.f2019w = true;
        this.f2020x = true;
        this.f2013n.L(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f2006g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        if (this.f2007h == c2) {
            return this;
        }
        this.f2007h = c2;
        this.f2013n.L(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f1998C = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f2015q = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        this.f2007h = c2;
        this.f2009j = Character.toLowerCase(c3);
        this.f2013n.L(false);
        return this;
    }

    @Override // s.c, android.view.MenuItem
    public void setShowAsAction(int i2) {
        int i3 = i2 & 3;
        if (i3 != 0 && i3 != 1 && i3 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f2022z = i2;
        this.f2013n.J(this);
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.e = charSequence;
        this.f2013n.L(false);
        m mVar = this.o;
        if (mVar != null) {
            mVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f2005f = charSequence;
        this.f2013n.L(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z2) {
        if (y(z2)) {
            this.f2013n.K(this);
        }
        return this;
    }

    public void t(boolean z2) {
        this.f2021y = (z2 ? 4 : 0) | (this.f2021y & (-5));
    }

    public String toString() {
        CharSequence charSequence = this.e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void u(boolean z2) {
        if (z2) {
            this.f2021y |= 32;
        } else {
            this.f2021y &= -33;
        }
    }

    void v(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f2000E = contextMenuInfo;
    }

    @Override // s.c, android.view.MenuItem
    /* renamed from: w */
    public s.c setShowAsActionFlags(int i2) {
        setShowAsAction(i2);
        return this;
    }

    public void x(m mVar) {
        this.o = mVar;
        mVar.setHeaderTitle(getTitle());
    }

    boolean y(boolean z2) {
        int i2 = this.f2021y;
        int i3 = (z2 ? 0 : 8) | (i2 & (-9));
        this.f2021y = i3;
        return i2 != i3;
    }

    public boolean z() {
        return this.f2013n.A();
    }

    @Override // android.view.MenuItem
    public s.c setContentDescription(CharSequence charSequence) {
        this.r = charSequence;
        this.f2013n.L(false);
        return this;
    }

    @Override // android.view.MenuItem
    public s.c setTooltipText(CharSequence charSequence) {
        this.s = charSequence;
        this.f2013n.L(false);
        return this;
    }

    @Override // s.c, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        if (this.f2009j == c2 && this.f2010k == i2) {
            return this;
        }
        this.f2009j = Character.toLowerCase(c2);
        this.f2010k = KeyEvent.normalizeMetaState(i2);
        this.f2013n.L(false);
        return this;
    }

    @Override // s.c, android.view.MenuItem
    public MenuItem setNumericShortcut(char c2, int i2) {
        if (this.f2007h == c2 && this.f2008i == i2) {
            return this;
        }
        this.f2007h = c2;
        this.f2008i = KeyEvent.normalizeMetaState(i2);
        this.f2013n.L(false);
        return this;
    }

    @Override // s.c, android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.f2007h = c2;
        this.f2008i = KeyEvent.normalizeMetaState(i2);
        this.f2009j = Character.toLowerCase(c3);
        this.f2010k = KeyEvent.normalizeMetaState(i3);
        this.f2013n.L(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i2) {
        this.f2011l = null;
        this.f2012m = i2;
        this.f2020x = true;
        this.f2013n.L(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i2) {
        return setTitle(this.f2013n.u().getString(i2));
    }
}
