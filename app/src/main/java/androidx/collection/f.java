package androidx.collection;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes.dex */
abstract class f {

    /* renamed from: a, reason: collision with root package name */
    b f2607a;

    /* renamed from: b, reason: collision with root package name */
    c f2608b;

    /* renamed from: c, reason: collision with root package name */
    e f2609c;

    final class a implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        final int f2610a;

        /* renamed from: b, reason: collision with root package name */
        int f2611b;

        /* renamed from: c, reason: collision with root package name */
        int f2612c;

        /* renamed from: d, reason: collision with root package name */
        boolean f2613d = false;

        a(int i2) {
            this.f2610a = i2;
            this.f2611b = f.this.d();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2612c < this.f2611b;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Object objB = f.this.b(this.f2612c, this.f2610a);
            this.f2612c++;
            this.f2613d = true;
            return objB;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f2613d) {
                throw new IllegalStateException();
            }
            int i2 = this.f2612c - 1;
            this.f2612c = i2;
            this.f2611b--;
            this.f2613d = false;
            f.this.h(i2);
        }
    }

    final class b implements Set {
        b() {
        }

        @Override // java.util.Set, java.util.Collection
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection collection) {
            int iD = f.this.d();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                f.this.g(entry.getKey(), entry.getValue());
            }
            return iD != f.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            f.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int iE = f.this.e(entry.getKey());
            if (iE < 0) {
                return false;
            }
            return androidx.collection.c.c(f.this.b(iE, 1), entry.getValue());
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return f.k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iD = f.this.d() - 1; iD >= 0; iD--) {
                Object objB = f.this.b(iD, 0);
                Object objB2 = f.this.b(iD, 1);
                iHashCode += (objB == null ? 0 : objB.hashCode()) ^ (objB2 == null ? 0 : objB2.hashCode());
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return f.this.d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return f.this.new d();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return f.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            throw new UnsupportedOperationException();
        }
    }

    final class c implements Set {
        c() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            f.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return f.this.e(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection collection) {
            return f.j(f.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return f.k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iD = f.this.d() - 1; iD >= 0; iD--) {
                Object objB = f.this.b(iD, 0);
                iHashCode += objB == null ? 0 : objB.hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return f.this.d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return f.this.new a(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int iE = f.this.e(obj);
            if (iE < 0) {
                return false;
            }
            f.this.h(iE);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection collection) {
            return f.o(f.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection collection) {
            return f.p(f.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return f.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return f.this.q(0);
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return f.this.r(objArr, 0);
        }
    }

    final class d implements Iterator, Map.Entry {

        /* renamed from: a, reason: collision with root package name */
        int f2616a;

        /* renamed from: c, reason: collision with root package name */
        boolean f2618c = false;

        /* renamed from: b, reason: collision with root package name */
        int f2617b = -1;

        d() {
            this.f2616a = f.this.d() - 1;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f2617b++;
            this.f2618c = true;
            return this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!this.f2618c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return androidx.collection.c.c(entry.getKey(), f.this.b(this.f2617b, 0)) && androidx.collection.c.c(entry.getValue(), f.this.b(this.f2617b, 1));
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            if (this.f2618c) {
                return f.this.b(this.f2617b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            if (this.f2618c) {
                return f.this.b(this.f2617b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2617b < this.f2616a;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.f2618c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object objB = f.this.b(this.f2617b, 0);
            Object objB2 = f.this.b(this.f2617b, 1);
            return (objB == null ? 0 : objB.hashCode()) ^ (objB2 != null ? objB2.hashCode() : 0);
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f2618c) {
                throw new IllegalStateException();
            }
            f.this.h(this.f2617b);
            this.f2617b--;
            this.f2616a--;
            this.f2618c = false;
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (this.f2618c) {
                return f.this.i(this.f2617b, obj);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    final class e implements Collection {
        e() {
        }

        @Override // java.util.Collection
        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            f.this.a();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return f.this.f(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection collection) {
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
            return f.this.d() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return f.this.new a(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int iF = f.this.f(obj);
            if (iF < 0) {
                return false;
            }
            f.this.h(iF);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection collection) {
            int iD = f.this.d();
            int i2 = 0;
            boolean z2 = false;
            while (i2 < iD) {
                if (collection.contains(f.this.b(i2, 1))) {
                    f.this.h(i2);
                    i2--;
                    iD--;
                    z2 = true;
                }
                i2++;
            }
            return z2;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection collection) {
            int iD = f.this.d();
            int i2 = 0;
            boolean z2 = false;
            while (i2 < iD) {
                if (!collection.contains(f.this.b(i2, 1))) {
                    f.this.h(i2);
                    i2--;
                    iD--;
                    z2 = true;
                }
                i2++;
            }
            return z2;
        }

        @Override // java.util.Collection
        public int size() {
            return f.this.d();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return f.this.q(1);
        }

        @Override // java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return f.this.r(objArr, 1);
        }
    }

    f() {
    }

    public static boolean j(Map map, Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean k(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static boolean o(Map map, Collection collection) {
        int size = map.size();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static boolean p(Map map, Collection collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    protected abstract void a();

    protected abstract Object b(int i2, int i3);

    protected abstract Map c();

    protected abstract int d();

    protected abstract int e(Object obj);

    protected abstract int f(Object obj);

    protected abstract void g(Object obj, Object obj2);

    protected abstract void h(int i2);

    protected abstract Object i(int i2, Object obj);

    public Set l() {
        if (this.f2607a == null) {
            this.f2607a = new b();
        }
        return this.f2607a;
    }

    public Set m() {
        if (this.f2608b == null) {
            this.f2608b = new c();
        }
        return this.f2608b;
    }

    public Collection n() {
        if (this.f2609c == null) {
            this.f2609c = new e();
        }
        return this.f2609c;
    }

    public Object[] q(int i2) {
        int iD = d();
        Object[] objArr = new Object[iD];
        for (int i3 = 0; i3 < iD; i3++) {
            objArr[i3] = b(i3, i2);
        }
        return objArr;
    }

    public Object[] r(Object[] objArr, int i2) {
        int iD = d();
        if (objArr.length < iD) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), iD);
        }
        for (int i3 = 0; i3 < iD; i3++) {
            objArr[i3] = b(i3, i2);
        }
        if (objArr.length > iD) {
            objArr[iD] = null;
        }
        return objArr;
    }
}
