package androidx.concurrent.futures;

import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class a implements Future {

    /* renamed from: d, reason: collision with root package name */
    static final boolean f2625d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    private static final Logger e = Logger.getLogger(a.class.getName());

    /* renamed from: f, reason: collision with root package name */
    static final b f2626f;

    /* renamed from: g, reason: collision with root package name */
    private static final Object f2627g;

    /* renamed from: a, reason: collision with root package name */
    volatile Object f2628a;

    /* renamed from: b, reason: collision with root package name */
    volatile e f2629b;

    /* renamed from: c, reason: collision with root package name */
    volatile h f2630c;

    private static abstract class b {
        private b() {
        }

        abstract boolean a(a aVar, e eVar, e eVar2);

        abstract boolean b(a aVar, Object obj, Object obj2);

        abstract boolean c(a aVar, h hVar, h hVar2);

        abstract void d(h hVar, h hVar2);

        abstract void e(h hVar, Thread thread);
    }

    private static final class c {

        /* renamed from: c, reason: collision with root package name */
        static final c f2631c;

        /* renamed from: d, reason: collision with root package name */
        static final c f2632d;

        /* renamed from: a, reason: collision with root package name */
        final boolean f2633a;

        /* renamed from: b, reason: collision with root package name */
        final Throwable f2634b;

        static {
            if (a.f2625d) {
                f2632d = null;
                f2631c = null;
            } else {
                f2632d = new c(false, null);
                f2631c = new c(true, null);
            }
        }

        c(boolean z2, Throwable th) {
            this.f2633a = z2;
            this.f2634b = th;
        }
    }

    private static final class d {

        /* renamed from: a, reason: collision with root package name */
        final Throwable f2635a;
    }

    private static final class e {

        /* renamed from: d, reason: collision with root package name */
        static final e f2636d = new e(null, null);

        /* renamed from: a, reason: collision with root package name */
        final Runnable f2637a;

        /* renamed from: b, reason: collision with root package name */
        final Executor f2638b;

        /* renamed from: c, reason: collision with root package name */
        e f2639c;

        e(Runnable runnable, Executor executor) {
            this.f2637a = runnable;
            this.f2638b = executor;
        }
    }

    private static final class f extends b {

        /* renamed from: a, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f2640a;

        /* renamed from: b, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f2641b;

        /* renamed from: c, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f2642c;

        /* renamed from: d, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f2643d;
        final AtomicReferenceFieldUpdater e;

        f(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super();
            this.f2640a = atomicReferenceFieldUpdater;
            this.f2641b = atomicReferenceFieldUpdater2;
            this.f2642c = atomicReferenceFieldUpdater3;
            this.f2643d = atomicReferenceFieldUpdater4;
            this.e = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.concurrent.futures.a.b
        boolean a(a aVar, e eVar, e eVar2) {
            return androidx.concurrent.futures.b.a(this.f2643d, aVar, eVar, eVar2);
        }

        @Override // androidx.concurrent.futures.a.b
        boolean b(a aVar, Object obj, Object obj2) {
            return androidx.concurrent.futures.b.a(this.e, aVar, obj, obj2);
        }

        @Override // androidx.concurrent.futures.a.b
        boolean c(a aVar, h hVar, h hVar2) {
            return androidx.concurrent.futures.b.a(this.f2642c, aVar, hVar, hVar2);
        }

        @Override // androidx.concurrent.futures.a.b
        void d(h hVar, h hVar2) {
            this.f2641b.lazySet(hVar, hVar2);
        }

        @Override // androidx.concurrent.futures.a.b
        void e(h hVar, Thread thread) {
            this.f2640a.lazySet(hVar, thread);
        }
    }

    private static final class g extends b {
        g() {
            super();
        }

        @Override // androidx.concurrent.futures.a.b
        boolean a(a aVar, e eVar, e eVar2) {
            synchronized (aVar) {
                try {
                    if (aVar.f2629b != eVar) {
                        return false;
                    }
                    aVar.f2629b = eVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.a.b
        boolean b(a aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                try {
                    if (aVar.f2628a != obj) {
                        return false;
                    }
                    aVar.f2628a = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.a.b
        boolean c(a aVar, h hVar, h hVar2) {
            synchronized (aVar) {
                try {
                    if (aVar.f2630c != hVar) {
                        return false;
                    }
                    aVar.f2630c = hVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.a.b
        void d(h hVar, h hVar2) {
            hVar.f2646b = hVar2;
        }

        @Override // androidx.concurrent.futures.a.b
        void e(h hVar, Thread thread) {
            hVar.f2645a = thread;
        }
    }

    private static final class h {

        /* renamed from: c, reason: collision with root package name */
        static final h f2644c = new h(false);

        /* renamed from: a, reason: collision with root package name */
        volatile Thread f2645a;

        /* renamed from: b, reason: collision with root package name */
        volatile h f2646b;

        h(boolean z2) {
        }

        void a(h hVar) {
            a.f2626f.d(this, hVar);
        }

        void b() {
            Thread thread = this.f2645a;
            if (thread != null) {
                this.f2645a = null;
                LockSupport.unpark(thread);
            }
        }

        h() {
            a.f2626f.e(this, Thread.currentThread());
        }
    }

    static {
        b gVar;
        try {
            gVar = new f(AtomicReferenceFieldUpdater.newUpdater(h.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(h.class, h.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, h.class, "c"), AtomicReferenceFieldUpdater.newUpdater(a.class, e.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "a"));
            th = null;
        } catch (Throwable th) {
            th = th;
            gVar = new g();
        }
        f2626f = gVar;
        if (th != null) {
            e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f2627g = new Object();
    }

    protected a() {
    }

    private void a(StringBuilder sb) {
        try {
            Object objH = h(this);
            sb.append("SUCCESS, result=[");
            sb.append(n(objH));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e3) {
            sb.append("FAILURE, cause=[");
            sb.append(e3.getCause());
            sb.append("]");
        }
    }

    private static CancellationException c(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    private e d(e eVar) {
        e eVar2;
        do {
            eVar2 = this.f2629b;
        } while (!f2626f.a(this, eVar2, e.f2636d));
        e eVar3 = eVar;
        e eVar4 = eVar2;
        while (eVar4 != null) {
            e eVar5 = eVar4.f2639c;
            eVar4.f2639c = eVar3;
            eVar3 = eVar4;
            eVar4 = eVar5;
        }
        return eVar3;
    }

    static void e(a aVar) {
        aVar.k();
        aVar.b();
        e eVarD = aVar.d(null);
        while (eVarD != null) {
            e eVar = eVarD.f2639c;
            f(eVarD.f2637a, eVarD.f2638b);
            eVarD = eVar;
        }
    }

    private static void f(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            e.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    private Object g(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            throw c("Task was cancelled.", ((c) obj).f2634b);
        }
        if (obj instanceof d) {
            throw new ExecutionException(((d) obj).f2635a);
        }
        if (obj == f2627g) {
            return null;
        }
        return obj;
    }

    static Object h(Future future) {
        Object obj;
        boolean z2 = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z2 = true;
            } catch (Throwable th) {
                if (z2) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    private void k() {
        h hVar;
        do {
            hVar = this.f2630c;
        } while (!f2626f.c(this, hVar, h.f2644c));
        while (hVar != null) {
            hVar.b();
            hVar = hVar.f2646b;
        }
    }

    private void l(h hVar) {
        hVar.f2645a = null;
        while (true) {
            h hVar2 = this.f2630c;
            if (hVar2 == h.f2644c) {
                return;
            }
            h hVar3 = null;
            while (hVar2 != null) {
                h hVar4 = hVar2.f2646b;
                if (hVar2.f2645a != null) {
                    hVar3 = hVar2;
                } else if (hVar3 != null) {
                    hVar3.f2646b = hVar4;
                    if (hVar3.f2645a == null) {
                        break;
                    }
                } else if (!f2626f.c(this, hVar2, hVar4)) {
                    break;
                }
                hVar2 = hVar4;
            }
            return;
        }
    }

    private String n(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    protected void b() {
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z2) {
        Object obj = this.f2628a;
        if (obj == null) {
            if (f2626f.b(this, obj, f2625d ? new c(z2, new CancellationException("Future.cancel() was called.")) : z2 ? c.f2631c : c.f2632d)) {
                if (z2) {
                    i();
                }
                e(this);
                return true;
            }
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j2, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j2);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f2628a;
        if (obj != null) {
            return g(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            h hVar = this.f2630c;
            if (hVar != h.f2644c) {
                h hVar2 = new h();
                do {
                    hVar2.a(hVar);
                    if (f2626f.c(this, hVar, hVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                l(hVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f2628a;
                            if (obj2 != null) {
                                return g(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        l(hVar2);
                    } else {
                        hVar = this.f2630c;
                    }
                } while (hVar != h.f2644c);
            }
            return g(this.f2628a);
        }
        while (nanos > 0) {
            Object obj3 = this.f2628a;
            if (obj3 != null) {
                return g(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        String str = "Waited " + j2 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String str2 = str + " (plus ";
            long j3 = -nanos;
            long jConvert = timeUnit.convert(j3, TimeUnit.NANOSECONDS);
            long nanos2 = j3 - timeUnit.toNanos(jConvert);
            boolean z2 = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String str3 = str2 + jConvert + " " + lowerCase;
                if (z2) {
                    str3 = str3 + ",";
                }
                str2 = str3 + " ";
            }
            if (z2) {
                str2 = str2 + nanos2 + " nanoseconds ";
            }
            str = str2 + "delay)";
        }
        if (isDone()) {
            throw new TimeoutException(str + " but future completed as timeout expired");
        }
        throw new TimeoutException(str + " for " + string);
    }

    protected void i() {
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f2628a instanceof c;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f2628a != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected String j() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    protected boolean m(Object obj) {
        if (obj == null) {
            obj = f2627g;
        }
        if (!f2626f.b(this, null, obj)) {
            return false;
        }
        e(this);
        return true;
    }

    public String toString() {
        String strJ;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            a(sb);
        } else {
            try {
                strJ = j();
            } catch (RuntimeException e2) {
                strJ = "Exception thrown from implementation: " + e2.getClass();
            }
            if (strJ != null && !strJ.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(strJ);
                sb.append("]");
            } else if (isDone()) {
                a(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f2628a;
            if (obj2 != null) {
                return g(obj2);
            }
            h hVar = this.f2630c;
            if (hVar != h.f2644c) {
                h hVar2 = new h();
                do {
                    hVar2.a(hVar);
                    if (f2626f.c(this, hVar, hVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f2628a;
                            } else {
                                l(hVar2);
                                throw new InterruptedException();
                            }
                        } while (!(obj != null));
                        return g(obj);
                    }
                    hVar = this.f2630c;
                } while (hVar != h.f2644c);
            }
            return g(this.f2628a);
        }
        throw new InterruptedException();
    }
}
