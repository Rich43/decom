package androidx.core.view;

import android.view.View;
import android.view.ViewParent;

/* loaded from: classes.dex */
public class B {

    /* renamed from: a, reason: collision with root package name */
    private ViewParent f3081a;

    /* renamed from: b, reason: collision with root package name */
    private ViewParent f3082b;

    /* renamed from: c, reason: collision with root package name */
    private final View f3083c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f3084d;
    private int[] e;

    public B(View view) {
        this.f3083c = view;
    }

    private boolean h(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        ViewParent viewParentI;
        int i7;
        int i8;
        int[] iArr3;
        if (!m() || (viewParentI = i(i6)) == null) {
            return false;
        }
        if (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.f3083c.getLocationInWindow(iArr);
            i7 = iArr[0];
            i8 = iArr[1];
        } else {
            i7 = 0;
            i8 = 0;
        }
        if (iArr2 == null) {
            int[] iArrJ = j();
            iArrJ[0] = 0;
            iArrJ[1] = 0;
            iArr3 = iArrJ;
        } else {
            iArr3 = iArr2;
        }
        T.d(viewParentI, this.f3083c, i2, i3, i4, i5, i6, iArr3);
        if (iArr != null) {
            this.f3083c.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i7;
            iArr[1] = iArr[1] - i8;
        }
        return true;
    }

    private ViewParent i(int i2) {
        if (i2 == 0) {
            return this.f3081a;
        }
        if (i2 != 1) {
            return null;
        }
        return this.f3082b;
    }

    private int[] j() {
        if (this.e == null) {
            this.e = new int[2];
        }
        return this.e;
    }

    private void o(int i2, ViewParent viewParent) {
        if (i2 == 0) {
            this.f3081a = viewParent;
        } else {
            if (i2 != 1) {
                return;
            }
            this.f3082b = viewParent;
        }
    }

    public boolean a(float f2, float f3, boolean z2) {
        ViewParent viewParentI;
        if (!m() || (viewParentI = i(0)) == null) {
            return false;
        }
        return T.a(viewParentI, this.f3083c, f2, f3, z2);
    }

    public boolean b(float f2, float f3) {
        ViewParent viewParentI;
        if (!m() || (viewParentI = i(0)) == null) {
            return false;
        }
        return T.b(viewParentI, this.f3083c, f2, f3);
    }

    public boolean c(int i2, int i3, int[] iArr, int[] iArr2) {
        return d(i2, i3, iArr, iArr2, 0);
    }

    public boolean d(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        ViewParent viewParentI;
        int i5;
        int i6;
        if (!m() || (viewParentI = i(i4)) == null) {
            return false;
        }
        if (i2 == 0 && i3 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
        if (iArr2 != null) {
            this.f3083c.getLocationInWindow(iArr2);
            i5 = iArr2[0];
            i6 = iArr2[1];
        } else {
            i5 = 0;
            i6 = 0;
        }
        if (iArr == null) {
            iArr = j();
        }
        iArr[0] = 0;
        iArr[1] = 0;
        T.c(viewParentI, this.f3083c, i2, i3, iArr, i4);
        if (iArr2 != null) {
            this.f3083c.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i5;
            iArr2[1] = iArr2[1] - i6;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    public void e(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        h(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    public boolean f(int i2, int i3, int i4, int i5, int[] iArr) {
        return h(i2, i3, i4, i5, iArr, 0, null);
    }

    public boolean g(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        return h(i2, i3, i4, i5, iArr, i6, null);
    }

    public boolean k() {
        return l(0);
    }

    public boolean l(int i2) {
        return i(i2) != null;
    }

    public boolean m() {
        return this.f3084d;
    }

    public void n(boolean z2) {
        if (this.f3084d) {
            M.y0(this.f3083c);
        }
        this.f3084d = z2;
    }

    public boolean p(int i2) {
        return q(i2, 0);
    }

    public boolean q(int i2, int i3) {
        if (l(i3)) {
            return true;
        }
        if (!m()) {
            return false;
        }
        View view = this.f3083c;
        for (ViewParent parent = this.f3083c.getParent(); parent != null; parent = parent.getParent()) {
            if (T.f(parent, view, this.f3083c, i2, i3)) {
                o(i3, parent);
                T.e(parent, view, this.f3083c, i2, i3);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public void r() {
        s(0);
    }

    public void s(int i2) {
        ViewParent viewParentI = i(i2);
        if (viewParentI != null) {
            T.g(viewParentI, this.f3083c, i2);
            o(i2, null);
        }
    }
}
