package com.bumptech.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.DrawableTransformation;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableTransformation;
import com.bumptech.glide.load.resource.gif.GifOptions;
import com.bumptech.glide.signature.EmptySignature;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.Map;

/* loaded from: classes.dex */
public class RequestOptions implements Cloneable {
    private static final int DISK_CACHE_STRATEGY = 4;
    private static final int ERROR_ID = 32;
    private static final int ERROR_PLACEHOLDER = 16;
    private static final int FALLBACK = 8192;
    private static final int FALLBACK_ID = 16384;
    private static final int IS_CACHEABLE = 256;
    private static final int ONLY_RETRIEVE_FROM_CACHE = 524288;
    private static final int OVERRIDE = 512;
    private static final int PLACEHOLDER = 64;
    private static final int PLACEHOLDER_ID = 128;
    private static final int PRIORITY = 8;
    private static final int RESOURCE_CLASS = 4096;
    private static final int SIGNATURE = 1024;
    private static final int SIZE_MULTIPLIER = 2;
    private static final int THEME = 32768;
    private static final int TRANSFORMATION = 2048;
    private static final int TRANSFORMATION_ALLOWED = 65536;
    private static final int TRANSFORMATION_REQUIRED = 131072;
    private static final int UNSET = -1;
    private static final int USE_ANIMATION_POOL = 1048576;
    private static final int USE_UNLIMITED_SOURCE_GENERATORS_POOL = 262144;
    private static RequestOptions centerCropOptions;
    private static RequestOptions centerInsideOptions;
    private static RequestOptions circleCropOptions;
    private static RequestOptions fitCenterOptions;
    private static RequestOptions noAnimationOptions;
    private static RequestOptions noTransformOptions;
    private static RequestOptions skipMemoryCacheFalseOptions;
    private static RequestOptions skipMemoryCacheTrueOptions;
    private int errorId;
    private Drawable errorPlaceholder;
    private Drawable fallbackDrawable;
    private int fallbackId;
    private int fields;
    private boolean isAutoCloneEnabled;
    private boolean isLocked;
    private boolean isTransformationRequired;
    private boolean onlyRetrieveFromCache;
    private Drawable placeholderDrawable;
    private int placeholderId;
    private Resources.Theme theme;
    private boolean useAnimationPool;
    private boolean useUnlimitedSourceGeneratorsPool;
    private float sizeMultiplier = 1.0f;
    private DiskCacheStrategy diskCacheStrategy = DiskCacheStrategy.AUTOMATIC;
    private Priority priority = Priority.NORMAL;
    private boolean isCacheable = true;
    private int overrideHeight = -1;
    private int overrideWidth = -1;
    private Key signature = EmptySignature.obtain();
    private boolean isTransformationAllowed = true;
    private Options options = new Options();
    private Map<Class<?>, Transformation<?>> transformations = new CachedHashCodeArrayMap();
    private Class<?> resourceClass = Object.class;
    private boolean isScaleOnlyOrNoTransform = true;

    public static RequestOptions bitmapTransform(Transformation<Bitmap> transformation) {
        return new RequestOptions().transform(transformation);
    }

    public static RequestOptions centerCropTransform() {
        if (centerCropOptions == null) {
            centerCropOptions = new RequestOptions().centerCrop().autoClone();
        }
        return centerCropOptions;
    }

    public static RequestOptions centerInsideTransform() {
        if (centerInsideOptions == null) {
            centerInsideOptions = new RequestOptions().centerInside().autoClone();
        }
        return centerInsideOptions;
    }

    public static RequestOptions circleCropTransform() {
        if (circleCropOptions == null) {
            circleCropOptions = new RequestOptions().circleCrop().autoClone();
        }
        return circleCropOptions;
    }

    public static RequestOptions decodeTypeOf(Class<?> cls) {
        return new RequestOptions().decode(cls);
    }

    public static RequestOptions diskCacheStrategyOf(DiskCacheStrategy diskCacheStrategy) {
        return new RequestOptions().diskCacheStrategy(diskCacheStrategy);
    }

    public static RequestOptions downsampleOf(DownsampleStrategy downsampleStrategy) {
        return new RequestOptions().downsample(downsampleStrategy);
    }

