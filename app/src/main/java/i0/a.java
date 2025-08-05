package I0;

import D0.g;
import D0.i;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import z0.o;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final D0.b f242a;

    /* renamed from: b, reason: collision with root package name */
    private final E0.b f243b;

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final o f244a;

        /* renamed from: b, reason: collision with root package name */
        private final o f245b;

        /* renamed from: c, reason: collision with root package name */
        private final int f246c;

        o a() {
            return this.f244a;
        }

        o b() {
            return this.f245b;
        }

        int c() {
            return this.f246c;
        }

        public String toString() {
            return this.f244a + "/" + this.f245b + '/' + this.f246c;
        }

        private b(o oVar, o oVar2, int i2) {
            this.f244a = oVar;
            this.f245b = oVar2;
            this.f246c = i2;
        }
    }

    private static final class c implements Serializable, Comparator {
        private c() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b bVar, b bVar2) {
            return bVar.c() - bVar2.c();
        }
    }

    public a(D0.b bVar) {
        this.f242a = bVar;
        this.f243b = new E0.b(bVar);
    }

    private o a(o oVar, o oVar2, o oVar3, o oVar4, int i2) {
        float f2 = i2;
        float fD = d(oVar, oVar2) / f2;
        float fD2 = d(oVar3, oVar4);
        o oVar5 = new o(oVar4.c() + (((oVar4.c() - oVar3.c()) / fD2) * fD), oVar4.d() + (fD * ((oVar4.d() - oVar3.d()) / fD2)));
        float fD3 = d(oVar, oVar3) / f2;
        float fD4 = d(oVar2, oVar4);
        o oVar6 = new o(oVar4.c() + (((oVar4.c() - oVar2.c()) / fD4) * fD3), oVar4.d() + (fD3 * ((oVar4.d() - oVar2.d()) / fD4)));
        if (f(oVar5)) {
            return (f(oVar6) && Math.abs(h(oVar3, oVar5).c() - h(oVar2, oVar5).c()) > Math.abs(h(oVar3, oVar6).c() - h(oVar2, oVar6).c())) ? oVar6 : oVar5;
        }
        if (f(oVar6)) {
            return oVar6;
        }
        return null;
    }

    private o b(o oVar, o oVar2, o oVar3, o oVar4, int i2, int i3) {
        float fD = d(oVar, oVar2) / i2;
        float fD2 = d(oVar3, oVar4);
        o oVar5 = new o(oVar4.c() + (((oVar4.c() - oVar3.c()) / fD2) * fD), oVar4.d() + (fD * ((oVar4.d() - oVar3.d()) / fD2)));
        float fD3 = d(oVar, oVar3) / i3;
        float fD4 = d(oVar2, oVar4);
        o oVar6 = new o(oVar4.c() + (((oVar4.c() - oVar2.c()) / fD4) * fD3), oVar4.d() + (fD3 * ((oVar4.d() - oVar2.d()) / fD4)));
        if (f(oVar5)) {
            return (f(oVar6) && Math.abs(i2 - h(oVar3, oVar5).c()) + Math.abs(i3 - h(oVar2, oVar5).c()) > Math.abs(i2 - h(oVar3, oVar6).c()) + Math.abs(i3 - h(oVar2, oVar6).c())) ? oVar6 : oVar5;
        }
        if (f(oVar6)) {
            return oVar6;
        }
        return null;
    }

    private static int d(o oVar, o oVar2) {
        return E0.a.c(o.b(oVar, oVar2));
    }

    private static void e(Map map, o oVar) {
        Integer num = (Integer) map.get(oVar);
        map.put(oVar, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    private boolean f(o oVar) {
        return oVar.c() >= 0.0f && oVar.c() < ((float) this.f242a.j()) && oVar.d() > 0.0f && oVar.d() < ((float) this.f242a.g());
    }

    private static D0.b g(D0.b bVar, o oVar, o oVar2, o oVar3, o oVar4, int i2, int i3) {
        float f2 = i2 - 0.5f;
        float f3 = i3 - 0.5f;
        return i.b().c(bVar, i2, i3, 0.5f, 0.5f, f2, 0.5f, f2, f3, 0.5f, f3, oVar.c(), oVar.d(), oVar4.c(), oVar4.d(), oVar3.c(), oVar3.d(), oVar2.c(), oVar2.d());
    }

    private b h(o oVar, o oVar2) {
        int iC = (int) oVar.c();
        int iD = (int) oVar.d();
        int iC2 = (int) oVar2.c();
        int iD2 = (int) oVar2.d();
        int i2 = 0;
        boolean z2 = Math.abs(iD2 - iD) > Math.abs(iC2 - iC);
        if (z2) {
            iD = iC;
            iC = iD;
            iD2 = iC2;
            iC2 = iD2;
        }
        int iAbs = Math.abs(iC2 - iC);
        int iAbs2 = Math.abs(iD2 - iD);
        int i3 = (-iAbs) / 2;
        int i4 = iD < iD2 ? 1 : -1;
        int i5 = iC >= iC2 ? -1 : 1;
        boolean zD = this.f242a.d(z2 ? iD : iC, z2 ? iC : iD);
        while (iC != iC2) {
            boolean zD2 = this.f242a.d(z2 ? iD : iC, z2 ? iC : iD);
            if (zD2 != zD) {
                i2++;
                zD = zD2;
            }
            i3 += iAbs2;
            if (i3 > 0) {
                if (iD == iD2) {
                    break;
                }
                iD += i4;
                i3 -= iAbs;
            }
            iC += i5;
        }
        return new b(oVar, oVar2, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v3, types: [z0.o] */
    /* JADX WARN: Type inference failed for: r16v3, types: [z0.o] */
    /* JADX WARN: Type inference failed for: r22v0, types: [z0.o] */
    /* JADX WARN: Type inference failed for: r23v0, types: [I0.a] */
    /* JADX WARN: Type inference failed for: r2v4, types: [z0.o[]] */
    /* JADX WARN: Type inference failed for: r4v6, types: [z0.o[]] */
    /* JADX WARN: Type inference failed for: r6v2, types: [z0.o] */
    public g c() throws z0.i {
        o oVar;
        D0.b bVarG;
        o[] oVarArrC = this.f243b.c();
        o oVar2 = oVarArrC[0];
        o oVar3 = oVarArrC[1];
        o oVar4 = oVarArrC[2];
        o oVar5 = oVarArrC[3];
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(h(oVar2, oVar3));
        arrayList.add(h(oVar2, oVar4));
        arrayList.add(h(oVar3, oVar5));
        arrayList.add(h(oVar4, oVar5));
        C0007a c0007a = null;
        Collections.sort(arrayList, new c());
        b bVar = (b) arrayList.get(0);
        b bVar2 = (b) arrayList.get(1);
        HashMap map = new HashMap();
        e(map, bVar.a());
        e(map, bVar.b());
        e(map, bVar2.a());
        e(map, bVar2.b());
        Object obj = null;
        Object obj2 = null;
        for (Map.Entry entry : map.entrySet()) {
            ?? r16 = (o) entry.getKey();
            if (((Integer) entry.getValue()).intValue() == 2) {
                obj = r16;
            } else if (c0007a == null) {
                c0007a = r16;
            } else {
                obj2 = r16;
            }
        }
        if (c0007a == null || obj == null || obj2 == null) {
            throw z0.i.a();
        }
        ?? r4 = {c0007a, obj, obj2};
        o.e(r4);
        ?? r14 = r4[0];
        ?? r22 = r4[1];
        ?? r6 = r4[2];
        o oVar6 = !map.containsKey(oVar2) ? oVar2 : !map.containsKey(oVar3) ? oVar3 : !map.containsKey(oVar4) ? oVar4 : oVar5;
        int iC = h(r6, oVar6).c();
        int iC2 = h(r14, oVar6).c();
        if ((iC & 1) == 1) {
            iC++;
        }
        int i2 = iC + 2;
        if ((iC2 & 1) == 1) {
            iC2++;
        }
        int i3 = iC2 + 2;
        if (i2 * 4 >= i3 * 7 || i3 * 4 >= i2 * 7) {
            oVar = r6;
            o oVarB = b(r22, r14, r6, oVar6, i2, i3);
            if (oVarB != null) {
                oVar6 = oVarB;
            }
            int iC3 = h(oVar, oVar6).c();
            int iC4 = h(r14, oVar6).c();
            if ((iC3 & 1) == 1) {
                iC3++;
            }
            int i4 = iC3;
            if ((iC4 & 1) == 1) {
                iC4++;
            }
            bVarG = g(this.f242a, oVar, r22, r14, oVar6, i4, iC4);
        } else {
            o oVarA = a(r22, r14, r6, oVar6, Math.min(i3, i2));
            if (oVarA != null) {
                oVar6 = oVarA;
            }
            int iMax = Math.max(h(r6, oVar6).c(), h(r14, oVar6).c());
            int i5 = iMax + 1;
            int i6 = (i5 & 1) == 1 ? iMax + 2 : i5;
            bVarG = g(this.f242a, r6, r22, r14, oVar6, i6, i6);
            oVar = r6;
        }
        return new g(bVarG, new o[]{oVar, r22, r14, oVar6});
    }
}
