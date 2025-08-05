package S;

import T.a;
import X.q;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class s implements c, a.InterfaceC0012a {

    /* renamed from: a */
    private final String f837a;

    /* renamed from: b */
    private final boolean f838b;

    /* renamed from: c */
    private final List f839c = new ArrayList();

    /* renamed from: d */
    private final q.a f840d;
    private final T.a e;

    /* renamed from: f */
    private final T.a f841f;

    /* renamed from: g */
    private final T.a f842g;

    public s(Y.a aVar, X.q qVar) {
        this.f837a = qVar.c();
        this.f838b = qVar.g();
        this.f840d = qVar.f();
        T.a aVarA = qVar.e().a();
        this.e = aVarA;
        T.a aVarA2 = qVar.b().a();
        this.f841f = aVarA2;
        T.a aVarA3 = qVar.d().a();
        this.f842g = aVarA3;
        aVar.j(aVarA);
        aVar.j(aVarA2);
        aVar.j(aVarA3);
        aVarA.a(this);
        aVarA2.a(this);
        aVarA3.a(this);
    }

    @Override // T.a.InterfaceC0012a
    public void b() {
        for (int i2 = 0; i2 < this.f839c.size(); i2++) {
            ((a.InterfaceC0012a) this.f839c.get(i2)).b();
        }
    }

    void c(a.InterfaceC0012a interfaceC0012a) {
        this.f839c.add(interfaceC0012a);
    }

    public T.a e() {
        return this.f841f;
    }

    public T.a f() {
        return this.f842g;
    }

    public T.a j() {
        return this.e;
    }

    q.a k() {
        return this.f840d;
    }

    public boolean l() {
        return this.f838b;
    }

    @Override // S.c
    public void d(List list, List list2) {
    }
}