    public static RequestOptions encodeFormatOf(Bitmap.CompressFormat compressFormat) {
        return new RequestOptions().encodeFormat(compressFormat);
    }

    public static RequestOptions encodeQualityOf(int i2) {
        return new RequestOptions().encodeQuality(i2);
    }

    public static RequestOptions errorOf(Drawable drawable) {
        return new RequestOptions().error(drawable);
    }

    public static RequestOptions fitCenterTransform() {
        if (fitCenterOptions == null) {
            fitCenterOptions = new RequestOptions().fitCenter().autoClone();
        }
        return fitCenterOptions;
    }

    public static RequestOptions formatOf(DecodeFormat decodeFormat) {
        return new RequestOptions().format(decodeFormat);
    }

    public static RequestOptions frameOf(long j2) {
        return new RequestOptions().frame(j2);
    }

    private static boolean isSet(int i2, int i3) {
        return (i2 & i3) != 0;
    }

    public static RequestOptions noAnimation() {
        if (noAnimationOptions == null) {
            noAnimationOptions = new RequestOptions().dontAnimate().autoClone();
        }
        return noAnimationOptions;
    }

    public static RequestOptions noTransformation() {
        if (noTransformOptions == null) {
            noTransformOptions = new RequestOptions().dontTransform().autoClone();
        }
        return noTransformOptions;
    }

    public static <T> RequestOptions option(Option<T> option, T t2) {
        return new RequestOptions().set(option, t2);
    }

    private RequestOptions optionalScaleOnlyTransform(DownsampleStrategy downsampleStrategy, Transformation<Bitmap> transformation) {
        return scaleOnlyTransform(downsampleStrategy, transformation, false);
    }

    public static RequestOptions overrideOf(int i2, int i3) {
        return new RequestOptions().override(i2, i3);
    }

    public static RequestOptions placeholderOf(Drawable drawable) {
        return new RequestOptions().placeholder(drawable);
    }

    public static RequestOptions priorityOf(Priority priority) {
        return new RequestOptions().priority(priority);
    }

    private RequestOptions scaleOnlyTransform(DownsampleStrategy downsampleStrategy, Transformation<Bitmap> transformation) {
        return scaleOnlyTransform(downsampleStrategy, transformation, true);
    }

    private RequestOptions selfOrThrowIfLocked() {
        if (this.isLocked) {
            throw new IllegalStateException("You cannot modify locked RequestOptions, consider clone()");
        }
        return this;
    }

    public static RequestOptions signatureOf(Key key) {
        return new RequestOptions().signature(key);
    }

    public static RequestOptions sizeMultiplierOf(float f2) {
        return new RequestOptions().sizeMultiplier(f2);
    }

    public static RequestOptions skipMemoryCacheOf(boolean z2) {
        if (z2) {
            if (skipMemoryCacheTrueOptions == null) {
                skipMemoryCacheTrueOptions = new RequestOptions().skipMemoryCache(true).autoClone();
            }
            return skipMemoryCacheTrueOptions;
        }
        if (skipMemoryCacheFalseOptions == null) {
            skipMemoryCacheFalseOptions = new RequestOptions().skipMemoryCache(false).autoClone();
        }
        return skipMemoryCacheFalseOptions;
    }

    public static RequestOptions timeoutOf(int i2) {
        return new RequestOptions().timeout(i2);
    }

