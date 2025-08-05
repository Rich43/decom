package V;

/* loaded from: classes.dex */
public class g {

    /* renamed from: b, reason: collision with root package name */
    private static final g f975b = new g();

    /* renamed from: a, reason: collision with root package name */
    private final androidx.collection.e f976a = new androidx.collection.e(20);

    g() {
    }

    public static g b() {
        return f975b;
    }

    public Q.d a(String str) {
        if (str == null) {
            return null;
        }
        return (Q.d) this.f976a.c(str);
    }

    public void c(String str, Q.d dVar) {
        if (str == null) {
            return;
        }
        this.f976a.d(str, dVar);
    }
}
