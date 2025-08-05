package com.caglobal.kodakluma.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class KeysButton extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private Long f5460a;

    /* renamed from: b, reason: collision with root package name */
    private long f5461b;

    /* renamed from: c, reason: collision with root package name */
    private int f5462c;

    /* renamed from: d, reason: collision with root package name */
    private int f5463d;
    private int e;

    /* renamed from: f, reason: collision with root package name */
    private a f5464f;

    /* renamed from: g, reason: collision with root package name */
    private int f5465g;

    public interface a {
        void a(int i2);

        void b(int i2);
    }

    public KeysButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5462c = 427;
        this.f5463d = 53;
        this.e = 213;
        this.f5465g = 0;
    }

    private boolean a(float f2, float f3) {
        float fAbs = Math.abs(f2 - (this.f5462c / 2));
        float fAbs2 = Math.abs(f3 - (this.f5462c / 2));
        return Math.sqrt((double) ((fAbs * fAbs) + (fAbs2 * fAbs2))) <= ((double) this.e);
    }

    private boolean b(float f2, float f3) {
        float fAbs = Math.abs(f2 - (this.f5462c / 2));
        float fAbs2 = Math.abs(f3 - (this.f5462c / 2));
        return Math.sqrt((double) ((fAbs * fAbs) + (fAbs2 * fAbs2))) <= ((double) this.f5463d);
    }

    private boolean c(float f2, float f3) {
        return f2 + f3 <= ((float) this.f5462c);
    }

    private boolean d(float f2, float f3) {
        return f2 >= f3;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int measuredWidth = getMeasuredWidth();
        this.f5462c = measuredWidth;
        this.f5463d = (measuredWidth * 53) / 427;
        this.e = (measuredWidth * 213) / 427;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i2;
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        if (b(x2, y2)) {
            i2 = 5;
        } else if (a(x2, y2)) {
            boolean zC = c(x2, y2);
            boolean zD = d(x2, y2);
            i2 = (zC && zD) ? 1 : zC ? 3 : zD ? 4 : 2;
        } else {
            i2 = 0;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f5465g = i2;
            setImageLevel(i2);
            this.f5460a = Long.valueOf(motionEvent.getDownTime());
            a aVar = this.f5464f;
            if (aVar != null) {
                aVar.b(this.f5465g);
            }
        } else if (action == 1) {
            setImageLevel(0);
            this.f5461b = motionEvent.getEventTime();
            a aVar2 = this.f5464f;
            if (aVar2 != null) {
                aVar2.a(this.f5465g);
            }
        } else if (action != 2) {
            if (action == 3) {
                setImageLevel(0);
            }
        } else if (this.f5465g != i2) {
            setImageLevel(0);
            this.f5465g = 0;
        }
        return true;
    }

    public void setButtonClickListener(a aVar) {
        this.f5464f = aVar;
    }
}
