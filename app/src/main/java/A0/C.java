package a0;

import b0.c;
import d0.C0247d;

/* loaded from: classes.dex */
public class C implements J {

    /* renamed from: a, reason: collision with root package name */
    public static final C f1387a = new C();

    private C() {
    }

    @Override // a0.J
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0247d a(b0.c cVar, float f2) {
        boolean z2 = cVar.w() == c.b.BEGIN_ARRAY;
        if (z2) {
            cVar.k();
        }
        float fR = (float) cVar.r();
        float fR2 = (float) cVar.r();
        while (cVar.p()) {
            cVar.A();
        }
        if (z2) {
            cVar.m();
        }
        return new C0247d((fR / 100.0f) * f2, (fR2 / 100.0f) * f2);
    }
}
