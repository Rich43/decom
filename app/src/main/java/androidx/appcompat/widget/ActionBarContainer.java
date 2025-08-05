package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bumptech.glide.request.target.Target;
import defpackage.e;

/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private boolean f2058a;

    /* renamed from: b, reason: collision with root package name */
    private View f2059b;

    /* renamed from: c, reason: collision with root package name */
    private View f2060c;

    /* renamed from: d, reason: collision with root package name */
    private View f2061d;
    Drawable e;

    /* renamed from: f, reason: collision with root package name */
    Drawable f2062f;

    /* renamed from: g, reason: collision with root package name */
    Drawable f2063g;

    /* renamed from: h, reason: collision with root package name */
    boolean f2064h;

    /* renamed from: i, reason: collision with root package name */
    boolean f2065i;

    /* renamed from: j, reason: collision with root package name */
    private int f2066j;

    private static class a {
        public static void a(ActionBarContainer actionBarContainer) {
            actionBarContainer.invalidateOutline();
        }
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackground(new C0134b(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.m.f6024a);
        this.e = typedArrayObtainStyledAttributes.getDrawable(e.m.f6027b);
        this.f2062f = typedArrayObtainStyledAttributes.getDrawable(e.m.f6033d);
        this.f2066j = typedArrayObtainStyledAttributes.getDimensionPixelSize(e.m.f6050j, -1);
        boolean z2 = true;
        if (getId() == e.i.f5941y) {
            this.f2064h = true;
            this.f2063g = typedArrayObtainStyledAttributes.getDrawable(e.m.f6030c);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.f2064h ? this.e != null || this.f2062f != null : this.f2063g != null) {
            z2 = false;
        }
        setWillNotDraw(z2);
    }

    private int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    private boolean b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.e;
        if (drawable != null && drawable.isStateful()) {
            this.e.setState(getDrawableState());
        }
        Drawable drawable2 = this.f2062f;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f2062f.setState(getDrawableState());
        }
        Drawable drawable3 = this.f2063g;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f2063g.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f2059b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f2062f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f2063g;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f2060c = findViewById(e.i.f5921a);
        this.f2061d = findViewById(e.i.f5925f);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f2058a || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        Drawable drawable;
        super.onLayout(z2, i2, i3, i4, i5);
        View view = this.f2059b;
        boolean z3 = true;
        boolean z4 = false;
        boolean z5 = (view == null || view.getVisibility() == 8) ? false : true;
        if (view != null && view.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            int measuredHeight2 = measuredHeight - view.getMeasuredHeight();
            int i6 = layoutParams.bottomMargin;
            view.layout(i2, measuredHeight2 - i6, i4, measuredHeight - i6);
        }
        if (this.f2064h) {
            Drawable drawable2 = this.f2063g;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z3 = false;
            }
        } else {
            if (this.e != null) {
                if (this.f2060c.getVisibility() == 0) {
                    this.e.setBounds(this.f2060c.getLeft(), this.f2060c.getTop(), this.f2060c.getRight(), this.f2060c.getBottom());
                } else {
                    View view2 = this.f2061d;
                    if (view2 == null || view2.getVisibility() != 0) {
                        this.e.setBounds(0, 0, 0, 0);
                    } else {
                        this.e.setBounds(this.f2061d.getLeft(), this.f2061d.getTop(), this.f2061d.getRight(), this.f2061d.getBottom());
                    }
                }
                z4 = true;
            }
            this.f2065i = z5;
            if (!z5 || (drawable = this.f2062f) == null) {
                z3 = z4;
            } else {
                drawable.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        }
        if (z3) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        if (this.f2060c == null && View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE && (i4 = this.f2066j) >= 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(i4, View.MeasureSpec.getSize(i3)), Target.SIZE_ORIGINAL);
        }
        super.onMeasure(i2, i3);
        if (this.f2060c == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i3);
        View view = this.f2059b;
        if (view == null || view.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min((!b(this.f2060c) ? a(this.f2060c) : !b(this.f2061d) ? a(this.f2061d) : 0) + a(this.f2059b), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i3) : Integer.MAX_VALUE));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.e);
        }
        this.e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f2060c;
            if (view != null) {
                this.e.setBounds(view.getLeft(), this.f2060c.getTop(), this.f2060c.getRight(), this.f2060c.getBottom());
            }
        }
        boolean z2 = false;
        if (!this.f2064h ? !(this.e != null || this.f2062f != null) : this.f2063g == null) {
            z2 = true;
        }
        setWillNotDraw(z2);
        invalidate();
        a.a(this);
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f2063g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f2063g);
        }
        this.f2063g = drawable;
        boolean z2 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f2064h && (drawable2 = this.f2063g) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f2064h ? !(this.e != null || this.f2062f != null) : this.f2063g == null) {
            z2 = true;
        }
        setWillNotDraw(z2);
        invalidate();
        a.a(this);
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f2062f;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f2062f);
        }
        this.f2062f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f2065i && (drawable2 = this.f2062f) != null) {
                drawable2.setBounds(this.f2059b.getLeft(), this.f2059b.getTop(), this.f2059b.getRight(), this.f2059b.getBottom());
            }
        }
        boolean z2 = false;
        if (!this.f2064h ? !(this.e != null || this.f2062f != null) : this.f2063g == null) {
            z2 = true;
        }
        setWillNotDraw(z2);
        invalidate();
        a.a(this);
    }

    public void setTabContainer(Y y2) {
        View view = this.f2059b;
        if (view != null) {
            removeView(view);
        }
        this.f2059b = y2;
    }

    public void setTransitioning(boolean z2) {
        this.f2058a = z2;
        setDescendantFocusability(z2 ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z2 = i2 == 0;
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.setVisible(z2, false);
        }
        Drawable drawable2 = this.f2062f;
        if (drawable2 != null) {
            drawable2.setVisible(z2, false);
        }
        Drawable drawable3 = this.f2063g;
        if (drawable3 != null) {
            drawable3.setVisible(z2, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.e && !this.f2064h) || (drawable == this.f2062f && this.f2065i) || ((drawable == this.f2063g && this.f2064h) || super.verifyDrawable(drawable));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i2) {
        if (i2 != 0) {
            return super.startActionModeForChild(view, callback, i2);
        }
        return null;
    }
}
