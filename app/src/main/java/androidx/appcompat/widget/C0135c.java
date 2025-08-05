package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.AbstractC0159b;
import defpackage.e;
import i.InterfaceC0269e;
import java.util.ArrayList;

/* renamed from: androidx.appcompat.widget.c */
/* loaded from: classes.dex */
class C0135c extends androidx.appcompat.view.menu.a implements AbstractC0159b.a {

    /* renamed from: A */
    RunnableC0020c f2384A;

    /* renamed from: B */
    private b f2385B;

    /* renamed from: C */
    final f f2386C;

    /* renamed from: D */
    int f2387D;

    /* renamed from: k */
    d f2388k;

    /* renamed from: l */
    private Drawable f2389l;

    /* renamed from: m */
    private boolean f2390m;

    /* renamed from: n */
    private boolean f2391n;
    private boolean o;

    /* renamed from: p */
    private int f2392p;

    /* renamed from: q */
    private int f2393q;
    private int r;
    private boolean s;

    /* renamed from: t */
    private boolean f2394t;

    /* renamed from: u */
    private boolean f2395u;

    /* renamed from: v */
    private boolean f2396v;

    /* renamed from: w */
    private int f2397w;

    /* renamed from: x */
    private final SparseBooleanArray f2398x;

    /* renamed from: y */
    e f2399y;

    /* renamed from: z */
    a f2400z;

    /* renamed from: androidx.appcompat.widget.c$a */
    private class a extends androidx.appcompat.view.menu.i {
        public a(Context context, androidx.appcompat.view.menu.m mVar, View view) {
            super(context, mVar, view, false, e.d.f5843i);
            if (!((androidx.appcompat.view.menu.g) mVar.getItem()).l()) {
                View view2 = C0135c.this.f2388k;
                f(view2 == null ? (View) ((androidx.appcompat.view.menu.a) C0135c.this).f1919i : view2);
            }
            j(C0135c.this.f2386C);
        }

        @Override // androidx.appcompat.view.menu.i
        protected void e() {
            C0135c c0135c = C0135c.this;
            c0135c.f2400z = null;
            c0135c.f2387D = 0;
            super.e();
        }
    }

    /* renamed from: androidx.appcompat.widget.c$b */
    private class b extends ActionMenuItemView.b {
        b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public InterfaceC0269e a() {
            a aVar = C0135c.this.f2400z;
            if (aVar != null) {
                return aVar.c();
            }
            return null;
        }
    }

    /* renamed from: androidx.appcompat.widget.c$c */
    private class RunnableC0020c implements Runnable {

        /* renamed from: a */
        private e f2403a;

