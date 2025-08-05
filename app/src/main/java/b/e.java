package b;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.AbstractC0203h;
import androidx.lifecycle.InterfaceC0206k;
import androidx.lifecycle.m;
import c.AbstractC0224a;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import i1.k;
import i1.l;
import i1.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: h, reason: collision with root package name */
    private static final b f4565h = new b(null);

    /* renamed from: a, reason: collision with root package name */
    private final Map f4566a = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map f4567b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    private final Map f4568c = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name */
    private final List f4569d = new ArrayList();
    private final transient Map e = new LinkedHashMap();

    /* renamed from: f, reason: collision with root package name */
    private final Map f4570f = new LinkedHashMap();

    /* renamed from: g, reason: collision with root package name */
    private final Bundle f4571g = new Bundle();

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final b.b f4572a;

        /* renamed from: b, reason: collision with root package name */
        private final AbstractC0224a f4573b;

        public a(b.b bVar, AbstractC0224a abstractC0224a) {
            k.e(bVar, "callback");
            k.e(abstractC0224a, "contract");
            this.f4572a = bVar;
            this.f4573b = abstractC0224a;
        }

        public final b.b a() {
            return this.f4572a;
        }

        public final AbstractC0224a b() {
            return this.f4573b;
        }
    }

    private static final class b {
        public /* synthetic */ b(i1.g gVar) {
            this();
        }

        private b() {
        }
    }

    private static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final AbstractC0203h f4574a;

        /* renamed from: b, reason: collision with root package name */
        private final List f4575b;

        public c(AbstractC0203h abstractC0203h) {
            k.e(abstractC0203h, "lifecycle");
            this.f4574a = abstractC0203h;
            this.f4575b = new ArrayList();
        }

        public final void a(InterfaceC0206k interfaceC0206k) {
            k.e(interfaceC0206k, "observer");
            this.f4574a.a(interfaceC0206k);
            this.f4575b.add(interfaceC0206k);
        }

        public final void b() {
            Iterator it = this.f4575b.iterator();
            while (it.hasNext()) {
                this.f4574a.c((InterfaceC0206k) it.next());
            }
            this.f4575b.clear();
        }
    }

    static final class d extends l implements h1.a {

        /* renamed from: b, reason: collision with root package name */
        public static final d f4576b = new d();

        d() {
            super(0);
        }

        @Override // h1.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Integer a() {
            return Integer.valueOf(k1.c.f6518a.b(2147418112) + ArrayPool.STANDARD_BUFFER_SIZE_BYTES);
        }
    }

    /* renamed from: b.e$e, reason: collision with other inner class name */
    public static final class C0061e extends b.c {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f4578b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AbstractC0224a f4579c;

        C0061e(String str, AbstractC0224a abstractC0224a) {
            this.f4578b = str;
            this.f4579c = abstractC0224a;
        }

        @Override // b.c
        public void b(Object obj, androidx.core.app.c cVar) throws Exception {
            Object obj2 = e.this.f4567b.get(this.f4578b);
            AbstractC0224a abstractC0224a = this.f4579c;
            if (obj2 != null) {
                int iIntValue = ((Number) obj2).intValue();
                e.this.f4569d.add(this.f4578b);
                try {
                    e.this.i(iIntValue, this.f4579c, obj, cVar);
                    return;
                } catch (Exception e) {
                    e.this.f4569d.remove(this.f4578b);
                    throw e;
                }
            }
            throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + abstractC0224a + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
        }

        @Override // b.c
        public void c() {
            e.this.p(this.f4578b);
        }
    }

    public static final class f extends b.c {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f4581b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AbstractC0224a f4582c;

        f(String str, AbstractC0224a abstractC0224a) {
            this.f4581b = str;
            this.f4582c = abstractC0224a;
        }

        @Override // b.c
        public void b(Object obj, androidx.core.app.c cVar) throws Exception {
            Object obj2 = e.this.f4567b.get(this.f4581b);
            AbstractC0224a abstractC0224a = this.f4582c;
            if (obj2 != null) {
                int iIntValue = ((Number) obj2).intValue();
                e.this.f4569d.add(this.f4581b);
                try {
                    e.this.i(iIntValue, this.f4582c, obj, cVar);
                    return;
                } catch (Exception e) {
                    e.this.f4569d.remove(this.f4581b);
                    throw e;
                }
            }
            throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + abstractC0224a + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
        }

        @Override // b.c
        public void c() {
            e.this.p(this.f4581b);
        }
    }

    private final void d(int i2, String str) {
        this.f4566a.put(Integer.valueOf(i2), str);
        this.f4567b.put(str, Integer.valueOf(i2));
    }

    private final void g(String str, int i2, Intent intent, a aVar) {
        if ((aVar != null ? aVar.a() : null) == null || !this.f4569d.contains(str)) {
            this.f4570f.remove(str);
            this.f4571g.putParcelable(str, new C0211a(i2, intent));
        } else {
            aVar.a().a(aVar.b().c(i2, intent));
            this.f4569d.remove(str);
        }
    }

    private final int h() {
        for (Number number : o1.d.b(d.f4576b)) {
            if (!this.f4566a.containsKey(Integer.valueOf(number.intValue()))) {
                return number.intValue();
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(e eVar, String str, b.b bVar, AbstractC0224a abstractC0224a, m mVar, AbstractC0203h.a aVar) {
        k.e(eVar, "this$0");
        k.e(str, "$key");
        k.e(bVar, "$callback");
        k.e(abstractC0224a, "$contract");
        k.e(mVar, "<anonymous parameter 0>");
        k.e(aVar, "event");
        if (AbstractC0203h.a.ON_START != aVar) {
            if (AbstractC0203h.a.ON_STOP == aVar) {
                eVar.e.remove(str);
                return;
            } else {
                if (AbstractC0203h.a.ON_DESTROY == aVar) {
                    eVar.p(str);
                    return;
                }
                return;
            }
        }
        eVar.e.put(str, new a(bVar, abstractC0224a));
        if (eVar.f4570f.containsKey(str)) {
            Object obj = eVar.f4570f.get(str);
            eVar.f4570f.remove(str);
            bVar.a(obj);
        }
        C0211a c0211a = (C0211a) androidx.core.os.b.a(eVar.f4571g, str, C0211a.class);
        if (c0211a != null) {
            eVar.f4571g.remove(str);
            bVar.a(abstractC0224a.c(c0211a.b(), c0211a.a()));
        }
    }

    private final void o(String str) {
        if (((Integer) this.f4567b.get(str)) != null) {
            return;
        }
        d(h(), str);
    }

    public final boolean e(int i2, int i3, Intent intent) {
        String str = (String) this.f4566a.get(Integer.valueOf(i2));
        if (str == null) {
            return false;
        }
        g(str, i3, intent, (a) this.e.get(str));
        return true;
    }

    public final boolean f(int i2, Object obj) {
        String str = (String) this.f4566a.get(Integer.valueOf(i2));
        if (str == null) {
            return false;
        }
        a aVar = (a) this.e.get(str);
        if ((aVar != null ? aVar.a() : null) == null) {
            this.f4571g.remove(str);
            this.f4570f.put(str, obj);
            return true;
        }
        b.b bVarA = aVar.a();
        k.c(bVarA, "null cannot be cast to non-null type androidx.activity.result.ActivityResultCallback<O of androidx.activity.result.ActivityResultRegistry.dispatchResult>");
        if (!this.f4569d.remove(str)) {
            return true;
        }
        bVarA.a(obj);
        return true;
    }

    public abstract void i(int i2, AbstractC0224a abstractC0224a, Object obj, androidx.core.app.c cVar);

    public final void j(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
        if (stringArrayList2 != null) {
            this.f4569d.addAll(stringArrayList2);
        }
        Bundle bundle2 = bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
        if (bundle2 != null) {
            this.f4571g.putAll(bundle2);
        }
        int size = stringArrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            String str = stringArrayList.get(i2);
            if (this.f4567b.containsKey(str)) {
                Integer num = (Integer) this.f4567b.remove(str);
                if (!this.f4571g.containsKey(str)) {
                    p.a(this.f4566a).remove(num);
                }
            }
            Integer num2 = integerArrayList.get(i2);
            k.d(num2, "rcs[i]");
            int iIntValue = num2.intValue();
            String str2 = stringArrayList.get(i2);
            k.d(str2, "keys[i]");
            d(iIntValue, str2);
        }
    }

    public final void k(Bundle bundle) {
        k.e(bundle, "outState");
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.f4567b.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.f4567b.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.f4569d));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", new Bundle(this.f4571g));
    }

    public final b.c l(final String str, m mVar, final AbstractC0224a abstractC0224a, final b.b bVar) {
        k.e(str, "key");
        k.e(mVar, "lifecycleOwner");
        k.e(abstractC0224a, "contract");
        k.e(bVar, "callback");
        AbstractC0203h lifecycle = mVar.getLifecycle();
        if (lifecycle.b().b(AbstractC0203h.b.STARTED)) {
            throw new IllegalStateException(("LifecycleOwner " + mVar + " is attempting to register while current state is " + lifecycle.b() + ". LifecycleOwners must call register before they are STARTED.").toString());
        }
        o(str);
        c cVar = (c) this.f4568c.get(str);
        if (cVar == null) {
            cVar = new c(lifecycle);
        }
        cVar.a(new InterfaceC0206k() { // from class: b.d
            @Override // androidx.lifecycle.InterfaceC0206k
            public final void d(m mVar2, AbstractC0203h.a aVar) {
                e.n(this.f4561a, str, bVar, abstractC0224a, mVar2, aVar);
            }
        });
        this.f4568c.put(str, cVar);
        return new C0061e(str, abstractC0224a);
    }

    public final b.c m(String str, AbstractC0224a abstractC0224a, b.b bVar) {
        k.e(str, "key");
        k.e(abstractC0224a, "contract");
        k.e(bVar, "callback");
        o(str);
        this.e.put(str, new a(bVar, abstractC0224a));
        if (this.f4570f.containsKey(str)) {
            Object obj = this.f4570f.get(str);
            this.f4570f.remove(str);
            bVar.a(obj);
        }
        C0211a c0211a = (C0211a) androidx.core.os.b.a(this.f4571g, str, C0211a.class);
        if (c0211a != null) {
            this.f4571g.remove(str);
            bVar.a(abstractC0224a.c(c0211a.b(), c0211a.a()));
        }
        return new f(str, abstractC0224a);
    }

    public final void p(String str) {
        Integer num;
        k.e(str, "key");
        if (!this.f4569d.contains(str) && (num = (Integer) this.f4567b.remove(str)) != null) {
            this.f4566a.remove(num);
        }
        this.e.remove(str);
        if (this.f4570f.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f4570f.get(str));
            this.f4570f.remove(str);
        }
        if (this.f4571g.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + ((C0211a) androidx.core.os.b.a(this.f4571g, str, C0211a.class)));
            this.f4571g.remove(str);
        }
        c cVar = (c) this.f4568c.get(str);
        if (cVar != null) {
            cVar.b();
            this.f4568c.remove(str);
        }
    }
}
