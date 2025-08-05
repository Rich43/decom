package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.manager.TargetTracker;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.net.URL;
import java.util.Iterator;

/* loaded from: classes.dex */
public class RequestManager implements LifecycleListener, ModelTypes<RequestBuilder<Drawable>> {
    private static final RequestOptions DECODE_TYPE_BITMAP = RequestOptions.decodeTypeOf(Bitmap.class).lock();
    private static final RequestOptions DECODE_TYPE_GIF = RequestOptions.decodeTypeOf(GifDrawable.class).lock();
    private static final RequestOptions DOWNLOAD_ONLY_OPTIONS = RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.DATA).priority(Priority.LOW).skipMemoryCache(true);
    private final Runnable addSelfToLifecycle;
    private final ConnectivityMonitor connectivityMonitor;
    protected final Context context;
    protected final Glide glide;
    final Lifecycle lifecycle;
    private final Handler mainHandler;
    private RequestOptions requestOptions;
    private final RequestTracker requestTracker;
    private final TargetTracker targetTracker;
    private final RequestManagerTreeNode treeNode;

    /* renamed from: com.bumptech.glide.RequestManager$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RequestManager requestManager = RequestManager.this;
            requestManager.lifecycle.addListener(requestManager);
        }
    }

    /* renamed from: com.bumptech.glide.RequestManager$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ Target val$target;

        AnonymousClass2(Target target) {
            target = target;
        }

        @Override // java.lang.Runnable
        public void run() {
            RequestManager.this.clear(target);
        }
    }

    private static class ClearTarget extends ViewTarget<View, Object> {
        ClearTarget(View view) {
            super(view);
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(Object obj, Transition<? super Object> transition) {
        }
    }

    private static class RequestManagerConnectivityListener implements ConnectivityMonitor.ConnectivityListener {
        private final RequestTracker requestTracker;

        RequestManagerConnectivityListener(RequestTracker requestTracker) {
            this.requestTracker = requestTracker;
        }

        @Override // com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener
        public void onConnectivityChanged(boolean z2) {
            if (z2) {
                this.requestTracker.restartRequests();
            }
        }
    }

    public RequestManager(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context) {
        this(glide, lifecycle, requestManagerTreeNode, new RequestTracker(), glide.getConnectivityMonitorFactory(), context);
    }

    private void untrackOrDelegate(Target<?> target) {
        if (untrack(target) || this.glide.removeFromManagers(target) || target.getRequest() == null) {
            return;
        }
        Request request = target.getRequest();
        target.setRequest(null);
        request.clear();
    }

    private void updateRequestOptions(RequestOptions requestOptions) {
        this.requestOptions = this.requestOptions.apply(requestOptions);
    }

    public RequestManager applyDefaultRequestOptions(RequestOptions requestOptions) {
        updateRequestOptions(requestOptions);
        return this;
    }

    public <ResourceType> RequestBuilder<ResourceType> as(Class<ResourceType> cls) {
        return new RequestBuilder<>(this.glide, this, cls, this.context);
    }

    public RequestBuilder<Bitmap> asBitmap() {
        return as(Bitmap.class).apply(DECODE_TYPE_BITMAP);
    }

    public RequestBuilder<Drawable> asDrawable() {
        return as(Drawable.class);
    }

    public RequestBuilder<File> asFile() {
        return as(File.class).apply(RequestOptions.skipMemoryCacheOf(true));
    }

    public RequestBuilder<GifDrawable> asGif() {
        return as(GifDrawable.class).apply(DECODE_TYPE_GIF);
    }

    public void clear(View view) {
        clear(new ClearTarget(view));
    }

    public RequestBuilder<File> download(Object obj) {
        return downloadOnly().load(obj);
    }

    public RequestBuilder<File> downloadOnly() {
        return as(File.class).apply(DOWNLOAD_ONLY_OPTIONS);
    }

    RequestOptions getDefaultRequestOptions() {
        return this.requestOptions;
    }

    <T> TransitionOptions<?, T> getDefaultTransitionOptions(Class<T> cls) {
        return this.glide.getGlideContext().getDefaultTransitionOptions(cls);
    }

    public boolean isPaused() {
        Util.assertMainThread();
        return this.requestTracker.isPaused();
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
        this.targetTracker.onDestroy();
        Iterator<Target<?>> it = this.targetTracker.getAll().iterator();
        while (it.hasNext()) {
            clear(it.next());
        }
        this.targetTracker.clear();
        this.requestTracker.clearRequests();
        this.lifecycle.removeListener(this);
        this.lifecycle.removeListener(this.connectivityMonitor);
        this.mainHandler.removeCallbacks(this.addSelfToLifecycle);
        this.glide.unregisterRequestManager(this);
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        resumeRequests();
        this.targetTracker.onStart();
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        pauseRequests();
        this.targetTracker.onStop();
    }

    public void pauseAllRequests() {
        Util.assertMainThread();
        this.requestTracker.pauseAllRequests();
    }

    public void pauseRequests() {
        Util.assertMainThread();
        this.requestTracker.pauseRequests();
    }

    public void pauseRequestsRecursive() {
        Util.assertMainThread();
        pauseRequests();
        Iterator<RequestManager> it = this.treeNode.getDescendants().iterator();
        while (it.hasNext()) {
            it.next().pauseRequests();
        }
    }

    public void resumeRequests() {
        Util.assertMainThread();
        this.requestTracker.resumeRequests();
    }

    public void resumeRequestsRecursive() {
        Util.assertMainThread();
        resumeRequests();
        Iterator<RequestManager> it = this.treeNode.getDescendants().iterator();
        while (it.hasNext()) {
            it.next().resumeRequests();
        }
    }

    public RequestManager setDefaultRequestOptions(RequestOptions requestOptions) {
        setRequestOptions(requestOptions);
        return this;
    }

    protected void setRequestOptions(RequestOptions requestOptions) {
        this.requestOptions = requestOptions.m2clone().autoClone();
    }

    public String toString() {
        return super.toString() + "{tracker=" + this.requestTracker + ", treeNode=" + this.treeNode + "}";
    }

    void track(Target<?> target, Request request) {
        this.targetTracker.track(target);
        this.requestTracker.runRequest(request);
    }

    boolean untrack(Target<?> target) {
        Request request = target.getRequest();
        if (request == null) {
            return true;
        }
        if (!this.requestTracker.clearRemoveAndRecycle(request)) {
            return false;
        }
        this.targetTracker.untrack(target);
        target.setRequest(null);
        return true;
    }

    public void clear(Target<?> target) {
        if (target == null) {
            return;
        }
        if (Util.isOnMainThread()) {
            untrackOrDelegate(target);
        } else {
            this.mainHandler.post(new Runnable() { // from class: com.bumptech.glide.RequestManager.2
                final /* synthetic */ Target val$target;

                AnonymousClass2(Target target2) {
                    target = target2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    RequestManager.this.clear(target);
                }
            });
        }
    }

    RequestManager(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, RequestTracker requestTracker, ConnectivityMonitorFactory connectivityMonitorFactory, Context context) {
        this.targetTracker = new TargetTracker();
        AnonymousClass1 anonymousClass1 = new Runnable() { // from class: com.bumptech.glide.RequestManager.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                RequestManager requestManager = RequestManager.this;
                requestManager.lifecycle.addListener(requestManager);
            }
        };
        this.addSelfToLifecycle = anonymousClass1;
        Handler handler = new Handler(Looper.getMainLooper());
        this.mainHandler = handler;
        this.glide = glide;
        this.lifecycle = lifecycle;
        this.treeNode = requestManagerTreeNode;
        this.requestTracker = requestTracker;
        this.context = context;
        ConnectivityMonitor connectivityMonitorBuild = connectivityMonitorFactory.build(context.getApplicationContext(), new RequestManagerConnectivityListener(requestTracker));
        this.connectivityMonitor = connectivityMonitorBuild;
        if (Util.isOnBackgroundThread()) {
            handler.post(anonymousClass1);
        } else {
            lifecycle.addListener(this);
        }
        lifecycle.addListener(connectivityMonitorBuild);
        setRequestOptions(glide.getGlideContext().getDefaultRequestOptions());
        glide.registerRequestManager(this);
    }

    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(Bitmap bitmap) {
        return asDrawable().load(bitmap);
    }

    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(Drawable drawable) {
        return asDrawable().load(drawable);
    }

    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(String str) {
        return asDrawable().load(str);
    }

    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(Uri uri) {
        return asDrawable().load(uri);
    }

    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(File file) {
        return asDrawable().load(file);
    }

    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(Integer num) {
        return asDrawable().load(num);
    }

    @Override // com.bumptech.glide.ModelTypes
    @Deprecated
    public RequestBuilder<Drawable> load(URL url) {
        return asDrawable().load(url);
    }

    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(byte[] bArr) {
        return asDrawable().load(bArr);
    }

    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<Drawable> load(Object obj) {
        return asDrawable().load(obj);
    }
}
