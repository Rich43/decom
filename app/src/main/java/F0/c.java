package F0;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final a f197a;

    public c(a aVar) {
        this.f197a = aVar;
    }

    private int[] b(b bVar) throws d {
        int iD = bVar.d();
        if (iD == 1) {
            return new int[]{bVar.c(1)};
        }
        int[] iArr = new int[iD];
        int i2 = 0;
        for (int i3 = 1; i3 < this.f197a.f() && i2 < iD; i3++) {
            if (bVar.b(i3) == 0) {
                iArr[i2] = this.f197a.h(i3);
                i2++;
            }
        }
        if (i2 == iD) {
            return iArr;
        }
        throw new d("Error locator degree does not match number of roots");
    }

    private int[] c(b bVar, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            int iH = this.f197a.h(iArr[i2]);
            int iJ = 1;
            for (int i3 = 0; i3 < length; i3++) {
                if (i2 != i3) {
                    int iJ2 = this.f197a.j(iArr[i3], iH);
                    iJ = this.f197a.j(iJ, (iJ2 & 1) == 0 ? iJ2 | 1 : iJ2 & (-2));
                }
            }
            iArr2[i2] = this.f197a.j(bVar.b(iH), this.f197a.h(iJ));
            if (this.f197a.d() != 0) {
                iArr2[i2] = this.f197a.j(iArr2[i2], iH);
            }
        }
        return iArr2;
    }

    private b[] d(b bVar, b bVar2, int i2) throws d {
        if (bVar.d() < bVar2.d()) {
            bVar2 = bVar;
            bVar = bVar2;
        }
        b bVarG = this.f197a.g();
        b bVarE = this.f197a.e();
        do {
            b bVar3 = bVar2;
            bVar2 = bVar;
            bVar = bVar3;
            b bVar4 = bVarE;
            b bVar5 = bVarG;
            bVarG = bVar4;
            if (bVar.d() < i2 / 2) {
                int iC = bVarG.c(0);
                if (iC == 0) {
                    throw new d("sigmaTilde(0) was zero");
                }
                int iH = this.f197a.h(iC);
                return new b[]{bVarG.f(iH), bVar.f(iH)};
            }
            if (bVar.e()) {
                throw new d("r_{i-1} was zero");
            }
            b bVarG2 = this.f197a.g();
            int iH2 = this.f197a.h(bVar.c(bVar.d()));
            while (bVar2.d() >= bVar.d() && !bVar2.e()) {
                int iD = bVar2.d() - bVar.d();
                int iJ = this.f197a.j(bVar2.c(bVar2.d()), iH2);
                bVarG2 = bVarG2.a(this.f197a.b(iD, iJ));
                bVar2 = bVar2.a(bVar.h(iD, iJ));
            }
            bVarE = bVarG2.g(bVarG).a(bVar5);
        } while (bVar2.d() < bVar.d());
        throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
    }

    public void a(int[] iArr, int i2) throws d {
        b bVar = new b(this.f197a, iArr);
        int[] iArr2 = new int[i2];
        boolean z2 = true;
        for (int i3 = 0; i3 < i2; i3++) {
            a aVar = this.f197a;
            int iB = bVar.b(aVar.c(aVar.d() + i3));
            iArr2[(i2 - 1) - i3] = iB;
            if (iB != 0) {
                z2 = false;
            }
        }
        if (z2) {
            return;
        }
        b[] bVarArrD = d(this.f197a.b(i2, 1), new b(this.f197a, iArr2), i2);
        b bVar2 = bVarArrD[0];
        b bVar3 = bVarArrD[1];
        int[] iArrB = b(bVar2);
        int[] iArrC = c(bVar3, iArrB);
        for (int i4 = 0; i4 < iArrB.length; i4++) {
            int length = (iArr.length - 1) - this.f197a.i(iArrB[i4]);
            if (length < 0) {
                throw new d("Bad error location");
            }
            iArr[length] = a.a(iArr[length], iArrC[i4]);
        }
    }
}
