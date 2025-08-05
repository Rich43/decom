package Q;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* loaded from: classes.dex */
public class k {
    public static Executor e = Executors.newCachedThreadPool();

    /* renamed from: a, reason: collision with root package name */
    private final Set f614a;

    /* renamed from: b, reason: collision with root package name */
    private final Set f615b;

    /* renamed from: c, reason: collision with root package name */
    private final Handler f616c;

    /* renamed from: d, reason: collision with root package name */
    private volatile j f617d;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (k.this.f617d == null) {
                return;
            }
            j jVar = k.this.f617d;
            if (jVar.b() != null) {
                k.this.i(jVar.b());
            } else {
                k.this.g(jVar.a());
            }
        }
    }

    private class b extends FutureTask {
        b(Callable callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            if (isCancelled()) {
                return;
            }
            try {
                k.this.l((j) get());
            } catch (InterruptedException | ExecutionException e) {
                k.this.l(new j(e));
            }
        }
    }

    public k(Callable callable) {
        this(callable, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g(Throwable th) {
        ArrayList arrayList = new ArrayList(this.f615b);
        if (arrayList.isEmpty()) {
            c0.f.c("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g) it.next()).a(th);
        }
    }

    private void h() {
        this.f616c.post(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void i(Object obj) {
        Iterator it = new ArrayList(this.f614a).iterator();
        while (it.hasNext()) {
            ((g) it.next()).a(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(j jVar) {
        if (this.f617d != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.f617d = jVar;
        h();
    }

    public synchronized k e(g gVar) {
        try {
            if (this.f617d != null && this.f617d.a() != null) {
                gVar.a(this.f617d.a());
            }
            this.f615b.add(gVar);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public synchronized k f(g gVar) {
        try {
            if (this.f617d != null && this.f617d.b() != null) {
                gVar.a(this.f617d.b());
            }
            this.f614a.add(gVar);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public synchronized k j(g gVar) {
        this.f615b.remove(gVar);
        return this;
    }

    public synchronized k k(g gVar) {
        this.f614a.remove(gVar);
        return this;
    }

    k(Callable callable, boolean z2) {
        this.f614a = new LinkedHashSet(1);
        this.f615b = new LinkedHashSet(1);
        this.f616c = new Handler(Looper.getMainLooper());
        this.f617d = null;
        if (!z2) {
            e.execute(new b(callable));
            return;
        }
        try {
            l((j) callable.call());
        } catch (Throwable th) {
            l(new j(th));
        }
    }
}
