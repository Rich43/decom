package U0;

import z0.o;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f937a;

    i(boolean z2) {
        this.f937a = z2;
    }

    public void a(o[] oVarArr) {
        if (!this.f937a || oVarArr == null || oVarArr.length < 3) {
            return;
        }
        o oVar = oVarArr[0];
        oVarArr[0] = oVarArr[2];
        oVarArr[2] = oVar;
    }
}
