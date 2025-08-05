package androidx.core.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* renamed from: androidx.core.view.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0172o {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3172a;

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC0173p f3173b;

    /* renamed from: c, reason: collision with root package name */
    private final b f3174c;

    /* renamed from: d, reason: collision with root package name */
    private final a f3175d;
    private VelocityTracker e;

    /* renamed from: f, reason: collision with root package name */
    private float f3176f;

    /* renamed from: g, reason: collision with root package name */
    private int f3177g;

    /* renamed from: h, reason: collision with root package name */
    private int f3178h;

    /* renamed from: i, reason: collision with root package name */
    private int f3179i;

    /* renamed from: j, reason: collision with root package name */
    private final int[] f3180j;

    /* renamed from: androidx.core.view.o$a */
    interface a {
        float a(VelocityTracker velocityTracker, MotionEvent motionEvent, int i2);
    }

    /* renamed from: androidx.core.view.o$b */
    interface b {
        void a(Context context, int[] iArr, MotionEvent motionEvent, int i2);
    }

    public C0172o(Context context, InterfaceC0173p interfaceC0173p) {
        this(context, interfaceC0173p, new b() { // from class: androidx.core.view.m
            @Override // androidx.core.view.C0172o.b
            public final void a(Context context2, int[] iArr, MotionEvent motionEvent, int i2) {
                C0172o.c(context2, iArr, motionEvent, i2);
            }
        }, new a() { // from class: androidx.core.view.n
            @Override // androidx.core.view.C0172o.a
            public final float a(VelocityTracker velocityTracker, MotionEvent motionEvent, int i2) {
                return C0172o.f(velocityTracker, motionEvent, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, int[] iArr, MotionEvent motionEvent, int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        iArr[0] = Q.i(context, viewConfiguration, motionEvent.getDeviceId(), i2, motionEvent.getSource());
        iArr[1] = Q.h(context, viewConfiguration, motionEvent.getDeviceId(), i2, motionEvent.getSource());
    }

    private boolean d(MotionEvent motionEvent, int i2) {
        int source = motionEvent.getSource();
        int deviceId = motionEvent.getDeviceId();
        if (this.f3178h == source && this.f3179i == deviceId && this.f3177g == i2) {
            return false;
        }
        this.f3174c.a(this.f3172a, this.f3180j, motionEvent, i2);
        this.f3178h = source;
        this.f3179i = deviceId;
        this.f3177g = i2;
        return true;
    }

    private float e(MotionEvent motionEvent, int i2) {
        if (this.e == null) {
            this.e = VelocityTracker.obtain();
        }
        return this.f3175d.a(this.e, motionEvent, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float f(VelocityTracker velocityTracker, MotionEvent motionEvent, int i2) {
        J.a(velocityTracker, motionEvent);
        J.b(velocityTracker, 1000);
        return J.d(velocityTracker, i2);
    }

    public void g(MotionEvent motionEvent, int i2) {
        boolean zD = d(motionEvent, i2);
        if (this.f3180j[0] == Integer.MAX_VALUE) {
            VelocityTracker velocityTracker = this.e;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.e = null;
                return;
            }
            return;
        }
        float fE = e(motionEvent, i2) * this.f3173b.b();
        float fSignum = Math.signum(fE);
        if (zD || (fSignum != Math.signum(this.f3176f) && fSignum != 0.0f)) {
            this.f3173b.c();
        }
        float fAbs = Math.abs(fE);
        int[] iArr = this.f3180j;
        if (fAbs < iArr[0]) {
            return;
        }
        float fMax = Math.max(-r6, Math.min(fE, iArr[1]));
        this.f3176f = this.f3173b.a(fMax) ? fMax : 0.0f;
    }

    C0172o(Context context, InterfaceC0173p interfaceC0173p, b bVar, a aVar) {
        this.f3177g = -1;
        this.f3178h = -1;
        this.f3179i = -1;
        this.f3180j = new int[]{Integer.MAX_VALUE, 0};
        this.f3172a = context;
        this.f3173b = interfaceC0173p;
        this.f3174c = bVar;
        this.f3175d = aVar;
    }
}
