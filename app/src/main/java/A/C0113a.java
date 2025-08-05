package a;

import android.content.Context;
import i1.k;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: a.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0113a {

    /* renamed from: a, reason: collision with root package name */
    private final Set f1383a = new CopyOnWriteArraySet();

    /* renamed from: b, reason: collision with root package name */
    private volatile Context f1384b;

    public final void a(b bVar) {
        k.e(bVar, "listener");
        Context context = this.f1384b;
        if (context != null) {
            bVar.a(context);
        }
        this.f1383a.add(bVar);
    }

    public final void b() {
        this.f1384b = null;
    }

    public final void c(Context context) {
        k.e(context, "context");
        this.f1384b = context;
        Iterator it = this.f1383a.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(context);
        }
    }
}
