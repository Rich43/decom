package V;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a */
    public final String f950a;

    /* renamed from: b */
    public final String f951b;

    /* renamed from: c */
    public final double f952c;

    /* renamed from: d */
    public final a f953d;
    public final int e;

    /* renamed from: f */
    public final double f954f;

    /* renamed from: g */
    public final double f955g;

    /* renamed from: h */
    public final int f956h;

    /* renamed from: i */
    public final int f957i;

    /* renamed from: j */
    public final double f958j;

    /* renamed from: k */
    public final boolean f959k;

    public enum a {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public b(String str, String str2, double d2, a aVar, int i2, double d3, double d4, int i3, int i4, double d5, boolean z2) {
        this.f950a = str;
        this.f951b = str2;
        this.f952c = d2;
        this.f953d = aVar;
        this.e = i2;
        this.f954f = d3;
        this.f955g = d4;
        this.f956h = i3;
        this.f957i = i4;
        this.f958j = d5;
        this.f959k = z2;
    }

    public int hashCode() {
        int iHashCode = (((((int) ((((this.f950a.hashCode() * 31) + this.f951b.hashCode()) * 31) + this.f952c)) * 31) + this.f953d.ordinal()) * 31) + this.e;
        long jDoubleToLongBits = Double.doubleToLongBits(this.f954f);
        return (((iHashCode * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)))) * 31) + this.f956h;
    }
}
