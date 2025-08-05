package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.List;
import v.InterfaceC0342e;

/* loaded from: classes.dex */
class EngineJob<R> implements DecodeJob.Callback<R>, FactoryPools.Poolable {
    private static final EngineResourceFactory DEFAULT_FACTORY = new EngineResourceFactory();
    private static final Handler MAIN_THREAD_HANDLER = new Handler(Looper.getMainLooper(), new MainThreadCallback());
    private static final int MSG_CANCELLED = 3;
    private static final int MSG_COMPLETE = 1;
    private static final int MSG_EXCEPTION = 2;
    private final GlideExecutor animationExecutor;
    private final List<ResourceCallback> cbs;
    private DataSource dataSource;
    private DecodeJob<R> decodeJob;
    private final GlideExecutor diskCacheExecutor;
    private EngineResource<?> engineResource;
    private final EngineResourceFactory engineResourceFactory;
    private GlideException exception;
    private boolean hasLoadFailed;
    private boolean hasResource;
    private List<ResourceCallback> ignoredCallbacks;
    private boolean isCacheable;
    private volatile boolean isCancelled;
    private Key key;
    private final EngineJobListener listener;
    private boolean onlyRetrieveFromCache;
    private final InterfaceC0342e pool;
    private Resource<?> resource;
    private final GlideExecutor sourceExecutor;
    private final GlideExecutor sourceUnlimitedExecutor;
    private final StateVerifier stateVerifier;
    private boolean useAnimationPool;
    private boolean useUnlimitedSourceGeneratorPool;

    static class EngineResourceFactory {
        EngineResourceFactory() {
        }

        public <R> EngineResource<R> build(Resource<R> resource, boolean z2) {
            return new EngineResource<>(resource, z2, true);
        }
    }

