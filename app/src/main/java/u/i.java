package u;

import android.os.Handler;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import v.InterfaceC0338a;

/* loaded from: classes.dex */
abstract class i {

    private static class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private String f7553a;

        /* renamed from: b, reason: collision with root package name */
        private int f7554b;

        /* renamed from: u.i$a$a, reason: collision with other inner class name */
        private static class C0104a extends Thread {

            /* renamed from: a, reason: collision with root package name */
            private final int f7555a;

            C0104a(Runnable runnable, String str, int i2) {
                super(runnable, str);
                this.f7555a = i2;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws SecurityException, IllegalArgumentException {
                Process.setThreadPriority(this.f7555a);
                super.run();
            }
        }

        a(String str, int i2) {
            this.f7553a = str;
            this.f7554b = i2;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C0104a(runnable, this.f7553a, this.f7554b);
        }
    }

    private static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private Callable f7556a;

        /* renamed from: b, reason: collision with root package name */
        private InterfaceC0338a f7557b;

        /* renamed from: c, reason: collision with root package name */
        private Handler f7558c;

        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ InterfaceC0338a f7559a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Object f7560b;

            a(InterfaceC0338a interfaceC0338a, Object obj) {
                this.f7559a = interfaceC0338a;
                this.f7560b = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f7559a.a(this.f7560b);
            }
        }

        b(Handler handler, Callable callable, InterfaceC0338a interfaceC0338a) {
            this.f7556a = callable;
            this.f7557b = interfaceC0338a;
            this.f7558c = handler;
        }

        @Override // java.lang.Runnable
        public void run() throws Exception {
            Object objCall;
            try {
                objCall = this.f7556a.call();
            } catch (Exception unused) {
                objCall = null;
            }
            this.f7558c.post(new a(this.f7557b, objCall));
        }
    }

    static ThreadPoolExecutor a(String str, int i2, int i3) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, i3, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new a(str, i2));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    static void b(Executor executor, Callable callable, InterfaceC0338a interfaceC0338a) {
        executor.execute(new b(AbstractC0330b.a(), callable, interfaceC0338a));
    }

    static Object c(ExecutorService executorService, Callable callable, int i2) throws InterruptedException {
        try {
            return executorService.submit(callable).get(i2, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw e;
        } catch (ExecutionException e2) {
            throw new RuntimeException(e2);
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
