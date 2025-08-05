package a0;

/* loaded from: classes.dex */
abstract class u {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static X.g a(b0.c r10, Q.d r11) {
        /*
            r0 = 2
            r1 = 1
            r2 = -1
            r10.l()
            r3 = 0
            r4 = 0
            r5 = r3
            r6 = r5
            r7 = 0
        Lb:
            boolean r8 = r10.p()
            if (r8 == 0) goto Lc6
            java.lang.String r8 = r10.t()
            r8.hashCode()
            int r9 = r8.hashCode()
            switch(r9) {
                case 111: goto L42;
                case 3588: goto L37;
                case 104433: goto L2c;
                case 3357091: goto L21;
                default: goto L1f;
            }
        L1f:
            r9 = -1
            goto L4c
        L21:
            java.lang.String r9 = "mode"
            boolean r9 = r8.equals(r9)
            if (r9 != 0) goto L2a
            goto L1f
        L2a:
            r9 = 3
            goto L4c
        L2c:
            java.lang.String r9 = "inv"
            boolean r9 = r8.equals(r9)
            if (r9 != 0) goto L35
            goto L1f
        L35:
            r9 = 2
            goto L4c
        L37:
            java.lang.String r9 = "pt"
            boolean r9 = r8.equals(r9)
            if (r9 != 0) goto L40
            goto L1f
        L40:
            r9 = 1
            goto L4c
        L42:
            java.lang.String r9 = "o"
            boolean r9 = r8.equals(r9)
            if (r9 != 0) goto L4b
            goto L1f
        L4b:
            r9 = 0
        L4c:
            switch(r9) {
                case 0: goto Lc0;
                case 1: goto Lba;
                case 2: goto Lb4;
                case 3: goto L53;
                default: goto L4f;
            }
        L4f:
            r10.A()
            goto Lb
        L53:
            java.lang.String r3 = r10.u()
            r3.hashCode()
            int r9 = r3.hashCode()
            switch(r9) {
                case 97: goto L79;
                case 105: goto L6e;
                case 115: goto L63;
                default: goto L61;
            }
        L61:
            r3 = -1
            goto L83
        L63:
            java.lang.String r9 = "s"
            boolean r3 = r3.equals(r9)
            if (r3 != 0) goto L6c
            goto L61
        L6c:
            r3 = 2
            goto L83
        L6e:
            java.lang.String r9 = "i"
            boolean r3 = r3.equals(r9)
            if (r3 != 0) goto L77
            goto L61
        L77:
            r3 = 1
            goto L83
        L79:
            java.lang.String r9 = "a"
            boolean r3 = r3.equals(r9)
            if (r3 != 0) goto L82
            goto L61
        L82:
            r3 = 0
        L83:
            switch(r3) {
                case 0: goto Lb0;
                case 1: goto La7;
                case 2: goto La3;
                default: goto L86;
            }
        L86:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r9 = "Unknown mask mode "
            r3.append(r9)
            r3.append(r8)
            java.lang.String r8 = ". Defaulting to Add."
            r3.append(r8)
            java.lang.String r3 = r3.toString()
            c0.f.b(r3)
            X.g$a r3 = X.g.a.MASK_MODE_ADD
            goto Lb
        La3:
            X.g$a r3 = X.g.a.MASK_MODE_SUBTRACT
            goto Lb
        La7:
            java.lang.String r3 = "Animation contains intersect masks. They are not supported but will be treated like add masks."
            r11.a(r3)
            X.g$a r3 = X.g.a.MASK_MODE_INTERSECT
            goto Lb
        Lb0:
            X.g$a r3 = X.g.a.MASK_MODE_ADD
            goto Lb
        Lb4:
            boolean r7 = r10.q()
            goto Lb
        Lba:
            W.h r5 = a0.AbstractC0119d.k(r10, r11)
            goto Lb
        Lc0:
            W.d r6 = a0.AbstractC0119d.h(r10, r11)
            goto Lb
        Lc6:
            r10.n()
            X.g r10 = new X.g
            r10.<init>(r3, r5, r6, r7)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: a0.u.a(b0.c, Q.d):X.g");
    }
}
