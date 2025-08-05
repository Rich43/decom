package O;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.M;

/* renamed from: O.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0108d extends F {

    /* renamed from: O.d$a */
    class a extends m {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f426a;

        a(View view) {
            this.f426a = view;
        }

        @Override // O.l.f
        public void b(l lVar) {
            A.h(this.f426a, 1.0f);
            A.a(this.f426a);
            lVar.O(this);
        }
    }

    /* renamed from: O.d$b */
    private static class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final View f428a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f429b = false;

        b(View view) {
            this.f428a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            A.h(this.f428a, 1.0f);
            if (this.f429b) {
                this.f428a.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (M.K(this.f428a) && this.f428a.getLayerType() == 0) {
                this.f429b = true;
                this.f428a.setLayerType(2, null);
            }
        }
    }

    public C0108d(int i2) {
        h0(i2);
    }

    private Animator i0(View view, float f2, float f3) {
        if (f2 == f3) {
            return null;
        }
        A.h(view, f2);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) A.f366d, f3);
        objectAnimatorOfFloat.addListener(new b(view));
        a(new a(view));
        return objectAnimatorOfFloat;
    }

    private static float j0(s sVar, float f2) {
        Float f3;
        return (sVar == null || (f3 = (Float) sVar.f502a.get("android:fade:transitionAlpha")) == null) ? f2 : f3.floatValue();
    }

    @Override // O.F
    public Animator e0(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        float fJ0 = j0(sVar, 0.0f);
        return i0(view, fJ0 != 1.0f ? fJ0 : 0.0f, 1.0f);
    }

    @Override // O.F
    public Animator g0(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        A.f(view);
        return i0(view, j0(sVar, 1.0f), 0.0f);
    }

    @Override // O.F, O.l
    public void i(s sVar) {
        super.i(sVar);
        sVar.f502a.put("android:fade:transitionAlpha", Float.valueOf(A.d(sVar.f503b)));
    }
}
