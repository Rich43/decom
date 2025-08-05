package i1;

/* loaded from: classes.dex */
public final class m implements d {

    /* renamed from: a, reason: collision with root package name */
    private final Class f6475a;

    /* renamed from: b, reason: collision with root package name */
    private final String f6476b;

    public m(Class cls, String str) {
        k.e(cls, "jClass");
        k.e(str, "moduleName");
        this.f6475a = cls;
        this.f6476b = str;
    }

    @Override // i1.d
    public Class a() {
        return this.f6475a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof m) && k.a(a(), ((m) obj).a());
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
