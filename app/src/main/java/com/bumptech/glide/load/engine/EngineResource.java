package com.bumptech.glide.load.engine;

import android.os.Looper;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;

/* loaded from: classes.dex */
class EngineResource<Z> implements Resource<Z> {
    private int acquired;
    private final boolean isCacheable;
    private final boolean isRecyclable;
    private boolean isRecycled;
    private Key key;
    private ResourceListener listener;
    private final Resource<Z> resource;

    interface ResourceListener {
        void onResourceReleased(Key key, EngineResource<?> engineResource);
    }

    EngineResource(Resource<Z> resource, boolean z2, boolean z3) {
        this.resource = (Resource) Preconditions.checkNotNull(resource);
        this.isCacheable = z2;
        this.isRecyclable = z3;
    }

    void acquire() {
        if (this.isRecycled) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        if (!Looper.getMainLooper().equals(Looper.myLooper())) {
            throw new IllegalThreadStateException("Must call acquire on the main thread");
        }
        this.acquired++;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Z get() {
        return this.resource.get();
    }

    Resource<Z> getResource() {
        return this.resource;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Class<Z> getResourceClass() {
        return this.resource.getResourceClass();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.resource.getSize();
    }

    boolean isCacheable() {
        return this.isCacheable;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
        if (this.acquired > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.isRecycled) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.isRecycled = true;
        if (this.isRecyclable) {
            this.resource.recycle();
        }
    }

    void release() {
        if (this.acquired <= 0) {
            throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
        }
        if (!Looper.getMainLooper().equals(Looper.myLooper())) {
            throw new IllegalThreadStateException("Must call release on the main thread");
        }
        int i2 = this.acquired - 1;
        this.acquired = i2;
        if (i2 == 0) {
            this.listener.onResourceReleased(this.key, this);
        }
    }

    void setResourceListener(Key key, ResourceListener resourceListener) {
        this.key = key;
        this.listener = resourceListener;
    }

    public String toString() {
        return "EngineResource{isCacheable=" + this.isCacheable + ", listener=" + this.listener + ", key=" + this.key + ", acquired=" + this.acquired + ", isRecycled=" + this.isRecycled + ", resource=" + this.resource + '}';
    }
}
