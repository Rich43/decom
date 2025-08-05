package d0;

/* renamed from: d0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0247d {

    /* renamed from: a, reason: collision with root package name */
    private float f5804a;

    /* renamed from: b, reason: collision with root package name */
    private float f5805b;

    public C0247d(float f2, float f3) {
        this.f5804a = f2;
        this.f5805b = f3;
    }

    public boolean a(float f2, float f3) {
        return this.f5804a == f2 && this.f5805b == f3;
    }

    public float b() {
        return this.f5804a;
    }

    public float c() {
        return this.f5805b;
    }

    public void d(float f2, float f3) {
        this.f5804a = f2;
        this.f5805b = f3;
    }

    public String toString() {
        return b() + "x" + c();
    }

    public C0247d() {
        this(1.0f, 1.0f);
    }
}
