package v;

import i1.k;

/* renamed from: v.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0344g extends C0343f {

    /* renamed from: c, reason: collision with root package name */
    private final Object f7675c;

    public C0344g(int i2) {
        super(i2);
        this.f7675c = new Object();
    }

    @Override // v.C0343f, v.InterfaceC0342e
    public Object acquire() {
        Object objAcquire;
        synchronized (this.f7675c) {
            objAcquire = super.acquire();
        }
        return objAcquire;
    }

    @Override // v.C0343f, v.InterfaceC0342e
    public boolean release(Object obj) {
        boolean zRelease;
        k.e(obj, "instance");
        synchronized (this.f7675c) {
            zRelease = super.release(obj);
        }
        return zRelease;
    }
}
