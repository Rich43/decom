package s1;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public class c {
    static volatile c s;

    /* renamed from: t */
    private static final d f7429t = new d();

    /* renamed from: u */
    private static final Map f7430u = new HashMap();

    /* renamed from: a */
    private final Map f7431a;

    /* renamed from: b */
    private final Map f7432b;

    /* renamed from: c */
    private final Map f7433c;

    /* renamed from: d */
    private final ThreadLocal f7434d;
    private final h e;

    /* renamed from: f */
    private final l f7435f;

    /* renamed from: g */
    private final s1.b f7436g;

    /* renamed from: h */
    private final s1.a f7437h;

    /* renamed from: i */
    private final p f7438i;

    /* renamed from: j */
    private final ExecutorService f7439j;

    /* renamed from: k */
    private final boolean f7440k;

    /* renamed from: l */
    private final boolean f7441l;

    /* renamed from: m */
    private final boolean f7442m;

    /* renamed from: n */
    private final boolean f7443n;
    private final boolean o;

    /* renamed from: p */
    private final boolean f7444p;

    /* renamed from: q */
    private final int f7445q;
    private final g r;

    class a extends ThreadLocal {
        a() {
        }

        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public C0102c initialValue() {
            return new C0102c();
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a */
        static final /* synthetic */ int[] f7447a;

        static {
            int[] iArr = new int[ThreadMode.values().length];
            f7447a = iArr;
            try {
                iArr[ThreadMode.POSTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7447a[ThreadMode.MAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7447a[ThreadMode.MAIN_ORDERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7447a[ThreadMode.BACKGROUND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7447a[ThreadMode.ASYNC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* renamed from: s1.c$c */
    static final class C0102c {

        /* renamed from: a */
        final List f7448a = new ArrayList();

        /* renamed from: b */
        boolean f7449b;

        /* renamed from: c */
        boolean f7450c;

        /* renamed from: d */
        q f7451d;
        Object e;

        /* renamed from: f */
        boolean f7452f;

        C0102c() {
        }
    }

    public c() {
        this(f7429t);
    }

    static void a(List list, Class[] clsArr) {
        for (Class cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, cls.getInterfaces());
            }
        }
    }

    private void b(q qVar, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (obj != null) {
            o(qVar, obj, i());
        }
    }

    public static c c() {
        if (s == null) {
            synchronized (c.class) {
                try {
                    if (s == null) {
                        s = new c();
                    }
                } finally {
                }
            }
        }
        return s;
    }

    private void f(q qVar, Object obj, Throwable th) {
        if (!(obj instanceof n)) {
            if (this.f7440k) {
                throw new e("Invoking subscriber failed", th);
            }
            if (this.f7441l) {
                this.r.b(Level.SEVERE, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + qVar.f7499a.getClass(), th);
            }
            if (this.f7443n) {
                l(new n(this, th, obj, qVar.f7499a));
                return;
            }
            return;
        }
        if (this.f7441l) {
            g gVar = this.r;
            Level level = Level.SEVERE;
            gVar.b(level, "SubscriberExceptionEvent subscriber " + qVar.f7499a.getClass() + " threw an exception", th);
            n nVar = (n) obj;
            this.r.b(level, "Initial event " + nVar.f7482c + " caused exception in " + nVar.f7483d, nVar.f7481b);
        }
    }

    private boolean i() {
        h hVar = this.e;
        if (hVar != null) {
            return hVar.a();
        }
        return true;
    }

    private static List k(Class cls) {
        List arrayList;
        Map map = f7430u;
        synchronized (map) {
            try {
                arrayList = (List) map.get(cls);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    for (Class superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
                        arrayList.add(superclass);
                        a(arrayList, superclass.getInterfaces());
                    }
                    f7430u.put(cls, arrayList);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    private void m(Object obj, C0102c c0102c) {
        boolean zN;
        Class<?> cls = obj.getClass();
        if (this.f7444p) {
            List listK = k(cls);
            int size = listK.size();
            zN = false;
            for (int i2 = 0; i2 < size; i2++) {
                zN |= n(obj, c0102c, (Class) listK.get(i2));
            }
        } else {
            zN = n(obj, c0102c, cls);
        }
        if (zN) {
            return;
        }
        if (this.f7442m) {
            this.r.a(Level.FINE, "No subscribers registered for event " + cls);
        }
        if (!this.o || cls == i.class || cls == n.class) {
            return;
        }
        l(new i(this, obj));
    }

    private boolean n(Object obj, C0102c c0102c, Class cls) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = (CopyOnWriteArrayList) this.f7431a.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            q qVar = (q) it.next();
            c0102c.e = obj;
            c0102c.f7451d = qVar;
            try {
                o(qVar, obj, c0102c.f7450c);
                if (c0102c.f7452f) {
                    return true;
                }
            } finally {
                c0102c.e = null;
                c0102c.f7451d = null;
                c0102c.f7452f = false;
            }
        }
        return true;
    }

    private void o(q qVar, Object obj, boolean z2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int i2 = b.f7447a[qVar.f7500b.f7485b.ordinal()];
        if (i2 == 1) {
            h(qVar, obj);
            return;
        }
        if (i2 == 2) {
            if (z2) {
                h(qVar, obj);
                return;
            } else {
                this.f7435f.a(qVar, obj);
                return;
            }
        }
        if (i2 == 3) {
            l lVar = this.f7435f;
            if (lVar != null) {
                lVar.a(qVar, obj);
                return;
            } else {
                h(qVar, obj);
                return;
            }
        }
        if (i2 == 4) {
            if (z2) {
                this.f7436g.a(qVar, obj);
                return;
            } else {
                h(qVar, obj);
                return;
            }
        }
        if (i2 == 5) {
            this.f7437h.a(qVar, obj);
            return;
        }
        throw new IllegalStateException("Unknown thread mode: " + qVar.f7500b.f7485b);
    }

    private void q(Object obj, o oVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class cls = oVar.f7486c;
        q qVar = new q(obj, oVar);
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.f7431a.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.f7431a.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(qVar)) {
            throw new e("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        for (int i2 = 0; i2 <= size; i2++) {
            if (i2 == size || oVar.f7487d > ((q) copyOnWriteArrayList.get(i2)).f7500b.f7487d) {
                copyOnWriteArrayList.add(i2, qVar);
                break;
            }
        }
        List arrayList = (List) this.f7432b.get(obj);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.f7432b.put(obj, arrayList);
        }
        arrayList.add(cls);
        if (oVar.e) {
            if (!this.f7444p) {
                b(qVar, this.f7433c.get(cls));
                return;
            }
            for (Map.Entry entry : this.f7433c.entrySet()) {
                if (cls.isAssignableFrom((Class) entry.getKey())) {
                    b(qVar, entry.getValue());
                }
            }
        }
    }

    private void s(Object obj, Class cls) {
        List list = (List) this.f7431a.get(cls);
        if (list != null) {
            int size = list.size();
            int i2 = 0;
            while (i2 < size) {
                q qVar = (q) list.get(i2);
                if (qVar.f7499a == obj) {
                    qVar.f7501c = false;
                    list.remove(i2);
                    i2--;
                    size--;
                }
                i2++;
            }
        }
    }

    ExecutorService d() {
        return this.f7439j;
    }

    public g e() {
        return this.r;
    }

    void g(j jVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object obj = jVar.f7475a;
        q qVar = jVar.f7476b;
        j.b(jVar);
        if (qVar.f7501c) {
            h(qVar, obj);
        }
    }

    void h(q qVar, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            qVar.f7500b.f7484a.invoke(qVar.f7499a, obj);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Unexpected exception", e);
        } catch (InvocationTargetException e2) {
            f(qVar, obj, e2.getCause());
        }
    }

    public synchronized boolean j(Object obj) {
        return this.f7432b.containsKey(obj);
    }

    public void l(Object obj) {
        C0102c c0102c = (C0102c) this.f7434d.get();
        List list = c0102c.f7448a;
        list.add(obj);
        if (c0102c.f7449b) {
            return;
        }
        c0102c.f7450c = i();
        c0102c.f7449b = true;
        if (c0102c.f7452f) {
            throw new e("Internal error. Abort state was not reset");
        }
        while (true) {
            try {
                if (list.isEmpty()) {
                    return;
                } else {
                    m(list.remove(0), c0102c);
                }
            } finally {
                c0102c.f7449b = false;
                c0102c.f7450c = false;
            }
        }
    }

    public void p(Object obj) {
        List listA = this.f7438i.a(obj.getClass());
        synchronized (this) {
            try {
                Iterator it = listA.iterator();
                while (it.hasNext()) {
                    q(obj, (o) it.next());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized void r(Object obj) {
        try {
            List list = (List) this.f7432b.get(obj);
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    s(obj, (Class) it.next());
                }
                this.f7432b.remove(obj);
            } else {
                this.r.a(Level.WARNING, "Subscriber to unregister was not registered before: " + obj.getClass());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public String toString() {
        return "EventBus[indexCount=" + this.f7445q + ", eventInheritance=" + this.f7444p + "]";
    }

    c(d dVar) {
        this.f7434d = new a();
        this.r = dVar.b();
        this.f7431a = new HashMap();
        this.f7432b = new HashMap();
        this.f7433c = new ConcurrentHashMap();
        h hVarC = dVar.c();
        this.e = hVarC;
        this.f7435f = hVarC != null ? hVarC.b(this) : null;
        this.f7436g = new s1.b(this);
        this.f7437h = new s1.a(this);
        List list = dVar.f7462j;
        this.f7445q = list != null ? list.size() : 0;
        this.f7438i = new p(dVar.f7462j, dVar.f7460h, dVar.f7459g);
        this.f7441l = dVar.f7454a;
        this.f7442m = dVar.f7455b;
        this.f7443n = dVar.f7456c;
        this.o = dVar.f7457d;
        this.f7440k = dVar.e;
        this.f7444p = dVar.f7458f;
        this.f7439j = dVar.f7461i;
    }
}
