package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.F;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.M;
import java.lang.ref.WeakReference;
import java.util.List;
import t.AbstractC0327a;
import u0.AbstractC0337g;

/* loaded from: classes.dex */
public abstract class AppBarLayout extends LinearLayout {

    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        @Override // com.google.android.material.appbar.c
        public /* bridge */ /* synthetic */ int D() {
            return super.D();
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean V(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i2) {
            return super.V(coordinatorLayout, appBarLayout, i2);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean W(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i2, int i3, int i4, int i5) {
            return super.W(coordinatorLayout, appBarLayout, i2, i3, i4, i5);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void X(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2, int i3, int[] iArr, int i4) {
            super.X(coordinatorLayout, appBarLayout, view, i2, i3, iArr, i4);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void Y(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2, int i3, int i4, int i5, int i6) {
            super.Y(coordinatorLayout, appBarLayout, view, i2, i3, i4, i5, i6);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void Z(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            super.Z(coordinatorLayout, appBarLayout, parcelable);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ Parcelable a0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            return super.a0(coordinatorLayout, appBarLayout);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean b0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i2, int i3) {
            return super.b0(coordinatorLayout, appBarLayout, view, view2, i2, i3);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void c0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2) {
            super.c0(coordinatorLayout, appBarLayout, view, i2);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class ScrollingViewBehavior extends b {
        public ScrollingViewBehavior() {
        }

        private void N(View view, View view2) {
            CoordinatorLayout.b bVarE = ((CoordinatorLayout.e) view2.getLayoutParams()).e();
            if (bVarE instanceof BaseBehavior) {
                M.V(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) bVarE).f5615k) + J()) - G(view2));
            }
        }

        private void O(View view, View view2) {
        }

        @Override // com.google.android.material.appbar.b
        /* bridge */ /* synthetic */ View F(List list) {
            M(list);
            return null;
        }

        @Override // com.google.android.material.appbar.b
        float H(View view) {
            return 0.0f;
        }

        @Override // com.google.android.material.appbar.b
        int I(View view) {
            return super.I(view);
        }

        AppBarLayout M(List list) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
            }
            return null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            N(view, view2);
            O(view, view2);
            return false;
        }

        @Override // com.google.android.material.appbar.c, androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ boolean l(CoordinatorLayout coordinatorLayout, View view, int i2) {
            return super.l(coordinatorLayout, view, i2);
        }

