package com.caglobal.kodakluma.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.F;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* loaded from: classes.dex */
public class PinchImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private View.OnClickListener f5480a;

    /* renamed from: b, reason: collision with root package name */
    private View.OnLongClickListener f5481b;

    /* renamed from: c, reason: collision with root package name */
    private Matrix f5482c;

    /* renamed from: d, reason: collision with root package name */
    private RectF f5483d;
    private int e;

    /* renamed from: f, reason: collision with root package name */
    private RectF f5484f;

    /* renamed from: g, reason: collision with root package name */
    private List f5485g;

    /* renamed from: h, reason: collision with root package name */
    private List f5486h;

    /* renamed from: i, reason: collision with root package name */
    private int f5487i;

    /* renamed from: j, reason: collision with root package name */
    private PointF f5488j;

    /* renamed from: k, reason: collision with root package name */
    private PointF f5489k;

    /* renamed from: l, reason: collision with root package name */
    private float f5490l;

    /* renamed from: m, reason: collision with root package name */
    private g f5491m;

    /* renamed from: n, reason: collision with root package name */
    private b f5492n;
    private GestureDetector o;

    class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (PinchImageView.this.e == 1 && (PinchImageView.this.f5491m == null || !PinchImageView.this.f5491m.isRunning())) {
                PinchImageView.this.m(motionEvent.getX(), motionEvent.getY());
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (PinchImageView.this.e != 0) {
                return true;
            }
            if (PinchImageView.this.f5491m != null && PinchImageView.this.f5491m.isRunning()) {
                return true;
            }
            PinchImageView.this.n(f2, f3);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (PinchImageView.this.f5481b != null) {
                PinchImageView.this.f5481b.onLongClick(PinchImageView.this);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (PinchImageView.this.f5480a == null) {
                return true;
            }
            PinchImageView.this.f5480a.onClick(PinchImageView.this);
            return true;
        }
    }

    private class b extends ValueAnimator implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        private float[] f5494a;

        public b(float f2, float f3) {
            setFloatValues(0.0f, 1.0f);
            setDuration(1000000L);
            addUpdateListener(this);
            this.f5494a = new float[]{f2, f3};
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            PinchImageView pinchImageView = PinchImageView.this;
            float[] fArr = this.f5494a;
            boolean zX = pinchImageView.x(fArr[0], fArr[1]);
            float[] fArr2 = this.f5494a;
            float f2 = fArr2[0] * 0.9f;
            fArr2[0] = f2;
            float f3 = fArr2[1] * 0.9f;
            fArr2[1] = f3;
            if (!zX || c.b(0.0f, 0.0f, f2, f3) < 1.0f) {
                valueAnimator.cancel();
            }
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private static d f5496a = new d(16);

        /* renamed from: b, reason: collision with root package name */
        private static f f5497b = new f(16);

        public static float[] a(float f2, float f3, float f4, float f5) {
            return new float[]{(f2 + f4) / 2.0f, (f3 + f5) / 2.0f};
        }

        public static float b(float f2, float f3, float f4, float f5) {
            float f6 = f2 - f4;
            float f7 = f3 - f5;
            return (float) Math.sqrt((f6 * f6) + (f7 * f7));
        }

        public static float[] c(Matrix matrix) {
            if (matrix == null) {
                return new float[2];
            }
            float[] fArr = new float[9];
            matrix.getValues(fArr);
            return new float[]{fArr[0], fArr[4]};
        }

        public static float[] d(float[] fArr, Matrix matrix) {
            if (fArr == null || matrix == null) {
                return new float[2];
            }
            float[] fArr2 = new float[2];
            Matrix matrixF = f();
            matrix.invert(matrixF);
            matrixF.mapPoints(fArr2, fArr);
            e(matrixF);
            return fArr2;
        }

        public static void e(Matrix matrix) {
            f5496a.a(matrix);
        }

        public static Matrix f() {
            return (Matrix) f5496a.d();
        }

        public static Matrix g(Matrix matrix) {
            Matrix matrix2 = (Matrix) f5496a.d();
            if (matrix != null) {
                matrix2.set(matrix);
            }
            return matrix2;
        }

        public static void h(RectF rectF) {
            f5497b.a(rectF);
        }

        public static RectF i() {
            return (RectF) f5497b.d();
        }

        public static RectF j(float f2, float f3, float f4, float f5) {
            RectF rectF = (RectF) f5497b.d();
            rectF.set(f2, f3, f4, f5);
            return rectF;
        }
    }

    private static class d extends e {
        public d(int i2) {
            super(i2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.caglobal.kodakluma.view.PinchImageView.e
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Matrix b() {
            return new Matrix();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.caglobal.kodakluma.view.PinchImageView.e
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Matrix c(Matrix matrix) {
            matrix.reset();
            return matrix;
        }
    }

    private static abstract class e {

        /* renamed from: a, reason: collision with root package name */
        private int f5498a;

        /* renamed from: b, reason: collision with root package name */
        private Queue f5499b = new LinkedList();

        public e(int i2) {
            this.f5498a = i2;
        }

        public void a(Object obj) {
            if (obj == null || this.f5499b.size() >= this.f5498a) {
                return;
            }
            this.f5499b.offer(obj);
        }

        protected abstract Object b();

        protected abstract Object c(Object obj);

        public Object d() {
            return this.f5499b.size() == 0 ? b() : c(this.f5499b.poll());
        }
    }

    private static class f extends e {
        public f(int i2) {
            super(i2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.caglobal.kodakluma.view.PinchImageView.e
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public RectF b() {
            return new RectF();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.caglobal.kodakluma.view.PinchImageView.e
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public RectF c(RectF rectF) {
            rectF.setEmpty();
            return rectF;
        }
    }

    private class g extends ValueAnimator implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        private float[] f5500a;

        /* renamed from: b, reason: collision with root package name */
        private float[] f5501b;

        /* renamed from: c, reason: collision with root package name */
        private float[] f5502c;

        public g(PinchImageView pinchImageView, Matrix matrix, Matrix matrix2) {
            this(matrix, matrix2, 200L);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            for (int i2 = 0; i2 < 9; i2++) {
                float[] fArr = this.f5502c;
                float f2 = this.f5500a[i2];
                fArr[i2] = f2 + ((this.f5501b[i2] - f2) * fFloatValue);
            }
            PinchImageView.this.f5482c.setValues(this.f5502c);
            PinchImageView.this.l();
            PinchImageView.this.invalidate();
        }

        public g(Matrix matrix, Matrix matrix2, long j2) {
            this.f5500a = new float[9];
            this.f5501b = new float[9];
            this.f5502c = new float[9];
            setFloatValues(0.0f, 1.0f);
            setDuration(j2);
            addUpdateListener(this);
            matrix.getValues(this.f5500a);
            matrix2.getValues(this.f5501b);
        }
    }

    public PinchImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5482c = new Matrix();
        this.e = 0;
        this.f5488j = new PointF();
        this.f5489k = new PointF();
        this.f5490l = 0.0f;
        this.o = new GestureDetector(getContext(), new a());
        r();
    }

    private void k() {
        g gVar = this.f5491m;
        if (gVar != null) {
            gVar.cancel();
            this.f5491m = null;
        }
        b bVar = this.f5492n;
        if (bVar != null) {
            bVar.cancel();
            this.f5492n = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        List list;
        List list2 = this.f5485g;
        if (list2 == null) {
            return;
        }
        this.f5487i++;
        Iterator it = list2.iterator();
        if (it.hasNext()) {
            F.a(it.next());
            throw null;
        }
        int i2 = this.f5487i - 1;
        this.f5487i = i2;
        if (i2 != 0 || (list = this.f5486h) == null) {
            return;
        }
        this.f5485g = list;
        this.f5486h = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(float f2, float f3) {
        if (s()) {
            Matrix matrixF = c.f();
            q(matrixF);
            float f4 = c.c(matrixF)[0];
            float f5 = c.c(this.f5482c)[0];
            float f6 = f4 * f5;
            float width = getWidth();
            float height = getHeight();
            float maxScale = getMaxScale();
            float fJ = j(f4, f5);
            if (fJ <= maxScale) {
                maxScale = fJ;
            }
            if (maxScale >= f4) {
                f4 = maxScale;
            }
            Matrix matrixG = c.g(this.f5482c);
            float f7 = f4 / f6;
            matrixG.postScale(f7, f7, f2, f3);
            float f8 = width / 2.0f;
            float f9 = height / 2.0f;
            matrixG.postTranslate(f8 - f2, f9 - f3);
            Matrix matrixG2 = c.g(matrixF);
            matrixG2.postConcat(matrixG);
            float f10 = 0.0f;
            RectF rectFJ = c.j(0.0f, 0.0f, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
            matrixG2.mapRect(rectFJ);
            float f11 = rectFJ.right;
            float f12 = rectFJ.left;
            float f13 = f11 - f12 < width ? f8 - ((f11 + f12) / 2.0f) : f12 > 0.0f ? -f12 : f11 < width ? width - f11 : 0.0f;
            float f14 = rectFJ.bottom;
            float f15 = rectFJ.top;
            if (f14 - f15 < height) {
                f10 = f9 - ((f14 + f15) / 2.0f);
            } else if (f15 > 0.0f) {
                f10 = -f15;
            } else if (f14 < height) {
                f10 = height - f14;
            }
            matrixG.postTranslate(f13, f10);
            k();
            g gVar = new g(this, this.f5482c, matrixG);
            this.f5491m = gVar;
            gVar.start();
            c.h(rectFJ);
            c.e(matrixG2);
            c.e(matrixG);
            c.e(matrixF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(float f2, float f3) {
        if (s()) {
            k();
            b bVar = new b(f2 / 60.0f, f3 / 60.0f);
            this.f5492n = bVar;
            bVar.start();
        }
    }

    private void r() {
        super.setScaleType(ImageView.ScaleType.MATRIX);
    }

    private boolean s() {
        return getDrawable() != null && getDrawable().getIntrinsicWidth() > 0 && getDrawable().getIntrinsicHeight() > 0 && getWidth() > 0 && getHeight() > 0;
    }

    private void u(float f2, float f3, float f4, float f5) {
        this.f5490l = c.c(this.f5482c)[0] / c.b(f2, f3, f4, f5);
        float[] fArrD = c.d(c.a(f2, f3, f4, f5), this.f5482c);
        this.f5489k.set(fArrD[0], fArrD[1]);
    }

    private void v(PointF pointF, float f2, float f3, PointF pointF2) {
        if (s()) {
            float f4 = f2 * f3;
            Matrix matrixF = c.f();
            matrixF.postScale(f4, f4, pointF.x, pointF.y);
            matrixF.postTranslate(pointF2.x - pointF.x, pointF2.y - pointF.y);
            this.f5482c.set(matrixF);
            c.e(matrixF);
            l();
            invalidate();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void w() {
        /*
            Method dump skipped, instructions count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caglobal.kodakluma.view.PinchImageView.w():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean x(float r9, float r10) {
        /*
            r8 = this;
            boolean r0 = r8.s()
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            android.graphics.RectF r0 = com.caglobal.kodakluma.view.PinchImageView.c.i()
            r8.p(r0)
            int r2 = r8.getWidth()
            float r2 = (float) r2
            int r3 = r8.getHeight()
            float r3 = (float) r3
            float r4 = r0.right
            float r5 = r0.left
            float r6 = r4 - r5
            r7 = 0
            int r6 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r6 >= 0) goto L26
        L24:
            r9 = 0
            goto L3e
        L26:
            float r6 = r5 + r9
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 <= 0) goto L32
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 >= 0) goto L24
            float r9 = -r5
            goto L3e
        L32:
            float r5 = r4 + r9
            int r5 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r5 >= 0) goto L3e
            int r9 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r9 <= 0) goto L24
            float r9 = r2 - r4
        L3e:
            float r2 = r0.bottom
            float r4 = r0.top
            float r5 = r2 - r4
            int r5 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r5 >= 0) goto L4a
        L48:
            r10 = 0
            goto L62
        L4a:
            float r5 = r4 + r10
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 <= 0) goto L56
            int r10 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r10 >= 0) goto L48
            float r10 = -r4
            goto L62
        L56:
            float r4 = r2 + r10
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 >= 0) goto L62
            int r10 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r10 <= 0) goto L48
            float r10 = r3 - r2
        L62:
            com.caglobal.kodakluma.view.PinchImageView.c.h(r0)
            android.graphics.Matrix r0 = r8.f5482c
            r0.postTranslate(r9, r10)
            r8.l()
            r8.invalidate()
            int r9 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r9 != 0) goto L7a
            int r9 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r9 == 0) goto L79
            goto L7a
        L79:
            return r1
        L7a:
            r9 = 1
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caglobal.kodakluma.view.PinchImageView.x(float, float):boolean");
    }

    public RectF getInnerImageBound() {
        if (this.f5484f == null) {
            this.f5484f = new RectF();
        }
        if (!s()) {
            return this.f5484f;
        }
        Matrix matrixF = c.f();
        q(matrixF);
        this.f5484f.set(0.0f, 0.0f, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
        matrixF.mapRect(this.f5484f);
        c.e(matrixF);
        return this.f5484f;
    }

    public RectF getMask() {
        if (this.f5483d != null) {
            return new RectF(this.f5483d);
        }
        return null;
    }

    protected float getMaxScale() {
        return 4.0f;
    }

    public int getPinchMode() {
        return this.e;
    }

    protected float j(float f2, float f3) {
        if (f3 * f2 < 4.0f) {
            return 4.0f;
        }
        return f2;
    }

    public Matrix o(Matrix matrix) {
        Matrix matrixQ = q(matrix);
        matrixQ.postConcat(this.f5482c);
        return matrixQ;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (s()) {
            Matrix matrixF = c.f();
            setImageMatrix(o(matrixF));
            c.e(matrixF);
        }
        if (this.f5483d == null) {
            super.onDraw(canvas);
            return;
        }
        canvas.save();
        canvas.clipRect(this.f5483d);
        super.onDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        g gVar;
        super.onTouchEvent(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 1 || action == 3) {
            if (this.e == 2) {
                w();
            }
            this.e = 0;
        } else if (action == 6) {
            if (this.e == 2 && motionEvent.getPointerCount() > 2) {
                if ((motionEvent.getAction() >> 8) == 0) {
                    u(motionEvent.getX(1), motionEvent.getY(1), motionEvent.getX(2), motionEvent.getY(2));
                } else if ((motionEvent.getAction() >> 8) == 1) {
                    u(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(2), motionEvent.getY(2));
                }
            }
        } else if (action == 0) {
            g gVar2 = this.f5491m;
            if (gVar2 == null || !gVar2.isRunning()) {
                k();
                this.e = 1;
                this.f5488j.set(motionEvent.getX(), motionEvent.getY());
            }
        } else if (action == 5) {
            k();
            this.e = 2;
            u(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(1), motionEvent.getY(1));
        } else if (action == 2 && ((gVar = this.f5491m) == null || !gVar.isRunning())) {
            int i2 = this.e;
            if (i2 == 1) {
                x(motionEvent.getX() - this.f5488j.x, motionEvent.getY() - this.f5488j.y);
                this.f5488j.set(motionEvent.getX(), motionEvent.getY());
            } else if (i2 == 2 && motionEvent.getPointerCount() > 1) {
                float fB = c.b(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(1), motionEvent.getY(1));
                float[] fArrA = c.a(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(1), motionEvent.getY(1));
                this.f5488j.set(fArrA[0], fArrA[1]);
                v(this.f5489k, this.f5490l, fB, this.f5488j);
            }
        }
        this.o.onTouchEvent(motionEvent);
        return true;
    }

    public RectF p(RectF rectF) {
        if (rectF == null) {
            rectF = new RectF();
        } else {
            rectF.setEmpty();
        }
        if (!s()) {
            return rectF;
        }
        Matrix matrixF = c.f();
        o(matrixF);
        rectF.set(0.0f, 0.0f, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
        matrixF.mapRect(rectF);
        c.e(matrixF);
        return rectF;
    }

    public Matrix q(Matrix matrix) {
        if (matrix == null) {
            matrix = new Matrix();
        } else {
            matrix.reset();
        }
        if (s()) {
            RectF rectFJ = c.j(0.0f, 0.0f, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
            RectF rectFJ2 = c.j(0.0f, 0.0f, getWidth(), getHeight());
            matrix.setRectToRect(rectFJ, rectFJ2, Matrix.ScaleToFit.CENTER);
            c.h(rectFJ2);
            c.h(rectFJ);
        }
        return matrix;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f5480a = onClickListener;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f5481b = onLongClickListener;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
    }

    public void t() {
        this.f5482c.reset();
        l();
        this.f5483d = null;
        this.e = 0;
        this.f5488j.set(0.0f, 0.0f);
        this.f5489k.set(0.0f, 0.0f);
        this.f5490l = 0.0f;
        k();
        invalidate();
    }
}
