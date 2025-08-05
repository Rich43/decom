package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: androidx.lifecycle.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0205j {

    /* renamed from: a, reason: collision with root package name */
    public static final C0205j f3722a = new C0205j();

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f3723b = new AtomicBoolean(false);

    /* renamed from: androidx.lifecycle.j$a */
    public static final class a extends AbstractC0200e {
        @Override // androidx.lifecycle.AbstractC0200e, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            i1.k.e(activity, "activity");
            v.f3750b.c(activity);
        }
    }

    private C0205j() {
    }

    public static final void a(Context context) {
        i1.k.e(context, "context");
        if (f3723b.getAndSet(true)) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        i1.k.c(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new a());
    }
}
