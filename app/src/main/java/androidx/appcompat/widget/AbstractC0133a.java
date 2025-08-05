package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.request.target.Target;
import defpackage.e;

/* renamed from: androidx.appcompat.widget.a */
/* loaded from: classes.dex */
abstract class AbstractC0133a extends ViewGroup {

    /* renamed from: a */
    protected final C0019a f2365a;

    /* renamed from: b */
    protected final Context f2366b;

    /* renamed from: c */
    protected ActionMenuView f2367c;

    /* renamed from: d */
    protected C0135c f2368d;
    protected int e;

    /* renamed from: f */
    protected androidx.core.view.V f2369f;

    /* renamed from: g */
    private boolean f2370g;

    /* renamed from: h */
    private boolean f2371h;

    /* renamed from: androidx.appcompat.widget.a$a */
    protected class C0019a implements androidx.core.view.W {

        /* renamed from: a */
        private boolean f2372a = false;

        /* renamed from: b */
        int f2373b;

        protected C0019a() {
        }

        @Override // androidx.core.view.W
        public void a(View view) {
            if (this.f2372a) {
                return;
            }
            AbstractC0133a abstractC0133a = AbstractC0133a.this;
            abstractC0133a.f2369f = null;
            AbstractC0133a.super.setVisibility(this.f2373b);
        }

        @Override // androidx.core.view.W
        public void b(View view) {
            AbstractC0133a.super.setVisibility(0);
            this.f2372a = false;
        }

        @Override // androidx.core.view.W
        public void c(View view) {
            this.f2372a = true;
        }

        public C0019a d(androidx.core.view.V v2, int i2) {
            AbstractC0133a.this.f2369f = v2;
            this.f2373b = i2;
            return this;
        }
    }

    AbstractC0133a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2365a = new C0019a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(e.d.f5836a, typedValue, true) || typedValue.resourceId == 0) {
            this.f2366b = context;
        } else {
            this.f2366b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    protected static int d(int i2, int i3, boolean z2) {
        return z2 ? i2 - i3 : i2 + i3;
    }

    protected int c(View view, int i2, int i3, int i4) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i2, Target.SIZE_ORIGINAL), i3);
        return Math.max(0, (i2 - view.getMeasuredWidth()) - i4);
    }

    protected int e(View view, int i2, int i3, int i4, boolean z2) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i5 = i3 + ((i4 - measuredHeight) / 2);
        if (z2) {
            view.layout(i2 - measuredWidth, i5, i2, measuredHeight + i5);
        } else {
            view.layout(i2, i5, i2 + measuredWidth, measuredHeight + i5);
        }
        return z2 ? -measuredWidth : measuredWidth;
    }

    public androidx.core.view.V f(int i2, long j2) {
        androidx.core.view.V v2 = this.f2369f;
        if (v2 != null) {
            v2.c();
        }
        if (i2 != 0) {
            androidx.core.view.V vB = androidx.core.view.M.c(this).b(0.0f);
            vB.f(j2);
            vB.h(this.f2365a.d(vB, i2));
            return vB;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        androidx.core.view.V vB2 = androidx.core.view.M.c(this).b(1.0f);
        vB2.f(j2);
        vB2.h(this.f2365a.d(vB2, i2));
        return vB2;
    }

    public int getAnimatedVisibility() {
        return this.f2369f != null ? this.f2365a.f2373b : getVisibility();
    }

    public int getContentHeight() {
        return this.e;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, e.m.f6024a, e.d.f5838c, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(e.m.f6050j, 0));
        typedArrayObtainStyledAttributes.recycle();
        C0135c c0135c = this.f2368d;
        if (c0135c != null) {
            c0135c.F(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f2371h = false;
        }
        if (!this.f2371h) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f2371h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f2371h = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f2370g = false;
        }
        if (!this.f2370g) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f2370g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f2370g = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i2);

    @Override // android.view.View
    public void setVisibility(int i2) {
        if (i2 != getVisibility()) {
            androidx.core.view.V v2 = this.f2369f;
            if (v2 != null) {
                v2.c();
            }
            super.setVisibility(i2);
        }
    }
}
