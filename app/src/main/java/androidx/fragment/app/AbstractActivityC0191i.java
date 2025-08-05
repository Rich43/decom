package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.app.b;
import androidx.core.view.InterfaceC0179w;
import androidx.core.view.InterfaceC0182z;
import androidx.lifecycle.AbstractC0203h;
import androidx.savedstate.a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import v.InterfaceC0338a;

/* renamed from: androidx.fragment.app.i */
/* loaded from: classes.dex */
public abstract class AbstractActivityC0191i extends ComponentActivity implements b.e, b.f {

    /* renamed from: y */
    boolean f3554y;

    /* renamed from: z */
    boolean f3555z;

    /* renamed from: w */
    final C0195m f3552w = C0195m.b(new a());

    /* renamed from: x */
    final androidx.lifecycle.n f3553x = new androidx.lifecycle.n(this);

    /* renamed from: A */
    boolean f3551A = true;

    /* renamed from: androidx.fragment.app.i$a */
    class a extends o implements androidx.core.content.b, androidx.core.content.c, androidx.core.app.o, androidx.core.app.p, androidx.lifecycle.J, androidx.activity.w, b.f, L.d, A, InterfaceC0179w {
        public a() {
            super(AbstractActivityC0191i.this);
        }

        @Override // androidx.core.content.c
        public void I(InterfaceC0338a interfaceC0338a) {
            AbstractActivityC0191i.this.I(interfaceC0338a);
        }

        @Override // androidx.core.app.o
        public void L(InterfaceC0338a interfaceC0338a) {
            AbstractActivityC0191i.this.L(interfaceC0338a);
        }

        @Override // androidx.core.app.p
        public void M(InterfaceC0338a interfaceC0338a) {
            AbstractActivityC0191i.this.M(interfaceC0338a);
        }

        @Override // androidx.core.content.c
        public void Z(InterfaceC0338a interfaceC0338a) {
            AbstractActivityC0191i.this.Z(interfaceC0338a);
        }

        @Override // androidx.fragment.app.A
        public void a(w wVar, Fragment fragment) {
            AbstractActivityC0191i.this.V0(fragment);
        }

        @Override // androidx.core.app.p
        public void a0(InterfaceC0338a interfaceC0338a) {
            AbstractActivityC0191i.this.a0(interfaceC0338a);
        }

        @Override // androidx.core.content.b
        public void b(InterfaceC0338a interfaceC0338a) {
            AbstractActivityC0191i.this.b(interfaceC0338a);
        }

        @Override // androidx.core.app.o
        public void b0(InterfaceC0338a interfaceC0338a) {
            AbstractActivityC0191i.this.b0(interfaceC0338a);
        }

        @Override // androidx.fragment.app.AbstractC0193k
        public View d(int i2) {
            return AbstractActivityC0191i.this.findViewById(i2);
        }