        @Override // com.google.android.material.appbar.b, androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ boolean m(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4, int i5) {
            return super.m(coordinatorLayout, view, i2, i3, i4, i5);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public boolean v(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z2) {
            M(coordinatorLayout.q(view));
            return false;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0337g.f7661w0);
            L(typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC0337g.f7663x0, 0));
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    protected static class BaseBehavior<T extends AppBarLayout> extends com.google.android.material.appbar.a {

        /* renamed from: k, reason: collision with root package name */
        private int f5615k;

        /* renamed from: l, reason: collision with root package name */
        private int f5616l;

        /* renamed from: m, reason: collision with root package name */
        private int f5617m;

        /* renamed from: n, reason: collision with root package name */
        private boolean f5618n;
        private float o;

        /* renamed from: p, reason: collision with root package name */
        private WeakReference f5619p;

        protected static class a extends A.a {
            public static final Parcelable.Creator<a> CREATOR = new C0070a();

            /* renamed from: c, reason: collision with root package name */
            int f5620c;

            /* renamed from: d, reason: collision with root package name */
            float f5621d;
            boolean e;

            /* renamed from: com.google.android.material.appbar.AppBarLayout$BaseBehavior$a$a, reason: collision with other inner class name */
            static class C0070a implements Parcelable.ClassLoaderCreator {
                C0070a() {
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public a createFromParcel(Parcel parcel) {
                    return new a(parcel, null);
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return new a(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public a[] newArray(int i2) {
                    return new a[i2];
                }
            }

            public a(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f5620c = parcel.readInt();
                this.f5621d = parcel.readFloat();
                this.e = parcel.readByte() != 0;
            }

            @Override // A.a, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i2) {
                super.writeToParcel(parcel, i2);
                parcel.writeInt(this.f5620c);
                parcel.writeFloat(this.f5621d);
                parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
            }
        }

        public BaseBehavior() {
            this.f5617m = -1;
        }

        private int R(AppBarLayout appBarLayout, int i2) {
            throw null;
        }

        private void e0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            if (R(appBarLayout, K()) >= 0) {
                throw null;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ void B(CoordinatorLayout coordinatorLayout, View view, View view2, int i2) {
            F.a(view);
            c0(coordinatorLayout, null, view2, i2);
        }

        @Override // com.google.android.material.appbar.a
        /* bridge */ /* synthetic */ boolean F(View view) {
            F.a(view);
            return Q(null);
        }

        @Override // com.google.android.material.appbar.a
        /* bridge */ /* synthetic */ int I(View view) {
            F.a(view);
            return S(null);
        }

        @Override // com.google.android.material.appbar.a
        /* bridge */ /* synthetic */ int J(View view) {
            F.a(view);
            return T(null);
        }

        @Override // com.google.android.material.appbar.a
        int K() {
            return D() + this.f5615k;
        }

        @Override // com.google.android.material.appbar.a
        /* bridge */ /* synthetic */ void L(CoordinatorLayout coordinatorLayout, View view) {
            F.a(view);
            U(coordinatorLayout, null);
        }

        @Override // com.google.android.material.appbar.a
        /* bridge */ /* synthetic */ int O(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4) {
            F.a(view);
            return d0(coordinatorLayout, null, i2, i3, i4);
        }

        boolean Q(AppBarLayout appBarLayout) {
            WeakReference weakReference = this.f5619p;
            if (weakReference == null) {
                return true;
            }
            View view = (View) weakReference.get();
            return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
        }

        int S(AppBarLayout appBarLayout) {
            throw null;
        }

        int T(AppBarLayout appBarLayout) {
            throw null;
        }

        void U(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            e0(coordinatorLayout, appBarLayout);
        }

        public boolean V(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i2) {
            super.l(coordinatorLayout, appBarLayout, i2);
            throw null;
        }

        public boolean W(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i2, int i3, int i4, int i5) {
            throw null;
        }

        public void X(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2, int i3, int[] iArr, int i4) {
            if (i3 != 0) {
                if (i3 >= 0) {
                    throw null;
                }
                throw null;
            }
        }

        public void Y(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2, int i3, int i4, int i5, int i6) {
            if (i5 >= 0) {
                throw null;
            }
            throw null;
        }

        public void Z(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            if (!(parcelable instanceof a)) {
                super.w(coordinatorLayout, appBarLayout, parcelable);
                this.f5617m = -1;
                return;
            }
            a aVar = (a) parcelable;
            super.w(coordinatorLayout, appBarLayout, aVar.a());
            this.f5617m = aVar.f5620c;
            this.o = aVar.f5621d;
            this.f5618n = aVar.e;
        }

        public Parcelable a0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            super.x(coordinatorLayout, appBarLayout);
            D();
            throw null;
        }

        public boolean b0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i2, int i3) {
            if ((i2 & 2) != 0) {
                throw null;
            }
            this.f5619p = null;
            this.f5616l = i3;
            return false;
        }

        public void c0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2) {
            if (this.f5616l == 0 || i2 == 1) {
                e0(coordinatorLayout, appBarLayout);
            }
            this.f5619p = new WeakReference(view);
        }

        int d0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i2, int i3, int i4) {
            int iK = K();
            if (i3 == 0 || iK < i3 || iK > i4) {
                this.f5615k = 0;
            } else if (iK != AbstractC0327a.a(i2, i3, i4)) {
                throw null;
            }
            return 0;
        }

        @Override // com.google.android.material.appbar.c, androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ boolean l(CoordinatorLayout coordinatorLayout, View view, int i2) {
            F.a(view);
            return V(coordinatorLayout, null, i2);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ boolean m(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4, int i5) {
            F.a(view);
            return W(coordinatorLayout, null, i2, i3, i4, i5);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ void q(CoordinatorLayout coordinatorLayout, View view, View view2, int i2, int i3, int[] iArr, int i4) {
            F.a(view);
            X(coordinatorLayout, null, view2, i2, i3, iArr, i4);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ void s(CoordinatorLayout coordinatorLayout, View view, View view2, int i2, int i3, int i4, int i5, int i6) {
            F.a(view);
            Y(coordinatorLayout, null, view2, i2, i3, i4, i5, i6);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ void w(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
            F.a(view);
            Z(coordinatorLayout, null, parcelable);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ Parcelable x(CoordinatorLayout coordinatorLayout, View view) {
            F.a(view);
            return a0(coordinatorLayout, null);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ boolean z(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i2, int i3) {
            F.a(view);
            return b0(coordinatorLayout, null, view2, view3, i2, i3);
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f5617m = -1;
        }
    }
}
