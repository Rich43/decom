package o1;

import i1.k;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference f6999a;

    public a(c cVar) {
        k.e(cVar, "sequence");
        this.f6999a = new AtomicReference(cVar);
    }

    @Override // o1.c
    public Iterator iterator() {
        c cVar = (c) this.f6999a.getAndSet(null);
        if (cVar != null) {
            return cVar.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
