package com.google.android.material.transformation;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: b, reason: collision with root package name */
    private final Rect f5747b;

    /* renamed from: c, reason: collision with root package name */
    private final RectF f5748c;

    /* renamed from: d, reason: collision with root package name */
    private final RectF f5749d;
    private final int[] e;

    public FabTransformationBehavior() {
        this.f5747b = new Rect();
        this.f5748c = new RectF();
        this.f5749d = new RectF();
        this.e = new int[2];
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() != 8) {
            return false;
        }
        throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public void g(CoordinatorLayout.e eVar) {
        if (eVar.f2830h == 0) {
            eVar.f2830h = 80;
        }
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5747b = new Rect();
        this.f5748c = new RectF();
        this.f5749d = new RectF();
        this.e = new int[2];
    }
}
