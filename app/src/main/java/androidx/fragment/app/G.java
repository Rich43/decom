package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class G extends H {

    class a extends Transition.EpicenterCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Rect f3436a;

        a(Rect rect) {
            this.f3436a = rect;
        }

        @Override // android.transition.Transition.EpicenterCallback
        public Rect onGetEpicenter(Transition transition) {
            return this.f3436a;
        }
    }

    class b implements Transition.TransitionListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f3438a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f3439b;

        b(View view, ArrayList arrayList) {
            this.f3438a = view;
            this.f3439b = arrayList;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            f.b(transition, this);
            this.f3438a.setVisibility(8);
            int size = this.f3439b.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((View) this.f3439b.get(i2)).setVisibility(0);
            }
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            f.b(transition, this);
            f.a(transition, this);
        }
    }

    class c implements Transition.TransitionListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f3441a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f3442b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f3443c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f3444d;
        final /* synthetic */ Object e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f3445f;

        c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f3441a = obj;
            this.f3442b = arrayList;
            this.f3443c = obj2;
            this.f3444d = arrayList2;
            this.e = obj3;
            this.f3445f = arrayList3;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            f.b(transition, this);
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            Object obj = this.f3441a;
            if (obj != null) {
                G.this.w(obj, this.f3442b, null);
            }
            Object obj2 = this.f3443c;
            if (obj2 != null) {
                G.this.w(obj2, this.f3444d, null);
            }
            Object obj3 = this.e;
            if (obj3 != null) {
                G.this.w(obj3, this.f3445f, null);
            }
        }
    }

    class d implements Transition.TransitionListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f3447a;

        d(Runnable runnable) {
            this.f3447a = runnable;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            this.f3447a.run();
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
        }
    }

    class e extends Transition.EpicenterCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Rect f3449a;

        e(Rect rect) {
            this.f3449a = rect;
        }

        @Override // android.transition.Transition.EpicenterCallback
        public Rect onGetEpicenter(Transition transition) {
            Rect rect = this.f3449a;
            if (rect == null || rect.isEmpty()) {
                return null;
            }
            return this.f3449a;
        }
    }

    static class f {
        static void a(Transition transition, Transition.TransitionListener transitionListener) {
            transition.addListener(transitionListener);
        }

        static void b(Transition transition, Transition.TransitionListener transitionListener) {
            transition.removeListener(transitionListener);
        }
    }

    G() {
    }

    private static boolean v(Transition transition) {
        return (H.i(transition.getTargetIds()) && H.i(transition.getTargetNames()) && H.i(transition.getTargetTypes())) ? false : true;
    }

    @Override // androidx.fragment.app.H
    public void a(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).addTarget(view);
        }
    }

    @Override // androidx.fragment.app.H
    public void b(Object obj, ArrayList arrayList) {
        Transition transition = (Transition) obj;
        if (transition == null) {
            return;
        }
        int i2 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i2 < transitionCount) {
                b(transitionSet.getTransitionAt(i2), arrayList);
                i2++;
            }
            return;
        }
        if (v(transition) || !H.i(transition.getTargets())) {
            return;
        }
        int size = arrayList.size();
        while (i2 < size) {
            transition.addTarget((View) arrayList.get(i2));
            i2++;
        }
    }

    @Override // androidx.fragment.app.H
    public void c(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    @Override // androidx.fragment.app.H
    public boolean e(Object obj) {
        return obj instanceof Transition;
    }

    @Override // androidx.fragment.app.H
    public Object f(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.H
    public Object j(Object obj, Object obj2, Object obj3) {
        Transition ordering = (Transition) obj;
        Transition transition = (Transition) obj2;
        Transition transition2 = (Transition) obj3;
        if (ordering != null && transition != null) {
            ordering = new TransitionSet().addTransition(ordering).addTransition(transition).setOrdering(1);
        } else if (ordering == null) {
            ordering = transition != null ? transition : null;
        }
        if (transition2 == null) {
            return ordering;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (ordering != null) {
            transitionSet.addTransition(ordering);
        }
        transitionSet.addTransition(transition2);
        return transitionSet;
    }

    @Override // androidx.fragment.app.H
    public Object k(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.addTransition((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.addTransition((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.addTransition((Transition) obj3);
        }
        return transitionSet;
    }

    @Override // androidx.fragment.app.H
    public void m(Object obj, View view, ArrayList arrayList) {
        ((Transition) obj).addListener(new b(view, arrayList));
    }

    @Override // androidx.fragment.app.H
    public void n(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2, Object obj4, ArrayList arrayList3) {
        ((Transition) obj).addListener(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.H
    public void o(Object obj, Rect rect) {
        if (obj != null) {
            ((Transition) obj).setEpicenterCallback(new e(rect));
        }
    }

    @Override // androidx.fragment.app.H
    public void p(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            h(view, rect);
            ((Transition) obj).setEpicenterCallback(new a(rect));
        }
    }

    @Override // androidx.fragment.app.H
    public void q(Fragment fragment, Object obj, androidx.core.os.d dVar, Runnable runnable) {
        ((Transition) obj).addListener(new d(runnable));
    }

    @Override // androidx.fragment.app.H
    public void s(Object obj, View view, ArrayList arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List<View> targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            H.d(targets, (View) arrayList.get(i2));
        }
        targets.add(view);
        arrayList.add(view);
        b(transitionSet, arrayList);
    }

    @Override // androidx.fragment.app.H
    public void t(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.getTargets().clear();
            transitionSet.getTargets().addAll(arrayList2);
            w(transitionSet, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.H
    public Object u(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition((Transition) obj);
        return transitionSet;
    }

    public void w(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        List<View> targets;
        Transition transition = (Transition) obj;
        int i2 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i2 < transitionCount) {
                w(transitionSet.getTransitionAt(i2), arrayList, arrayList2);
                i2++;
            }
            return;
        }
        if (v(transition) || (targets = transition.getTargets()) == null || targets.size() != arrayList.size() || !targets.containsAll(arrayList)) {
            return;
        }
        int size = arrayList2 == null ? 0 : arrayList2.size();
        while (i2 < size) {
            transition.addTarget((View) arrayList2.get(i2));
            i2++;
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            transition.removeTarget((View) arrayList.get(size2));
        }
    }
}
