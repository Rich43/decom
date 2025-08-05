package androidx.activity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f1529a;

    /* renamed from: b, reason: collision with root package name */
    private final h1.a f1530b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f1531c;

    /* renamed from: d, reason: collision with root package name */
    private int f1532d;
    private boolean e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f1533f;

    /* renamed from: g, reason: collision with root package name */
    private final List f1534g;

    /* renamed from: h, reason: collision with root package name */
    private final Runnable f1535h;

    public s(Executor executor, h1.a aVar) {
        i1.k.e(executor, "executor");
        i1.k.e(aVar, "reportFullyDrawn");
        this.f1529a = executor;
        this.f1530b = aVar;
        this.f1531c = new Object();
        this.f1534g = new ArrayList();
        this.f1535h = new Runnable() { // from class: androidx.activity.r
            @Override // java.lang.Runnable
            public final void run() {
                s.d(this.f1528a);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(s sVar) {
        i1.k.e(sVar, "this$0");
        synchronized (sVar.f1531c) {
            try {
                sVar.e = false;
                if (sVar.f1532d == 0 && !sVar.f1533f) {
                    sVar.f1530b.a();
                    sVar.b();
                }
                a1.i iVar = a1.i.f1440a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        synchronized (this.f1531c) {
            try {
                this.f1533f = true;
                Iterator it = this.f1534g.iterator();
                while (it.hasNext()) {
                    ((h1.a) it.next()).a();
                }
                this.f1534g.clear();
                a1.i iVar = a1.i.f1440a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean c() {
        boolean z2;
        synchronized (this.f1531c) {
            z2 = this.f1533f;
        }
        return z2;
    }
}
