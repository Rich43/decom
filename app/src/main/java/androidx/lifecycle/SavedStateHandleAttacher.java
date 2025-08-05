package androidx.lifecycle;

import androidx.lifecycle.AbstractC0203h;

/* loaded from: classes.dex */
public final class SavedStateHandleAttacher implements InterfaceC0206k {

    /* renamed from: a, reason: collision with root package name */
    private final A f3703a;

    public SavedStateHandleAttacher(A a2) {
        i1.k.e(a2, "provider");
        this.f3703a = a2;
    }

    @Override // androidx.lifecycle.InterfaceC0206k
    public void d(m mVar, AbstractC0203h.a aVar) {
        i1.k.e(mVar, "source");
        i1.k.e(aVar, "event");
        if (aVar == AbstractC0203h.a.ON_CREATE) {
            mVar.getLifecycle().c(this);
            this.f3703a.d();
        } else {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + aVar).toString());
        }
    }
}