    private static class MainThreadCallback implements Handler.Callback {
        MainThreadCallback() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            EngineJob engineJob = (EngineJob) message.obj;
            int i2 = message.what;
            if (i2 == 1) {
                engineJob.handleResultOnMainThread();
            } else if (i2 == 2) {
                engineJob.handleExceptionOnMainThread();
            } else {
                if (i2 != 3) {
                    throw new IllegalStateException("Unrecognized message: " + message.what);
                }
                engineJob.handleCancelledOnMainThread();
            }
            return true;
        }
    }

    EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, InterfaceC0342e interfaceC0342e) {
        this(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, engineJobListener, interfaceC0342e, DEFAULT_FACTORY);
    }

    private void addIgnoredCallback(ResourceCallback resourceCallback) {
        if (this.ignoredCallbacks == null) {
            this.ignoredCallbacks = new ArrayList(2);
        }
        if (this.ignoredCallbacks.contains(resourceCallback)) {
            return;
        }
        this.ignoredCallbacks.add(resourceCallback);
    }

    private GlideExecutor getActiveSourceExecutor() {
        return this.useUnlimitedSourceGeneratorPool ? this.sourceUnlimitedExecutor : this.useAnimationPool ? this.animationExecutor : this.sourceExecutor;
    }

    private boolean isInIgnoredCallbacks(ResourceCallback resourceCallback) {
        List<ResourceCallback> list = this.ignoredCallbacks;
        return list != null && list.contains(resourceCallback);
    }

    private void release(boolean z2) {
        Util.assertMainThread();
        this.cbs.clear();
        this.key = null;
        this.engineResource = null;
        this.resource = null;
        List<ResourceCallback> list = this.ignoredCallbacks;
        if (list != null) {
            list.clear();
        }
        this.hasLoadFailed = false;
        this.isCancelled = false;
        this.hasResource = false;
        this.decodeJob.release(z2);
        this.decodeJob = null;
        this.exception = null;
        this.dataSource = null;
        this.pool.release(this);
    }

    void addCallback(ResourceCallback resourceCallback) {
        Util.assertMainThread();
        this.stateVerifier.throwIfRecycled();
        if (this.hasResource) {
            resourceCallback.onResourceReady(this.engineResource, this.dataSource);
        } else if (this.hasLoadFailed) {
            resourceCallback.onLoadFailed(this.exception);
        } else {
            this.cbs.add(resourceCallback);
        }
    }

    void cancel() {
        if (this.hasLoadFailed || this.hasResource || this.isCancelled) {
            return;
        }
        this.isCancelled = true;
        this.decodeJob.cancel();
        this.listener.onEngineJobCancelled(this, this.key);
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    public StateVerifier getVerifier() {
        return this.stateVerifier;
    }

    void handleCancelledOnMainThread() {
        this.stateVerifier.throwIfRecycled();
        if (!this.isCancelled) {
            throw new IllegalStateException("Not cancelled");
        }
        this.listener.onEngineJobCancelled(this, this.key);
        release(false);
    }

    void handleExceptionOnMainThread() {
        this.stateVerifier.throwIfRecycled();
        if (this.isCancelled) {
            release(false);
            return;
        }
        if (this.cbs.isEmpty()) {
            throw new IllegalStateException("Received an exception without any callbacks to notify");
        }
        if (this.hasLoadFailed) {
            throw new IllegalStateException("Already failed once");
        }
        this.hasLoadFailed = true;
        this.listener.onEngineJobComplete(this, this.key, null);
        for (ResourceCallback resourceCallback : this.cbs) {
            if (!isInIgnoredCallbacks(resourceCallback)) {
                resourceCallback.onLoadFailed(this.exception);
            }
        }
        release(false);
    }

    void handleResultOnMainThread() {
        this.stateVerifier.throwIfRecycled();
        if (this.isCancelled) {
            this.resource.recycle();
            release(false);
            return;
        }
        if (this.cbs.isEmpty()) {
            throw new IllegalStateException("Received a resource without any callbacks to notify");
        }
        if (this.hasResource) {
            throw new IllegalStateException("Already have resource");
        }
        EngineResource<?> engineResourceBuild = this.engineResourceFactory.build(this.resource, this.isCacheable);
        this.engineResource = engineResourceBuild;
        this.hasResource = true;
        engineResourceBuild.acquire();
        this.listener.onEngineJobComplete(this, this.key, this.engineResource);
        int size = this.cbs.size();
        for (int i2 = 0; i2 < size; i2++) {
            ResourceCallback resourceCallback = this.cbs.get(i2);
            if (!isInIgnoredCallbacks(resourceCallback)) {
                this.engineResource.acquire();
                resourceCallback.onResourceReady(this.engineResource, this.dataSource);
            }
        }
        this.engineResource.release();
        release(false);
    }

    EngineJob<R> init(Key key, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.key = key;
        this.isCacheable = z2;
        this.useUnlimitedSourceGeneratorPool = z3;
        this.useAnimationPool = z4;
        this.onlyRetrieveFromCache = z5;
        return this;
    }

    boolean isCancelled() {
        return this.isCancelled;
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void onLoadFailed(GlideException glideException) {
        this.exception = glideException;
        MAIN_THREAD_HANDLER.obtainMessage(2, this).sendToTarget();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void onResourceReady(Resource<R> resource, DataSource dataSource) {
        this.resource = resource;
        this.dataSource = dataSource;
        MAIN_THREAD_HANDLER.obtainMessage(1, this).sendToTarget();
    }

    boolean onlyRetrieveFromCache() {
        return this.onlyRetrieveFromCache;
    }

    void removeCallback(ResourceCallback resourceCallback) {
        Util.assertMainThread();
        this.stateVerifier.throwIfRecycled();
        if (this.hasResource || this.hasLoadFailed) {
            addIgnoredCallback(resourceCallback);
            return;
        }
        this.cbs.remove(resourceCallback);
        if (this.cbs.isEmpty()) {
            cancel();
        }
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void reschedule(DecodeJob<?> decodeJob) {
        getActiveSourceExecutor().execute(decodeJob);
    }

    public void start(DecodeJob<R> decodeJob) {
        this.decodeJob = decodeJob;
        (decodeJob.willDecodeFromCache() ? this.diskCacheExecutor : getActiveSourceExecutor()).execute(decodeJob);
    }

    EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, InterfaceC0342e interfaceC0342e, EngineResourceFactory engineResourceFactory) {
        this.cbs = new ArrayList(2);
        this.stateVerifier = StateVerifier.newInstance();
        this.diskCacheExecutor = glideExecutor;
        this.sourceExecutor = glideExecutor2;
        this.sourceUnlimitedExecutor = glideExecutor3;
        this.animationExecutor = glideExecutor4;
        this.listener = engineJobListener;
        this.pool = interfaceC0342e;
        this.engineResourceFactory = engineResourceFactory;
    }
}
