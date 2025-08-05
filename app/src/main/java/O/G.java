package O;

import android.view.View;
import android.view.WindowId;

/* loaded from: classes.dex */
class G implements H {

    /* renamed from: a, reason: collision with root package name */
    private final WindowId f391a;

    G(View view) {
        this.f391a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof G) && ((G) obj).f391a.equals(this.f391a);
    }

    public int hashCode() {
        return this.f391a.hashCode();
    }
}
