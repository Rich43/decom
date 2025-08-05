package com.eshare.mirror;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes.dex */
public class PaintView extends View {

    /* renamed from: a, reason: collision with root package name */
    private Paint f5602a;

    /* renamed from: b, reason: collision with root package name */
    private Bitmap f5603b;

    /* renamed from: c, reason: collision with root package name */
    private Canvas f5604c;

    /* renamed from: d, reason: collision with root package name */
    private Path f5605d;
    private Paint e;

    /* renamed from: f, reason: collision with root package name */
    private int f5606f;

    /* renamed from: g, reason: collision with root package name */
    private int f5607g;

    /* renamed from: h, reason: collision with root package name */
    private float f5608h;

    /* renamed from: i, reason: collision with root package name */
    private float f5609i;

    public PaintView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5606f = 1;
        this.f5607g = 1;
        c(context);
    }

    private void c(Context context) {
        Paint paint = new Paint(6);
        this.f5602a = paint;
        paint.setAntiAlias(true);
        this.f5602a.setDither(true);
        this.f5602a.setStyle(Paint.Style.STROKE);
        this.f5602a.setStrokeJoin(Paint.Join.ROUND);
        this.f5602a.setStrokeCap(Paint.Cap.ROUND);
        this.f5602a.setStrokeWidth(6.0f);
        Bitmap bitmap = this.f5603b;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f5603b.recycle();
        }
        this.f5603b = Bitmap.createBitmap(this.f5606f, this.f5607g, Bitmap.Config.ARGB_8888);
        this.f5604c = new Canvas(this.f5603b);
        this.f5605d = new Path();
        this.e = new Paint(6);
    }

    private void e(float f2, float f3) {
        this.f5605d.reset();
        this.f5605d.moveTo(f2, f3);
        this.f5608h = f2;
        this.f5609i = f3;
    }

    public void a() {
        Bitmap bitmap = this.f5603b;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f5603b.recycle();
        }
        this.f5603b = Bitmap.createBitmap(this.f5606f, this.f5607g, Bitmap.Config.ARGB_8888);
        this.f5604c = new Canvas(this.f5603b);
        this.f5605d.reset();
        invalidate();
    }

    public void b(float f2, float f3) {
        float fAbs = Math.abs(f2 - this.f5608h);
        float fAbs2 = Math.abs(f3 - this.f5609i);
        if (fAbs >= 4.0f || fAbs2 >= 4.0f) {
            Path path = this.f5605d;
            float f4 = this.f5608h;
            float f5 = this.f5609i;
            path.quadTo(f4, f5, (f2 + f4) / 2.0f, (f3 + f5) / 2.0f);
            this.f5608h = f2;
            this.f5609i = f3;
        }
    }

    public void d() {
        this.f5605d.lineTo(this.f5608h, this.f5609i);
        this.f5604c.drawPath(this.f5605d, this.f5602a);
        this.f5605d.reset();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawBitmap(this.f5603b, 0.0f, 0.0f, this.e);
        canvas.drawPath(this.f5605d, this.f5602a);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f5606f = i2;
        this.f5607g = i3;
        a();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            e(x2, y2);
        } else if (action == 1) {
            d();
            invalidate();
        } else if (action == 2) {
            b(x2, y2);
            invalidate();
        }
        return true;
    }

    public void setColor(int i2) {
        this.f5602a.setColor(i2);
    }
}
