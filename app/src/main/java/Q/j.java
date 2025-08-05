package Q;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private final Object f612a;

    /* renamed from: b, reason: collision with root package name */
    private final Throwable f613b;

    public j(Object obj) {
        this.f612a = obj;
        this.f613b = null;
    }

    public Throwable a() {
        return this.f613b;
    }

    public Object b() {
        return this.f612a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (b() != null && b().equals(jVar.b())) {
            return true;
        }
        if (a() == null || jVar.a() == null) {
            return false;
        }
        return a().toString().equals(a().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{b(), a()});
    }

    public j(Throwable th) {
        this.f613b = th;
        this.f612a = null;
    }
}
