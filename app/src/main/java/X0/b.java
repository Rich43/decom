package X0;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.hardware.Camera;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

/* loaded from: classes.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private final Context f1237a;

    /* renamed from: b, reason: collision with root package name */
    private int f1238b;

    /* renamed from: c, reason: collision with root package name */
    private int f1239c;

    /* renamed from: d, reason: collision with root package name */
    private Point f1240d;
    private Point e;

    /* renamed from: f, reason: collision with root package name */
    private Point f1241f;

    /* renamed from: g, reason: collision with root package name */
    private Point f1242g;

    b(Context context) {
        this.f1237a = context;
    }

    private void a(Camera.Parameters parameters, boolean z2, boolean z3) {
        c.j(parameters, z2);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f1237a);
        if (z3 || defaultSharedPreferences.getBoolean("preferences_disable_exposure", true)) {
            return;
        }
        c.e(parameters, z2);
    }

    private void f(Camera.Parameters parameters, SharedPreferences sharedPreferences, boolean z2) {
        a(parameters, e.b(sharedPreferences) == e.ON, z2);
    }

    Point b() {
        return this.e;
    }

    Point c() {
        return this.f1240d;
    }

    boolean d(Camera camera) {
        Camera.Parameters parameters;
        if (camera == null || (parameters = camera.getParameters()) == null) {
            return false;
        }
        String flashMode = parameters.getFlashMode();
        return "on".equals(flashMode) || "torch".equals(flashMode);
    }

    void e(Y0.b bVar) {
        int i2;
        Camera.Parameters parameters = bVar.a().getParameters();
        Display defaultDisplay = ((WindowManager) this.f1237a.getSystemService("window")).getDefaultDisplay();
        int rotation = defaultDisplay.getRotation();
        if (rotation == 0) {
            i2 = 0;
        } else if (rotation == 1) {
            i2 = 90;
        } else if (rotation == 2) {
            i2 = 180;
        } else if (rotation == 3) {
            i2 = 270;
        } else {
            if (rotation % 90 != 0) {
                throw new IllegalArgumentException("Bad rotation: " + rotation);
            }
            i2 = (rotation + 360) % 360;
        }
        Log.i("CameraConfiguration", "Display at: " + i2);
        int iC = bVar.c();
        Log.i("CameraConfiguration", "Camera at: " + iC);
        Y0.a aVarB = bVar.b();
        Y0.a aVar = Y0.a.FRONT;
        if (aVarB == aVar) {
            iC = (360 - iC) % 360;
            Log.i("CameraConfiguration", "Front camera overriden to: " + iC);
        }
        this.f1239c = ((iC + 360) - i2) % 360;
        Log.i("CameraConfiguration", "Final display orientation: " + this.f1239c);
        if (bVar.b() == aVar) {
            Log.i("CameraConfiguration", "Compensating rotation for front camera");
            this.f1238b = (360 - this.f1239c) % 360;
        } else {
            this.f1238b = this.f1239c;
        }
        Log.i("CameraConfiguration", "Clockwise rotation from display to camera: " + this.f1238b);
        Point point = new Point();
        defaultDisplay.getSize(point);
        this.f1240d = point;
        Log.i("CameraConfiguration", "Screen resolution in current orientation: " + this.f1240d);
        this.e = c.b(parameters, this.f1240d);
        Log.i("CameraConfiguration", "Camera resolution: " + this.e);
        this.f1241f = c.b(parameters, this.f1240d);
        Log.i("CameraConfiguration", "Best available preview size: " + this.f1241f);
        Point point2 = this.f1240d;
        boolean z2 = point2.x < point2.y;
        Point point3 = this.f1241f;
        if (z2 == (point3.x < point3.y)) {
            this.f1242g = point3;
        } else {
            Point point4 = this.f1241f;
            this.f1242g = new Point(point4.y, point4.x);
        }
        Log.i("CameraConfiguration", "Preview size on screen: " + this.f1242g);
    }

    void g(Y0.b bVar, boolean z2) {
        Camera cameraA = bVar.a();
        Camera.Parameters parameters = cameraA.getParameters();
        if (parameters == null) {
            Log.w("CameraConfiguration", "Device error: no camera parameters are available. Proceeding without configuration.");
            return;
        }
        Log.i("CameraConfiguration", "Initial camera parameters: " + parameters.flatten());
        if (z2) {
            Log.w("CameraConfiguration", "In camera config safe mode -- most settings will not be honored");
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f1237a);
        if (parameters.isZoomSupported()) {
            parameters.setZoom(parameters.getMaxZoom() / 10);
        }
        f(parameters, defaultSharedPreferences, z2);
        c.f(parameters, defaultSharedPreferences.getBoolean("preferences_auto_focus", true), defaultSharedPreferences.getBoolean("preferences_disable_continuous_focus", true), z2);
        if (!z2) {
            if (defaultSharedPreferences.getBoolean("preferences_invert_scan", false)) {
                c.h(parameters);
            }
            if (!defaultSharedPreferences.getBoolean("preferences_disable_barcode_scene_mode", true)) {
                c.d(parameters);
            }
            if (!defaultSharedPreferences.getBoolean("preferences_disable_metering", true)) {
                c.k(parameters);
                c.g(parameters);
                c.i(parameters);
            }
            parameters.setRecordingHint(true);
        }
        Point point = this.f1241f;
        parameters.setPreviewSize(point.x, point.y);
        cameraA.setParameters(parameters);
        cameraA.setDisplayOrientation(this.f1239c);
        Camera.Size previewSize = cameraA.getParameters().getPreviewSize();
        if (previewSize != null) {
            Point point2 = this.f1241f;
            if (point2.x == previewSize.width && point2.y == previewSize.height) {
                return;
            }
            Log.w("CameraConfiguration", "Camera said it supported preview size " + this.f1241f.x + 'x' + this.f1241f.y + ", but after setting it, preview size is " + previewSize.width + 'x' + previewSize.height);
            Point point3 = this.f1241f;
            point3.x = previewSize.width;
            point3.y = previewSize.height;
        }
    }

    void h(Camera camera, boolean z2) {
        Camera.Parameters parameters = camera.getParameters();
        a(parameters, z2, false);
        camera.setParameters(parameters);
    }
}
