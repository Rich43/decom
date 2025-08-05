package defpackage;

import android.content.Context;
import android.util.Log;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import n.C0295c;
import n.i;

/* loaded from: classes.dex */
public class o {

    /* renamed from: a */
    private Context f6792a;

    /* renamed from: b */
    private a f6793b;

    /* renamed from: c */
    private defpackage.r f6794c;

    /* renamed from: d */
    private defpackage.q f6795d;

    private class a extends Thread {

        /* renamed from: a */
        private volatile boolean f6796a = false;

        /* renamed from: b */
        private volatile boolean f6797b = false;

        /* renamed from: c */
        private int f6798c = 51040;

        /* renamed from: d */
        private Socket f6799d = new Socket();
        private String e;

        public a(String str) {
            this.e = str;
        }

        private void a() throws IOException {
            Socket socket = this.f6799d;
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void b(long j2) throws InterruptedException {
            try {
                Thread.sleep(j2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private boolean c() throws IOException {
            try {
                this.f6799d.connect(new InetSocketAddress(InetAddress.getByName(this.e), this.f6798c), 5000);
                this.f6799d.setSoTimeout(3000);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }

        public void d() throws InterruptedException {
            start();
            while (!this.f6796a) {
                b(50L);
            }
        }

        public void e() throws InterruptedException {
            if (this.f6796a) {
                this.f6797b = true;
                while (this.f6797b) {
                    b(100L);
                }
                this.f6796a = false;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws InterruptedException, IOException {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f6796a = true;
            Log.d("eshare", "rtsp thread begin ");
            if (c()) {
                defpackage.p pVar = new defpackage.p(this.f6799d, this.e);
                if (pVar.c(o.this.f6792a) != null) {
                    o oVar = o.this;
                    oVar.f6794c = new defpackage.r(oVar.f6792a, this.e);
                    o.this.f6794c.g(o.this.f6795d);
                    o.this.f6794c.q();
                    long jCurrentTimeMillis2 = 0;
                    loop0: while (true) {
                        int i2 = 0;
                        while (true) {
                            if (!this.f6796a || this.f6797b) {
                                break loop0;
                            }
                            int iJ = o.this.f6794c.j();
                            if (iJ != 0) {
                                if (o.this.f6795d != null) {
                                    o.this.f6795d.a(iJ);
                                }
                            } else if (System.currentTimeMillis() - jCurrentTimeMillis2 >= 1000) {
                                jCurrentTimeMillis2 = System.currentTimeMillis();
                                if (pVar.d() == null) {
                                    Log.d("eshare", "send option failed " + i2);
                                    int i3 = i2 + 1;
                                    if (i2 >= 3) {
                                        break loop0;
                                    } else {
                                        i2 = i3;
                                    }
                                }
                            } else {
                                b(100L);
                            }
                        }
                        Log.d("eshare", "send option success " + i2);
                    }
                    pVar.e();
                    o.this.f6794c.t();
                    if (o.this.f6795d != null) {
                        o.this.f6795d.a(1);
                    }
                } else if (o.this.f6795d != null) {
                    o.this.f6795d.a(257);
                }
            } else if (o.this.f6795d != null) {
                o.this.f6795d.a(256);
            }
            if (System.currentTimeMillis() - jCurrentTimeMillis <= 100) {
                b(100L);
            }
            a();
            this.f6796a = false;
            this.f6797b = false;
            Log.d("eshare", "rtsp thread exit ");
        }
    }

    public abstract class b {
        public static void a(h hVar) {
            if ((hVar.R0() & 32) != 32) {
                j(hVar);
                return;
            }
            hVar.f6934O0 = true;
            hVar.f6928I0 = false;
            hVar.f6929J0 = false;
            hVar.f6930K0 = false;
            ArrayList<g> arrayList = hVar.f6987v0;
            List<i> list = hVar.f6927H0;
            g.b bVarS = hVar.s();
            g.b bVar = g.b.WRAP_CONTENT;
            boolean z2 = bVarS == bVar;
            boolean z3 = hVar.B() == bVar;
            boolean z4 = z2 || z3;
            list.clear();
            for (g gVar : arrayList) {
                gVar.r = null;
                gVar.f6892k0 = false;
                gVar.S();
            }
            for (g gVar2 : arrayList) {
                if (gVar2.r == null && !b(gVar2, list, z4)) {
                    j(hVar);
                    hVar.f6934O0 = false;
                    return;
                }
            }
            int iMax = 0;
            int iMax2 = 0;
            for (i iVar : list) {
                iMax = Math.max(iMax, c(iVar, 0));
                iMax2 = Math.max(iMax2, c(iVar, 1));
            }
            if (z2) {
                hVar.g0(g.b.FIXED);
                hVar.y0(iMax);
                hVar.f6928I0 = true;
                hVar.f6929J0 = true;
                hVar.f6931L0 = iMax;
            }
            if (z3) {
                hVar.u0(g.b.FIXED);
                hVar.b0(iMax2);
                hVar.f6928I0 = true;
                hVar.f6930K0 = true;
                hVar.f6932M0 = iMax2;
            }
            i(list, 0, hVar.D());
            i(list, 1, hVar.r());
        }

        private static boolean b(g gVar, List list, boolean z2) {
            i iVar = new i(new ArrayList(), true);
            list.add(iVar);
            return k(gVar, iVar, list, z2);
        }

        private static int c(i iVar, int i2) {
            int i3 = i2 * 2;
            List listB = iVar.b(i2);
            int size = listB.size();
            int iMax = 0;
            for (int i4 = 0; i4 < size; i4++) {
                g gVar = (g) listB.get(i4);
                f[] fVarArr = gVar.f6848C;
                f fVar = fVarArr[i3 + 1].f6822d;
                iMax = Math.max(iMax, d(gVar, i2, fVar == null || !(fVarArr[i3].f6822d == null || fVar == null), 0));
            }
            iVar.e[i2] = iMax;
            return iMax;
        }

        private static int d(g gVar, int i2, boolean z2, int i3) {
            int iR;
            int iJ;
            int i4;
            int i5;
            int i6;
            int iD;
            int i7;
            int i8;
            int i9;
            int iMax = 0;
            if (!gVar.f6888i0) {
                return 0;
            }
            boolean z3 = gVar.f6912y.f6822d != null && i2 == 1;
            if (z2) {
                iR = gVar.j();
                iJ = gVar.r() - gVar.j();
                i5 = i2 * 2;
                i4 = i5 + 1;
            } else {
                iR = gVar.r() - gVar.j();
                iJ = gVar.j();
                i4 = i2 * 2;
                i5 = i4 + 1;
            }
            f[] fVarArr = gVar.f6848C;
            if (fVarArr[i4].f6822d == null || fVarArr[i5].f6822d != null) {
                i6 = 1;
            } else {
                i6 = -1;
                int i10 = i4;
                i4 = i5;
                i5 = i10;
            }
            int i11 = z3 ? i3 - iR : i3;
            int iD2 = (fVarArr[i5].d() * i6) + e(gVar, i2);
            int i12 = i11 + iD2;
            int iD3 = (i2 == 0 ? gVar.D() : gVar.r()) * i6;
            Iterator it = gVar.f6848C[i5].f().f6977a.iterator();
            while (it.hasNext()) {
                iMax = Math.max(iMax, d(((n) ((p) it.next())).f6965c.f6820b, i2, z2, i12));
            }
            int iMax2 = 0;
            for (Iterator it2 = gVar.f6848C[i4].f().f6977a.iterator(); it2.hasNext(); it2 = it2) {
                iMax2 = Math.max(iMax2, d(((n) ((p) it2.next())).f6965c.f6820b, i2, z2, iD3 + i12));
            }
            if (z3) {
                iMax -= iR;
                iD = iMax2 + iJ;
            } else {
                iD = iMax2 + ((i2 == 0 ? gVar.D() : gVar.r()) * i6);
            }
            int i13 = 1;
            if (i2 == 1) {
                Iterator it3 = gVar.f6912y.f().f6977a.iterator();
                int iMax3 = 0;
                while (it3.hasNext()) {
                    Iterator it4 = it3;
                    n nVar = (n) ((p) it3.next());
                    if (i6 == i13) {
                        iMax3 = Math.max(iMax3, d(nVar.f6965c.f6820b, i2, z2, iR + i12));
                        i9 = i4;
                    } else {
                        i9 = i4;
                        iMax3 = Math.max(iMax3, d(nVar.f6965c.f6820b, i2, z2, (iJ * i6) + i12));
                    }
                    it3 = it4;
                    i4 = i9;
                    i13 = 1;
                }
                i7 = i4;
                int i14 = iMax3;
                i8 = (gVar.f6912y.f().f6977a.size() <= 0 || z3) ? i14 : i6 == 1 ? i14 + iR : i14 - iJ;
            } else {
                i7 = i4;
                i8 = 0;
            }
            int iMax4 = iD2 + Math.max(iMax, Math.max(iD, i8));
            int i15 = iD3 + i12;
            if (i6 == -1) {
                i15 = i12;
                i12 = i15;
            }
            if (z2) {
                l.e(gVar, i2, i12);
                gVar.Z(i12, i15, i2);
            } else {
                gVar.r.a(gVar, i2);
                gVar.q0(i12, i2);
            }
            if (gVar.o(i2) == g.b.MATCH_CONSTRAINT && gVar.f6854I != 0.0f) {
                gVar.r.a(gVar, i2);
            }
            f[] fVarArr2 = gVar.f6848C;
            if (fVarArr2[i5].f6822d != null && fVarArr2[i7].f6822d != null) {
                g gVarU = gVar.u();
                f[] fVarArr3 = gVar.f6848C;
                if (fVarArr3[i5].f6822d.f6820b == gVarU && fVarArr3[i7].f6822d.f6820b == gVarU) {
                    gVar.r.a(gVar, i2);
                }
            }
            return iMax4;
        }

        private static int e(g gVar, int i2) {
            f fVar;
            int i3 = i2 * 2;
            f[] fVarArr = gVar.f6848C;
            f fVar2 = fVarArr[i3];
            f fVar3 = fVarArr[i3 + 1];
            f fVar4 = fVar2.f6822d;
            if (fVar4 == null) {
                return 0;
            }
            g gVar2 = fVar4.f6820b;
            g gVar3 = gVar.f6851F;
            if (gVar2 != gVar3 || (fVar = fVar3.f6822d) == null || fVar.f6820b != gVar3) {
                return 0;
            }
            return (int) ((((gVar3.t(i2) - fVar2.d()) - fVar3.d()) - gVar.t(i2)) * (i2 == 0 ? gVar.f6871Z : gVar.f6873a0));
        }

        private static void f(h hVar, g gVar, i iVar) {
            iVar.f6945d = false;
            hVar.f6934O0 = false;
            gVar.f6888i0 = false;
        }

        private static int g(g gVar) {
            g.b bVarS = gVar.s();
            g.b bVar = g.b.MATCH_CONSTRAINT;
            if (bVarS == bVar) {
                int iR = (int) (gVar.f6855J == 0 ? gVar.r() * gVar.f6854I : gVar.r() / gVar.f6854I);
                gVar.y0(iR);
                return iR;
            }
            if (gVar.B() != bVar) {
                return -1;
            }
            int iD = (int) (gVar.f6855J == 1 ? gVar.D() * gVar.f6854I : gVar.D() / gVar.f6854I);
            gVar.b0(iD);
            return iD;
        }

        private static void h(f fVar) {
            n nVarF = fVar.f();
            f fVar2 = fVar.f6822d;
            if (fVar2 == null || fVar2.f6822d == fVar) {
                return;
            }
            fVar2.f().a(nVarF);
        }

        public static void i(List list, int i2, int i3) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                for (g gVar : ((i) list.get(i4)).c(i2)) {
                    if (gVar.f6888i0) {
                        l(gVar, i2, i3);
                    }
                }
            }
        }

        private static void j(h hVar) {
            hVar.f6927H0.clear();
            hVar.f6927H0.add(0, new i(hVar.f6987v0));
        }

        /* JADX WARN: Removed duplicated region for block: B:259:0x0112  */
        /* JADX WARN: Removed duplicated region for block: B:286:0x015b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static boolean k(o.g r8, o.i r9, java.util.List r10, boolean r11) {
            /*
                Method dump skipped, instructions count: 516
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: o.b.k(o$g, o$i, java.util.List, boolean):boolean");
        }

        private static void l(g gVar, int i2, int i3) {
            int i4 = i2 * 2;
            f[] fVarArr = gVar.f6848C;
            f fVar = fVarArr[i4];
            f fVar2 = fVarArr[i4 + 1];
            if (fVar.f6822d != null && fVar2.f6822d != null) {
                l.e(gVar, i2, e(gVar, i2) + fVar.d());
                return;
            }
            if (gVar.f6854I == 0.0f || gVar.o(i2) != g.b.MATCH_CONSTRAINT) {
                int iV = i3 - gVar.v(i2);
                int iT = iV - gVar.t(i2);
                gVar.Z(iT, iV, i2);
                l.e(gVar, i2, iT);
                return;
            }
            int iG = g(gVar);
            int i5 = (int) gVar.f6848C[i4].f().f6969h;
            fVar2.f().f6968g = fVar.f();
            fVar2.f().f6969h = iG;
            fVar2.f().f6978b = 1;
            gVar.Z(i5, i5 + iG, i2);
        }
    }

    public class c extends k {

        /* renamed from: x0 */
        private int f6801x0 = 0;

        /* renamed from: y0 */
        private ArrayList f6802y0 = new ArrayList(4);

        /* renamed from: z0 */
        private boolean f6803z0 = true;

        public void K0(boolean z2) {
            this.f6803z0 = z2;
        }

        public void L0(int i2) {
            this.f6801x0 = i2;
        }

        @Override // o.g
        public void S() {
            super.S();
            this.f6802y0.clear();
        }

        @Override // o.g
        public void U() {
            n nVarF;
            float f2;
            n nVar;
            int i2 = this.f6801x0;
            float f3 = Float.MAX_VALUE;
            if (i2 != 0) {
                if (i2 == 1) {
                    nVarF = this.f6910w.f();
                } else if (i2 == 2) {
                    nVarF = this.f6909v.f();
                } else if (i2 != 3) {
                    return;
                } else {
                    nVarF = this.f6911x.f();
                }
                f3 = 0.0f;
            } else {
                nVarF = this.f6908u.f();
            }
            int size = this.f6802y0.size();
            n nVar2 = null;
            for (int i3 = 0; i3 < size; i3++) {
                n nVar3 = (n) this.f6802y0.get(i3);
                if (nVar3.f6978b != 1) {
                    return;
                }
                int i4 = this.f6801x0;
                if (i4 == 0 || i4 == 2) {
                    f2 = nVar3.f6969h;
                    if (f2 < f3) {
                        nVar = nVar3.f6968g;
                        nVar2 = nVar;
                        f3 = f2;
                    }
                } else {
                    f2 = nVar3.f6969h;
                    if (f2 > f3) {
                        nVar = nVar3.f6968g;
                        nVar2 = nVar;
                        f3 = f2;
                    }
                }
            }
            n.e.x();
            nVarF.f6968g = nVar2;
            nVarF.f6969h = f3;
            nVarF.b();
            int i5 = this.f6801x0;
            if (i5 == 0) {
                this.f6910w.f().l(nVar2, f3);
                return;
            }
            if (i5 == 1) {
                this.f6908u.f().l(nVar2, f3);
            } else if (i5 == 2) {
                this.f6911x.f().l(nVar2, f3);
            } else {
                if (i5 != 3) {
                    return;
                }
                this.f6909v.f().l(nVar2, f3);
            }
        }

        @Override // o.g
        public void b(n.e eVar) {
            f[] fVarArr;
            boolean z2;
            int i2;
            int i3;
            f[] fVarArr2 = this.f6848C;
            fVarArr2[0] = this.f6908u;
            fVarArr2[2] = this.f6909v;
            fVarArr2[1] = this.f6910w;
            fVarArr2[3] = this.f6911x;
            int i4 = 0;
            while (true) {
                fVarArr = this.f6848C;
                if (i4 >= fVarArr.length) {
                    break;
                }
                f fVar = fVarArr[i4];
                fVar.f6827j = eVar.r(fVar);
                i4++;
            }
            int i5 = this.f6801x0;
            if (i5 < 0 || i5 >= 4) {
                return;
            }
            f fVar2 = fVarArr[i5];
            for (int i6 = 0; i6 < this.f6963w0; i6++) {
                g gVar = this.f6962v0[i6];
                if ((this.f6803z0 || gVar.c()) && ((((i2 = this.f6801x0) == 0 || i2 == 1) && gVar.s() == g.b.MATCH_CONSTRAINT) || (((i3 = this.f6801x0) == 2 || i3 == 3) && gVar.B() == g.b.MATCH_CONSTRAINT))) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
            int i7 = this.f6801x0;
            if (i7 == 0 || i7 == 1 ? u().s() == g.b.WRAP_CONTENT : u().B() == g.b.WRAP_CONTENT) {
                z2 = false;
            }
            for (int i8 = 0; i8 < this.f6963w0; i8++) {
                g gVar2 = this.f6962v0[i8];
                if (this.f6803z0 || gVar2.c()) {
                    n.i iVarR = eVar.r(gVar2.f6848C[this.f6801x0]);
                    f[] fVarArr3 = gVar2.f6848C;
                    int i9 = this.f6801x0;
                    fVarArr3[i9].f6827j = iVarR;
                    if (i9 == 0 || i9 == 2) {
                        eVar.j(fVar2.f6827j, iVarR, z2);
                    } else {
                        eVar.h(fVar2.f6827j, iVarR, z2);
                    }
                }
            }
            int i10 = this.f6801x0;
            if (i10 == 0) {
                eVar.e(this.f6910w.f6827j, this.f6908u.f6827j, 0, 6);
                if (z2) {
                    return;
                }
                eVar.e(this.f6908u.f6827j, this.f6851F.f6910w.f6827j, 0, 5);
                return;
            }
            if (i10 == 1) {
                eVar.e(this.f6908u.f6827j, this.f6910w.f6827j, 0, 6);
                if (z2) {
                    return;
                }
                eVar.e(this.f6908u.f6827j, this.f6851F.f6908u.f6827j, 0, 5);
                return;
            }
            if (i10 == 2) {
                eVar.e(this.f6911x.f6827j, this.f6909v.f6827j, 0, 6);
                if (z2) {
                    return;
                }
                eVar.e(this.f6909v.f6827j, this.f6851F.f6911x.f6827j, 0, 5);
                return;
            }
            if (i10 == 3) {
                eVar.e(this.f6909v.f6827j, this.f6911x.f6827j, 0, 6);
                if (z2) {
                    return;
                }
                eVar.e(this.f6909v.f6827j, this.f6851F.f6909v.f6827j, 0, 5);
            }
        }

        @Override // o.g
        public boolean c() {
            return true;
        }

        @Override // o.g
        public void d(int i2) {
            n nVarF;
            g gVar = this.f6851F;
            if (gVar != null && ((h) gVar).X0(2)) {
                int i3 = this.f6801x0;
                if (i3 == 0) {
                    nVarF = this.f6908u.f();
                } else if (i3 == 1) {
                    nVarF = this.f6910w.f();
                } else if (i3 == 2) {
                    nVarF = this.f6909v.f();
                } else if (i3 != 3) {
                    return;
                } else {
                    nVarF = this.f6911x.f();
                }
                nVarF.p(5);
                int i4 = this.f6801x0;
                if (i4 == 0 || i4 == 1) {
                    this.f6909v.f().l(null, 0.0f);
                    this.f6911x.f().l(null, 0.0f);
                } else {
                    this.f6908u.f().l(null, 0.0f);
                    this.f6910w.f().l(null, 0.0f);
                }
                this.f6802y0.clear();
                for (int i5 = 0; i5 < this.f6963w0; i5++) {
                    g gVar2 = this.f6962v0[i5];
                    if (this.f6803z0 || gVar2.c()) {
                        int i6 = this.f6801x0;
                        n nVarF2 = i6 != 0 ? i6 != 1 ? i6 != 2 ? i6 != 3 ? null : gVar2.f6911x.f() : gVar2.f6909v.f() : gVar2.f6910w.f() : gVar2.f6908u.f();
                        if (nVarF2 != null) {
                            this.f6802y0.add(nVarF2);
                            nVarF2.a(nVarF);
                        }
                    }
                }
            }
        }
    }

    abstract class d {
        static void a(h hVar, n.e eVar, int i2) {
            int i3;
            e[] eVarArr;
            int i4;
            if (i2 == 0) {
                i3 = hVar.f6923D0;
                eVarArr = hVar.f6926G0;
                i4 = 0;
            } else {
                i3 = hVar.f6924E0;
                eVarArr = hVar.f6925F0;
                i4 = 2;
            }
            for (int i5 = 0; i5 < i3; i5++) {
                e eVar2 = eVarArr[i5];
                eVar2.a();
                if (!hVar.X0(4)) {
                    b(hVar, eVar, i2, i4, eVar2);
                } else if (!l.b(hVar, eVar, i2, i4, eVar2)) {
                    b(hVar, eVar, i2, i4, eVar2);
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:317:0x002f A[PHI: r8 r15
  0x002f: PHI (r8v29 boolean) = (r8v1 boolean), (r8v31 boolean) binds: [B:327:0x0044, B:316:0x002d] A[DONT_GENERATE, DONT_INLINE]
  0x002f: PHI (r15v33 boolean) = (r15v1 boolean), (r15v35 boolean) binds: [B:327:0x0044, B:316:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:318:0x0031 A[PHI: r8 r15
  0x0031: PHI (r8v3 boolean) = (r8v1 boolean), (r8v31 boolean) binds: [B:327:0x0044, B:316:0x002d] A[DONT_GENERATE, DONT_INLINE]
  0x0031: PHI (r15v3 boolean) = (r15v1 boolean), (r15v35 boolean) binds: [B:327:0x0044, B:316:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:382:0x0138  */
        /* JADX WARN: Removed duplicated region for block: B:453:0x0289  */
        /* JADX WARN: Type inference failed for: r2v58, types: [o$g] */
        /* JADX WARN: Type inference failed for: r8v27 */
        /* JADX WARN: Type inference failed for: r8v28 */
        /* JADX WARN: Type inference failed for: r8v33 */
        /* JADX WARN: Type inference failed for: r8v5 */
        /* JADX WARN: Type inference failed for: r8v6, types: [o$g] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        static void b(o.h r34, n.e r35, int r36, int r37, o.e r38) {
            /*
                Method dump skipped, instructions count: 1210
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: o.d.b(o$h, n.e, int, int, o$e):void");
        }
    }

    public class e {

        /* renamed from: a */
        protected g f6804a;

        /* renamed from: b */
        protected g f6805b;

        /* renamed from: c */
        protected g f6806c;

        /* renamed from: d */
        protected g f6807d;
        protected g e;

        /* renamed from: f */
        protected g f6808f;

        /* renamed from: g */
        protected g f6809g;

        /* renamed from: h */
        protected ArrayList f6810h;

        /* renamed from: i */
        protected int f6811i;

        /* renamed from: j */
        protected int f6812j;

        /* renamed from: k */
        protected float f6813k = 0.0f;

        /* renamed from: l */
        private int f6814l;

        /* renamed from: m */
        private boolean f6815m;

        /* renamed from: n */
        protected boolean f6816n;
        protected boolean o;

        /* renamed from: p */
        protected boolean f6817p;

        /* renamed from: q */
        private boolean f6818q;

        public e(g gVar, int i2, boolean z2) {
            this.f6804a = gVar;
            this.f6814l = i2;
            this.f6815m = z2;
        }

        private void b() {
            int i2;
            int i3 = this.f6814l * 2;
            g gVar = this.f6804a;
            boolean z2 = false;
            g gVar2 = gVar;
            boolean z3 = false;
            while (!z3) {
                this.f6811i++;
                g[] gVarArr = gVar.f6904r0;
                int i4 = this.f6814l;
                g gVar3 = null;
                gVarArr[i4] = null;
                gVar.f6903q0[i4] = null;
                if (gVar.C() != 8) {
                    if (this.f6805b == null) {
                        this.f6805b = gVar;
                    }
                    this.f6807d = gVar;
                    g.b[] bVarArr = gVar.f6850E;
                    int i5 = this.f6814l;
                    if (bVarArr[i5] == g.b.MATCH_CONSTRAINT && ((i2 = gVar.f6883g[i5]) == 0 || i2 == 3 || i2 == 2)) {
                        this.f6812j++;
                        float f2 = gVar.f6901p0[i5];
                        if (f2 > 0.0f) {
                            this.f6813k += f2;
                        }
                        if (c(gVar, i5)) {
                            if (f2 < 0.0f) {
                                this.f6816n = true;
                            } else {
                                this.o = true;
                            }
                            if (this.f6810h == null) {
                                this.f6810h = new ArrayList();
                            }
                            this.f6810h.add(gVar);
                        }
                        if (this.f6808f == null) {
                            this.f6808f = gVar;
                        }
                        g gVar4 = this.f6809g;
                        if (gVar4 != null) {
                            gVar4.f6903q0[this.f6814l] = gVar;
                        }
                        this.f6809g = gVar;
                    }
                }
                if (gVar2 != gVar) {
                    gVar2.f6904r0[this.f6814l] = gVar;
                }
                f fVar = gVar.f6848C[i3 + 1].f6822d;
                if (fVar != null) {
                    g gVar5 = fVar.f6820b;
                    f fVar2 = gVar5.f6848C[i3].f6822d;
                    if (fVar2 != null && fVar2.f6820b == gVar) {
                        gVar3 = gVar5;
                    }
                }
                if (gVar3 == null) {
                    gVar3 = gVar;
                    z3 = true;
                }
                gVar2 = gVar;
                gVar = gVar3;
            }
            this.f6806c = gVar;
            if (this.f6814l == 0 && this.f6815m) {
                this.e = gVar;
            } else {
                this.e = this.f6804a;
            }
            if (this.o && this.f6816n) {
                z2 = true;
            }
            this.f6817p = z2;
        }

        private static boolean c(g gVar, int i2) {
            int i3;
            return gVar.C() != 8 && gVar.f6850E[i2] == g.b.MATCH_CONSTRAINT && ((i3 = gVar.f6883g[i2]) == 0 || i3 == 3);
        }

        public void a() {
            if (!this.f6818q) {
                b();
            }
            this.f6818q = true;
        }
    }

    public class f {

        /* renamed from: b */
        final g f6820b;

        /* renamed from: c */
        final d f6821c;

        /* renamed from: d */
        f f6822d;

        /* renamed from: j */
        n.i f6827j;

        /* renamed from: a */
        private n f6819a = new n(this);
        public int e = 0;

        /* renamed from: f */
        int f6823f = -1;

        /* renamed from: g */
        private c f6824g = c.NONE;

        /* renamed from: h */
        private b f6825h = b.RELAXED;

        /* renamed from: i */
        private int f6826i = 0;

        static /* synthetic */ class a {

            /* renamed from: a */
            static final /* synthetic */ int[] f6828a;

            static {
                int[] iArr = new int[d.values().length];
                f6828a = iArr;
                try {
                    iArr[d.CENTER.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    f6828a[d.LEFT.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    f6828a[d.RIGHT.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    f6828a[d.TOP.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    f6828a[d.BOTTOM.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    f6828a[d.BASELINE.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    f6828a[d.CENTER_X.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    f6828a[d.CENTER_Y.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    f6828a[d.NONE.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
            }
        }

        public enum b {
            RELAXED,
            STRICT
        }

        public enum c {
            NONE,
            STRONG,
            WEAK
        }

        public enum d {
            NONE,
            LEFT,
            TOP,
            RIGHT,
            BOTTOM,
            BASELINE,
            CENTER,
            CENTER_X,
            CENTER_Y
        }

        public f(g gVar, d dVar) {
            this.f6820b = gVar;
            this.f6821c = dVar;
        }

        public boolean a(f fVar, int i2, int i3, c cVar, int i4, boolean z2) {
            if (fVar == null) {
                this.f6822d = null;
                this.e = 0;
                this.f6823f = -1;
                this.f6824g = c.NONE;
                this.f6826i = 2;
                return true;
            }
            if (!z2 && !l(fVar)) {
                return false;
            }
            this.f6822d = fVar;
            if (i2 > 0) {
                this.e = i2;
            } else {
                this.e = 0;
            }
            this.f6823f = i3;
            this.f6824g = cVar;
            this.f6826i = i4;
            return true;
        }

        public boolean b(f fVar, int i2, c cVar, int i3) {
            return a(fVar, i2, -1, cVar, i3, false);
        }

        public int c() {
            return this.f6826i;
        }

        public int d() {
            f fVar;
            if (this.f6820b.C() == 8) {
                return 0;
            }
            return (this.f6823f <= -1 || (fVar = this.f6822d) == null || fVar.f6820b.C() != 8) ? this.e : this.f6823f;
        }

        public g e() {
            return this.f6820b;
        }

        public n f() {
            return this.f6819a;
        }

        public n.i g() {
            return this.f6827j;
        }

        public c h() {
            return this.f6824g;
        }

        public f i() {
            return this.f6822d;
        }

        public d j() {
            return this.f6821c;
        }

        public boolean k() {
            return this.f6822d != null;
        }

        public boolean l(f fVar) {
            if (fVar == null) {
                return false;
            }
            d dVarJ = fVar.j();
            d dVar = this.f6821c;
            if (dVarJ == dVar) {
                return dVar != d.BASELINE || (fVar.e().I() && e().I());
            }
            switch (a.f6828a[dVar.ordinal()]) {
                case 1:
                    return (dVarJ == d.BASELINE || dVarJ == d.CENTER_X || dVarJ == d.CENTER_Y) ? false : true;
                case 2:
                case 3:
                    boolean z2 = dVarJ == d.LEFT || dVarJ == d.RIGHT;
                    if (fVar.e() instanceof j) {
                        return z2 || dVarJ == d.CENTER_X;
                    }
                    return z2;
                case 4:
                case 5:
                    boolean z3 = dVarJ == d.TOP || dVarJ == d.BOTTOM;
                    if (fVar.e() instanceof j) {
                        return z3 || dVarJ == d.CENTER_Y;
                    }
                    return z3;
                case 6:
                case 7:
                case 8:
                case 9:
                    return false;
                default:
                    throw new AssertionError(this.f6821c.name());
            }
        }

        public void m() {
            this.f6822d = null;
            this.e = 0;
            this.f6823f = -1;
            this.f6824g = c.STRONG;
            this.f6826i = 0;
            this.f6825h = b.RELAXED;
            this.f6819a.e();
        }

        public void n(C0295c c0295c) {
            n.i iVar = this.f6827j;
            if (iVar == null) {
                this.f6827j = new n.i(i.a.UNRESTRICTED, null);
            } else {
                iVar.d();
            }
        }

        public String toString() {
            return this.f6820b.n() + ":" + this.f6821c.toString();
        }
    }

    public class h extends r {

        /* renamed from: A0 */
        int f6920A0;

        /* renamed from: B0 */
        int f6921B0;

        /* renamed from: C0 */
        int f6922C0;

        /* renamed from: y0 */
        private q f6940y0;

        /* renamed from: z0 */
        int f6941z0;

        /* renamed from: w0 */
        private boolean f6938w0 = false;

        /* renamed from: x0 */
        protected n.e f6939x0 = new n.e();

        /* renamed from: D0 */
        int f6923D0 = 0;

        /* renamed from: E0 */
        int f6924E0 = 0;

        /* renamed from: F0 */
        e[] f6925F0 = new e[4];

        /* renamed from: G0 */
        e[] f6926G0 = new e[4];

        /* renamed from: H0 */
        public List f6927H0 = new ArrayList();

        /* renamed from: I0 */
        public boolean f6928I0 = false;

        /* renamed from: J0 */
        public boolean f6929J0 = false;

        /* renamed from: K0 */
        public boolean f6930K0 = false;

        /* renamed from: L0 */
        public int f6931L0 = 0;

        /* renamed from: M0 */
        public int f6932M0 = 0;

        /* renamed from: N0 */
        private int f6933N0 = 7;

        /* renamed from: O0 */
        public boolean f6934O0 = false;

        /* renamed from: P0 */
        private boolean f6935P0 = false;

        /* renamed from: Q0 */
        private boolean f6936Q0 = false;

        /* renamed from: R0 */
        int f6937R0 = 0;

        private void P0(g gVar) {
            int i2 = this.f6923D0 + 1;
            e[] eVarArr = this.f6926G0;
            if (i2 >= eVarArr.length) {
                this.f6926G0 = (e[]) Arrays.copyOf(eVarArr, eVarArr.length * 2);
            }
            this.f6926G0[this.f6923D0] = new e(gVar, 0, U0());
            this.f6923D0++;
        }

        private void Q0(g gVar) {
            int i2 = this.f6924E0 + 1;
            e[] eVarArr = this.f6925F0;
            if (i2 >= eVarArr.length) {
                this.f6925F0 = (e[]) Arrays.copyOf(eVarArr, eVarArr.length * 2);
            }
            this.f6925F0[this.f6924E0] = new e(gVar, 1, U0());
            this.f6924E0++;
        }

        private void b1() {
            this.f6923D0 = 0;
            this.f6924E0 = 0;
        }

        /* JADX WARN: Removed duplicated region for block: B:238:0x0185  */
        /* JADX WARN: Removed duplicated region for block: B:241:0x0190  */
        /* JADX WARN: Removed duplicated region for block: B:257:0x01e0  */
        /* JADX WARN: Removed duplicated region for block: B:274:0x024a  */
        /* JADX WARN: Removed duplicated region for block: B:277:0x025b  */
        /* JADX WARN: Removed duplicated region for block: B:280:0x0278  */
        /* JADX WARN: Removed duplicated region for block: B:281:0x0285  */
        /* JADX WARN: Removed duplicated region for block: B:283:0x028a  */
        /* JADX WARN: Removed duplicated region for block: B:295:0x02c5 A[PHI: r0 r9
  0x02c5: PHI (r0v31 boolean) = (r0v30 boolean), (r0v33 boolean), (r0v33 boolean), (r0v33 boolean) binds: [B:282:0x0288, B:290:0x02ad, B:291:0x02af, B:293:0x02b5] A[DONT_GENERATE, DONT_INLINE]
  0x02c5: PHI (r9v11 boolean) = (r9v10 boolean), (r9v13 boolean), (r9v13 boolean), (r9v13 boolean) binds: [B:282:0x0288, B:290:0x02ad, B:291:0x02af, B:293:0x02b5] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Type inference failed for: r8v20 */
        /* JADX WARN: Type inference failed for: r8v21, types: [boolean] */
        /* JADX WARN: Type inference failed for: r8v25 */
        @Override // o.r
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void K0() {
            /*
                Method dump skipped, instructions count: 838
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: o.h.K0():void");
        }

        void N0(g gVar, int i2) {
            if (i2 == 0) {
                P0(gVar);
            } else if (i2 == 1) {
                Q0(gVar);
            }
        }

        public boolean O0(n.e eVar) {
            b(eVar);
            int size = this.f6987v0.size();
            for (int i2 = 0; i2 < size; i2++) {
                g gVar = (g) this.f6987v0.get(i2);
                if (gVar instanceof h) {
                    g.b[] bVarArr = gVar.f6850E;
                    g.b bVar = bVarArr[0];
                    g.b bVar2 = bVarArr[1];
                    g.b bVar3 = g.b.WRAP_CONTENT;
                    if (bVar == bVar3) {
                        gVar.g0(g.b.FIXED);
                    }
                    if (bVar2 == bVar3) {
                        gVar.u0(g.b.FIXED);
                    }
                    gVar.b(eVar);
                    if (bVar == bVar3) {
                        gVar.g0(bVar);
                    }
                    if (bVar2 == bVar3) {
                        gVar.u0(bVar2);
                    }
                } else {
                    l.c(this, eVar, gVar);
                    gVar.b(eVar);
                }
            }
            if (this.f6923D0 > 0) {
                d.a(this, eVar, 0);
            }
            if (this.f6924E0 > 0) {
                d.a(this, eVar, 1);
            }
            return true;
        }

        @Override // o.r, o.g
        public void Q() {
            this.f6939x0.E();
            this.f6941z0 = 0;
            this.f6921B0 = 0;
            this.f6920A0 = 0;
            this.f6922C0 = 0;
            this.f6927H0.clear();
            this.f6934O0 = false;
            super.Q();
        }

        public int R0() {
            return this.f6933N0;
        }

        public boolean S0() {
            return false;
        }

        public boolean T0() {
            return this.f6936Q0;
        }

        public boolean U0() {
            return this.f6938w0;
        }

        public boolean V0() {
            return this.f6935P0;
        }

        public void W0() {
            if (!X0(8)) {
                d(this.f6933N0);
            }
            e1();
        }

        public boolean X0(int i2) {
            return (this.f6933N0 & i2) == i2;
        }

        public void Y0(int i2, int i3) {
            C0097o c0097o;
            C0097o c0097o2;
            g.b bVar = this.f6850E[0];
            g.b bVar2 = g.b.WRAP_CONTENT;
            if (bVar != bVar2 && (c0097o2 = this.f6876c) != null) {
                c0097o2.h(i2);
            }
            if (this.f6850E[1] == bVar2 || (c0097o = this.f6878d) == null) {
                return;
            }
            c0097o.h(i3);
        }

        public void Z0() {
            int size = this.f6987v0.size();
            S();
            for (int i2 = 0; i2 < size; i2++) {
                ((g) this.f6987v0.get(i2)).S();
            }
        }

        public void a1() {
            Z0();
            d(this.f6933N0);
        }

        public void c1(int i2) {
            this.f6933N0 = i2;
        }

        @Override // o.g
        public void d(int i2) {
            super.d(i2);
            int size = this.f6987v0.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((g) this.f6987v0.get(i3)).d(i2);
            }
        }

        public void d1(boolean z2) {
            this.f6938w0 = z2;
        }

        public void e1() {
            n nVarF = h(f.d.LEFT).f();
            n nVarF2 = h(f.d.TOP).f();
            nVarF.l(null, 0.0f);
            nVarF2.l(null, 0.0f);
        }

        public void f1(n.e eVar, boolean[] zArr) {
            zArr[2] = false;
            G0(eVar);
            int size = this.f6987v0.size();
            for (int i2 = 0; i2 < size; i2++) {
                g gVar = (g) this.f6987v0.get(i2);
                gVar.G0(eVar);
                g.b bVar = gVar.f6850E[0];
                g.b bVar2 = g.b.MATCH_CONSTRAINT;
                if (bVar == bVar2 && gVar.D() < gVar.F()) {
                    zArr[2] = true;
                }
                if (gVar.f6850E[1] == bVar2 && gVar.r() < gVar.E()) {
                    zArr[2] = true;
                }
            }
        }
    }

    public class j extends g {

        /* renamed from: v0 */
        protected float f6956v0 = -1.0f;

        /* renamed from: w0 */
        protected int f6957w0 = -1;

        /* renamed from: x0 */
        protected int f6958x0 = -1;

        /* renamed from: y0 */
        private f f6959y0 = this.f6909v;

        /* renamed from: z0 */
        private int f6960z0 = 0;

        /* renamed from: A0 */
        private boolean f6952A0 = false;

        /* renamed from: B0 */
        private int f6953B0 = 0;

        /* renamed from: C0 */
        private m f6954C0 = new m();

        /* renamed from: D0 */
        private int f6955D0 = 8;

        static /* synthetic */ class a {

            /* renamed from: a */
            static final /* synthetic */ int[] f6961a;

            static {
                int[] iArr = new int[f.d.values().length];
                f6961a = iArr;
                try {
                    iArr[f.d.LEFT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    f6961a[f.d.RIGHT.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    f6961a[f.d.TOP.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    f6961a[f.d.BOTTOM.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    f6961a[f.d.BASELINE.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    f6961a[f.d.CENTER.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    f6961a[f.d.CENTER_X.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    f6961a[f.d.CENTER_Y.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    f6961a[f.d.NONE.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
            }
        }

        public j() {
            this.f6849D.clear();
            this.f6849D.add(this.f6959y0);
            int length = this.f6848C.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.f6848C[i2] = this.f6959y0;
            }
        }

        @Override // o.g
        public void G0(n.e eVar) {
            if (u() == null) {
                return;
            }
            int iY = eVar.y(this.f6959y0);
            if (this.f6960z0 == 1) {
                C0(iY);
                D0(0);
                b0(u().r());
                y0(0);
                return;
            }
            C0(0);
            D0(iY);
            y0(u().D());
            b0(0);
        }

        public int I0() {
            return this.f6960z0;
        }

        public void J0(int i2) {
            if (i2 > -1) {
                this.f6956v0 = -1.0f;
                this.f6957w0 = i2;
                this.f6958x0 = -1;
            }
        }

        public void K0(int i2) {
            if (i2 > -1) {
                this.f6956v0 = -1.0f;
                this.f6957w0 = -1;
                this.f6958x0 = i2;
            }
        }

        public void L0(float f2) {
            if (f2 > -1.0f) {
                this.f6956v0 = f2;
                this.f6957w0 = -1;
                this.f6958x0 = -1;
            }
        }

        public void M0(int i2) {
            if (this.f6960z0 == i2) {
                return;
            }
            this.f6960z0 = i2;
            this.f6849D.clear();
            if (this.f6960z0 == 1) {
                this.f6959y0 = this.f6908u;
            } else {
                this.f6959y0 = this.f6909v;
            }
            this.f6849D.add(this.f6959y0);
            int length = this.f6848C.length;
            for (int i3 = 0; i3 < length; i3++) {
                this.f6848C[i3] = this.f6959y0;
            }
        }

        @Override // o.g
        public void b(n.e eVar) {
            h hVar = (h) u();
            if (hVar == null) {
                return;
            }
            f fVarH = hVar.h(f.d.LEFT);
            f fVarH2 = hVar.h(f.d.RIGHT);
            g gVar = this.f6851F;
            boolean z2 = gVar != null && gVar.f6850E[0] == g.b.WRAP_CONTENT;
            if (this.f6960z0 == 0) {
                fVarH = hVar.h(f.d.TOP);
                fVarH2 = hVar.h(f.d.BOTTOM);
                g gVar2 = this.f6851F;
                z2 = gVar2 != null && gVar2.f6850E[1] == g.b.WRAP_CONTENT;
            }
            if (this.f6957w0 != -1) {
                n.i iVarR = eVar.r(this.f6959y0);
                eVar.e(iVarR, eVar.r(fVarH), this.f6957w0, 6);
                if (z2) {
                    eVar.i(eVar.r(fVarH2), iVarR, 0, 5);
                    return;
                }
                return;
            }
            if (this.f6958x0 == -1) {
                if (this.f6956v0 != -1.0f) {
                    eVar.d(n.e.t(eVar, eVar.r(this.f6959y0), eVar.r(fVarH), eVar.r(fVarH2), this.f6956v0, this.f6952A0));
                    return;
                }
                return;
            }
            n.i iVarR2 = eVar.r(this.f6959y0);
            n.i iVarR3 = eVar.r(fVarH2);
            eVar.e(iVarR2, iVarR3, -this.f6958x0, 6);
            if (z2) {
                eVar.i(iVarR2, eVar.r(fVarH), 0, 5);
                eVar.i(iVarR3, iVarR2, 0, 5);
            }
        }

        @Override // o.g
        public boolean c() {
            return true;
        }

        @Override // o.g
        public void d(int i2) {
            g gVarU = u();
            if (gVarU == null) {
                return;
            }
            if (I0() == 1) {
                this.f6909v.f().h(1, gVarU.f6909v.f(), 0);
                this.f6911x.f().h(1, gVarU.f6909v.f(), 0);
                if (this.f6957w0 != -1) {
                    this.f6908u.f().h(1, gVarU.f6908u.f(), this.f6957w0);
                    this.f6910w.f().h(1, gVarU.f6908u.f(), this.f6957w0);
                    return;
                } else if (this.f6958x0 != -1) {
                    this.f6908u.f().h(1, gVarU.f6910w.f(), -this.f6958x0);
                    this.f6910w.f().h(1, gVarU.f6910w.f(), -this.f6958x0);
                    return;
                } else {
                    if (this.f6956v0 == -1.0f || gVarU.s() != g.b.FIXED) {
                        return;
                    }
                    int i3 = (int) (gVarU.f6852G * this.f6956v0);
                    this.f6908u.f().h(1, gVarU.f6908u.f(), i3);
                    this.f6910w.f().h(1, gVarU.f6908u.f(), i3);
                    return;
                }
            }
            this.f6908u.f().h(1, gVarU.f6908u.f(), 0);
            this.f6910w.f().h(1, gVarU.f6908u.f(), 0);
            if (this.f6957w0 != -1) {
                this.f6909v.f().h(1, gVarU.f6909v.f(), this.f6957w0);
                this.f6911x.f().h(1, gVarU.f6909v.f(), this.f6957w0);
            } else if (this.f6958x0 != -1) {
                this.f6909v.f().h(1, gVarU.f6911x.f(), -this.f6958x0);
                this.f6911x.f().h(1, gVarU.f6911x.f(), -this.f6958x0);
            } else {
                if (this.f6956v0 == -1.0f || gVarU.B() != g.b.FIXED) {
                    return;
                }
                int i4 = (int) (gVarU.f6853H * this.f6956v0);
                this.f6909v.f().h(1, gVarU.f6909v.f(), i4);
                this.f6911x.f().h(1, gVarU.f6909v.f(), i4);
            }
        }

        @Override // o.g
        public f h(f.d dVar) {
            switch (a.f6961a[dVar.ordinal()]) {
                case 1:
                case 2:
                    if (this.f6960z0 == 1) {
                        return this.f6959y0;
                    }
                    break;
                case 3:
                case 4:
                    if (this.f6960z0 == 0) {
                        return this.f6959y0;
                    }
                    break;
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    return null;
            }
            throw new AssertionError(dVar.name());
        }

        @Override // o.g
        public ArrayList i() {
            return this.f6849D;
        }
    }

    public abstract class k extends g {

        /* renamed from: v0 */
        protected g[] f6962v0 = new g[4];

        /* renamed from: w0 */
        protected int f6963w0 = 0;

        public void I0(g gVar) {
            int i2 = this.f6963w0 + 1;
            g[] gVarArr = this.f6962v0;
            if (i2 > gVarArr.length) {
                this.f6962v0 = (g[]) Arrays.copyOf(gVarArr, gVarArr.length * 2);
            }
            g[] gVarArr2 = this.f6962v0;
            int i3 = this.f6963w0;
            gVarArr2[i3] = gVar;
            this.f6963w0 = i3 + 1;
        }

        public void J0() {
            this.f6963w0 = 0;
        }
    }

    public abstract class l {

        /* renamed from: a */
        static boolean[] f6964a = new boolean[3];

        static void a(int i2, g gVar) {
            gVar.H0();
            n nVarF = gVar.f6908u.f();
            n nVarF2 = gVar.f6909v.f();
            n nVarF3 = gVar.f6910w.f();
            n nVarF4 = gVar.f6911x.f();
            boolean z2 = (i2 & 8) == 8;
            g.b bVar = gVar.f6850E[0];
            g.b bVar2 = g.b.MATCH_CONSTRAINT;
            boolean z3 = bVar == bVar2 && d(gVar, 0);
            if (nVarF.f6970i != 4 && nVarF3.f6970i != 4) {
                if (gVar.f6850E[0] == g.b.FIXED || (z3 && gVar.C() == 8)) {
                    f fVar = gVar.f6908u.f6822d;
                    if (fVar == null && gVar.f6910w.f6822d == null) {
                        nVarF.p(1);
                        nVarF3.p(1);
                        if (z2) {
                            nVarF3.j(nVarF, 1, gVar.x());
                        } else {
                            nVarF3.i(nVarF, gVar.D());
                        }
                    } else if (fVar != null && gVar.f6910w.f6822d == null) {
                        nVarF.p(1);
                        nVarF3.p(1);
                        if (z2) {
                            nVarF3.j(nVarF, 1, gVar.x());
                        } else {
                            nVarF3.i(nVarF, gVar.D());
                        }
                    } else if (fVar == null && gVar.f6910w.f6822d != null) {
                        nVarF.p(1);
                        nVarF3.p(1);
                        nVarF.i(nVarF3, -gVar.D());
                        if (z2) {
                            nVarF.j(nVarF3, -1, gVar.x());
                        } else {
                            nVarF.i(nVarF3, -gVar.D());
                        }
                    } else if (fVar != null && gVar.f6910w.f6822d != null) {
                        nVarF.p(2);
                        nVarF3.p(2);
                        if (z2) {
                            gVar.x().a(nVarF);
                            gVar.x().a(nVarF3);
                            nVarF.o(nVarF3, -1, gVar.x());
                            nVarF3.o(nVarF, 1, gVar.x());
                        } else {
                            nVarF.n(nVarF3, -gVar.D());
                            nVarF3.n(nVarF, gVar.D());
                        }
                    }
                } else if (z3) {
                    int iD = gVar.D();
                    nVarF.p(1);
                    nVarF3.p(1);
                    f fVar2 = gVar.f6908u.f6822d;
                    if (fVar2 == null && gVar.f6910w.f6822d == null) {
                        if (z2) {
                            nVarF3.j(nVarF, 1, gVar.x());
                        } else {
                            nVarF3.i(nVarF, iD);
                        }
                    } else if (fVar2 == null || gVar.f6910w.f6822d != null) {
                        if (fVar2 != null || gVar.f6910w.f6822d == null) {
                            if (fVar2 != null && gVar.f6910w.f6822d != null) {
                                if (z2) {
                                    gVar.x().a(nVarF);
                                    gVar.x().a(nVarF3);
                                }
                                if (gVar.f6854I == 0.0f) {
                                    nVarF.p(3);
                                    nVarF3.p(3);
                                    nVarF.n(nVarF3, 0.0f);
                                    nVarF3.n(nVarF, 0.0f);
                                } else {
                                    nVarF.p(2);
                                    nVarF3.p(2);
                                    nVarF.n(nVarF3, -iD);
                                    nVarF3.n(nVarF, iD);
                                    gVar.y0(iD);
                                }
                            }
                        } else if (z2) {
                            nVarF.j(nVarF3, -1, gVar.x());
                        } else {
                            nVarF.i(nVarF3, -iD);
                        }
                    } else if (z2) {
                        nVarF3.j(nVarF, 1, gVar.x());
                    } else {
                        nVarF3.i(nVarF, iD);
                    }
                }
            }
            boolean z4 = gVar.f6850E[1] == bVar2 && d(gVar, 1);
            if (nVarF2.f6970i == 4 || nVarF4.f6970i == 4) {
                return;
            }
            if (gVar.f6850E[1] != g.b.FIXED && (!z4 || gVar.C() != 8)) {
                if (z4) {
                    int iR = gVar.r();
                    nVarF2.p(1);
                    nVarF4.p(1);
                    f fVar3 = gVar.f6909v.f6822d;
                    if (fVar3 == null && gVar.f6911x.f6822d == null) {
                        if (z2) {
                            nVarF4.j(nVarF2, 1, gVar.w());
                            return;
                        } else {
                            nVarF4.i(nVarF2, iR);
                            return;
                        }
                    }
                    if (fVar3 != null && gVar.f6911x.f6822d == null) {
                        if (z2) {
                            nVarF4.j(nVarF2, 1, gVar.w());
                            return;
                        } else {
                            nVarF4.i(nVarF2, iR);
                            return;
                        }
                    }
                    if (fVar3 == null && gVar.f6911x.f6822d != null) {
                        if (z2) {
                            nVarF2.j(nVarF4, -1, gVar.w());
                            return;
                        } else {
                            nVarF2.i(nVarF4, -iR);
                            return;
                        }
                    }
                    if (fVar3 == null || gVar.f6911x.f6822d == null) {
                        return;
                    }
                    if (z2) {
                        gVar.w().a(nVarF2);
                        gVar.x().a(nVarF4);
                    }
                    if (gVar.f6854I == 0.0f) {
                        nVarF2.p(3);
                        nVarF4.p(3);
                        nVarF2.n(nVarF4, 0.0f);
                        nVarF4.n(nVarF2, 0.0f);
                        return;
                    }
                    nVarF2.p(2);
                    nVarF4.p(2);
                    nVarF2.n(nVarF4, -iR);
                    nVarF4.n(nVarF2, iR);
                    gVar.b0(iR);
                    if (gVar.f6866U > 0) {
                        gVar.f6912y.f().h(1, nVarF2, gVar.f6866U);
                        return;
                    }
                    return;
                }
                return;
            }
            f fVar4 = gVar.f6909v.f6822d;
            if (fVar4 == null && gVar.f6911x.f6822d == null) {
                nVarF2.p(1);
                nVarF4.p(1);
                if (z2) {
                    nVarF4.j(nVarF2, 1, gVar.w());
                } else {
                    nVarF4.i(nVarF2, gVar.r());
                }
                f fVar5 = gVar.f6912y;
                if (fVar5.f6822d != null) {
                    fVar5.f().p(1);
                    nVarF2.h(1, gVar.f6912y.f(), -gVar.f6866U);
                    return;
                }
                return;
            }
            if (fVar4 != null && gVar.f6911x.f6822d == null) {
                nVarF2.p(1);
                nVarF4.p(1);
                if (z2) {
                    nVarF4.j(nVarF2, 1, gVar.w());
                } else {
                    nVarF4.i(nVarF2, gVar.r());
                }
                if (gVar.f6866U > 0) {
                    gVar.f6912y.f().h(1, nVarF2, gVar.f6866U);
                    return;
                }
                return;
            }
            if (fVar4 == null && gVar.f6911x.f6822d != null) {
                nVarF2.p(1);
                nVarF4.p(1);
                if (z2) {
                    nVarF2.j(nVarF4, -1, gVar.w());
                } else {
                    nVarF2.i(nVarF4, -gVar.r());
                }
                if (gVar.f6866U > 0) {
                    gVar.f6912y.f().h(1, nVarF2, gVar.f6866U);
                    return;
                }
                return;
            }
            if (fVar4 == null || gVar.f6911x.f6822d == null) {
                return;
            }
            nVarF2.p(2);
            nVarF4.p(2);
            if (z2) {
                nVarF2.o(nVarF4, -1, gVar.w());
                nVarF4.o(nVarF2, 1, gVar.w());
                gVar.w().a(nVarF2);
                gVar.x().a(nVarF4);
            } else {
                nVarF2.n(nVarF4, -gVar.r());
                nVarF4.n(nVarF2, gVar.r());
            }
            if (gVar.f6866U > 0) {
                gVar.f6912y.f().h(1, nVarF2, gVar.f6866U);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:236:0x002c A[PHI: r11 r12
  0x002c: PHI (r11v8 boolean) = (r11v1 boolean), (r11v10 boolean) binds: [B:245:0x003c, B:235:0x002a] A[DONT_GENERATE, DONT_INLINE]
  0x002c: PHI (r12v7 boolean) = (r12v1 boolean), (r12v9 boolean) binds: [B:245:0x003c, B:235:0x002a] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:237:0x002e A[PHI: r11 r12
  0x002e: PHI (r11v3 boolean) = (r11v1 boolean), (r11v10 boolean) binds: [B:245:0x003c, B:235:0x002a] A[DONT_GENERATE, DONT_INLINE]
  0x002e: PHI (r12v3 boolean) = (r12v1 boolean), (r12v9 boolean) binds: [B:245:0x003c, B:235:0x002a] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:296:0x00ef  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        static boolean b(o.h r21, n.e r22, int r23, int r24, o.e r25) {
            /*
                Method dump skipped, instructions count: 816
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: o.l.b(o$h, n.e, int, int, o$e):boolean");
        }

        static void c(h hVar, n.e eVar, g gVar) {
            g.b bVar = hVar.f6850E[0];
            g.b bVar2 = g.b.WRAP_CONTENT;
            if (bVar != bVar2 && gVar.f6850E[0] == g.b.MATCH_PARENT) {
                int i2 = gVar.f6908u.e;
                int iD = hVar.D() - gVar.f6910w.e;
                f fVar = gVar.f6908u;
                fVar.f6827j = eVar.r(fVar);
                f fVar2 = gVar.f6910w;
                fVar2.f6827j = eVar.r(fVar2);
                eVar.f(gVar.f6908u.f6827j, i2);
                eVar.f(gVar.f6910w.f6827j, iD);
                gVar.f6872a = 2;
                gVar.f0(i2, iD);
            }
            if (hVar.f6850E[1] == bVar2 || gVar.f6850E[1] != g.b.MATCH_PARENT) {
                return;
            }
            int i3 = gVar.f6909v.e;
            int iR = hVar.r() - gVar.f6911x.e;
            f fVar3 = gVar.f6909v;
            fVar3.f6827j = eVar.r(fVar3);
            f fVar4 = gVar.f6911x;
            fVar4.f6827j = eVar.r(fVar4);
            eVar.f(gVar.f6909v.f6827j, i3);
            eVar.f(gVar.f6911x.f6827j, iR);
            if (gVar.f6866U > 0 || gVar.C() == 8) {
                f fVar5 = gVar.f6912y;
                fVar5.f6827j = eVar.r(fVar5);
                eVar.f(gVar.f6912y.f6827j, gVar.f6866U + i3);
            }
            gVar.f6874b = 2;
            gVar.t0(i3, iR);
        }

        private static boolean d(g gVar, int i2) {
            g.b[] bVarArr = gVar.f6850E;
            if (bVarArr[i2] != g.b.MATCH_CONSTRAINT) {
                return false;
            }
            if (gVar.f6854I != 0.0f) {
                g.b bVar = bVarArr[i2 != 0 ? (char) 0 : (char) 1];
                return false;
            }
            if (i2 == 0) {
                if (gVar.e != 0 || gVar.f6885h != 0 || gVar.f6887i != 0) {
                    return false;
                }
            } else if (gVar.f6881f != 0 || gVar.f6891k != 0 || gVar.f6893l != 0) {
                return false;
            }
            return true;
        }

        static void e(g gVar, int i2, int i3) {
            int i4 = i2 * 2;
            int i5 = i4 + 1;
            gVar.f6848C[i4].f().f6968g = gVar.u().f6908u.f();
            gVar.f6848C[i4].f().f6969h = i3;
            gVar.f6848C[i4].f().f6978b = 1;
            gVar.f6848C[i5].f().f6968g = gVar.f6848C[i4].f();
            gVar.f6848C[i5].f().f6969h = gVar.t(i2);
            gVar.f6848C[i5].f().f6978b = 1;
        }
    }

    public class m {
    }

    public class n extends p {

        /* renamed from: c */
        f f6965c;

        /* renamed from: d */
        float f6966d;
        n e;

        /* renamed from: f */
        float f6967f;

        /* renamed from: g */
        n f6968g;

        /* renamed from: h */
        float f6969h;

        /* renamed from: j */
        private n f6971j;

        /* renamed from: k */
        private float f6972k;

        /* renamed from: i */
        int f6970i = 0;

        /* renamed from: l */
        private C0097o f6973l = null;

        /* renamed from: m */
        private int f6974m = 1;

        /* renamed from: n */
        private C0097o f6975n = null;
        private int o = 1;

        public n(f fVar) {
            this.f6965c = fVar;
        }

        @Override // o.p
        public void e() {
            super.e();
            this.e = null;
            this.f6967f = 0.0f;
            this.f6973l = null;
            this.f6974m = 1;
            this.f6975n = null;
            this.o = 1;
            this.f6968g = null;
            this.f6969h = 0.0f;
            this.f6966d = 0.0f;
            this.f6971j = null;
            this.f6972k = 0.0f;
            this.f6970i = 0;
        }

        @Override // o.p
        public void f() {
            int i2;
            n nVar;
            n nVar2;
            n nVar3;
            n nVar4;
            n nVar5;
            n nVar6;
            float fD;
            float f2;
            n nVar7;
            boolean z2 = true;
            if (this.f6978b == 1 || (i2 = this.f6970i) == 4) {
                return;
            }
            C0097o c0097o = this.f6973l;
            if (c0097o != null) {
                if (c0097o.f6978b != 1) {
                    return;
                } else {
                    this.f6967f = this.f6974m * c0097o.f6976c;
                }
            }
            C0097o c0097o2 = this.f6975n;
            if (c0097o2 != null) {
                if (c0097o2.f6978b != 1) {
                    return;
                } else {
                    this.f6972k = this.o * c0097o2.f6976c;
                }
            }
            if (i2 == 1 && ((nVar7 = this.e) == null || nVar7.f6978b == 1)) {
                if (nVar7 == null) {
                    this.f6968g = this;
                    this.f6969h = this.f6967f;
                } else {
                    this.f6968g = nVar7.f6968g;
                    this.f6969h = nVar7.f6969h + this.f6967f;
                }
                b();
                return;
            }
            if (i2 != 2 || (nVar4 = this.e) == null || nVar4.f6978b != 1 || (nVar5 = this.f6971j) == null || (nVar6 = nVar5.e) == null || nVar6.f6978b != 1) {
                if (i2 != 3 || (nVar = this.e) == null || nVar.f6978b != 1 || (nVar2 = this.f6971j) == null || (nVar3 = nVar2.e) == null || nVar3.f6978b != 1) {
                    if (i2 == 5) {
                        this.f6965c.f6820b.U();
                        return;
                    }
                    return;
                }
                n.e.x();
                n nVar8 = this.e;
                this.f6968g = nVar8.f6968g;
                n nVar9 = this.f6971j;
                n nVar10 = nVar9.e;
                nVar9.f6968g = nVar10.f6968g;
                this.f6969h = nVar8.f6969h + this.f6967f;
                nVar9.f6969h = nVar10.f6969h + nVar9.f6967f;
                b();
                this.f6971j.b();
                return;
            }
            n.e.x();
            n nVar11 = this.e;
            this.f6968g = nVar11.f6968g;
            n nVar12 = this.f6971j;
            n nVar13 = nVar12.e;
            nVar12.f6968g = nVar13.f6968g;
            f.d dVar = this.f6965c.f6821c;
            f.d dVar2 = f.d.RIGHT;
            int i3 = 0;
            if (dVar != dVar2 && dVar != f.d.BOTTOM) {
                z2 = false;
            }
            float f3 = z2 ? nVar11.f6969h - nVar13.f6969h : nVar13.f6969h - nVar11.f6969h;
            if (dVar == f.d.LEFT || dVar == dVar2) {
                fD = f3 - r2.f6820b.D();
                f2 = this.f6965c.f6820b.f6871Z;
            } else {
                fD = f3 - r2.f6820b.r();
                f2 = this.f6965c.f6820b.f6873a0;
            }
            int iD = this.f6965c.d();
            int iD2 = this.f6971j.f6965c.d();
            if (this.f6965c.i() == this.f6971j.f6965c.i()) {
                f2 = 0.5f;
                iD2 = 0;
            } else {
                i3 = iD;
            }
            float f4 = i3;
            float f5 = iD2;
            float f6 = (fD - f4) - f5;
            if (z2) {
                n nVar14 = this.f6971j;
                nVar14.f6969h = nVar14.e.f6969h + f5 + (f6 * f2);
                this.f6969h = (this.e.f6969h - f4) - (f6 * (1.0f - f2));
            } else {
                this.f6969h = this.e.f6969h + f4 + (f6 * f2);
                n nVar15 = this.f6971j;
                nVar15.f6969h = (nVar15.e.f6969h - f5) - (f6 * (1.0f - f2));
            }
            b();
            this.f6971j.b();
        }

        void g(n.e eVar) {
            n.i iVarG = this.f6965c.g();
            n nVar = this.f6968g;
            if (nVar == null) {
                eVar.f(iVarG, (int) (this.f6969h + 0.5f));
            } else {
                eVar.e(iVarG, eVar.r(nVar.f6965c), (int) (this.f6969h + 0.5f), 6);
            }
        }

        public void h(int i2, n nVar, int i3) {
            this.f6970i = i2;
            this.e = nVar;
            this.f6967f = i3;
            nVar.a(this);
        }

        public void i(n nVar, int i2) {
            this.e = nVar;
            this.f6967f = i2;
            nVar.a(this);
        }

        public void j(n nVar, int i2, C0097o c0097o) {
            this.e = nVar;
            nVar.a(this);
            this.f6973l = c0097o;
            this.f6974m = i2;
            c0097o.a(this);
        }

        public float k() {
            return this.f6969h;
        }

        public void l(n nVar, float f2) {
            int i2 = this.f6978b;
            if (i2 == 0 || !(this.f6968g == nVar || this.f6969h == f2)) {
                this.f6968g = nVar;
                this.f6969h = f2;
                if (i2 == 1) {
                    c();
                }
                b();
            }
        }

        String m(int i2) {
            return i2 == 1 ? "DIRECT" : i2 == 2 ? "CENTER" : i2 == 3 ? "MATCH" : i2 == 4 ? "CHAIN" : i2 == 5 ? "BARRIER" : "UNCONNECTED";
        }

        public void n(n nVar, float f2) {
            this.f6971j = nVar;
            this.f6972k = f2;
        }

        public void o(n nVar, int i2, C0097o c0097o) {
            this.f6971j = nVar;
            this.f6975n = c0097o;
            this.o = i2;
        }

        public void p(int i2) {
            this.f6970i = i2;
        }

        public void q() {
            f fVarI = this.f6965c.i();
            if (fVarI == null) {
                return;
            }
            if (fVarI.i() == this.f6965c) {
                this.f6970i = 4;
                fVarI.f().f6970i = 4;
            }
            int iD = this.f6965c.d();
            f.d dVar = this.f6965c.f6821c;
            if (dVar == f.d.RIGHT || dVar == f.d.BOTTOM) {
                iD = -iD;
            }
            i(fVarI.f(), iD);
        }

        public String toString() {
            if (this.f6978b != 1) {
                return "{ " + this.f6965c + " UNRESOLVED} type: " + m(this.f6970i);
            }
            if (this.f6968g == this) {
                return "[" + this.f6965c + ", RESOLVED: " + this.f6969h + "]  type: " + m(this.f6970i);
            }
            return "[" + this.f6965c + ", RESOLVED: " + this.f6968g + ":" + this.f6969h + "] type: " + m(this.f6970i);
        }
    }

    /* renamed from: o$o */
    public class C0097o extends p {

        /* renamed from: c */
        float f6976c = 0.0f;

        @Override // o.p
        public void e() {
            super.e();
            this.f6976c = 0.0f;
        }

        public void g() {
            this.f6978b = 2;
        }

        public void h(int i2) {
            int i3 = this.f6978b;
            if (i3 == 0 || this.f6976c != i2) {
                this.f6976c = i2;
                if (i3 == 1) {
                    c();
                }
                b();
            }
        }
    }

    public class q {

        /* renamed from: a */
        private int f6979a;

        /* renamed from: b */
        private int f6980b;

        /* renamed from: c */
        private int f6981c;

        /* renamed from: d */
        private int f6982d;
        private ArrayList e = new ArrayList();

        static class a {

            /* renamed from: a */
            private f f6983a;

            /* renamed from: b */
            private f f6984b;

            /* renamed from: c */
            private int f6985c;

            /* renamed from: d */
            private f.c f6986d;
            private int e;

            public a(f fVar) {
                this.f6983a = fVar;
                this.f6984b = fVar.i();
                this.f6985c = fVar.d();
                this.f6986d = fVar.h();
                this.e = fVar.c();
            }

            public void a(g gVar) {
                gVar.h(this.f6983a.j()).b(this.f6984b, this.f6985c, this.f6986d, this.e);
            }

            public void b(g gVar) {
                f fVarH = gVar.h(this.f6983a.j());
                this.f6983a = fVarH;
                if (fVarH != null) {
                    this.f6984b = fVarH.i();
                    this.f6985c = this.f6983a.d();
                    this.f6986d = this.f6983a.h();
                    this.e = this.f6983a.c();
                    return;
                }
                this.f6984b = null;
                this.f6985c = 0;
                this.f6986d = f.c.STRONG;
                this.e = 0;
            }
        }

        public q(g gVar) {
            this.f6979a = gVar.G();
            this.f6980b = gVar.H();
            this.f6981c = gVar.D();
            this.f6982d = gVar.r();
            ArrayList arrayListI = gVar.i();
            int size = arrayListI.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.e.add(new a((f) arrayListI.get(i2)));
            }
        }

        public void a(g gVar) {
            gVar.C0(this.f6979a);
            gVar.D0(this.f6980b);
            gVar.y0(this.f6981c);
            gVar.b0(this.f6982d);
            int size = this.e.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((a) this.e.get(i2)).a(gVar);
            }
        }

        public void b(g gVar) {
            this.f6979a = gVar.G();
            this.f6980b = gVar.H();
            this.f6981c = gVar.D();
            this.f6982d = gVar.r();
            int size = this.e.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((a) this.e.get(i2)).b(gVar);
            }
        }
    }

    public abstract class r extends g {

        /* renamed from: v0 */
        protected ArrayList f6987v0 = new ArrayList();

        @Override // o.g
        public void F0() {
            super.F0();
            ArrayList arrayList = this.f6987v0;
            if (arrayList == null) {
                return;
            }
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                g gVar = (g) this.f6987v0.get(i2);
                gVar.n0(p(), q());
                if (!(gVar instanceof h)) {
                    gVar.F0();
                }
            }
        }

        public void I0(g gVar) {
            this.f6987v0.add(gVar);
            if (gVar.u() != null) {
                ((r) gVar.u()).L0(gVar);
            }
            gVar.p0(this);
        }

        public h J0() {
            g gVarU = u();
            h hVar = this instanceof h ? (h) this : null;
            while (gVarU != null) {
                g gVarU2 = gVarU.u();
                if (gVarU instanceof h) {
                    hVar = (h) gVarU;
                }
                gVarU = gVarU2;
            }
            return hVar;
        }

        public abstract void K0();

        public void L0(g gVar) {
            this.f6987v0.remove(gVar);
            gVar.p0(null);
        }

        public void M0() {
            this.f6987v0.clear();
        }

        @Override // o.g
        public void Q() {
            this.f6987v0.clear();
            super.Q();
        }

        @Override // o.g
        public void T(C0295c c0295c) {
            super.T(c0295c);
            int size = this.f6987v0.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((g) this.f6987v0.get(i2)).T(c0295c);
            }
        }

        @Override // o.g
        public void n0(int i2, int i3) {
            super.n0(i2, i3);
            int size = this.f6987v0.size();
            for (int i4 = 0; i4 < size; i4++) {
                ((g) this.f6987v0.get(i4)).n0(z(), A());
            }
        }
    }

    public o(Context context) {
        this.f6792a = context;
    }

    public synchronized void c() {
        a aVar = this.f6793b;
        if (aVar != null) {
            aVar.e();
            this.f6793b = null;
        }
    }

    public synchronized void d(String str) {
        c();
        a aVar = new a(str);
        this.f6793b = aVar;
        aVar.d();
    }

    public void e(defpackage.q qVar) {
        this.f6795d = qVar;
    }

    public class i {

        /* renamed from: a */
        public List f6942a;

        /* renamed from: b */
        int f6943b;

        /* renamed from: c */
        int f6944c;

        /* renamed from: d */
        public boolean f6945d;
        public final int[] e;

        /* renamed from: f */
        List f6946f;

        /* renamed from: g */
        List f6947g;

        /* renamed from: h */
        HashSet f6948h;

        /* renamed from: i */
        HashSet f6949i;

        /* renamed from: j */
        List f6950j;

        /* renamed from: k */
        List f6951k;

        i(List list) {
            this.f6943b = -1;
            this.f6944c = -1;
            this.f6945d = false;
            this.e = new int[]{-1, -1};
            this.f6946f = new ArrayList();
            this.f6947g = new ArrayList();
            this.f6948h = new HashSet();
            this.f6949i = new HashSet();
            this.f6950j = new ArrayList();
            this.f6951k = new ArrayList();
            this.f6942a = list;
        }

        private void e(ArrayList arrayList, g gVar) {
            g gVar2;
            if (gVar.f6892k0) {
                return;
            }
            arrayList.add(gVar);
            gVar.f6892k0 = true;
            if (gVar.L()) {
                return;
            }
            if (gVar instanceof k) {
                k kVar = (k) gVar;
                int i2 = kVar.f6963w0;
                for (int i3 = 0; i3 < i2; i3++) {
                    e(arrayList, kVar.f6962v0[i3]);
                }
            }
            int length = gVar.f6848C.length;
            for (int i4 = 0; i4 < length; i4++) {
                f fVar = gVar.f6848C[i4].f6822d;
                if (fVar != null && (gVar2 = fVar.f6820b) != gVar.u()) {
                    e(arrayList, gVar2);
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:81:0x0041  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void f(o.g r7) {
            /*
                Method dump skipped, instructions count: 215
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: o.i.f(o$g):void");
        }

        void a(g gVar, int i2) {
            if (i2 == 0) {
                this.f6948h.add(gVar);
            } else if (i2 == 1) {
                this.f6949i.add(gVar);
            }
        }

        public List b(int i2) {
            if (i2 == 0) {
                return this.f6946f;
            }
            if (i2 == 1) {
                return this.f6947g;
            }
            return null;
        }

        Set c(int i2) {
            if (i2 == 0) {
                return this.f6948h;
            }
            if (i2 == 1) {
                return this.f6949i;
            }
            return null;
        }

        List d() {
            if (!this.f6950j.isEmpty()) {
                return this.f6950j;
            }
            int size = this.f6942a.size();
            for (int i2 = 0; i2 < size; i2++) {
                g gVar = (g) this.f6942a.get(i2);
                if (!gVar.f6888i0) {
                    e((ArrayList) this.f6950j, gVar);
                }
            }
            this.f6951k.clear();
            this.f6951k.addAll(this.f6942a);
            this.f6951k.removeAll(this.f6950j);
            return this.f6950j;
        }

        void g() {
            int size = this.f6951k.size();
            for (int i2 = 0; i2 < size; i2++) {
                f((g) this.f6951k.get(i2));
            }
        }

        i(List list, boolean z2) {
            this.f6943b = -1;
            this.f6944c = -1;
            this.f6945d = false;
            this.e = new int[]{-1, -1};
            this.f6946f = new ArrayList();
            this.f6947g = new ArrayList();
            this.f6948h = new HashSet();
            this.f6949i = new HashSet();
            this.f6950j = new ArrayList();
            this.f6951k = new ArrayList();
            this.f6942a = list;
            this.f6945d = z2;
        }
    }

    public class g {

        /* renamed from: u0 */
        public static float f6845u0 = 0.5f;

        /* renamed from: B */
        f f6847B;

        /* renamed from: C */
        protected f[] f6848C;

        /* renamed from: D */
        protected ArrayList f6849D;

        /* renamed from: E */
        protected b[] f6850E;

        /* renamed from: F */
        g f6851F;

        /* renamed from: G */
        int f6852G;

        /* renamed from: H */
        int f6853H;

        /* renamed from: I */
        protected float f6854I;

        /* renamed from: J */
        protected int f6855J;

        /* renamed from: K */
        protected int f6856K;

        /* renamed from: L */
        protected int f6857L;

        /* renamed from: M */
        int f6858M;

        /* renamed from: N */
        int f6859N;

        /* renamed from: O */
        private int f6860O;

        /* renamed from: P */
        private int f6861P;

        /* renamed from: Q */
        private int f6862Q;

        /* renamed from: R */
        private int f6863R;

        /* renamed from: S */
        protected int f6864S;

        /* renamed from: T */
        protected int f6865T;

        /* renamed from: U */
        int f6866U;

        /* renamed from: V */
        protected int f6867V;

        /* renamed from: W */
        protected int f6868W;

        /* renamed from: X */
        private int f6869X;

        /* renamed from: Y */
        private int f6870Y;

        /* renamed from: Z */
        float f6871Z;

        /* renamed from: a0 */
        float f6873a0;

        /* renamed from: b0 */
        private Object f6875b0;

        /* renamed from: c */
        C0097o f6876c;

        /* renamed from: c0 */
        private int f6877c0;

        /* renamed from: d */
        C0097o f6878d;

        /* renamed from: d0 */
        private int f6879d0;

        /* renamed from: e0 */
        private String f6880e0;

        /* renamed from: f0 */
        private String f6882f0;

        /* renamed from: g0 */
        boolean f6884g0;

        /* renamed from: h0 */
        boolean f6886h0;

        /* renamed from: i0 */
        boolean f6888i0;

        /* renamed from: j0 */
        boolean f6890j0;

        /* renamed from: k0 */
        boolean f6892k0;

        /* renamed from: l0 */
        int f6894l0;

        /* renamed from: m0 */
        int f6896m0;

        /* renamed from: n */
        boolean f6897n;

        /* renamed from: n0 */
        boolean f6898n0;
        boolean o;

        /* renamed from: o0 */
        boolean f6899o0;

        /* renamed from: p0 */
        float[] f6901p0;

        /* renamed from: q0 */
        protected g[] f6903q0;

        /* renamed from: r0 */
        protected g[] f6904r0;

        /* renamed from: s0 */
        g f6905s0;

        /* renamed from: t0 */
        g f6907t0;

        /* renamed from: a */
        public int f6872a = -1;

        /* renamed from: b */
        public int f6874b = -1;
        int e = 0;

        /* renamed from: f */
        int f6881f = 0;

        /* renamed from: g */
        int[] f6883g = new int[2];

        /* renamed from: h */
        int f6885h = 0;

        /* renamed from: i */
        int f6887i = 0;

        /* renamed from: j */
        float f6889j = 1.0f;

        /* renamed from: k */
        int f6891k = 0;

        /* renamed from: l */
        int f6893l = 0;

        /* renamed from: m */
        float f6895m = 1.0f;

        /* renamed from: p */
        int f6900p = -1;

        /* renamed from: q */
        float f6902q = 1.0f;
        i r = null;
        private int[] s = {Integer.MAX_VALUE, Integer.MAX_VALUE};

        /* renamed from: t */
        private float f6906t = 0.0f;

        /* renamed from: u */
        f f6908u = new f(this, f.d.LEFT);

        /* renamed from: v */
        f f6909v = new f(this, f.d.TOP);

        /* renamed from: w */
        f f6910w = new f(this, f.d.RIGHT);

        /* renamed from: x */
        f f6911x = new f(this, f.d.BOTTOM);

        /* renamed from: y */
        f f6912y = new f(this, f.d.BASELINE);

        /* renamed from: z */
        f f6913z = new f(this, f.d.CENTER_X);

        /* renamed from: A */
        f f6846A = new f(this, f.d.CENTER_Y);

        static /* synthetic */ class a {

            /* renamed from: a */
            static final /* synthetic */ int[] f6914a;

            /* renamed from: b */
            static final /* synthetic */ int[] f6915b;

            static {
                int[] iArr = new int[b.values().length];
                f6915b = iArr;
                try {
                    iArr[b.FIXED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    f6915b[b.WRAP_CONTENT.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    f6915b[b.MATCH_PARENT.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    f6915b[b.MATCH_CONSTRAINT.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                int[] iArr2 = new int[f.d.values().length];
                f6914a = iArr2;
                try {
                    iArr2[f.d.LEFT.ordinal()] = 1;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    f6914a[f.d.TOP.ordinal()] = 2;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    f6914a[f.d.RIGHT.ordinal()] = 3;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    f6914a[f.d.BOTTOM.ordinal()] = 4;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    f6914a[f.d.BASELINE.ordinal()] = 5;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    f6914a[f.d.CENTER.ordinal()] = 6;
                } catch (NoSuchFieldError unused10) {
                }
                try {
                    f6914a[f.d.CENTER_X.ordinal()] = 7;
                } catch (NoSuchFieldError unused11) {
                }
                try {
                    f6914a[f.d.CENTER_Y.ordinal()] = 8;
                } catch (NoSuchFieldError unused12) {
                }
                try {
                    f6914a[f.d.NONE.ordinal()] = 9;
                } catch (NoSuchFieldError unused13) {
                }
            }
        }

        public enum b {
            FIXED,
            WRAP_CONTENT,
            MATCH_CONSTRAINT,
            MATCH_PARENT
        }

        public g() {
            f fVar = new f(this, f.d.CENTER);
            this.f6847B = fVar;
            this.f6848C = new f[]{this.f6908u, this.f6910w, this.f6909v, this.f6911x, this.f6912y, fVar};
            this.f6849D = new ArrayList();
            b bVar = b.FIXED;
            this.f6850E = new b[]{bVar, bVar};
            this.f6851F = null;
            this.f6852G = 0;
            this.f6853H = 0;
            this.f6854I = 0.0f;
            this.f6855J = -1;
            this.f6856K = 0;
            this.f6857L = 0;
            this.f6858M = 0;
            this.f6859N = 0;
            this.f6860O = 0;
            this.f6861P = 0;
            this.f6862Q = 0;
            this.f6863R = 0;
            this.f6864S = 0;
            this.f6865T = 0;
            this.f6866U = 0;
            float f2 = f6845u0;
            this.f6871Z = f2;
            this.f6873a0 = f2;
            this.f6877c0 = 0;
            this.f6879d0 = 0;
            this.f6880e0 = null;
            this.f6882f0 = null;
            this.f6888i0 = false;
            this.f6890j0 = false;
            this.f6892k0 = false;
            this.f6894l0 = 0;
            this.f6896m0 = 0;
            this.f6901p0 = new float[]{-1.0f, -1.0f};
            this.f6903q0 = new g[]{null, null};
            this.f6904r0 = new g[]{null, null};
            this.f6905s0 = null;
            this.f6907t0 = null;
            a();
        }

        private boolean K(int i2) {
            f fVar;
            f fVar2;
            int i3 = i2 * 2;
            f[] fVarArr = this.f6848C;
            f fVar3 = fVarArr[i3];
            f fVar4 = fVar3.f6822d;
            return (fVar4 == null || fVar4.f6822d == fVar3 || (fVar2 = (fVar = fVarArr[i3 + 1]).f6822d) == null || fVar2.f6822d != fVar) ? false : true;
        }

        private void a() {
            this.f6849D.add(this.f6908u);
            this.f6849D.add(this.f6909v);
            this.f6849D.add(this.f6910w);
            this.f6849D.add(this.f6911x);
            this.f6849D.add(this.f6913z);
            this.f6849D.add(this.f6846A);
            this.f6849D.add(this.f6847B);
            this.f6849D.add(this.f6912y);
        }

        /* JADX WARN: Removed duplicated region for block: B:280:0x01aa A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:286:0x01bf  */
        /* JADX WARN: Removed duplicated region for block: B:346:0x0279  */
        /* JADX WARN: Removed duplicated region for block: B:353:0x02bd  */
        /* JADX WARN: Removed duplicated region for block: B:356:0x02cc  */
        /* JADX WARN: Removed duplicated region for block: B:358:0x02d0 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:359:0x02d2 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:362:0x02dd A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:363:0x02df A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:367:0x02ed  */
        /* JADX WARN: Removed duplicated region for block: B:369:0x02f2  */
        /* JADX WARN: Removed duplicated region for block: B:377:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void e(n.e r26, boolean r27, n.i r28, n.i r29, o.g.b r30, boolean r31, o.f r32, o.f r33, int r34, int r35, int r36, int r37, float r38, boolean r39, boolean r40, int r41, int r42, int r43, float r44, boolean r45) {
            /*
                Method dump skipped, instructions count: 772
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: o.g.e(n.e, boolean, n.i, n.i, o$g$b, boolean, o$f, o$f, int, int, int, int, float, boolean, boolean, int, int, int, float, boolean):void");
        }

        protected int A() {
            return this.f6857L + this.f6865T;
        }

        public void A0(int i2) {
            this.f6870Y = i2;
        }

        public b B() {
            return this.f6850E[1];
        }

        public void B0(int i2) {
            this.f6869X = i2;
        }

        public int C() {
            return this.f6879d0;
        }

        public void C0(int i2) {
            this.f6856K = i2;
        }

        public int D() {
            if (this.f6879d0 == 8) {
                return 0;
            }
            return this.f6852G;
        }

        public void D0(int i2) {
            this.f6857L = i2;
        }

        public int E() {
            return this.f6870Y;
        }

        public void E0(boolean z2, boolean z3, boolean z4, boolean z5) {
            if (this.f6900p == -1) {
                if (z4 && !z5) {
                    this.f6900p = 0;
                } else if (!z4 && z5) {
                    this.f6900p = 1;
                    if (this.f6855J == -1) {
                        this.f6902q = 1.0f / this.f6902q;
                    }
                }
            }
            if (this.f6900p == 0 && (!this.f6909v.k() || !this.f6911x.k())) {
                this.f6900p = 1;
            } else if (this.f6900p == 1 && (!this.f6908u.k() || !this.f6910w.k())) {
                this.f6900p = 0;
            }
            if (this.f6900p == -1 && (!this.f6909v.k() || !this.f6911x.k() || !this.f6908u.k() || !this.f6910w.k())) {
                if (this.f6909v.k() && this.f6911x.k()) {
                    this.f6900p = 0;
                } else if (this.f6908u.k() && this.f6910w.k()) {
                    this.f6902q = 1.0f / this.f6902q;
                    this.f6900p = 1;
                }
            }
            if (this.f6900p == -1) {
                if (z2 && !z3) {
                    this.f6900p = 0;
                } else if (!z2 && z3) {
                    this.f6902q = 1.0f / this.f6902q;
                    this.f6900p = 1;
                }
            }
            if (this.f6900p == -1) {
                int i2 = this.f6885h;
                if (i2 > 0 && this.f6891k == 0) {
                    this.f6900p = 0;
                } else if (i2 == 0 && this.f6891k > 0) {
                    this.f6902q = 1.0f / this.f6902q;
                    this.f6900p = 1;
                }
            }
            if (this.f6900p == -1 && z2 && z3) {
                this.f6902q = 1.0f / this.f6902q;
                this.f6900p = 1;
            }
        }

        public int F() {
            return this.f6869X;
        }

        public void F0() {
            int i2 = this.f6856K;
            int i3 = this.f6857L;
            int i4 = this.f6852G + i2;
            int i5 = this.f6853H + i3;
            this.f6860O = i2;
            this.f6861P = i3;
            this.f6862Q = i4 - i2;
            this.f6863R = i5 - i3;
        }

        public int G() {
            return this.f6856K;
        }

        public void G0(n.e eVar) {
            int iY = eVar.y(this.f6908u);
            int iY2 = eVar.y(this.f6909v);
            int iY3 = eVar.y(this.f6910w);
            int iY4 = eVar.y(this.f6911x);
            int i2 = iY4 - iY2;
            if (iY3 - iY < 0 || i2 < 0 || iY == Integer.MIN_VALUE || iY == Integer.MAX_VALUE || iY2 == Integer.MIN_VALUE || iY2 == Integer.MAX_VALUE || iY3 == Integer.MIN_VALUE || iY3 == Integer.MAX_VALUE || iY4 == Integer.MIN_VALUE || iY4 == Integer.MAX_VALUE) {
                iY = 0;
                iY4 = 0;
                iY2 = 0;
                iY3 = 0;
            }
            a0(iY, iY2, iY3, iY4);
        }

        public int H() {
            return this.f6857L;
        }

        public void H0() {
            for (int i2 = 0; i2 < 6; i2++) {
                this.f6848C[i2].f().q();
            }
        }

        public boolean I() {
            return this.f6866U > 0;
        }

        public void J(f.d dVar, g gVar, f.d dVar2, int i2, int i3) {
            h(dVar).a(gVar.h(dVar2), i2, i3, f.c.STRONG, 0, true);
        }

        public boolean L() {
            return this.f6908u.f().f6978b == 1 && this.f6910w.f().f6978b == 1 && this.f6909v.f().f6978b == 1 && this.f6911x.f().f6978b == 1;
        }

        public boolean M() {
            f fVar = this.f6908u;
            f fVar2 = fVar.f6822d;
            if (fVar2 != null && fVar2.f6822d == fVar) {
                return true;
            }
            f fVar3 = this.f6910w;
            f fVar4 = fVar3.f6822d;
            return fVar4 != null && fVar4.f6822d == fVar3;
        }

        public boolean N() {
            f fVar = this.f6909v;
            f fVar2 = fVar.f6822d;
            if (fVar2 != null && fVar2.f6822d == fVar) {
                return true;
            }
            f fVar3 = this.f6911x;
            f fVar4 = fVar3.f6822d;
            return fVar4 != null && fVar4.f6822d == fVar3;
        }

        public boolean O() {
            return this.f6881f == 0 && this.f6854I == 0.0f && this.f6891k == 0 && this.f6893l == 0 && this.f6850E[1] == b.MATCH_CONSTRAINT;
        }

        public boolean P() {
            return this.e == 0 && this.f6854I == 0.0f && this.f6885h == 0 && this.f6887i == 0 && this.f6850E[0] == b.MATCH_CONSTRAINT;
        }

        public void Q() {
            this.f6908u.m();
            this.f6909v.m();
            this.f6910w.m();
            this.f6911x.m();
            this.f6912y.m();
            this.f6913z.m();
            this.f6846A.m();
            this.f6847B.m();
            this.f6851F = null;
            this.f6906t = 0.0f;
            this.f6852G = 0;
            this.f6853H = 0;
            this.f6854I = 0.0f;
            this.f6855J = -1;
            this.f6856K = 0;
            this.f6857L = 0;
            this.f6860O = 0;
            this.f6861P = 0;
            this.f6862Q = 0;
            this.f6863R = 0;
            this.f6864S = 0;
            this.f6865T = 0;
            this.f6866U = 0;
            this.f6867V = 0;
            this.f6868W = 0;
            this.f6869X = 0;
            this.f6870Y = 0;
            float f2 = f6845u0;
            this.f6871Z = f2;
            this.f6873a0 = f2;
            b[] bVarArr = this.f6850E;
            b bVar = b.FIXED;
            bVarArr[0] = bVar;
            bVarArr[1] = bVar;
            this.f6875b0 = null;
            this.f6877c0 = 0;
            this.f6879d0 = 0;
            this.f6882f0 = null;
            this.f6884g0 = false;
            this.f6886h0 = false;
            this.f6894l0 = 0;
            this.f6896m0 = 0;
            this.f6898n0 = false;
            this.f6899o0 = false;
            float[] fArr = this.f6901p0;
            fArr[0] = -1.0f;
            fArr[1] = -1.0f;
            this.f6872a = -1;
            this.f6874b = -1;
            int[] iArr = this.s;
            iArr[0] = Integer.MAX_VALUE;
            iArr[1] = Integer.MAX_VALUE;
            this.e = 0;
            this.f6881f = 0;
            this.f6889j = 1.0f;
            this.f6895m = 1.0f;
            this.f6887i = Integer.MAX_VALUE;
            this.f6893l = Integer.MAX_VALUE;
            this.f6885h = 0;
            this.f6891k = 0;
            this.f6900p = -1;
            this.f6902q = 1.0f;
            C0097o c0097o = this.f6876c;
            if (c0097o != null) {
                c0097o.e();
            }
            C0097o c0097o2 = this.f6878d;
            if (c0097o2 != null) {
                c0097o2.e();
            }
            this.r = null;
            this.f6888i0 = false;
            this.f6890j0 = false;
            this.f6892k0 = false;
        }

        public void R() {
            g gVarU = u();
            if (gVarU != null && (gVarU instanceof h) && ((h) u()).S0()) {
                return;
            }
            int size = this.f6849D.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((f) this.f6849D.get(i2)).m();
            }
        }

        public void S() {
            for (int i2 = 0; i2 < 6; i2++) {
                this.f6848C[i2].f().e();
            }
        }

        public void T(C0295c c0295c) {
            this.f6908u.n(c0295c);
            this.f6909v.n(c0295c);
            this.f6910w.n(c0295c);
            this.f6911x.n(c0295c);
            this.f6912y.n(c0295c);
            this.f6847B.n(c0295c);
            this.f6913z.n(c0295c);
            this.f6846A.n(c0295c);
        }

        public void V(int i2) {
            this.f6866U = i2;
        }

        public void W(Object obj) {
            this.f6875b0 = obj;
        }

        public void X(String str) {
            this.f6880e0 = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:90:0x0087 A[PHI: r0
  0x0087: PHI (r0v2 int) = (r0v1 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int) binds: [B:89:0x0086, B:86:0x007f, B:74:0x0051, B:76:0x0057, B:78:0x0063, B:80:0x0067] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x0087 -> B:91:0x0088). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void Y(java.lang.String r9) throws java.lang.NumberFormatException {
            /*
                r8 = this;
                r0 = 0
                if (r9 == 0) goto L91
                int r1 = r9.length()
                if (r1 != 0) goto Lb
                goto L91
            Lb:
                int r1 = r9.length()
                r2 = 44
                int r2 = r9.indexOf(r2)
                r3 = 0
                r4 = 1
                r5 = -1
                if (r2 <= 0) goto L39
                int r6 = r1 + (-1)
                if (r2 >= r6) goto L39
                java.lang.String r6 = r9.substring(r3, r2)
                java.lang.String r7 = "W"
                boolean r7 = r6.equalsIgnoreCase(r7)
                if (r7 == 0) goto L2b
                goto L36
            L2b:
                java.lang.String r3 = "H"
                boolean r3 = r6.equalsIgnoreCase(r3)
                if (r3 == 0) goto L35
                r3 = 1
                goto L36
            L35:
                r3 = -1
            L36:
                int r2 = r2 + r4
                r5 = r3
                r3 = r2
            L39:
                r2 = 58
                int r2 = r9.indexOf(r2)
                if (r2 < 0) goto L77
                int r1 = r1 - r4
                if (r2 >= r1) goto L77
                java.lang.String r1 = r9.substring(r3, r2)
                int r2 = r2 + r4
                java.lang.String r9 = r9.substring(r2)
                int r2 = r1.length()
                if (r2 <= 0) goto L87
                int r2 = r9.length()
                if (r2 <= 0) goto L87
                float r1 = java.lang.Float.parseFloat(r1)     // Catch: java.lang.NumberFormatException -> L86
                float r9 = java.lang.Float.parseFloat(r9)     // Catch: java.lang.NumberFormatException -> L86
                int r2 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
                if (r2 <= 0) goto L87
                int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r2 <= 0) goto L87
                if (r5 != r4) goto L71
                float r9 = r9 / r1
                float r9 = java.lang.Math.abs(r9)     // Catch: java.lang.NumberFormatException -> L86
                goto L88
            L71:
                float r1 = r1 / r9
                float r9 = java.lang.Math.abs(r1)     // Catch: java.lang.NumberFormatException -> L86
                goto L88
            L77:
                java.lang.String r9 = r9.substring(r3)
                int r1 = r9.length()
                if (r1 <= 0) goto L87
                float r9 = java.lang.Float.parseFloat(r9)     // Catch: java.lang.NumberFormatException -> L86
                goto L88
            L86:
            L87:
                r9 = 0
            L88:
                int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r0 <= 0) goto L90
                r8.f6854I = r9
                r8.f6855J = r5
            L90:
                return
            L91:
                r8.f6854I = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: o.g.Y(java.lang.String):void");
        }

        public void Z(int i2, int i3, int i4) {
            if (i4 == 0) {
                f0(i2, i3);
            } else if (i4 == 1) {
                t0(i2, i3);
            }
            this.f6890j0 = true;
        }

        public void a0(int i2, int i3, int i4, int i5) {
            int i6;
            int i7;
            int i8 = i4 - i2;
            int i9 = i5 - i3;
            this.f6856K = i2;
            this.f6857L = i3;
            if (this.f6879d0 == 8) {
                this.f6852G = 0;
                this.f6853H = 0;
                return;
            }
            b[] bVarArr = this.f6850E;
            b bVar = bVarArr[0];
            b bVar2 = b.FIXED;
            if (bVar == bVar2 && i8 < (i7 = this.f6852G)) {
                i8 = i7;
            }
            if (bVarArr[1] == bVar2 && i9 < (i6 = this.f6853H)) {
                i9 = i6;
            }
            this.f6852G = i8;
            this.f6853H = i9;
            int i10 = this.f6868W;
            if (i9 < i10) {
                this.f6853H = i10;
            }
            int i11 = this.f6867V;
            if (i8 < i11) {
                this.f6852G = i11;
            }
            this.f6890j0 = true;
        }

        /* JADX WARN: Removed duplicated region for block: B:317:0x027f  */
        /* JADX WARN: Removed duplicated region for block: B:318:0x0288  */
        /* JADX WARN: Removed duplicated region for block: B:321:0x028e  */
        /* JADX WARN: Removed duplicated region for block: B:322:0x0296  */
        /* JADX WARN: Removed duplicated region for block: B:325:0x02cf  */
        /* JADX WARN: Removed duplicated region for block: B:331:0x02fc  */
        /* JADX WARN: Removed duplicated region for block: B:333:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void b(n.e r42) {
            /*
                Method dump skipped, instructions count: 797
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: o.g.b(n.e):void");
        }

        public void b0(int i2) {
            this.f6853H = i2;
            int i3 = this.f6868W;
            if (i2 < i3) {
                this.f6853H = i3;
            }
        }

        public boolean c() {
            return this.f6879d0 != 8;
        }

        public void c0(boolean z2) {
            this.o = z2;
        }

        public void d(int i2) {
            l.a(i2, this);
        }

        public void d0(float f2) {
            this.f6871Z = f2;
        }

        public void e0(int i2) {
            this.f6894l0 = i2;
        }

        public void f(g gVar, float f2, int i2) {
            f.d dVar = f.d.CENTER;
            J(dVar, gVar, dVar, i2, 0);
            this.f6906t = f2;
        }

        public void f0(int i2, int i3) {
            this.f6856K = i2;
            int i4 = i3 - i2;
            this.f6852G = i4;
            int i5 = this.f6867V;
            if (i4 < i5) {
                this.f6852G = i5;
            }
        }

        public void g(n.e eVar) {
            eVar.r(this.f6908u);
            eVar.r(this.f6909v);
            eVar.r(this.f6910w);
            eVar.r(this.f6911x);
            if (this.f6866U > 0) {
                eVar.r(this.f6912y);
            }
        }

        public void g0(b bVar) {
            this.f6850E[0] = bVar;
            if (bVar == b.WRAP_CONTENT) {
                y0(this.f6869X);
            }
        }

        public f h(f.d dVar) {
            switch (a.f6914a[dVar.ordinal()]) {
                case 1:
                    return this.f6908u;
                case 2:
                    return this.f6909v;
                case 3:
                    return this.f6910w;
                case 4:
                    return this.f6911x;
                case 5:
                    return this.f6912y;
                case 6:
                    return this.f6847B;
                case 7:
                    return this.f6913z;
                case 8:
                    return this.f6846A;
                case 9:
                    return null;
                default:
                    throw new AssertionError(dVar.name());
            }
        }

        public void h0(int i2, int i3, int i4, float f2) {
            this.e = i2;
            this.f6885h = i3;
            this.f6887i = i4;
            this.f6889j = f2;
            if (f2 >= 1.0f || i2 != 0) {
                return;
            }
            this.e = 2;
        }

        public ArrayList i() {
            return this.f6849D;
        }

        public void i0(float f2) {
            this.f6901p0[0] = f2;
        }

        public int j() {
            return this.f6866U;
        }

        public void j0(int i2) {
            this.s[1] = i2;
        }

        public float k(int i2) {
            if (i2 == 0) {
                return this.f6871Z;
            }
            if (i2 == 1) {
                return this.f6873a0;
            }
            return -1.0f;
        }

        public void k0(int i2) {
            this.s[0] = i2;
        }

        public int l() {
            return H() + this.f6853H;
        }

        public void l0(int i2) {
            if (i2 < 0) {
                this.f6868W = 0;
            } else {
                this.f6868W = i2;
            }
        }

        public Object m() {
            return this.f6875b0;
        }

        public void m0(int i2) {
            if (i2 < 0) {
                this.f6867V = 0;
            } else {
                this.f6867V = i2;
            }
        }

        public String n() {
            return this.f6880e0;
        }

        public void n0(int i2, int i3) {
            this.f6864S = i2;
            this.f6865T = i3;
        }

        public b o(int i2) {
            if (i2 == 0) {
                return s();
            }
            if (i2 == 1) {
                return B();
            }
            return null;
        }

        public void o0(int i2, int i3) {
            this.f6856K = i2;
            this.f6857L = i3;
        }

        public int p() {
            return this.f6860O + this.f6864S;
        }

        public void p0(g gVar) {
            this.f6851F = gVar;
        }

        public int q() {
            return this.f6861P + this.f6865T;
        }

        void q0(int i2, int i3) {
            if (i3 == 0) {
                this.f6858M = i2;
            } else if (i3 == 1) {
                this.f6859N = i2;
            }
        }

        public int r() {
            if (this.f6879d0 == 8) {
                return 0;
            }
            return this.f6853H;
        }

        public void r0(float f2) {
            this.f6873a0 = f2;
        }

        public b s() {
            return this.f6850E[0];
        }

        public void s0(int i2) {
            this.f6896m0 = i2;
        }

        public int t(int i2) {
            if (i2 == 0) {
                return D();
            }
            if (i2 == 1) {
                return r();
            }
            return 0;
        }

        public void t0(int i2, int i3) {
            this.f6857L = i2;
            int i4 = i3 - i2;
            this.f6853H = i4;
            int i5 = this.f6868W;
            if (i4 < i5) {
                this.f6853H = i5;
            }
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            String str2 = "";
            if (this.f6882f0 != null) {
                str = "type: " + this.f6882f0 + " ";
            } else {
                str = "";
            }
            sb.append(str);
            if (this.f6880e0 != null) {
                str2 = "id: " + this.f6880e0 + " ";
            }
            sb.append(str2);
            sb.append("(");
            sb.append(this.f6856K);
            sb.append(", ");
            sb.append(this.f6857L);
            sb.append(") - (");
            sb.append(this.f6852G);
            sb.append(" x ");
            sb.append(this.f6853H);
            sb.append(") wrap: (");
            sb.append(this.f6869X);
            sb.append(" x ");
            sb.append(this.f6870Y);
            sb.append(")");
            return sb.toString();
        }

        public g u() {
            return this.f6851F;
        }

        public void u0(b bVar) {
            this.f6850E[1] = bVar;
            if (bVar == b.WRAP_CONTENT) {
                b0(this.f6870Y);
            }
        }

        int v(int i2) {
            if (i2 == 0) {
                return this.f6858M;
            }
            if (i2 == 1) {
                return this.f6859N;
            }
            return 0;
        }

        public void v0(int i2, int i3, int i4, float f2) {
            this.f6881f = i2;
            this.f6891k = i3;
            this.f6893l = i4;
            this.f6895m = f2;
            if (f2 >= 1.0f || i2 != 0) {
                return;
            }
            this.f6881f = 2;
        }

        public C0097o w() {
            if (this.f6878d == null) {
                this.f6878d = new C0097o();
            }
            return this.f6878d;
        }

        public void w0(float f2) {
            this.f6901p0[1] = f2;
        }

        public C0097o x() {
            if (this.f6876c == null) {
                this.f6876c = new C0097o();
            }
            return this.f6876c;
        }

        public void x0(int i2) {
            this.f6879d0 = i2;
        }

        public int y() {
            return G() + this.f6852G;
        }

        public void y0(int i2) {
            this.f6852G = i2;
            int i3 = this.f6867V;
            if (i2 < i3) {
                this.f6852G = i3;
            }
        }

        protected int z() {
            return this.f6856K + this.f6864S;
        }

        public void z0(boolean z2) {
            this.f6897n = z2;
        }

        public void U() {
        }
    }

    public abstract class p {

        /* renamed from: a */
        HashSet f6977a = new HashSet(2);

        /* renamed from: b */
        int f6978b = 0;

        public void a(p pVar) {
            this.f6977a.add(pVar);
        }

        public void b() {
            this.f6978b = 1;
            Iterator it = this.f6977a.iterator();
            while (it.hasNext()) {
                ((p) it.next()).f();
            }
        }

        public void c() {
            this.f6978b = 0;
            Iterator it = this.f6977a.iterator();
            while (it.hasNext()) {
                ((p) it.next()).c();
            }
        }

        public boolean d() {
            return this.f6978b == 1;
        }

        public void e() {
            this.f6978b = 0;
            this.f6977a.clear();
        }

        public void f() {
        }
    }
}