    public RequestOptions apply(RequestOptions requestOptions) {
        if (this.isAutoCloneEnabled) {
            return m2clone().apply(requestOptions);
        }
        if (isSet(requestOptions.fields, 2)) {
            this.sizeMultiplier = requestOptions.sizeMultiplier;
        }
        if (isSet(requestOptions.fields, USE_UNLIMITED_SOURCE_GENERATORS_POOL)) {
            this.useUnlimitedSourceGeneratorsPool = requestOptions.useUnlimitedSourceGeneratorsPool;
        }
        if (isSet(requestOptions.fields, USE_ANIMATION_POOL)) {
            this.useAnimationPool = requestOptions.useAnimationPool;
        }
        if (isSet(requestOptions.fields, 4)) {
            this.diskCacheStrategy = requestOptions.diskCacheStrategy;
        }
        if (isSet(requestOptions.fields, 8)) {
            this.priority = requestOptions.priority;
        }
        if (isSet(requestOptions.fields, ERROR_PLACEHOLDER)) {
            this.errorPlaceholder = requestOptions.errorPlaceholder;
        }
        if (isSet(requestOptions.fields, ERROR_ID)) {
            this.errorId = requestOptions.errorId;
        }
        if (isSet(requestOptions.fields, PLACEHOLDER)) {
            this.placeholderDrawable = requestOptions.placeholderDrawable;
        }
        if (isSet(requestOptions.fields, PLACEHOLDER_ID)) {
            this.placeholderId = requestOptions.placeholderId;
        }
        if (isSet(requestOptions.fields, IS_CACHEABLE)) {
            this.isCacheable = requestOptions.isCacheable;
        }
        if (isSet(requestOptions.fields, OVERRIDE)) {
            this.overrideWidth = requestOptions.overrideWidth;
            this.overrideHeight = requestOptions.overrideHeight;
        }
        if (isSet(requestOptions.fields, SIGNATURE)) {
            this.signature = requestOptions.signature;
        }
        if (isSet(requestOptions.fields, RESOURCE_CLASS)) {
            this.resourceClass = requestOptions.resourceClass;
        }
        if (isSet(requestOptions.fields, FALLBACK)) {
            this.fallbackDrawable = requestOptions.fallbackDrawable;
        }
        if (isSet(requestOptions.fields, FALLBACK_ID)) {
            this.fallbackId = requestOptions.fallbackId;
        }
        if (isSet(requestOptions.fields, THEME)) {
            this.theme = requestOptions.theme;
        }
        if (isSet(requestOptions.fields, 65536)) {
            this.isTransformationAllowed = requestOptions.isTransformationAllowed;
        }
        if (isSet(requestOptions.fields, TRANSFORMATION_REQUIRED)) {
            this.isTransformationRequired = requestOptions.isTransformationRequired;
        }
        if (isSet(requestOptions.fields, TRANSFORMATION)) {
            this.transformations.putAll(requestOptions.transformations);
            this.isScaleOnlyOrNoTransform = requestOptions.isScaleOnlyOrNoTransform;
        }
        if (isSet(requestOptions.fields, ONLY_RETRIEVE_FROM_CACHE)) {
            this.onlyRetrieveFromCache = requestOptions.onlyRetrieveFromCache;
        }
        if (!this.isTransformationAllowed) {
            this.transformations.clear();
            int i2 = this.fields;
            this.isTransformationRequired = false;
            this.fields = i2 & (-133121);
            this.isScaleOnlyOrNoTransform = true;
        }
        this.fields |= requestOptions.fields;
        this.options.putAll(requestOptions.options);
        return selfOrThrowIfLocked();
    }

    public RequestOptions autoClone() {
        if (this.isLocked && !this.isAutoCloneEnabled) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.isAutoCloneEnabled = true;
        return lock();
    }

    public RequestOptions centerCrop() {
        return transform(DownsampleStrategy.CENTER_OUTSIDE, new CenterCrop());
    }

    public RequestOptions centerInside() {
        return scaleOnlyTransform(DownsampleStrategy.CENTER_INSIDE, new CenterInside());
    }

    public RequestOptions circleCrop() {
        return transform(DownsampleStrategy.CENTER_INSIDE, new CircleCrop());
    }

    public RequestOptions decode(Class<?> cls) {
        if (this.isAutoCloneEnabled) {
            return m2clone().decode(cls);
        }
        this.resourceClass = (Class) Preconditions.checkNotNull(cls);
        this.fields |= RESOURCE_CLASS;
        return selfOrThrowIfLocked();
    }

    public RequestOptions disallowHardwareConfig() {
        return set(Downsampler.ALLOW_HARDWARE_CONFIG, Boolean.FALSE);
    }

    public RequestOptions diskCacheStrategy(DiskCacheStrategy diskCacheStrategy) {
        if (this.isAutoCloneEnabled) {
            return m2clone().diskCacheStrategy(diskCacheStrategy);
        }
        this.diskCacheStrategy = (DiskCacheStrategy) Preconditions.checkNotNull(diskCacheStrategy);
        this.fields |= 4;
        return selfOrThrowIfLocked();
    }

