package X;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class n implements b {

    /* renamed from: a */
    private final String f1196a;

    /* renamed from: b */
    private final List f1197b;

    /* renamed from: c */
    private final boolean f1198c;

    public n(String str, List list, boolean z2) {
        this.f1196a = str;
        this.f1197b = list;
        this.f1198c = z2;
    }

    @Override // X.b
    public S.c a(com.airbnb.lottie.a aVar, Y.a aVar2) {
        return new S.d(aVar, aVar2, this);
    }

    public List b() {
        return this.f1197b;
    }

    public String c() {
        return this.f1196a;
    }

    public boolean d() {
        return this.f1198c;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f1196a + "' Shapes: " + Arrays.toString(this.f1197b.toArray()) + '}';
    }
}
