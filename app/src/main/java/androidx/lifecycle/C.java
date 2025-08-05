package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.F;
import java.io.IOException;
import java.lang.reflect.Constructor;

/* loaded from: classes.dex */
public final class C extends F.d implements F.b {

    /* renamed from: a, reason: collision with root package name */
    private Application f3657a;

    /* renamed from: b, reason: collision with root package name */
    private final F.b f3658b;

    /* renamed from: c, reason: collision with root package name */
    private Bundle f3659c;

    /* renamed from: d, reason: collision with root package name */
    private AbstractC0203h f3660d;
    private androidx.savedstate.a e;

    public C(Application application, L.d dVar, Bundle bundle) {
        i1.k.e(dVar, "owner");
        this.e = dVar.getSavedStateRegistry();
        this.f3660d = dVar.getLifecycle();
        this.f3659c = bundle;
        this.f3657a = application;
        this.f3658b = application != null ? F.a.e.a(application) : new F.a();
    }

    @Override // androidx.lifecycle.F.b
    public E a(Class cls) {
        i1.k.e(cls, "modelClass");
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return d(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.F.b
    public E b(Class cls, I.a aVar) {
        i1.k.e(cls, "modelClass");
        i1.k.e(aVar, "extras");
        String str = (String) aVar.a(F.c.f3679c);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        }
        if (aVar.a(z.f3759a) == null || aVar.a(z.f3760b) == null) {
            if (this.f3660d != null) {
                return d(str, cls);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        Application application = (Application) aVar.a(F.a.f3674g);
        boolean zIsAssignableFrom = AbstractC0196a.class.isAssignableFrom(cls);
        Constructor constructorC = (!zIsAssignableFrom || application == null) ? D.c(cls, D.f3663b) : D.c(cls, D.f3662a);
        return constructorC == null ? this.f3658b.b(cls, aVar) : (!zIsAssignableFrom || application == null) ? D.d(cls, constructorC, z.a(aVar)) : D.d(cls, constructorC, application, z.a(aVar));
    }

    @Override // androidx.lifecycle.F.d
    public void c(E e) throws NoSuchMethodException, SecurityException {
        i1.k.e(e, "viewModel");
        if (this.f3660d != null) {
            androidx.savedstate.a aVar = this.e;
            i1.k.b(aVar);
            AbstractC0203h abstractC0203h = this.f3660d;
            i1.k.b(abstractC0203h);
            LegacySavedStateHandleController.a(e, aVar, abstractC0203h);
        }
    }

    public final E d(String str, Class cls) throws NoSuchMethodException, SecurityException, IOException {
        E eD;
        Application application;
        i1.k.e(str, "key");
        i1.k.e(cls, "modelClass");
        AbstractC0203h abstractC0203h = this.f3660d;
        if (abstractC0203h == null) {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
        boolean zIsAssignableFrom = AbstractC0196a.class.isAssignableFrom(cls);
        Constructor constructorC = (!zIsAssignableFrom || this.f3657a == null) ? D.c(cls, D.f3663b) : D.c(cls, D.f3662a);
        if (constructorC == null) {
            return this.f3657a != null ? this.f3658b.a(cls) : F.c.f3677a.a().a(cls);
        }
        androidx.savedstate.a aVar = this.e;
        i1.k.b(aVar);
        SavedStateHandleController savedStateHandleControllerB = LegacySavedStateHandleController.b(aVar, abstractC0203h, str, this.f3659c);
        if (!zIsAssignableFrom || (application = this.f3657a) == null) {
            eD = D.d(cls, constructorC, savedStateHandleControllerB.i());
        } else {
            i1.k.b(application);
            eD = D.d(cls, constructorC, application, savedStateHandleControllerB.i());
        }
        eD.e("androidx.lifecycle.savedstate.vm.tag", savedStateHandleControllerB);
        return eD;
    }
}
