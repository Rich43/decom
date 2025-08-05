package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
class d extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private float f2571a;

    /* renamed from: c, reason: collision with root package name */
    private final RectF f2573c;

    /* renamed from: d, reason: collision with root package name */
    private final Rect f2574d;
    private float e;

    /* renamed from: h, reason: collision with root package name */
    private ColorStateList f2577h;

    /* renamed from: i, reason: collision with root package name */
    private PorterDuffColorFilter f2578i;

    /* renamed from: j, reason: collision with root package name */
    private ColorStateList f2579j;

    /* renamed from: f, reason: collision with root package name */
    private boolean f2575f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f2576g = true;

    /* renamed from: k, reason: collision with root package name */
    private PorterDuff.Mode f2580k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b, reason: collision with root package name */
    private final Paint f2572b = new Paint(5);

    d(ColorStateList colorStateList, float f2) {
        this.f2571a = f2;
        e(colorStateList);
        this.f2573c = new RectF();
        this.f2574d = new Rect();
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    private void e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f2577h = colorStateList;
        this.f2572b.setColor(colorStateList.getColorForState(getState(), this.f2577h.getDefaultColor()));
    }

    private void i(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f2573c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f2574d.set(rect);
        if (this.f2575f) {
            this.f2574d.inset((int) Math.ceil(e.a(this.e, this.f2571a, this.f2576g)), (int) Math.ceil(e.b(this.e, this.f2571a, this.f2576g)));
            this.f2573c.set(this.f2574d);
        }
    }

    public ColorStateList b() {
        return this.f2577h;
    }

    float c() {
        return this.e;
    }

    public float d() {
        return this.f2571a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z2;
        Paint paint = this.f2572b;
        if (this.f2578i == null || paint.getColorFilter() != null) {
            z2 = false;
        } else {
            paint.setColorFilter(this.f2578i);
            z2 = true;
        }
        RectF rectF = this.f2573c;
        float f2 = this.f2571a;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        if (z2) {
            paint.setColorFilter(null);
        }
    }

    public void f(ColorStateList colorStateList) {
        e(colorStateList);
        invalidateSelf();
    }

    void g(float f2, boolean z2, boolean z3) {
        if (f2 == this.e && this.f2575f == z2 && this.f2576g == z3) {
            return;
        }
        this.e = f2;
        this.f2575f = z2;
        this.f2576g = z3;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f2574d, this.f2571a);
    }

    void h(float f2) {
        if (f2 == this.f2571a) {
            return;
        }
        this.f2571a = f2;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f2579j;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f2577h) != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        i(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f2577h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z2 = colorForState != this.f2572b.getColor();
        if (z2) {
            this.f2572b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f2579j;
        if (colorStateList2 == null || (mode = this.f2580k) == null) {
            return z2;
        }
        this.f2578i = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f2572b.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f2572b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f2579j = colorStateList;
        this.f2578i = a(colorStateList, this.f2580k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f2580k = mode;
        this.f2578i = a(this.f2579j, mode);
        invalidateSelf();
    }
}
