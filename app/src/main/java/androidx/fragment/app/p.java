package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
class p implements LayoutInflater.Factory2 {

    /* renamed from: a, reason: collision with root package name */
    final w f3574a;

    class a implements View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ C f3575a;

        a(C c2) {
            this.f3575a = c2;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Fragment fragmentK = this.f3575a.k();
            this.f3575a.m();
            K.n((ViewGroup) fragmentK.mView.getParent(), p.this.f3574a).j();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    p(w wVar) {
        this.f3574a = wVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        C cW;
        if (C0194l.class.getName().equals(str)) {
            return new C0194l(context, attributeSet, this.f3574a);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, E.c.f147a);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes.getString(E.c.f148b);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(E.c.f149c, -1);
        String string = typedArrayObtainStyledAttributes.getString(E.c.f150d);
        typedArrayObtainStyledAttributes.recycle();
        if (attributeValue == null || !n.b(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        Fragment fragmentH0 = resourceId != -1 ? this.f3574a.h0(resourceId) : null;
        if (fragmentH0 == null && string != null) {
            fragmentH0 = this.f3574a.i0(string);
        }
        if (fragmentH0 == null && id != -1) {
            fragmentH0 = this.f3574a.h0(id);
        }
        if (fragmentH0 == null) {
            fragmentH0 = this.f3574a.s0().a(context.getClassLoader(), attributeValue);
            fragmentH0.mFromLayout = true;
            fragmentH0.mFragmentId = resourceId != 0 ? resourceId : id;
            fragmentH0.mContainerId = id;
            fragmentH0.mTag = string;
            fragmentH0.mInLayout = true;
            w wVar = this.f3574a;
            fragmentH0.mFragmentManager = wVar;
            fragmentH0.mHost = wVar.u0();
            fragmentH0.onInflate(this.f3574a.u0().h(), attributeSet, fragmentH0.mSavedFragmentState);
            cW = this.f3574a.j(fragmentH0);
            if (w.H0(2)) {
                Log.v("FragmentManager", "Fragment " + fragmentH0 + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        } else {
            if (fragmentH0.mInLayout) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
            }
            fragmentH0.mInLayout = true;
            w wVar2 = this.f3574a;
            fragmentH0.mFragmentManager = wVar2;
            fragmentH0.mHost = wVar2.u0();
            fragmentH0.onInflate(this.f3574a.u0().h(), attributeSet, fragmentH0.mSavedFragmentState);
            cW = this.f3574a.w(fragmentH0);
            if (w.H0(2)) {
                Log.v("FragmentManager", "Retained Fragment " + fragmentH0 + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        }
        ViewGroup viewGroup = (ViewGroup) view;
        F.c.g(fragmentH0, viewGroup);
        fragmentH0.mContainer = viewGroup;
        cW.m();
        cW.j();
        View view2 = fragmentH0.mView;
        if (view2 == null) {
            throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        if (resourceId != 0) {
            view2.setId(resourceId);
        }
        if (fragmentH0.mView.getTag() == null) {
            fragmentH0.mView.setTag(string);
        }
        fragmentH0.mView.addOnAttachStateChangeListener(new a(cW));
        return fragmentH0.mView;
    }
}
