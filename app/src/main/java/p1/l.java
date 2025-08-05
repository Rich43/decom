package p1;

/* loaded from: classes.dex */
public abstract class l extends k {
    public static final boolean a(String str, int i2, String str2, int i3, int i4, boolean z2) {
        i1.k.e(str, "<this>");
        i1.k.e(str2, "other");
        return !z2 ? str.regionMatches(i2, str2, i3, i4) : str.regionMatches(z2, i2, str2, i3, i4);
    }

    public static final String b(String str, String str2, String str3, boolean z2) {
        i1.k.e(str, "<this>");
        i1.k.e(str2, "oldValue");
        i1.k.e(str3, "newValue");
        int i2 = 0;
        int iE = m.e(str, str2, 0, z2);
        if (iE < 0) {
            return str;
        }
        int length = str2.length();
        int iA = m1.d.a(length, 1);
        int length2 = (str.length() - length) + str3.length();
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        do {
            sb.append((CharSequence) str, i2, iE);
            sb.append(str3);
            i2 = iE + length;
            if (iE >= str.length()) {
                break;
            }
            iE = m.e(str, str2, iE + iA, z2);
        } while (iE > 0);
        sb.append((CharSequence) str, i2, str.length());
        String string = sb.toString();
        i1.k.d(string, "toString(...)");
        return string;
    }

    public static /* synthetic */ String c(String str, String str2, String str3, boolean z2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        return b(str, str2, str3, z2);
    }
}
