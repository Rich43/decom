package B;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.M;
import java.util.Arrays;

/* loaded from: classes.dex */
public class a {

    /* renamed from: w, reason: collision with root package name */
    private static final Interpolator f4w = new InterpolatorC0001a();

    /* renamed from: a, reason: collision with root package name */
    private int f5a;

    /* renamed from: b, reason: collision with root package name */
    private int f6b;

    /* renamed from: d, reason: collision with root package name */
    private float[] f8d;
    private float[] e;

    /* renamed from: f, reason: collision with root package name */
    private float[] f9f;

    /* renamed from: g, reason: collision with root package name */
    private float[] f10g;

    /* renamed from: h, reason: collision with root package name */
    private int[] f11h;

    /* renamed from: i, reason: collision with root package name */
    private int[] f12i;

    /* renamed from: j, reason: collision with root package name */
    private int[] f13j;

    /* renamed from: k, reason: collision with root package name */
    private int f14k;

    /* renamed from: l, reason: collision with root package name */
    private VelocityTracker f15l;

    /* renamed from: m, reason: collision with root package name */
    private float f16m;

    /* renamed from: n, reason: collision with root package name */
    private float f17n;
    private int o;

    /* renamed from: p, reason: collision with root package name */
    private int f18p;

    /* renamed from: q, reason: collision with root package name */
    private OverScroller f19q;
    private final c r;
    private View s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f20t;

    /* renamed from: u, reason: collision with root package name */
    private final ViewGroup f21u;

    /* renamed from: c, reason: collision with root package name */
    private int f7c = -1;

    /* renamed from: v, reason: collision with root package name */
    private final Runnable f22v = new b();

