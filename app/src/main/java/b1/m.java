package b1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class m {
    public static final Object[] a(Object[] objArr, boolean z2) {
        i1.k.e(objArr, "<this>");
        if (z2 && i1.k.a(objArr.getClass(), Object[].class)) {
            return objArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length, Object[].class);
        i1.k.d(objArrCopyOf, "copyOf(...)");
        return objArrCopyOf;
    }

    public static List b(Object obj) {
        List listSingletonList = Collections.singletonList(obj);
        i1.k.d(listSingletonList, "singletonList(...)");
        return listSingletonList;
    }

    public static final Object[] c(int i2, Object[] objArr) {
        i1.k.e(objArr, "array");
        if (i2 < objArr.length) {
            objArr[i2] = null;
        }
        return objArr;
    }
}