    public RequestOptions dontAnimate() {
        return set(GifOptions.DISABLE_ANIMATION, Boolean.TRUE);
    }

    public RequestOptions dontTransform() {
        if (this.isAutoCloneEnabled) {
            return m2clone().dontTransform();
        }
        this.transformations.clear();
        int i2 = this.fields;
        this.isTransformationRequired = false;
        this.isTransformationAllowed = false;
        this.fields = (i2 & (-133121)) | 65536;
        this.isScaleOnlyOrNoTransform = true;
        return selfOrThrowIfLocked();
    }

    public RequestOptions downsample(DownsampleStrategy downsampleStrategy) {
        return set(DownsampleStrategy.OPTION, Preconditions.checkNotNull(downsampleStrategy));
    }

    public RequestOptions encodeFormat(Bitmap.CompressFormat compressFormat) {
        return set(BitmapEncoder.COMPRESSION_FORMAT, Preconditions.checkNotNull(compressFormat));
    }

    public RequestOptions encodeQuality(int i2) {
        return set(BitmapEncoder.COMPRESSION_QUALITY, Integer.valueOf(i2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RequestOptions)) {
            return false;
        }
        RequestOptions requestOptions = (RequestOptions) obj;
        return Float.compare(requestOptions.sizeMultiplier, this.sizeMultiplier) == 0 && this.errorId == requestOptions.errorId && Util.bothNullOrEqual(this.errorPlaceholder, requestOptions.errorPlaceholder) && this.placeholderId == requestOptions.placeholderId && Util.bothNullOrEqual(this.placeholderDrawable, requestOptions.placeholderDrawable) && this.fallbackId == requestOptions.fallbackId && Util.bothNullOrEqual(this.fallbackDrawable, requestOptions.fallbackDrawable) && this.isCacheable == requestOptions.isCacheable && this.overrideHeight == requestOptions.overrideHeight && this.overrideWidth == requestOptions.overrideWidth && this.isTransformationRequired == requestOptions.isTransformationRequired && this.isTransformationAllowed == requestOptions.isTransformationAllowed && this.useUnlimitedSourceGeneratorsPool == requestOptions.useUnlimitedSourceGeneratorsPool && this.onlyRetrieveFromCache == requestOptions.onlyRetrieveFromCache && this.diskCacheStrategy.equals(requestOptions.diskCacheStrategy) && this.priority == requestOptions.priority && this.options.equals(requestOptions.options) && this.transformations.equals(requestOptions.transformations) && this.resourceClass.equals(requestOptions.resourceClass) && Util.bothNullOrEqual(this.signature, requestOptions.signature) && Util.bothNullOrEqual(this.theme, requestOptions.theme);
    }

    public RequestOptions error(Drawable drawable) {
        if (this.isAutoCloneEnabled) {
            return m2clone().error(drawable);
        }
        this.errorPlaceholder = drawable;
        this.fields |= ERROR_PLACEHOLDER;
        return selfOrThrowIfLocked();
    }

    public RequestOptions fallback(Drawable drawable) {
        if (this.isAutoCloneEnabled) {
            return m2clone().fallback(drawable);
        }
        this.fallbackDrawable = drawable;
        this.fields |= FALLBACK;
        return selfOrThrowIfLocked();
    }

    public RequestOptions fitCenter() {
        return scaleOnlyTransform(DownsampleStrategy.FIT_CENTER, new FitCenter());
    }

    public RequestOptions format(DecodeFormat decodeFormat) {
        Preconditions.checkNotNull(decodeFormat);
        return set(Downsampler.DECODE_FORMAT, decodeFormat).set(GifOptions.DECODE_FORMAT, decodeFormat);
    }

    public RequestOptions frame(long j2) {
        return set(VideoDecoder.TARGET_FRAME, Long.valueOf(j2));
    }

    public final DiskCacheStrategy getDiskCacheStrategy() {
        return this.diskCacheStrategy;
    }

