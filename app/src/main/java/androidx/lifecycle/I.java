package androidx.lifecycle;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class I {

    /* renamed from: a, reason: collision with root package name */
    private final Map f3681a = new LinkedHashMap();

    public final void a() {
        Iterator it = this.f3681a.values().iterator();
        while (it.hasNext()) {
            ((E) it.next()).a();
        }
        this.f3681a.clear();
    }

    public final E b(String str) {
        i1.k.e(str, "key");
        return (E) this.f3681a.get(str);
    }

    public final Set c() {
        return new HashSet(this.f3681a.keySet());
    }

    public final void d(String str, E e) {
        i1.k.e(str, "key");
        i1.k.e(e, "viewModel");
        E e2 = (E) this.f3681a.put(str, e);
        if (e2 != null) {
            e2.d();
        }
    }
}
