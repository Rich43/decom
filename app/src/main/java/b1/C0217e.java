package b1;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: b1.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0217e extends AbstractC0215c {

    /* renamed from: d, reason: collision with root package name */
    public static final a f4621d = new a(null);
    private static final Object[] e = new Object[0];

    /* renamed from: a, reason: collision with root package name */
    private int f4622a;

    /* renamed from: b, reason: collision with root package name */
    private Object[] f4623b = e;

    /* renamed from: c, reason: collision with root package name */
    private int f4624c;

    /* renamed from: b1.e$a */
    public static final class a {
        public /* synthetic */ a(i1.g gVar) {
            this();
        }

        private a() {
        }
    }

    private final void e(int i2, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.f4623b.length;
        while (i2 < length && it.hasNext()) {
            this.f4623b[i2] = it.next();
            i2++;
        }
        int i3 = this.f4622a;
        for (int i4 = 0; i4 < i3 && it.hasNext(); i4++) {
            this.f4623b[i4] = it.next();
        }
        this.f4624c = size() + collection.size();
    }

    private final void f(int i2) {
        Object[] objArr = new Object[i2];
        Object[] objArr2 = this.f4623b;
        AbstractC0221i.c(objArr2, objArr, 0, this.f4622a, objArr2.length);
        Object[] objArr3 = this.f4623b;
        int length = objArr3.length;
        int i3 = this.f4622a;
        AbstractC0221i.c(objArr3, objArr, length - i3, 0, i3);
        this.f4622a = 0;
        this.f4623b = objArr;
    }

    private final int g(int i2) {
        return i2 == 0 ? AbstractC0222j.i(this.f4623b) : i2 - 1;
    }

    private final void h(int i2) {
        if (i2 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f4623b;
        if (i2 <= objArr.length) {
            return;
        }
        if (objArr == e) {
            this.f4623b = new Object[m1.d.a(i2, 10)];
        } else {
            f(AbstractC0214b.f4618a.c(objArr.length, i2));
        }
    }

    private final int i(int i2) {
        if (i2 == AbstractC0222j.i(this.f4623b)) {
            return 0;
        }
        return i2 + 1;
    }

    private final int j(int i2) {
        return i2 < 0 ? i2 + this.f4623b.length : i2;
    }

    private final int k(int i2) {
        Object[] objArr = this.f4623b;
        return i2 >= objArr.length ? i2 - objArr.length : i2;
    }

    @Override // b1.AbstractC0215c
    public int a() {
        return this.f4624c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        d(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        i1.k.e(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        h(size() + collection.size());
        e(k(this.f4622a + size()), collection);
        return true;
    }

    @Override // b1.AbstractC0215c
    public Object b(int i2) {
        AbstractC0214b.f4618a.a(i2, size());
        if (i2 == n.f(this)) {
            return m();
        }
        if (i2 == 0) {
            return l();
        }
        int iK = k(this.f4622a + i2);
        Object obj = this.f4623b[iK];
        if (i2 < (size() >> 1)) {
            int i3 = this.f4622a;
            if (iK >= i3) {
                Object[] objArr = this.f4623b;
                AbstractC0221i.c(objArr, objArr, i3 + 1, i3, iK);
            } else {
                Object[] objArr2 = this.f4623b;
                AbstractC0221i.c(objArr2, objArr2, 1, 0, iK);
                Object[] objArr3 = this.f4623b;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i4 = this.f4622a;
                AbstractC0221i.c(objArr3, objArr3, i4 + 1, i4, objArr3.length - 1);
            }
            Object[] objArr4 = this.f4623b;
            int i5 = this.f4622a;
            objArr4[i5] = null;
            this.f4622a = i(i5);
        } else {
            int iK2 = k(this.f4622a + n.f(this));
            if (iK <= iK2) {
                Object[] objArr5 = this.f4623b;
                AbstractC0221i.c(objArr5, objArr5, iK, iK + 1, iK2 + 1);
            } else {
                Object[] objArr6 = this.f4623b;
                AbstractC0221i.c(objArr6, objArr6, iK, iK + 1, objArr6.length);
                Object[] objArr7 = this.f4623b;
                objArr7[objArr7.length - 1] = objArr7[0];
                AbstractC0221i.c(objArr7, objArr7, 0, 1, iK2 + 1);
            }
            this.f4623b[iK2] = null;
        }
        this.f4624c = size() - 1;
        return obj;
    }

    public final void c(Object obj) {
        h(size() + 1);
        int iG = g(this.f4622a);
        this.f4622a = iG;
        this.f4623b[iG] = obj;
        this.f4624c = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int iK = k(this.f4622a + size());
        int i2 = this.f4622a;
        if (i2 < iK) {
            AbstractC0221i.e(this.f4623b, null, i2, iK);
        } else if (!isEmpty()) {
            Object[] objArr = this.f4623b;
            AbstractC0221i.e(objArr, null, this.f4622a, objArr.length);
            AbstractC0221i.e(this.f4623b, null, 0, iK);
        }
        this.f4622a = 0;
        this.f4624c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(Object obj) {
        h(size() + 1);
        this.f4623b[k(this.f4622a + size())] = obj;
        this.f4624c = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i2) {
        AbstractC0214b.f4618a.a(i2, size());
        return this.f4623b[k(this.f4622a + i2)];
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i2;
        int iK = k(this.f4622a + size());
        int length = this.f4622a;
        if (length < iK) {
            while (length < iK) {
                if (i1.k.a(obj, this.f4623b[length])) {
                    i2 = this.f4622a;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iK) {
            return -1;
        }
        int length2 = this.f4623b.length;
        while (true) {
            if (length >= length2) {
                for (int i3 = 0; i3 < iK; i3++) {
                    if (i1.k.a(obj, this.f4623b[i3])) {
                        length = i3 + this.f4623b.length;
                        i2 = this.f4622a;
                    }
                }
                return -1;
            }
            if (i1.k.a(obj, this.f4623b[length])) {
                i2 = this.f4622a;
                break;
            }
            length++;
        }
        return length - i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    public final Object l() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        Object[] objArr = this.f4623b;
        int i2 = this.f4622a;
        Object obj = objArr[i2];
        objArr[i2] = null;
        this.f4622a = i(i2);
        this.f4624c = size() - 1;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int i2;
        int i3;
        int iK = k(this.f4622a + size());
        int i4 = this.f4622a;
        if (i4 < iK) {
            i2 = iK - 1;
            if (i4 <= i2) {
                while (!i1.k.a(obj, this.f4623b[i2])) {
                    if (i2 != i4) {
                        i2--;
                    }
                }
                i3 = this.f4622a;
                return i2 - i3;
            }
            return -1;
        }
        if (i4 > iK) {
            int i5 = iK - 1;
            while (true) {
                if (-1 >= i5) {
                    i2 = AbstractC0222j.i(this.f4623b);
                    int i6 = this.f4622a;
                    if (i6 <= i2) {
                        while (!i1.k.a(obj, this.f4623b[i2])) {
                            if (i2 != i6) {
                                i2--;
                            }
                        }
                        i3 = this.f4622a;
                    }
                } else {
                    if (i1.k.a(obj, this.f4623b[i5])) {
                        i2 = i5 + this.f4623b.length;
                        i3 = this.f4622a;
                        break;
                    }
                    i5--;
                }
            }
        }
        return -1;
    }

    public final Object m() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        int iK = k(this.f4622a + n.f(this));
        Object[] objArr = this.f4623b;
        Object obj = objArr[iK];
        objArr[iK] = null;
        this.f4624c = size() - 1;
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection collection) {
        int iK;
        i1.k.e(collection, "elements");
        boolean z2 = false;
        z2 = false;
        z2 = false;
        if (!isEmpty() && this.f4623b.length != 0) {
            int iK2 = k(this.f4622a + size());
            int i2 = this.f4622a;
            if (i2 < iK2) {
                iK = i2;
                while (i2 < iK2) {
                    Object obj = this.f4623b[i2];
                    if (collection.contains(obj)) {
                        z2 = true;
                    } else {
                        this.f4623b[iK] = obj;
                        iK++;
                    }
                    i2++;
                }
                AbstractC0221i.e(this.f4623b, null, iK, iK2);
            } else {
                int length = this.f4623b.length;
                int i3 = i2;
                boolean z3 = false;
                while (i2 < length) {
                    Object[] objArr = this.f4623b;
                    Object obj2 = objArr[i2];
                    objArr[i2] = null;
                    if (collection.contains(obj2)) {
                        z3 = true;
                    } else {
                        this.f4623b[i3] = obj2;
                        i3++;
                    }
                    i2++;
                }
                iK = k(i3);
                for (int i4 = 0; i4 < iK2; i4++) {
                    Object[] objArr2 = this.f4623b;
                    Object obj3 = objArr2[i4];
                    objArr2[i4] = null;
                    if (collection.contains(obj3)) {
                        z3 = true;
                    } else {
                        this.f4623b[iK] = obj3;
                        iK = i(iK);
                    }
                }
                z2 = z3;
            }
            if (z2) {
                this.f4624c = j(iK - this.f4622a);
            }
        }
        return z2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection collection) {
        int iK;
        i1.k.e(collection, "elements");
        boolean z2 = false;
        z2 = false;
        z2 = false;
        if (!isEmpty() && this.f4623b.length != 0) {
            int iK2 = k(this.f4622a + size());
            int i2 = this.f4622a;
            if (i2 < iK2) {
                iK = i2;
                while (i2 < iK2) {
                    Object obj = this.f4623b[i2];
                    if (collection.contains(obj)) {
                        this.f4623b[iK] = obj;
                        iK++;
                    } else {
                        z2 = true;
                    }
                    i2++;
                }
                AbstractC0221i.e(this.f4623b, null, iK, iK2);
            } else {
                int length = this.f4623b.length;
                int i3 = i2;
                boolean z3 = false;
                while (i2 < length) {
                    Object[] objArr = this.f4623b;
                    Object obj2 = objArr[i2];
                    objArr[i2] = null;
                    if (collection.contains(obj2)) {
                        this.f4623b[i3] = obj2;
                        i3++;
                    } else {
                        z3 = true;
                    }
                    i2++;
                }
                iK = k(i3);
                for (int i4 = 0; i4 < iK2; i4++) {
                    Object[] objArr2 = this.f4623b;
                    Object obj3 = objArr2[i4];
                    objArr2[i4] = null;
                    if (collection.contains(obj3)) {
                        this.f4623b[iK] = obj3;
                        iK = i(iK);
                    } else {
                        z3 = true;
                    }
                }
                z2 = z3;
            }
            if (z2) {
                this.f4624c = j(iK - this.f4622a);
            }
        }
        return z2;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i2, Object obj) {
        AbstractC0214b.f4618a.a(i2, size());
        int iK = k(this.f4622a + i2);
        Object[] objArr = this.f4623b;
        Object obj2 = objArr[iK];
        objArr[iK] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray(Object[] objArr) throws NegativeArraySizeException {
        i1.k.e(objArr, "array");
        if (objArr.length < size()) {
            objArr = AbstractC0219g.a(objArr, size());
        }
        int iK = k(this.f4622a + size());
        int i2 = this.f4622a;
        if (i2 < iK) {
            AbstractC0221i.d(this.f4623b, objArr, 0, i2, iK, 2, null);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.f4623b;
            AbstractC0221i.c(objArr2, objArr, 0, this.f4622a, objArr2.length);
            Object[] objArr3 = this.f4623b;
            AbstractC0221i.c(objArr3, objArr, objArr3.length - this.f4622a, 0, iK);
        }
        return m.c(size(), objArr);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i2, Object obj) {
        AbstractC0214b.f4618a.b(i2, size());
        if (i2 == size()) {
            d(obj);
            return;
        }
        if (i2 == 0) {
            c(obj);
            return;
        }
        h(size() + 1);
        int iK = k(this.f4622a + i2);
        if (i2 < ((size() + 1) >> 1)) {
            int iG = g(iK);
            int iG2 = g(this.f4622a);
            int i3 = this.f4622a;
            if (iG >= i3) {
                Object[] objArr = this.f4623b;
                objArr[iG2] = objArr[i3];
                AbstractC0221i.c(objArr, objArr, i3, i3 + 1, iG + 1);
            } else {
                Object[] objArr2 = this.f4623b;
                AbstractC0221i.c(objArr2, objArr2, i3 - 1, i3, objArr2.length);
                Object[] objArr3 = this.f4623b;
                objArr3[objArr3.length - 1] = objArr3[0];
                AbstractC0221i.c(objArr3, objArr3, 0, 1, iG + 1);
            }
            this.f4623b[iG] = obj;
            this.f4622a = iG2;
        } else {
            int iK2 = k(this.f4622a + size());
            if (iK < iK2) {
                Object[] objArr4 = this.f4623b;
                AbstractC0221i.c(objArr4, objArr4, iK + 1, iK, iK2);
            } else {
                Object[] objArr5 = this.f4623b;
                AbstractC0221i.c(objArr5, objArr5, 1, 0, iK2);
                Object[] objArr6 = this.f4623b;
                objArr6[0] = objArr6[objArr6.length - 1];
                AbstractC0221i.c(objArr6, objArr6, iK + 1, iK, objArr6.length - 1);
            }
            this.f4623b[iK] = obj;
        }
        this.f4624c = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i2, Collection collection) {
        i1.k.e(collection, "elements");
        AbstractC0214b.f4618a.b(i2, size());
        if (collection.isEmpty()) {
            return false;
        }
        if (i2 == size()) {
            return addAll(collection);
        }
        h(size() + collection.size());
        int iK = k(this.f4622a + size());
        int iK2 = k(this.f4622a + i2);
        int size = collection.size();
        if (i2 < ((size() + 1) >> 1)) {
            int i3 = this.f4622a;
            int length = i3 - size;
            if (iK2 < i3) {
                Object[] objArr = this.f4623b;
                AbstractC0221i.c(objArr, objArr, length, i3, objArr.length);
                if (size >= iK2) {
                    Object[] objArr2 = this.f4623b;
                    AbstractC0221i.c(objArr2, objArr2, objArr2.length - size, 0, iK2);
                } else {
                    Object[] objArr3 = this.f4623b;
                    AbstractC0221i.c(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.f4623b;
                    AbstractC0221i.c(objArr4, objArr4, 0, size, iK2);
                }
            } else if (length >= 0) {
                Object[] objArr5 = this.f4623b;
                AbstractC0221i.c(objArr5, objArr5, length, i3, iK2);
            } else {
                Object[] objArr6 = this.f4623b;
                length += objArr6.length;
                int i4 = iK2 - i3;
                int length2 = objArr6.length - length;
                if (length2 >= i4) {
                    AbstractC0221i.c(objArr6, objArr6, length, i3, iK2);
                } else {
                    AbstractC0221i.c(objArr6, objArr6, length, i3, i3 + length2);
                    Object[] objArr7 = this.f4623b;
                    AbstractC0221i.c(objArr7, objArr7, 0, this.f4622a + length2, iK2);
                }
            }
            this.f4622a = length;
            e(j(iK2 - size), collection);
        } else {
            int i5 = iK2 + size;
            if (iK2 < iK) {
                int i6 = size + iK;
                Object[] objArr8 = this.f4623b;
                if (i6 <= objArr8.length) {
                    AbstractC0221i.c(objArr8, objArr8, i5, iK2, iK);
                } else if (i5 >= objArr8.length) {
                    AbstractC0221i.c(objArr8, objArr8, i5 - objArr8.length, iK2, iK);
                } else {
                    int length3 = iK - (i6 - objArr8.length);
                    AbstractC0221i.c(objArr8, objArr8, 0, length3, iK);
                    Object[] objArr9 = this.f4623b;
                    AbstractC0221i.c(objArr9, objArr9, i5, iK2, length3);
                }
            } else {
                Object[] objArr10 = this.f4623b;
                AbstractC0221i.c(objArr10, objArr10, size, 0, iK);
                Object[] objArr11 = this.f4623b;
                if (i5 >= objArr11.length) {
                    AbstractC0221i.c(objArr11, objArr11, i5 - objArr11.length, iK2, objArr11.length);
                } else {
                    AbstractC0221i.c(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.f4623b;
                    AbstractC0221i.c(objArr12, objArr12, i5, iK2, objArr12.length - size);
                }
            }
            e(iK2, collection);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
