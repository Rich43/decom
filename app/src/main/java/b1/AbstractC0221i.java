package b1;

import java.util.Arrays;
import java.util.List;

/* renamed from: b1.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract class AbstractC0221i extends AbstractC0220h {
    public static final List b(Object[] objArr) {
        i1.k.e(objArr, "<this>");
        List listA = AbstractC0223k.a(objArr);
        i1.k.d(listA, "asList(...)");
        return listA;
    }

    public static final Object[] c(Object[] objArr, Object[] objArr2, int i2, int i3, int i4) {
        i1.k.e(objArr, "<this>");
        i1.k.e(objArr2, "destination");
        System.arraycopy(objArr, i3, objArr2, i2, i4 - i3);
        return objArr2;
    }

    public static /* synthetic */ Object[] d(Object[] objArr, Object[] objArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = objArr.length;
        }
        return c(objArr, objArr2, i2, i3, i4);
    }

    public static final void e(Object[] objArr, Object obj, int i2, int i3) {
        i1.k.e(objArr, "<this>");
        Arrays.fill(objArr, i2, i3, obj);
    }
}
