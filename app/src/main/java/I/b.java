package I;

import androidx.lifecycle.E;
import androidx.lifecycle.F;
import androidx.lifecycle.G;
import i1.k;

/* loaded from: classes.dex */
public final class b implements F.b {

    /* renamed from: a, reason: collision with root package name */
    private final f[] f237a;

    public b(f... fVarArr) {
        k.e(fVarArr, "initializers");
        this.f237a = fVarArr;
    }

    @Override // androidx.lifecycle.F.b
    public /* synthetic */ E a(Class cls) {
        return G.a(this, cls);
    }

    @Override // androidx.lifecycle.F.b
    public E b(Class cls, a aVar) {
        k.e(cls, "modelClass");
        k.e(aVar, "extras");
        E e = null;
        for (f fVar : this.f237a) {
            if (k.a(fVar.a(), cls)) {
                Object objB = fVar.b().b(aVar);
                e = objB instanceof E ? (E) objB : null;
            }
        }
        if (e != null) {
            return e;
        }
        throw new IllegalArgumentException("No initializer set for given class " + cls.getName());
    }
}
