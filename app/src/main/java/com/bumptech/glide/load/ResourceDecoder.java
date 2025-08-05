package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.Resource;

/* loaded from: classes.dex */
public interface ResourceDecoder<T, Z> {
    Resource<Z> decode(T t2, int i2, int i3, Options options);

    boolean handles(T t2, Options options);
}
