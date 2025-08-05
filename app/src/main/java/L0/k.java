package L0;

import java.util.Arrays;
import java.util.Map;
import z0.C0381c;
import z0.EnumC0383e;

/* loaded from: classes.dex */
public abstract class k implements z0.k {
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0048, code lost:
    
        r3 = r22.b(r11, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004c, code lost:
    
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00e0, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private z0.m d(z0.C0381c r22, java.util.Map r23) throws z0.i {
        /*
            Method dump skipped, instructions count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: L0.k.d(z0.c, java.util.Map):z0.m");
    }

    protected static float e(int[] iArr, int[] iArr2, float f2) {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            i2 += iArr[i4];
            i3 += iArr2[i4];
        }
        if (i2 < i3) {
            return Float.POSITIVE_INFINITY;
        }
        float f3 = i2;
        float f4 = f3 / i3;
        float f5 = f2 * f4;
        float f6 = 0.0f;
        for (int i5 = 0; i5 < length; i5++) {
            float f7 = iArr2[i5] * f4;
            float f8 = iArr[i5];
            float f9 = f8 > f7 ? f8 - f7 : f7 - f8;
            if (f9 > f5) {
                return Float.POSITIVE_INFINITY;
            }
            f6 += f9;
        }
        return f6 / f3;
    }

    protected static void f(D0.a aVar, int i2, int[] iArr) throws z0.i {
        int length = iArr.length;
        int i3 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int iG = aVar.g();
        if (i2 >= iG) {
            throw z0.i.a();
        }
        boolean z2 = !aVar.c(i2);
        while (i2 < iG) {
            if (aVar.c(i2) == z2) {
                i3++;
                if (i3 == length) {
                    break;
                }
                iArr[i3] = 1;
                z2 = !z2;
            } else {
                iArr[i3] = iArr[i3] + 1;
            }
            i2++;
        }
        if (i3 != length) {
            if (i3 != length - 1 || i2 != iG) {
                throw z0.i.a();
            }
        }
    }

    protected static void g(D0.a aVar, int i2, int[] iArr) throws z0.i {
        int length = iArr.length;
        boolean zC = aVar.c(i2);
        while (i2 > 0 && length >= 0) {
            i2--;
            if (aVar.c(i2) != zC) {
                length--;
                zC = !zC;
            }
        }
        if (length >= 0) {
            throw z0.i.a();
        }
        f(aVar, i2 + 1, iArr);
    }

    @Override // z0.k
    public z0.m a(C0381c c0381c, Map map) throws z0.i {
        try {
            return d(c0381c, map);
        } catch (z0.i e) {
            if (map == null || !map.containsKey(EnumC0383e.TRY_HARDER) || !c0381c.e()) {
                throw e;
            }
            C0381c c0381cF = c0381c.f();
            z0.m mVarD = d(c0381cF, map);
            Map mapD = mVarD.d();
            int iIntValue = 270;
            if (mapD != null) {
                z0.n nVar = z0.n.ORIENTATION;
                if (mapD.containsKey(nVar)) {
                    iIntValue = (((Integer) mapD.get(nVar)).intValue() + 270) % 360;
                }
            }
            mVarD.h(z0.n.ORIENTATION, Integer.valueOf(iIntValue));
            z0.o[] oVarArrE = mVarD.e();
            if (oVarArrE != null) {
                int iC = c0381cF.c();
                for (int i2 = 0; i2 < oVarArrE.length; i2++) {
                    oVarArrE[i2] = new z0.o((iC - oVarArrE[i2].d()) - 1.0f, oVarArrE[i2].c());
                }
            }
            return mVarD;
        }
    }

    public abstract z0.m c(int i2, D0.a aVar, Map map);

    @Override // z0.k
    public void b() {
    }
}
