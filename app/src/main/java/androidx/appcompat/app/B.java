package androidx.appcompat.app;

import java.util.LinkedHashSet;
import java.util.Locale;

/* loaded from: classes.dex */
abstract class B {
    private static androidx.core.os.e a(androidx.core.os.e eVar, androidx.core.os.e eVar2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i2 = 0;
        while (i2 < eVar.g() + eVar2.g()) {
            Locale localeD = i2 < eVar.g() ? eVar.d(i2) : eVar2.d(i2 - eVar.g());
            if (localeD != null) {
                linkedHashSet.add(localeD);
            }
            i2++;
        }
        return androidx.core.os.e.a((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
    }

    static androidx.core.os.e b(androidx.core.os.e eVar, androidx.core.os.e eVar2) {
        return (eVar == null || eVar.f()) ? androidx.core.os.e.e() : a(eVar, eVar2);
    }
}
