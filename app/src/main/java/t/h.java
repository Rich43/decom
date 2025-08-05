package T;

import android.graphics.Path;
import android.graphics.PointF;
import d0.C0244a;

/* loaded from: classes.dex */
public class h extends C0244a {
    private Path o;

    /* renamed from: p, reason: collision with root package name */
    private final C0244a f863p;

    public h(Q.d dVar, C0244a c0244a) {
        super(dVar, c0244a.f5783b, c0244a.f5784c, c0244a.f5785d, c0244a.e, c0244a.f5786f);
        this.f863p = c0244a;
        i();
    }

    public void i() {
        Object obj;
        Object obj2 = this.f5784c;
        boolean z2 = (obj2 == null || (obj = this.f5783b) == null || !((PointF) obj).equals(((PointF) obj2).x, ((PointF) obj2).y)) ? false : true;
        Object obj3 = this.f5784c;
        if (obj3 == null || z2) {
            return;
        }
        C0244a c0244a = this.f863p;
        this.o = c0.j.d((PointF) this.f5783b, (PointF) obj3, c0244a.f5793m, c0244a.f5794n);
    }

    Path j() {
        return this.o;
    }
}
