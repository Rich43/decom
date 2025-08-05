package b1;

import java.util.Collection;

/* loaded from: classes.dex */
public abstract class o extends n {
    public static int i(Iterable iterable, int i2) {
        i1.k.e(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i2;
    }
}
