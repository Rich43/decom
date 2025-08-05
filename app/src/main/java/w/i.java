package W;

import java.util.List;

/* loaded from: classes.dex */
public class i implements m {

    /* renamed from: a, reason: collision with root package name */
    private final b f1006a;

    /* renamed from: b, reason: collision with root package name */
    private final b f1007b;

    public i(b bVar, b bVar2) {
        this.f1006a = bVar;
        this.f1007b = bVar2;
    }

    @Override // W.m
    public T.a a() {
        return new T.m(this.f1006a.a(), this.f1007b.a());
    }

    @Override // W.m
    public List b() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // W.m
    public boolean c() {
        return this.f1006a.c() && this.f1007b.c();
    }
}
