package androidx.lifecycle;

import androidx.lifecycle.F;

/* loaded from: classes.dex */
public abstract /* synthetic */ class G {
    public static E a(F.b bVar, Class cls) {
        i1.k.e(cls, "modelClass");
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    public static E b(F.b bVar, Class cls, I.a aVar) {
        i1.k.e(cls, "modelClass");
        i1.k.e(aVar, "extras");
        return bVar.a(cls);
    }
}
