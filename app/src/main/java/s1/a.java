package s1;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
class a implements Runnable, l {

    /* renamed from: a, reason: collision with root package name */
    private final k f7424a = new k();

    /* renamed from: b, reason: collision with root package name */
    private final c f7425b;

    a(c cVar) {
        this.f7425b = cVar;
    }

    @Override // s1.l
    public void a(q qVar, Object obj) {
        this.f7424a.a(j.a(qVar, obj));
        this.f7425b.d().execute(this);
    }

    @Override // java.lang.Runnable
    public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        j jVarB = this.f7424a.b();
        if (jVarB == null) {
            throw new IllegalStateException("No pending post available");
        }
        this.f7425b.g(jVarB);
    }
}
