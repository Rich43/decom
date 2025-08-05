package b1;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class D extends C {
    public static int a(int i2) {
        if (i2 < 0) {
            return i2;
        }
        if (i2 < 3) {
            return i2 + 1;
        }
        if (i2 < 1073741824) {
            return (int) ((i2 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static final Map b(a1.e eVar) {
        i1.k.e(eVar, "pair");
        Map mapSingletonMap = Collections.singletonMap(eVar.c(), eVar.d());
        i1.k.d(mapSingletonMap, "singletonMap(...)");
        return mapSingletonMap;
    }

    public static final Map c(Map map) {
        i1.k.e(map, "<this>");
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map mapSingletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        i1.k.d(mapSingletonMap, "with(...)");
        return mapSingletonMap;
    }
}
