package L0;

import java.util.EnumMap;
import java.util.Map;
import z0.EnumC0379a;

/* loaded from: classes.dex */
final class n {

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f308c = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};

    /* renamed from: a, reason: collision with root package name */
    private final int[] f309a = new int[4];

    /* renamed from: b, reason: collision with root package name */
    private final StringBuilder f310b = new StringBuilder();

    n() {
    }

    private int a(D0.a aVar, int[] iArr, StringBuilder sb) throws z0.i {
        int[] iArr2 = this.f309a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iG = aVar.g();
        int iF = iArr[1];
        int i2 = 0;
        for (int i3 = 0; i3 < 5 && iF < iG; i3++) {
            int iJ = p.j(aVar, iArr2, iF, p.f317h);
            sb.append((char) ((iJ % 10) + 48));
            for (int i4 : iArr2) {
                iF += i4;
            }
            if (iJ >= 10) {
                i2 |= 1 << (4 - i3);
            }
            if (i3 != 4) {
                iF = aVar.f(aVar.e(iF));
            }
        }
        if (sb.length() != 5) {
            throw z0.i.a();
        }
        if (d(sb.toString()) == c(i2)) {
            return iF;
        }
        throw z0.i.a();
    }

    private static int c(int i2) throws z0.i {
        for (int i3 = 0; i3 < 10; i3++) {
            if (i2 == f308c[i3]) {
                return i3;
            }
        }
        throw z0.i.a();
    }

    private static int d(CharSequence charSequence) {
        int length = charSequence.length();
        int iCharAt = 0;
        for (int i2 = length - 2; i2 >= 0; i2 -= 2) {
            iCharAt += charSequence.charAt(i2) - '0';
        }
        int iCharAt2 = iCharAt * 3;
        for (int i3 = length - 1; i3 >= 0; i3 -= 2) {
            iCharAt2 += charSequence.charAt(i3) - '0';
        }
        return (iCharAt2 * 3) % 10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String e(java.lang.String r5) throws java.lang.NumberFormatException {
        /*
            r0 = 1
            r1 = 0
            char r2 = r5.charAt(r1)
            r3 = 48
            if (r2 == r3) goto L4d
            r3 = 53
            if (r2 == r3) goto L4a
            r3 = 57
            java.lang.String r4 = ""
            if (r2 == r3) goto L15
            goto L4f
        L15:
            r2 = -1
            int r3 = r5.hashCode()
            switch(r3) {
                case 54118329: goto L35;
                case 54395376: goto L2a;
                case 54395377: goto L1f;
                default: goto L1d;
            }
        L1d:
            r1 = -1
            goto L3e
        L1f:
            java.lang.String r1 = "99991"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L28
            goto L1d
        L28:
            r1 = 2
            goto L3e
        L2a:
            java.lang.String r1 = "99990"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L33
            goto L1d
        L33:
            r1 = 1
            goto L3e
        L35:
            java.lang.String r3 = "90000"
            boolean r3 = r5.equals(r3)
            if (r3 != 0) goto L3e
            goto L1d
        L3e:
            switch(r1) {
                case 0: goto L48;
                case 1: goto L45;
                case 2: goto L42;
                default: goto L41;
            }
        L41:
            goto L4f
        L42:
            java.lang.String r5 = "0.00"
            return r5
        L45:
            java.lang.String r5 = "Used"
            return r5
        L48:
            r5 = 0
            return r5
        L4a:
            java.lang.String r4 = "$"
            goto L4f
        L4d:
            java.lang.String r4 = "£"
        L4f:
            java.lang.String r5 = r5.substring(r0)
            int r5 = java.lang.Integer.parseInt(r5)
            int r0 = r5 / 100
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r5 = r5 % 100
            r1 = 10
            if (r5 >= r1) goto L6e
            java.lang.String r1 = "0"
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r5 = r1.concat(r5)
            goto L72
        L6e:
            java.lang.String r5 = java.lang.String.valueOf(r5)
        L72:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            r1.append(r0)
            r0 = 46
            r1.append(r0)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: L0.n.e(java.lang.String):java.lang.String");
    }

    private static Map f(String str) {
        String strE;
        if (str.length() != 5 || (strE = e(str)) == null) {
            return null;
        }
        EnumMap enumMap = new EnumMap(z0.n.class);
        enumMap.put((EnumMap) z0.n.SUGGESTED_PRICE, (z0.n) strE);
        return enumMap;
    }

    z0.m b(int i2, D0.a aVar, int[] iArr) throws z0.i {
        StringBuilder sb = this.f310b;
        sb.setLength(0);
        int iA = a(aVar, iArr, sb);
        String string = sb.toString();
        Map mapF = f(string);
        float f2 = i2;
        z0.m mVar = new z0.m(string, null, new z0.o[]{new z0.o((iArr[0] + iArr[1]) / 2.0f, f2), new z0.o(iA, f2)}, EnumC0379a.UPC_EAN_EXTENSION);
        if (mapF != null) {
            mVar.g(mapF);
        }
        return mVar;
    }
}
