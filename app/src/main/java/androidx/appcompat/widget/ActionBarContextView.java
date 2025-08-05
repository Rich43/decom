package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.request.target.Target;
import defpackage.e;

/* loaded from: classes.dex */
public class ActionBarContextView extends AbstractC0133a {

    /* renamed from: i, reason: collision with root package name */
    private CharSequence f2067i;

    /* renamed from: j, reason: collision with root package name */
    private CharSequence f2068j;

    /* renamed from: k, reason: collision with root package name */
    private View f2069k;

    /* renamed from: l, reason: collision with root package name */
    private View f2070l;

    /* renamed from: m, reason: collision with root package name */
    private View f2071m;

    /* renamed from: n, reason: collision with root package name */
    private LinearLayout f2072n;
    private TextView o;

    /* renamed from: p, reason: collision with root package name */
    private TextView f2073p;

    /* renamed from: q, reason: collision with root package name */
    private int f2074q;
    private int r;
    private boolean s;

    /* renamed from: t, reason: collision with root package name */
    private int f2075t;

    class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ androidx.appcompat.view.b f2076a;

        a(androidx.appcompat.view.b bVar) {
            this.f2076a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f2076a.c();
        }
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    private void i() {
        if (this.f2072n == null) {
            LayoutInflater.from(getContext()).inflate(e.j.f5943a, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f2072n = linearLayout;
            this.o = (TextView) linearLayout.findViewById(e.i.e);
            this.f2073p = (TextView) this.f2072n.findViewById(e.i.f5924d);
            if (this.f2074q != 0) {
                this.o.setTextAppearance(getContext(), this.f2074q);
            }
            if (this.r != 0) {
                this.f2073p.setTextAppearance(getContext(), this.r);
            }
        }
        this.o.setText(this.f2067i);
        this.f2073p.setText(this.f2068j);
        boolean zIsEmpty = TextUtils.isEmpty(this.f2067i);
        boolean zIsEmpty2 = TextUtils.isEmpty(this.f2068j);
        this.f2073p.setVisibility(!zIsEmpty2 ? 0 : 8);
        this.f2072n.setVisibility((zIsEmpty && zIsEmpty2) ? 8 : 0);
        if (this.f2072n.getParent() == null) {
            addView(this.f2072n);
        }
    }

    @Override // androidx.appcompat.widget.AbstractC0133a
    public /* bridge */ /* synthetic */ androidx.core.view.V f(int i2, long j2) {
        return super.f(i2, j2);
    }

    public void g() {
        if (this.f2069k == null) {
            k();
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.AbstractC0133a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.AbstractC0133a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f2068j;
    }

    public CharSequence getTitle() {
        return this.f2067i;
    }

    public void h(androidx.appcompat.view.b bVar) {
        View view = this.f2069k;
        if (view == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.f2075t, (ViewGroup) this, false);
            this.f2069k = viewInflate;
            addView(viewInflate);
        } else if (view.getParent() == null) {
            addView(this.f2069k);
        }
        View viewFindViewById = this.f2069k.findViewById(e.i.f5928i);
        this.f2070l = viewFindViewById;
        viewFindViewById.setOnClickListener(new a(bVar));
        androidx.appcompat.view.menu.e eVar = (androidx.appcompat.view.menu.e) bVar.e();
        C0135c c0135c = this.f2368d;
        if (c0135c != null) {
            c0135c.y();
        }
        C0135c c0135c2 = new C0135c(getContext());
        this.f2368d = c0135c2;
        c0135c2.J(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        eVar.c(this.f2368d, this.f2366b);
        ActionMenuView actionMenuView = (ActionMenuView) this.f2368d.o(this);
        this.f2367c = actionMenuView;
        actionMenuView.setBackground(null);
        addView(this.f2367c, layoutParams);
    }

    public boolean j() {
        return this.s;
    }

    public void k() {
        removeAllViews();
        this.f2071m = null;
        this.f2367c = null;
        this.f2368d = null;
        View view = this.f2070l;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    public boolean l() {
        C0135c c0135c = this.f2368d;
        if (c0135c != null) {
            return c0135c.K();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0135c c0135c = this.f2368d;
        if (c0135c != null) {
            c0135c.B();
            this.f2368d.C();
        }
    }

    @Override // androidx.appcompat.widget.AbstractC0133a, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        boolean zB = o0.b(this);
        int paddingRight = zB ? (i4 - i2) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i5 - i3) - getPaddingTop()) - getPaddingBottom();
        View view = this.f2069k;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f2069k.getLayoutParams();
            int i6 = zB ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i7 = zB ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int iD = AbstractC0133a.d(paddingRight, i6, zB);
            paddingRight = AbstractC0133a.d(iD + e(this.f2069k, iD, paddingTop, paddingTop2, zB), i7, zB);
        }
        int iE = paddingRight;
        LinearLayout linearLayout = this.f2072n;
        if (linearLayout != null && this.f2071m == null && linearLayout.getVisibility() != 8) {
            iE += e(this.f2072n, iE, paddingTop, paddingTop2, zB);
        }
        int i8 = iE;
        View view2 = this.f2071m;
        if (view2 != null) {
            e(view2, i8, paddingTop, paddingTop2, zB);
        }
        int paddingLeft = zB ? getPaddingLeft() : (i4 - i2) - getPaddingRight();
        ActionMenuView actionMenuView = this.f2367c;
        if (actionMenuView != null) {
            e(actionMenuView, paddingLeft, paddingTop, paddingTop2, !zB);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        if (View.MeasureSpec.getMode(i2) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i3) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i2);
        int size2 = this.e;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i3);
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingTop;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Target.SIZE_ORIGINAL);
        View view = this.f2069k;
        if (view != null) {
            int iC = c(view, paddingLeft, iMakeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f2069k.getLayoutParams();
            paddingLeft = iC - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f2367c;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = c(this.f2367c, paddingLeft, iMakeMeasureSpec, 0);
        }
        LinearLayout linearLayout = this.f2072n;
        if (linearLayout != null && this.f2071m == null) {
            if (this.s) {
                this.f2072n.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.f2072n.getMeasuredWidth();
                boolean z2 = measuredWidth <= paddingLeft;
                if (z2) {
                    paddingLeft -= measuredWidth;
                }
                this.f2072n.setVisibility(z2 ? 0 : 8);
            } else {
                paddingLeft = c(linearLayout, paddingLeft, iMakeMeasureSpec, 0);
            }
        }
        View view2 = this.f2071m;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i4 = layoutParams.width;
            int i5 = i4 != -2 ? 1073741824 : Target.SIZE_ORIGINAL;
            if (i4 >= 0) {
                paddingLeft = Math.min(i4, paddingLeft);
            }
            int i6 = layoutParams.height;
            int i7 = i6 == -2 ? Target.SIZE_ORIGINAL : 1073741824;
            if (i6 >= 0) {
                iMin = Math.min(i6, iMin);
            }
            this.f2071m.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i5), View.MeasureSpec.makeMeasureSpec(iMin, i7));
        }
        if (this.e > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            int measuredHeight = getChildAt(i9).getMeasuredHeight() + paddingTop;
            if (measuredHeight > i8) {
                i8 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i8);
    }

    @Override // androidx.appcompat.widget.AbstractC0133a, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.widget.AbstractC0133a
    public void setContentHeight(int i2) {
        this.e = i2;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f2071m;
        if (view2 != null) {
            removeView(view2);
        }
        this.f2071m = view;
        if (view != null && (linearLayout = this.f2072n) != null) {
            removeView(linearLayout);
            this.f2072n = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f2068j = charSequence;
        i();
    }

    public void setTitle(CharSequence charSequence) {
        this.f2067i = charSequence;
        i();
        androidx.core.view.M.h0(this, charSequence);
    }

    public void setTitleOptional(boolean z2) {
        if (z2 != this.s) {
            requestLayout();
        }
        this.s = z2;
    }

    @Override // androidx.appcompat.widget.AbstractC0133a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i2) {
        super.setVisibility(i2);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, e.d.f5841g);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        d0 d0VarU = d0.u(context, attributeSet, e.m.f6089y, i2, 0);
        setBackground(d0VarU.f(e.m.f6091z));
        this.f2074q = d0VarU.m(e.m.f5978D, 0);
        this.r = d0VarU.m(e.m.f5976C, 0);
        this.e = d0VarU.l(e.m.f5974B, 0);
        this.f2075t = d0VarU.m(e.m.f5972A, e.j.f5946d);
        d0VarU.w();
    }
}
