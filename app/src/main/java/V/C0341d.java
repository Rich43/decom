package v;

/* renamed from: v.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0341d {

    /* renamed from: a, reason: collision with root package name */
    public final Object f7671a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f7672b;

    public C0341d(Object obj, Object obj2) {
        this.f7671a = obj;
        this.f7672b = obj2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0341d)) {
            return false;
        }
        C0341d c0341d = (C0341d) obj;
        return AbstractC0340c.a(c0341d.f7671a, this.f7671a) && AbstractC0340c.a(c0341d.f7672b, this.f7672b);
    }

    public int hashCode() {
        Object obj = this.f7671a;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.f7672b;
        return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.f7671a + " " + this.f7672b + "}";
    }
}
