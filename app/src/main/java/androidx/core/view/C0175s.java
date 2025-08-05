package androidx.core.view;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;

/* renamed from: androidx.core.view.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0175s {

    /* renamed from: a, reason: collision with root package name */
    private final GestureDetector f3182a;

    public C0175s(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public boolean a(MotionEvent motionEvent) {
        return this.f3182a.onTouchEvent(motionEvent);
    }

    public C0175s(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        this.f3182a = new GestureDetector(context, onGestureListener, handler);
    }
}
