package T;

import T.a;
import android.graphics.PointF;
import d0.C0244a;
import java.util.Collections;

/* loaded from: classes.dex */
public class m extends a {

    /* renamed from: l, reason: collision with root package name */
    private final PointF f871l;

    /* renamed from: m, reason: collision with root package name */
    private final a f872m;

    /* renamed from: n, reason: collision with root package name */
    private final a f873n;

    public m(a aVar, a aVar2) {
        super(Collections.emptyList());
        this.f871l = new PointF();
        this.f872m = aVar;
        this.f873n = aVar2;
        l(f());
    }

    @Override // T.a
    public void l(float f2) {
        this.f872m.l(f2);
        this.f873n.l(f2);
        this.f871l.set(((Float) this.f872m.h()).floatValue(), ((Float) this.f873n.h()).floatValue());
        for (int i2 = 0; i2 < this.f849a.size(); i2++) {
            ((a.InterfaceC0012a) this.f849a.get(i2)).b();
        }
    }

    @Override // T.a
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public PointF h() {
        return i(null, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // T.a
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public PointF i(C0244a c0244a, float f2) {
        return this.f871l;
    }
}
