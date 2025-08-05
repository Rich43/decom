package v;

import i1.k;

/* renamed from: v.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0343f implements InterfaceC0342e {

    /* renamed from: a, reason: collision with root package name */
    private final Object[] f7673a;

    /* renamed from: b, reason: collision with root package name */
    private int f7674b;

    public C0343f(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f7673a = new Object[i2];
    }

    private final boolean a(Object obj) {
        int i2 = this.f7674b;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.f7673a[i3] == obj) {
                return true;
            }
        }
        return false;
    }

    @Override // v.InterfaceC0342e
    public Object acquire() {
        int i2 = this.f7674b;
        if (i2 <= 0) {
            return null;
        }
        int i3 = i2 - 1;
        Object obj = this.f7673a[i3];
        k.c(obj, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
        this.f7673a[i3] = null;
        this.f7674b--;
        return obj;
    }

    @Override // v.InterfaceC0342e
    public boolean release(Object obj) {
        k.e(obj, "instance");
        if (a(obj)) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i2 = this.f7674b;
        Object[] objArr = this.f7673a;
        if (i2 >= objArr.length) {
            return false;
        }
        objArr[i2] = obj;
        this.f7674b = i2 + 1;
        return true;
    }
}
