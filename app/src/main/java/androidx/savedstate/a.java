package androidx.savedstate;

import L.d;
import android.os.Bundle;
import androidx.lifecycle.AbstractC0203h;
import androidx.lifecycle.InterfaceC0206k;
import androidx.lifecycle.m;
import androidx.savedstate.Recreator;
import i1.g;
import i1.k;
import java.util.Iterator;
import java.util.Map;
import k.C0274b;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: g */
    private static final b f4297g = new b(null);

    /* renamed from: b */
    private boolean f4299b;

    /* renamed from: c */
    private Bundle f4300c;

    /* renamed from: d */
    private boolean f4301d;
    private Recreator.b e;

    /* renamed from: a */
    private final C0274b f4298a = new C0274b();

    /* renamed from: f */
    private boolean f4302f = true;

    /* renamed from: androidx.savedstate.a$a */
    public interface InterfaceC0055a {
        void a(d dVar);
    }

    private static final class b {
        public /* synthetic */ b(g gVar) {
            this();
        }

        private b() {
        }
    }

    public interface c {
        Bundle a();
    }

    public static final void d(a aVar, m mVar, AbstractC0203h.a aVar2) {
        k.e(aVar, "this$0");
        k.e(mVar, "<anonymous parameter 0>");
        k.e(aVar2, "event");
        if (aVar2 == AbstractC0203h.a.ON_START) {
            aVar.f4302f = true;
        } else if (aVar2 == AbstractC0203h.a.ON_STOP) {
            aVar.f4302f = false;
        }
    }

    public final Bundle b(String str) {
        k.e(str, "key");
        if (!this.f4301d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = this.f4300c;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle != null ? bundle.getBundle(str) : null;
        Bundle bundle3 = this.f4300c;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = this.f4300c;
        if (bundle4 == null || bundle4.isEmpty()) {
            this.f4300c = null;
        }
        return bundle2;
    }

    public final c c(String str) {
        k.e(str, "key");
        Iterator it = this.f4298a.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            k.d(entry, "components");
            String str2 = (String) entry.getKey();
            c cVar = (c) entry.getValue();
            if (k.a(str2, str)) {
                return cVar;
            }
        }
        return null;
    }

    public final void e(AbstractC0203h abstractC0203h) {
        k.e(abstractC0203h, "lifecycle");
        if (this.f4299b) {
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        abstractC0203h.a(new InterfaceC0206k() { // from class: L.b
            @Override // androidx.lifecycle.InterfaceC0206k
            public final void d(m mVar, AbstractC0203h.a aVar) {
                androidx.savedstate.a.d(this.f275a, mVar, aVar);
            }
        });
        this.f4299b = true;
    }

    public final void f(Bundle bundle) {
        if (!this.f4299b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).");
        }
        if (this.f4301d) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        this.f4300c = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        this.f4301d = true;
    }

    public final void g(Bundle bundle) {
        k.e(bundle, "outBundle");
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f4300c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        C0274b.d dVarD = this.f4298a.d();
        k.d(dVarD, "this.components.iteratorWithAdditions()");
        while (dVarD.hasNext()) {
            Map.Entry entry = (Map.Entry) dVarD.next();
            bundle2.putBundle((String) entry.getKey(), ((c) entry.getValue()).a());
        }
        if (bundle2.isEmpty()) {
            return;
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }

    public final void h(String str, c cVar) {
        k.e(str, "key");
        k.e(cVar, "provider");
        if (((c) this.f4298a.g(str, cVar)) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public final void i(Class cls) throws NoSuchMethodException, SecurityException {
        k.e(cls, "clazz");
        if (!this.f4302f) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        Recreator.b bVar = this.e;
        if (bVar == null) {
            bVar = new Recreator.b(this);
        }
        this.e = bVar;
        try {
            cls.getDeclaredConstructor(null);
            Recreator.b bVar2 = this.e;
            if (bVar2 != null) {
                String name = cls.getName();
                k.d(name, "clazz.name");
                bVar2.b(name);
            }
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Class " + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
        }
    }
}
