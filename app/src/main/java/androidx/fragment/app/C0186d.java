package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.os.d;
import androidx.core.view.S;
import androidx.fragment.app.AbstractC0192j;
import androidx.fragment.app.K;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import v.AbstractC0345h;

/* renamed from: androidx.fragment.app.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0186d extends K {

    /* renamed from: androidx.fragment.app.d$a */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3507a;

        static {
            int[] iArr = new int[K.e.c.values().length];
            f3507a = iArr;
            try {
                iArr[K.e.c.GONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3507a[K.e.c.INVISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3507a[K.e.c.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3507a[K.e.c.VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* renamed from: androidx.fragment.app.d$b */
    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f3508a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ K.e f3509b;

        b(List list, K.e eVar) {
            this.f3508a = list;
            this.f3509b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f3508a.contains(this.f3509b)) {
                this.f3508a.remove(this.f3509b);
                C0186d.this.s(this.f3509b);
            }
        }
    }

    /* renamed from: androidx.fragment.app.d$c */
    class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f3511a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f3512b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f3513c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ K.e f3514d;
        final /* synthetic */ k e;

        c(ViewGroup viewGroup, View view, boolean z2, K.e eVar, k kVar) {
            this.f3511a = viewGroup;
            this.f3512b = view;
            this.f3513c = z2;
            this.f3514d = eVar;
            this.e = kVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f3511a.endViewTransition(this.f3512b);
            if (this.f3513c) {
                this.f3514d.e().a(this.f3512b);
            }
            this.e.a();
            if (w.H0(2)) {
                Log.v("FragmentManager", "Animator from operation " + this.f3514d + " has ended.");
            }
        }
    }

    /* renamed from: androidx.fragment.app.d$d, reason: collision with other inner class name */
    class C0040d implements d.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Animator f3516a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ K.e f3517b;

        C0040d(Animator animator, K.e eVar) {
            this.f3516a = animator;
            this.f3517b = eVar;
        }

        @Override // androidx.core.os.d.a
        public void a() {
            this.f3516a.end();
            if (w.H0(2)) {
                Log.v("FragmentManager", "Animator from operation " + this.f3517b + " has been canceled.");
            }
        }
    }

    /* renamed from: androidx.fragment.app.d$e */
    class e implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ K.e f3519a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f3520b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f3521c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ k f3522d;

        /* renamed from: androidx.fragment.app.d$e$a */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                eVar.f3520b.endViewTransition(eVar.f3521c);
                e.this.f3522d.a();
            }
        }

        e(K.e eVar, ViewGroup viewGroup, View view, k kVar) {
            this.f3519a = eVar;
            this.f3520b = viewGroup;
            this.f3521c = view;
            this.f3522d = kVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f3520b.post(new a());
            if (w.H0(2)) {
                Log.v("FragmentManager", "Animation from operation " + this.f3519a + " has ended.");
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (w.H0(2)) {
                Log.v("FragmentManager", "Animation from operation " + this.f3519a + " has reached onAnimationStart.");
            }
        }
    }

    /* renamed from: androidx.fragment.app.d$f */
    class f implements d.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f3524a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f3525b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f3526c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ K.e f3527d;

        f(View view, ViewGroup viewGroup, k kVar, K.e eVar) {
            this.f3524a = view;
            this.f3525b = viewGroup;
            this.f3526c = kVar;
            this.f3527d = eVar;
        }

        @Override // androidx.core.os.d.a
        public void a() {
            this.f3524a.clearAnimation();
            this.f3525b.endViewTransition(this.f3524a);
            this.f3526c.a();
            if (w.H0(2)) {
                Log.v("FragmentManager", "Animation from operation " + this.f3527d + " has been cancelled.");
            }
        }
    }

    /* renamed from: androidx.fragment.app.d$g */
    class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ K.e f3528a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ K.e f3529b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f3530c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ androidx.collection.a f3531d;

        g(K.e eVar, K.e eVar2, boolean z2, androidx.collection.a aVar) {
            this.f3528a = eVar;
            this.f3529b = eVar2;
            this.f3530c = z2;
            this.f3531d = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            F.a(this.f3528a.f(), this.f3529b.f(), this.f3530c, this.f3531d, false);
        }
    }

    /* renamed from: androidx.fragment.app.d$h */
    class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ H f3532a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f3533b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Rect f3534c;

        h(H h2, View view, Rect rect) {
            this.f3532a = h2;
            this.f3533b = view;
            this.f3534c = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3532a.h(this.f3533b, this.f3534c);
        }
    }

    /* renamed from: androidx.fragment.app.d$i */
    class i implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f3536a;

        i(ArrayList arrayList) {
            this.f3536a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            F.d(this.f3536a, 4);
        }
    }

    /* renamed from: androidx.fragment.app.d$j */
    class j implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ m f3538a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ K.e f3539b;

        j(m mVar, K.e eVar) {
            this.f3538a = mVar;
            this.f3539b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3538a.a();
            if (w.H0(2)) {
                Log.v("FragmentManager", "Transition for operation " + this.f3539b + "has completed");
            }
        }
    }

    /* renamed from: androidx.fragment.app.d$k */
    private static class k extends l {

        /* renamed from: c, reason: collision with root package name */
        private boolean f3541c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f3542d;
        private AbstractC0192j.a e;

        k(K.e eVar, androidx.core.os.d dVar, boolean z2) {
            super(eVar, dVar);
            this.f3542d = false;
            this.f3541c = z2;
        }

        AbstractC0192j.a e(Context context) throws Resources.NotFoundException {
            if (this.f3542d) {
                return this.e;
            }
            AbstractC0192j.a aVarB = AbstractC0192j.b(context, b().f(), b().e() == K.e.c.VISIBLE, this.f3541c);
            this.e = aVarB;
            this.f3542d = true;
            return aVarB;
        }
    }

    /* renamed from: androidx.fragment.app.d$l */
    private static class l {

        /* renamed from: a, reason: collision with root package name */
        private final K.e f3543a;

        /* renamed from: b, reason: collision with root package name */
        private final androidx.core.os.d f3544b;

        l(K.e eVar, androidx.core.os.d dVar) {
            this.f3543a = eVar;
            this.f3544b = dVar;
        }

        void a() {
            this.f3543a.d(this.f3544b);
        }

        K.e b() {
            return this.f3543a;
        }

        androidx.core.os.d c() {
            return this.f3544b;
        }

        boolean d() {
            K.e.c cVar;
            K.e.c cVarC = K.e.c.c(this.f3543a.f().mView);
            K.e.c cVarE = this.f3543a.e();
            return cVarC == cVarE || !(cVarC == (cVar = K.e.c.VISIBLE) || cVarE == cVar);
        }
    }

    /* renamed from: androidx.fragment.app.d$m */
    private static class m extends l {

        /* renamed from: c, reason: collision with root package name */
        private final Object f3545c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f3546d;
        private final Object e;

        m(K.e eVar, androidx.core.os.d dVar, boolean z2, boolean z3) {
            super(eVar, dVar);
            if (eVar.e() == K.e.c.VISIBLE) {
                this.f3545c = z2 ? eVar.f().getReenterTransition() : eVar.f().getEnterTransition();
                this.f3546d = z2 ? eVar.f().getAllowReturnTransitionOverlap() : eVar.f().getAllowEnterTransitionOverlap();
            } else {
                this.f3545c = z2 ? eVar.f().getReturnTransition() : eVar.f().getExitTransition();
                this.f3546d = true;
            }
            if (!z3) {
                this.e = null;
            } else if (z2) {
                this.e = eVar.f().getSharedElementReturnTransition();
            } else {
                this.e = eVar.f().getSharedElementEnterTransition();
            }
        }

        private H f(Object obj) {
            if (obj == null) {
                return null;
            }
            H h2 = F.f3397a;
            if (h2 != null && h2.e(obj)) {
                return h2;
            }
            H h3 = F.f3398b;
            if (h3 != null && h3.e(obj)) {
                return h3;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + b().f() + " is not a valid framework Transition or AndroidX Transition");
        }

        H e() {
            H hF = f(this.f3545c);
            H hF2 = f(this.e);
            if (hF == null || hF2 == null || hF == hF2) {
                return hF != null ? hF : hF2;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + b().f() + " returned Transition " + this.f3545c + " which uses a different Transition  type than its shared element transition " + this.e);
        }

        public Object g() {
            return this.e;
        }

        Object h() {
            return this.f3545c;
        }

        public boolean i() {
            return this.e != null;
        }

        boolean j() {
            return this.f3546d;
        }
    }

    C0186d(ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void w(List list, List list2, boolean z2, Map map) throws Resources.NotFoundException {
        int i2;
        boolean z3;
        Context context;
        View view;
        K.e eVar;
        ViewGroup viewGroupM = m();
        Context context2 = viewGroupM.getContext();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        boolean z4 = false;
        while (true) {
            i2 = 2;
            if (!it.hasNext()) {
                break;
            }
            k kVar = (k) it.next();
            if (kVar.d()) {
                kVar.a();
            } else {
                AbstractC0192j.a aVarE = kVar.e(context2);
                if (aVarE == null) {
                    kVar.a();
                } else {
                    Animator animator = aVarE.f3558b;
                    if (animator == null) {
                        arrayList.add(kVar);
                    } else {
                        K.e eVarB = kVar.b();
                        Fragment fragmentF = eVarB.f();
                        if (Boolean.TRUE.equals(map.get(eVarB))) {
                            if (w.H0(2)) {
                                Log.v("FragmentManager", "Ignoring Animator set on " + fragmentF + " as this Fragment was involved in a Transition.");
                            }
                            kVar.a();
                        } else {
                            boolean z5 = eVarB.e() == K.e.c.GONE;
                            if (z5) {
                                list2.remove(eVarB);
                            }
                            View view2 = fragmentF.mView;
                            viewGroupM.startViewTransition(view2);
                            animator.addListener(new c(viewGroupM, view2, z5, eVarB, kVar));
                            animator.setTarget(view2);
                            animator.start();
                            if (w.H0(2)) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Animator from operation ");
                                eVar = eVarB;
                                sb.append(eVar);
                                sb.append(" has started.");
                                Log.v("FragmentManager", sb.toString());
                            } else {
                                eVar = eVarB;
                            }
                            kVar.c().b(new C0040d(animator, eVar));
                            z4 = true;
                        }
                    }
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            k kVar2 = (k) it2.next();
            K.e eVarB2 = kVar2.b();
            Fragment fragmentF2 = eVarB2.f();
            if (z2) {
                if (w.H0(i2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + fragmentF2 + " as Animations cannot run alongside Transitions.");
                }
                kVar2.a();
            } else if (z4) {
                if (w.H0(i2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + fragmentF2 + " as Animations cannot run alongside Animators.");
                }
                kVar2.a();
            } else {
                View view3 = fragmentF2.mView;
                Animation animation = (Animation) AbstractC0345h.f(((AbstractC0192j.a) AbstractC0345h.f(kVar2.e(context2))).f3557a);
                if (eVarB2.e() != K.e.c.REMOVED) {
                    view3.startAnimation(animation);
                    kVar2.a();
                    z3 = z4;
                    context = context2;
                    view = view3;
                } else {
                    viewGroupM.startViewTransition(view3);
                    AbstractC0192j.b bVar = new AbstractC0192j.b(animation, viewGroupM, view3);
                    z3 = z4;
                    context = context2;
                    view = view3;
                    bVar.setAnimationListener(new e(eVarB2, viewGroupM, view3, kVar2));
                    view.startAnimation(bVar);
                    if (w.H0(2)) {
                        Log.v("FragmentManager", "Animation from operation " + eVarB2 + " has started.");
                    }
                }
                kVar2.c().b(new f(view, viewGroupM, kVar2, eVarB2));
                z4 = z3;
                context2 = context;
                i2 = 2;
            }
        }
    }

    private Map x(List list, List list2, boolean z2, K.e eVar, K.e eVar2) {
        String str;
        String str2;
        String str3;
        View view;
        Object obj;
        ArrayList arrayList;
        Object obj2;
        ArrayList arrayList2;
        HashMap map;
        View view2;
        Object objK;
        androidx.collection.a aVar;
        ArrayList arrayList3;
        K.e eVar3;
        ArrayList arrayList4;
        Rect rect;
        H h2;
        HashMap map2;
        K.e eVar4;
        View view3;
        View view4;
        View view5;
        boolean z3 = z2;
        K.e eVar5 = eVar;
        K.e eVar6 = eVar2;
        HashMap map3 = new HashMap();
        Iterator it = list.iterator();
        H h3 = null;
        while (it.hasNext()) {
            m mVar = (m) it.next();
            if (!mVar.d()) {
                H hE = mVar.e();
                if (h3 == null) {
                    h3 = hE;
                } else if (hE != null && h3 != hE) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + mVar.b().f() + " returned Transition " + mVar.h() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (h3 == null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                m mVar2 = (m) it2.next();
                map3.put(mVar2.b(), Boolean.FALSE);
                mVar2.a();
            }
            return map3;
        }
        View view6 = new View(m().getContext());
        Rect rect2 = new Rect();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        androidx.collection.a aVar2 = new androidx.collection.a();
        Iterator it3 = list.iterator();
        Object obj3 = null;
        View view7 = null;
        boolean z4 = false;
        while (true) {
            str = "FragmentManager";
            if (!it3.hasNext()) {
                break;
            }
            m mVar3 = (m) it3.next();
            if (!mVar3.i() || eVar5 == null || eVar6 == null) {
                aVar = aVar2;
                arrayList3 = arrayList6;
                eVar3 = eVar5;
                arrayList4 = arrayList5;
                rect = rect2;
                h2 = h3;
                map2 = map3;
                View view8 = view6;
                eVar4 = eVar6;
                view3 = view8;
                view7 = view7;
            } else {
                Object objU = h3.u(h3.f(mVar3.g()));
                ArrayList<String> sharedElementSourceNames = eVar2.f().getSharedElementSourceNames();
                ArrayList<String> sharedElementSourceNames2 = eVar.f().getSharedElementSourceNames();
                ArrayList<String> sharedElementTargetNames = eVar.f().getSharedElementTargetNames();
                View view9 = view7;
                int i2 = 0;
                while (i2 < sharedElementTargetNames.size()) {
                    int iIndexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i2));
                    ArrayList<String> arrayList7 = sharedElementTargetNames;
                    if (iIndexOf != -1) {
                        sharedElementSourceNames.set(iIndexOf, sharedElementSourceNames2.get(i2));
                    }
                    i2++;
                    sharedElementTargetNames = arrayList7;
                }
                ArrayList<String> sharedElementTargetNames2 = eVar2.f().getSharedElementTargetNames();
                if (z3) {
                    eVar.f().getEnterTransitionCallback();
                    eVar2.f().getExitTransitionCallback();
                } else {
                    eVar.f().getExitTransitionCallback();
                    eVar2.f().getEnterTransitionCallback();
                }
                int i3 = 0;
                for (int size = sharedElementSourceNames.size(); i3 < size; size = size) {
                    aVar2.put(sharedElementSourceNames.get(i3), sharedElementTargetNames2.get(i3));
                    i3++;
                }
                if (w.H0(2)) {
                    Log.v("FragmentManager", ">>> entering view names <<<");
                    for (Iterator<String> it4 = sharedElementTargetNames2.iterator(); it4.hasNext(); it4 = it4) {
                        Log.v("FragmentManager", "Name: " + it4.next());
                    }
                    Log.v("FragmentManager", ">>> exiting view names <<<");
                    for (Iterator<String> it5 = sharedElementSourceNames.iterator(); it5.hasNext(); it5 = it5) {
                        Log.v("FragmentManager", "Name: " + it5.next());
                    }
                }
                androidx.collection.a aVar3 = new androidx.collection.a();
                u(aVar3, eVar.f().mView);
                aVar3.retainAll(sharedElementSourceNames);
                aVar2.retainAll(aVar3.keySet());
                androidx.collection.a aVar4 = new androidx.collection.a();
                u(aVar4, eVar2.f().mView);
                aVar4.retainAll(sharedElementTargetNames2);
                aVar4.retainAll(aVar2.values());
                F.c(aVar2, aVar4);
                v(aVar3, aVar2.keySet());
                v(aVar4, aVar2.values());
                if (aVar2.isEmpty()) {
                    arrayList5.clear();
                    arrayList6.clear();
                    aVar = aVar2;
                    arrayList3 = arrayList6;
                    eVar3 = eVar5;
                    arrayList4 = arrayList5;
                    rect = rect2;
                    view3 = view6;
                    h2 = h3;
                    view7 = view9;
                    obj3 = null;
                    eVar4 = eVar2;
                    map2 = map3;
                } else {
                    F.a(eVar2.f(), eVar.f(), z3, aVar3, true);
                    HashMap map4 = map3;
                    View view10 = view6;
                    aVar = aVar2;
                    ArrayList arrayList8 = arrayList6;
                    androidx.core.view.I.a(m(), new g(eVar2, eVar, z2, aVar4));
                    arrayList5.addAll(aVar3.values());
                    if (sharedElementSourceNames.isEmpty()) {
                        view7 = view9;
                    } else {
                        view7 = (View) aVar3.get((String) sharedElementSourceNames.get(0));
                        h3.p(objU, view7);
                    }
                    arrayList3 = arrayList8;
                    arrayList3.addAll(aVar4.values());
                    if (sharedElementTargetNames2.isEmpty() || (view5 = (View) aVar4.get((String) sharedElementTargetNames2.get(0))) == null) {
                        view4 = view10;
                    } else {
                        androidx.core.view.I.a(m(), new h(h3, view5, rect2));
                        view4 = view10;
                        z4 = true;
                    }
                    h3.s(objU, view4, arrayList5);
                    arrayList4 = arrayList5;
                    rect = rect2;
                    view3 = view4;
                    h2 = h3;
                    h3.n(objU, null, null, null, null, objU, arrayList3);
                    Boolean bool = Boolean.TRUE;
                    eVar3 = eVar;
                    map2 = map4;
                    map2.put(eVar3, bool);
                    eVar4 = eVar2;
                    map2.put(eVar4, bool);
                    obj3 = objU;
                }
            }
            eVar5 = eVar3;
            arrayList5 = arrayList4;
            rect2 = rect;
            map3 = map2;
            aVar2 = aVar;
            z3 = z2;
            arrayList6 = arrayList3;
            h3 = h2;
            K.e eVar7 = eVar4;
            view6 = view3;
            eVar6 = eVar7;
        }
        View view11 = view7;
        androidx.collection.a aVar5 = aVar2;
        ArrayList arrayList9 = arrayList6;
        K.e eVar8 = eVar5;
        ArrayList arrayList10 = arrayList5;
        Rect rect3 = rect2;
        H h4 = h3;
        HashMap map5 = map3;
        View view12 = view6;
        K.e eVar9 = eVar6;
        View view13 = view12;
        ArrayList arrayList11 = new ArrayList();
        Iterator it6 = list.iterator();
        Object obj4 = null;
        Object objK2 = null;
        while (it6.hasNext()) {
            m mVar4 = (m) it6.next();
            if (mVar4.d()) {
                map5.put(mVar4.b(), Boolean.FALSE);
                mVar4.a();
            } else {
                Object objF = h4.f(mVar4.h());
                K.e eVarB = mVar4.b();
                boolean z5 = obj3 != null && (eVarB == eVar8 || eVarB == eVar9);
                if (objF == null) {
                    if (!z5) {
                        map5.put(eVarB, Boolean.FALSE);
                        mVar4.a();
                    }
                    arrayList2 = arrayList9;
                    str3 = str;
                    arrayList = arrayList10;
                    view = view13;
                    objK = obj4;
                    map = map5;
                    view2 = view11;
                } else {
                    str3 = str;
                    ArrayList arrayList12 = new ArrayList();
                    Object obj5 = obj4;
                    t(arrayList12, eVarB.f().mView);
                    if (z5) {
                        if (eVarB == eVar8) {
                            arrayList12.removeAll(arrayList10);
                        } else {
                            arrayList12.removeAll(arrayList9);
                        }
                    }
                    if (arrayList12.isEmpty()) {
                        h4.a(objF, view13);
                        arrayList2 = arrayList9;
                        arrayList = arrayList10;
                        view = view13;
                        obj2 = objK2;
                        map = map5;
                        obj = obj5;
                    } else {
                        h4.b(objF, arrayList12);
                        view = view13;
                        obj = obj5;
                        arrayList = arrayList10;
                        obj2 = objK2;
                        arrayList2 = arrayList9;
                        map = map5;
                        h4.n(objF, objF, arrayList12, null, null, null, null);
                        if (eVarB.e() == K.e.c.GONE) {
                            list2.remove(eVarB);
                            ArrayList arrayList13 = new ArrayList(arrayList12);
                            arrayList13.remove(eVarB.f().mView);
                            h4.m(objF, eVarB.f().mView, arrayList13);
                            androidx.core.view.I.a(m(), new i(arrayList12));
                        }
                    }
                    if (eVarB.e() == K.e.c.VISIBLE) {
                        arrayList11.addAll(arrayList12);
                        if (z4) {
                            h4.o(objF, rect3);
                        }
                        view2 = view11;
                    } else {
                        view2 = view11;
                        h4.p(objF, view2);
                    }
                    map.put(eVarB, Boolean.TRUE);
                    if (mVar4.j()) {
                        objK2 = h4.k(obj2, objF, null);
                        objK = obj;
                    } else {
                        objK = h4.k(obj, objF, null);
                        objK2 = obj2;
                    }
                }
                eVar9 = eVar2;
                map5 = map;
                obj4 = objK;
                view11 = view2;
                str = str3;
                view13 = view;
                arrayList10 = arrayList;
                arrayList9 = arrayList2;
            }
        }
        ArrayList arrayList14 = arrayList9;
        String str4 = str;
        ArrayList arrayList15 = arrayList10;
        HashMap map6 = map5;
        Object objJ = h4.j(objK2, obj4, obj3);
        if (objJ == null) {
            return map6;
        }
        Iterator it7 = list.iterator();
        while (it7.hasNext()) {
            m mVar5 = (m) it7.next();
            if (!mVar5.d()) {
                Object objH = mVar5.h();
                K.e eVarB2 = mVar5.b();
                HashMap map7 = map6;
                boolean z6 = obj3 != null && (eVarB2 == eVar8 || eVarB2 == eVar2);
                if (objH == null && !z6) {
                    str2 = str4;
                } else if (androidx.core.view.M.O(m())) {
                    str2 = str4;
                    h4.q(mVar5.b().f(), objJ, mVar5.c(), new j(mVar5, eVarB2));
                } else {
                    if (w.H0(2)) {
                        str2 = str4;
                        Log.v(str2, "SpecialEffectsController: Container " + m() + " has not been laid out. Completing operation " + eVarB2);
                    } else {
                        str2 = str4;
                    }
                    mVar5.a();
                }
                map6 = map7;
                str4 = str2;
            }
        }
        HashMap map8 = map6;
        String str5 = str4;
        if (!androidx.core.view.M.O(m())) {
            return map8;
        }
        F.d(arrayList11, 4);
        ArrayList arrayListL = h4.l(arrayList14);
        if (w.H0(2)) {
            Log.v(str5, ">>>>> Beginning transition <<<<<");
            Log.v(str5, ">>>>> SharedElementFirstOutViews <<<<<");
            Iterator it8 = arrayList15.iterator();
            while (it8.hasNext()) {
                View view14 = (View) it8.next();
                Log.v(str5, "View: " + view14 + " Name: " + androidx.core.view.M.G(view14));
            }
            Log.v(str5, ">>>>> SharedElementLastInViews <<<<<");
            Iterator it9 = arrayList14.iterator();
            while (it9.hasNext()) {
                View view15 = (View) it9.next();
                Log.v(str5, "View: " + view15 + " Name: " + androidx.core.view.M.G(view15));
            }
        }
        h4.c(m(), objJ);
        h4.r(m(), arrayList15, arrayList14, arrayListL, aVar5);
        F.d(arrayList11, 0);
        h4.t(obj3, arrayList15, arrayList14);
        return map8;
    }

    private void y(List list) {
        Fragment fragmentF = ((K.e) list.get(list.size() - 1)).f();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            K.e eVar = (K.e) it.next();
            eVar.f().mAnimationInfo.f3418c = fragmentF.mAnimationInfo.f3418c;
            eVar.f().mAnimationInfo.f3419d = fragmentF.mAnimationInfo.f3419d;
            eVar.f().mAnimationInfo.e = fragmentF.mAnimationInfo.e;
            eVar.f().mAnimationInfo.f3420f = fragmentF.mAnimationInfo.f3420f;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a8  */
    @Override // androidx.fragment.app.K
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void f(java.util.List r14, boolean r15) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0186d.f(java.util.List, boolean):void");
    }

    void s(K.e eVar) {
        eVar.e().a(eVar.f().mView);
    }

    void t(ArrayList arrayList, View view) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (S.a(viewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                t(arrayList, childAt);
            }
        }
    }

    void u(Map map, View view) {
        String strG = androidx.core.view.M.G(view);
        if (strG != null) {
            map.put(strG, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt.getVisibility() == 0) {
                    u(map, childAt);
                }
            }
        }
    }

    void v(androidx.collection.a aVar, Collection collection) {
        Iterator<Map.Entry<Object, Object>> it = aVar.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(androidx.core.view.M.G((View) it.next().getValue()))) {
                it.remove();
            }
        }
    }
}
