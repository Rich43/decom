package Y;

import Q.i;
import T.p;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import d0.C0246c;

/* loaded from: classes.dex */
public class g extends a {

    /* renamed from: A, reason: collision with root package name */
    private final d f1326A;

    /* renamed from: B, reason: collision with root package name */
    private T.a f1327B;

    /* renamed from: w, reason: collision with root package name */
    private final RectF f1328w;

    /* renamed from: x, reason: collision with root package name */
    private final Paint f1329x;

    /* renamed from: y, reason: collision with root package name */
    private final float[] f1330y;

    /* renamed from: z, reason: collision with root package name */
    private final Path f1331z;

    g(com.airbnb.lottie.a aVar, d dVar) {
        super(aVar, dVar);
        this.f1328w = new RectF();
        R.a aVar2 = new R.a();
        this.f1329x = aVar2;
        this.f1330y = new float[8];
        this.f1331z = new Path();
        this.f1326A = dVar;
        aVar2.setAlpha(0);
        aVar2.setStyle(Paint.Style.FILL);
        aVar2.setColor(dVar.m());
    }

    @Override // Y.a, S.e
    public void a(RectF rectF, Matrix matrix, boolean z2) {
        super.a(rectF, matrix, z2);
        this.f1328w.set(0.0f, 0.0f, this.f1326A.o(), this.f1326A.n());
        this.f1276m.mapRect(this.f1328w);
        rectF.set(this.f1328w);
    }

    @Override // Y.a, V.f
    public void c(Object obj, C0246c c0246c) {
        super.c(obj, c0246c);
        if (obj == i.f588B) {
            if (c0246c == null) {
                this.f1327B = null;
            } else {
                this.f1327B = new p(c0246c);
            }
        }
    }

    @Override // Y.a
    public void t(Canvas canvas, Matrix matrix, int i2) {
        int iAlpha = Color.alpha(this.f1326A.m());
        if (iAlpha == 0) {
            return;
        }
        int iIntValue = (int) ((i2 / 255.0f) * (((iAlpha / 255.0f) * (this.f1281u.h() == null ? 100 : ((Integer) this.f1281u.h().h()).intValue())) / 100.0f) * 255.0f);
        this.f1329x.setAlpha(iIntValue);
        T.a aVar = this.f1327B;
        if (aVar != null) {
            this.f1329x.setColorFilter((ColorFilter) aVar.h());
        }
        if (iIntValue > 0) {
            float[] fArr = this.f1330y;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.f1326A.o();
            float[] fArr2 = this.f1330y;
            fArr2[3] = 0.0f;
            fArr2[4] = this.f1326A.o();
            this.f1330y[5] = this.f1326A.n();
            float[] fArr3 = this.f1330y;
            fArr3[6] = 0.0f;
            fArr3[7] = this.f1326A.n();
            matrix.mapPoints(this.f1330y);
            this.f1331z.reset();
            Path path = this.f1331z;
            float[] fArr4 = this.f1330y;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.f1331z;
            float[] fArr5 = this.f1330y;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.f1331z;
            float[] fArr6 = this.f1330y;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.f1331z;
            float[] fArr7 = this.f1330y;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.f1331z;
            float[] fArr8 = this.f1330y;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.f1331z.close();
            canvas.drawPath(this.f1331z, this.f1329x);
        }
    }
}
