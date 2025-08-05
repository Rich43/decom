package androidx.lifecycle;

import androidx.lifecycle.AbstractC0203h;

/* loaded from: classes.dex */
public final class SavedStateHandleController implements InterfaceC0206k {

    /* renamed from: a, reason: collision with root package name */
    private final String f3704a;

    /* renamed from: b, reason: collision with root package name */
    private final y f3705b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f3706c;

    public SavedStateHandleController(String str, y yVar) {
        i1.k.e(str, "key");
        i1.k.e(yVar, "handle");
        this.f3704a = str;
        this.f3705b = yVar;
    }

    @Override // androidx.lifecycle.InterfaceC0206k
    public void d(m mVar, AbstractC0203h.a aVar) {
        i1.k.e(mVar, "source");
        i1.k.e(aVar, "event");
        if (aVar == AbstractC0203h.a.ON_DESTROY) {
            this.f3706c = false;
            mVar.getLifecycle().c(this);
        }
    }

    public final void h(androidx.savedstate.a aVar, AbstractC0203h abstractC0203h) {
        i1.k.e(aVar, "registry");
        i1.k.e(abstractC0203h, "lifecycle");
        if (this.f3706c) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.f3706c = true;
        abstractC0203h.a(this);
        aVar.h(this.f3704a, this.f3705b.c());
    }

    public final y i() {
        return this.f3705b;
    }

    public final boolean j() {
        return this.f3706c;
    }
}
