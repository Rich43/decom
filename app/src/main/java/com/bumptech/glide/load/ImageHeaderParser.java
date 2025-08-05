package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public interface ImageHeaderParser {
    public static final int UNKNOWN_ORIENTATION = -1;

    public enum ImageType {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        UNKNOWN(false);

        private final boolean hasAlpha;

        ImageType(boolean z2) {
            this.hasAlpha = z2;
        }

        public boolean hasAlpha() {
            return this.hasAlpha;
        }
    }

    int getOrientation(InputStream inputStream, ArrayPool arrayPool);

    int getOrientation(ByteBuffer byteBuffer, ArrayPool arrayPool);

    ImageType getType(InputStream inputStream);

    ImageType getType(ByteBuffer byteBuffer);
}
