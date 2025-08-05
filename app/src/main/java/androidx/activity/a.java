package androidx.activity;

import android.window.BackEvent;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f1502a = new a();

    private a() {
    }

    public final BackEvent a(float f2, float f3, float f4, int i2) {
        return new BackEvent(f2, f3, f4, i2);
    }

    public final float b(BackEvent backEvent) {
        i1.k.e(backEvent, "backEvent");
        return backEvent.getProgress();
    }

    public final int c(BackEvent backEvent) {
        i1.k.e(backEvent, "backEvent");
        return backEvent.getSwipeEdge();
    }

    public final float d(BackEvent backEvent) {
        i1.k.e(backEvent, "backEvent");
        return backEvent.getTouchX();
    }

    public final float e(BackEvent backEvent) {
        i1.k.e(backEvent, "backEvent");
        return backEvent.getTouchY();
    }
}
