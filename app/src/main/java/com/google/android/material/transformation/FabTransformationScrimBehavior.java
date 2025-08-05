package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import v0.C0348b;

/* loaded from: classes.dex */
public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {

    /* renamed from: b, reason: collision with root package name */
    private final C0348b f5750b;

    /* renamed from: c, reason: collision with root package name */
    private final C0348b f5751c;

    public FabTransformationScrimBehavior() {
        this.f5750b = new C0348b(75L, 150L);
        this.f5751c = new C0348b(0L, 150L);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean C(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        return super.C(coordinatorLayout, view, motionEvent);
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return false;
    }

    public FabTransformationScrimBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5750b = new C0348b(75L, 150L);
        this.f5751c = new C0348b(0L, 150L);
    }
}
