package pl.droidsonroids.gif;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes.dex */
final class c extends ScheduledThreadPoolExecutor {

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private static final c f7175a = new c();
    }

    static c c() {
        return b.f7175a;
    }

    private c() {
        super(1, new ThreadPoolExecutor.DiscardPolicy());
    }
}
