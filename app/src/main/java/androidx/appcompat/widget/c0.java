package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class c0 extends W {

    /* renamed from: b, reason: collision with root package name */
    private final WeakReference f2410b;

    public c0(Context context, Resources resources) {
        super(resources);
        this.f2410b = new WeakReference(context);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i2) {
        Drawable drawableA = a(i2);
        Context context = (Context) this.f2410b.get();
        if (drawableA != null && context != null) {
            V.h().x(context, i2, drawableA);
        }
        return drawableA;
    }
}
