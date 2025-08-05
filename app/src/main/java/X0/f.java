package X0;

import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;
import android.util.Log;

/* loaded from: classes.dex */
final class f implements Camera.PreviewCallback {

    /* renamed from: d, reason: collision with root package name */
    private static final String f1261d = "f";

    /* renamed from: a, reason: collision with root package name */
    private final b f1262a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f1263b;

    /* renamed from: c, reason: collision with root package name */
    private int f1264c;

    f(b bVar) {
        this.f1262a = bVar;
    }

    void a(Handler handler, int i2) {
        this.f1263b = handler;
        this.f1264c = i2;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Point pointB = this.f1262a.b();
        Handler handler = this.f1263b;
        if (pointB == null || handler == null) {
            Log.d(f1261d, "Got preview callback, but no handler or resolution available");
        } else {
            handler.obtainMessage(this.f1264c, pointB.x, pointB.y, bArr).sendToTarget();
            this.f1263b = null;
        }
    }
}
