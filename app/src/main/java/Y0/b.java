package Y0;

import android.hardware.Camera;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final int f1352a;

    /* renamed from: b, reason: collision with root package name */
    private final Camera f1353b;

    /* renamed from: c, reason: collision with root package name */
    private final a f1354c;

    /* renamed from: d, reason: collision with root package name */
    private final int f1355d;

    public b(int i2, Camera camera, a aVar, int i3) {
        this.f1352a = i2;
        this.f1353b = camera;
        this.f1354c = aVar;
        this.f1355d = i3;
    }

    public Camera a() {
        return this.f1353b;
    }

    public a b() {
        return this.f1354c;
    }

    public int c() {
        return this.f1355d;
    }

    public String toString() {
        return "Camera #" + this.f1352a + " : " + this.f1354c + ',' + this.f1355d;
    }
}
