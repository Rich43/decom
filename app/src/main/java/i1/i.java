package i1;

/* loaded from: classes.dex */
public abstract class i extends c implements h, n1.d {

    /* renamed from: h, reason: collision with root package name */
    private final int f6472h;

    /* renamed from: i, reason: collision with root package name */
    private final int f6473i;

    public i(int i2, Object obj, Class cls, String str, String str2, int i3) {
        super(obj, cls, str, str2, (i3 & 1) == 1);
        this.f6472h = i2;
        this.f6473i = i3 >> 1;
    }

    @Override // i1.c
    protected n1.a c() {
        return n.a(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            return e().equals(iVar.e()) && g().equals(iVar.g()) && this.f6473i == iVar.f6473i && this.f6472h == iVar.f6472h && k.a(d(), iVar.d()) && k.a(f(), iVar.f());
        }
        if (obj instanceof n1.d) {
            return obj.equals(b());
        }
        return false;
    }

    public int hashCode() {
        return (((f() == null ? 0 : f().hashCode() * 31) + e().hashCode()) * 31) + g().hashCode();
    }

    public String toString() {
        n1.a aVarB = b();
        if (aVarB != this) {
            return aVarB.toString();
        }
        if ("<init>".equals(e())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + e() + " (Kotlin reflection is not available)";
    }
}
