package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import defpackage.e;
import g.AbstractC0256c;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class N extends ListView {

    /* renamed from: a, reason: collision with root package name */
    private final Rect f2196a;

    /* renamed from: b, reason: collision with root package name */
    private int f2197b;

    /* renamed from: c, reason: collision with root package name */
    private int f2198c;

    /* renamed from: d, reason: collision with root package name */
    private int f2199d;
    private int e;

    /* renamed from: f, reason: collision with root package name */
    private int f2200f;

    /* renamed from: g, reason: collision with root package name */
    private d f2201g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f2202h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f2203i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f2204j;

    /* renamed from: k, reason: collision with root package name */
    private androidx.core.view.V f2205k;

    /* renamed from: l, reason: collision with root package name */
    private androidx.core.widget.f f2206l;

    /* renamed from: m, reason: collision with root package name */
    f f2207m;

    static class a {
        static void a(View view, float f2, float f3) {
            view.drawableHotspotChanged(f2, f3);
        }
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        private static Method f2208a;

        /* renamed from: b, reason: collision with root package name */
        private static Method f2209b;

        /* renamed from: c, reason: collision with root package name */
        private static Method f2210c;

        /* renamed from: d, reason: collision with root package name */
        private static boolean f2211d;

        static {
            try {
                Class cls = Integer.TYPE;
                Class cls2 = Float.TYPE;
                Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, Boolean.TYPE, cls2, cls2);
                f2208a = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
                f2209b = declaredMethod2;
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
                f2210c = declaredMethod3;
                declaredMethod3.setAccessible(true);
                f2211d = true;
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        static boolean a() {
            return f2211d;
        }

        static void b(N n2, int i2, View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            try {
                f2208a.invoke(n2, Integer.valueOf(i2), view, Boolean.FALSE, -1, -1);
                f2209b.invoke(n2, Integer.valueOf(i2));
                f2210c.invoke(n2, Integer.valueOf(i2));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
        }
    }

    static class c {
        static boolean a(AbsListView absListView) {
            return absListView.isSelectedChildViewEnabled();
        }

        static void b(AbsListView absListView, boolean z2) {
            absListView.setSelectedChildViewEnabled(z2);
        }
    }

    private static class d extends AbstractC0256c {

        /* renamed from: b, reason: collision with root package name */
        private boolean f2212b;

        d(Drawable drawable) {
            super(drawable);
            this.f2212b = true;
        }

        void b(boolean z2) {
            this.f2212b = z2;
        }

        @Override // g.AbstractC0256c, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f2212b) {
                super.draw(canvas);
            }
        }

        @Override // g.AbstractC0256c, android.graphics.drawable.Drawable
        public void setHotspot(float f2, float f3) {
            if (this.f2212b) {
                super.setHotspot(f2, f3);
            }
        }

        @Override // g.AbstractC0256c, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i2, int i3, int i4, int i5) {
            if (this.f2212b) {
                super.setHotspotBounds(i2, i3, i4, i5);
            }
        }

        @Override // g.AbstractC0256c, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f2212b) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // g.AbstractC0256c, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z2, boolean z3) {
            if (this.f2212b) {
                return super.setVisible(z2, z3);
            }
            return false;
        }
    }

    static class e {

        /* renamed from: a, reason: collision with root package name */
        private static final Field f2213a;

        static {
            Field declaredField = null;
            try {
                declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            f2213a = declaredField;
        }

        static boolean a(AbsListView absListView) {
            Field field = f2213a;
            if (field == null) {
                return false;
            }
            try {
                return field.getBoolean(absListView);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return false;
            }
        }

        static void b(AbsListView absListView, boolean z2) throws IllegalAccessException, IllegalArgumentException {
            Field field = f2213a;
            if (field != null) {
                try {
                    field.set(absListView, Boolean.valueOf(z2));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class f implements Runnable {
        f() {
        }

        public void a() {
            N n2 = N.this;
            n2.f2207m = null;
            n2.removeCallbacks(this);
        }

        public void b() {
            N.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            N n2 = N.this;
            n2.f2207m = null;
            n2.drawableStateChanged();
        }
    }

    N(Context context, boolean z2) {
        super(context, null, e.d.f5855x);
        this.f2196a = new Rect();
        this.f2197b = 0;
        this.f2198c = 0;
        this.f2199d = 0;
        this.e = 0;
        this.f2203i = z2;
        setCacheColorHint(0);
    }

    private void a() {
        this.f2204j = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f2200f - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        androidx.core.view.V v2 = this.f2205k;
        if (v2 != null) {
            v2.c();
            this.f2205k = null;
        }
    }

    private void b(View view, int i2) {
        performItemClick(view, i2, getItemIdAtPosition(i2));
    }

    private void c(Canvas canvas) {
        Drawable selector;
        if (this.f2196a.isEmpty() || (selector = getSelector()) == null) {
            return;
        }
        selector.setBounds(this.f2196a);
        selector.draw(canvas);
    }

    private void f(int i2, View view) throws IllegalAccessException, IllegalArgumentException {
        Rect rect = this.f2196a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f2197b;
        rect.top -= this.f2198c;
        rect.right += this.f2199d;
        rect.bottom += this.e;
        boolean zK = k();
        if (view.isEnabled() != zK) {
            l(!zK);
            if (i2 != -1) {
                refreshDrawableState();
            }
        }
    }

    private void g(int i2, View view) throws IllegalAccessException, IllegalArgumentException {
        Drawable selector = getSelector();
        boolean z2 = (selector == null || i2 == -1) ? false : true;
        if (z2) {
            selector.setVisible(false, false);
        }
        f(i2, view);
        if (z2) {
            Rect rect = this.f2196a;
            float fExactCenterX = rect.exactCenterX();
            float fExactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            androidx.core.graphics.drawable.a.j(selector, fExactCenterX, fExactCenterY);
        }
    }

    private void h(int i2, View view, float f2, float f3) throws IllegalAccessException, IllegalArgumentException {
        g(i2, view);
        Drawable selector = getSelector();
        if (selector == null || i2 == -1) {
            return;
        }
        androidx.core.graphics.drawable.a.j(selector, f2, f3);
    }

    private void i(View view, int i2, float f2, float f3) throws IllegalAccessException, IllegalArgumentException {
        View childAt;
        this.f2204j = true;
        a.a(this, f2, f3);
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i3 = this.f2200f;
        if (i3 != -1 && (childAt = getChildAt(i3 - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.f2200f = i2;
        a.a(view, f2 - view.getLeft(), f3 - view.getTop());
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        h(i2, view, f2, f3);
        j(false);
        refreshDrawableState();
    }

    private void j(boolean z2) {
        d dVar = this.f2201g;
        if (dVar != null) {
            dVar.b(z2);
        }
    }

    private boolean k() {
        return Build.VERSION.SDK_INT >= 33 ? c.a(this) : e.a(this);
    }

    private void l(boolean z2) throws IllegalAccessException, IllegalArgumentException {
        if (Build.VERSION.SDK_INT >= 33) {
            c.b(this, z2);
        } else {
            e.b(this, z2);
        }
    }

    private boolean m() {
        return this.f2204j;
    }

    private void n() {
        Drawable selector = getSelector();
        if (selector != null && m() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    public int d(int i2, int i3, int i4, int i5, int i6) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int measuredHeight = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        View view = null;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i7 < count) {
            int itemViewType = adapter.getItemViewType(i7);
            if (itemViewType != i8) {
                view = null;
                i8 = itemViewType;
            }
            view = adapter.getView(i7, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i10 = layoutParams.height;
            view.measure(i2, i10 > 0 ? View.MeasureSpec.makeMeasureSpec(i10, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i7 > 0) {
                measuredHeight += dividerHeight;
            }
            measuredHeight += view.getMeasuredHeight();
            if (measuredHeight >= i5) {
                return (i6 < 0 || i7 <= i6 || i9 <= 0 || measuredHeight == i5) ? i5 : i9;
            }
            if (i6 >= 0 && i7 >= i6) {
                i9 = measuredHeight;
            }
            i7++;
        }
        return measuredHeight;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        c(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.f2207m != null) {
            return;
        }
        super.drawableStateChanged();
        j(true);
        n();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean e(android.view.MotionEvent r8, int r9) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L16
            r3 = 2
            if (r0 == r3) goto L14
            r9 = 3
            if (r0 == r9) goto L11
        Le:
            r9 = 0
            r3 = 1
            goto L46
        L11:
            r9 = 0
            r3 = 0
            goto L46
        L14:
            r3 = 1
            goto L17
        L16:
            r3 = 0
        L17:
            int r9 = r8.findPointerIndex(r9)
            if (r9 >= 0) goto L1e
            goto L11
        L1e:
            float r4 = r8.getX(r9)
            int r4 = (int) r4
            float r9 = r8.getY(r9)
            int r9 = (int) r9
            int r5 = r7.pointToPosition(r4, r9)
            r6 = -1
            if (r5 != r6) goto L31
            r9 = 1
            goto L46
        L31:
            int r3 = r7.getFirstVisiblePosition()
            int r3 = r5 - r3
            android.view.View r3 = r7.getChildAt(r3)
            float r4 = (float) r4
            float r9 = (float) r9
            r7.i(r3, r5, r4, r9)
            if (r0 != r1) goto Le
            r7.b(r3, r5)
            goto Le
        L46:
            if (r3 == 0) goto L4a
            if (r9 == 0) goto L4d
        L4a:
            r7.a()
        L4d:
            if (r3 == 0) goto L65
            androidx.core.widget.f r9 = r7.f2206l
            if (r9 != 0) goto L5a
            androidx.core.widget.f r9 = new androidx.core.widget.f
            r9.<init>(r7)
            r7.f2206l = r9
        L5a:
            androidx.core.widget.f r9 = r7.f2206l
            r9.m(r1)
            androidx.core.widget.f r9 = r7.f2206l
            r9.onTouch(r7, r8)
            goto L6c
        L65:
            androidx.core.widget.f r8 = r7.f2206l
            if (r8 == 0) goto L6c
            r8.m(r2)
        L6c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.N.e(android.view.MotionEvent, int):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.f2203i || super.hasFocus();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.f2203i || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.f2203i || super.isFocused();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.f2203i && this.f2202h) || super.isInTouchMode();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f2207m = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f2207m == null) {
            f fVar = new f();
            this.f2207m = fVar;
            fVar.b();
        }
        boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (iPointToPosition != -1 && iPointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    requestFocus();
                    if (i2 < 30 || !b.a()) {
                        setSelectionFromTop(iPointToPosition, childAt.getTop() - getTop());
                    } else {
                        b.b(this, iPointToPosition, childAt);
                    }
                }
                n();
            }
        } else {
            setSelection(-1);
        }
        return zOnHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f2200f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        f fVar = this.f2207m;
        if (fVar != null) {
            fVar.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    void setListSelectionHidden(boolean z2) {
        this.f2202h = z2;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        d dVar = drawable != null ? new d(drawable) : null;
        this.f2201g = dVar;
        super.setSelector(dVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f2197b = rect.left;
        this.f2198c = rect.top;
        this.f2199d = rect.right;
        this.e = rect.bottom;
    }
}
