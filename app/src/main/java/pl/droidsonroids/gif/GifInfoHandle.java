package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.net.Uri;
import java.io.FileDescriptor;
import java.io.IOException;

/* loaded from: classes.dex */
final class GifInfoHandle {

    /* renamed from: a, reason: collision with root package name */
    private volatile long f7136a;

    static {
        g.b(null);
    }

    GifInfoHandle(String str) {
        this.f7136a = openFile(str);
    }

    private static native void free(long j2);

    private static native int getCurrentFrameIndex(long j2);

    private static native int getCurrentLoop(long j2);

    private static native int getCurrentPosition(long j2);

    private static native int getDuration(long j2);

    private static native int getHeight(long j2);

    private static native int getLoopCount(long j2);

    private static native int getNativeErrorCode(long j2);

    private static native int getNumberOfFrames(long j2);

    private static native long[] getSavedState(long j2);

    private static native int getWidth(long j2);

    private static native boolean isOpaque(long j2);

    static GifInfoHandle m(ContentResolver contentResolver, Uri uri) {
        return "file".equals(uri.getScheme()) ? new GifInfoHandle(uri.getPath()) : new GifInfoHandle(contentResolver.openAssetFileDescriptor(uri, "r"));
    }

    static native long openFd(FileDescriptor fileDescriptor, long j2);

    static native long openFile(String str);

    private static native long renderFrame(long j2, Bitmap bitmap);

    private static native boolean reset(long j2);

    private static native long restoreRemainder(long j2);

    private static native int restoreSavedState(long j2, long[] jArr, Bitmap bitmap);

    private static native void saveRemainder(long j2);

    private static native void seekToTime(long j2, int i2, Bitmap bitmap);

    synchronized int a() {
        return getCurrentFrameIndex(this.f7136a);
    }

    synchronized int b() {
        return getCurrentLoop(this.f7136a);
    }

    synchronized int c() {
        return getCurrentPosition(this.f7136a);
    }

    synchronized int d() {
        return getDuration(this.f7136a);
    }

    synchronized int e() {
        return getHeight(this.f7136a);
    }

    synchronized int f() {
        return getLoopCount(this.f7136a);
    }

    protected void finalize() throws Throwable {
        try {
            n();
        } finally {
            super.finalize();
        }
    }

    synchronized int g() {
        return getNativeErrorCode(this.f7136a);
    }

    synchronized int h() {
        return getNumberOfFrames(this.f7136a);
    }

    synchronized long[] i() {
        return getSavedState(this.f7136a);
    }

    synchronized int j() {
        return getWidth(this.f7136a);
    }

    synchronized boolean k() {
        return isOpaque(this.f7136a);
    }

    synchronized boolean l() {
        return this.f7136a == 0;
    }

    synchronized void n() {
        free(this.f7136a);
        this.f7136a = 0L;
    }

    synchronized long o(Bitmap bitmap) {
        return renderFrame(this.f7136a, bitmap);
    }

    synchronized boolean p() {
        return reset(this.f7136a);
    }

    synchronized long q() {
        return restoreRemainder(this.f7136a);
    }

    synchronized int r(long[] jArr, Bitmap bitmap) {
        return restoreSavedState(this.f7136a, jArr, bitmap);
    }

    synchronized void s() {
        saveRemainder(this.f7136a);
    }

    synchronized void t(int i2, Bitmap bitmap) {
        seekToTime(this.f7136a, i2, bitmap);
    }

    GifInfoHandle(AssetFileDescriptor assetFileDescriptor) throws IOException {
        try {
            this.f7136a = openFd(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset());
        } finally {
            try {
                assetFileDescriptor.close();
            } catch (IOException unused) {
            }
        }
    }
}
