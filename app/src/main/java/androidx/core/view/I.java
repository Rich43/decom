package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: classes.dex */
public final class I implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    private final View f3087a;

    /* renamed from: b, reason: collision with root package name */
    private ViewTreeObserver f3088b;

    /* renamed from: c, reason: collision with root package name */
    private final Runnable f3089c;

    private I(View view, Runnable runnable) {
        this.f3087a = view;
        this.f3088b = view.getViewTreeObserver();
        this.f3089c = runnable;
    }

    public static I a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        I i2 = new I(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(i2);
        view.addOnAttachStateChangeListener(i2);
        return i2;
    }

    public void b() {
        if (this.f3088b.isAlive()) {
            this.f3088b.removeOnPreDrawListener(this);
        } else {
            this.f3087a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f3087a.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.f3089c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f3088b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
