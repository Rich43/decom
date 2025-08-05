package X;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f1125a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f1126b;

    public c(float[] fArr, int[] iArr) {
        this.f1125a = fArr;
        this.f1126b = iArr;
    }

    public int[] a() {
        return this.f1126b;
    }

    public float[] b() {
        return this.f1125a;
    }

    public int c() {
        return this.f1126b.length;
    }

    public void d(c cVar, c cVar2, float f2) {
        if (cVar.f1126b.length == cVar2.f1126b.length) {
            for (int i2 = 0; i2 < cVar.f1126b.length; i2++) {
                this.f1125a[i2] = c0.i.j(cVar.f1125a[i2], cVar2.f1125a[i2], f2);
                this.f1126b[i2] = c0.d.c(f2, cVar.f1126b[i2], cVar2.f1126b[i2]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.f1126b.length + " vs " + cVar2.f1126b.length + ")");
    }
}
