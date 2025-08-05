package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.LocaleManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.window.OnBackInvokedDispatcher;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.Executor;

/* renamed from: androidx.appcompat.app.f */
/* loaded from: classes.dex */
public abstract class AbstractC0131f {

    /* renamed from: a */
    static c f1708a = new c(new d());

    /* renamed from: b */
    private static int f1709b = -100;

    /* renamed from: c */
    private static androidx.core.os.e f1710c = null;

    /* renamed from: d */
    private static androidx.core.os.e f1711d = null;
    private static Boolean e = null;

    /* renamed from: f */
    private static boolean f1712f = false;

    /* renamed from: g */
    private static final androidx.collection.b f1713g = new androidx.collection.b();

    /* renamed from: h */
    private static final Object f1714h = new Object();

    /* renamed from: i */
    private static final Object f1715i = new Object();

    /* renamed from: androidx.appcompat.app.f$a */
    static class a {
        static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }
    }

    /* renamed from: androidx.appcompat.app.f$b */
    static class b {
        static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        static void b(Object obj, LocaleList localeList) {
            ((LocaleManager) obj).setApplicationLocales(localeList);
        }
    }

    /* renamed from: androidx.appcompat.app.f$c */
    static class c implements Executor {

        /* renamed from: a */
        private final Object f1716a = new Object();

        /* renamed from: b */
        final Queue f1717b = new ArrayDeque();

        /* renamed from: c */
        final Executor f1718c;

        /* renamed from: d */
        Runnable f1719d;

        c(Executor executor) {
            this.f1718c = executor;
        }

        public /* synthetic */ void d(Runnable runnable) {
            try {
                runnable.run();
            } finally {
                e();
            }
        }

        protected void e() {
            synchronized (this.f1716a) {
                try {
                    Runnable runnable = (Runnable) this.f1717b.poll();
                    this.f1719d = runnable;
                    if (runnable != null) {
                        this.f1718c.execute(runnable);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(final Runnable runnable) {
            synchronized (this.f1716a) {
                try {
                    this.f1717b.add(new Runnable() { // from class: androidx.appcompat.app.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f1720a.d(runnable);
                        }
                    });
                    if (this.f1719d == null) {
                        e();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* renamed from: androidx.appcompat.app.f$d */
    static class d implements Executor {
        d() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            new Thread(runnable).start();
        }
    }

    AbstractC0131f() {
    }

    static void E(AbstractC0131f abstractC0131f) {
        synchronized (f1714h) {
            F(abstractC0131f);
        }
    }

    private static void F(AbstractC0131f abstractC0131f) {
        synchronized (f1714h) {
            try {
                Iterator it = f1713g.iterator();
                while (it.hasNext()) {
                    AbstractC0131f abstractC0131f2 = (AbstractC0131f) ((WeakReference) it.next()).get();
                    if (abstractC0131f2 == abstractC0131f || abstractC0131f2 == null) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static void N(Context context) {
        if (Build.VERSION.SDK_INT >= 33) {
            ComponentName componentName = new ComponentName(context, "androidx.appcompat.app.AppLocalesMetadataHolderService");
            if (context.getPackageManager().getComponentEnabledSetting(componentName) != 1) {
                if (k().f()) {
                    String strB = androidx.core.app.e.b(context);
                    Object systemService = context.getSystemService("locale");
                    if (systemService != null) {
                        b.b(systemService, a.a(strB));
                    }
                }
                context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
            }
        }
    }

    static void O(final Context context) {
        if (u(context)) {
            if (Build.VERSION.SDK_INT >= 33) {
                if (f1712f) {
                    return;
                }
                f1708a.execute(new Runnable() { // from class: androidx.appcompat.app.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbstractC0131f.v(context);
                    }
                });
                return;
            }
            synchronized (f1715i) {
                try {
                    androidx.core.os.e eVar = f1710c;
                    if (eVar == null) {
                        if (f1711d == null) {
                            f1711d = androidx.core.os.e.c(androidx.core.app.e.b(context));
                        }
                        if (f1711d.f()) {
                        } else {
                            f1710c = f1711d;
                        }
                    } else if (!eVar.equals(f1711d)) {
                        androidx.core.os.e eVar2 = f1710c;
                        f1711d = eVar2;
                        androidx.core.app.e.a(context, eVar2.h());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    static void d(AbstractC0131f abstractC0131f) {
        synchronized (f1714h) {
            F(abstractC0131f);
            f1713g.add(new WeakReference(abstractC0131f));
        }
    }

    public static AbstractC0131f h(Activity activity, InterfaceC0129d interfaceC0129d) {
        return new h(activity, interfaceC0129d);
    }

    public static AbstractC0131f i(Dialog dialog, InterfaceC0129d interfaceC0129d) {
        return new h(dialog, interfaceC0129d);
    }

    public static androidx.core.os.e k() {
        if (Build.VERSION.SDK_INT >= 33) {
            Object objO = o();
            if (objO != null) {
                return androidx.core.os.e.i(b.a(objO));
            }
        } else {
            androidx.core.os.e eVar = f1710c;
            if (eVar != null) {
                return eVar;
            }
        }
        return androidx.core.os.e.e();
    }

    public static int m() {
        return f1709b;
    }

    static Object o() {
        Context contextL;
        Iterator it = f1713g.iterator();
        while (it.hasNext()) {
            AbstractC0131f abstractC0131f = (AbstractC0131f) ((WeakReference) it.next()).get();
            if (abstractC0131f != null && (contextL = abstractC0131f.l()) != null) {
                return contextL.getSystemService("locale");
            }
        }
        return null;
    }

    static androidx.core.os.e q() {
        return f1710c;
    }

    static boolean u(Context context) {
        if (e == null) {
            try {
                Bundle bundle = z.a(context).metaData;
                if (bundle != null) {
                    e = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                e = Boolean.FALSE;
            }
        }
        return e.booleanValue();
    }

    public static /* synthetic */ void v(Context context) {
        N(context);
        f1712f = true;
    }

    public abstract void A();

    public abstract void B(Bundle bundle);

    public abstract void C();

    public abstract void D();

    public abstract boolean G(int i2);

    public abstract void H(int i2);

    public abstract void I(View view);

    public abstract void J(View view, ViewGroup.LayoutParams layoutParams);

    public void K(OnBackInvokedDispatcher onBackInvokedDispatcher) {
    }

    public abstract void L(int i2);

    public abstract void M(CharSequence charSequence);

    public abstract void e(View view, ViewGroup.LayoutParams layoutParams);

    public void f(Context context) {
    }

    public Context g(Context context) {
        f(context);
        return context;
    }

    public abstract View j(int i2);

    public abstract Context l();

    public abstract int n();

    public abstract MenuInflater p();

    public abstract AbstractC0126a r();

    public abstract void s();

    public abstract void t();

    public abstract void w(Configuration configuration);

    public abstract void x(Bundle bundle);

    public abstract void y();

    public abstract void z(Bundle bundle);
}