    public final int getErrorId() {
        return this.errorId;
    }

    public final Drawable getErrorPlaceholder() {
        return this.errorPlaceholder;
    }

    public final Drawable getFallbackDrawable() {
        return this.fallbackDrawable;
    }

    public final int getFallbackId() {
        return this.fallbackId;
    }

    public final boolean getOnlyRetrieveFromCache() {
        return this.onlyRetrieveFromCache;
    }

    public final Options getOptions() {
        return this.options;
    }

    public final int getOverrideHeight() {
        return this.overrideHeight;
    }

    public final int getOverrideWidth() {
        return this.overrideWidth;
    }

    public final Drawable getPlaceholderDrawable() {
        return this.placeholderDrawable;
    }

    public final int getPlaceholderId() {
        return this.placeholderId;
    }

    public final Priority getPriority() {
        return this.priority;
    }

    public final Class<?> getResourceClass() {
        return this.resourceClass;
    }

    public final Key getSignature() {
        return this.signature;
    }

    public final float getSizeMultiplier() {
        return this.sizeMultiplier;
    }

    public final Resources.Theme getTheme() {
        return this.theme;
    }

    public final Map<Class<?>, Transformation<?>> getTransformations() {
        return this.transformations;
    }

    public final boolean getUseAnimationPool() {
        return this.useAnimationPool;
    }

    public final boolean getUseUnlimitedSourceGeneratorsPool() {
        return this.useUnlimitedSourceGeneratorsPool;
    }

    public int hashCode() {
        return Util.hashCode(this.theme, Util.hashCode(this.signature, Util.hashCode(this.resourceClass, Util.hashCode(this.transformations, Util.hashCode(this.options, Util.hashCode(this.priority, Util.hashCode(this.diskCacheStrategy, Util.hashCode(this.onlyRetrieveFromCache, Util.hashCode(this.useUnlimitedSourceGeneratorsPool, Util.hashCode(this.isTransformationAllowed, Util.hashCode(this.isTransformationRequired, Util.hashCode(this.overrideWidth, Util.hashCode(this.overrideHeight, Util.hashCode(this.isCacheable, Util.hashCode(this.fallbackDrawable, Util.hashCode(this.fallbackId, Util.hashCode(this.placeholderDrawable, Util.hashCode(this.placeholderId, Util.hashCode(this.errorPlaceholder, Util.hashCode(this.errorId, Util.hashCode(this.sizeMultiplier)))))))))))))))))))));
    }

    protected boolean isAutoCloneEnabled() {
        return this.isAutoCloneEnabled;
    }

    public final boolean isDiskCacheStrategySet() {
        return isSet(4);
    }

    public final boolean isLocked() {
        return this.isLocked;
    }

    public final boolean isMemoryCacheable() {
        return this.isCacheable;
    }

    public final boolean isPrioritySet() {
        return isSet(8);
    }

    boolean isScaleOnlyOrNoTransform() {
        return this.isScaleOnlyOrNoTransform;
    }

    public final boolean isSkipMemoryCacheSet() {
        return isSet(IS_CACHEABLE);
    }

    public final boolean isTransformationAllowed() {
        return this.isTransformationAllowed;
    }

    public final boolean isTransformationRequired() {
        return this.isTransformationRequired;
    }

    public final boolean isTransformationSet() {
        return isSet(TRANSFORMATION);
    }

    public final boolean isValidOverride() {
        return Util.isValidDimensions(this.overrideWidth, this.overrideHeight);
    }

    public RequestOptions lock() {
        this.isLocked = true;
        return this;
    }

    public RequestOptions onlyRetrieveFromCache(boolean z2) {
        if (this.isAutoCloneEnabled) {
            return m2clone().onlyRetrieveFromCache(z2);
        }
        this.onlyRetrieveFromCache = z2;
        this.fields |= ONLY_RETRIEVE_FROM_CACHE;
        return selfOrThrowIfLocked();
    }

    public RequestOptions optionalCenterCrop() {
        return optionalTransform(DownsampleStrategy.CENTER_OUTSIDE, new CenterCrop());
    }

    public RequestOptions optionalCenterInside() {
        return optionalScaleOnlyTransform(DownsampleStrategy.CENTER_INSIDE, new CenterInside());
    }

