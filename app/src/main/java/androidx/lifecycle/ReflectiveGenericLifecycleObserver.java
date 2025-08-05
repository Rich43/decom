package androidx.lifecycle;

import androidx.lifecycle.AbstractC0203h;
import androidx.lifecycle.C0197b;
import java.lang.reflect.InvocationTargetException;

@Deprecated
/* loaded from: classes.dex */
class ReflectiveGenericLifecycleObserver implements InterfaceC0206k {

    /* renamed from: a, reason: collision with root package name */
    private final Object f3701a;

    /* renamed from: b, reason: collision with root package name */
    private final C0197b.a f3702b;

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.f3701a = obj;
        this.f3702b = C0197b.f3707c.c(obj.getClass());
    }

    @Override // androidx.lifecycle.InterfaceC0206k
    public void d(m mVar, AbstractC0203h.a aVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.f3702b.a(mVar, aVar, this.f3701a);
    }
}
