package com.caglobal.kodakluma.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public class TouchView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private Paint f5508a;

    /* renamed from: b, reason: collision with root package name */
    private List f5509b;

    /* renamed from: c, reason: collision with root package name */
    private final Handler f5510c;

    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            if (!TouchView.this.f5509b.isEmpty()) {
                TouchView.this.f5509b.remove(0);
                TouchView.this.f5509b.add(new Point(-1, -1));
                TouchView.this.invalidate();
            }
            sendEmptyMessageDelayed(1, 30L);
        }
    }

    public TouchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5510c = new a();
        b();
    }

    private void b() {
        Paint paint = new Paint();
        this.f5508a = paint;
        paint.setColor(-15236387);
        this.f5509b = new ArrayList();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i2 = 0; i2 < this.f5509b.size(); i2++) {
            Point point = (Point) this.f5509b.get(i2);
            if (point.x >= 0 && point.y >= 0) {
                this.f5508a.setAlpha(((i2 + 1) * 50) / this.f5509b.size());
                canvas.drawCircle(point.x, point.y, 40.0f, this.f5508a);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Point point = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
        if (this.f5509b.size() >= 15) {
            this.f5509b.remove(0);
        }
        this.f5509b.add(point);
        invalidate();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f5510c.removeMessages(1);
        } else if (action == 1 || action == 3) {
            this.f5510c.sendEmptyMessageDelayed(1, 30L);
        }
        return true;
    }
}