    public RequestOptions optionalCircleCrop() {
        return optionalTransform(DownsampleStrategy.CENTER_OUTSIDE, new CircleCrop());
    }

    public RequestOptions optionalFitCenter() {
        return optionalScaleOnlyTransform(DownsampleStrategy.FIT_CENTER, new FitCenter());
    }

    final RequestOptions optionalTransform(DownsampleStrategy downsampleStrategy, Transformation<Bitmap> transformation) {
        if (this.isAutoCloneEnabled) {
            return m2clone().optionalTransform(downsampleStrategy, transformation);
        }
        downsample(downsampleStrategy);
        return transform(transformation, false);
    }

    public RequestOptions override(int i2, int i3) {
        if (this.isAutoCloneEnabled) {
            return m2clone().override(i2, i3);
        }
        this.overrideWidth = i2;
        this.overrideHeight = i3;
        this.fields |= OVERRIDE;
        return selfOrThrowIfLocked();
    }

    public RequestOptions placeholder(Drawable drawable) {
        if (this.isAutoCloneEnabled) {
            return m2clone().placeholder(drawable);
        }
        this.placeholderDrawable = drawable;
        this.fields |= PLACEHOLDER;
        return selfOrThrowIfLocked();
    }

    public RequestOptions priority(Priority priority) {
        if (this.isAutoCloneEnabled) {
            return m2clone().priority(priority);
        }
        this.priority = (Priority) Preconditions.checkNotNull(priority);
        this.fields |= 8;
        return selfOrThrowIfLocked();
    }

    public <T> RequestOptions set(Option<T> option, T t2) {
        if (this.isAutoCloneEnabled) {
            return m2clone().set(option, t2);
        }
        Preconditions.checkNotNull(option);
        Preconditions.checkNotNull(t2);
        this.options.set(option, t2);
        return selfOrThrowIfLocked();
    }

    public RequestOptions signature(Key key) {
        if (this.isAutoCloneEnabled) {
            return m2clone().signature(key);
        }
        this.signature = (Key) Preconditions.checkNotNull(key);
        this.fields |= SIGNATURE;
        return selfOrThrowIfLocked();
    }

    public RequestOptions sizeMultiplier(float f2) {
        if (this.isAutoCloneEnabled) {
            return m2clone().sizeMultiplier(f2);
        }
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.sizeMultiplier = f2;
        this.fields |= 2;
        return selfOrThrowIfLocked();
    }

    public RequestOptions skipMemoryCache(boolean z2) {
        if (this.isAutoCloneEnabled) {
            return m2clone().skipMemoryCache(true);
        }
        this.isCacheable = !z2;
        this.fields |= IS_CACHEABLE;
        return selfOrThrowIfLocked();
    }

    public RequestOptions theme(Resources.Theme theme) {
        if (this.isAutoCloneEnabled) {
            return m2clone().theme(theme);
        }
        this.theme = theme;
        this.fields |= THEME;
        return selfOrThrowIfLocked();
    }

    public RequestOptions timeout(int i2) {
        return set(HttpGlideUrlLoader.TIMEOUT, Integer.valueOf(i2));
    }

    final RequestOptions transform(DownsampleStrategy downsampleStrategy, Transformation<Bitmap> transformation) {
        if (this.isAutoCloneEnabled) {
            return m2clone().transform(downsampleStrategy, transformation);
        }
        downsample(downsampleStrategy);
        return transform(transformation);
    }

    public RequestOptions transforms(Transformation<Bitmap>... transformationArr) {
        return transform((Transformation<Bitmap>) new MultiTransformation(transformationArr), true);
    }

    public RequestOptions useAnimationPool(boolean z2) {
        if (this.isAutoCloneEnabled) {
            return m2clone().useAnimationPool(z2);
        }
        this.useAnimationPool = z2;
        this.fields |= USE_ANIMATION_POOL;
        return selfOrThrowIfLocked();
    }

