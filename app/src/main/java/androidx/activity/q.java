package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.AbstractC0203h;

/* loaded from: classes.dex */
public abstract class q extends Dialog implements androidx.lifecycle.m, w, L.d {

    /* renamed from: a, reason: collision with root package name */
    private androidx.lifecycle.n f1525a;

    /* renamed from: b, reason: collision with root package name */
    private final L.c f1526b;

    /* renamed from: c, reason: collision with root package name */
    private final OnBackPressedDispatcher f1527c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(Context context, int i2) {
        super(context, i2);
        i1.k.e(context, "context");
        this.f1526b = L.c.f276d.a(this);
        this.f1527c = new OnBackPressedDispatcher(new Runnable() { // from class: androidx.activity.p
            @Override // java.lang.Runnable
            public final void run() {
                q.c(this.f1524a);
            }
        });
    }

    private final androidx.lifecycle.n b() {
        androidx.lifecycle.n nVar = this.f1525a;
        if (nVar != null) {
            return nVar;
        }
        androidx.lifecycle.n nVar2 = new androidx.lifecycle.n(this);
        this.f1525a = nVar2;
        return nVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(q qVar) {
        i1.k.e(qVar, "this$0");
        super.onBackPressed();
    }

    @Override // androidx.activity.w
    public final OnBackPressedDispatcher f() {
        return this.f1527c;
    }

    @Override // androidx.lifecycle.m
    public AbstractC0203h getLifecycle() {
        return b();
    }

    @Override // L.d
    public androidx.savedstate.a getSavedStateRegistry() {
        return this.f1526b.b();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        this.f1527c.k();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackPressedDispatcher onBackPressedDispatcher = this.f1527c;
            OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            i1.k.d(onBackInvokedDispatcher, "onBackInvokedDispatcher");
            onBackPressedDispatcher.n(onBackInvokedDispatcher);
        }
        this.f1526b.d(bundle);
        b().h(AbstractC0203h.a.ON_CREATE);
    }

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        i1.k.d(bundleOnSaveInstanceState, "super.onSaveInstanceState()");
        this.f1526b.e(bundleOnSaveInstanceState);
        return bundleOnSaveInstanceState;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        b().h(AbstractC0203h.a.ON_RESUME);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        b().h(AbstractC0203h.a.ON_DESTROY);
        this.f1525a = null;
        super.onStop();
    }
}
