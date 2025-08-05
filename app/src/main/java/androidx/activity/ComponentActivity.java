package androidx.activity;

import I.a;
import a.C0113a;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.ComponentActivity;
import androidx.core.view.C0180x;
import androidx.core.view.InterfaceC0179w;
import androidx.core.view.InterfaceC0182z;
import androidx.lifecycle.AbstractC0203h;
import androidx.lifecycle.C;
import androidx.lifecycle.F;
import androidx.lifecycle.I;
import androidx.lifecycle.InterfaceC0202g;
import androidx.lifecycle.InterfaceC0206k;
import androidx.lifecycle.J;
import androidx.lifecycle.K;
import androidx.lifecycle.L;
import androidx.savedstate.a;
import c.AbstractC0224a;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import v.InterfaceC0338a;

/* loaded from: classes.dex */
public abstract class ComponentActivity extends androidx.core.app.h implements androidx.lifecycle.m, J, InterfaceC0202g, L.d, w, b.f, androidx.core.content.b, androidx.core.content.c, androidx.core.app.o, androidx.core.app.p, InterfaceC0179w, t {

    /* renamed from: v */
    private static final b f1441v = new b(null);

    /* renamed from: c */
    private final C0113a f1442c = new C0113a();

    /* renamed from: d */
    private final C0180x f1443d = new C0180x(new Runnable() { // from class: androidx.activity.d
        @Override // java.lang.Runnable
        public final void run() {
            ComponentActivity.E0(this.f1507a);
        }
    });
    private final L.c e;

    /* renamed from: f */
    private I f1444f;

    /* renamed from: g */
    private final d f1445g;

    /* renamed from: h */
    private final a1.a f1446h;

    /* renamed from: i */
    private int f1447i;

    /* renamed from: j */
    private final AtomicInteger f1448j;

    /* renamed from: k */
    private final b.e f1449k;

    /* renamed from: l */
    private final CopyOnWriteArrayList f1450l;

    /* renamed from: m */
    private final CopyOnWriteArrayList f1451m;

    /* renamed from: n */
    private final CopyOnWriteArrayList f1452n;
    private final CopyOnWriteArrayList o;

    /* renamed from: p */
    private final CopyOnWriteArrayList f1453p;

    /* renamed from: q */
    private final CopyOnWriteArrayList f1454q;
    private boolean r;
    private boolean s;

    /* renamed from: t */
    private final a1.a f1455t;

    /* renamed from: u */
    private final a1.a f1456u;

    /* renamed from: androidx.activity.ComponentActivity$4 */
    public static final class AnonymousClass4 implements InterfaceC0206k {
        AnonymousClass4() {
        }

        @Override // androidx.lifecycle.InterfaceC0206k
        public void d(androidx.lifecycle.m mVar, AbstractC0203h.a aVar) {
            i1.k.e(mVar, "source");
            i1.k.e(aVar, "event");
            ComponentActivity.this.A0();
            ComponentActivity.this.getLifecycle().c(this);
        }
    }

    private static final class a {

        /* renamed from: a */
        public static final a f1458a = new a();

        private a() {
        }

        public final OnBackInvokedDispatcher a(Activity activity) {
            i1.k.e(activity, "activity");
            OnBackInvokedDispatcher onBackInvokedDispatcher = activity.getOnBackInvokedDispatcher();
            i1.k.d(onBackInvokedDispatcher, "activity.getOnBackInvokedDispatcher()");
            return onBackInvokedDispatcher;
        }
    }

    private static final class b {
        public /* synthetic */ b(i1.g gVar) {
            this();
        }

        private b() {
        }
    }

    public static final class c {

        /* renamed from: a */
        private Object f1459a;

        /* renamed from: b */
        private I f1460b;

        public final I a() {
            return this.f1460b;
        }

        public final void b(Object obj) {
            this.f1459a = obj;
        }

        public final void c(I i2) {
            this.f1460b = i2;
        }
    }

