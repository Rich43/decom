package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.E;
import androidx.appcompat.widget.P;
import androidx.appcompat.widget.i0;
import defpackage.e;
import i.InterfaceC0269e;

/* loaded from: classes.dex */
public class ActionMenuItemView extends E implements k.a, View.OnClickListener, ActionMenuView.a {

    /* renamed from: h, reason: collision with root package name */
    g f1884h;

    /* renamed from: i, reason: collision with root package name */
    private CharSequence f1885i;

    /* renamed from: j, reason: collision with root package name */
    private Drawable f1886j;

    /* renamed from: k, reason: collision with root package name */
    e.b f1887k;

    /* renamed from: l, reason: collision with root package name */
    private P f1888l;

    /* renamed from: m, reason: collision with root package name */
    b f1889m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f1890n;
    private boolean o;

    /* renamed from: p, reason: collision with root package name */
    private int f1891p;

    /* renamed from: q, reason: collision with root package name */
    private int f1892q;
    private int r;

    private class a extends P {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // androidx.appcompat.widget.P
        public InterfaceC0269e b() {
            b bVar = ActionMenuItemView.this.f1889m;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }

        @Override // androidx.appcompat.widget.P
        protected boolean c() {
            InterfaceC0269e interfaceC0269eB;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            e.b bVar = actionMenuItemView.f1887k;
            return bVar != null && bVar.a(actionMenuItemView.f1884h) && (interfaceC0269eB = b()) != null && interfaceC0269eB.b();
        }
    }

    public static abstract class b {
        public abstract InterfaceC0269e a();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private boolean t() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        return i2 >= 480 || (i2 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    private void u() {
        boolean z2 = true;
        boolean z3 = !TextUtils.isEmpty(this.f1885i);
        if (this.f1886j != null && (!this.f1884h.B() || (!this.f1890n && !this.o))) {
            z2 = false;
        }
        boolean z4 = z3 & z2;
        setText(z4 ? this.f1885i : null);
        CharSequence contentDescription = this.f1884h.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(z4 ? null : this.f1884h.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f1884h.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            i0.a(this, z4 ? null : this.f1884h.getTitle());
        } else {
            i0.a(this, tooltipText);
        }
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean a() {
        return s();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean b() {
        return s() && this.f1884h.getIcon() == null;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public boolean d() {
        return true;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void e(g gVar, int i2) {
        this.f1884h = gVar;
        setIcon(gVar.getIcon());
        setTitle(gVar.i(this));
        setId(gVar.getItemId());
        setVisibility(gVar.isVisible() ? 0 : 8);
        setEnabled(gVar.isEnabled());
        if (gVar.hasSubMenu() && this.f1888l == null) {
            this.f1888l = new a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // androidx.appcompat.view.menu.k.a
    public g getItemData() {
        return this.f1884h;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e.b bVar = this.f1887k;
        if (bVar != null) {
            bVar.a(this.f1884h);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1890n = t();
        u();
    }

    @Override // androidx.appcompat.widget.E, android.widget.TextView, android.view.View
    protected void onMeasure(int i2, int i3) {
        int i4;
        boolean zS = s();
        if (zS && (i4 = this.f1892q) >= 0) {
            super.setPadding(i4, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int measuredWidth = getMeasuredWidth();
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, this.f1891p) : this.f1891p;
        if (mode != 1073741824 && this.f1891p > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i3);
        }
        if (zS || this.f1886j == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f1886j.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        P p2;
        if (this.f1884h.hasSubMenu() && (p2 = this.f1888l) != null && p2.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean s() {
        return !TextUtils.isEmpty(getText());
    }

    public void setCheckable(boolean z2) {
    }

    public void setChecked(boolean z2) {
    }

    public void setExpandedFormat(boolean z2) {
        if (this.o != z2) {
            this.o = z2;
            g gVar = this.f1884h;
            if (gVar != null) {
                gVar.c();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f1886j = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i2 = this.r;
            if (intrinsicWidth > i2) {
                intrinsicHeight = (int) (intrinsicHeight * (i2 / intrinsicWidth));
                intrinsicWidth = i2;
            }
            if (intrinsicHeight > i2) {
                intrinsicWidth = (int) (intrinsicWidth * (i2 / intrinsicHeight));
            } else {
                i2 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i2);
        }
        setCompoundDrawables(drawable, null, null, null);
        u();
    }

    public void setItemInvoker(e.b bVar) {
        this.f1887k = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        this.f1892q = i2;
        super.setPadding(i2, i3, i4, i5);
    }

    public void setPopupCallback(b bVar) {
        this.f1889m = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f1885i = charSequence;
        u();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Resources resources = context.getResources();
        this.f1890n = t();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.m.f6083v, i2, 0);
        this.f1891p = typedArrayObtainStyledAttributes.getDimensionPixelSize(e.m.f6085w, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.r = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f1892q = -1;
        setSaveEnabled(false);
    }
}
