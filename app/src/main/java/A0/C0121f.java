package a0;

import android.graphics.Color;
import b0.c;

/* renamed from: a0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0121f implements J {

    /* renamed from: a, reason: collision with root package name */
    public static final C0121f f1402a = new C0121f();

    private C0121f() {
    }

    @Override // a0.J
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer a(b0.c cVar, float f2) {
        boolean z2 = cVar.w() == c.b.BEGIN_ARRAY;
        if (z2) {
            cVar.k();
        }
        double dR = cVar.r();
        double dR2 = cVar.r();
        double dR3 = cVar.r();
        double dR4 = cVar.r();
        if (z2) {
            cVar.m();
        }
        if (dR <= 1.0d && dR2 <= 1.0d && dR3 <= 1.0d && dR4 <= 1.0d) {
            dR *= 255.0d;
            dR2 *= 255.0d;
            dR3 *= 255.0d;
            dR4 *= 255.0d;
        }
        return Integer.valueOf(Color.argb((int) dR4, (int) dR, (int) dR2, (int) dR3));
    }
}
