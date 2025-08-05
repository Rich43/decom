package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public class RequestFutureTarget<R> implements FutureTarget<R>, RequestListener<R>, Runnable {
    private static final Waiter DEFAULT_WAITER = new Waiter();
    private final boolean assertBackgroundThread;
    private GlideException exception;
    private final int height;
    private boolean isCancelled;
    private boolean loadFailed;
    private final Handler mainHandler;
    private Request request;
    private R resource;
    private boolean resultReceived;
    private final Waiter waiter;
    private final int width;

    static class Waiter {
        Waiter() {
        }

        void notifyAll(Object obj) {
            obj.notifyAll();
        }

        void waitForTimeout(Object obj, long j2) throws InterruptedException {
            obj.wait(j2);
        }
    }

    public RequestFutureTarget(Handler handler, int i2, int i3) {
        this(handler, i2, i3, true, DEFAULT_WAITER);
    }

    private void clearOnMainThread() {
        this.mainHandler.post(this);
    }

    private synchronized R doGet(Long l2) {
        try {
            if (this.assertBackgroundThread && !isDone()) {
                Util.assertBackgroundThread();
            }
            if (this.isCancelled) {
                throw new CancellationException();
            }
            if (this.loadFailed) {
                throw new ExecutionException(this.exception);
            }
            if (this.resultReceived) {
                return this.resource;
            }
            if (l2 == null) {
                this.waiter.waitForTimeout(this, 0L);
            } else if (l2.longValue() > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                long jLongValue = l2.longValue() + jCurrentTimeMillis;
                while (!isDone() && jCurrentTimeMillis < jLongValue) {
                    this.waiter.waitForTimeout(this, jLongValue - jCurrentTimeMillis);
                    jCurrentTimeMillis = System.currentTimeMillis();
                }
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            if (this.loadFailed) {
                throw new ExecutionException(this.exception);
            }
            if (this.isCancelled) {
                throw new CancellationException();
            }
            if (!this.resultReceived) {
                throw new TimeoutException();
            }
            return this.resource;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z2) {
        if (isDone()) {
            return false;
        }
        this.isCancelled = true;
        this.waiter.notifyAll(this);
        if (z2) {
            clearOnMainThread();
        }
        return true;
    }

    @Override // java.util.concurrent.Future
    public R get() {
        try {
            return doGet(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public Request getRequest() {
        return this.request;
    }

    @Override // com.bumptech.glide.request.target.Target
    public void getSize(SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.onSizeReady(this.width, this.height);
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.isCancelled;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0012  */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean isDone() {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.isCancelled     // Catch: java.lang.Throwable -> L10
            if (r0 != 0) goto L12
            boolean r0 = r1.resultReceived     // Catch: java.lang.Throwable -> L10
            if (r0 != 0) goto L12
            boolean r0 = r1.loadFailed     // Catch: java.lang.Throwable -> L10
            if (r0 == 0) goto Le
            goto L12
        Le:
            r0 = 0
            goto L13
        L10:
            r0 = move-exception
            goto L15
        L12:
            r0 = 1
        L13:
            monitor-exit(r1)
            return r0
        L15:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L10
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.RequestFutureTarget.isDone():boolean");
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void onLoadFailed(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadStarted(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void onResourceReady(R r, Transition<? super R> transition) {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void removeCallback(SizeReadyCallback sizeReadyCallback) {
    }

    @Override // java.lang.Runnable
    public void run() {
        Request request = this.request;
        if (request != null) {
            request.clear();
            this.request = null;
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public void setRequest(Request request) {
        this.request = request;
    }

    RequestFutureTarget(Handler handler, int i2, int i3, boolean z2, Waiter waiter) {
        this.mainHandler = handler;
        this.width = i2;
        this.height = i3;
        this.assertBackgroundThread = z2;
        this.waiter = waiter;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public synchronized boolean onLoadFailed(GlideException glideException, Object obj, Target<R> target, boolean z2) {
        this.loadFailed = true;
        this.exception = glideException;
        this.waiter.notifyAll(this);
        return false;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public synchronized boolean onResourceReady(R r, Object obj, Target<R> target, DataSource dataSource, boolean z2) {
        this.resultReceived = true;
        this.resource = r;
        this.waiter.notifyAll(this);
        return false;
    }

    @Override // java.util.concurrent.Future
    public R get(long j2, TimeUnit timeUnit) {
        return doGet(Long.valueOf(timeUnit.toMillis(j2)));
    }
}
