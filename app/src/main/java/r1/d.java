package r1;

import java.io.Serializable;
import java.util.Arrays;

/* loaded from: classes.dex */
public class d implements Serializable, Comparable {

    /* renamed from: d, reason: collision with root package name */
    static final char[] f7367d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final d e = g(new byte[0]);

    /* renamed from: a, reason: collision with root package name */
    final byte[] f7368a;

    /* renamed from: b, reason: collision with root package name */
    transient int f7369b;

    /* renamed from: c, reason: collision with root package name */
    transient String f7370c;

    d(byte[] bArr) {
        this.f7368a = bArr;
    }

    static int a(String str, int i2) {
        int length = str.length();
        int iCharCount = 0;
        int i3 = 0;
        while (iCharCount < length) {
            if (i3 == i2) {
                return iCharCount;
            }
            int iCodePointAt = str.codePointAt(iCharCount);
            if ((Character.isISOControl(iCodePointAt) && iCodePointAt != 10 && iCodePointAt != 13) || iCodePointAt == 65533) {
                return -1;
            }
            i3++;
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str.length();
    }

    public static d c(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        d dVar = new d(str.getBytes(m.f7392a));
        dVar.f7370c = str;
        return dVar;
    }

    public static d g(byte... bArr) {
        if (bArr != null) {
            return new d((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(d dVar) {
        int iJ = j();
        int iJ2 = dVar.j();
        int iMin = Math.min(iJ, iJ2);
        for (int i2 = 0; i2 < iMin; i2++) {
            int iD = d(i2) & 255;
            int iD2 = dVar.d(i2) & 255;
            if (iD != iD2) {
                return iD < iD2 ? -1 : 1;
            }
        }
        if (iJ == iJ2) {
            return 0;
        }
        return iJ < iJ2 ? -1 : 1;
    }

    public byte d(int i2) {
        return this.f7368a[i2];
    }

    public String e() {
        byte[] bArr = this.f7368a;
        char[] cArr = new char[bArr.length * 2];
        int i2 = 0;
        for (byte b2 : bArr) {
            int i3 = i2 + 1;
            char[] cArr2 = f7367d;
            cArr[i2] = cArr2[(b2 >> 4) & 15];
            i2 += 2;
            cArr[i3] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            int iJ = dVar.j();
            byte[] bArr = this.f7368a;
            if (iJ == bArr.length && dVar.i(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    byte[] f() {
        return this.f7368a;
    }

    public boolean h(int i2, d dVar, int i3, int i4) {
        return dVar.i(i3, this.f7368a, i2, i4);
    }

    public int hashCode() {
        int i2 = this.f7369b;
        if (i2 != 0) {
            return i2;
        }
        int iHashCode = Arrays.hashCode(this.f7368a);
        this.f7369b = iHashCode;
        return iHashCode;
    }

    public boolean i(int i2, byte[] bArr, int i3, int i4) {
        if (i2 >= 0) {
            byte[] bArr2 = this.f7368a;
            if (i2 <= bArr2.length - i4 && i3 >= 0 && i3 <= bArr.length - i4 && m.a(bArr2, i2, bArr, i3, i4)) {
                return true;
            }
        }
        return false;
    }

    public int j() {
        return this.f7368a.length;
    }

    public final boolean k(d dVar) {
        return h(0, dVar, 0, dVar.j());
    }

    public d l(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.f7368a;
        if (i3 > bArr.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.f7368a.length + ")");
        }
        int i4 = i3 - i2;
        if (i4 < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        if (i2 == 0 && i3 == bArr.length) {
            return this;
        }
        byte[] bArr2 = new byte[i4];
        System.arraycopy(bArr, i2, bArr2, 0, i4);
        return new d(bArr2);
    }

    public String m() {
        String str = this.f7370c;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f7368a, m.f7392a);
        this.f7370c = str2;
        return str2;
    }

    public String toString() {
        if (this.f7368a.length == 0) {
            return "[size=0]";
        }
        String strM = m();
        int iA = a(strM, 64);
        if (iA == -1) {
            if (this.f7368a.length <= 64) {
                return "[hex=" + e() + "]";
            }
            return "[size=" + this.f7368a.length + " hex=" + l(0, 64).e() + "…]";
        }
        String strReplace = strM.substring(0, iA).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (iA >= strM.length()) {
            return "[text=" + strReplace + "]";
        }
        return "[size=" + this.f7368a.length + " text=" + strReplace + "…]";
    }
}
