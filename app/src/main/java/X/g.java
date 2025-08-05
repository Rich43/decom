package X;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final a f1151a;

    /* renamed from: b, reason: collision with root package name */
    private final W.h f1152b;

    /* renamed from: c, reason: collision with root package name */
    private final W.d f1153c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f1154d;

    public enum a {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT
    }

    public g(a aVar, W.h hVar, W.d dVar, boolean z2) {
        this.f1151a = aVar;
        this.f1152b = hVar;
        this.f1153c = dVar;
        this.f1154d = z2;
    }

    public a a() {
        return this.f1151a;
    }

    public W.h b() {
        return this.f1152b;
    }

    public W.d c() {
        return this.f1153c;
    }

    public boolean d() {
        return this.f1154d;
    }
}
