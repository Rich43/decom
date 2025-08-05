package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.os.Handler;
import androidx.emoji2.text.f;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import u.h;
import v.AbstractC0345h;

/* loaded from: classes.dex */
public class k extends f.c {

    /* renamed from: k, reason: collision with root package name */
    private static final a f3319k = new a();

    public static class a {
        public Typeface a(Context context, h.b bVar) {
            return u.h.a(context, null, new h.b[]{bVar});
        }

        public h.a b(Context context, u.f fVar) {
            return u.h.b(context, null, fVar);
        }

        public void c(Context context, ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class b implements f.h {

        /* renamed from: a, reason: collision with root package name */
        private final Context f3320a;

        /* renamed from: b, reason: collision with root package name */
        private final u.f f3321b;

        /* renamed from: c, reason: collision with root package name */
        private final a f3322c;

        /* renamed from: d, reason: collision with root package name */
        private final Object f3323d = new Object();
        private Handler e;

        /* renamed from: f, reason: collision with root package name */
        private Executor f3324f;

        /* renamed from: g, reason: collision with root package name */
        private ThreadPoolExecutor f3325g;

        /* renamed from: h, reason: collision with root package name */
        f.i f3326h;

        /* renamed from: i, reason: collision with root package name */
        private ContentObserver f3327i;

        /* renamed from: j, reason: collision with root package name */
        private Runnable f3328j;

        b(Context context, u.f fVar, a aVar) {
            AbstractC0345h.g(context, "Context cannot be null");
            AbstractC0345h.g(fVar, "FontRequest cannot be null");
            this.f3320a = context.getApplicationContext();
            this.f3321b = fVar;
            this.f3322c = aVar;
        }

        private void b() {
            synchronized (this.f3323d) {
                try {
                    this.f3326h = null;
                    ContentObserver contentObserver = this.f3327i;
                    if (contentObserver != null) {
                        this.f3322c.c(this.f3320a, contentObserver);
                        this.f3327i = null;
                    }
                    Handler handler = this.e;
                    if (handler != null) {
                        handler.removeCallbacks(this.f3328j);
                    }
                    this.e = null;
                    ThreadPoolExecutor threadPoolExecutor = this.f3325g;
                    if (threadPoolExecutor != null) {
                        threadPoolExecutor.shutdown();
                    }
                    this.f3324f = null;
                    this.f3325g = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private h.b e() {
            try {
                h.a aVarB = this.f3322c.b(this.f3320a, this.f3321b);
                if (aVarB.c() == 0) {
                    h.b[] bVarArrB = aVarB.b();
                    if (bVarArrB == null || bVarArrB.length == 0) {
                        throw new RuntimeException("fetchFonts failed (empty result)");
                    }
                    return bVarArrB[0];
                }
                throw new RuntimeException("fetchFonts failed (" + aVarB.c() + ")");
            } catch (PackageManager.NameNotFoundException e) {
                throw new RuntimeException("provider not found", e);
            }
        }

        @Override // androidx.emoji2.text.f.h
        public void a(f.i iVar) {
            AbstractC0345h.g(iVar, "LoaderCallback cannot be null");
            synchronized (this.f3323d) {
                this.f3326h = iVar;
            }
            d();
        }

        void c() {
            synchronized (this.f3323d) {
                try {
                    if (this.f3326h == null) {
                        return;
                    }
                    try {
                        h.b bVarE = e();
                        int iB = bVarE.b();
                        if (iB == 2) {
                            synchronized (this.f3323d) {
                            }
                        }
                        if (iB != 0) {
                            throw new RuntimeException("fetchFonts result is not OK. (" + iB + ")");
                        }
                        try {
                            androidx.core.os.o.a("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                            Typeface typefaceA = this.f3322c.a(this.f3320a, bVarE);
                            ByteBuffer byteBufferF = androidx.core.graphics.p.f(this.f3320a, null, bVarE.d());
                            if (byteBufferF == null || typefaceA == null) {
                                throw new RuntimeException("Unable to open file.");
                            }
                            n nVarB = n.b(typefaceA, byteBufferF);
                            androidx.core.os.o.b();
                            synchronized (this.f3323d) {
                                try {
                                    f.i iVar = this.f3326h;
                                    if (iVar != null) {
                                        iVar.b(nVarB);
                                    }
                                } finally {
                                }
                            }
                            b();
                        } catch (Throwable th) {
                            androidx.core.os.o.b();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        synchronized (this.f3323d) {
                            try {
                                f.i iVar2 = this.f3326h;
                                if (iVar2 != null) {
                                    iVar2.a(th2);
                                }
                                b();
                            } finally {
                            }
                        }
                    }
                } finally {
                }
            }
        }

        void d() {
            synchronized (this.f3323d) {
                try {
                    if (this.f3326h == null) {
                        return;
                    }
                    if (this.f3324f == null) {
                        ThreadPoolExecutor threadPoolExecutorB = c.b("emojiCompat");
                        this.f3325g = threadPoolExecutorB;
                        this.f3324f = threadPoolExecutorB;
                    }
                    this.f3324f.execute(new Runnable() { // from class: androidx.emoji2.text.l
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f3329a.c();
                        }
                    });
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void f(Executor executor) {
            synchronized (this.f3323d) {
                this.f3324f = executor;
            }
        }
    }

    public k(Context context, u.f fVar) {
        super(new b(context, fVar, f3319k));
    }

    public k c(Executor executor) {
        ((b) a()).f(executor);
        return this;
    }
}
