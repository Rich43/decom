package L0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import z0.EnumC0379a;
import z0.EnumC0383e;

/* loaded from: classes.dex */
public final class j extends k {

    /* renamed from: a, reason: collision with root package name */
    private final p[] f304a;

    public j(Map map) {
        Collection collection = map == null ? null : (Collection) map.get(EnumC0383e.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(EnumC0379a.EAN_13)) {
                arrayList.add(new e());
            } else if (collection.contains(EnumC0379a.UPC_A)) {
                arrayList.add(new l());
            }
            if (collection.contains(EnumC0379a.EAN_8)) {
                arrayList.add(new f());
            }
            if (collection.contains(EnumC0379a.UPC_E)) {
                arrayList.add(new q());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new e());
            arrayList.add(new f());
            arrayList.add(new q());
        }
        this.f304a = (p[]) arrayList.toArray(new p[arrayList.size()]);
    }

    @Override // L0.k, z0.k
    public void b() {
        for (p pVar : this.f304a) {
            pVar.b();
        }
    }

    @Override // L0.k
    public z0.m c(int i2, D0.a aVar, Map map) throws z0.i {
        int[] iArrP = p.p(aVar);
        for (p pVar : this.f304a) {
            try {
                z0.m mVarM = pVar.m(i2, aVar, iArrP, map);
                boolean z2 = mVarM.b() == EnumC0379a.EAN_13 && mVarM.f().charAt(0) == '0';
                Collection collection = map == null ? null : (Collection) map.get(EnumC0383e.POSSIBLE_FORMATS);
                boolean z3 = collection == null || collection.contains(EnumC0379a.UPC_A);
                if (!z2 || !z3) {
                    return mVarM;
                }
                z0.m mVar = new z0.m(mVarM.f().substring(1), mVarM.c(), mVarM.e(), EnumC0379a.UPC_A);
                mVar.g(mVarM.d());
                return mVar;
            } catch (z0.l unused) {
            }
        }
        throw z0.i.a();
    }
}
