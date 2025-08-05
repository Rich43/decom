package W;

import d0.C0244a;
import java.util.List;

/* loaded from: classes.dex */
public class e implements m {

    /* renamed from: a, reason: collision with root package name */
    private final List f1005a;

    public e(List list) {
        this.f1005a = list;
    }

    @Override // W.m
    public T.a a() {
        return ((C0244a) this.f1005a.get(0)).h() ? new T.j(this.f1005a) : new T.i(this.f1005a);
    }

    @Override // W.m
    public List b() {
        return this.f1005a;
    }

    @Override // W.m
    public boolean c() {
        return this.f1005a.size() == 1 && ((C0244a) this.f1005a.get(0)).h();
    }
}
