package a1;

import i1.k;
import java.io.Serializable;

/* loaded from: classes.dex */
final class f implements a, Serializable {

    /* renamed from: a, reason: collision with root package name */
    private h1.a f1436a;

    /* renamed from: b, reason: collision with root package name */
    private volatile Object f1437b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f1438c;

    public f(h1.a aVar, Object obj) {
        k.e(aVar, "initializer");
        this.f1436a = aVar;
        this.f1437b = h.f1439a;
        this.f1438c = obj == null ? this : obj;
    }

    public boolean a() {
        return this.f1437b != h.f1439a;
    }

    @Override // a1.a
    public Object getValue() {
        Object objA;
        Object obj = this.f1437b;
        h hVar = h.f1439a;
        if (obj != hVar) {
            return obj;
        }
        synchronized (this.f1438c) {
            objA = this.f1437b;
            if (objA == hVar) {
                h1.a aVar = this.f1436a;
                k.b(aVar);
                objA = aVar.a();
                this.f1437b = objA;
                this.f1436a = null;
            }
        }
        return objA;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ f(h1.a aVar, Object obj, int i2, i1.g gVar) {
        this(aVar, (i2 & 2) != 0 ? null : obj);
    }
}
