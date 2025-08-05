package P0;

import D0.e;
import Q0.j;
import java.util.ArrayList;
import java.util.Map;
import z0.C0381c;
import z0.EnumC0379a;
import z0.i;
import z0.k;
import z0.m;
import z0.n;
import z0.o;

/* loaded from: classes.dex */
public final class b implements k {
    private static m[] c(C0381c c0381c, Map map, boolean z2) throws i {
        ArrayList arrayList = new ArrayList();
        S0.b bVarB = S0.a.b(c0381c, map, z2);
        for (o[] oVarArr : bVarB.b()) {
            e eVarI = j.i(bVarB.a(), oVarArr[4], oVarArr[5], oVarArr[6], oVarArr[7], f(oVarArr), d(oVarArr));
            m mVar = new m(eVarI.h(), eVarI.e(), oVarArr, EnumC0379a.PDF_417);
            mVar.h(n.ERROR_CORRECTION_LEVEL, eVarI.b());
            c cVar = (c) eVarI.d();
            if (cVar != null) {
                mVar.h(n.PDF417_EXTRA_METADATA, cVar);
            }
            arrayList.add(mVar);
        }
        return (m[]) arrayList.toArray(new m[arrayList.size()]);
    }

    private static int d(o[] oVarArr) {
        return Math.max(Math.max(e(oVarArr[0], oVarArr[4]), (e(oVarArr[6], oVarArr[2]) * 17) / 18), Math.max(e(oVarArr[1], oVarArr[5]), (e(oVarArr[7], oVarArr[3]) * 17) / 18));
    }

    private static int e(o oVar, o oVar2) {
        if (oVar == null || oVar2 == null) {
            return 0;
        }
        return (int) Math.abs(oVar.c() - oVar2.c());
    }

    private static int f(o[] oVarArr) {
        return Math.min(Math.min(g(oVarArr[0], oVarArr[4]), (g(oVarArr[6], oVarArr[2]) * 17) / 18), Math.min(g(oVarArr[1], oVarArr[5]), (g(oVarArr[7], oVarArr[3]) * 17) / 18));
    }

    private static int g(o oVar, o oVar2) {
        if (oVar == null || oVar2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.abs(oVar.c() - oVar2.c());
    }

    @Override // z0.k
    public m a(C0381c c0381c, Map map) throws i {
        m mVar;
        m[] mVarArrC = c(c0381c, map, false);
        if (mVarArrC == null || mVarArrC.length == 0 || (mVar = mVarArrC[0]) == null) {
            throw i.a();
        }
        return mVar;
    }

    @Override // z0.k
    public void b() {
    }
}
