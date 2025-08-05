package k;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: k.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0274b implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    c f6493a;

    /* renamed from: b, reason: collision with root package name */
    private c f6494b;

    /* renamed from: c, reason: collision with root package name */
    private final WeakHashMap f6495c = new WeakHashMap();

    /* renamed from: d, reason: collision with root package name */
    private int f6496d = 0;

    /* renamed from: k.b$a */
    static class a extends e {
        a(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // k.C0274b.e
        c b(c cVar) {
            return cVar.f6500d;
        }

        @Override // k.C0274b.e
        c c(c cVar) {
            return cVar.f6499c;
        }
    }

    /* renamed from: k.b$b, reason: collision with other inner class name */
    private static class C0086b extends e {
        C0086b(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // k.C0274b.e
        c b(c cVar) {
            return cVar.f6499c;
        }

        @Override // k.C0274b.e
        c c(c cVar) {
            return cVar.f6500d;
        }
    }

    /* renamed from: k.b$c */
    static class c implements Map.Entry {

        /* renamed from: a, reason: collision with root package name */
        final Object f6497a;

        /* renamed from: b, reason: collision with root package name */
        final Object f6498b;

        /* renamed from: c, reason: collision with root package name */
        c f6499c;

        /* renamed from: d, reason: collision with root package name */
        c f6500d;

        c(Object obj, Object obj2) {
            this.f6497a = obj;
            this.f6498b = obj2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f6497a.equals(cVar.f6497a) && this.f6498b.equals(cVar.f6498b);
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f6497a;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f6498b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f6497a.hashCode() ^ this.f6498b.hashCode();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f6497a + "=" + this.f6498b;
        }
    }

    /* renamed from: k.b$d */
    public class d extends f implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        private c f6501a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f6502b = true;

        d() {
        }

        @Override // k.C0274b.f
        void a(c cVar) {
            c cVar2 = this.f6501a;
            if (cVar == cVar2) {
                c cVar3 = cVar2.f6500d;
                this.f6501a = cVar3;
                this.f6502b = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (this.f6502b) {
                this.f6502b = false;
                this.f6501a = C0274b.this.f6493a;
            } else {
                c cVar = this.f6501a;
                this.f6501a = cVar != null ? cVar.f6499c : null;
            }
            return this.f6501a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f6502b) {
                return C0274b.this.f6493a != null;
            }
            c cVar = this.f6501a;
            return (cVar == null || cVar.f6499c == null) ? false : true;
        }
    }

    /* renamed from: k.b$e */
    private static abstract class e extends f implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        c f6504a;

        /* renamed from: b, reason: collision with root package name */
        c f6505b;

        e(c cVar, c cVar2) {
            this.f6504a = cVar2;
            this.f6505b = cVar;
        }

        private c e() {
            c cVar = this.f6505b;
            c cVar2 = this.f6504a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }

        @Override // k.C0274b.f
        public void a(c cVar) {
            if (this.f6504a == cVar && cVar == this.f6505b) {
                this.f6505b = null;
                this.f6504a = null;
            }
            c cVar2 = this.f6504a;
            if (cVar2 == cVar) {
                this.f6504a = b(cVar2);
            }
            if (this.f6505b == cVar) {
                this.f6505b = e();
            }
        }

        abstract c b(c cVar);

        abstract c c(c cVar);

        @Override // java.util.Iterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            c cVar = this.f6505b;
            this.f6505b = e();
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6505b != null;
        }
    }

    /* renamed from: k.b$f */
    public static abstract class f {
        abstract void a(c cVar);
    }

    public Iterator a() {
        C0086b c0086b = new C0086b(this.f6494b, this.f6493a);
        this.f6495c.put(c0086b, Boolean.FALSE);
        return c0086b;
    }

    public Map.Entry b() {
        return this.f6493a;
    }

    protected c c(Object obj) {
        c cVar = this.f6493a;
        while (cVar != null && !cVar.f6497a.equals(obj)) {
            cVar = cVar.f6499c;
        }
        return cVar;
    }

    public d d() {
        d dVar = new d();
        this.f6495c.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Map.Entry e() {
        return this.f6494b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0274b)) {
            return false;
        }
        C0274b c0274b = (C0274b) obj;
        if (size() != c0274b.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = c0274b.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    c f(Object obj, Object obj2) {
        c cVar = new c(obj, obj2);
        this.f6496d++;
        c cVar2 = this.f6494b;
        if (cVar2 == null) {
            this.f6493a = cVar;
            this.f6494b = cVar;
            return cVar;
        }
        cVar2.f6499c = cVar;
        cVar.f6500d = cVar2;
        this.f6494b = cVar;
        return cVar;
    }

    public Object g(Object obj, Object obj2) {
        c cVarC = c(obj);
        if (cVarC != null) {
            return cVarC.f6498b;
        }
        f(obj, obj2);
        return null;
    }

    public Object h(Object obj) {
        c cVarC = c(obj);
        if (cVarC == null) {
            return null;
        }
        this.f6496d--;
        if (!this.f6495c.isEmpty()) {
            Iterator it = this.f6495c.keySet().iterator();
            while (it.hasNext()) {
                ((f) it.next()).a(cVarC);
            }
        }
        c cVar = cVarC.f6500d;
        if (cVar != null) {
            cVar.f6499c = cVarC.f6499c;
        } else {
            this.f6493a = cVarC.f6499c;
        }
        c cVar2 = cVarC.f6499c;
        if (cVar2 != null) {
            cVar2.f6500d = cVar;
        } else {
            this.f6494b = cVar;
        }
        cVarC.f6499c = null;
        cVarC.f6500d = null;
        return cVarC.f6498b;
    }

    public int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            iHashCode += ((Map.Entry) it.next()).hashCode();
        }
        return iHashCode;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        a aVar = new a(this.f6493a, this.f6494b);
        this.f6495c.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public int size() {
        return this.f6496d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            sb.append(((Map.Entry) it.next()).toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
