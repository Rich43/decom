package O;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.M;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class n {

    /* renamed from: a, reason: collision with root package name */
    private static l f484a = new C0106b();

    /* renamed from: b, reason: collision with root package name */
    private static ThreadLocal f485b = new ThreadLocal();

    /* renamed from: c, reason: collision with root package name */
    static ArrayList f486c = new ArrayList();

    public static void a(ViewGroup viewGroup, l lVar) {
        if (f486c.contains(viewGroup) || !M.O(viewGroup)) {
            return;
        }
        f486c.add(viewGroup);
        if (lVar == null) {
            lVar = f484a;
        }
        l lVarClone = lVar.clone();
        d(viewGroup, lVarClone);
        k.b(viewGroup, null);
        c(viewGroup, lVarClone);
    }

    static androidx.collection.a b() {
        androidx.collection.a aVar;
        WeakReference weakReference = (WeakReference) f485b.get();
        if (weakReference != null && (aVar = (androidx.collection.a) weakReference.get()) != null) {
            return aVar;
        }
        androidx.collection.a aVar2 = new androidx.collection.a();
        f485b.set(new WeakReference(aVar2));
        return aVar2;
    }

    private static void c(ViewGroup viewGroup, l lVar) {
        if (lVar == null || viewGroup == null) {
            return;
        }
        a aVar = new a(lVar, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    private static void d(ViewGroup viewGroup, l lVar) {
        ArrayList arrayList = (ArrayList) b().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((l) it.next()).M(viewGroup);
            }
        }
        if (lVar != null) {
            lVar.j(viewGroup, true);
        }
        k.a(viewGroup);
    }

    private static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        l f487a;

        /* renamed from: b, reason: collision with root package name */
        ViewGroup f488b;

        /* renamed from: O.n$a$a, reason: collision with other inner class name */
        class C0009a extends m {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ androidx.collection.a f489a;

            C0009a(androidx.collection.a aVar) {
                this.f489a = aVar;
            }

            @Override // O.l.f
            public void b(l lVar) {
                ((ArrayList) this.f489a.get(a.this.f488b)).remove(lVar);
            }
        }

        a(l lVar, ViewGroup viewGroup) {
            this.f487a = lVar;
            this.f488b = viewGroup;
        }

        private void a() {
            this.f488b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f488b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (!n.f486c.remove(this.f488b)) {
                return true;
            }
            androidx.collection.a aVarB = n.b();
            ArrayList arrayList = (ArrayList) aVarB.get(this.f488b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                aVarB.put(this.f488b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f487a);
            this.f487a.a(new C0009a(aVarB));
            this.f487a.j(this.f488b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((l) it.next()).Q(this.f488b);
                }
            }
            this.f487a.N(this.f488b);
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            n.f486c.remove(this.f488b);
            ArrayList arrayList = (ArrayList) n.b().get(this.f488b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((l) it.next()).Q(this.f488b);
                }
            }
            this.f487a.k(true);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }
    }
}
