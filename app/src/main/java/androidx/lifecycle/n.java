package androidx.lifecycle;

import androidx.lifecycle.AbstractC0203h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import k.C0273a;
import k.C0274b;

/* loaded from: classes.dex */
public class n extends AbstractC0203h {

    /* renamed from: j */
    public static final a f3724j = new a(null);

    /* renamed from: b */
    private final boolean f3725b;

    /* renamed from: c */
    private C0273a f3726c;

    /* renamed from: d */
    private AbstractC0203h.b f3727d;
    private final WeakReference e;

    /* renamed from: f */
    private int f3728f;

    /* renamed from: g */
    private boolean f3729g;

    /* renamed from: h */
    private boolean f3730h;

    /* renamed from: i */
    private ArrayList f3731i;

    public static final class a {
        public /* synthetic */ a(i1.g gVar) {
            this();
        }

        public final AbstractC0203h.b a(AbstractC0203h.b bVar, AbstractC0203h.b bVar2) {
            i1.k.e(bVar, "state1");
            return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
        }

        private a() {
        }
    }

    public static final class b {

        /* renamed from: a */
        private AbstractC0203h.b f3732a;

        /* renamed from: b */
        private InterfaceC0206k f3733b;

        public b(InterfaceC0207l interfaceC0207l, AbstractC0203h.b bVar) {
            i1.k.e(bVar, "initialState");
            i1.k.b(interfaceC0207l);
            this.f3733b = o.f(interfaceC0207l);
            this.f3732a = bVar;
        }

        public final void a(m mVar, AbstractC0203h.a aVar) {
            i1.k.e(aVar, "event");
            AbstractC0203h.b bVarB = aVar.b();
            this.f3732a = n.f3724j.a(this.f3732a, bVarB);
            InterfaceC0206k interfaceC0206k = this.f3733b;
            i1.k.b(mVar);
            interfaceC0206k.d(mVar, aVar);
            this.f3732a = bVarB;
        }

        public final AbstractC0203h.b b() {
            return this.f3732a;
        }
    }

    private n(m mVar, boolean z2) {
        this.f3725b = z2;
        this.f3726c = new C0273a();
        this.f3727d = AbstractC0203h.b.INITIALIZED;
        this.f3731i = new ArrayList();
        this.e = new WeakReference(mVar);
    }

    private final void d(m mVar) {
        Iterator itA = this.f3726c.a();
        i1.k.d(itA, "observerMap.descendingIterator()");
        while (itA.hasNext() && !this.f3730h) {
            Map.Entry entry = (Map.Entry) itA.next();
            i1.k.d(entry, "next()");
            InterfaceC0207l interfaceC0207l = (InterfaceC0207l) entry.getKey();
            b bVar = (b) entry.getValue();
            while (bVar.b().compareTo(this.f3727d) > 0 && !this.f3730h && this.f3726c.contains(interfaceC0207l)) {
                AbstractC0203h.a aVarA = AbstractC0203h.a.Companion.a(bVar.b());
                if (aVarA == null) {
                    throw new IllegalStateException("no event down from " + bVar.b());
                }
                l(aVarA.b());
                bVar.a(mVar, aVarA);
                k();
            }
        }
    }

    private final AbstractC0203h.b e(InterfaceC0207l interfaceC0207l) {
        b bVar;
        Map.Entry entryI = this.f3726c.i(interfaceC0207l);
        AbstractC0203h.b bVar2 = null;
        AbstractC0203h.b bVarB = (entryI == null || (bVar = (b) entryI.getValue()) == null) ? null : bVar.b();
        if (!this.f3731i.isEmpty()) {
            bVar2 = (AbstractC0203h.b) this.f3731i.get(r0.size() - 1);
        }
        a aVar = f3724j;
        return aVar.a(aVar.a(this.f3727d, bVarB), bVar2);
    }

    private final void f(String str) {
        if (!this.f3725b || j.c.f().b()) {
            return;
        }
        throw new IllegalStateException(("Method " + str + " must be called on the main thread").toString());
    }

    private final void g(m mVar) {
        C0274b.d dVarD = this.f3726c.d();
        i1.k.d(dVarD, "observerMap.iteratorWithAdditions()");
        while (dVarD.hasNext() && !this.f3730h) {
            Map.Entry entry = (Map.Entry) dVarD.next();
            InterfaceC0207l interfaceC0207l = (InterfaceC0207l) entry.getKey();
            b bVar = (b) entry.getValue();
            while (bVar.b().compareTo(this.f3727d) < 0 && !this.f3730h && this.f3726c.contains(interfaceC0207l)) {
                l(bVar.b());
                AbstractC0203h.a aVarB = AbstractC0203h.a.Companion.b(bVar.b());
                if (aVarB == null) {
                    throw new IllegalStateException("no event up from " + bVar.b());
                }
                bVar.a(mVar, aVarB);
                k();
            }
        }
    }

