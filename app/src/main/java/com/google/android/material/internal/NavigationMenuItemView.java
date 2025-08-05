package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.Q;
import androidx.appcompat.widget.i0;
import androidx.core.content.res.h;
import androidx.core.view.C0158a;
import androidx.core.view.M;
import androidx.core.widget.j;
import defpackage.e;
import u0.AbstractC0332b;
import u0.AbstractC0333c;
import u0.AbstractC0334d;
import u0.AbstractC0335e;
import w.C0353E;

/* loaded from: classes.dex */
public class NavigationMenuItemView extends com.google.android.material.internal.a implements k.a {

    /* renamed from: F, reason: collision with root package name */
    private static final int[] f5716F = {R.attr.state_checked};

    /* renamed from: A, reason: collision with root package name */
    private g f5717A;

    /* renamed from: B, reason: collision with root package name */
    private ColorStateList f5718B;

    /* renamed from: C, reason: collision with root package name */
    private boolean f5719C;

    /* renamed from: D, reason: collision with root package name */
    private Drawable f5720D;

    /* renamed from: E, reason: collision with root package name */
    private final C0158a f5721E;

    /* renamed from: v, reason: collision with root package name */
    private final int f5722v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f5723w;

    /* renamed from: x, reason: collision with root package name */
    boolean f5724x;

    /* renamed from: y, reason: collision with root package name */
    private final CheckedTextView f5725y;

    /* renamed from: z, reason: collision with root package name */
    private FrameLayout f5726z;

    class a extends C0158a {
        a() {
        }

        @Override // androidx.core.view.C0158a
        public void g(View view, C0353E c0353e) {
            super.g(view, c0353e);
            c0353e.W(NavigationMenuItemView.this.f5724x);
        }
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void B() {
        if (D()) {
            this.f5725y.setVisibility(8);
            FrameLayout frameLayout = this.f5726z;
            if (frameLayout != null) {
                Q.a aVar = (Q.a) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) aVar).width = -1;
                this.f5726z.setLayoutParams(aVar);
                return;
            }
            return;
        }
        this.f5725y.setVisibility(0);
        FrameLayout frameLayout2 = this.f5726z;
        if (frameLayout2 != null) {
            Q.a aVar2 = (Q.a) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) aVar2).width = -2;
            this.f5726z.setLayoutParams(aVar2);
        }
    }

    private StateListDrawable C() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(e.d.f5851t, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(f5716F, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    private boolean D() {
        return this.f5717A.getTitle() == null && this.f5717A.getIcon() == null && this.f5717A.getActionView() != null;
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.f5726z == null) {
                this.f5726z = (FrameLayout) ((ViewStub) findViewById(AbstractC0334d.f7570a)).inflate();
            }
            this.f5726z.removeAllViews();
            this.f5726z.addView(view);
        }
    }

    @Override // androidx.appcompat.view.menu.k.a
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void e(g gVar, int i2) {
        this.f5717A = gVar;
        setVisibility(gVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            M.i0(this, C());
        }
        setCheckable(gVar.isCheckable());
        setChecked(gVar.isChecked());
        setEnabled(gVar.isEnabled());
        setTitle(gVar.getTitle());
        setIcon(gVar.getIcon());
        setActionView(gVar.getActionView());
        setContentDescription(gVar.getContentDescription());
        i0.a(this, gVar.getTooltipText());
        B();
    }

    @Override // androidx.appcompat.view.menu.k.a
    public g getItemData() {
        return this.f5717A;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        g gVar = this.f5717A;
        if (gVar != null && gVar.isCheckable() && this.f5717A.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f5716F);
        }
        return iArrOnCreateDrawableState;
    }

    public void setCheckable(boolean z2) {
        refreshDrawableState();
        if (this.f5724x != z2) {
            this.f5724x = z2;
            this.f5721E.l(this.f5725y, 2048);
        }
    }

    public void setChecked(boolean z2) {
        refreshDrawableState();
        this.f5725y.setChecked(z2);
    }

    public void setHorizontalPadding(int i2) {
        setPadding(i2, 0, i2, 0);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.f5719C) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = androidx.core.graphics.drawable.a.p(drawable).mutate();
                androidx.core.graphics.drawable.a.n(drawable, this.f5718B);
            }
            int i2 = this.f5722v;
            drawable.setBounds(0, 0, i2, i2);
        } else if (this.f5723w) {
            if (this.f5720D == null) {
                Drawable drawableD = h.d(getResources(), AbstractC0333c.f7569a, getContext().getTheme());
                this.f5720D = drawableD;
                if (drawableD != null) {
                    int i3 = this.f5722v;
                    drawableD.setBounds(0, 0, i3, i3);
                }
            }
            drawable = this.f5720D;
        }
        j.h(this.f5725y, drawable, null, null, null);
    }

    public void setIconPadding(int i2) {
        this.f5725y.setCompoundDrawablePadding(i2);
    }

    void setIconTintList(ColorStateList colorStateList) {
        this.f5718B = colorStateList;
        this.f5719C = colorStateList != null;
        g gVar = this.f5717A;
        if (gVar != null) {
            setIcon(gVar.getIcon());
        }
    }

    public void setNeedsEmptyIcon(boolean z2) {
        this.f5723w = z2;
    }

    public void setTextAppearance(int i2) {
        j.n(this.f5725y, i2);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f5725y.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.f5725y.setText(charSequence);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a aVar = new a();
        this.f5721E = aVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(AbstractC0335e.f7574a, (ViewGroup) this, true);
        this.f5722v = context.getResources().getDimensionPixelSize(AbstractC0332b.f7566b);
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(AbstractC0334d.f7571b);
        this.f5725y = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        M.f0(checkedTextView, aVar);
    }
}
