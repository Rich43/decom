package X;

import android.graphics.Path;

/* loaded from: classes.dex */
public class m implements b {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f1191a;

    /* renamed from: b, reason: collision with root package name */
    private final Path.FillType f1192b;

    /* renamed from: c, reason: collision with root package name */
    private final String f1193c;

    /* renamed from: d, reason: collision with root package name */
    private final W.a f1194d;
    private final W.d e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f1195f;

    public m(String str, boolean z2, Path.FillType fillType, W.a aVar, W.d dVar, boolean z3) {
        this.f1193c = str;
        this.f1191a = z2;
        this.f1192b = fillType;
        this.f1194d = aVar;
        this.e = dVar;
        this.f1195f = z3;
    }

    @Override // X.b
    public S.c a(com.airbnb.lottie.a aVar, Y.a aVar2) {
        return new S.g(aVar, aVar2, this);
    }

    public W.a b() {
        return this.f1194d;
    }

    public Path.FillType c() {
        return this.f1192b;
    }

    public String d() {
        return this.f1193c;
    }

    public W.d e() {
        return this.e;
    }

    public boolean f() {
        return this.f1195f;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f1191a + '}';
    }
}
