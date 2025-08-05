package androidx.lifecycle;

import I.a;
import android.os.Bundle;
import androidx.lifecycle.AbstractC0203h;
import androidx.lifecycle.F;
import androidx.savedstate.a;

/* loaded from: classes.dex */
public abstract class z {

    /* renamed from: a */
    public static final a.b f3759a = new b();

    /* renamed from: b */
    public static final a.b f3760b = new c();

    /* renamed from: c */
    public static final a.b f3761c = new a();

    public static final class a implements a.b {
        a() {
        }
    }

    public static final class b implements a.b {
        b() {
        }
    }

    public static final class c implements a.b {
        c() {
        }
    }

    static final class d extends i1.l implements h1.l {

        /* renamed from: b */
        public static final d f3762b = new d();

        d() {
            super(1);
        }

        @Override // h1.l
        /* renamed from: c */
        public final B b(I.a aVar) {
            i1.k.e(aVar, "$this$initializer");
            return new B();
        }
    }

    public static final y a(I.a aVar) {
        i1.k.e(aVar, "<this>");
        L.d dVar = (L.d) aVar.a(f3759a);
        if (dVar == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        J j2 = (J) aVar.a(f3760b);
        if (j2 == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        Bundle bundle = (Bundle) aVar.a(f3761c);
        String str = (String) aVar.a(F.c.f3679c);
        if (str != null) {
            return b(dVar, j2, str, bundle);
        }
        throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
    }

    private static final y b(L.d dVar, J j2, String str, Bundle bundle) {
        A aD = d(dVar);
        B bE = e(j2);
        y yVar = (y) bE.f().get(str);
        if (yVar != null) {
            return yVar;
        }
        y yVarA = y.f3753f.a(aD.b(str), bundle);
        bE.f().put(str, yVarA);
        return yVarA;
    }

    public static final void c(L.d dVar) {
        i1.k.e(dVar, "<this>");
        AbstractC0203h.b bVarB = dVar.getLifecycle().b();
        if (bVarB != AbstractC0203h.b.INITIALIZED && bVarB != AbstractC0203h.b.CREATED) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (dVar.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider") == null) {
            A a2 = new A(dVar.getSavedStateRegistry(), (J) dVar);
            dVar.getSavedStateRegistry().h("androidx.lifecycle.internal.SavedStateHandlesProvider", a2);
            dVar.getLifecycle().a(new SavedStateHandleAttacher(a2));
        }
    }

    public static final A d(L.d dVar) {
        i1.k.e(dVar, "<this>");
        a.c cVarC = dVar.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider");
        A a2 = cVarC instanceof A ? (A) cVarC : null;
        if (a2 != null) {
            return a2;
        }
        throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
    }

    public static final B e(J j2) {
        i1.k.e(j2, "<this>");
        I.c cVar = new I.c();
        cVar.a(i1.n.b(B.class), d.f3762b);
        return (B) new F(j2, cVar.b()).b("androidx.lifecycle.internal.SavedStateHandlesVM", B.class);
    }
}
