package L0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import z0.EnumC0379a;
import z0.EnumC0383e;

/* loaded from: classes.dex */
public final class i extends k {

    /* renamed from: a */
    private final k[] f303a;

    public i(Map map) {
        Collection collection = map == null ? null : (Collection) map.get(EnumC0383e.POSSIBLE_FORMATS);
        boolean z2 = (map == null || map.get(EnumC0383e.ASSUME_CODE_39_CHECK_DIGIT) == null) ? false : true;
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(EnumC0379a.EAN_13) || collection.contains(EnumC0379a.UPC_A) || collection.contains(EnumC0379a.EAN_8) || collection.contains(EnumC0379a.UPC_E)) {
                arrayList.add(new j(map));
            }
            if (collection.contains(EnumC0379a.CODE_39)) {
                arrayList.add(new c(z2));
            }
            if (collection.contains(EnumC0379a.CODE_93)) {
                arrayList.add(new d());
            }
            if (collection.contains(EnumC0379a.CODE_128)) {
                arrayList.add(new b());
            }
            if (collection.contains(EnumC0379a.ITF)) {
                arrayList.add(new h());
            }
            if (collection.contains(EnumC0379a.CODABAR)) {
                arrayList.add(new a());
            }
            if (collection.contains(EnumC0379a.RSS_14)) {
                arrayList.add(new M0.e());
            }
            if (collection.contains(EnumC0379a.RSS_EXPANDED)) {
                arrayList.add(new N0.d());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new j(map));
            arrayList.add(new c());
            arrayList.add(new a());
            arrayList.add(new d());
            arrayList.add(new b());
            arrayList.add(new h());
            arrayList.add(new M0.e());
            arrayList.add(new N0.d());
        }
        this.f303a = (k[]) arrayList.toArray(new k[arrayList.size()]);
    }

    @Override // L0.k, z0.k
    public void b() {
        for (k kVar : this.f303a) {
            kVar.b();
        }
    }

    @Override // L0.k
    public z0.m c(int i2, D0.a aVar, Map map) throws z0.i {
        for (k kVar : this.f303a) {
            try {
                return kVar.c(i2, aVar, map);
            } catch (z0.l unused) {
            }
        }
        throw z0.i.a();
    }
}
