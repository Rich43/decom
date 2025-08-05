package a1;

import i1.k;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class e implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private final Object f1434a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f1435b;

    public e(Object obj, Object obj2) {
        this.f1434a = obj;
        this.f1435b = obj2;
    }

    public final Object a() {
        return this.f1434a;
    }

    public final Object b() {
        return this.f1435b;
    }

    public final Object c() {
        return this.f1434a;
    }

    public final Object d() {
        return this.f1435b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return k.a(this.f1434a, eVar.f1434a) && k.a(this.f1435b, eVar.f1435b);
    }

    public int hashCode() {
        Object obj = this.f1434a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f1435b;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.f1434a + ", " + this.f1435b + ')';
    }
}
