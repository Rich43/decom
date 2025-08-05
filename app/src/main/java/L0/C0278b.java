package l0;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Handler;
import android.os.Looper;
import h0.n;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import q0.AbstractC0319h;

/* renamed from: l0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0278b {

    /* renamed from: c, reason: collision with root package name */
    private final Handler f6527c = new Handler(Looper.getMainLooper());

    /* renamed from: a, reason: collision with root package name */
    private Map f6525a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private ExecutorService f6526b = Executors.newFixedThreadPool(5);

    /* renamed from: l0.b$a */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ n f6528a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ InterfaceC0090b f6529b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f6530c;

        /* renamed from: l0.b$a$a, reason: collision with other inner class name */
        class RunnableC0089a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Bitmap f6532a;

            RunnableC0089a(Bitmap bitmap) {
                this.f6532a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap = this.f6532a;
                if (bitmap == null) {
                    a aVar = a.this;
                    aVar.f6529b.onError(aVar.f6530c);
                } else {
                    a aVar2 = a.this;
                    aVar2.f6529b.a(bitmap, aVar2.f6530c);
                }
            }
        }

        a(n nVar, InterfaceC0090b interfaceC0090b, String str) {
            this.f6528a = nVar;
            this.f6529b = interfaceC0090b;
            this.f6530c = str;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            C0278b.this.f6527c.post(new RunnableC0089a(C0278b.this.d(this.f6528a)));
        }
    }

    /* renamed from: l0.b$b, reason: collision with other inner class name */
    public interface InterfaceC0090b {
        void a(Bitmap bitmap, String str);

        void onError(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap d(n nVar) throws Throwable {
        if (nVar.k()) {
            return AbstractC0319h.e(nVar.j(), 320, 320);
        }
        Bitmap bitmapCreateVideoThumbnail = ThumbnailUtils.createVideoThumbnail(nVar.c(), 1);
        AbstractC0319h.j(bitmapCreateVideoThumbnail, new File(nVar.j()));
        return bitmapCreateVideoThumbnail;
    }

    public void c() {
        Iterator it = this.f6525a.keySet().iterator();
        while (it.hasNext()) {
            Bitmap bitmap = (Bitmap) ((SoftReference) this.f6525a.get((String) it.next())).get();
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
        this.f6525a.clear();
        if (this.f6526b.isShutdown()) {
            return;
        }
        this.f6526b.shutdown();
    }

    public void e(n nVar, InterfaceC0090b interfaceC0090b) {
        Bitmap bitmap;
        String strC = nVar.c();
        if (!this.f6525a.containsKey(strC) || (bitmap = (Bitmap) ((SoftReference) this.f6525a.get(strC)).get()) == null || bitmap.isRecycled()) {
            this.f6526b.execute(new a(nVar, interfaceC0090b, strC));
        } else {
            interfaceC0090b.a(bitmap, strC);
        }
    }
}
