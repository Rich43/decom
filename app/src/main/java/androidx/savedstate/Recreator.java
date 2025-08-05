package androidx.savedstate;

import L.d;
import android.os.Bundle;
import androidx.lifecycle.AbstractC0203h;
import androidx.lifecycle.InterfaceC0206k;
import androidx.lifecycle.m;
import androidx.savedstate.a;
import i1.g;
import i1.k;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class Recreator implements InterfaceC0206k {

    /* renamed from: b, reason: collision with root package name */
    public static final a f4294b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final d f4295a;

    public static final class a {
        public /* synthetic */ a(g gVar) {
            this();
        }

        private a() {
        }
    }

    public static final class b implements a.c {

        /* renamed from: a, reason: collision with root package name */
        private final Set f4296a;

        public b(androidx.savedstate.a aVar) {
            k.e(aVar, "registry");
            this.f4296a = new LinkedHashSet();
            aVar.h("androidx.savedstate.Restarter", this);
        }

        @Override // androidx.savedstate.a.c
        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList<>(this.f4296a));
            return bundle;
        }

        public final void b(String str) {
            k.e(str, "className");
            this.f4296a.add(str);
        }
    }

    public Recreator(d dVar) {
        k.e(dVar, "owner");
        this.f4295a = dVar;
    }

    private final void h(String str) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<? extends U> clsAsSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(a.InterfaceC0055a.class);
            k.d(clsAsSubclass, "{\n                Class.…class.java)\n            }");
            try {
                Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                try {
                    Object objNewInstance = declaredConstructor.newInstance(null);
                    k.d(objNewInstance, "{\n                constr…wInstance()\n            }");
                    ((a.InterfaceC0055a) objNewInstance).a(this.f4295a);
                } catch (Exception e) {
                    throw new RuntimeException("Failed to instantiate " + str, e);
                }
            } catch (NoSuchMethodException e2) {
                throw new IllegalStateException("Class " + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
            }
        } catch (ClassNotFoundException e3) {
            throw new RuntimeException("Class " + str + " wasn't found", e3);
        }
    }

    @Override // androidx.lifecycle.InterfaceC0206k
    public void d(m mVar, AbstractC0203h.a aVar) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        k.e(mVar, "source");
        k.e(aVar, "event");
        if (aVar != AbstractC0203h.a.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        mVar.getLifecycle().c(this);
        Bundle bundleB = this.f4295a.getSavedStateRegistry().b("androidx.savedstate.Restarter");
        if (bundleB == null) {
            return;
        }
        ArrayList<String> stringArrayList = bundleB.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        Iterator<String> it = stringArrayList.iterator();
        while (it.hasNext()) {
            h(it.next());
        }
    }
}