    private final boolean i() {
        if (this.f3726c.size() == 0) {
            return true;
        }
        Map.Entry entryB = this.f3726c.b();
        i1.k.b(entryB);
        AbstractC0203h.b bVarB = ((b) entryB.getValue()).b();
        Map.Entry entryE = this.f3726c.e();
        i1.k.b(entryE);
        AbstractC0203h.b bVarB2 = ((b) entryE.getValue()).b();
        return bVarB == bVarB2 && this.f3727d == bVarB2;
    }

    private final void j(AbstractC0203h.b bVar) {
        AbstractC0203h.b bVar2 = this.f3727d;
        if (bVar2 == bVar) {
            return;
        }
        if (bVar2 == AbstractC0203h.b.INITIALIZED && bVar == AbstractC0203h.b.DESTROYED) {
            throw new IllegalStateException(("no event down from " + this.f3727d + " in component " + this.e.get()).toString());
        }
        this.f3727d = bVar;
        if (this.f3729g || this.f3728f != 0) {
            this.f3730h = true;
            return;
        }
        this.f3729g = true;
        n();
        this.f3729g = false;
        if (this.f3727d == AbstractC0203h.b.DESTROYED) {
            this.f3726c = new C0273a();
        }
    }

    private final void k() {
        this.f3731i.remove(r0.size() - 1);
    }

    private final void l(AbstractC0203h.b bVar) {
        this.f3731i.add(bVar);
    }

    private final void n() {
        m mVar = (m) this.e.get();
        if (mVar == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
        }
        while (!i()) {
            this.f3730h = false;
            AbstractC0203h.b bVar = this.f3727d;
            Map.Entry entryB = this.f3726c.b();
            i1.k.b(entryB);
            if (bVar.compareTo(((b) entryB.getValue()).b()) < 0) {
                d(mVar);
            }
            Map.Entry entryE = this.f3726c.e();
            if (!this.f3730h && entryE != null && this.f3727d.compareTo(((b) entryE.getValue()).b()) > 0) {
                g(mVar);
            }
        }
        this.f3730h = false;
    }

    @Override // androidx.lifecycle.AbstractC0203h
    public void a(InterfaceC0207l interfaceC0207l) {
        m mVar;
        i1.k.e(interfaceC0207l, "observer");
        f("addObserver");
        AbstractC0203h.b bVar = this.f3727d;
        AbstractC0203h.b bVar2 = AbstractC0203h.b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = AbstractC0203h.b.INITIALIZED;
        }
        b bVar3 = new b(interfaceC0207l, bVar2);
        if (((b) this.f3726c.g(interfaceC0207l, bVar3)) == null && (mVar = (m) this.e.get()) != null) {
            boolean z2 = this.f3728f != 0 || this.f3729g;
            AbstractC0203h.b bVarE = e(interfaceC0207l);
            this.f3728f++;
            while (bVar3.b().compareTo(bVarE) < 0 && this.f3726c.contains(interfaceC0207l)) {
                l(bVar3.b());
                AbstractC0203h.a aVarB = AbstractC0203h.a.Companion.b(bVar3.b());
                if (aVarB == null) {
                    throw new IllegalStateException("no event up from " + bVar3.b());
                }
                bVar3.a(mVar, aVarB);
                k();
                bVarE = e(interfaceC0207l);
            }
            if (!z2) {
                n();
            }
            this.f3728f--;
        }
    }

    @Override // androidx.lifecycle.AbstractC0203h
    public AbstractC0203h.b b() {
        return this.f3727d;
    }

    @Override // androidx.lifecycle.AbstractC0203h
    public void c(InterfaceC0207l interfaceC0207l) {
        i1.k.e(interfaceC0207l, "observer");
        f("removeObserver");
        this.f3726c.h(interfaceC0207l);
    }

    public void h(AbstractC0203h.a aVar) {
        i1.k.e(aVar, "event");
        f("handleLifecycleEvent");
        j(aVar.b());
    }

    public void m(AbstractC0203h.b bVar) {
        i1.k.e(bVar, "state");
        f("setCurrentState");
        j(bVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public n(m mVar) {
        this(mVar, true);
        i1.k.e(mVar, "provider");
    }
}
