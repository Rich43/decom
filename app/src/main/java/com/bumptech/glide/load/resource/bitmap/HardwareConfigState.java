package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import java.io.File;

/* loaded from: classes.dex */
final class HardwareConfigState {
    private static final File FD_SIZE_LIST = new File("/proc/self/fd");
    private static final int MAXIMUM_FDS_FOR_HARDWARE_CONFIGS = 700;
    private static final int MINIMUM_DECODES_BETWEEN_FD_CHECKS = 50;
    private static final int MIN_HARDWARE_DIMENSION = 128;
    private static volatile HardwareConfigState instance;
    private volatile int decodesSinceLastFdCheck;
    private volatile boolean isHardwareConfigAllowed = true;

    private HardwareConfigState() {
    }

    static HardwareConfigState getInstance() {
        if (instance == null) {
            synchronized (HardwareConfigState.class) {
                try {
                    if (instance == null) {
                        instance = new HardwareConfigState();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    private synchronized boolean isFdSizeBelowHardwareLimit() {
        try {
            boolean z2 = true;
            int i2 = this.decodesSinceLastFdCheck + 1;
            this.decodesSinceLastFdCheck = i2;
            if (i2 >= MINIMUM_DECODES_BETWEEN_FD_CHECKS) {
                this.decodesSinceLastFdCheck = 0;
                int length = FD_SIZE_LIST.list().length;
                if (length >= MAXIMUM_FDS_FOR_HARDWARE_CONFIGS) {
                    z2 = false;
                }
                this.isHardwareConfigAllowed = z2;
                if (!this.isHardwareConfigAllowed && Log.isLoggable("Downsampler", 5)) {
                    Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + MAXIMUM_FDS_FOR_HARDWARE_CONFIGS);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.isHardwareConfigAllowed;
    }

    @TargetApi(26)
    boolean setHardwareConfigIfAllowed(int i2, int i3, BitmapFactory.Options options, DecodeFormat decodeFormat, boolean z2, boolean z3) {
        if (!z2 || Build.VERSION.SDK_INT < 26 || decodeFormat == DecodeFormat.PREFER_ARGB_8888_DISALLOW_HARDWARE || z3) {
            return false;
        }
        boolean z4 = i2 >= MIN_HARDWARE_DIMENSION && i3 >= MIN_HARDWARE_DIMENSION && isFdSizeBelowHardwareLimit();
        if (z4) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return z4;
    }
}
