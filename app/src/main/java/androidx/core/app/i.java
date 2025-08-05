package androidx.core.app;

import android.content.res.Configuration;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f2876a;

    /* renamed from: b, reason: collision with root package name */
    private Configuration f2877b;

    public i(boolean z2) {
        this.f2876a = z2;
    }

    public final boolean a() {
        return this.f2876a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(boolean z2, Configuration configuration) {
        this(z2);
        i1.k.e(configuration, "newConfig");
        this.f2877b = configuration;
    }
}
