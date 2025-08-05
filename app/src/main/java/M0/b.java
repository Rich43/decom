package M0;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final int f330a;

    /* renamed from: b, reason: collision with root package name */
    private final int f331b;

    public b(int i2, int i3) {
        this.f330a = i2;
        this.f331b = i3;
    }

    public final int a() {
        return this.f331b;
    }

    public final int b() {
        return this.f330a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f330a == bVar.f330a && this.f331b == bVar.f331b;
    }

    public final int hashCode() {
        return this.f330a ^ this.f331b;
    }

    public final String toString() {
        return this.f330a + "(" + this.f331b + ')';
    }
}
