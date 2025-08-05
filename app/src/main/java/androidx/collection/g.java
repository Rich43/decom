package androidx.collection;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* loaded from: classes.dex */
public class g {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean CONCURRENT_MODIFICATION_EXCEPTIONS = true;
    private static final boolean DEBUG = false;
    private static final String TAG = "ArrayMap";
    static Object[] mBaseCache;
    static int mBaseCacheSize;
    static Object[] mTwiceBaseCache;
    static int mTwiceBaseCacheSize;
    Object[] mArray;
    int[] mHashes;
    int mSize;

    public g() {
        this.mHashes = c.f2593a;
        this.mArray = c.f2595c;
        this.mSize = 0;
    }

    private void a(int i2) {
        if (i2 == 8) {
            synchronized (g.class) {
                try {
                    Object[] objArr = mTwiceBaseCache;
                    if (objArr != null) {
                        this.mArray = objArr;
                        mTwiceBaseCache = (Object[]) objArr[0];
                        this.mHashes = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        mTwiceBaseCacheSize--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i2 == 4) {
            synchronized (g.class) {
                try {
                    Object[] objArr2 = mBaseCache;
                    if (objArr2 != null) {
                        this.mArray = objArr2;
                        mBaseCache = (Object[]) objArr2[0];
                        this.mHashes = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        mBaseCacheSize--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.mHashes = new int[i2];
        this.mArray = new Object[i2 << 1];
    }

    private static int b(int[] iArr, int i2, int i3) {
        try {
            return c.a(iArr, i2, i3);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private static void c(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (g.class) {
                try {
                    if (mTwiceBaseCacheSize < 10) {
                        objArr[0] = mTwiceBaseCache;
                        objArr[1] = iArr;
                        for (int i3 = (i2 << 1) - 1; i3 >= 2; i3--) {
                            objArr[i3] = null;
                        }
                        mTwiceBaseCache = objArr;
                        mTwiceBaseCacheSize++;
                    }
                } finally {
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (g.class) {
                try {
                    if (mBaseCacheSize < 10) {
                        objArr[0] = mBaseCache;
                        objArr[1] = iArr;
                        for (int i4 = (i2 << 1) - 1; i4 >= 2; i4--) {
                            objArr[i4] = null;
                        }
                        mBaseCache = objArr;
                        mBaseCacheSize++;
                    }
                } finally {
                }
            }
        }
    }

    public void clear() {
        int i2 = this.mSize;
        if (i2 > 0) {
            int[] iArr = this.mHashes;
            Object[] objArr = this.mArray;
            this.mHashes = c.f2593a;
            this.mArray = c.f2595c;
            this.mSize = 0;
            c(iArr, objArr, i2);
        }
        if (this.mSize > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        if (indexOfKey(obj) >= 0) {
            return true;
        }
        return DEBUG;
    }

    public boolean containsValue(Object obj) {
        if (indexOfValue(obj) >= 0) {
            return true;
        }
        return DEBUG;
    }

    public void ensureCapacity(int i2) {
        int i3 = this.mSize;
        int[] iArr = this.mHashes;
        if (iArr.length < i2) {
            Object[] objArr = this.mArray;
            a(i2);
            if (this.mSize > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, i3);
                System.arraycopy(objArr, 0, this.mArray, 0, i3 << 1);
            }
            c(iArr, objArr, i3);
        }
        if (this.mSize != i3) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (size() != gVar.size()) {
                return DEBUG;
            }
            for (int i2 = 0; i2 < this.mSize; i2++) {
                try {
                    Object objKeyAt = keyAt(i2);
                    Object objValueAt = valueAt(i2);
                    Object obj2 = gVar.get(objKeyAt);
                    if (objValueAt == null) {
                        if (obj2 != null || !gVar.containsKey(objKeyAt)) {
                            return DEBUG;
                        }
                    } else if (!objValueAt.equals(obj2)) {
                        return DEBUG;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return DEBUG;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return DEBUG;
            }
            for (int i3 = 0; i3 < this.mSize; i3++) {
                try {
                    Object objKeyAt2 = keyAt(i3);
                    Object objValueAt2 = valueAt(i3);
                    Object obj3 = map.get(objKeyAt2);
                    if (objValueAt2 == null) {
                        if (obj3 != null || !map.containsKey(objKeyAt2)) {
                            return DEBUG;
                        }
                    } else if (!objValueAt2.equals(obj3)) {
                        return DEBUG;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return DEBUG;
    }

    public Object get(Object obj) {
        return getOrDefault(obj, null);
    }

    public Object getOrDefault(Object obj, Object obj2) {
        int iIndexOfKey = indexOfKey(obj);
        return iIndexOfKey >= 0 ? this.mArray[(iIndexOfKey << 1) + 1] : obj2;
    }

    public int hashCode() {
        int[] iArr = this.mHashes;
        Object[] objArr = this.mArray;
        int i2 = this.mSize;
        int i3 = 1;
        int i4 = 0;
        int iHashCode = 0;
        while (i4 < i2) {
            Object obj = objArr[i3];
            iHashCode += (obj == null ? 0 : obj.hashCode()) ^ iArr[i4];
            i4++;
            i3 += 2;
        }
        return iHashCode;
    }

    int indexOf(Object obj, int i2) {
        int i3 = this.mSize;
        if (i3 == 0) {
            return -1;
        }
        int iB = b(this.mHashes, i3, i2);
        if (iB < 0 || obj.equals(this.mArray[iB << 1])) {
            return iB;
        }
        int i4 = iB + 1;
        while (i4 < i3 && this.mHashes[i4] == i2) {
            if (obj.equals(this.mArray[i4 << 1])) {
                return i4;
            }
            i4++;
        }
        for (int i5 = iB - 1; i5 >= 0 && this.mHashes[i5] == i2; i5--) {
            if (obj.equals(this.mArray[i5 << 1])) {
                return i5;
            }
        }
        return ~i4;
    }

    public int indexOfKey(Object obj) {
        return obj == null ? indexOfNull() : indexOf(obj, obj.hashCode());
    }

    int indexOfNull() {
        int i2 = this.mSize;
        if (i2 == 0) {
            return -1;
        }
        int iB = b(this.mHashes, i2, 0);
        if (iB < 0 || this.mArray[iB << 1] == null) {
            return iB;
        }
        int i3 = iB + 1;
        while (i3 < i2 && this.mHashes[i3] == 0) {
            if (this.mArray[i3 << 1] == null) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iB - 1; i4 >= 0 && this.mHashes[i4] == 0; i4--) {
            if (this.mArray[i4 << 1] == null) {
                return i4;
            }
        }
        return ~i3;
    }

    int indexOfValue(Object obj) {
        int i2 = this.mSize * 2;
        Object[] objArr = this.mArray;
        if (obj == null) {
            for (int i3 = 1; i3 < i2; i3 += 2) {
                if (objArr[i3] == null) {
                    return i3 >> 1;
                }
            }
            return -1;
        }
        for (int i4 = 1; i4 < i2; i4 += 2) {
            if (obj.equals(objArr[i4])) {
                return i4 >> 1;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        if (this.mSize <= 0) {
            return true;
        }
        return DEBUG;
    }

    public Object keyAt(int i2) {
        return this.mArray[i2 << 1];
    }

    public Object put(Object obj, Object obj2) {
        int i2;
        int iIndexOf;
        int i3 = this.mSize;
        if (obj == null) {
            iIndexOf = indexOfNull();
            i2 = 0;
        } else {
            int iHashCode = obj.hashCode();
            i2 = iHashCode;
            iIndexOf = indexOf(obj, iHashCode);
        }
        if (iIndexOf >= 0) {
            int i4 = (iIndexOf << 1) + 1;
            Object[] objArr = this.mArray;
            Object obj3 = objArr[i4];
            objArr[i4] = obj2;
            return obj3;
        }
        int i5 = ~iIndexOf;
        int[] iArr = this.mHashes;
        if (i3 >= iArr.length) {
            int i6 = 8;
            if (i3 >= 8) {
                i6 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i6 = 4;
            }
            Object[] objArr2 = this.mArray;
            a(i6);
            if (i3 != this.mSize) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.mHashes;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.mArray, 0, objArr2.length);
            }
            c(iArr, objArr2, i3);
        }
        if (i5 < i3) {
            int[] iArr3 = this.mHashes;
            int i7 = i5 + 1;
            System.arraycopy(iArr3, i5, iArr3, i7, i3 - i5);
            Object[] objArr3 = this.mArray;
            System.arraycopy(objArr3, i5 << 1, objArr3, i7 << 1, (this.mSize - i5) << 1);
        }
        int i8 = this.mSize;
        if (i3 == i8) {
            int[] iArr4 = this.mHashes;
            if (i5 < iArr4.length) {
                iArr4[i5] = i2;
                Object[] objArr4 = this.mArray;
                int i9 = i5 << 1;
                objArr4[i9] = obj;
                objArr4[i9 + 1] = obj2;
                this.mSize = i8 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public void putAll(g gVar) {
        int i2 = gVar.mSize;
        ensureCapacity(this.mSize + i2);
        if (this.mSize != 0) {
            for (int i3 = 0; i3 < i2; i3++) {
                put(gVar.keyAt(i3), gVar.valueAt(i3));
            }
        } else if (i2 > 0) {
            System.arraycopy(gVar.mHashes, 0, this.mHashes, 0, i2);
            System.arraycopy(gVar.mArray, 0, this.mArray, 0, i2 << 1);
            this.mSize = i2;
        }
    }

    public Object putIfAbsent(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 == null ? put(obj, obj2) : obj3;
    }

    public Object remove(Object obj) {
        int iIndexOfKey = indexOfKey(obj);
        if (iIndexOfKey >= 0) {
            return removeAt(iIndexOfKey);
        }
        return null;
    }

    public Object removeAt(int i2) {
        Object[] objArr = this.mArray;
        int i3 = i2 << 1;
        Object obj = objArr[i3 + 1];
        int i4 = this.mSize;
        int i5 = 0;
        if (i4 <= 1) {
            c(this.mHashes, objArr, i4);
            this.mHashes = c.f2593a;
            this.mArray = c.f2595c;
        } else {
            int i6 = i4 - 1;
            int[] iArr = this.mHashes;
            if (iArr.length <= 8 || i4 >= iArr.length / 3) {
                if (i2 < i6) {
                    int i7 = i2 + 1;
                    int i8 = i6 - i2;
                    System.arraycopy(iArr, i7, iArr, i2, i8);
                    Object[] objArr2 = this.mArray;
                    System.arraycopy(objArr2, i7 << 1, objArr2, i3, i8 << 1);
                }
                Object[] objArr3 = this.mArray;
                int i9 = i6 << 1;
                objArr3[i9] = null;
                objArr3[i9 + 1] = null;
            } else {
                a(i4 > 8 ? i4 + (i4 >> 1) : 8);
                if (i4 != this.mSize) {
                    throw new ConcurrentModificationException();
                }
                if (i2 > 0) {
                    System.arraycopy(iArr, 0, this.mHashes, 0, i2);
                    System.arraycopy(objArr, 0, this.mArray, 0, i3);
                }
                if (i2 < i6) {
                    int i10 = i2 + 1;
                    int i11 = i6 - i2;
                    System.arraycopy(iArr, i10, this.mHashes, i2, i11);
                    System.arraycopy(objArr, i10 << 1, this.mArray, i3, i11 << 1);
                }
            }
            i5 = i6;
        }
        if (i4 != this.mSize) {
            throw new ConcurrentModificationException();
        }
        this.mSize = i5;
        return obj;
    }

    public Object replace(Object obj, Object obj2) {
        int iIndexOfKey = indexOfKey(obj);
        if (iIndexOfKey >= 0) {
            return setValueAt(iIndexOfKey, obj2);
        }
        return null;
    }

    public Object setValueAt(int i2, Object obj) {
        int i3 = (i2 << 1) + 1;
        Object[] objArr = this.mArray;
        Object obj2 = objArr[i3];
        objArr[i3] = obj;
        return obj2;
    }

    public int size() {
        return this.mSize;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.mSize * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.mSize; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object objKeyAt = keyAt(i2);
            if (objKeyAt != this) {
                sb.append(objKeyAt);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object objValueAt = valueAt(i2);
            if (objValueAt != this) {
                sb.append(objValueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public Object valueAt(int i2) {
        return this.mArray[(i2 << 1) + 1];
    }

    public boolean remove(Object obj, Object obj2) {
        int iIndexOfKey = indexOfKey(obj);
        if (iIndexOfKey < 0) {
            return DEBUG;
        }
        Object objValueAt = valueAt(iIndexOfKey);
        if (obj2 != objValueAt && (obj2 == null || !obj2.equals(objValueAt))) {
            return DEBUG;
        }
        removeAt(iIndexOfKey);
        return true;
    }

    public boolean replace(Object obj, Object obj2, Object obj3) {
        int iIndexOfKey = indexOfKey(obj);
        if (iIndexOfKey < 0) {
            return DEBUG;
        }
        Object objValueAt = valueAt(iIndexOfKey);
        if (objValueAt != obj2 && (obj2 == null || !obj2.equals(objValueAt))) {
            return DEBUG;
        }
        setValueAt(iIndexOfKey, obj3);
        return true;
    }

    public g(int i2) {
        if (i2 == 0) {
            this.mHashes = c.f2593a;
            this.mArray = c.f2595c;
        } else {
            a(i2);
        }
        this.mSize = 0;
    }

    public g(g gVar) {
        this();
        if (gVar != null) {
            putAll(gVar);
        }
    }
}
