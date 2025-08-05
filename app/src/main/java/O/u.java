package O;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* loaded from: classes.dex */
class u implements v {

    /* renamed from: a, reason: collision with root package name */
    private final ViewGroupOverlay f509a;

    u(ViewGroup viewGroup) {
        this.f509a = viewGroup.getOverlay();
    }

    @Override // O.v
    public void a(View view) {
        this.f509a.add(view);
    }

    @Override // O.z
    public void b(Drawable drawable) {
        this.f509a.add(drawable);
    }

    @Override // O.v
    public void c(View view) {
        this.f509a.remove(view);
    }

    @Override // O.z
    public void d(Drawable drawable) {
        this.f509a.remove(drawable);
    }
}
