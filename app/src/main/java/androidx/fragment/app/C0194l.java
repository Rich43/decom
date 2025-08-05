package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.core.view.Z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: androidx.fragment.app.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0194l extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private final List f3563a;

    /* renamed from: b, reason: collision with root package name */
    private final List f3564b;

    /* renamed from: c, reason: collision with root package name */
    private View.OnApplyWindowInsetsListener f3565c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f3566d;

    /* renamed from: androidx.fragment.app.l$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f3567a = new a();

        private a() {
        }

        public final WindowInsets a(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener, View view, WindowInsets windowInsets) {
            i1.k.e(onApplyWindowInsetsListener, "onApplyWindowInsetsListener");
            i1.k.e(view, "v");
            i1.k.e(windowInsets, "insets");
            WindowInsets windowInsetsOnApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            i1.k.d(windowInsetsOnApplyWindowInsets, "onApplyWindowInsetsListe…lyWindowInsets(v, insets)");
            return windowInsetsOnApplyWindowInsets;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0194l(Context context, AttributeSet attributeSet, w wVar) {
        String str;
        super(context, attributeSet);
        i1.k.e(context, "context");
        i1.k.e(attributeSet, "attrs");
        i1.k.e(wVar, "fm");
        this.f3563a = new ArrayList();
        this.f3564b = new ArrayList();
        this.f3566d = true;
        String classAttribute = attributeSet.getClassAttribute();
        int[] iArr = E.c.e;
        i1.k.d(iArr, "FragmentContainerView");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        classAttribute = classAttribute == null ? typedArrayObtainStyledAttributes.getString(E.c.f151f) : classAttribute;
        String string = typedArrayObtainStyledAttributes.getString(E.c.f152g);
        typedArrayObtainStyledAttributes.recycle();
        int id = getId();
        Fragment fragmentH0 = wVar.h0(id);
        if (classAttribute != null && fragmentH0 == null) {
            if (id == -1) {
                if (string != null) {
                    str = " with tag " + string;
                } else {
                    str = "";
                }
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + classAttribute + str);
            }
            Fragment fragmentA = wVar.s0().a(context.getClassLoader(), classAttribute);
            i1.k.d(fragmentA, "fm.fragmentFactory.insta…ontext.classLoader, name)");
            fragmentA.onInflate(context, attributeSet, (Bundle) null);
            wVar.p().n(true).d(this, fragmentA, string).i();
        }
        wVar.Z0(this);
    }

    private final void a(View view) {
        if (this.f3564b.contains(view)) {
            this.f3563a.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        i1.k.e(view, "child");
        if (w.B0(view) != null) {
            super.addView(view, i2, layoutParams);
            return;
        }
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.").toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        Z zW;
        i1.k.e(windowInsets, "insets");
        Z zU = Z.u(windowInsets);
        i1.k.d(zU, "toWindowInsetsCompat(insets)");
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f3565c;
        if (onApplyWindowInsetsListener != null) {
            a aVar = a.f3567a;
            i1.k.b(onApplyWindowInsetsListener);
            zW = Z.u(aVar.a(onApplyWindowInsetsListener, this, windowInsets));
        } else {
            zW = androidx.core.view.M.W(this, zU);
        }
        i1.k.d(zW, "if (applyWindowInsetsLis…, insetsCompat)\n        }");
        if (!zW.n()) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                androidx.core.view.M.g(getChildAt(i2), zW);
            }
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        i1.k.e(canvas, "canvas");
        if (this.f3566d) {
            Iterator it = this.f3563a.iterator();
            while (it.hasNext()) {
                super.drawChild(canvas, (View) it.next(), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j2) {
        i1.k.e(canvas, "canvas");
        i1.k.e(view, "child");
        if (this.f3566d && !this.f3563a.isEmpty() && this.f3563a.contains(view)) {
            return false;
        }
        return super.drawChild(canvas, view, j2);
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(View view) {
        i1.k.e(view, "view");
        this.f3564b.remove(view);
        if (this.f3563a.remove(view)) {
            this.f3566d = true;
        }
        super.endViewTransition(view);
    }

    public final <F extends Fragment> F getFragment() {
        return (F) w.k0(this).h0(getId());
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        i1.k.e(windowInsets, "insets");
        return windowInsets;
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 >= childCount) {
                super.removeAllViewsInLayout();
                return;
            } else {
                View childAt = getChildAt(childCount);
                i1.k.d(childAt, "view");
                a(childAt);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        i1.k.e(view, "view");
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i2) {
        View childAt = getChildAt(i2);
        i1.k.d(childAt, "view");
        a(childAt);
        super.removeViewAt(i2);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        i1.k.e(view, "view");
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i2, int i3) {
        int i4 = i2 + i3;
        for (int i5 = i2; i5 < i4; i5++) {
            View childAt = getChildAt(i5);
            i1.k.d(childAt, "view");
            a(childAt);
        }
        super.removeViews(i2, i3);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i2, int i3) {
        int i4 = i2 + i3;
        for (int i5 = i2; i5 < i4; i5++) {
            View childAt = getChildAt(i5);
            i1.k.d(childAt, "view");
            a(childAt);
        }
        super.removeViewsInLayout(i2, i3);
    }

    public final void setDrawDisappearingViewsLast(boolean z2) {
        this.f3566d = z2;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        i1.k.e(onApplyWindowInsetsListener, "listener");
        this.f3565c = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(View view) {
        i1.k.e(view, "view");
        if (view.getParent() == this) {
            this.f3564b.add(view);
        }
        super.startViewTransition(view);
    }
}
