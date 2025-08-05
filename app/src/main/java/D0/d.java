package D0;

import com.bumptech.glide.load.Key;
import java.util.HashMap;
import java.util.Map;
import z0.C0384f;

/* loaded from: classes.dex */
public enum d {
    Cp437(new int[]{0, 2}, new String[0]),
    ISO8859_1(new int[]{1, 3}, "ISO-8859-1"),
    ISO8859_2(4, "ISO-8859-2"),
    ISO8859_3(5, "ISO-8859-3"),
    ISO8859_4(6, "ISO-8859-4"),
    ISO8859_5(7, "ISO-8859-5"),
    ISO8859_6(8, "ISO-8859-6"),
    ISO8859_7(9, "ISO-8859-7"),
    ISO8859_8(10, "ISO-8859-8"),
    ISO8859_9(11, "ISO-8859-9"),
    ISO8859_10(12, "ISO-8859-10"),
    ISO8859_11(13, "ISO-8859-11"),
    ISO8859_13(15, "ISO-8859-13"),
    ISO8859_14(16, "ISO-8859-14"),
    ISO8859_15(17, "ISO-8859-15"),
    ISO8859_16(18, "ISO-8859-16"),
    SJIS(20, "Shift_JIS"),
    Cp1250(21, "windows-1250"),
    Cp1251(22, "windows-1251"),
    Cp1252(23, "windows-1252"),
    Cp1256(24, "windows-1256"),
    UnicodeBigUnmarked(25, "UTF-16BE", "UnicodeBig"),
    UTF8(26, Key.STRING_CHARSET_NAME),
    ASCII(new int[]{27, 170}, "US-ASCII"),
    Big5(28),
    GB18030(29, "GB2312", "EUC_CN", "GBK"),
    EUC_KR(30, "EUC-KR");


    /* renamed from: D, reason: collision with root package name */
    private static final Map f89D = new HashMap();

    /* renamed from: E, reason: collision with root package name */
    private static final Map f90E = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    private final int[] f112a;

    /* renamed from: b, reason: collision with root package name */
    private final String[] f113b;

    static {
        for (d dVar : values()) {
            for (int i2 : dVar.f112a) {
                f89D.put(Integer.valueOf(i2), dVar);
            }
            f90E.put(dVar.name(), dVar);
            for (String str : dVar.f113b) {
                f90E.put(str, dVar);
            }
        }
    }

    d(int i2) {
        this(new int[]{i2}, new String[0]);
    }

    public static d a(int i2) throws C0384f {
        if (i2 < 0 || i2 >= 900) {
            throw C0384f.a();
        }
        return (d) f89D.get(Integer.valueOf(i2));
    }

    d(int i2, String... strArr) {
        this.f112a = new int[]{i2};
        this.f113b = strArr;
    }

    d(int[] iArr, String... strArr) {
        this.f112a = iArr;
        this.f113b = strArr;
    }
}
