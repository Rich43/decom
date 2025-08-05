package com.google.android.material.bottomappbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.app.F;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* loaded from: classes.dex */
public abstract class BottomAppBar extends Toolbar {
    static /* synthetic */ FloatingActionButton T(BottomAppBar bottomAppBar) {
        throw null;
    }

    static /* synthetic */ boolean U(BottomAppBar bottomAppBar) {
        throw null;
    }

    static /* synthetic */ void V(BottomAppBar bottomAppBar) {
        throw null;
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* renamed from: d, reason: collision with root package name */
        private final Rect f5659d;

        public Behavior() {
            this.f5659d = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior
        protected /* bridge */ /* synthetic */ void F(View view) {
            F.a(view);
            J(null);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior
        protected /* bridge */ /* synthetic */ void G(View view) {
            F.a(view);
            K(null);
        }

        public boolean H(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i2) {
            BottomAppBar.T(bottomAppBar);
            if (!BottomAppBar.U(bottomAppBar)) {
                BottomAppBar.V(bottomAppBar);
            }
            coordinatorLayout.G(bottomAppBar, i2);
            return super.l(coordinatorLayout, bottomAppBar, i2);
        }

        public boolean I(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i2, int i3) {
            throw null;
        }

        protected void J(BottomAppBar bottomAppBar) {
            super.F(bottomAppBar);
            BottomAppBar.T(bottomAppBar);
        }

        protected void K(BottomAppBar bottomAppBar) {
            super.G(bottomAppBar);
            BottomAppBar.T(bottomAppBar);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ boolean l(CoordinatorLayout coordinatorLayout, View view, int i2) {
            F.a(view);
            return H(coordinatorLayout, null, i2);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ boolean z(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i2, int i3) {
            F.a(view);
            return I(coordinatorLayout, null, view2, view3, i2, i3);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f5659d = new Rect();
        }
    }
}
