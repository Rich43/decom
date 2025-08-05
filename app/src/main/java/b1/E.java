package b1;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class E extends D {
    public static Map d() {
        y yVar = y.f4627a;
        i1.k.c(yVar, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return yVar;
    }

    public static final Map e(Map map) {
        i1.k.e(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? map : D.c(map) : B.d();
    }

    public static final void f(Map map, Iterable iterable) {
        i1.k.e(map, "<this>");
        i1.k.e(iterable, "pairs");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            a1.e eVar = (a1.e) it.next();
            map.put(eVar.a(), eVar.b());
        }
    }

    public static Map g(Iterable iterable) {
        i1.k.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return e(h(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return B.d();
        }
        if (size != 1) {
            return h(iterable, new LinkedHashMap(B.a(collection.size())));
        }
        return D.b((a1.e) (iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next()));
    }

    public static final Map h(Iterable iterable, Map map) {
        i1.k.e(iterable, "<this>");
        i1.k.e(map, "destination");
        f(map, iterable);
        return map;
    }

    public static Map i(Map map) {
        i1.k.e(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? j(map) : D.c(map) : B.d();
    }

    public static final Map j(Map map) {
        i1.k.e(map, "<this>");
        return new LinkedHashMap(map);
    }
}
