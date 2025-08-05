package z;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final c f7751a;

    private interface c {
        void a();

        Uri b();

        ClipDescription c();

        Object d();

        Uri e();
    }

    public f(Uri uri, ClipDescription clipDescription, Uri uri2) {
        if (Build.VERSION.SDK_INT >= 25) {
            this.f7751a = new a(uri, clipDescription, uri2);
        } else {
            this.f7751a = new b(uri, clipDescription, uri2);
        }
    }

    public static f f(Object obj) {
        if (obj != null && Build.VERSION.SDK_INT >= 25) {
            return new f(new a(obj));
        }
        return null;
    }

    public Uri a() {
        return this.f7751a.e();
    }

    public ClipDescription b() {
        return this.f7751a.c();
    }

    public Uri c() {
        return this.f7751a.b();
    }

    public void d() {
        this.f7751a.a();
    }

    public Object e() {
        return this.f7751a.d();
    }

    private static final class a implements c {

        /* renamed from: a, reason: collision with root package name */
        final InputContentInfo f7752a;

        a(Object obj) {
            this.f7752a = (InputContentInfo) obj;
        }

        @Override // z.f.c
        public void a() {
            this.f7752a.requestPermission();
        }

        @Override // z.f.c
        public Uri b() {
            return this.f7752a.getLinkUri();
        }

        @Override // z.f.c
        public ClipDescription c() {
            return this.f7752a.getDescription();
        }

        @Override // z.f.c
        public Object d() {
            return this.f7752a;
        }

        @Override // z.f.c
        public Uri e() {
            return this.f7752a.getContentUri();
        }

        a(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f7752a = new InputContentInfo(uri, clipDescription, uri2);
        }
    }

    private f(c cVar) {
        this.f7751a = cVar;
    }

    private static final class b implements c {

        /* renamed from: a, reason: collision with root package name */
        private final Uri f7753a;

        /* renamed from: b, reason: collision with root package name */
        private final ClipDescription f7754b;

        /* renamed from: c, reason: collision with root package name */
        private final Uri f7755c;

        b(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f7753a = uri;
            this.f7754b = clipDescription;
            this.f7755c = uri2;
        }

        @Override // z.f.c
        public Uri b() {
            return this.f7755c;
        }

        @Override // z.f.c
        public ClipDescription c() {
            return this.f7754b;
        }

        @Override // z.f.c
        public Object d() {
            return null;
        }

        @Override // z.f.c
        public Uri e() {
            return this.f7753a;
        }

        @Override // z.f.c
        public void a() {
        }
    }
}
