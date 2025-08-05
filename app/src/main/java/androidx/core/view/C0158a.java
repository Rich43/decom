package androidx.core.view;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import defpackage.r;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import w.C0353E;
import w.C0354F;

/* renamed from: androidx.core.view.a */
/* loaded from: classes.dex */
public class C0158a {

    /* renamed from: c */
    private static final View.AccessibilityDelegate f3153c = new View.AccessibilityDelegate();

    /* renamed from: a */
    private final View.AccessibilityDelegate f3154a;

    /* renamed from: b */
    private final View.AccessibilityDelegate f3155b;

    /* renamed from: androidx.core.view.a$a */
    static final class C0032a extends View.AccessibilityDelegate {

        /* renamed from: a */
        final C0158a f3156a;

        C0032a(C0158a c0158a) {
            this.f3156a = c0158a;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f3156a.a(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            C0354F c0354fB = this.f3156a.b(view);
            if (c0354fB != null) {
                return (AccessibilityNodeProvider) c0354fB.a();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f3156a.f(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            C0353E c0353eH0 = C0353E.h0(accessibilityNodeInfo);
            c0353eH0.d0(M.R(view));
            c0353eH0.b0(M.M(view));
            c0353eH0.c0(M.n(view));
            c0353eH0.f0(M.F(view));
            this.f3156a.g(view, c0353eH0);
            c0353eH0.d(accessibilityNodeInfo.getText(), view);
            List listC = C0158a.c(view);
            for (int i2 = 0; i2 < listC.size(); i2++) {
                c0353eH0.b((C0353E.a) listC.get(i2));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f3156a.h(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f3156a.i(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            return this.f3156a.j(view, i2, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i2) {
            this.f3156a.l(view, i2);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f3156a.m(view, accessibilityEvent);
        }
    }

    public C0158a() {
        this(f3153c);
    }

    static List c(View view) {
        List list = (List) view.getTag(r.e.f7261H);
        return list == null ? Collections.emptyList() : list;
    }

    private boolean e(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] clickableSpanArrN = C0353E.n(view.createAccessibilityNodeInfo().getText());
            for (int i2 = 0; clickableSpanArrN != null && i2 < clickableSpanArrN.length; i2++) {
                if (clickableSpan.equals(clickableSpanArrN[i2])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean k(int i2, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(r.e.f7262I);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i2)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!e(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f3154a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public C0354F b(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = this.f3154a.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new C0354F(accessibilityNodeProvider);
        }
        return null;
    }

    View.AccessibilityDelegate d() {
        return this.f3155b;
    }

    public void f(View view, AccessibilityEvent accessibilityEvent) {
        this.f3154a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void g(View view, C0353E c0353e) {
        this.f3154a.onInitializeAccessibilityNodeInfo(view, c0353e.g0());
    }

    public void h(View view, AccessibilityEvent accessibilityEvent) {
        this.f3154a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f3154a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean j(View view, int i2, Bundle bundle) {
        List listC = c(view);
        boolean zPerformAccessibilityAction = false;
        int i3 = 0;
        while (true) {
            if (i3 >= listC.size()) {
                break;
            }
            C0353E.a aVar = (C0353E.a) listC.get(i3);
            if (aVar.a() == i2) {
                zPerformAccessibilityAction = aVar.c(view, bundle);
                break;
            }
            i3++;
        }
        if (!zPerformAccessibilityAction) {
            zPerformAccessibilityAction = this.f3154a.performAccessibilityAction(view, i2, bundle);
        }
        return (zPerformAccessibilityAction || i2 != r.e.f7273a || bundle == null) ? zPerformAccessibilityAction : k(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    public void l(View view, int i2) {
        this.f3154a.sendAccessibilityEvent(view, i2);
    }

    public void m(View view, AccessibilityEvent accessibilityEvent) {
        this.f3154a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public C0158a(View.AccessibilityDelegate accessibilityDelegate) {
        this.f3154a = accessibilityDelegate;
        this.f3155b = new C0032a(this);
    }
}
