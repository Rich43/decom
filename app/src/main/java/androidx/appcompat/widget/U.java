package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class U extends S implements T {

    /* renamed from: K, reason: collision with root package name */
    private static Method f2330K;

    /* renamed from: J, reason: collision with root package name */
    private T f2331J;

    static class a {
        static void a(PopupWindow popupWindow, Transition transition) {
            popupWindow.setEnterTransition(transition);
        }

        static void b(PopupWindow popupWindow, Transition transition) {
            popupWindow.setExitTransition(transition);
        }
    }

    static class b {
        static void a(PopupWindow popupWindow, boolean z2) {
            popupWindow.setTouchModal(z2);
        }
    }

    public static class c extends N {

        /* renamed from: n, reason: collision with root package name */
        final int f2332n;
        final int o;

        /* renamed from: p, reason: collision with root package name */
        private T f2333p;

        /* renamed from: q, reason: collision with root package name */
        private MenuItem f2334q;

        public c(Context context, boolean z2) {
            super(context, z2);
            if (1 == context.getResources().getConfiguration().getLayoutDirection()) {
                this.f2332n = 21;
                this.o = 22;
            } else {
                this.f2332n = 22;
                this.o = 21;
            }
        }

        @Override // androidx.appcompat.widget.N
        public /* bridge */ /* synthetic */ int d(int i2, int i3, int i4, int i5, int i6) {
            return super.d(i2, i3, i4, i5, i6);
        }

        @Override // androidx.appcompat.widget.N
        public /* bridge */ /* synthetic */ boolean e(MotionEvent motionEvent, int i2) {
            return super.e(motionEvent, i2);
        }

        @Override // androidx.appcompat.widget.N, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // androidx.appcompat.widget.N, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // androidx.appcompat.widget.N, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // androidx.appcompat.widget.N, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // androidx.appcompat.widget.N, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            androidx.appcompat.view.menu.d dVar;
            int headersCount;
            int iPointToPosition;
            int i2;
            if (this.f2333p != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    dVar = (androidx.appcompat.view.menu.d) headerViewListAdapter.getWrappedAdapter();
                } else {
                    dVar = (androidx.appcompat.view.menu.d) adapter;
                    headersCount = 0;
                }
                androidx.appcompat.view.menu.g item = (motionEvent.getAction() == 10 || (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i2 = iPointToPosition - headersCount) < 0 || i2 >= dVar.getCount()) ? null : dVar.getItem(i2);
                MenuItem menuItem = this.f2334q;
                if (menuItem != item) {
                    androidx.appcompat.view.menu.e eVarB = dVar.b();
                    if (menuItem != null) {
                        this.f2333p.h(eVarB, menuItem);
                    }
                    this.f2334q = item;
                    if (item != null) {
                        this.f2333p.a(eVarB, item);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i2, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i2 == this.f2332n) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView == null || i2 != this.o) {
                return super.onKeyDown(i2, keyEvent);
            }
            setSelection(-1);
            ListAdapter adapter = getAdapter();
            (adapter instanceof HeaderViewListAdapter ? (androidx.appcompat.view.menu.d) ((HeaderViewListAdapter) adapter).getWrappedAdapter() : (androidx.appcompat.view.menu.d) adapter).b().e(false);
            return true;
        }

        @Override // androidx.appcompat.widget.N, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setHoverListener(T t2) {
            this.f2333p = t2;
        }

        @Override // androidx.appcompat.widget.N, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                f2330K = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public U(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    public void N(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            a.a(this.f2246F, (Transition) obj);
        }
    }

    public void O(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            a.b(this.f2246F, (Transition) obj);
        }
    }

    public void P(T t2) {
        this.f2331J = t2;
    }

    public void Q(boolean z2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT > 28) {
            b.a(this.f2246F, z2);
            return;
        }
        Method method = f2330K;
        if (method != null) {
            try {
                method.invoke(this.f2246F, Boolean.valueOf(z2));
            } catch (Exception unused) {
                Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }

    @Override // androidx.appcompat.widget.T
    public void a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        T t2 = this.f2331J;
        if (t2 != null) {
            t2.a(eVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.T
    public void h(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        T t2 = this.f2331J;
        if (t2 != null) {
            t2.h(eVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.S
    N s(Context context, boolean z2) {
        c cVar = new c(context, z2);
        cVar.setHoverListener(this);
        return cVar;
    }
}
