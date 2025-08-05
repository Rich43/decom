package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.AbstractC0203h;
import androidx.lifecycle.LegacySavedStateHandleController;
import androidx.savedstate.a;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class LegacySavedStateHandleController {

    /* renamed from: a, reason: collision with root package name */
    public static final LegacySavedStateHandleController f3682a = new LegacySavedStateHandleController();

    public static final class a implements a.InterfaceC0055a {
        @Override // androidx.savedstate.a.InterfaceC0055a
        public void a(L.d dVar) throws NoSuchMethodException, SecurityException {
            i1.k.e(dVar, "owner");
            if (!(dVar instanceof J)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
            }
            I viewModelStore = ((J) dVar).getViewModelStore();
            androidx.savedstate.a savedStateRegistry = dVar.getSavedStateRegistry();
            Iterator it = viewModelStore.c().iterator();
            while (it.hasNext()) {
                E eB = viewModelStore.b((String) it.next());
                i1.k.b(eB);
                LegacySavedStateHandleController.a(eB, savedStateRegistry, dVar.getLifecycle());
            }
            if (viewModelStore.c().isEmpty()) {
                return;
            }
            savedStateRegistry.i(a.class);
        }
    }

    private LegacySavedStateHandleController() {
    }

    public static final void a(E e, androidx.savedstate.a aVar, AbstractC0203h abstractC0203h) throws NoSuchMethodException, SecurityException {
        i1.k.e(e, "viewModel");
        i1.k.e(aVar, "registry");
        i1.k.e(abstractC0203h, "lifecycle");
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) e.c("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController == null || savedStateHandleController.j()) {
            return;
        }
        savedStateHandleController.h(aVar, abstractC0203h);
        f3682a.c(aVar, abstractC0203h);
    }

    public static final SavedStateHandleController b(androidx.savedstate.a aVar, AbstractC0203h abstractC0203h, String str, Bundle bundle) throws NoSuchMethodException, SecurityException {
        i1.k.e(aVar, "registry");
        i1.k.e(abstractC0203h, "lifecycle");
        i1.k.b(str);
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, y.f3753f.a(aVar.b(str), bundle));
        savedStateHandleController.h(aVar, abstractC0203h);
        f3682a.c(aVar, abstractC0203h);
        return savedStateHandleController;
    }

    private final void c(final androidx.savedstate.a aVar, final AbstractC0203h abstractC0203h) throws NoSuchMethodException, SecurityException {
        AbstractC0203h.b bVarB = abstractC0203h.b();
        if (bVarB == AbstractC0203h.b.INITIALIZED || bVarB.b(AbstractC0203h.b.STARTED)) {
            aVar.i(a.class);
        } else {
            abstractC0203h.a(new InterfaceC0206k() { // from class: androidx.lifecycle.LegacySavedStateHandleController$tryToAddRecreator$1
                @Override // androidx.lifecycle.InterfaceC0206k
                public void d(m mVar, AbstractC0203h.a aVar2) throws NoSuchMethodException, SecurityException {
                    i1.k.e(mVar, "source");
                    i1.k.e(aVar2, "event");
                    if (aVar2 == AbstractC0203h.a.ON_START) {
                        abstractC0203h.c(this);
                        aVar.i(LegacySavedStateHandleController.a.class);
                    }
                }
            });
        }
    }
}
