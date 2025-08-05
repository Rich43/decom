package O;

import O.l;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public abstract class F extends l {

    /* renamed from: K, reason: collision with root package name */
    private static final String[] f376K = {"android:visibility:visibility", "android:visibility:parent"};

    /* renamed from: J, reason: collision with root package name */
    private int f377J = 3;

    class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ v f378a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f379b;

        a(v vVar, View view) {
            this.f378a = vVar;
            this.f379b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f378a.c(this.f379b);
        }
    }

    private static class c {

        /* renamed from: a, reason: collision with root package name */
        boolean f386a;

        /* renamed from: b, reason: collision with root package name */
        boolean f387b;

        /* renamed from: c, reason: collision with root package name */
        int f388c;

        /* renamed from: d, reason: collision with root package name */
        int f389d;
        ViewGroup e;

        /* renamed from: f, reason: collision with root package name */
        ViewGroup f390f;

        c() {
        }
    }

    private void b0(s sVar) {
        sVar.f502a.put("android:visibility:visibility", Integer.valueOf(sVar.f503b.getVisibility()));
        sVar.f502a.put("android:visibility:parent", sVar.f503b.getParent());
        int[] iArr = new int[2];
        sVar.f503b.getLocationOnScreen(iArr);
        sVar.f502a.put("android:visibility:screenLocation", iArr);
    }

    private c c0(s sVar, s sVar2) {
        c cVar = new c();
        cVar.f386a = false;
        cVar.f387b = false;
        if (sVar == null || !sVar.f502a.containsKey("android:visibility:visibility")) {
            cVar.f388c = -1;
            cVar.e = null;
        } else {
            cVar.f388c = ((Integer) sVar.f502a.get("android:visibility:visibility")).intValue();
            cVar.e = (ViewGroup) sVar.f502a.get("android:visibility:parent");
        }
        if (sVar2 == null || !sVar2.f502a.containsKey("android:visibility:visibility")) {
            cVar.f389d = -1;
            cVar.f390f = null;
        } else {
            cVar.f389d = ((Integer) sVar2.f502a.get("android:visibility:visibility")).intValue();
            cVar.f390f = (ViewGroup) sVar2.f502a.get("android:visibility:parent");
        }
        if (sVar != null && sVar2 != null) {
            int i2 = cVar.f388c;
            int i3 = cVar.f389d;
            if (i2 == i3 && cVar.e == cVar.f390f) {
                return cVar;
            }
            if (i2 != i3) {
                if (i2 == 0) {
                    cVar.f387b = false;
                    cVar.f386a = true;
                } else if (i3 == 0) {
                    cVar.f387b = true;
                    cVar.f386a = true;
                }
            } else if (cVar.f390f == null) {
                cVar.f387b = false;
                cVar.f386a = true;
            } else if (cVar.e == null) {
                cVar.f387b = true;
                cVar.f386a = true;
            }
        } else if (sVar == null && cVar.f389d == 0) {
            cVar.f387b = true;
            cVar.f386a = true;
        } else if (sVar2 == null && cVar.f388c == 0) {
            cVar.f387b = false;
            cVar.f386a = true;
        }
        return cVar;
    }

    @Override // O.l
    public String[] C() {
        return f376K;
    }

    @Override // O.l
    public boolean E(s sVar, s sVar2) {
        if (sVar == null && sVar2 == null) {
            return false;
        }
        if (sVar != null && sVar2 != null && sVar2.f502a.containsKey("android:visibility:visibility") != sVar.f502a.containsKey("android:visibility:visibility")) {
            return false;
        }
        c cVarC0 = c0(sVar, sVar2);
        if (cVarC0.f386a) {
            return cVarC0.f388c == 0 || cVarC0.f389d == 0;
        }
        return false;
    }

    public Animator d0(ViewGroup viewGroup, s sVar, int i2, s sVar2, int i3) {
        if ((this.f377J & 1) != 1 || sVar2 == null) {
            return null;
        }
        if (sVar == null) {
            View view = (View) sVar2.f503b.getParent();
            if (c0(s(view, false), D(view, false)).f386a) {
                return null;
            }
        }
        return e0(viewGroup, sVar2.f503b, sVar, sVar2);
    }

    public abstract Animator e0(ViewGroup viewGroup, View view, s sVar, s sVar2);

    @Override // O.l
    public void f(s sVar) {
        b0(sVar);
    }

    public Animator f0(ViewGroup viewGroup, s sVar, int i2, s sVar2, int i3) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        int id;
        if ((this.f377J & 2) != 2) {
            return null;
        }
        View viewA = sVar != null ? sVar.f503b : null;
        View view = sVar2 != null ? sVar2.f503b : null;
        if (view == null || view.getParent() == null) {
            if (view != null) {
                viewA = view;
            } else {
                if (viewA != null) {
                    if (viewA.getParent() != null) {
                        if (viewA.getParent() instanceof View) {
                            View view2 = (View) viewA.getParent();
                            if (!c0(D(view2, true), s(view2, true)).f386a) {
                                viewA = r.a(viewGroup, viewA, view2);
                            } else if (view2.getParent() != null || (id = view2.getId()) == -1 || viewGroup.findViewById(id) == null || !this.f473w) {
                                viewA = null;
                            }
                        }
                    }
                }
                viewA = null;
                view = null;
            }
            view = null;
        } else if (i3 == 4 || viewA == view) {
            viewA = null;
        } else {
            if (!this.f473w) {
                viewA = r.a(viewGroup, viewA, (View) viewA.getParent());
            }
            view = null;
        }
        if (viewA == null || sVar == null) {
            if (view == null) {
                return null;
            }
            int visibility = view.getVisibility();
            A.i(view, 0);
            Animator animatorG0 = g0(viewGroup, view, sVar, sVar2);
            if (animatorG0 != null) {
                b bVar = new b(view, i3, true);
                animatorG0.addListener(bVar);
                AbstractC0105a.a(animatorG0, bVar);
                a(bVar);
            } else {
                A.i(view, visibility);
            }
            return animatorG0;
        }
        int[] iArr = (int[]) sVar.f502a.get("android:visibility:screenLocation");
        int i4 = iArr[0];
        int i5 = iArr[1];
        int[] iArr2 = new int[2];
        viewGroup.getLocationOnScreen(iArr2);
        viewA.offsetLeftAndRight((i4 - iArr2[0]) - viewA.getLeft());
        viewA.offsetTopAndBottom((i5 - iArr2[1]) - viewA.getTop());
        v vVarA = w.a(viewGroup);
        vVarA.a(viewA);
        Animator animatorG02 = g0(viewGroup, viewA, sVar, sVar2);
        if (animatorG02 == null) {
            vVarA.c(viewA);
        } else {
            animatorG02.addListener(new a(vVarA, viewA));
        }
        return animatorG02;
    }

    public abstract Animator g0(ViewGroup viewGroup, View view, s sVar, s sVar2);

    public void h0(int i2) {
        if ((i2 & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.f377J = i2;
    }

    @Override // O.l
    public void i(s sVar) {
        b0(sVar);
    }

    @Override // O.l
    public Animator m(ViewGroup viewGroup, s sVar, s sVar2) {
        c cVarC0 = c0(sVar, sVar2);
        if (!cVarC0.f386a) {
            return null;
        }
        if (cVarC0.e == null && cVarC0.f390f == null) {
            return null;
        }
        return cVarC0.f387b ? d0(viewGroup, sVar, cVarC0.f388c, sVar2, cVarC0.f389d) : f0(viewGroup, sVar, cVarC0.f388c, sVar2, cVarC0.f389d);
    }

    private static class b extends AnimatorListenerAdapter implements l.f {

        /* renamed from: a, reason: collision with root package name */
        private final View f381a;

        /* renamed from: b, reason: collision with root package name */
        private final int f382b;

        /* renamed from: c, reason: collision with root package name */
        private final ViewGroup f383c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f384d;
        private boolean e;

        /* renamed from: f, reason: collision with root package name */
        boolean f385f = false;

        b(View view, int i2, boolean z2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            this.f381a = view;
            this.f382b = i2;
            this.f383c = (ViewGroup) view.getParent();
            this.f384d = z2;
            f(true);
        }

        private void e() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (!this.f385f) {
                A.i(this.f381a, this.f382b);
                ViewGroup viewGroup = this.f383c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            f(false);
        }

        private void f(boolean z2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            ViewGroup viewGroup;
            if (!this.f384d || this.e == z2 || (viewGroup = this.f383c) == null) {
                return;
            }
            this.e = z2;
            w.b(viewGroup, z2);
        }

        @Override // O.l.f
        public void a(l lVar) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            f(false);
        }

        @Override // O.l.f
        public void b(l lVar) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            e();
            lVar.O(this);
        }

        @Override // O.l.f
        public void d(l lVar) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            f(true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f385f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            e();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
            if (this.f385f) {
                return;
            }
            A.i(this.f381a, this.f382b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
            if (this.f385f) {
                return;
            }
            A.i(this.f381a, 0);
        }

        @Override // O.l.f
        public void c(l lVar) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
