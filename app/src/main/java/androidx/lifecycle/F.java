package androidx.lifecycle;

import I.a;
import android.app.Application;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class F {

    /* renamed from: a, reason: collision with root package name */
    private final I f3670a;

    /* renamed from: b, reason: collision with root package name */
    private final b f3671b;

    /* renamed from: c, reason: collision with root package name */
    private final I.a f3672c;

    public interface b {
        E a(Class cls);

        E b(Class cls, I.a aVar);
    }

    public static class c implements b {

        /* renamed from: b, reason: collision with root package name */
        private static c f3678b;

        /* renamed from: a, reason: collision with root package name */
        public static final a f3677a = new a(null);

        /* renamed from: c, reason: collision with root package name */
        public static final a.b f3679c = a.C0043a.f3680a;

        public static final class a {

            /* renamed from: androidx.lifecycle.F$c$a$a, reason: collision with other inner class name */
            private static final class C0043a implements a.b {

                /* renamed from: a, reason: collision with root package name */
                public static final C0043a f3680a = new C0043a();

                private C0043a() {
                }
            }

            public /* synthetic */ a(i1.g gVar) {
                this();
            }

            public final c a() {
                if (c.f3678b == null) {
                    c.f3678b = new c();
                }
                c cVar = c.f3678b;
                i1.k.b(cVar);
                return cVar;
            }

            private a() {
            }
        }

        @Override // androidx.lifecycle.F.b
        public E a(Class cls) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
            i1.k.e(cls, "modelClass");
            try {
                Object objNewInstance = cls.getDeclaredConstructor(null).newInstance(null);
                i1.k.d(objNewInstance, "{\n                modelC…wInstance()\n            }");
                return (E) objNewInstance;
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Cannot create an instance of " + cls, e);
            } catch (InstantiationException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (NoSuchMethodException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            }
        }

        @Override // androidx.lifecycle.F.b
        public /* synthetic */ E b(Class cls, I.a aVar) {
            return G.b(this, cls, aVar);
        }
    }

    public static class d {
        public abstract void c(E e);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public F(I i2, b bVar) {
        this(i2, bVar, null, 4, null);
        i1.k.e(i2, "store");
        i1.k.e(bVar, "factory");
    }

    public E a(Class cls) {
        i1.k.e(cls, "modelClass");
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
    }

    public E b(String str, Class cls) {
        E eA;
        i1.k.e(str, "key");
        i1.k.e(cls, "modelClass");
        E eB = this.f3670a.b(str);
        if (!cls.isInstance(eB)) {
            I.d dVar = new I.d(this.f3672c);
            dVar.c(c.f3679c, str);
            try {
                eA = this.f3671b.b(cls, dVar);
            } catch (AbstractMethodError unused) {
                eA = this.f3671b.a(cls);
            }
            this.f3670a.d(str, eA);
            return eA;
        }
        Object obj = this.f3671b;
        d dVar2 = obj instanceof d ? (d) obj : null;
        if (dVar2 != null) {
            i1.k.b(eB);
            dVar2.c(eB);
        }
        i1.k.c(eB, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
        return eB;
    }

    public static class a extends c {

        /* renamed from: f, reason: collision with root package name */
        private static a f3673f;

        /* renamed from: d, reason: collision with root package name */
        private final Application f3675d;
        public static final C0041a e = new C0041a(null);

        /* renamed from: g, reason: collision with root package name */
        public static final a.b f3674g = C0041a.C0042a.f3676a;

        /* renamed from: androidx.lifecycle.F$a$a, reason: collision with other inner class name */
        public static final class C0041a {

            /* renamed from: androidx.lifecycle.F$a$a$a, reason: collision with other inner class name */
            private static final class C0042a implements a.b {

                /* renamed from: a, reason: collision with root package name */
                public static final C0042a f3676a = new C0042a();

                private C0042a() {
                }
            }

            public /* synthetic */ C0041a(i1.g gVar) {
                this();
            }

            public final a a(Application application) {
                i1.k.e(application, "application");
                if (a.f3673f == null) {
                    a.f3673f = new a(application);
                }
                a aVar = a.f3673f;
                i1.k.b(aVar);
                return aVar;
            }

            private C0041a() {
            }
        }

        private a(Application application, int i2) {
            this.f3675d = application;
        }

        private final E g(Class cls, Application application) {
            if (!AbstractC0196a.class.isAssignableFrom(cls)) {
                return super.a(cls);
            }
            try {
                E e2 = (E) cls.getConstructor(Application.class).newInstance(application);
                i1.k.d(e2, "{\n                try {\n…          }\n            }");
                return e2;
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            } catch (InstantiationException e4) {
                throw new RuntimeException("Cannot create an instance of " + cls, e4);
            } catch (NoSuchMethodException e5) {
                throw new RuntimeException("Cannot create an instance of " + cls, e5);
            } catch (InvocationTargetException e6) {
                throw new RuntimeException("Cannot create an instance of " + cls, e6);
            }
        }

        @Override // androidx.lifecycle.F.c, androidx.lifecycle.F.b
        public E a(Class cls) {
            i1.k.e(cls, "modelClass");
            Application application = this.f3675d;
            if (application != null) {
                return g(cls, application);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        @Override // androidx.lifecycle.F.c, androidx.lifecycle.F.b
        public E b(Class cls, I.a aVar) {
            i1.k.e(cls, "modelClass");
            i1.k.e(aVar, "extras");
            if (this.f3675d != null) {
                return a(cls);
            }
            Application application = (Application) aVar.a(f3674g);
            if (application != null) {
                return g(cls, application);
            }
            if (AbstractC0196a.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
            }
            return super.a(cls);
        }

        public a() {
            this(null, 0);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(Application application) {
            this(application, 0);
            i1.k.e(application, "application");
        }
    }

    public F(I i2, b bVar, I.a aVar) {
        i1.k.e(i2, "store");
        i1.k.e(bVar, "factory");
        i1.k.e(aVar, "defaultCreationExtras");
        this.f3670a = i2;
        this.f3671b = bVar;
        this.f3672c = aVar;
    }

    public /* synthetic */ F(I i2, b bVar, I.a aVar, int i3, i1.g gVar) {
        this(i2, bVar, (i3 & 4) != 0 ? a.C0006a.f236b : aVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public F(J j2, b bVar) {
        this(j2.getViewModelStore(), bVar, H.a(j2));
        i1.k.e(j2, "owner");
        i1.k.e(bVar, "factory");
    }
}
