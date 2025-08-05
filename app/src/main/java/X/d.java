package X;

import android.graphics.Path;

/* loaded from: classes.dex */
public class d implements b {

    /* renamed from: a */
    private final f f1127a;

    /* renamed from: b */
    private final Path.FillType f1128b;

    /* renamed from: c */
    private final W.c f1129c;

    /* renamed from: d */
    private final W.d f1130d;
    private final W.f e;

    /* renamed from: f */
    private final W.f f1131f;

    /* renamed from: g */
    private final String f1132g;

    /* renamed from: h */
    private final W.b f1133h;

    /* renamed from: i */
    private final W.b f1134i;

    /* renamed from: j */
    private final boolean f1135j;

    public d(String str, f fVar, Path.FillType fillType, W.c cVar, W.d dVar, W.f fVar2, W.f fVar3, W.b bVar, W.b bVar2, boolean z2) {
        this.f1127a = fVar;
        this.f1128b = fillType;
        this.f1129c = cVar;
        this.f1130d = dVar;
        this.e = fVar2;
        this.f1131f = fVar3;
        this.f1132g = str;
        this.f1133h = bVar;
        this.f1134i = bVar2;
        this.f1135j = z2;
    }

    @Override // X.b
    public S.c a(com.airbnb.lottie.a aVar, Y.a aVar2) {
        return new S.h(aVar, aVar2, this);
    }

    public W.f b() {
        return this.f1131f;
    }

    public Path.FillType c() {
        return this.f1128b;
    }

    public W.c d() {
        return this.f1129c;
    }

    public f e() {
        return this.f1127a;
    }

    public String f() {
        return this.f1132g;
    }

    public W.d g() {
        return this.f1130d;
    }

    public W.f h() {
        return this.e;
    }

    public boolean i() {
        return this.f1135j;
    }
}
