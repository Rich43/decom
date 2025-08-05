package com.google.android.material.snackbar;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;

/* loaded from: classes.dex */
public class a {
    public a(SwipeDismissBehavior swipeDismissBehavior) {
        swipeDismissBehavior.J(0.1f);
        swipeDismissBehavior.I(0.6f);
        swipeDismissBehavior.K(0);
    }

    public boolean a(View view) {
        return view instanceof d;
    }

    public void b(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            if (coordinatorLayout.z(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                e.b().e(null);
            }
        } else if (actionMasked == 1 || actionMasked == 3) {
            e.b().f(null);
        }
    }
}
