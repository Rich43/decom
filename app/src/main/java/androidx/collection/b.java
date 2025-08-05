package androidx.collection;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class b implements Collection, Set {
    private static final int[] e = new int[0];

    /* renamed from: f, reason: collision with root package name */
    private static final Object[] f2583f = new Object[0];

    /* renamed from: g, reason: collision with root package name */
    private static Object[] f2584g;

    /* renamed from: h, reason: collision with root package name */
    private static int f2585h;

    /* renamed from: i, reason: collision with root package name */
    private static Object[] f2586i;

    /* renamed from: j, reason: collision with root package name */
    private static int f2587j;

    /* renamed from: a, reason: collision with root package name */
    private int[] f2588a;

    /* renamed from: b, reason: collision with root package name */
    Object[] f2589b;

    /* renamed from: c, reason: collision with root package name */
    int f2590c;

    /* renamed from: d, reason: collision with root package name */
    private f f2591d;

    class a extends f {
        a() {
        }

        @Override // androidx.collection.f
        protected void a() {
            b.this.clear();
        }

        @Override // androidx.collection.f
        protected Object b(int i2, int i3) {
            return b.this.f2589b[i2];
        }

        @Override // androidx.collection.f
        protected Map c() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // androidx.collection.f
        protected int d() {
            return b.this.f2590c;
        }

        @Override // androidx.collection.f
        protected int e(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // androidx.collection.f
        protected int f(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // androidx.collection.f
        protected void g(Object obj, Object obj2) {
            b.this.add(obj);
        }

        @Override // androidx.collection.f
        protected void h(int i2) {
            b.this.g(i2);
        }

        @Override // androidx.collection.f
        protected Object i(int i2, Object obj) {
            throw new UnsupportedOperationException("not a map");
        }
    }

    public b() {
        this(0);
    }

    private void a(int i2) {
        if (i2 == 8) {
            synchronized (b.class) {
                try {
                    Object[] objArr = f2586i;
                    if (objArr != null) {
                        this.f2589b = objArr;
                        f2586i = (Object[]) objArr[0];
                        this.f2588a = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        f2587j--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i2 == 4) {
            synchronized (b.class) {
                try {
                    Object[] objArr2 = f2584g;
                    if (objArr2 != null) {
                        this.f2589b = objArr2;
                        f2584g = (Object[]) objArr2[0];
                        this.f2588a = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        f2585h--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.f2588a = new int[i2];
        this.f2589b = new Object[i2];
    }

    private static void c(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (b.class) {
                try {
                    if (f2587j < 10) {
                        objArr[0] = f2586i;
                        objArr[1] = iArr;
                        for (int i3 = i2 - 1; i3 >= 2; i3--) {
                            objArr[i3] = null;
                        }
                        f2586i = objArr;
                        f2587j++;
                    }
                } finally {
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (b.class) {
                try {
                    if (f2585h < 10) {
                        objArr[0] = f2584g;
                        objArr[1] = iArr;
                        for (int i4 = i2 - 1; i4 >= 2; i4--) {
                            objArr[i4] = null;
                        }
                        f2584g = objArr;
                        f2585h++;
                    }
                } finally {
                }
            }
        }
    }

    private f d() {
        if (this.f2591d == null) {
            this.f2591d = new a();
        }
        return this.f2591d;
    }

    private int e(Object obj, int i2) {
        int i3 = this.f2590c;
        if (i3 == 0) {
            return -1;
        }
        int iA = c.a(this.f2588a, i3, i2);
        if (iA < 0 || obj.equals(this.f2589b[iA])) {
            return iA;
        }
        int i4 = iA + 1;
        while (i4 < i3 && this.f2588a[i4] == i2) {
            if (obj.equals(this.f2589b[i4])) {
                return i4;
            }
            i4++;
        }
        for (int i5 = iA - 1; i5 >= 0 && this.f2588a[i5] == i2; i5--) {
            if (obj.equals(this.f2589b[i5])) {
                return i5;
            }
        }
        return ~i4;
    }

    private int f() {
        int i2 = this.f2590c;
        if (i2 == 0) {
            return -1;
        }
        int iA = c.a(this.f2588a, i2, 0);
        if (iA < 0 || this.f2589b[iA] == null) {
            return iA;
        }
        int i3 = iA + 1;
        while (i3 < i2 && this.f2588a[i3] == 0) {
            if (this.f2589b[i3] == null) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iA - 1; i4 >= 0 && this.f2588a[i4] == 0; i4--) {
            if (this.f2589b[i4] == null) {
                return i4;
            }
        }
        return ~i3;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        int i2;
        int iE;
        if (obj == null) {
            iE = f();
            i2 = 0;
        } else {
            int iHashCode = obj.hashCode();
            i2 = iHashCode;
            iE = e(obj, iHashCode);
        }
        if (iE >= 0) {
            return false;
        }
        int i3 = ~iE;
        int i4 = this.f2590c;
        int[] iArr = this.f2588a;
        if (i4 >= iArr.length) {
            int i5 = 8;
            if (i4 >= 8) {
                i5 = (i4 >> 1) + i4;
            } else if (i4 < 4) {
                i5 = 4;
            }
            Object[] objArr = this.f2589b;
            a(i5);
            int[] iArr2 = this.f2588a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f2589b, 0, objArr.length);
            }
            c(iArr, objArr, this.f2590c);
        }
        int i6 = this.f2590c;
        if (i3 < i6) {
            int[] iArr3 = this.f2588a;
            int i7 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i7, i6 - i3);
            Object[] objArr2 = this.f2589b;
            System.arraycopy(objArr2, i3, objArr2, i7, this.f2590c - i3);
        }
        this.f2588a[i3] = i2;
        this.f2589b[i3] = obj;
        this.f2590c++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection collection) {
        b(this.f2590c + collection.size());
        Iterator it = collection.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    public void b(int i2) {
        int[] iArr = this.f2588a;
        if (iArr.length < i2) {
            Object[] objArr = this.f2589b;
            a(i2);
            int i3 = this.f2590c;
            if (i3 > 0) {
                System.arraycopy(iArr, 0, this.f2588a, 0, i3);
                System.arraycopy(objArr, 0, this.f2589b, 0, this.f2590c);
            }
            c(iArr, objArr, this.f2590c);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i2 = this.f2590c;
        if (i2 != 0) {
            c(this.f2588a, this.f2589b, i2);
            this.f2588a = e;
            this.f2589b = f2583f;
            this.f2590c = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.f2590c; i2++) {
                try {
                    if (!set.contains(h(i2))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public Object g(int i2) {
        Object[] objArr = this.f2589b;
        Object obj = objArr[i2];
        int i3 = this.f2590c;
        if (i3 <= 1) {
            c(this.f2588a, objArr, i3);
            this.f2588a = e;
            this.f2589b = f2583f;
            this.f2590c = 0;
        } else {
            int[] iArr = this.f2588a;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                int i4 = i3 - 1;
                this.f2590c = i4;
                if (i2 < i4) {
                    int i5 = i2 + 1;
                    System.arraycopy(iArr, i5, iArr, i2, i4 - i2);
                    Object[] objArr2 = this.f2589b;
                    System.arraycopy(objArr2, i5, objArr2, i2, this.f2590c - i2);
                }
                this.f2589b[this.f2590c] = null;
            } else {
                a(i3 > 8 ? i3 + (i3 >> 1) : 8);
                this.f2590c--;
                if (i2 > 0) {
                    System.arraycopy(iArr, 0, this.f2588a, 0, i2);
                    System.arraycopy(objArr, 0, this.f2589b, 0, i2);
                }
                int i6 = this.f2590c;
                if (i2 < i6) {
                    int i7 = i2 + 1;
                    System.arraycopy(iArr, i7, this.f2588a, i2, i6 - i2);
                    System.arraycopy(objArr, i7, this.f2589b, i2, this.f2590c - i2);
                }
            }
        }
        return obj;
    }

    public Object h(int i2) {
        return this.f2589b[i2];
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f2588a;
        int i2 = this.f2590c;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += iArr[i4];
        }
        return i3;
    }

    public int indexOf(Object obj) {
        return obj == null ? f() : e(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f2590c <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return d().m().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        g(iIndexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection collection) {
        Iterator it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection collection) {
        boolean z2 = false;
        for (int i2 = this.f2590c - 1; i2 >= 0; i2--) {
            if (!collection.contains(this.f2589b[i2])) {
                g(i2);
                z2 = true;
            }
        }
        return z2;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f2590c;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i2 = this.f2590c;
        Object[] objArr = new Object[i2];
        System.arraycopy(this.f2589b, 0, objArr, 0, i2);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f2590c * 14);
        sb.append('{');
        for (int i2 = 0; i2 < this.f2590c; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object objH = h(i2);
            if (objH != this) {
                sb.append(objH);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public b(int i2) {
        if (i2 == 0) {
            this.f2588a = e;
            this.f2589b = f2583f;
        } else {
            a(i2);
        }
        this.f2590c = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray(Object[] objArr) {
        if (objArr.length < this.f2590c) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), this.f2590c);
        }
        System.arraycopy(this.f2589b, 0, objArr, 0, this.f2590c);
        int length = objArr.length;
        int i2 = this.f2590c;
        if (length > i2) {
            objArr[i2] = null;
        }
        return objArr;
    }
}
