package Z0;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.view.View;
import f.AbstractC0250a;

/* loaded from: classes.dex */
abstract class f {
    static int a(Context context, int i2) {
        return androidx.core.content.a.b(context, i2);
    }

    static Drawable b(Context context, int i2) {
        return AbstractC0250a.b(context, i2);
    }

    static void c(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    static Drawable d(Context context, int i2) {
        return e((NinePatchDrawable) b(context, b.f1369b), i2);
    }

    static Drawable e(Drawable drawable, int i2) {
        drawable.setColorFilter(i2, PorterDuff.Mode.SRC_IN);
        return drawable;
    }
}
