package androidx.emoji2.text;

import android.content.Context;
import androidx.emoji2.text.f;
import androidx.lifecycle.AbstractC0198c;
import androidx.lifecycle.AbstractC0203h;
import androidx.lifecycle.InterfaceC0199d;
import androidx.lifecycle.ProcessLifecycleInitializer;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes.dex */
public class EmojiCompatInitializer implements M.a {

    static class a extends f.c {
        protected a(Context context) {
            super(new b(context));
            b(1);
        }
    }

    static class b implements f.h {

        /* renamed from: a, reason: collision with root package name */
        private final Context f3259a;

        class a extends f.i {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ f.i f3260a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ ThreadPoolExecutor f3261b;

            a(f.i iVar, ThreadPoolExecutor threadPoolExecutor) {
                this.f3260a = iVar;
                this.f3261b = threadPoolExecutor;
            }

            @Override // androidx.emoji2.text.f.i
            public void a(Throwable th) {
                try {
                    this.f3260a.a(th);
                } finally {
                    this.f3261b.shutdown();
                }
            }

            @Override // androidx.emoji2.text.f.i
            public void b(n nVar) {
                try {
                    this.f3260a.b(nVar);
                } finally {
                    this.f3261b.shutdown();
                }
            }
        }

        b(Context context) {
            this.f3259a = context.getApplicationContext();
        }

        @Override // androidx.emoji2.text.f.h
        public void a(final f.i iVar) {
            final ThreadPoolExecutor threadPoolExecutorB = androidx.emoji2.text.c.b("EmojiCompatInitializer");
            threadPoolExecutorB.execute(new Runnable() { // from class: androidx.emoji2.text.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f3298a.d(iVar, threadPoolExecutorB);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void d(f.i iVar, ThreadPoolExecutor threadPoolExecutor) {
            try {
                k kVarA = d.a(this.f3259a);
                if (kVarA == null) {
                    throw new RuntimeException("EmojiCompat font provider not available on this device.");
                }
                kVarA.c(threadPoolExecutor);
                kVarA.a().a(new a(iVar, threadPoolExecutor));
            } catch (Throwable th) {
                iVar.a(th);
                threadPoolExecutor.shutdown();
            }
        }
    }

    static class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                androidx.core.os.o.a("EmojiCompat.EmojiCompatInitializer.run");
                if (f.i()) {
                    f.c().l();
                }
            } finally {
                androidx.core.os.o.b();
            }
        }
    }

    @Override // M.a
    public List a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // M.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Boolean b(Context context) {
        f.h(new a(context));
        d(context);
        return Boolean.TRUE;
    }

    void d(Context context) {
        final AbstractC0203h lifecycle = ((androidx.lifecycle.m) androidx.startup.a.e(context).f(ProcessLifecycleInitializer.class)).getLifecycle();
        lifecycle.a(new InterfaceC0199d() { // from class: androidx.emoji2.text.EmojiCompatInitializer.1
            @Override // androidx.lifecycle.InterfaceC0199d
            public void a(androidx.lifecycle.m mVar) {
                EmojiCompatInitializer.this.e();
                lifecycle.c(this);
            }

            @Override // androidx.lifecycle.InterfaceC0199d
            public /* synthetic */ void b(androidx.lifecycle.m mVar) {
                AbstractC0198c.b(this, mVar);
            }

            @Override // androidx.lifecycle.InterfaceC0199d
            public /* synthetic */ void c(androidx.lifecycle.m mVar) {
                AbstractC0198c.a(this, mVar);
            }

            @Override // androidx.lifecycle.InterfaceC0199d
            public /* synthetic */ void e(androidx.lifecycle.m mVar) {
                AbstractC0198c.c(this, mVar);
            }

            @Override // androidx.lifecycle.InterfaceC0199d
            public /* synthetic */ void f(androidx.lifecycle.m mVar) {
                AbstractC0198c.e(this, mVar);
            }

            @Override // androidx.lifecycle.InterfaceC0199d
            public /* synthetic */ void g(androidx.lifecycle.m mVar) {
                AbstractC0198c.d(this, mVar);
            }
        });
    }

    void e() {
        androidx.emoji2.text.c.d().postDelayed(new c(), 500L);
    }
}
