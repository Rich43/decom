package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class a implements j {

    /* renamed from: a, reason: collision with root package name */
    protected Context f1912a;

    /* renamed from: b, reason: collision with root package name */
    protected Context f1913b;

    /* renamed from: c, reason: collision with root package name */
    protected e f1914c;

    /* renamed from: d, reason: collision with root package name */
    protected LayoutInflater f1915d;
    protected LayoutInflater e;

    /* renamed from: f, reason: collision with root package name */
    private j.a f1916f;

    /* renamed from: g, reason: collision with root package name */
    private int f1917g;

    /* renamed from: h, reason: collision with root package name */
    private int f1918h;

    /* renamed from: i, reason: collision with root package name */
    protected k f1919i;

    /* renamed from: j, reason: collision with root package name */
    private int f1920j;

    public a(Context context, int i2, int i3) {
        this.f1912a = context;
        this.f1915d = LayoutInflater.from(context);
        this.f1917g = i2;
        this.f1918h = i3;
    }

    @Override // androidx.appcompat.view.menu.j
    public void a(e eVar, boolean z2) {
        j.a aVar = this.f1916f;
        if (aVar != null) {
            aVar.a(eVar, z2);
        }
    }

    protected void b(View view, int i2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f1919i).addView(view, i2);
    }

    @Override // androidx.appcompat.view.menu.j
    public void d(Context context, e eVar) {
        this.f1913b = context;
        this.e = LayoutInflater.from(context);
        this.f1914c = eVar;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean e(e eVar, g gVar) {
        return false;
    }

    public abstract void f(g gVar, k.a aVar);

    @Override // androidx.appcompat.view.menu.j
    public boolean g(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void h(j.a aVar) {
        this.f1916f = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.appcompat.view.menu.e] */
    @Override // androidx.appcompat.view.menu.j
    public boolean i(m mVar) {
        j.a aVar = this.f1916f;
        m mVar2 = mVar;
        if (aVar == null) {
            return false;
        }
        if (mVar == null) {
            mVar2 = this.f1914c;
        }
        return aVar.b(mVar2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.j
    public void j(boolean z2) {
        ViewGroup viewGroup = (ViewGroup) this.f1919i;
        if (viewGroup == null) {
            return;
        }
        e eVar = this.f1914c;
        int i2 = 0;
        if (eVar != null) {
            eVar.r();
            ArrayList arrayListE = this.f1914c.E();
            int size = arrayListE.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                g gVar = (g) arrayListE.get(i4);
                if (q(i3, gVar)) {
                    View childAt = viewGroup.getChildAt(i3);
                    g itemData = childAt instanceof k.a ? ((k.a) childAt).getItemData() : null;
                    View viewN = n(gVar, childAt, viewGroup);
                    if (gVar != itemData) {
                        viewN.setPressed(false);
                        viewN.jumpDrawablesToCurrentState();
                    }
                    if (viewN != childAt) {
                        b(viewN, i3);
                    }
                    i3++;
                }
            }
            i2 = i3;
        }
        while (i2 < viewGroup.getChildCount()) {
            if (!l(viewGroup, i2)) {
                i2++;
            }
        }
    }

    public k.a k(ViewGroup viewGroup) {
        return (k.a) this.f1915d.inflate(this.f1918h, viewGroup, false);
    }

    protected boolean l(ViewGroup viewGroup, int i2) {
        viewGroup.removeViewAt(i2);
        return true;
    }

    public j.a m() {
        return this.f1916f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View n(g gVar, View view, ViewGroup viewGroup) {
        k.a aVarK = view instanceof k.a ? (k.a) view : k(viewGroup);
        f(gVar, aVarK);
        return (View) aVarK;
    }

    public k o(ViewGroup viewGroup) {
        if (this.f1919i == null) {
            k kVar = (k) this.f1915d.inflate(this.f1917g, viewGroup, false);
            this.f1919i = kVar;
            kVar.b(this.f1914c);
            j(true);
        }
        return this.f1919i;
    }

    public void p(int i2) {
        this.f1920j = i2;
    }

    public abstract boolean q(int i2, g gVar);
}
