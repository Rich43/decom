package T;

import d0.C0244a;
import java.util.List;

/* loaded from: classes.dex */
public class d extends f {

    /* renamed from: l, reason: collision with root package name */
    private final X.c f859l;

    public d(List list) {
        super(list);
        X.c cVar = (X.c) ((C0244a) list.get(0)).f5783b;
        int iC = cVar != null ? cVar.c() : 0;
        this.f859l = new X.c(new float[iC], new int[iC]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // T.a
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public X.c i(C0244a c0244a, float f2) {
        this.f859l.d((X.c) c0244a.f5783b, (X.c) c0244a.f5784c, f2);
        return this.f859l;
    }
}
