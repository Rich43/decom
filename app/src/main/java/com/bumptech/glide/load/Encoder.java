package com.bumptech.glide.load;

import java.io.File;

/* loaded from: classes.dex */
public interface Encoder<T> {
    boolean encode(T t2, File file, Options options);
}
