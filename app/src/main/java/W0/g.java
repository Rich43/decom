package W0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.io.ByteArrayOutputStream;
import java.util.Map;

/* loaded from: classes.dex */
final class g extends Handler {

    /* renamed from: g */
    private static final String f1077g = "g";

    /* renamed from: a */
    private final Context f1078a;

    /* renamed from: b */
    private final X0.d f1079b;

    /* renamed from: c */
    private final d f1080c;

    /* renamed from: d */
    private final z0.h f1081d;
    private boolean e = true;

    /* renamed from: f */
    private long f1082f;

    g(Context context, X0.d dVar, d dVar2, Map map) {
        z0.h hVar = new z0.h();
        this.f1081d = hVar;
        hVar.e(map);
        this.f1078a = context;
        this.f1079b = dVar;
        this.f1080c = dVar2;
    }

    private z0.j a(byte[] bArr, int i2, int i3, boolean z2) {
        if (!z2) {
            return this.f1079b.a(bArr, i2, i3);
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i4 = 0; i4 < i3; i4++) {
            for (int i5 = 0; i5 < i2; i5++) {
                bArr2[(((i5 * i3) + i3) - i4) - 1] = bArr[(i4 * i2) + i5];
            }
        }
        return this.f1079b.a(bArr2, i3, i2);
    }

    private static void b(z0.j jVar, Bundle bundle) {
        int[] iArrI = jVar.i();
        int iH = jVar.h();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArrI, 0, iH, iH, jVar.g(), Bitmap.Config.ARGB_8888);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        bundle.putByteArray("barcode_bitmap", byteArrayOutputStream.toByteArray());
        bundle.putFloat("barcode_scaled_factor", iH / jVar.d());
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(byte[] r9, int r10, int r11, boolean r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 271
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: W0.g.c(byte[], int, int, boolean, boolean):void");
    }

    private boolean d(int i2, int i3) {
        Camera cameraA;
        if (this.f1082f > System.currentTimeMillis() - 1000) {
            return true;
        }
        if (i2 >= i3 / 5 || (cameraA = this.f1079b.f().a()) == null) {
            return false;
        }
        Camera.Parameters parameters = cameraA.getParameters();
        if (!parameters.isZoomSupported()) {
            Log.i(f1077g, "Zoom not supported");
            return false;
        }
        int maxZoom = parameters.getMaxZoom();
        parameters.setZoom(Math.min(parameters.getZoom() + (maxZoom / 5), maxZoom));
        cameraA.setParameters(parameters);
        this.f1082f = System.currentTimeMillis();
        return true;
    }

    private boolean e() {
        Display defaultDisplay = ((WindowManager) this.f1078a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.x < point.y;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message == null || !this.e) {
            return;
        }
        int i2 = message.what;
        if (i2 == m.f1099a) {
            c((byte[]) message.obj, message.arg1, message.arg2, e(), this.f1080c.d());
        } else if (i2 == m.f1102d) {
            this.e = false;
            Looper.myLooper().quit();
        }
    }
}
