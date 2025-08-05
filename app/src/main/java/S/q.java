package S;

import T.a;
import X.q;
import android.graphics.Path;
import java.util.List;

/* loaded from: classes.dex */
public class q implements m, a.InterfaceC0012a {

    /* renamed from: b, reason: collision with root package name */
    private final String f830b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f831c;

    /* renamed from: d, reason: collision with root package name */
    private final com.airbnb.lottie.a f832d;
    private final T.a e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f833f;

    /* renamed from: a, reason: collision with root package name */
    private final Path f829a = new Path();

    /* renamed from: g, reason: collision with root package name */
    private b f834g = new b();

    public q(com.airbnb.lottie.a aVar, Y.a aVar2, X.o oVar) {
        this.f830b = oVar.b();
        this.f831c = oVar.d();
        this.f832d = aVar;
        T.a aVarA = oVar.c().a();
        this.e = aVarA;
        aVar2.j(aVarA);
        aVarA.a(this);
    }

    private void c() {
        this.f833f = false;
        this.f832d.invalidateSelf();
    }

    @Override // T.a.InterfaceC0012a
    public void b() {
        c();
    }

    @Override // S.c
    public void d(List list, List list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVar = (c) list.get(i2);
            if (cVar instanceof s) {
                s sVar = (s) cVar;
                if (sVar.k() == q.a.SIMULTANEOUSLY) {
                    this.f834g.a(sVar);
                    sVar.c(this);
                }
            }
        }
    }

    @Override // S.m
    public Path h() {
        if (this.f833f) {
            return this.f829a;
        }
        this.f829a.reset();
        if (this.f831c) {
            this.f833f = true;
            return this.f829a;
        }
        this.f829a.set((Path) this.e.h());
        this.f829a.setFillType(Path.FillType.EVEN_ODD);
        this.f834g.b(this.f829a);
        this.f833f = true;
        return this.f829a;
    }
}
