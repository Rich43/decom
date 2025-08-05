package I;

import androidx.lifecycle.F;
import h1.l;
import i1.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final List f238a = new ArrayList();

    public final void a(n1.b bVar, l lVar) {
        k.e(bVar, "clazz");
        k.e(lVar, "initializer");
        this.f238a.add(new f(g1.a.a(bVar), lVar));
    }

    public final F.b b() {
        f[] fVarArr = (f[]) this.f238a.toArray(new f[0]);
        return new b((f[]) Arrays.copyOf(fVarArr, fVarArr.length));
    }
}
