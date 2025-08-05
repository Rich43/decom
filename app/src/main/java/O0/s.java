package O0;

import z0.C0384f;

/* loaded from: classes.dex */
final class s {

    /* renamed from: a, reason: collision with root package name */
    private final D0.a f536a;

    /* renamed from: b, reason: collision with root package name */
    private final m f537b = new m();

    /* renamed from: c, reason: collision with root package name */
    private final StringBuilder f538c = new StringBuilder();

    s(D0.a aVar) {
        this.f536a = aVar;
    }

    private n b(int i2) {
        char c2;
        int iF = f(i2, 5);
        if (iF == 15) {
            return new n(i2 + 5, '$');
        }
        if (iF >= 5 && iF < 15) {
            return new n(i2 + 5, (char) (iF + 43));
        }
        int iF2 = f(i2, 6);
        if (iF2 >= 32 && iF2 < 58) {
            return new n(i2 + 6, (char) (iF2 + 33));
        }
        switch (iF2) {
            case 58:
                c2 = '*';
                break;
            case 59:
                c2 = ',';
                break;
            case 60:
                c2 = '-';
                break;
            case 61:
                c2 = '.';
                break;
            case 62:
                c2 = '/';
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: ".concat(String.valueOf(iF2)));
        }
        return new n(i2 + 6, c2);
    }

    private n d(int i2) throws C0384f {
        int iF = f(i2, 5);
        if (iF == 15) {
            return new n(i2 + 5, '$');
        }
        char c2 = '+';
        if (iF >= 5 && iF < 15) {
            return new n(i2 + 5, (char) (iF + 43));
        }
        int iF2 = f(i2, 7);
        if (iF2 >= 64 && iF2 < 90) {
            return new n(i2 + 7, (char) (iF2 + 1));
        }
        if (iF2 >= 90 && iF2 < 116) {
            return new n(i2 + 7, (char) (iF2 + 7));
        }
        switch (f(i2, 8)) {
            case 232:
                c2 = '!';
                break;
            case 233:
                c2 = '\"';
                break;
            case 234:
                c2 = '%';
                break;
            case 235:
                c2 = '&';
                break;
            case 236:
                c2 = '\'';
                break;
            case 237:
                c2 = '(';
                break;
            case 238:
                c2 = ')';
                break;
            case 239:
                c2 = '*';
                break;
            case 240:
                break;
            case 241:
                c2 = ',';
                break;
            case 242:
                c2 = '-';
                break;
            case 243:
                c2 = '.';
                break;
            case 244:
                c2 = '/';
                break;
            case 245:
                c2 = ':';
                break;
            case 246:
                c2 = ';';
                break;
            case 247:
                c2 = '<';
                break;
            case 248:
                c2 = '=';
                break;
            case 249:
                c2 = '>';
                break;
            case 250:
                c2 = '?';
                break;
            case 251:
                c2 = '_';
                break;
            case 252:
                c2 = ' ';
                break;
            default:
                throw C0384f.a();
        }
        return new n(i2 + 8, c2);
    }

    private p e(int i2) {
        int i3 = i2 + 7;
        if (i3 > this.f536a.g()) {
            int iF = f(i2, 4);
            return iF == 0 ? new p(this.f536a.g(), 10, 10) : new p(this.f536a.g(), iF - 1, 10);
        }
        int iF2 = f(i2, 7) - 8;
        return new p(i3, iF2 / 11, iF2 % 11);
    }

