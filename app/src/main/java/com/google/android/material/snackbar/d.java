package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.core.view.M;
import u0.AbstractC0337g;
import w.AbstractC0359c;

/* loaded from: classes.dex */
public abstract class d extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private final AccessibilityManager f5739a;

    /* renamed from: b, reason: collision with root package name */
    private final AbstractC0359c.a f5740b;

    class a implements AbstractC0359c.a {
        a() {
        }

        @Override // w.AbstractC0359c.a
        public void onTouchExplorationStateChanged(boolean z2) {
            d.this.setClickableOrFocusableBasedOnAccessibility(z2);
        }
    }

    protected d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0337g.f7577A0);
        if (typedArrayObtainStyledAttributes.hasValue(AbstractC0337g.f7581C0)) {
            M.m0(this, typedArrayObtainStyledAttributes.getDimensionPixelSize(r0, 0));
        }
        typedArrayObtainStyledAttributes.recycle();
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        this.f5739a = accessibilityManager;
        a aVar = new a();
        this.f5740b = aVar;
        AbstractC0359c.a(accessibilityManager, aVar);
        setClickableOrFocusableBasedOnAccessibility(accessibilityManager.isTouchExplorationEnabled());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClickableOrFocusableBasedOnAccessibility(boolean z2) {
        setClickable(!z2);
        setFocusable(z2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        M.c0(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AbstractC0359c.b(this.f5739a, this.f5740b);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
    }

    void setOnAttachStateChangeListener(b bVar) {
    }

    void setOnLayoutChangeListener(c cVar) {
    }
}
