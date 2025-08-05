package com.caglobal.kodakluma.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.caglobal.kodakluma.activity.MirrorNoteActivity;
import e0.AbstractC0249b;

/* loaded from: classes.dex */
public class BackColorButton extends View {

    /* renamed from: a, reason: collision with root package name */
    private Paint f5447a;

    /* renamed from: b, reason: collision with root package name */
    private int f5448b;

    public static class BackSizeButton extends View {

        /* renamed from: a, reason: collision with root package name */
        private Paint f5449a;

        /* renamed from: b, reason: collision with root package name */
        private int f5450b;

        public BackSizeButton(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            a(context, attributeSet);
        }

        public void a(Context context, AttributeSet attributeSet) {
            setSoundEffectsEnabled(true);
            Paint paint = new Paint();
            this.f5449a = paint;
            paint.setColor(-16777216);
            this.f5449a.setAntiAlias(true);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0249b.f6178u);
            this.f5450b = (int) typedArrayObtainStyledAttributes.getDimension(0, 1.0f);
            typedArrayObtainStyledAttributes.recycle();
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.f5450b, this.f5449a);
            if (isPressed() || isSelected()) {
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.STROKE);
                paint.setAntiAlias(true);
                paint.setStrokeWidth(3.0f);
                paint.setColor(-256);
                canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.f5450b + 1.5f, paint);
            }
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                setPressed(true);
                playSoundEffect(0);
                invalidate();
                return true;
            }
            if (action != 1) {
                return false;
            }
            setPressed(false);
            MirrorNoteActivity.m2().x2(getId(), false);
            MirrorNoteActivity.m2().w2(this.f5450b);
            invalidate();
            return true;
        }
    }

    public BackColorButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        setSoundEffectsEnabled(true);
        this.f5447a = new Paint();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0249b.f6176t);
        this.f5448b = typedArrayObtainStyledAttributes.getColor(0, -1);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(this.f5448b);
        if (isPressed() || isSelected()) {
            this.f5447a.setStyle(Paint.Style.STROKE);
            this.f5447a.setStrokeWidth(3.0f);
            this.f5447a.setColor(-256);
            canvas.drawRect(1.5f, 1.5f, getWidth() - 1.5f, getHeight() - 1.5f, this.f5447a);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            setPressed(true);
            playSoundEffect(0);
            invalidate();
            return true;
        }
        if (action != 1) {
            return false;
        }
        setPressed(false);
        MirrorNoteActivity.m2().x2(getId(), true);
        MirrorNoteActivity.m2().v2(this.f5448b);
        invalidate();
        return true;
    }
}
