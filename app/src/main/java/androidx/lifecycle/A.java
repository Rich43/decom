package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.a;
import java.util.Map;

/* loaded from: classes.dex */
public final class A implements a.c {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.savedstate.a f3651a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f3652b;

    /* renamed from: c, reason: collision with root package name */
    private Bundle f3653c;

    /* renamed from: d, reason: collision with root package name */
    private final a1.a f3654d;

    static final class a extends i1.l implements h1.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ J f3655b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(J j2) {
            super(0);
            this.f3655b = j2;
        }

        @Override // h1.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final B a() {
            return z.e(this.f3655b);
        }
    }

    public A(androidx.savedstate.a aVar, J j2) {
        i1.k.e(aVar, "savedStateRegistry");
        i1.k.e(j2, "viewModelStoreOwner");
        this.f3651a = aVar;
        this.f3654d = a1.b.a(new a(j2));
    }

    private final B c() {
        return (B) this.f3654d.getValue();
    }

    @Override // androidx.savedstate.a.c
    public Bundle a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f3653c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry entry : c().f().entrySet()) {
            String str = (String) entry.getKey();
            Bundle bundleA = ((y) entry.getValue()).c().a();
            if (!i1.k.a(bundleA, Bundle.EMPTY)) {
                bundle.putBundle(str, bundleA);
            }
        }
        this.f3652b = false;
        return bundle;
    }

    public final Bundle b(String str) {
        i1.k.e(str, "key");
        d();
        Bundle bundle = this.f3653c;
        Bundle bundle2 = bundle != null ? bundle.getBundle(str) : null;
        Bundle bundle3 = this.f3653c;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = this.f3653c;
        if (bundle4 != null && bundle4.isEmpty()) {
            this.f3653c = null;
        }
        return bundle2;
    }

    public final void d() {
        if (this.f3652b) {
            return;
        }
        Bundle bundleB = this.f3651a.b("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f3653c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if (bundleB != null) {
            bundle.putAll(bundleB);
        }
        this.f3653c = bundle;
        this.f3652b = true;
        c();
    }
}
