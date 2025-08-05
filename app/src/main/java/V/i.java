package V;

import v.C0341d;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    Object f981a;

    /* renamed from: b, reason: collision with root package name */
    Object f982b;

    private static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public void b(Object obj, Object obj2) {
        this.f981a = obj;
        this.f982b = obj2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0341d)) {
            return false;
        }
        C0341d c0341d = (C0341d) obj;
        return a(c0341d.f7671a, this.f981a) && a(c0341d.f7672b, this.f982b);
    }

    public int hashCode() {
        Object obj = this.f981a;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.f982b;
        return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f981a) + " " + String.valueOf(this.f982b) + "}";
    }
}
