package androidx.coordinatorlayout.widget;

import androidx.collection.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import v.C0343f;
import v.InterfaceC0342e;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC0342e f2841a = new C0343f(10);

    /* renamed from: b, reason: collision with root package name */
    private final g f2842b = new g();

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList f2843c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private final HashSet f2844d = new HashSet();

    private void e(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (arrayList.contains(obj)) {
            return;
        }
        if (hashSet.contains(obj)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(obj);
        ArrayList arrayList2 = (ArrayList) this.f2842b.get(obj);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i2 = 0; i2 < size; i2++) {
                e(arrayList2.get(i2), arrayList, hashSet);
            }
        }
        hashSet.remove(obj);
        arrayList.add(obj);
    }

    private ArrayList f() {
        ArrayList arrayList = (ArrayList) this.f2841a.acquire();
        return arrayList == null ? new ArrayList() : arrayList;
    }

    private void j(ArrayList arrayList) {
        arrayList.clear();
        this.f2841a.release(arrayList);
    }

    public void a(Object obj, Object obj2) {
        if (!this.f2842b.containsKey(obj) || !this.f2842b.containsKey(obj2)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList arrayListF = (ArrayList) this.f2842b.get(obj);
        if (arrayListF == null) {
            arrayListF = f();
            this.f2842b.put(obj, arrayListF);
        }
        arrayListF.add(obj2);
    }

    public void b(Object obj) {
        if (this.f2842b.containsKey(obj)) {
            return;
        }
        this.f2842b.put(obj, null);
    }

    public void c() {
        int size = this.f2842b.size();
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList arrayList = (ArrayList) this.f2842b.valueAt(i2);
            if (arrayList != null) {
                j(arrayList);
            }
        }
        this.f2842b.clear();
    }

    public boolean d(Object obj) {
        return this.f2842b.containsKey(obj);
    }

    public List g(Object obj) {
        int size = this.f2842b.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList arrayList2 = (ArrayList) this.f2842b.valueAt(i2);
            if (arrayList2 != null && arrayList2.contains(obj)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f2842b.keyAt(i2));
            }
        }
        return arrayList;
    }

    public ArrayList h() {
        this.f2843c.clear();
        this.f2844d.clear();
        int size = this.f2842b.size();
        for (int i2 = 0; i2 < size; i2++) {
            e(this.f2842b.keyAt(i2), this.f2843c, this.f2844d);
        }
        return this.f2843c;
    }

    public boolean i(Object obj) {
        int size = this.f2842b.size();
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList arrayList = (ArrayList) this.f2842b.valueAt(i2);
            if (arrayList != null && arrayList.contains(obj)) {
                return true;
            }
        }
        return false;
    }
}