        @Override // androidx.fragment.app.AbstractC0193k
        public boolean e() {
            Window window = AbstractActivityC0191i.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // androidx.activity.w
        public OnBackPressedDispatcher f() {
            return AbstractActivityC0191i.this.f();
        }

        @Override // androidx.lifecycle.m
        public AbstractC0203h getLifecycle() {
            return AbstractActivityC0191i.this.f3553x;
        }

        @Override // L.d
        public androidx.savedstate.a getSavedStateRegistry() {
            return AbstractActivityC0191i.this.getSavedStateRegistry();
        }

        @Override // androidx.lifecycle.J
        public androidx.lifecycle.I getViewModelStore() {
            return AbstractActivityC0191i.this.getViewModelStore();
        }

        @Override // androidx.fragment.app.o
        public void j(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            AbstractActivityC0191i.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // androidx.fragment.app.o
        public LayoutInflater l() {
            return AbstractActivityC0191i.this.getLayoutInflater().cloneInContext(AbstractActivityC0191i.this);
        }

        @Override // androidx.core.content.b
        public void m(InterfaceC0338a interfaceC0338a) {
            AbstractActivityC0191i.this.m(interfaceC0338a);
        }

        @Override // androidx.core.view.InterfaceC0179w
        public void n(InterfaceC0182z interfaceC0182z) {
            AbstractActivityC0191i.this.n(interfaceC0182z);
        }

        @Override // androidx.fragment.app.o
        public boolean p(String str) {
            return androidx.core.app.b.n(AbstractActivityC0191i.this, str);
        }

        @Override // androidx.core.view.InterfaceC0179w
        public void r(InterfaceC0182z interfaceC0182z) {
            AbstractActivityC0191i.this.r(interfaceC0182z);
        }

        @Override // b.f
        public b.e s() {
            return AbstractActivityC0191i.this.s();
        }

        @Override // androidx.fragment.app.o
        public void u() {
            v();
        }

        public void v() {
            AbstractActivityC0191i.this.invalidateOptionsMenu();
        }

        @Override // androidx.fragment.app.o
        /* renamed from: w */
        public AbstractActivityC0191i k() {
            return AbstractActivityC0191i.this;
        }
    }

    public AbstractActivityC0191i() {
        O0();
    }

    private void O0() {
        getSavedStateRegistry().h("android:support:lifecycle", new a.c() { // from class: androidx.fragment.app.e
            @Override // androidx.savedstate.a.c
            public final Bundle a() {
                return this.f3547a.P0();
            }
        });
        m(new InterfaceC0338a() { // from class: androidx.fragment.app.f
            @Override // v.InterfaceC0338a
            public final void a(Object obj) {
                this.f3548a.Q0((Configuration) obj);
            }
        });
        y0(new InterfaceC0338a() { // from class: androidx.fragment.app.g
            @Override // v.InterfaceC0338a
            public final void a(Object obj) {
                this.f3549a.R0((Intent) obj);
            }
        });
        x0(new a.b() { // from class: androidx.fragment.app.h
            @Override // a.b
            public final void a(Context context) {
                this.f3550a.S0(context);
            }
        });
    }

    public /* synthetic */ Bundle P0() {
        T0();
        this.f3553x.h(AbstractC0203h.a.ON_STOP);
        return new Bundle();
    }

    public /* synthetic */ void Q0(Configuration configuration) {
        this.f3552w.m();
    }

    public /* synthetic */ void R0(Intent intent) {
        this.f3552w.m();
    }

    public /* synthetic */ void S0(Context context) {
        this.f3552w.a(null);
    }

    private static boolean U0(w wVar, AbstractC0203h.b bVar) {
        boolean zU0 = false;
        for (Fragment fragment : wVar.t0()) {
            if (fragment != null) {
                if (fragment.getHost() != null) {
                    zU0 |= U0(fragment.getChildFragmentManager(), bVar);
                }
                I i2 = fragment.mViewLifecycleOwner;
                if (i2 != null && i2.getLifecycle().b().b(AbstractC0203h.b.STARTED)) {
                    fragment.mViewLifecycleOwner.g(bVar);
                    zU0 = true;
                }
                if (fragment.mLifecycleRegistry.b().b(AbstractC0203h.b.STARTED)) {
                    fragment.mLifecycleRegistry.m(bVar);
                    zU0 = true;
                }
            }
        }
        return zU0;
    }

    final View M0(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f3552w.n(view, str, context, attributeSet);
    }

    public w N0() {
        return this.f3552w.l();
    }

    void T0() {
        while (U0(N0(), AbstractC0203h.b.CREATED)) {
        }
    }

    public void V0(Fragment fragment) {
    }

    protected void W0() {
        this.f3553x.h(AbstractC0203h.a.ON_RESUME);
        this.f3552w.h();
    }

    @Override // androidx.core.app.b.f
    public final void d(int i2) {
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (f0(strArr)) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            String str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.f3554y);
            printWriter.print(" mResumed=");
            printWriter.print(this.f3555z);
            printWriter.print(" mStopped=");
            printWriter.print(this.f3551A);
            if (getApplication() != null) {
                androidx.loader.app.a.b(this).a(str2, fileDescriptor, printWriter, strArr);
            }
            this.f3552w.l().X(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        this.f3552w.m();
        super.onActivityResult(i2, i3, intent);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.h, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3553x.h(AbstractC0203h.a.ON_CREATE);
        this.f3552w.e();
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewM0 = M0(view, str, context, attributeSet);
        return viewM0 == null ? super.onCreateView(view, str, context, attributeSet) : viewM0;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f3552w.f();
        this.f3553x.h(AbstractC0203h.a.ON_DESTROY);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        if (i2 == 6) {
            return this.f3552w.d(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.f3555z = false;
        this.f3552w.g();
        this.f3553x.h(AbstractC0203h.a.ON_PAUSE);
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        W0();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        this.f3552w.m();
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Override // android.app.Activity
    protected void onResume() {
        this.f3552w.m();
        super.onResume();
        this.f3555z = true;
        this.f3552w.k();
    }

    @Override // android.app.Activity
    protected void onStart() {
        this.f3552w.m();
        super.onStart();
        this.f3551A = false;
        if (!this.f3554y) {
            this.f3554y = true;
            this.f3552w.c();
        }
        this.f3552w.k();
        this.f3553x.h(AbstractC0203h.a.ON_START);
        this.f3552w.i();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.f3552w.m();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.f3551A = true;
        T0();
        this.f3552w.j();
        this.f3553x.h(AbstractC0203h.a.ON_STOP);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewM0 = M0(null, str, context, attributeSet);
        return viewM0 == null ? super.onCreateView(str, context, attributeSet) : viewM0;
    }
}
