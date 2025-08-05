package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.d0;

/* loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements e.b, k, AdapterView.OnItemClickListener {

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f1894c = {R.attr.background, R.attr.divider};

    /* renamed from: a, reason: collision with root package name */
    private e f1895a;

    /* renamed from: b, reason: collision with root package name */
    private int f1896b;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    @Override // androidx.appcompat.view.menu.e.b
    public boolean a(g gVar) {
        return this.f1895a.M(gVar, 0);
    }

    @Override // androidx.appcompat.view.menu.k
    public void b(e eVar) {
        this.f1895a = eVar;
    }

    public int getWindowAnimations() {
        return this.f1896b;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        a((g) getAdapter().getItem(i2));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        d0 d0VarU = d0.u(context, attributeSet, f1894c, i2, 0);
        if (d0VarU.r(0)) {
            setBackgroundDrawable(d0VarU.f(0));
        }
        if (d0VarU.r(1)) {
            setDivider(d0VarU.f(1));
        }
        d0VarU.w();
    }
}