    private interface d extends Executor {
        void a();

        void b(View view);
    }

    final class e implements d, ViewTreeObserver.OnDrawListener, Runnable {

        /* renamed from: a */
        private final long f1461a = SystemClock.uptimeMillis() + 10000;

        /* renamed from: b */
        private Runnable f1462b;

        /* renamed from: c */
        private boolean f1463c;

        public e() {
        }

        public static final void d(e eVar) {
            i1.k.e(eVar, "this$0");
            Runnable runnable = eVar.f1462b;
            if (runnable != null) {
                i1.k.b(runnable);
                runnable.run();
                eVar.f1462b = null;
            }
        }

        @Override // androidx.activity.ComponentActivity.d
        public void a() {
            ComponentActivity.this.getWindow().getDecorView().removeCallbacks(this);
            ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        @Override // androidx.activity.ComponentActivity.d
        public void b(View view) {
            i1.k.e(view, "view");
            if (this.f1463c) {
                return;
            }
            this.f1463c = true;
            view.getViewTreeObserver().addOnDrawListener(this);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            i1.k.e(runnable, "runnable");
            this.f1462b = runnable;
            View decorView = ComponentActivity.this.getWindow().getDecorView();
            i1.k.d(decorView, "window.decorView");
            if (!this.f1463c) {
                decorView.postOnAnimation(new Runnable() { // from class: androidx.activity.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        ComponentActivity.e.d(this.f1514a);
                    }
                });
            } else if (i1.k.a(Looper.myLooper(), Looper.getMainLooper())) {
                decorView.invalidate();
            } else {
                decorView.postInvalidate();
            }
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            Runnable runnable = this.f1462b;
            if (runnable == null) {
                if (SystemClock.uptimeMillis() > this.f1461a) {
                    this.f1463c = false;
                    ComponentActivity.this.getWindow().getDecorView().post(this);
                    return;
                }
                return;
            }
            runnable.run();
            this.f1462b = null;
            if (ComponentActivity.this.B0().c()) {
                this.f1463c = false;
                ComponentActivity.this.getWindow().getDecorView().post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }
    }

    public static final class f extends b.e {
        f() {
        }

        public static final void s(f fVar, int i2, AbstractC0224a.C0062a c0062a) {
            i1.k.e(fVar, "this$0");
            fVar.f(i2, c0062a.a());
        }

