package n;

/* loaded from: classes.dex */
class h implements g {

    /* renamed from: a, reason: collision with root package name */
    private final Object[] f6739a;

    /* renamed from: b, reason: collision with root package name */
    private int f6740b;

    h(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f6739a = new Object[i2];
    }

    @Override // n.g
    public void a(Object[] objArr, int i2) {
        if (i2 > objArr.length) {
            i2 = objArr.length;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            Object obj = objArr[i3];
            int i4 = this.f6740b;
            Object[] objArr2 = this.f6739a;
            if (i4 < objArr2.length) {
                objArr2[i4] = obj;
                this.f6740b = i4 + 1;
            }
        }
    }

    @Override // n.g
    public Object acquire() {
        int i2 = this.f6740b;
        if (i2 <= 0) {
            return null;
        }
        int i3 = i2 - 1;
        Object[] objArr = this.f6739a;
        Object obj = objArr[i3];
        objArr[i3] = null;
        this.f6740b = i2 - 1;
        return obj;
    }

    @Override // n.g
    public boolean release(Object obj) {
        int i2 = this.f6740b;
        Object[] objArr = this.f6739a;
        if (i2 >= objArr.length) {
            return false;
        }
        objArr[i2] = obj;
        this.f6740b = i2 + 1;
        return true;
    }
}
