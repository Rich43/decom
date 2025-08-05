package b1;

import java.lang.reflect.Array;

/* renamed from: b1.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract class AbstractC0219g {
    public static final Object[] a(Object[] objArr, int i2) throws NegativeArraySizeException {
        i1.k.e(objArr, "reference");
        Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), i2);
        i1.k.c(objNewInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return (Object[]) objNewInstance;
    }
}
