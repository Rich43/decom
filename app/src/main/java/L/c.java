package L;

import android.os.Bundle;
import androidx.lifecycle.AbstractC0203h;
import androidx.savedstate.Recreator;
import i1.g;
import i1.k;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: d, reason: collision with root package name */
    public static final a f276d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final d f277a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.savedstate.a f278b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f279c;

    public static final class a {
        public /* synthetic */ a(g gVar) {
            this();
        }

        public final c a(d dVar) {
            k.e(dVar, "owner");
            return new c(dVar, null);
        }

        private a() {
        }
    }

    public /* synthetic */ c(d dVar, g gVar) {
        this(dVar);
    }

    public static final c a(d dVar) {
        return f276d.a(dVar);
    }

    public final androidx.savedstate.a b() {
        return this.f278b;
    }

    public final void c() {
        AbstractC0203h lifecycle = this.f277a.getLifecycle();
        if (lifecycle.b() != AbstractC0203h.b.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        lifecycle.a(new Recreator(this.f277a));
        this.f278b.e(lifecycle);
        this.f279c = true;
    }

    public final void d(Bundle bundle) {
        if (!this.f279c) {
            c();
        }
        AbstractC0203h lifecycle = this.f277a.getLifecycle();
        if (!lifecycle.b().b(AbstractC0203h.b.STARTED)) {
            this.f278b.f(bundle);
            return;
        }
        throw new IllegalStateException(("performRestore cannot be called when owner is " + lifecycle.b()).toString());
    }

    public final void e(Bundle bundle) {
        k.e(bundle, "outBundle");
        this.f278b.g(bundle);
    }

    private c(d dVar) {
        this.f277a = dVar;
        this.f278b = new androidx.savedstate.a();
    }
}
