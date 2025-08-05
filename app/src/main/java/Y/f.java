package Y;

import X.n;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class f extends a {

    /* renamed from: w, reason: collision with root package name */
    private final S.d f1325w;

    f(com.airbnb.lottie.a aVar, d dVar) {
        super(aVar, dVar);
        S.d dVar2 = new S.d(aVar, this, new n("__container", dVar.l(), false));
        this.f1325w = dVar2;
        dVar2.d(Collections.emptyList(), Collections.emptyList());
    }

    @Override // Y.a
    protected void D(V.e eVar, int i2, List list, V.e eVar2) {
        this.f1325w.f(eVar, i2, list, eVar2);
    }

    @Override // Y.a, S.e
    public void a(RectF rectF, Matrix matrix, boolean z2) {
        super.a(rectF, matrix, z2);
        this.f1325w.a(rectF, this.f1276m, z2);
    }

    @Override // Y.a
    void t(Canvas canvas, Matrix matrix, int i2) {
        this.f1325w.g(canvas, matrix, i2);
    }
}
