package O;

import O.l;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* renamed from: O.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0109e extends androidx.fragment.app.H {

    /* renamed from: O.e$a */
    class a extends l.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Rect f430a;

        a(Rect rect) {
            this.f430a = rect;
        }
    }

    /* renamed from: O.e$d */
    class d extends l.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Rect f441a;

        d(Rect rect) {
            this.f441a = rect;
        }
    }

    private static boolean v(l lVar) {
        return (androidx.fragment.app.H.i(lVar.y()) && androidx.fragment.app.H.i(lVar.z()) && androidx.fragment.app.H.i(lVar.A())) ? false : true;
    }

    @Override // androidx.fragment.app.H
    public void a(Object obj, View view) {
        if (obj != null) {
            ((l) obj).b(view);
        }
    }

    @Override // androidx.fragment.app.H
    public void b(Object obj, ArrayList arrayList) {
        l lVar = (l) obj;
        if (lVar == null) {
            return;
        }
        int i2 = 0;
        if (lVar instanceof p) {
            p pVar = (p) lVar;
            int iF0 = pVar.f0();
            while (i2 < iF0) {
                b(pVar.e0(i2), arrayList);
                i2++;
            }
            return;
        }
        if (v(lVar) || !androidx.fragment.app.H.i(lVar.B())) {
            return;
        }
        int size = arrayList.size();
        while (i2 < size) {
            lVar.b((View) arrayList.get(i2));
            i2++;
        }
    }

    @Override // androidx.fragment.app.H
    public void c(ViewGroup viewGroup, Object obj) {
        n.a(viewGroup, (l) obj);
    }

    @Override // androidx.fragment.app.H
    public boolean e(Object obj) {
        return obj instanceof l;
    }

    @Override // androidx.fragment.app.H
    public Object f(Object obj) {
        if (obj != null) {
            return ((l) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.H
    public Object j(Object obj, Object obj2, Object obj3) {
        l lVarK0 = (l) obj;
        l lVar = (l) obj2;
        l lVar2 = (l) obj3;
        if (lVarK0 != null && lVar != null) {
            lVarK0 = new p().d0(lVarK0).d0(lVar).k0(1);
        } else if (lVarK0 == null) {
            lVarK0 = lVar != null ? lVar : null;
        }
        if (lVar2 == null) {
            return lVarK0;
        }
        p pVar = new p();
        if (lVarK0 != null) {
            pVar.d0(lVarK0);
        }
        pVar.d0(lVar2);
        return pVar;
    }

    @Override // androidx.fragment.app.H
    public Object k(Object obj, Object obj2, Object obj3) {
        p pVar = new p();
        if (obj != null) {
            pVar.d0((l) obj);
        }
        if (obj2 != null) {
            pVar.d0((l) obj2);
        }
        if (obj3 != null) {
            pVar.d0((l) obj3);
        }
        return pVar;
    }

    @Override // androidx.fragment.app.H
    public void m(Object obj, View view, ArrayList arrayList) {
        ((l) obj).a(new b(view, arrayList));
    }

    @Override // androidx.fragment.app.H
    public void n(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2, Object obj4, ArrayList arrayList3) {
        ((l) obj).a(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.H
    public void o(Object obj, Rect rect) {
        if (obj != null) {
            ((l) obj).U(new d(rect));
        }
    }

    @Override // androidx.fragment.app.H
    public void p(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            h(view, rect);
            ((l) obj).U(new a(rect));
        }
    }

    @Override // androidx.fragment.app.H
    public void s(Object obj, View view, ArrayList arrayList) {
        p pVar = (p) obj;
        List listB = pVar.B();
        listB.clear();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            androidx.fragment.app.H.d(listB, (View) arrayList.get(i2));
        }
        listB.add(view);
        arrayList.add(view);
        b(pVar, arrayList);
    }

    @Override // androidx.fragment.app.H
    public void t(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        p pVar = (p) obj;
        if (pVar != null) {
            pVar.B().clear();
            pVar.B().addAll(arrayList2);
            w(pVar, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.H
    public Object u(Object obj) {
        if (obj == null) {
            return null;
        }
        p pVar = new p();
        pVar.d0((l) obj);
        return pVar;
    }

    public void w(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        l lVar = (l) obj;
        int i2 = 0;
        if (lVar instanceof p) {
            p pVar = (p) lVar;
            int iF0 = pVar.f0();
            while (i2 < iF0) {
                w(pVar.e0(i2), arrayList, arrayList2);
                i2++;
            }
            return;
        }
        if (v(lVar)) {
            return;
        }
        List listB = lVar.B();
        if (listB.size() == arrayList.size() && listB.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i2 < size) {
                lVar.b((View) arrayList2.get(i2));
                i2++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                lVar.P((View) arrayList.get(size2));
            }
        }
    }

    /* renamed from: O.e$b */
    class b implements l.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f432a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f433b;

        b(View view, ArrayList arrayList) {
            this.f432a = view;
            this.f433b = arrayList;
        }

        @Override // O.l.f
        public void b(l lVar) {
            lVar.O(this);
            this.f432a.setVisibility(8);
            int size = this.f433b.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((View) this.f433b.get(i2)).setVisibility(0);
            }
        }

        @Override // O.l.f
        public void a(l lVar) {
        }

        @Override // O.l.f
        public void c(l lVar) {
        }

        @Override // O.l.f
        public void d(l lVar) {
        }
    }

    /* renamed from: O.e$c */
    class c implements l.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f435a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f436b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f437c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f438d;
        final /* synthetic */ Object e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f439f;

        c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f435a = obj;
            this.f436b = arrayList;
            this.f437c = obj2;
            this.f438d = arrayList2;
            this.e = obj3;
            this.f439f = arrayList3;
        }

        @Override // O.l.f
        public void c(l lVar) {
            Object obj = this.f435a;
            if (obj != null) {
                C0109e.this.w(obj, this.f436b, null);
            }
            Object obj2 = this.f437c;
            if (obj2 != null) {
                C0109e.this.w(obj2, this.f438d, null);
            }
            Object obj3 = this.e;
            if (obj3 != null) {
                C0109e.this.w(obj3, this.f439f, null);
            }
        }

        @Override // O.l.f
        public void a(l lVar) {
        }

        @Override // O.l.f
        public void b(l lVar) {
        }

        @Override // O.l.f
        public void d(l lVar) {
        }
    }
}
