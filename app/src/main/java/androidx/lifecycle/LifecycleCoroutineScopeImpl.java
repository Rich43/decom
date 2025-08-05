package androidx.lifecycle;

import androidx.lifecycle.AbstractC0203h;

/* loaded from: classes.dex */
public final class LifecycleCoroutineScopeImpl extends AbstractC0204i implements InterfaceC0206k {

    /* renamed from: a, reason: collision with root package name */
    private final AbstractC0203h f3685a;

    @Override // androidx.lifecycle.InterfaceC0206k
    public void d(m mVar, AbstractC0203h.a aVar) {
        i1.k.e(mVar, "source");
        i1.k.e(aVar, "event");
        if (i().b().compareTo(AbstractC0203h.b.DESTROYED) <= 0) {
            i().c(this);
            h();
            q1.c.b(null, null, 1, null);
        }
    }

    public c1.a h() {
        return null;
    }

    public AbstractC0203h i() {
        return this.f3685a;
    }
}
