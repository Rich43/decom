package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class V {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference f3119a;

    class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ W f3120a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f3121b;

        a(W w2, View view) {
            this.f3120a = w2;
            this.f3121b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f3120a.c(this.f3121b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f3120a.a(this.f3121b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f3120a.b(this.f3121b);
        }
    }

    V(View view) {
        this.f3119a = new WeakReference(view);
    }

    private void i(View view, W w2) {
        if (w2 != null) {
            view.animate().setListener(new a(w2, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public V b(float f2) {
        View view = (View) this.f3119a.get();
        if (view != null) {
            view.animate().alpha(f2);
        }
        return this;
    }

    public void c() {
        View view = (View) this.f3119a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long d() {
        View view = (View) this.f3119a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public V f(long j2) {
        View view = (View) this.f3119a.get();
        if (view != null) {
            view.animate().setDuration(j2);
        }
        return this;
    }

    public V g(Interpolator interpolator) {
        View view = (View) this.f3119a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public V h(W w2) {
        View view = (View) this.f3119a.get();
        if (view != null) {
            i(view, w2);
        }
        return this;
    }

    public V j(long j2) {
        View view = (View) this.f3119a.get();
        if (view != null) {
            view.animate().setStartDelay(j2);
        }
        return this;
    }

    public V k(final Y y2) {
        final View view = (View) this.f3119a.get();
        if (view != null) {
            view.animate().setUpdateListener(y2 != null ? new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.view.U
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    y2.a(view);
                }
            } : null);
        }
        return this;
    }

    public void l() {
        View view = (View) this.f3119a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public V m(float f2) {
        View view = (View) this.f3119a.get();
        if (view != null) {
            view.animate().translationY(f2);
        }
        return this;
    }
}
