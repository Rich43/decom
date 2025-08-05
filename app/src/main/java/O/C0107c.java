package O;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.M;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/* renamed from: O.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0107c extends l {

    /* renamed from: M, reason: collision with root package name */
    private static final String[] f392M = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* renamed from: N, reason: collision with root package name */
    private static final Property f393N = new b(PointF.class, "boundsOrigin");

    /* renamed from: O, reason: collision with root package name */
    private static final Property f394O = new C0008c(PointF.class, "topLeft");

    /* renamed from: P, reason: collision with root package name */
    private static final Property f395P = new d(PointF.class, "bottomRight");

    /* renamed from: Q, reason: collision with root package name */
    private static final Property f396Q = new e(PointF.class, "bottomRight");

    /* renamed from: R, reason: collision with root package name */
    private static final Property f397R = new f(PointF.class, "topLeft");

    /* renamed from: S, reason: collision with root package name */
    private static final Property f398S = new g(PointF.class, "position");

    /* renamed from: T, reason: collision with root package name */
    private static O.j f399T = new O.j();

    /* renamed from: J, reason: collision with root package name */
    private int[] f400J = new int[2];

    /* renamed from: K, reason: collision with root package name */
    private boolean f401K = false;

    /* renamed from: L, reason: collision with root package name */
    private boolean f402L = false;

    /* renamed from: O.c$a */
    class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f403a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ BitmapDrawable f404b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f405c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f406d;

        a(ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f2) {
            this.f403a = viewGroup;
            this.f404b = bitmapDrawable;
            this.f405c = view;
            this.f406d = f2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            A.c(this.f403a).d(this.f404b);
            A.h(this.f405c, this.f406d);
        }
    }

    /* renamed from: O.c$b */
    static class b extends Property {

        /* renamed from: a, reason: collision with root package name */
        private Rect f407a;

        b(Class cls, String str) {
            super(cls, str);
            this.f407a = new Rect();
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f407a);
            Rect rect = this.f407a;
            return new PointF(rect.left, rect.top);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f407a);
            this.f407a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f407a);
        }
    }

    /* renamed from: O.c$c, reason: collision with other inner class name */
    static class C0008c extends Property {
        C0008c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(k kVar, PointF pointF) {
            kVar.c(pointF);
        }
    }

    /* renamed from: O.c$d */
    static class d extends Property {
        d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(k kVar, PointF pointF) {
            kVar.a(pointF);
        }
    }

    /* renamed from: O.c$e */
    static class e extends Property {
        e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            A.g(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    /* renamed from: O.c$f */
    static class f extends Property {
        f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            A.g(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    /* renamed from: O.c$g */
    static class g extends Property {
        g(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            int iRound = Math.round(pointF.x);
            int iRound2 = Math.round(pointF.y);
            A.g(view, iRound, iRound2, view.getWidth() + iRound, view.getHeight() + iRound2);
        }
    }

    /* renamed from: O.c$h */
    class h extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ k f408a;
        private k mViewBounds;

        h(k kVar) {
            this.f408a = kVar;
            this.mViewBounds = kVar;
        }
    }

    /* renamed from: O.c$i */
    class i extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private boolean f410a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f411b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Rect f412c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f413d;
        final /* synthetic */ int e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f414f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f415g;

        i(View view, Rect rect, int i2, int i3, int i4, int i5) {
            this.f411b = view;
            this.f412c = rect;
            this.f413d = i2;
            this.e = i3;
            this.f414f = i4;
            this.f415g = i5;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f410a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f410a) {
                return;
            }
            M.l0(this.f411b, this.f412c);
            A.g(this.f411b, this.f413d, this.e, this.f414f, this.f415g);
        }
    }

    /* renamed from: O.c$j */
    class j extends m {

        /* renamed from: a, reason: collision with root package name */
        boolean f417a = false;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f418b;

        j(ViewGroup viewGroup) {
            this.f418b = viewGroup;
        }

        @Override // O.m, O.l.f
        public void a(l lVar) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            w.b(this.f418b, false);
        }

        @Override // O.l.f
        public void b(l lVar) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (!this.f417a) {
                w.b(this.f418b, false);
            }
            lVar.O(this);
        }

        @Override // O.m, O.l.f
        public void d(l lVar) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            w.b(this.f418b, true);
        }
    }

    /* renamed from: O.c$k */
    private static class k {

        /* renamed from: a, reason: collision with root package name */
        private int f420a;

        /* renamed from: b, reason: collision with root package name */
        private int f421b;

        /* renamed from: c, reason: collision with root package name */
        private int f422c;

        /* renamed from: d, reason: collision with root package name */
        private int f423d;
        private View e;

        /* renamed from: f, reason: collision with root package name */
        private int f424f;

        /* renamed from: g, reason: collision with root package name */
        private int f425g;

        k(View view) {
            this.e = view;
        }

        private void b() {
            A.g(this.e, this.f420a, this.f421b, this.f422c, this.f423d);
            this.f424f = 0;
            this.f425g = 0;
        }

        void a(PointF pointF) {
            this.f422c = Math.round(pointF.x);
            this.f423d = Math.round(pointF.y);
            int i2 = this.f425g + 1;
            this.f425g = i2;
            if (this.f424f == i2) {
                b();
            }
        }

        void c(PointF pointF) {
            this.f420a = Math.round(pointF.x);
            this.f421b = Math.round(pointF.y);
            int i2 = this.f424f + 1;
            this.f424f = i2;
            if (i2 == this.f425g) {
                b();
            }
        }
    }

    private void b0(s sVar) {
        View view = sVar.f503b;
        if (!M.O(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        sVar.f502a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        sVar.f502a.put("android:changeBounds:parent", sVar.f503b.getParent());
        if (this.f402L) {
            sVar.f503b.getLocationInWindow(this.f400J);
            sVar.f502a.put("android:changeBounds:windowX", Integer.valueOf(this.f400J[0]));
            sVar.f502a.put("android:changeBounds:windowY", Integer.valueOf(this.f400J[1]));
        }
        if (this.f401K) {
            sVar.f502a.put("android:changeBounds:clip", M.q(view));
        }
    }

    private boolean c0(View view, View view2) {
        if (!this.f402L) {
            return true;
        }
        s sVarS = s(view, true);
        if (sVarS == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == sVarS.f503b) {
            return true;
        }
        return false;
    }

    @Override // O.l
    public String[] C() {
        return f392M;
    }

    @Override // O.l
    public void f(s sVar) {
        b0(sVar);
    }

    @Override // O.l
    public void i(s sVar) {
        b0(sVar);
    }

    @Override // O.l
    public Animator m(ViewGroup viewGroup, s sVar, s sVar2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int i2;
        View view;
        int i3;
        ObjectAnimator objectAnimator;
        Animator animatorC;
        if (sVar == null || sVar2 == null) {
            return null;
        }
        Map map = sVar.f502a;
        Map map2 = sVar2.f502a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = sVar2.f503b;
        if (!c0(viewGroup2, viewGroup3)) {
            int iIntValue = ((Integer) sVar.f502a.get("android:changeBounds:windowX")).intValue();
            int iIntValue2 = ((Integer) sVar.f502a.get("android:changeBounds:windowY")).intValue();
            int iIntValue3 = ((Integer) sVar2.f502a.get("android:changeBounds:windowX")).intValue();
            int iIntValue4 = ((Integer) sVar2.f502a.get("android:changeBounds:windowY")).intValue();
            if (iIntValue == iIntValue3 && iIntValue2 == iIntValue4) {
                return null;
            }
            viewGroup.getLocationInWindow(this.f400J);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
            view2.draw(new Canvas(bitmapCreateBitmap));
            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
            float fD = A.d(view2);
            A.h(view2, 0.0f);
            A.c(viewGroup).b(bitmapDrawable);
            AbstractC0111g abstractC0111gU = u();
            int[] iArr = this.f400J;
            int i4 = iArr[0];
            int i5 = iArr[1];
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, AbstractC0112h.a(f393N, abstractC0111gU.a(iIntValue - i4, iIntValue2 - i5, iIntValue3 - i4, iIntValue4 - i5)));
            objectAnimatorOfPropertyValuesHolder.addListener(new a(viewGroup, bitmapDrawable, view2, fD));
            return objectAnimatorOfPropertyValuesHolder;
        }
        Rect rect = (Rect) sVar.f502a.get("android:changeBounds:bounds");
        Rect rect2 = (Rect) sVar2.f502a.get("android:changeBounds:bounds");
        int i6 = rect.left;
        int i7 = rect2.left;
        int i8 = rect.top;
        int i9 = rect2.top;
        int i10 = rect.right;
        int i11 = rect2.right;
        int i12 = rect.bottom;
        int i13 = rect2.bottom;
        int i14 = i10 - i6;
        int i15 = i12 - i8;
        int i16 = i11 - i7;
        int i17 = i13 - i9;
        Rect rect3 = (Rect) sVar.f502a.get("android:changeBounds:clip");
        Rect rect4 = (Rect) sVar2.f502a.get("android:changeBounds:clip");
        if ((i14 == 0 || i15 == 0) && (i16 == 0 || i17 == 0)) {
            i2 = 0;
        } else {
            i2 = (i6 == i7 && i8 == i9) ? 0 : 1;
            if (i10 != i11 || i12 != i13) {
                i2++;
            }
        }
        if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
            i2++;
        }
        if (i2 <= 0) {
            return null;
        }
        if (this.f401K) {
            view = view2;
            A.g(view, i6, i8, Math.max(i14, i16) + i6, Math.max(i15, i17) + i8);
            ObjectAnimator objectAnimatorA = (i6 == i7 && i8 == i9) ? null : AbstractC0110f.a(view, f398S, u().a(i6, i8, i7, i9));
            if (rect3 == null) {
                i3 = 0;
                rect3 = new Rect(0, 0, i14, i15);
            } else {
                i3 = 0;
            }
            Rect rect5 = rect4 == null ? new Rect(i3, i3, i16, i17) : rect4;
            if (rect3.equals(rect5)) {
                objectAnimator = null;
            } else {
                M.l0(view, rect3);
                O.j jVar = f399T;
                Object[] objArr = new Object[2];
                objArr[i3] = rect3;
                objArr[1] = rect5;
                ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(view, "clipBounds", jVar, objArr);
                objectAnimatorOfObject.addListener(new i(view, rect4, i7, i9, i11, i13));
                objectAnimator = objectAnimatorOfObject;
            }
            animatorC = r.c(objectAnimatorA, objectAnimator);
        } else {
            view = view2;
            A.g(view, i6, i8, i10, i12);
            if (i2 != 2) {
                animatorC = (i6 == i7 && i8 == i9) ? AbstractC0110f.a(view, f396Q, u().a(i10, i12, i11, i13)) : AbstractC0110f.a(view, f397R, u().a(i6, i8, i7, i9));
            } else if (i14 == i16 && i15 == i17) {
                animatorC = AbstractC0110f.a(view, f398S, u().a(i6, i8, i7, i9));
            } else {
                k kVar = new k(view);
                ObjectAnimator objectAnimatorA2 = AbstractC0110f.a(kVar, f394O, u().a(i6, i8, i7, i9));
                ObjectAnimator objectAnimatorA3 = AbstractC0110f.a(kVar, f395P, u().a(i10, i12, i11, i13));
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(objectAnimatorA2, objectAnimatorA3);
                animatorSet.addListener(new h(kVar));
                animatorC = animatorSet;
            }
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
            w.b(viewGroup4, true);
            a(new j(viewGroup4));
        }
        return animatorC;
    }
}
