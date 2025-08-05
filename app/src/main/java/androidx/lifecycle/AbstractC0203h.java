package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: androidx.lifecycle.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0203h {

    /* renamed from: a, reason: collision with root package name */
    private AtomicReference f3714a = new AtomicReference();

    /* renamed from: androidx.lifecycle.h$a */
    public enum a {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;

        public static final C0045a Companion = new C0045a(null);

        /* renamed from: androidx.lifecycle.h$a$a, reason: collision with other inner class name */
        public static final class C0045a {

            /* renamed from: androidx.lifecycle.h$a$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C0046a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f3715a;

                static {
                    int[] iArr = new int[b.values().length];
                    try {
                        iArr[b.CREATED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[b.STARTED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[b.RESUMED.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[b.DESTROYED.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[b.INITIALIZED.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    f3715a = iArr;
                }
            }

            public /* synthetic */ C0045a(i1.g gVar) {
                this();
            }

            public final a a(b bVar) {
                i1.k.e(bVar, "state");
                int i2 = C0046a.f3715a[bVar.ordinal()];
                if (i2 == 1) {
                    return a.ON_DESTROY;
                }
                if (i2 == 2) {
                    return a.ON_STOP;
                }
                if (i2 != 3) {
                    return null;
                }
                return a.ON_PAUSE;
            }

            public final a b(b bVar) {
                i1.k.e(bVar, "state");
                int i2 = C0046a.f3715a[bVar.ordinal()];
                if (i2 == 1) {
                    return a.ON_START;
                }
                if (i2 == 2) {
                    return a.ON_RESUME;
                }
                if (i2 != 5) {
                    return null;
                }
                return a.ON_CREATE;
            }

            private C0045a() {
            }
        }

        /* renamed from: androidx.lifecycle.h$a$b */
        public /* synthetic */ class b {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f3716a;

            static {
                int[] iArr = new int[a.values().length];
                try {
                    iArr[a.ON_CREATE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[a.ON_STOP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[a.ON_START.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[a.ON_PAUSE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[a.ON_RESUME.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[a.ON_DESTROY.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[a.ON_ANY.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                f3716a = iArr;
            }
        }

        public final b b() {
            switch (b.f3716a[ordinal()]) {
                case 1:
                case 2:
                    return b.CREATED;
                case 3:
                case 4:
                    return b.STARTED;
                case 5:
                    return b.RESUMED;
                case 6:
                    return b.DESTROYED;
                default:
                    throw new IllegalArgumentException(this + " has no target state");
            }
        }
    }

    /* renamed from: androidx.lifecycle.h$b */
    public enum b {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public final boolean b(b bVar) {
            i1.k.e(bVar, "state");
            return compareTo(bVar) >= 0;
        }
    }

    public abstract void a(InterfaceC0207l interfaceC0207l);

    public abstract b b();

    public abstract void c(InterfaceC0207l interfaceC0207l);
}
