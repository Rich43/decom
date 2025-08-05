package b1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: b1.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0222j extends AbstractC0221i {
    public static final boolean f(Object[] objArr, Object obj) {
        i1.k.e(objArr, "<this>");
        return j(objArr, obj) >= 0;
    }

    public static List g(Object[] objArr) {
        i1.k.e(objArr, "<this>");
        return (List) h(objArr, new ArrayList());
    }

    public static final Collection h(Object[] objArr, Collection collection) {
        i1.k.e(objArr, "<this>");
        i1.k.e(collection, "destination");
        for (Object obj : objArr) {
            if (obj != null) {
                collection.add(obj);
            }
        }
        return collection;
    }

    public static final int i(Object[] objArr) {
        i1.k.e(objArr, "<this>");
        return objArr.length - 1;
    }

    public static final int j(Object[] objArr, Object obj) {
        i1.k.e(objArr, "<this>");
        int i2 = 0;
        if (obj == null) {
            int length = objArr.length;
            while (i2 < length) {
                if (objArr[i2] == null) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        int length2 = objArr.length;
        while (i2 < length2) {
            if (i1.k.a(obj, objArr[i2])) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static char k(char[] cArr) {
        i1.k.e(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static List l(Object[] objArr) {
        i1.k.e(objArr, "<this>");
        int length = objArr.length;
        return length != 0 ? length != 1 ? m(objArr) : l.b(objArr[0]) : l.e();
    }

    public static final List m(Object[] objArr) {
        i1.k.e(objArr, "<this>");
        return new ArrayList(n.d(objArr));
    }
}
