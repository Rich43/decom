package Q;

import a0.t;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    private static final Map f570a = new HashMap();

    static class a implements Q.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f571a;

        a(String str) {
            this.f571a = str;
        }

        @Override // Q.g
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Q.d dVar) {
            if (this.f571a != null) {
                V.g.b().c(this.f571a, dVar);
            }
            e.f570a.remove(this.f571a);
        }
    }

    static class b implements Q.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f572a;

        b(String str) {
            this.f572a = str;
        }

        @Override // Q.g
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Throwable th) {
            e.f570a.remove(this.f572a);
        }
    }

    static class c implements Callable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f573a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f574b;

        c(Context context, String str) {
            this.f573a = context;
            this.f574b = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public j call() {
            return Z.c.e(this.f573a, this.f574b);
        }
    }

    static class d implements Callable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f575a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f576b;

        d(Context context, String str) {
            this.f575a = context;
            this.f576b = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public j call() {
            return e.e(this.f575a, this.f576b);
        }
    }

    /* renamed from: Q.e$e, reason: collision with other inner class name */
    static class CallableC0010e implements Callable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f577a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f578b;

        CallableC0010e(Context context, int i2) {
            this.f577a = context;
            this.f578b = i2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public j call() {
            return e.l(this.f577a, this.f578b);
        }
    }

    static class f implements Callable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b0.c f579a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f580b;

        f(b0.c cVar, String str) {
            this.f579a = cVar;
            this.f580b = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public j call() {
            return e.i(this.f579a, this.f580b);
        }
    }

    static class g implements Callable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Q.d f581a;

        g(Q.d dVar) {
            this.f581a = dVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public j call() {
            return new j(this.f581a);
        }
    }

    private static k b(String str, Callable callable) {
        Q.d dVarA = str == null ? null : V.g.b().a(str);
        if (dVarA != null) {
            return new k(new g(dVarA));
        }
        if (str != null) {
            Map map = f570a;
            if (map.containsKey(str)) {
                return (k) map.get(str);
            }
        }
        k kVar = new k(callable);
        kVar.f(new a(str));
        kVar.e(new b(str));
        f570a.put(str, kVar);
        return kVar;
    }

    private static Q.f c(Q.d dVar, String str) {
        for (Q.f fVar : dVar.i().values()) {
            if (fVar.b().equals(str)) {
                return fVar;
            }
        }
        return null;
    }

    public static k d(Context context, String str) {
        return b(str, new d(context.getApplicationContext(), str));
    }

    public static j e(Context context, String str) {
        try {
            String str2 = "asset_" + str;
            return str.endsWith(".zip") ? n(new ZipInputStream(context.getAssets().open(str)), str2) : f(context.getAssets().open(str), str2);
        } catch (IOException e) {
            return new j((Throwable) e);
        }
    }

    public static j f(InputStream inputStream, String str) {
        return g(inputStream, str, true);
    }

    private static j g(InputStream inputStream, String str, boolean z2) throws IOException {
        try {
            return i(b0.c.v(r1.e.a(r1.e.c(inputStream))), str);
        } finally {
            if (z2) {
                c0.j.c(inputStream);
            }
        }
    }

    public static k h(b0.c cVar, String str) {
        return b(str, new f(cVar, str));
    }

    public static j i(b0.c cVar, String str) {
        return j(cVar, str, true);
    }

    private static j j(b0.c cVar, String str, boolean z2) throws IOException {
        try {
            try {
                Q.d dVarA = t.a(cVar);
                V.g.b().c(str, dVarA);
                j jVar = new j(dVarA);
                if (z2) {
                    c0.j.c(cVar);
                }
                return jVar;
            } catch (Exception e) {
                j jVar2 = new j((Throwable) e);
                if (z2) {
                    c0.j.c(cVar);
                }
                return jVar2;
            }
        } catch (Throwable th) {
            if (z2) {
                c0.j.c(cVar);
            }
            throw th;
        }
    }

    public static k k(Context context, int i2) {
        return b(p(i2), new CallableC0010e(context.getApplicationContext(), i2));
    }

    public static j l(Context context, int i2) {
        try {
            return f(context.getResources().openRawResource(i2), p(i2));
        } catch (Resources.NotFoundException e) {
            return new j((Throwable) e);
        }
    }

    public static k m(Context context, String str) {
        return b("url_" + str, new c(context, str));
    }

    public static j n(ZipInputStream zipInputStream, String str) {
        try {
            return o(zipInputStream, str);
        } finally {
            c0.j.c(zipInputStream);
        }
    }

    private static j o(ZipInputStream zipInputStream, String str) throws IOException {
        HashMap map = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            Q.d dVar = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    dVar = (Q.d) j(b0.c.v(r1.e.a(r1.e.c(zipInputStream))), null, false).b();
                } else if (name.contains(".png") || name.contains(".webp")) {
                    map.put(name.split("/")[r1.length - 1], BitmapFactory.decodeStream(zipInputStream));
                } else {
                    zipInputStream.closeEntry();
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (dVar == null) {
                return new j((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : map.entrySet()) {
                Q.f fVarC = c(dVar, (String) entry.getKey());
                if (fVarC != null) {
                    fVarC.f(c0.j.k((Bitmap) entry.getValue(), fVarC.e(), fVarC.c()));
                }
            }
            for (Map.Entry entry2 : dVar.i().entrySet()) {
                if (((Q.f) entry2.getValue()).a() == null) {
                    return new j((Throwable) new IllegalStateException("There is no image for " + ((Q.f) entry2.getValue()).b()));
                }
            }
            V.g.b().c(str, dVar);
            return new j(dVar);
        } catch (IOException e) {
            return new j((Throwable) e);
        }
    }

    private static String p(int i2) {
        return "rawRes_" + i2;
    }
}
