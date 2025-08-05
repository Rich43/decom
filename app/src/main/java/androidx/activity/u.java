package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public abstract class u {

    /* renamed from: a, reason: collision with root package name */
    private boolean f1536a;

    /* renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList f1537b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    private h1.a f1538c;

    public u(boolean z2) {
        this.f1536a = z2;
    }

    public final void a(c cVar) {
        i1.k.e(cVar, "cancellable");
        this.f1537b.add(cVar);
    }

    public final h1.a b() {
        return this.f1538c;
    }

    public void c() {
    }

    public abstract void d();

    public void e(b bVar) {
        i1.k.e(bVar, "backEvent");
    }

    public void f(b bVar) {
        i1.k.e(bVar, "backEvent");
    }

    public final boolean g() {
        return this.f1536a;
    }

    public final void h() {
        Iterator it = this.f1537b.iterator();
        while (it.hasNext()) {
            ((c) it.next()).cancel();
        }
    }

    public final void i(c cVar) {
        i1.k.e(cVar, "cancellable");
        this.f1537b.remove(cVar);
    }

    public final void j(boolean z2) {
        this.f1536a = z2;
        h1.a aVar = this.f1538c;
        if (aVar != null) {
            aVar.a();
        }
    }

    public final void k(h1.a aVar) {
        this.f1538c = aVar;
    }
}
