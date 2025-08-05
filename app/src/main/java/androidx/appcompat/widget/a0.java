package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class a0 extends ContextWrapper {

    /* renamed from: c, reason: collision with root package name */
    private static final Object f2375c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static ArrayList f2376d;

    /* renamed from: a, reason: collision with root package name */
    private final Resources f2377a;

    /* renamed from: b, reason: collision with root package name */
    private final Resources.Theme f2378b;

    private a0(Context context) {
        super(context);
        if (!n0.c()) {
            this.f2377a = new c0(this, context.getResources());
            this.f2378b = null;
            return;
        }
        n0 n0Var = new n0(this, context.getResources());
        this.f2377a = n0Var;
        Resources.Theme themeNewTheme = n0Var.newTheme();
        this.f2378b = themeNewTheme;
        themeNewTheme.setTo(context.getTheme());
    }

    private static boolean a(Context context) {
        if ((context instanceof a0) || (context.getResources() instanceof c0) || (context.getResources() instanceof n0)) {
            return false;
        }
        return n0.c();
    }

    public static Context b(Context context) {
        if (!a(context)) {
            return context;
        }
        synchronized (f2375c) {
            try {
                ArrayList arrayList = f2376d;
                if (arrayList == null) {
                    f2376d = new ArrayList();
                } else {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        WeakReference weakReference = (WeakReference) f2376d.get(size);
                        if (weakReference == null || weakReference.get() == null) {
                            f2376d.remove(size);
                        }
                    }
                    for (int size2 = f2376d.size() - 1; size2 >= 0; size2--) {
                        WeakReference weakReference2 = (WeakReference) f2376d.get(size2);
                        a0 a0Var = weakReference2 != null ? (a0) weakReference2.get() : null;
                        if (a0Var != null && a0Var.getBaseContext() == context) {
                            return a0Var;
                        }
                    }
                }
                a0 a0Var2 = new a0(context);
                f2376d.add(new WeakReference(a0Var2));
                return a0Var2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f2377a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f2377a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f2378b;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        Resources.Theme theme = this.f2378b;
        if (theme == null) {
            super.setTheme(i2);
        } else {
            theme.applyStyle(i2, true);
        }
    }
}
