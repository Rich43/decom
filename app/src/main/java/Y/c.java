package Y;

import Q.i;
import T.p;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import c0.j;
import d0.C0246c;

/* loaded from: classes.dex */
public class c extends a {

    /* renamed from: w, reason: collision with root package name */
    private final Paint f1292w;

    /* renamed from: x, reason: collision with root package name */
    private final Rect f1293x;

    /* renamed from: y, reason: collision with root package name */
    private final Rect f1294y;

    /* renamed from: z, reason: collision with root package name */
    private T.a f1295z;

    c(com.airbnb.lottie.a aVar, d dVar) {
        super(aVar, dVar);
        this.f1292w = new R.a(3);
        this.f1293x = new Rect();
        this.f1294y = new Rect();
    }

    private Bitmap K() {
        return this.f1277n.o(this.o.k());
    }

    @Override // Y.a, S.e
    public void a(RectF rectF, Matrix matrix, boolean z2) {
        super.a(rectF, matrix, z2);
        if (K() != null) {
            rectF.set(0.0f, 0.0f, r3.getWidth() * j.e(), r3.getHeight() * j.e());
            this.f1276m.mapRect(rectF);
        }
    }

    @Override // Y.a, V.f
    public void c(Object obj, C0246c c0246c) {
        super.c(obj, c0246c);
        if (obj == i.f588B) {
            if (c0246c == null) {
                this.f1295z = null;
            } else {
                this.f1295z = new p(c0246c);
            }
        }
    }

    @Override // Y.a
    public void t(Canvas canvas, Matrix matrix, int i2) {
        Bitmap bitmapK = K();
        if (bitmapK == null || bitmapK.isRecycled()) {
            return;
        }
        float fE = j.e();
        this.f1292w.setAlpha(i2);
        T.a aVar = this.f1295z;
        if (aVar != null) {
            this.f1292w.setColorFilter((ColorFilter) aVar.h());
        }
        canvas.save();
        canvas.concat(matrix);
        this.f1293x.set(0, 0, bitmapK.getWidth(), bitmapK.getHeight());
        this.f1294y.set(0, 0, (int) (bitmapK.getWidth() * fE), (int) (bitmapK.getHeight() * fE));
        canvas.drawBitmap(bitmapK, this.f1293x, this.f1294y, this.f1292w);
        canvas.restore();
    }
}
