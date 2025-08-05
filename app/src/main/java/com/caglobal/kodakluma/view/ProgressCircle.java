package com.caglobal.kodakluma.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bumptech.glide.request.target.Target;

/* loaded from: classes.dex */
public class ProgressCircle extends View {

    /* renamed from: a, reason: collision with root package name */
    private int f5504a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f5505b;

    /* renamed from: c, reason: collision with root package name */
    private int f5506c;

    /* renamed from: d, reason: collision with root package name */
    private int f5507d;
    private RectF e;

    public ProgressCircle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        Paint paint = new Paint(1);
        this.f5505b = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f5505b.setStrokeWidth(30.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.f5505b.setColor(Target.SIZE_ORIGINAL);
        int i2 = this.f5507d;
        canvas.drawCircle(i2, i2, i2, this.f5505b);
        this.f5505b.setColor(-1);
        canvas.drawArc(this.e, -90.0f, this.f5504a, false, this.f5505b);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f5506c == 0) {
            int measuredWidth = getMeasuredWidth();
            this.f5506c = measuredWidth;
            this.f5507d = measuredWidth / 2;
            int i4 = this.f5506c;
            this.e = new RectF(0.0f, 0.0f, i4, i4);
        }
    }

    public void setProgress(int i2) {
        this.f5504a = (i2 * 360) / 100;
        postInvalidate();
    }
}
