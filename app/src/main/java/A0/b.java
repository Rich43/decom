package A0;

import z0.k;

/* loaded from: classes.dex */
public final class b implements k {
    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0060 A[LOOP:0: B:32:0x005e->B:33:0x0060, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0091  */
    @Override // z0.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public z0.m a(z0.C0381c r11, java.util.Map r12) throws z0.C0384f, z0.i {
        /*
            r10 = this;
            C0.a r0 = new C0.a
            D0.b r11 = r11.a()
            r0.<init>(r11)
            r11 = 0
            r1 = 0
            A0.a r2 = r0.a(r11)     // Catch: z0.C0384f -> L25 z0.i -> L28
            z0.o[] r3 = r2.b()     // Catch: z0.C0384f -> L25 z0.i -> L28
            B0.a r4 = new B0.a     // Catch: z0.C0384f -> L21 z0.i -> L23
            r4.<init>()     // Catch: z0.C0384f -> L21 z0.i -> L23
            D0.e r2 = r4.c(r2)     // Catch: z0.C0384f -> L21 z0.i -> L23
            r4 = r3
            r3 = r1
            r1 = r2
            r2 = r3
            goto L31
        L21:
            r2 = move-exception
            goto L2b
        L23:
            r2 = move-exception
            goto L2f
        L25:
            r2 = move-exception
            r3 = r1
            goto L2b
        L28:
            r2 = move-exception
            r3 = r1
            goto L2f
        L2b:
            r4 = r3
            r3 = r2
            r2 = r1
            goto L31
        L2f:
            r4 = r3
            r3 = r1
        L31:
            if (r1 != 0) goto L45
            r1 = 1
            A0.a r0 = r0.a(r1)     // Catch: z0.C0384f -> L47 z0.i -> L49
            z0.o[] r4 = r0.b()     // Catch: z0.C0384f -> L47 z0.i -> L49
            B0.a r1 = new B0.a     // Catch: z0.C0384f -> L47 z0.i -> L49
            r1.<init>()     // Catch: z0.C0384f -> L47 z0.i -> L49
            D0.e r1 = r1.c(r0)     // Catch: z0.C0384f -> L47 z0.i -> L49
        L45:
            r6 = r4
            goto L51
        L47:
            r11 = move-exception
            goto L4a
        L49:
            r11 = move-exception
        L4a:
            if (r2 != 0) goto L50
            if (r3 == 0) goto L4f
            throw r3
        L4f:
            throw r11
        L50:
            throw r2
        L51:
            if (r12 == 0) goto L68
            z0.e r0 = z0.EnumC0383e.NEED_RESULT_POINT_CALLBACK
            java.lang.Object r12 = r12.get(r0)
            z0.p r12 = (z0.p) r12
            if (r12 == 0) goto L68
            int r0 = r6.length
        L5e:
            if (r11 >= r0) goto L68
            r2 = r6[r11]
            r12.a(r2)
            int r11 = r11 + 1
            goto L5e
        L68:
            z0.m r11 = new z0.m
            java.lang.String r3 = r1.h()
            byte[] r4 = r1.e()
            int r5 = r1.c()
            z0.a r7 = z0.EnumC0379a.AZTEC
            long r8 = java.lang.System.currentTimeMillis()
            r2 = r11
            r2.<init>(r3, r4, r5, r6, r7, r8)
            java.util.List r12 = r1.a()
            if (r12 == 0) goto L8b
            z0.n r0 = z0.n.BYTE_SEGMENTS
            r11.h(r0, r12)
        L8b:
            java.lang.String r12 = r1.b()
            if (r12 == 0) goto L96
            z0.n r0 = z0.n.ERROR_CORRECTION_LEVEL
            r11.h(r0, r12)
        L96:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: A0.b.a(z0.c, java.util.Map):z0.m");
    }

    @Override // z0.k
    public void b() {
    }
}
