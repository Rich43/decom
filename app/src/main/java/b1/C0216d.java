package b1;

import java.util.Collection;
import java.util.Iterator;

/* renamed from: b1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0216d implements Collection, j1.a {

    /* renamed from: a, reason: collision with root package name */
    private final Object[] f4619a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f4620b;

    public C0216d(Object[] objArr, boolean z2) {
        i1.k.e(objArr, "values");
        this.f4619a = objArr;
        this.f4620b = z2;
    }

    public int a() {
        return this.f4619a.length;
    }

    @Override // java.util.Collection
    public boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return AbstractC0222j.f(this.f4619a, obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection collection) {
        i1.k.e(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f4619a.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return i1.b.a(this.f4619a);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return a();
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] objArr) {
        i1.k.e(objArr, "array");
        return i1.f.b(this, objArr);
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return m.a(this.f4619a, this.f4620b);
    }
}
