package androidx.cardview.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import m.AbstractC0284a;
import m.AbstractC0285b;
import m.AbstractC0286c;

/* loaded from: classes.dex */
public class CardView extends FrameLayout {

    /* renamed from: h, reason: collision with root package name */
    private static final int[] f2561h = {R.attr.colorBackground};

    /* renamed from: i, reason: collision with root package name */
    private static final c f2562i;

    /* renamed from: a, reason: collision with root package name */
    private boolean f2563a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f2564b;

    /* renamed from: c, reason: collision with root package name */
    int f2565c;

    /* renamed from: d, reason: collision with root package name */
    int f2566d;
    final Rect e;

    /* renamed from: f, reason: collision with root package name */
    final Rect f2567f;

    /* renamed from: g, reason: collision with root package name */
    private final b f2568g;

    class a implements b {

        /* renamed from: a, reason: collision with root package name */
        private Drawable f2569a;

        a() {
        }

        @Override // androidx.cardview.widget.b
        public View a() {
            return CardView.this;
        }

        @Override // androidx.cardview.widget.b
        public boolean b() {
            return CardView.this.getUseCompatPadding();
        }

        @Override // androidx.cardview.widget.b
        public void c(int i2, int i3, int i4, int i5) {
            CardView.this.f2567f.set(i2, i3, i4, i5);
            CardView cardView = CardView.this;
            Rect rect = cardView.e;
            CardView.super.setPadding(i2 + rect.left, i3 + rect.top, i4 + rect.right, i5 + rect.bottom);
        }

        @Override // androidx.cardview.widget.b
        public Drawable d() {
            return this.f2569a;
        }

        @Override // androidx.cardview.widget.b
        public void e(Drawable drawable) {
            this.f2569a = drawable;
            CardView.this.setBackgroundDrawable(drawable);
        }

        @Override // androidx.cardview.widget.b
        public boolean f() {
            return CardView.this.getPreventCornerOverlap();
        }
    }

    static {
        androidx.cardview.widget.a aVar = new androidx.cardview.widget.a();
        f2562i = aVar;
        aVar.n();
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC0284a.f6579a);
    }

    public ColorStateList getCardBackgroundColor() {
        return f2562i.f(this.f2568g);
    }

    public float getCardElevation() {
        return f2562i.l(this.f2568g);
    }

    public int getContentPaddingBottom() {
        return this.e.bottom;
    }

    public int getContentPaddingLeft() {
        return this.e.left;
    }

    public int getContentPaddingRight() {
        return this.e.right;
    }

    public int getContentPaddingTop() {
        return this.e.top;
    }

    public float getMaxCardElevation() {
        return f2562i.a(this.f2568g);
    }

    public boolean getPreventCornerOverlap() {
        return this.f2564b;
    }

    public float getRadius() {
        return f2562i.b(this.f2568g);
    }

    public boolean getUseCompatPadding() {
        return this.f2563a;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        if (f2562i instanceof androidx.cardview.widget.a) {
            super.onMeasure(i2, i3);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.d(this.f2568g)), View.MeasureSpec.getSize(i2)), mode);
        }
        int mode2 = View.MeasureSpec.getMode(i3);
        if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.c(this.f2568g)), View.MeasureSpec.getSize(i3)), mode2);
        }
        super.onMeasure(i2, i3);
    }

    public void setCardBackgroundColor(int i2) {
        f2562i.k(this.f2568g, ColorStateList.valueOf(i2));
    }

    public void setCardElevation(float f2) {
        f2562i.g(this.f2568g, f2);
    }

    public void setMaxCardElevation(float f2) {
        f2562i.m(this.f2568g, f2);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i2) {
        this.f2566d = i2;
        super.setMinimumHeight(i2);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i2) {
        this.f2565c = i2;
        super.setMinimumWidth(i2);
    }

    @Override // android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
    }

    public void setPreventCornerOverlap(boolean z2) {
        if (z2 != this.f2564b) {
            this.f2564b = z2;
            f2562i.j(this.f2568g);
        }
    }

    public void setRadius(float f2) {
        f2562i.i(this.f2568g, f2);
    }

    public void setUseCompatPadding(boolean z2) {
        if (this.f2563a != z2) {
            this.f2563a = z2;
            f2562i.e(this.f2568g);
        }
    }

    public CardView(Context context, AttributeSet attributeSet, int i2) {
        ColorStateList colorStateListValueOf;
        super(context, attributeSet, i2);
        Rect rect = new Rect();
        this.e = rect;
        this.f2567f = new Rect();
        a aVar = new a();
        this.f2568g = aVar;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.d.f6583a, i2, AbstractC0286c.f6582a);
        int i3 = m.d.f6586d;
        if (typedArrayObtainStyledAttributes.hasValue(i3)) {
            colorStateListValueOf = typedArrayObtainStyledAttributes.getColorStateList(i3);
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(f2561h);
            int color = typedArrayObtainStyledAttributes2.getColor(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            colorStateListValueOf = ColorStateList.valueOf(fArr[2] > 0.5f ? getResources().getColor(AbstractC0285b.f6581b) : getResources().getColor(AbstractC0285b.f6580a));
        }
        ColorStateList colorStateList = colorStateListValueOf;
        float dimension = typedArrayObtainStyledAttributes.getDimension(m.d.e, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(m.d.f6587f, 0.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(m.d.f6588g, 0.0f);
        this.f2563a = typedArrayObtainStyledAttributes.getBoolean(m.d.f6590i, false);
        this.f2564b = typedArrayObtainStyledAttributes.getBoolean(m.d.f6589h, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(m.d.f6591j, 0);
        rect.left = typedArrayObtainStyledAttributes.getDimensionPixelSize(m.d.f6593l, dimensionPixelSize);
        rect.top = typedArrayObtainStyledAttributes.getDimensionPixelSize(m.d.f6595n, dimensionPixelSize);
        rect.right = typedArrayObtainStyledAttributes.getDimensionPixelSize(m.d.f6594m, dimensionPixelSize);
        rect.bottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(m.d.f6592k, dimensionPixelSize);
        float f2 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f2565c = typedArrayObtainStyledAttributes.getDimensionPixelSize(m.d.f6584b, 0);
        this.f2566d = typedArrayObtainStyledAttributes.getDimensionPixelSize(m.d.f6585c, 0);
        typedArrayObtainStyledAttributes.recycle();
        f2562i.h(aVar, context, colorStateList, dimension, dimension2, f2);
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f2562i.k(this.f2568g, colorStateList);
    }
}
