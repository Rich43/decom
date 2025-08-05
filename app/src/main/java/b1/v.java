package b1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class v extends u {
    public static boolean j(Iterable iterable, Object obj) {
        i1.k.e(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).contains(obj) : k(iterable, obj) >= 0;
    }

    public static final int k(Iterable iterable, Object obj) {
        i1.k.e(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(obj);
        }
        int i2 = 0;
        for (Object obj2 : iterable) {
            if (i2 < 0) {
                l.h();
            }
            if (i1.k.a(obj, obj2)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static List l(Iterable iterable, Iterable iterable2) {
        i1.k.e(iterable, "<this>");
        i1.k.e(iterable2, "other");
        Iterator it = iterable.iterator();
        Iterator it2 = iterable2.iterator();
        ArrayList arrayList = new ArrayList(Math.min(l.i(iterable, 10), l.i(iterable2, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(a1.g.a(it.next(), it2.next()));
        }
        return arrayList;
    }
}
