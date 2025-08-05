package j;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class d extends e {

    /* renamed from: a, reason: collision with root package name */
    private final Object f6483a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final ExecutorService f6484b = Executors.newFixedThreadPool(4, new a());

    /* renamed from: c, reason: collision with root package name */
    private volatile Handler f6485c;

    class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f6486a = new AtomicInteger(0);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("arch_disk_io_" + this.f6486a.getAndIncrement());
            return thread;
        }
    }

    private static class b {
        public static Handler a(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    private static Handler d(Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return b.a(looper);
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            return new Handler(looper);
        } catch (InvocationTargetException unused2) {
            return new Handler(looper);
        }
    }

    @Override // j.e
    public void a(Runnable runnable) {
        this.f6484b.execute(runnable);
    }

    @Override // j.e
    public boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    @Override // j.e
    public void c(Runnable runnable) {
        if (this.f6485c == null) {
            synchronized (this.f6483a) {
                try {
                    if (this.f6485c == null) {
                        this.f6485c = d(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        this.f6485c.post(runnable);
    }
}
