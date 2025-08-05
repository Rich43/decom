package z0;

/* renamed from: z0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0381c {

    /* renamed from: a, reason: collision with root package name */
    private final AbstractC0380b f7772a;

    /* renamed from: b, reason: collision with root package name */
    private D0.b f7773b;

    public C0381c(AbstractC0380b abstractC0380b) {
        if (abstractC0380b == null) {
            throw new IllegalArgumentException("Binarizer must be non-null.");
        }
        this.f7772a = abstractC0380b;
    }

    public D0.b a() {
        if (this.f7773b == null) {
            this.f7773b = this.f7772a.b();
        }
        return this.f7773b;
    }

    public D0.a b(int i2, D0.a aVar) {
        return this.f7772a.c(i2, aVar);
    }

    public int c() {
        return this.f7772a.d();
    }

    public int d() {
        return this.f7772a.f();
    }

    public boolean e() {
        return this.f7772a.e().e();
    }

    public C0381c f() {
        return new C0381c(this.f7772a.a(this.f7772a.e().f()));
    }

    public String toString() {
        try {
            return a().toString();
        } catch (i unused) {
            return "";
        }
    }
}
