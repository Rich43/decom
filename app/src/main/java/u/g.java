package u;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import u.h;
import v.InterfaceC0338a;

/* loaded from: classes.dex */
abstract class g {

    /* renamed from: a, reason: collision with root package name */
    static final androidx.collection.e f7531a = new androidx.collection.e(16);

    /* renamed from: b, reason: collision with root package name */
    private static final ExecutorService f7532b = i.a("fonts-androidx", 10, 10000);

    /* renamed from: c, reason: collision with root package name */
    static final Object f7533c = new Object();

    /* renamed from: d, reason: collision with root package name */
    static final androidx.collection.g f7534d = new androidx.collection.g();

    class a implements Callable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7535a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f7536b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f7537c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f7538d;

        a(String str, Context context, f fVar, int i2) {
            this.f7535a = str;
            this.f7536b = context;
            this.f7537c = fVar;
            this.f7538d = i2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            return g.c(this.f7535a, this.f7536b, this.f7537c, this.f7538d);
        }
    }

    class b implements InterfaceC0338a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ C0329a f7539a;

        b(C0329a c0329a) {
            this.f7539a = c0329a;
        }

        @Override // v.InterfaceC0338a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(e eVar) {
            if (eVar == null) {
                eVar = new e(-3);
            }
            this.f7539a.b(eVar);
        }
    }

    class c implements Callable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7540a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f7541b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f7542c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f7543d;

        c(String str, Context context, f fVar, int i2) {
            this.f7540a = str;
            this.f7541b = context;
            this.f7542c = fVar;
            this.f7543d = i2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            try {
                return g.c(this.f7540a, this.f7541b, this.f7542c, this.f7543d);
            } catch (Throwable unused) {
                return new e(-3);
            }
        }
    }

    class d implements InterfaceC0338a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7544a;

        d(String str) {
            this.f7544a = str;
        }

        @Override // v.InterfaceC0338a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(e eVar) {
            synchronized (g.f7533c) {
                try {
                    androidx.collection.g gVar = g.f7534d;
                    ArrayList arrayList = (ArrayList) gVar.get(this.f7544a);
                    if (arrayList == null) {
                        return;
                    }
                    gVar.remove(this.f7544a);
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        ((InterfaceC0338a) arrayList.get(i2)).a(eVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private static String a(f fVar, int i2) {
        return fVar.d() + "-" + i2;
    }

    private static int b(h.a aVar) {
        int i2 = 1;
        if (aVar.c() != 0) {
            return aVar.c() != 1 ? -3 : -2;
        }
        h.b[] bVarArrB = aVar.b();
        if (bVarArrB != null && bVarArrB.length != 0) {
            i2 = 0;
            for (h.b bVar : bVarArrB) {
                int iB = bVar.b();
                if (iB != 0) {
                    if (iB < 0) {
                        return -3;
                    }
                    return iB;
                }
            }
        }
        return i2;
    }

    static e c(String str, Context context, f fVar, int i2) {
        androidx.collection.e eVar = f7531a;
        Typeface typeface = (Typeface) eVar.c(str);
        if (typeface != null) {
            return new e(typeface);
        }
        try {
            h.a aVarE = u.e.e(context, fVar, null);
            int iB = b(aVarE);
            if (iB != 0) {
                return new e(iB);
            }
            Typeface typefaceB = androidx.core.graphics.i.b(context, null, aVarE.b(), i2);
            if (typefaceB == null) {
                return new e(-3);
            }
            eVar.d(str, typefaceB);
            return new e(typefaceB);
        } catch (PackageManager.NameNotFoundException unused) {
            return new e(-1);
        }
    }

    static Typeface d(Context context, f fVar, int i2, Executor executor, C0329a c0329a) {
        String strA = a(fVar, i2);
        Typeface typeface = (Typeface) f7531a.c(strA);
        if (typeface != null) {
            c0329a.b(new e(typeface));
            return typeface;
        }
        b bVar = new b(c0329a);
        synchronized (f7533c) {
            try {
                androidx.collection.g gVar = f7534d;
                ArrayList arrayList = (ArrayList) gVar.get(strA);
                if (arrayList != null) {
                    arrayList.add(bVar);
                    return null;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(bVar);
                gVar.put(strA, arrayList2);
                c cVar = new c(strA, context, fVar, i2);
                if (executor == null) {
                    executor = f7532b;
                }
                i.b(executor, cVar, new d(strA));
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static Typeface e(Context context, f fVar, C0329a c0329a, int i2, int i3) {
        String strA = a(fVar, i2);
        Typeface typeface = (Typeface) f7531a.c(strA);
        if (typeface != null) {
            c0329a.b(new e(typeface));
            return typeface;
        }
        if (i3 == -1) {
            e eVarC = c(strA, context, fVar, i2);
            c0329a.b(eVarC);
            return eVarC.f7545a;
        }
        try {
            e eVar = (e) i.c(f7532b, new a(strA, context, fVar, i2), i3);
            c0329a.b(eVar);
            return eVar.f7545a;
        } catch (InterruptedException unused) {
            c0329a.b(new e(-3));
            return null;
        }
    }

    static final class e {

        /* renamed from: a, reason: collision with root package name */
        final Typeface f7545a;

        /* renamed from: b, reason: collision with root package name */
        final int f7546b;

        e(int i2) {
            this.f7545a = null;
            this.f7546b = i2;
        }

        boolean a() {
            return this.f7546b == 0;
        }

        e(Typeface typeface) {
            this.f7545a = typeface;
            this.f7546b = 0;
        }
    }
}
