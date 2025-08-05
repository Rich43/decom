package Q0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private final Map f688a = new HashMap();

    b() {
    }

    int[] a() {
        ArrayList arrayList = new ArrayList();
        int iIntValue = -1;
        for (Map.Entry entry : this.f688a.entrySet()) {
            if (((Integer) entry.getValue()).intValue() > iIntValue) {
                iIntValue = ((Integer) entry.getValue()).intValue();
                arrayList.clear();
                arrayList.add(entry.getKey());
            } else if (((Integer) entry.getValue()).intValue() == iIntValue) {
                arrayList.add(entry.getKey());
            }
        }
        return P0.a.b(arrayList);
    }

    void b(int i2) {
        Integer num = (Integer) this.f688a.get(Integer.valueOf(i2));
        if (num == null) {
            num = 0;
        }
        this.f688a.put(Integer.valueOf(i2), Integer.valueOf(num.intValue() + 1));
    }
}
