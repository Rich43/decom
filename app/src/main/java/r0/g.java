package r0;

import java.io.IOException;

/* loaded from: classes.dex */
public class g extends h implements Comparable {

    /* renamed from: b, reason: collision with root package name */
    private int f7357b;

    /* renamed from: c, reason: collision with root package name */
    private long f7358c;

    /* renamed from: d, reason: collision with root package name */
    private double f7359d;
    private boolean e;

    public g(long j2) {
        this.f7358c = j2;
        this.f7359d = j2;
        this.f7357b = 0;
    }

    @Override // r0.h
    void b(C0323b c0323b) throws IOException {
        int iM = m();
        if (iM != 0) {
            if (iM == 1) {
                c0323b.f(35);
                c0323b.k(k());
                return;
            } else {
                if (iM != 2) {
                    return;
                }
                c0323b.f(j() ? 9 : 8);
                return;
            }
        }
        if (l() < 0) {
            c0323b.f(19);
            c0323b.j(l(), 8);
            return;
        }
        if (l() <= 255) {
            c0323b.f(16);
            c0323b.j(l(), 1);
        } else if (l() <= 65535) {
            c0323b.f(17);
            c0323b.j(l(), 2);
        } else if (l() <= 4294967295L) {
            c0323b.f(18);
            c0323b.j(l(), 4);
        } else {
            c0323b.f(19);
            c0323b.j(l(), 8);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        double dK = k();
        if (obj instanceof g) {
            double dK2 = ((g) obj).k();
            if (dK < dK2) {
                return -1;
            }
            return dK == dK2 ? 0 : 1;
        }
        if (!(obj instanceof Number)) {
            return -1;
        }
        double dDoubleValue = ((Number) obj).doubleValue();
        if (dK < dDoubleValue) {
            return -1;
        }
        return dK == dDoubleValue ? 0 : 1;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f7357b == gVar.f7357b && this.f7358c == gVar.f7358c && this.f7359d == gVar.f7359d && this.e == gVar.e;
    }

    public int hashCode() {
        int i2 = this.f7357b * 37;
        long j2 = this.f7358c;
        return ((((i2 + ((int) (j2 ^ (j2 >>> 32)))) * 37) + ((int) (Double.doubleToLongBits(this.f7359d) ^ (Double.doubleToLongBits(this.f7359d) >>> 32)))) * 37) + (j() ? 1 : 0);
    }

    public boolean j() {
        return this.f7357b == 2 ? this.e : this.f7358c != 0;
    }

    public double k() {
        return this.f7359d;
    }

    public long l() {
        return this.f7358c;
    }

    public int m() {
        return this.f7357b;
    }

    public String toString() {
        int i2 = this.f7357b;
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? super.toString() : String.valueOf(j()) : String.valueOf(k()) : String.valueOf(l());
    }

    public g(double d2) {
        this.f7359d = d2;
        this.f7358c = (long) d2;
        this.f7357b = 1;
    }

    public g(boolean z2) {
        this.e = z2;
        long j2 = z2 ? 1L : 0L;
        this.f7358c = j2;
        this.f7359d = j2;
        this.f7357b = 2;
    }
}
