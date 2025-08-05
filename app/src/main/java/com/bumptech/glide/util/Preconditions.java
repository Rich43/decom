package com.bumptech.glide.util;

import android.text.TextUtils;
import java.util.Collection;

/* loaded from: classes.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean z2, String str) {
        if (!z2) {
            throw new IllegalArgumentException(str);
        }
    }

    public static String checkNotEmpty(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must not be null or empty");
        }
        return str;
    }

    public static <T> T checkNotNull(T t2) {
        return (T) checkNotNull(t2, "Argument must not be null");
    }

    public static <T> T checkNotNull(T t2, String str) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(str);
    }

    public static <T extends Collection<Y>, Y> T checkNotEmpty(T t2) {
        if (t2.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        return t2;
    }
}
