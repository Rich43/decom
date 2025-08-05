package M0;

import L0.k;
import com.bumptech.glide.request.target.Target;
import z0.i;

/* loaded from: classes.dex */
public abstract class a extends k {

    /* renamed from: b, reason: collision with root package name */
    private final int[] f326b;
    private final int[] e;

    /* renamed from: f, reason: collision with root package name */
    private final int[] f329f;

    /* renamed from: a, reason: collision with root package name */
    private final int[] f325a = new int[4];

    /* renamed from: c, reason: collision with root package name */
    private final float[] f327c = new float[4];

    /* renamed from: d, reason: collision with root package name */
    private final float[] f328d = new float[4];

    protected a() {
        int[] iArr = new int[8];
        this.f326b = iArr;
        this.e = new int[iArr.length / 2];
        this.f329f = new int[iArr.length / 2];
    }

    protected static void h(int[] iArr, float[] fArr) {
        int i2 = 0;
        float f2 = fArr[0];
        for (int i3 = 1; i3 < iArr.length; i3++) {
            float f3 = fArr[i3];
            if (f3 < f2) {
                i2 = i3;
                f2 = f3;
            }
        }
        iArr[i2] = iArr[i2] - 1;
    }

    protected static void o(int[] iArr, float[] fArr) {
        int i2 = 0;
        float f2 = fArr[0];
        for (int i3 = 1; i3 < iArr.length; i3++) {
            float f3 = fArr[i3];
            if (f3 > f2) {
                i2 = i3;
                f2 = f3;
            }
        }
        iArr[i2] = iArr[i2] + 1;
    }

    protected static boolean p(int[] iArr) {
        float f2 = (iArr[0] + iArr[1]) / ((iArr[2] + r1) + iArr[3]);
        if (f2 >= 0.7916667f && f2 <= 0.89285713f) {
            int i2 = Integer.MAX_VALUE;
            int i3 = Target.SIZE_ORIGINAL;
            for (int i4 : iArr) {
                if (i4 > i3) {
                    i3 = i4;
                }
                if (i4 < i2) {
                    i2 = i4;
                }
            }
            if (i3 < i2 * 10) {
                return true;
            }
        }
        return false;
    }

    protected static int q(int[] iArr, int[][] iArr2) throws i {
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            if (k.e(iArr, iArr2[i2], 0.45f) < 0.2f) {
                return i2;
            }
        }
        throw i.a();
    }

    protected final int[] i() {
        return this.f326b;
    }

    protected final int[] j() {
        return this.f325a;
    }

    protected final int[] k() {
        return this.f329f;
    }

    protected final float[] l() {
        return this.f328d;
    }

    protected final int[] m() {
        return this.e;
    }

    protected final float[] n() {
        return this.f327c;
    }
}
