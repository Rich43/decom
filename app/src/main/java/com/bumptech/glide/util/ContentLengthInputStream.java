package com.bumptech.glide.util;

import android.text.TextUtils;
import android.util.Log;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class ContentLengthInputStream extends FilterInputStream {
    private static final String TAG = "ContentLengthStream";
    private static final int UNKNOWN = -1;
    private final long contentLength;
    private int readSoFar;

    private ContentLengthInputStream(InputStream inputStream, long j2) {
        super(inputStream);
        this.contentLength = j2;
    }

    private int checkReadSoFarOrThrow(int i2) throws IOException {
        if (i2 >= 0) {
            this.readSoFar += i2;
        } else if (this.contentLength - this.readSoFar > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.contentLength + ", but read: " + this.readSoFar);
        }
        return i2;
    }

    public static InputStream obtain(InputStream inputStream, String str) {
        return obtain(inputStream, parseContentLength(str));
    }

    private static int parseContentLength(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "failed to parse content length header: " + str, e);
                }
            }
        }
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        return (int) Math.max(this.contentLength - this.readSoFar, ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        int i2;
        i2 = super.read();
        checkReadSoFarOrThrow(i2 >= 0 ? 1 : -1);
        return i2;
    }

    public static InputStream obtain(InputStream inputStream, long j2) {
        return new ContentLengthInputStream(inputStream, j2);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i2, int i3) {
        return checkReadSoFarOrThrow(super.read(bArr, i2, i3));
    }
}
