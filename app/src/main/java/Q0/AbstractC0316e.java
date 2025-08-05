package q0;

import android.content.Context;
import android.util.DisplayMetrics;

/* renamed from: q0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0316e {
    public static int a(Context context, float f2) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) (((displayMetrics.widthPixels / displayMetrics.density) / f2) + 0.5d);
    }

    public static int b(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
