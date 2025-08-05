package com.caglobal.kodakluma.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes.dex */
public class CircleBar extends View {

    /* renamed from: a, reason: collision with root package name */
    private Paint f5451a;

    /* renamed from: b, reason: collision with root package name */
    private int f5452b;

    /* renamed from: c, reason: collision with root package name */
    private int f5453c;

    /* renamed from: d, reason: collision with root package name */
    private RectF f5454d;

    public CircleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        Paint paint = new Paint(1);
        this.f5451a = paint;
        paint.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f5451a.setColor(-3158065);
        int i2 = this.f5452b;
        canvas.drawCircle(i2, i2, i2, this.f5451a);
        this.f5451a.setColor(-16719803);
        canvas.drawArc(this.f5454d, -90.0f, this.f5453c, true, this.f5451a);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.f5452b = getWidth() / 2;
        int i4 = this.f5452b;
        this.f5454d = new RectF(0.0f, 0.0f, i4 * 2, i4 * 2);
    }

    public void setProgress(int i2) {
        this.f5453c = i2;
        postInvalidate();
    }
}
