package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import androidx.lifecycle.AbstractC0203h;

/* loaded from: classes.dex */
public class v extends Fragment {

    /* renamed from: b, reason: collision with root package name */
    public static final b f3750b = new b(null);

    /* renamed from: a, reason: collision with root package name */
    private a f3751a;

    public interface a {
        void a();

        void b();

        void onStart();
    }

    public static final class b {
        public /* synthetic */ b(i1.g gVar) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(Activity activity, AbstractC0203h.a aVar) {
            i1.k.e(activity, "activity");
            i1.k.e(aVar, "event");
            if (activity instanceof m) {
                AbstractC0203h lifecycle = ((m) activity).getLifecycle();
                if (lifecycle instanceof n) {
                    ((n) lifecycle).h(aVar);
                }
            }
        }

        public final v b(Activity activity) {
            i1.k.e(activity, "<this>");
            Fragment fragmentFindFragmentByTag = activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
            i1.k.c(fragmentFindFragmentByTag, "null cannot be cast to non-null type androidx.lifecycle.ReportFragment");
            return (v) fragmentFindFragmentByTag;
        }

        public final void c(Activity activity) {
            i1.k.e(activity, "activity");
            if (Build.VERSION.SDK_INT >= 29) {
                c.Companion.a(activity);
            }
            FragmentManager fragmentManager = activity.getFragmentManager();
            if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
                fragmentManager.beginTransaction().add(new v(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
                fragmentManager.executePendingTransactions();
            }
        }

        private b() {
        }
    }

    public static final class c implements Application.ActivityLifecycleCallbacks {
        public static final a Companion = new a(null);

        public static final class a {
            public /* synthetic */ a(i1.g gVar) {
                this();
            }

            public final void a(Activity activity) {
                i1.k.e(activity, "activity");
                activity.registerActivityLifecycleCallbacks(new c());
            }

            private a() {
            }
        }

        public static final void registerIn(Activity activity) {
            Companion.a(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            i1.k.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            i1.k.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            i1.k.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            i1.k.e(activity, "activity");
            v.f3750b.a(activity, AbstractC0203h.a.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            i1.k.e(activity, "activity");
            v.f3750b.a(activity, AbstractC0203h.a.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            i1.k.e(activity, "activity");
            v.f3750b.a(activity, AbstractC0203h.a.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity activity) {
            i1.k.e(activity, "activity");
            v.f3750b.a(activity, AbstractC0203h.a.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity activity) {
            i1.k.e(activity, "activity");
            v.f3750b.a(activity, AbstractC0203h.a.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity activity) {
            i1.k.e(activity, "activity");
            v.f3750b.a(activity, AbstractC0203h.a.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            i1.k.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            i1.k.e(activity, "activity");
            i1.k.e(bundle, "bundle");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            i1.k.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            i1.k.e(activity, "activity");
        }
    }

    private final void a(AbstractC0203h.a aVar) {
        if (Build.VERSION.SDK_INT < 29) {
            b bVar = f3750b;
            Activity activity = getActivity();
            i1.k.d(activity, "activity");
            bVar.a(activity, aVar);
        }
    }

    private final void b(a aVar) {
        if (aVar != null) {
            aVar.a();
        }
    }

    private final void c(a aVar) {
        if (aVar != null) {
            aVar.b();
        }
    }

    private final void d(a aVar) {
        if (aVar != null) {
            aVar.onStart();
        }
    }

    public final void e(a aVar) {
        this.f3751a = aVar;
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        b(this.f3751a);
        a(AbstractC0203h.a.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        a(AbstractC0203h.a.ON_DESTROY);
        this.f3751a = null;
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        a(AbstractC0203h.a.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        c(this.f3751a);
        a(AbstractC0203h.a.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        d(this.f3751a);
        a(AbstractC0203h.a.ON_START);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        a(AbstractC0203h.a.ON_STOP);
    }
}
