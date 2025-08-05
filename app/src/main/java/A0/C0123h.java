package a0;

import V.b;
import b0.c;

/* renamed from: a0.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0123h implements J {

    /* renamed from: a, reason: collision with root package name */
    public static final C0123h f1404a = new C0123h();

    /* renamed from: b, reason: collision with root package name */
    private static final c.a f1405b = c.a.a("t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of");

    private C0123h() {
    }

    @Override // a0.J
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public V.b a(b0.c cVar, float f2) {
        b.a aVar = b.a.CENTER;
        cVar.l();
        b.a aVar2 = aVar;
        String strU = null;
        String strU2 = null;
        double dR = 0.0d;
        double dR2 = 0.0d;
        double dR3 = 0.0d;
        double dR4 = 0.0d;
        int iS = 0;
        int iD = 0;
        int iD2 = 0;
        boolean zQ = true;
        while (cVar.p()) {
            switch (cVar.y(f1405b)) {
                case 0:
                    strU = cVar.u();
                    break;
                case 1:
                    strU2 = cVar.u();
                    break;
                case 2:
                    dR = cVar.r();
                    break;
                case 3:
                    int iS2 = cVar.s();
                    aVar2 = b.a.CENTER;
                    if (iS2 <= aVar2.ordinal() && iS2 >= 0) {
                        aVar2 = b.a.values()[iS2];
                        break;
                    } else {
                        break;
                    }
                    break;
                case 4:
                    iS = cVar.s();
                    break;
                case 5:
                    dR2 = cVar.r();
                    break;
                case 6:
                    dR3 = cVar.r();
                    break;
                case 7:
                    iD = p.d(cVar);
                    break;
                case 8:
                    iD2 = p.d(cVar);
                    break;
                case 9:
                    dR4 = cVar.r();
                    break;
                case 10:
                    zQ = cVar.q();
                    break;
                default:
                    cVar.z();
                    cVar.A();
                    break;
            }
        }
        cVar.n();
        return new V.b(strU, strU2, dR, aVar2, iS, dR2, dR3, iD, iD2, dR4, zQ);
    }
}
