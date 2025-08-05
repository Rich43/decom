package b0;

import b0.c;
import java.io.EOFException;

/* loaded from: classes.dex */
final class e extends c {

    /* renamed from: n, reason: collision with root package name */
    private static final r1.d f4609n = r1.d.c("'\\");
    private static final r1.d o = r1.d.c("\"\\");

    /* renamed from: p, reason: collision with root package name */
    private static final r1.d f4610p = r1.d.c("{}[]:, \n\t\r\f/\\;#=");

    /* renamed from: q, reason: collision with root package name */
    private static final r1.d f4611q = r1.d.c("\n\r");
    private static final r1.d r = r1.d.c("*/");

    /* renamed from: h, reason: collision with root package name */
    private final r1.c f4612h;

    /* renamed from: i, reason: collision with root package name */
    private final r1.a f4613i;

    /* renamed from: j, reason: collision with root package name */
    private int f4614j = 0;

    /* renamed from: k, reason: collision with root package name */
    private long f4615k;

    /* renamed from: l, reason: collision with root package name */
    private int f4616l;

    /* renamed from: m, reason: collision with root package name */
    private String f4617m;

    e(r1.c cVar) {
        if (cVar == null) {
            throw new NullPointerException("source == null");
        }
        this.f4612h = cVar;
        this.f4613i = cVar.f();
        x(6);
    }

