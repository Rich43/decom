package s1;

import android.os.Looper;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import s1.g;
import s1.h;

/* loaded from: classes.dex */
public class d {

    /* renamed from: m, reason: collision with root package name */
    private static final ExecutorService f7453m = Executors.newCachedThreadPool();
    boolean e;

    /* renamed from: g, reason: collision with root package name */
    boolean f7459g;

    /* renamed from: h, reason: collision with root package name */
    boolean f7460h;

    /* renamed from: j, reason: collision with root package name */
    List f7462j;

    /* renamed from: k, reason: collision with root package name */
    g f7463k;

    /* renamed from: l, reason: collision with root package name */
    h f7464l;

    /* renamed from: a, reason: collision with root package name */
    boolean f7454a = true;

    /* renamed from: b, reason: collision with root package name */
    boolean f7455b = true;

    /* renamed from: c, reason: collision with root package name */
    boolean f7456c = true;

    /* renamed from: d, reason: collision with root package name */
    boolean f7457d = true;

    /* renamed from: f, reason: collision with root package name */
    boolean f7458f = true;

    /* renamed from: i, reason: collision with root package name */
    ExecutorService f7461i = f7453m;

    d() {
    }

    Object a() {
        try {
            return Looper.getMainLooper();
        } catch (RuntimeException unused) {
            return null;
        }
    }

    g b() {
        g gVar = this.f7463k;
        return gVar != null ? gVar : (!g.a.c() || a() == null) ? new g.b() : new g.a("EventBus");
    }

    h c() {
        Object objA;
        h hVar = this.f7464l;
        if (hVar != null) {
            return hVar;
        }
        if (!g.a.c() || (objA = a()) == null) {
            return null;
        }
        return new h.a((Looper) objA);
    }
}
