package androidx.fragment.app;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class H {

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f3451a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f3452b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ArrayList f3453c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f3454d;
        final /* synthetic */ ArrayList e;

        a(int i2, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.f3451a = i2;
            this.f3452b = arrayList;
            this.f3453c = arrayList2;
            this.f3454d = arrayList3;
            this.e = arrayList4;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i2 = 0; i2 < this.f3451a; i2++) {
                androidx.core.view.M.w0((View) this.f3452b.get(i2), (String) this.f3453c.get(i2));
                androidx.core.view.M.w0((View) this.f3454d.get(i2), (String) this.e.get(i2));
            }
        }
    }

    protected static void d(List list, View view) {
        int size = list.size();
        if (g(list, view, size)) {
            return;
        }
        if (androidx.core.view.M.G(view) != null) {
            list.add(view);
        }
        for (int i2 = size; i2 < list.size(); i2++) {
            View view2 = (View) list.get(i2);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = viewGroup.getChildAt(i3);
                    if (!g(list, childAt, size) && androidx.core.view.M.G(childAt) != null) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    private static boolean g(List list, View view, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (list.get(i3) == view) {
                return true;
            }
        }
        return false;
    }

    protected static boolean i(List list) {
        return list == null || list.isEmpty();
    }

    public abstract void a(Object obj, View view);

    public abstract void b(Object obj, ArrayList arrayList);

    public abstract void c(ViewGroup viewGroup, Object obj);

    public abstract boolean e(Object obj);

    public abstract Object f(Object obj);

    protected void h(View view, Rect rect) {
        if (androidx.core.view.M.N(view)) {
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
            view.getMatrix().mapRect(rectF);
            rectF.offset(view.getLeft(), view.getTop());
            Object parent = view.getParent();
            while (parent instanceof View) {
                View view2 = (View) parent;
                rectF.offset(-view2.getScrollX(), -view2.getScrollY());
                view2.getMatrix().mapRect(rectF);
                rectF.offset(view2.getLeft(), view2.getTop());
                parent = view2.getParent();
            }
            view.getRootView().getLocationOnScreen(new int[2]);
            rectF.offset(r1[0], r1[1]);
            rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        }
    }

    public abstract Object j(Object obj, Object obj2, Object obj3);

    public abstract Object k(Object obj, Object obj2, Object obj3);

    ArrayList l(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = (View) arrayList.get(i2);
            arrayList2.add(androidx.core.view.M.G(view));
            androidx.core.view.M.w0(view, null);
        }
        return arrayList2;
    }

    public abstract void m(Object obj, View view, ArrayList arrayList);

    public abstract void n(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2, Object obj4, ArrayList arrayList3);

    public abstract void o(Object obj, Rect rect);

    public abstract void p(Object obj, View view);

    public void q(Fragment fragment, Object obj, androidx.core.os.d dVar, Runnable runnable) {
        runnable.run();
    }

    void r(View view, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Map map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            View view2 = (View) arrayList.get(i2);
            String strG = androidx.core.view.M.G(view2);
            arrayList4.add(strG);
            if (strG != null) {
                androidx.core.view.M.w0(view2, null);
                String str = (String) map.get(strG);
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        break;
                    }
                    if (str.equals(arrayList3.get(i3))) {
                        androidx.core.view.M.w0((View) arrayList2.get(i3), strG);
                        break;
                    }
                    i3++;
                }
            }
        }
        androidx.core.view.I.a(view, new a(size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    public abstract void s(Object obj, View view, ArrayList arrayList);

    public abstract void t(Object obj, ArrayList arrayList, ArrayList arrayList2);

    public abstract Object u(Object obj);
}
