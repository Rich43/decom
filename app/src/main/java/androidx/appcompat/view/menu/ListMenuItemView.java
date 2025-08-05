package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.d0;
import defpackage.e;

/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements k.a, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: a, reason: collision with root package name */
    private g f1897a;

    /* renamed from: b, reason: collision with root package name */
    private ImageView f1898b;

    /* renamed from: c, reason: collision with root package name */
    private RadioButton f1899c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f1900d;
    private CheckBox e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f1901f;

    /* renamed from: g, reason: collision with root package name */
    private ImageView f1902g;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f1903h;

    /* renamed from: i, reason: collision with root package name */
    private LinearLayout f1904i;

    /* renamed from: j, reason: collision with root package name */
    private Drawable f1905j;

    /* renamed from: k, reason: collision with root package name */
    private int f1906k;

    /* renamed from: l, reason: collision with root package name */
    private Context f1907l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f1908m;

    /* renamed from: n, reason: collision with root package name */
    private Drawable f1909n;
    private boolean o;

    /* renamed from: p, reason: collision with root package name */
    private LayoutInflater f1910p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f1911q;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, e.d.f5828A);
    }

    private void a(View view) {
        b(view, -1);
    }

    private void b(View view, int i2) {
        LinearLayout linearLayout = this.f1904i;
        if (linearLayout != null) {
            linearLayout.addView(view, i2);
        } else {
            addView(view, i2);
        }
    }

    private void c() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(e.j.f5949h, (ViewGroup) this, false);
        this.e = checkBox;
        a(checkBox);
    }

    private void f() {
        ImageView imageView = (ImageView) getInflater().inflate(e.j.f5950i, (ViewGroup) this, false);
        this.f1898b = imageView;
        b(imageView, 0);
    }

    private void g() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(e.j.f5952k, (ViewGroup) this, false);
        this.f1899c = radioButton;
        a(radioButton);
    }

    private LayoutInflater getInflater() {
        if (this.f1910p == null) {
            this.f1910p = LayoutInflater.from(getContext());
        }
        return this.f1910p;
    }

    private void setSubMenuArrowVisible(boolean z2) {
        ImageView imageView = this.f1902g;
        if (imageView != null) {
            imageView.setVisibility(z2 ? 0 : 8);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f1903h;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f1903h.getLayoutParams();
        rect.top += this.f1903h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void e(g gVar, int i2) {
        this.f1897a = gVar;
        setVisibility(gVar.isVisible() ? 0 : 8);
        setTitle(gVar.i(this));
        setCheckable(gVar.isCheckable());
        h(gVar.A(), gVar.g());
        setIcon(gVar.getIcon());
        setEnabled(gVar.isEnabled());
        setSubMenuArrowVisible(gVar.hasSubMenu());
        setContentDescription(gVar.getContentDescription());
    }

    @Override // androidx.appcompat.view.menu.k.a
    public g getItemData() {
        return this.f1897a;
    }

    public void h(boolean z2, char c2) {
        int i2 = (z2 && this.f1897a.A()) ? 0 : 8;
        if (i2 == 0) {
            this.f1901f.setText(this.f1897a.h());
        }
        if (this.f1901f.getVisibility() != i2) {
            this.f1901f.setVisibility(i2);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        setBackground(this.f1905j);
        TextView textView = (TextView) findViewById(e.i.f5917C);
        this.f1900d = textView;
        int i2 = this.f1906k;
        if (i2 != -1) {
            textView.setTextAppearance(this.f1907l, i2);
        }
        this.f1901f = (TextView) findViewById(e.i.f5939w);
        ImageView imageView = (ImageView) findViewById(e.i.f5942z);
        this.f1902g = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f1909n);
        }
        this.f1903h = (ImageView) findViewById(e.i.f5935q);
        this.f1904i = (LinearLayout) findViewById(e.i.f5931l);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        if (this.f1898b != null && this.f1908m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f1898b.getLayoutParams();
            int i4 = layoutParams.height;
            if (i4 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i4;
            }
        }
        super.onMeasure(i2, i3);
    }

    public void setCheckable(boolean z2) {
        CompoundButton compoundButton;
        View view;
        if (!z2 && this.f1899c == null && this.e == null) {
            return;
        }
        if (this.f1897a.m()) {
            if (this.f1899c == null) {
                g();
            }
            compoundButton = this.f1899c;
            view = this.e;
        } else {
            if (this.e == null) {
                c();
            }
            compoundButton = this.e;
            view = this.f1899c;
        }
        if (z2) {
            compoundButton.setChecked(this.f1897a.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.e;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.f1899c;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    public void setChecked(boolean z2) {
        CompoundButton compoundButton;
        if (this.f1897a.m()) {
            if (this.f1899c == null) {
                g();
            }
            compoundButton = this.f1899c;
        } else {
            if (this.e == null) {
                c();
            }
            compoundButton = this.e;
        }
        compoundButton.setChecked(z2);
    }

    public void setForceShowIcon(boolean z2) {
        this.f1911q = z2;
        this.f1908m = z2;
    }

    public void setGroupDividerEnabled(boolean z2) {
        ImageView imageView = this.f1903h;
        if (imageView != null) {
            imageView.setVisibility((this.o || !z2) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z2 = this.f1897a.z() || this.f1911q;
        if (z2 || this.f1908m) {
            ImageView imageView = this.f1898b;
            if (imageView == null && drawable == null && !this.f1908m) {
                return;
            }
            if (imageView == null) {
                f();
            }
            if (drawable == null && !this.f1908m) {
                this.f1898b.setVisibility(8);
                return;
            }
            ImageView imageView2 = this.f1898b;
            if (!z2) {
                drawable = null;
            }
            imageView2.setImageDrawable(drawable);
            if (this.f1898b.getVisibility() != 0) {
                this.f1898b.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f1900d.getVisibility() != 8) {
                this.f1900d.setVisibility(8);
            }
        } else {
            this.f1900d.setText(charSequence);
            if (this.f1900d.getVisibility() != 0) {
                this.f1900d.setVisibility(0);
            }
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        d0 d0VarU = d0.u(getContext(), attributeSet, e.m.T1, i2, 0);
        this.f1905j = d0VarU.f(e.m.V1);
        this.f1906k = d0VarU.m(e.m.U1, -1);
        this.f1908m = d0VarU.a(e.m.W1, false);
        this.f1907l = context;
        this.f1909n = d0VarU.f(e.m.X1);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{R.attr.divider}, e.d.f5855x, 0);
        this.o = typedArrayObtainStyledAttributes.hasValue(0);
        d0VarU.w();
        typedArrayObtainStyledAttributes.recycle();
    }
}