        public RunnableC0020c(e eVar) {
            this.f2403a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((androidx.appcompat.view.menu.a) C0135c.this).f1914c != null) {
                ((androidx.appcompat.view.menu.a) C0135c.this).f1914c.d();
            }
            View view = (View) ((androidx.appcompat.view.menu.a) C0135c.this).f1919i;
            if (view != null && view.getWindowToken() != null && this.f2403a.m()) {
                C0135c.this.f2399y = this.f2403a;
            }
            C0135c.this.f2384A = null;
        }
    }

    /* renamed from: androidx.appcompat.widget.c$d */
    private class d extends C0149q implements ActionMenuView.a {

        /* renamed from: androidx.appcompat.widget.c$d$a */
        class a extends P {

            /* renamed from: j */
            final /* synthetic */ C0135c f2406j;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(View view, C0135c c0135c) {
                super(view);
                this.f2406j = c0135c;
            }

            @Override // androidx.appcompat.widget.P
            public InterfaceC0269e b() {
                e eVar = C0135c.this.f2399y;
                if (eVar == null) {
                    return null;
                }
                return eVar.c();
            }

            @Override // androidx.appcompat.widget.P
            public boolean c() {
                C0135c.this.K();
                return true;
            }

            @Override // androidx.appcompat.widget.P
            public boolean d() {
                C0135c c0135c = C0135c.this;
                if (c0135c.f2384A != null) {
                    return false;
                }
                c0135c.B();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, e.d.f5842h);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            i0.a(this, getContentDescription());
            setOnTouchListener(new a(this, C0135c.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean a() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean b() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            C0135c.this.K();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i2, int i3, int i4, int i5) {
            boolean frame = super.setFrame(i2, i3, i4, i5);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                androidx.core.graphics.drawable.a.k(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    /* renamed from: androidx.appcompat.widget.c$e */
    private class e extends androidx.appcompat.view.menu.i {
        public e(Context context, androidx.appcompat.view.menu.e eVar, View view, boolean z2) {
            super(context, eVar, view, z2, e.d.f5843i);
            h(8388613);
            j(C0135c.this.f2386C);
        }

        @Override // androidx.appcompat.view.menu.i
        protected void e() {
            if (((androidx.appcompat.view.menu.a) C0135c.this).f1914c != null) {
                ((androidx.appcompat.view.menu.a) C0135c.this).f1914c.close();
            }
            C0135c.this.f2399y = null;
            super.e();
        }
    }

    /* renamed from: androidx.appcompat.widget.c$f */
    private class f implements j.a {
        f() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public void a(androidx.appcompat.view.menu.e eVar, boolean z2) {
            if (eVar instanceof androidx.appcompat.view.menu.m) {
                eVar.D().e(false);
            }
            j.a aVarM = C0135c.this.m();
            if (aVarM != null) {
                aVarM.a(eVar, z2);
            }
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean b(androidx.appcompat.view.menu.e eVar) {
            if (eVar == ((androidx.appcompat.view.menu.a) C0135c.this).f1914c) {
                return false;
            }
            C0135c.this.f2387D = ((androidx.appcompat.view.menu.m) eVar).getItem().getItemId();
            j.a aVarM = C0135c.this.m();
            if (aVarM != null) {
                return aVarM.b(eVar);
            }
            return false;
        }
    }

    public C0135c(Context context) {
        super(context, e.j.f5945c, e.j.f5944b);
        this.f2398x = new SparseBooleanArray();
        this.f2386C = new f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View z(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f1919i;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof k.a) && ((k.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public Drawable A() {
        d dVar = this.f2388k;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.f2390m) {
            return this.f2389l;
        }
        return null;
    }

    public boolean B() {
        Object obj;
        RunnableC0020c runnableC0020c = this.f2384A;
        if (runnableC0020c != null && (obj = this.f1919i) != null) {
            ((View) obj).removeCallbacks(runnableC0020c);
            this.f2384A = null;
            return true;
        }
        e eVar = this.f2399y;
        if (eVar == null) {
            return false;
        }
        eVar.b();
        return true;
    }

    public boolean C() {
        a aVar = this.f2400z;
        if (aVar == null) {
            return false;
        }
        aVar.b();
        return true;
    }

    public boolean D() {
        return this.f2384A != null || E();
    }

    public boolean E() {
        e eVar = this.f2399y;
        return eVar != null && eVar.d();
    }

    public void F(Configuration configuration) {
        if (!this.s) {
            this.r = androidx.appcompat.view.a.b(this.f1913b).d();
        }
        androidx.appcompat.view.menu.e eVar = this.f1914c;
        if (eVar != null) {
            eVar.L(true);
        }
    }

    public void G(boolean z2) {
        this.f2396v = z2;
    }

    public void H(ActionMenuView actionMenuView) {
        this.f1919i = actionMenuView;
        actionMenuView.b(this.f1914c);
    }

    public void I(Drawable drawable) {
        d dVar = this.f2388k;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
        } else {
            this.f2390m = true;
            this.f2389l = drawable;
        }
    }

    public void J(boolean z2) {
        this.f2391n = z2;
        this.o = true;
    }

    public boolean K() {
        androidx.appcompat.view.menu.e eVar;
        if (!this.f2391n || E() || (eVar = this.f1914c) == null || this.f1919i == null || this.f2384A != null || eVar.z().isEmpty()) {
            return false;
        }
        RunnableC0020c runnableC0020c = new RunnableC0020c(new e(this.f1913b, this.f1914c, this.f2388k, true));
        this.f2384A = runnableC0020c;
        ((View) this.f1919i).post(runnableC0020c);
        return true;
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public void a(androidx.appcompat.view.menu.e eVar, boolean z2) {
        y();
        super.a(eVar, z2);
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean c() {
        ArrayList arrayListE;
        int size;
        int i2;
        int iL;
        int i3;
        C0135c c0135c = this;
        androidx.appcompat.view.menu.e eVar = c0135c.f1914c;
        View view = null;
        int i4 = 0;
        if (eVar != null) {
            arrayListE = eVar.E();
            size = arrayListE.size();
        } else {
            arrayListE = null;
            size = 0;
        }
        int i5 = c0135c.r;
        int i6 = c0135c.f2393q;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) c0135c.f1919i;
        boolean z2 = false;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            androidx.appcompat.view.menu.g gVar = (androidx.appcompat.view.menu.g) arrayListE.get(i9);
            if (gVar.o()) {
                i7++;
            } else if (gVar.n()) {
                i8++;
            } else {
                z2 = true;
            }
            if (c0135c.f2396v && gVar.isActionViewExpanded()) {
                i5 = 0;
            }
        }
        if (c0135c.f2391n && (z2 || i8 + i7 > i5)) {
            i5--;
        }
        int i10 = i5 - i7;
        SparseBooleanArray sparseBooleanArray = c0135c.f2398x;
        sparseBooleanArray.clear();
        if (c0135c.f2394t) {
            int i11 = c0135c.f2397w;
            iL = i6 / i11;
            i2 = i11 + ((i6 % i11) / iL);
        } else {
            i2 = 0;
            iL = 0;
        }
        int i12 = 0;
        int i13 = 0;
        while (i12 < size) {
            androidx.appcompat.view.menu.g gVar2 = (androidx.appcompat.view.menu.g) arrayListE.get(i12);
            if (gVar2.o()) {
                View viewN = c0135c.n(gVar2, view, viewGroup);
                if (c0135c.f2394t) {
                    iL -= ActionMenuView.L(viewN, i2, iL, iMakeMeasureSpec, i4);
                } else {
                    viewN.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                }
                int measuredWidth = viewN.getMeasuredWidth();
                i6 -= measuredWidth;
                if (i13 == 0) {
                    i13 = measuredWidth;
                }
                int groupId = gVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                gVar2.u(true);
                i3 = size;
            } else if (gVar2.n()) {
                int groupId2 = gVar2.getGroupId();
                boolean z3 = sparseBooleanArray.get(groupId2);
                boolean z4 = (i10 > 0 || z3) && i6 > 0 && (!c0135c.f2394t || iL > 0);
                boolean z5 = z4;
                i3 = size;
                if (z4) {
                    View viewN2 = c0135c.n(gVar2, null, viewGroup);
                    if (c0135c.f2394t) {
                        int iL2 = ActionMenuView.L(viewN2, i2, iL, iMakeMeasureSpec, 0);
                        iL -= iL2;
                        if (iL2 == 0) {
                            z5 = false;
                        }
                    } else {
                        viewN2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    }
                    boolean z6 = z5;
                    int measuredWidth2 = viewN2.getMeasuredWidth();
                    i6 -= measuredWidth2;
                    if (i13 == 0) {
                        i13 = measuredWidth2;
                    }
                    z4 = z6 & (!c0135c.f2394t ? i6 + i13 <= 0 : i6 < 0);
                }
                if (z4 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z3) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i14 = 0; i14 < i12; i14++) {
                        androidx.appcompat.view.menu.g gVar3 = (androidx.appcompat.view.menu.g) arrayListE.get(i14);
                        if (gVar3.getGroupId() == groupId2) {
                            if (gVar3.l()) {
                                i10++;
                            }
                            gVar3.u(false);
                        }
                    }
                }
                if (z4) {
                    i10--;
                }
                gVar2.u(z4);
            } else {
                i3 = size;
                gVar2.u(false);
                i12++;
                view = null;
                c0135c = this;
                size = i3;
                i4 = 0;
            }
            i12++;
            view = null;
            c0135c = this;
            size = i3;
            i4 = 0;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public void d(Context context, androidx.appcompat.view.menu.e eVar) {
        super.d(context, eVar);
        Resources resources = context.getResources();
        androidx.appcompat.view.a aVarB = androidx.appcompat.view.a.b(context);
        if (!this.o) {
            this.f2391n = aVarB.f();
        }
        if (!this.f2395u) {
            this.f2392p = aVarB.c();
        }
        if (!this.s) {
            this.r = aVarB.d();
        }
        int measuredWidth = this.f2392p;
        if (this.f2391n) {
            if (this.f2388k == null) {
                d dVar = new d(this.f1912a);
                this.f2388k = dVar;
                if (this.f2390m) {
                    dVar.setImageDrawable(this.f2389l);
                    this.f2389l = null;
                    this.f2390m = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f2388k.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.f2388k.getMeasuredWidth();
        } else {
            this.f2388k = null;
        }
        this.f2393q = measuredWidth;
        this.f2397w = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    @Override // androidx.appcompat.view.menu.a
    public void f(androidx.appcompat.view.menu.g gVar, k.a aVar) {
        aVar.e(gVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f1919i);
        if (this.f2385B == null) {
            this.f2385B = new b();
        }
        actionMenuItemView.setPopupCallback(this.f2385B);
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public boolean i(androidx.appcompat.view.menu.m mVar) {
        boolean z2 = false;
        if (!mVar.hasVisibleItems()) {
            return false;
        }
        androidx.appcompat.view.menu.m mVar2 = mVar;
        while (mVar2.f0() != this.f1914c) {
            mVar2 = (androidx.appcompat.view.menu.m) mVar2.f0();
        }
        View viewZ = z(mVar2.getItem());
        if (viewZ == null) {
            return false;
        }
        this.f2387D = mVar.getItem().getItemId();
        int size = mVar.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            MenuItem item = mVar.getItem(i2);
            if (item.isVisible() && item.getIcon() != null) {
                z2 = true;
                break;
            }
            i2++;
        }
        a aVar = new a(this.f1913b, mVar, viewZ);
        this.f2400z = aVar;
        aVar.g(z2);
        this.f2400z.k();
        super.i(mVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public void j(boolean z2) {
        super.j(z2);
        ((View) this.f1919i).requestLayout();
        androidx.appcompat.view.menu.e eVar = this.f1914c;
        boolean z3 = false;
        if (eVar != null) {
            ArrayList arrayListS = eVar.s();
            int size = arrayListS.size();
            for (int i2 = 0; i2 < size; i2++) {
                AbstractC0159b abstractC0159bB = ((androidx.appcompat.view.menu.g) arrayListS.get(i2)).b();
                if (abstractC0159bB != null) {
                    abstractC0159bB.h(this);
                }
            }
        }
        androidx.appcompat.view.menu.e eVar2 = this.f1914c;
        ArrayList arrayListZ = eVar2 != null ? eVar2.z() : null;
        if (this.f2391n && arrayListZ != null) {
            int size2 = arrayListZ.size();
            if (size2 == 1) {
                z3 = !((androidx.appcompat.view.menu.g) arrayListZ.get(0)).isActionViewExpanded();
            } else if (size2 > 0) {
                z3 = true;
            }
        }
        if (z3) {
            if (this.f2388k == null) {
                this.f2388k = new d(this.f1912a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f2388k.getParent();
            if (viewGroup != this.f1919i) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f2388k);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f1919i;
                actionMenuView.addView(this.f2388k, actionMenuView.F());
            }
        } else {
            d dVar = this.f2388k;
            if (dVar != null) {
                Object parent = dVar.getParent();
                Object obj = this.f1919i;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.f2388k);
                }
            }
        }
        ((ActionMenuView) this.f1919i).setOverflowReserved(this.f2391n);
    }

    @Override // androidx.appcompat.view.menu.a
    public boolean l(ViewGroup viewGroup, int i2) {
        if (viewGroup.getChildAt(i2) == this.f2388k) {
            return false;
        }
        return super.l(viewGroup, i2);
    }

    @Override // androidx.appcompat.view.menu.a
    public View n(androidx.appcompat.view.menu.g gVar, View view, ViewGroup viewGroup) {
        View actionView = gVar.getActionView();
        if (actionView == null || gVar.j()) {
            actionView = super.n(gVar, view, viewGroup);
        }
        actionView.setVisibility(gVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.a
    public androidx.appcompat.view.menu.k o(ViewGroup viewGroup) {
        androidx.appcompat.view.menu.k kVar = this.f1919i;
        androidx.appcompat.view.menu.k kVarO = super.o(viewGroup);
        if (kVar != kVarO) {
            ((ActionMenuView) kVarO).setPresenter(this);
        }
        return kVarO;
    }

    @Override // androidx.appcompat.view.menu.a
    public boolean q(int i2, androidx.appcompat.view.menu.g gVar) {
        return gVar.l();
    }

    public boolean y() {
        return B() | C();
    }
}
