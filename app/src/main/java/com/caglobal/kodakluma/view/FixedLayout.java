package com.caglobal.kodakluma.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import e0.AbstractC0249b;

/* loaded from: classes.dex */
public final class FixedLayout extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    private int[] f5458a;

    public static class a extends ViewGroup.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public float f5459a;

        public a(Context context, AttributeSet attributeSet) {
            super(-1, -2);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0249b.f6128P);
            this.f5459a = typedArrayObtainStyledAttributes.getFloat(0, -1.0f);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public FixedLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                childAt.layout(paddingLeft, paddingTop, childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + paddingTop);
            }
            paddingTop += this.f5458a[i6];
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode == 0 || mode2 == 0) {
            throw new RuntimeException("FixedLayout cannot have UNSPECIFIED dimensions");
        }
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        this.f5458a = new int[childCount];
        if (childCount == 0) {
            return;
        }
        int i4 = paddingTop;
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            ViewGroup.LayoutParams layoutParams = getChildAt(i6).getLayoutParams();
            float f2 = layoutParams instanceof a ? ((a) layoutParams).f5459a : -1.0f;
            if (f2 > 0.0f) {
                int i7 = (int) ((paddingTop * f2) / 100.0f);
                this.f5458a[i6] = i7;
                i4 -= i7;
            } else {
                this.f5458a[i6] = 0;
            }
            int i8 = this.f5458a[i6];
            if (i8 < 0) {
                throw new IllegalStateException("Negative height of row: " + i6);
            }
            if (i8 == 0) {
                i5++;
            }
        }
        if (i4 < 0) {
            throw new IllegalStateException("Remaining height < 0: " + i4);
        }
        if (i5 > 0) {
            int i9 = 0;
            while (i5 > 0) {
                int i10 = i4 / i5;
                while (true) {
                    if (i9 >= childCount || i5 <= 0) {
                        break;
                    }
                    int[] iArr = this.f5458a;
                    if (iArr[i9] == 0) {
                        iArr[i9] = i10;
                        i4 -= i10;
                        break;
                    }
                    i9++;
                }
                i5--;
            }
            if (i4 != 0) {
                throw new IllegalStateException("Remaining height != 0: " + i4);
            }
        } else if (i4 > 0) {
            int[] iArr2 = this.f5458a;
            int i11 = childCount - 1;
            iArr2[i11] = iArr2[i11] + i4;
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            getChildAt(i12).measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f5458a[i12], 1073741824));
        }
        setMeasuredDimension(size, size2);
    }

    public FixedLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
