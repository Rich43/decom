package androidx.fragment.app;

import O.C0109e;
import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
abstract class F {

    /* renamed from: a, reason: collision with root package name */
    static final H f3397a = new G();

    /* renamed from: b, reason: collision with root package name */
    static final H f3398b = b();

    static void a(Fragment fragment, Fragment fragment2, boolean z2, androidx.collection.a aVar, boolean z3) {
        if (z2) {
            fragment2.getEnterTransitionCallback();
        } else {
            fragment.getEnterTransitionCallback();
        }
    }

    private static H b() {
        try {
            return (H) C0109e.class.getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }

    static void c(androidx.collection.a aVar, androidx.collection.a aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey((String) aVar.valueAt(size))) {
                aVar.removeAt(size);
            }
        }
    }

    static void d(ArrayList arrayList, int i2) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((View) arrayList.get(size)).setVisibility(i2);
        }
    }
}
