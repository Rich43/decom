package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.lifecycle.AbstractC0203h;
import androidx.lifecycle.F;
import androidx.lifecycle.InterfaceC0202g;

/* loaded from: classes.dex */
class I implements InterfaceC0202g, L.d, androidx.lifecycle.J {

    /* renamed from: a, reason: collision with root package name */
    private final Fragment f3456a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.lifecycle.I f3457b;

    /* renamed from: c, reason: collision with root package name */
    private androidx.lifecycle.n f3458c = null;

    /* renamed from: d, reason: collision with root package name */
    private L.c f3459d = null;

    I(Fragment fragment, androidx.lifecycle.I i2) {
        this.f3456a = fragment;
        this.f3457b = i2;
    }

    void a(AbstractC0203h.a aVar) {
        this.f3458c.h(aVar);
    }

    void b() {
        if (this.f3458c == null) {
            this.f3458c = new androidx.lifecycle.n(this);
            L.c cVarA = L.c.a(this);
            this.f3459d = cVarA;
            cVarA.c();
            androidx.lifecycle.z.c(this);
        }
    }

    boolean c() {
        return this.f3458c != null;
    }

    void d(Bundle bundle) {
        this.f3459d.d(bundle);
    }

    void e(Bundle bundle) {
        this.f3459d.e(bundle);
    }

    void g(AbstractC0203h.b bVar) {
        this.f3458c.m(bVar);
    }

    @Override // androidx.lifecycle.InterfaceC0202g
    public I.a getDefaultViewModelCreationExtras() {
        Application application;
        Context applicationContext = this.f3456a.requireContext().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        I.d dVar = new I.d();
        if (application != null) {
            dVar.c(F.a.f3674g, application);
        }
        dVar.c(androidx.lifecycle.z.f3759a, this);
        dVar.c(androidx.lifecycle.z.f3760b, this);
        if (this.f3456a.getArguments() != null) {
            dVar.c(androidx.lifecycle.z.f3761c, this.f3456a.getArguments());
        }
        return dVar;
    }

    @Override // androidx.lifecycle.m
    public AbstractC0203h getLifecycle() {
        b();
        return this.f3458c;
    }

    @Override // L.d
    public androidx.savedstate.a getSavedStateRegistry() {
        b();
        return this.f3459d.b();
    }

    @Override // androidx.lifecycle.J
    public androidx.lifecycle.I getViewModelStore() {
        b();
        return this.f3457b;
    }
}
