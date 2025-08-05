package N0;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    private final List f351a;

    /* renamed from: b, reason: collision with root package name */
    private final int f352b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f353c;

    c(List list, int i2, boolean z2) {
        this.f351a = new ArrayList(list);
        this.f352b = i2;
        this.f353c = z2;
    }

    List a() {
        return this.f351a;
    }

    int b() {
        return this.f352b;
    }

    boolean c(List list) {
        return this.f351a.equals(list);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f351a.equals(cVar.a()) && this.f353c == cVar.f353c;
    }

    public int hashCode() {
        return this.f351a.hashCode() ^ Boolean.valueOf(this.f353c).hashCode();
    }

    public String toString() {
        return "{ " + this.f351a + " }";
    }
}
