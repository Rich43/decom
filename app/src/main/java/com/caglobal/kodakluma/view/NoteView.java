package com.caglobal.kodakluma.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.eshare.api.EShareAPI;
import com.eshare.api.IEvent;

/* loaded from: classes.dex */
public class NoteView extends View {

    /* renamed from: a, reason: collision with root package name */
    private Paint f5466a;

    /* renamed from: b, reason: collision with root package name */
    private Bitmap f5467b;

    /* renamed from: c, reason: collision with root package name */
    private Canvas f5468c;

    /* renamed from: d, reason: collision with root package name */
    private Path f5469d;
    private int e;

    /* renamed from: f, reason: collision with root package name */
    private int f5470f;

    /* renamed from: g, reason: collision with root package name */
    private int f5471g;

    /* renamed from: h, reason: collision with root package name */
    private int f5472h;

    /* renamed from: i, reason: collision with root package name */
    private float f5473i;

    /* renamed from: j, reason: collision with root package name */
    private float f5474j;

    /* renamed from: k, reason: collision with root package name */
    private long f5475k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f5476l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f5477m;

    /* renamed from: n, reason: collision with root package name */
    private IEvent f5478n;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (NoteView.this.f5477m || System.currentTimeMillis() - NoteView.this.f5475k <= 1000) {
                return;
            }
            NoteView.this.f5469d.reset();
            NoteView.this.f5469d.addCircle(0.0f, 0.0f, 0.0f, Path.Direction.CCW);
            NoteView.this.invalidate();
        }
    }

    public NoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = 4;
        this.f5470f = -3916011;
        this.f5471g = 1;
        this.f5472h = 1;
        this.f5476l = false;
        e(context);
    }

    private void e(Context context) {
        Paint paint = new Paint();
        this.f5466a = paint;
        paint.setAntiAlias(true);
        this.f5466a.setDither(true);
        this.f5466a.setStyle(Paint.Style.STROKE);
        this.f5466a.setStrokeJoin(Paint.Join.ROUND);
        this.f5466a.setStrokeCap(Paint.Cap.ROUND);
        this.f5466a.setStrokeWidth(this.e);
        this.f5478n = EShareAPI.init(context).event();
        this.f5466a.setColor(this.f5470f);
        Bitmap bitmap = this.f5467b;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f5467b.recycle();
        }
        this.f5467b = Bitmap.createBitmap(this.f5471g, this.f5472h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f5467b);
        this.f5468c = canvas;
        canvas.drawColor(0);
        this.f5469d = new Path();
    }

    private void g(float f2, float f3) {
        float fAbs = Math.abs(f2 - this.f5473i);
        float fAbs2 = Math.abs(f3 - this.f5474j);
        if (fAbs > 0.0f || fAbs2 > 0.0f) {
            Path path = this.f5469d;
            float f4 = this.f5473i;
            float f5 = this.f5474j;
            path.quadTo(f4, f5, (f2 + f4) / 2.0f, (f3 + f5) / 2.0f);
            this.f5473i = f2;
            this.f5474j = f3;
        }
    }

    private void h(float f2, float f3) {
        this.f5469d.moveTo(f2, f3);
        this.f5473i = f2;
        this.f5474j = f3;
    }

    private void i(float f2, float f3) {
        this.f5469d.lineTo(f2, f3);
        this.f5468c.drawPath(this.f5469d, this.f5466a);
        invalidate();
        this.f5473i = 0.0f;
        this.f5474j = 0.0f;
    }

    public void d() {
        Bitmap bitmap = this.f5467b;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f5467b.recycle();
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.f5471g, this.f5472h, Bitmap.Config.ARGB_8888);
            this.f5467b = bitmapCreateBitmap;
            this.f5468c.setBitmap(bitmapCreateBitmap);
        }
        Path path = this.f5469d;
        if (path != null) {
            path.reset();
            this.f5469d.addCircle(0.0f, 0.0f, 0.0f, Path.Direction.CCW);
        }
        invalidate();
    }

    public void f() {
        Bitmap bitmap = this.f5467b;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f5467b.recycle();
        }
        this.f5467b = Bitmap.createBitmap(this.f5471g, this.f5472h, Bitmap.Config.ARGB_8888);
        this.f5468c = new Canvas(this.f5467b);
        this.f5469d.reset();
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawPath(this.f5469d, this.f5466a);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f5471g = i2;
        this.f5472h = i3;
        f();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f5478n.setNoteStyle(this.f5470f, this.e);
        }
        if (motionEvent.getActionIndex() == 0) {
            this.f5478n.sendNoteEvent(motionEvent, getWidth(), getHeight());
        }
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f5477m = true;
            h(x2, y2);
        } else if (action == 1) {
            i(x2, y2);
            this.f5475k = System.currentTimeMillis();
            this.f5477m = false;
            postDelayed(new a(), 1500L);
        } else if (action == 2) {
            g(x2, y2);
            invalidate();
        }
        return true;
    }

    public void setAlpha(int i2) {
        this.f5466a.setAlpha(i2);
    }

    public void setColor(int i2) {
        this.f5466a.setColor(i2);
    }

    public void setEraser(boolean z2) {
        this.f5476l = z2;
        if (z2) {
            this.f5466a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            this.f5466a.setStrokeWidth(30.0f);
        } else {
            this.f5466a.setXfermode(null);
            this.f5466a.setStrokeWidth(this.e);
        }
    }

    public void setLine(int i2) {
        this.f5466a.setStrokeWidth(i2);
    }

    public void setPenColor(int i2) {
        this.f5470f = i2;
        this.f5466a.setColor(i2);
    }

    public void setPenSize(int i2) {
        this.e = i2;
        this.f5466a.setStrokeWidth(i2);
    }
}
