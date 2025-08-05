package Y0;

import android.hardware.Camera;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f1356a = "Y0.c";

    public static b a(int i2) {
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras == 0) {
            Log.w(f1356a, "No cameras!");
            return null;
        }
        if (i2 >= numberOfCameras) {
            Log.w(f1356a, "Requested camera does not exist: " + i2);
            return null;
        }
        if (i2 <= -1) {
            i2 = 0;
            int i3 = 0;
            while (i3 < numberOfCameras) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i3, cameraInfo);
                if (a.values()[cameraInfo.facing] == a.BACK) {
                    break;
                }
                i3++;
            }
            if (i3 == numberOfCameras) {
                Log.i(f1356a, "No camera facing " + a.BACK + "; returning camera #0");
            } else {
                i2 = i3;
            }
        }
        Log.i(f1356a, "Opening camera #" + i2);
        Camera.CameraInfo cameraInfo2 = new Camera.CameraInfo();
        Camera.getCameraInfo(i2, cameraInfo2);
        Camera cameraOpen = Camera.open(i2);
        if (cameraOpen == null) {
            return null;
        }
        return new b(i2, cameraOpen, a.values()[cameraInfo2.facing], cameraInfo2.orientation);
    }
}
