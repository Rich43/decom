package Q0;

import z0.o;

/* loaded from: classes.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    private final D0.b f689a;

    /* renamed from: b, reason: collision with root package name */
    private final o f690b;

    /* renamed from: c, reason: collision with root package name */
    private final o f691c;

    /* renamed from: d, reason: collision with root package name */
    private final o f692d;
    private final o e;

    /* renamed from: f, reason: collision with root package name */
    private final int f693f;

    /* renamed from: g, reason: collision with root package name */
    private final int f694g;

    /* renamed from: h, reason: collision with root package name */
    private final int f695h;

    /* renamed from: i, reason: collision with root package name */
    private final int f696i;

    c(D0.b bVar, o oVar, o oVar2, o oVar3, o oVar4) throws z0.i {
        boolean z2 = oVar == null || oVar2 == null;
        boolean z3 = oVar3 == null || oVar4 == null;
        if (z2 && z3) {
            throw z0.i.a();
        }
        if (z2) {
            oVar = new o(0.0f, oVar3.d());
            oVar2 = new o(0.0f, oVar4.d());
        } else if (z3) {
            oVar3 = new o(bVar.j() - 1, oVar.d());
            oVar4 = new o(bVar.j() - 1, oVar2.d());
        }
        this.f689a = bVar;
        this.f690b = oVar;
        this.f691c = oVar2;
        this.f692d = oVar3;
        this.e = oVar4;
        this.f693f = (int) Math.min(oVar.c(), oVar2.c());
        this.f694g = (int) Math.max(oVar3.c(), oVar4.c());
        this.f695h = (int) Math.min(oVar.d(), oVar3.d());
        this.f696i = (int) Math.max(oVar2.d(), oVar4.d());
    }

    static c j(c cVar, c cVar2) {
        return cVar == null ? cVar2 : cVar2 == null ? cVar : new c(cVar.f689a, cVar.f690b, cVar.f691c, cVar2.f692d, cVar2.e);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    Q0.c a(int r13, int r14, boolean r15) {
        /*
            r12 = this;
            z0.o r0 = r12.f690b
            z0.o r1 = r12.f691c
            z0.o r2 = r12.f692d
            z0.o r3 = r12.e
            if (r13 <= 0) goto L2a
            if (r15 == 0) goto Le
            r4 = r0
            goto Lf
        Le:
            r4 = r2
        Lf:
            float r5 = r4.d()
            int r5 = (int) r5
            int r5 = r5 - r13
            if (r5 >= 0) goto L18
            r5 = 0
        L18:
            z0.o r13 = new z0.o
            float r4 = r4.c()
            float r5 = (float) r5
            r13.<init>(r4, r5)
            if (r15 == 0) goto L27
            r8 = r13
        L25:
            r10 = r2
            goto L2c
        L27:
            r10 = r13
            r8 = r0
            goto L2c
        L2a:
            r8 = r0
            goto L25
        L2c:
            if (r14 <= 0) goto L5d
            if (r15 == 0) goto L33
            z0.o r13 = r12.f691c
            goto L35
        L33:
            z0.o r13 = r12.e
        L35:
            float r0 = r13.d()
            int r0 = (int) r0
            int r0 = r0 + r14
            D0.b r14 = r12.f689a
            int r14 = r14.g()
            if (r0 < r14) goto L4b
            D0.b r14 = r12.f689a
            int r14 = r14.g()
            int r0 = r14 + (-1)
        L4b:
            z0.o r14 = new z0.o
            float r13 = r13.c()
            float r0 = (float) r0
            r14.<init>(r13, r0)
            if (r15 == 0) goto L5a
            r9 = r14
        L58:
            r11 = r3
            goto L5f
        L5a:
            r11 = r14
            r9 = r1
            goto L5f
        L5d:
            r9 = r1
            goto L58
        L5f:
            Q0.c r13 = new Q0.c
            D0.b r7 = r12.f689a
            r6 = r13
            r6.<init>(r7, r8, r9, r10, r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: Q0.c.a(int, int, boolean):Q0.c");
    }

    o b() {
        return this.f691c;
    }

    o c() {
        return this.e;
    }

    int d() {
        return this.f694g;
    }

    int e() {
        return this.f696i;
    }

    int f() {
        return this.f693f;
    }

    int g() {
        return this.f695h;
    }

    o h() {
        return this.f690b;
    }

    o i() {
        return this.f692d;
    }

    c(c cVar) {
        this.f689a = cVar.f689a;
        this.f690b = cVar.h();
        this.f691c = cVar.b();
        this.f692d = cVar.i();
        this.e = cVar.c();
        this.f693f = cVar.f();
        this.f694g = cVar.d();
        this.f695h = cVar.g();
        this.f696i = cVar.e();
    }
}
