package Z;

/* loaded from: classes.dex */
public enum a {
    JSON(".json"),
    ZIP(".zip");


    /* renamed from: a, reason: collision with root package name */
    public final String f1360a;

    a(String str) {
        this.f1360a = str;
    }

    public String a() {
        return ".temp" + this.f1360a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f1360a;
    }
}
