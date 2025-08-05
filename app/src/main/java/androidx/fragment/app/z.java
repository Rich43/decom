package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.F;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
final class z extends androidx.lifecycle.E {

    /* renamed from: k, reason: collision with root package name */
    private static final F.b f3644k = new a();

    /* renamed from: g, reason: collision with root package name */
    private final boolean f3647g;

    /* renamed from: d, reason: collision with root package name */
    private final HashMap f3645d = new HashMap();
    private final HashMap e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    private final HashMap f3646f = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    private boolean f3648h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f3649i = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean f3650j = false;

    class a implements F.b {
        a() {
        }

        @Override // androidx.lifecycle.F.b
        public androidx.lifecycle.E a(Class cls) {
            return new z(true);
        }

        @Override // androidx.lifecycle.F.b
        public /* synthetic */ androidx.lifecycle.E b(Class cls, I.a aVar) {
            return androidx.lifecycle.G.b(this, cls, aVar);
        }
    }

    z(boolean z2) {
        this.f3647g = z2;
    }

    private void i(String str) {
        z zVar = (z) this.e.get(str);
        if (zVar != null) {
            zVar.d();
            this.e.remove(str);
        }
        androidx.lifecycle.I i2 = (androidx.lifecycle.I) this.f3646f.get(str);
        if (i2 != null) {
            i2.a();
            this.f3646f.remove(str);
        }
    }

    static z l(androidx.lifecycle.I i2) {
        return (z) new androidx.lifecycle.F(i2, f3644k).a(z.class);
    }

    @Override // androidx.lifecycle.E
    protected void d() {
        if (w.H0(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f3648h = true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || z.class != obj.getClass()) {
            return false;
        }
        z zVar = (z) obj;
        return this.f3645d.equals(zVar.f3645d) && this.e.equals(zVar.e) && this.f3646f.equals(zVar.f3646f);
    }

    void f(Fragment fragment) {
        if (this.f3650j) {
            if (w.H0(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f3645d.containsKey(fragment.mWho)) {
                return;
            }
            this.f3645d.put(fragment.mWho, fragment);
            if (w.H0(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
            }
        }
    }

    void g(Fragment fragment) {
        if (w.H0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        i(fragment.mWho);
    }

    void h(String str) {
        if (w.H0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for saved state of Fragment " + str);
        }
        i(str);
    }

    public int hashCode() {
        return (((this.f3645d.hashCode() * 31) + this.e.hashCode()) * 31) + this.f3646f.hashCode();
    }

    Fragment j(String str) {
        return (Fragment) this.f3645d.get(str);
    }

    z k(Fragment fragment) {
        z zVar = (z) this.e.get(fragment.mWho);
        if (zVar != null) {
            return zVar;
        }
        z zVar2 = new z(this.f3647g);
        this.e.put(fragment.mWho, zVar2);
        return zVar2;
    }

    Collection m() {
        return new ArrayList(this.f3645d.values());
    }

    androidx.lifecycle.I n(Fragment fragment) {
        androidx.lifecycle.I i2 = (androidx.lifecycle.I) this.f3646f.get(fragment.mWho);
        if (i2 != null) {
            return i2;
        }
        androidx.lifecycle.I i3 = new androidx.lifecycle.I();
        this.f3646f.put(fragment.mWho, i3);
        return i3;
    }

    boolean o() {
        return this.f3648h;
    }

    void p(Fragment fragment) {
        if (this.f3650j) {
            if (w.H0(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f3645d.remove(fragment.mWho) == null || !w.H0(2)) {
                return;
            }
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    void q(boolean z2) {
        this.f3650j = z2;
    }

    boolean r(Fragment fragment) {
        if (this.f3645d.containsKey(fragment.mWho)) {
            return this.f3647g ? this.f3648h : !this.f3649i;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.f3645d.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.e.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.f3646f.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
