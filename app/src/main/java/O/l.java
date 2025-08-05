package O;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.core.view.M;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class l implements Cloneable {

    /* renamed from: G, reason: collision with root package name */
    private static final int[] f446G = {2, 1, 3, 4};

    /* renamed from: H, reason: collision with root package name */
    private static final AbstractC0111g f447H = new a();

    /* renamed from: I, reason: collision with root package name */
    private static ThreadLocal f448I = new ThreadLocal();

    /* renamed from: D, reason: collision with root package name */
    private e f452D;

    /* renamed from: E, reason: collision with root package name */
    private androidx.collection.a f453E;

    /* renamed from: t, reason: collision with root package name */
    private ArrayList f470t;

    /* renamed from: u, reason: collision with root package name */
    private ArrayList f471u;

    /* renamed from: a, reason: collision with root package name */
    private String f455a = getClass().getName();

    /* renamed from: b, reason: collision with root package name */
    private long f456b = -1;

    /* renamed from: c, reason: collision with root package name */
    long f457c = -1;

    /* renamed from: d, reason: collision with root package name */
    private TimeInterpolator f458d = null;
    ArrayList e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    ArrayList f459f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    private ArrayList f460g = null;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList f461h = null;

    /* renamed from: i, reason: collision with root package name */
    private ArrayList f462i = null;

    /* renamed from: j, reason: collision with root package name */
    private ArrayList f463j = null;

    /* renamed from: k, reason: collision with root package name */
    private ArrayList f464k = null;

    /* renamed from: l, reason: collision with root package name */
    private ArrayList f465l = null;

    /* renamed from: m, reason: collision with root package name */
    private ArrayList f466m = null;

    /* renamed from: n, reason: collision with root package name */
    private ArrayList f467n = null;
    private ArrayList o = null;

    /* renamed from: p, reason: collision with root package name */
    private t f468p = new t();

    /* renamed from: q, reason: collision with root package name */
    private t f469q = new t();
    p r = null;
    private int[] s = f446G;

    /* renamed from: v, reason: collision with root package name */
    private ViewGroup f472v = null;

    /* renamed from: w, reason: collision with root package name */
    boolean f473w = false;

    /* renamed from: x, reason: collision with root package name */
    ArrayList f474x = new ArrayList();

    /* renamed from: y, reason: collision with root package name */
    private int f475y = 0;

    /* renamed from: z, reason: collision with root package name */
    private boolean f476z = false;

    /* renamed from: A, reason: collision with root package name */
    private boolean f449A = false;

    /* renamed from: B, reason: collision with root package name */
    private ArrayList f450B = null;

    /* renamed from: C, reason: collision with root package name */
    private ArrayList f451C = new ArrayList();

    /* renamed from: F, reason: collision with root package name */
    private AbstractC0111g f454F = f447H;

    static class a extends AbstractC0111g {
        a() {
        }

        @Override // O.AbstractC0111g
        public Path a(float f2, float f3, float f4, float f5) {
            Path path = new Path();
            path.moveTo(f2, f3);
            path.lineTo(f4, f5);
            return path;
        }
    }

    class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ androidx.collection.a f477a;

        b(androidx.collection.a aVar) {
            this.f477a = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f477a.remove(animator);
            l.this.f474x.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            l.this.f474x.add(animator);
        }
    }

    class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            l.this.o();
            animator.removeListener(this);
        }
    }

    private static class d {

        /* renamed from: a, reason: collision with root package name */
        View f480a;

        /* renamed from: b, reason: collision with root package name */
        String f481b;

        /* renamed from: c, reason: collision with root package name */
        s f482c;

        /* renamed from: d, reason: collision with root package name */
        H f483d;
        l e;

        d(View view, String str, l lVar, H h2, s sVar) {
            this.f480a = view;
            this.f481b = str;
            this.f482c = sVar;
            this.f483d = h2;
            this.e = lVar;
        }
    }

    public static abstract class e {
    }

    public interface f {
        void a(l lVar);

        void b(l lVar);

        void c(l lVar);

        void d(l lVar);
    }

    private static boolean G(s sVar, s sVar2, String str) {
        Object obj = sVar.f502a.get(str);
        Object obj2 = sVar2.f502a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    private void H(androidx.collection.a aVar, androidx.collection.a aVar2, SparseArray sparseArray, SparseArray sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view2 = (View) sparseArray.valueAt(i2);
            if (view2 != null && F(view2) && (view = (View) sparseArray2.get(sparseArray.keyAt(i2))) != null && F(view)) {
                s sVar = (s) aVar.get(view2);
                s sVar2 = (s) aVar2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.f470t.add(sVar);
                    this.f471u.add(sVar2);
                    aVar.remove(view2);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void I(androidx.collection.a aVar, androidx.collection.a aVar2) {
        s sVar;
        View view;
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View view2 = (View) aVar.keyAt(size);
            if (view2 != null && F(view2) && (sVar = (s) aVar2.remove(view2)) != null && (view = sVar.f503b) != null && F(view)) {
                this.f470t.add((s) aVar.removeAt(size));
                this.f471u.add(sVar);
            }
        }
    }

    private void J(androidx.collection.a aVar, androidx.collection.a aVar2, androidx.collection.d dVar, androidx.collection.d dVar2) {
        View view;
        int iM = dVar.m();
        for (int i2 = 0; i2 < iM; i2++) {
            View view2 = (View) dVar.n(i2);
            if (view2 != null && F(view2) && (view = (View) dVar2.f(dVar.i(i2))) != null && F(view)) {
                s sVar = (s) aVar.get(view2);
                s sVar2 = (s) aVar2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.f470t.add(sVar);
                    this.f471u.add(sVar2);
                    aVar.remove(view2);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void K(androidx.collection.a aVar, androidx.collection.a aVar2, androidx.collection.a aVar3, androidx.collection.a aVar4) {
        View view;
        int size = aVar3.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view2 = (View) aVar3.valueAt(i2);
            if (view2 != null && F(view2) && (view = (View) aVar4.get(aVar3.keyAt(i2))) != null && F(view)) {
                s sVar = (s) aVar.get(view2);
                s sVar2 = (s) aVar2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.f470t.add(sVar);
                    this.f471u.add(sVar2);
                    aVar.remove(view2);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void L(t tVar, t tVar2) {
        androidx.collection.a aVar = new androidx.collection.a(tVar.f505a);
        androidx.collection.a aVar2 = new androidx.collection.a(tVar2.f505a);
        int i2 = 0;
        while (true) {
            int[] iArr = this.s;
            if (i2 >= iArr.length) {
                c(aVar, aVar2);
                return;
            }
            int i3 = iArr[i2];
            if (i3 == 1) {
                I(aVar, aVar2);
            } else if (i3 == 2) {
                K(aVar, aVar2, tVar.f508d, tVar2.f508d);
            } else if (i3 == 3) {
                H(aVar, aVar2, tVar.f506b, tVar2.f506b);
            } else if (i3 == 4) {
                J(aVar, aVar2, tVar.f507c, tVar2.f507c);
            }
            i2++;
        }
    }

    private void R(Animator animator, androidx.collection.a aVar) {
        if (animator != null) {
            animator.addListener(new b(aVar));
            e(animator);
        }
    }

    private void c(androidx.collection.a aVar, androidx.collection.a aVar2) {
        for (int i2 = 0; i2 < aVar.size(); i2++) {
            s sVar = (s) aVar.valueAt(i2);
            if (F(sVar.f503b)) {
                this.f470t.add(sVar);
                this.f471u.add(null);
            }
        }
        for (int i3 = 0; i3 < aVar2.size(); i3++) {
            s sVar2 = (s) aVar2.valueAt(i3);
            if (F(sVar2.f503b)) {
                this.f471u.add(sVar2);
                this.f470t.add(null);
            }
        }
    }

    private static void d(t tVar, View view, s sVar) {
        tVar.f505a.put(view, sVar);
        int id = view.getId();
        if (id >= 0) {
            if (tVar.f506b.indexOfKey(id) >= 0) {
                tVar.f506b.put(id, null);
            } else {
                tVar.f506b.put(id, view);
            }
        }
        String strG = M.G(view);
        if (strG != null) {
            if (tVar.f508d.containsKey(strG)) {
                tVar.f508d.put(strG, null);
            } else {
                tVar.f508d.put(strG, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (tVar.f507c.h(itemIdAtPosition) < 0) {
                    M.o0(view, true);
                    tVar.f507c.j(itemIdAtPosition, view);
                    return;
                }
                View view2 = (View) tVar.f507c.f(itemIdAtPosition);
                if (view2 != null) {
                    M.o0(view2, false);
                    tVar.f507c.j(itemIdAtPosition, null);
                }
            }
        }
    }

    private void g(View view, boolean z2) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList arrayList = this.f462i;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList arrayList2 = this.f463j;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList arrayList3 = this.f464k;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        if (((Class) this.f464k.get(i2)).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    s sVar = new s();
                    sVar.f503b = view;
                    if (z2) {
                        i(sVar);
                    } else {
                        f(sVar);
                    }
                    sVar.f504c.add(this);
                    h(sVar);
                    if (z2) {
                        d(this.f468p, view, sVar);
                    } else {
                        d(this.f469q, view, sVar);
                    }
                }
                if (view instanceof ViewGroup) {
                    ArrayList arrayList4 = this.f466m;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList arrayList5 = this.f467n;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList arrayList6 = this.o;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i3 = 0; i3 < size2; i3++) {
                                    if (((Class) this.o.get(i3)).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                                g(viewGroup.getChildAt(i4), z2);
                            }
                        }
                    }
                }
            }
        }
    }

    private static androidx.collection.a w() {
        androidx.collection.a aVar = (androidx.collection.a) f448I.get();
        if (aVar != null) {
            return aVar;
        }
        androidx.collection.a aVar2 = new androidx.collection.a();
        f448I.set(aVar2);
        return aVar2;
    }

    public List A() {
        return this.f461h;
    }

    public List B() {
        return this.f459f;
    }

    public String[] C() {
        return null;
    }

    public s D(View view, boolean z2) {
        p pVar = this.r;
        if (pVar != null) {
            return pVar.D(view, z2);
        }
        return (s) (z2 ? this.f468p : this.f469q).f505a.get(view);
    }

    public boolean E(s sVar, s sVar2) {
        if (sVar == null || sVar2 == null) {
            return false;
        }
        String[] strArrC = C();
        if (strArrC == null) {
            Iterator it = sVar.f502a.keySet().iterator();
            while (it.hasNext()) {
                if (G(sVar, sVar2, (String) it.next())) {
                }
            }
            return false;
        }
        for (String str : strArrC) {
            if (!G(sVar, sVar2, str)) {
            }
        }
        return false;
        return true;
    }

    boolean F(View view) {
        ArrayList arrayList;
        ArrayList arrayList2;
        int id = view.getId();
        ArrayList arrayList3 = this.f462i;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList arrayList4 = this.f463j;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList arrayList5 = this.f464k;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (((Class) this.f464k.get(i2)).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.f465l != null && M.G(view) != null && this.f465l.contains(M.G(view))) {
            return false;
        }
        if ((this.e.size() == 0 && this.f459f.size() == 0 && (((arrayList = this.f461h) == null || arrayList.isEmpty()) && ((arrayList2 = this.f460g) == null || arrayList2.isEmpty()))) || this.e.contains(Integer.valueOf(id)) || this.f459f.contains(view)) {
            return true;
        }
        ArrayList arrayList6 = this.f460g;
        if (arrayList6 != null && arrayList6.contains(M.G(view))) {
            return true;
        }
        if (this.f461h != null) {
            for (int i3 = 0; i3 < this.f461h.size(); i3++) {
                if (((Class) this.f461h.get(i3)).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void M(View view) {
        if (this.f449A) {
            return;
        }
        androidx.collection.a aVarW = w();
        int size = aVarW.size();
        H hE = A.e(view);
        for (int i2 = size - 1; i2 >= 0; i2--) {
            d dVar = (d) aVarW.valueAt(i2);
            if (dVar.f480a != null && hE.equals(dVar.f483d)) {
                AbstractC0105a.b((Animator) aVarW.keyAt(i2));
            }
        }
        ArrayList arrayList = this.f450B;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.f450B.clone();
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                ((f) arrayList2.get(i3)).a(this);
            }
        }
        this.f476z = true;
    }

    void N(ViewGroup viewGroup) {
        d dVar;
        this.f470t = new ArrayList();
        this.f471u = new ArrayList();
        L(this.f468p, this.f469q);
        androidx.collection.a aVarW = w();
        int size = aVarW.size();
        H hE = A.e(viewGroup);
        for (int i2 = size - 1; i2 >= 0; i2--) {
            Animator animator = (Animator) aVarW.keyAt(i2);
            if (animator != null && (dVar = (d) aVarW.get(animator)) != null && dVar.f480a != null && hE.equals(dVar.f483d)) {
                s sVar = dVar.f482c;
                View view = dVar.f480a;
                s sVarD = D(view, true);
                s sVarS = s(view, true);
                if ((sVarD != null || sVarS != null) && dVar.e.E(sVar, sVarS)) {
                    if (animator.isRunning() || animator.isStarted()) {
                        animator.cancel();
                    } else {
                        aVarW.remove(animator);
                    }
                }
            }
        }
        n(viewGroup, this.f468p, this.f469q, this.f470t, this.f471u);
        S();
    }

    public l O(f fVar) {
        ArrayList arrayList = this.f450B;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(fVar);
        if (this.f450B.size() == 0) {
            this.f450B = null;
        }
        return this;
    }

    public l P(View view) {
        this.f459f.remove(view);
        return this;
    }

    public void Q(View view) {
        if (this.f476z) {
            if (!this.f449A) {
                androidx.collection.a aVarW = w();
                int size = aVarW.size();
                H hE = A.e(view);
                for (int i2 = size - 1; i2 >= 0; i2--) {
                    d dVar = (d) aVarW.valueAt(i2);
                    if (dVar.f480a != null && hE.equals(dVar.f483d)) {
                        AbstractC0105a.c((Animator) aVarW.keyAt(i2));
                    }
                }
                ArrayList arrayList = this.f450B;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.f450B.clone();
                    int size2 = arrayList2.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        ((f) arrayList2.get(i3)).d(this);
                    }
                }
            }
            this.f476z = false;
        }
    }

    protected void S() {
        Z();
        androidx.collection.a aVarW = w();
        Iterator it = this.f451C.iterator();
        while (it.hasNext()) {
            Animator animator = (Animator) it.next();
            if (aVarW.containsKey(animator)) {
                Z();
                R(animator, aVarW);
            }
        }
        this.f451C.clear();
        o();
    }

    public l T(long j2) {
        this.f457c = j2;
        return this;
    }

    public void U(e eVar) {
        this.f452D = eVar;
    }

    public l V(TimeInterpolator timeInterpolator) {
        this.f458d = timeInterpolator;
        return this;
    }

    public void W(AbstractC0111g abstractC0111g) {
        if (abstractC0111g == null) {
            this.f454F = f447H;
        } else {
            this.f454F = abstractC0111g;
        }
    }

    public l Y(long j2) {
        this.f456b = j2;
        return this;
    }

    protected void Z() {
        if (this.f475y == 0) {
            ArrayList arrayList = this.f450B;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f450B.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((f) arrayList2.get(i2)).c(this);
                }
            }
            this.f449A = false;
        }
        this.f475y++;
    }

    public l a(f fVar) {
        if (this.f450B == null) {
            this.f450B = new ArrayList();
        }
        this.f450B.add(fVar);
        return this;
    }

    String a0(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f457c != -1) {
            str2 = str2 + "dur(" + this.f457c + ") ";
        }
        if (this.f456b != -1) {
            str2 = str2 + "dly(" + this.f456b + ") ";
        }
        if (this.f458d != null) {
            str2 = str2 + "interp(" + this.f458d + ") ";
        }
        if (this.e.size() <= 0 && this.f459f.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.e.size() > 0) {
            for (int i2 = 0; i2 < this.e.size(); i2++) {
                if (i2 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.e.get(i2);
            }
        }
        if (this.f459f.size() > 0) {
            for (int i3 = 0; i3 < this.f459f.size(); i3++) {
                if (i3 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f459f.get(i3);
            }
        }
        return str3 + ")";
    }

    public l b(View view) {
        this.f459f.add(view);
        return this;
    }

    protected void e(Animator animator) {
        if (animator == null) {
            o();
            return;
        }
        if (p() >= 0) {
            animator.setDuration(p());
        }
        if (x() >= 0) {
            animator.setStartDelay(x());
        }
        if (r() != null) {
            animator.setInterpolator(r());
        }
        animator.addListener(new c());
        animator.start();
    }

    public abstract void f(s sVar);

    public abstract void i(s sVar);

    void j(ViewGroup viewGroup, boolean z2) {
        ArrayList arrayList;
        ArrayList arrayList2;
        androidx.collection.a aVar;
        k(z2);
        if ((this.e.size() > 0 || this.f459f.size() > 0) && (((arrayList = this.f460g) == null || arrayList.isEmpty()) && ((arrayList2 = this.f461h) == null || arrayList2.isEmpty()))) {
            for (int i2 = 0; i2 < this.e.size(); i2++) {
                View viewFindViewById = viewGroup.findViewById(((Integer) this.e.get(i2)).intValue());
                if (viewFindViewById != null) {
                    s sVar = new s();
                    sVar.f503b = viewFindViewById;
                    if (z2) {
                        i(sVar);
                    } else {
                        f(sVar);
                    }
                    sVar.f504c.add(this);
                    h(sVar);
                    if (z2) {
                        d(this.f468p, viewFindViewById, sVar);
                    } else {
                        d(this.f469q, viewFindViewById, sVar);
                    }
                }
            }
            for (int i3 = 0; i3 < this.f459f.size(); i3++) {
                View view = (View) this.f459f.get(i3);
                s sVar2 = new s();
                sVar2.f503b = view;
                if (z2) {
                    i(sVar2);
                } else {
                    f(sVar2);
                }
                sVar2.f504c.add(this);
                h(sVar2);
                if (z2) {
                    d(this.f468p, view, sVar2);
                } else {
                    d(this.f469q, view, sVar2);
                }
            }
        } else {
            g(viewGroup, z2);
        }
        if (z2 || (aVar = this.f453E) == null) {
            return;
        }
        int size = aVar.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i4 = 0; i4 < size; i4++) {
            arrayList3.add(this.f468p.f508d.remove((String) this.f453E.keyAt(i4)));
        }
        for (int i5 = 0; i5 < size; i5++) {
            View view2 = (View) arrayList3.get(i5);
            if (view2 != null) {
                this.f468p.f508d.put((String) this.f453E.valueAt(i5), view2);
            }
        }
    }

    void k(boolean z2) {
        if (z2) {
            this.f468p.f505a.clear();
            this.f468p.f506b.clear();
            this.f468p.f507c.b();
        } else {
            this.f469q.f505a.clear();
            this.f469q.f506b.clear();
            this.f469q.f507c.b();
        }
    }

    @Override // 
    /* renamed from: l */
    public l clone() {
        try {
            l lVar = (l) super.clone();
            lVar.f451C = new ArrayList();
            lVar.f468p = new t();
            lVar.f469q = new t();
            lVar.f470t = null;
            lVar.f471u = null;
            return lVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator m(ViewGroup viewGroup, s sVar, s sVar2) {
        return null;
    }

    protected void n(ViewGroup viewGroup, t tVar, t tVar2, ArrayList arrayList, ArrayList arrayList2) {
        View view;
        Animator animator;
        s sVar;
        int i2;
        Animator animator2;
        s sVar2;
        androidx.collection.a aVarW = w();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            s sVar3 = (s) arrayList.get(i3);
            s sVar4 = (s) arrayList2.get(i3);
            if (sVar3 != null && !sVar3.f504c.contains(this)) {
                sVar3 = null;
            }
            if (sVar4 != null && !sVar4.f504c.contains(this)) {
                sVar4 = null;
            }
            if ((sVar3 != null || sVar4 != null) && (sVar3 == null || sVar4 == null || E(sVar3, sVar4))) {
                Animator animatorM = m(viewGroup, sVar3, sVar4);
                if (animatorM != null) {
                    if (sVar4 != null) {
                        View view2 = sVar4.f503b;
                        String[] strArrC = C();
                        if (view2 == null || strArrC == null || strArrC.length <= 0) {
                            animator2 = animatorM;
                            sVar2 = null;
                        } else {
                            sVar2 = new s();
                            sVar2.f503b = view2;
                            s sVar5 = (s) tVar2.f505a.get(view2);
                            if (sVar5 != null) {
                                int i4 = 0;
                                while (i4 < strArrC.length) {
                                    Map map = sVar2.f502a;
                                    Animator animator3 = animatorM;
                                    String str = strArrC[i4];
                                    map.put(str, sVar5.f502a.get(str));
                                    i4++;
                                    animatorM = animator3;
                                    strArrC = strArrC;
                                }
                            }
                            Animator animator4 = animatorM;
                            int size2 = aVarW.size();
                            int i5 = 0;
                            while (true) {
                                if (i5 >= size2) {
                                    animator2 = animator4;
                                    break;
                                }
                                d dVar = (d) aVarW.get((Animator) aVarW.keyAt(i5));
                                if (dVar.f482c != null && dVar.f480a == view2 && dVar.f481b.equals(t()) && dVar.f482c.equals(sVar2)) {
                                    animator2 = null;
                                    break;
                                }
                                i5++;
                            }
                        }
                        view = view2;
                        animator = animator2;
                        sVar = sVar2;
                    } else {
                        view = sVar3.f503b;
                        animator = animatorM;
                        sVar = null;
                    }
                    if (animator != null) {
                        i2 = size;
                        aVarW.put(animator, new d(view, t(), this, A.e(viewGroup), sVar));
                        this.f451C.add(animator);
                    }
                    i3++;
                    size = i2;
                }
                i2 = size;
                i3++;
                size = i2;
            }
            i2 = size;
            i3++;
            size = i2;
        }
        if (Long.MAX_VALUE != 0) {
            for (int i6 = 0; i6 < sparseIntArray.size(); i6++) {
                Animator animator5 = (Animator) this.f451C.get(sparseIntArray.keyAt(i6));
                animator5.setStartDelay((sparseIntArray.valueAt(i6) - Long.MAX_VALUE) + animator5.getStartDelay());
            }
        }
    }

    protected void o() {
        int i2 = this.f475y - 1;
        this.f475y = i2;
        if (i2 == 0) {
            ArrayList arrayList = this.f450B;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f450B.clone();
                int size = arrayList2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((f) arrayList2.get(i3)).b(this);
                }
            }
            for (int i4 = 0; i4 < this.f468p.f507c.m(); i4++) {
                View view = (View) this.f468p.f507c.n(i4);
                if (view != null) {
                    M.o0(view, false);
                }
            }
            for (int i5 = 0; i5 < this.f469q.f507c.m(); i5++) {
                View view2 = (View) this.f469q.f507c.n(i5);
                if (view2 != null) {
                    M.o0(view2, false);
                }
            }
            this.f449A = true;
        }
    }

    public long p() {
        return this.f457c;
    }

    public e q() {
        return this.f452D;
    }

    public TimeInterpolator r() {
        return this.f458d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x002d, code lost:
    
        if (r3 < 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x002f, code lost:
    
        if (r7 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0031, code lost:
    
        r6 = r5.f471u;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0034, code lost:
    
        r6 = r5.f470t;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003d, code lost:
    
        return (O.s) r6.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    O.s s(android.view.View r6, boolean r7) {
        /*
            r5 = this;
            O.p r0 = r5.r
            if (r0 == 0) goto L9
            O.s r6 = r0.s(r6, r7)
            return r6
        L9:
            if (r7 == 0) goto Le
            java.util.ArrayList r0 = r5.f470t
            goto L10
        Le:
            java.util.ArrayList r0 = r5.f471u
        L10:
            r1 = 0
            if (r0 != 0) goto L14
            return r1
        L14:
            int r2 = r0.size()
            r3 = 0
        L19:
            if (r3 >= r2) goto L2c
            java.lang.Object r4 = r0.get(r3)
            O.s r4 = (O.s) r4
            if (r4 != 0) goto L24
            return r1
        L24:
            android.view.View r4 = r4.f503b
            if (r4 != r6) goto L29
            goto L2d
        L29:
            int r3 = r3 + 1
            goto L19
        L2c:
            r3 = -1
        L2d:
            if (r3 < 0) goto L3d
            if (r7 == 0) goto L34
            java.util.ArrayList r6 = r5.f471u
            goto L36
        L34:
            java.util.ArrayList r6 = r5.f470t
        L36:
            java.lang.Object r6 = r6.get(r3)
            r1 = r6
            O.s r1 = (O.s) r1
        L3d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: O.l.s(android.view.View, boolean):O.s");
    }

    public String t() {
        return this.f455a;
    }

    public String toString() {
        return a0("");
    }

    public AbstractC0111g u() {
        return this.f454F;
    }

    public o v() {
        return null;
    }

    public long x() {
        return this.f456b;
    }

    public List y() {
        return this.e;
    }

    public List z() {
        return this.f460g;
    }

    public void X(o oVar) {
    }

    void h(s sVar) {
    }
}
