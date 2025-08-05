package k;

import java.util.HashMap;
import java.util.Map;
import k.C0274b;

/* renamed from: k.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0273a extends C0274b {
    private final HashMap e = new HashMap();

    @Override // k.C0274b
    protected C0274b.c c(Object obj) {
        return (C0274b.c) this.e.get(obj);
    }

    public boolean contains(Object obj) {
        return this.e.containsKey(obj);
    }

    @Override // k.C0274b
    public Object g(Object obj, Object obj2) {
        C0274b.c cVarC = c(obj);
        if (cVarC != null) {
            return cVarC.f6498b;
        }
        this.e.put(obj, f(obj, obj2));
        return null;
    }

    @Override // k.C0274b
    public Object h(Object obj) {
        Object objH = super.h(obj);
        this.e.remove(obj);
        return objH;
    }

    public Map.Entry i(Object obj) {
        if (contains(obj)) {
            return ((C0274b.c) this.e.get(obj)).f6500d;
        }
        return null;
    }
}
