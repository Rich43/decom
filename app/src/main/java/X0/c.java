package X0;

import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.util.Log;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f1243a = Pattern.compile(";");

    private static List a(int i2) {
        int i3 = -i2;
        return Collections.singletonList(new Camera.Area(new Rect(i3, i3, i2, i2), 1));
    }

    public static Point b(Camera.Parameters parameters, Point point) {
        Iterator<Camera.Size> it;
        String str;
        char c2 = 0;
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        String str2 = "Parameters contained no preview size!";
        if (supportedPreviewSizes == null) {
            Log.w("CameraConfiguration", "Device returned no supported preview sizes; using default");
            Camera.Size previewSize = parameters.getPreviewSize();
            if (previewSize != null) {
                return new Point(previewSize.width, previewSize.height);
            }
            throw new IllegalStateException("Parameters contained no preview size!");
        }
        if (Log.isLoggable("CameraConfiguration", 4)) {
            StringBuilder sb = new StringBuilder();
            for (Camera.Size size : supportedPreviewSizes) {
                sb.append(size.width);
                sb.append('x');
                sb.append(size.height);
                sb.append(' ');
            }
            Log.i("CameraConfiguration", "Supported preview sizes: " + ((Object) sb));
        }
        int i2 = point.x;
        int i3 = point.y;
        double d2 = i2 < i3 ? i2 / i3 : i3 / i2;
        Log.i("CameraConfiguration", "screenAspectRatio: " + d2);
        Iterator<Camera.Size> it2 = supportedPreviewSizes.iterator();
        Camera.Size size2 = null;
        int i4 = 0;
        while (it2.hasNext()) {
            Camera.Size next = it2.next();
            int i5 = next.width;
            int i6 = next.height;
            int i7 = i5 * i6;
            if (i7 < 153600) {
                it = it2;
                str = str2;
            } else {
                boolean z2 = i5 < i6;
                int i8 = z2 ? i5 : i6;
                int i9 = z2 ? i6 : i5;
                Integer numValueOf = Integer.valueOf(i8);
                Integer numValueOf2 = Integer.valueOf(i9);
                Object[] objArr = new Object[2];
                objArr[c2] = numValueOf;
                objArr[1] = numValueOf2;
                Log.i("CameraConfiguration", String.format("maybeFlipped:%d * %d", objArr));
                it = it2;
                str = str2;
                double d3 = i8 / i9;
                Log.i("CameraConfiguration", "aspectRatio: " + d3);
                double dAbs = Math.abs(d3 - d2);
                Log.i("CameraConfiguration", "distortion: " + dAbs);
                if (dAbs > 0.05d) {
                    continue;
                } else {
                    if (i8 == point.x && i9 == point.y) {
                        Point point2 = new Point(i5, i6);
                        Log.i("CameraConfiguration", "Found preview size exactly matching screen size: " + point2);
                        return point2;
                    }
                    if (i7 > i4) {
                        size2 = next;
                        i4 = i7;
                    }
                }
            }
            str2 = str;
            it2 = it;
            c2 = 0;
        }
        String str3 = str2;
        if (size2 != null) {
            Point point3 = new Point(size2.width, size2.height);
            Log.i("CameraConfiguration", "Using largest suitable preview size: " + point3);
            return point3;
        }
        Camera.Size previewSize2 = parameters.getPreviewSize();
        if (previewSize2 == null) {
            throw new IllegalStateException(str3);
        }
        Point point4 = new Point(previewSize2.width, previewSize2.height);
        Log.i("CameraConfiguration", "No suitable preview sizes, using default: " + point4);
        return point4;
    }

    private static String c(String str, Collection collection, String... strArr) {
        Log.i("CameraConfiguration", "Requesting " + str + " value from among: " + Arrays.toString(strArr));
        Log.i("CameraConfiguration", "Supported " + str + " values: " + collection);
        if (collection != null) {
            for (String str2 : strArr) {
                if (collection.contains(str2)) {
                    Log.i("CameraConfiguration", "Can set " + str + " to: " + str2);
                    return str2;
                }
            }
        }
        Log.i("CameraConfiguration", "No supported values match");
        return null;
    }

    public static void d(Camera.Parameters parameters) {
        if ("barcode".equals(parameters.getSceneMode())) {
            Log.i("CameraConfiguration", "Barcode scene mode already set");
            return;
        }
        String strC = c("scene mode", parameters.getSupportedSceneModes(), "barcode");
        if (strC != null) {
            parameters.setSceneMode(strC);
        }
    }

    public static void e(Camera.Parameters parameters, boolean z2) {
        int minExposureCompensation = parameters.getMinExposureCompensation();
        int maxExposureCompensation = parameters.getMaxExposureCompensation();
        float exposureCompensationStep = parameters.getExposureCompensationStep();
        if (minExposureCompensation != 0 || maxExposureCompensation != 0) {
            if (exposureCompensationStep > 0.0f) {
                int iRound = Math.round((z2 ? 0.0f : 1.5f) / exposureCompensationStep);
                float f2 = exposureCompensationStep * iRound;
                int iMax = Math.max(Math.min(iRound, maxExposureCompensation), minExposureCompensation);
                if (parameters.getExposureCompensation() == iMax) {
                    Log.i("CameraConfiguration", "Exposure compensation already set to " + iMax + " / " + f2);
                    return;
                }
                Log.i("CameraConfiguration", "Setting exposure compensation to " + iMax + " / " + f2);
                parameters.setExposureCompensation(iMax);
                return;
            }
        }
        Log.i("CameraConfiguration", "Camera does not support exposure compensation");
    }

    public static void f(Camera.Parameters parameters, boolean z2, boolean z3, boolean z4) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        String strC = z2 ? (z4 || z3) ? c("focus mode", supportedFocusModes, "auto") : c("focus mode", supportedFocusModes, "continuous-picture", "continuous-video", "auto") : null;
        if (!z4 && strC == null) {
            strC = c("focus mode", supportedFocusModes, "macro", "edof");
        }
        if (strC != null) {
            if (!strC.equals(parameters.getFocusMode())) {
                parameters.setFocusMode(strC);
                return;
            }
            Log.i("CameraConfiguration", "Focus mode already set to " + strC);
        }
    }

    public static void g(Camera.Parameters parameters) {
        if (parameters.getMaxNumFocusAreas() <= 0) {
            Log.i("CameraConfiguration", "Device does not support focus areas");
            return;
        }
        Log.i("CameraConfiguration", "Old focus areas: " + l(parameters.getFocusAreas()));
        List<Camera.Area> listA = a(400);
        Log.i("CameraConfiguration", "Setting focus area to : " + l(listA));
        parameters.setFocusAreas(listA);
    }

    public static void h(Camera.Parameters parameters) {
        if ("negative".equals(parameters.getColorEffect())) {
            Log.i("CameraConfiguration", "Negative effect already set");
            return;
        }
        String strC = c("color effect", parameters.getSupportedColorEffects(), "negative");
        if (strC != null) {
            parameters.setColorEffect(strC);
        }
    }

    public static void i(Camera.Parameters parameters) {
        if (parameters.getMaxNumMeteringAreas() <= 0) {
            Log.i("CameraConfiguration", "Device does not support metering areas");
            return;
        }
        Log.i("CameraConfiguration", "Old metering areas: " + parameters.getMeteringAreas());
        List<Camera.Area> listA = a(400);
        Log.i("CameraConfiguration", "Setting metering area to : " + l(listA));
        parameters.setMeteringAreas(listA);
    }

    public static void j(Camera.Parameters parameters, boolean z2) {
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        String strC = z2 ? c("flash mode", supportedFlashModes, "torch", "on") : c("flash mode", supportedFlashModes, "off");
        if (strC != null) {
            if (strC.equals(parameters.getFlashMode())) {
                Log.i("CameraConfiguration", "Flash mode already set to " + strC);
                return;
            }
            Log.i("CameraConfiguration", "Setting flash mode to " + strC);
            parameters.setFlashMode(strC);
        }
    }

    public static void k(Camera.Parameters parameters) {
        if (!parameters.isVideoStabilizationSupported()) {
            Log.i("CameraConfiguration", "This device does not support video stabilization");
        } else if (parameters.getVideoStabilization()) {
            Log.i("CameraConfiguration", "Video stabilization already enabled");
        } else {
            Log.i("CameraConfiguration", "Enabling video stabilization...");
            parameters.setVideoStabilization(true);
        }
    }

    private static String l(Iterable iterable) {
        if (iterable == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Camera.Area area = (Camera.Area) it.next();
            sb.append(area.rect);
            sb.append(':');
            sb.append(area.weight);
            sb.append(' ');
        }
        return sb.toString();
    }
}
