package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.M;
import u0.AbstractC0332b;
import u0.AbstractC0334d;
import u0.AbstractC0337g;

/* loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private TextView f5735a;

    /* renamed from: b, reason: collision with root package name */
    private Button f5736b;

    /* renamed from: c, reason: collision with root package name */
    private int f5737c;

    /* renamed from: d, reason: collision with root package name */
    private int f5738d;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0337g.f7577A0);
        this.f5737c = typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC0337g.f7579B0, -1);
        this.f5738d = typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC0337g.f7583D0, -1);
        typedArrayObtainStyledAttributes.recycle();
    }

    private static void a(View view, int i2, int i3) {
        if (M.Q(view)) {
            M.t0(view, M.D(view), i2, M.C(view), i3);
        } else {
            view.setPadding(view.getPaddingLeft(), i2, view.getPaddingRight(), i3);
        }
    }

    private boolean b(int i2, int i3, int i4) {
        boolean z2;
        if (i2 != getOrientation()) {
            setOrientation(i2);
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.f5735a.getPaddingTop() == i3 && this.f5735a.getPaddingBottom() == i4) {
            return z2;
        }
        a(this.f5735a, i3, i4);
        return true;
    }

    public Button getActionView() {
        return this.f5736b;
    }

    public TextView getMessageView() {
        return this.f5735a;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f5735a = (TextView) findViewById(AbstractC0334d.f7573d);
        this.f5736b = (Button) findViewById(AbstractC0334d.f7572c);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i2, int i3) throws Resources.NotFoundException {
        super.onMeasure(i2, i3);
        if (this.f5737c > 0) {
            int measuredWidth = getMeasuredWidth();
            int i4 = this.f5737c;
            if (measuredWidth > i4) {
                i2 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                super.onMeasure(i2, i3);
            }
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(AbstractC0332b.f7568d);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(AbstractC0332b.f7567c);
        boolean z2 = this.f5735a.getLayout().getLineCount() > 1;
        if (!z2 || this.f5738d <= 0 || this.f5736b.getMeasuredWidth() <= this.f5738d) {
            if (!z2) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (!b(0, dimensionPixelSize, dimensionPixelSize)) {
                return;
            }
        } else if (!b(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
            return;
        }
        super.onMeasure(i2, i3);
    }
}
