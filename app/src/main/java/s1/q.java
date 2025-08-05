package s1;

/* loaded from: classes.dex */
final class q {

    /* renamed from: a, reason: collision with root package name */
    final Object f7499a;

    /* renamed from: b, reason: collision with root package name */
    final o f7500b;

    /* renamed from: c, reason: collision with root package name */
    volatile boolean f7501c = true;

    q(Object obj, o oVar) {
        this.f7499a = obj;
        this.f7500b = oVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f7499a == qVar.f7499a && this.f7500b.equals(qVar.f7500b);
    }

    public int hashCode() {
        return this.f7499a.hashCode() + this.f7500b.f7488f.hashCode();
    }
}
