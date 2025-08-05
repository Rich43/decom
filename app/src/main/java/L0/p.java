package L0;

import java.util.Arrays;
import java.util.Map;
import z0.C0382d;
import z0.C0384f;
import z0.EnumC0379a;
import z0.EnumC0383e;

/* loaded from: classes.dex */
public abstract class p extends k {

    /* renamed from: d, reason: collision with root package name */
    static final int[] f314d = {1, 1, 1};
    static final int[] e = {1, 1, 1, 1, 1};

    /* renamed from: f, reason: collision with root package name */
    static final int[] f315f = {1, 1, 1, 1, 1, 1};

    /* renamed from: g, reason: collision with root package name */
    static final int[][] f316g;

    /* renamed from: h, reason: collision with root package name */
    static final int[][] f317h;

    /* renamed from: a, reason: collision with root package name */
    private final StringBuilder f318a = new StringBuilder(20);

    /* renamed from: b, reason: collision with root package name */
    private final o f319b = new o();

    /* renamed from: c, reason: collision with root package name */
    private final g f320c = new g();

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        f316g = iArr;
        int[][] iArr2 = new int[20][];
        f317h = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i2 = 10; i2 < 20; i2++) {
            int[] iArr3 = f316g[i2 - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i3 = 0; i3 < iArr3.length; i3++) {
                iArr4[i3] = iArr3[(iArr3.length - i3) - 1];
            }
            f317h[i2] = iArr4;
        }
    }

    protected p() {
    }

    static boolean i(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i2 = length - 1;
        return r(charSequence.subSequence(0, i2)) == Character.digit(charSequence.charAt(i2), 10);
    }

    static int j(D0.a aVar, int[] iArr, int i2, int[][] iArr2) throws z0.i {
        k.f(aVar, i2, iArr);
        int length = iArr2.length;
        float f2 = 0.48f;
        int i3 = -1;
        for (int i4 = 0; i4 < length; i4++) {
            float fE = k.e(iArr, iArr2[i4], 0.7f);
            if (fE < f2) {
                i3 = i4;
                f2 = fE;
            }
        }
        if (i3 >= 0) {
            return i3;
        }
        throw z0.i.a();
    }

    static int[] n(D0.a aVar, int i2, boolean z2, int[] iArr) {
        return o(aVar, i2, z2, iArr, new int[iArr.length]);
    }

    private static int[] o(D0.a aVar, int i2, boolean z2, int[] iArr, int[] iArr2) throws z0.i {
        int iG = aVar.g();
        int iF = z2 ? aVar.f(i2) : aVar.e(i2);
        int length = iArr.length;
        boolean z3 = z2;
        int i3 = 0;
        int i4 = iF;
        while (iF < iG) {
            if (aVar.c(iF) != z3) {
                iArr2[i3] = iArr2[i3] + 1;
            } else {
                if (i3 != length - 1) {
                    i3++;
                } else {
                    if (k.e(iArr2, iArr, 0.7f) < 0.48f) {
                        return new int[]{i4, iF};
                    }
                    i4 += iArr2[0] + iArr2[1];
                    int i5 = i3 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i5);
                    iArr2[i5] = 0;
                    iArr2[i3] = 0;
                    i3--;
                }
                iArr2[i3] = 1;
                z3 = !z3;
            }
            iF++;
        }
        throw z0.i.a();
    }

    static int[] p(D0.a aVar) throws z0.i {
        int[] iArr = new int[f314d.length];
        int[] iArrO = null;
        boolean zH = false;
        int i2 = 0;
        while (!zH) {
            int[] iArr2 = f314d;
            Arrays.fill(iArr, 0, iArr2.length, 0);
            iArrO = o(aVar, i2, false, iArr2, iArr);
            int i3 = iArrO[0];
            int i4 = iArrO[1];
            int i5 = i3 - (i4 - i3);
            if (i5 >= 0) {
                zH = aVar.h(i5, i3, false);
            }
            i2 = i4;
        }
        return iArrO;
    }

    static int r(CharSequence charSequence) throws C0384f {
        int length = charSequence.length();
        int i2 = 0;
        for (int i3 = length - 1; i3 >= 0; i3 -= 2) {
            int iCharAt = charSequence.charAt(i3) - '0';
            if (iCharAt < 0 || iCharAt > 9) {
                throw C0384f.a();
            }
            i2 += iCharAt;
        }
        int i4 = i2 * 3;
        for (int i5 = length - 2; i5 >= 0; i5 -= 2) {
            int iCharAt2 = charSequence.charAt(i5) - '0';
            if (iCharAt2 < 0 || iCharAt2 > 9) {
                throw C0384f.a();
            }
            i4 += iCharAt2;
        }
        return (1000 - i4) % 10;
    }

    @Override // L0.k
    public z0.m c(int i2, D0.a aVar, Map map) {
        return m(i2, aVar, p(aVar), map);
    }

    boolean h(String str) {
        return i(str);
    }

    int[] k(D0.a aVar, int i2) {
        return n(aVar, i2, false, f314d);
    }

    protected abstract int l(D0.a aVar, int[] iArr, StringBuilder sb);

    public z0.m m(int i2, D0.a aVar, int[] iArr, Map map) throws C0382d, C0384f, z0.i {
        int length;
        String strC;
        z0.p pVar = map == null ? null : (z0.p) map.get(EnumC0383e.NEED_RESULT_POINT_CALLBACK);
        if (pVar != null) {
            pVar.a(new z0.o((iArr[0] + iArr[1]) / 2.0f, i2));
        }
        StringBuilder sb = this.f318a;
        sb.setLength(0);
        int iL = l(aVar, iArr, sb);
        if (pVar != null) {
            pVar.a(new z0.o(iL, i2));
        }
        int[] iArrK = k(aVar, iL);
        if (pVar != null) {
            pVar.a(new z0.o((iArrK[0] + iArrK[1]) / 2.0f, i2));
        }
        int i3 = iArrK[1];
        int i4 = (i3 - iArrK[0]) + i3;
        if (i4 >= aVar.g() || !aVar.h(i3, i4, false)) {
            throw z0.i.a();
        }
        String string = sb.toString();
        if (string.length() < 8) {
            throw C0384f.a();
        }
        if (!h(string)) {
            throw C0382d.a();
        }
        EnumC0379a enumC0379aQ = q();
        float f2 = i2;
        z0.m mVar = new z0.m(string, null, new z0.o[]{new z0.o((iArr[1] + iArr[0]) / 2.0f, f2), new z0.o((iArrK[1] + iArrK[0]) / 2.0f, f2)}, enumC0379aQ);
        try {
            z0.m mVarA = this.f319b.a(i2, aVar, iArrK[1]);
            mVar.h(z0.n.UPC_EAN_EXTENSION, mVarA.f());
            mVar.g(mVarA.d());
            mVar.a(mVarA.e());
            length = mVarA.f().length();
        } catch (z0.l unused) {
            length = 0;
        }
        int[] iArr2 = map != null ? (int[]) map.get(EnumC0383e.ALLOWED_EAN_EXTENSIONS) : null;
        if (iArr2 != null) {
            for (int i5 : iArr2) {
                if (length != i5) {
                }
            }
            throw z0.i.a();
        }
        if ((enumC0379aQ == EnumC0379a.EAN_13 || enumC0379aQ == EnumC0379a.UPC_A) && (strC = this.f320c.c(string)) != null) {
            mVar.h(z0.n.POSSIBLE_COUNTRY, strC);
        }
        return mVar;
    }

    abstract EnumC0379a q();
}
