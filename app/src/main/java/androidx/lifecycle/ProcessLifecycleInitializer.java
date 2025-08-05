package androidx.lifecycle;

import android.content.Context;
import androidx.lifecycle.u;
import java.util.List;

/* loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements M.a {
    @Override // M.a
    public List a() {
        return b1.l.e();
    }

    @Override // M.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public m b(Context context) {
        i1.k.e(context, "context");
        androidx.startup.a aVarE = androidx.startup.a.e(context);
        i1.k.d(aVarE, "getInstance(context)");
        if (!aVarE.g(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml");
        }
        C0205j.a(context);
        u.b bVar = u.f3739i;
        bVar.b(context);
        return bVar.a();
    }
}
