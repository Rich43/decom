package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.core.view.C0158a;
import androidx.core.view.F;
import androidx.core.view.M;
import androidx.core.view.Z;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import w.C0353E;

/* loaded from: classes.dex */
public class ViewPager extends ViewGroup {

    /* renamed from: f0, reason: collision with root package name */
    static final int[] f4486f0 = {R.attr.layout_gravity};

    /* renamed from: g0, reason: collision with root package name */
    private static final Comparator f4487g0 = new a();

    /* renamed from: h0, reason: collision with root package name */
    private static final Interpolator f4488h0 = new b();

    /* renamed from: i0, reason: collision with root package name */
    private static final m f4489i0 = new m();

    /* renamed from: A, reason: collision with root package name */
    private int f4490A;

    /* renamed from: B, reason: collision with root package name */
    private int f4491B;

    /* renamed from: C, reason: collision with root package name */
    private int f4492C;

    /* renamed from: D, reason: collision with root package name */
    private float f4493D;

    /* renamed from: E, reason: collision with root package name */
    private float f4494E;

    /* renamed from: F, reason: collision with root package name */
    private float f4495F;

    /* renamed from: G, reason: collision with root package name */
    private float f4496G;

    /* renamed from: H, reason: collision with root package name */
    private int f4497H;

    /* renamed from: I, reason: collision with root package name */
    private VelocityTracker f4498I;

    /* renamed from: J, reason: collision with root package name */
    private int f4499J;

    /* renamed from: K, reason: collision with root package name */
    private int f4500K;

    /* renamed from: L, reason: collision with root package name */
    private int f4501L;

    /* renamed from: M, reason: collision with root package name */
    private int f4502M;

    /* renamed from: N, reason: collision with root package name */
    private boolean f4503N;

    /* renamed from: O, reason: collision with root package name */
    private EdgeEffect f4504O;

    /* renamed from: P, reason: collision with root package name */
    private EdgeEffect f4505P;

    /* renamed from: Q, reason: collision with root package name */
    private boolean f4506Q;

    /* renamed from: R, reason: collision with root package name */
    private boolean f4507R;

    /* renamed from: S, reason: collision with root package name */
    private boolean f4508S;

    /* renamed from: T, reason: collision with root package name */
    private int f4509T;

    /* renamed from: U, reason: collision with root package name */
    private List f4510U;

    /* renamed from: V, reason: collision with root package name */
    private i f4511V;

    /* renamed from: W, reason: collision with root package name */
    private i f4512W;

    /* renamed from: a, reason: collision with root package name */
    private int f4513a;

    /* renamed from: a0, reason: collision with root package name */
    private List f4514a0;

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList f4515b;

    /* renamed from: b0, reason: collision with root package name */
    private int f4516b0;

    /* renamed from: c, reason: collision with root package name */
    private final f f4517c;

    /* renamed from: c0, reason: collision with root package name */
    private ArrayList f4518c0;

    /* renamed from: d, reason: collision with root package name */
    private final Rect f4519d;

    /* renamed from: d0, reason: collision with root package name */
    private final Runnable f4520d0;
    androidx.viewpager.widget.a e;

    /* renamed from: e0, reason: collision with root package name */
    private int f4521e0;

    /* renamed from: f, reason: collision with root package name */
    int f4522f;

    /* renamed from: g, reason: collision with root package name */
    private int f4523g;

    /* renamed from: h, reason: collision with root package name */
    private Parcelable f4524h;

    /* renamed from: i, reason: collision with root package name */
    private ClassLoader f4525i;

    /* renamed from: j, reason: collision with root package name */
    private Scroller f4526j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f4527k;

    /* renamed from: l, reason: collision with root package name */
    private j f4528l;

    /* renamed from: m, reason: collision with root package name */
    private int f4529m;

    /* renamed from: n, reason: collision with root package name */
    private Drawable f4530n;
    private int o;

    /* renamed from: p, reason: collision with root package name */
    private int f4531p;

    /* renamed from: q, reason: collision with root package name */
    private float f4532q;
    private float r;
    private int s;

    /* renamed from: t, reason: collision with root package name */
    private int f4533t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f4534u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f4535v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f4536w;

    /* renamed from: x, reason: collision with root package name */
    private int f4537x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f4538y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f4539z;

