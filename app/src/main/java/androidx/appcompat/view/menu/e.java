package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.view.AbstractC0159b;
import defpackage.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class e implements s.b {

    /* renamed from: A */
    private static final int[] f1969A = {1, 4, 5, 3, 2, 0};

    /* renamed from: a */
    private final Context f1970a;

    /* renamed from: b */
    private final Resources f1971b;

    /* renamed from: c */
    private boolean f1972c;

    /* renamed from: d */
    private boolean f1973d;
    private a e;

    /* renamed from: m */
    private ContextMenu.ContextMenuInfo f1981m;

    /* renamed from: n */
    CharSequence f1982n;
    Drawable o;

    /* renamed from: p */
    View f1983p;

    /* renamed from: x */
    private g f1989x;

    /* renamed from: z */
    private boolean f1991z;

    /* renamed from: l */
    private int f1980l = 0;

    /* renamed from: q */
    private boolean f1984q = false;
    private boolean r = false;
    private boolean s = false;

    /* renamed from: t */
    private boolean f1985t = false;

    /* renamed from: u */
    private boolean f1986u = false;

    /* renamed from: v */
    private ArrayList f1987v = new ArrayList();

    /* renamed from: w */
    private CopyOnWriteArrayList f1988w = new CopyOnWriteArrayList();

    /* renamed from: y */
    private boolean f1990y = false;

    /* renamed from: f */
    private ArrayList f1974f = new ArrayList();

    /* renamed from: g */
    private ArrayList f1975g = new ArrayList();

    /* renamed from: h */
    private boolean f1976h = true;

    /* renamed from: i */
    private ArrayList f1977i = new ArrayList();

    /* renamed from: j */
    private ArrayList f1978j = new ArrayList();

    /* renamed from: k */
    private boolean f1979k = true;

    public interface a {
        boolean a(e eVar, MenuItem menuItem);

        void b(e eVar);
    }

    public interface b {
        boolean a(g gVar);
    }

    public e(Context context) {
        this.f1970a = context;
        this.f1971b = context.getResources();
        c0(true);
    }

    private static int B(int i2) {
        int i3 = ((-65536) & i2) >> 16;
        if (i3 >= 0) {
            int[] iArr = f1969A;
            if (i3 < iArr.length) {
                return (i2 & 65535) | (iArr[i3] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void O(int i2, boolean z2) {
        if (i2 < 0 || i2 >= this.f1974f.size()) {
            return;
        }
        this.f1974f.remove(i2);
        if (z2) {
            L(true);
        }
    }

    private void X(int i2, CharSequence charSequence, int i3, Drawable drawable, View view) {
        Resources resourcesC = C();
        if (view != null) {
            this.f1983p = view;
            this.f1982n = null;
            this.o = null;
        } else {
            if (i2 > 0) {
                this.f1982n = resourcesC.getText(i2);
            } else if (charSequence != null) {
                this.f1982n = charSequence;
            }
            if (i3 > 0) {
                this.o = androidx.core.content.a.d(u(), i3);
            } else if (drawable != null) {
                this.o = drawable;
            }
            this.f1983p = null;
        }
        L(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c0(boolean r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L1c
            android.content.res.Resources r3 = r2.f1971b
            android.content.res.Configuration r3 = r3.getConfiguration()
            int r3 = r3.keyboard
            r0 = 1
            if (r3 == r0) goto L1c
            android.content.Context r3 = r2.f1970a
            android.view.ViewConfiguration r3 = android.view.ViewConfiguration.get(r3)
            android.content.Context r1 = r2.f1970a
            boolean r3 = androidx.core.view.Q.l(r3, r1)
            if (r3 == 0) goto L1c
            goto L1d
        L1c:
            r0 = 0
        L1d:
            r2.f1973d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.e.c0(boolean):void");
    }

    private g g(int i2, int i3, int i4, int i5, CharSequence charSequence, int i6) {
        return new g(this, i2, i3, i4, i5, charSequence, i6);
    }

    private void i(boolean z2) {
        if (this.f1988w.isEmpty()) {
            return;
        }
        e0();
        Iterator it = this.f1988w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            j jVar = (j) weakReference.get();
            if (jVar == null) {
                this.f1988w.remove(weakReference);
            } else {
                jVar.j(z2);
            }
        }
        d0();
    }

    private boolean j(m mVar, j jVar) {
        if (this.f1988w.isEmpty()) {
            return false;
        }
        boolean zI = jVar != null ? jVar.i(mVar) : false;
        Iterator it = this.f1988w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            j jVar2 = (j) weakReference.get();
            if (jVar2 == null) {
                this.f1988w.remove(weakReference);
            } else if (!zI) {
                zI = jVar2.i(mVar);
            }
        }
        return zI;
    }

    private static int n(ArrayList arrayList, int i2) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((g) arrayList.get(size)).f() <= i2) {
                return size + 1;
            }
        }
        return 0;
    }

    boolean A() {
        return this.f1985t;
    }

    Resources C() {
        return this.f1971b;
    }

    public e D() {
        return this;
    }

    public ArrayList E() {
        if (!this.f1976h) {
            return this.f1975g;
        }
        this.f1975g.clear();
        int size = this.f1974f.size();
        for (int i2 = 0; i2 < size; i2++) {
            g gVar = (g) this.f1974f.get(i2);
            if (gVar.isVisible()) {
                this.f1975g.add(gVar);
            }
        }
        this.f1976h = false;
        this.f1979k = true;
        return this.f1975g;
    }

    public boolean F() {
        return !this.f1984q;
    }

    public boolean G() {
        return this.f1990y;
    }

    boolean H() {
        return this.f1972c;
    }

    public boolean I() {
        return this.f1973d;
    }

    void J(g gVar) {
        this.f1979k = true;
        L(true);
    }

    void K(g gVar) {
        this.f1976h = true;
        L(true);
    }

    public void L(boolean z2) {
        if (this.f1984q) {
            this.r = true;
            if (z2) {
                this.s = true;
                return;
            }
            return;
        }
        if (z2) {
            this.f1976h = true;
            this.f1979k = true;
        }
        i(z2);
    }

    public boolean M(MenuItem menuItem, int i2) {
        return N(menuItem, null, i2);
    }

    public boolean N(MenuItem menuItem, j jVar, int i2) {
        g gVar = (g) menuItem;
        if (gVar == null || !gVar.isEnabled()) {
            return false;
        }
        boolean zK = gVar.k();
        AbstractC0159b abstractC0159bB = gVar.b();
        boolean z2 = abstractC0159bB != null && abstractC0159bB.a();
        if (gVar.j()) {
            zK |= gVar.expandActionView();
            if (zK) {
                e(true);
            }
        } else if (gVar.hasSubMenu() || z2) {
            if ((i2 & 4) == 0) {
                e(false);
            }
            if (!gVar.hasSubMenu()) {
                gVar.x(new m(u(), this, gVar));
            }
            m mVar = (m) gVar.getSubMenu();
            if (z2) {
                abstractC0159bB.e(mVar);
            }
            zK |= j(mVar, jVar);
            if (!zK) {
                e(true);
            }
        } else if ((i2 & 1) == 0) {
            e(true);
        }
        return zK;
    }

    public void P(j jVar) {
        Iterator it = this.f1988w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            j jVar2 = (j) weakReference.get();
            if (jVar2 == null || jVar2 == jVar) {
                this.f1988w.remove(weakReference);
            }
        }
    }

    public void Q(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(t());
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = getItem(i2);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((m) item.getSubMenu()).Q(bundle);
            }
        }
        int i3 = bundle.getInt("android:menu:expandedactionview");
        if (i3 <= 0 || (menuItemFindItem = findItem(i3)) == null) {
            return;
        }
        menuItemFindItem.expandActionView();
    }

    public void R(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = getItem(i2);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((m) item.getSubMenu()).R(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(t(), sparseArray);
        }
    }

    public void S(a aVar) {
        this.e = aVar;
    }

    public e T(int i2) {
        this.f1980l = i2;
        return this;
    }

    void U(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f1974f.size();
        e0();
        for (int i2 = 0; i2 < size; i2++) {
            g gVar = (g) this.f1974f.get(i2);
            if (gVar.getGroupId() == groupId && gVar.m() && gVar.isCheckable()) {
                gVar.s(gVar == menuItem);
            }
        }
        d0();
    }

    protected e V(int i2) {
        X(0, null, i2, null, null);
        return this;
    }

    protected e W(Drawable drawable) {
        X(0, null, 0, drawable, null);
        return this;
    }

    protected e Y(int i2) {
        X(i2, null, 0, null, null);
        return this;
    }

    protected e Z(CharSequence charSequence) {
        X(0, charSequence, 0, null, null);
        return this;
    }

    protected MenuItem a(int i2, int i3, int i4, CharSequence charSequence) {
        int iB = B(i4);
        g gVarG = g(i2, i3, i4, iB, charSequence, this.f1980l);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.f1981m;
        if (contextMenuInfo != null) {
            gVarG.v(contextMenuInfo);
        }
        ArrayList arrayList = this.f1974f;
        arrayList.add(n(arrayList, iB), gVarG);
        L(true);
        return gVarG;
    }

    protected e a0(View view) {
        X(0, null, 0, null, view);
        return this;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i2, int i3, int i4, ComponentName componentName, Intent[] intentArr, Intent intent, int i5, MenuItem[] menuItemArr) {
        int i6;
        PackageManager packageManager = this.f1970a.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i5 & 1) == 0) {
            removeGroup(i2);
        }
        for (int i7 = 0; i7 < size; i7++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i7);
            int i8 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i8 < 0 ? intent : intentArr[i8]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i2, i3, i4, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i6 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i6] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void b(j jVar) {
        c(jVar, this.f1970a);
    }

    public void b0(boolean z2) {
        this.f1991z = z2;
    }

    public void c(j jVar, Context context) {
        this.f1988w.add(new WeakReference(jVar));
        jVar.d(context, this);
        this.f1979k = true;
    }

    @Override // android.view.Menu
    public void clear() {
        g gVar = this.f1989x;
        if (gVar != null) {
            f(gVar);
        }
        this.f1974f.clear();
        L(true);
    }

    public void clearHeader() {
        this.o = null;
        this.f1982n = null;
        this.f1983p = null;
        L(false);
    }

    @Override // android.view.Menu
    public void close() {
        e(true);
    }

    public void d() {
        a aVar = this.e;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public void d0() {
        this.f1984q = false;
        if (this.r) {
            this.r = false;
            L(this.s);
        }
    }

    public final void e(boolean z2) {
        if (this.f1986u) {
            return;
        }
        this.f1986u = true;
        Iterator it = this.f1988w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            j jVar = (j) weakReference.get();
            if (jVar == null) {
                this.f1988w.remove(weakReference);
            } else {
                jVar.a(this, z2);
            }
        }
        this.f1986u = false;
    }

    public void e0() {
        if (this.f1984q) {
            return;
        }
        this.f1984q = true;
        this.r = false;
        this.s = false;
    }

    public boolean f(g gVar) {
        boolean zE = false;
        if (!this.f1988w.isEmpty() && this.f1989x == gVar) {
            e0();
            Iterator it = this.f1988w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                j jVar = (j) weakReference.get();
                if (jVar == null) {
                    this.f1988w.remove(weakReference);
                } else {
                    zE = jVar.e(this, gVar);
                    if (zE) {
                        break;
                    }
                }
            }
            d0();
            if (zE) {
                this.f1989x = null;
            }
        }
        return zE;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i2) {
        MenuItem menuItemFindItem;
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            g gVar = (g) this.f1974f.get(i3);
            if (gVar.getItemId() == i2) {
                return gVar;
            }
            if (gVar.hasSubMenu() && (menuItemFindItem = gVar.getSubMenu().findItem(i2)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i2) {
        return (MenuItem) this.f1974f.get(i2);
    }

    boolean h(e eVar, MenuItem menuItem) {
        a aVar = this.e;
        return aVar != null && aVar.a(eVar, menuItem);
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.f1991z) {
            return true;
        }
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((g) this.f1974f.get(i2)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i2, KeyEvent keyEvent) {
        return p(i2, keyEvent) != null;
    }

    public boolean k(g gVar) {
        boolean zG = false;
        if (this.f1988w.isEmpty()) {
            return false;
        }
        e0();
        Iterator it = this.f1988w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            j jVar = (j) weakReference.get();
            if (jVar == null) {
                this.f1988w.remove(weakReference);
            } else {
                zG = jVar.g(this, gVar);
                if (zG) {
                    break;
                }
            }
        }
        d0();
        if (zG) {
            this.f1989x = gVar;
        }
        return zG;
    }

    public int l(int i2) {
        return m(i2, 0);
    }

    public int m(int i2, int i3) {
        int size = size();
        if (i3 < 0) {
            i3 = 0;
        }
        while (i3 < size) {
            if (((g) this.f1974f.get(i3)).getGroupId() == i2) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public int o(int i2) {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (((g) this.f1974f.get(i3)).getItemId() == i2) {
                return i3;
            }
        }
        return -1;
    }

    g p(int i2, KeyEvent keyEvent) {
        ArrayList arrayList = this.f1987v;
        arrayList.clear();
        q(arrayList, i2, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return (g) arrayList.get(0);
        }
        boolean zH = H();
        for (int i3 = 0; i3 < size; i3++) {
            g gVar = (g) arrayList.get(i3);
            char alphabeticShortcut = zH ? gVar.getAlphabeticShortcut() : gVar.getNumericShortcut();
            char[] cArr = keyData.meta;
            if ((alphabeticShortcut == cArr[0] && (metaState & 2) == 0) || ((alphabeticShortcut == cArr[2] && (metaState & 2) != 0) || (zH && alphabeticShortcut == '\b' && i2 == 67))) {
                return gVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i2, int i3) {
        return M(findItem(i2), i3);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i2, KeyEvent keyEvent, int i3) {
        g gVarP = p(i2, keyEvent);
        boolean zM = gVarP != null ? M(gVarP, i3) : false;
        if ((i3 & 2) != 0) {
            e(true);
        }
        return zM;
    }

    void q(List list, int i2, KeyEvent keyEvent) {
        boolean zH = H();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i2 == 67) {
            int size = this.f1974f.size();
            for (int i3 = 0; i3 < size; i3++) {
                g gVar = (g) this.f1974f.get(i3);
                if (gVar.hasSubMenu()) {
                    ((e) gVar.getSubMenu()).q(list, i2, keyEvent);
                }
                char alphabeticShortcut = zH ? gVar.getAlphabeticShortcut() : gVar.getNumericShortcut();
                if ((modifiers & 69647) == ((zH ? gVar.getAlphabeticModifiers() : gVar.getNumericModifiers()) & 69647) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (zH && alphabeticShortcut == '\b' && i2 == 67)) && gVar.isEnabled()) {
                        list.add(gVar);
                    }
                }
            }
        }
    }

    public void r() {
        ArrayList arrayListE = E();
        if (this.f1979k) {
            Iterator it = this.f1988w.iterator();
            boolean zC = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                j jVar = (j) weakReference.get();
                if (jVar == null) {
                    this.f1988w.remove(weakReference);
                } else {
                    zC |= jVar.c();
                }
            }
            if (zC) {
                this.f1977i.clear();
                this.f1978j.clear();
                int size = arrayListE.size();
                for (int i2 = 0; i2 < size; i2++) {
                    g gVar = (g) arrayListE.get(i2);
                    if (gVar.l()) {
                        this.f1977i.add(gVar);
                    } else {
                        this.f1978j.add(gVar);
                    }
                }
            } else {
                this.f1977i.clear();
                this.f1978j.clear();
                this.f1978j.addAll(E());
            }
            this.f1979k = false;
        }
    }

    @Override // android.view.Menu
    public void removeGroup(int i2) {
        int iL = l(i2);
        if (iL >= 0) {
            int size = this.f1974f.size() - iL;
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (i3 >= size || ((g) this.f1974f.get(iL)).getGroupId() != i2) {
                    break;
                }
                O(iL, false);
                i3 = i4;
            }
            L(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i2) {
        O(o(i2), true);
    }

    public ArrayList s() {
        r();
        return this.f1977i;
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i2, boolean z2, boolean z3) {
        int size = this.f1974f.size();
        for (int i3 = 0; i3 < size; i3++) {
            g gVar = (g) this.f1974f.get(i3);
            if (gVar.getGroupId() == i2) {
                gVar.t(z3);
                gVar.setCheckable(z2);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z2) {
        this.f1990y = z2;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i2, boolean z2) {
        int size = this.f1974f.size();
        for (int i3 = 0; i3 < size; i3++) {
            g gVar = (g) this.f1974f.get(i3);
            if (gVar.getGroupId() == i2) {
                gVar.setEnabled(z2);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i2, boolean z2) {
        int size = this.f1974f.size();
        boolean z3 = false;
        for (int i3 = 0; i3 < size; i3++) {
            g gVar = (g) this.f1974f.get(i3);
            if (gVar.getGroupId() == i2 && gVar.y(z2)) {
                z3 = true;
            }
        }
        if (z3) {
            L(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z2) {
        this.f1972c = z2;
        L(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f1974f.size();
    }

    protected String t() {
        return "android:menu:actionviewstates";
    }

    public Context u() {
        return this.f1970a;
    }

    public g v() {
        return this.f1989x;
    }

    public Drawable w() {
        return this.o;
    }

    public CharSequence x() {
        return this.f1982n;
    }

    public View y() {
        return this.f1983p;
    }

    public ArrayList z() {
        r();
        return this.f1978j;
    }

    @Override // android.view.Menu
    public MenuItem add(int i2) {
        return a(0, 0, 0, this.f1971b.getString(i2));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2) {
        return addSubMenu(0, 0, 0, this.f1971b.getString(i2));
    }

    @Override // android.view.Menu
    public MenuItem add(int i2, int i3, int i4, CharSequence charSequence) {
        return a(i2, i3, i4, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        g gVar = (g) a(i2, i3, i4, charSequence);
        m mVar = new m(this.f1970a, this, gVar);
        gVar.x(mVar);
        return mVar;
    }

    @Override // android.view.Menu
    public MenuItem add(int i2, int i3, int i4, int i5) {
        return a(i2, i3, i4, this.f1971b.getString(i5));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2, int i3, int i4, int i5) {
        return addSubMenu(i2, i3, i4, this.f1971b.getString(i5));
    }
}
