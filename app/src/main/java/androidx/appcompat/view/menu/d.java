package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.k;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class d extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    e f1964a;

    /* renamed from: b, reason: collision with root package name */
    private int f1965b = -1;

    /* renamed from: c, reason: collision with root package name */
    private boolean f1966c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f1967d;
    private final LayoutInflater e;

    /* renamed from: f, reason: collision with root package name */
    private final int f1968f;

    public d(e eVar, LayoutInflater layoutInflater, boolean z2, int i2) {
        this.f1967d = z2;
        this.e = layoutInflater;
        this.f1964a = eVar;
        this.f1968f = i2;
        a();
    }

    void a() {
        g gVarV = this.f1964a.v();
        if (gVarV != null) {
            ArrayList arrayListZ = this.f1964a.z();
            int size = arrayListZ.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (((g) arrayListZ.get(i2)) == gVarV) {
                    this.f1965b = i2;
                    return;
                }
            }
        }
        this.f1965b = -1;
    }

    public e b() {
        return this.f1964a;
    }

    @Override // android.widget.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public g getItem(int i2) {
        ArrayList arrayListZ = this.f1967d ? this.f1964a.z() : this.f1964a.E();
        int i3 = this.f1965b;
        if (i3 >= 0 && i2 >= i3) {
            i2++;
        }
        return (g) arrayListZ.get(i2);
    }

    public void d(boolean z2) {
        this.f1966c = z2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f1965b < 0 ? (this.f1967d ? this.f1964a.z() : this.f1964a.E()).size() : r0.size() - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.e.inflate(this.f1968f, viewGroup, false);
        }
        int groupId = getItem(i2).getGroupId();
        int i3 = i2 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f1964a.G() && groupId != (i3 >= 0 ? getItem(i3).getGroupId() : groupId));
        k.a aVar = (k.a) view;
        if (this.f1966c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.e(getItem(i2), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