    static class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(f fVar, f fVar2) {
            return fVar.f4544b - fVar2.f4544b;
        }
    }

    static class b implements Interpolator {
        b() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            ViewPager.this.setScrollState(0);
            ViewPager.this.C();
        }
    }

    class d implements F {

        /* renamed from: a, reason: collision with root package name */
        private final Rect f4541a = new Rect();

        d() {
        }

        @Override // androidx.core.view.F
        public Z a(View view, Z z2) {
            Z zW = M.W(view, z2);
            if (zW.n()) {
                return zW;
            }
            Rect rect = this.f4541a;
            rect.left = zW.i();
            rect.top = zW.k();
            rect.right = zW.j();
            rect.bottom = zW.h();
            int childCount = ViewPager.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                Z zG = M.g(ViewPager.this.getChildAt(i2), zW);
                rect.left = Math.min(zG.i(), rect.left);
                rect.top = Math.min(zG.k(), rect.top);
                rect.right = Math.min(zG.j(), rect.right);
                rect.bottom = Math.min(zG.h(), rect.bottom);
            }
            return zW.o(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface e {
    }

    static class f {

        /* renamed from: a, reason: collision with root package name */
        Object f4543a;

        /* renamed from: b, reason: collision with root package name */
        int f4544b;

        /* renamed from: c, reason: collision with root package name */
        boolean f4545c;

        /* renamed from: d, reason: collision with root package name */
        float f4546d;
        float e;

        f() {
        }
    }

    class h extends C0158a {
        h() {
        }

        private boolean n() {
            androidx.viewpager.widget.a aVar = ViewPager.this.e;
            return aVar != null && aVar.d() > 1;
        }

        @Override // androidx.core.view.C0158a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            androidx.viewpager.widget.a aVar;
            super.f(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(n());
            if (accessibilityEvent.getEventType() != 4096 || (aVar = ViewPager.this.e) == null) {
                return;
            }
            accessibilityEvent.setItemCount(aVar.d());
            accessibilityEvent.setFromIndex(ViewPager.this.f4522f);
            accessibilityEvent.setToIndex(ViewPager.this.f4522f);
        }

        @Override // androidx.core.view.C0158a
        public void g(View view, C0353E c0353e) {
            super.g(view, c0353e);
            c0353e.Y(ViewPager.class.getName());
            c0353e.e0(n());
            if (ViewPager.this.canScrollHorizontally(1)) {
                c0353e.a(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                c0353e.a(8192);
            }
        }

        @Override // androidx.core.view.C0158a
        public boolean j(View view, int i2, Bundle bundle) throws Resources.NotFoundException {
            if (super.j(view, i2, bundle)) {
                return true;
            }
            if (i2 == 4096) {
                if (!ViewPager.this.canScrollHorizontally(1)) {
                    return false;
                }
                ViewPager viewPager = ViewPager.this;
                viewPager.setCurrentItem(viewPager.f4522f + 1);
                return true;
            }
            if (i2 != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                return false;
            }
            ViewPager viewPager2 = ViewPager.this;
            viewPager2.setCurrentItem(viewPager2.f4522f - 1);
            return true;
        }
    }

    public interface i {
        void a(int i2, float f2, int i3);

        void b(int i2);

        void c(int i2);
    }

    private class j extends DataSetObserver {
        j() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() throws Resources.NotFoundException {
            ViewPager.this.g();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() throws Resources.NotFoundException {
            ViewPager.this.g();
        }
    }

    public static class k extends A.a {
        public static final Parcelable.Creator<k> CREATOR = new a();

        /* renamed from: c, reason: collision with root package name */
        int f4554c;

        /* renamed from: d, reason: collision with root package name */
        Parcelable f4555d;
        ClassLoader e;

        static class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public k createFromParcel(Parcel parcel) {
                return new k(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public k createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new k(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public k[] newArray(int i2) {
                return new k[i2];
            }
        }

        public k(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f4554c + "}";
        }

        @Override // A.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f4554c);
            parcel.writeParcelable(this.f4555d, i2);
        }

        k(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f4554c = parcel.readInt();
            this.f4555d = parcel.readParcelable(classLoader);
            this.e = classLoader;
        }
    }

    public static class l implements i {
        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void b(int i2) {
        }
    }

    static class m implements Comparator {
        m() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            g gVar = (g) view.getLayoutParams();
            g gVar2 = (g) view2.getLayoutParams();
            boolean z2 = gVar.f4547a;
            return z2 != gVar2.f4547a ? z2 ? 1 : -1 : gVar.e - gVar2.e;
        }
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4515b = new ArrayList();
        this.f4517c = new f();
        this.f4519d = new Rect();
        this.f4523g = -1;
        this.f4524h = null;
        this.f4525i = null;
        this.f4532q = -3.4028235E38f;
        this.r = Float.MAX_VALUE;
        this.f4537x = 1;
        this.f4497H = -1;
        this.f4506Q = true;
        this.f4507R = false;
        this.f4520d0 = new c();
        this.f4521e0 = 0;
        t();
    }

    private boolean A(int i2) {
        if (this.f4515b.size() == 0) {
            if (this.f4506Q) {
                return false;
            }
            this.f4508S = false;
            w(0, 0.0f, 0);
            if (this.f4508S) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        f fVarR = r();
        int clientWidth = getClientWidth();
        int i3 = this.f4529m;
        int i4 = clientWidth + i3;
        float f2 = clientWidth;
        int i5 = fVarR.f4544b;
        float f3 = ((i2 / f2) - fVarR.e) / (fVarR.f4546d + (i3 / f2));
        this.f4508S = false;
        w(i5, f3, (int) (i4 * f3));
        if (this.f4508S) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private boolean B(float f2) {
        boolean z2;
        boolean z3;
        float f3 = this.f4493D - f2;
        this.f4493D = f2;
        float scrollX = getScrollX() + f3;
        float clientWidth = getClientWidth();
        float f4 = this.f4532q * clientWidth;
        float f5 = this.r * clientWidth;
        boolean z4 = false;
        f fVar = (f) this.f4515b.get(0);
        ArrayList arrayList = this.f4515b;
        f fVar2 = (f) arrayList.get(arrayList.size() - 1);
        if (fVar.f4544b != 0) {
            f4 = fVar.e * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (fVar2.f4544b != this.e.d() - 1) {
            f5 = fVar2.e * clientWidth;
            z3 = false;
        } else {
            z3 = true;
        }
        if (scrollX < f4) {
            if (z2) {
                this.f4504O.onPull(Math.abs(f4 - scrollX) / clientWidth);
                z4 = true;
            }
            scrollX = f4;
        } else if (scrollX > f5) {
            if (z3) {
                this.f4505P.onPull(Math.abs(scrollX - f5) / clientWidth);
                z4 = true;
            }
            scrollX = f5;
        }
        int i2 = (int) scrollX;
        this.f4493D += scrollX - i2;
        scrollTo(i2, getScrollY());
        A(i2);
        return z4;
    }

    private void E(int i2, int i3, int i4, int i5) {
        if (i3 > 0 && !this.f4515b.isEmpty()) {
            if (!this.f4526j.isFinished()) {
                this.f4526j.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i3 - getPaddingLeft()) - getPaddingRight()) + i5)) * (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)), getScrollY());
                return;
            }
        }
        f fVarS = s(this.f4522f);
        int iMin = (int) ((fVarS != null ? Math.min(fVarS.e, this.r) : 0.0f) * ((i2 - getPaddingLeft()) - getPaddingRight()));
        if (iMin != getScrollX()) {
            f(false);
            scrollTo(iMin, getScrollY());
        }
    }

    private void F() {
        int i2 = 0;
        while (i2 < getChildCount()) {
            if (!((g) getChildAt(i2).getLayoutParams()).f4547a) {
                removeViewAt(i2);
                i2--;
            }
            i2++;
        }
    }

    private void G(boolean z2) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z2);
        }
    }

    private boolean H() {
        this.f4497H = -1;
        m();
        this.f4504O.onRelease();
        this.f4505P.onRelease();
        return this.f4504O.isFinished() || this.f4505P.isFinished();
    }

    private void I(int i2, boolean z2, int i3, boolean z3) throws Resources.NotFoundException {
        f fVarS = s(i2);
        int clientWidth = fVarS != null ? (int) (getClientWidth() * Math.max(this.f4532q, Math.min(fVarS.e, this.r))) : 0;
        if (z2) {
            M(clientWidth, 0, i3);
            if (z3) {
                j(i2);
                return;
            }
            return;
        }
        if (z3) {
            j(i2);
        }
        f(false);
        scrollTo(clientWidth, 0);
        A(clientWidth);
    }

    private void N() {
        if (this.f4516b0 != 0) {
            ArrayList arrayList = this.f4518c0;
            if (arrayList == null) {
                this.f4518c0 = new ArrayList();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                this.f4518c0.add(getChildAt(i2));
            }
            Collections.sort(this.f4518c0, f4489i0);
        }
    }

    private void d(f fVar, int i2, f fVar2) {
        int i3;
        int i4;
        f fVar3;
        f fVar4;
        int iD = this.e.d();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? this.f4529m / clientWidth : 0.0f;
        if (fVar2 != null) {
            int i5 = fVar2.f4544b;
            int i6 = fVar.f4544b;
            if (i5 < i6) {
                float f3 = fVar2.e + fVar2.f4546d + f2;
                int i7 = i5 + 1;
                int i8 = 0;
                while (i7 <= fVar.f4544b && i8 < this.f4515b.size()) {
                    Object obj = this.f4515b.get(i8);
                    while (true) {
                        fVar4 = (f) obj;
                        if (i7 <= fVar4.f4544b || i8 >= this.f4515b.size() - 1) {
                            break;
                        }
                        i8++;
                        obj = this.f4515b.get(i8);
                    }
                    while (i7 < fVar4.f4544b) {
                        f3 += this.e.f(i7) + f2;
                        i7++;
                    }
                    fVar4.e = f3;
                    f3 += fVar4.f4546d + f2;
                    i7++;
                }
            } else if (i5 > i6) {
                int size = this.f4515b.size() - 1;
                float f4 = fVar2.e;
                while (true) {
                    i5--;
                    if (i5 < fVar.f4544b || size < 0) {
                        break;
                    }
                    Object obj2 = this.f4515b.get(size);
                    while (true) {
                        fVar3 = (f) obj2;
                        if (i5 >= fVar3.f4544b || size <= 0) {
                            break;
                        }
                        size--;
                        obj2 = this.f4515b.get(size);
                    }
                    while (i5 > fVar3.f4544b) {
                        f4 -= this.e.f(i5) + f2;
                        i5--;
                    }
                    f4 -= fVar3.f4546d + f2;
                    fVar3.e = f4;
                }
            }
        }
        int size2 = this.f4515b.size();
        float f5 = fVar.e;
        int i9 = fVar.f4544b;
        int i10 = i9 - 1;
        this.f4532q = i9 == 0 ? f5 : -3.4028235E38f;
        int i11 = iD - 1;
        this.r = i9 == i11 ? (fVar.f4546d + f5) - 1.0f : Float.MAX_VALUE;
        int i12 = i2 - 1;
        while (i12 >= 0) {
            f fVar5 = (f) this.f4515b.get(i12);
            while (true) {
                i4 = fVar5.f4544b;
                if (i10 <= i4) {
                    break;
                }
                f5 -= this.e.f(i10) + f2;
                i10--;
            }
            f5 -= fVar5.f4546d + f2;
            fVar5.e = f5;
            if (i4 == 0) {
                this.f4532q = f5;
            }
            i12--;
            i10--;
        }
        float f6 = fVar.e + fVar.f4546d + f2;
        int i13 = fVar.f4544b + 1;
        int i14 = i2 + 1;
        while (i14 < size2) {
            f fVar6 = (f) this.f4515b.get(i14);
            while (true) {
                i3 = fVar6.f4544b;
                if (i13 >= i3) {
                    break;
                }
                f6 += this.e.f(i13) + f2;
                i13++;
            }
            if (i3 == i11) {
                this.r = (fVar6.f4546d + f6) - 1.0f;
            }
            fVar6.e = f6;
            f6 += fVar6.f4546d + f2;
            i14++;
            i13++;
        }
        this.f4507R = false;
    }

    private void f(boolean z2) {
        boolean z3 = this.f4521e0 == 2;
        if (z3) {
            setScrollingCacheEnabled(false);
            if (!this.f4526j.isFinished()) {
                this.f4526j.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.f4526j.getCurrX();
                int currY = this.f4526j.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        A(currX);
                    }
                }
            }
        }
        this.f4536w = false;
        for (int i2 = 0; i2 < this.f4515b.size(); i2++) {
            f fVar = (f) this.f4515b.get(i2);
            if (fVar.f4545c) {
                fVar.f4545c = false;
                z3 = true;
            }
        }
        if (z3) {
            if (z2) {
                M.a0(this, this.f4520d0);
            } else {
                this.f4520d0.run();
            }
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private int h(int i2, float f2, int i3, int i4) {
        if (Math.abs(i4) <= this.f4501L || Math.abs(i3) <= this.f4499J) {
            i2 += (int) (f2 + (i2 >= this.f4522f ? 0.4f : 0.6f));
        } else if (i3 <= 0) {
            i2++;
        }
        if (this.f4515b.size() <= 0) {
            return i2;
        }
        return Math.max(((f) this.f4515b.get(0)).f4544b, Math.min(i2, ((f) this.f4515b.get(r4.size() - 1)).f4544b));
    }

    private void i(int i2, float f2, int i3) {
        i iVar = this.f4511V;
        if (iVar != null) {
            iVar.a(i2, f2, i3);
        }
        List list = this.f4510U;
        if (list != null) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                i iVar2 = (i) this.f4510U.get(i4);
                if (iVar2 != null) {
                    iVar2.a(i2, f2, i3);
                }
            }
        }
        i iVar3 = this.f4512W;
        if (iVar3 != null) {
            iVar3.a(i2, f2, i3);
        }
    }

    private void j(int i2) {
        i iVar = this.f4511V;
        if (iVar != null) {
            iVar.c(i2);
        }
        List list = this.f4510U;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                i iVar2 = (i) this.f4510U.get(i3);
                if (iVar2 != null) {
                    iVar2.c(i2);
                }
            }
        }
        i iVar3 = this.f4512W;
        if (iVar3 != null) {
            iVar3.c(i2);
        }
    }

    private void k(int i2) {
        i iVar = this.f4511V;
        if (iVar != null) {
            iVar.b(i2);
        }
        List list = this.f4510U;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                i iVar2 = (i) this.f4510U.get(i3);
                if (iVar2 != null) {
                    iVar2.b(i2);
                }
            }
        }
        i iVar3 = this.f4512W;
        if (iVar3 != null) {
            iVar3.b(i2);
        }
    }

    private void m() {
        this.f4538y = false;
        this.f4539z = false;
        VelocityTracker velocityTracker = this.f4498I;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f4498I = null;
        }
    }

    private Rect o(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private f r() {
        int i2;
        int clientWidth = getClientWidth();
        float f2 = 0.0f;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f3 = clientWidth > 0 ? this.f4529m / clientWidth : 0.0f;
        f fVar = null;
        float f4 = 0.0f;
        int i3 = -1;
        int i4 = 0;
        boolean z2 = true;
        while (i4 < this.f4515b.size()) {
            f fVar2 = (f) this.f4515b.get(i4);
            if (!z2 && fVar2.f4544b != (i2 = i3 + 1)) {
                fVar2 = this.f4517c;
                fVar2.e = f2 + f4 + f3;
                fVar2.f4544b = i2;
                fVar2.f4546d = this.e.f(i2);
                i4--;
            }
            f fVar3 = fVar2;
            f2 = fVar3.e;
            float f5 = fVar3.f4546d + f2 + f3;
            if (!z2 && scrollX < f2) {
                return fVar;
            }
            if (scrollX < f5 || i4 == this.f4515b.size() - 1) {
                return fVar3;
            }
            int i5 = fVar3.f4544b;
            float f6 = fVar3.f4546d;
            i4++;
            z2 = false;
            i3 = i5;
            f4 = f6;
            fVar = fVar3;
        }
        return fVar;
    }

    private void setScrollingCacheEnabled(boolean z2) {
        if (this.f4535v != z2) {
            this.f4535v = z2;
        }
    }

    private static boolean u(View view) {
        return view.getClass().getAnnotation(e.class) != null;
    }

    private boolean v(float f2, float f3) {
        return (f2 < ((float) this.f4491B) && f3 > 0.0f) || (f2 > ((float) (getWidth() - this.f4491B)) && f3 < 0.0f);
    }

    private void x(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f4497H) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.f4493D = motionEvent.getX(i2);
            this.f4497H = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.f4498I;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    void C() throws Resources.NotFoundException {
        D(this.f4522f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0066, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00cb A[PHI: r7 r10 r15
  0x00cb: PHI (r7v6 int) = (r7v5 int), (r7v4 int), (r7v9 int) binds: [B:64:0x00ef, B:61:0x00d9, B:53:0x00c0] A[DONT_GENERATE, DONT_INLINE]
  0x00cb: PHI (r10v9 int) = (r10v1 int), (r10v8 int), (r10v12 int) binds: [B:64:0x00ef, B:61:0x00d9, B:53:0x00c0] A[DONT_GENERATE, DONT_INLINE]
  0x00cb: PHI (r15v7 float) = (r15v5 float), (r15v6 float), (r15v4 float) binds: [B:64:0x00ef, B:61:0x00d9, B:53:0x00c0] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void D(int r18) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 615
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.D(int):void");
    }

    public void J(int i2, boolean z2) throws Resources.NotFoundException {
        this.f4536w = false;
        K(i2, z2, false);
    }

    void K(int i2, boolean z2, boolean z3) throws Resources.NotFoundException {
        L(i2, z2, z3, 0);
    }

    void L(int i2, boolean z2, boolean z3, int i3) throws Resources.NotFoundException {
        androidx.viewpager.widget.a aVar = this.e;
        if (aVar == null || aVar.d() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z3 && this.f4522f == i2 && this.f4515b.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 >= this.e.d()) {
            i2 = this.e.d() - 1;
        }
        int i4 = this.f4537x;
        int i5 = this.f4522f;
        if (i2 > i5 + i4 || i2 < i5 - i4) {
            for (int i6 = 0; i6 < this.f4515b.size(); i6++) {
                ((f) this.f4515b.get(i6)).f4545c = true;
            }
        }
        boolean z4 = this.f4522f != i2;
        if (!this.f4506Q) {
            D(i2);
            I(i2, z2, i3, z4);
        } else {
            this.f4522f = i2;
            if (z4) {
                j(i2);
            }
            requestLayout();
        }
    }

    void M(int i2, int i3, int i4) throws Resources.NotFoundException {
        int scrollX;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.f4526j;
        if (scroller == null || scroller.isFinished()) {
            scrollX = getScrollX();
        } else {
            scrollX = this.f4527k ? this.f4526j.getCurrX() : this.f4526j.getStartX();
            this.f4526j.abortAnimation();
            setScrollingCacheEnabled(false);
        }
        int i5 = scrollX;
        int scrollY = getScrollY();
        int i6 = i2 - i5;
        int i7 = i3 - scrollY;
        if (i6 == 0 && i7 == 0) {
            f(false);
            C();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i8 = clientWidth / 2;
        float f2 = clientWidth;
        float f3 = i8;
        float fL = f3 + (l(Math.min(1.0f, (Math.abs(i6) * 1.0f) / f2)) * f3);
        int iAbs = Math.abs(i4);
        int iMin = Math.min(iAbs > 0 ? Math.round(Math.abs(fL / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i6) / ((f2 * this.e.f(this.f4522f)) + this.f4529m)) + 1.0f) * 100.0f), 600);
        this.f4527k = false;
        this.f4526j.startScroll(i5, scrollY, i6, i7, iMin);
        M.Z(this);
    }

    f a(int i2, int i3) {
        f fVar = new f();
        fVar.f4544b = i2;
        fVar.f4543a = this.e.g(this, i2);
        fVar.f4546d = this.e.f(i2);
        if (i3 < 0 || i3 >= this.f4515b.size()) {
            this.f4515b.add(fVar);
        } else {
            this.f4515b.add(i3, fVar);
        }
        return fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList arrayList, int i2, int i3) {
        f fVarQ;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && (fVarQ = q(childAt)) != null && fVarQ.f4544b == this.f4522f) {
                    childAt.addFocusables(arrayList, i2, i3);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i3 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList arrayList) {
        f fVarQ;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (fVarQ = q(childAt)) != null && fVarQ.f4544b == this.f4522f) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        g gVar = (g) layoutParams;
        boolean zU = gVar.f4547a | u(view);
        gVar.f4547a = zU;
        if (!this.f4534u) {
            super.addView(view, i2, layoutParams);
        } else {
            if (zU) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            gVar.f4550d = true;
            addViewInLayout(view, i2, layoutParams);
        }
    }

    public void b(i iVar) {
        if (this.f4510U == null) {
            this.f4510U = new ArrayList();
        }
        this.f4510U.add(iVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean c(int r5) {
        /*
            r4 = this;
            android.view.View r0 = r4.findFocus()
            r1 = 0
            if (r0 != r4) goto L9
        L7:
            r0 = r1
            goto L63
        L9:
            if (r0 == 0) goto L63
            android.view.ViewParent r2 = r0.getParent()
        Lf:
            boolean r3 = r2 instanceof android.view.ViewGroup
            if (r3 == 0) goto L1b
            if (r2 != r4) goto L16
            goto L63
        L16:
            android.view.ViewParent r2 = r2.getParent()
            goto Lf
        L1b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            android.view.ViewParent r0 = r0.getParent()
        L2f:
            boolean r3 = r0 instanceof android.view.ViewGroup
            if (r3 == 0) goto L48
            java.lang.String r3 = " => "
            r2.append(r3)
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            android.view.ViewParent r0 = r0.getParent()
            goto L2f
        L48:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "arrowScroll tried to find focus based on non-child current focused view "
            r0.append(r3)
            java.lang.String r2 = r2.toString()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "ViewPager"
            android.util.Log.e(r2, r0)
            goto L7
        L63:
            android.view.FocusFinder r1 = android.view.FocusFinder.getInstance()
            android.view.View r1 = r1.findNextFocus(r4, r0, r5)
            r2 = 66
            r3 = 17
            if (r1 == 0) goto Lb3
            if (r1 == r0) goto Lb3
            if (r5 != r3) goto L93
            android.graphics.Rect r2 = r4.f4519d
            android.graphics.Rect r2 = r4.o(r2, r1)
            int r2 = r2.left
            android.graphics.Rect r3 = r4.f4519d
            android.graphics.Rect r3 = r4.o(r3, r0)
            int r3 = r3.left
            if (r0 == 0) goto L8e
            if (r2 < r3) goto L8e
            boolean r0 = r4.y()
            goto Lca
        L8e:
            boolean r0 = r1.requestFocus()
            goto Lca
        L93:
            if (r5 != r2) goto Lbf
            android.graphics.Rect r2 = r4.f4519d
            android.graphics.Rect r2 = r4.o(r2, r1)
            int r2 = r2.left
            android.graphics.Rect r3 = r4.f4519d
            android.graphics.Rect r3 = r4.o(r3, r0)
            int r3 = r3.left
            if (r0 == 0) goto Lae
            if (r2 > r3) goto Lae
            boolean r0 = r4.z()
            goto Lca
        Lae:
            boolean r0 = r1.requestFocus()
            goto Lca
        Lb3:
            if (r5 == r3) goto Lc6
            r0 = 1
            if (r5 != r0) goto Lb9
            goto Lc6
        Lb9:
            if (r5 == r2) goto Lc1
            r0 = 2
            if (r5 != r0) goto Lbf
            goto Lc1
        Lbf:
            r0 = 0
            goto Lca
        Lc1:
            boolean r0 = r4.z()
            goto Lca
        Lc6:
            boolean r0 = r4.y()
        Lca:
            if (r0 == 0) goto Ld3
            int r5 = android.view.SoundEffectConstants.getContantForFocusDirection(r5)
            r4.playSoundEffect(r5)
        Ld3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.c(int):boolean");
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i2) {
        if (this.e == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i2 < 0 ? scrollX > ((int) (((float) clientWidth) * this.f4532q)) : i2 > 0 && scrollX < ((int) (((float) clientWidth) * this.r));
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof g) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.f4527k = true;
        if (this.f4526j.isFinished() || !this.f4526j.computeScrollOffset()) {
            f(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f4526j.getCurrX();
        int currY = this.f4526j.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!A(currX)) {
                this.f4526j.abortAnimation();
                scrollTo(0, currY);
            }
        }
        M.Z(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || n(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        f fVarQ;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (fVarQ = q(childAt)) != null && fVarQ.f4544b == this.f4522f && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        androidx.viewpager.widget.a aVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean zDraw = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (aVar = this.e) != null && aVar.d() > 1)) {
            if (!this.f4504O.isFinished()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.f4532q * width);
                this.f4504O.setSize(height, width);
                zDraw = this.f4504O.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!this.f4505P.isFinished()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.r + 1.0f)) * width2);
                this.f4505P.setSize(height2, width2);
                zDraw |= this.f4505P.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            this.f4504O.finish();
            this.f4505P.finish();
        }
        if (zDraw) {
            M.Z(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f4530n;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    protected boolean e(View view, boolean z2, int i2, int i3, int i4) {
        int i5;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i6 = i3 + scrollX;
                if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom() && e(childAt, true, i2, i6 - childAt.getLeft(), i5 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z2 && view.canScrollHorizontally(-i2);
    }

    void g() throws Resources.NotFoundException {
        int iD = this.e.d();
        this.f4513a = iD;
        boolean z2 = this.f4515b.size() < (this.f4537x * 2) + 1 && this.f4515b.size() < iD;
        int iMax = this.f4522f;
        int i2 = 0;
        boolean z3 = false;
        while (i2 < this.f4515b.size()) {
            f fVar = (f) this.f4515b.get(i2);
            int iE = this.e.e(fVar.f4543a);
            if (iE != -1) {
                if (iE == -2) {
                    this.f4515b.remove(i2);
                    i2--;
                    if (!z3) {
                        this.e.o(this);
                        z3 = true;
                    }
                    this.e.a(this, fVar.f4544b, fVar.f4543a);
                    int i3 = this.f4522f;
                    if (i3 == fVar.f4544b) {
                        iMax = Math.max(0, Math.min(i3, iD - 1));
                    }
                } else {
                    int i4 = fVar.f4544b;
                    if (i4 != iE) {
                        if (i4 == this.f4522f) {
                            iMax = iE;
                        }
                        fVar.f4544b = iE;
                    }
                }
                z2 = true;
            }
            i2++;
        }
        if (z3) {
            this.e.c(this);
        }
        Collections.sort(this.f4515b, f4487g0);
        if (z2) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                g gVar = (g) getChildAt(i5).getLayoutParams();
                if (!gVar.f4547a) {
                    gVar.f4549c = 0.0f;
                }
            }
            K(iMax, false, true);
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new g();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public androidx.viewpager.widget.a getAdapter() {
        return this.e;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        if (this.f4516b0 == 2) {
            i3 = (i2 - 1) - i3;
        }
        return ((g) ((View) this.f4518c0.get(i3)).getLayoutParams()).f4551f;
    }

    public int getCurrentItem() {
        return this.f4522f;
    }

    public int getOffscreenPageLimit() {
        return this.f4537x;
    }

    public int getPageMargin() {
        return this.f4529m;
    }

    float l(float f2) {
        return (float) Math.sin((f2 - 0.5f) * 0.47123894f);
    }

    public boolean n(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                return keyEvent.hasModifiers(2) ? y() : c(17);
            }
            if (keyCode == 22) {
                return keyEvent.hasModifiers(2) ? z() : c(66);
            }
            if (keyCode == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return c(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return c(1);
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f4506Q = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f4520d0);
        Scroller scroller = this.f4526j;
        if (scroller != null && !scroller.isFinished()) {
            this.f4526j.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i2;
        float f2;
        float f3;
        super.onDraw(canvas);
        if (this.f4529m <= 0 || this.f4530n == null || this.f4515b.size() <= 0 || this.e == null) {
            return;
        }
        int scrollX = getScrollX();
        float width = getWidth();
        float f4 = this.f4529m / width;
        int i3 = 0;
        f fVar = (f) this.f4515b.get(0);
        float f5 = fVar.e;
        int size = this.f4515b.size();
        int i4 = fVar.f4544b;
        int i5 = ((f) this.f4515b.get(size - 1)).f4544b;
        while (i4 < i5) {
            while (true) {
                i2 = fVar.f4544b;
                if (i4 <= i2 || i3 >= size) {
                    break;
                }
                i3++;
                fVar = (f) this.f4515b.get(i3);
            }
            if (i4 == i2) {
                float f6 = fVar.e;
                float f7 = fVar.f4546d;
                f2 = (f6 + f7) * width;
                f5 = f6 + f7 + f4;
            } else {
                float f8 = this.e.f(i4);
                f2 = (f5 + f8) * width;
                f5 += f8 + f4;
            }
            if (this.f4529m + f2 > scrollX) {
                f3 = f4;
                this.f4530n.setBounds(Math.round(f2), this.o, Math.round(this.f4529m + f2), this.f4531p);
                this.f4530n.draw(canvas);
            } else {
                f3 = f4;
            }
            if (f2 > scrollX + r2) {
                return;
            }
            i4++;
            f4 = f3;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) throws Resources.NotFoundException {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            H();
            return false;
        }
        if (action != 0) {
            if (this.f4538y) {
                return true;
            }
            if (this.f4539z) {
                return false;
            }
        }
        if (action == 0) {
            float x2 = motionEvent.getX();
            this.f4495F = x2;
            this.f4493D = x2;
            float y2 = motionEvent.getY();
            this.f4496G = y2;
            this.f4494E = y2;
            this.f4497H = motionEvent.getPointerId(0);
            this.f4539z = false;
            this.f4527k = true;
            this.f4526j.computeScrollOffset();
            if (this.f4521e0 != 2 || Math.abs(this.f4526j.getFinalX() - this.f4526j.getCurrX()) <= this.f4502M) {
                f(false);
                this.f4538y = false;
            } else {
                this.f4526j.abortAnimation();
                this.f4536w = false;
                C();
                this.f4538y = true;
                G(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i2 = this.f4497H;
            if (i2 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i2);
                float x3 = motionEvent.getX(iFindPointerIndex);
                float f2 = x3 - this.f4493D;
                float fAbs = Math.abs(f2);
                float y3 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y3 - this.f4496G);
                if (f2 != 0.0f && !v(this.f4493D, f2) && e(this, false, (int) f2, (int) x3, (int) y3)) {
                    this.f4493D = x3;
                    this.f4494E = y3;
                    this.f4539z = true;
                    return false;
                }
                int i3 = this.f4492C;
                if (fAbs > i3 && fAbs * 0.5f > fAbs2) {
                    this.f4538y = true;
                    G(true);
                    setScrollState(1);
                    float f3 = this.f4495F;
                    float f4 = this.f4492C;
                    this.f4493D = f2 > 0.0f ? f3 + f4 : f3 - f4;
                    this.f4494E = y3;
                    setScrollingCacheEnabled(true);
                } else if (fAbs2 > i3) {
                    this.f4539z = true;
                }
                if (this.f4538y && B(x3)) {
                    M.Z(this);
                }
            }
        } else if (action == 6) {
            x(motionEvent);
        }
        if (this.f4498I == null) {
            this.f4498I = VelocityTracker.obtain();
        }
        this.f4498I.addMovement(motionEvent);
        return this.f4538y;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0094  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onLayout(boolean r19, int r20, int r21, int r22, int r23) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a7  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r14, int r15) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        int i5;
        f fVarQ;
        int childCount = getChildCount();
        if ((i2 & 2) != 0) {
            i4 = childCount;
            i3 = 0;
            i5 = 1;
        } else {
            i3 = childCount - 1;
            i4 = -1;
            i5 = -1;
        }
        while (i3 != i4) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (fVarQ = q(childAt)) != null && fVarQ.f4544b == this.f4522f && childAt.requestFocus(i2, rect)) {
                return true;
            }
            i3 += i5;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) throws Resources.NotFoundException {
        if (!(parcelable instanceof k)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        k kVar = (k) parcelable;
        super.onRestoreInstanceState(kVar.a());
        androidx.viewpager.widget.a aVar = this.e;
        if (aVar != null) {
            aVar.i(kVar.f4555d, kVar.e);
            K(kVar.f4554c, false, true);
        } else {
            this.f4523g = kVar.f4554c;
            this.f4524h = kVar.f4555d;
            this.f4525i = kVar.e;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        k kVar = new k(super.onSaveInstanceState());
        kVar.f4554c = this.f4522f;
        androidx.viewpager.widget.a aVar = this.e;
        if (aVar != null) {
            kVar.f4555d = aVar.j();
        }
        return kVar;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            int i6 = this.f4529m;
            E(i2, i4, i6, i6);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00dc  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 351
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onTouchEvent(android.view.MotionEvent):boolean");
    }

    f p(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent == this) {
                return q(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    f q(View view) {
        for (int i2 = 0; i2 < this.f4515b.size(); i2++) {
            f fVar = (f) this.f4515b.get(i2);
            if (this.e.h(view, fVar.f4543a)) {
                return fVar;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.f4534u) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    f s(int i2) {
        for (int i3 = 0; i3 < this.f4515b.size(); i3++) {
            f fVar = (f) this.f4515b.get(i3);
            if (fVar.f4544b == i2) {
                return fVar;
            }
        }
        return null;
    }

    public void setAdapter(androidx.viewpager.widget.a aVar) throws Resources.NotFoundException {
        androidx.viewpager.widget.a aVar2 = this.e;
        if (aVar2 != null) {
            aVar2.m(null);
            this.e.o(this);
            for (int i2 = 0; i2 < this.f4515b.size(); i2++) {
                f fVar = (f) this.f4515b.get(i2);
                this.e.a(this, fVar.f4544b, fVar.f4543a);
            }
            this.e.c(this);
            this.f4515b.clear();
            F();
            this.f4522f = 0;
            scrollTo(0, 0);
        }
        this.e = aVar;
        this.f4513a = 0;
        if (aVar != null) {
            if (this.f4528l == null) {
                this.f4528l = new j();
            }
            this.e.m(this.f4528l);
            this.f4536w = false;
            boolean z2 = this.f4506Q;
            this.f4506Q = true;
            this.f4513a = this.e.d();
            if (this.f4523g >= 0) {
                this.e.i(this.f4524h, this.f4525i);
                K(this.f4523g, false, true);
                this.f4523g = -1;
                this.f4524h = null;
                this.f4525i = null;
            } else if (z2) {
                requestLayout();
            } else {
                C();
            }
        }
        List list = this.f4514a0;
        if (list == null || list.isEmpty() || this.f4514a0.size() <= 0) {
            return;
        }
        androidx.appcompat.app.F.a(this.f4514a0.get(0));
        throw null;
    }

    public void setCurrentItem(int i2) throws Resources.NotFoundException {
        this.f4536w = false;
        K(i2, !this.f4506Q, false);
    }

    public void setOffscreenPageLimit(int i2) throws Resources.NotFoundException {
        if (i2 < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i2 + " too small; defaulting to 1");
            i2 = 1;
        }
        if (i2 != this.f4537x) {
            this.f4537x = i2;
            C();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(i iVar) {
        this.f4511V = iVar;
    }

    public void setPageMargin(int i2) {
        int i3 = this.f4529m;
        this.f4529m = i2;
        int width = getWidth();
        E(width, width, i2, i3);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f4530n = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    void setScrollState(int i2) {
        if (this.f4521e0 == i2) {
            return;
        }
        this.f4521e0 = i2;
        k(i2);
    }

    void t() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f4526j = new Scroller(context, f4488h0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.f4492C = viewConfiguration.getScaledPagingTouchSlop();
        this.f4499J = (int) (400.0f * f2);
        this.f4500K = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f4504O = new EdgeEffect(context);
        this.f4505P = new EdgeEffect(context);
        this.f4501L = (int) (25.0f * f2);
        this.f4502M = (int) (2.0f * f2);
        this.f4490A = (int) (f2 * 16.0f);
        M.f0(this, new h());
        if (M.w(this) == 0) {
            M.p0(this, 1);
        }
        M.s0(this, new d());
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f4530n;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void w(int r12, float r13, int r14) {
        /*
            r11 = this;
            int r0 = r11.f4509T
            r1 = 1
            if (r0 <= 0) goto L6b
            int r0 = r11.getScrollX()
            int r2 = r11.getPaddingLeft()
            int r3 = r11.getPaddingRight()
            int r4 = r11.getWidth()
            int r5 = r11.getChildCount()
            r6 = 0
        L1a:
            if (r6 >= r5) goto L6b
            android.view.View r7 = r11.getChildAt(r6)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.viewpager.widget.ViewPager$g r8 = (androidx.viewpager.widget.ViewPager.g) r8
            boolean r9 = r8.f4547a
            if (r9 != 0) goto L2b
            goto L68
        L2b:
            int r8 = r8.f4548b
            r8 = r8 & 7
            if (r8 == r1) goto L4f
            r9 = 3
            if (r8 == r9) goto L49
            r9 = 5
            if (r8 == r9) goto L39
            r8 = r2
            goto L5c
        L39:
            int r8 = r4 - r3
            int r9 = r7.getMeasuredWidth()
            int r8 = r8 - r9
            int r9 = r7.getMeasuredWidth()
            int r3 = r3 + r9
        L45:
            r10 = r8
            r8 = r2
            r2 = r10
            goto L5c
        L49:
            int r8 = r7.getWidth()
            int r8 = r8 + r2
            goto L5c
        L4f:
            int r8 = r7.getMeasuredWidth()
            int r8 = r4 - r8
            int r8 = r8 / 2
            int r8 = java.lang.Math.max(r8, r2)
            goto L45
        L5c:
            int r2 = r2 + r0
            int r9 = r7.getLeft()
            int r2 = r2 - r9
            if (r2 == 0) goto L67
            r7.offsetLeftAndRight(r2)
        L67:
            r2 = r8
        L68:
            int r6 = r6 + 1
            goto L1a
        L6b:
            r11.i(r12, r13, r14)
            r11.f4508S = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.w(int, float, int):void");
    }

    boolean y() throws Resources.NotFoundException {
        int i2 = this.f4522f;
        if (i2 <= 0) {
            return false;
        }
        J(i2 - 1, true);
        return true;
    }

    boolean z() throws Resources.NotFoundException {
        androidx.viewpager.widget.a aVar = this.e;
        if (aVar == null || this.f4522f >= aVar.d() - 1) {
            return false;
        }
        J(this.f4522f + 1, true);
        return true;
    }

    public static class g extends ViewGroup.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public boolean f4547a;

        /* renamed from: b, reason: collision with root package name */
        public int f4548b;

        /* renamed from: c, reason: collision with root package name */
        float f4549c;

        /* renamed from: d, reason: collision with root package name */
        boolean f4550d;
        int e;

        /* renamed from: f, reason: collision with root package name */
        int f4551f;

        public g() {
            super(-1, -1);
            this.f4549c = 0.0f;
        }

        public g(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f4549c = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f4486f0);
            this.f4548b = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new g(getContext(), attributeSet);
    }

    public void setPageMarginDrawable(int i2) {
        setPageMarginDrawable(androidx.core.content.a.d(getContext(), i2));
    }
}
