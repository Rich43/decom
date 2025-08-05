package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import i.InterfaceC0269e;

/* loaded from: classes.dex */
public abstract class P implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    private final float f2215a;

    /* renamed from: b, reason: collision with root package name */
    private final int f2216b;

    /* renamed from: c, reason: collision with root package name */
    private final int f2217c;

    /* renamed from: d, reason: collision with root package name */
    final View f2218d;
    private Runnable e;

    /* renamed from: f, reason: collision with root package name */
    private Runnable f2219f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f2220g;

    /* renamed from: h, reason: collision with root package name */
    private int f2221h;

    /* renamed from: i, reason: collision with root package name */
    private final int[] f2222i = new int[2];

    private class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = P.this.f2218d.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    private class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            P.this.e();
        }
    }

    public P(View view) {
        this.f2218d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f2215a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f2216b = tapTimeout;
        this.f2217c = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private void a() {
        Runnable runnable = this.f2219f;
        if (runnable != null) {
            this.f2218d.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.e;
        if (runnable2 != null) {
            this.f2218d.removeCallbacks(runnable2);
        }
    }

    private boolean f(MotionEvent motionEvent) throws IllegalAccessException, IllegalArgumentException {
        N n2;
        View view = this.f2218d;
        InterfaceC0269e interfaceC0269eB = b();
        if (interfaceC0269eB == null || !interfaceC0269eB.b() || (n2 = (N) interfaceC0269eB.k()) == null || !n2.isShown()) {
            return false;
        }
        MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        i(view, motionEventObtainNoHistory);
        j(n2, motionEventObtainNoHistory);
        boolean zE = n2.e(motionEventObtainNoHistory, this.f2221h);
        motionEventObtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return zE && (actionMasked != 1 && actionMasked != 3);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean g(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.f2218d
            boolean r1 = r0.isEnabled()
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            int r1 = r6.getActionMasked()
            if (r1 == 0) goto L41
            r3 = 1
            if (r1 == r3) goto L3d
            r4 = 2
            if (r1 == r4) goto L1a
            r6 = 3
            if (r1 == r6) goto L3d
            goto L6d
        L1a:
            int r1 = r5.f2221h
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L6d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.f2215a
            boolean r6 = h(r0, r4, r6, r1)
            if (r6 != 0) goto L6d
            r5.a()
            android.view.ViewParent r6 = r0.getParent()
            r6.requestDisallowInterceptTouchEvent(r3)
            return r3
        L3d:
            r5.a()
            goto L6d
        L41:
            int r6 = r6.getPointerId(r2)
            r5.f2221h = r6
            java.lang.Runnable r6 = r5.e
            if (r6 != 0) goto L52
            androidx.appcompat.widget.P$a r6 = new androidx.appcompat.widget.P$a
            r6.<init>()
            r5.e = r6
        L52:
            java.lang.Runnable r6 = r5.e
            int r1 = r5.f2216b
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.f2219f
            if (r6 != 0) goto L65
            androidx.appcompat.widget.P$b r6 = new androidx.appcompat.widget.P$b
            r6.<init>()
            r5.f2219f = r6
        L65:
            java.lang.Runnable r6 = r5.f2219f
            int r1 = r5.f2217c
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.P.g(android.view.MotionEvent):boolean");
    }

    private static boolean h(View view, float f2, float f3, float f4) {
        float f5 = -f4;
        return f2 >= f5 && f3 >= f5 && f2 < ((float) (view.getRight() - view.getLeft())) + f4 && f3 < ((float) (view.getBottom() - view.getTop())) + f4;
    }

    private boolean i(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f2222i);
        motionEvent.offsetLocation(r0[0], r0[1]);
        return true;
    }

    private boolean j(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f2222i);
        motionEvent.offsetLocation(-r0[0], -r0[1]);
        return true;
    }

    public abstract InterfaceC0269e b();

    protected abstract boolean c();

    protected boolean d() {
        InterfaceC0269e interfaceC0269eB = b();
        if (interfaceC0269eB == null || !interfaceC0269eB.b()) {
            return true;
        }
        interfaceC0269eB.dismiss();
        return true;
    }

    void e() {
        a();
        View view = this.f2218d;
        if (view.isEnabled() && !view.isLongClickable() && c()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
            this.f2220g = true;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z2;
        boolean z3 = this.f2220g;
        if (z3) {
            z2 = f(motionEvent) || !d();
        } else {
            z2 = g(motionEvent) && c();
            if (z2) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f2218d.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
        this.f2220g = z2;
        return z2 || z3;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f2220g = false;
        this.f2221h = -1;
        Runnable runnable = this.e;
        if (runnable != null) {
            this.f2218d.removeCallbacks(runnable);
        }
    }
}
