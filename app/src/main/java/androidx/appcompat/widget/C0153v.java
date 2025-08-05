package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import defpackage.e;

/* renamed from: androidx.appcompat.widget.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0153v extends RatingBar {

    /* renamed from: a, reason: collision with root package name */
    private final C0151t f2526a;

    public C0153v(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, e.d.f5831D);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        Bitmap bitmapB = this.f2526a.b();
        if (bitmapB != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmapB.getWidth() * getNumStars(), i2, 0), getMeasuredHeight());
        }
    }

    public C0153v(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Z.a(this, getContext());
        C0151t c0151t = new C0151t(this);
        this.f2526a = c0151t;
        c0151t.c(attributeSet, i2);
    }
}
