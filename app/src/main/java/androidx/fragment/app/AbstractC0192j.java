package androidx.fragment.app;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

/* renamed from: androidx.fragment.app.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract class AbstractC0192j {
    private static int a(Fragment fragment, boolean z2, boolean z3) {
        return z3 ? z2 ? fragment.getPopEnterAnim() : fragment.getPopExitAnim() : z2 ? fragment.getEnterAnim() : fragment.getExitAnim();
    }

    static a b(Context context, Fragment fragment, boolean z2, boolean z3) throws Resources.NotFoundException {
        int nextTransition = fragment.getNextTransition();
        int iA = a(fragment, z2, z3);
        fragment.setAnimations(0, 0, 0, 0);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            int i2 = E.b.f146c;
            if (viewGroup.getTag(i2) != null) {
                fragment.mContainer.setTag(i2, null);
            }
        }
        ViewGroup viewGroup2 = fragment.mContainer;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation animationOnCreateAnimation = fragment.onCreateAnimation(nextTransition, z2, iA);
        if (animationOnCreateAnimation != null) {
            return new a(animationOnCreateAnimation);
        }
        Animator animatorOnCreateAnimator = fragment.onCreateAnimator(nextTransition, z2, iA);
        if (animatorOnCreateAnimator != null) {
            return new a(animatorOnCreateAnimator);
        }
        if (iA == 0 && nextTransition != 0) {
            iA = d(context, nextTransition, z2);
        }
        if (iA != 0) {
            boolean zEquals = "anim".equals(context.getResources().getResourceTypeName(iA));
            if (zEquals) {
                try {
                    Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, iA);
                    if (animationLoadAnimation != null) {
                        return new a(animationLoadAnimation);
                    }
                } catch (Resources.NotFoundException e) {
                    throw e;
                } catch (RuntimeException unused) {
                }
            } else {
                try {
                    Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, iA);
                    if (animatorLoadAnimator != null) {
                        return new a(animatorLoadAnimator);
                    }
                } catch (RuntimeException e2) {
                    if (zEquals) {
                        throw e2;
                    }
                    Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, iA);
                    if (animationLoadAnimation2 != null) {
                        return new a(animationLoadAnimation2);
                    }
                }
            }
        }
        return null;
    }

    private static int c(Context context, int i2) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(R.style.Animation.Activity, new int[]{i2});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    private static int d(Context context, int i2, boolean z2) {
        if (i2 == 4097) {
            return z2 ? E.a.e : E.a.f143f;
        }
        if (i2 == 8194) {
            return z2 ? E.a.f139a : E.a.f140b;
        }
        if (i2 == 8197) {
            return z2 ? c(context, R.attr.activityCloseEnterAnimation) : c(context, R.attr.activityCloseExitAnimation);
        }
        if (i2 == 4099) {
            return z2 ? E.a.f141c : E.a.f142d;
        }
        if (i2 != 4100) {
            return -1;
        }
        return z2 ? c(context, R.attr.activityOpenEnterAnimation) : c(context, R.attr.activityOpenExitAnimation);
    }

    /* renamed from: androidx.fragment.app.j$a */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Animation f3557a;

        /* renamed from: b, reason: collision with root package name */
        public final Animator f3558b;

        a(Animation animation) {
            this.f3557a = animation;
            this.f3558b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        a(Animator animator) {
            this.f3557a = null;
            this.f3558b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* renamed from: androidx.fragment.app.j$b */
    static class b extends AnimationSet implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final ViewGroup f3559a;

        /* renamed from: b, reason: collision with root package name */
        private final View f3560b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f3561c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f3562d;
        private boolean e;

        b(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.e = true;
            this.f3559a = viewGroup;
            this.f3560b = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j2, Transformation transformation) {
            this.e = true;
            if (this.f3561c) {
                return !this.f3562d;
            }
            if (!super.getTransformation(j2, transformation)) {
                this.f3561c = true;
                androidx.core.view.I.a(this.f3559a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f3561c || !this.e) {
                this.f3559a.endViewTransition(this.f3560b);
                this.f3562d = true;
            } else {
                this.e = false;
                this.f3559a.post(this);
            }
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j2, Transformation transformation, float f2) {
            this.e = true;
            if (this.f3561c) {
                return !this.f3562d;
            }
            if (!super.getTransformation(j2, transformation, f2)) {
                this.f3561c = true;
                androidx.core.view.I.a(this.f3559a, this);
            }
            return true;
        }
    }
}
