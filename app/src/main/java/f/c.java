package F;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.w;
import b1.B;
import b1.H;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f162a = new c();

    /* renamed from: b, reason: collision with root package name */
    private static C0005c f163b = C0005c.f173d;

    public enum a {
        PENALTY_LOG,
        PENALTY_DEATH,
        DETECT_FRAGMENT_REUSE,
        DETECT_FRAGMENT_TAG_USAGE,
        DETECT_RETAIN_INSTANCE_USAGE,
        DETECT_SET_USER_VISIBLE_HINT,
        DETECT_TARGET_FRAGMENT_USAGE,
        DETECT_WRONG_FRAGMENT_CONTAINER
    }

    public interface b {
    }

    /* renamed from: F.c$c, reason: collision with other inner class name */
    public static final class C0005c {

        /* renamed from: c, reason: collision with root package name */
        public static final a f172c = new a(null);

        /* renamed from: d, reason: collision with root package name */
        public static final C0005c f173d = new C0005c(H.a(), null, B.d());

        /* renamed from: a, reason: collision with root package name */
        private final Set f174a;

        /* renamed from: b, reason: collision with root package name */
        private final Map f175b;

        /* renamed from: F.c$c$a */
        public static final class a {
            public /* synthetic */ a(i1.g gVar) {
                this();
            }

            private a() {
            }
        }

        public C0005c(Set set, b bVar, Map map) {
            i1.k.e(set, "flags");
            i1.k.e(map, "allowedViolations");
            this.f174a = set;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                linkedHashMap.put((String) entry.getKey(), (Set) entry.getValue());
            }
            this.f175b = linkedHashMap;
        }

        public final Set a() {
            return this.f174a;
        }

        public final b b() {
            return null;
        }

        public final Map c() {
            return this.f175b;
        }
    }

    private c() {
    }

    private final C0005c b(Fragment fragment) {
        while (fragment != null) {
            if (fragment.isAdded()) {
                w parentFragmentManager = fragment.getParentFragmentManager();
                i1.k.d(parentFragmentManager, "declaringFragment.parentFragmentManager");
                if (parentFragmentManager.A0() != null) {
                    C0005c c0005cA0 = parentFragmentManager.A0();
                    i1.k.b(c0005cA0);
                    return c0005cA0;
                }
            }
            fragment = fragment.getParentFragment();
        }
        return f163b;
    }

    private final void c(C0005c c0005c, final m mVar) {
        Fragment fragmentA = mVar.a();
        final String name = fragmentA.getClass().getName();
        if (c0005c.a().contains(a.PENALTY_LOG)) {
            Log.d("FragmentStrictMode", "Policy violation in " + name, mVar);
        }
        c0005c.b();
        if (c0005c.a().contains(a.PENALTY_DEATH)) {
            o(fragmentA, new Runnable() { // from class: F.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.d(name, mVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(String str, m mVar) {
        i1.k.e(mVar, "$violation");
        Log.e("FragmentStrictMode", "Policy violation with PENALTY_DEATH in " + str, mVar);
        throw mVar;
    }

    private final void e(m mVar) {
        if (w.H0(3)) {
            Log.d("FragmentManager", "StrictMode violation in " + mVar.a().getClass().getName(), mVar);
        }
    }

    public static final void f(Fragment fragment, String str) {
        i1.k.e(fragment, "fragment");
        i1.k.e(str, "previousFragmentId");
        F.a aVar = new F.a(fragment, str);
        c cVar = f162a;
        cVar.e(aVar);
        C0005c c0005cB = cVar.b(fragment);
        if (c0005cB.a().contains(a.DETECT_FRAGMENT_REUSE) && cVar.p(c0005cB, fragment.getClass(), aVar.getClass())) {
            cVar.c(c0005cB, aVar);
        }
    }

    public static final void g(Fragment fragment, ViewGroup viewGroup) {
        i1.k.e(fragment, "fragment");
        d dVar = new d(fragment, viewGroup);
        c cVar = f162a;
        cVar.e(dVar);
        C0005c c0005cB = cVar.b(fragment);
        if (c0005cB.a().contains(a.DETECT_FRAGMENT_TAG_USAGE) && cVar.p(c0005cB, fragment.getClass(), dVar.getClass())) {
            cVar.c(c0005cB, dVar);
        }
    }

    public static final void h(Fragment fragment) {
        i1.k.e(fragment, "fragment");
        e eVar = new e(fragment);
        c cVar = f162a;
        cVar.e(eVar);
        C0005c c0005cB = cVar.b(fragment);
        if (c0005cB.a().contains(a.DETECT_RETAIN_INSTANCE_USAGE) && cVar.p(c0005cB, fragment.getClass(), eVar.getClass())) {
            cVar.c(c0005cB, eVar);
        }
    }

    public static final void i(Fragment fragment) {
        i1.k.e(fragment, "fragment");
        f fVar = new f(fragment);
        c cVar = f162a;
        cVar.e(fVar);
        C0005c c0005cB = cVar.b(fragment);
        if (c0005cB.a().contains(a.DETECT_TARGET_FRAGMENT_USAGE) && cVar.p(c0005cB, fragment.getClass(), fVar.getClass())) {
            cVar.c(c0005cB, fVar);
        }
    }

    public static final void j(Fragment fragment) {
        i1.k.e(fragment, "fragment");
        g gVar = new g(fragment);
        c cVar = f162a;
        cVar.e(gVar);
        C0005c c0005cB = cVar.b(fragment);
        if (c0005cB.a().contains(a.DETECT_TARGET_FRAGMENT_USAGE) && cVar.p(c0005cB, fragment.getClass(), gVar.getClass())) {
            cVar.c(c0005cB, gVar);
        }
    }

    public static final void k(Fragment fragment) {
        i1.k.e(fragment, "fragment");
        i iVar = new i(fragment);
        c cVar = f162a;
        cVar.e(iVar);
        C0005c c0005cB = cVar.b(fragment);
        if (c0005cB.a().contains(a.DETECT_RETAIN_INSTANCE_USAGE) && cVar.p(c0005cB, fragment.getClass(), iVar.getClass())) {
            cVar.c(c0005cB, iVar);
        }
    }

    public static final void l(Fragment fragment, Fragment fragment2, int i2) {
        i1.k.e(fragment, "violatingFragment");
        i1.k.e(fragment2, "targetFragment");
        j jVar = new j(fragment, fragment2, i2);
        c cVar = f162a;
        cVar.e(jVar);
        C0005c c0005cB = cVar.b(fragment);
        if (c0005cB.a().contains(a.DETECT_TARGET_FRAGMENT_USAGE) && cVar.p(c0005cB, fragment.getClass(), jVar.getClass())) {
            cVar.c(c0005cB, jVar);
        }
    }

    public static final void m(Fragment fragment, boolean z2) {
        i1.k.e(fragment, "fragment");
        k kVar = new k(fragment, z2);
        c cVar = f162a;
        cVar.e(kVar);
        C0005c c0005cB = cVar.b(fragment);
        if (c0005cB.a().contains(a.DETECT_SET_USER_VISIBLE_HINT) && cVar.p(c0005cB, fragment.getClass(), kVar.getClass())) {
            cVar.c(c0005cB, kVar);
        }
    }

    public static final void n(Fragment fragment, ViewGroup viewGroup) {
        i1.k.e(fragment, "fragment");
        i1.k.e(viewGroup, "container");
        n nVar = new n(fragment, viewGroup);
        c cVar = f162a;
        cVar.e(nVar);
        C0005c c0005cB = cVar.b(fragment);
        if (c0005cB.a().contains(a.DETECT_WRONG_FRAGMENT_CONTAINER) && cVar.p(c0005cB, fragment.getClass(), nVar.getClass())) {
            cVar.c(c0005cB, nVar);
        }
    }

    private final void o(Fragment fragment, Runnable runnable) {
        if (!fragment.isAdded()) {
            runnable.run();
            return;
        }
        Handler handlerI = fragment.getParentFragmentManager().u0().i();
        i1.k.d(handlerI, "fragment.parentFragmentManager.host.handler");
        if (i1.k.a(handlerI.getLooper(), Looper.myLooper())) {
            runnable.run();
        } else {
            handlerI.post(runnable);
        }
    }

    private final boolean p(C0005c c0005c, Class cls, Class cls2) {
        Set set = (Set) c0005c.c().get(cls.getName());
        if (set == null) {
            return true;
        }
        if (i1.k.a(cls2.getSuperclass(), m.class) || !b1.l.j(set, cls2.getSuperclass())) {
            return !set.contains(cls2);
        }
        return false;
    }
}
