package com.google.android.material.floatingactionbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.F;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.d;
import java.util.List;
import u0.AbstractC0337g;
import w0.InterfaceC0371a;

/* loaded from: classes.dex */
public abstract class FloatingActionButton extends d implements InterfaceC0371a {

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean D(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            return super.D(coordinatorLayout, floatingActionButton, rect);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean G(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            return super.G(coordinatorLayout, floatingActionButton, view);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean H(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i2) {
            return super.H(coordinatorLayout, floatingActionButton, i2);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ void g(CoordinatorLayout.e eVar) {
            super.g(eVar);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    protected static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.b {

        /* renamed from: a, reason: collision with root package name */
        private boolean f5712a;

        public BaseBehavior() {
            this.f5712a = true;
        }

        private static boolean E(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.e) {
                return ((CoordinatorLayout.e) layoutParams).e() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private void F(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            throw null;
        }

        private boolean I(View view, FloatingActionButton floatingActionButton) {
            throw null;
        }

        private boolean J(View view, FloatingActionButton floatingActionButton) {
            if (I(view, floatingActionButton)) {
                throw null;
            }
            return false;
        }

        public boolean D(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            throw null;
        }

        public boolean G(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (!E(view)) {
                return false;
            }
            J(view, floatingActionButton);
            return false;
        }

        public boolean H(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i2) {
            List listQ = coordinatorLayout.q(floatingActionButton);
            int size = listQ.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = (View) listQ.get(i3);
                if (E(view) && J(view, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.G(floatingActionButton, i2);
            F(coordinatorLayout, floatingActionButton);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ boolean b(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
            F.a(view);
            return D(coordinatorLayout, null, rect);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public void g(CoordinatorLayout.e eVar) {
            if (eVar.f2830h == 0) {
                eVar.f2830h = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            F.a(view);
            return G(coordinatorLayout, null, view2);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ boolean l(CoordinatorLayout coordinatorLayout, View view, int i2) {
            F.a(view);
            return H(coordinatorLayout, null, i2);
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0337g.f7592I);
            this.f5712a = typedArrayObtainStyledAttributes.getBoolean(AbstractC0337g.f7594J, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
