package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.AbstractC0203h;
import androidx.lifecycle.v;

/* loaded from: classes.dex */
public final class u implements m {

    /* renamed from: i, reason: collision with root package name */
    public static final b f3739i = new b(null);

    /* renamed from: j, reason: collision with root package name */
    private static final u f3740j = new u();

    /* renamed from: a, reason: collision with root package name */
    private int f3741a;

    /* renamed from: b, reason: collision with root package name */
    private int f3742b;
    private Handler e;

    /* renamed from: c, reason: collision with root package name */
    private boolean f3743c = true;

    /* renamed from: d, reason: collision with root package name */
    private boolean f3744d = true;

    /* renamed from: f, reason: collision with root package name */
    private final n f3745f = new n(this);

    /* renamed from: g, reason: collision with root package name */
    private final Runnable f3746g = new Runnable() { // from class: androidx.lifecycle.t
        @Override // java.lang.Runnable
        public final void run() {
            u.j(this.f3738a);
        }
    };

    /* renamed from: h, reason: collision with root package name */
    private final v.a f3747h = new d();

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f3748a = new a();

        private a() {
        }

        public static final void a(Activity activity, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            i1.k.e(activity, "activity");
            i1.k.e(activityLifecycleCallbacks, "callback");
            activity.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    public static final class b {
        public /* synthetic */ b(i1.g gVar) {
            this();
        }

        public final m a() {
            return u.f3740j;
        }

        public final void b(Context context) {
            i1.k.e(context, "context");
            u.f3740j.i(context);
        }

        private b() {
        }
    }

    public static final class c extends AbstractC0200e {

        public static final class a extends AbstractC0200e {
            final /* synthetic */ u this$0;

            a(u uVar) {
                this.this$0 = uVar;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostResumed(Activity activity) {
                i1.k.e(activity, "activity");
                this.this$0.e();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostStarted(Activity activity) {
                i1.k.e(activity, "activity");
                this.this$0.g();
            }
        }

        c() {
        }

        @Override // androidx.lifecycle.AbstractC0200e, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            i1.k.e(activity, "activity");
            if (Build.VERSION.SDK_INT < 29) {
                v.f3750b.b(activity).e(u.this.f3747h);
            }
        }

        @Override // androidx.lifecycle.AbstractC0200e, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            i1.k.e(activity, "activity");
            u.this.d();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            i1.k.e(activity, "activity");
            a.a(activity, new a(u.this));
        }

        @Override // androidx.lifecycle.AbstractC0200e, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            i1.k.e(activity, "activity");
            u.this.h();
        }
    }

    public static final class d implements v.a {
        d() {
        }

        @Override // androidx.lifecycle.v.a
        public void a() {
        }

        @Override // androidx.lifecycle.v.a
        public void b() {
            u.this.e();
        }

        @Override // androidx.lifecycle.v.a
        public void onStart() {
            u.this.g();
        }
    }

    private u() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(u uVar) {
        i1.k.e(uVar, "this$0");
        uVar.k();
        uVar.l();
    }

    public final void d() {
        int i2 = this.f3742b - 1;
        this.f3742b = i2;
        if (i2 == 0) {
            Handler handler = this.e;
            i1.k.b(handler);
            handler.postDelayed(this.f3746g, 700L);
        }
    }

    public final void e() {
        int i2 = this.f3742b + 1;
        this.f3742b = i2;
        if (i2 == 1) {
            if (this.f3743c) {
                this.f3745f.h(AbstractC0203h.a.ON_RESUME);
                this.f3743c = false;
            } else {
                Handler handler = this.e;
                i1.k.b(handler);
                handler.removeCallbacks(this.f3746g);
            }
        }
    }

    public final void g() {
        int i2 = this.f3741a + 1;
        this.f3741a = i2;
        if (i2 == 1 && this.f3744d) {
            this.f3745f.h(AbstractC0203h.a.ON_START);
            this.f3744d = false;
        }
    }

    @Override // androidx.lifecycle.m
    public AbstractC0203h getLifecycle() {
        return this.f3745f;
    }

    public final void h() {
        this.f3741a--;
        l();
    }

    public final void i(Context context) {
        i1.k.e(context, "context");
        this.e = new Handler();
        this.f3745f.h(AbstractC0203h.a.ON_CREATE);
        Context applicationContext = context.getApplicationContext();
        i1.k.c(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new c());
    }

    public final void k() {
        if (this.f3742b == 0) {
            this.f3743c = true;
            this.f3745f.h(AbstractC0203h.a.ON_PAUSE);
        }
    }

    public final void l() {
        if (this.f3741a == 0 && this.f3743c) {
            this.f3745f.h(AbstractC0203h.a.ON_STOP);
            this.f3744d = true;
        }
    }
}
