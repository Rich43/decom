package com.google.android.material.snackbar;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;

/* loaded from: classes.dex */
public class BaseTransientBottomBar$Behavior extends SwipeDismissBehavior<View> {

    /* renamed from: j, reason: collision with root package name */
    private final a f5734j = new a(this);

    @Override // com.google.android.material.behavior.SwipeDismissBehavior
    public boolean D(View view) {
        return this.f5734j.a(view);
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        this.f5734j.b(coordinatorLayout, view, motionEvent);
        return super.k(coordinatorLayout, view, motionEvent);
    }
}
