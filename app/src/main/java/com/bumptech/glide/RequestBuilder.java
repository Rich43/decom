package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.ErrorRequestCoordinator;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.RequestFutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.request.ThumbnailRequestCoordinator;
import com.bumptech.glide.request.target.PreloadTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.signature.ApplicationVersionSignature;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.net.URL;

/* loaded from: classes.dex */
public class RequestBuilder<TranscodeType> implements Cloneable, ModelTypes<RequestBuilder<TranscodeType>> {
    protected static final RequestOptions DOWNLOAD_ONLY_OPTIONS = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.DATA).priority(Priority.LOW).skipMemoryCache(true);
    private final Context context;
    private final RequestOptions defaultRequestOptions;
    private RequestBuilder<TranscodeType> errorBuilder;
    private final Glide glide;
    private final GlideContext glideContext;
    private boolean isDefaultTransitionOptionsSet;
    private boolean isModelSet;
    private boolean isThumbnailBuilt;
    private Object model;
    private RequestListener<TranscodeType> requestListener;
    private final RequestManager requestManager;
    protected RequestOptions requestOptions;
    private Float thumbSizeMultiplier;
    private RequestBuilder<TranscodeType> thumbnailBuilder;
    private final Class<TranscodeType> transcodeClass;
    private TransitionOptions<?, ? super TranscodeType> transitionOptions;

    /* renamed from: com.bumptech.glide.RequestBuilder$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ RequestFutureTarget val$target;

        AnonymousClass1(RequestFutureTarget requestFutureTarget) {
            requestFutureTarget = requestFutureTarget;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (requestFutureTarget.isCancelled()) {
                return;
            }
            RequestBuilder requestBuilder = RequestBuilder.this;
            RequestFutureTarget requestFutureTarget = requestFutureTarget;
            requestBuilder.into((RequestBuilder) requestFutureTarget, (RequestListener) requestFutureTarget);
        }
    }

    /* renamed from: com.bumptech.glide.RequestBuilder$2 */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType;
        static final /* synthetic */ int[] $SwitchMap$com$bumptech$glide$Priority;

        static {
            int[] iArr = new int[Priority.values().length];
            $SwitchMap$com$bumptech$glide$Priority = iArr;
            try {
                iArr[Priority.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bumptech$glide$Priority[Priority.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bumptech$glide$Priority[Priority.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$bumptech$glide$Priority[Priority.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            $SwitchMap$android$widget$ImageView$ScaleType = iArr2;
            try {
                iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    protected RequestBuilder(Glide glide, RequestManager requestManager, Class<TranscodeType> cls, Context context) {
        this.isDefaultTransitionOptionsSet = true;
        this.glide = glide;
        this.requestManager = requestManager;
        this.transcodeClass = cls;
        RequestOptions defaultRequestOptions = requestManager.getDefaultRequestOptions();
        this.defaultRequestOptions = defaultRequestOptions;
        this.context = context;
        this.transitionOptions = requestManager.getDefaultTransitionOptions(cls);
        this.requestOptions = defaultRequestOptions;
        this.glideContext = glide.getGlideContext();
    }

    private Request buildRequest(Target<TranscodeType> target, RequestListener<TranscodeType> requestListener, RequestOptions requestOptions) {
        return buildRequestRecursive(target, requestListener, null, this.transitionOptions, requestOptions.getPriority(), requestOptions.getOverrideWidth(), requestOptions.getOverrideHeight(), requestOptions);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Request buildRequestRecursive(Target<TranscodeType> target, RequestListener<TranscodeType> requestListener, RequestCoordinator requestCoordinator, TransitionOptions<?, ? super TranscodeType> transitionOptions, Priority priority, int i2, int i3, RequestOptions requestOptions) {
        RequestCoordinator requestCoordinator2;
        RequestCoordinator errorRequestCoordinator;
        if (this.errorBuilder != null) {
            errorRequestCoordinator = new ErrorRequestCoordinator(requestCoordinator);
            requestCoordinator2 = errorRequestCoordinator;
        } else {
            requestCoordinator2 = null;
            errorRequestCoordinator = requestCoordinator;
        }
        Request requestBuildThumbnailRequestRecursive = buildThumbnailRequestRecursive(target, requestListener, errorRequestCoordinator, transitionOptions, priority, i2, i3, requestOptions);
        if (requestCoordinator2 == null) {
            return requestBuildThumbnailRequestRecursive;
        }
        int overrideWidth = this.errorBuilder.requestOptions.getOverrideWidth();
        int overrideHeight = this.errorBuilder.requestOptions.getOverrideHeight();
        if (Util.isValidDimensions(i2, i3) && !this.errorBuilder.requestOptions.isValidOverride()) {
            overrideWidth = requestOptions.getOverrideWidth();
            overrideHeight = requestOptions.getOverrideHeight();
        }
        RequestBuilder<TranscodeType> requestBuilder = this.errorBuilder;
        ErrorRequestCoordinator errorRequestCoordinator2 = requestCoordinator2;
        errorRequestCoordinator2.setRequests(requestBuildThumbnailRequestRecursive, requestBuilder.buildRequestRecursive(target, requestListener, requestCoordinator2, requestBuilder.transitionOptions, requestBuilder.requestOptions.getPriority(), overrideWidth, overrideHeight, this.errorBuilder.requestOptions));
        return errorRequestCoordinator2;
    }

    private Request buildThumbnailRequestRecursive(Target<TranscodeType> target, RequestListener<TranscodeType> requestListener, RequestCoordinator requestCoordinator, TransitionOptions<?, ? super TranscodeType> transitionOptions, Priority priority, int i2, int i3, RequestOptions requestOptions) {
        RequestBuilder<TranscodeType> requestBuilder = this.thumbnailBuilder;
        if (requestBuilder == null) {
            if (this.thumbSizeMultiplier == null) {
                return obtainRequest(target, requestListener, requestOptions, requestCoordinator, transitionOptions, priority, i2, i3);
            }
            ThumbnailRequestCoordinator thumbnailRequestCoordinator = new ThumbnailRequestCoordinator(requestCoordinator);
            thumbnailRequestCoordinator.setRequests(obtainRequest(target, requestListener, requestOptions, thumbnailRequestCoordinator, transitionOptions, priority, i2, i3), obtainRequest(target, requestListener, requestOptions.m2clone().sizeMultiplier(this.thumbSizeMultiplier.floatValue()), thumbnailRequestCoordinator, transitionOptions, getThumbnailPriority(priority), i2, i3));
            return thumbnailRequestCoordinator;
        }
        if (this.isThumbnailBuilt) {
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        TransitionOptions<?, ? super TranscodeType> transitionOptions2 = requestBuilder.isDefaultTransitionOptionsSet ? transitionOptions : requestBuilder.transitionOptions;
        Priority priority2 = requestBuilder.requestOptions.isPrioritySet() ? this.thumbnailBuilder.requestOptions.getPriority() : getThumbnailPriority(priority);
        int overrideWidth = this.thumbnailBuilder.requestOptions.getOverrideWidth();
        int overrideHeight = this.thumbnailBuilder.requestOptions.getOverrideHeight();
        if (Util.isValidDimensions(i2, i3) && !this.thumbnailBuilder.requestOptions.isValidOverride()) {
            overrideWidth = requestOptions.getOverrideWidth();
            overrideHeight = requestOptions.getOverrideHeight();
        }
        ThumbnailRequestCoordinator thumbnailRequestCoordinator2 = new ThumbnailRequestCoordinator(requestCoordinator);
        Request requestObtainRequest = obtainRequest(target, requestListener, requestOptions, thumbnailRequestCoordinator2, transitionOptions, priority, i2, i3);
        this.isThumbnailBuilt = true;
        RequestBuilder<TranscodeType> requestBuilder2 = this.thumbnailBuilder;
        Request requestBuildRequestRecursive = requestBuilder2.buildRequestRecursive(target, requestListener, thumbnailRequestCoordinator2, transitionOptions2, priority2, overrideWidth, overrideHeight, requestBuilder2.requestOptions);
        this.isThumbnailBuilt = false;
        thumbnailRequestCoordinator2.setRequests(requestObtainRequest, requestBuildRequestRecursive);
        return thumbnailRequestCoordinator2;
    }

    private Priority getThumbnailPriority(Priority priority) {
        int i2 = AnonymousClass2.$SwitchMap$com$bumptech$glide$Priority[priority.ordinal()];
        if (i2 == 1) {
            return Priority.NORMAL;
        }
        if (i2 == 2) {
            return Priority.HIGH;
        }
        if (i2 == 3 || i2 == 4) {
            return Priority.IMMEDIATE;
        }
        throw new IllegalArgumentException("unknown priority: " + this.requestOptions.getPriority());
    }

    private boolean isSkipMemoryCacheWithCompletePreviousRequest(RequestOptions requestOptions, Request request) {
        return !requestOptions.isMemoryCacheable() && request.isComplete();
    }

    private RequestBuilder<TranscodeType> loadGeneric(Object obj) {
        this.model = obj;
        this.isModelSet = true;
        return this;
    }

    private Request obtainRequest(Target<TranscodeType> target, RequestListener<TranscodeType> requestListener, RequestOptions requestOptions, RequestCoordinator requestCoordinator, TransitionOptions<?, ? super TranscodeType> transitionOptions, Priority priority, int i2, int i3) {
        Context context = this.context;
        GlideContext glideContext = this.glideContext;
        return SingleRequest.obtain(context, glideContext, this.model, this.transcodeClass, requestOptions, i2, i3, priority, target, requestListener, this.requestListener, requestCoordinator, glideContext.getEngine(), transitionOptions.getTransitionFactory());
    }

    public RequestBuilder<TranscodeType> apply(RequestOptions requestOptions) {
        Preconditions.checkNotNull(requestOptions);
        this.requestOptions = getMutableOptions().apply(requestOptions);
        return this;
    }

    @Deprecated
    public <Y extends Target<File>> Y downloadOnly(Y y2) {
        return (Y) getDownloadOnlyRequest().into((RequestBuilder<File>) y2);
    }

    public RequestBuilder<TranscodeType> error(RequestBuilder<TranscodeType> requestBuilder) {
        this.errorBuilder = requestBuilder;
        return this;
    }

    protected RequestBuilder<File> getDownloadOnlyRequest() {
        return new RequestBuilder(File.class, this).apply(DOWNLOAD_ONLY_OPTIONS);
    }

    protected RequestOptions getMutableOptions() {
        RequestOptions requestOptions = this.defaultRequestOptions;
        RequestOptions requestOptions2 = this.requestOptions;
        return requestOptions == requestOptions2 ? requestOptions2.m2clone() : requestOptions2;
    }

    public <Y extends Target<TranscodeType>> Y into(Y y2) {
        return (Y) into((RequestBuilder<TranscodeType>) y2, (RequestListener) null);
    }

    public RequestBuilder<TranscodeType> listener(RequestListener<TranscodeType> requestListener) {
        this.requestListener = requestListener;
        return this;
    }

    public Target<TranscodeType> preload(int i2, int i3) {
        return into((RequestBuilder<TranscodeType>) PreloadTarget.obtain(this.requestManager, i2, i3));
    }

    public FutureTarget<TranscodeType> submit() {
        return submit(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL);
    }

    public RequestBuilder<TranscodeType> thumbnail(RequestBuilder<TranscodeType> requestBuilder) {
        this.thumbnailBuilder = requestBuilder;
        return this;
    }

    public RequestBuilder<TranscodeType> transition(TransitionOptions<?, ? super TranscodeType> transitionOptions) {
        this.transitionOptions = (TransitionOptions) Preconditions.checkNotNull(transitionOptions);
        this.isDefaultTransitionOptionsSet = false;
        return this;
    }

    /* renamed from: clone */
    public RequestBuilder<TranscodeType> m0clone() {
        try {
            RequestBuilder<TranscodeType> requestBuilder = (RequestBuilder) super.clone();
            requestBuilder.requestOptions = requestBuilder.requestOptions.m2clone();
            requestBuilder.transitionOptions = requestBuilder.transitionOptions.m1clone();
            return requestBuilder;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Deprecated
    public FutureTarget<File> downloadOnly(int i2, int i3) {
        return getDownloadOnlyRequest().submit(i2, i3);
    }

    <Y extends Target<TranscodeType>> Y into(Y y2, RequestListener<TranscodeType> requestListener) {
        return (Y) into(y2, requestListener, getMutableOptions());
    }

    public FutureTarget<TranscodeType> submit(int i2, int i3) {
        RequestFutureTarget requestFutureTarget = new RequestFutureTarget(this.glideContext.getMainHandler(), i2, i3);
        if (Util.isOnBackgroundThread()) {
            this.glideContext.getMainHandler().post(new Runnable() { // from class: com.bumptech.glide.RequestBuilder.1
                final /* synthetic */ RequestFutureTarget val$target;

                AnonymousClass1(RequestFutureTarget requestFutureTarget2) {
                    requestFutureTarget = requestFutureTarget2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (requestFutureTarget.isCancelled()) {
                        return;
                    }
                    RequestBuilder requestBuilder = RequestBuilder.this;
                    RequestFutureTarget requestFutureTarget2 = requestFutureTarget;
                    requestBuilder.into((RequestBuilder) requestFutureTarget2, (RequestListener) requestFutureTarget2);
                }
            });
        } else {
            into((RequestBuilder<TranscodeType>) requestFutureTarget2, requestFutureTarget2);
        }
        return requestFutureTarget2;
    }

    public RequestBuilder<TranscodeType> thumbnail(RequestBuilder<TranscodeType>... requestBuilderArr) {
        RequestBuilder<TranscodeType> requestBuilderThumbnail = null;
        if (requestBuilderArr == null || requestBuilderArr.length == 0) {
            return thumbnail((RequestBuilder) null);
        }
        for (int length = requestBuilderArr.length - 1; length >= 0; length--) {
            RequestBuilder<TranscodeType> requestBuilder = requestBuilderArr[length];
            if (requestBuilder != null) {
                requestBuilderThumbnail = requestBuilderThumbnail == null ? requestBuilder : requestBuilder.thumbnail(requestBuilderThumbnail);
            }
        }
        return thumbnail(requestBuilderThumbnail);
    }

    private <Y extends Target<TranscodeType>> Y into(Y y2, RequestListener<TranscodeType> requestListener, RequestOptions requestOptions) {
        Util.assertMainThread();
        Preconditions.checkNotNull(y2);
        if (this.isModelSet) {
            RequestOptions requestOptionsAutoClone = requestOptions.autoClone();
            Request requestBuildRequest = buildRequest(y2, requestListener, requestOptionsAutoClone);
            Request request = y2.getRequest();
            if (requestBuildRequest.isEquivalentTo(request) && !isSkipMemoryCacheWithCompletePreviousRequest(requestOptionsAutoClone, request)) {
                requestBuildRequest.recycle();
                if (!((Request) Preconditions.checkNotNull(request)).isRunning()) {
                    request.begin();
                }
                return y2;
            }
            this.requestManager.clear((Target<?>) y2);
            y2.setRequest(requestBuildRequest);
            this.requestManager.track(y2, requestBuildRequest);
            return y2;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    public Target<TranscodeType> preload() {
        return preload(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL);
    }

    public RequestBuilder<TranscodeType> thumbnail(float f2) {
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.thumbSizeMultiplier = Float.valueOf(f2);
            return this;
        }
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<TranscodeType> load(Object obj) {
        return loadGeneric(obj);
    }

    protected RequestBuilder(Class<TranscodeType> cls, RequestBuilder<?> requestBuilder) {
        this(requestBuilder.glide, requestBuilder.requestManager, cls, requestBuilder.context);
        this.model = requestBuilder.model;
        this.isModelSet = requestBuilder.isModelSet;
        this.requestOptions = requestBuilder.requestOptions;
    }

    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<TranscodeType> load(Bitmap bitmap) {
        return loadGeneric(bitmap).apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE));
    }

    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<TranscodeType> load(Drawable drawable) {
        return loadGeneric(drawable).apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE));
    }

    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<TranscodeType> load(String str) {
        return loadGeneric(str);
    }

    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<TranscodeType> load(Uri uri) {
        return loadGeneric(uri);
    }

    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<TranscodeType> load(File file) {
        return loadGeneric(file);
    }

    public ViewTarget<ImageView, TranscodeType> into(ImageView imageView) {
        Util.assertMainThread();
        Preconditions.checkNotNull(imageView);
        RequestOptions requestOptionsOptionalCenterCrop = this.requestOptions;
        if (!requestOptionsOptionalCenterCrop.isTransformationSet() && requestOptionsOptionalCenterCrop.isTransformationAllowed() && imageView.getScaleType() != null) {
            switch (AnonymousClass2.$SwitchMap$android$widget$ImageView$ScaleType[imageView.getScaleType().ordinal()]) {
                case 1:
                    requestOptionsOptionalCenterCrop = requestOptionsOptionalCenterCrop.m2clone().optionalCenterCrop();
                    break;
                case 2:
                    requestOptionsOptionalCenterCrop = requestOptionsOptionalCenterCrop.m2clone().optionalCenterInside();
                    break;
                case 3:
                case 4:
                case 5:
                    requestOptionsOptionalCenterCrop = requestOptionsOptionalCenterCrop.m2clone().optionalFitCenter();
                    break;
                case 6:
                    requestOptionsOptionalCenterCrop = requestOptionsOptionalCenterCrop.m2clone().optionalCenterInside();
                    break;
            }
        }
        return (ViewTarget) into(this.glideContext.buildImageViewTarget(imageView, this.transcodeClass), null, requestOptionsOptionalCenterCrop);
    }

    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<TranscodeType> load(Integer num) {
        return loadGeneric(num).apply(RequestOptions.signatureOf(ApplicationVersionSignature.obtain(this.context)));
    }

    @Override // com.bumptech.glide.ModelTypes
    @Deprecated
    public RequestBuilder<TranscodeType> load(URL url) {
        return loadGeneric(url);
    }

    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<TranscodeType> load(byte[] bArr) {
        RequestBuilder<TranscodeType> requestBuilderLoadGeneric = loadGeneric(bArr);
        if (!requestBuilderLoadGeneric.requestOptions.isDiskCacheStrategySet()) {
            requestBuilderLoadGeneric = requestBuilderLoadGeneric.apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE));
        }
        return !requestBuilderLoadGeneric.requestOptions.isSkipMemoryCacheSet() ? requestBuilderLoadGeneric.apply(RequestOptions.skipMemoryCacheOf(true)) : requestBuilderLoadGeneric;
    }

    @Deprecated
    public FutureTarget<TranscodeType> into(int i2, int i3) {
        return submit(i2, i3);
    }
}
