package O;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* loaded from: classes.dex */
class y implements z {

    /* renamed from: a, reason: collision with root package name */
    private final ViewOverlay f512a;

    y(View view) {
        this.f512a = view.getOverlay();
    }

    @Override // O.z
    public void b(Drawable drawable) {
        this.f512a.add(drawable);
    }

    @Override // O.z
    public void d(Drawable drawable) {
        this.f512a.remove(drawable);
    }
}
