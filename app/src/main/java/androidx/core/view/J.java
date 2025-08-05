package androidx.core.view;

import android.os.Build;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class J {

    /* renamed from: a, reason: collision with root package name */
    private static Map f3090a = Collections.synchronizedMap(new WeakHashMap());

    private static class a {
        static float a(VelocityTracker velocityTracker, int i2) {
            return velocityTracker.getAxisVelocity(i2);
        }

        static float b(VelocityTracker velocityTracker, int i2, int i3) {
            return velocityTracker.getAxisVelocity(i2, i3);
        }

        static boolean c(VelocityTracker velocityTracker, int i2) {
            return velocityTracker.isAxisSupported(i2);
        }
    }

    public static void a(VelocityTracker velocityTracker, MotionEvent motionEvent) {
        velocityTracker.addMovement(motionEvent);
        if (Build.VERSION.SDK_INT < 34 && motionEvent.getSource() == 4194304) {
            if (!f3090a.containsKey(velocityTracker)) {
                f3090a.put(velocityTracker, new K());
            }
            ((K) f3090a.get(velocityTracker)).a(motionEvent);
        }
    }

    public static void b(VelocityTracker velocityTracker, int i2) {
        c(velocityTracker, i2, Float.MAX_VALUE);
    }

    public static void c(VelocityTracker velocityTracker, int i2, float f2) {
        velocityTracker.computeCurrentVelocity(i2, f2);
        K kE = e(velocityTracker);
        if (kE != null) {
            kE.c(i2, f2);
        }
    }

    public static float d(VelocityTracker velocityTracker, int i2) {
        if (Build.VERSION.SDK_INT >= 34) {
            return a.a(velocityTracker, i2);
        }
        if (i2 == 0) {
            return velocityTracker.getXVelocity();
        }
        if (i2 == 1) {
            return velocityTracker.getYVelocity();
        }
        K kE = e(velocityTracker);
        if (kE != null) {
            return kE.d(i2);
        }
        return 0.0f;
    }

    private static K e(VelocityTracker velocityTracker) {
        return (K) f3090a.get(velocityTracker);
    }
}