    /* renamed from: B.a$a, reason: collision with other inner class name */
    static class InterpolatorC0001a implements Interpolator {
        InterpolatorC0001a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.E(0);
        }
    }

    private a(Context context, ViewGroup viewGroup, c cVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (cVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f21u = viewGroup;
        this.r = cVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f6b = viewConfiguration.getScaledTouchSlop();
        this.f16m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f17n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f19q = new OverScroller(context, f4w);
    }

    private void A() {
        this.f15l.computeCurrentVelocity(1000, this.f16m);
        n(e(this.f15l.getXVelocity(this.f7c), this.f17n, this.f16m), e(this.f15l.getYVelocity(this.f7c), this.f17n, this.f16m));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r3v3, types: [B.a$c] */
    private void B(float f2, float f3, int i2) {
        boolean zC = c(f2, f3, i2, 1);
        boolean z2 = zC;
        if (c(f3, f2, i2, 4)) {
            z2 = (zC ? 1 : 0) | 4;
        }
        boolean z3 = z2;
        if (c(f2, f3, i2, 2)) {
            z3 = (z2 ? 1 : 0) | 2;
        }
        ?? r02 = z3;
        if (c(f3, f2, i2, 8)) {
            r02 = (z3 ? 1 : 0) | 8;
        }
        if (r02 != 0) {
            int[] iArr = this.f12i;
            iArr[i2] = iArr[i2] | r02;
            this.r.f(r02, i2);
        }
    }

    private void C(float f2, float f3, int i2) {
        q(i2);
        float[] fArr = this.f8d;
        this.f9f[i2] = f2;
        fArr[i2] = f2;
        float[] fArr2 = this.e;
        this.f10g[i2] = f3;
        fArr2[i2] = f3;
        this.f11h[i2] = t((int) f2, (int) f3);
        this.f14k |= 1 << i2;
    }

    private void D(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            int pointerId = motionEvent.getPointerId(i2);
            if (x(pointerId)) {
                float x2 = motionEvent.getX(i2);
                float y2 = motionEvent.getY(i2);
                this.f9f[pointerId] = x2;
                this.f10g[pointerId] = y2;
            }
        }
    }

    private boolean c(float f2, float f3, int i2, int i3) {
        float fAbs = Math.abs(f2);
        float fAbs2 = Math.abs(f3);
        if ((this.f11h[i2] & i3) != i3 || (this.f18p & i3) == 0 || (this.f13j[i2] & i3) == i3 || (this.f12i[i2] & i3) == i3) {
            return false;
        }
        int i4 = this.f6b;
        if (fAbs <= i4 && fAbs2 <= i4) {
            return false;
        }
        if (fAbs >= fAbs2 * 0.5f || !this.r.g(i3)) {
            return (this.f12i[i2] & i3) == 0 && fAbs > ((float) this.f6b);
        }
        int[] iArr = this.f13j;
        iArr[i2] = iArr[i2] | i3;
        return false;
    }

    private boolean d(View view, float f2, float f3) {
        if (view == null) {
            return false;
        }
        boolean z2 = this.r.d(view) > 0;
        boolean z3 = this.r.e(view) > 0;
        if (!z2 || !z3) {
            return z2 ? Math.abs(f2) > ((float) this.f6b) : z3 && Math.abs(f3) > ((float) this.f6b);
        }
        float f4 = (f2 * f2) + (f3 * f3);
        int i2 = this.f6b;
        return f4 > ((float) (i2 * i2));
    }

    private float e(float f2, float f3, float f4) {
        float fAbs = Math.abs(f2);
        if (fAbs < f3) {
            return 0.0f;
        }
        return fAbs > f4 ? f2 > 0.0f ? f4 : -f4 : f2;
    }

    private int f(int i2, int i3, int i4) {
        int iAbs = Math.abs(i2);
        if (iAbs < i3) {
            return 0;
        }
        return iAbs > i4 ? i2 > 0 ? i4 : -i4 : i2;
    }

    private void g() {
        float[] fArr = this.f8d;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.e, 0.0f);
        Arrays.fill(this.f9f, 0.0f);
        Arrays.fill(this.f10g, 0.0f);
        Arrays.fill(this.f11h, 0);
        Arrays.fill(this.f12i, 0);
        Arrays.fill(this.f13j, 0);
        this.f14k = 0;
    }

    private void h(int i2) {
        if (this.f8d == null || !w(i2)) {
            return;
        }
        this.f8d[i2] = 0.0f;
        this.e[i2] = 0.0f;
        this.f9f[i2] = 0.0f;
        this.f10g[i2] = 0.0f;
        this.f11h[i2] = 0;
        this.f12i[i2] = 0;
        this.f13j[i2] = 0;
        this.f14k = (~(1 << i2)) & this.f14k;
    }

    private int i(int i2, int i3, int i4) {
        if (i2 == 0) {
            return 0;
        }
        int width = this.f21u.getWidth();
        float f2 = width / 2;
        float fO = f2 + (o(Math.min(1.0f, Math.abs(i2) / width)) * f2);
        int iAbs = Math.abs(i3);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fO / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i2) / i4) + 1.0f) * 256.0f), 600);
    }

    private int j(View view, int i2, int i3, int i4, int i5) {
        float f2;
        float f3;
        float f4;
        float f5;
        int iF = f(i4, (int) this.f17n, (int) this.f16m);
        int iF2 = f(i5, (int) this.f17n, (int) this.f16m);
        int iAbs = Math.abs(i2);
        int iAbs2 = Math.abs(i3);
        int iAbs3 = Math.abs(iF);
        int iAbs4 = Math.abs(iF2);
        int i6 = iAbs3 + iAbs4;
        int i7 = iAbs + iAbs2;
        if (iF != 0) {
            f2 = iAbs3;
            f3 = i6;
        } else {
            f2 = iAbs;
            f3 = i7;
        }
        float f6 = f2 / f3;
        if (iF2 != 0) {
            f4 = iAbs4;
            f5 = i6;
        } else {
            f4 = iAbs2;
            f5 = i7;
        }
        return (int) ((i(i2, iF, this.r.d(view)) * f6) + (i(i3, iF2, this.r.e(view)) * (f4 / f5)));
    }

    public static a l(ViewGroup viewGroup, float f2, c cVar) {
        a aVarM = m(viewGroup, cVar);
        aVarM.f6b = (int) (aVarM.f6b * (1.0f / f2));
        return aVarM;
    }

    public static a m(ViewGroup viewGroup, c cVar) {
        return new a(viewGroup.getContext(), viewGroup, cVar);
    }

    private void n(float f2, float f3) {
        this.f20t = true;
        this.r.l(this.s, f2, f3);
        this.f20t = false;
        if (this.f5a == 1) {
            E(0);
        }
    }

    private float o(float f2) {
        return (float) Math.sin((f2 - 0.5f) * 0.47123894f);
    }

    private void p(int i2, int i3, int i4, int i5) {
        int left = this.s.getLeft();
        int top = this.s.getTop();
        if (i4 != 0) {
            i2 = this.r.a(this.s, i2, i4);
            M.U(this.s, i2 - left);
        }
        int i6 = i2;
        if (i5 != 0) {
            i3 = this.r.b(this.s, i3, i5);
            M.V(this.s, i3 - top);
        }
        int i7 = i3;
        if (i4 == 0 && i5 == 0) {
            return;
        }
        this.r.k(this.s, i6, i7, i6 - left, i7 - top);
    }

    private void q(int i2) {
        float[] fArr = this.f8d;
        if (fArr == null || fArr.length <= i2) {
            int i3 = i2 + 1;
            float[] fArr2 = new float[i3];
            float[] fArr3 = new float[i3];
            float[] fArr4 = new float[i3];
            float[] fArr5 = new float[i3];
            int[] iArr = new int[i3];
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f9f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f10g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f11h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f12i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f13j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f8d = fArr2;
            this.e = fArr3;
            this.f9f = fArr4;
            this.f10g = fArr5;
            this.f11h = iArr;
            this.f12i = iArr2;
            this.f13j = iArr3;
        }
    }

    private boolean s(int i2, int i3, int i4, int i5) {
        int left = this.s.getLeft();
        int top = this.s.getTop();
        int i6 = i2 - left;
        int i7 = i3 - top;
        if (i6 == 0 && i7 == 0) {
            this.f19q.abortAnimation();
            E(0);
            return false;
        }
        this.f19q.startScroll(left, top, i6, i7, j(this.s, i6, i7, i4, i5));
        E(2);
        return true;
    }

    private int t(int i2, int i3) {
        int i4 = i2 < this.f21u.getLeft() + this.o ? 1 : 0;
        if (i3 < this.f21u.getTop() + this.o) {
            i4 |= 4;
        }
        if (i2 > this.f21u.getRight() - this.o) {
            i4 |= 2;
        }
        return i3 > this.f21u.getBottom() - this.o ? i4 | 8 : i4;
    }

    private boolean x(int i2) {
        if (w(i2)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i2 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    void E(int i2) {
        this.f21u.removeCallbacks(this.f22v);
        if (this.f5a != i2) {
            this.f5a = i2;
            this.r.j(i2);
            if (this.f5a == 0) {
                this.s = null;
            }
        }
    }

    public boolean F(int i2, int i3) {
        if (this.f20t) {
            return s(i2, i3, (int) this.f15l.getXVelocity(this.f7c), (int) this.f15l.getYVelocity(this.f7c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean G(android.view.MotionEvent r17) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: B.a.G(android.view.MotionEvent):boolean");
    }

    public boolean H(View view, int i2, int i3) {
        this.s = view;
        this.f7c = -1;
        boolean zS = s(i2, i3, 0, 0);
        if (!zS && this.f5a == 0 && this.s != null) {
            this.s = null;
        }
        return zS;
    }

    boolean I(View view, int i2) {
        if (view == this.s && this.f7c == i2) {
            return true;
        }
        if (view == null || !this.r.m(view, i2)) {
            return false;
        }
        this.f7c = i2;
        b(view, i2);
        return true;
    }

    public void a() {
        this.f7c = -1;
        g();
        VelocityTracker velocityTracker = this.f15l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f15l = null;
        }
    }

    public void b(View view, int i2) {
        if (view.getParent() == this.f21u) {
            this.s = view;
            this.f7c = i2;
            this.r.i(view, i2);
            E(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f21u + ")");
    }

    public boolean k(boolean z2) {
        if (this.f5a == 2) {
            boolean zComputeScrollOffset = this.f19q.computeScrollOffset();
            int currX = this.f19q.getCurrX();
            int currY = this.f19q.getCurrY();
            int left = currX - this.s.getLeft();
            int top = currY - this.s.getTop();
            if (left != 0) {
                M.U(this.s, left);
            }
            if (top != 0) {
                M.V(this.s, top);
            }
            if (left != 0 || top != 0) {
                this.r.k(this.s, currX, currY, left, top);
            }
            if (zComputeScrollOffset && currX == this.f19q.getFinalX() && currY == this.f19q.getFinalY()) {
                this.f19q.abortAnimation();
                zComputeScrollOffset = false;
            }
            if (!zComputeScrollOffset) {
                if (z2) {
                    this.f21u.post(this.f22v);
                } else {
                    E(0);
                }
            }
        }
        return this.f5a == 2;
    }

    public View r(int i2, int i3) {
        for (int childCount = this.f21u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f21u.getChildAt(this.r.c(childCount));
            if (i2 >= childAt.getLeft() && i2 < childAt.getRight() && i3 >= childAt.getTop() && i3 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public int u() {
        return this.f6b;
    }

    public boolean v(int i2, int i3) {
        return y(this.s, i2, i3);
    }

    public boolean w(int i2) {
        return ((1 << i2) & this.f14k) != 0;
    }

    public boolean y(View view, int i2, int i3) {
        return view != null && i2 >= view.getLeft() && i2 < view.getRight() && i3 >= view.getTop() && i3 < view.getBottom();
    }

    public void z(MotionEvent motionEvent) {
        int i2;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f15l == null) {
            this.f15l = VelocityTracker.obtain();
        }
        this.f15l.addMovement(motionEvent);
        int i3 = 0;
        if (actionMasked == 0) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewR = r((int) x2, (int) y2);
            C(x2, y2, pointerId);
            I(viewR, pointerId);
            int i4 = this.f11h[pointerId];
            int i5 = this.f18p;
            if ((i4 & i5) != 0) {
                this.r.h(i4 & i5, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.f5a == 1) {
                A();
            }
            a();
            return;
        }
        if (actionMasked == 2) {
            if (this.f5a == 1) {
                if (x(this.f7c)) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.f7c);
                    float x3 = motionEvent.getX(iFindPointerIndex);
                    float y3 = motionEvent.getY(iFindPointerIndex);
                    float[] fArr = this.f9f;
                    int i6 = this.f7c;
                    int i7 = (int) (x3 - fArr[i6]);
                    int i8 = (int) (y3 - this.f10g[i6]);
                    p(this.s.getLeft() + i7, this.s.getTop() + i8, i7, i8);
                    D(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            while (i3 < pointerCount) {
                int pointerId2 = motionEvent.getPointerId(i3);
                if (x(pointerId2)) {
                    float x4 = motionEvent.getX(i3);
                    float y4 = motionEvent.getY(i3);
                    float f2 = x4 - this.f8d[pointerId2];
                    float f3 = y4 - this.e[pointerId2];
                    B(f2, f3, pointerId2);
                    if (this.f5a != 1) {
                        View viewR2 = r((int) x4, (int) y4);
                        if (d(viewR2, f2, f3) && I(viewR2, pointerId2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i3++;
            }
            D(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.f5a == 1) {
                n(0.0f, 0.0f);
            }
            a();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x5 = motionEvent.getX(actionIndex);
            float y5 = motionEvent.getY(actionIndex);
            C(x5, y5, pointerId3);
            if (this.f5a != 0) {
                if (v((int) x5, (int) y5)) {
                    I(this.s, pointerId3);
                    return;
                }
                return;
            } else {
                I(r((int) x5, (int) y5), pointerId3);
                int i9 = this.f11h[pointerId3];
                int i10 = this.f18p;
                if ((i9 & i10) != 0) {
                    this.r.h(i9 & i10, pointerId3);
                    return;
                }
                return;
            }
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = motionEvent.getPointerId(actionIndex);
        if (this.f5a == 1 && pointerId4 == this.f7c) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (true) {
                if (i3 >= pointerCount2) {
                    i2 = -1;
                    break;
                }
                int pointerId5 = motionEvent.getPointerId(i3);
                if (pointerId5 != this.f7c) {
                    View viewR3 = r((int) motionEvent.getX(i3), (int) motionEvent.getY(i3));
                    View view = this.s;
                    if (viewR3 == view && I(view, pointerId5)) {
                        i2 = this.f7c;
                        break;
                    }
                }
                i3++;
            }
            if (i2 == -1) {
                A();
            }
        }
        h(pointerId4);
    }

    public static abstract class c {
        public abstract int a(View view, int i2, int i3);

        public abstract int b(View view, int i2, int i3);

        public int d(View view) {
            return 0;
        }

        public int e(View view) {
            return 0;
        }

        public boolean g(int i2) {
            return false;
        }

        public abstract void j(int i2);

        public abstract void k(View view, int i2, int i3, int i4, int i5);

        public abstract void l(View view, float f2, float f3);

        public abstract boolean m(View view, int i2);

        public int c(int i2) {
            return i2;
        }

        public void f(int i2, int i3) {
        }

        public void h(int i2, int i3) {
        }

        public void i(View view, int i2) {
        }
    }
}
