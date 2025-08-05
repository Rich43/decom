package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import defpackage.e;

/* loaded from: classes.dex */
public class d extends ContextWrapper {

    /* renamed from: f, reason: collision with root package name */
    private static Configuration f1822f;

    /* renamed from: a, reason: collision with root package name */
    private int f1823a;

    /* renamed from: b, reason: collision with root package name */
    private Resources.Theme f1824b;

    /* renamed from: c, reason: collision with root package name */
    private LayoutInflater f1825c;

    /* renamed from: d, reason: collision with root package name */
    private Configuration f1826d;
    private Resources e;

    public d(Context context, int i2) {
        super(context);
        this.f1823a = i2;
    }

    private Resources b() {
        if (this.e == null) {
            Configuration configuration = this.f1826d;
            if (configuration == null || (Build.VERSION.SDK_INT >= 26 && e(configuration))) {
                this.e = super.getResources();
            } else {
                this.e = createConfigurationContext(this.f1826d).getResources();
            }
        }
        return this.e;
    }

    private void d() {
        boolean z2 = this.f1824b == null;
        if (z2) {
            this.f1824b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f1824b.setTo(theme);
            }
        }
        f(this.f1824b, this.f1823a, z2);
    }

    private static boolean e(Configuration configuration) {
        if (configuration == null) {
            return true;
        }
        if (f1822f == null) {
            Configuration configuration2 = new Configuration();
            configuration2.fontScale = 0.0f;
            f1822f = configuration2;
        }
        return configuration.equals(f1822f);
    }

    public void a(Configuration configuration) {
        if (this.e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f1826d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f1826d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public int c() {
        return this.f1823a;
    }

    protected void f(Resources.Theme theme, int i2, boolean z2) {
        theme.applyStyle(i2, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return b();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f1825c == null) {
            this.f1825c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f1825c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f1824b;
        if (theme != null) {
            return theme;
        }
        if (this.f1823a == 0) {
            this.f1823a = e.l.f5971d;
        }
        d();
        return this.f1824b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        if (this.f1823a != i2) {
            this.f1823a = i2;
            d();
        }
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f1824b = theme;
    }
}