    private void D() throws b {
        if (!this.e) {
            throw C("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private int E() throws EOFException, b {
        int[] iArr = this.f4593b;
        int i2 = this.f4592a;
        int i3 = iArr[i2 - 1];
        if (i3 == 1) {
            iArr[i2 - 1] = 2;
        } else if (i3 == 2) {
            int iH = H(true);
            this.f4613i.r();
            if (iH != 44) {
                if (iH != 59) {
                    if (iH != 93) {
                        throw C("Unterminated array");
                    }
                    this.f4614j = 4;
                    return 4;
                }
                D();
            }
        } else {
            if (i3 == 3 || i3 == 5) {
                iArr[i2 - 1] = 4;
                if (i3 == 5) {
                    int iH2 = H(true);
                    this.f4613i.r();
                    if (iH2 != 44) {
                        if (iH2 != 59) {
                            if (iH2 != 125) {
                                throw C("Unterminated object");
                            }
                            this.f4614j = 2;
                            return 2;
                        }
                        D();
                    }
                }
                int iH3 = H(true);
                if (iH3 == 34) {
                    this.f4613i.r();
                    this.f4614j = 13;
                    return 13;
                }
                if (iH3 == 39) {
                    this.f4613i.r();
                    D();
                    this.f4614j = 12;
                    return 12;
                }
                if (iH3 != 125) {
                    D();
                    if (!G((char) iH3)) {
                        throw C("Expected name");
                    }
                    this.f4614j = 14;
                    return 14;
                }
                if (i3 == 5) {
                    throw C("Expected name");
                }
                this.f4613i.r();
                this.f4614j = 2;
                return 2;
            }
            if (i3 == 4) {
                iArr[i2 - 1] = 5;
                int iH4 = H(true);
                this.f4613i.r();
                if (iH4 != 58) {
                    if (iH4 != 61) {
                        throw C("Expected ':'");
                    }
                    D();
                    if (this.f4612h.d(1L) && this.f4613i.m(0L) == 62) {
                        this.f4613i.r();
                    }
                }
            } else if (i3 == 6) {
                iArr[i2 - 1] = 7;
            } else if (i3 == 7) {
                if (H(false) == -1) {
                    this.f4614j = 18;
                    return 18;
                }
                D();
            } else if (i3 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iH5 = H(true);
        if (iH5 == 34) {
            this.f4613i.r();
            this.f4614j = 9;
            return 9;
        }
        if (iH5 == 39) {
            D();
            this.f4613i.r();
            this.f4614j = 8;
            return 8;
        }
        if (iH5 != 44 && iH5 != 59) {
            if (iH5 == 91) {
                this.f4613i.r();
                this.f4614j = 3;
                return 3;
            }
            if (iH5 != 93) {
                if (iH5 == 123) {
                    this.f4613i.r();
                    this.f4614j = 1;
                    return 1;
                }
                int iK = K();
                if (iK != 0) {
                    return iK;
                }
                int iL = L();
                if (iL != 0) {
                    return iL;
                }
                if (!G(this.f4613i.m(0L))) {
                    throw C("Expected value");
                }
                D();
                this.f4614j = 10;
                return 10;
            }
            if (i3 == 1) {
                this.f4613i.r();
                this.f4614j = 4;
                return 4;
            }
        }
        if (i3 != 1 && i3 != 2) {
            throw C("Unexpected value");
        }
        D();
        this.f4614j = 7;
        return 7;
    }

    private int F(String str, c.a aVar) {
        int length = aVar.f4597a.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(aVar.f4597a[i2])) {
                this.f4614j = 0;
                this.f4594c[this.f4592a - 1] = str;
                return i2;
            }
        }
        return -1;
    }

    private boolean G(int i2) throws b {
        if (i2 == 9 || i2 == 10 || i2 == 12 || i2 == 13 || i2 == 32) {
            return false;
        }
        if (i2 != 35) {
            if (i2 == 44) {
                return false;
            }
            if (i2 != 47 && i2 != 61) {
                if (i2 == 123 || i2 == 125 || i2 == 58) {
                    return false;
                }
                if (i2 != 59) {
                    switch (i2) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        D();
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
    
        r6.f4613i.C(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
    
        if (r2 != 47) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
    
        if (r6.f4612h.d(2) != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0039, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003a, code lost:
    
        D();
        r3 = r6.f4613i.m(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0047, code lost:
    
        if (r3 == 42) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
    
        if (r3 == 47) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004b, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004c, code lost:
    
        r6.f4613i.r();
        r6.f4613i.r();
        P();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:
    
        r6.f4613i.r();
        r6.f4613i.r();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0068, code lost:
    
        if (O() == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0071, code lost:
    
        throw C("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0074, code lost:
    
        if (r2 != 35) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0076, code lost:
    
        D();
        P();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007d, code lost:
    
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int H(boolean r7) throws java.io.EOFException, b0.b {
        /*
            r6 = this;
            r0 = 0
        L1:
            r1 = 0
        L2:
            r1.c r2 = r6.f4612h
            int r3 = r1 + 1
            long r4 = (long) r3
            boolean r2 = r2.d(r4)
            if (r2 == 0) goto L80
            r1.a r2 = r6.f4613i
            long r4 = (long) r1
            byte r2 = r2.m(r4)
            r4 = 10
            if (r2 == r4) goto L7e
            r4 = 32
            if (r2 == r4) goto L7e
            r4 = 13
            if (r2 == r4) goto L7e
            r4 = 9
            if (r2 != r4) goto L25
            goto L7e
        L25:
            r1.a r3 = r6.f4613i
            long r4 = (long) r1
            r3.C(r4)
            r1 = 47
            if (r2 != r1) goto L72
            r1.c r3 = r6.f4612h
            r4 = 2
            boolean r3 = r3.d(r4)
            if (r3 != 0) goto L3a
            return r2
        L3a:
            r6.D()
            r1.a r3 = r6.f4613i
            r4 = 1
            byte r3 = r3.m(r4)
            r4 = 42
            if (r3 == r4) goto L5a
            if (r3 == r1) goto L4c
            return r2
        L4c:
            r1.a r1 = r6.f4613i
            r1.r()
            r1.a r1 = r6.f4613i
            r1.r()
            r6.P()
            goto L1
        L5a:
            r1.a r1 = r6.f4613i
            r1.r()
            r1.a r1 = r6.f4613i
            r1.r()
            boolean r1 = r6.O()
            if (r1 == 0) goto L6b
            goto L1
        L6b:
            java.lang.String r7 = "Unterminated comment"
            b0.b r7 = r6.C(r7)
            throw r7
        L72:
            r1 = 35
            if (r2 != r1) goto L7d
            r6.D()
            r6.P()
            goto L1
        L7d:
            return r2
        L7e:
            r1 = r3
            goto L2
        L80:
            if (r7 != 0) goto L84
            r7 = -1
            return r7
        L84:
            java.io.EOFException r7 = new java.io.EOFException
            java.lang.String r0 = "End of input"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.e.H(boolean):int");
    }

    private String I(r1.d dVar) throws b {
        StringBuilder sb = null;
        while (true) {
            long jB = this.f4612h.b(dVar);
            if (jB == -1) {
                throw C("Unterminated string");
            }
            if (this.f4613i.m(jB) != 92) {
                if (sb == null) {
                    String strZ = this.f4613i.z(jB);
                    this.f4613i.r();
                    return strZ;
                }
                sb.append(this.f4613i.z(jB));
                this.f4613i.r();
                return sb.toString();
            }
            if (sb == null) {
                sb = new StringBuilder();
            }
            sb.append(this.f4613i.z(jB));
            this.f4613i.r();
            sb.append(M());
        }
    }

    private String J() {
        long jB = this.f4612h.b(f4610p);
        return jB != -1 ? this.f4613i.z(jB) : this.f4613i.y();
    }

    private int K() throws EOFException {
        String str;
        String str2;
        int i2;
        byte bM = this.f4613i.m(0L);
        if (bM == 116 || bM == 84) {
            str = "true";
            str2 = "TRUE";
            i2 = 5;
        } else if (bM == 102 || bM == 70) {
            str = "false";
            str2 = "FALSE";
            i2 = 6;
        } else {
            if (bM != 110 && bM != 78) {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i2 = 7;
        }
        int length = str.length();
        int i3 = 1;
        while (i3 < length) {
            int i4 = i3 + 1;
            if (!this.f4612h.d(i4)) {
                return 0;
            }
            byte bM2 = this.f4613i.m(i3);
            if (bM2 != str.charAt(i3) && bM2 != str2.charAt(i3)) {
                return 0;
            }
            i3 = i4;
        }
        if (this.f4612h.d(length + 1) && G(this.f4613i.m(length))) {
            return 0;
        }
        this.f4613i.C(length);
        this.f4614j = i2;
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0081, code lost:
    
        if (G(r11) != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0083, code lost:
    
        if (r6 != 2) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0085, code lost:
    
        if (r7 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008b, code lost:
    
        if (r8 != Long.MIN_VALUE) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x008d, code lost:
    
        if (r10 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0091, code lost:
    
        if (r8 != 0) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0093, code lost:
    
        if (r10 != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0095, code lost:
    
        if (r10 == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0098, code lost:
    
        r8 = -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0099, code lost:
    
        r16.f4615k = r8;
        r16.f4613i.C(r5);
        r16.f4614j = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00a5, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a6, code lost:
    
        if (r6 == 2) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a9, code lost:
    
        if (r6 == 4) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ac, code lost:
    
        if (r6 != 7) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00af, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00b0, code lost:
    
        r16.f4616l = r5;
        r16.f4614j = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00b6, code lost:
    
        return 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00b7, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int L() throws java.io.EOFException {
        /*
            Method dump skipped, instructions count: 221
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.e.L():int");
    }

    private char M() throws EOFException, b {
        int i2;
        if (!this.f4612h.d(1L)) {
            throw C("Unterminated escape sequence");
        }
        byte bR = this.f4613i.r();
        if (bR == 10 || bR == 34 || bR == 39 || bR == 47 || bR == 92) {
            return (char) bR;
        }
        if (bR == 98) {
            return '\b';
        }
        if (bR == 102) {
            return '\f';
        }
        if (bR == 110) {
            return '\n';
        }
        if (bR == 114) {
            return '\r';
        }
        if (bR == 116) {
            return '\t';
        }
        if (bR != 117) {
            if (this.e) {
                return (char) bR;
            }
            throw C("Invalid escape sequence: \\" + ((char) bR));
        }
        if (!this.f4612h.d(4L)) {
            throw new EOFException("Unterminated escape sequence at path " + o());
        }
        char c2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            byte bM = this.f4613i.m(i3);
            char c3 = (char) (c2 << 4);
            if (bM >= 48 && bM <= 57) {
                i2 = bM - 48;
            } else if (bM >= 97 && bM <= 102) {
                i2 = bM - 87;
            } else {
                if (bM < 65 || bM > 70) {
                    throw C("\\u" + this.f4613i.z(4L));
                }
                i2 = bM - 55;
            }
            c2 = (char) (c3 + i2);
        }
        this.f4613i.C(4L);
        return c2;
    }

    private void N(r1.d dVar) throws EOFException, b {
        while (true) {
            long jB = this.f4612h.b(dVar);
            if (jB == -1) {
                throw C("Unterminated string");
            }
            if (this.f4613i.m(jB) != 92) {
                this.f4613i.C(jB + 1);
                return;
            } else {
                this.f4613i.C(jB + 1);
                M();
            }
        }
    }

    private boolean O() throws EOFException {
        long jG = this.f4612h.g(r);
        boolean z2 = jG != -1;
        r1.a aVar = this.f4613i;
        aVar.C(z2 ? jG + r1.j() : aVar.B());
        return z2;
    }

    private void P() throws EOFException {
        long jB = this.f4612h.b(f4611q);
        r1.a aVar = this.f4613i;
        aVar.C(jB != -1 ? jB + 1 : aVar.B());
    }

    private void Q() throws EOFException {
        long jB = this.f4612h.b(f4610p);
        r1.a aVar = this.f4613i;
        if (jB == -1) {
            jB = aVar.B();
        }
        aVar.C(jB);
    }

    @Override // b0.c
    public void A() throws EOFException, b {
        if (this.f4596f) {
            throw new C0212a("Cannot skip unexpected " + w() + " at " + o());
        }
        int i2 = 0;
        do {
            int iE = this.f4614j;
            if (iE == 0) {
                iE = E();
            }
            if (iE == 3) {
                x(1);
            } else if (iE == 1) {
                x(3);
            } else {
                if (iE == 4) {
                    i2--;
                    if (i2 < 0) {
                        throw new C0212a("Expected a value but was " + w() + " at path " + o());
                    }
                    this.f4592a--;
                } else if (iE == 2) {
                    i2--;
                    if (i2 < 0) {
                        throw new C0212a("Expected a value but was " + w() + " at path " + o());
                    }
                    this.f4592a--;
                } else if (iE == 14 || iE == 10) {
                    Q();
                } else if (iE == 9 || iE == 13) {
                    N(o);
                } else if (iE == 8 || iE == 12) {
                    N(f4609n);
                } else if (iE == 17) {
                    this.f4613i.C(this.f4616l);
                } else if (iE == 18) {
                    throw new C0212a("Expected a value but was " + w() + " at path " + o());
                }
                this.f4614j = 0;
            }
            i2++;
            this.f4614j = 0;
        } while (i2 != 0);
        int[] iArr = this.f4595d;
        int i3 = this.f4592a;
        int i4 = i3 - 1;
        iArr[i4] = iArr[i4] + 1;
        this.f4594c[i3 - 1] = "null";
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f4614j = 0;
        this.f4593b[0] = 8;
        this.f4592a = 1;
        this.f4613i.j();
        this.f4612h.close();
    }

    @Override // b0.c
    public void k() throws EOFException, b {
        int iE = this.f4614j;
        if (iE == 0) {
            iE = E();
        }
        if (iE == 3) {
            x(1);
            this.f4595d[this.f4592a - 1] = 0;
            this.f4614j = 0;
        } else {
            throw new C0212a("Expected BEGIN_ARRAY but was " + w() + " at path " + o());
        }
    }

    @Override // b0.c
    public void l() throws EOFException, b {
        int iE = this.f4614j;
        if (iE == 0) {
            iE = E();
        }
        if (iE == 1) {
            x(3);
            this.f4614j = 0;
            return;
        }
        throw new C0212a("Expected BEGIN_OBJECT but was " + w() + " at path " + o());
    }

    @Override // b0.c
    public void m() throws EOFException, b {
        int iE = this.f4614j;
        if (iE == 0) {
            iE = E();
        }
        if (iE != 4) {
            throw new C0212a("Expected END_ARRAY but was " + w() + " at path " + o());
        }
        int i2 = this.f4592a;
        this.f4592a = i2 - 1;
        int[] iArr = this.f4595d;
        int i3 = i2 - 2;
        iArr[i3] = iArr[i3] + 1;
        this.f4614j = 0;
    }

    @Override // b0.c
    public void n() throws EOFException, b {
        int iE = this.f4614j;
        if (iE == 0) {
            iE = E();
        }
        if (iE != 2) {
            throw new C0212a("Expected END_OBJECT but was " + w() + " at path " + o());
        }
        int i2 = this.f4592a;
        int i3 = i2 - 1;
        this.f4592a = i3;
        this.f4594c[i3] = null;
        int[] iArr = this.f4595d;
        int i4 = i2 - 2;
        iArr[i4] = iArr[i4] + 1;
        this.f4614j = 0;
    }

    @Override // b0.c
    public boolean p() throws EOFException, b {
        int iE = this.f4614j;
        if (iE == 0) {
            iE = E();
        }
        return (iE == 2 || iE == 4 || iE == 18) ? false : true;
    }

    @Override // b0.c
    public boolean q() throws EOFException, b {
        int iE = this.f4614j;
        if (iE == 0) {
            iE = E();
        }
        if (iE == 5) {
            this.f4614j = 0;
            int[] iArr = this.f4595d;
            int i2 = this.f4592a - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        }
        if (iE == 6) {
            this.f4614j = 0;
            int[] iArr2 = this.f4595d;
            int i3 = this.f4592a - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        }
        throw new C0212a("Expected a boolean but was " + w() + " at path " + o());
    }

    @Override // b0.c
    public double r() throws NumberFormatException, EOFException, b {
        int iE = this.f4614j;
        if (iE == 0) {
            iE = E();
        }
        if (iE == 16) {
            this.f4614j = 0;
            int[] iArr = this.f4595d;
            int i2 = this.f4592a - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.f4615k;
        }
        if (iE == 17) {
            this.f4617m = this.f4613i.z(this.f4616l);
        } else if (iE == 9) {
            this.f4617m = I(o);
        } else if (iE == 8) {
            this.f4617m = I(f4609n);
        } else if (iE == 10) {
            this.f4617m = J();
        } else if (iE != 11) {
            throw new C0212a("Expected a double but was " + w() + " at path " + o());
        }
        this.f4614j = 11;
        try {
            double d2 = Double.parseDouble(this.f4617m);
            if (this.e || !(Double.isNaN(d2) || Double.isInfinite(d2))) {
                this.f4617m = null;
                this.f4614j = 0;
                int[] iArr2 = this.f4595d;
                int i3 = this.f4592a - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return d2;
            }
            throw new b("JSON forbids NaN and infinities: " + d2 + " at path " + o());
        } catch (NumberFormatException unused) {
            throw new C0212a("Expected a double but was " + this.f4617m + " at path " + o());
        }
    }

    @Override // b0.c
    public int s() throws NumberFormatException, EOFException, b {
        int iE = this.f4614j;
        if (iE == 0) {
            iE = E();
        }
        if (iE == 16) {
            long j2 = this.f4615k;
            int i2 = (int) j2;
            if (j2 == i2) {
                this.f4614j = 0;
                int[] iArr = this.f4595d;
                int i3 = this.f4592a - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
            throw new C0212a("Expected an int but was " + this.f4615k + " at path " + o());
        }
        if (iE == 17) {
            this.f4617m = this.f4613i.z(this.f4616l);
        } else if (iE == 9 || iE == 8) {
            String strI = iE == 9 ? I(o) : I(f4609n);
            this.f4617m = strI;
            try {
                int i4 = Integer.parseInt(strI);
                this.f4614j = 0;
                int[] iArr2 = this.f4595d;
                int i5 = this.f4592a - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return i4;
            } catch (NumberFormatException unused) {
            }
        } else if (iE != 11) {
            throw new C0212a("Expected an int but was " + w() + " at path " + o());
        }
        this.f4614j = 11;
        try {
            double d2 = Double.parseDouble(this.f4617m);
            int i6 = (int) d2;
            if (i6 == d2) {
                this.f4617m = null;
                this.f4614j = 0;
                int[] iArr3 = this.f4595d;
                int i7 = this.f4592a - 1;
                iArr3[i7] = iArr3[i7] + 1;
                return i6;
            }
            throw new C0212a("Expected an int but was " + this.f4617m + " at path " + o());
        } catch (NumberFormatException unused2) {
            throw new C0212a("Expected an int but was " + this.f4617m + " at path " + o());
        }
    }

    @Override // b0.c
    public String t() throws EOFException, b {
        String strI;
        int iE = this.f4614j;
        if (iE == 0) {
            iE = E();
        }
        if (iE == 14) {
            strI = J();
        } else if (iE == 13) {
            strI = I(o);
        } else if (iE == 12) {
            strI = I(f4609n);
        } else {
            if (iE != 15) {
                throw new C0212a("Expected a name but was " + w() + " at path " + o());
            }
            strI = this.f4617m;
        }
        this.f4614j = 0;
        this.f4594c[this.f4592a - 1] = strI;
        return strI;
    }

    public String toString() {
        return "JsonReader(" + this.f4612h + ")";
    }

    @Override // b0.c
    public String u() throws EOFException, b {
        String strZ;
        int iE = this.f4614j;
        if (iE == 0) {
            iE = E();
        }
        if (iE == 10) {
            strZ = J();
        } else if (iE == 9) {
            strZ = I(o);
        } else if (iE == 8) {
            strZ = I(f4609n);
        } else if (iE == 11) {
            strZ = this.f4617m;
            this.f4617m = null;
        } else if (iE == 16) {
            strZ = Long.toString(this.f4615k);
        } else {
            if (iE != 17) {
                throw new C0212a("Expected a string but was " + w() + " at path " + o());
            }
            strZ = this.f4613i.z(this.f4616l);
        }
        this.f4614j = 0;
        int[] iArr = this.f4595d;
        int i2 = this.f4592a - 1;
        iArr[i2] = iArr[i2] + 1;
        return strZ;
    }

    @Override // b0.c
    public c.b w() throws EOFException, b {
        int iE = this.f4614j;
        if (iE == 0) {
            iE = E();
        }
        switch (iE) {
            case 1:
                return c.b.BEGIN_OBJECT;
            case 2:
                return c.b.END_OBJECT;
            case 3:
                return c.b.BEGIN_ARRAY;
            case 4:
                return c.b.END_ARRAY;
            case 5:
            case 6:
                return c.b.BOOLEAN;
            case 7:
                return c.b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return c.b.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return c.b.NAME;
            case 16:
            case 17:
                return c.b.NUMBER;
            case 18:
                return c.b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    @Override // b0.c
    public int y(c.a aVar) throws EOFException, b {
        int iE = this.f4614j;
        if (iE == 0) {
            iE = E();
        }
        if (iE < 12 || iE > 15) {
            return -1;
        }
        if (iE == 15) {
            return F(this.f4617m, aVar);
        }
        int i2 = this.f4612h.i(aVar.f4598b);
        if (i2 != -1) {
            this.f4614j = 0;
            this.f4594c[this.f4592a - 1] = aVar.f4597a[i2];
            return i2;
        }
        String str = this.f4594c[this.f4592a - 1];
        String strT = t();
        int iF = F(strT, aVar);
        if (iF == -1) {
            this.f4614j = 15;
            this.f4617m = strT;
            this.f4594c[this.f4592a - 1] = str;
        }
        return iF;
    }

    @Override // b0.c
    public void z() throws EOFException, b {
        if (this.f4596f) {
            throw new C0212a("Cannot skip unexpected " + w() + " at " + o());
        }
        int iE = this.f4614j;
        if (iE == 0) {
            iE = E();
        }
        if (iE == 14) {
            Q();
        } else if (iE == 13) {
            N(o);
        } else if (iE == 12) {
            N(f4609n);
        } else if (iE != 15) {
            throw new C0212a("Expected a name but was " + w() + " at path " + o());
        }
        this.f4614j = 0;
        this.f4594c[this.f4592a - 1] = "null";
    }
}
