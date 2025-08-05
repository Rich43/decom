package T;

import android.graphics.Path;
import d0.C0244a;
import java.util.List;

/* loaded from: classes.dex */
public class l extends a {

    /* renamed from: l, reason: collision with root package name */
    private final X.l f869l;

    /* renamed from: m, reason: collision with root package name */
    private final Path f870m;

    public l(List list) {
        super(list);
        this.f869l = new X.l();
        this.f870m = new Path();
    }

    @Override // T.a
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public Path i(C0244a c0244a, float f2) {
        this.f869l.c((X.l) c0244a.f5783b, (X.l) c0244a.f5784c, f2);
        c0.i.h(this.f869l, this.f870m);
        return this.f870m;
    }
}