        public static final void t(f fVar, int i2, IntentSender.SendIntentException sendIntentException) {
            i1.k.e(fVar, "this$0");
            i1.k.e(sendIntentException, "$e");
            fVar.e(i2, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", sendIntentException));
        }

        @Override // b.e
        public void i(final int i2, AbstractC0224a abstractC0224a, Object obj, androidx.core.app.c cVar) {
            Bundle bundle;
            i1.k.e(abstractC0224a, "contract");
            ComponentActivity componentActivity = ComponentActivity.this;
            final AbstractC0224a.C0062a c0062aB = abstractC0224a.b(componentActivity, obj);
            if (c0062aB != null) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: androidx.activity.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        ComponentActivity.f.s(this.f1515a, i2, c0062aB);
                    }
                });
                return;
            }
            Intent intentA = abstractC0224a.a(componentActivity, obj);
            if (intentA.getExtras() != null) {
                Bundle extras = intentA.getExtras();
                i1.k.b(extras);
                if (extras.getClassLoader() == null) {
                    intentA.setExtrasClassLoader(componentActivity.getClassLoader());
                }
            }
            if (intentA.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                Bundle bundleExtra = intentA.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                intentA.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                bundle = bundleExtra;
            } else {
                bundle = null;
            }
            if (i1.k.a("androidx.activity.result.contract.action.REQUEST_PERMISSIONS", intentA.getAction())) {
                String[] stringArrayExtra = intentA.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                if (stringArrayExtra == null) {
                    stringArrayExtra = new String[0];
                }
                androidx.core.app.b.m(componentActivity, stringArrayExtra, i2);
                return;
            }
            if (!i1.k.a("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST", intentA.getAction())) {
                androidx.core.app.b.o(componentActivity, intentA, i2, bundle);
                return;
            }
            b.g gVar = (b.g) intentA.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
            try {
                i1.k.b(gVar);
                androidx.core.app.b.p(componentActivity, gVar.d(), i2, gVar.a(), gVar.b(), gVar.c(), 0, bundle);
            } catch (IntentSender.SendIntentException e) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: androidx.activity.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        ComponentActivity.f.t(this.f1518a, i2, e);
                    }
                });
            }
        }
    }

    static final class g extends i1.l implements h1.a {
        g() {
            super(0);
        }

        @Override // h1.a
        /* renamed from: c */
        public final C a() {
            Application application = ComponentActivity.this.getApplication();
            ComponentActivity componentActivity = ComponentActivity.this;
            return new C(application, componentActivity, componentActivity.getIntent() != null ? ComponentActivity.this.getIntent().getExtras() : null);
        }
    }

    static final class h extends i1.l implements h1.a {

        static final class a extends i1.l implements h1.a {

            /* renamed from: b */
            final /* synthetic */ ComponentActivity f1468b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ComponentActivity componentActivity) {
                super(0);
                this.f1468b = componentActivity;
            }

            @Override // h1.a
            public /* bridge */ /* synthetic */ Object a() {
                c();
                return a1.i.f1440a;
            }

            public final void c() {
                this.f1468b.reportFullyDrawn();
            }
        }

        h() {
            super(0);
        }

        @Override // h1.a
        /* renamed from: c */
        public final s a() {
            return new s(ComponentActivity.this.f1445g, new a(ComponentActivity.this));
        }
    }

    static final class i extends i1.l implements h1.a {
        i() {
            super(0);
        }

        public static final void f(ComponentActivity componentActivity) {
            i1.k.e(componentActivity, "this$0");
            try {
                ComponentActivity.super.onBackPressed();
            } catch (IllegalStateException e) {
                if (!i1.k.a(e.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw e;
                }
            } catch (NullPointerException e2) {
                if (!i1.k.a(e2.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                    throw e2;
                }
            }
        }

        public static final void g(ComponentActivity componentActivity, OnBackPressedDispatcher onBackPressedDispatcher) {
            i1.k.e(componentActivity, "this$0");
            i1.k.e(onBackPressedDispatcher, "$dispatcher");
            componentActivity.v0(onBackPressedDispatcher);
        }

        @Override // h1.a
        /* renamed from: e */
        public final OnBackPressedDispatcher a() {
            final ComponentActivity componentActivity = ComponentActivity.this;
            final OnBackPressedDispatcher onBackPressedDispatcher = new OnBackPressedDispatcher(new Runnable() { // from class: androidx.activity.m
                @Override // java.lang.Runnable
                public final void run() {
                    ComponentActivity.i.f(componentActivity);
                }
            });
            final ComponentActivity componentActivity2 = ComponentActivity.this;
            if (Build.VERSION.SDK_INT >= 33) {
                if (i1.k.a(Looper.myLooper(), Looper.getMainLooper())) {
                    componentActivity2.v0(onBackPressedDispatcher);
                } else {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: androidx.activity.n
                        @Override // java.lang.Runnable
                        public final void run() {
                            ComponentActivity.i.g(componentActivity2, onBackPressedDispatcher);
                        }
                    });
                }
            }
            return onBackPressedDispatcher;
        }
    }

    public ComponentActivity() {
        L.c cVarA = L.c.f276d.a(this);
        this.e = cVarA;
        this.f1445g = z0();
        this.f1446h = a1.b.a(new h());
        this.f1448j = new AtomicInteger();
        this.f1449k = new f();
        this.f1450l = new CopyOnWriteArrayList();
        this.f1451m = new CopyOnWriteArrayList();
        this.f1452n = new CopyOnWriteArrayList();
        this.o = new CopyOnWriteArrayList();
        this.f1453p = new CopyOnWriteArrayList();
        this.f1454q = new CopyOnWriteArrayList();
        if (getLifecycle() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        getLifecycle().a(new InterfaceC0206k() { // from class: androidx.activity.e
            @Override // androidx.lifecycle.InterfaceC0206k
            public final void d(androidx.lifecycle.m mVar, AbstractC0203h.a aVar) {
                ComponentActivity.n0(this.f1508a, mVar, aVar);
            }
        });
        getLifecycle().a(new InterfaceC0206k() { // from class: androidx.activity.f
            @Override // androidx.lifecycle.InterfaceC0206k
            public final void d(androidx.lifecycle.m mVar, AbstractC0203h.a aVar) {
                ComponentActivity.o0(this.f1509a, mVar, aVar);
            }
        });
        getLifecycle().a(new InterfaceC0206k() { // from class: androidx.activity.ComponentActivity.4
            AnonymousClass4() {
            }

            @Override // androidx.lifecycle.InterfaceC0206k
            public void d(androidx.lifecycle.m mVar, AbstractC0203h.a aVar) {
                i1.k.e(mVar, "source");
                i1.k.e(aVar, "event");
                ComponentActivity.this.A0();
                ComponentActivity.this.getLifecycle().c(this);
            }
        });
        cVarA.c();
        androidx.lifecycle.z.c(this);
        if (Build.VERSION.SDK_INT <= 23) {
            getLifecycle().a(new ImmLeaksCleaner(this));
        }
        getSavedStateRegistry().h("android:support:activity-result", new a.c() { // from class: androidx.activity.g
            @Override // androidx.savedstate.a.c
            public final Bundle a() {
                return ComponentActivity.p0(this.f1510a);
            }
        });
        x0(new a.b() { // from class: androidx.activity.h
            @Override // a.b
            public final void a(Context context) {
                ComponentActivity.q0(this.f1511a, context);
            }
        });
        this.f1455t = a1.b.a(new g());
        this.f1456u = a1.b.a(new i());
    }

    public final void A0() {
        if (this.f1444f == null) {
            c cVar = (c) getLastNonConfigurationInstance();
            if (cVar != null) {
                this.f1444f = cVar.a();
            }
            if (this.f1444f == null) {
                this.f1444f = new I();
            }
        }
    }

    public static final void E0(ComponentActivity componentActivity) {
        i1.k.e(componentActivity, "this$0");
        componentActivity.D0();
    }

    public static final void n0(ComponentActivity componentActivity, androidx.lifecycle.m mVar, AbstractC0203h.a aVar) {
        Window window;
        View viewPeekDecorView;
        i1.k.e(componentActivity, "this$0");
        i1.k.e(mVar, "<anonymous parameter 0>");
        i1.k.e(aVar, "event");
        if (aVar != AbstractC0203h.a.ON_STOP || (window = componentActivity.getWindow()) == null || (viewPeekDecorView = window.peekDecorView()) == null) {
            return;
        }
        viewPeekDecorView.cancelPendingInputEvents();
    }

    public static final void o0(ComponentActivity componentActivity, androidx.lifecycle.m mVar, AbstractC0203h.a aVar) {
        i1.k.e(componentActivity, "this$0");
        i1.k.e(mVar, "<anonymous parameter 0>");
        i1.k.e(aVar, "event");
        if (aVar == AbstractC0203h.a.ON_DESTROY) {
            componentActivity.f1442c.b();
            if (!componentActivity.isChangingConfigurations()) {
                componentActivity.getViewModelStore().a();
            }
            componentActivity.f1445g.a();
        }
    }

    public static final Bundle p0(ComponentActivity componentActivity) {
        i1.k.e(componentActivity, "this$0");
        Bundle bundle = new Bundle();
        componentActivity.f1449k.k(bundle);
        return bundle;
    }

    public static final void q0(ComponentActivity componentActivity, Context context) {
        i1.k.e(componentActivity, "this$0");
        i1.k.e(context, "it");
        Bundle bundleB = componentActivity.getSavedStateRegistry().b("android:support:activity-result");
        if (bundleB != null) {
            componentActivity.f1449k.j(bundleB);
        }
    }

    public final void v0(final OnBackPressedDispatcher onBackPressedDispatcher) {
        getLifecycle().a(new InterfaceC0206k() { // from class: androidx.activity.i
            @Override // androidx.lifecycle.InterfaceC0206k
            public final void d(androidx.lifecycle.m mVar, AbstractC0203h.a aVar) {
                ComponentActivity.w0(onBackPressedDispatcher, this, mVar, aVar);
            }
        });
    }

    public static final void w0(OnBackPressedDispatcher onBackPressedDispatcher, ComponentActivity componentActivity, androidx.lifecycle.m mVar, AbstractC0203h.a aVar) {
        i1.k.e(onBackPressedDispatcher, "$dispatcher");
        i1.k.e(componentActivity, "this$0");
        i1.k.e(mVar, "<anonymous parameter 0>");
        i1.k.e(aVar, "event");
        if (aVar == AbstractC0203h.a.ON_CREATE) {
            onBackPressedDispatcher.n(a.f1458a.a(componentActivity));
        }
    }

    private final d z0() {
        return new e();
    }

    public s B0() {
        return (s) this.f1446h.getValue();
    }

    public void C0() {
        View decorView = getWindow().getDecorView();
        i1.k.d(decorView, "window.decorView");
        K.a(decorView, this);
        View decorView2 = getWindow().getDecorView();
        i1.k.d(decorView2, "window.decorView");
        L.a(decorView2, this);
        View decorView3 = getWindow().getDecorView();
        i1.k.d(decorView3, "window.decorView");
        L.e.a(decorView3, this);
        View decorView4 = getWindow().getDecorView();
        i1.k.d(decorView4, "window.decorView");
        z.a(decorView4, this);
        View decorView5 = getWindow().getDecorView();
        i1.k.d(decorView5, "window.decorView");
        y.a(decorView5, this);
    }

    public void D0() {
        invalidateOptionsMenu();
    }

    public Object F0() {
        return null;
    }

    public final b.c G0(AbstractC0224a abstractC0224a, b.b bVar) {
        i1.k.e(abstractC0224a, "contract");
        i1.k.e(bVar, "callback");
        return H0(abstractC0224a, this.f1449k, bVar);
    }

    public final b.c H0(AbstractC0224a abstractC0224a, b.e eVar, b.b bVar) {
        i1.k.e(abstractC0224a, "contract");
        i1.k.e(eVar, "registry");
        i1.k.e(bVar, "callback");
        return eVar.l("activity_rq#" + this.f1448j.getAndIncrement(), this, abstractC0224a, bVar);
    }

    @Override // androidx.core.content.c
    public final void I(InterfaceC0338a interfaceC0338a) {
        i1.k.e(interfaceC0338a, "listener");
        this.f1451m.add(interfaceC0338a);
    }

    @Override // androidx.core.app.o
    public final void L(InterfaceC0338a interfaceC0338a) {
        i1.k.e(interfaceC0338a, "listener");
        this.o.add(interfaceC0338a);
    }

    @Override // androidx.core.app.p
    public final void M(InterfaceC0338a interfaceC0338a) {
        i1.k.e(interfaceC0338a, "listener");
        this.f1453p.add(interfaceC0338a);
    }

    @Override // androidx.core.content.c
    public final void Z(InterfaceC0338a interfaceC0338a) {
        i1.k.e(interfaceC0338a, "listener");
        this.f1451m.remove(interfaceC0338a);
    }

    @Override // androidx.core.app.p
    public final void a0(InterfaceC0338a interfaceC0338a) {
        i1.k.e(interfaceC0338a, "listener");
        this.f1453p.remove(interfaceC0338a);
    }

    @Override // androidx.core.content.b
    public final void b(InterfaceC0338a interfaceC0338a) {
        i1.k.e(interfaceC0338a, "listener");
        this.f1450l.remove(interfaceC0338a);
    }

    @Override // androidx.core.app.o
    public final void b0(InterfaceC0338a interfaceC0338a) {
        i1.k.e(interfaceC0338a, "listener");
        this.o.remove(interfaceC0338a);
    }

    @Override // androidx.activity.w
    public final OnBackPressedDispatcher f() {
        return (OnBackPressedDispatcher) this.f1456u.getValue();
    }

    @Override // androidx.lifecycle.InterfaceC0202g
    public I.a getDefaultViewModelCreationExtras() {
        I.d dVar = new I.d(null, 1, null);
        if (getApplication() != null) {
            a.b bVar = F.a.f3674g;
            Application application = getApplication();
            i1.k.d(application, "application");
            dVar.c(bVar, application);
        }
        dVar.c(androidx.lifecycle.z.f3759a, this);
        dVar.c(androidx.lifecycle.z.f3760b, this);
        Intent intent = getIntent();
        Bundle extras = intent != null ? intent.getExtras() : null;
        if (extras != null) {
            dVar.c(androidx.lifecycle.z.f3761c, extras);
        }
        return dVar;
    }

    @Override // androidx.core.app.h, androidx.lifecycle.m
    public AbstractC0203h getLifecycle() {
        return super.getLifecycle();
    }

    @Override // L.d
    public final androidx.savedstate.a getSavedStateRegistry() {
        return this.e.b();
    }

    @Override // androidx.lifecycle.J
    public I getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        A0();
        I i2 = this.f1444f;
        i1.k.b(i2);
        return i2;
    }

    @Override // androidx.core.content.b
    public final void m(InterfaceC0338a interfaceC0338a) {
        i1.k.e(interfaceC0338a, "listener");
        this.f1450l.add(interfaceC0338a);
    }

    @Override // androidx.core.view.InterfaceC0179w
    public void n(InterfaceC0182z interfaceC0182z) {
        i1.k.e(interfaceC0182z, "provider");
        this.f1443d.f(interfaceC0182z);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        if (this.f1449k.e(i2, i3, intent)) {
            return;
        }
        super.onActivityResult(i2, i3, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        f().k();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        i1.k.e(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        Iterator it = this.f1450l.iterator();
        while (it.hasNext()) {
            ((InterfaceC0338a) it.next()).a(configuration);
        }
    }

    @Override // androidx.core.app.h, android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.e.d(bundle);
        this.f1442c.c(this);
        super.onCreate(bundle);
        androidx.lifecycle.v.f3750b.c(this);
        int i2 = this.f1447i;
        if (i2 != 0) {
            setContentView(i2);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i2, Menu menu) {
        i1.k.e(menu, "menu");
        if (i2 != 0) {
            return true;
        }
        super.onCreatePanelMenu(i2, menu);
        this.f1443d.b(menu, getMenuInflater());
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        i1.k.e(menuItem, "item");
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        if (i2 == 0) {
            return this.f1443d.d(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z2) {
        if (this.r) {
            return;
        }
        Iterator it = this.o.iterator();
        while (it.hasNext()) {
            ((InterfaceC0338a) it.next()).a(new androidx.core.app.i(z2));
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        i1.k.e(intent, "intent");
        super.onNewIntent(intent);
        Iterator it = this.f1452n.iterator();
        while (it.hasNext()) {
            ((InterfaceC0338a) it.next()).a(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i2, Menu menu) {
        i1.k.e(menu, "menu");
        this.f1443d.c(menu);
        super.onPanelClosed(i2, menu);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z2) {
        if (this.s) {
            return;
        }
        Iterator it = this.f1453p.iterator();
        while (it.hasNext()) {
            ((InterfaceC0338a) it.next()).a(new androidx.core.app.q(z2));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i2, View view, Menu menu) {
        i1.k.e(menu, "menu");
        if (i2 != 0) {
            return true;
        }
        super.onPreparePanel(i2, view, menu);
        this.f1443d.e(menu);
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        i1.k.e(strArr, "permissions");
        i1.k.e(iArr, "grantResults");
        if (this.f1449k.e(i2, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr)) || Build.VERSION.SDK_INT < 23) {
            return;
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        c cVar;
        Object objF0 = F0();
        I iA = this.f1444f;
        if (iA == null && (cVar = (c) getLastNonConfigurationInstance()) != null) {
            iA = cVar.a();
        }
        if (iA == null && objF0 == null) {
            return null;
        }
        c cVar2 = new c();
        cVar2.b(objF0);
        cVar2.c(iA);
        return cVar2;
    }

    @Override // androidx.core.app.h, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        i1.k.e(bundle, "outState");
        if (getLifecycle() instanceof androidx.lifecycle.n) {
            AbstractC0203h lifecycle = getLifecycle();
            i1.k.c(lifecycle, "null cannot be cast to non-null type androidx.lifecycle.LifecycleRegistry");
            ((androidx.lifecycle.n) lifecycle).m(AbstractC0203h.b.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.e.e(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        super.onTrimMemory(i2);
        Iterator it = this.f1451m.iterator();
        while (it.hasNext()) {
            ((InterfaceC0338a) it.next()).a(Integer.valueOf(i2));
        }
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        Iterator it = this.f1454q.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    @Override // androidx.core.view.InterfaceC0179w
    public void r(InterfaceC0182z interfaceC0182z) {
        i1.k.e(interfaceC0182z, "provider");
        this.f1443d.a(interfaceC0182z);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (N.b.d()) {
                N.b.a("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            B0().b();
            N.b.b();
        } catch (Throwable th) {
            N.b.b();
            throw th;
        }
    }

    @Override // b.f
    public final b.e s() {
        return this.f1449k;
    }

    @Override // android.app.Activity
    public abstract void setContentView(int i2);

    @Override // android.app.Activity
    public void setContentView(View view) {
        C0();
        d dVar = this.f1445g;
        View decorView = getWindow().getDecorView();
        i1.k.d(decorView, "window.decorView");
        dVar.b(decorView);
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i2) {
        i1.k.e(intent, "intent");
        super.startActivityForResult(intent, i2);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) throws IntentSender.SendIntentException {
        i1.k.e(intentSender, "intent");
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
    }

    public final void x0(a.b bVar) {
        i1.k.e(bVar, "listener");
        this.f1442c.a(bVar);
    }

    public final void y0(InterfaceC0338a interfaceC0338a) {
        i1.k.e(interfaceC0338a, "listener");
        this.f1452n.add(interfaceC0338a);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i2, Bundle bundle) {
        i1.k.e(intent, "intent");
        super.startActivityForResult(intent, i2, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        i1.k.e(intentSender, "intent");
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z2, Configuration configuration) {
        i1.k.e(configuration, "newConfig");
        this.r = true;
        try {
            super.onMultiWindowModeChanged(z2, configuration);
            this.r = false;
            Iterator it = this.o.iterator();
            while (it.hasNext()) {
                ((InterfaceC0338a) it.next()).a(new androidx.core.app.i(z2, configuration));
            }
        } catch (Throwable th) {
            this.r = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z2, Configuration configuration) {
        i1.k.e(configuration, "newConfig");
        this.s = true;
        try {
            super.onPictureInPictureModeChanged(z2, configuration);
            this.s = false;
            Iterator it = this.f1453p.iterator();
            while (it.hasNext()) {
                ((InterfaceC0338a) it.next()).a(new androidx.core.app.q(z2, configuration));
            }
        } catch (Throwable th) {
            this.s = false;
            throw th;
        }
    }
}