    public RequestOptions useUnlimitedSourceGeneratorsPool(boolean z2) {
        if (this.isAutoCloneEnabled) {
            return m2clone().useUnlimitedSourceGeneratorsPool(z2);
        }
        this.useUnlimitedSourceGeneratorsPool = z2;
        this.fields |= USE_UNLIMITED_SOURCE_GENERATORS_POOL;
        return selfOrThrowIfLocked();
    }

    public static RequestOptions errorOf(int i2) {
        return new RequestOptions().error(i2);
    }

    private boolean isSet(int i2) {
        return isSet(this.fields, i2);
    }

    public static RequestOptions overrideOf(int i2) {
        return overrideOf(i2, i2);
    }

    public static RequestOptions placeholderOf(int i2) {
        return new RequestOptions().placeholder(i2);
    }

    private RequestOptions scaleOnlyTransform(DownsampleStrategy downsampleStrategy, Transformation<Bitmap> transformation, boolean z2) {
        RequestOptions requestOptionsTransform = z2 ? transform(downsampleStrategy, transformation) : optionalTransform(downsampleStrategy, transformation);
        requestOptionsTransform.isScaleOnlyOrNoTransform = true;
        return requestOptionsTransform;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public RequestOptions m2clone() {
        try {
            RequestOptions requestOptions = (RequestOptions) super.clone();
            Options options = new Options();
            requestOptions.options = options;
            options.putAll(this.options);
            CachedHashCodeArrayMap cachedHashCodeArrayMap = new CachedHashCodeArrayMap();
            requestOptions.transformations = cachedHashCodeArrayMap;
            cachedHashCodeArrayMap.putAll(this.transformations);
            requestOptions.isLocked = false;
            requestOptions.isAutoCloneEnabled = false;
            return requestOptions;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public RequestOptions optionalTransform(Transformation<Bitmap> transformation) {
        return transform(transformation, false);
    }

    public RequestOptions transform(Transformation<Bitmap> transformation) {
        return transform(transformation, true);
    }

    private RequestOptions transform(Transformation<Bitmap> transformation, boolean z2) {
        if (this.isAutoCloneEnabled) {
            return m2clone().transform(transformation, z2);
        }
        DrawableTransformation drawableTransformation = new DrawableTransformation(transformation, z2);
        transform(Bitmap.class, transformation, z2);
        transform(Drawable.class, drawableTransformation, z2);
        transform(BitmapDrawable.class, drawableTransformation.asBitmapDrawable(), z2);
        transform(GifDrawable.class, new GifDrawableTransformation(transformation), z2);
        return selfOrThrowIfLocked();
    }

    public RequestOptions error(int i2) {
        if (this.isAutoCloneEnabled) {
            return m2clone().error(i2);
        }
        this.errorId = i2;
        this.fields |= ERROR_ID;
        return selfOrThrowIfLocked();
    }

    public RequestOptions fallback(int i2) {
        if (this.isAutoCloneEnabled) {
            return m2clone().fallback(i2);
        }
        this.fallbackId = i2;
        this.fields |= FALLBACK_ID;
        return selfOrThrowIfLocked();
    }

    public <T> RequestOptions optionalTransform(Class<T> cls, Transformation<T> transformation) {
        return transform(cls, transformation, false);
    }

    public RequestOptions placeholder(int i2) {
        if (this.isAutoCloneEnabled) {
            return m2clone().placeholder(i2);
        }
        this.placeholderId = i2;
        this.fields |= PLACEHOLDER_ID;
        return selfOrThrowIfLocked();
    }

    public RequestOptions override(int i2) {
        return override(i2, i2);
    }

    private <T> RequestOptions transform(Class<T> cls, Transformation<T> transformation, boolean z2) {
        if (this.isAutoCloneEnabled) {
            return m2clone().transform(cls, transformation, z2);
        }
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(transformation);
        this.transformations.put(cls, transformation);
        int i2 = this.fields;
        this.isTransformationAllowed = true;
        this.fields = 67584 | i2;
        this.isScaleOnlyOrNoTransform = false;
        if (z2) {
            this.fields = i2 | 198656;
            this.isTransformationRequired = true;
        }
        return selfOrThrowIfLocked();
    }

    public <T> RequestOptions transform(Class<T> cls, Transformation<T> transformation) {
        return transform(cls, transformation, true);
    }
}
