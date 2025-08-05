package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import defpackage.e;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class c implements j, AdapterView.OnItemClickListener {

    /* renamed from: a */
    Context f1954a;

    /* renamed from: b */
    LayoutInflater f1955b;

    /* renamed from: c */
    e f1956c;

    /* renamed from: d */
    ExpandedMenuView f1957d;
    int e;

    /* renamed from: f */
    int f1958f;

    /* renamed from: g */
    int f1959g;

    /* renamed from: h */
    private j.a f1960h;

    /* renamed from: i */
    a f1961i;

    private class a extends BaseAdapter {

        /* renamed from: a */
        private int f1962a = -1;

        public a() {
            a();
        }

        void a() {
            g gVarV = c.this.f1956c.v();
            if (gVarV != null) {
                ArrayList arrayListZ = c.this.f1956c.z();
                int size = arrayListZ.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (((g) arrayListZ.get(i2)) == gVarV) {
                        this.f1962a = i2;
                        return;
                    }
                }
            }
            this.f1962a = -1;
        }

        @Override // android.widget.Adapter
        /* renamed from: b */
        public g getItem(int i2) {
            ArrayList arrayListZ = c.this.f1956c.z();
            int i3 = i2 + c.this.e;
            int i4 = this.f1962a;
            if (i4 >= 0 && i3 >= i4) {
                i3++;
            }
            return (g) arrayListZ.get(i3);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = c.this.f1956c.z().size() - c.this.e;
            return this.f1962a < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                c cVar = c.this;
                view = cVar.f1955b.inflate(cVar.f1959g, viewGroup, false);
            }
            ((k.a) view).e(getItem(i2), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public c(Context context, int i2) {
        this(i2, 0);
        this.f1954a = context;
        this.f1955b = LayoutInflater.from(context);
    }

    @Override // androidx.appcompat.view.menu.j
    public void a(e eVar, boolean z2) {
        j.a aVar = this.f1960h;
        if (aVar != null) {
            aVar.a(eVar, z2);
        }
    }

    public ListAdapter b() {
        if (this.f1961i == null) {
            this.f1961i = new a();
        }
        return this.f1961i;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean c() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void d(Context context, e eVar) {
        if (this.f1958f != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.f1958f);
            this.f1954a = contextThemeWrapper;
            this.f1955b = LayoutInflater.from(contextThemeWrapper);
        } else if (this.f1954a != null) {
            this.f1954a = context;
            if (this.f1955b == null) {
                this.f1955b = LayoutInflater.from(context);
            }
        }
        this.f1956c = eVar;
        a aVar = this.f1961i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean e(e eVar, g gVar) {
        return false;
    }

    public k f(ViewGroup viewGroup) {
        if (this.f1957d == null) {
            this.f1957d = (ExpandedMenuView) this.f1955b.inflate(e.j.f5948g, viewGroup, false);
            if (this.f1961i == null) {
                this.f1961i = new a();
            }
            this.f1957d.setAdapter((ListAdapter) this.f1961i);
            this.f1957d.setOnItemClickListener(this);
        }
        return this.f1957d;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean g(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void h(j.a aVar) {
        this.f1960h = aVar;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean i(m mVar) {
        if (!mVar.hasVisibleItems()) {
            return false;
        }
        new f(mVar).d(null);
        j.a aVar = this.f1960h;
        if (aVar == null) {
            return true;
        }
        aVar.b(mVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.j
    public void j(boolean z2) {
        a aVar = this.f1961i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        this.f1956c.N(this.f1961i.getItem(i2), this, 0);
    }

    public c(int i2, int i3) {
        this.f1959g = i2;
        this.f1958f = i3;
    }
}
