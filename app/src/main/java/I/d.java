package I;

import I.a;
import i1.g;
import i1.k;

/* loaded from: classes.dex */
public final class d extends a {
    public d() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // I.a
    public Object a(a.b bVar) {
        k.e(bVar, "key");
        return b().get(bVar);
    }

    public final void c(a.b bVar, Object obj) {
        k.e(bVar, "key");
        b().put(bVar, obj);
    }

    public d(a aVar) {
        k.e(aVar, "initialExtras");
        b().putAll(aVar.b());
    }

    public /* synthetic */ d(a aVar, int i2, g gVar) {
        this((i2 & 1) != 0 ? a.C0006a.f236b : aVar);
    }
}
