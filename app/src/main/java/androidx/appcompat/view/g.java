package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.widget.M;
import androidx.appcompat.widget.d0;
import androidx.core.view.AbstractC0159b;
import androidx.core.view.AbstractC0181y;
import defpackage.e;
import defpackage.s;
import i.MenuItemC0267c;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class g extends MenuInflater {
    static final Class[] e;

    /* renamed from: f, reason: collision with root package name */
    static final Class[] f1839f;

    /* renamed from: a, reason: collision with root package name */
    final Object[] f1840a;

    /* renamed from: b, reason: collision with root package name */
    final Object[] f1841b;

    /* renamed from: c, reason: collision with root package name */
    Context f1842c;

    /* renamed from: d, reason: collision with root package name */
    private Object f1843d;

    private static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: c, reason: collision with root package name */
        private static final Class[] f1844c = {MenuItem.class};

        /* renamed from: a, reason: collision with root package name */
        private Object f1845a;

        /* renamed from: b, reason: collision with root package name */
        private Method f1846b;

        public a(Object obj, String str) {
            this.f1845a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f1846b = cls.getMethod(str, f1844c);
            } catch (Exception e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            try {
                if (this.f1846b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f1846b.invoke(this.f1845a, menuItem)).booleanValue();
                }
                this.f1846b.invoke(this.f1845a, menuItem);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class b {

        /* renamed from: A, reason: collision with root package name */
        AbstractC0159b f1847A;

        /* renamed from: B, reason: collision with root package name */
        private CharSequence f1848B;

        /* renamed from: C, reason: collision with root package name */
        private CharSequence f1849C;

        /* renamed from: D, reason: collision with root package name */
        private ColorStateList f1850D = null;

        /* renamed from: E, reason: collision with root package name */
        private PorterDuff.Mode f1851E = null;

        /* renamed from: a, reason: collision with root package name */
        private Menu f1853a;

        /* renamed from: b, reason: collision with root package name */
        private int f1854b;

        /* renamed from: c, reason: collision with root package name */
        private int f1855c;

        /* renamed from: d, reason: collision with root package name */
        private int f1856d;
        private int e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f1857f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f1858g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f1859h;

        /* renamed from: i, reason: collision with root package name */
        private int f1860i;

        /* renamed from: j, reason: collision with root package name */
        private int f1861j;

        /* renamed from: k, reason: collision with root package name */
        private CharSequence f1862k;

        /* renamed from: l, reason: collision with root package name */
        private CharSequence f1863l;

        /* renamed from: m, reason: collision with root package name */
        private int f1864m;

        /* renamed from: n, reason: collision with root package name */
        private char f1865n;
        private int o;

        /* renamed from: p, reason: collision with root package name */
        private char f1866p;

        /* renamed from: q, reason: collision with root package name */
        private int f1867q;
        private int r;
        private boolean s;

        /* renamed from: t, reason: collision with root package name */
        private boolean f1868t;

        /* renamed from: u, reason: collision with root package name */
        private boolean f1869u;

        /* renamed from: v, reason: collision with root package name */
        private int f1870v;

        /* renamed from: w, reason: collision with root package name */
        private int f1871w;

        /* renamed from: x, reason: collision with root package name */
        private String f1872x;

        /* renamed from: y, reason: collision with root package name */
        private String f1873y;

        /* renamed from: z, reason: collision with root package name */
        private String f1874z;

        public b(Menu menu) {
            this.f1853a = menu;
            h();
        }

        private char c(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private Object e(String str, Class[] clsArr, Object[] objArr) throws NoSuchMethodException, SecurityException {
            try {
                Constructor<?> constructor = Class.forName(str, false, g.this.f1842c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }

        private void i(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            boolean z2 = false;
            menuItem.setChecked(this.s).setVisible(this.f1868t).setEnabled(this.f1869u).setCheckable(this.r >= 1).setTitleCondensed(this.f1863l).setIcon(this.f1864m);
            int i2 = this.f1870v;
            if (i2 >= 0) {
                menuItem.setShowAsAction(i2);
            }
            if (this.f1874z != null) {
                if (g.this.f1842c.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(g.this.b(), this.f1874z));
            }
            if (this.r >= 2) {
                if (menuItem instanceof androidx.appcompat.view.menu.g) {
                    ((androidx.appcompat.view.menu.g) menuItem).t(true);
                } else if (menuItem instanceof MenuItemC0267c) {
                    ((MenuItemC0267c) menuItem).h(true);
                }
            }
            String str = this.f1872x;
            if (str != null) {
                menuItem.setActionView((View) e(str, g.e, g.this.f1840a));
                z2 = true;
            }
            int i3 = this.f1871w;
            if (i3 > 0) {
                if (z2) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(i3);
                }
            }
            AbstractC0159b abstractC0159b = this.f1847A;
            if (abstractC0159b != null) {
                AbstractC0181y.a(menuItem, abstractC0159b);
            }
            AbstractC0181y.c(menuItem, this.f1848B);
            AbstractC0181y.g(menuItem, this.f1849C);
            AbstractC0181y.b(menuItem, this.f1865n, this.o);
            AbstractC0181y.f(menuItem, this.f1866p, this.f1867q);
            PorterDuff.Mode mode = this.f1851E;
            if (mode != null) {
                AbstractC0181y.e(menuItem, mode);
            }
            ColorStateList colorStateList = this.f1850D;
            if (colorStateList != null) {
                AbstractC0181y.d(menuItem, colorStateList);
            }
        }

        public void a() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.f1859h = true;
            i(this.f1853a.add(this.f1854b, this.f1860i, this.f1861j, this.f1862k));
        }

        public SubMenu b() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.f1859h = true;
            SubMenu subMenuAddSubMenu = this.f1853a.addSubMenu(this.f1854b, this.f1860i, this.f1861j, this.f1862k);
            i(subMenuAddSubMenu.getItem());
            return subMenuAddSubMenu;
        }

        public boolean d() {
            return this.f1859h;
        }

        public void f(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = g.this.f1842c.obtainStyledAttributes(attributeSet, e.m.f6066o1);
            this.f1854b = typedArrayObtainStyledAttributes.getResourceId(e.m.f6072q1, 0);
            this.f1855c = typedArrayObtainStyledAttributes.getInt(e.m.f6076s1, 0);
            this.f1856d = typedArrayObtainStyledAttributes.getInt(e.m.f6079t1, 0);
            this.e = typedArrayObtainStyledAttributes.getInt(e.m.f6082u1, 0);
            this.f1857f = typedArrayObtainStyledAttributes.getBoolean(e.m.f6074r1, true);
            this.f1858g = typedArrayObtainStyledAttributes.getBoolean(e.m.f6069p1, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        public void g(AttributeSet attributeSet) {
            d0 d0VarT = d0.t(g.this.f1842c, attributeSet, e.m.v1);
            this.f1860i = d0VarT.m(e.m.y1, 0);
            this.f1861j = (d0VarT.j(e.m.B1, this.f1855c) & (-65536)) | (d0VarT.j(e.m.C1, this.f1856d) & 65535);
            this.f1862k = d0VarT.o(e.m.D1);
            this.f1863l = d0VarT.o(e.m.E1);
            this.f1864m = d0VarT.m(e.m.w1, 0);
            this.f1865n = c(d0VarT.n(e.m.F1));
            this.o = d0VarT.j(e.m.M1, 4096);
            this.f1866p = c(d0VarT.n(e.m.G1));
            this.f1867q = d0VarT.j(e.m.Q1, 4096);
            int i2 = e.m.H1;
            if (d0VarT.r(i2)) {
                this.r = d0VarT.a(i2, false) ? 1 : 0;
            } else {
                this.r = this.e;
            }
            this.s = d0VarT.a(e.m.z1, false);
            this.f1868t = d0VarT.a(e.m.A1, this.f1857f);
            this.f1869u = d0VarT.a(e.m.x1, this.f1858g);
            this.f1870v = d0VarT.j(e.m.R1, -1);
            this.f1874z = d0VarT.n(e.m.I1);
            this.f1871w = d0VarT.m(e.m.J1, 0);
            this.f1872x = d0VarT.n(e.m.L1);
            String strN = d0VarT.n(e.m.K1);
            this.f1873y = strN;
            boolean z2 = strN != null;
            if (z2 && this.f1871w == 0 && this.f1872x == null) {
                this.f1847A = (AbstractC0159b) e(strN, g.f1839f, g.this.f1841b);
            } else {
                if (z2) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f1847A = null;
            }
            this.f1848B = d0VarT.o(e.m.N1);
            this.f1849C = d0VarT.o(e.m.S1);
            int i3 = e.m.P1;
            if (d0VarT.r(i3)) {
                this.f1851E = M.c(d0VarT.j(i3, -1), this.f1851E);
            } else {
                this.f1851E = null;
            }
            int i4 = e.m.O1;
            if (d0VarT.r(i4)) {
                this.f1850D = d0VarT.c(i4);
            } else {
                this.f1850D = null;
            }
            d0VarT.w();
            this.f1859h = false;
        }

        public void h() {
            this.f1854b = 0;
            this.f1855c = 0;
            this.f1856d = 0;
            this.e = 0;
            this.f1857f = true;
            this.f1858g = true;
        }
    }

    static {
        Class[] clsArr = {Context.class};
        e = clsArr;
        f1839f = clsArr;
    }

    public g(Context context) {
        super(context);
        this.f1842c = context;
        Object[] objArr = {context};
        this.f1840a = objArr;
        this.f1841b = objArr;
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    private void c(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (!name.equals("menu")) {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
                eventType = xmlPullParser.next();
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        String str = null;
        boolean z2 = false;
        boolean z3 = false;
        while (!z2) {
            if (eventType == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType != 2) {
                if (eventType == 3) {
                    String name2 = xmlPullParser.getName();
                    if (z3 && name2.equals(str)) {
                        str = null;
                        z3 = false;
                    } else if (name2.equals("group")) {
                        bVar.h();
                    } else if (name2.equals("item")) {
                        if (!bVar.d()) {
                            AbstractC0159b abstractC0159b = bVar.f1847A;
                            if (abstractC0159b == null || !abstractC0159b.a()) {
                                bVar.a();
                            } else {
                                bVar.b();
                            }
                        }
                    } else if (name2.equals("menu")) {
                        z2 = true;
                    }
                }
            } else if (!z3) {
                String name3 = xmlPullParser.getName();
                if (name3.equals("group")) {
                    bVar.f(attributeSet);
                } else if (name3.equals("item")) {
                    bVar.g(attributeSet);
                } else if (name3.equals("menu")) {
                    c(xmlPullParser, attributeSet, bVar.b());
                } else {
                    str = name3;
                    z3 = true;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    Object b() {
        if (this.f1843d == null) {
            this.f1843d = a(this.f1842c);
        }
        return this.f1843d;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i2, Menu menu) {
        if (!(menu instanceof s.b)) {
            super.inflate(i2, menu);
            return;
        }
        XmlResourceParser layout = null;
        boolean z2 = false;
        try {
            try {
                layout = this.f1842c.getResources().getLayout(i2);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(layout);
                if (menu instanceof androidx.appcompat.view.menu.e) {
                    androidx.appcompat.view.menu.e eVar = (androidx.appcompat.view.menu.e) menu;
                    if (eVar.F()) {
                        eVar.e0();
                        z2 = true;
                    }
                }
                c(layout, attributeSetAsAttributeSet, menu);
                if (z2) {
                    ((androidx.appcompat.view.menu.e) menu).d0();
                }
                if (layout != null) {
                    layout.close();
                }
            } catch (IOException e2) {
                throw new InflateException("Error inflating menu XML", e2);
            } catch (XmlPullParserException e3) {
                throw new InflateException("Error inflating menu XML", e3);
            }
        } catch (Throwable th) {
            if (z2) {
                ((androidx.appcompat.view.menu.e) menu).d0();
            }
            if (layout != null) {
                layout.close();
            }
            throw th;
        }
    }
}
