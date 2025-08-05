package androidx.lifecycle;

import androidx.lifecycle.AbstractC0203h;

/* loaded from: classes.dex */
public final class CompositeGeneratedAdaptersObserver implements InterfaceC0206k {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC0201f[] f3661a;

    public CompositeGeneratedAdaptersObserver(InterfaceC0201f[] interfaceC0201fArr) {
        i1.k.e(interfaceC0201fArr, "generatedAdapters");
        this.f3661a = interfaceC0201fArr;
    }

    @Override // androidx.lifecycle.InterfaceC0206k
    public void d(m mVar, AbstractC0203h.a aVar) {
        i1.k.e(mVar, "source");
        i1.k.e(aVar, "event");
        new p();
        InterfaceC0201f[] interfaceC0201fArr = this.f3661a;
        if (interfaceC0201fArr.length > 0) {
            InterfaceC0201f interfaceC0201f = interfaceC0201fArr[0];
            throw null;
        }
        if (interfaceC0201fArr.length <= 0) {
            return;
        }
        InterfaceC0201f interfaceC0201f2 = interfaceC0201fArr[0];
        throw null;
    }
}
