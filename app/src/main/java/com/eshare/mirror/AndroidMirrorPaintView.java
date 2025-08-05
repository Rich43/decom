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
public class AndroidMirrorPaintView extends View {

    /* renamed from: a, reason: collision with root package name */
    private Paint f5575a;

    /* renamed from: b, reason: collision with root package name */
    private Bitmap f5576b;

    /* renamed from: c, reason: collision with root package name */
    private Canvas f5577c;

    /* renamed from: d, reason: collision with root package name */
    private Path f5578d;
    private Paint e;

    /* renamed from: f, reason: collision with root package name */
    private int f5579f;

    /* renamed from: g, reason: collision with root package name */
    private int f5580g;

    /* renamed from: h, reason: collision with root package name */
    private float f5581h;

    /* renamed from: i, reason: collision with root package name */
    private float f5582i;

    public AndroidMirrorPaintView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5579f = 1;
        this.f5580g = 1;
        c(context);
    }

    private void c(Context context) {
        Paint paint = new Paint(6);
        this.f5575a = paint;
        paint.setAntiAlias(true);
        this.f5575a.setDither(true);
        this.f5575a.setStyle(Paint.Style.STROKE);
        this.f5575a.setStrokeJoin(Paint.Join.ROUND);
        this.f5575a.setStrokeCap(Paint.Cap.ROUND);
        this.f5575a.setStrokeWidth(6.0f);
        Bitmap bitmap = this.f5576b;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f5576b.recycle();
        }
        this.f5576b = Bitmap.createBitmap(this.f5579f, this.f5580g, Bitmap.Config.ARGB_8888);
        this.f5577c = new Canvas(this.f5576b);
        this.f5578d = new Path();
        this.e = new Paint(6);
    }

    private void e(float f2, float f3) {
        this.f5578d.reset();
        this.f5578d.moveTo(f2, f3);
        this.f5581h = f2;
        this.f5582i = f3;
    }

    public void a() {
        Bitmap bitmap = this.f5576b;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f5576b.recycle();
        }
        this.f5576b = Bitmap.createBitmap(this.f5579f, this.f5580g, Bitmap.Config.ARGB_8888);
        this.f5577c = new Canvas(this.f5576b);
        this.f5578d.reset();
        invalidate();
    }

    public void b(float f2, float f3) {
        float fAbs = Math.abs(f2 - this.f5581h);
        float fAbs2 = Math.abs(f3 - this.f5582i);
        if (fAbs >= 4.0f || fAbs2 >= 4.0f) {
            Path path = this.f5578d;
            float f4 = this.f5581h;
            float f5 = this.f5582i;
            path.quadTo(f4, f5, (f2 + f4) / 2.0f, (f3 + f5) / 2.0f);
            this.f5581h = f2;
            this.f5582i = f3;
        }
    }

    public void d() {
        this.f5578d.lineTo(this.f5581h, this.f5582i);
        this.f5577c.drawPath(this.f5578d, this.f5575a);
        this.f5578d.reset();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawBitmap(this.f5576b, 0.0f, 0.0f, this.e);
        canvas.drawPath(this.f5578d, this.f5575a);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f5579f = i2;
        this.f5580g = i3;
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
        this.f5575a.setColor(i2);
    }
}
