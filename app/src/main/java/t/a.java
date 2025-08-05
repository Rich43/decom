package T;

import d0.C0244a;
import d0.C0246c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: c, reason: collision with root package name */
    private final List f851c;
    protected C0246c e;

    /* renamed from: f, reason: collision with root package name */
    private C0244a f853f;

    /* renamed from: g, reason: collision with root package name */
    private C0244a f854g;

    /* renamed from: a, reason: collision with root package name */
    final List f849a = new ArrayList(1);

    /* renamed from: b, reason: collision with root package name */
    private boolean f850b = false;

    /* renamed from: d, reason: collision with root package name */
    private float f852d = 0.0f;

    /* renamed from: h, reason: collision with root package name */
    private float f855h = -1.0f;

    /* renamed from: i, reason: collision with root package name */
    private Object f856i = null;

    /* renamed from: j, reason: collision with root package name */
    private float f857j = -1.0f;

    /* renamed from: k, reason: collision with root package name */
    private float f858k = -1.0f;

    /* renamed from: T.a$a, reason: collision with other inner class name */
    public interface InterfaceC0012a {
        void b();
    }

    a(List list) {
        this.f851c = list;
    }

    private float g() {
        if (this.f857j == -1.0f) {
            this.f857j = this.f851c.isEmpty() ? 0.0f : ((C0244a) this.f851c.get(0)).e();
        }
        return this.f857j;
    }

    public void a(InterfaceC0012a interfaceC0012a) {
        this.f849a.add(interfaceC0012a);
    }

    protected C0244a b() {
        C0244a c0244a = this.f853f;
        if (c0244a != null && c0244a.a(this.f852d)) {
            return this.f853f;
        }
        C0244a c0244a2 = (C0244a) this.f851c.get(r0.size() - 1);
        if (this.f852d < c0244a2.e()) {
            for (int size = this.f851c.size() - 1; size >= 0; size--) {
                c0244a2 = (C0244a) this.f851c.get(size);
                if (c0244a2.a(this.f852d)) {
                    break;
                }
            }
        }
        this.f853f = c0244a2;
        return c0244a2;
    }

    float c() {
        float fB;
        if (this.f858k == -1.0f) {
            if (this.f851c.isEmpty()) {
                fB = 1.0f;
            } else {
                fB = ((C0244a) this.f851c.get(r0.size() - 1)).b();
            }
            this.f858k = fB;
        }
        return this.f858k;
    }

    protected float d() {
        C0244a c0244aB = b();
        if (c0244aB.h()) {
            return 0.0f;
        }
        return c0244aB.f5785d.getInterpolation(e());
    }

    float e() {
        if (this.f850b) {
            return 0.0f;
        }
        C0244a c0244aB = b();
        if (c0244aB.h()) {
            return 0.0f;
        }
        return (this.f852d - c0244aB.e()) / (c0244aB.b() - c0244aB.e());
    }

    public float f() {
        return this.f852d;
    }

    public Object h() {
        C0244a c0244aB = b();
        float fD = d();
        if (this.e == null && c0244aB == this.f854g && this.f855h == fD) {
            return this.f856i;
        }
        this.f854g = c0244aB;
        this.f855h = fD;
        Object objI = i(c0244aB, fD);
        this.f856i = objI;
        return objI;
    }

    abstract Object i(C0244a c0244a, float f2);

    public void j() {
        for (int i2 = 0; i2 < this.f849a.size(); i2++) {
            ((InterfaceC0012a) this.f849a.get(i2)).b();
        }
    }

    public void k() {
        this.f850b = true;
    }

    public void l(float f2) {
        if (this.f851c.isEmpty()) {
            return;
        }
        C0244a c0244aB = b();
        if (f2 < g()) {
            f2 = g();
        } else if (f2 > c()) {
            f2 = c();
        }
        if (f2 == this.f852d) {
            return;
        }
        this.f852d = f2;
        C0244a c0244aB2 = b();
        if (c0244aB == c0244aB2 && c0244aB2.h()) {
            return;
        }
        j();
    }

    public void m(C0246c c0246c) {
        C0246c c0246c2 = this.e;
        if (c0246c2 != null) {
            c0246c2.c(null);
        }
        this.e = c0246c;
        if (c0246c != null) {
            c0246c.c(this);
        }
    }
}
