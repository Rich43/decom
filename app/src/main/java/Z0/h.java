package z0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes.dex */
public final class h implements k {

    /* renamed from: a, reason: collision with root package name */
    private Map f7790a;

    /* renamed from: b, reason: collision with root package name */
    private k[] f7791b;

    private m c(C0381c c0381c) throws i {
        k[] kVarArr = this.f7791b;
        if (kVarArr != null) {
            for (k kVar : kVarArr) {
                try {
                    return kVar.a(c0381c, this.f7790a);
                } catch (l unused) {
                }
            }
        }
        throw i.a();
    }

    @Override // z0.k
    public m a(C0381c c0381c, Map map) {
        e(map);
        return c(c0381c);
    }

    @Override // z0.k
    public void b() {
        k[] kVarArr = this.f7791b;
        if (kVarArr != null) {
            for (k kVar : kVarArr) {
                kVar.b();
            }
        }
    }

    public m d(C0381c c0381c) {
        if (this.f7791b == null) {
            e(null);
        }
        return c(c0381c);
    }

    public void e(Map map) {
        this.f7790a = map;
        boolean z2 = map != null && map.containsKey(EnumC0383e.TRY_HARDER);
        Collection collection = map == null ? null : (Collection) map.get(EnumC0383e.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            boolean z3 = collection.contains(EnumC0379a.UPC_A) || collection.contains(EnumC0379a.UPC_E) || collection.contains(EnumC0379a.EAN_13) || collection.contains(EnumC0379a.EAN_8) || collection.contains(EnumC0379a.CODABAR) || collection.contains(EnumC0379a.CODE_39) || collection.contains(EnumC0379a.CODE_93) || collection.contains(EnumC0379a.CODE_128) || collection.contains(EnumC0379a.ITF) || collection.contains(EnumC0379a.RSS_14) || collection.contains(EnumC0379a.RSS_EXPANDED);
            if (z3 && !z2) {
                arrayList.add(new L0.i(map));
            }
            if (collection.contains(EnumC0379a.QR_CODE)) {
                arrayList.add(new T0.a());
            }
            if (collection.contains(EnumC0379a.DATA_MATRIX)) {
                arrayList.add(new G0.a());
            }
            if (collection.contains(EnumC0379a.AZTEC)) {
                arrayList.add(new A0.b());
            }
            if (collection.contains(EnumC0379a.PDF_417)) {
                arrayList.add(new P0.b());
            }
            if (collection.contains(EnumC0379a.MAXICODE)) {
                arrayList.add(new J0.a());
            }
            if (z3 && z2) {
                arrayList.add(new L0.i(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z2) {
                arrayList.add(new L0.i(map));
            }
            arrayList.add(new T0.a());
            arrayList.add(new G0.a());
            arrayList.add(new A0.b());
            arrayList.add(new P0.b());
            arrayList.add(new J0.a());
            if (z2) {
                arrayList.add(new L0.i(map));
            }
        }
        this.f7791b = (k[]) arrayList.toArray(new k[arrayList.size()]);
    }
}
