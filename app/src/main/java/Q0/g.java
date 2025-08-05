package Q0;

import java.util.Formatter;

/* loaded from: classes.dex */
class g {

    /* renamed from: a, reason: collision with root package name */
    private final c f715a;

    /* renamed from: b, reason: collision with root package name */
    private final d[] f716b;

    g(c cVar) {
        this.f715a = new c(cVar);
        this.f716b = new d[(cVar.e() - cVar.g()) + 1];
    }

    final c a() {
        return this.f715a;
    }

    final d b(int i2) {
        return this.f716b[e(i2)];
    }

    final d c(int i2) {
        d dVar;
        d dVar2;
        d dVarB = b(i2);
        if (dVarB != null) {
            return dVarB;
        }
        for (int i3 = 1; i3 < 5; i3++) {
            int iE = e(i2) - i3;
            if (iE >= 0 && (dVar2 = this.f716b[iE]) != null) {
                return dVar2;
            }
            int iE2 = e(i2) + i3;
            d[] dVarArr = this.f716b;
            if (iE2 < dVarArr.length && (dVar = dVarArr[iE2]) != null) {
                return dVar;
            }
        }
        return null;
    }

    final d[] d() {
        return this.f716b;
    }

    final int e(int i2) {
        return i2 - this.f715a.g();
    }

    final void f(int i2, d dVar) {
        this.f716b[e(i2)] = dVar;
    }

    public String toString() {
        Formatter formatter = new Formatter();
        try {
            int i2 = 0;
            for (d dVar : this.f716b) {
                if (dVar == null) {
                    formatter.format("%3d:    |   %n", Integer.valueOf(i2));
                    i2++;
                } else {
                    formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i2), Integer.valueOf(dVar.c()), Integer.valueOf(dVar.e()));
                    i2++;
                }
            }
            String string = formatter.toString();
            formatter.close();
            return string;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    formatter.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }
}
