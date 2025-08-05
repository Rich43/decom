package V0;

import z0.o;

/* loaded from: classes.dex */
public final class a extends o {

    /* renamed from: c, reason: collision with root package name */
    private final float f983c;

    a(float f2, float f3, float f4) {
        super(f2, f3);
        this.f983c = f4;
    }

    boolean f(float f2, float f3, float f4) {
        if (Math.abs(f3 - d()) > f2 || Math.abs(f4 - c()) > f2) {
            return false;
        }
        float fAbs = Math.abs(f2 - this.f983c);
        return fAbs <= 1.0f || fAbs <= this.f983c;
    }

    a g(float f2, float f3, float f4) {
        return new a((c() + f3) / 2.0f, (d() + f2) / 2.0f, (this.f983c + f4) / 2.0f);
    }
}
