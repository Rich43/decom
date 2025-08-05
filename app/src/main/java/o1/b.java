package o1;

import h1.l;
import i1.k;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
final class b implements c {

    /* renamed from: a, reason: collision with root package name */
    private final h1.a f7000a;

    /* renamed from: b, reason: collision with root package name */
    private final l f7001b;

    public static final class a implements Iterator, j1.a {

        /* renamed from: a, reason: collision with root package name */
        private Object f7002a;

        /* renamed from: b, reason: collision with root package name */
        private int f7003b = -2;

        a() {
        }

        private final void a() {
            Object objB;
            if (this.f7003b == -2) {
                objB = b.this.f7000a.a();
            } else {
                l lVar = b.this.f7001b;
                Object obj = this.f7002a;
                k.b(obj);
                objB = lVar.b(obj);
            }
            this.f7002a = objB;
            this.f7003b = objB == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f7003b < 0) {
                a();
            }
            return this.f7003b == 1;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.f7003b < 0) {
                a();
            }
            if (this.f7003b == 0) {
                throw new NoSuchElementException();
            }
            Object obj = this.f7002a;
            k.c(obj, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
            this.f7003b = -1;
            return obj;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public b(h1.a aVar, l lVar) {
        k.e(aVar, "getInitialValue");
        k.e(lVar, "getNextValue");
        this.f7000a = aVar;
        this.f7001b = lVar;
    }

    @Override // o1.c
    public Iterator iterator() {
        return new a();
    }
}
