package s1;

/* loaded from: classes.dex */
final class k {

    /* renamed from: a, reason: collision with root package name */
    private j f7478a;

    /* renamed from: b, reason: collision with root package name */
    private j f7479b;

    k() {
    }

    synchronized void a(j jVar) {
        try {
            if (jVar == null) {
                throw new NullPointerException("null cannot be enqueued");
            }
            j jVar2 = this.f7479b;
            if (jVar2 != null) {
                jVar2.f7477c = jVar;
                this.f7479b = jVar;
            } else {
                if (this.f7478a != null) {
                    throw new IllegalStateException("Head present, but no tail");
                }
                this.f7479b = jVar;
                this.f7478a = jVar;
            }
            notifyAll();
        } catch (Throwable th) {
            throw th;
        }
    }

    synchronized j b() {
        j jVar;
        jVar = this.f7478a;
        if (jVar != null) {
            j jVar2 = jVar.f7477c;
            this.f7478a = jVar2;
            if (jVar2 == null) {
                this.f7479b = null;
            }
        }
        return jVar;
    }

    synchronized j c(int i2) {
        try {
            if (this.f7478a == null) {
                wait(i2);
            }
        } catch (Throwable th) {
            throw th;
        }
        return b();
    }
}
