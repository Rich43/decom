package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.core.view.M;

/* loaded from: classes.dex */
class a extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private Animation.AnimationListener f4354a;

    /* renamed from: b, reason: collision with root package name */
    int f4355b;

    /* renamed from: androidx.swiperefreshlayout.widget.a$a, reason: collision with other inner class name */
    private class C0056a extends OvalShape {

        /* renamed from: a, reason: collision with root package name */
        private RadialGradient f4356a;

        /* renamed from: b, reason: collision with root package name */
        private Paint f4357b = new Paint();

        C0056a(int i2) {
            a.this.f4355b = i2;
            a((int) rect().width());
        }

        private void a(int i2) {
            float f2 = i2 / 2;
            RadialGradient radialGradient = new RadialGradient(f2, f2, a.this.f4355b, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.f4356a = radialGradient;
            this.f4357b.setShader(radialGradient);
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas canvas, Paint paint) {
            float width = a.this.getWidth() / 2;
            float height = a.this.getHeight() / 2;
            canvas.drawCircle(width, height, width, this.f4357b);
            canvas.drawCircle(width, height, r0 - a.this.f4355b, paint);
        }

        @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        protected void onResize(float f2, float f3) {
            super.onResize(f2, f3);
            a((int) f2);
        }
    }

    a(Context context, int i2) {
        ShapeDrawable shapeDrawable;
        super(context);
        float f2 = getContext().getResources().getDisplayMetrics().density;
        int i3 = (int) (1.75f * f2);
        int i4 = (int) (0.0f * f2);
        this.f4355b = (int) (3.5f * f2);
        if (a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            M.m0(this, f2 * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new C0056a(this.f4355b));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer(this.f4355b, i4, i3, 503316480);
            int i5 = this.f4355b;
            setPadding(i5, i5, i5, i5);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(i2);
        M.i0(this, shapeDrawable);
    }

    private boolean a() {
        return true;
    }

    public void b(Animation.AnimationListener animationListener) {
        this.f4354a = animationListener;
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f4354a;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f4354a;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (a()) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth() + (this.f4355b * 2), getMeasuredHeight() + (this.f4355b * 2));
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i2);
        }
    }
}
