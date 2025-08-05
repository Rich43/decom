package androidx.lifecycle;

import androidx.lifecycle.AbstractC0203h;

/* loaded from: classes.dex */
public final class DefaultLifecycleObserverAdapter implements InterfaceC0206k {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC0199d f3664a;

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC0206k f3665b;

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3666a;

        static {
            int[] iArr = new int[AbstractC0203h.a.values().length];
            try {
                iArr[AbstractC0203h.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AbstractC0203h.a.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AbstractC0203h.a.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AbstractC0203h.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AbstractC0203h.a.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AbstractC0203h.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AbstractC0203h.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f3666a = iArr;
        }
    }

    public DefaultLifecycleObserverAdapter(InterfaceC0199d interfaceC0199d, InterfaceC0206k interfaceC0206k) {
        i1.k.e(interfaceC0199d, "defaultLifecycleObserver");
        this.f3664a = interfaceC0199d;
        this.f3665b = interfaceC0206k;
    }

    @Override // androidx.lifecycle.InterfaceC0206k
    public void d(m mVar, AbstractC0203h.a aVar) {
        i1.k.e(mVar, "source");
        i1.k.e(aVar, "event");
        switch (a.f3666a[aVar.ordinal()]) {
            case 1:
                this.f3664a.c(mVar);
                break;
            case 2:
                this.f3664a.g(mVar);
                break;
            case 3:
                this.f3664a.a(mVar);
                break;
            case 4:
                this.f3664a.e(mVar);
                break;
            case 5:
                this.f3664a.f(mVar);
                break;
            case 6:
                this.f3664a.b(mVar);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        InterfaceC0206k interfaceC0206k = this.f3665b;
        if (interfaceC0206k != null) {
            interfaceC0206k.d(mVar, aVar);
        }
    }
}
