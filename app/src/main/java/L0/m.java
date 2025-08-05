package L0;

import java.util.EnumMap;
import java.util.Map;
import z0.EnumC0379a;

/* loaded from: classes.dex */
final class m {

    /* renamed from: a, reason: collision with root package name */
    private final int[] f306a = new int[4];

    /* renamed from: b, reason: collision with root package name */
    private final StringBuilder f307b = new StringBuilder();

    m() {
    }

    private int a(D0.a aVar, int[] iArr, StringBuilder sb) throws z0.i {
        int[] iArr2 = this.f306a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iG = aVar.g();
        int iF = iArr[1];
        int i2 = 0;
        for (int i3 = 0; i3 < 2 && iF < iG; i3++) {
            int iJ = p.j(aVar, iArr2, iF, p.f317h);
            sb.append((char) ((iJ % 10) + 48));
            for (int i4 : iArr2) {
                iF += i4;
            }
            if (iJ >= 10) {
                i2 |= 1 << (1 - i3);
            }
            if (i3 != 1) {
                iF = aVar.f(aVar.e(iF));
            }
        }
        if (sb.length() != 2) {
            throw z0.i.a();
        }
        if (Integer.parseInt(sb.toString()) % 4 == i2) {
            return iF;
        }
        throw z0.i.a();
    }

    private static Map c(String str) {
        if (str.length() != 2) {
            return null;
        }
        EnumMap enumMap = new EnumMap(z0.n.class);
        enumMap.put((EnumMap) z0.n.ISSUE_NUMBER, (z0.n) Integer.valueOf(str));
        return enumMap;
    }

    z0.m b(int i2, D0.a aVar, int[] iArr) throws z0.i {
        StringBuilder sb = this.f307b;
        sb.setLength(0);
        int iA = a(aVar, iArr, sb);
        String string = sb.toString();
        Map mapC = c(string);
        float f2 = i2;
        z0.m mVar = new z0.m(string, null, new z0.o[]{new z0.o((iArr[0] + iArr[1]) / 2.0f, f2), new z0.o(iA, f2)}, EnumC0379a.UPC_EAN_EXTENSION);
        if (mapC != null) {
            mVar.g(mapC);
        }
        return mVar;
    }
}
