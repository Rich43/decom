package X;

import S.s;

/* loaded from: classes.dex */
public class q implements b {

    /* renamed from: a, reason: collision with root package name */
    private final String f1222a;

    /* renamed from: b, reason: collision with root package name */
    private final a f1223b;

    /* renamed from: c, reason: collision with root package name */
    private final W.b f1224c;

    /* renamed from: d, reason: collision with root package name */
    private final W.b f1225d;
    private final W.b e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f1226f;

    public enum a {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static a a(int i2) {
            if (i2 == 1) {
                return SIMULTANEOUSLY;
            }
            if (i2 == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type " + i2);
        }
    }

    public q(String str, a aVar, W.b bVar, W.b bVar2, W.b bVar3, boolean z2) {
        this.f1222a = str;
        this.f1223b = aVar;
        this.f1224c = bVar;
        this.f1225d = bVar2;
        this.e = bVar3;
        this.f1226f = z2;
    }

    @Override // X.b
    public S.c a(com.airbnb.lottie.a aVar, Y.a aVar2) {
        return new s(aVar2, this);
    }

    public W.b b() {
        return this.f1225d;
    }

    public String c() {
        return this.f1222a;
    }

    public W.b d() {
        return this.e;
    }

    public W.b e() {
        return this.f1224c;
    }

    public a f() {
        return this.f1223b;
    }

    public boolean g() {
        return this.f1226f;
    }

    public String toString() {
        return "Trim Path: {start: " + this.f1224c + ", end: " + this.f1225d + ", offset: " + this.e + "}";
    }
}