    static int g(D0.a aVar, int i2, int i3) {
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            if (aVar.c(i2 + i5)) {
                i4 |= 1 << ((i3 - i5) - 1);
            }
        }
        return i4;
    }

    private boolean h(int i2) {
        int i3 = i2 + 3;
        if (i3 > this.f536a.g()) {
            return false;
        }
        while (i2 < i3) {
            if (this.f536a.c(i2)) {
                return false;
            }
            i2++;
        }
        return true;
    }

    private boolean i(int i2) {
        int i3;
        if (i2 + 1 > this.f536a.g()) {
            return false;
        }
        for (int i4 = 0; i4 < 5 && (i3 = i4 + i2) < this.f536a.g(); i4++) {
            if (i4 == 2) {
                if (!this.f536a.c(i2 + 2)) {
                    return false;
                }
            } else if (this.f536a.c(i3)) {
                return false;
            }
        }
        return true;
    }

    private boolean j(int i2) {
        int i3;
        if (i2 + 1 > this.f536a.g()) {
            return false;
        }
        for (int i4 = 0; i4 < 4 && (i3 = i4 + i2) < this.f536a.g(); i4++) {
            if (this.f536a.c(i3)) {
                return false;
            }
        }
        return true;
    }

    private boolean k(int i2) {
        int iF;
        if (i2 + 5 > this.f536a.g()) {
            return false;
        }
        int iF2 = f(i2, 5);
        if (iF2 < 5 || iF2 >= 16) {
            return i2 + 6 <= this.f536a.g() && (iF = f(i2, 6)) >= 16 && iF < 63;
        }
        return true;
    }

    private boolean l(int i2) {
        int iF;
        if (i2 + 5 > this.f536a.g()) {
            return false;
        }
        int iF2 = f(i2, 5);
        if (iF2 >= 5 && iF2 < 16) {
            return true;
        }
        if (i2 + 7 > this.f536a.g()) {
            return false;
        }
        int iF3 = f(i2, 7);
        if (iF3 < 64 || iF3 >= 116) {
            return i2 + 8 <= this.f536a.g() && (iF = f(i2, 8)) >= 232 && iF < 253;
        }
        return true;
    }

    private boolean m(int i2) {
        if (i2 + 7 > this.f536a.g()) {
            return i2 + 4 <= this.f536a.g();
        }
        int i3 = i2;
        while (true) {
            int i4 = i2 + 3;
            if (i3 >= i4) {
                return this.f536a.c(i4);
            }
            if (this.f536a.c(i3)) {
                return true;
            }
            i3++;
        }
    }

    private l n() {
        while (k(this.f537b.a())) {
            n nVarB = b(this.f537b.a());
            this.f537b.h(nVarB.a());
            if (nVarB.c()) {
                return new l(new o(this.f537b.a(), this.f538c.toString()), true);
            }
            this.f538c.append(nVarB.b());
        }
        if (h(this.f537b.a())) {
            this.f537b.b(3);
            this.f537b.g();
        } else if (i(this.f537b.a())) {
            if (this.f537b.a() + 5 < this.f536a.g()) {
                this.f537b.b(5);
            } else {
                this.f537b.h(this.f536a.g());
            }
            this.f537b.f();
        }
        return new l(false);
    }

    private o o() throws C0384f {
        l lVarQ;
        boolean zB;
        do {
            int iA = this.f537b.a();
            if (this.f537b.c()) {
                lVarQ = n();
                zB = lVarQ.b();
            } else if (this.f537b.d()) {
                lVarQ = p();
                zB = lVarQ.b();
            } else {
                lVarQ = q();
                zB = lVarQ.b();
            }
            if (iA == this.f537b.a() && !zB) {
                break;
            }
        } while (!zB);
        return lVarQ.a();
    }

    private l p() throws C0384f {
        while (l(this.f537b.a())) {
            n nVarD = d(this.f537b.a());
            this.f537b.h(nVarD.a());
            if (nVarD.c()) {
                return new l(new o(this.f537b.a(), this.f538c.toString()), true);
            }
            this.f538c.append(nVarD.b());
        }
        if (h(this.f537b.a())) {
            this.f537b.b(3);
            this.f537b.g();
        } else if (i(this.f537b.a())) {
            if (this.f537b.a() + 5 < this.f536a.g()) {
                this.f537b.b(5);
            } else {
                this.f537b.h(this.f536a.g());
            }
            this.f537b.e();
        }
        return new l(false);
    }

    private l q() {
        while (m(this.f537b.a())) {
            p pVarE = e(this.f537b.a());
            this.f537b.h(pVarE.a());
            if (pVarE.d()) {
                return new l(pVarE.e() ? new o(this.f537b.a(), this.f538c.toString()) : new o(this.f537b.a(), this.f538c.toString(), pVarE.c()), true);
            }
            this.f538c.append(pVarE.b());
            if (pVarE.e()) {
                return new l(new o(this.f537b.a(), this.f538c.toString()), true);
            }
            this.f538c.append(pVarE.c());
        }
        if (j(this.f537b.a())) {
            this.f537b.e();
            this.f537b.b(4);
        }
        return new l(false);
    }

    String a(StringBuilder sb, int i2) throws C0384f, z0.i {
        String str = null;
        while (true) {
            o oVarC = c(i2, str);
            String strA = r.a(oVarC.b());
            if (strA != null) {
                sb.append(strA);
            }
            String strValueOf = oVarC.d() ? String.valueOf(oVarC.c()) : null;
            if (i2 == oVarC.a()) {
                return sb.toString();
            }
            i2 = oVarC.a();
            str = strValueOf;
        }
    }

    o c(int i2, String str) throws C0384f {
        this.f538c.setLength(0);
        if (str != null) {
            this.f538c.append(str);
        }
        this.f537b.h(i2);
        o oVarO = o();
        return (oVarO == null || !oVarO.d()) ? new o(this.f537b.a(), this.f538c.toString()) : new o(this.f537b.a(), this.f538c.toString(), oVarO.c());
    }

    int f(int i2, int i3) {
        return g(this.f536a, i2, i3);
    }
}
