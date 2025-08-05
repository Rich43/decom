package a0;

import android.graphics.Color;
import b0.c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class l implements J {

    /* renamed from: a, reason: collision with root package name */
    private int f1410a;

    public l(int i2) {
        this.f1410a = i2;
    }

    private void b(X.c cVar, List list) {
        int i2 = this.f1410a * 4;
        if (list.size() <= i2) {
            return;
        }
        int size = (list.size() - i2) / 2;
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        int i3 = 0;
        while (i2 < list.size()) {
            if (i2 % 2 == 0) {
                dArr[i3] = ((Float) list.get(i2)).floatValue();
            } else {
                dArr2[i3] = ((Float) list.get(i2)).floatValue();
                i3++;
            }
            i2++;
        }
        for (int i4 = 0; i4 < cVar.c(); i4++) {
            int i5 = cVar.a()[i4];
            cVar.a()[i4] = Color.argb(c(cVar.b()[i4], dArr, dArr2), Color.red(i5), Color.green(i5), Color.blue(i5));
        }
    }

    private int c(double d2, double[] dArr, double[] dArr2) {
        double dI;
        int i2 = 1;
        while (true) {
            if (i2 >= dArr.length) {
                dI = dArr2[dArr2.length - 1];
                break;
            }
            int i3 = i2 - 1;
            double d3 = dArr[i3];
            double d4 = dArr[i2];
            if (d4 >= d2) {
                dI = c0.i.i(dArr2[i3], dArr2[i2], (d2 - d3) / (d4 - d3));
                break;
            }
            i2++;
        }
        return (int) (dI * 255.0d);
    }

    @Override // a0.J
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public X.c a(b0.c cVar, float f2) {
        ArrayList arrayList = new ArrayList();
        boolean z2 = cVar.w() == c.b.BEGIN_ARRAY;
        if (z2) {
            cVar.k();
        }
        while (cVar.p()) {
            arrayList.add(Float.valueOf((float) cVar.r()));
        }
        if (z2) {
            cVar.m();
        }
        if (this.f1410a == -1) {
            this.f1410a = arrayList.size() / 4;
        }
        int i2 = this.f1410a;
        float[] fArr = new float[i2];
        int[] iArr = new int[i2];
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < this.f1410a * 4; i5++) {
            int i6 = i5 / 4;
            double dFloatValue = ((Float) arrayList.get(i5)).floatValue();
            int i7 = i5 % 4;
            if (i7 == 0) {
                fArr[i6] = (float) dFloatValue;
            } else if (i7 == 1) {
                i3 = (int) (dFloatValue * 255.0d);
            } else if (i7 == 2) {
                i4 = (int) (dFloatValue * 255.0d);
            } else if (i7 == 3) {
                iArr[i6] = Color.argb(255, i3, i4, (int) (dFloatValue * 255.0d));
            }
        }
        X.c cVar2 = new X.c(fArr, iArr);
        b(cVar2, arrayList);
        return cVar2;
    }
}
