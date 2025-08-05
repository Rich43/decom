package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.view.M;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class c extends n {
    private static TimeInterpolator s;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList f4124h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    private ArrayList f4125i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    private ArrayList f4126j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    private ArrayList f4127k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    ArrayList f4128l = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    ArrayList f4129m = new ArrayList();

    /* renamed from: n, reason: collision with root package name */
    ArrayList f4130n = new ArrayList();
    ArrayList o = new ArrayList();

    /* renamed from: p, reason: collision with root package name */
    ArrayList f4131p = new ArrayList();

    /* renamed from: q, reason: collision with root package name */
    ArrayList f4132q = new ArrayList();
    ArrayList r = new ArrayList();

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f4133a;

        a(ArrayList arrayList) {
            this.f4133a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f4133a.iterator();
            while (it.hasNext()) {
                j jVar = (j) it.next();
                c.this.T(jVar.f4165a, jVar.f4166b, jVar.f4167c, jVar.f4168d, jVar.e);
            }
            this.f4133a.clear();
            c.this.f4129m.remove(this.f4133a);
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f4135a;

        b(ArrayList arrayList) {
            this.f4135a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f4135a.iterator();
            while (it.hasNext()) {
                c.this.S((i) it.next());
            }
            this.f4135a.clear();
            c.this.f4130n.remove(this.f4135a);
        }
    }

    /* renamed from: androidx.recyclerview.widget.c$c, reason: collision with other inner class name */
    class RunnableC0052c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f4137a;

        RunnableC0052c(ArrayList arrayList) {
            this.f4137a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f4137a.iterator();
            while (it.hasNext()) {
                c.this.R((RecyclerView.C) it.next());
            }
            this.f4137a.clear();
            c.this.f4128l.remove(this.f4137a);
        }
    }

    class d extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RecyclerView.C f4139a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f4140b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f4141c;

        d(RecyclerView.C c2, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f4139a = c2;
            this.f4140b = viewPropertyAnimator;
            this.f4141c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f4140b.setListener(null);
            this.f4141c.setAlpha(1.0f);
            c.this.H(this.f4139a);
            c.this.f4132q.remove(this.f4139a);
            c.this.W();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.I(this.f4139a);
        }
    }

    class e extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RecyclerView.C f4143a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f4144b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f4145c;

        e(RecyclerView.C c2, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f4143a = c2;
            this.f4144b = view;
            this.f4145c = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f4144b.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f4145c.setListener(null);
            c.this.B(this.f4143a);
            c.this.o.remove(this.f4143a);
            c.this.W();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.C(this.f4143a);
        }
    }

    class f extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RecyclerView.C f4147a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f4148b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f4149c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f4150d;
        final /* synthetic */ ViewPropertyAnimator e;

        f(RecyclerView.C c2, int i2, View view, int i3, ViewPropertyAnimator viewPropertyAnimator) {
            this.f4147a = c2;
            this.f4148b = i2;
            this.f4149c = view;
            this.f4150d = i3;
            this.e = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f4148b != 0) {
                this.f4149c.setTranslationX(0.0f);
            }
            if (this.f4150d != 0) {
                this.f4149c.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.e.setListener(null);
            c.this.F(this.f4147a);
            c.this.f4131p.remove(this.f4147a);
            c.this.W();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.G(this.f4147a);
        }
    }

    class g extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f4152a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f4153b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f4154c;

        g(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f4152a = iVar;
            this.f4153b = viewPropertyAnimator;
            this.f4154c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f4153b.setListener(null);
            this.f4154c.setAlpha(1.0f);
            this.f4154c.setTranslationX(0.0f);
            this.f4154c.setTranslationY(0.0f);
            c.this.D(this.f4152a.f4160a, true);
            c.this.r.remove(this.f4152a.f4160a);
            c.this.W();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.E(this.f4152a.f4160a, true);
        }
    }

    class h extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f4156a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f4157b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f4158c;

        h(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f4156a = iVar;
            this.f4157b = viewPropertyAnimator;
            this.f4158c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f4157b.setListener(null);
            this.f4158c.setAlpha(1.0f);
            this.f4158c.setTranslationX(0.0f);
            this.f4158c.setTranslationY(0.0f);
            c.this.D(this.f4156a.f4161b, false);
            c.this.r.remove(this.f4156a.f4161b);
            c.this.W();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.E(this.f4156a.f4161b, false);
        }
    }

    private static class j {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.C f4165a;

        /* renamed from: b, reason: collision with root package name */
        public int f4166b;

        /* renamed from: c, reason: collision with root package name */
        public int f4167c;

        /* renamed from: d, reason: collision with root package name */
        public int f4168d;
        public int e;

        j(RecyclerView.C c2, int i2, int i3, int i4, int i5) {
            this.f4165a = c2;
            this.f4166b = i2;
            this.f4167c = i3;
            this.f4168d = i4;
            this.e = i5;
        }
    }

    private void U(RecyclerView.C c2) {
        View view = c2.f3971a;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f4132q.add(c2);
        viewPropertyAnimatorAnimate.setDuration(o()).alpha(0.0f).setListener(new d(c2, viewPropertyAnimatorAnimate, view)).start();
    }

    private void X(List list, RecyclerView.C c2) {
        for (int size = list.size() - 1; size >= 0; size--) {
            i iVar = (i) list.get(size);
            if (Z(iVar, c2) && iVar.f4160a == null && iVar.f4161b == null) {
                list.remove(iVar);
            }
        }
    }

    private void Y(i iVar) {
        RecyclerView.C c2 = iVar.f4160a;
        if (c2 != null) {
            Z(iVar, c2);
        }
        RecyclerView.C c3 = iVar.f4161b;
        if (c3 != null) {
            Z(iVar, c3);
        }
    }

    private boolean Z(i iVar, RecyclerView.C c2) {
        boolean z2 = false;
        if (iVar.f4161b == c2) {
            iVar.f4161b = null;
        } else {
            if (iVar.f4160a != c2) {
                return false;
            }
            iVar.f4160a = null;
            z2 = true;
        }
        c2.f3971a.setAlpha(1.0f);
        c2.f3971a.setTranslationX(0.0f);
        c2.f3971a.setTranslationY(0.0f);
        D(c2, z2);
        return true;
    }

    private void a0(RecyclerView.C c2) {
        if (s == null) {
            s = new ValueAnimator().getInterpolator();
        }
        c2.f3971a.animate().setInterpolator(s);
        j(c2);
    }

    @Override // androidx.recyclerview.widget.n
    public boolean A(RecyclerView.C c2) {
        a0(c2);
        this.f4124h.add(c2);
        return true;
    }

    void R(RecyclerView.C c2) {
        View view = c2.f3971a;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.o.add(c2);
        viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(l()).setListener(new e(c2, view, viewPropertyAnimatorAnimate)).start();
    }

    void S(i iVar) {
        RecyclerView.C c2 = iVar.f4160a;
        View view = c2 == null ? null : c2.f3971a;
        RecyclerView.C c3 = iVar.f4161b;
        View view2 = c3 != null ? c3.f3971a : null;
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(m());
            this.r.add(iVar.f4160a);
            duration.translationX(iVar.e - iVar.f4162c);
            duration.translationY(iVar.f4164f - iVar.f4163d);
            duration.alpha(0.0f).setListener(new g(iVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.r.add(iVar.f4161b);
            viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(m()).alpha(1.0f).setListener(new h(iVar, viewPropertyAnimatorAnimate, view2)).start();
        }
    }

    void T(RecyclerView.C c2, int i2, int i3, int i4, int i5) {
        View view = c2.f3971a;
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        if (i6 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i7 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f4131p.add(c2);
        viewPropertyAnimatorAnimate.setDuration(n()).setListener(new f(c2, i6, view, i7, viewPropertyAnimatorAnimate)).start();
    }

    void V(List list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ((RecyclerView.C) list.get(size)).f3971a.animate().cancel();
        }
    }

    void W() {
        if (p()) {
            return;
        }
        i();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean g(RecyclerView.C c2, List list) {
        return !list.isEmpty() || super.g(c2, list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void j(RecyclerView.C c2) {
        View view = c2.f3971a;
        view.animate().cancel();
        int size = this.f4126j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (((j) this.f4126j.get(size)).f4165a == c2) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                F(c2);
                this.f4126j.remove(size);
            }
        }
        X(this.f4127k, c2);
        if (this.f4124h.remove(c2)) {
            view.setAlpha(1.0f);
            H(c2);
        }
        if (this.f4125i.remove(c2)) {
            view.setAlpha(1.0f);
            B(c2);
        }
        for (int size2 = this.f4130n.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = (ArrayList) this.f4130n.get(size2);
            X(arrayList, c2);
            if (arrayList.isEmpty()) {
                this.f4130n.remove(size2);
            }
        }
        for (int size3 = this.f4129m.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = (ArrayList) this.f4129m.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (((j) arrayList2.get(size4)).f4165a == c2) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    F(c2);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f4129m.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f4128l.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = (ArrayList) this.f4128l.get(size5);
            if (arrayList3.remove(c2)) {
                view.setAlpha(1.0f);
                B(c2);
                if (arrayList3.isEmpty()) {
                    this.f4128l.remove(size5);
                }
            }
        }
        this.f4132q.remove(c2);
        this.o.remove(c2);
        this.r.remove(c2);
        this.f4131p.remove(c2);
        W();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void k() {
        int size = this.f4126j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            j jVar = (j) this.f4126j.get(size);
            View view = jVar.f4165a.f3971a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            F(jVar.f4165a);
            this.f4126j.remove(size);
        }
        for (int size2 = this.f4124h.size() - 1; size2 >= 0; size2--) {
            H((RecyclerView.C) this.f4124h.get(size2));
            this.f4124h.remove(size2);
        }
        int size3 = this.f4125i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.C c2 = (RecyclerView.C) this.f4125i.get(size3);
            c2.f3971a.setAlpha(1.0f);
            B(c2);
            this.f4125i.remove(size3);
        }
        for (int size4 = this.f4127k.size() - 1; size4 >= 0; size4--) {
            Y((i) this.f4127k.get(size4));
        }
        this.f4127k.clear();
        if (p()) {
            for (int size5 = this.f4129m.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = (ArrayList) this.f4129m.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    j jVar2 = (j) arrayList.get(size6);
                    View view2 = jVar2.f4165a.f3971a;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    F(jVar2.f4165a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f4129m.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f4128l.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = (ArrayList) this.f4128l.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.C c3 = (RecyclerView.C) arrayList2.get(size8);
                    c3.f3971a.setAlpha(1.0f);
                    B(c3);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f4128l.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f4130n.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = (ArrayList) this.f4130n.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    Y((i) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f4130n.remove(arrayList3);
                    }
                }
            }
            V(this.f4132q);
            V(this.f4131p);
            V(this.o);
            V(this.r);
            i();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean p() {
        return (this.f4125i.isEmpty() && this.f4127k.isEmpty() && this.f4126j.isEmpty() && this.f4124h.isEmpty() && this.f4131p.isEmpty() && this.f4132q.isEmpty() && this.o.isEmpty() && this.r.isEmpty() && this.f4129m.isEmpty() && this.f4128l.isEmpty() && this.f4130n.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void v() {
        boolean zIsEmpty = this.f4124h.isEmpty();
        boolean zIsEmpty2 = this.f4126j.isEmpty();
        boolean zIsEmpty3 = this.f4127k.isEmpty();
        boolean zIsEmpty4 = this.f4125i.isEmpty();
        if (zIsEmpty && zIsEmpty2 && zIsEmpty4 && zIsEmpty3) {
            return;
        }
        Iterator it = this.f4124h.iterator();
        while (it.hasNext()) {
            U((RecyclerView.C) it.next());
        }
        this.f4124h.clear();
        if (!zIsEmpty2) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f4126j);
            this.f4129m.add(arrayList);
            this.f4126j.clear();
            a aVar = new a(arrayList);
            if (zIsEmpty) {
                aVar.run();
            } else {
                M.b0(((j) arrayList.get(0)).f4165a.f3971a, aVar, o());
            }
        }
        if (!zIsEmpty3) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(this.f4127k);
            this.f4130n.add(arrayList2);
            this.f4127k.clear();
            b bVar = new b(arrayList2);
            if (zIsEmpty) {
                bVar.run();
            } else {
                M.b0(((i) arrayList2.get(0)).f4160a.f3971a, bVar, o());
            }
        }
        if (zIsEmpty4) {
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        arrayList3.addAll(this.f4125i);
        this.f4128l.add(arrayList3);
        this.f4125i.clear();
        RunnableC0052c runnableC0052c = new RunnableC0052c(arrayList3);
        if (zIsEmpty && zIsEmpty2 && zIsEmpty3) {
            runnableC0052c.run();
        } else {
            M.b0(((RecyclerView.C) arrayList3.get(0)).f3971a, runnableC0052c, (!zIsEmpty ? o() : 0L) + Math.max(!zIsEmpty2 ? n() : 0L, zIsEmpty3 ? 0L : m()));
        }
    }

    @Override // androidx.recyclerview.widget.n
    public boolean x(RecyclerView.C c2) {
        a0(c2);
        c2.f3971a.setAlpha(0.0f);
        this.f4125i.add(c2);
        return true;
    }

    @Override // androidx.recyclerview.widget.n
    public boolean y(RecyclerView.C c2, RecyclerView.C c3, int i2, int i3, int i4, int i5) {
        if (c2 == c3) {
            return z(c2, i2, i3, i4, i5);
        }
        float translationX = c2.f3971a.getTranslationX();
        float translationY = c2.f3971a.getTranslationY();
        float alpha = c2.f3971a.getAlpha();
        a0(c2);
        int i6 = (int) ((i4 - i2) - translationX);
        int i7 = (int) ((i5 - i3) - translationY);
        c2.f3971a.setTranslationX(translationX);
        c2.f3971a.setTranslationY(translationY);
        c2.f3971a.setAlpha(alpha);
        if (c3 != null) {
            a0(c3);
            c3.f3971a.setTranslationX(-i6);
            c3.f3971a.setTranslationY(-i7);
            c3.f3971a.setAlpha(0.0f);
        }
        this.f4127k.add(new i(c2, c3, i2, i3, i4, i5));
        return true;
    }

    @Override // androidx.recyclerview.widget.n
    public boolean z(RecyclerView.C c2, int i2, int i3, int i4, int i5) {
        View view = c2.f3971a;
        int translationX = i2 + ((int) view.getTranslationX());
        int translationY = i3 + ((int) c2.f3971a.getTranslationY());
        a0(c2);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            F(c2);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX(-i6);
        }
        if (i7 != 0) {
            view.setTranslationY(-i7);
        }
        this.f4126j.add(new j(c2, translationX, translationY, i4, i5));
        return true;
    }

    private static class i {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.C f4160a;

        /* renamed from: b, reason: collision with root package name */
        public RecyclerView.C f4161b;

        /* renamed from: c, reason: collision with root package name */
        public int f4162c;

        /* renamed from: d, reason: collision with root package name */
        public int f4163d;
        public int e;

        /* renamed from: f, reason: collision with root package name */
        public int f4164f;

        private i(RecyclerView.C c2, RecyclerView.C c3) {
            this.f4160a = c2;
            this.f4161b = c3;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f4160a + ", newHolder=" + this.f4161b + ", fromX=" + this.f4162c + ", fromY=" + this.f4163d + ", toX=" + this.e + ", toY=" + this.f4164f + '}';
        }

        i(RecyclerView.C c2, RecyclerView.C c3, int i2, int i3, int i4, int i5) {
            this(c2, c3);
            this.f4162c = i2;
            this.f4163d = i3;
            this.e = i4;
            this.f4164f = i5;
        }
    }
}
