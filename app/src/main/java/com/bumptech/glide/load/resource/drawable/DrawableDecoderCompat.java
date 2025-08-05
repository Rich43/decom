package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.appcompat.view.d;
import androidx.core.content.a;
import androidx.core.content.res.h;
import f.AbstractC0250a;

/* loaded from: classes.dex */
public final class DrawableDecoderCompat {
    private static volatile boolean shouldCallAppCompatResources = true;

    private DrawableDecoderCompat() {
    }

    public static Drawable getDrawable(Context context, Context context2, int i2) {
        return getDrawable(context, context2, i2, null);
    }

    private static Drawable loadDrawableV4(Context context, int i2, Resources.Theme theme) {
        return h.d(context.getResources(), i2, theme);
    }

    private static Drawable loadDrawableV7(Context context, int i2, Resources.Theme theme) {
        if (theme != null) {
            context = new d(context, theme);
        }
        return AbstractC0250a.b(context, i2);
    }

    public static Drawable getDrawable(Context context, int i2, Resources.Theme theme) {
        return getDrawable(context, context, i2, theme);
    }

    private static Drawable getDrawable(Context context, Context context2, int i2, Resources.Theme theme) {
        try {
            if (shouldCallAppCompatResources) {
                return loadDrawableV7(context2, i2, theme);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e) {
            if (!context.getPackageName().equals(context2.getPackageName())) {
                return a.d(context2, i2);
            }
            throw e;
        } catch (NoClassDefFoundError unused2) {
            shouldCallAppCompatResources = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return loadDrawableV4(context2, i2, theme);
    }
}
