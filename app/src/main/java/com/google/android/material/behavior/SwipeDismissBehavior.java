package com.google.android.material.behavior;

import B.a;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.M;

/* loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.b {

    /* renamed from: a, reason: collision with root package name */
    B.a f5645a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f5646b;

    /* renamed from: d, reason: collision with root package name */
    private boolean f5648d;

    /* renamed from: c, reason: collision with root package name */
    private float f5647c = 0.0f;
    int e = 2;

    /* renamed from: f, reason: collision with root package name */
    float f5649f = 0.5f;

    /* renamed from: g, reason: collision with root package name */
    float f5650g = 0.0f;

    /* renamed from: h, reason: collision with root package name */
    float f5651h = 0.5f;

    /* renamed from: i, reason: collision with root package name */
    private final a.c f5652i = new a();

    class a extends a.c {

        /* renamed from: a, reason: collision with root package name */
        private int f5653a;

        /* renamed from: b, reason: collision with root package name */
        private int f5654b = -1;

        a() {
        }

        private boolean n(View view, float f2) {
            if (f2 == 0.0f) {
                return Math.abs(view.getLeft() - this.f5653a) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.f5649f);
            }
            boolean z2 = M.y(view) == 1;
            int i2 = SwipeDismissBehavior.this.e;
            if (i2 == 2) {
                return true;
            }
            if (i2 == 0) {
                if (z2) {
                    if (f2 >= 0.0f) {
                        return false;
                    }
                } else if (f2 <= 0.0f) {
                    return false;
                }
                return true;
            }
            if (i2 != 1) {
                return false;
            }
            if (z2) {
                if (f2 <= 0.0f) {
                    return false;
                }
            } else if (f2 >= 0.0f) {
                return false;
            }
            return true;
        }

        @Override // B.a.c
        public int a(View view, int i2, int i3) {
            int width;
            int width2;
            int width3;
            boolean z2 = M.y(view) == 1;
            int i4 = SwipeDismissBehavior.this.e;
            if (i4 == 0) {
                if (z2) {
                    width = this.f5653a - view.getWidth();
                    width2 = this.f5653a;
                } else {
                    width = this.f5653a;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (i4 != 1) {
                width = this.f5653a - view.getWidth();
                width2 = view.getWidth() + this.f5653a;
            } else if (z2) {
                width = this.f5653a;
                width3 = view.getWidth();
                width2 = width3 + width;
            } else {
                width = this.f5653a - view.getWidth();
                width2 = this.f5653a;
            }
            return SwipeDismissBehavior.F(width, i2, width2);
        }

        @Override // B.a.c
        public int b(View view, int i2, int i3) {
            return view.getTop();
        }

        @Override // B.a.c
        public int d(View view) {
            return view.getWidth();
        }

        @Override // B.a.c
        public void i(View view, int i2) {
            this.f5654b = i2;
            this.f5653a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // B.a.c
        public void j(int i2) {
            SwipeDismissBehavior.this.getClass();
        }

        @Override // B.a.c
        public void k(View view, int i2, int i3, int i4, int i5) {
            float width = this.f5653a + (view.getWidth() * SwipeDismissBehavior.this.f5650g);
            float width2 = this.f5653a + (view.getWidth() * SwipeDismissBehavior.this.f5651h);
            float f2 = i2;
            if (f2 <= width) {
                view.setAlpha(1.0f);
            } else if (f2 >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.E(0.0f, 1.0f - SwipeDismissBehavior.H(width, width2, f2), 1.0f));
            }
        }

        @Override // B.a.c
        public void l(View view, float f2, float f3) {
            int i2;
            boolean z2;
            this.f5654b = -1;
            int width = view.getWidth();
            if (n(view, f2)) {
                int left = view.getLeft();
                int i3 = this.f5653a;
                i2 = left < i3 ? i3 - width : i3 + width;
                z2 = true;
            } else {
                i2 = this.f5653a;
                z2 = false;
            }
            if (SwipeDismissBehavior.this.f5645a.F(i2, view.getTop())) {
                M.a0(view, new b(view, z2));
            } else if (z2) {
                SwipeDismissBehavior.this.getClass();
            }
        }

        @Override // B.a.c
        public boolean m(View view, int i2) {
            return this.f5654b == -1 && SwipeDismissBehavior.this.D(view);
        }
    }

    private class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final View f5656a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f5657b;

        b(View view, boolean z2) {
            this.f5656a = view;
            this.f5657b = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            B.a aVar = SwipeDismissBehavior.this.f5645a;
            if (aVar != null && aVar.k(true)) {
                M.a0(this.f5656a, this);
            } else if (this.f5657b) {
                SwipeDismissBehavior.this.getClass();
            }
        }
    }

    static float E(float f2, float f3, float f4) {
        return Math.min(Math.max(f2, f3), f4);
    }

    static int F(int i2, int i3, int i4) {
        return Math.min(Math.max(i2, i3), i4);
    }

    private void G(ViewGroup viewGroup) {
        if (this.f5645a == null) {
            this.f5645a = this.f5648d ? B.a.l(viewGroup, this.f5647c, this.f5652i) : B.a.m(viewGroup, this.f5652i);
        }
    }

    static float H(float f2, float f3, float f4) {
        return (f4 - f2) / (f3 - f2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean C(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        B.a aVar = this.f5645a;
        if (aVar == null) {
            return false;
        }
        aVar.z(motionEvent);
        return true;
    }

    public boolean D(View view) {
        return true;
    }

    public void I(float f2) {
        this.f5651h = E(0.0f, f2, 1.0f);
    }

    public void J(float f2) {
        this.f5650g = E(0.0f, f2, 1.0f);
    }

    public void K(int i2) {
        this.e = i2;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean z2 = this.f5646b;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z2 = coordinatorLayout.z(view, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f5646b = z2;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f5646b = false;
        }
        if (!z2) {
            return false;
        }
        G(coordinatorLayout);
        return this.f5645a.G(motionEvent);
    }
}
