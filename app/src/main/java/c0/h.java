package c0;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private float f4644a;

    /* renamed from: b, reason: collision with root package name */
    private int f4645b;

    public void a(float f2) {
        float f3 = this.f4644a + f2;
        this.f4644a = f3;
        int i2 = this.f4645b + 1;
        this.f4645b = i2;
        if (i2 == Integer.MAX_VALUE) {
            this.f4644a = f3 / 2.0f;
            this.f4645b = i2 / 2;
        }
    }
}
